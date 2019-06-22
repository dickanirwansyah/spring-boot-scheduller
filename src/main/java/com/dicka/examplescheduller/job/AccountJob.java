package com.dicka.examplescheduller.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class AccountJob extends QuartzJobBean{

    private static final Logger log = LoggerFactory.getLogger(AccountJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Executing job with key {} : ",jobExecutionContext.getJobDetail().getKey());

        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String firstname = jobDataMap.getString("firstname");
        String lastname = jobDataMap.getString("lastname");
        String email = jobDataMap.getString("email");
    }
}
