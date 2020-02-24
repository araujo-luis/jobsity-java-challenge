package com.araujo.jobsity.codechallenge.controllers.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.controllers.BowlingController;
import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.BowlingService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class BowlingControllerImpl implements BowlingController {

	@Autowired
	private BowlingService bowlingService;

	/**
	 * Inizialize Bowling Game
	 * 
	 * @param filePath
	 */
	@Override
	public List<Game> bowlingGame(Map<String, List<Roll>> rolls) {
		return bowlingService.init(rolls);
	}

}
