package com.araujo.jobsity.codechallenge.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.ParseFileService;

/**
 * @author Luis Araujo
 *
 */
@Service
public class ParseFileServiceImpl implements ParseFileService {

	/**
	 * Parse file to a Map
	 * 
	 * @param filePath
	 * @return Map
	 */
	@Override
	public Map<String, List<Roll>> parseFile(String filePath) {
		Map<String, List<Roll>> playersRolls = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), Charset.defaultCharset())) {

			stream.forEach(roll -> {

				String[] currentRoll = roll.split("\\t");
				String playerName = getPlayerName(currentRoll);
				boolean isFoul = getPinsDown(currentRoll).equals("F");
				int pinsDown = Integer.parseInt(isFoul ? "0" : getPinsDown(currentRoll));

				List<Roll> rolls = playersRolls.getOrDefault(playerName, new ArrayList<>());
				rolls.add(new Roll(pinsDown, isFoul));
				playersRolls.put(playerName, rolls);

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return playersRolls;

	}

	/**
	 * @param rollLine
	 * @return Player name
	 */
	private String getPlayerName(String[] rollLine) {
		return rollLine[0];
	}

	/**
	 * @param rollLine
	 * @return Pins down
	 */
	private String getPinsDown(String[] rollLine) {
		return rollLine[1];
	}

}
