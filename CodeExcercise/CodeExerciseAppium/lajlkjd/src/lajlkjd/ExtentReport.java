package lajlkjd;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtentReport {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	//pass scenario
	
	@Test(priority = 1, enabled = true)
	public void verifyHomePageTitle() {
		report = new ExtentReports("C:\\Users\\Nayeem\\Desktop\\automationreport.html", true);
	
	test = report.startTest("Verify application Title");
	
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	
	
	test.log(LogStatus.INFO, "Browser started");
	driver.get("https://www.built.io/");
	String title = driver.getTitle();
	System.out.println(title);
			if (title.equals("Built.io – Build mobile apps fast, Connect your digital business, Deliver content everywhere")) {
				test.log(LogStatus.PASS, "verify Title of the page");
				} else {
					test.log(LogStatus.FAIL, "verify Title of the page");
			}	
	report.endTest(test);
	report.flush();
	
	}

	
	
	
	
	//Fail scenario
	@Test(priority = 2, enabled = true)
	public void verifyLogo() throws IOException {
		
		
	test = report.startTest("Verify logo of the application");
	String src = driver.findElement(By.xpath("//img[@class='img']")).getAttribute("src");
					if (src.equals("")) {
							test.log(LogStatus.PASS, "verify logo");
								} else {
										test.log(LogStatus.FAIL, "verify logo");
										File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
										FileUtils.copyFile(scrFile, new File("C:\\Users\\Nayeem\\Desktop\\img.jpg"));
										
										String image= test.addScreenCapture("C:\\Users\\Nayeem\\Desktop\\img.jpg");
										test.log(LogStatus.FAIL, "verify logo of the application", image);
					}
	report.endTest(test);
	report.flush();
	//driver.quit();
	}
	
	@AfterTest
	public void result(){
		driver.get("file:///C:/Users/Nayeem/Desktop/automationreport.html");
		driver.findElement(By.xpath("html/body/nav/ul[2]/li[1]/i")).click();
	}
	
	
	
	
	
	@Test(dataProvider="ud")
	public  void data(String s1, String s2, String s3, String s4,String s5){
		
		test=report.startTest("asdsadsadsa");
		System.out.println("Id = " +s1);
		System.out.println("Name = " +s2);
		System.out.println("me = " +s3);
		System.out.println("we = " +s4);
		System.out.println("see= " +s5);
		String gg="passed";
		if(gg.contains("passed")){
			test.log(LogStatus.PASS, "Data has been written to Object Array");
		}else{
			test.log(LogStatus.FAIL, "gotta work on it---it failed bro");
		}
		
report.endTest(test);
report.flush();
		
		
	}
	@DataProvider(name="ud")
	public  Object[][] m() throws Throwable{
		
		Object obj[][]=new Object[10][5];
		
		
		test=report.startTest("Add Data From Database to Object Multi Array");
											XSSFWorkbook wb=new XSSFWorkbook("C:\\Users\\Islam\\Desktop\\b.xlsx");
											
											//0=id
											//1=name
											//2=me
											//3=we
											//4=see
											
											XSSFSheet s=wb.getSheet("Sheet1");
											//System.out.println(s.getRow(0).getCell(j).getStringCellValue());
											
												
												System.out.println();
												for(int j=0;j<10;j++){
													//System.out.println(s.getRow(0).getCell(j).getStringCellValue()+" [0]"+" ["+j+"]");
												
													
														for(int i=0;i<5;i++){
															
															
																String data=s.getRow(j).getCell(i).getStringCellValue();
																obj[j][i]=data;
																
																
															//System.out.println(obj[j][i]=data+ "---["+j+"]["+i+"]");
														}
												
													
													
													
												
												}
												String ii="pass";
												if(ii.contains("pass")){
													test.log(LogStatus.PASS, "Data has been written to Object Array");
												}else{
													test.log(LogStatus.FAIL, "gotta work on it---it failed bro");
												}
												
					report.endTest(test);
					report.flush();
												
		return obj;
			
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
