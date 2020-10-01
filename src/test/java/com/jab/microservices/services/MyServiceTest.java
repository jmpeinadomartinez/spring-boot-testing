package com.jab.microservices.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jab.microservices.MyService;

@SpringBootTest
public class MyServiceTest {
	
	private static final String RESP_HELLO_WORLD = "Hello, World";
    
	@Autowired
	private MyService service;

	@Test
	public void greet(){
		
		String resp = service.greet();
		assertNotNull(resp);
		assertSame(RESP_HELLO_WORLD, resp);
	}
}
