package com.qa.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LaunchPaytm {

	@Test
	public void paytmAppLaunch() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		// capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		capabilities.setCapability("appPackage", "net.one97.paytm");
		capabilities.setCapability("appActivity", "net.one97.paytm.landingpage.activity.AJRMainActivity");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.quit();

	}
}
