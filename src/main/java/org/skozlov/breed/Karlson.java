package org.skozlov.breed;

import org.skozlov.breed.config.TestSettings;
import org.skozlov.breed.drmtyperesolver.DrmTypeRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Karlson {
	private final static Logger logger = LoggerFactory.getLogger(Karlson.class);

	
	public static void main(String[] args) throws Exception {
		logger.info("Loading args...");
		TestSettings.getInstance().setProperties(args);
		DrmTypeRunner runner = new DrmTypeRunner();
		logger.info("Executing test...");
		runner.executeDrmTest();
	}
	
}
