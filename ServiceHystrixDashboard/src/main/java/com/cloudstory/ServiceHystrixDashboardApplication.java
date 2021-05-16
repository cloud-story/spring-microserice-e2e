package com.cloudstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
public class ServiceHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHystrixDashboardApplication.class, args);
	}

}
