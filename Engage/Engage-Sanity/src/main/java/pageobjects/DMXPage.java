package pageobjects;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang.time.DateUtils;
import org.jsoup.Jsoup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Splitter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import property.IDMXPage;
import property.IHomePage;
import property.ISMXPage;
import property.ISurveyPage;
import testsuitebase.TestResultStatus;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.WebPageElements;

public class DMXPage extends SeleniumUtils implements IDMXPage, ISMXPage {
	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	

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
	
	public void downloadFile(WebDriver driver, HashMap<String, String> param, WebPageElements button, String format, String downloadFilePath, ExtentTest test) {
		DMXPage dmxPage = new DMXPage();
		String testcaseName = param.get("TestCaseName");
		long beforeCount = 0;
		try {
			beforeCount = Files.list(Paths.get(downloadFilePath)).count();
			System.out.println(beforeCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			long afterCount = beforeCount;
			int i = 0;
			waitforElemPresent(driver, testcaseName, 30, button, test);
			click(driver, testcaseName, button, test);
			while (beforeCount >= afterCount && i < 300) {
				afterCount = Files.list(Paths.get(downloadFilePath)).count();
				Thread.sleep(1000);
				i++;
			}
			if(i == 300) {
				reportFail(testcaseName,
						"The file was not downloaded.", test);
			}
			System.out.println(afterCount);
//			Thread.sleep(2000);
			String fileName = dmxPage.latestFileNameFromPath(downloadFilePath);
			while(fileName.contains("tmp") || fileName.contains("crdownload")) {
				Thread.sleep(500);
				fileName = dmxPage.latestFileNameFromPath(downloadFilePath);
			}
			
		} catch (Exception e) {
			reportFail(testcaseName,
					"The excel was not downloaded.", test);
			e.printStackTrace();
		}
		
		File theDir = new File(downloadFilePath);
		if(!theDir.exists()) {
			theDir.mkdir();
		}
		int r = dmxPage.RandomNumber();
		String fileName = dmxPage.latestFileName(downloadFilePath, format);
		String[] filesNew2 = fileName.split("\\.");
		String latestFile = filesNew2[0] + "_" + r;
//		String latestFile = fileName;
		System.out.println(latestFile);
		File file = new File(downloadFilePath + latestFile.trim()+"."+format);
		File file2 = new File(downloadFilePath + fileName);
		
		file2.renameTo(file);
		String path = downloadFilePath + "/"+latestFile.trim()+"."+format;
		
		file.renameTo(new File(downloadFilePath +"/"+latestFile.trim()+"."+format));
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
	
	public String latestFileNameFromPath(String path) {
		File theNewFile = null;
		File dir = new File(path);
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

	public String latestFileName(String path, String extension) {
		File theNewFile = null;
		File dir = new File(path);
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
		waitforElemPresent(driver, testcaseName, 60, sms_invitation_sent, test);
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
	
	public void sendOrScheduleReminders(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, send_or_schedule, test);
		waitforElemPresent(driver, testcaseName, 30, send_now, test);
		click(driver, testcaseName, send_now, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, reminder_sent, test);
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
		sendOrScheduleReminders(driver, param, test);
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
		waitforElemPresent(driver, testcaseName, 30, sms_reminder_sent, test);
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
	
	public void goToAllProject(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
//		Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
		if(isShowNewAllProjectDashBoard) {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
		}
//		For old dashboard
		else {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
		}
	}
	
	public double goToDistributePage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
		//	Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
				
		//	For new dashboard changes
		if (isShowNewAllProjectDashBoard) {		
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, surveyTitle, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"), surveyTitle, 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_publish_icon, 60, 100, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_publish_icon, test);
		}
		//	For old dashboard
		else {	
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitforElemPresent(driver, testcaseName, 60, IHomePage.publish_icon, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.publish_icon, test);
		}
		
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, quick_send, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public double goToDistributePage2(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		
//		Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
//		For new dashboard changes
		if (isShowNewAllProjectDashBoard) {	
			if(param.containsKey("copiedSurveyTitle")) {
				waitForLoad(driver, testcaseName, 30, test);
				waitForJStoLoad(driver, 30);
				clearText(driver, testcaseName, IHomePage.new_search_bar, test);
				Thread.sleep(1000);
			}
			setText(driver, testcaseName, IHomePage.new_search_bar, surveyTitle, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"), surveyTitle, 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_publish_icon, 60, 100, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_publish_icon, test);
		}
//		For old dashboard
		else {
			setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitforElemPresent(driver, testcaseName, 60, IHomePage.publish_icon, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.publish_icon, test);
		}
		
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, quick_send, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	public String goToDistributePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
//		Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
//		For new dashboard changes
		if (isShowNewAllProjectDashBoard) {	
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("Survey Title"), test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"), param.get("Survey Title"), 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_publish_icon, 60, 100, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_publish_icon, test);
		}
		
		else {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, param.get("Survey Title"), test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+param.get("SID")+"']"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitforElemPresent(driver, testcaseName, 60, IHomePage.publish_icon, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.publish_icon, test);
		}
		
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, quick_send, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		return strtotalTime;
	}
	
	public void goToDistributePage2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, distribute, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, quick_send, test);
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
		
//		Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
//		For new dashboard changes
		if (isShowNewAllProjectDashBoard) {	
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("Survey Title"), test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"), surveyTitle, 60, 100, test);
			WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"));
			new Actions(driver).moveToElement(survey).build().perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_track_survey_icon, 60, 100, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_track_survey_icon, test);
		}
		else {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
			new Actions(driver).moveToElement(survey).perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.track_survey_icon, 10, 100, test);
			
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.track_survey_icon, test);
		}
		
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, time_filter, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		totalTime = ((end - start)) / 1000;
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
	
	public void selectSingleUseLinkChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
	String testcaseName = param.get("TestCaseName");
		if(!getWebElement(driver, testcaseName, selected_channel, test).getAttribute("innerHTML").contains("Single-Use Link")) {
			click(driver, testcaseName, selected_channel, test);
			waitforElemPresent(driver, testcaseName, 30, channel_menu, test);
			click(driver, testcaseName, single_use_link_channel, test);
			waitForLoad(driver, testcaseName, 30, test);
			try {
				waitForJStoLoad(driver, 30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			Reporter.log("Single-Use link channel is already selected");
			test.info("Single-Use link channel is already selected");
			Add_Log.info("Single-Use link channel is already selected");
		}
	}
	
	
	public JsonObject jsonTrackSurveyData(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		selectSingleUseLinkChannel(driver, param, test);
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
		new JSONUtility().writeJSONToFIle(testcaseName, json, "\\src\\main\\resources\\jsonFiles\\jsonReminderData.json", test);	
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
	
	/* ************************************************************************************************************************
	 * 
	 * Created functions for capturing page load time for DMX modules. All these functions are used in performance testcase file
	 * 
	 * *************************************************************************************************************************
	 */
	public Map<String, String> getDMHomePageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToDistributePage(driver, param, test));
		return readingData;
	}
	
	public Map<String, String> getSingleUseInvByListReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToDistributePage(driver, param, test));
		readingData.put(param.get("Step2"), goToEmailMsgPage(driver, param, test));
		readingData.put(param.get("Step3"), goToEmailAddrSourcePage(driver, param, test));
		readingData.put(param.get("Step4"), selectList(driver, param, test));
		readingData.put(param.get("Step5"), goToMailMergePageByList(driver, param, test));
		readingData.put(param.get("Step6"), goToPrepopPage(driver, param, test));
		readingData.put(param.get("Step7"), goToReviewDataPage(driver, param, test));
		readingData.put(param.get("Step8"), goToSendInvPage(driver, param, test));
		readingData.put(param.get("Step9"), sendInvitations(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getSingleUseInvReadingsByFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToDistributePage(driver, param, test));
		readingData.put(param.get("Step2"), goToEmailMsgPage(driver, param, test));
		readingData.put(param.get("Step3"), goToEmailAddrSourcePage(driver, param, test));
		readingData.put(param.get("Step4"), goToMailMergePageByFile(driver, param, test));
		readingData.put(param.get("Step5"), goToPrepopPage(driver, param, test));
		readingData.put(param.get("Step6"), goToReviewDataPage(driver, param, test));
		readingData.put(param.get("Step7"), goToSendInvPage(driver, param, test));
		readingData.put(param.get("Step8"), sendInvitations(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getSingleUseInvReadingsByManually(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToDistributePage(driver, param, test));
		readingData.put(param.get("Step2"), goToEmailMsgPage(driver, param, test));
		readingData.put(param.get("Step3"), goToEmailAddrSourcePage(driver, param, test));
		readingData.put(param.get("Step4"), goToMailMergePageByManually(driver, param, test));
		readingData.put(param.get("Step5"), goToPrepopPageByManually(driver, param, test));
		readingData.put(param.get("Step6"), goToReviewDataPageByManually(driver, param, test));
		readingData.put(param.get("Step7"), goToSendInvPage(driver, param, test));
		readingData.put(param.get("Step8"), sendInvitations(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getListCreationReadingByFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToContactListPage(driver, param, test));
		readingData.put(param.get("Step2"), goToListSourcePage(driver, param, test));
		readingData.put(param.get("Step3"), goToMappingPageByFile(driver, param, test));
		readingData.put(param.get("Step4"), createListByMappingValues(driver, param, test));
		readingData.put(param.get("Step5"), getdeleteContactListReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getSAPReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), getSAPDashboardReading(driver, param, test));
		readingData.put(param.get("Step2"), getSAPPageReading(driver, param, test));
		readingData.put(param.get("Step3"), getSAPPrepopReading(driver, param, test));
		readingData.put(param.get("Step4"), getTempSelReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getEmailTempCreationReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), getEmailTempPageReading(driver, param, test));
		readingData.put(param.get("Step2"), getEmailTempCreateNewReading(driver, param, test));
		readingData.put(param.get("Step3"), getSaveEmailTempReading(driver, param, test));
		//Delete copied template after reading
		getDelEmailTempReading(driver, param, test);		
		return readingData;
	} 
	
	public Map<String, String> getDeleteEmailTempReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		getEmailTempCreateNewReading(driver, param, test);
		getSaveEmailTempReading(driver, param, test);
		readingData.put(param.get("Step1"), getDelEmailTempReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getDeleteEmailTempFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		getEmailTempCreateNewReading(driver, param, test);
		getSaveEmailTempReading(driver, param, test);
		switchToListView(driver, param, test);
		readingData.put(param.get("Step1"), getDelEmailTempFromListReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getCopyEmailTemplateReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		readingData.put(param.get("Step1"), getCopyEmailTempReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getCopyEmailTemplateFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		readingData.put(param.get("Step1"), getCopyEmailTempFromListReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getPreviewEmailTemplateReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		readingData.put(param.get("Step1"), getPreviewEmailTempReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getPreviewEmailTemplateFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		getEmailTempPageReading(driver, param, test);
		readingData.put(param.get("Step1"), getPreviewEmailTempFromListReading(driver, param, test));
		return readingData;
	} 
	
	public Map<String, String> getTrackSurveyReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), df.format(goToTrackSurvey(driver, param, param.get("Survey Title"), param.get("SID"),test)));
		selectTrackSurveyChannel(driver, param, test);
		//Clear the previous search
		if(driver.findElement(By.xpath(SEARCH_ICON)).getAttribute("class").contains("active close-search")) {
			click(driver, testcaseName, search_icon, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitForInsideLoad(driver, testcaseName, 30, test);
		}
		readingData.put(param.get("Step2"), getSearchRecordReading(driver, param, param.get("searchRec1"), test));
		readingData.put(param.get("Step3"), getSearchRecordReading(driver, param, param.get("searchRec2"), test));
		
		return readingData;
	} 
	
	public Map<String, String> getTrackSurveyDeleteReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToTrackSurvey(driver, param, param.get("Survey Title"), param.get("SID"),test);
		selectTrackSurveyChannel(driver, param, test);
		readingData.put(param.get("Step1"), getDelRecordReading(driver, param, test));

		return readingData;
	} 
	
	public Map<String, String> getScheduledLaterByFileReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage2(driver, param, param.get("Survey Title"), param.get("SID"), test);
		goToEmailMsgPage(driver, param, test);
		goToEmailAddrSourcePage(driver, param, test);
		goToMailMergePageByFile(driver, param, test);
		goToPrepopPage(driver, param, test);
		goToReviewDataPage(driver, param, test);
		goToSendInvPage(driver, param, test);
		readingData.put(param.get("Step1"), getScheduledReading(driver, param, 1, test));

		return readingData;
	} 
	
	
	public Map<String, String> getScheduledLaterByListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage2(driver, param, param.get("Survey Title"), param.get("SID"), test);
		goToEmailMsgPage(driver, param, test);
		goToEmailAddrSourcePage(driver, param, test);
		selectList(driver, param, test);
		goToMailMergePageByList(driver, param, test);
		goToPrepopPage(driver, param, test);
		goToReviewDataPage(driver, param, test);
		goToSendInvPage(driver, param, test);
		readingData.put(param.get("Step1"), getScheduledReading(driver, param, 1, test));
		return readingData;
	} 
	
