package com.defineIp.IPcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IPcheckApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(IPcheckApplication.class, args);
		System.out.println("Server started......");
		
	}

}
