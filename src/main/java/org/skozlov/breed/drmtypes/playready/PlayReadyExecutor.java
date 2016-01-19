package org.skozlov.breed.drmtypes.playready;

import org.skozlov.breed.config.TestSettings;
import org.skozlov.breed.config.TestSettings.PropertyDoesNotExists;
import org.skozlov.breed.matrixresolver.BrowserEnum;
import org.skozlov.breed.tests.playready.PlayreadySilverlightIeTest;
import org.skozlov.breed.tests.widevine.WidevineChromeTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayReadyExecutor {

	private final static Logger logger = LoggerFactory.getLogger(PlayReadyExecutor.class);
	private BrowserEnum browser;

	public PlayReadyExecutor() throws PropertyDoesNotExists {
		this.browser = TestSettings.getInstance().getBrowser();
	}

	public void executeTest() throws Exception {
		
		switch (this.browser) {
		case FIREFOX:
			logger.error("Tests for Playready Firefox are not implemented yet...");
			break;
		case IE:
			logger.info("Executing Playready Silverlight IE tests");
			PlayreadySilverlightIeTest.runPRSLIeTest();
			break;
		case CHROME:
			logger.error("Tests for Playready Chrome are not implemented yet...");
			break;
		}

	}
}
