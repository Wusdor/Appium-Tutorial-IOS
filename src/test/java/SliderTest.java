import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SliderTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<?> driver = DesiredCapabilities();

		driver.findElementByAccessibilityId("Sliders").click();

		IOSElement slider = (IOSElement) driver.findElementByXPath("//XCUIElementTypeSlider"); // add cast to gain
																								// additional
																								// functionality for
																								// slider (slider
																								// object), IOS only

		slider.setValue("0%");
		slider.setValue("1%"); // setValue method takes values from 0 to 1; if you want 42 => 0.42
		
		String sliderValue = slider.getAttribute("value");
		
		System.out.println(sliderValue);
		//Assert.assertEquals(sliderValue, "100 %");
		
		if (sliderValue.equals("100 %")) {

			Assert.assertEquals(sliderValue, "100 %");

			System.out.println("Right value!");

		} else {

			System.out.println("Wrong value!");

		}

	}

}
