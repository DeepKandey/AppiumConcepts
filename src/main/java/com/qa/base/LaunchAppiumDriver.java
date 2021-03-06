package com.qa.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LaunchAppiumDriver {
	
	public static AppiumDriver<MobileElement> driver;
	public static DesiredCapabilities capabilities;

	public static AppiumDriver<MobileElement> Capabilities() throws MalformedURLException {
		File appDir = new File("src/main/resources");
		File app = new File(appDir, "ApiDemos-debug.apk");
		capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android"); // For real Device
		// capabilities.setCapability("deviceName", "Deepak"); // For emulator
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
}
