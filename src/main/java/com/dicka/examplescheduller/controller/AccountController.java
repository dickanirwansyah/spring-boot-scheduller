package com.dicka.examplescheduller.controller;

import com.dicka.examplescheduller.entity.Account;
import com.dicka.examplescheduller.job.AccountJob;
import com.dicka.examplescheduller.payload.RequestAccount;
import com.dicka.examplescheduller.payload.ResponseAccount;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private Scheduler scheduler;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseAccount> createAccount(@RequestBody @Valid  RequestAccount reqAccount){

        try{

            ZonedDateTime dateTime = ZonedDateTime.of(reqAccount.getDateTime(), reqAccount.getTimeZone());
            if (dateTime.isBefore(ZonedDateTime.now())){
                ResponseAccount responseAccount = new ResponseAccount(false, "datetime must current time");
                return ResponseEntity.badRequest()
                        .body(responseAccount);
            }

            JobDetail jobDetail = buildJobDetail(reqAccount);
            Trigger trigger = buildJobTrigger(jobDetail, dateTime);
            scheduler.scheduleJob(jobDetail, trigger);

            ResponseAccount responseAccount = new ResponseAccount(
                    true,
                    jobDetail.getKey().getName(),
                    jobDetail.getKey().getGroup(),
                    "account has been created");
            return ResponseEntity.ok(responseAccount);

        }catch (SchedulerException ex){
            ex.printStackTrace();
            log.error("error created account.");
            ResponseAccount responseAccount = new ResponseAccount(false, "error schedulling");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseAccount);
        }
    }

    private JobDetail buildJobDetail(RequestAccount reqAccount){
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("firstname", reqAccount.getFirstname());
        jobDataMap.put("lastname", reqAccount.getLastname());
        jobDataMap.put("email", reqAccount.getEmail());

        return JobBuilder.newJob(AccountJob.class)
                .withIdentity(UUID.randomUUID().toString(), "account-jobs")
                .withDescription("create account job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt){
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "account-trigger")
                .withDescription("create account trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
