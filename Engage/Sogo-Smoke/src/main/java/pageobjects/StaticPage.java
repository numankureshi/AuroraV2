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
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IStaticPage;
import utility.SeleniumUtils;

public class StaticPage extends SeleniumUtils implements IStaticPage, IHomePage {
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
	
	public void SoGoLoginPageWithoutCredentials(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		navigateToSogoLoginPage(driver, param, URL, test);;
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
			waitforElemPresent(driver, testcaseName, 60, sogo_login_img_static, test);
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
		
		
		public double navigateToSoGoRegistration(WebDriver driver, HashMap<String, String> param, String URL,
				ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			navigateToSogoPricing(driver, param, URL, test);
			scrollIntoCenter(driver, testcaseName, pricing_buy_plus_package, test);
			waitforElemPresent(driver, testcaseName, 60, pricing_buy_plus_package, test);
			Calendar calandar = Calendar.getInstance();
			int hours = calandar.get(Calendar.HOUR_OF_DAY);

			start = System.currentTimeMillis();
			// Rotate click on package in every hour
			switch (hours % 3) {
			case 0:
				click(driver, testcaseName, pricing_buy_plus_package, test);
				break;
			case 1:
				click(driver, testcaseName, pricing_buy_pro_package, test);
				break;
			case 2:
				click(driver, testcaseName, pricing_buy_premium_package, test);
				break;
			default:
				break;
			}
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, registration_first_name, test);
			end = System.currentTimeMillis();

			double totalTime = ((end - start)) / 1000;
			return totalTime;
		}

		public double navigateToSoGoBilling(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test,
				String firstName, String lastName, String userID, String password, String emailID)
				throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			navigateToSoGoRegistration(driver, param, URL, test);
			setText(driver, testcaseName, registration_first_name, firstName, test);
			setText(driver, testcaseName, registration_last_name, lastName, test);
			setText(driver, testcaseName, registration_userid, userID, test);
			setText(driver, testcaseName, registration_password, password, test);
			waitUntilReqAttribute(driver, testcaseName, 30, registration_validate_userinfo, "style", "display: block;",
					test);
			setText(driver, testcaseName, registration_reenter_password, password, test);
			setText(driver, testcaseName, registration_email_id, emailID, test);
			clickAtOffset(driver, testcaseName, registration_disclaimer_checkbox, -50, 0, test);
			Thread.sleep(1000);

			start = System.currentTimeMillis();
			click(driver, testcaseName, registration_create_acc, test);
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, billing_address_field, test);
			end = System.currentTimeMillis();

			double totalTime = ((end - start)) / 1000;
			return totalTime;

		}
		
		public void Invalidlogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
			String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 30,invalid_username, test);
			driver.findElement(By.xpath("//input[@id='txtUserId']")).sendKeys("sogo44test@gmail.com");		
			waitforElemPresent(driver, testcaseName, 30,invalid_password, test);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("xyz");
			waitforElemPresent(driver, testcaseName, 30, login_button, test);
			click(driver, testcaseName, login_button, test);
			waitforElemPresent(driver, testcaseName, 60, invalid_id_pass, test);
			String actualalert = driver.findElement(By.xpath("//span[contains(text(),'Invalid User ID or Password')]")).getAttribute("innerHTML");
			String expectedalert = "Invalid User ID or Password";
			Assert.assertEquals(actualalert, expectedalert, "Alert message is not matching with expected alert");
			driver.close();
		}
		
		public void Facebooklogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
			String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 30, fb, test);
			click(driver, testcaseName, fb, test);
			String winHandleBefore = driver.getWindowHandle();
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			waitforElemPresent(driver, testcaseName, 30, fb_username, test);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testingrmx123@gmail.com");
			waitforElemPresent(driver, testcaseName, 30, fb_password, test);
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Welcome@1234");
			click(driver, testcaseName, fb_login_button, test);
			driver.switchTo().window(winHandleBefore);
			waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
			driver.close();	
		}
		
		public void Googlelogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
			String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 30, google, test);
			click(driver, testcaseName, google, test);
			String winHandleBefore = driver.getWindowHandle();
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			waitforElemPresent(driver, testcaseName, 30, google_username, test);
			driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sogo44test@gmail.com");
			waitforElemPresent(driver, testcaseName, 30, google_next_button, test);
			click(driver, testcaseName, google_next_button, test);
			waitforElemPresent(driver, testcaseName, 30, google_password, test);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9819254698");
			waitforElemPresent(driver, testcaseName, 30, google_next_button, test);
			click(driver, testcaseName, google_next_button, test);
			driver.switchTo().window(winHandleBefore);
			waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
			driver.close();
		}

//		public double logout(WebDriver driver, HashMap<String, String> param, String URL, String username, String password,
//				ExtentTest test) throws InterruptedException {
//			String testcaseName = param.get("TestCaseName");
//			login(driver, param, username, password, URL, test);
//			click(driver, testcaseName, account_settings, test);
//
//			start = System.currentTimeMillis();
//			click(driver, testcaseName, logout_popup_option, test);
//			waitForJStoLoad(driver, 60);
//			waitforElemPresent(driver, testcaseName, 60, login_img_static, test);
//			end = System.currentTimeMillis();
//
//			double totalTime = ((end - start)) / 1000;
//			return totalTime;
//		}
	
}
