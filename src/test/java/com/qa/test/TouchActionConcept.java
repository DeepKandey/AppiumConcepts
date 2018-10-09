package com.qa.test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.qa.base.LaunchAppiumDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TouchActionConcept extends LaunchAppiumDriver {

	public static void main(String[] args) throws MalformedURLException {

		AppiumDriver<MobileElement> driver = Capabilities();

		System.out.println("Session ID: " + driver.getSessionId());
		System.out.println("Context: " + driver.getContext()); // views- native, hybrid, Web view
		System.out.println("Orientation: " + driver.getOrientation());
		System.out.println("Device Time: " + driver.getDeviceTime());

		driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		/*
		 * driver.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"android:id/text1\"));"
		 * );
		 */
		Dimension dimension = driver.manage().window().getSize();
		Double screenHeightStart = dimension.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimension.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();

		Boolean status = true;
		while (status) {
			if (driver.findElementsByXPath("//android.widget.TextView[@text='WebView']").size() == 0) {
				new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollStart))
						.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
						.moveTo(PointOption.point(0, scrollEnd)).release().perform();
			} else {
				status = false;
			}
		}
		driver.findElementByXPath("//android.widget.TextView[@text='WebView']").click();
		
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
