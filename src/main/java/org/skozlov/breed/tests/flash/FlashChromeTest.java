package org.skozlov.breed.tests.flash;

import java.io.File;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImageLocator;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.ObserveEvent;
import org.sikuli.script.ObserverCallBack;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.chrome.ChromeHelper;

public class FlashChromeTest {
	
	public abstract class ScreenCallBack extends ObserverCallBack {
		private final Screen screen;
		
		public ScreenCallBack(final Screen screen) {
			this.screen = screen;
		}
		
		@Override
		public void appeared(final ObserveEvent evt) {
			this.handle(evt, screen);
		}
		
		public abstract void handle(final ObserveEvent evt, final Screen screen);
	}
	
	public void runChromeFlashTest() throws Exception {
			ChromeHelper chromeHelper = new ChromeHelper();
			chromeHelper.openChrome();
			Screen s = new Screen();
			
			try{
				s.compare("/src/main/resources/images/chrome_fa/newChrome.png").highlight(1);
				
				//s.compare("/src/main/resources/images/chrome_fa/search_chrome.png").highlight(1);
				s.onAppear("/src/main/resources/images/chrome_fa/search_chrome.png", new ScreenCallBack(s) {

					@Override
					public void handle(ObserveEvent evt, Screen screen) {
						try {
							screen.click("/src/main/resources/images/chrome_fa/search_chrome.png");
						} catch (FindFailed e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
				});
				//s.click("/src/main/resources/images/chrome_fa/search_chrome.png");
				s.type("http://drmtest2.adobe.com/AccessPlayer/player.swf" + Key.ENTER);
				s.wait("/src/main/resources/images/chrome_fa/compare_player.png", 20).highlight(1);
				s.click("/src/main/resources/images/chrome_fa/edt_player.png");
				s.type("a", Key.CTRL);
				s.type(Key.BACKSPACE);
				s.type("http://lic_acq_url");
				s.click("/src/main/resources/images/chrome_fa/play_player.png");
			}
			catch(FindFailed e){
				e.printStackTrace();
			}
		}
	
}
