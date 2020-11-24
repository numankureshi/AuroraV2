package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.ILoginPage;
import utility.SeleniumUtils;

public class LoginPage extends SeleniumUtils implements ILoginPage {
	public double finish, start;
	public double end;
	
	

	public void login(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(URL);
		waitforElemPresent(driver, testcaseName, 60, user_name, test);
		setText(driver, testcaseName, user_name, username, test);
		setText(driver, testcaseName, user_pass, password, test);
		click(driver, testcaseName, login_button, test);
		Thread.sleep(2000);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, k12_account, test);
	}
	
	
}
