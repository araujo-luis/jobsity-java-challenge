package com.araujo.jobsity.codechallenge.service;

import java.util.List;

import com.araujo.jobsity.codechallenge.models.Game;

/**
 * @author Luis Araujo
 *
 */
public interface PrintService {

	public String getResultsString(List<Game> games);

	public String printSpare(List<String> spare);

	public String printBasic(List<String> frame);

	public String printStrike();
}
