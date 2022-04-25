import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;

public class ScrollTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<?> driver = DesiredCapabilities("real");

		// scroll

		HashMap<String, Object> scrollObject = new HashMap<>();

		scrollObject.put("direction", "down"); // (direction, value) | value - down, up etc.
		scrollObject.put("name", "Web View"); // (attribute, value)

		driver.executeScript("mobile:scroll", scrollObject);

		WebDriverWait wait = new WebDriverWait(driver, 2);

		WebElement webView = driver.findElementByAccessibilityId("Web View");

		wait.until(ExpectedConditions.visibilityOf(webView));

		webView.click();

		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]").click();

		driver.findElementByAccessibilityId("Picker View").click();

		driver.findElementByAccessibilityId("Red color component value").sendKeys("80"); // if u deal with scrollable
																							// elements (up/down;
																							// numbers etc.) use this
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		driver.findElementByAccessibilityId("Blue color component value").sendKeys("105");

		String blueScrollEl = driver.findElementByAccessibilityId("Blue color component value").getText();

		if (blueScrollEl.equals("105")) {

			System.out.println("Text matched!");

		} else {
			
			System.out.println("Wrong text!");
			
		}
	}

}