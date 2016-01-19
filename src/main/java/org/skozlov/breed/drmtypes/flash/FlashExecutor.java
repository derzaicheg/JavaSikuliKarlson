package org.skozlov.breed.drmtypes.flash;

import org.skozlov.breed.config.TestSettings;
import org.skozlov.breed.config.TestSettings.PropertyDoesNotExists;
import org.skozlov.breed.matrixresolver.BrowserEnum;
import org.skozlov.breed.tests.flash.FlashChromeTest;
import org.skozlov.breed.tests.playready.PlayreadySilverlightIeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlashExecutor {

	private final static Logger logger = LoggerFactory.getLogger(FlashExecutor.class);
	private BrowserEnum browser;

	public FlashExecutor() throws PropertyDoesNotExists {
		this.browser = TestSettings.getInstance().getBrowser();
	}

	public void executeTest() throws Exception {

		switch (this.browser) {
		case IE:
			logger.error("Tests for Flash IE are not implemented yet...");
			break;
		case FIREFOX:
			logger.error("Tests for Flash Firefox are not implemented yet...");
			break;
		case CHROME:
			logger.info("Run tests for Flash on Chrome");
			FlashChromeTest flashChromeTest = new FlashChromeTest();
			flashChromeTest.runChromeFlashTest();
			flashChromeTest.runChromeFlashTestFail();
			break;
		}

	}
}
