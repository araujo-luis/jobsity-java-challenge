package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;

import com.araujo.jobsity.codechallenge.models.Game;

public interface PrintController {
	public String getResultsString(List<Game> games);
}
