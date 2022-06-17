package pageobjects;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.time.CalendarUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.DateUtil;

import property.IHomePage;
import property.ISMXPage;
import property.ISurveyPage;
import testsuitebase.TestResultStatus;
import utility.SeleniumUtils;

public class SMXPage extends SeleniumUtils implements ISMXPage {
	public double finish, start;
	public double end;
	
	public void createSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		createNewSurvey(driver, param, test);
		enterDescription(driver, param, test);

		enterNetPromoter(driver, param, test);
		enterTextBox(driver, param, test);
		enterRadioButton(driver, param, test);
		enterCheckBoxButton(driver, param, test);
		enterDropDownButton(driver, param, test);
		enterDemographicsButton(driver, param, test);
		enterRatingScaleButton(driver, param, test);
		enterSymbolRatingScaleButton(driver, param, test);
		enterLikeDislikeButton(driver, param, test);
		enterRankingQuestionButton(driver, param, test);
		enterDateButton(driver, param, test);

		enterImageChoiceButton(driver, param, test);
		enterMultipleTextBoxButton(driver, param, test);
		enterMultiDropDownButton(driver, param, test);
		enterRadioGridButton(driver, param, test);
		enterCheckBoxGridButton(driver, param, test);
		enterRatingRadioGridButton(driver, param, test);
		enterRatingDropDownGridButton(driver, param, test);

