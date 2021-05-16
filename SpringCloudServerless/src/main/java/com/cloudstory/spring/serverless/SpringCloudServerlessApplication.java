package com.cloudstory.spring.serverless;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudServerlessApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerlessApplication.class, args);
	}
	
	@Bean
	public Function<String, String> fucntion() {
		return input -> input;
	}
	
	@Bean
	public Consumer<String> consume(){
		return input->System.out.println("Input :: "+input);
	}
	
	@Bean
	public Supplier<String> supply(){
		return () -> "Hello World!";
	}

}
