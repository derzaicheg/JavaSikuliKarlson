package org.skozlov.breed.utils.ie;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.BrowserErrorCodeValidator;

public class IEHelper {

	
	public static Process openIE() throws ExecuteException, IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"\"");
		return p;
	}

	public static Process openIE(String url) throws ExecuteException, IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://www.google.com\"");
		return p;
	}
	
	public void closeIEWindow(Process ieProcess) throws InterruptedException {
		ieProcess.destroy();
	}
	
	public static void main(String[] args) throws Exception {
		IEHelper i = new IEHelper();
		Process p = i.openIE();
		Thread.sleep(2000);
//		i.closeIEWindow(p);
	}

}
