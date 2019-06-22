package com.dicka.examplescheduller.scheduler;

import com.dicka.examplescheduller.entity.Account;
import com.dicka.examplescheduller.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class SchedullerTasks {

    private static final Logger logger = LoggerFactory.getLogger(SchedullerTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Scheduled(fixedRate = 3000)
//    public void schedullerFixRate(){
//        logger.info("schedullerFixeRate - {} : "+dateTimeFormatter.format(LocalDateTime.now()));
//
//        accountRepository.save(new Account(UUID.randomUUID().toString(),
//                "muhammad",
//                "dicka",
//                "dickanirwansyah@gmail.com"));
//
//        logger.info("findAccountByFirstname : "+accountRepository.findAccountByFirstname("muhammad"));
//        logger.info("Fixed rate scheduler finish : "+dateTimeFormatter.format(LocalDateTime.now()));
//    }
//
//    @Scheduled(fixedRate = 3000)
//    public void schedullerFixDelay(){
//        logger.info("schedullerFixDelay - {} : "+dateTimeFormatter.format(LocalDateTime.now()));
//    }
}
