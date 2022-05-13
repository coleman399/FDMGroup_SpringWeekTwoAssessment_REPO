package com.fdmgroup.week_two_assessment_employee_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WeekTwoAssessmentEmployeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeekTwoAssessmentEmployeeApiApplication.class, args);
	}

}
