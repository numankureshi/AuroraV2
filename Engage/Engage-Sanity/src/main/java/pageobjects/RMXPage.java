package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IRMXPage;
import utility.SeleniumUtils;

public class RMXPage extends SeleniumUtils implements IRMXPage{
	

	public double finish, start;
	public double end;
	
	public double goToReportPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new DMXPage().goToDistributePage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, report_tab, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_report, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	
	public double loadOMNIReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, omni_report, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_modify_report, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public void loadDARReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		
		
		click(driver, testcaseName, special_reports, test);
		click(driver, testcaseName, dimensional_analysis, test);
		waitforElemPresent(driver, testcaseName, 30, select_project_1_dd, test);
		click(driver, testcaseName, dar_1dd, test);
		scrollIntoCenter(driver, testcaseName, select_folder1_dd, test);
		click(driver, testcaseName, select_folder1_dd, test);
		click(driver, testcaseName, select_project_1_dd, test);
		click(driver, testcaseName, dar_2dd, test);
		scrollIntoCenter(driver, testcaseName, select_folder2_dd, test);
		click(driver, testcaseName, select_folder2_dd, test);
		click(driver, testcaseName, select_project2_dd, test);
		click(driver, testcaseName, generate_report, test);
		click(driver, testcaseName, select_folder2_dd, test);
		waitforElemPresent(driver, testcaseName, 30, add_parent1, test);
		click(driver, testcaseName, add_parent1, test);
		click(driver, testcaseName, add_star1, test);
		click(driver, testcaseName, add_parent2, test);
		click(driver, testcaseName, add_star2, test);
		click(driver, testcaseName, add_parent3, test);
		click(driver, testcaseName, add_star3, test);
		click(driver, testcaseName, add_parent4, test);
		click(driver, testcaseName, add_star4, test);
		click(driver, testcaseName, add_parent5, test);
		click(driver, testcaseName, add_star5, test);
		click(driver, testcaseName, add_parent6, test);
		click(driver, testcaseName, add_star6, test);
		click(driver, testcaseName, add_parent7, test);
		click(driver, testcaseName, add_star7, test);
		click(driver, testcaseName, add_parent8, test);
		click(driver, testcaseName, add_star8, test);
		click(driver, testcaseName, add_parent9, test);
		click(driver, testcaseName, add_star9, test);
		click(driver, testcaseName, add_parent10, test);
		click(driver, testcaseName, add_star10, test);
		click(driver, testcaseName, add_parent11, test);
		click(driver, testcaseName, add_star11, test);
		click(driver, testcaseName, report_canvas, test);
		waitforElemPresent(driver, testcaseName, 30, canvas_title, test);
		click(driver, testcaseName, canvas_title, test);
		click(driver, testcaseName, canvas_description, test);
		click(driver, testcaseName, segment, test);
		waitforElemPresent(driver, testcaseName, 30, segment_surveydd, test);
		click(driver, testcaseName, segment_surveydd, test);
		click(driver, testcaseName, segment_questiondd, test);
		click(driver, testcaseName, segment_answercb, test);
		click(driver, testcaseName, email_report, test);
		waitforElemPresent(driver, testcaseName, 30, segment, test);
		
		
		
		
	}
		
		
		
		
	}
		


