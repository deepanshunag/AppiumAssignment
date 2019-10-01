package appiumtests;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;

import jxl.read.biff.BiffException;

import org.json.JSONArray;
import org.json.JSONObject;
public class Calculator extends ExtentReportsDemo{
public static void main(String args[]) {
		try {
			tasks t = new tasks();
			t.openCalculator();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}