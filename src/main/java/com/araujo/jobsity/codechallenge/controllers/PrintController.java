package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.service.PrintService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class PrintController {

	@Autowired
	private PrintService printService;

	public void printResults(List<Game> games) {
		printService.printResults(games);

	}
}
