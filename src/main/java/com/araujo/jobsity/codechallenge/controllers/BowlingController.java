package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.BowlingService;
import com.araujo.jobsity.codechallenge.service.ParseFileService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class BowlingController{

	@Autowired
	private BowlingService bowlingService;

	@Autowired
	private ParseFileService parseFileService;
	
	
	/**
	 * Inizialize Bowling Game
	 * @param filePath
	 */
	public void initBowlingGame(String filePath) {
		Map<String, List<Roll>> playersRolls = parseFileService.parseFile(filePath);
		System.out.println("MAP");
		playersRolls.forEach((key, value) -> {
			System.out.println(key);
			value.forEach(e-> System.out.print(e.getValue() + " "));
			
		});
		bowlingService.init();
	}

}
