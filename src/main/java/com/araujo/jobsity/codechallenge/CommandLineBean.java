package com.araujo.jobsity.codechallenge;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.araujo.jobsity.codechallenge.controllers.BowlingController;

/**
 * @author Luis Araujo
 *
 */
@Configuration
public class CommandLineBean  implements CommandLineRunner {
	@Autowired
	private BowlingController bowlingController;
	

	@Override
	public void run(String... args) throws Exception {
		String filePath = Arrays.stream(args).collect(Collectors.joining("-"));
		
		bowlingController.initBowlingGame(filePath);
	}
}
