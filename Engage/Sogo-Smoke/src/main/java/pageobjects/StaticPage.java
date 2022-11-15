package pageobjects;

import java.io.File;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
	DMXPage dmxPage = new DMXPage();
	
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
		
		public double navigateToSogoPricing(WebDriver driver, HashMap<String, String> param, String URL, ExtentTest test)
				throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			navigateToSogoLoginPage(driver, param, URL, test);
			waitforElemPresent(driver, testcaseName, 60, sign_up, test);
			start = System.currentTimeMillis();
			click(driver, testcaseName, sign_up, test);
			waitForJStoLoad(driver, 60);
			waitforElemPresent(driver, testcaseName, 60, all_packages, test);
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
		
		public void Invalidlogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			maxLengthCheck(driver,param, test);
			rememberFontValidation(driver,param, test);
			waitforElemPresent(driver, testcaseName, 30, login_button, test);
			click(driver, testcaseName, login_button, test);
			waitforElemPresent(driver, testcaseName, 60, invalid_id_pass, test);
			String actualalert = driver.findElement(By.xpath("//span[contains(text(),'Invalid User ID or Password')]")).getAttribute("innerHTML");
			String expectedalert = "Invalid User ID or Password";
			Assert.assertEquals(actualalert, expectedalert, "Alert message is not matching with expected alert");
			String xpath = param.get("TextBox");
			ImgValidation1(driver,param, xpath, test);
			forgetPassword(driver,param, test);
		}
		public void forgetPassword(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Date currentTime = Calendar.getInstance().getTime();
			waitforElemPresent(driver, testcaseName, 30, forget_password, test);
			click(driver, testcaseName, forget_password, test);
			waitForLoad(driver, testcaseName, 30, test);
			driver.findElement(By.xpath("//input[@id='txtUserId']")).sendKeys(param.get("stremailaddress"));
			waitforElemPresent(driver, testcaseName, 30, forget_password_submit, test);
			click(driver, testcaseName, forget_password_submit, test);
			dmxPage.getInviteURLFromEmail (param,currentTime,test);
			waitforElemPresent(driver, testcaseName, 30, return_login, test);
			click(driver, testcaseName, return_login, test);
			waitforElemPresent(driver, testcaseName, 30, sogo_title, test);
		}
		
		public void maxLengthCheck(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			String xpath = "";
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder(20);
			Random random = new Random();
			for (int i = 0; i < Integer.parseInt(param.get("Expected")); i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			String output = sb.toString();
			System.out.println(output);
			
			waitforElemPresent(driver, testcaseName, 30,invalid_username, test);
			driver.findElement(By.xpath("//input[@id='txtUserId']")).sendKeys(output);	
			String UserID = driver.findElement(By.xpath("//input[@id='txtUserId']")).getAttribute("value");
			
			int UserIDLength = UserID.length();
			int UserIDlendiff = output.length() - UserIDLength;
			System.out.println(UserIDlendiff);
			
			if (UserIDlendiff == Integer.parseInt(param.get("Expected2"))) {
		    	  reportPass("maxlength for userid is 30, working fine",test);
		      } else {
		    	  reportFail(testcaseName,"maxlength for userid is 30, not working fine" , test);
		      }
			
			
			waitforElemPresent(driver, testcaseName, 30,invalid_password, test);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(output);
			String Password = driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("value");
			
			int PasswordLength = Password.length();
			int Passlendiff = output.length() - PasswordLength;
			System.out.println(Passlendiff);
			
			if (Passlendiff == Integer.parseInt(param.get("Expected3"))) {
		    	  reportPass("maxlength for password is 30, working fine",test);
		      } else {
		    	  reportFail(testcaseName,"maxlength for password is 30, notworking fine" , test);
		      }
			
			xpath = param.get("RadioButton");
			ImgValidation1(driver,param,xpath,test);
			passwordType(driver,param,test);
		}
		public void passwordType(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			//waitforElemPresent(driver, testcaseName, 30, eye_icon, test);
			String actualPasswordType = driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("type");
			String expectedPasswordType = param.get("RadioButton2");
			Assert.assertEquals(actualPasswordType, expectedPasswordType, "Type mismatch");
			click(driver, testcaseName, eye_icon, test);
			Thread.sleep(2000);
			String actualPasswordTypeaf = driver.findElement(By.xpath("//input[@id='txtPassword']")).getAttribute("type");
			String expectedPasswordTypeaf =  param.get("CheckBox");
			Assert.assertEquals(actualPasswordTypeaf, expectedPasswordTypeaf, "Type mismatch");
		}
		
		
		
		public void ImgValidation1(WebDriver driver, HashMap<String, String> param,String xpath, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(3000);
			 WebElement i = driver.findElement(By.xpath(xpath));
				      Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
				      if (p) {
				    	  reportPass("i img  present",test);
				      } else {
				    	  reportFail(testcaseName,"i img  present" , test);
				      }
		}
		
		public void SogolyticsButtonValidation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(3000);
			 WebElement i = driver.findElement(By.xpath("//img[@title='Sogolytics']"));
				      Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
				      if (p) {
				    	  reportPass("sogolytics img Logo present",test);
				      } else {
				    	  reportFail(testcaseName,"sogolytics img Logo present" , test);
				      }
		
				      String displayValue = driver.findElement(By.xpath("//img[@title='Sogolytics']")).getAttribute("src");
					  System.out.println(displayValue);
						Assert.assertEquals(param.get("Header"), displayValue);
		}
		
		
		public void Facebooklogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
			String testcaseName = param.get("TestCaseName");
			String displayValue = driver.findElement(By.className("facebook-banner")).getCssValue("background-image");
			System.out.println(displayValue);
			Assert.assertEquals(param.get("Expected"), displayValue);
			
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
		
		public void Googlelogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			String displayValue = driver.findElement(By.className("google-banner")).getCssValue("background-image");
			System.out.println(displayValue);
			Assert.assertEquals(param.get("Expected"), displayValue);
			
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
		
		
		public void rememberFontValidation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			waitforElemPresent(driver, testcaseName, 20, By.xpath("//span[@class='sogo-remember']"), "remember me before check", test);
			click(driver, testcaseName, By.xpath("//span[@class='sogo-remember']"), "clicking remember me before check", test);
			Thread.sleep(2000);
			
			WebElement rememberMeFont = driver.findElement(By.xpath("//span[@class='sogo-remember sogo-rem-font']")); 
		    if(rememberMeFont.isDisplayed()) { 
		    	reportPass("rememberMeFont is changed",test);
		    } 
		    else { 
		    	 reportFail(testcaseName,"rememberMeFont is not changed" , test);
		    } 
			waitforElemPresent(driver, testcaseName, 20, By.xpath("//span[@class='sogo-remember sogo-rem-font']"), "remember me after check", test);
			click(driver, testcaseName, By.xpath("//span[@class='sogo-remember sogo-rem-font']"), "clicking remember me after check", test);
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
	
		public void privacyPolicy(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(5000);
			waitforElemPresent(driver, testcaseName, 30, privacy_policy, test);
			click(driver, testcaseName, privacy_policy, test);
			Thread.sleep(5000);
			changingTabControl(driver,param,test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			System.out.println(param.get("Expected"));
			Assert.assertEquals(actualalert, param.get("Expected"), "Alert message is not matching with expected alert");
		}
		
		public void termsOfService(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(5000);
			waitforElemPresent(driver, testcaseName, 30, terms_of_service, test);
			click(driver, testcaseName, terms_of_service, test);
			Thread.sleep(5000);
			changingTabControl(driver,param,test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			System.out.println(param.get("Expected2"));
			Assert.assertEquals(actualalert, param.get("Expected2"), "Alert message is not matching with expected alert");
		}
		
		public void antiSpamPolicy(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(5000);
			waitforElemPresent(driver, testcaseName, 30, anti_spam_policy, test);
			click(driver, testcaseName, anti_spam_policy, test);
			Thread.sleep(5000);
			changingTabControl(driver,param,test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			System.out.println(param.get("Expected3"));
			Assert.assertEquals(actualalert, param.get("Expected3"), "Alert message is not matching with expected alert");
		}
		
		public void dataAndSecurity(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Thread.sleep(5000);
			waitforElemPresent(driver, testcaseName, 30, data_and_security, test);
			click(driver, testcaseName, data_and_security, test);
			Thread.sleep(5000);
			changingTabControl(driver,param,test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			System.out.println(param.get("Header"));
			Assert.assertEquals(actualalert, param.get("Header"), "Alert message is not matching with expected alert");
		}
		
		public void changingTabControl(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			Set<String> handles = driver.getWindowHandles();
		    String currentWindowHandle = driver.getWindowHandle();
		    param.put("currentWindowHandle", currentWindowHandle);
		    for (String handle : handles) {
		    	System.out.println(handle);
		    	System.out.println(currentWindowHandle);
		        if (!currentWindowHandle.equals(handle)) {
		            driver.switchTo().window(handle);
		        }
		    }			
		}
		
		public void extraDetails(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			privacyPolicy(driver,param,test);
			driver.close();
			driver.switchTo().window(param.get("currentWindowHandle"));
			termsOfService(driver,param,test);
			driver.close();
			driver.switchTo().window(param.get("currentWindowHandle"));
			antiSpamPolicy(driver,param,test);
			driver.close();
			driver.switchTo().window(param.get("currentWindowHandle"));
			dataAndSecurity(driver,param,test);
			driver.close();
			driver.switchTo().window(param.get("currentWindowHandle"));
			sogoButtonNavigation(driver,param,test);
		}
		public void sogoButtonNavigation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//img[@title='Sogolytics']"));
			click(driver, testcaseName, By.xpath("//img[@title='Sogolytics']"), "Navigate to SoGo", test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			Assert.assertEquals(actualalert, param.get("TextBox"), "Alert message is not matching with expected alert");
		}
		
					
		public void BasicAccountStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), "Basic account creation button", test);
			UniqueEmail(driver, param, test);
			setText(driver, testcaseName, By.xpath("//input[@id='EmailAddress6']"), param.get("EmailAdd"), "Email Address entered", test);
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), "Submit mail id", test);
			
			
		}
		
		public void UniqueEmail(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
			param.put("EmailAdd", EmailAdd);
			
			
			
		}
		
		public void WelcomePageUserInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "Enter First Name", test);
		Thread.sleep(10);
		setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
		Thread.sleep(10);
		setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
		Thread.sleep(10);
		String GenerateRandomNumber = UUID.randomUUID().toString().replace("-", "").substring(13);
		String UserID = "sogo_" + GenerateRandomNumber ;
		param.put("UserID", UserID);
		setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), UserID, "User ID entered", test);
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
		Thread.sleep(1000);
		click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), "Submit user details", test);
		
		}
		
		
		public void WelcomePageCompanyInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), "Industry type", test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), "Industry type selected", test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), "Project type", test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), "Project type selected", test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), "Timezone selection", test);
			scrollIntoView(driver, testcaseName, By.xpath("//div[text()='"+param.get("Timezone")+"']"), "Time zone selected", test);
			click(driver, testcaseName, By.xpath("//div[text()='"+param.get("Timezone")+"']"), "Time Zone Selected", test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), "Help Checkbox", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), "Submit", test);
		
		
		}
		
		public void TrialAccountCreation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), "Ready", test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@class='pt-tooltip-close']"), "Wait for Tooltip", test);
		click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), "Close Tooltip", test);
		click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), "End Tour", test);
		click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), "Next modal ", test);
		click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account Dropdown", test);
		Thread.sleep(1000);
		click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), "Account settings", test);
		String actualUserid =  driver.findElement(By.xpath("//span[@id='lblUserID']")).getText();
		Assert.assertEquals( actualUserid, param.get("UserID"), "User ids do not match.");	
		
		}
		
		
			
		
		public void TrialPlusStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn2']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn2']"), "Plus Trial Button", test);
			UniqueEmail(driver, param, test);
			setText(driver, testcaseName, By.xpath("//input[@id='EmailAddress2']"), param.get("EmailAdd"), "Email Address entered", test);
			driver.findElement(By.xpath("//a[@id='submit2']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit2']"), "Submit Plus Trial", test);
			
		}
		
		
		
		public void TrialProStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn3']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn3']"), "Pro Trial Button", test);
			UniqueEmail(driver, param, test);
			setText(driver, testcaseName, By.xpath("//input[@id='EmailAddress3']"), param.get("EmailAdd"), "Email Address entered", test);
			driver.findElement(By.xpath("//a[@id='submit3']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit3']"), "Submit Pro Trial", test);
			
		}
		
		public void TrialPremiumStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), "Premium Trial Button", test);
			UniqueEmail(driver, param, test);
			setText(driver, testcaseName, By.xpath("//input[@id='EmailAddress5']"), param.get("EmailAdd"), "Email Address entered", test);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), "Submit Premium Trial", test);
			
		}
		
		public void BasicAccountSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			BasicAccountStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			WelcomePageCompanyInfo(driver, param, test);
			TrialAccountCreation(driver, param, test);
			
		}
		
		public void TrialPlusSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			WelcomePageCompanyInfo(driver, param, test);
			TrialAccountCreation(driver, param, test);
			
		}
		
		public void TrialProSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialProStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			WelcomePageCompanyInfo(driver, param, test);
			TrialAccountCreation(driver, param, test);
			
		}
		
		public void TrialPremiumSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPremiumStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			WelcomePageCompanyInfo(driver, param, test);
			TrialAccountCreation(driver, param, test);
			
			
			
		}
		
		public void Blockedmail(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			//Basic blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), "Trial Button", test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAddBasic = GenerateRandomNumber + "@" + "0815.q	";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAddBasic);
	        //Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit6']"), "Submit Trial mail", test);
			driver.findElement(By.xpath("//a[@id='btnOk']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), "OK Button", test);
			click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), "Close modal", test);
			
			//Trial Plus blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn2']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn2']"), "Trial Button", test);
			String EmailAddPlus = GenerateRandomNumber + "@" + "0wnd.org";
	        driver.findElement(By.xpath("//input[@id='EmailAddress2']")).sendKeys(EmailAddPlus);
	        click(driver, testcaseName, By.xpath("//a[@id='submit2']"), "Submit Trial mail", test);
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), "OK Button", test);
	        click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), testcaseName, test);
	        
	        //Trial Pro blocked mail
	        driver.findElement(By.xpath("//a[@id='pop_btn3']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn3']"), "Trial Button", test);
			Thread.sleep(1000);
			String EmailAddPro = GenerateRandomNumber + "@" + "1zhuan.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress3']")).sendKeys(EmailAddPro);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit3']"), "Submit Trial mail", test);
	        driver.findElement(By.xpath("//a[@id='btnOk']"));
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), "OK Button", test);
	        click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), testcaseName, test);
	        
	        //Trial Premium blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), "Trial Button", test);
			Thread.sleep(1000);
			String EmailAddPremium = GenerateRandomNumber + "@" + "4warding.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAddPremium);
	        click(driver, testcaseName, By.xpath("//a[@id='submit5']"), "Submit Trial mail", test);
	        driver.findElement(By.xpath("//a[@id='btnOk']"));
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), "OK Button", test);
			
						
			
			
			
		}
		
		public void EmptyFirstName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			BasicAccountStatic(driver, param, test);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "", "Blank first name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), "Error message", test);
			
		}
		
		public void EmptyLastName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "", "Empty last name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), param.get("UserID"), "User ID entered", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), "Error message", test);
			
		}
		
		public void MinCharUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialProStatic(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			String Userid = "sog"  ;
			setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), Userid, "User ID entered", test);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), "Minimum character criteria not fulfilled", test);
			
		}
		
		public void MaxCharUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPremiumStatic(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String Userid = "sogo_" + GenerateRandomNumber ;
			setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), Userid, "User ID entered", test);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), "More than allowed characters", test);
			
		}
		
		public void MissingPasswordRequisite(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			BasicAccountStatic(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String Userid = "sogo_" + GenerateRandomNumber ;
			setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), Userid, "User ID entered", test);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey");
			click(driver, testcaseName, (By.xpath("//input[@id='txtConfirmPassword']")), "Incorrect password entered", test);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='div_Pass']"), "Password error", test);
			
		}
		
		public void InvalidUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			

			BasicAccountStatic(driver, param, test);
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), "Submit Mail", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String Userid = "sogo_" + "  " + GenerateRandomNumber ;
			setText(driver, testcaseName, (By.xpath("//input[@id='txtuserId']")), Userid, "User ID entered", test);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), "Invalid User info", test);
			
		}
		
		public void AllFieldsEmpty(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), "Submit Mail", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//button[@id='btnNext']"), "Next", test);
			click(driver, testcaseName, By.xpath("//button[@id='btnNext']"), "Next", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), "Error in name field", test);
			
		}
		
		public void InvalidCharactersUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialProStatic(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtfirstname']")), "Mohammad", "First Name Entered", test);
			Thread.sleep(10);
			setText(driver, testcaseName, (By.xpath("//input[@id='txtlastname']")), "Numan", "Last Name Entered", test);
			Thread.sleep(10);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String Userid = "~`!@#$%^&*(()-_=+][}{';:?></.," + "  " + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), "User info", test);
			
		}
		
		public void EmptyCompanyInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), "Submit button", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_company_error']"), "Company Error", test);
		}
		
		public void EmptyOrgName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPremiumStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys(" ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_company_error']"), "Company Error", test);
		
		}
		
		public void EmptyJobTitle(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			BasicAccountStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys(" ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
		   waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_responsibility_error']"), "Error message", test);
	
			
			
			
			
		}
		
		public void EmptyPhoneNumber(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys(" ");
		   	Thread.sleep(10);
		   	click(driver, testcaseName , By.xpath("//span[@id=\"ddIndustrySelected\"]"), "Industry DD" , test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), "Industry field", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_phone_error']"), "Error displayed", test);
							
			
			
			
		}
		
		public void InvalidPhoneNumber(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			BasicAccountStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name" , test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("987");
		   	Thread.sleep(10);
		   	
		   	click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), "Industry DD", test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), "Industry Selection", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_phone_error']"), "Error message", test);
							
			
			
			
		}
		
		public void EmptyWorkInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialPlusStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9998877887");
		   	Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), "Check Disclaimer CB", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), "Submit welcome page", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_industry_error']"), "Error", test);
			
		}
		
		public void EmptyProjectInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			TrialProStatic(driver, param, test);
			WelcomePageUserInfo(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9998877887");
		   	Thread.sleep(10);
		   	click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), "Industry DD", test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), "Industry DD Selection", test);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), "Check Disclaimer CB", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), "Submit", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_project_error']"), "Error", test);
							
			
			
			
		}
		
		public void ExistingUserID(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), "Trial Button", test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), "Submit Mail", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys("sogo_nkureshi");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//div[@id='availableids']"), "Available ID message", test);
			
			
		}
		
		
		public void PlusPaidStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnProfMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnProfMonthly']"), "Plus Y Account", test);
		
		}
		
		public void ProMStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEntMonthly']"));
			click(driver, testcaseName, By.xpath("(//a[@class='pricing-package-plan-switch'])[1]"), "Switch to Pro M account", test);
			click(driver, testcaseName, By.xpath("//a[@id='btnEntMonthly']"), "Pro M account", test);
			
		}
		public void ProYPaidStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEntMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEntMonthly']"), "Pro Y account", test);
			
			
		}
		
		public void PremYPaidStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEP']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEP']"), "Premium Y account", test);
			
		}
		
		public void PremMPaidStatic(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEP']"));
			click(driver, testcaseName, By.xpath("(//a[@class='pricing-package-plan-switch'])[1]"), "Switch to Premium M account", test);
			click(driver, testcaseName, By.xpath("//a[@id='btnEP']"), "Premium M account", test);
			
		}
		
		public void Registration(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), "First Name", test);
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
		Thread.sleep(10);
		driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
		Thread.sleep(10);
		String GenerateRandomNumber = UUID.randomUUID().toString();
		String Userid = "sogo_"  + GenerateRandomNumber ;
		driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
		String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
		param.put("EmailAdd", EmailAdd);
        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
        Thread.sleep(1000);
        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), "Disclaimer check", test);
        Thread.sleep(1000);
        click(driver, testcaseName, By.xpath("//input[@type='submit']"), "Submit", test);
        Thread.sleep(5000);
        click(driver, testcaseName, By.xpath("//input[@type='submit']"), "Submit", test);
        Thread.sleep(1000);
        
		}
		
		public void Billing(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
			
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), "Billing Address", test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), "Country DD", test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), "Country Selection", test);
			setText(driver, testcaseName, cc_field, param.get("CC_number"), test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), "CC Expiry DD", test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), "CC month", test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), "CC year DD", test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), "CC year", test);
			setText(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']"), param.get("CVV"), "CVV entered", test);
			//driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("9997");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), "Submit billing details", test);
			Thread.sleep(1000);
		
        
		}
		
		public void BillingwithPromo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
        click(driver, testcaseName, By.xpath("//a[@id='btnPromo']"), testcaseName, test);
        driver.findElement(By.xpath("//input[@value='Have a promo code? (Promotional offer)']")).sendKeys("pric01");
        click(driver, testcaseName, By.xpath("//input[@value='Apply']"), testcaseName, test);
        waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='viewdetails']"), testcaseName, test);
        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
		click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
		setText(driver, testcaseName, cc_field, param.get("CC_number"), test);
		click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
		click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
		click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
		click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
		setText(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']"), param.get("CVV"), "CVV entered", test);
		//driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("998");
		click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
		Thread.sleep(1000);
		
		}
		
		 public void Confirmation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
				//This is to be run on QAUC only
				String testcaseName = param.get("TestCaseName");
				
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), "Confirm subscription", test);
		click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), "Confirm subscription", test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), "Confirm modal", test);
		
		 }
		 
		 public void UserInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
				//This is to be run on QAUC only
				String testcaseName = param.get("TestCaseName");
		 
		 waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), "Ready homepage", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), "Ready homepage", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), "Company Name", test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//select[@id='ddlTimeZone']"), "Timezone DD", test);
			scrollIntoView(driver, testcaseName, By.xpath("//option[text()='"+param.get("Timezone")+"']"), "Time zone selected", test);
			click(driver, testcaseName, By.xpath("//option[text()='"+param.get("Timezone")+"']"), "Time Zone Selected", test);
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), "Details", test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), "Industry Selection", test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), "Submit selection", test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), "Customer experience selection", test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), "Submit button", test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), "Next button", test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), "End of requisites", test);
			
		 }
		 
		 public void ValidatePaid(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
				//This is to be run on QAUC only
				String testcaseName = param.get("TestCaseName");
		 waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@class='pt-tooltip-close']"), "Tooltip close", test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), "Tooltip close", test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), "End tour modal", test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), "Close tour modal", test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account initials Drodpown", test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), "Account settings", test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), "Company Info", test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, param.get("EmailAdd"), "Email ids do not match.");
			
		}
		
        public void CreatePaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
			
			Registration(driver, param, test);
			Billing(driver, param, test);
			Confirmation(driver, param, test);
			UserInfo(driver, param, test);	
			ValidatePaid(driver, param, test);
					
		
		}
		
		public void CreatePlusPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
			
			PlusPaidStatic(driver, param, test);
			CreatePaidAccount(driver, param, test);
				
			
		}
		
		public void CreateProYPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			ProYPaidStatic(driver, param, test);
			CreatePaidAccount(driver, param, test);
						
			
		}
		
		
		
		public void CreateProMPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			ProMStatic(driver, param, test);
			CreatePaidAccount(driver, param, test);
			
			
		}
		
		public void CreatePremYPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			PremYPaidStatic(driver, param, test);
			Registration(driver, param, test);
	        BillingwithPromo(driver, param, test);
			Confirmation(driver, param, test);
			UserInfo(driver, param, test);	
			ValidatePaid(driver, param, test);
					
		}
		
		public void CreatePremMPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			PremMPaidStatic(driver, param, test);
			CreatePaidAccount(driver, param, test);
			
		}
		
		public void InvalidCC(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			
			ProMStatic(driver, param, test);
			Registration(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), "CC Address", test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), "CC Country DD", test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), "CC Country", test);
			setText(driver, testcaseName, cc_field, param.get("CC_number"), test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), "CC Expiry month", test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), "CC month selected", test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), "CC Expiry year", test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), "CC Year selected", test);
			setText(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']"), param.get("CVV"), "CVV entered", test);
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), "Submit button", test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblErrorMsg']"), "Error message displayed", test);
		
			
		}
		
		public void InvalidDate(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			ProYPaidStatic(driver, param, test);
			Registration(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), "CC Address field", test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), "Country DD", test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), "Country Selected", test);
			setText(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']"), param.get("CC_number"), "CC number entered", test);
			//driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys(param.get("CC_number"));
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), "CC Expiry month", test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), "CC month selected", test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), "CC Expiry year", test);
			click(driver, testcaseName, By.xpath("//option[text()='2022']"), "CC year selected", test);
			setText(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']"), param.get("CVV"), "CVV entered", test);
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), "Submit Billing Details", test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblErrorMsg']"), "Error message displayed", test);
		
			
		}
		
		
		public void CancelPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//a[@id='aCancelAccount']"), "Cancel Account tab", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@class='cancelaccount']"), "Cancel account button", test);
			click(driver, testcaseName, By.xpath("//div[@class='cancelaccount']"), "Cancel account button", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[contains(text(),'I signed up to do just one project and it’s done now.')]"), "Cancellation reason", test);
			click(driver, testcaseName, By.xpath("//label[contains(text(),'I signed up to do just one project and it’s done now.')]"), "Cancel account button", test);
			click(driver, testcaseName, By.xpath("//input[@value='Proceed']"), "Cancel account button", test);
			click(driver, testcaseName, By.xpath("//span[@clickrate='rs10']"), "Rate sogolytics experience", test);
			driver.findElement(By.xpath("//textarea[@name='txtFeedback']")).sendKeys("Amazing");
			click(driver, testcaseName, By.xpath("//input[@name='btnSubmitFeedback']"), "Cancellation Confirmation", test);
			click(driver, testcaseName, By.xpath("//input[@name='btnCancelAccount']"), "Cancellation Modal", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvCencelled']"), "Cancellation done", test);
		}
		
		public void CancelTrialAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//a[@id='aCancelAccount']"), "Cancel Account tab", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@clickrate='rs10']"), "Rate sogolytics experience", test);
			click(driver, testcaseName, By.xpath("//span[@clickrate='rs10']"), "Rate sogolytics experience", test);
			driver.findElement(By.xpath("//textarea[@name='txtFeedback']")).sendKeys("Amazing");
			click(driver, testcaseName, By.xpath("//input[@name='btnSubmitFeedback']"), "Cancellation Confirmation", test);
			click(driver, testcaseName, By.xpath("//input[@name='btnCancelAccount']"), "Cancellation Modal", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='btnLogin']"), "Account Cancelled", test);
		}
		
		public void SwitchtoYearly(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			click(driver, testcaseName, By.xpath("//li[@id='SideNavigation_lBillingInfo']"), "Billing Info tab", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[text()='Change to Annual']"), "Change to Annual", test);
			click(driver, testcaseName, By.xpath("//a[text()='Change to Annual']"), "Switch to annual", test);
			Billing(driver, param, test);
			Confirmation(driver, param, test);			
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account settings dropdown", test);
			
		}
		
		
		
		public void Upgrademodal(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//li[@id='SideNavigation_lBillingInfo']"), "Billing Info tab", test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@onclick='openUpgradePopup()']"), "Upgrade Package", test);
		click(driver, testcaseName, By.xpath("//a[@onclick='openUpgradePopup()']"), "Upgrade Package", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		
		
		}
		
		public void UpgradetoProY(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		Upgrademodal(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnEntMonthly']"), "Select Package", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEntMonthly']"), "Select Package", test);
		driver.switchTo().defaultContent();
		
		UpgradePackageBilling(driver, param, test);
		
		}
		
		public void UpgradetoPremY(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");

		Upgrademodal(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		driver.switchTo().defaultContent();
		UpgradePackageBilling(driver, param, test);
		
		}
		
		public void UpgradetoPremM(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");


		Upgrademodal(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), "Monthly subscription present", test);
        click(driver, testcaseName, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), "Monthly subscription selected", test);
		
        UpgradePackageBilling(driver, param, test);
        
		}
		
		public void UpgradePackageBilling(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			Billing(driver, param, test);
			Confirmation(driver, param, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account settings dropdown", test);
			
		}
		
		public void UpgradefromTrialtoPlusY(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//div[@id='Inner_header1_ctl00_divUpgrade']"), "CLick on Upgrade Icon", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnProfMonthly']"), "Select Package", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnProfMonthly']"), "Select Package", test);
		driver.switchTo().defaultContent();
		UpgradeTrialtoPaid(driver, param, test);
		
		}
		
		public void UpgradefromTrialtoProM(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//div[@id='Inner_header1_ctl00_divUpgrade']"), "CLick on Upgrade Icon", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@class='btnSwitch']"), "Switch to Monthly", test);
		click(driver, testcaseName, By.xpath("//a[@class='btnSwitch']"), "Select Package", test);	
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEntMonthly']"), "Select Package", test);
		driver.switchTo().defaultContent();
		UpgradeTrialtoPaid(driver, param, test);
		
		
		}
		
		public void UpgradefromTrialtoProY(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//div[@id='Inner_header1_ctl00_divUpgrade']"), "CLick on Upgrade Icon", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnEntMonthly']"), "Switch to Monthly", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEntMonthly']"), "Select Package", test);
		driver.switchTo().defaultContent();
		UpgradeTrialtoPaid(driver, param, test);
		
		
		}
		
		public void UpgradefromTrialtoPremM(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//div[@id='Inner_header1_ctl00_divUpgrade']"), "CLick on Upgrade Icon", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@class='btnSwitch']"), "Switch to Monthly", test);
		click(driver, testcaseName, By.xpath("//a[@class='btnSwitch']"), "Select Package", test);	
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		driver.switchTo().defaultContent();
		UpgradeTrialtoPaid(driver, param, test);
		
		
		}
		
		public void UpgradefromTrialtoPremY(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, By.xpath("//div[@id='Inner_header1_ctl00_divUpgrade']"), "CLick on Upgrade Icon", test);
		switchToIframe(driver, testcaseName, IStaticPage.upgrade_modal, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='MyHeader_btnEP']"), "Switch to Monthly", test);
		click(driver, testcaseName, By.xpath("//a[@id='MyHeader_btnEP']"), "Select Package", test);
		driver.switchTo().defaultContent();

		BillingwithPromo(driver, param, test);
		Confirmation(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account settings dropdown", test);
		
		
		}
		
		public void UpgradeTrialtoPaid(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
		
		
		Billing(driver, param, test);
		Confirmation(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), "Account settings dropdown", test);
		
		}
		

		
}
