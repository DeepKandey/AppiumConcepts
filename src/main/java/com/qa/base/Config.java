package com.qa.base;

public class Config {

	// App Config
	public static final String ANDROID_APP_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/apps/HusqvarnaConnectqa.apk";

	// TimeOUT
	public static int WAIT_TIME_SMALL = 10;
	public static final int MAX_WAIT_TIME = 180;
	public static final int POLLING_TIME = 500;
	public static final int XSMALL_PAUSE = 3;
	public static final int SMALL_PAUSE = 10;
	public static final int MEDIUM_PAUSE = 30;
	public static final int LARGE_PAUSE = 60;
	public static final int XLARGE_PAUSE = 120;
}
