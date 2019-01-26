package com.pirate.form.basketball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasketballApplication {

	public static void main(String[] args) {
		System.err.println(">>>>>>>>>>>>>>>>>>>>>	服务开启");
		SpringApplication.run(BasketballApplication.class, args);
	}
}
