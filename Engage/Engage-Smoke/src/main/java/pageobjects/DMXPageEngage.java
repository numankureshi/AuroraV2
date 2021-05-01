package pageobjects;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.IDMXPage;
import property.IHomePage;
import property.ISMXPage;
import property.ISurveyPage;
import utility.SeleniumUtils;
import utility.WebPageElements;

public class DMXPageEngage extends SeleniumUtils implements IDMXPage, ISMXPage {
	public double finish, start;
	public double end;
	DMXPage dmxPage = new DMXPage();

	
	public void mailMerge(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String mailmergedd[] = param.get("mailmergedd").split(";");
		String mailmergetxt[] = param.get("mailmergetxt").split(";");
		waitforElemPresent(driver, testcaseName, 30, mail_merge, test);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd1, test);
		Select select = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD1)));
		select.selectByVisibleText(mailmergedd[0]);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd2, test);
		Select select2 = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD2)));
		select2.selectByVisibleText(mailmergedd[1]);
		Thread.sleep(1000);
		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd3, test);
//		Select select3 = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD3)));
//		select3.selectByVisibleText(mailmergedd[2]);
//		Thread.sleep(1000);
		
		
		if(getWebElement(driver, testcaseName, mail_merge_txt1, test).isEnabled()) {
			waitforElemPresent(driver, testcaseName, 30, mail_merge_txt1, test);
			setText(driver, testcaseName, mail_merge_txt1, mailmergetxt[0], test);
		}
		Thread.sleep(1000);
		
		
		if(getWebElement(driver, testcaseName, mail_merge_txt2, test).isEnabled()) {
			waitforElemPresent(driver, testcaseName, 30, mail_merge_txt2, test);
			setText(driver, testcaseName, mail_merge_txt2, mailmergetxt[1], test);
		}
		
		Thread.sleep(1000);
		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt3, test);
//		setText(driver, testcaseName, mail_merge_txt3, mailmergetxt[2], test);
//		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void mailMerge2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String mailmergedd[] = param.get("mailmergedd").split(";");
		String mailmergetxt[] = param.get("mailmergetxt").split(";");
		waitforElemPresent(driver, testcaseName, 30, mail_merge, test);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd1, test);
		Select select = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD1)));
		select.selectByVisibleText(mailmergedd[0]);
		Thread.sleep(1000);
//		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd2, test);
//		Select select2 = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD2)));
//		select2.selectByVisibleText(mailmergedd[1]);
//		Thread.sleep(1000);
		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd3, test);
//		Select select3 = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD3)));
//		select3.selectByVisibleText(mailmergedd[2]);
//		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt1, test);
		setText(driver, testcaseName, mail_merge_txt1, mailmergetxt[0], test);
		Thread.sleep(1000);
		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt2, test);
//		setText(driver, testcaseName, mail_merge_txt2, mailmergetxt[1], test);
//		Thread.sleep(1000);
		
//		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt3, test);
//		setText(driver, testcaseName, mail_merge_txt3, mailmergetxt[2], test);
//		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void publishSingleUseLinkexe(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		dmxPage.selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		click(driver, testcaseName, single_use_link_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		dmxPage.selectEmailTemplate(driver, param, test);
		dmxPage.selectFromAList(driver, param, test);
		try {
			driver.findElement(By.xpath("//input[@value='Continue']")).isDisplayed();
			click(driver, testcaseName, By.xpath("//input[@value='Continue']"), "Continue", test);
			waitForLoad(driver, testcaseName, 30, test);
		} catch (Exception e) {
			// TODO: handle exception
		}
		mailMerge(driver, param, test);
		dmxPage.prePopulation(driver, param, test);
