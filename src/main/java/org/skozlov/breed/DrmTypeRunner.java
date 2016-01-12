package org.skozlov.breed;
import org.skozlov.breed.TestSettings.PropertyDoesNotExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DrmTypeRunner {

	private DrmTypesEnum drm;
	private final static Logger logger = LoggerFactory.getLogger(Karlson.class);
	
	public DrmTypeRunner() throws PropertyDoesNotExists {
		this.drm = TestSettings.getInstance().getDrmProperty();
	}
	
	public void executeDrmTest(){
		switch (this.drm) {
		case PLAYREADY:
			logger.info("Loading PLAYREADY tests...");
			break;
		case WIDEVINE:
			logger.info("Loading WIDEVINE tests...");
			break;
		case FLASHACCESS:
			logger.info("Loading FLASHACCESS tests...");
			break;
		default:
			throw new IllegalArgumentException("DrmProperty does not exists in list of known properties");
		}
	}
	
	
	
}
