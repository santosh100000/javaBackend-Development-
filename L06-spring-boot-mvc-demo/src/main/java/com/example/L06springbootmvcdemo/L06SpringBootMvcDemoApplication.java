package com.example.L06springbootmvcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L06SpringBootMvcDemoApplication {
	private static Logger LOGGER =  LoggerFactory.getLogger(L06SpringBootMvcDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(L06SpringBootMvcDemoApplication.class, args);
		LOGGER.info("This is info log");
		LOGGER.error("This is error log");
		LOGGER.warn("This is warn log");
		LOGGER.debug("This is debug log");
		LOGGER.trace("This is trace log");
	}

}
