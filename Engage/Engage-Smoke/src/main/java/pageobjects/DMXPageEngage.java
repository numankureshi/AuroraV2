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
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt1, test);
		setText(driver, testcaseName, mail_merge_txt1, mailmergetxt[0], test);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt2, test);
		setText(driver, testcaseName, mail_merge_txt2, mailmergetxt[1], test);
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
//		waitforElemPresent(driver, testcaseName, 50, By.xpath("//span[contains(text(),'This list includes duplicate email addresses. A single-use link will be generated for each.')]"), "List with duplicate email address", test);
//		waitforElemPresent(driver, testcaseName, 30, invite_in_seperate_email, test);
//		click(driver, testcaseName, invite_in_seperate_email, test);
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
		dmxPage.selectFromAList2(driver, param, test);
		prePopulation2(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, successfully_generated, test);
		
		waitForLoad(driver, testcaseName, 30, test);
		//file download
		dmxPage.downloadFile(driver, param, generate_password , test);
	}

	
}
