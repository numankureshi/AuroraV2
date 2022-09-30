package pageobjects.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import property.IDMXPage;
import property.ISMXPage;
import property.utilities.IMasterLogPage;
import utility.SeleniumUtils;

public class MasterLogPage extends SeleniumUtils implements IDMXPage, ISMXPage, IMasterLogPage {	
	
	public void openMasterLog(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");	
		waitforElemPresent(driver, testcaseName, 30, utilities, test);
		click(driver, testcaseName, utilities, test);
		waitforElemPresent(driver, testcaseName, 30, master_log, test);
		click(driver, testcaseName, master_log, test);
	}
	
	public void exportAll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		DeletePreviousDownloadedFile(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, export_all, test);
		click(driver, testcaseName, export_all, test);
		Thread.sleep(2000);
		ValidateDownloadedFile(driver, param, test);
	}
	
	public void search(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String searchfortext = param.get("searchfor");
		waitforElemPresent(driver, testcaseName, 30, search_box, test);
		setText(driver, testcaseName, search_box, param.get("searchfor"), test);
		WebElement searchbox = driver.findElement(By.xpath("//input[@class='searchText']"));
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		 List<WebElement> searchboxresult = driver.findElements(By.xpath("//td[contains(text(),'"+ param.get("searchfor") +"')]"));
	        //System.out.println(searchboxresult.size());
	        for (int i = 0; i < searchboxresult.size(); i++)
	        {
	            //System.out.println(LIST.get(i).getText());
	            if (searchboxresult.get(i).getText().contains("searchfortext"))
	            {
	            	searchboxresult.get(i).click();
	                break;
	            }
	        }
	    System.out.println("Found " + searchboxresult.size() + " Email Address/Mobile Number having keyword : " + searchfortext);
	    
	    if (searchboxresult.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
			Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}
	    
		Thread.sleep(2000);
	}
	
	public void subscription_Status_Unsubscribe(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String search_for_subscription_status = param.get("subscription_status");
		waitforElemPresent(driver, testcaseName, 30, subscription_status, test);
		click(driver, testcaseName, subscription_status, test);
		waitforElemPresent(driver, testcaseName, 30, unsubscribed_status, test);
		click(driver, testcaseName, unsubscribed_status, test);
		waitforElemPresent(driver, testcaseName, 30, masterlog_status_done, test);
		click(driver, testcaseName, masterlog_status_done, test);
		
		List<WebElement> subscription_status_result = driver.findElements(By.xpath("//td[contains(text(),'"+ param.get("subscription_status") +"')]"));
        for (int i = 0; i < subscription_status_result.size(); i++)
        {
            //System.out.println(LIST.get(i).getText());
            if (subscription_status_result.get(i).getText().contains("subscription_status"))
            {
            	subscription_status_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + subscription_status_result.size() + " Email Address/Mobile Number having subscription status : " + search_for_subscription_status);
        
        if (subscription_status_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
            waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
    		click(driver, testcaseName, export_filtered_record, test);
    		Thread.sleep(2000);
    		ValidateDownloadedFile(driver, param, test);
		}
        
	}
	
	public void subscription_Status_Ok(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String search_for_subscription_status = param.get("subscription_status");
		waitforElemPresent(driver, testcaseName, 30, subscription_status, test);
		click(driver, testcaseName, subscription_status, test);
		waitforElemPresent(driver, testcaseName, 30, ok_status, test);
		click(driver, testcaseName, ok_status, test);
		waitforElemPresent(driver, testcaseName, 30, masterlog_status_done, test);
		click(driver, testcaseName, masterlog_status_done, test);
		
		List<WebElement> subscription_status_result = driver.findElements(By.xpath("//td[contains(text(),'"+ param.get("subscription_status") +"')]"));
        for (int i = 0; i < subscription_status_result.size(); i++)
        {
            //System.out.println(LIST.get(i).getText());
            if (subscription_status_result.get(i).getText().contains("subscription_status"))
            {
            	subscription_status_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + subscription_status_result.size() + " Email Address/Mobile Number having subscription status : " + search_for_subscription_status);
		
        if (subscription_status_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}
        
	}
	
	public void learnMore(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, tool_tip_master_log, test);
		WebElement hower_tool_tip = driver.findElement(By.xpath("//div[@class='tooltip_container tooltip_help tooltip_white']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower_tool_tip).perform();	
		waitforElemPresent(driver, testcaseName, 30, learn_more, test);
		click(driver, testcaseName, learn_more, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_userguide_master_log ,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Help panel Iframe']")));
		String actualText = driver.findElement(By.xpath("//h1[(contains (text(),'Master Log'))]")).getAttribute("innerHTML");
		String expectedText = "Master Log";
		Assert.assertEquals(actualText.trim(), expectedText, "Alert message is not matching with expected alert");
		
	}
	
	public void newEntryMasterLog(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		Thread.sleep(2000);
		CreateNewSurveyForMasterLog(driver,param,test);
		Thread.sleep(2000);
		String newSurveyName = driver.findElement(By.xpath("//span[@class='hd-survey-title-name']")).getAttribute("innerHTML");
		System.out.println(newSurveyName);
		waitforElemPresent(driver, testcaseName, 30, distribute, test);
		click(driver, testcaseName, distribute, test);
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		click(driver, testcaseName, single_use_link_button, test);
		
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '"+ param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::div[@class='middle-content'])[1]"), param.get("emailtemplate"), test);
		Thread.sleep(2000);	
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::div[@class='middle-content'])[1]"))).build().perform();			
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//div[@id='"+ param.get("SelectTemplate") +"']"), param.get("SelectTemplate"), test);
		click(driver, testcaseName, By.xpath("//div[@id='"+ param.get("SelectTemplate") +"']"), param.get("SelectTemplate"), test);	
		
		waitforElemPresent(driver, testcaseName, 30, text_area_for_invitation, test);
		click(driver, testcaseName, text_area_for_invitation, test);
		waitforElemPresent(driver, testcaseName, 30, text_area_for_invitation, test);
		driver.findElement(By.xpath("//input[@name='txtSendFromType']")).sendKeys(param.get("Email"));
		waitforElemPresent(driver, testcaseName, 30, button_continue, test);
		click(driver, testcaseName, button_continue, test);
		waitforElemPresent(driver, testcaseName, 30, send_now, test);
		click(driver, testcaseName, send_now, test);
		waitforElemPresent(driver, testcaseName, 30, utilitiesfrominside, test);
		click(driver, testcaseName, utilitiesfrominside, test);
		waitforElemPresent(driver, testcaseName, 30, master_log, test);
		click(driver, testcaseName, master_log, test);		
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//td[contains(text(),'"+ param.get("Email") +"')]"), param.get("Email"), test);
		click(driver, testcaseName, By.xpath("//td[contains(text(),'"+ param.get("Email") +"')]"), param.get("Email"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//td[(contains (text(),'"+newSurveyName.trim()+"'))]"),newSurveyName.trim(), test);
	}
	
	public void filter_Keyword_A(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_B(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_b, test);
		click(driver, testcaseName, option_value_b, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_C(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_c, test);
		click(driver, testcaseName, option_value_c, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_D(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_d, test);
		click(driver, testcaseName, option_value_d, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_E(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_e, test);
		click(driver, testcaseName, option_value_e, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_F(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_f, test);
		click(driver, testcaseName, option_value_f, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_G(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_g, test);
		click(driver, testcaseName, option_value_g, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_H(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_h, test);
		click(driver, testcaseName, option_value_h, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_I(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_i, test);
		click(driver, testcaseName, option_value_i, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_J(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_j, test);
		click(driver, testcaseName, option_value_j, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_K(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_k, test);
		click(driver, testcaseName, option_value_k, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_L(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_l, test);
		click(driver, testcaseName, option_value_l, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_M(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_m, test);
		click(driver, testcaseName, option_value_m, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_N(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_n, test);
		click(driver, testcaseName, option_value_n, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_O(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_o, test);
		click(driver, testcaseName, option_value_o, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_P(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_p, test);
		click(driver, testcaseName, option_value_p, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_Q(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_q, test);
		click(driver, testcaseName, option_value_q, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_R(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_r, test);
		click(driver, testcaseName, option_value_r, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_S(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_s, test);
		click(driver, testcaseName, option_value_s, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_T(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_t, test);
		click(driver, testcaseName, option_value_t, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_U(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_u, test);
		click(driver, testcaseName, option_value_u, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_V(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_v, test);
		click(driver, testcaseName, option_value_v, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_W(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_w, test);
		click(driver, testcaseName, option_value_w, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_X(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_x, test);
		click(driver, testcaseName, option_value_x, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_Y(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_y, test);
		click(driver, testcaseName, option_value_y, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_Z(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_z, test);
		click(driver, testcaseName, option_value_z, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_0(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_0, test);
		click(driver, testcaseName, option_value_0, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_1(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_1, test);
		click(driver, testcaseName, option_value_1, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_2, test);
		click(driver, testcaseName, option_value_2, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_3(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_3, test);
		click(driver, testcaseName, option_value_3, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_4(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_4, test);
		click(driver, testcaseName, option_value_4, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_5(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_5, test);
		click(driver, testcaseName, option_value_5, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_6(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_6, test);
		click(driver, testcaseName, option_value_6, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_7(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_7, test);
		click(driver, testcaseName, option_value_7, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_8(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_8, test);
		click(driver, testcaseName, option_value_8, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	public void filter_Keyword_9(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String email_mobile_filter = param.get("aplhabet_number");
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber, test);
		click(driver, testcaseName, emailaddress_mobilenumber, test);
		waitforElemPresent(driver, testcaseName, 30, choose_alphabet_number, test);
		click(driver, testcaseName, choose_alphabet_number, test);
		waitforElemPresent(driver, testcaseName, 30, option_value_9, test);
		click(driver, testcaseName, option_value_9, test);
		waitforElemPresent(driver, testcaseName, 30, emailaddress_mobilenumber_filter_done, test);
		click(driver, testcaseName, emailaddress_mobilenumber_filter_done, test);
		
		List<WebElement> Email_Mobile_result = driver.findElements(By.xpath("//table[@class='dashboard']//td[contains(text(),'"+ param.get("aplhabet_number") +"')]"));
        for (int i = 0; i < Email_Mobile_result.size(); i++)
        {
            if (Email_Mobile_result.get(i).getText().contains("subscription_status"))
            {
            	Email_Mobile_result.get(i).click();
                break;
            }
        }
        System.out.println("Found " + Email_Mobile_result.size() + " Email Address/Mobile Number starting with keyword  : " + email_mobile_filter);
		
        if (Email_Mobile_result.size() == 0) {
        	System.out.println("No Record Found to Export");   	
		}else {
			DeletePreviousDownloadedFile(driver, param, test);
	        waitforElemPresent(driver, testcaseName, 30, export_filtered_record, test);
			click(driver, testcaseName, export_filtered_record, test);
	        Thread.sleep(2000);
			ValidateDownloadedFile(driver, param, test);
		}	
	}
	
	public void pagationMasterLog(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");	
		
		List<WebElement> numberOfPages = driver.findElements(By.xpath("//select[@class='bigselect']/option"));
		System.out.println("Number of pages:" +numberOfPages.size());
		 for (int i=1; i<numberOfPages.size();i++){
		 int last_Page = numberOfPages.size()-1;
		 
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@class='bigselect']/option["+i+"]"),"page_dropdown", test);
		click(driver, testcaseName,  By.xpath("//select[@class='bigselect']/option["+i+"]"),"page_dropdown", test);
		
		List<WebElement> numberOfEmail_Mobile = driver.findElements(By.xpath("//td[@style='cursor: pointer;word-break: break-all;']"));
		System.out.println("Number of Email/Mobile in this page:" +numberOfEmail_Mobile.size());
		
		if (i!=last_Page) {
			
			if(numberOfEmail_Mobile.size() == 100) {
	            reportPass("Entries are equally to page size", test);
	        }
	        else {
	            reportFail(testcaseName,"Entries are not equally to page size" , test);
	        }
		} 
		
		else {
			if(numberOfEmail_Mobile.size() <= 100) {
	            reportPass("Entries are equally to last page size", test);
	        }
	        else {
	            reportFail(testcaseName,"Entries are not equally to last page size" , test);
	        }
		}
		
		 }
	}
	
	public void CompareWithCurrentTime(WebDriver driver, HashMap<String, String> param, ExtentTest test, java.util.Date currentTime) throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");
		boolean isFileUploaded = false;

		String DateUploadedInString = driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[1]/div[7]/div[1]/div[5]/div[2]/table[1]/tbody[1]/tr[77]/td[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]")).getAttribute("innerHTML");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date DateUploaded=new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(DateUploadedInString);
		System.out.println(dateFormat.format(DateUploaded.getTime()));
		
		if(DateUploaded.equals(currentTime)||DateUploaded.after(currentTime)){
				isFileUploaded=true;
				System.out.println(isFileUploaded);
				System.out.println("Date/Time Validation Passed");
		}
		else{
				System.out.println("Date/Time Validation Failed");
		}
		
	}
	
	public void DeletePreviousDownloadedFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
	     	throws InterruptedException {
	String testcaseName = param.get("TestCaseName");
	String fileName = param.get("secondarylanguage");
	System.out.println("Searching for "  +  fileName);  
	 String dirPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles"); 
	 String dirPath1 = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\" + fileName); 
     File dir1 = new File(dirPath1);
     File dir = new File(dirPath);
     File[] files = dir.listFiles();
     for (File listFile : files) {
             if (listFile.getName().contains(fileName)) {      
            	 dir1.delete();
                 System.out.println(fileName + " is deleted successfully");
                 break;
             }
	}
	}
	
	public void ValidateDownloadedFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
	String testcaseName = param.get("TestCaseName");
	String fileName = param.get("secondarylanguage");
	System.out.println("Searching for " +  fileName);
	boolean flag = false;
     
     String dirPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles"); 
     File dir = new File(dirPath);
     File[] files = dir.listFiles();
     if (files.length == 0 || files == null) {
         System.out.println("The directory is empty");
         flag = false;
     } else {
         for (File listFile : files) {
             if (listFile.getName().contains(fileName)) {
                 System.out.println(fileName + " is present");
                 flag = true;
                 break;         
             }        
         }
         System.out.println(flag);
         if(flag == true)
         {
             reportPass("Validation of Downloaded File is passed", test);
         }
         else
         {
             reportFail(testcaseName,"Validation of Downloaded File" , test);
         }
     }
	}
	
	public void CreateNewSurveyForMasterLog(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);		
		waitforElemPresent(driver, testcaseName, 30, textbox, test);
		WebElement tb = driver.findElement(By.xpath("//div[@id='dvtb']"));
		Actions action0 = new Actions(driver);
		action0.doubleClick(tb).perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@title='Rich Text Editor, QuestionText']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, QuestionText']")));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']"),testcaseName,test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(param.get("TextBox"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, save_question, test);
		click(driver, testcaseName, save_question, test);
		
	}
	
	public void selectCreateProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		click(driver, testcaseName, create_project, test);
		waitForLoad(driver, testcaseName, 30, test);
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
	
}