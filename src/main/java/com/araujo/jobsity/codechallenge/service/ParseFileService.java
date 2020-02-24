package com.araujo.jobsity.codechallenge.service;

import java.util.List;
import java.util.Map;

import com.araujo.jobsity.codechallenge.models.Roll;

/**
 * @author Luis Araujo
 *
 */
public interface ParseFileService {

	public Map<String, List<Roll>> parseFile(String filePath);

}
