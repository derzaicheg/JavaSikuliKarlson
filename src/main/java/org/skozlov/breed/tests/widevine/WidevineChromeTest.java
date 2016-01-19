package org.skozlov.breed.tests.widevine;

import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.ObserveEvent;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.ScreenCallBackAdapter;
import org.skozlov.breed.utils.asserts.AssertHelper;
import org.skozlov.breed.utils.chrome.ChromeHelper;
import org.skozlov.breed.utils.gui.InputHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WidevineChromeTest {

	private Match find;
	private final static Logger logger = LoggerFactory.getLogger(WidevineChromeTest.class);

	public void runChromeFlashTest() throws Exception {
		ChromeHelper chromeHelper = new ChromeHelper();
		chromeHelper.openChrome();
		final Screen s = new Screen();
		try {
			s.compare("/src/main/resources/images/chrome_fa/newChrome.png").highlight(1);

			// s.compare("/src/main/resources/images/chrome_fa/search_chrome.png").highlight(1);
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
			s.type("http://www.dash-player.com/demo/drm-test-area/" + Key.ENTER);
			s.wait("/src/main/resources/images/chrome_wv/assertWvPlayer.png", 20).highlight(1);
			// https://bitdash-a.akamaihd.net/content/art-of-motion_drm/mpds/11331.mpd
			// https://wv-ref-eme-player.appspot.com/proxy
			find = s.find("/src/main/resources/images/chrome_wv/wv_chrome_mpd_edt.png");
			find.right().click();
			InputHelper.cleanEdt(s);
			s.type("https://bitdash-a.akamaihd.net/content/art-of-motion_drm/mpds/11331.mpd");
			find = s.find("/src/main/resources/images/chrome_wv/wv_chrome_la_edt.png");
			find.right().click();
			InputHelper.cleanEdt(s);
			s.type("https://wv-ref-eme-player.appspot.com/proxy");
			s.find("/src/main/resources/images/chrome_wv/wv_chrome_applysetting.png").highlight(1).click();
			System.out.println(s.getAutoWaitTimeout());
			s.setAutoWaitTimeout(0.5);
			for (int count = 0; count <= 10; count++) {
				try {
					s.click("/src/main/resources/images/chrome_wv/wv_chrome_play_btn.png");
					break;
				} catch (FindFailed e) {
					// TODO Auto-generated catch block
					if (count == 10) {
						logger.error("Play button not found");
					} else {
						s.wheel(Button.WHEEL_DOWN, 1);
					}
				}
			}
			s.setAutoWaitTimeout(3);
			AssertHelper.assertImage(s, "/src/main/resources/images/chrome_wv/wv_chrome_assert_stream.png", 30, "");
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
