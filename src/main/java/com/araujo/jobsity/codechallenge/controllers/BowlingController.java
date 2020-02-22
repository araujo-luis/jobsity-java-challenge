package com.araujo.jobsity.codechallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.service.HelloService;

@Controller
public class BowlingController{

	@Autowired
	private HelloService helloService;

	public void initGame() {
		helloService.hello();
	}

}
