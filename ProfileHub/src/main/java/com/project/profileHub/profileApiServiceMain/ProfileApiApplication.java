package com.project.profileHub.profileApiServiceMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.project.profileHub", excludeName = "com.project.kafka")
@ComponentScan(basePackages = {"com.project.profileHub", "com.project.kafka"})
@EntityScan(basePackages ={"com.project.profileHub.profileservice.*","com.project.kafka.*","com.project.profileHub.profileApiServiceMain"})
@EnableJpaRepositories(basePackages ={"com.project.profileHub.profileservice.*","com.project.kafka.*","com.project.profileHub.profileApiServiceMain"})
public class ProfileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileApiApplication.class, args);
	}



}