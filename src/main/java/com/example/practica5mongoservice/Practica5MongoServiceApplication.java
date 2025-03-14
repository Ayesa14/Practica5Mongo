package com.example.practica5mongoservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Practica5MongoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practica5MongoServiceApplication.class, args);
	}
}