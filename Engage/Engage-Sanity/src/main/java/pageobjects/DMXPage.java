package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.IDMXPage;
import property.ISMXPage;
import property.ISurveyPage;
import utility.SeleniumUtils;

public class DMXPage extends SeleniumUtils implements IDMXPage, ISMXPage {
	

	public void selectDistributeProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		String URL = driver.getCurrentUrl();
		URL = URL.replace("zHome/home.aspx", "zDM/PublishSurveyOptions.aspx?type=0&test=0&survey_no="+ param.get("surveyid") +"");
		driver.get(URL);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, publish_button, test);
	}
	

	public void publishSingleUseLink(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		click(driver, testcaseName, single_use_link_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		selectEmailTemplate(driver, param, test);
	}
	
	public void selectEmailTemplate(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 30, select_email_message, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]"), param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]/following::div[@class='middle-content'])[1]"), param.get("emailtemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]/following::div[@class='middle-content'])[1]"))).build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, edit_button, test);
		click(driver, testcaseName, edit_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[text()='"+ param.get("emailtemplate") +"']"), "Edit template: "+param.get("emailtemplate"), test);
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath(EDIT_SUBJECT_HOVER))).build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, edit_subject_icon, test);
		click(driver, testcaseName, edit_subject_icon, test);
		Thread.sleep(1000);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		setText(driver, testcaseName, edit_subject, "DP Email Template - "+strDate, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, edit_subject_save, test);
		click(driver, testcaseName, edit_subject_save, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, save_overwrite_button, test);
		click(driver, testcaseName, save_overwrite_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, done_button, test);
		click(driver, testcaseName, done_button, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, source_email, test);
	}
	

}
