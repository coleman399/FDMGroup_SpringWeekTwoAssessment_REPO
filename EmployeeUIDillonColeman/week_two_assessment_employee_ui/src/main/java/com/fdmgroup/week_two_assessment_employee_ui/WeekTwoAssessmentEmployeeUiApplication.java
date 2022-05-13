package com.fdmgroup.week_two_assessment_employee_ui;

import com.fdmgroup.week_two_assessment_employee_ui.exception.FeignClientErrorDecoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import feign.codec.ErrorDecoder;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WeekTwoAssessmentEmployeeUiApplication {

	private static final String MESSAGES_URI = "http://employee-service";

	public static void main(String[] args) {
		SpringApplication.run(WeekTwoAssessmentEmployeeUiApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder builder() {
		return WebClient.builder();
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl(MESSAGES_URI).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new FeignClientErrorDecoder();
	}

}
