package com.example.parse.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.parse.data" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(FileParsing.class, args);
	}

}
