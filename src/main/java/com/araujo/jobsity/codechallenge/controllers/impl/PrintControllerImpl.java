package com.araujo.jobsity.codechallenge.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.controllers.PrintController;
import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.service.PrintService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class PrintControllerImpl implements PrintController {

	@Autowired
	private PrintService printService;

	/**
	 * @param games
	 */
	@Override
	public String getResultsString(List<Game> games) {
		return printService.getResultsString(games);

	}
}
