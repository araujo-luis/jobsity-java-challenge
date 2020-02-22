package com.araujo.jobsity.codechallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.araujo.jobsity.codechallenge.controllers.BowlingController;

@SpringBootApplication
public class CommandLineBean implements CommandLineRunner {

	@Autowired
	private BowlingController bowlingController;

	@Override
	public void run(String... args) throws Exception {
		bowlingController.initGame();
	}

}
