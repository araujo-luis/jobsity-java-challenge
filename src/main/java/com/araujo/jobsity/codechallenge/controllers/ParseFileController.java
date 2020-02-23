package com.araujo.jobsity.codechallenge.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.araujo.jobsity.codechallenge.models.Roll;
import com.araujo.jobsity.codechallenge.service.ParseFileService;

/**
 * @author Luis Araujo
 *
 */
@Controller
public class ParseFileController {

	@Autowired
	private ParseFileService parseFileService;

	/**
	 * @param filePath
	 * @return
	 */
	public Map<String, List<Roll>> parseFile(String filePath) {
		return parseFileService.parseFile(filePath);
	}
}
