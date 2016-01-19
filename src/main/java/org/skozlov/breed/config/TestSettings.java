package org.skozlov.breed.config;

import org.skozlov.breed.matrixresolver.BrowserEnum;
import org.skozlov.breed.matrixresolver.DrmTypesEnum;

public class TestSettings {

	private static TestSettings instance;
	private String drm;
	private String browser;
	
	
	private TestSettings() {
		
	}
	
	public static TestSettings getInstance() {
		if (instance == null) {
			instance = new TestSettings();
		}
		return instance;
	}
	
	public void setProperties(String[] args) {
		try{
			this.drm = args[0];
			this.browser = args[1];
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			getUsageInfo();
			System.exit(1);
		}
		
		
	}
	
	public DrmTypesEnum getDrmProperty() throws PropertyDoesNotExists{
		//this.logger.info("Getting DRM property");
		System.out.println("*INFO* Getting DRM property " + this.drm);
		switch (this.drm.toLowerCase()) {
		case "playready":
			return DrmTypesEnum.PLAYREADY;
		case "flashaccess":
			return DrmTypesEnum.FLASHACCESS;
		case "widevine":
			return DrmTypesEnum.WIDEVINE;
		default:
			getUsageInfo();
			throw new PropertyDoesNotExists("Unknown Drm Property");
		}
	}
	
	public BrowserEnum getBrowser() throws PropertyDoesNotExists{
		//this.logger.info("Getting DRM property");
		System.out.println("*INFO* Getting Browser Type " + this.browser);
		switch (this.browser.toLowerCase()) {
		case "ie":
			return BrowserEnum.IE;
		case "firefox":
			return BrowserEnum.FIREFOX;
		case "chrome":
			return BrowserEnum.CHROME;
		default:
			getUsageInfo();
			throw new PropertyDoesNotExists("Unknown Browser	");
		}
	}
	
	public class PropertyDoesNotExists extends Exception {
		public PropertyDoesNotExists(String message) {
			super(message);
		}
	}
	
	private void getUsageInfo() {
		System.out.println("Incorrect parameters usage.\n\n1st parameter should be DrmType.\n"
				+ "Acceptable parameters are: playready, widevine, flashaccess\n"
				+ "2nd parameter should be Browser type,\n"
				+ "Acceptable parameters are: ie, firefox, chrome\n");
	}
}
