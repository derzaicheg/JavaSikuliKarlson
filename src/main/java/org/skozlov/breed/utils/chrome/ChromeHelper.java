package org.skozlov.breed.utils.chrome;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.BrowserErrorCodeValidator;

public class ChromeHelper {

	private static String CHROME_PATH = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe";
	BrowserErrorCodeValidator errCodeValidator;
	
	public ChromeHelper() {
		errCodeValidator = new BrowserErrorCodeValidator();
	}
	
	public void openChrome() throws Exception {
		int exitCode = getChromeWindow();
		errCodeValidator.validateErrorCode(exitCode);
	}

	private int getChromeWindow() throws ExecuteException, IOException {
		CommandLine cmdLine = new CommandLine("cmd.exe");
		cmdLine.addArgument("/c");
		cmdLine.addArgument(CHROME_PATH);
		DefaultExecutor executor = new DefaultExecutor();
		int exitValue = executor.execute(cmdLine);
		return exitValue;
	}
	
	private void getChromeWindow(Screen screen) throws FindFailed {
		screen.click("/src/main/resources/imgs/chrome.png");
		//TODO
	}
	
	public void closeChromeWindow() {
		// TODO Close Chrome

	}

}
