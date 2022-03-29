package awsdemo;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceCap {

	public static AppiumDriver<MobileElement> driver;
	public static Properties prop;
	
	@BeforeClass
	public void setUp() throws Exception {
	System.out.println("Opening app...");
	SetProperty();	
		
	DesiredCapabilities caps= new DesiredCapabilities();
	
	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy s10 Lite");
	caps.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") + prop.getProperty("Apk"));
	caps.setCapability("appPackage", "com.spentra");
	caps.setCapability("appActivity", "com.spentra.activities.start.SplashScreenActivity");
	caps.setCapability("noReset", true);
	caps.setCapability("autoGrantPermissions", true);

	driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public static void SetProperty() throws Exception {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fis);

	}
	
	@AfterClass
    public void afterTest(){

    //quit the driver
    driver.quit();
    }


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
