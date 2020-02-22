package com.araujo.jobsity.codechallenge.service;

import java.util.List;
import java.util.Map;

import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;

/**
 * @author Luis Araujo
 *
 */
public interface BowlingService {

	public List<Game> init(Map<String, List<Roll>> playerRolls);

}
