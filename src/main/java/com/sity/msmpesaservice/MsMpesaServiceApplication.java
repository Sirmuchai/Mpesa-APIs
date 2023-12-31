package com.sity.msmpesaservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsMpesaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMpesaServiceApplication.class, args);
	}

	@Bean
	public OkHttpClient getOkHttpClient(){
		return new OkHttpClient();
	}

	@Bean
	public ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}

}
