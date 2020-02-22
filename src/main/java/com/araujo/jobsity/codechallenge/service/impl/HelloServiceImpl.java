package com.araujo.jobsity.codechallenge.service.impl;

import org.springframework.stereotype.Service;

import com.araujo.jobsity.codechallenge.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Override
	public void hello() {
		System.out.println("Hello from console");
		
		
	}

}
