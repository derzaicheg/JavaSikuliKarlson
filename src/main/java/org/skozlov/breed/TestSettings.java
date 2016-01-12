package org.skozlov.breed;
import javax.management.InstanceAlreadyExistsException;

import org.slf4j.Logger;


public class TestSettings {

	private static TestSettings instance;
	private Logger logger;
	private String drm;
	
	
	private TestSettings() {
		
	}
	
	public static TestSettings getInstance() {
		if (instance == null) {
			instance = new TestSettings();
		}
		return instance;
	}
	
	public void setProperties(String[] args) {
		this.drm = args[0];
		if (this.drm == null) {
			throw new IllegalArgumentException("Drm parameter cannot be null");
		}
	}
	
	public DrmTypesEnum getDrmProperty() throws PropertyDoesNotExists{
		//this.logger.info("Getting DRM property");
		System.out.println("*INFO* Getting DRM property");
		switch (this.drm.toLowerCase()) {
		case "playready":
			return DrmTypesEnum.PLAYREADY;
		case "flashaccess":
			return DrmTypesEnum.FLASHACCESS;
		case "widevine":
			return DrmTypesEnum.WIDEVINE;
		default:
			throw new PropertyDoesNotExists("Unknown Drm Property");
		}
	}
	
	public class PropertyDoesNotExists extends Exception {
		public PropertyDoesNotExists(String message) {
			super(message);
		}
	}
}
