package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
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
		    	  reportFail(testcaseName,"maxlength for userid is 30, notworking fine" , test);
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
			click(driver, testcaseName, By.xpath("//img[@title='Sogolytics']"), testcaseName, test);
			String actualalert = driver.getTitle();
			System.out.println(actualalert);
			Assert.assertEquals(actualalert, param.get("TextBox"), "Alert message is not matching with expected alert");
		}
		
		public void BasicAccountSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@id=\"EmailAddress6\"]"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			//WebElement Element = driver.findElement(By.xpath("//input[@id='EmailAddress6']"));
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAdd);
	       	//driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys("s4o44aa4g4444404st@gmail.com");
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//waitforElemPresent(driver, testcaseName, 30, user_name, test);
			//String username = param.get("user_name") + " - " + strDate;
			//param.put("user_name", username);
			//setText(driver, testcaseName, user_name, username, test);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			//driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys("sogo_4aa4s444d4df4fg4g");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			//waitforElemPresent(driver, testcaseName, 100, EmailAdd, test);
			//System.out.println(EmailAdd);
			//WebElement Element2 = driver.findElement(By.xpath("//input[@id='lblEmail']"));
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");		
			
			
		}
		
		public void TrialPlusSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn2']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn2']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@id=\"EmailAddress6\"]"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress2']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit2']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit2']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
			
			
		}
		
		public void TrialProSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn3']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn3']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@id=\"EmailAddress6\"]"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress3']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit3']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit3']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
			
			
		}
		
		public void TrialPremiumSignup(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
			
			
			
		}
		
		public void Blockedmail(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			//Basic blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAddBasic = GenerateRandomNumber + "@" + "0039.cf";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAddBasic);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
	       // waitForElementToBeVisible(driver, testcaseName, By.xpath("//2[@id='btnOk'"), testcaseName, 10, 10, test);
			driver.findElement(By.xpath("//a[@id='btnOk']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), testcaseName, test);
			//Thread.sleep(1000);
			//waitforElemNotVisible(driver, testcaseName, 10, By.xpath("//a[@id='btnOk']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), testcaseName, test);
			//Trial Plus blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn2']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn2']"), testcaseName, test);
			//Thread.sleep(1000);
			String EmailAddPlus = GenerateRandomNumber + "@" + "0-mail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress2']")).sendKeys(EmailAddPlus);
	        //Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit2']"), testcaseName, test);
	        //driver.findElement(By.xpath("//a[@id='btnOk']"));
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), testcaseName, test);
	       // Thread.sleep(1000);
			//waitforElemNotVisible(driver, testcaseName, 10, By.xpath("//a[@id='btnOk']"), testcaseName, test);
	        click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), testcaseName, test);
	        //Trial Pro blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn3']"), testcaseName, test);
			Thread.sleep(1000);
			String EmailAddPro = GenerateRandomNumber + "@" + "001.igg.biz";
	        driver.findElement(By.xpath("//input[@id='EmailAddress3']")).sendKeys(EmailAddPro);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit3']"), testcaseName, test);
	        driver.findElement(By.xpath("//a[@id='btnOk']"));
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), testcaseName, test);
	        //Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//span[@class='pricing-account-close-btn']"), testcaseName, test);
	        //Trial Premium blocked mail
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			Thread.sleep(1000);
			String EmailAddPremium = GenerateRandomNumber + "@" + "080mail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAddPremium);
	        //Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
	        driver.findElement(By.xpath("//a[@id='btnOk']"));
	        click(driver, testcaseName, By.xpath("//a[@id='btnOk']"), testcaseName, test);
			
						
			
			
			
		}
		
		public void EmptyFirstName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), testcaseName, test);
			
		}
		
		public void EmptyLastName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("");
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), testcaseName, test);
			
		}
		
		public void MinCharUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn3']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn3']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress3']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit3']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit3']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sog"  ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), testcaseName, test);
			
		}
		
		public void MaxCharUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn2']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn2']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress2']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit2']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit2']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), testcaseName, test);
			
		}
		
		public void MissingPasswordRequisite(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey");
			click(driver, testcaseName, (By.xpath("//input[@id='txtConfirmPassword']")), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='div_Pass']"), testcaseName, test);
			
		}
		
		public void InvalidUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + "  " + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			//waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='div_Pass']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), testcaseName, test);
			
		}
		
		public void AllFieldsEmpty(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//button[@id='btnNext']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//button[@id='btnNext']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dvName_error']"), testcaseName, test);
			
		}
		
		public void InvalidCharactersUserId(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			driver.findElement(By.xpath("//a[@id='pop_btn6']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn6']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress6']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit6']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit6']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "~`!@#$%^&*(()-_=+][}{';:?></.," + "  " + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			//waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='div_Pass']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='userinfo']"), testcaseName, test);
			
		}
		
		public void EmptyCompanyInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_company_error']"), testcaseName, test);
			
			
			
			
			
		}
		
		public void EmptyOrgName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys(" ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_company_error']"), testcaseName, test);
		/*	driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	*/
			
			
			
			
		}
		
		public void EmptyJobTitle(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys(" ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
		   waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_responsibility_error']"), testcaseName, test);
		/*	Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddProjectSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Personal Use']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//span[@id='ddTimeZoneSelected']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='(GMT-10:00) Hawaii']"), testcaseName, test);
			Thread.sleep(10);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			//driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			//driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			//driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			//click(driver, testcaseName, By.xpath("//a[text()='Continue']"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvIndustrySubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	*/
			
			
			
			
		}
		
		public void EmptyPhoneNumber(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys(" ");
		   	Thread.sleep(10);
		   	
		   	click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
					click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_phone_error']"), testcaseName, test);
							
			
			
			
		}
		
		public void InvalidPhoneNumber(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("987");
		   	Thread.sleep(10);
		   	
		   	click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
					click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_phone_error']"), testcaseName, test);
							
			
			
			
		}
		
		public void EmptyWorkInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9998877887");
		   	Thread.sleep(10);
		   	//click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			//click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_industry_error']"), testcaseName, test);
			
							
			
			
			
		}
		
		public void EmptyProjectInfo(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys(Userid);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtConfirmPassword']")).sendKeys("Sogosurvey@123");
			//driver.findElement(By.xpath("//button[@id='btnNext']"));
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//button[@class='sogo-submitopt']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("SoGo ");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9998877887");
		   	Thread.sleep(10);
		   	click(driver, testcaseName, By.xpath("//span[@id=\"ddIndustrySelected\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[text()='Education ']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='pDisclaimerHelpUsCheckBox']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSubmit']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='dv_project_error']"), testcaseName, test);
							
			
			
			
		}
		
		public void ExistingUserID(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='pop_btn5']"));
			click(driver, testcaseName, By.xpath("//a[@id='pop_btn5']"), testcaseName, test);
			String GenerateRandomNumber = UUID.randomUUID().toString();
			String EmailAdd = GenerateRandomNumber + "@" + "gmail.com";
	        driver.findElement(By.xpath("//input[@id='EmailAddress5']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
			driver.findElement(By.xpath("//a[@id='submit5']"));
			click(driver, testcaseName, By.xpath("//a[@id='submit5']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtfirstname']")).sendKeys("Mohammad");
			Thread.sleep(10);
			driver.findElement(By.xpath("//input[@id='txtlastname']")).sendKeys("Numan");
			Thread.sleep(10);
			//WebElement Element3 = driver.findElement(By.xpath("//input[@id='txtuserId']"));
			//String Userid = "sogo_" + GenerateRandomNumber ;
			driver.findElement(By.xpath("//input[@id='txtuserId']")).sendKeys("sogo_nkureshi");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='txtpassword']")).sendKeys("Sogosurvey@123");
			Thread.sleep(1000);
			click(driver, testcaseName, By.xpath("//div[@id='availableids']"), testcaseName, test);
			//waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='availableids']"), testcaseName, test); 
							
			
			
			
		}
		
		public void CreatePlusPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			//This is to be run on QAUC only
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnProfMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnProfMonthly']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("378282246310005");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("9997");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
		}
		
		public void CreateProYPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEntMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEntMonthly']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("5499740000000057");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("998");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
		}
		
		public void CreateProMPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEntMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEntMonthly']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), testcaseName, test);
	        click(driver, testcaseName, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), testcaseName, test);
	        // waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("4012888888881881");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("111");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
		}
		
		public void CreatePremYPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEP']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEP']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
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
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("5499740000000057");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("998");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
		}
		
		public void CreatePremMPaidAccount(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnEP']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnEP']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), testcaseName, test);
	        click(driver, testcaseName, By.xpath("//div[@id='ctl00_ContentPlaceHolder1_dvMonthlyPriceCard']"), testcaseName, test);
	        // waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("378282246310005");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("9997");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	
			
		}
		
		public void InvalidCC(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnProfMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnProfMonthly']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("30569309025904");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2040']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("9997");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblErrorMsg']"), testcaseName, test);
		/*	click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	*/
			
		}
		
		public void InvalidDate(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			driver.findElement(By.xpath("//a[@id='btnProfMonthly']"));
			click(driver, testcaseName, By.xpath("//a[@id='btnProfMonthly']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtfirstname']"), testcaseName, test);
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
	        driver.findElement(By.xpath("//input[@name='txtEmailId']")).sendKeys(EmailAdd);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@name='pDisclaimerCheckBox']"), testcaseName, test);
	        Thread.sleep(1000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        Thread.sleep(5000);
	        click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
	        waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']"), testcaseName, test);
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtAddress']")).sendKeys("Pali Village");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCity']")).sendKeys("Mumbai");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtstate']")).sendKeys("Maharashtra");
	        driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtpincode']")).sendKeys("400050");
	        click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlcountry']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='Togo']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtcardno']")).sendKeys("378282246310005");
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpmonth']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='01-Jan']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddlexpyear']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//option[text()='2022']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txtCCV']")).sendKeys("9997");
			click(driver, testcaseName, By.xpath("//input[@type='submit']"), testcaseName, test);
			Thread.sleep(1000);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblErrorMsg']"), testcaseName, test);
		/*	click(driver, testcaseName, By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btnConfirm']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvPreparingAccount']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@name='btnReady']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@id='btnReady']"), testcaseName, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='txtCompany']"), testcaseName, test);
			driver.findElement(By.xpath("//input[@id='txtCompany']")).sendKeys("Sogo");
			driver.findElement(By.xpath("//input[@id='txtJobTitle']")).sendKeys("QA");
			driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("9988009988");
			click(driver, testcaseName, By.xpath("//a[@onclick='validateAccountSetupForm()']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Education\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='dvIndustrySubmitBtn']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value=\"Measure Customer Experience\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"dvProjectSubmitBtn\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@onclick='showNextStep(3)']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id=\"btnLetsGo\"]"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-tooltip-close']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//input[@value='End Tour']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@class='pt-next-btn fr']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//span[@id='z_h_ctl00_lblInitials1']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//div[@id='z_h_ctl00_liAccountSettings']"), testcaseName, test);
			click(driver, testcaseName, By.xpath("//a[@id='SideNavigation_aCompanyInfo']"), testcaseName, test);
			String actualEmailid =  driver.findElement(By.xpath("//span[@id='lblEmail']")).getText();
			Assert.assertEquals( actualEmailid, EmailAdd, "Email ids do not match.");	*/
			
		}
		

		
}
