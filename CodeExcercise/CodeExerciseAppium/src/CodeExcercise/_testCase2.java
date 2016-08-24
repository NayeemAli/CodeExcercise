package CodeExcercise;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class _testCase2 {
	
	
@Test
public void test2() throws Throwable{
	
	System.out.println("Setting up Capabilities for phone");
	AppiumDriver<WebElement>d;
	String Expected="Mobile integration Workgroup";
	DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
			capabilities.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
			capabilities.setCapability(MobileCapabilityType.VERSION,"5.0.1");
			d= new AndroidDriver<WebElement>(new URL ("http://127.0.0.1:4723/wd/hub"),capabilities);
			Assert.assertNotNull(d.getContext());
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.get("http://www.google.com");System.out.println("Navigating to website");
			
			
			//driver.switchTo().window(driver.findElement(By.className("android.widget.Spinner")));
			
			WebElement search=d.findElement(By.name("q"));System.out.println("Looking for search box");
			search.click();System.out.println("Clicked Search Box");
			search.sendKeys("Mobile integration group");System.out.println("Typed what to search");
			search.sendKeys(Keys.RETURN);
List<WebElement> oo=d.findElements(By.xpath("//div[@id='ires']//h3"));System.out.println("Created an Arraylist of all links on the page");
			String Actual =oo.get(0).getText();System.out.println("Setting up actual result");
			System.out.println(Actual);
			
			Assert.assertEquals(Expected, Actual);
}
	
	
	

}
