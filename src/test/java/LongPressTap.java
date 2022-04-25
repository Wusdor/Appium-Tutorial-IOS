import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;


public class LongPressTap extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException {

		IOSDriver<?> driver = DesiredCapabilities("simulator");

		MobileElement longPress = (MobileElement) driver.findElementByName("Long tap");

		IOSTouchAction touch = new IOSTouchAction(driver);

		touch.longPress(longPressOptions().withElement(element(longPress)).withDuration(ofSeconds(2))).release().perform(); // withElement(element(MobileElement)))-
																													// provide
																													// a
																													// locator,
																													// withDuration(ofSeconds(time))
																													// -
																													// amount
																													// of
																													// seconds
																													// the
																													// element
																													// to
																													// be
																													// pressed

		MobileElement tap = (MobileElement) driver.findElementByXPath("//XCUIElementTypeSwitch[1]");
		
		touch.tap(tapOptions().withElement(element(tap))).perform();

	}

}