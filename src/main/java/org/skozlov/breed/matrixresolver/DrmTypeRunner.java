package org.skozlov.breed.matrixresolver;
import org.skozlov.breed.config.TestSettings;
import org.skozlov.breed.config.TestSettings.PropertyDoesNotExists;
import org.skozlov.breed.drmtypes.flash.FlashExecutor;
import org.skozlov.breed.drmtypes.playready.PlayReadyExecutor;
import org.skozlov.breed.drmtypes.widevine.WidevineExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DrmTypeRunner {

	private DrmTypesEnum drm;
	private final static Logger logger = LoggerFactory.getLogger(DrmTypeRunner.class);
	
	public DrmTypeRunner() throws PropertyDoesNotExists {
		this.drm = TestSettings.getInstance().getDrmProperty();
	}
	
	
	public void executeDrmTest() throws Exception{
		switch (this.drm) {
		case PLAYREADY:
			logger.info("Loading PLAYREADY tests...");
			PlayReadyExecutor prExec = new PlayReadyExecutor();
			prExec.executeTest();
			break;
		case WIDEVINE:
			logger.info("Loading WIDEVINE tests...");
			WidevineExecutor wvExec = new WidevineExecutor();
			wvExec.executeTest();
			break;
		case FLASHACCESS:
			logger.info("Loading FLASHACCESS tests...");
			FlashExecutor flashExec = new FlashExecutor();
			flashExec.executeTest();
			break;
		default:
			throw new IllegalArgumentException("DrmProperty does not exists in list of known properties");
		}
	}
	
	
	
}
