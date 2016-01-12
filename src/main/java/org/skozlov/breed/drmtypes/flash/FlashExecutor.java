package org.skozlov.breed.drmtypes.flash;

import java.io.IOException;

import org.skozlov.breed.utils.chrome.ChromeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlashExecutor {
	
	private final static Logger logger = LoggerFactory.getLogger(FlashExecutor.class);
	
	public int runTest() throws IOException {
		ChromeHelper chromeHelper = new ChromeHelper();
		int exitCode = chromeHelper.getChromeWindow();
		logger.info(String.format("Opening new chrome windows. Error code is '%d'", exitCode));
		return exitCode;
	}
	
	public static void main(String[] args) throws IOException {
		FlashExecutor f = new FlashExecutor();
		System.out.println(f.runTest());
	}
}
