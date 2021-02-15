package com.lollaby.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentServcieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServcieApplication.class, args);
	}

}
