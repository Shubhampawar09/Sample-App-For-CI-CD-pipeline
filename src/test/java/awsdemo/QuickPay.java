package awsdemo;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class QuickPay extends DeviceCap {

	    
	@Test
	public void test() throws InterruptedException {
		driver.findElement(MobileBy.id("com.spentra:id/btn1")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.spentra:id/btn2")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.spentra:id/btn3")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.spentra:id/btn4")).click();
		Thread.sleep(5000);
		driver.findElement(MobileBy.id("com.spentra:id/loginBtn")).click();
	}
	
}
