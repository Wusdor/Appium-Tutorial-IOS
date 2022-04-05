import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseIOSTest {

	public static IOSDriver<?> DesiredCapabilities () throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000);
		capabilities.setCapability("commandTimeouts", "12000");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/wusdor/Library/Developer/Xcode/DerivedData/UIKitCatalog-fuqqnurytfubltaolqdbgrtgwkln/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
		
		IOSDriver<?> driver = new IOSDriver<>(new URL("http://192.168.0.119:4723/wd/hub"), capabilities);
		
		return driver;

	}

}