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
	
		

	
}
