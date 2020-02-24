package com.araujo.jobsity.codechallenge.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.araujo.jobsity.codechallenge.service.impl.PrintServiceImpl;

public class PrintServiceTest {

	private PrintService printService;

	@Before
	public void setUp() {
		printService = new PrintServiceImpl();

	}

	@Test
	public void printStrike() {
		assertThat(printService.printStrike(), is("\tX\t"));
	}

	@Test
	public void printSpare() {
		List<String> spare = new ArrayList<>();
		spare.add("7");
		spare.add("3");
		assertThat(printService.printSpare(spare), is("7\t/\t"));
	}

	@Test
	public void printBasic() {
		List<String> basic = new ArrayList<>();
		basic.add("7");
		basic.add("1");
		assertThat(printService.printBasic(basic), is("7\t1\t"));
	}

}
