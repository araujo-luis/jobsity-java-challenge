package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;

import com.araujo.jobsity.codechallenge.models.Game;

public interface PrintController {
	public void printResults(List<Game> games);
}
