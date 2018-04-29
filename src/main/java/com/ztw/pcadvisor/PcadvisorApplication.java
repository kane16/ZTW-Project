package com.ztw.pcadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class PcadvisorApplication {


	public static void main(String[] args) {
		SpringApplication.run(PcadvisorApplication.class, args);

	}

}