		enterRatingScaleGridButton(driver, param, test);
		enterMatrixGridButton(driver, param, test);
		enterHorizontalRadioButton(driver, param, test);
		enterAttachmentButton(driver, param, test);
		enterRatingRadioButton(driver, param, test);
		enterRatingDropDownButton(driver, param, test);
		enterListBoxButton(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, captcha_button, test);
	}

	public void createPoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectCreatePoll(driver, param, test);
		createPollButton(driver, param, test);
		selectAnswerlibrary(driver, param, test);
		pollSettings(driver, param, test);
		visualSettings(driver, param, test);
		resultSettings(driver, param, test);
		publishPoll(driver, param, test);
		pollParticipation(driver, param, test);
		pollTrack(driver, param, test);
		answerCheck(driver, param, test);
		
	}
	
	public void selectCreateProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		click(driver, testcaseName, create_project, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectProjectType(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().frame("iframe1");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//div[@class='cls-projecttype-container']//div[contains(text(),'"+ param.get("surveyType") +"')]"), param.get("surveyType"), test);        
	   click(driver, testcaseName,  By.xpath("//div[@class='cls-projecttype-container']//div[contains(text(),'"+ param.get("surveyType") +"')]"), param.get("surveyType"), test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);
		enterSurveyName(driver, param, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	

	public void logoUploadFromComputer(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation") +"");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
		WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
		if(img.isDisplayed())
		{
			reportPass("logo is displayed", test);
		}
		else
		{
			reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
		}
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		click(driver, testcaseName, save_btn, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
		  WebElement img2 = driver.findElement(By.xpath("//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed())
		  {
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		 
		  deleteLogo(driver, param, test);
	}
	public void useAccountLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, use_account_logo, test);
		click(driver, testcaseName, use_account_logo, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), "account logo", test);
		WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
		if(img.isDisplayed())
		{
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		click(driver, testcaseName, save_btn, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), "account logo after save", test);
		  WebElement img2 = driver.findElement(By.xpath(
		  "//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed()) {
		  
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		
	}
	public void deleteUseAccountLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		 useAccountLogo(driver, param, test);
		deleteLogo(driver, param, test);
	}
	public void logoValidation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
	WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
	if(img.isDisplayed())
	{
		  reportPass("logo is displayed", test);
	  } 
	  else
		{
			reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
		}
	waitforElemPresent(driver, testcaseName, 30, save_btn, test);
	click(driver, testcaseName, save_btn, test);
	driver.switchTo().defaultContent();
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
	  WebElement img2 = driver.findElement(By.xpath(
	  "//img[@id='imgSurveyLogo1']"));
	  if(img2.isDisplayed()){
		  
		  reportPass("logo is displayed", test);
	  } 
	  else
		{
			reportFail(testcaseName,"logo is not displayed" , test);  
		}
}
	public void logoValidation2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
		  WebElement img2 = driver.findElement(By.xpath(
		  "//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed()){
		  
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);  
			}
	}
	public void logoCommonSteps(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {

		String testcaseName = param.get("TestCaseName");
		
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_logo, test);
		click(driver, testcaseName, add_logo, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'AddSurveyLogo.aspx?')]")));
	}
	public void copyFromAnotherProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, copy_from_other_project, test);
		 click(driver, testcaseName, copy_from_other_project, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[normalize-space()='--Select Project--']"), testcaseName, test);
 	    click(driver, testcaseName, By.xpath("//a[normalize-space()='--Select Project--']"), testcaseName, test);
 	    waitforElemPresent(driver, testcaseName, 10,   By.xpath("//span[normalize-space()='"+ param.get("foldername") +"']"), param.get("foldername"), test);        
	   	click(driver, testcaseName,  By.xpath("//span[normalize-space()='"+ param.get("foldername") +"']"), param.get("foldername"), test); 
 	   waitforElemPresent(driver, testcaseName, 30, select_main, test);
		 doubleClick(driver, testcaseName, select_main, test);
		 waitforElemPresent(driver, testcaseName, 10,   By.xpath("//a[normalize-space()='"+ param.get("ThanksMsg") +"']"), param.get("ThanksMsg"), test);        
		   	click(driver, testcaseName,  By.xpath("//a[normalize-space()='"+ param.get("ThanksMsg") +"']"), param.get("ThanksMsg"), test); 
	    waitforElemPresent(driver, testcaseName, 30, copy_from_anothersurvey, test);
		 doubleClick(driver, testcaseName, copy_from_anothersurvey, test);
		 logoValidation(driver, param, test);
		 deleteLogo(driver, param, test);
	}
	
	
	public void insertFromUrl(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		  waitforElemPresent(driver, testcaseName, 30, insert_from_url, test);
			click(driver, testcaseName, insert_from_url, test);
			WebElement q6 = driver.findElement(By.xpath("//input[@id='txtLogoURL']"));
			q6.sendKeys("https://image.shutterstock.com/image-vector/link-icon-hyperlink-chain-symbol-260nw-1186749931.jpg");
			 waitforElemPresent(driver, testcaseName, 30, btn_logo_url, test);
			 click(driver, testcaseName, btn_logo_url, test);
			 logoValidation(driver, param, test);
			 deleteLogo(driver, param, test);
	}
	public void deleteLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 30, logo_display, test);
			WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action = new Actions(driver);
			action.moveToElement(hower).perform();
			waitforElemPresent(driver, testcaseName, 30, delete_logo_display, test);
			click(driver, testcaseName, delete_logo_display, test);
			waitforElemPresent(driver, testcaseName, 30, delete_icon, test);
			click(driver, testcaseName, delete_icon, test);
	}
	
	public void alignOfLogoLeft(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			 useAccountLogo(driver, param, test);
			WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action = new Actions(driver);
			action.moveToElement(hower).perform();
			waitforElemPresent(driver, testcaseName, 30, align_icon1, test);
			click(driver, testcaseName, align_icon1, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[normalize-space()='Left']"),"logo left align ", test);
			click(driver, testcaseName, By.xpath("//span[normalize-space()='Left']"),"logo left align ", test);
			 logoValidation2(driver, param, test);
	}
	public void alignOfLogoRight(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			 useAccountLogo(driver, param, test);
			
			waitforElemPresent(driver, testcaseName, 30, logo_display, test);
			
			WebElement hower1 = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(hower1).perform();
			
			waitforElemPresent(driver, testcaseName, 30, align_icon1, test);
			click(driver, testcaseName, align_icon1, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[normalize-space()='Right']"),"logo right align ", test);
			click(driver, testcaseName, By.xpath("//span[normalize-space()='Right']"),"logo right align", test);
			
			logoValidation2(driver, param, test);
	}
	
	
	public void uploadingJPGFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation1") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
				}
			
	}
	
	
	public void uploadingGIFFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation2") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			
	}
	public void uploadingJPEGFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation3") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}	
	}
	public void logoGreaterThan5mb(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation4") +"");
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
	        // Print the alert message to console
		 String alert_msg =  ("Alert Box message: " + alertPopUp.getText());
	        // Accept the alert popup
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg1 = param.get("DOB");
	        if(alert_msg.contains(alert_msg1))
				
				System.out.println(" \"matched\" ");
				else
				//Fail
				System.out.println(" \"not matched\" ");
	}
	
	
	public void unSupportedFileForLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation5") +"");
		 Alert alertPopUp = driver.switchTo().alert();
	        // Print the alert message to console
		 String alert_msg =  ("Alert Box message: " + alertPopUp.getText());
	        // Accept the alert popup
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg0 = param.get("Grade");
	        if(alert_msg.contains(alert_msg0))
				
				System.out.println(" \"matched\" ");
				else
				//Fail
				System.out.println(" \"not matched\" ");
		}
		
	public void selectCreatePoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().frame("iframe1");
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='cls-projecttype-container']//div[@class='cls-project-name-container'][normalize-space()='Poll']")));
		waitforElemPresent(driver, testcaseName, 30, create_poll, test);
		click(driver, testcaseName, create_poll, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	
	
	public void selectAnswerlibrary(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, answer_library, test);
		click(driver, testcaseName, answer_library,test);
		WebElement OPTION = driver.findElement(By.xpath("//a[@id='A1']"));
		OPTION.click();
		driver.switchTo().frame("iframe1");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("RadioButton") +"']"), param.get("RadioButton"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("RadioButton") +"']"), param.get("RadioButton"), test); 
	   	click(driver, testcaseName, use_this_list,test);
	   	driver.switchTo().defaultContent();
	   	continuebuttonp(driver, param, test);
	   	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@title='Auto-translate with Bing.']/parent::a"),"Bing Translate",test);
		click(driver, testcaseName, By.xpath("//img[@title='Auto-translate with Bing.']/parent::a"),"Bing Translate",test); 
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttont, test);
		click(driver, testcaseName, Continue_Buttont,test);
	}
	
	
	public void continuebuttonp(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, continue_buttonp, test);
		
	}
	
	public void pollSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, expire_poll_yes, test);
		click(driver, testcaseName, expire_poll_yes,test);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonps, test);
		click(driver, testcaseName, Continue_Buttonps,test);

	}
	
	
	public void visualSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonvs, test);
		click(driver, testcaseName, Continue_Buttonvs,test);
	}
	
	
	public void resultSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, Result_Settings, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonrs, test);
		click(driver, testcaseName, Continue_Buttonrs,test);
	}
	
	public void publishPoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String URl = (driver.findElement(By.xpath("//div[@id='txt_English']")).getText());
		waitforElemPresent(driver, testcaseName, 30, Save_And_Finish, test);
		click(driver, testcaseName, Save_And_Finish,test);
		executeScript(driver, testcaseName, "window.open()", test);
		Thread.sleep(2000);
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
		driver.get(URl);
	}
	
	public void pollParticipation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);
	   	click(driver, testcaseName, Participation_Poll_Submit, test);
		driver.close();
		driver.switchTo().window(param.get("currentWindowHandle"));
	}	
		
	public void pollTrack(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, Track_Poll, test);
		waitforElemPresent(driver, testcaseName, 30, Public_Access, test);
		click(driver, testcaseName, Public_Access, test);
	}
	
	public void answerCheck(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
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
		
	String	ANS = param.get("AnswerOptions");
	
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='individual-answer']"), ANS, test);
		
	String Ans = (driver.findElement(By.xpath("//div[@class='individual-answer']")).getText());
		if(Ans.contains(ANS))
			
			System.out.println(" \"matched\" ");
			else
			//Fail
			System.out.println("e \"not matched\" ");
	}
	
	
	
	public void selectBlankSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool')]"), "Iframe", test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool')]")));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, survey_button, test);
		click(driver, testcaseName, survey_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);

	}
	
	
	
	
	
	public void createNewSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		enterSurveyName(driver, param, test);
		selectFolder(driver, param, test);
		selectPrimaryLanugage(driver, param, test);
		selectSecondaryLanugage(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);
	}
	
	public void createPollButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		enterSurveyName(driver, param, test);
		
		addlanguages(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	
	
	public void enterSurveyName(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, survey_name, test);
		String surveyName = param.get("surveyname") + " - " + strDate;
		param.put("surveyName", surveyName);
		setText(driver, testcaseName, survey_name, surveyName, test);
	}
	public void selectFolder(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, folder, test);
		click(driver, testcaseName, folder, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		click(driver, testcaseName, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		
	}
		
	public void selectPrimaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, primary_lanugage_dd, test);
		click(driver, testcaseName, primary_lanugage_dd, test);
		waitforElemPresent(driver, testcaseName, 30, primary_lanugage_list, test);
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[@class='o-menu-list-item'][contains(text(),'" + param.get("primarylanguage") + "')]"), param.get("primarylanguage"), test);
		click(driver, testcaseName, By.xpath("//div[@class='o-menu-list-item'][contains(text(),'" + param.get("primarylanguage") + "')]"), param.get("primarylanguage"), test);

		
	}
	
	public void selectSecondaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, secondary_language_switch, test);
		click(driver, testcaseName, secondary_language_switch,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd, test);
		click(driver, testcaseName, secondary_lanugage_dd,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd_search, test);
		setText(driver, testcaseName, secondary_lanugage_dd_search, param.get("secondarylanguage"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		click(driver, testcaseName, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);

		
	}
	
	public void addlanguages(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd, test);
		click(driver, testcaseName, secondary_lanugage_dd,test);
		//driver.findElement(By.xpath("//label[normalize-space()='Arabic']"));
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("secondarylanguage") +"']"), param.get("secondarylanguage"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("secondarylanguage") +"']"), param.get("secondarylanguage"), test);        
	
	}
	
	public void enterDescription(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, description_button, test);
		waitForJStoLoad(driver, 30);
		doubleClick(driver, testcaseName, description_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("description"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("description") +"']"), "Description Added "+ param.get("description"), test);
	                                                             
	}
	
	
	public void enterNetPromoter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, net_promoter_score_button, test);
		doubleClick(driver, testcaseName, net_promoter_score_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		String netPromoterLabel = getText(driver, testcaseName, description_text, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']"), "Net Promoter Label Added "+ netPromoterLabel, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']/parent::div/following-sibling::div//div[@class='clearfix slider-div']"), "Net Promoter Label Added "+ netPromoterLabel, test);
	}	

	public void enterTextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, text_box_button, test);
		doubleClick(driver, testcaseName, text_box_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']"), "Text Box Label Added "+ param.get("textbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']/parent::div/following-sibling::div//input"), "Text Box Added "+ param.get("textbox"), test);
	}
	
	public void enterRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, radio_button, test);
		doubleClick(driver, testcaseName, radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']"), "Radio Buttons Label Added "+ param.get("radiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Radio Buttons Added "+ param.get("radiobutton"), test);
	}
	
	public void enterCheckBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, check_box_button, test);
		doubleClick(driver, testcaseName, check_box_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("checkbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, none_of_above, test);
		click(driver, testcaseName, none_of_above, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']"), "Check Box Label Added "+ param.get("checkbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Check Box Added "+ param.get("checkbox"), test);
	}
	
	
	public void answersLibrary(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, answers_library, test);
		click(driver, testcaseName, answers_library, test);
		if(driver.getTitle().toLowerCase().contains("sogosurvey")) {
			waitforElemPresent(driver, testcaseName, 30, answers_library_new, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
			new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		}else {
			waitforElemPresent(driver, testcaseName, 10, get_answer_options_library, test);
			click(driver, testcaseName, get_answer_options_library, test);
			waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_options, test);
			waitForLoad(driver, testcaseName,60, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS)));
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			click(driver, testcaseName, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
			click(driver, testcaseName, use_this_list_button, test);
			driver.switchTo().defaultContent();
			}
		}
	
	public void answersLibraryGrid(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, answers_library, test);
		click(driver, testcaseName, answers_library, test);
		if(driver.getTitle().toLowerCase().contains("sogosurvey")) {
			waitforElemPresent(driver, testcaseName, 30, answers_library_new, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
			new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		}else {
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 10, get_answer_options_library, test);
			click(driver, testcaseName, get_answer_options_library, test);
			waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_options_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS_GRID)));
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			click(driver, testcaseName, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
			click(driver, testcaseName, use_this_list_button, test);
			driver.switchTo().defaultContent();
		}
		
		}
	
	public void answersLibrary2(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, By.xpath("(//div[text()='More '])[2]"), "More", test);
		click(driver, testcaseName, By.xpath("(//div[text()='More '])[2]"), "More", test);
		
		waitforElemPresent(driver, testcaseName, 10, answers_library2, test);
		click(driver, testcaseName, answers_library2, test);
		if(driver.getTitle().toLowerCase().contains("sogosurvey")) {
			waitforElemPresent(driver, testcaseName, 30, answers_library_new, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
			new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		}else {
			waitForLoad(driver, testcaseName, 60, test);
//			waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_options2, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS2)));
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			click(driver, testcaseName, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
			waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
			click(driver, testcaseName, use_this_list_button, test);
			driver.switchTo().parentFrame();
		}
		
		}
	
	public void questionsLibrary(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, By.xpath("(//div[text()='More '])[1]"), "More", test);
		click(driver, testcaseName, By.xpath("(//div[text()='More '])[1]"), "More", test);
		
		waitforElemPresent(driver, testcaseName, 10, questions_library2, test);
		click(driver, testcaseName, questions_library2, test);
		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options2, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS2)));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		Thread.sleep(3000);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().parentFrame();
		}
	
	public void questionsLibrary2(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		waitforElemPresent(driver, testcaseName, 10, questions_library3, test);
		click(driver, testcaseName, questions_library3, test);
		
		waitforElemPresent(driver, testcaseName, 10, get_questions_questions_library, test);
		click(driver, testcaseName, get_questions_questions_library, test);
		
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options3, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS3)));
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void enterDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, drop_down_button, test);
		doubleClick(driver, testcaseName, drop_down_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("dropdown"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']"), "Drop Down Label Added "+ param.get("dropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']/parent::div/following-sibling::div/div[@class='clsEdit ControlColorsDD']"), "Drop Down Added "+ param.get("dropdown"), test);
	}
	
	public void enterDemographicsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, demographics_button, test);
		doubleClick(driver, testcaseName, demographics_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("demographics"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, name_expand, test);
		click(driver, testcaseName, name_expand, test);
		waitforElemPresent(driver, testcaseName, 30, name_title, test);
		click(driver, testcaseName, name_title, test);
//		waitforElemPresent(driver, testcaseName, 30, name_full_name, test);
//		click(driver, testcaseName, name_full_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_first_name, test);
		click(driver, testcaseName, name_first_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_middle_name, test);
		click(driver, testcaseName, name_middle_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_last_name, test);
		click(driver, testcaseName, name_last_name, test);
		waitforElemPresent(driver, testcaseName, 30, gender, test);
		click(driver, testcaseName, gender, test);
		waitforElemPresent(driver, testcaseName, 30, dob, test);
		click(driver, testcaseName, dob, test);
		
		waitforElemPresent(driver, testcaseName, 30, address_expand, test);
		click(driver, testcaseName, address_expand, test);
		waitforElemPresent(driver, testcaseName, 30, address_street1, test);
		click(driver, testcaseName, address_street1, test);
		waitforElemPresent(driver, testcaseName, 30, address_street2, test);
		click(driver, testcaseName, address_street2, test);
		waitforElemPresent(driver, testcaseName, 30, address_city, test);
		click(driver, testcaseName, address_city, test);
		waitforElemPresent(driver, testcaseName, 30, address_country, test);
		click(driver, testcaseName, address_country, test);
		waitforElemPresent(driver, testcaseName, 30, address_state, test);
		click(driver, testcaseName, address_state, test);
		waitforElemPresent(driver, testcaseName, 30, address_zip, test);
		click(driver, testcaseName, address_zip, test);
//		waitforElemPresent(driver, testcaseName, 30, address_zipplus4, test);
//		click(driver, testcaseName, address_zipplus4, test);
		
		waitforElemPresent(driver, testcaseName, 30, telephone_expand, test);
		click(driver, testcaseName, telephone_expand, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_telephone, test);
		click(driver, testcaseName, telephone_telephone, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_extension, test);
		click(driver, testcaseName, telephone_extension, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_fax, test);
		click(driver, testcaseName, telephone_fax, test);
		
		waitforElemPresent(driver, testcaseName, 30, email_address, test);
		click(driver, testcaseName, email_address, test);
		waitforElemPresent(driver, testcaseName, 30, reenter_email_address, test);
		click(driver, testcaseName, reenter_email_address, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']"), "Demographics Label Added "+ param.get("demographics"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Demographics Added "+ param.get("demographics"), test);
	}
	
	public void enterRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_button, test);
		doubleClick(driver, testcaseName, rating_scale_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscale"), test);
		driver.switchTo().defaultContent();
		scrollIntoView(driver, testcaseName, show_na_option, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, show_na_option, test);
		click(driver, testcaseName, show_na_option, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_scale_in_reverse_order, test);
		click(driver, testcaseName, show_scale_in_reverse_order, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_participant_rating_field, test);
		click(driver, testcaseName, show_participant_rating_field, test);
		Thread.sleep(500);
		scrollIntoView(driver, testcaseName, save_button, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']"), "Rating Scale Added "+ param.get("ratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']/parent::div/following-sibling::div//div[contains(@class,'slide ui-slider ui-slider-horizontal')]"), "Rating Scale Added "+ param.get("ratingscale"), test);
	}
	
	public void enterSymbolRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] subQuestions = param.get("subquestions").split(";");
		waitforElemPresent(driver, testcaseName, 30, symbol_rating_scale_button, test);
		doubleClick(driver, testcaseName, symbol_rating_scale_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("symbolratingscale"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, increase_srs_subque, test);
//		Commenting as drop down UI is changed to up/down button UI		
//		Select select = new Select(driver.findElement(By.xpath(NUMBER_SUBQUESTION)));
//		select.selectByVisibleText("6");
//		Thread.sleep(500);
		for(int i=0; i<5; i++) {
			click(driver, testcaseName, increase_srs_subque, test);
			Thread.sleep(500);
		}
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption1']"), "Sub Question 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption1']"), subQuestions[0], "Sub Question 1", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_1']"), "Sub Question 1 Scale", test);
		Select selectSubquestion1 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_1']")));
		selectSubquestion1.selectByVisibleText("Star");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption2']"), "Sub Question 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption2']"), subQuestions[1], "Sub Question 2", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_2']"), "Sub Question 2 Scale", test);
		Select selectSubquestion2 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_2']")));
		selectSubquestion2.selectByVisibleText("Thumb up");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption3']"), "Sub Question 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption3']"), subQuestions[2], "Sub Question 3", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_3']"), "Sub Question 3 Scale", test);
		Select selectSubquestion3 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_3']")));
		selectSubquestion3.selectByVisibleText("Heart");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption4']"), "Sub Question 4", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption4']"), subQuestions[3], "Sub Question 4", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_4']"), "Sub Question 4 Scale", test);
		Select selectSubquestion4 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_4']")));
		selectSubquestion4.selectByVisibleText("Check mark");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption5']"), "Sub Question 5", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption5']"), subQuestions[4], "Sub Question 5", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_5']"), "Sub Question 5 Scale", test);
		Select selectSubquestion5 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_5']")));
		selectSubquestion5.selectByVisibleText("Dollar sign");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption6']"), "Sub Question 6", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption6']"), subQuestions[5], "Sub Question 6", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_6']"), "Sub Question 6 Scale", test);
		Select selectSubquestion6 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_6']")));
		selectSubquestion6.selectByVisibleText("Person");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
	}
	
	public void enterLikeDislikeButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, like_dislike_button, test);
		doubleClick(driver, testcaseName, like_dislike_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("likedislike"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']"), "Like/Dislike Added "+ param.get("likedislike"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Like/Dislike Added "+ param.get("likedislike"), test);
	}
	
	public void enterRankingQuestionButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, ranking_question_button, test);
		doubleClick(driver, testcaseName, ranking_question_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ranking"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']"), "Ranking Added "+ param.get("ranking"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Ranking Added "+ param.get("ranking"), test);
	}
	
	public void enterDateButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, date_button, test);
		doubleClick(driver, testcaseName, date_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("date"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']"), "Date Added "+ param.get("date"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']/parent::div/following-sibling::div//div[@class='dateIcon']"), "Date Added "+ param.get("date"), test);
	}
	
	public void enterImageChoiceButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoView(driver, testcaseName, image_choice_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, image_choice_button, test);
		doubleClick(driver, testcaseName, image_choice_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("imagechoice"), test);
		driver.switchTo().defaultContent();
		String[] images = param.get("images").split(";");
		String[] reportingValue = param.get("reportingvalue").split(";");
		for(int i = 0; i < images.length; i++) {
			if(i == 0){
				waitforElemPresent(driver, testcaseName, 10, add_image_icon, test);
				click(driver, testcaseName, add_image_icon, test);
				waitforElemPresent(driver, testcaseName, 10, iframe_answer_options4, test);
				driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS4)));
			} else {
				waitforElemPresent(driver, testcaseName, 10, add_image_icon2, test);
				click(driver, testcaseName, add_image_icon2, test);
			}
			
			waitForLoad(driver, testcaseName, 30, test);

			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + images[i]);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 10, reporting_value, test);
			setText(driver, testcaseName, reporting_value, reportingValue[i], test);
		}
		waitforElemPresent(driver, testcaseName, 10, save_button_ind, test);
		click(driver, testcaseName, save_button_ind, test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']"), "Image Choice Added "+ param.get("imagechoice"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']"), "Image Choice Added "+ param.get("imagechoice"), test);
		Thread.sleep(1000);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']")).size();
		if(size == images.length) {
			reportPass("Image choice options added in the survey", test);
		} else {
			reportFail(testcaseName, "Image choice options not added in the survey", test);
		}
	}
	
	public void enterMultipleTextBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_textbox_button, test);
		doubleClick(driver, testcaseName, multiple_textbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multitextbox"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, multi_text1, test);
		setText(driver, testcaseName, multi_text1, param.get("textbox1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_text2, test);
		setText(driver, testcaseName, multi_text2, param.get("textbox2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Text Box options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Text Box options not added in the survey", test);
		}
	}
	
	public void enterMultiDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_dropdown_button, test);
		doubleClick(driver, testcaseName, multiple_dropdown_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multidropdown"), test);
		driver.switchTo().defaultContent();
		answersLibraryGrid(driver, param, param.get("AnswerOptions1"), test);
		
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown1, test);
		setText(driver, testcaseName, multi_dropdown1, param.get("dropdown1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown2, test);
		setText(driver, testcaseName, multi_dropdown2, param.get("dropdown2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Drop Down options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Drop Down options not added in the survey", test);
		}
	}
	
	public void enterRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_radio_button, test);
		doubleClick(driver, testcaseName, multiple_radio_button, test);
		Thread.sleep(2000);
		waitForLoad(driver, testcaseName, 30, test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		
		
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multiradio"), test);
		driver.switchTo().parentFrame();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
//		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']"), "Radio Grid Added "+ param.get("multiradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Radio Grid Added "+ param.get("multiradio"), test);
		
	}
	
	public void enterCheckBoxGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_checkbox_button, test);
		doubleClick(driver, testcaseName, multiple_checkbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multicheckbox"), test);
		driver.switchTo().parentFrame();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		
	}
	
	public void enterRatingRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio_button, test);
		doubleClick(driver, testcaseName, rating_radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradio"), test);
		driver.switchTo().parentFrame();
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 1']"), "Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 1']"), "Yes", "Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 2']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 2']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 3']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 3']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "0", "Weight 3", test);
		
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		
	}
	
	public void enterRatingDropDownGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_drop_down_button, test);
		doubleClick(driver, testcaseName, rating_drop_down_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdown"), test);
		driver.switchTo().parentFrame();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		click(driver, testcaseName, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_add_manually, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ADD_MANUALLY)));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_0']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_0']"), "Yes", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_1']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_1']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_2']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_2']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_0']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_0']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_1']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_1']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_2']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_2']"), "0", "Weight 3", test);
		waitforElemPresent(driver, testcaseName, 10, save_button_manual, test);
		click(driver, testcaseName, save_button_manual, test);
		driver.switchTo().parentFrame();
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		
	}
	
	public void enterRatingScaleGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_grid_button, test);
		doubleClick(driver, testcaseName, rating_scale_grid_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscalegrid"), test);
		driver.switchTo().parentFrame();

		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		click(driver, testcaseName, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		click(driver, testcaseName, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtNA_0']"), "Weight NA", test);
		click(driver, testcaseName, By.xpath("//input[@name='txtNA_0']"), "Weight NA", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtNA_0']"), "NA", "Weight NA", test);

		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		
	}
	
	public void enterMatrixGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, matrix_grid_button, test);
		doubleClick(driver, testcaseName, matrix_grid_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("matrixgrid"), test);
		driver.switchTo().parentFrame();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_Header']"), "Radio Grid Header", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_Header']"), "Radio Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_Header']"), param.get("multiradio"), "Radio Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_Header']"), "Checkbox Grid Header", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_Header']"), "Radio Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_Header']"), param.get("multicheckbox"), "Checkbox Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Radio Choice 1", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Radio Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Yes", "Radio Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "Radio Choice 2", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_1_Choice']"), "Radio Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "No", "Radio Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "Radio Choice 3", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_2_Choice']"), "Radio Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "NA", "Radio Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Checkbox Choice 1", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Checkbox Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Yes", "Checkbox Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "Checkbox Choice 2", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_1_Choice']"), "Checkbox Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "No", "Checkbox Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "Checkbox Choice 3", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_2_Choice']"), "Checkbox Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "NA", "Checkbox Choice 3", test);
