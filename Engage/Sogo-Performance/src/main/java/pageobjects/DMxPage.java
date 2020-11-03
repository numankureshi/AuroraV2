package pageobjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import property.IDMxPage;
import property.IHomePage;
import utility.SeleniumUtils;

public class DMxPage extends SeleniumUtils implements IDMxPage{
	public double finish, start;
	public double end;
	
	public double goToDistributePage(WebDriver driver, HashMap<String, String> param, String username, String password, String URL, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new StaticPage().login(driver, param, username, password, URL, test);
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
		setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
		click(driver, testcaseName, IHomePage.search_icon, test);
		WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
		new Actions(driver).moveToElement(survey).perform();
		waitForElementToBeVisible(driver, testcaseName, IHomePage.publish_icon, 10, 100, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, IHomePage.publish_icon, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, quick_send, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}

}
