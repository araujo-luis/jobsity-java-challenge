package com.araujo.jobsity.codechallenge.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.models.Frame;
import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.service.BowlingService;

/**
 * @author Luis Araujo
 *
 */
@Service
public class BowlingServiceImpl implements BowlingService {

	@Override
	public List<Game> init(Map<String, List<Roll>> playerRolls) {

		List<Game> games = new ArrayList<>();

		playerRolls.forEach((playerName, rolls) -> {

			List<Frame> frames = new ArrayList<>();

			System.out.println(rolls.get(0).getValue());

			int score = 0;
			int current = 0;

			for (int i = 0; i < 10; i++) {

				if (rolls.get(current).getValue() == 10) { // Strike

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue()
							+ rolls.get(current + 2).getValue();

					frames.add(new Frame(Arrays.asList(new Roll(rolls.get(current).getValue())), score));
					current++;
				} else if ((rolls.get(current).getValue() + rolls.get(current + 1).getValue()) == 10) { // Spare

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue()
							+ rolls.get(current + 2).getValue();
					frames.add(new Frame(Arrays.asList(new Roll(rolls.get(current).getValue()),
							new Roll(rolls.get(current + 1).getValue())), score));
					current += 2;
				} else {

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue();
					frames.add(new Frame(Arrays.asList(new Roll(rolls.get(current).getValue()),
							new Roll(rolls.get(current + 1).getValue())), score));
					current += 2;
				}

			}
			games.add(new Game(playerName, frames));

		});
		return games;

	}

}
