package com.juaracoding.rrspringboot4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class MainConfiguration {
	//untuk memakai autowired yang dimiliki bawaan java
	@Bean
	public Random getRandom(){
		return new Random();
	}
}
