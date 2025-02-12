package com.Technosignia.Azown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AzownApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzownApplication.class, args);
	}

}
