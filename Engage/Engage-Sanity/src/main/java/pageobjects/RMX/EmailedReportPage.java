package pageobjects.RMX;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import property.IRMXPage;
import property.RMX.IEmailedReportPage;
import utility.SeleniumUtils;
import utility.SuiteUtility;

public class EmailedReportPage extends SeleniumUtils implements IEmailedReportPage, IRMXPage{
	
	/**
	 * Check if Emailed report option present inside More option or not
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public boolean isEmailReportInGroup(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		boolean isEmailReportInGroup = driver.findElement(By.xpath(MORE)).isDisplayed();
		return isEmailReportInGroup ;
	}
	
	
	/**
	 * Go to Emailed reports page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public EmailedReportPage goToEmailedReportPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		if(isEmailReportInGroup(driver, param, test)) {
			click(driver, testcaseName, more, test);
		}
		
		waitforElemPresent(driver, testcaseName, 30, email_reports, test);
		click(driver, testcaseName, email_reports, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, emailed_report_page_header, test);
		return this;
	}
	
	
	/**
	 * Get emailed report details by passing index number from Emailed reports page
	 * @param driver
	 * @param param
	 * @param index
	 * @param test
	 * @return
	 */
	public HashMap<String, String> getEmailedReportDetails(WebDriver driver, HashMap<String, String> param, int index, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		HashMap<String, String> emailedReportDetails = new HashMap<>();
		
		emailedReportDetails.put("Email Address", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[3]")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Report Type", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[4]")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Report Title", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[5]/a")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Sent/Schedule", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[6]/span")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("No of times viewed", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[7]")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Last Viewed", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[8]")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Expiry Date", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[9]")).getAttribute("innerHTML").strip());
		emailedReportDetails.put("Emailed By", 
				driver.findElement(By.xpath("((//table[@id='tblMain']/tbody/tr[contains(@onmouseout,'rowSM')])[" + index +"]/td)[10]")).getAttribute("innerHTML").strip());
		
		return emailedReportDetails;
	}
	
	
	public EmailedReportPage validateEmailedReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String[] emailTo = param.get("emailto").split(",");
		Collections.reverse(Arrays.asList(emailTo));
		for(int i=0; i<emailTo.length; i++) {
			HashMap<String, String> emailReportDetails = getEmailedReportDetails(driver, param, i+1, test);
			
			String actualEmailAddress = emailReportDetails.get("Email Address");
			String expectedEmailAddress = emailTo[i];
			String actualReportTitle = emailReportDetails.get("Report Title");
			String expectedReportTitle = param.get("reportNameTitle");
			
			Assert.assertEquals(actualEmailAddress, expectedEmailAddress, "Emailed report for given email address not found.");
			Assert.assertEquals(actualReportTitle, expectedReportTitle, "Emailed report for given report title not found.");
			
			reportPass("Validated emailed report for email address " +actualEmailAddress + " with Report title " + actualReportTitle + " on Emailed report page", test);
		}
		return this;
	}
	
	public EmailedReportPage isEmailedReceived(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		Date emailSentTime = null;
		try {
			emailSentTime = formatter.parse(param.get("emailSentTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HashMap<String, String> emailData = SuiteUtility.waitForEmailToBeReceived(param, param.get("emailhost"), param.get("emailto"), param.get("emailPassword"), param.get("emailReportSubject"), 
				emailSentTime, test);
		
		// Check email report URL in message content
		Pattern p = Pattern.compile("href=\"(.*?)\"");
		Matcher m = p.matcher(emailData.get("Message Content"));
		if(m.find()) {
			System.out.println(m.group(0));		
			if(m.group(1).contains(SuiteUtility.getHost(driver.getCurrentUrl())) && m.group(1).contains("/zRMx/ViewSharedReport.aspx")) {
				param.put("emailedReportUrl", m.group(1));
				reportPass("Report Url is present in email content. Report url : " + param.get("emailedReportUrl"), test);
			}	
		}else {
			reportFail(testcaseName, "Email report url is not found", test);
		}
		
		
		// Check Branding logo URL in message content
		p = Pattern.compile("src=\"(.*?)\"");
		m = p.matcher(emailData.get("Message Content"));
		
		if(m.find()) {
			System.out.println(m.group(0));
			param.put("brandingUrl", m.group(1));
		}else {
			reportFail(testcaseName, "Branding url is not found", test);
		}
		
		// Check if branding logo is broken or not by validating the status code
		if (SuiteUtility.checkStatusCode(param.get("brandingUrl")) == 200) {

			// Compare branding logo with expected result
			param.put("brandingLogoPath", param.get("downloadFilePath") + "brandingLogo_" + SuiteUtility.randomNumberGenerator(10000) + ".jpg");
			SuiteUtility.saveFile(param.get("brandingUrl"), param.get("brandingLogoPath"));
			String diffImagePath = param.get("downloadFilePath") + "brandingLogo_diff_" + SuiteUtility.randomNumberGenerator(10000) + ".jpg";
			boolean isImageMatch = driver.getTitle().contains("Sogolytics")
					? SuiteUtility.compareImages(param.get("brandingLogoPath"),
							System.getProperty("user.dir") + "\\src\\main\\resources\\productImages\\" + "poweredby.jpg", diffImagePath)
					: SuiteUtility.compareImages(param.get("brandingLogoPath"),
							System.getProperty("user.dir") + "\\src\\main\\resources\\productImages\\" + "k_logo.gif", diffImagePath);
			if (isImageMatch) {
				reportPass("Branding logo is verified with expected result", test);
			} else {
				reportFail(testcaseName,
						"Branding logo is not matching with expected result. Check difference at " + diffImagePath,
						test);
			}

		} else {
			reportFail(testcaseName, "Branding image is not found", test);
		}
		
		return this;	
	}
	

}
