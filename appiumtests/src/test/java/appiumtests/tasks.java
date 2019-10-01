package appiumtests;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import jxl.read.biff.BiffException;
public class tasks extends ExtentReportsDemo{
	
	
	
	static AppiumDriver<MobileElement> driver;
	public static void openCalculator() throws InterruptedException, BiffException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Pixel XL API 25");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appPackage", "com.example.android.apis");
		cap.setCapability("appActivity", "com.example.android.apis.ApiDemos");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,cap);
		System.out.println("application started");
		
		task1();
		task2();
		
	}
	
	@Test
	private static void task2() throws InterruptedException, IOException{
		try {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest test2 = extent.createTest("TestTwo","Sample Test case for demo");
		test2.log(Status.INFO, "Test Two started");
		jsonData js = new jsonData();
		driver.findElement(By.xpath(js.string9)).click();
		test2.log(Status.PASS, "first click done on app");
		Thread.sleep(1000);
		driver.findElementById(js.string10).click();
		test2.log(Status.PASS, "second click done on action bar");
		driver.findElement(By.xpath(js.string11)).click();		
		test2.log(Status.PASS, "third click done on display options");
		String titletext = driver.findElementByClassName("android.widget.TextView").getText();
		test2.log(Status.PASS, "getting the text for title");
		Assert.assertEquals(titletext, "App/Action Bar/Display Options");
		test2.log(Status.PASS, "assert task done");
		driver.findElementById(js.string12).click();
		driver.findElementById(js.string12).click();
		String titletext2 = driver.findElementByClassName("android.widget.TextView").getText();
		Assert.assertEquals(titletext, "App/Action Bar/Display Options");
		test2.log(Status.PASS, "assert task done");
		test2.log(Status.INFO, "Test two Completed");
		extent.flush();
		}catch(Exception e) {
			File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("Screenshot.jpg"));
		}
	}
	@Test
	private static void task1() throws InterruptedException, IOException {
		try {
		ExtentHtmlReporter htmlReporters = new ExtentHtmlReporter("extent2.html");
		ExtentReports extents = new ExtentReports();
		extents.attachReporter(htmlReporters);
		
		ExtentTest test1 = extents.createTest("TestOne","Sample Test case for demo1");
		jsonData js = new jsonData();
		test1.log(Status.INFO, "Test One started");
		driver.findElement(By.xpath(js.string1)).click();
		test1.log(Status.PASS, "first click done on app");
		driver.findElement(By.xpath(js.string2)).click();
		test1.log(Status.PASS, "going to hide buttons");
		Thread.sleep(2000);
		driver.findElement(By.xpath(js.string4)).click();
		driver.findElement(By.xpath(js.string5)).click();
		driver.findElement(By.xpath(js.string6)).click();
		driver.findElement(By.xpath(js.string7)).click();
		test1.log(Status.PASS, "all buttons hidden");
		try {
		if(driver.findElements(By.xpath(js.string6)).size() != 0){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
		}catch(Exception er) {
			File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("Screenshot.jpg"));
			er.getMessage();
		}
		driver.findElementById(js.string8).click();
		Thread.sleep(2000);
		try {
			if(driver.findElements(By.xpath(js.string6)).size() != 0){
				System.out.println("Element is Present");
				}else{
				System.out.println("Element is Absent");
				}
			}catch(Exception er) {
				File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(file, new File("Screenshot.jpg"));
				er.getMessage();
			}
		test1.log(Status.INFO, "Test One Completed");
		extents.flush();
		driver.navigate().back();
		driver.navigate().back();
		}catch(Exception e) {
			File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("Screenshot.jpg"));
		}
	}

}