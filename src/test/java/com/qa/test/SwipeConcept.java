package com.qa.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeConcept {

	private static AndroidDriver<AndroidElement> driver;
	private static DesiredCapabilities capabilities;

	@BeforeTest
	public void setup() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Deepak");
		capabilities.setCapability("appPackage", "com.google.android.dialer");
		capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void test() throws InterruptedException {
		// com.google.android.dialer:id/lists_pager
		WebElement Panel = driver.findElement(By.id("lists_pager"));
		Dimension dimension = Panel.getSize();

		int Anchor = dimension.getHeight() / 2;

		Double ScreenWidthStart = dimension.getWidth() * 0.8;
		int swipeStart = ScreenWidthStart.intValue();

		Double ScreenWidthEnd = dimension.getWidth() * 0.2;
		int swipeEnd = ScreenWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(swipeStart, Anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(swipeEnd, Anchor))
				.release().perform();

		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
