package com.araujo.jobsity.codechallenge.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.impl.ParseFileServiceImpl;

public class ParseFileServiceTest {

	private ParseFileService parseFileService;

	@Before
	public void setUp() {
		parseFileService = new ParseFileServiceImpl();
	}

	@Test
	public void shouldParsePerfectScoreFile() {

		Map<String, List<Roll>> rolls = parseFileService.parseFile("inputs/perfect.txt");

		assertThat(rolls.get("Jeff").size(), is(12));
		assertThat(rolls, IsMapContaining.hasKey("Jeff"));

	}

}
