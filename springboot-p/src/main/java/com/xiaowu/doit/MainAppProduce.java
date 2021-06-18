package com.xiaowu.doit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MainAppProduce {
    public static void main(String[] args) {
        SpringApplication.run(MainAppProduce.class, args);
    }
}
