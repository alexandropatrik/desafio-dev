package com.bycoders.cnabdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.bycoders.cnabdemo.config")
public class CnabDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnabDemoApplication.class, args);
	}

}
