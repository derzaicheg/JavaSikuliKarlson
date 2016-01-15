package org.skozlov.breed.tests.flash;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.ObserveEvent;
import org.sikuli.script.ObserverCallBack;
import org.sikuli.script.Screen;
import org.skozlov.breed.utils.chrome.ChromeHelper;
import org.skozlov.breed.utils.chrome.ScreenCallBackAdapter;

public class FlashChromeTest {
	
	public void runChromeFlashTest() throws Exception {
			ChromeHelper chromeHelper = new ChromeHelper();
			chromeHelper.openChrome();
			Screen s = new Screen();
			
			try{
				s.compare("/src/main/resources/images/chrome_fa/newChrome.png").highlight(1);
				
				//s.compare("/src/main/resources/images/chrome_fa/search_chrome.png").highlight(1);
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
				//s.click("/src/main/resources/images/chrome_fa/search_chrome.png");
				s.type("http://drmtest2.adobe.com/AccessPlayer/player.swf" + Key.ENTER);
				s.wait("/src/main/resources/images/chrome_fa/compare_player.png", 20).highlight(1);
				s.click("/src/main/resources/images/chrome_fa/edt_player.png");
				s.type("a", Key.CTRL);
				s.type(Key.BACKSPACE);
				s.type("http://drmtest2.adobe.com:8080/Content/anonymous.f4v");
//				s.find("/src/main/resources/images/chrome_fa/wv_chrome_applysetting.png").highlight(1).click();
				s.click("/src/main/resources/images/chrome_fa/play_player.png");
			}
			catch(FindFailed e){
				e.printStackTrace();
			}
		}
	
}