//		dmxPage.reviewData(driver, param, test);
		dmxPage.sendOrScheduleexe(driver, param, test);
	}
	
	public void publishSingleUseLink(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		dmxPage.selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		click(driver, testcaseName, single_use_link_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		dmxPage.selectEmailTemplate(driver, param, test);
		selectFromAList(driver, param, test);
		mailMerge2(driver, param, test);
		dmxPage.prePopulation(driver, param, test);
//		dmxPage.reviewData(driver, param, test);
		dmxPage.sendOrSchedule(driver, param, test);
	}
	
	public void selectFromAList(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, from_a_list, test);
		click(driver, testcaseName, from_a_list, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, select_list, test);
		Select select = new Select(driver.findElement(By.xpath(SELECT_LIST)));
		select.selectByVisibleText(param.get("selectlist"));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 50, By.xpath("//span[contains(text(),'This list includes duplicate email addresses. A single-use link will be generated for each.')]"), "List with duplicate email address", test);
		waitforElemPresent(driver, testcaseName, 30, invite_in_seperate_email, test);
		click(driver, testcaseName, invite_in_seperate_email, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			driver.findElement(By.xpath(PRE_POP_SURVEY_INPUT)).isSelected();
		} catch (Exception e) {
			waitforElemPresent(driver, testcaseName, 30, pre_pop_survey, test);
			click(driver, testcaseName, pre_pop_survey, test);
			waitForLoad(driver, testcaseName, 60, test);
		}
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void prePopulation2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		waitforElemPresent(driver, testcaseName, 60, pre_pop_dd2, test);
		Select select = new Select(driver.findElement(By.xpath(PRE_POP_DD2)));
		select.selectByVisibleText(param.get("prepopdd"));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Continue']"), "Continue", test);
		click(driver, testcaseName, By.xpath("//input[@value='Continue']"), "Continue", test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void publishSurveyPasswords(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		dmxPage.selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, survey_passwords, test);
		click(driver, testcaseName, survey_passwords, test);
		waitForLoad(driver, testcaseName, 60, test);
		try {
			driver.findElement(By.xpath(SINGLE_USE_PWD)).isDisplayed();
		} catch (Exception e) {
			waitforElemPresent(driver, testcaseName, 30, generate_new_url, test);
			click(driver, testcaseName, generate_new_url, test);
			waitForLoad(driver, testcaseName, 60, test);
		}
		waitforElemPresent(driver, testcaseName, 30, single_use_pwd, test);
		click(driver, testcaseName, single_use_pwd, test);
		waitForLoad(driver, testcaseName, 60, test);	
		selectFromAList2(driver, param, test);
		prePopulation(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			driver.findElement(By.xpath("//div[text()='Generating Password']")).isDisplayed();
			waitforElemPresent(driver, testcaseName, 120, By.xpath("//div[text()='Your passwords have been generated.']"), "Your passwords have been generated.", test);
			waitforElemPresent(driver, testcaseName, 60, By.xpath("//input[@value='Done' and @type='submit']"), "Done", test);
			click(driver, testcaseName, By.xpath("//input[@value='Done' and @type='submit']"), "Done", test);
			waitForLoad(driver, testcaseName, 30, test);
		} catch (Exception e) {
			waitforElemPresent(driver, testcaseName, 60, successfully_generated, test);
		}
		
		
		
		waitForLoad(driver, testcaseName, 30, test);
		//file download
		dmxPage.downloadFile(driver, param, generate_password , test);
	}
	
	public void prePopulation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		waitforElemPresent(driver, testcaseName, 60, pre_pop_dd2, test);
