package org.skozlov.breed.utils.chrome;

import org.sikuli.script.ObserveEvent;
import org.sikuli.script.ObserverCallBack;
import org.sikuli.script.Screen;

public abstract class ScreenCallBackAdapter extends ObserverCallBack {
	private final Screen screen;

	public ScreenCallBackAdapter(final Screen screen) {
		this.screen = screen;
	}

	@Override
	public void appeared(final ObserveEvent evt) {
		this.handle(evt, screen);
	}

	public abstract void handle(final ObserveEvent evt, final Screen screen);
}
