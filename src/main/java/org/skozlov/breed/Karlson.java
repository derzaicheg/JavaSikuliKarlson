package org.skozlov.breed;

import org.skozlov.breed.TestSettings.PropertyDoesNotExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Karlson {
	private final static Logger logger = LoggerFactory.getLogger(Karlson.class);

	
	public static void main(String[] args) throws PropertyDoesNotExists {
		TestSettings.getInstance().setProperties(args);
		DrmTypeRunner runner = new DrmTypeRunner();
		runner.executeDrmTest();
	}
	
}
