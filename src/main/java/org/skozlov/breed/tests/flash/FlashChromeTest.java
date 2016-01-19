package org.skozlov.breed.tests.flash;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.ObserveEvent;
import org.sikuli.script.ObserverCallBack;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.ScreenCallBackAdapter;
import org.skozlov.breed.utils.asserts.AssertHelper;
import org.skozlov.breed.utils.chrome.ChromeHelper;
import org.skozlov.breed.utils.gui.InputHelper;

public class FlashChromeTest {

	public void runChromeFlashTest() throws Exception {
		ChromeHelper chromeHelper = new ChromeHelper();
		chromeHelper.openChrome();
		Screen s = new Screen();
		try {
			s.compare("/src/main/resources/images/chrome_fa/newChrome.png").highlight(1);
			s.onAppear("/src/main/resources/images/chrome_fa/search_chrome.png", new ScreenCallBackAdapter(s) {

				@Override
				public void handle(ObserveEvent evt, Screen screen) {
					try {
						screen.click("/src/main/resources/images/chrome_fa/search_chrome.png");
					} catch (FindFailed e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			s.type("http://drmtest2.adobe.com/AccessPlayer/player.swf" + Key.ENTER);
			s.wait("/src/main/resources/images/chrome_fa/compare_player.png", 20).highlight(1);
			s.click("/src/main/resources/images/chrome_fa/edt_player.png");
			InputHelper.cleanEdt(s);
			s.type("http://drmtest2.adobe.com:8080/Content/anonymous.f4v");
			s.click("/src/main/resources/images/chrome_fa/play_player.png");
			//s.wait("/src/main/resources/images/chrome_fa/flash_chrome_assert_playback2.png", 3).highlight(5);
			
			AssertHelper.assertImage(s, "/src/main/resources/images/chrome_fa/flash_chrome_assert_playback.png", 5, "Flash Chrome Playback Message Failed");
			AssertHelper.assertImage(s, "/src/main/resources/images/chrome_fa/flash_chrome_assert_stream.png", 30, "");
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
		public void runChromeFlashTestFail() throws Exception {
			ChromeHelper chromeHelper = new ChromeHelper();
			chromeHelper.openChrome();
			Screen s = new Screen();
			try {
				AssertHelper.assertImage(s, "/src/main/resources/images/chrome_fa/newChrome.png", 5, "Cannot find new opened Chrome");
				s.onAppear("/src/main/resources/images/chrome_fa/search_chrome.png", new ScreenCallBackAdapter(s) {

					@Override
					public void handle(ObserveEvent evt, Screen screen) {
						try {
							screen.click("/src/main/resources/images/chrome_fa/search_chrome.png");
						} catch (FindFailed e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				s.type("http://drmtest2.adobe.com/AccessPlayer/player.swf" + Key.ENTER);
				s.wait("/src/main/resources/images/chrome_fa/compare_player.png", 20).highlight(1);
				s.click("/src/main/resources/images/chrome_fa/edt_player.png");
				InputHelper.cleanEdt(s);
				s.type("http://drmtest2.adobe.com:8080/Content/anonyddmous.f4v");
				s.click("/src/main/resources/images/chrome_fa/play_player.png");
				//s.wait("/src/main/resources/images/chrome_fa/flash_chrome_assert_playback2.png", 3).highlight(5);
				
				AssertHelper.assertImage(s, "/src/main/resources/images/chrome_fa/flash_chrome_assert_playback.png", 5, "Flash Chrome Playback Message Failed");
				AssertHelper.assertImage(s, "/src/main/resources/images/chrome_fa/flash_chrome_assert_stream.png", 20, "Flash Chrome Playback Stream Failed");
			} catch (FindFailed e) {
				e.printStackTrace();
			}
		
	}

}
