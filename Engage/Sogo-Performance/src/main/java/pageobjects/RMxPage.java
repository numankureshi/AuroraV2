package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IRMxPage;
import utility.SeleniumUtils;

public class RMxPage extends SeleniumUtils implements IRMxPage{
	

	public double finish, start;
	public double end;
	
	public double goToReportPage(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new DMxPage().goToDistributePage(driver, param, username, password, URL, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, report_tab, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_report, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	
	public double loadOMNIReport(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, username, password, URL, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, omni_report, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_modify_report, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}


}
