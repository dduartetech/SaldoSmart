package com.projetouninove.saldosmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SaldosmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaldosmartApplication.class, args);
	}

}
