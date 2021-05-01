package pageobjects;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import property.IDMXPage;
import property.IHomePage;
import property.ISMXPage;
import property.ISurveyPage;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.WebPageElements;

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
		//reviewData(driver, param, test);
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
		selectFromAList2(driver, param, test);
		prePopulation2(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, successfully_generated, test);
//		waitforElemPresent(driver, testcaseName, 30, generate_password, test);
//		click(driver, testcaseName, generate_password, test);
		waitForLoad(driver, testcaseName, 30, test);
		//file download
		downloadFile(driver, param, generate_password, test);
	}
	
	public void downloadFile(WebDriver driver, HashMap<String, String> param, WebPageElements button, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String downloadFilePath = System.getProperty("user.dir") +"\\src\\main\\resources\\excelfiles";
		String fileSystem = "SurveyFiles";
		long beforeCount = 0;
		try {
			beforeCount = Files.list(Paths.get("./src/main/resources/excelfiles")).count();
			System.out.println(beforeCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			long afterCount = beforeCount;
			int i = 0;
			waitforElemPresent(driver, testcaseName, 30, button, test);
			click(driver, testcaseName, button, test);
			while (beforeCount >= afterCount && i < 180) {
				afterCount = Files.list(Paths.get("./src/main/resources/excelfiles")).count();
				Thread.sleep(1000);
				i++;
			}
			if(i == 180) {
				reportFail(testcaseName,
						"The excel was not downloaded.", test);
			}
			System.out.println(afterCount);
			String fileName = latestFileName();
			while(fileName.contains("tmp") || fileName.contains("crdownload")) {
				Thread.sleep(500);
				fileName = latestFileName();
			}
			
		} catch (Exception e) {
			reportFail(testcaseName,
					"The excel was not downloaded.", test);
		}
		
		File theDir = new File("./src/main/resources/excelfiles/"+ fileSystem);
		if(!theDir.exists()) {
			theDir.mkdir();
		}
		int r = RandomNumber();
		String fileName = latestFileName("xls");
		String latestFile = fileName + "_" + r;
		System.out.println(latestFile);
		File file = new File(fileName);
		File file2 = new File("./src/main/resources/excelfiles/"+latestFile.trim()+".xls");
		
		file.renameTo(file2);
		String path = "./src/main/resources/excelfiles/"+fileSystem+"/"+latestFile.trim()+".xls";
		
		file2.renameTo(new File("./src/main/resources/excelfiles/"+fileSystem+"/"+latestFile.trim()+".xls"));
		System.out.println("File path is: "+path);
	}
	
	public void publishTestInvites(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectDistributeProject(driver, param, test);	
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
	
	public int RandomNumber() {
		Random rand = new Random();
		int n = rand.nextInt(10000) + 1;
		return n;
	}
	
	public String latestFileName() {
		File theNewFile = null;
		File dir = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\excelfiles");
		FileFilter fileFilter = new WildcardFileFilter("*.*");
		File[] files = dir.listFiles(fileFilter);
		if(files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewFile = files[0];
		}
		return theNewFile.toString();
	}
	
	public String latestFileName(String extension) {
		File theNewFile = null;
		File dir = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\excelfiles");
		FileFilter fileFilter = new WildcardFileFilter("*."+extension);
		File[] files = dir.listFiles(fileFilter);
		if(files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewFile = files[0];
		}
		//
		String fileNew = theNewFile.getName().toString();
	
		return fileNew;
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
		waitForLoad(driver, testcaseName, 60, test);
		enterListName(driver, param, test);
		importFromFile2(driver, param, test);
		importColName(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, done_button2, test);
		click(driver, testcaseName, done_button2, test);
		waitForLoad(driver, testcaseName, 30, test);
		//waitforElemPresent(driver, testcaseName, 30, success_msg, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//span[text()='Your list has been created!']"), "Success Msg", 30, 200, test);
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
		try {
			driver.findElement(By.xpath("//span[@id='SmsInvSteps_lblPageSubTitle'][contains(text(),'Identify answers to be pre-filled.')]")).isDisplayed();
			List<WebElement> prepopDowns = getWebElements(driver, testcaseName, pre_pop_dd3, test);
			//Run the for each on pre-pop drop down and if duplicate value found, then select None value
			ArrayList<String> duplicateStr = new ArrayList<String>();
			for(WebElement ele : prepopDowns) {
				Select sel = new Select(ele);
				String selectedValue = sel.getFirstSelectedOption().getAttribute("innerHTML");
				if(!selectedValue.equalsIgnoreCase("None")) {
					if(duplicateStr.contains(selectedValue)) {
						sel.selectByValue("None");
					}
					duplicateStr.add(selectedValue);
				}
			}
			waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
			click(driver, testcaseName, done_editing_button, test);
			
		}catch(Exception e) {
			// TODO: handle exception
		}
		waitForLoad(driver, testcaseName, 60, test);
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
		try {
			driver.findElement(By.xpath("//input[@name='btnSendUnique']")).isDisplayed();
			click(driver, testcaseName, By.xpath("//input[@name='btnSendUnique']"), "Continue", test);
			waitForLoad(driver, testcaseName, 30, test);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

//        Invitations will not be sent to the addresses below.
    
		mailMerge(driver, param, test);
		prePopulation(driver, param, test);
		//reviewData(driver, param, test);
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
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '"+ param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("(//div[@title = '"+ param.get("emailtemplate") +"']//following::div[@class='middle-content'])[1]"), param.get("emailtemplate"), test);
		Thread.sleep(2000);
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
		setText(driver, testcaseName, search_email, param.get("emailtemplatere"), test);
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
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void importFromFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Thread.sleep(2000);
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
		//waitforElemNotVisible(driver, testcaseName, 30, error_msg, test);
		List<WebElement> prepopDowns = getWebElements(driver, testcaseName, pre_pop_dd3, test);
		//Run the for each on pre-pop drop down and if duplicate value found, then select None value
		ArrayList<String> duplicateStr = new ArrayList<String>();
		for(WebElement ele : prepopDowns) {
			Select sel = new Select(ele);
			String selectedValue = sel.getFirstSelectedOption().getAttribute("innerHTML");
			if(!selectedValue.equalsIgnoreCase("None")) {
				if(duplicateStr.contains(selectedValue)) {
					sel.selectByValue("None");
				}
				duplicateStr.add(selectedValue);
			}
		}
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		Thread.sleep(1000);	
		click(driver, testcaseName, done_editing_button, test);
		
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
		//waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='"+ fields[0] +"']//ancestor::tr[@class='withInLimit']"), fields[0], test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='"+ fields[0] +"'][@type='text']"), fields[0], test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@value='"+ fields[0] +"'][@type='text']"))).build().perform();
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
	
	public void sendOrScheduleReminderexe(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
		waitforElemPresent(driver, testcaseName, 30, send_now, test);
		click(driver, testcaseName, send_now, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, reminders_sent_exe, test);
	}
	
	public void sendReminders(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Thread.sleep(20000);
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
	
	public void sendRemindersEXE(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
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
		sendOrScheduleReminderexe(driver, param, test);
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
			waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
			click(driver, testcaseName, done_editing_button, test);
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

	
	public double goToTrackSurvey(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
		setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
		click(driver, testcaseName, IHomePage.search_icon, test);
		WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
		new Actions(driver).moveToElement(survey).perform();
		waitForElementToBeVisible(driver, testcaseName, IHomePage.track_survey_icon, 10, 100, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, IHomePage.track_survey_icon, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, email_template, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public ArrayList<String> getEmailList(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> emailList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, email_field, test);
		for(WebElement ele : emailList_locator) {
			emailList.add(ele.getAttribute("innerHTML"));
		}
		return emailList;
	}
	
	public ArrayList<String> getParticipationStatusList(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> participationStatusList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, status_field, test);
		for(WebElement ele : emailList_locator) {
			participationStatusList.add(ele.getAttribute("innerHTML"));
		}
		return participationStatusList;
	}
	
	public ArrayList<String> getInvitationDateList(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> invitationDateList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, invitation_date_field, test);
		for(WebElement ele : emailList_locator) {
			invitationDateList.add(ele.getAttribute("innerHTML"));
		}
		return invitationDateList;
	}
	
	public ArrayList<String> getURLExpiryList(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> urlExpiryList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, url_expiry_field, test);
		for(WebElement ele : emailList_locator) {
			urlExpiryList.add(ele.getAttribute("innerHTML"));
		}
		return urlExpiryList;
	}
	
	public JsonObject jsonTrackSurveyData(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> emailList = getEmailList(driver, param, test);
		ArrayList<String> participationStatusList = getParticipationStatusList(driver, param, test);
		ArrayList<String> invitationDateList = getInvitationDateList(driver, param, test);
		ArrayList<String> urlExpiryList = getURLExpiryList(driver, param, test);
		JsonObject json = new JsonObject();
		JsonArray jArray = new JsonArray();
		
		
			for(int j=0; j<emailList.size(); j++ ) {
				JsonObject innerJson = new JsonObject();
				innerJson.addProperty("Email", emailList.get(j));
				innerJson.addProperty("Status", participationStatusList.get(j));
				innerJson.addProperty("Invitation Date", invitationDateList.get(j));
				innerJson.addProperty("URL Expiry", urlExpiryList.get(j));
				jArray.add(innerJson);
			}			
		
		json.add("Table", jArray);
		new JSONUtility().writeJSONToFIle(testcaseName, json, "\\src\\main\\resources\\jsonFiles\\jsonTrackSurveyData.json", test);
		return json;		
	}
	
	public void goToReminderPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, reminders, test);
		click(driver, testcaseName, reminders, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, original_invitation_date_filter, test);
		
	}
	
	public void applyFirstReminderFilter(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, reminder_column_filter, test);
		click(driver, testcaseName, reminder_column_filter, test);
		waitforElemPresent(driver, testcaseName, 60, first_reminder_filter, test);
		click(driver, testcaseName, first_reminder_filter, test);
		scrollIntoCenter(driver, testcaseName, reminder_column_filter_save_button, test);
		waitforElemPresent(driver, testcaseName, 60, reminder_column_filter_save_button, test);
		click(driver, testcaseName, reminder_column_filter_save_button, test);			
	}
	
	public ArrayList<String> getEmailListFromReminderPage(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> emailList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, reminder_email_field, test);
		for(WebElement ele : emailList_locator) {
			emailList.add(ele.getAttribute("innerHTML"));
		}
		return emailList;
	}
	
	public ArrayList<String> getOriginalInvitationDateFromReminderPage(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> invitationDateList = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, reminder_original_invitation_field, test);
		for(WebElement ele : emailList_locator) {
			invitationDateList.add(ele.getAttribute("innerHTML"));
		}
		return invitationDateList;
	}
	
	public ArrayList<String> getNumberOfRemindersSent(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> reminderSentCount = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, number_of_reminders_sent, test);
		for(WebElement ele : emailList_locator) {
			reminderSentCount.add(ele.getAttribute("innerHTML"));
		}
		return reminderSentCount;
	}
	
	public ArrayList<String> getFirstReminderSentDate(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> sentDate = new ArrayList<String> ();
		List<WebElement> emailList_locator = getWebElements(driver, testcaseName, first_reminder_sent_date, test);
		for(WebElement ele : emailList_locator) {
			sentDate.add(ele.getAttribute("innerHTML"));
		}
		return sentDate;
	}
	
	public JsonObject jsonReminderData(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> emailList = getEmailListFromReminderPage(driver, param, test);
		ArrayList<String> originalInvitationDate = getOriginalInvitationDateFromReminderPage(driver, param, test);
		ArrayList<String> numberOfRemindersSent = getNumberOfRemindersSent(driver, param, test);
		ArrayList<String> firstReminderSentDate = getFirstReminderSentDate(driver, param, test);
		JsonObject json = new JsonObject();
		JsonArray jArray = new JsonArray();
			
		
			for(int j=0; j<emailList.size(); j++ ) {
				JsonObject innerJson = new JsonObject();
				innerJson.addProperty("Email", emailList.get(j));
				innerJson.addProperty("Original Invitation Date", originalInvitationDate.get(j));
				innerJson.addProperty("Number of Reminders Sent", numberOfRemindersSent.get(j));
				innerJson.addProperty("First Reminder Sent Date", firstReminderSentDate.get(j));
				jArray.add(innerJson);
			}			
		
		json.add("Table", jArray);
		new JSONUtility().writeJSONToFIle(testcaseName, json, "\\src\\main\\resources\\jsonFiles\\jsonReiminderData.json", test);	
		return json;		
	}
	
	public void goToSurveyPasswordsInTrackSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String surveyTitle = param.get("surveyTitle");
		String SID = param.get("surveyNo");
		goToTrackSurvey(driver, param, surveyTitle, SID, test);
		click(driver, testcaseName, select_channel_dropdown, test);
		waitforElemPresent(driver, testcaseName, 10, channel_list, test);
		click(driver, testcaseName, channel_survey_passwords, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public ArrayList<String> getPasswordList(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> passwordList = new ArrayList<String> ();
		List<WebElement> password_field = getWebElements(driver, testcaseName, sap_password_field, test);
		for(WebElement ele : password_field) {
			passwordList.add(ele.getAttribute("innerHTML"));
		}
		return passwordList;
	}
	
	public ArrayList<String> getSurveyLoginURLs(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> urls = new ArrayList<String> ();
		List<WebElement> surveyLoginUrls = getWebElements(driver, testcaseName, sap_survey_login_url_field, test);
		for(WebElement ele : surveyLoginUrls) {
			urls.add(ele.getAttribute("innerHTML"));
		}
		return urls;
	}
	
	public ArrayList<String> getSAPStatusdata(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> statusData = new ArrayList<String> ();
		List<WebElement> statusField = getWebElements(driver, testcaseName, sap_status_field, test);
		for(WebElement ele : statusField) {
			statusData.add(ele.getAttribute("innerHTML"));
		}
		return statusData;
	}
	
	public ArrayList<String> getSAPGeneratedOnData(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> generatedOnData = new ArrayList<String> ();
		List<WebElement> generatedOnField = getWebElements(driver, testcaseName, sap_generated_on_field, test);
		for(WebElement ele : generatedOnField) {
			generatedOnData.add(ele.getAttribute("innerHTML"));
		}
		return generatedOnData;
	}
	
	public JsonObject getSAPDataFromTrackSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> passwordList = getPasswordList(driver, param, test);
		ArrayList<String> urls = getSurveyLoginURLs(driver, param, test);
		ArrayList<String> status = getSAPStatusdata(driver, param, test);
		ArrayList<String> generatedOn = getSAPGeneratedOnData(driver, param, test);
		JsonObject json = new JsonObject();
		JsonArray jArray = new JsonArray();
			
		
			for(int i=0; i<passwordList.size(); i++ ) {
				JsonObject innerJson = new JsonObject();
				innerJson.addProperty("Password", passwordList.get(i));
				innerJson.addProperty("Survey Login URL", urls.get(i));
				innerJson.addProperty("Status", status.get(i));
				innerJson.addProperty("Generated On", generatedOn.get(i));
				jArray.add(innerJson);
			}			
		
		json.add("Table", jArray);
		
		new JSONUtility().writeJSONToFIle(testcaseName, json, "\\src\\main\\resources\\jsonFiles\\jsonSAPData.json", test);	
		return json;		
		
	}
	
	public void goToContactList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_contact, test);
		click(driver, testcaseName, create_contact, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, create_new, test);
	}
	
	public void selectContactList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String listName = param.get("listname");
		setText(driver, testcaseName, search_contact_list, listName, test);
		click(driver, testcaseName, search_contact_list_icon, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[text()= '"+listName+"']"), listName, test);
		click(driver, testcaseName, By.xpath("//td[text()= '"+listName+"']"), listName, test);
		click(driver, testcaseName, view_modify_contact_list, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, total_record_field, test);
		selectContactListPage(driver, param, test);
		
	}
	
	public void selectContactListPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		int totRecord = Integer.parseInt(getWebElement(driver, testcaseName, total_record_field, test).getAttribute("innerHTML"));
		
		Select select = new Select(getWebElement(driver, testcaseName, contact_list_drop_down, test));
		int selectIndex = totRecord/100;
		select.selectByIndex(selectIndex);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public JsonObject getContactListDetailsJson(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		List<WebElement> contactListRow = getWebElements(driver, testcaseName, contact_list_row, test);
		List<WebElement> headerFields = getWebElements(driver, testcaseName, contact_list_header_fields, test);
		headerFields.remove(1);		// Remove Status field
		JsonObject jTable = new JsonObject();
		JsonArray jArray = new JsonArray();
		for(int i=0; i<contactListRow.size(); i++) {
			List<WebElement> rowData = driver.findElements(By.xpath("//td[contains(@id,'td_"+(i+2)+"_')]"));	
			rowData.remove(1);		// Remove Status field
			JsonObject json = new JsonObject();
			for(int j=0; j<rowData.size(); j++) {
				json.addProperty(headerFields.get(j).getAttribute("innerHTML"), rowData.get(j).getAttribute("innerHTML"));
			}
			jArray.add(json);
		}
		jTable.add("Table", jArray);
		new JSONUtility().writeJSONToFIle(testcaseName, jTable, "\\src\\main\\resources\\jsonFiles\\jsonContactListData.json", test);
		return jTable;
	}
	
	public JsonObject getContactListDetailsJsonOfInsertedData(WebDriver driver, HashMap<String, String> param, ExtentTest test){
		String testcaseName = param.get("TestCaseName");
		int numberOfContact = Integer.parseInt(param.get("numberOfContact"));
		List<WebElement> contactListRow = getWebElements(driver, testcaseName, contact_list_row, test);
		List<WebElement> headerFields = getWebElements(driver, testcaseName, contact_list_header_fields, test);
		headerFields.remove(1);		// Remove Status field
		JsonObject jTable = new JsonObject();
		JsonArray jArray = new JsonArray();
		for(int i=(contactListRow.size()-numberOfContact); i<contactListRow.size(); i++) {
			List<WebElement> rowData = driver.findElements(By.xpath("//td[contains(@id,'td_"+(i+2)+"_')]"));	
			rowData.remove(1);		// Remove Status field
			JsonObject json = new JsonObject();
			for(int j=0; j<rowData.size(); j++) {
				json.addProperty(headerFields.get(j).getAttribute("innerHTML"), rowData.get(j).getAttribute("innerHTML"));
			}
			jArray.add(json);
		}
		jTable.add("Table", jArray);
		new JSONUtility().writeJSONToFIle(testcaseName, jTable, "\\src\\main\\resources\\jsonFiles\\jsonContactListData.json", test);
		return jTable;
	}
	
	
}
