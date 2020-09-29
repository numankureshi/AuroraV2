package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;


import property.ILoginPage;
import utility.SeleniumUtils;

public class LoginPage extends SeleniumUtils implements ILoginPage {
	public double finish, start;
	public double end;
	
	public double login(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		navigateToSogoLoginPage(driver, param, URL, test);;
		waitforElemPresent(driver, testcaseName, 60, user_name, test);
		setText(driver, testcaseName, user_name, username, test);
		setText(driver, testcaseName, user_pass, password, test);
		start = System.currentTimeMillis();
		click(driver, testcaseName, login_button, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
		end = System.currentTimeMillis();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	

		public double navigateToSogoStatic(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.get(URL);
			start = System.currentTimeMillis();
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, login_button_static, test);
			end = System.currentTimeMillis();
			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}
		
		public double navigateToSogoLoginPage(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.get(URL);		
			waitforElemPresent(driver, testcaseName, 60, login_button_static, test);
			start = System.currentTimeMillis();
			click(driver, testcaseName, login_button_static, test);			
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, login_img_static, test);
			end = System.currentTimeMillis();
			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}
		
		public double navigateToSogoProducts(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.get(URL);		
			waitforElemPresent(driver, testcaseName, 60, products_static, test);
			click(driver, testcaseName, products_static, test);
			waitforElemPresent(driver, testcaseName, 60, take_a_tour, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, take_a_tour, test);
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, take_a_tour_request_demo, test);
			end = System.currentTimeMillis();
			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}
		
		public double navigateToSogoPricing(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.get(URL);		
			waitforElemPresent(driver, testcaseName, 60, pricing_static, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, pricing_static, test);
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, pricing_static_text, test);
			end = System.currentTimeMillis();
			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}
	
}
