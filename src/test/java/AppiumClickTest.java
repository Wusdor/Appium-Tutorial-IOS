import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.ios.IOSDriver;

public class AppiumClickTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<?> driver = DesiredCapabilities("simulator");

		driver.findElementByAccessibilityId("Alert Views").click(); // accessibilityId - more stable locator
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Text Entry\"]")).click();
		driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("Hello");
		driver.findElementByAccessibilityId("OK").click();
		driver.findElementByAccessibilityId("Confirm / Cancel").click();

		String message = driver.findElementByXPath("//*[contains(@name, 'message')]").getText();

		if (message.equals("A message should be a short, complete sentence.")) {

			System.out.println("Text matched!");

		} else {
			System.out.println("Wrong text!");
		}

		driver.findElementByAccessibilityId("Confirm").click();

	}

}
