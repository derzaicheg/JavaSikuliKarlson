package org.skozlov.breed.utils.asserts;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.skozlov.breed.Karlson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertHelper {
	
	private final static Logger logger = LoggerFactory.getLogger(AssertHelper.class);

	public static void assertImage(Screen s, String target, int timeout, String customMsg) {
		try {
			s.wait(target, timeout).highlight(2);
		} catch (FindFailed e) {
			if (customMsg == null) {
				logger.error("Find image \"" + target + "\" failed with error" + e.toString());
			} else
				logger.error(customMsg + "\n " + e.toString());
		}
		
	}
	
}
