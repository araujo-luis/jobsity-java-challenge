package com.araujo.jobsity.codechallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.araujo.jobsity.codechallenge.controllers.BowlingController;
import com.araujo.jobsity.codechallenge.controllers.ParseFileController;
import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.PrintService;

@SpringBootApplication
public class CodechallengeApplication implements CommandLineRunner {

	@Autowired
	private BowlingController bowlingController;

	@Autowired
	private ParseFileController parseFileController;

	@Autowired
	private PrintService printService;

	@Override
	public void run(String... args) throws Exception {
		String filePath = Arrays.stream(args).collect(Collectors.joining("-"));

		Map<String, List<Roll>> rolls = parseFileController
				.parseFile(filePath.split("--spring.output.ansi.enabled=always-")[1]);

		List<Game> games = bowlingController.bowlingGame(rolls);

		printService.printResults(games);
	}

	public static void main(String[] args) {
		SpringApplication.run(CodechallengeApplication.class, args);
	}

}
