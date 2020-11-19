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

public class DMXPage extends SeleniumUtils implements IDMXPage, ISMXPage {
	public double finish, start;
	public double end;
	

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
		selectFromAList(driver, param, test);
		mailMerge(driver, param, test);
		prePopulation(driver, param, test);
		reviewData(driver, param, test);
		sendOrSchedule(driver, param, test);
	}
	
	public void publishSurveyPasswords(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, survey_passwords, test);
		click(driver, testcaseName, survey_passwords, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, single_use_pwd, test);
		click(driver, testcaseName, single_use_pwd, test);
		waitForLoad(driver, testcaseName, 60, test);	
		
		prePopulation2(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, successfully_generated, test);
		waitforElemPresent(driver, testcaseName, 30, generate_password, test);
		click(driver, testcaseName, generate_password, test);
		waitForLoad(driver, testcaseName, 30, test);
		//file download
	}
	
	public void createContactList(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, create_contact, test);
		click(driver, testcaseName, create_contact, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, create_new, test);
		click(driver, testcaseName, create_new, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, create_new_list, test);
		click(driver, testcaseName, create_new_list, test);
		enterListName(driver, param, test);
		importFromFile2(driver, param, test);
		importColName(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, done_button2, test);
		click(driver, testcaseName, done_button2, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, success_msg, test);
		waitforElemPresent(driver, testcaseName, 30, search_list, test);
		setText(driver, testcaseName, search_list, param.get("listname"), test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.findElement(By.xpath(SEARCH_LIST)).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[text()='"+ param.get("listname") +"']"), param.get("listname"), test);
		deleteContactList(driver, param, test);
	}
	
	public void deleteContactList(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 100, list_checkbox, test);
		click(driver, testcaseName, By.xpath("//td[text()='"+ param.get("listname") +"']"), param.get("listname"), test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, delete_button, test);
		click(driver, testcaseName, delete_button, test);
		waitForLoad(driver, testcaseName, 60, test);
//		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, delete_msg, test);
	}
	
	public void enterListName(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, list_name, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		setText(driver, testcaseName, list_name, "DP List - "+strDate, test);
		param.put("listname", "DP List - "+strDate);
		waitforElemPresent(driver, testcaseName, 30, continue_button3, test);
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 60, test);
	}
	
	public void publishSmsInvitation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, sms_invitation, test);
		click(driver, testcaseName, sms_invitation, test);
		waitForLoad(driver, testcaseName, 60, test);
