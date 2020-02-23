package com.araujo.jobsity.codechallenge.service;

import java.util.List;

import com.araujo.jobsity.codechallenge.models.Game;

/**
 * @author Luis Araujo
 *
 */
public interface PrintService {

	public void printResults(List<Game> games);
}
