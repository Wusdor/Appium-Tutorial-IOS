import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseIOSTest {

	public static IOSDriver<?> DesiredCapabilities (String device) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		switch (device) {
		
		case ("simulator"):
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
			capabilities.setCapability(MobileCapabilityType.APP, "/Users/wusdor/Library/Developer/Xcode/DerivedData/UIKitCatalog-fuqqnurytfubltaolqdbgrtgwkln/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
			
		case ("real"):
			
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Viktor");
			capabilities.setCapability("xcodeSigningId", "iPhone Developer"); // default capability (no need to seek for a specific value) | necessary for IOS capabilities
			capabilities.setCapability("xcodeOrgId", ""); // team ID in Apple account
			capabilities.setCapability("udid", ""); //device udid; IMPORTANT NOTE: real udid might be without hyphen (you can check appium logs to fix that properly)
			capabilities.setCapability("updateWDABundleId", "com.example.apple-samplecode.UICatalog"); //bundle identifier of the application
			
			
			capabilities.setCapability(MobileCapabilityType.APP, "/Users/wusdor/Library/Developer/Xcode/DerivedData/UIKitCatalog-fuqqnurytfubltaolqdbgrtgwkln/Build/Products/Debug-iphoneos/UIKitCatalog.app");
			
			
			
			break;
	}
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.4.1");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000); // amount of time in ms to wait for instruments before assuming it hung and failing the session
		capabilities.setCapability("commandTimeouts", "12000"); // amount of time in ms for command to execute
		//capabilities.setCapability(MobileCapabilityType.APP, "/Users/wusdor/Library/Developer/Xcode/DerivedData/UIKitCatalog-fuqqnurytfubltaolqdbgrtgwkln/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
		//capabilities.setCapability(MobileCapabilityType.APP, "/Users/wusdor/Library/Developer/Xcode/DerivedData/longtap-aeehjlkerlebpeegdhdvkmoitjat/Build/Products/Debug-iphonesimulator/longtap.app");

		IOSDriver<?> driver = new IOSDriver<>(new URL("http://192.168.0.119:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}

}