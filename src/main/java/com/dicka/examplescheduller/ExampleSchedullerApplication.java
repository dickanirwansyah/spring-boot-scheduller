package com.dicka.examplescheduller;

import com.dicka.examplescheduller.scheduler.SchedullerTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExampleSchedullerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSchedullerApplication.class, args);
	}

}