//		Select select = new Select(driver.findElement(By.xpath(PRE_POP_DD)));
//		select.selectByVisibleText(param.get("prepopdd"));
		String prepopdd[] = param.get("prepopdd").split(";");
		Thread.sleep(1000);	
		//waitforElemNotVisible(driver, testcaseName, 30, error_msg, test);
		List<WebElement> prepopDowns = getWebElements(driver, testcaseName, pre_pop_dd4, test);
		//Run the for each on pre-pop drop down and if duplicate value found, then select None value
		int j=0;
		for(String strprepop : prepopdd) {
			Select sel = new Select(prepopDowns.get(j));
			sel.selectByVisibleText(strprepop);
			j++;
		}
		ArrayList<String> duplicateStr = new ArrayList<String>();
		for(int i=0; i<prepopDowns.size(); i++) {
			Select sel = new Select(prepopDowns.get(i));
			String selectedValue = sel.getFirstSelectedOption().getAttribute("innerHTML");
			if(!selectedValue.equalsIgnoreCase("None")) {
				if(duplicateStr.contains(selectedValue)) {
					sel.selectByValue("None");
				}
				duplicateStr.add(selectedValue);
			}
		}
		scrollIntoCenter(driver, testcaseName, continue_button1, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button1, test);
		Thread.sleep(1000);	
		click(driver, testcaseName, continue_button1, test);
		
		waitForLoad(driver, testcaseName, 30, test);
		//Click on Continue button of Review data if prepopulated data has any mismatch
