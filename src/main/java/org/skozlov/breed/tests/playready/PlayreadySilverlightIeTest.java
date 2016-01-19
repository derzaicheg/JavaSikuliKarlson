package org.skozlov.breed.tests.playready;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.asserts.AssertHelper;
import org.skozlov.breed.utils.gui.InputHelper;
import org.skozlov.breed.utils.ie.IEHelper;

public class PlayreadySilverlightIeTest {

	public static void runPRSLIeTest() throws Exception {
		Process ieProcess = IEHelper.openIE();
		Screen s = new Screen();
		try {
			s.compare("/src/main/resources/images/ie_sl/newIE.png").highlight(2);
			// s.compare("/src/main/resources/images/chrome_fa/search_chrome.png").highlight(1);
			s.click("/src/main/resources/images/ie_sl/newIEAddressEdt.png");
			// //s.click("/src/main/resources/images/chrome_fa/search_chrome.png");
			s.type("http://172.16.114.20/playready_player/Players.SilverlightTestPage.html" + Key.ENTER);
			s.wait("/src/main/resources/images/ie_sl/ieSLPlayBtn.png", 20).highlight(1);
			s.find("/src/main/resources/images/ie_sl/ie_ls_manifest_edt.png").highlight(2).click();
			InputHelper.cleanEdt(s);
			s.type("http://playready.directtaps.net/smoothstreaming/SSWSS720H264/SuperSpeedway_720.ism/Manifest");
			s.click("/src/main/resources/images/ie_sl/ieSLPlayBtn.png");
			s.wait("/src/main/resources/images/ie_sl/ie_pr_sl_assert_playback.png", 10).highlight(5);
			AssertHelper.assertImage(s, "/src/main/resources/images/ie_sl/ie_sl_assert_stream.png", 30, "");
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

}
