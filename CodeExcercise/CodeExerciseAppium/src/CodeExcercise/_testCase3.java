package CodeExcercise;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class _testCase3 {
	private AndroidDriver driver;
	@Test
	public void androidConfig() throws Exception {
		//Credentials
		String User="mcb02test@gmail.com";
		String Pass="MCBTest1234";
		
		//1-//Set Capabilities as Required:    
		
				DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setCapability("deviceName", "Phone");
			   
			    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			    capabilities.setCapability("platformVersion", "5.0.2");
			    capabilities.setCapability("platformName", "Android");
			    capabilities.setCapability("appPackage", "com.clearchannel.iheartradio.controller");
			    capabilities.setCapability("appActivity","com.clearchannel.iheartradio.controller.activities.NavDrawerActivity");
			    
      //2-//Initializing Driver	
			    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			   
	  //3-//Starting Test
			    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);System.out.println("Implicit Wait set to 20 seconds");
			    try {
			    	 driver.findElement(By.xpath("//android.widget.Button[@text='Skip']")).click();System.out.println("Clicked Skip Button");
					    driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();System.out.println("Clicked OK");
					   	
				} catch (Exception e) {
					// TODO: handle exception
				}
			   driver.findElement(By.xpath("//android.widget.Button[@text='LOG IN']")).click();System.out.println("Clicked Login");
			    driver.findElement(By.id("com.clearchannel.iheartradio.controller:id/email")).sendKeys(User);System.out.println("Typed User");
			    driver.findElement(By.id("com.clearchannel.iheartradio.controller:id/password")).sendKeys(Pass);System.out.println("Typed Pass");
			    driver.findElement(By.xpath("//android.widget.Button[@text='Log In']")).click(); System.out.println("Log in Successful");
			    
			    //Only if Credentials are wanting to save
			    try {
			    	driver.findElement(By.id("com.google.android.gms:id/credential_save_reject")).click();
				} catch (Exception e) {
					System.out.println("Did not save credentials.");
					// TODO: handle exception
				}
			    
			    
			    
			    System.out.println("Creating list for all the ListView Elements");
			   List<WebElement>l=driver.findElements(By.xpath("//android.widget.ListView[@resource-id='com.clearchannel.iheartradio.controller:id/tab_list_view']/android.widget.LinearLayout//android.widget.TextView"));
			   System.out.println("Elements Stored");
			   WebElement ChosenStation=l.get(0);System.out.println("My station has been set");
			  String ExpectedStation=ChosenStation.getAttribute("text");System.out.println("Saving Expected Station");
			  System.out.println(ExpectedStation+" <---Expected Station");
			
			    ChosenStation.click();System.out.println("Clicked My Station");
			   
			    String timeStamp = LocalDateTime.now().toString();
			    System.out.println("Loaded and started station at ---"+timeStamp);
			    
			   System.out.println("Playing station for 60 seconds ");
			  
			   while(1<9){

				   String time =driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.clearchannel.iheartradio.controller:id/timeElapsed']")).getAttribute("text");
				    	System.out.println("Player time: "+time);
				    	if(time.contains("1:00")){
				    		break;}
			   }
			 
			    //ScreenShot
			    	File srcFile=driver.getScreenshotAs(OutputType.FILE);
			    	String FileName="ScreenShot";
			    	File targetFile=new File("C:\\Users\\Nayeem\\Customized\\CodeExerciseAppium\\ScreenShots\\ScreenShot.jpg");
			    	FileUtils.copyFile(srcFile, targetFile);
			    	
			    	
			    	
			 
			 	
			  WebElement StationArrival=driver.findElement(By.xpath("//android.view.View[@resource-id='com.clearchannel.iheartradio.controller:id/player_toolbar']//android.widget.TextView"));
				System.out.println("Setting up Actual station result");
			    Thread.sleep(2000);
			   String ActualStation=StationArrival.getAttribute("text");
			   System.out.println(ActualStation+" <-----Actual Station");
			   System.out.println("Preparing for Assertion");
			  Assert.assertEquals(ExpectedStation, ActualStation);
			   System.out.println("Assertion Passed");
			   System.out.println("iHeartRadio music station has been loaded and played");
			   System.out.println("Preparing to delete file");
			   driver.removeApp("com.clearchannel.iheartradio.controller");
			   System.out.println("App Has Been Deleted");
								   
			}
	
	


}
