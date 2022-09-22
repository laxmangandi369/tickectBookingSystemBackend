package com.mb.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TicketingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingsystemApplication.class, args);
	}

}
