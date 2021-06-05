package com.example.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookCatalogApplication {

	public static void main(String[] args) {
	//	System.setProperty("server", "8090");
		SpringApplication.run(BookCatalogApplication.class, args);
	}

}
