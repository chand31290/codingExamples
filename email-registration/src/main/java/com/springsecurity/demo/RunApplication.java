package com.springsecurity.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsync
public class RunApplication {
	public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }
}
