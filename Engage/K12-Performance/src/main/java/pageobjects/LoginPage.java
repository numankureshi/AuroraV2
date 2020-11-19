package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

import property.IHomePage;
import property.ILoginPage;
import utility.SeleniumUtils;

public class LoginPage extends SeleniumUtils implements ILoginPage, IHomePage {
	public double finish, start;
	public double end;
	
	public double login(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		navigateToK12LoginPage(driver, param, URL, test);
		waitforElemPresent(driver, testcaseName, 60, user_name, test);
		setText(driver, testcaseName, user_name, username, test);
		setText(driver, testcaseName, user_pass, password, test);
		start = System.currentTimeMillis();
		click(driver, testcaseName, login_button, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, account_settings, test);
		end = System.currentTimeMillis();
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	

		public double navigateToK12LoginPage(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.get(URL);
			start = System.currentTimeMillis();
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, login_img_static, test);
			end = System.currentTimeMillis();
			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}
		

		
	
}
