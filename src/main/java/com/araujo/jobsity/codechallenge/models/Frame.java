package com.araujo.jobsity.codechallenge.models;

import java.util.List;

public class Frame {

	private List<Roll> rolls;

	private int score;

	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Frame(List<Roll> rolls, int score) {
		super();
		this.rolls = rolls;
		this.score = score;
	}

	public Frame() {
		super();
	}

}
