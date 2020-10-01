package com.jab.microservices.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.jab.microservices.MyController2;
import com.jab.microservices.MyService;

@WebMvcTest(MyController2.class)
public class MyController2WebMockTest {
	
	private static final String RESP_HELLO_WORLD = "Hello, World";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MyService service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		
		when(service.greet()).thenReturn(RESP_HELLO_WORLD);
		
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(RESP_HELLO_WORLD)));
	}
}
