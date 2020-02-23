package com.araujo.jobsity.codechallenge.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.service.PrintService;

/**
 * @author Luis Araujo
 *
 */
@Service
public class PrintServiceImpl implements PrintService {

	private StringBuilder string = new StringBuilder();

	private String stringScore = "";

	private static final String PRINT_STRIKE = "\tX\t";

	private static final String PRINT_HEADER = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";

	private static final String PRINT_SCORE_LABEL = "\nScore\t\t";

	private static final String PRINT_PINFALLS_LABEL = "\nPinfalls\t";

	@Override
	public void printResults(List<Game> games) {
		string.append(PRINT_HEADER);

		games.forEach(game -> {

			string.append(game.getPlayerName());

			string.append(PRINT_PINFALLS_LABEL);

			game.getFrames().forEach(frame -> {

				List<String> pinsDown = frame.getRolls().stream()
						.map(roll -> roll.isFoul() ? "F" : Integer.toString(roll.getValue()))
						.collect(Collectors.toList());

				if (frame.isStrike() && pinsDown.size() <= 2)
					string.append(PRINT_STRIKE);
				else if (frame.isSpare())
					string.append(printSpare(pinsDown));
				else
					string.append(printBasic(pinsDown));

				stringScore += frame.getScore() + "\t\t";

			});

			string.append(PRINT_SCORE_LABEL);
			string.append(stringScore);
			stringScore = "";
			string.append("\n");
		});

		System.out.print(string);

	}

	private String printSpare(List<String> spare) {
		return spare.get(0) + "\t/\t";
	}

	private String printBasic(List<String> spare) {
		return spare.stream().map(roll -> (roll.equals("10") ? "X" : roll) + "\t").collect(Collectors.joining());
	}

}
