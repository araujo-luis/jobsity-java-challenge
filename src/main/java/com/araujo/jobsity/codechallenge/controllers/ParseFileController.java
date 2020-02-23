package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import com.araujo.jobsity.codechallenge.models.Roll;

public interface ParseFileController {
	public Map<String, List<Roll>> parseFile(String filePath);
}
