package org.skozlov.breed.drmtypes.flash;

import org.skozlov.breed.tests.flash.FlashChromeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlashExecutor {
	
	private final static Logger logger = LoggerFactory.getLogger(FlashExecutor.class);
	
	public void runTest() throws Exception {
		FlashChromeTest flashChromeTest = new FlashChromeTest();
		flashChromeTest.runChromeFlashTest();
	}
	
	public static void main(String[] args) throws Exception {
		FlashExecutor f = new FlashExecutor();
		f.runTest();
	}
}
