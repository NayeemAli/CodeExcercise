package lajlkjd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class A {
	
	ExtentReports report;
	ExtentTest test;
	WebDriver d=new FirefoxDriver();
	
	
	
	
	@Test
	public void m1() throws Throwable{
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.manage().window().maximize();
		report = new ExtentReports("C:\\Users\\Nayeem\\Desktop\\automationreport5.html", true);
		String element="first";
		List<WebElement>list=new ArrayList<>();
		test=report.startTest("Open Browser and started testing shoes section ");
		d.get("http://www.armani.com/us/giorgioarmani/men/onlinestore/sneakers");
		test.log(LogStatus.INFO,"Browser Started");
			
		list=d.findElements(By.xpath("(.//*[@id='elementsContainer']/div/div[2]/a[1])"));
		
		for(int i=2;i<list.size();i++){
			
			 
			 test=report.startTest("Click Elements "+element+"");
			 ((JavascriptExecutor)d).executeScript("window.scrollBy(0,400)");
			
		element=d.findElement(By.xpath("(.//*[@id='elementsContainer']/div["+i+"]/div[2]/a[1]/h3)")).getText();
			WebElement e=d.findElement(By.xpath("(.//*[@id='elementsContainer']/div/div[2]/a[1])["+i+"]"));
		    ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView();", e);
		    ((JavascriptExecutor)d).executeScript("window.scrollBy(0,-200)");
		    e.click();
			if(d.getCurrentUrl().contains("cod")){
				test.log(LogStatus.PASS, "CLicked on Element--- "+element+"");
			}else{
				test.log(LogStatus.FAIL, "Did not Click on on Element--- "+element+"");
			}
			d.get("http://www.armani.com/us/giorgioarmani/men/onlinestore/sneakers");
		
		}
	report.endTest(test);
	report.flush();
	
	}
	
	
	
	
	
	
	
	@Test
	public void m2(){
		
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.manage().window().maximize();
		//report = new ExtentReports("C:\\Users\\Nayeem\\Desktop\\automationreport5.html", true);
		String element="first";
		List<WebElement>list=new ArrayList<>();
		test=report.startTest("next wser");
		d.get("http://www.armani.com/us/giorgioarmani/men/onlinestore/ganewin");
		test.log(LogStatus.INFO," Started Testing MEns Wear");
			
		list=d.findElements(By.xpath("(.//*[@id='elementsContainer']/div/a)"));
		
		for(int i=2;i<list.size();i++){
		test=report.startTest("Click Elements "+element+"");
		element=d.findElement(By.xpath("(.//*[@id='elementsContainer']/div["+i+"]/div[2]/a[1]/h3)")).getText();
			WebElement e=d.findElement(By.xpath("(.//*[@id='elementsContainer']/div/a)["+i+"]"));
		    ((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView();", e);
		    ((JavascriptExecutor)d).executeScript("window.scrollBy(0,-100)");
		    e.click();
			if(d.getCurrentUrl().contains("cod")){
				test.log(LogStatus.PASS, "CLicked on Element--- "+element+"");
			}else{
				test.log(LogStatus.FAIL, "Did not Click on on Element--- "+element+"");
			}
			d.get("http://www.armani.com/us/giorgioarmani/men/onlinestore/ganewin");
		}
	report.endTest(test);
	report.flush();
	
	}
@AfterTest
public void result(){
	d.get("file:///C:/Users/Nayeem/Desktop/automationreport5.html#!");
	
}
}
