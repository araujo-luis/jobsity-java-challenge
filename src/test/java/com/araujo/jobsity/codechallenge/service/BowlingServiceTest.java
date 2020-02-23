package com.araujo.jobsity.codechallenge.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.impl.BowlingServiceImpl;
import com.araujo.jobsity.codechallenge.service.impl.ParseFileServiceImpl;

public class BowlingServiceTest {

	private BowlingService bowlingService;

	private ParseFileService parseFileService;

	@Before
	public void setUp() {
		bowlingService = new BowlingServiceImpl();

		parseFileService = new ParseFileServiceImpl();

	}

	@Test
	public void shouldCalculateZeroScore() {

		Map<String, List<Roll>> rolls = parseFileService.parseFile("inputs/zero.txt");
		List<Game> game = bowlingService.init(rolls);

		assertThat(game.get(0).getFinalScore(), is(0));

	}
	
	@Test
	public void shouldCalculatePerfectScore() {

		Map<String, List<Roll>> rolls = parseFileService.parseFile("inputs/perfect.txt");
		List<Game> game = bowlingService.init(rolls);

		assertThat(game.get(0).getFinalScore(), is(300));

	}
}
