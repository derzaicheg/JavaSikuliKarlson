package org.skozlov.breed.utils;

public class BrowserErrorCodeValidator {
	
	/*
	 * Valid for chrome only for now
	 */
	
	public void validateErrorCode(int exitCode) throws Exception {
		if (exitCode != 0) throw new Exception("Open Browser should have status code 0");
	}
}
