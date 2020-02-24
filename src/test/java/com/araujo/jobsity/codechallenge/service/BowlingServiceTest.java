package com.araujo.jobsity.codechallenge.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.impl.BowlingServiceImpl;

public class BowlingServiceTest {

	private BowlingService bowlingService;

	@Before
	public void setUp() {
		bowlingService = new BowlingServiceImpl();

	}

	@Test
	public void shouldCalculateZeroScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> rolls = new ArrayList<>();
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));
		rolls.add(new Roll(0));

		playersRoll.put("Jeff", rolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(0));

	}

	@Test
	public void shouldCalculatePerfectScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> rolls = new ArrayList<>();
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));
		rolls.add(new Roll(10));

		playersRoll.put("Jeff", rolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(300));

	}

	@Test
	public void shouldCalculateTwoPlayersScore() {

		Map<String, List<Roll>> playersRoll = new HashMap<>();
		List<Roll> jeffRolls = new ArrayList<>();
		jeffRolls.add(new Roll(10));
		jeffRolls.add(new Roll(7));
		jeffRolls.add(new Roll(3));
		jeffRolls.add(new Roll(9));
		jeffRolls.add(new Roll(0));
		jeffRolls.add(new Roll(10));
		jeffRolls.add(new Roll(0));
		jeffRolls.add(new Roll(8));
		jeffRolls.add(new Roll(8));
		jeffRolls.add(new Roll(2));
		jeffRolls.add(new Roll(0));
		jeffRolls.add(new Roll(6));
		jeffRolls.add(new Roll(10));
		jeffRolls.add(new Roll(10));
		jeffRolls.add(new Roll(10));
		jeffRolls.add(new Roll(8));
		jeffRolls.add(new Roll(1));

		List<Roll> johnRolls = new ArrayList<>();
		johnRolls.add(new Roll(3));
		johnRolls.add(new Roll(7));
		johnRolls.add(new Roll(6));
		johnRolls.add(new Roll(3));
		johnRolls.add(new Roll(10));
		johnRolls.add(new Roll(8));
		johnRolls.add(new Roll(1));
		johnRolls.add(new Roll(10));
		johnRolls.add(new Roll(10));
		johnRolls.add(new Roll(9));
		johnRolls.add(new Roll(0));
		johnRolls.add(new Roll(7));
		johnRolls.add(new Roll(3));
		johnRolls.add(new Roll(4));
		johnRolls.add(new Roll(4));
		johnRolls.add(new Roll(10));
		johnRolls.add(new Roll(9));
		johnRolls.add(new Roll(0));

		playersRoll.put("Jeff", jeffRolls);
		playersRoll.put("John", johnRolls);
		List<Game> game = bowlingService.init(playersRoll);

		assertThat(game.get(0).getFinalScore(), is(167));
		assertThat(game.get(1).getFinalScore(), is(151));

	}

	@Test
	public void isSpare() {
		assertThat(bowlingService.isSpare(new Roll(7), new Roll(3)), is(true));
	}

	@Test
	public void isStrike() {
		assertThat(bowlingService.isStrike(new Roll(10)), is(true));
	}
	
}
