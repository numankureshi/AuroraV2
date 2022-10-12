package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.ILoginPage;
import utility.SeleniumUtils;

public class LoginPage extends SeleniumUtils implements ILoginPage {
	public double finish, start;
	public double end;
	DMXPage dmxPage = new DMXPage();
	

	public void login(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(URL);
		waitforElemPresent(driver, testcaseName, 60, user_name, test);
		setText(driver, testcaseName, user_name, username, test);
		setText(driver, testcaseName, user_pass, password, test);
		click(driver, testcaseName, login_button, test);
		Thread.sleep(2000);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, zarca_account, test);
	}
	
	public void ZarcaLoginPageWithoutCredentials(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.get(URL);
		Thread.sleep(2000);
		waitForJStoLoad(driver, 30);
	}
	
	public void Invalidlogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 30,user_name, test);
//		driver.findElement(By.xpath("//input[contains(@name,'txtUsername')]")).sendKeys("sogo44test@gmail.com");		
//		waitforElemPresent(driver, testcaseName, 30,user_pass, test);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("xyz");
		maxLengthCheck(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30, login_button, test);
		click(driver, testcaseName, login_button, test);
		//waitforElemPresent(driver, testcaseName, 60, invalid_id_pass, test);
		String actualalert = driver.findElement(By.xpath("//div[contains(text(),'Invalid User Name or Password')]")).getAttribute("innerHTML");
		String expectedalert = "Invalid User Name or Password";
		Assert.assertEquals(actualalert, expectedalert, "Alert message is not matching with expected alert");
	
		forgetPassword(driver,param,test);
		
		String displayValue = driver.findElement(By.xpath("//a[normalize-space()='']")).getAttribute("href");
		System.out.println(displayValue);
		Assert.assertEquals(param.get("Expected2"), displayValue);
		waitforElemPresent(driver, testcaseName, 30,zarca_button, test);
		click(driver, testcaseName, zarca_button, test);
		Thread.sleep(5000);
		String zarcaTitle = driver.getTitle();
		Assert.assertEquals(zarcaTitle, param.get("Expected"), "Alert message is not matching with expected alert");
	}
	
	public void maxLengthCheck(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String xpath = "";
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < Integer.parseInt(param.get("Expected3")); i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
		
		waitforElemPresent(driver, testcaseName, 30,user_name, test);
		driver.findElement(By.xpath("//input[contains(@name,'txtUsername')]")).sendKeys(output);	
		String UserID = driver.findElement(By.xpath("//input[contains(@name,'txtUsername')]")).getAttribute("value");
		
		int UserIDLength = UserID.length();
		int UserIDlendiff = output.length() - UserIDLength;
		System.out.println(UserIDlendiff);
		
		if (UserIDlendiff == Integer.parseInt(param.get("Header"))) {
	    	  reportPass("maxlength for userid is 75, working fine",test);
	      } else {
	    	  reportFail(testcaseName,"maxlength for userid is 75, notworking fine" , test);
	      }
		waitforElemPresent(driver, testcaseName, 30,user_pass, test);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(output);
		String Password = driver.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
		
		int PasswordLength = Password.length();
		int Passlendiff = output.length() - PasswordLength;
		System.out.println(Passlendiff);
		
		if (Passlendiff == Integer.parseInt(param.get("RadioButton2"))) {
	    	  reportPass("maxlength for password is 20, working fine",test);
	      } else {
	    	  reportFail(testcaseName,"maxlength for password is 20, notworking fine" , test);
	      }
	}
	
	
	public void forgetPassword(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Date currentTime = Calendar.getInstance().getTime();
		waitforElemPresent(driver, testcaseName, 30, forget_password, test);
		click(driver, testcaseName, forget_password, test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.findElement(By.xpath("//input[@id='ctl00_Login_or_ForgotPassword_t1']")).sendKeys(param.get("stremailaddress"));
		waitforElemPresent(driver, testcaseName, 30, forget_password_submit, test);
		click(driver, testcaseName, forget_password_submit, test);
		dmxPage.getInviteURLFromEmail (param,currentTime,test);
		waitforElemPresent(driver, testcaseName, 30, return_login, test);
		click(driver, testcaseName, return_login, test);
		waitforElemPresent(driver, testcaseName, 30, zarca_button, test);
	}
	
	
}
