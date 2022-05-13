package com.fdmgroup.week_two_assessment_euraka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeekTwoAssessmentEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeekTwoAssessmentEurekaServerApplication.class, args);
	}

}
