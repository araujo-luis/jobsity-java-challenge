package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.BowlingService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class BowlingController {

	@Autowired
	private BowlingService bowlingService;

	/**
	 * Inizialize Bowling Game
	 * 
	 * @param filePath
	 */
	public void initBowlingGame(Map<String, List<Roll>> rolls) {

		bowlingService.init();
	}

}
