package pageobjects.RMX;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import property.IRMXPage;
import property.RMX.ISavedReportPage;
import utility.SeleniumUtils;

public class SavedReportPage extends SeleniumUtils implements ISavedReportPage, IRMXPage {
	
	/**
	 * Check if Saved report option present inside More option or not
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public boolean isSaveReportInGroup(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		boolean isSaveReportInGroup = driver.findElement(By.xpath(MORE)).isDisplayed();
		return isSaveReportInGroup ;
	}
	
	
	/**
	 * Go to Saved reports page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public SavedReportPage goToSavedReportPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		if(isSaveReportInGroup(driver, param, test)) {
			click(driver, testcaseName, more, test);
		}
		
		waitforElemPresent(driver, testcaseName, 30, saved_reports, test);
		click(driver, testcaseName, saved_reports, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, saved_report_page_header, test);
		return this;
	}
	
	
	/**
	 * Get saved report details by passing index number from Saved reports page
	 * @param driver
	 * @param param
	 * @param index
	 * @param test
	 * @return
	 */
	public HashMap<String, String> getSavedReportDetails(WebDriver driver, HashMap<String, String> param, int index, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		HashMap<String, String> savedReportDetails = new HashMap<>();
		
		savedReportDetails.put("Report Title", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[2]")).getAttribute("innerHTML").strip());
		savedReportDetails.put("Project Type", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[3]")).getAttribute("innerHTML").strip());
		savedReportDetails.put("Report Type", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[4]")).getAttribute("innerHTML").strip());
		savedReportDetails.put("Date Modified", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[5]")).getAttribute("innerHTML").strip());
		savedReportDetails.put("Modified By", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[6]")).getAttribute("innerHTML").strip());
		
		return savedReportDetails;
	}
	
	public SavedReportPage validateSavedReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String actualReportTitle = getSavedReportDetails(driver, param, 1, test).get("Report Title");
		String expectedReportTitle = param.get("reportName");
		Assert.assertEquals(actualReportTitle, expectedReportTitle, "Saved report not found.");
		reportPass("Validated saved report title " +actualReportTitle +" on Saved report page", test);
		return this;
	}

}
