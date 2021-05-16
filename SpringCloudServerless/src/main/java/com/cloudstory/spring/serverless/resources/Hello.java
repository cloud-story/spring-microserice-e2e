package com.cloudstory.spring.serverless.resources;

import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class Hello implements Function<String, String>{
	@Override
	public String apply(String t) {
		return "hello "+t;
	}
}