//		while(getWebElements(driver, testcaseName, review_mismatch_data, test).size()>0) {
//			click(driver, testcaseName, continue_button3, test);
//			waitForLoad(driver, testcaseName, 30, test);
//			break;
//		}
//		waitForElementToBeVisible(driver, testcaseName, By.xpath("//div[@class='header-content']/a[contains(text(),'Review Data')]"), 
//				"Review Data", 5, 200, test);
//		if(getWebElements(driver, testcaseName, review_mismatch_data, test).size()>0) {
//			click(driver, testcaseName, continue_button3, test);
//			waitForLoad(driver, testcaseName, 30, test);
//		}
		try {
			driver.findElement(By.xpath("//div[@class='header-content']/a[contains(text(),'Review Data')]")).isDisplayed();
			click(driver, testcaseName, continue_button3, test);
			waitForLoad(driver, testcaseName, 30, test);
		}catch(Exception e) {
			
		}
	}
	
	public void selectFromAList2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, use_existing_list, test);
		click(driver, testcaseName, use_existing_list, test);
		waitForLoad(driver, testcaseName, 60, test);
		
		waitforElemPresent(driver, testcaseName, 30, select_list2, test);
		Select select = new Select(driver.findElement(By.xpath(SELECT_LIST2)));
		select.selectByVisibleText(param.get("selectlist"));
		Thread.sleep(1000);
		
		try {
			driver.findElement(By.xpath(PRE_POP_SURVEY_INPUT2)).isSelected();
		} catch (Exception e) {
			waitforElemPresent(driver, testcaseName, 30, pre_pop_responses, test);
			click(driver, testcaseName, pre_pop_responses, test);
			waitForLoad(driver, testcaseName, 60, test);
		}
		waitforElemPresent(driver, testcaseName, 30, continue_button1, test);
		click(driver, testcaseName, continue_button1, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			driver.findElement(By.xpath("//input[@id='btnSendUnique']")).isDisplayed();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='btnSendUnique']"), "Send Unique", test);
			click(driver, testcaseName, By.xpath("//input[@id='btnSendUnique']"), "Send Unique", test);
			waitForLoad(driver, testcaseName, 30, test);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void prePopulation3(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		waitforElemPresent(driver, testcaseName, 60, pre_pop_dd2, test);
		Select select = new Select(driver.findElement(By.xpath(PRE_POP_DD2)));
		select.selectByVisibleText(param.get("prepopdd"));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//input[@value='Continue'])[2]"), "Continue", test);
		click(driver, testcaseName, By.xpath("(//input[@value='Continue'])[2]"), "Continue", test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void publishTestInvites(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		dmxPage.selectDistributeProject(driver, param, test);	
		selectTestDropDown(driver, param, test);
		/*
		 * waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		 * click(driver, testcaseName, single_use_link_button, test);
		 * waitForLoad(driver, testcaseName, 60, test);
		 * dmxPage.selectEmailTemplate(driver, param, test); selectFromAList(driver,
		 * param, test); try {
		 * driver.findElement(By.xpath("//input[@value='Continue']")).isDisplayed();
		 * click(driver, testcaseName, By.xpath("//input[@value='Continue']"),
		 * "Continue", test); waitForLoad(driver, testcaseName, 30, test); } catch
		 * (Exception e) { // TODO: handle exception } mailMerge2(driver, param, test);
		 * // dmxPage.prePopulation(driver, param, test); // dmxPage.reviewData(driver,
		 * param, test); dmxPage.sendOrSchedule(driver, param, test);
		 */
	}
	
	public void selectTestDropDown(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, test_dd, test);
			click(driver, testcaseName, test_dd, test);	
			waitforElemPresent(driver, testcaseName, 60, test_invite, test);
			click(driver, testcaseName, test_invite, test);
			waitforElemPresent(driver, testcaseName, 60, test_single, test);
			click(driver, testcaseName, test_single,test);
			waitForLoad(driver, testcaseName, 60, test);
			selectEmailTemplate(driver, param, test);
			selectFromATestList(driver, param, test);
//			waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
//			click(driver, testcaseName, done_editing_button, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
			click(driver, testcaseName, done_editing_button, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
			click(driver, testcaseName, test_send, test);
			click(driver, testcaseName, send_now, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 60, track_survey, test);
			
	}
	
	public void selectEmailTemplate(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 30, select_email_message, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '"+ param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::div[@class='middle-content'])[1]"), param.get("emailtemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::div[@class='middle-content'])[1]"))).build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::span[text()='Edit '])[1]"), param.get("emailtemplate") +" Edit", test);
		 
		click(driver, testcaseName, By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::span[text()='Edit '])[1]"), param.get("emailtemplate") +" Edit", test);
		 
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[text()='"+ param.get("emailtemplate") +"']"), "Edit template: "+param.get("emailtemplate"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 60, iframe_email_template, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_EMAIL_TEMPLATE)));
		waitforElemPresent(driver, testcaseName, 30, edit_subject_hover, test);
//		action.moveToElement(driver.findElement(By.xpath(EDIT_SUBJECT_HOVER))).build().perform();
//		Thread.sleep(1000);
//		waitforElemPresent(driver, testcaseName, 30, edit_subject_icon, test);
//		click(driver, testcaseName, edit_subject_icon, test);
//		Thread.sleep(1000);
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
//		String strDate = formatter.format(date);
//		setText(driver, testcaseName, edit_subject, "DP Email Template - "+strDate, test);
//		Thread.sleep(1000);
//		waitforElemPresent(driver, testcaseName, 30, edit_subject_save, test);
//		click(driver, testcaseName, edit_subject_save, test);
//		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		Thread.sleep(1000);
//		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 30, save_overwrite_button, test);
//		click(driver, testcaseName, save_overwrite_button, test);
//		Thread.sleep(1000);
//		waitforElemPresent(driver, testcaseName, 30, done_button, test);
//		click(driver, testcaseName, done_button, test);
//		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, source_email, test);
		
		
	}
	
	public void selectFromATestList(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, from_a_list, test);
		click(driver, testcaseName, from_a_list, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, select_list, test);
		Select select = new Select(driver.findElement(By.xpath(SELECT_LIST)));
		select.selectByVisibleText(param.get("selectlist"));
		Thread.sleep(1000);
		try {
			driver.findElement(By.xpath(PRE_POP_SURVEY_INPUT)).isSelected();
		} catch (Exception e) {
			waitforElemPresent(driver, testcaseName, 30, pre_pop_survey, test);
			click(driver, testcaseName, pre_pop_survey, test);
			waitForLoad(driver, testcaseName, 60, test);
		}
		waitForLoad(driver, testcaseName, 60, test);
		click(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, attributes_list, test);
		Select select1 = new Select(driver.findElement(By.xpath(ATTRIBUTES_LIST)));
		select1.selectByVisibleText(param.get("mailmergedd"));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10, attribute, test);
		setText(driver, testcaseName, attribute, param.get("mailmergetxt"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	

	
}
