package com.edu.co.uniquindio.transporte.publico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TPlublicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TPlublicoApplication.class, args);
	}

}
