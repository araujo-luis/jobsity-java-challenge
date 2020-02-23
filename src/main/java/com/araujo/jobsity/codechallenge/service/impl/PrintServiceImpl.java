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

	@Override
	public void printResults(List<Game> games) {
		string.append("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n");

		games.forEach(game -> {

			string.append(game.getPlayerName() + "\n");
			string.append("Pinfalls\t");

			game.getFrames().forEach(frame -> {

				String stringPinsDown = frame.getRolls().stream().map(x -> Integer.toString(x.getValue()))
						.collect(Collectors.joining(","));

				if (frame.isStrike() && stringPinsDown.split(",").length <= 2)
					string.append("\t" + stringPinsDown + "\t");
				else
					string.append(stringPinsDown.replace(",", "\t") + "\t");

				stringScore += frame.getScore() + "\t\t";

			});

			string.append("\nScore\t\t");
			string.append(stringScore);
			stringScore = "";
			string.append("\n");
		});

		System.out.print(string);

	}

}
