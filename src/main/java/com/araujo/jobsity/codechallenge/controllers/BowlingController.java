package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;

public interface BowlingController {
	public List<Game> bowlingGame(Map<String, List<Roll>> rolls);
}
