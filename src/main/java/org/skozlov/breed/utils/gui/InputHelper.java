package org.skozlov.breed.utils.gui;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class InputHelper {
	
	public static void cleanEdt(Screen s) {
		s.type("a", Key.CTRL);
		s.type(Key.BACKSPACE);
	}

}
