package org.skozlov.breed.drmtypes.widevine;

import org.skozlov.breed.config.TestSettings;
import org.skozlov.breed.config.TestSettings.PropertyDoesNotExists;
import org.skozlov.breed.drmtypes.flash.FlashExecutor;
import org.skozlov.breed.matrixresolver.BrowserEnum;
import org.skozlov.breed.matrixresolver.DrmTypesEnum;
import org.skozlov.breed.tests.widevine.WidevineChromeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WidevineExecutor {
	
	private final static Logger logger = LoggerFactory.getLogger(WidevineExecutor.class);
	private BrowserEnum browser;
	
	public WidevineExecutor() throws PropertyDoesNotExists {
		this.browser = TestSettings.getInstance().getBrowser();
	}
	
	public void executeTest() throws Exception {
		
		switch (this.browser) {
		case IE:
			logger.error("Tests for Widevine IE are not implemented yet...");
			break;
		case FIREFOX:
			logger.error("Tests for Widevine Firefox are not implemented yet...");
			break;
		case CHROME:
			logger.info("Loading WidevineChrome tests...");
			WidevineChromeTest wvChromeTest = new WidevineChromeTest();
			wvChromeTest.runChromeFlashTest();
			break;
		}
		
	}
}
