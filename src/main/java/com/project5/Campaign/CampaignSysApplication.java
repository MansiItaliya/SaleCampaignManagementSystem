package com.project5.Campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class CampaignSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampaignSysApplication.class, args);
		System.out.println("success...");
	}

}
