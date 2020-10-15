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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.ISMXPage;
import property.ISurveyPage;
import utility.SeleniumUtils;

public class SMXPage extends SeleniumUtils implements ISMXPage {
	
	public void createSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		createNewSurvey(driver, param, test);
		enterDescription(driver, param, test);
		enterNetPromoter(driver, param, test);
		enterTextBox(driver, param, test);
	}

	public void selectCreateProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		click(driver, testcaseName, create_project, test);
		waitforElemPresent(driver, testcaseName, 30, begin_label, test);
	}
	
	public void selectBlankSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool.aspx')]"), "Iframe", test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool.aspx')]")));
		waitforElemPresent(driver, testcaseName, 30, survey_button, test);
		click(driver, testcaseName, survey_button, test);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button, test);
		click(driver, testcaseName, continue_button, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, create_survey_label, test);
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
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);
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
		Select select = new Select(driver.findElement(By.xpath(PRIMARY_LANGUAGE_DD)));
		select.selectByVisibleText(param.get("primarylanguage"));
		
	}
	
	public void selectSecondaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, secondary_language_switch, test);
		click(driver, testcaseName, secondary_language_switch, test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd_search, test);
		setText(driver, testcaseName, secondary_lanugage_dd_search, param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]/preceding-sibling::input"), param.get("secondarylanguage"), test);
		click(driver, testcaseName, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]/preceding-sibling::input"), param.get("secondarylanguage"), test);
		Select select = new Select(driver.findElement(By.xpath(PRIMARY_LANGUAGE_DD)));
		select.selectByVisibleText(param.get("primarylanguage"));
		
	}
	
	public void enterDescription(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, description_button, test);
		doubleClick(driver, testcaseName, description_button, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("description"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("description") +"']"), "Description Added "+ param.get("description"), test);
	}
	
	public void enterNetPromoter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, net_promoter_score_button, test);
		doubleClick(driver, testcaseName, net_promoter_score_button, test);
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		String netPromoterLabel = getText(driver, testcaseName, description_text, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']"), "Net Promoter Label Added "+ netPromoterLabel, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']/parent::div/following-sibling::div//div[@class='clearfix slider-div']"), "Net Promoter Label Added "+ netPromoterLabel, test);
	}	

	public void enterTextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, text_box_button, test);
		doubleClick(driver, testcaseName, text_box_button, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']"), "Text Box Label Added "+ param.get("textbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']/parent::div/following-sibling::div//input"), "Text Box Added "+ param.get("textbox"), test);
	}
}
