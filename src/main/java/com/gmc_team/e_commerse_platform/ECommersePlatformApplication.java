package com.gmc_team.e_commerse_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ECommersePlatformApplication{

    public static void main(String[] args) {
        SpringApplication.run(ECommersePlatformApplication.class, args);
    }



}
