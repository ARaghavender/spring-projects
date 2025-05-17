package com.project.mnc.cc.srvc.userdataservicemain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication

@ComponentScan(basePackages = {"com.project.mnc.cc.srvc.userdataservice.*","com.project.mnc.cc.srvc.kafka", "com.project.mnc.cc.srvc.userdataservicemain"})
@EntityScan(basePackages = {"com.project.mnc.cc.srvc.userdataservice.*", "com.project.mnc.cc.srvc.kafka.*", "com.project.mnc.cc.srvc.userdataservicemain"})
@EnableJpaRepositories(basePackages = {"com.project.mnc.cc.srvc.userdataservice.*", "com.project.mnc.cc.srvc.kafka.*","com.project.mnc.cc.srvc.userdataservicemain"})
//@EnableCaching
@EnableAsync
public class UserDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataServiceApplication.class, args);
	}

}
