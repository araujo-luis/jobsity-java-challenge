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
			int score = 0;
			int current = 0;

			for (int i = 0; i < 10; i++) {

				if (isStrike(rolls.get(current))) { // Strike

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue()
							+ rolls.get(current + 2).getValue();
					if(i == 9) 
						frames.add(createFrame(score, rolls.get(current), rolls.get(current+1) , rolls.get(current+2) ));
					else
						frames.add(createFrame(score, rolls.get(current)));
					current++;

				} else if (isSpare(rolls.get(current), rolls.get(current + 1))) { // Spare

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue()
							+ rolls.get(current + 2).getValue();
					frames.add(createFrame(score, rolls.get(current), rolls.get(current + 1)));
					current += 2;

				} else {

					score += rolls.get(current).getValue() + rolls.get(current + 1).getValue();
					frames.add(createFrame(score, rolls.get(current), rolls.get(current + 1)));
					current += 2;
				}

			}

			games.add(new Game(playerName, frames));

		});
		return games;

	}

	private boolean isSpare(Roll roll, Roll next) {
		return roll.getValue() + next.getValue() == 10;
	}

	private boolean isStrike(Roll roll) {
		return roll.getValue() == 10;
	}

	private Frame createFrame(int score, Roll... rolls) {
		return new Frame(Arrays.asList(rolls), score);
	}

}