//		selectEmailTemplate(driver, param, test);
		importFromFile(driver, param, test);
		try {
			driver.findElement(By.xpath("//div[contains(text(),'duplicate mobile number(s) found in the list of invitees.')]")).isDisplayed();
			waitforElemPresent(driver, testcaseName, 30, send_unique, test);
			click(driver, testcaseName, send_unique, test);
			waitForLoad(driver, testcaseName, 60, test);
		} catch (Exception e) {
			// TODO: handle exception
		}
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, invitation_sent, test);
	}
	
	public void publishSingleUseLinkexe(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		click(driver, testcaseName, single_use_link_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		selectEmailTemplate(driver, param, test);
		selectFromAList(driver, param, test);
		mailMerge(driver, param, test);
		prePopulation(driver, param, test);
		reviewData(driver, param, test);
		sendOrScheduleexe(driver, param, test);
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
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]"), param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]/following::div[@class='middle-content'])[1]"), param.get("emailtemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplate") +"')]/following::div[@class='middle-content'])[1]"))).build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, edit_button, test);
		click(driver, testcaseName, edit_button, test);
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
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, save_overwrite_button, test);
		click(driver, testcaseName, save_overwrite_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, done_button, test);
		click(driver, testcaseName, done_button, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, source_email, test);
		
		
	}
	
	public void selectEmailTemplateReminder(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 30, select_email_message, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@class='header' and contains(text(),'"+ param.get("emailtemplatere") +"')]"), param.get("emailtemplatere"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplatere") +"')]/following::div[@class='middle-content'])[1]"), param.get("emailtemplatere"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//div[@class='header' and contains(text(),'"+ param.get("emailtemplatere") +"')]/following::div[@class='middle-content'])[1]"))).build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, edit_button, test);
		click(driver, testcaseName, edit_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[text()='"+ param.get("emailtemplatere") +"']"), "Edit template: "+param.get("emailtemplatere"), test);
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
//		setText(driver, testcaseName, edit_subject, "DP Reminder Template - "+strDate, test);
//		Thread.sleep(1000);
//		waitforElemPresent(driver, testcaseName, 30, edit_subject_save, test);
//		click(driver, testcaseName, edit_subject_save, test);
//		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 30, save_overwrite_button, test);
//		click(driver, testcaseName, save_overwrite_button, test);
//		Thread.sleep(1000);
//		waitforElemPresent(driver, testcaseName, 30, done_button, test);
//		click(driver, testcaseName, done_button, test);
//		Thread.sleep(1000);
//		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
		
		
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
		
	}
	
	public void importFromFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, import_from_file, test);
		click(driver, testcaseName, import_from_file, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, browse_button1, test);
		driver.findElement(By.xpath(BROWSE_BUTTON1)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[text()='"+ param.get("file") +"']"), param.get("file"), test);
		click(driver, testcaseName, header_switch,test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void importFromFile2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, import_from_file2, test);
		click(driver, testcaseName, import_from_file2, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, browse_button1, test);
		driver.findElement(By.xpath(BROWSE_BUTTON1)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[text()='"+ param.get("file") +"']"), param.get("file"), test);
		click(driver, testcaseName, header_switch2,test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		click(driver, testcaseName, allow_duplicate, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button3, test);
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
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
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_dd3, test);
		Select select3 = new Select(driver.findElement(By.xpath(MAIL_MERGE_DD3)));
		select3.selectByVisibleText(mailmergedd[2]);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt1, test);
		setText(driver, testcaseName, mail_merge_txt1, mailmergetxt[0], test);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt2, test);
		setText(driver, testcaseName, mail_merge_txt2, mailmergetxt[1], test);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, mail_merge_txt3, test);
		setText(driver, testcaseName, mail_merge_txt3, mailmergetxt[2], test);
		Thread.sleep(1000);
		
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}

	public void prePopulation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		waitforElemPresent(driver, testcaseName, 60, pre_pop_dd, test);
		Select select = new Select(driver.findElement(By.xpath(PRE_POP_DD)));
		select.selectByVisibleText(param.get("prepopdd"));
		Thread.sleep(1000);
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
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void importColName(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] fields = param.get("prepopdd").split(";");
		waitforElemPresent(driver, testcaseName, 30, map_fields, test);
		clearText(driver, testcaseName, map_fields, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, map_fields, fields[0], test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_fields2, test);
		clearText(driver, testcaseName, map_fields2, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, map_fields2, fields[1], test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_fields3, test);
		clearText(driver, testcaseName, map_fields3, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, map_fields3, fields[2], test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='"+ fields[0] +"']//ancestor::tr[@class='withInLimit']"), fields[0], test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@value='"+ fields[0] +"']//ancestor::tr[@class='withInLimit']"))).build().perform();
		click(driver, testcaseName, By.xpath("(//div[@class='lock-icon'])[1]"), "Lock Icon", test);
	}
	
	public void reviewData(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, review_data, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void sendOrSchedule(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
		waitforElemPresent(driver, testcaseName, 30, send_now, test);
		click(driver, testcaseName, send_now, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, invitation_sent, test);
	}
	
	public void sendOrScheduleexe(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
		waitforElemPresent(driver, testcaseName, 30, send_now, test);
		click(driver, testcaseName, send_now, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, invitation_sent_exe, test);
	}
	
	public void sendReminders(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, reminders, test);
		click(driver, testcaseName, reminders, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, original_invitation_date_filter, test);
		click(driver, testcaseName, original_invitation_date_filter, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, on_date, test);
		click(driver, testcaseName, on_date, test);
		selectCalendar(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, done_button3, test);
		click(driver, testcaseName, done_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, schedule_reminder, test);
		click(driver, testcaseName, schedule_reminder, test);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		selectEmailTemplateReminder(driver, param, test);
		sendOrSchedule(driver, param, test);
	}
	
	public void sendSMSReminders(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, reminders, test);
		click(driver, testcaseName, reminders, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, sms_invites_reminder, test);
		click(driver, testcaseName, sms_invites_reminder, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, original_invitation_date_filter, test);
		click(driver, testcaseName, original_invitation_date_filter, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, on_date, test);
		click(driver, testcaseName, on_date, test);
		selectCalendar(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, done_button3, test);
		click(driver, testcaseName, done_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, schedule_reminder, test);
		click(driver, testcaseName, schedule_reminder, test);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
//		selectEmailTemplateReminder(driver, param, test);
//		sendOrSchedule(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, invitation_sent, test);
	}
	
	public void selectCalendar(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		SimpleDateFormat formatter = new SimpleDateFormat("d.MMM.yyyy");  
		Date date = new Date();  
		System.out.println(formatter.format(date));  
		String today = formatter.format(date);
		String dates[] = today.split("\\.");
		waitforElemPresent(driver, testcaseName, 30, calendar, test);
		click(driver, testcaseName, calendar, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, year, test);
		Select select = new Select(driver.findElement(By.xpath(YEAR)));
		select.selectByVisibleText(dates[2]);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, month, test);
		Select select2 = new Select(driver.findElement(By.xpath(MONTH)));
		select2.selectByVisibleText(dates[1]);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ dates[0] +"']"), dates[0], test);
		click(driver, testcaseName, By.xpath("//td[@data-handler='selectDay']/a[text()='"+ dates[0] +"']"), dates[0], test);
		Thread.sleep(1000);
	}
	
	public double goToDistributePage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		//new StaticPage().login(driver, param, username, password, URL, test);
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
