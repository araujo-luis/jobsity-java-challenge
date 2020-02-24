package com.araujo.jobsity.codechallenge.service;

import java.util.List;
import java.util.Map;

import com.araujo.jobsity.codechallenge.models.Frame;
import com.araujo.jobsity.codechallenge.models.Game;
import com.araujo.jobsity.codechallenge.models.Roll;

/**
 * @author Luis Araujo
 *
 */
public interface BowlingService {

	public List<Game> init(Map<String, List<Roll>> playerRolls);

	public boolean isSpare(Roll roll, Roll next);

	public boolean isStrike(Roll roll);

	public Frame createFrame(int score, boolean strike, boolean spare, Roll... rolls);

}