	public Map<String, String> getScheduledLaterTypeManuallyReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage2(driver, param, param.get("Survey Title"), param.get("SID"), test);
		goToEmailMsgPage(driver, param, test);
		goToEmailAddrSourcePage(driver, param, test);
		goToMailMergePageByManually(driver, param, test);
		goToPrepopPageByManually(driver, param, test);
		goToReviewDataPageByManually(driver, param, test);
		goToSendInvPage(driver, param, test);
		readingData.put(param.get("Step1"), getScheduledReading(driver, param, 1, test));
		return readingData;
	} 
	
	public Map<String, String> getReminderWizReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage2(driver, param, param.get("copiedSurveyTitle"), param.get("copiedSurveySID"), test);
		goToEmailMsgPage(driver, param, test);
		goToEmailAddrSourcePage(driver, param, test);
		goToMailMergePageByFile(driver, param, test);
		goToPrepopPage(driver, param, test);
		goToReviewDataPage(driver, param, test);
		goToSendInvPage(driver, param, test);
		getScheduledReading(driver, param, 1, test);
		readingData.put(param.get("Step1"), getReminderPageReading(driver, param, test));
		readingData.put(param.get("Step2"), getReminderMessageReading(driver, param, test));
		readingData.put(param.get("Step3"), getSendReminderPageReading(driver, param, test));
		readingData.put(param.get("Step4"), getScheduledReading(driver, param, 2, test));
		getReminderPageReading(driver, param, test);
		getReminderMessageReading2(driver, param, test);
		getSendReminderPageReading(driver, param, test);
		readingData.put(param.get("Step5"), getScheduledReading(driver, param, 3, test));
		getReminderPageReading(driver, param, test);
		getReminderMessageReading3(driver, param, test);
		getSendReminderPageReading(driver, param, test);
		readingData.put(param.get("Step6"), getScheduledReading(driver, param, 4, test));
		getReminderPageReading(driver, param, test);
		delAllReminders(driver, param, test);
		
		return readingData;
	} 
	
	public Map<String, String> getCancelRemindersReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage2(driver, param, param.get("copiedSurveyTitle"), param.get("copiedSurveySID"), test);
		goToEmailMsgPage(driver, param, test);
		goToEmailAddrSourcePage(driver, param, test);
		goToMailMergePageByFile(driver, param, test);
		goToPrepopPage(driver, param, test);
		goToReviewDataPage(driver, param, test);
		goToSendInvPage(driver, param, test);
		getScheduledReading(driver, param, 1, test);
		getReminderPageReading(driver, param, test);
		getReminderMessageReading(driver, param, test);
		getSendReminderPageReading(driver, param, test);
		getScheduledReading(driver, param, 2, test);
		getReminderPageReading(driver, param, test);
		readingData.put(param.get("Step1"), getDelReminderReading(driver, param, test));
			
		return readingData;
	} 
	
	public Map<String, String> getShareOnFbReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage(driver, param, test);
		readingData.put(param.get("Step1"), selectFbChannel(driver, param, test));
		readingData.put(param.get("Step2"), publishOnFbChannel(driver, param, test));
			
		return readingData;
	}
	
	public Map<String, String> getShareOnTwitterReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage(driver, param, test);
		readingData.put(param.get("Step1"), selectTwitterChannel(driver, param, test));
		readingData.put(param.get("Step2"), publishOnTwitterChannel(driver, param, test));
			
		return readingData;
	} 
	
	public Map<String, String> getShareOnLinkedInReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage(driver, param, test);
		readingData.put(param.get("Step1"), selectLinkedInChannel(driver, param, test));
		readingData.put(param.get("Step2"), publishOnLinkedInChannel(driver, param, test));
			
		return readingData;
	} 
	
	public Map<String, String> getSMSInvReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDistributePage(driver, param, test);
		readingData.put(param.get("Step1"), goToSMSInvSource(driver, param, test));
		readingData.put(param.get("Step2"), goToPrepopSMSWiz(driver, param, test));
		readingData.put(param.get("Step3"), goToReviewDataPageByManually(driver, param, test));
		readingData.put(param.get("Step4"), goToCustomizeSMSWiz(driver, param, test));
		readingData.put(param.get("Step5"), openSMSPreview(driver, param, test));
		readingData.put(param.get("Step6"), sendSMSInv(driver, param, test));
			
		return readingData;
	} 
	
	/**
	 * Capture the quick send reading
	 * @param driver
	 * @param param
	 * @param test
	 * @return 
	 * @return
	 * @throws InterruptedException
	 */
	public  Map<String, String> getQuickSendReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		
		goToDistributePage(driver, param, test);
		click(driver, testcaseName, quick_send, test);
		waitforElemPresent(driver, testcaseName, 30, quick_send_left_pannel_title, test);
		click(driver, testcaseName, quick_send_single_use_channel, test);
		
		//Method 5 : Using nfo and stream api - Taking around 179 secs
		start = System.currentTimeMillis();
		try {
			Files.lines(Paths.get((System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\") + param.get("file")))
			.forEach(str -> setText(driver, testcaseName, enter_emailids, str.concat("\n"), test));
		} catch (IOException e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Add_Log.info("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Reporter.log("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.failureReason.add(testcaseName + "| Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") +
					"\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		end = System.currentTimeMillis();
		System.out.println("Time taken for add email id manually is " + df.format(((end - start)) / 1000));
		
		selectByVisibleText(driver, testcaseName, quick_send_email_lang, param.get("emailLang"), test);
		selectByVisibleText(driver, testcaseName, quick_send_email_msg, param.get("emailtemplate"), test);
		
		scrollIntoCenter(driver, testcaseName, quick_send_now_btn, test);
		waitforElemPresent(driver, testcaseName, 30, quick_send_now_btn, test);
		click(driver, testcaseName, quick_send_now_btn, test);
		
		//Start taking reading once js alert is accepted
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		readingData.put(param.get("Step1"), strtotalTime);
		
		return readingData;
	}
	
	
	/**
	 * Navigate to Email template page via Single use link channe
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToEmailMsgPage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, single_use_link_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, single_use_link_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	
	/**
	 * Navigate to Select Source Page by selecting email template given in an excel
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToEmailAddrSourcePage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, search_email, test);

		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("emailtemplate") + "']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"(//div[@title = '" + param.get("emailtemplate") + "']//following::div[@class='middle-content'])[1]"),
				param.get("emailtemplate"), test);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(
				"(//div[@title = '" + param.get("emailtemplate") + "']//following::div[@class='middle-content'])[1]")))
				.build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30,
				By.xpath("(//div[@title = '" + param.get("emailtemplate") + "']//following::span[text()='Edit '])[1]"),
				param.get("emailtemplate") + " Edit", test);

		start = System.currentTimeMillis();
		click(driver, testcaseName,
				By.xpath("//div[@class='layer-quick-view']//div[contains(@id,'selectET')][contains(@onclick,'" + param.get("emailtemplate") + "')]"),
				param.get("emailtemplate") + " Select", test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, source_email, test);
		end = System.currentTimeMillis();

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Select contact list given in an excel on Select Source Page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String selectList(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, from_a_list, test);
		click(driver, testcaseName, from_a_list, test);
		waitforElemPresent(driver, testcaseName, 30, select_list, test);

		start = System.currentTimeMillis();
		selectByVisibleText(driver, testcaseName, select_list, param.get("selectlist"), test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, select_sample_size, test);
		end = System.currentTimeMillis();

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Navigate Mail merge page if list is selected as source type
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToMailMergePageByList(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, invite_in_seperate_email, test);
		click(driver, testcaseName, invite_in_seperate_email, test);
		waitForLoad(driver, testcaseName, 30, test);
		if (driver.findElement(By.xpath(PRE_POP_SURVEY_INPUT)).getAttribute("disabled") == null) {
			if (!(driver.findElement(By.xpath(PRE_POP_SURVEY_INPUT)).isSelected())) {
				waitforElemPresent(driver, testcaseName, 30, pre_pop_survey, test);
				click(driver, testcaseName, pre_pop_survey, test);
			}
		}
		if (driver.findElement(By.xpath(TOUCH_RULE_INPUT)).isSelected()) {
			waitforElemPresent(driver, testcaseName, 30, touch_rules, test);
			click(driver, testcaseName, touch_rules, test);
		}
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, mail_merge, test);
		end = System.currentTimeMillis();

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Navigate to prepop page selecting mail merge values given in excel
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToPrepopPage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		boolean isValueSelected = false;
		String[] mailMergeText = getMailMergeVariables(driver, param, test);
		List<WebElement> listAttr = getWebElements(driver, testcaseName, list_attributes, test);
		//Get mail merge variable used in email content and based on that select the drop down values. 
		//If value is not found, then select None.
		for(int i=0; i<mailMergeText.length; i++) {
			Select select = new Select(listAttr.get(i));
			List<WebElement> listOfOptions = select.getOptions();
			String selValue = null;
			for (WebElement option : listOfOptions) {
				String optionText = Jsoup.parse(option.getAttribute("innerHTML")).text();
				if (optionText.contains(mailMergeText[i])) {
					selValue = option.getAttribute("value");
					select.selectByValue(selValue);
					isValueSelected = true;
					Add_Log.info("Successfully selected option containing text "+mailMergeText[i]);
					test.log(Status.INFO, "Successfully selected option containing text "+mailMergeText[i]);
					Reporter.log("Successfully selected option containing text "+mailMergeText[i]);
					break;
				}
			}
			if(isValueSelected == false) {
				select.selectByVisibleText("None");
				Add_Log.info("Mail merge attribute is not found list attribute. Hence, selecting None value");
				test.log(Status.INFO, "Mail merge attribute is not found list attribute. Hence, selecting None value");
				Reporter.log("Mail merge attribute is not found list attribute. Hence, selecting None value");
			}
		}
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		end = System.currentTimeMillis();

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Save all mail merge variables from mail merge page in a list
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String[] getMailMergeVariables(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		List<WebElement> mailMergeElements = getWebElements(driver, testcaseName, mail_merge_used, test);
		String mailMergeText[] = new String[mailMergeElements.size()];
		for(int i=0; i<mailMergeElements.size(); i++) {
			mailMergeText[i] = Jsoup.parse(mailMergeElements.get(i).getAttribute("innerHTML")).text();
		}
		return mailMergeText;
	}
	
	/**
	 * Navigate to Review Data page by using mismatch in prepop values
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToReviewDataPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, pre_pop_dd3, test);
		String prepopdd[] = param.get("prepopdd").split("/~/");
		
		List<WebElement> prepopDowns = getWebElements(driver, testcaseName, pre_pop_dd3, test);
		
		//Select pre-pop drop down values based on data given in excel
		for(int i=0; i<prepopdd.length; i++) {
			selectByVisibleText(driver, testcaseName, prepopDowns.get(i), prepopdd[i], test);
		}
		
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, data_mismatch_text, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Navigate to Send Invitation wizard
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToSendInvPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, send_now_inv, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Send invitation by clicking on Send Now button
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String sendInvitations(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, send_now, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, send_now, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	/**
	 * Use this method to navigate to mail merge step from email source page when email source is used as 'file'
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToMailMergePageByFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, import_from_file3, test);
		waitforElemPresent(driver, testcaseName, 30, choose_file, test);
		driver.findElement(By.xpath(BROWSE_BUTTON1)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		//Make file name to lower case and replace all whitespace by '_' to match with platform file name
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//b[text()='"+ param.get("file") +"']"), param.get("file"), test);
		click(driver, testcaseName, header_switch,test);
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		try {
			if(driver.findElement(By.xpath(DUPLICATE_MODAL)).isDisplayed()) {
				start = System.currentTimeMillis();
				click(driver, testcaseName, send_unique, test);
			}
		}catch(NoSuchElementException e) {
			//If list contains all unique ids and hence caution modal will not appear.
		}finally {
			waitforElemPresent(driver, testcaseName, 30, mail_merge, test);
			end = System.currentTimeMillis();
			
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		return strtotalTime;
	}
	

	
	/**
	 * Use this method to navigate to Mail merge step from email source page when email souces is used as 'Manually Type'
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToMailMergePageByManually(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, enter_emailids, test);
		try {
			/**************************************  Performance improvement  ****************************************************
			 
			File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\"
					+ param.get("file"));
			
			// Method 1 - Using apache POI common IO library - Taking time
			 String fileContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			
			// Method 2 - Using nio.file - Taking time
			String fileContent = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\"
					+ param.get("file"))), StandardCharsets.UTF_8);
			
			//Method 3 - Scanner - Taking time
			Scanner scanner = new Scanner(file);
			String fileContent = "";
			while (scanner.hasNextLine()) {
				fileContent = fileContent.concat(scanner.nextLine() + "\n");
			}
			scanner.close();
			setText(driver, testcaseName, enter_emailids, fileContent, test);
			
			//Method 4: took around 160-170 secs
			start = System.currentTimeMillis();
			List<String> fileContent = Files.lines(Paths.get((System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\") + param.get("file"))).collect(Collectors.toList());
			
			System.out.println(fileContent);
			String str = fileContent.toString().replace("[", "").replace("]", "").replace(" ", "");
			System.out.println(str);
			for(String token : Splitter.fixedLength(1500).split(str)) {
				if(!token.isEmpty()) {
					setText(driver, testcaseName, enter_emailids, token, test);
				}
			}
			end = System.currentTimeMillis();
			System.out.println("Time taken for add email id manually is " + df.format(((end - start)) / 1000));
			
			***********************************************************************************************************************
			*/
			
			//Method 5 : Using nfo and stream api - Taking around 179 secs
			start = System.currentTimeMillis();
			Files.lines(Paths.get((System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\") + param.get("file")))
			.forEach(str -> setText(driver, testcaseName, enter_emailids, str.concat("\n"), test));
			end = System.currentTimeMillis();
			System.out.println("Time taken for add email id manually is " + df.format(((end - start)) / 1000));
			

			
		}catch (Exception e) {
			test.log(Status.FAIL, "Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Add_Log.info("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Reporter.log("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.failureReason.add(testcaseName + "| Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") +
					"\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, mail_merge, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Use this method to navigate to Pre-pop step when email source  is used as 'Manually Type'
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToPrepopPageByManually(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		end = System.currentTimeMillis();

		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Use this method to navigate to Pre-pop Review Data step when email source  is used as 'Manually Type'
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToReviewDataPageByManually(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
				
		scrollIntoCenter(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitforElemPresent(driver, testcaseName, 30, blank_data_text, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	
	/**
	 * Navigate to contact list page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToContactListPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
	
		start = System.currentTimeMillis();
		goToContactList(driver, param, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Navigate to Contact list creation source page by clicking on Create New button
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToListSourcePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, create_new, test);
		waitforElemPresent(driver, testcaseName, 30, create_new_list, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, create_new_list, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, list_name, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	/**
	 * Navigate to mapping page by selecting file as list creation source
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String goToMappingPageByFile(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		enterListName2(driver, param, test);
		click(driver, testcaseName, import_from_file, test);
		waitforElemPresent(driver, testcaseName, 30, browse_button1_opt, test);
		driver.findElement(By.xpath(BROWSE_BUTTON1)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[text()='"+ param.get("file") +"']"), param.get("file"), test);
		scrollIntoCenter(driver, testcaseName, header_switch3, test);
		click(driver, testcaseName, header_switch3,test);

		start = System.currentTimeMillis();
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, map_fields, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	public void enterListName2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, list_name, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		setText(driver, testcaseName, list_name, "List - "+strDate, test);
		param.put("listname", "List - "+strDate);
	}
	
	public String createListByMappingValues(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		String[] fields = param.get("mapValues").split("/~/");
		List<WebElement> allMapValues = getWebElements(driver, testcaseName, all_map_fields, test);
		
		// Fail the testcase if map values given excel is not matching with map value fields
		if(allMapValues.size() != fields.length) {
			test.log(Status.FAIL, "Number of mapping fields are not same as mapping values provided in excel.");
			Add_Log.info("Number of mapping fields are not same as mapping values provided in excel.");
			Reporter.log("Number of mapping fields are not same as mapping values provided in excel.");
			TestResultStatus.failureReason.add(testcaseName + "| Number of mapping fields are not same as mapping values provided in excel.");
			TestResultStatus.TestFail = true;
			Assert.fail();
			return null;
		}else {
			//Run a loop for map field and enter text given in excel
			for (int i = 0; i<allMapValues.size(); i++) {
				clearText(driver, testcaseName, allMapValues.get(i), "Map field "+i, test);
				Thread.sleep(1000);
				setText(driver, testcaseName, allMapValues.get(i), fields[i], "Map field "+i, test);
			}			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='"+ param.get("emailaddcol") +"'][@type='text']"), param.get("emailaddcol"), test);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//input[@value='"+ param.get("emailaddcol") +"'][@type='text']"))).build().perform();
			click(driver, testcaseName, By.xpath("(//div[@class='lock-icon'])[1]"), "Lock Icon", test);

			start = System.currentTimeMillis();
			click(driver, testcaseName, done_button2, test);
			waitForLoad(driver, testcaseName, 30, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//span[text()='Your list has been created!']"), "Success Msg", 30, 200, test);
			waitforElemPresent(driver, testcaseName, 30, search_list, test);
			end = System.currentTimeMillis();
			
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			return strtotalTime;

		}
	}
	
	public String getdeleteContactListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		setText(driver, testcaseName, search_list, param.get("listname"), test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.findElement(By.xpath(SEARCH_LIST)).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[text()='"+ param.get("listname") +"']"), param.get("listname"), test);
		click(driver, testcaseName, By.xpath("//td[text()='"+ param.get("listname") +"']"), param.get("listname"), test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, delete_button, test);		
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, delete_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		//driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, delete_msg, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	

	public String getSAPDashboardReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, survey_passwords, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, generate_new_url_btn, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSAPPageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, generate_new_url_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, single_use_pwd2, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSAPPrepopReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, single_use_pwd2, test);
		click(driver, testcaseName, use_existing_list, test);
		scrollIntoCenter(driver, testcaseName, select_list2, test);
		selectByVisibleText(driver, testcaseName, select_list2, param.get("selectlist"), test);
		
		if(!getWebElement(driver, testcaseName, pre_pop_checkbox, test).isSelected()){
			click(driver, testcaseName, pre_pop_checkbox, test);
		}
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getTempSelReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		String[] fields = param.get("prepopdd").split("/~/");
		List<WebElement> allPrepopDD = getWebElements(driver, testcaseName, all_prepop_DD, test);
		
		// Fail the testcase if prepop values given excel is not matching with prepop fields
		if(allPrepopDD.size() != fields.length) {
			test.log(Status.FAIL, "Number of Prepop fields are not same as prepop values provided in excel.");
			Add_Log.info("Number of Prepop fields are not same as prepop values provided in excel.");
			Reporter.log("Number of Prepop fields are not same as prepop values provided in excel.");
			TestResultStatus.failureReason.add(testcaseName + "| Number of Prepop fields are not same as prepop values provided in excel.");
			TestResultStatus.TestFail = true;
			Assert.fail();
			return null;
		}else {
			for(int i=0; i<allPrepopDD.size(); i++) {
				scrollIntoCenter(driver, testcaseName, allPrepopDD.get(i), "Prepop dd "+i, test);
				selectByVisibleText(driver, testcaseName, allPrepopDD.get(i), fields[i], test);
			}
		}
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, no_of_passwords, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public String getEmailTempPageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, email_template, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, create_new_message, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getEmailTempCreateNewReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, create_new_message, test);
		waitforElemPresent(driver, testcaseName, 30, create_new_message_title, test);
		

		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		//Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("emailtemplate") + "']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']//following-sibling::div[contains(text(),'Select')]"),
				param.get("emailtemplate"), test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']//following-sibling::div[contains(text(),'Select')]"),
				param.get("emailtemplate"), test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, iframe_edit_template, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_EDIT_TEMPLATE)));
		waitforElemPresent(driver, testcaseName, 30, preview_email, test);
		waitforElemPresent(driver, testcaseName, 30, sender_name_label, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSaveEmailTempReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, done_button, test);
		waitforElemPresent(driver, testcaseName, 30, template_name_tb, test);
		clearText(driver, testcaseName, template_name_tb, test);
		param.put("savedTemplate", "Template -"+timeStamp());
		setText(driver, testcaseName, template_name_tb, param.get("savedTemplate"), test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("savedTemplate") + "']"),
				param.get("savedTemplate"), test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String timeStamp(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		return strDate;
	}
	

	
	public String getDelEmailTempReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"//div[@title='" +param.get("savedTemplate") +"']//following-sibling::div[@class='middle-content']"),
				param.get("savedTemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(
				"//div[@title='" +param.get("savedTemplate") +"']//following-sibling::div[@class='middle-content']"))).build().perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//div[@title='" +param.get("savedTemplate") +"']//following-sibling::div[@class='bottom-content']//following-sibling::li[@title='Quick Look']"),
				param.get("savedTemplate") +" Quick look icon", test);
		click(driver, testcaseName, By.xpath(
				"//div[@title='" +param.get("savedTemplate") +"']//following-sibling::div[@class='bottom-content']//following-sibling::li[@title='Quick Look']"),
				param.get("savedTemplate") +" Quick look icon", test);
		waitforElemPresent(driver, testcaseName, 30, quick_look_modal_header, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_preview_template, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_PREVIEW_TEMPLATE)));
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, warn_text, test);
		driver.switchTo().defaultContent();
		click(driver, testcaseName, delete_template, test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		//waitforElemPresent(driver, testcaseName, 30, delete_toaster_msg, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public void switchToListView(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, switch_view, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, mail_merge_col_header, test);
	}
	
	public String getDelEmailTempFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//span[text()='" + param.get("savedTemplate") +"']"), param.get("savedTemplate"), test);
		scrollIntoCenter(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("savedTemplate") +"']"), param.get("savedTemplate"), test);
		click(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("savedTemplate") +"']//parent::div//parent::div//parent::td//parent::tr"), param.get("savedTemplate") +" Row", test);
		waitforElemPresent(driver, testcaseName, 30, quick_look_button, test);
		click(driver, testcaseName, delete_temp_button, test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		//waitforElemPresent(driver, testcaseName, 30, delete_toaster_msg, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
		
	}
	

	
	public String getCopyEmailTempReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		//Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("emailtemplate") + "']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']"),
				param.get("emailtemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']"))).build().perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']/following-sibling::div[@class='bottom-content']/ul/li[@title='Copy Message']"), 
				"Copy icon of" +param.get("emailtemplate") +" template", test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']/following-sibling::div[@class='bottom-content']/ul/li[@title='Copy Message']"), 
				"Copy icon of" +param.get("emailtemplate") +" template", test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, copy_tooltip, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		//Delete copied template after reading
		param.put("savedTemplate", driver.findElement(By.xpath(COPIED_TEMPLATE_HEADER)).getAttribute("title"));
		getDelEmailTempReading(driver, param, test);
		
		return strtotalTime;
	}
	

	

	
	public String getCopyEmailTempFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, switch_view, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, mail_merge_col_header, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		scrollIntoCenter(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		click(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']//parent::div//parent::div//parent::td//parent::tr"), param.get("emailtemplate") +" Row", test);
		waitforElemPresent(driver, testcaseName, 30, copy_button, test);
		
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, copy_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, copy_tooltip_for_list, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		//Delete copied template after reading
		param.put("savedTemplate", driver.findElement(By.xpath(COPIED_TEMPLATE_HEADER_FOR_LISTVIEW)).getAttribute("innerHTML"));
		getDelEmailTempFromListReading(driver, param, test);
		
		return strtotalTime;
	}
	

	
	public String getPreviewEmailTempReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		//Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("emailtemplate") + "']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']"),
				param.get("emailtemplate"), test);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='middle-content']"))).build().perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='bottom-content']//following-sibling::li[@title='Quick Look']"),
				param.get("emailtemplate"), test);
		click(driver, testcaseName, By.xpath(
				"//div[@title='" +param.get("emailtemplate") +"']//following-sibling::div[@class='bottom-content']//following-sibling::li[@title='Quick Look']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 30, quick_look_modal_header, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_preview_template, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_PREVIEW_TEMPLATE)));
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, warn_text, test);
		driver.switchTo().defaultContent();
		
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();
		
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, preview_template, test);
		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		waitforElemPresent(driver, testcaseName, 30, warn_text, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public String getPreviewEmailTempFromListReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, switch_view, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, mail_merge_col_header, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		scrollIntoCenter(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']"), param.get("emailtemplate"), test);
		click(driver, testcaseName, By.xpath(
				"//span[text()='" + param.get("emailtemplate") +"']//parent::div//parent::div//parent::td//parent::tr"), 
				param.get("emailtemplate") +" Row", test);
		waitforElemPresent(driver, testcaseName, 30, quick_look_button, test);
		scrollIntoCenter(driver, testcaseName, quick_look_button, test);
		click(driver, testcaseName, quick_look_button, test);
		waitforElemPresent(driver, testcaseName, 30, quick_look_modal_header, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_preview_template, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_PREVIEW_TEMPLATE)));
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, warn_text, test);
		driver.switchTo().defaultContent();
		
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();
				
		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, preview_template, test);
		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
		waitforElemPresent(driver, testcaseName, 30, warn_text, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public String getSearchRecordReading(WebDriver driver, HashMap<String, String> param, String searchRec, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
	
		waitforElemPresent(driver, testcaseName, 30, search_field, test);
		setText(driver, testcaseName, search_field, searchRec, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, search_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		if(param.get("channel").equalsIgnoreCase("Single Use Link")) {
			if(getWebElements(driver, testcaseName, email_field, test).size()>0) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath(
						"//span[@class='ts-email-addr'][contains(text(),'" +searchRec +"')]"), searchRec, test);
				end = System.currentTimeMillis();
			}else {
				scrollIntoCenter(driver, testcaseName, no_record_found, test);
				waitforElemPresent(driver, testcaseName, 30, no_record_found, test);
				end = System.currentTimeMillis();
			}
		}
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		//Clear search record after reading
		click(driver, testcaseName, search_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitForInsideLoad(driver, testcaseName, 30, test);
		
		return strtotalTime;
	}
	
	public void selectTrackSurveyChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
			click(driver, testcaseName, selected_channel, test);
			waitforElemPresent(driver, testcaseName, 30, channel_menu, test);
			if(param.get("channel").equalsIgnoreCase("Single Use Link")) {
				click(driver, testcaseName, single_use_link_channel, test);
				waitForLoad(driver, testcaseName, 30, test);
				waitForInsideLoad(driver, testcaseName, 30, test);
				try {
					waitForJStoLoad(driver, 30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(param.get("channel").equalsIgnoreCase("Multi Use Link")) {
				click(driver, testcaseName, multi_use_link_channel, test);
				waitForLoad(driver, testcaseName, 30, test);
				waitForInsideLoad(driver, testcaseName, 30, test);
				try {
					waitForJStoLoad(driver, 30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(param.get("channel").equalsIgnoreCase("Survey Passwords")) {
				click(driver, testcaseName, survey_password_channel, test);
				waitForLoad(driver, testcaseName, 30, test);
				waitForInsideLoad(driver, testcaseName, 30, test);
				try {
					waitForJStoLoad(driver, 30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(param.get("channel").equalsIgnoreCase("SMS Invites")) {
				click(driver, testcaseName, sms_invites_channel, test);
				waitForLoad(driver, testcaseName, 30, test);
				waitForInsideLoad(driver, testcaseName, 30, test);
				try {
					waitForJStoLoad(driver, 30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				test.log(Status.FAIL, param.get("channel") + " is not present track survey drop down");
				Add_Log.info(param.get("channel") + " is not present track survey drop down");
				Reporter.log(param.get("channel") + " is not present track survey drop down");
				TestResultStatus.failureReason.add(testcaseName +"| "+ param.get("channel") + " is not present track survey drop down");
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
	}
	

	
	public String getDelRecordReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String strInvSentCount = null; 
		int invSentCountBefore, invSentCountAfter, delCount;
		
		strInvSentCount = driver.findElement(By.xpath(INVITATION_SENT_COUNT)).getAttribute("innerHTML");
		invSentCountBefore = Integer.parseInt(strInvSentCount);
		
		click(driver, testcaseName, check_all, test);
		waitforElemPresent(driver, testcaseName, 30, delete_btn, test);
		click(driver, testcaseName, delete_btn, test);
		waitforElemPresent(driver, testcaseName, 30, okay_btn, test);
		click(driver, testcaseName, okay_btn, test);
		waitforElemPresent(driver, testcaseName, 30, delete_text_box, test);
		setText(driver, testcaseName, delete_text_box, param.get("delText"), test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, delete_btn_pop, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitForInsideLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, search_field, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		strInvSentCount = driver.findElement(By.xpath(INVITATION_SENT_COUNT)).getAttribute("innerHTML");
		invSentCountAfter = Integer.parseInt(strInvSentCount);
		delCount = invSentCountBefore - invSentCountAfter;
		
		test.log(Status.INFO, "Successfully deleted " +delCount +" records from Track survey");
		Add_Log.info("Successfully deleted " +delCount +" records from Track survey");
		Reporter.log("Successfully deleted " +delCount +" records from Track survey");
		
		return strtotalTime;
	}
	

	
	public String getScheduledReading(WebDriver driver, HashMap<String, String> param, int noOfDays, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String strDate = null;
		Date newDate = null;
		
		click(driver, testcaseName, scheduled_for_later, test);
		waitforElemPresent(driver, testcaseName, 30, invitation_date, test);
		strDate = driver.findElement(By.xpath(INVITATION_DATE)).getAttribute("value");
		SimpleDateFormat sdf = new SimpleDateFormat(param.get("dateFormat"));
		try {
			newDate = DateUtils.addDays(sdf.parse(strDate), noOfDays);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		clearText(driver, testcaseName, invitation_date, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, invitation_date, sdf.format(newDate), test);
		scrollIntoCenter(driver, testcaseName, scheduled_delivery, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, scheduled_delivery, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	

	
	public String getReminderPageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, reminders2, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, reminders2, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, reminder_history_bar, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	
	/**
	 * This method will select all invites and then navigate to email message page by clicking on 'Send/Scheduled All Reminders' button
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReminderMessageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, By.xpath(SEND_REMINDERS_TO_ALL), driver.findElement(By.xpath(SEND_REMINDERS_TO_ALL)).getAttribute("value"), test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	
	/**
	 * This method will select all invites from first page and then navigate to email message page by clicking on 'Send/Scheduled Selected Reminders' button
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReminderMessageReading2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_reminders_cb, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath(SEND_REMINDERS), driver.findElement(By.xpath(SEND_REMINDERS)).getAttribute("value"), test);
		click(driver, testcaseName, By.xpath(SEND_REMINDERS), driver.findElement(By.xpath(SEND_REMINDERS)).getAttribute("value"), test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	
	public String getReminderMessageReading3(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		for(int i=1; i<=Integer.parseInt(param.get("pages")); i++){
			Select select = new Select(driver.findElement(By.xpath(REMINDER_PAGE_DD)));
			select.selectByValue(String.valueOf(i));
			selectRemindersIndividually(driver, param, test);
			
		}
		waitforElemPresent(driver, testcaseName, 30, By.xpath(SEND_REMINDERS), driver.findElement(By.xpath(SEND_REMINDERS)).getAttribute("value"), test);
		click(driver, testcaseName, By.xpath(SEND_REMINDERS), driver.findElement(By.xpath(SEND_REMINDERS)).getAttribute("value"), test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 10, search_email, test);

		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	
	public void selectRemindersIndividually(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		List<WebElement> checkBoxes = driver.findElements(By.xpath(REMINDER_CHECK_BOX));
		checkBoxes.remove(0); //Remove Select All Check Box element from list
		for(int i=0; i<Integer.parseInt(param.get("count")); i++){
			scrollIntoCenter(driver, testcaseName, checkBoxes.get(i), "Record "+(i+1), test);
			click(driver, testcaseName, checkBoxes.get(i), "Record "+(i+1), test);
		}
	}
	
	public String getSendReminderPageReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, search_email, test);

		setText(driver, testcaseName, search_email, param.get("emailtemplate"), test);
		Thread.sleep(2000);
		driver.findElement(By.xpath(SEARCH_EMAIL)).sendKeys(Keys.RETURN);
		waitForLoadAttach(driver, testcaseName, 60, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@title = '" + param.get("emailtemplate") + "']"),
				param.get("emailtemplate"), test);
		waitforElemPresent(driver, testcaseName, 60, By.xpath(
				"(//div[@title = '" + param.get("emailtemplate") + "']//following::div[@class='middle-content'])[1]"),
				param.get("emailtemplate"), test);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(
				"(//div[@title = '" + param.get("emailtemplate") + "']//following::div[@class='middle-content'])[1]")))
				.build().perform();
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30,
				By.xpath("(//div[@title = '" + param.get("emailtemplate") + "']//following::span[text()='Edit '])[1]"),
				param.get("emailtemplate") + " Edit", test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName,
				By.xpath("//div[@class='layer-quick-view']//div[contains(@id,'selectET')][contains(@onclick,'" + param.get("emailtemplate") + "')]"),
				param.get("emailtemplate") + " Select", test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, scheduled_for_later, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;	
	}
	
	public void delAllReminders(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, reminder_history_bar, test);
		int totCancelBtn = driver.findElements(By.xpath(CANCEL_REMINDERS)).size();
		if(totCancelBtn > 0) {
			waitforElemPresent(driver, testcaseName, 30, cancel_reminders, test);	
			for (int i=0; i<totCancelBtn; i++) {
				waitforElemPresent(driver, testcaseName, 30, getWebElements(driver, testcaseName, cancel_reminders, test).get(0), "Cancel Reminders", test);
				click(driver, testcaseName, getWebElements(driver, testcaseName, cancel_reminders, test).get(0), "Cancel Reminders", test);
				driver.switchTo().alert().accept();
				waitForLoad(driver, testcaseName, 30, test);
				waitforElemPresent(driver, testcaseName, 30, reminder_history_bar, test);
				click(driver, testcaseName, reminder_history_bar, test);
			}
		}else {
			Add_Log.info("No reminders found to be deleted in survey");
			test.log(Status.INFO, "No reminders found to be deleted in survey.");
			Reporter.log("No reminders found to be deleted in survey.");
		}
	}
	
	/**
	 * This method will delete first reminders which are scheduled
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getDelReminderReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, reminder_history_bar, test);
		waitforElemPresent(driver, testcaseName, 30, getWebElements(driver, testcaseName, cancel_reminders, test).get(0), "Cancel Reminders", test);
		click(driver, testcaseName, getWebElements(driver, testcaseName, cancel_reminders, test).get(0), "Cancel Reminders", test); //Delete first reminders which are scheduled
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, reminder_history_bar, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
 
	/**
	 * Select participation by FB channel on publish page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String selectFbChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, facebook, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, facebook, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, fb_wizard_header_1, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Publish the survey on FB channel
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String publishOnFbChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, fb_publish_btn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, fb_publish_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public String selectTwitterChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, facebook, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, twitter, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, twitter_wizard_header_1, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String publishOnTwitterChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, twitter_publish_btn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, twitter_publish_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	

	
	public String selectLinkedInChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, facebook, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, linkedin, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, linkedin_wizard_header_1, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String publishOnLinkedInChannel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, linkedin_publish_btn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, linkedin_publish_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	
	public String goToSMSInvSource(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, sms_invitation, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, sms_invitation, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, type_manually_icon, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToPrepopSMSWiz(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		try {
			Files.lines(Paths.get((System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\") + param.get("file")))
			.forEach(str -> setText(driver, testcaseName, enter_mobile, str.concat("\n"), test));
		} catch (IOException e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Add_Log.info("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			Reporter.log("Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.failureReason.add(testcaseName + "| Unable to find file " + param.get("file") +"at " + System.getProperty("user.dir") +
					"\\src\\main\\resources\\excelfiles\\uploadfiles\\");
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		if(!getWebElement(driver, testcaseName, pre_pop_checkbox, test).isSelected()){
			click(driver, testcaseName, pre_pop_checkbox, test);
		}
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, map_answers, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToCustomizeSMSWiz(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, modify_message, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String openSMSPreview(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, sms_preview_link, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, sms_preview_link, test);
		waitforElemPresent(driver, testcaseName, 30, sms_inv_preview, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		//Close the preview pannel after readings
		click(driver, testcaseName, sms_inv_preview_close, test);
		waitforElemNotVisible(driver, testcaseName, 30, sms_inv_preview, test);
		
		return strtotalTime;
	}
	
	public String sendSMSInv(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, done_editing_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, done_editing_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, track_survey, test);
		end = System.currentTimeMillis();
		
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}

}