Thread.sleep(1000);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		
	}
	
	public void enterHorizontalRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoView(driver, testcaseName, horizontal_radio_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, horizontal_radio_button, test);
		doubleClick(driver, testcaseName, horizontal_radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("horizontalradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']"), "Horizontal Radio Buttons Label Added "+ param.get("horizontalradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Horizontal Radio Buttons Added "+ param.get("horizontalradiobutton"), test);
	}
	
	public void enterNumericAllocationsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, numeric_allocations_button, test);
		doubleClick(driver, testcaseName, numeric_allocations_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("numericallocations"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
	}
	
	public void enterAttachmentButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, attachments_button, test);
		doubleClick(driver, testcaseName, attachments_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("attachments"), test);
		driver.switchTo().defaultContent();
		questionsLibrary2(driver, param, param.get("QuestionOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']"), "Attachments Added "+ param.get("attachments"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Attachments Added "+ param.get("attachments"), test);
	}
	
	public void enterRatingRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio2_button, test);
		doubleClick(driver, testcaseName, rating_radio2_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']"), "Rating Radio Buttons "+ param.get("ratingradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Rating Radio Buttons Added "+ param.get("ratingradiobutton"), test);
	}
	
	public void enterRatingDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_dropdown_button, test);
		doubleClick(driver, testcaseName, rating_dropdown_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdownbutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']"), "Rating Drop Down "+ param.get("ratingdropdownbutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']/parent::div/following-sibling::div/div[@class='Search-DD-Container ControlColorsDD']"), "Rating Drop Down Buttons Added "+ param.get("ratingdropdownbutton"), test);
	}
	
	public void enterListBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, listbox_button, test);
		doubleClick(driver, testcaseName, listbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("listbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, other_checkbox2, test);
		click(driver, testcaseName, other_checkbox2, test);
		waitForLoad(driver, testcaseName, 30, test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']"), "Listbox Added "+ param.get("listbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Listbox Added "+ param.get("listbox"), test);
		
	}
	
	public double goToDesignerPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
		//Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
		//For new dashboard changes
		if (isShowNewAllProjectDashBoard) {		
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, surveyTitle, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"), surveyTitle, 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_edit_icon, 60, 100, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_edit_icon, test);
		}
		//For old dashboard
		else {		
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@sid='"+SID+"']"), "Survey ID "+SID, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
			new Actions(driver).moveToElement(survey).perform();
			waitforElemPresent(driver, testcaseName, 60, IHomePage.edit_icon, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.edit_icon, test);
		}
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	/**
	 * Use this method to get String Array of ZarcaQIDs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<String> getZarcaQIDs(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		ArrayList<Object> pageQuestionData = new ArrayList<Object>();
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		String script = "return SurveyJson.PageQuestion;";
		pageQuestionData = (ArrayList<Object>) executeScript(driver, testcaseName, script, test);
		Iterator<Object> iterator = pageQuestionData.iterator();
		while(iterator.hasNext()) {
			Map<String, Object> temp =  (Map<String, Object>) iterator.next();
			zarcaQIDs.add(temp.get("QID").toString());
		}
		return zarcaQIDs;	
	}
	
	private Boolean chooseCategory(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		// Execute for loop on categoryList and break the loop once the condition is satisfied
		List<WebElement> categoryList = getWebElements(driver, testcaseName, category_list, test);
		for (int i =0; i<categoryList.size(); i++) {
			WebElement category = categoryList.get(i);
			// Remove the leading and trailing white space to prevent NumberFormatException, that is it will convert String " 81 " to "81" and then convert String to Integer
			int questioncount = Integer.parseInt(category.getAttribute("questioncount").strip()); 
			//Check question count before depositing the question to prevent getting JS message of exhausted limit
			if (questioncount<100) {
				String categoryTitle = category.getAttribute("title");
				WebElement searchField = driver.findElement(By.xpath("(//input[contains(@class,'SearchInput')])[2]"));
				searchField.sendKeys(categoryTitle);
				category.click();
				test.log(Status.INFO, categoryTitle +" has been selected");
				Add_Log.info(categoryTitle +" has been selected");
				Reporter.log(categoryTitle +" has been selected");
				isCategoryFound = true;

				break;	
			}
			
		}
		return isCategoryFound;
		
	}
	
	
	public void selectCategoryFromQBList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		waitForLoad(driver, testcaseName, 30, test);
		click(driver, testcaseName, drop_down_of_select_category, test);
		isCategoryFound = chooseCategory(driver, param, test);
		if(isCategoryFound == false) {
			Calendar calendar = Calendar.getInstance();
			String newCategoryName = "Category : " + calendar.getTime();
			click(driver, testcaseName, add_category, test);
			try {
				//waitforElemPresent(driver, testcaseName, 30, toaster_msg, test);
				if(driver.findElement(By.xpath(TOASTER_MSG)).getAttribute("innerHTML").
						contains("You may create up to 50 custom Question Bank categories. Delete one or more to create new categories.")) {
					test.log(Status.INFO, "More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					Add_Log.info("More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					Reporter.log("More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");	
					TestResultStatus.failureReason.add(testcaseName + "| More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					TestResultStatus.TestFail = true;
					Assert.fail();
					}
				} catch(Exception e) {
					
				}		
				setText(driver, testcaseName, add_category_input_field, newCategoryName, test);
				click(driver, testcaseName, save_category_name, test);
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, toaster_msg_of_category_added, test);
				click(driver, testcaseName, close_toaster_msg, test);
				waitforElemNotVisible(driver, testcaseName, 60, toaster_msg_of_category_added, test);
				test.log(Status.INFO, "Category " + newCategoryName + " added");
				Add_Log.info("Category " + newCategoryName + " added");
				Reporter.log("Category " + newCategoryName + " added");
				click(driver, testcaseName, drop_down_of_select_category, test);
				chooseCategory(driver, param, test);
			
		}
	}
	

	
	
	public double depositeQuestionToQuestionBank(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		String placeholderText = null;
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		for(int i=0; i<100; i++) {	
			waitForLoad(driver, testcaseName, 60, test);
			WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
			new Actions(driver).moveToElement(firstQue_WebElement).build().perform();
			waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
			click(driver, testcaseName, question_menu_more_options, test);
			click(driver, testcaseName, deposite_to_question_bank_option, test);
			waitforElemPresent(driver, testcaseName, 60, deposite_to_question_bank_modal, test);
			//waitUntilReqCSSValue(driver, testcaseName, 60, deposite_to_question_bank_modal, "width", "363px", test);
			String width = getWebElement(driver, testcaseName, deposite_to_question_bank_modal, test).getCssValue("width");
			System.out.println("Width = "+width);
			
			selectCategoryFromQBList(driver, param, test);
			placeholderText = getWebElement(driver, testcaseName, drop_down_of_select_category_placeholder, test).getAttribute("innerHTML");
			
			start = System.currentTimeMillis();
			click(driver, testcaseName, deposite_button, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 60, toaster_msg, test);
			end = System.currentTimeMillis();
			
			Thread.sleep(1000);
			System.out.println(getWebElement(driver, testcaseName, toaster_msg, test).getAttribute("innerHTML"));
			if(getWebElement(driver, testcaseName, toaster_msg, test).getAttribute("innerHTML").contains("Question deposited to ")) {
				break;
			}
			
			test.log(Status.INFO, "Limit has been exhausted for "+ placeholderText + " category");
			Add_Log.info("Limit has been exhausted for "+ placeholderText + " category");
			Reporter.log("Limit has been exhausted for "+ placeholderText + " category");
			
		}
		
		test.log(Status.INFO, "Question is deposited under "+ placeholderText + " category");
		Add_Log.info("Question is deposited under "+ placeholderText + " category");
		Reporter.log("Question is deposited under "+ placeholderText + " category");
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	
	
	
	public double addComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
		dragAndDropAction2(driver, testcaseName, question_descriptive_text, firstQue_WebElement, test);
		waitForLoad(driver, testcaseName, 60, test);
		
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, descrText, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ descrText +"']"), "Description Added "+ descrText, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	public double deleteComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Boolean isDescipTextFound = false;
		long totalQuestions = (Long) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion.length;", test);
		int totalUniqueQuestions = Integer.parseInt((String) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion[" +(totalQuestions-1) +"].uniqueqno;", test));
		
		for (int i= 0; i<totalUniqueQuestions; i++) {
			List<WebElement> questionList = getWebElements(driver, testcaseName, list_of_question_in_survey, test);
			WebElement question = questionList.get(i);
			scrollIntoView(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
			// Check qno attribute for each element, for comment question type qno = 'Ci', where, i=1,2,3....n.
			if(question.getAttribute("qno").contains("C")) {
				scrollIntoCenter(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				hoverAction(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_delete_option, test);	
				
				start = System.currentTimeMillis();
				driver.switchTo().alert().accept();
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				isDescipTextFound = true;
				break;
				
			}
			waitforElemNotVisible(driver, testcaseName, 60, question_page_loader, test);
			Thread.sleep(600);
				
		}			
		if (isDescipTextFound == false) {
			click(driver, testcaseName, page_number_drop_down, test);
			List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
			click(driver, testcaseName, surveyPages.get(0), "Page No 1", test);
			waitForElementToBePresentOnDOM(driver, testcaseName, 60, page_number_drop_down_value_1, test);		
			addComment(driver, param, descrText, test);
			hoverAction(driver, testcaseName, By.xpath("//span[contains(text(),'" + descrText + "')]"),
					"Description Question - Added via addComment method", test);
			click(driver, testcaseName, question_menu_delete_option, test);

			start = System.currentTimeMillis();
			driver.switchTo().alert().accept();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 60, designer_button, test);
			end = System.currentTimeMillis();
		}
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	public double movePage(WebDriver driver, HashMap<String, String> param, int pageNo, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_number_drop_down, test);
		waitforElemPresent(driver, testcaseName, 60, go_to_page_list, test);
		List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
		
		click(driver, testcaseName, surveyPages.get(pageNo-1), "Page "+pageNo, test);
		waitforElemPresent(driver, testcaseName, 60, page_actions, test);
		click(driver, testcaseName, page_actions, test);
		click(driver, testcaseName, move_page, test);		
		Select select = new Select(getWebElement(driver, testcaseName, move_page_options, test));
		
		start = System.currentTimeMillis();
		select.selectByValue("2");
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, page_number_drop_down, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	public double moveMatrixGrid(WebDriver driver, HashMap<String, String> param, String SID, ExtentTest test) throws InterruptedException {
		
		String testcaseName = param.get("TestCaseName");
		Boolean isMatrixGridFound = false;
		String qtitle = null;
		List<WebElement> questions = null;
		long totalQuestions = (Long) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion.length;", test);
		int totalUniqueQuestions = Integer.parseInt((String) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion[" +(totalQuestions-1) +"].uniqueqno;", test));
		
		for(int i=0; i<totalUniqueQuestions; i++) {
			questions = getWebElements(driver, testcaseName, question_title, test);
			try {
				qtitle = questions.get(i).getAttribute("qtitle");
			}catch (IndexOutOfBoundsException e) {
				executeScript(driver, testcaseName, "return window.scrollTo(0, document.body.scrollHeight);", test);
				waitForJStoLoad(driver, 30);
				questions = getWebElements(driver, testcaseName, question_title, test);
				qtitle = questions.get(i).getAttribute("qtitle");
			}
			scrollIntoCenter(driver, testcaseName, questions.get(i), "Question : " + questions.get(i).getAttribute("qtitle"), test);
			
			if(questions.get(i).getAttribute("bind-html-compile").contains("matrix")) {
				scrollIntoCenter(driver, testcaseName, questions.get(i), "Question : " + qtitle, test);
				hoverAction(driver, testcaseName, questions.get(i), "Question : " + qtitle, test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_more_options, test);
				click(driver, testcaseName, move_question, test);
				String moveTo = getWebElements(driver, testcaseName, move_question_options, test).get(0)
						.getAttribute("innerHTML");

				start = System.currentTimeMillis();
				click(driver, testcaseName, getWebElements(driver, testcaseName, move_question_options, test).get(0),
						"First options in Move side menu", test);
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				test.log(Status.INFO, "Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				Add_Log.info("Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				Reporter.log("Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				
				isMatrixGridFound = true;
				break;
			} 
			Thread.sleep(1000);
		}
		
		if (isMatrixGridFound == false) {
			test.log(Status.INFO, "Matrix grid question is not found in survey SID : " + SID);
			Add_Log.info("Matrix grid question is not found in survey SID : " + SID);
			Reporter.log("Matrix grid question is not found in survey SID : " + SID);	
			TestResultStatus.failureReason.add(testcaseName + "| Matrix grid question is not found in survey SID : " + SID);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	public void copySurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
//		Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
//		For new dashboard changes
		if (isShowNewAllProjectDashBoard) {		
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("Survey Title"), test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"), param.get("Survey Title"), 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_copy_icon, 10, 100, test);
			click(driver, testcaseName, IHomePage.new_copy_icon, test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.new_copy_drop_down, test);
			click(driver, testcaseName, IHomePage.new_copy_in_same_acc, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 30, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitForJStoLoad(driver, 60);
			
			//Rename survey title of Copied Survey
			waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("Survey Title"), test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"), param.get("Survey Title"), 60, 100, test);
			click(driver, testcaseName, getWebElements(driver, testcaseName, IHomePage.new_survey_title, test).get(0), "Survey Title", test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.new_edit_survey_title, test);
			clearText(driver, testcaseName, IHomePage.new_edit_survey_title, test);
			Thread.sleep(1000);
			
			//Save Survey title Copied survey
			param.put("copiedSurveyTitle", testcaseName +" -" + DateFormatUtils.format(new Date(), "dd-MMM-yyyy HH:mm:ss"));
			setText(driver, testcaseName, IHomePage.new_edit_survey_title, param.get("copiedSurveyTitle") , test);
			click(driver, testcaseName, IHomePage.new_save_survey_title, test);
			waitforElemNotVisible(driver, testcaseName, 30, IHomePage.small_loader, test);
			waitForJStoLoad(driver, 30);
			
//			waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
//			clearText(driver, testcaseName, IHomePage.new_search_bar, test);
//			Thread.sleep(1000);
//			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("copiedSurveyTitle"), test);
//			driver.switchTo().defaultContent();	
//			waitForLoad(driver, testcaseName, 120, test);
//			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
//			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
//			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("copiedSurveyTitle") +"\"]"), param.get("copiedSurveyTitle"), 60, 100, test);
			//Save Survey title and SID of Copied survey which always appears at first position
//			param.put("copiedSurveyTitle", driver.findElement(By.xpath(IHomePage.NEW_FIRST_ROW)).getAttribute("stitle"));
//			param.put("copiedSurveySID", driver.findElement(By.xpath(IHomePage.NEW_FIRST_ROW)).getAttribute("hoversurveyno"));
			
		
			test.log(Status.INFO, "Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle") 
			+ " .");
			Add_Log.info("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+ " .");
			Reporter.log("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+ " .");
		}
		// For old dashboard
		else {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, param.get("Survey Title"), test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+param.get("SID")+"']"));
			new Actions(driver).moveToElement(survey).perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.copy_icon, 10, 100, test);
			
			click(driver, testcaseName, IHomePage.copy_icon, test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.copy_drop_down, test);
			click(driver, testcaseName, IHomePage.copy_in_same_acc, test);
			waitForLoad(driver, testcaseName, 30, test);
			
			//Rename survey title of Copied Survey
			click(driver, testcaseName, getWebElements(driver, testcaseName, IHomePage.survey_title, test).get(0), "Survey Title", test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.edit_survey_title, test);
			clearText(driver, testcaseName, IHomePage.edit_survey_title, test);
			Thread.sleep(1000);
			
			setText(driver, testcaseName, IHomePage.edit_survey_title, testcaseName +" -" + DateFormatUtils.format(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss") , test);
			click(driver, testcaseName, IHomePage.save_survey_title, test);
			waitforElemNotVisible(driver, testcaseName, 30, IHomePage.small_loader, test);
			waitForJStoLoad(driver, 30);
			
			//Save Survey title and SID of Copied survey which always appears at first position
			param.put("copiedSurveyTitle", driver.findElement(By.xpath(IHomePage.FIRST_ROW)).getAttribute("stitle"));
			param.put("copiedSurveySID", driver.findElement(By.xpath(IHomePage.FIRST_ROW)).getAttribute("sid"));
			
			test.log(Status.INFO, "Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle") 
			+" and " +param.get("copiedSurveySID") + " respectively.");
			Add_Log.info("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+" and " +param.get("copiedSurveySID") + " respectively.");
			Reporter.log("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+" and " +param.get("copiedSurveySID") + " respectively.");
		}
		
		
	}
	
	
}
