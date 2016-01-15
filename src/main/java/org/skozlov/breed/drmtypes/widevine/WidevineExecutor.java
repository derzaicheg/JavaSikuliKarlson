package org.skozlov.breed.drmtypes.widevine;

import org.skozlov.breed.tests.flash.FlashChromeTest;
import org.skozlov.breed.tests.widevine.WidevineChromeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WidevineExecutor {
	
	private final static Logger logger = LoggerFactory.getLogger(WidevineExecutor.class);
	
	public void runChromeTest() throws Exception {
		WidevineChromeTest wvChromeTest = new WidevineChromeTest();
		wvChromeTest.runChromeFlashTest();
		
	}
	
	public static void main(String[] args) throws Exception {
		WidevineExecutor f = new WidevineExecutor();
		f.runChromeTest();
	}
}
