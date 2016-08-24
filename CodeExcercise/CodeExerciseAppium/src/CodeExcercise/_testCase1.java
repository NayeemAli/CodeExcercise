package CodeExcercise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class _testCase1 {
	@Test
	 public  void test1() throws Throwable{
		String URs="http://www.google.com";System.out.println("Navigation set for Google.com");

		//Set Capability as Required
			DesiredCapabilities capabilities=DesiredCapabilities.android();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
			capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
			capabilities.setCapability(MobileCapabilityType.VERSION,"5.0.1");
	  

			URL url= new URL("http://127.0.0.1:4723/wd/hub");
	  

	    
			
			
			
			WebDriver driver = new AndroidDriver(url, capabilities);System.out.println("Initializing Driver");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);System.out.println("Implicit Wait Set for 20 Seconds");
			driver.get(URs);System.out.println("Navigating to WebSite");
	  

		String h[]=URs.split("\\.");System.out.println("Setting up Expected Result");
		String Expected=h[1];
		System.out.println(Expected+"<--Expected Result");
		
	    String Actual=driver.getTitle().toLowerCase();System.out.println("Setting Up Actual Result");
	    System.out.println(Actual+"<--Actual Result");
	    
	    
	    System.out.println("Preparing for Assertion");
		Assert.assertEquals(Actual, Expected);
		System.out.println("Assertion Passed");
	
	}
}
