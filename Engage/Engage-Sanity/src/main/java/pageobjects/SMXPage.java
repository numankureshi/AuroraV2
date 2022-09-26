package pageobjects;


import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.mail.Message;

import java.util.Set;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.message.BasicListHeaderIterator;
import org.apache.poi.util.ArrayUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.time.CalendarUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.network.Network;
import org.openqa.selenium.devtools.v100.network.model.RequestId;
import org.openqa.selenium.devtools.v100.performance.Performance;
import org.openqa.selenium.devtools.v100.performance.model.Metric;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import property.IHomePage;
import property.ISMXPage;
import testsuitebase.TestResultStatus;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.WebPageElements;

public class SMXPage extends SeleniumUtils implements ISMXPage {
	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	boolean isFirstQDL = true;
	boolean isAnswerQuotaApplied = true;
	
	public void createSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		createNewSurvey(driver, param, test);
		enterDescription(driver, param, test);

		enterNetPromoter(driver, param, test);
		enterTextBox(driver, param, test);
		enterRadioButton(driver, param, test);
		enterCheckBoxButton(driver, param, test);
		enterDropDownButton(driver, param, test);
		enterDemographicsButton(driver, param, test);
		enterRatingScaleButton(driver, param, test);
		enterSymbolRatingScaleButton(driver, param, test);
		enterLikeDislikeButton(driver, param, test);
		enterRankingQuestionButton(driver, param, test);
		enterDateButton(driver, param, test);

		enterImageChoiceButton(driver, param, test);
		enterMultipleTextBoxButton(driver, param, test);
		enterMultiDropDownButton(driver, param, test);
		enterRadioGridButton(driver, param, test);
		enterCheckBoxGridButton(driver, param, test);
		enterRatingRadioGridButton(driver, param, test);
		enterRatingDropDownGridButton(driver, param, test);

		enterRatingScaleGridButton(driver, param, test);
		enterMatrixGridButton(driver, param, test);
		enterHorizontalRadioButton(driver, param, test);
		enterAttachmentButton(driver, param, test);
		enterRatingRadioButton(driver, param, test);
		enterRatingDropDownButton(driver, param, test);
		enterListBoxButton(driver, param, test);
		scrollIntoCenter(driver, testcaseName, captcha_button, test);
		waitforElemPresent(driver, testcaseName, 10, captcha_button, test);
		PMR(driver, param, test);
		textTranslation(driver, param, test);
	}
	
	public void OpenFileLibrary(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");		
		waitforElemPresent(driver, testcaseName, 30, utilities, test);
		click(driver, testcaseName, utilities, test);
		waitforElemPresent(driver, testcaseName, 30, file_library, test);
		click(driver, testcaseName, file_library, test);
		waitforElemPresent(driver, testcaseName, 30, add_new_file, test);
		//click(driver, testcaseName, add_new_file, test);
		Thread.sleep(2000);
	}
	
	public void Upload_mp4file(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		////TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "mp4.mp4";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_mp4, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_mp3file(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		////TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "mp3.mp3";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_mp3, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_csvfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		////TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "csv.csv";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_csv, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}

	public void Upload_xhtmlfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		////TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "xhtml.xhtml";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_xhtml, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_htmlfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		////TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "html.html";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_html, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_htmfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "htm.htm";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_htm, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_pngfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "png.png";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_png, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_giffile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "gif.gif";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_gif, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_bmpfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "bmp.bmp";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_bmp, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_jpegfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "jpeg.jpeg";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_jpeg, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_jpgfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "jpg.jpg";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_jpg, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_swffile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "swf.swf";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_swf, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_mpgfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "mpg.mpg";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_mpg, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		DeletePreviousDownloadedFile(driver, param, test);
		Thread.sleep(5000);
	}
	
	public void Upload_xmlfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "xml.xml";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_xml, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_rtffile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "rtf.rtf";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_rtf, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_txtfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "txt.txt";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_txt, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_pdffile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "pdf.pdf";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_pdf, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_ppsfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "pps.pps";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_pps, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_pptxfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
	
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);	
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "pptx.pptx";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_pptx, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_pptfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
			
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		
		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "ppt.ppt";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_ppt, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
  
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_docxfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		
		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "docxfile.docx";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }	
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_docx, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_docfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);		
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		
		
		String actualfile = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expectedfile = "docfile.doc";
		Assert.assertEquals(actualfile, expectedfile, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_doc, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_xlsxfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		
		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "smsnumber.xlsx";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_xlsx, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}
	
	public void Upload_xlsfile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date currentTime = Calendar.getInstance().getTime();
		System.out.println(dateFormat.format(currentTime.getTime()));
		//TimeUnit.MINUTES.sleep(1);
		
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		
		if (dynamicElement.size() != 0){      
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
			waitforElemPresent(driver, testcaseName, 30, delete_file, test);
			click(driver, testcaseName, delete_file, test);
			waitforAlert(driver, testcaseName, 30, test);
			driver.switchTo().alert().accept();
        }
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(BROWSE_BUTTON2)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("secondarylanguage") +"");
				
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		
		
		String actual = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]")).getAttribute("innerHTML");
		String expected = "sogo_data_import_file.xls";
		Assert.assertEquals(actual, expected, "Alert message is not matching with expected alert");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]"), param.get("account_id"), test);			
		String actualuser = driver.findElement(By.xpath("//tr[@id='2']//span[contains(text(),'"+ param.get("account_id") +"')]")).getAttribute("innerHTML");
		
		if(driver.getCurrentUrl().contains("https://www.sogolytics.com/zUM/FileManager.aspx")) {
			String expecteduser = "sogo_abhandi";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert"); 
		}		
		else if(driver.getCurrentUrl().contains("https://research.k12insight.com/zUM/FileManager.aspx")) {
			String expecteduser = "ruksar_k12";
			Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
		}
      else {
    	  String expecteduser = "anil_test";
  		Assert.assertEquals(actualuser, expecteduser, "Alert message is not matching with expected alert");
      }
		CompareWithCurrentTime(driver,param, test, currentTime);
		DeletePreviousDownloadedFile(driver, param, test);  
				
		waitforElemPresent(driver, testcaseName, 30, hover_xls, test);
		WebElement hower = driver.findElement(By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		
		waitforElemPresent(driver, testcaseName, 30, copy_url1, test);
		click(driver, testcaseName, copy_url1, test);
		
		String actualCopyrl = driver.findElement(By.xpath("//div[contains(text(),'URL copied to clipboard.')]")).getAttribute("innerHTML");
		String expectedCopyUrl = "URL copied to clipboard.";
		Assert.assertEquals(actualCopyrl.trim(), expectedCopyUrl, "Alert message is not matching with expected alert");
		
		String URL = (driver.findElement(By.xpath("//a[@id='dgAllDocuments_ctl02_hlFileURL']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	    Thread.sleep(5000);
	    ValidateDownloadedFile(driver, param, test);    
	    driver.switchTo().window(param.get("currentWindowHandle"));
	    
	    waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
	    click(driver, testcaseName,  By.xpath("//span[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		waitforElemPresent(driver, testcaseName, 30, delete_file, test);
		click(driver, testcaseName, delete_file, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();	
		Thread.sleep(5000);
	}	
	       
	public void DeletePreviousDownloadedFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
	     	throws InterruptedException {
	String testcaseName = param.get("TestCaseName");
	String fileName = param.get("secondarylanguage");
	System.out.println("Searching for "  +  fileName);  
	 String dirPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles"); 
	 String dirPath1 = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\" + fileName); 
     File dir1 = new File(dirPath1);
     File dir = new File(dirPath);
     File[] files = dir.listFiles();
     for (File listFile : files) {
             if (listFile.getName().contains(fileName)) {      
            	 dir1.delete();
                 System.out.println(fileName + " is deleted successfully");
                 break;
             }
	}
	}
	         
	public void ValidateDownloadedFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
	String testcaseName = param.get("TestCaseName");
	String fileName = param.get("secondarylanguage");
	System.out.println("Searching for " +  fileName);
	boolean flag = false;
     
     String dirPath = (System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles"); 
     File dir = new File(dirPath);
     File[] files = dir.listFiles();
     if (files.length == 0 || files == null) {
         System.out.println("The directory is empty");
         flag = false;
     } else {
         for (File listFile : files) {
             if (listFile.getName().contains(fileName)) {
                 System.out.println(fileName + " is present");
                 flag = true;
                 break;         
             }        
         }
         System.out.println(flag);
         if(flag == true)
         {
             reportPass("Validation of Downloaded File is passed", test);
         }
         else
         {
             reportFail(testcaseName,"Validation of Downloaded File" , test);
         }
     }
	}
	
	public void CompareWithCurrentTime(WebDriver driver, HashMap<String, String> param, ExtentTest test, java.util.Date currentTime) throws InterruptedException, ParseException {
		String testcaseName = param.get("TestCaseName");
		boolean isFileUploaded = false;

		String DateUploadedInString = driver.findElement(By.xpath("//span[@id='dgAllDocuments_ctl02_Label1']")).getAttribute("innerHTML");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date DateUploaded=new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(DateUploadedInString);
		System.out.println(dateFormat.format(DateUploaded.getTime()));
		
		if(DateUploaded.equals(currentTime)||DateUploaded.after(currentTime)){
				isFileUploaded=true;
				System.out.println(isFileUploaded);
				System.out.println("Date/Time Validation Passed");
		}
		else{
				System.out.println("Date/Time Validation Failed");
		}
		
	}
	
	public void PMR(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 100, settings_icon, test);
		click(driver, testcaseName, settings_icon, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[normalize-space()='Print Options']"), "Print Options", test);
		click(driver, testcaseName, By.xpath("//div[normalize-space()='Print Options']"), "print Options click", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[@for='rbprintrespYes']"), "survey responses", test);
		click(driver, testcaseName, By.xpath("//label[@for='rbprintrespYes']"), "click survey responses", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[@id='lblprintblankYes']"), "blank survey ", test);
		click(driver, testcaseName, By.xpath("//label[@id='lblprintblankYes']"), "click blank survey ", test);
	//	scrollIntoView(driver, testcaseName, settings_save, test);
		waitforElemPresent(driver, testcaseName, 100, settings_save, test);
		click(driver, testcaseName, settings_save, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[normalize-space()='Your updates have been saved.']"), "alert check after saving", test);
		click(driver, testcaseName, By.xpath("//span[normalize-space()='Your updates have been saved.']"), "alert check after saving", test);
		
	}
	
	public void textTranslation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		gotoTextTranslationPage(driver,param,test);
		translateAllQuestions(driver,param,test);
		saveTranslation(driver,param,test);
	}
	
	public void DescriptiveText(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Descriptive_Text(driver,param,test);
		Add_Questions(driver,param,test);	
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("DescriptiveText") +"')]"), "Descriptive Text : "+ param.get("DescriptiveText"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("DescriptiveText") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Descriptive Text is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Descriptive Text is not displayed" , test);
		}
	}
	public void TextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Text_Box(driver,param,test);
		Add_Questions(driver,param,test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("TextBox") +"')]"), "TextBox : "+ param.get("TextBox"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("TextBox") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Text Box is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Text Box is not displayed" , test);
		}
	}
	public void RadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Radio_Button(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("RadioButton") +"')]"), "RadioButton : "+ param.get("RadioButton"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("RadioButton") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Radio Button is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Radio Button is not displayed" , test);
		}
	}
	public void CheckBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Check_Box(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("CheckBox") +"')]"), "CheckBox : "+ param.get("CheckBox"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("CheckBox") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Check Box is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Check Box is not displayed" , test);
		}
	}
	public void DropDown(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Drop_Down(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("DropDown") +"')]"), "DropDown : "+ param.get("DropDown"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("DropDown") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Drop Down is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Drop Down is not displayed" , test);
		}
	}
	public void RankingQuestion(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Ranking(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("ranking") +"')]"), "Ranking : "+ param.get("ranking"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("ranking") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Ranking is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Ranking is not displayed" , test);
		}
	}
	
	public void DateQuestion(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Date(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("date") +"')]"), "Date : "+ param.get("date"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("date") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Date is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Date is not displayed" , test);
		}
	}
	public void HorizontalRadio(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Horizontal_Radio(driver,param,test);
		Add_Questions(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//span[contains(text(),'"+ param.get("horizontalradiobutton") +"')]"), "horizontal RadioButton : "+ param.get("horizontalradiobutton"), test);
		WebElement style = driver.findElement( By.xpath("//span[contains(text(),'"+ param.get("horizontalradiobutton") +"')]"));

		if(style.isDisplayed())
		{
		reportPass("Horizontal Radio is displayed", test);
		}
		else
		{
		reportFail(testcaseName,"Horizontal Radio is not displayed" , test);
		}
	}
	public void PageBreakWithoutQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Page_Break(driver,param,test);
		waitforElemPresent(driver, testcaseName, 30, add_questions, test);
		click(driver, testcaseName, add_questions, test);
		//WebDriverWait wait = new WebDriverWait(driver, 300 /*timeout in seconds*/);
		//if(wait.until(ExpectedConditions.alertIsPresent())==null)
		    //System.out.println("page break without questions alert was not present");	
		String actualalert = driver.switchTo().alert().getText();
		String expectedalert = "Looks like something's missing! Please review tags, questions, and answer text.";
		Assert.assertEquals(actualalert, expectedalert, "Alert message is not matching with expectedalert");
	}
	
	public void CreateCopyPaste(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		selectCreateProject(driver,param,test);
		selectBlankSurvey(driver,param,test);
		enterSurveyName(driver, param, test);
		CreateNewSurveyForCopyPaste(driver,param,test);
		Descriptive_Text(driver,param,test);
		Text_Box(driver,param,test);
		Radio_Button(driver,param,test);
		Page_Break(driver,param,test);
		Check_Box(driver,param,test);
		Drop_Down(driver,param,test);
		Ranking(driver,param,test);
		Page_Break(driver,param,test);
		Date(driver,param,test);
		Horizontal_Radio(driver,param,test);
		Add_Questions(driver,param,test);
	}
	
	public void CopyPaste(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		SelectAllProject(driver,param,test);
		Hover_Edit_Project(driver,param,test);
		Descriptive_Text(driver,param,test);
		Text_Box(driver,param,test);
		Radio_Button(driver,param,test);
		Page_Break(driver,param,test);
		Check_Box(driver,param,test);
		Drop_Down(driver,param,test);
		Ranking(driver,param,test);
		Page_Break(driver,param,test);
		Date(driver,param,test);
		Horizontal_Radio(driver,param,test);
		Add_Questions(driver,param,test);
	}
		
	public void CreateNewSurveyForCopyPaste(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, ihavequestionsreadytocp, test);
		click(driver, testcaseName, ihavequestionsreadytocp, test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		//waitForLoad(driver, testcaseName, 30, test);
		//waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);	
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		waitforElemPresent(driver, testcaseName, 30, questiontags, test);
		click(driver, testcaseName, questiontags, test);
	}
	public void Page_Break(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, pb, test);
		click(driver, testcaseName, pb, test);
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	public void Hover_Edit_Project(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		waitforElemPresent(driver, testcaseName, 30, hover3, test);
		WebElement hower = driver.findElement(By.xpath("//div[@title='SID: 1334, new copy paste feature Anas']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver, testcaseName, 30, edit1, test);
		click(driver, testcaseName, edit1, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, clickhere, test);
		click(driver, testcaseName, clickhere, test);	
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		waitforElemPresent(driver, testcaseName, 30, questiontags, test);
		click(driver, testcaseName, questiontags, test);
		Thread.sleep(3000);
	}


	public void Descriptive_Text(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, dt, test);
		click(driver, testcaseName, dt, test);
		//driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(param.get("DescriptiveText"));
		setText(driver, testcaseName, enter_text, param.get("DescriptiveText"), test);
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		
	}
	public void Text_Box(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, tb, test);
		click(driver, testcaseName, tb, test);
		//driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(param.get("TextBox"));	
		setText(driver, testcaseName, enter_text, param.get("TextBox"), test);
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Radio_Button(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		//String rbquestiontext = param.get("RadioButton").split("/~~/")[0];
		//String[] rbansweroptionarray = param.get("RadioButton").split("/~~/")[1].split("/~/");
		waitforElemPresent(driver, testcaseName, 30, rb, test);
		click(driver, testcaseName, rb, test);
		//driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(param.get("RadioButton"));	
		setText(driver, testcaseName, enter_text, param.get("RadioButton"), test);
		//setText(driver, testcaseName, enter_text, rbquestiontext , test);
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption1");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption2");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption3");
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Check_Box(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, cb, test);
		click(driver, testcaseName, cb, test);	
		setText(driver, testcaseName, enter_text, param.get("CheckBox"), test);
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption1");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption2");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption3");
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Drop_Down(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, dd, test);
		click(driver, testcaseName, dd, test);	
		setText(driver, testcaseName, enter_text, param.get("DropDown"), test);
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption1");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption2");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption3");
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Ranking(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, r, test);
		click(driver, testcaseName, r, test);	
		setText(driver, testcaseName, enter_text, param.get("ranking"), test);
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption1");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption2");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption3");
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Date(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, date, test);
		click(driver, testcaseName, date, test);	
		setText(driver, testcaseName, enter_text, param.get("date"), test);
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Horizontal_Radio(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, hr, test);
		click(driver, testcaseName, hr, test);	
		setText(driver, testcaseName, enter_text, param.get("horizontalradiobutton"), test);
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption1");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption2");
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys("AnsOption3");
		Actions action = new Actions(driver);
		action.moveByOffset(10,0).click().build().perform();
		driver.findElement(By.xpath("//textarea[@id='txtCopyPaste']")).sendKeys(System.lineSeparator());
	}
	
	public void Add_Questions(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, add_questions, test);
		click(driver, testcaseName, add_questions, test);
		//waitforElemPresent(driver, testcaseName, 30, hp, test);
		//click(driver, testcaseName, hp, test);
		
	}

	public void MergeDP(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		SelectAllProject(driver,param,test);
		SelectFolder(driver,param,test);
		Publish_Survey1(driver,param,test);
		SurveyParticipation1(driver,param,test);
		NewAllProject(driver,param,test);
		Publish_Survey2(driver,param,test);
		SurveyParticipation2(driver,param,test);
		Final_Merge_Steps(driver,param,test);
	}
	
	public void NewAllProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, hd_logo, test);
		click(driver, testcaseName, hd_logo, test);
		waitforElemPresent(driver, testcaseName, 30, all_projects1, test);
		click(driver, testcaseName, all_projects1, test);
	}
	
	public void SelectAllProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, all_projects, test);
		click(driver, testcaseName, all_projects, test);
	}
	
	public void SelectFolder(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		waitforElemPresent(driver, testcaseName, 30, select_folder_merge_dp, test);
		click(driver, testcaseName, select_folder_merge_dp, test);
	}
	
	public void Publish_Survey1(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, hover1, test);
		WebElement hower = driver.findElement(By.xpath("//div[contains(@title,'Do not touch - Merge DP1 FROM sogo_Asharma')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();	
		waitforElemPresent(driver, testcaseName, 30, publish_project, test);
		click(driver, testcaseName, publish_project, test);
		waitforElemPresent(driver, testcaseName, 30, copy_url, test);
		click(driver, testcaseName, copy_url, test);
		String URL = (driver.findElement(By.xpath("//div[@id='publishUrl']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL);
	}
		
	public void SurveyParticipation1(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[normalize-space()='Much less than others']"),testcaseName,test);
		click(driver, testcaseName, By.xpath("//label[normalize-space()='Much less than others']"), testcaseName, test);
		click(driver, testcaseName, s1q2, test);
		click(driver, testcaseName, s1q3, test);
		click(driver, testcaseName, s1q4, test);
		//click(driver, testcaseName, s1q5, test);  
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		if(driver.getCurrentUrl().contains("http://urlbranding.sogoquiz.com/survey.aspx?k=SsQTURPVsTVSsPsPsP&lang=0&data=")) {
			waitforElemPresent(driver, testcaseName, 30, submit, test);
			click(driver, testcaseName, submit, test); 
		}	
		else if(driver.getCurrentUrl().contains("https://urlbranding.k12insight.com/survey1.aspx?k=SsTUXQQsQPRQsPsPsP&lang=0")) {
		     waitforElemPresent(driver, testcaseName, 30, submitengage, test);
	    	 click(driver, testcaseName, submitengage, test);
		}
      else {
    	  waitforElemPresent(driver, testcaseName, 30, submitzarca, test);
    	  click(driver, testcaseName, submitzarca, test);
      }
    	  
		driver.switchTo().window(param.get("currentWindowHandle"));
	}
	
	public void Publish_Survey2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1']"),testcaseName,test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		waitforElemPresent(driver, testcaseName, 30, hover2, test);
		WebElement hower = driver.findElement(By.xpath("//div[contains(@title,'Do not touch - Merge DP2 FROM sogo_Asharma')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver, testcaseName, 30, publish_project, test);
		click(driver, testcaseName, publish_project, test);
		waitforElemPresent(driver, testcaseName, 30, copy_url, test);
		click(driver, testcaseName, copy_url, test);	
		String URL1 = (driver.findElement(By.xpath("//div[@id='publishUrl']")).getText());
		executeScript(driver, testcaseName, "window.open()", test);
		
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		param.put("currentWindowHandle", currentWindowHandle);
		for (String handle : handles) {
		System.out.println(handle);
		System.out.println(currentWindowHandle);
		if (!currentWindowHandle.equals(handle)) {
		driver.switchTo().window(handle);
		}
		}
	    driver.get(URL1);
	    	    
	}
	
	public void SurveyParticipation2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[normalize-space()='Much less than others']"),testcaseName,test);
		click(driver, testcaseName, By.xpath("//label[normalize-space()='Much less than others']"), testcaseName, test);
		click(driver, testcaseName, s2q2, test);
		click(driver, testcaseName, s2q3, test);
		click(driver, testcaseName, s2q4, test);
		//click(driver, testcaseName, s2q5, test);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		if(driver.getCurrentUrl().contains("http://urlbranding.sogoquiz.com/survey1.aspx?k=SsQTURPVsTVRsPsPsP&lang=0")) {
			waitforElemPresent(driver, testcaseName, 30, submit2, test);
			click(driver, testcaseName, submit2, test); 
		}		
		else if(driver.getCurrentUrl().contains("https://urlbranding.k12insight.com/survey.aspx?k=SsTUXQQsQPRRsPsPsP&lang=0&data=")) {
		     waitforElemPresent(driver, testcaseName, 30, submitengage2, test);
	    	 click(driver, testcaseName, submitengage2, test);
		}
      else {
    	  waitforElemPresent(driver, testcaseName, 30, submitzarca2, test);
    	  click(driver, testcaseName, submitzarca2, test);
      }
		driver.switchTo().window(param.get("currentWindowHandle"));
		
	}
	
	public void Final_Merge_Steps(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, utilities, test);
		click(driver, testcaseName, utilities, test);
		waitforElemPresent(driver, testcaseName, 30, merge_projects, test);
		click(driver, testcaseName, merge_projects, test);
		waitforElemPresent(driver, testcaseName, 30, create_new_merge_projects, test);
		click(driver, testcaseName, create_new_merge_projects, test);
		waitforElemPresent(driver, testcaseName, 30, continue1, test);
		click(driver, testcaseName, continue1, test);
		waitforElemPresent(driver, testcaseName, 30, select_project1, test);
		click(driver, testcaseName, select_project1, test);
		waitforElemPresent(driver, testcaseName, 30, dd0, test);
		WebElement dd0 = driver.findElement(By.xpath("//ul[@id='common-menu1']//li//a[@class='fly']//span[contains(text(),'Merge DP')]"));
		Actions action0 = new Actions(driver); 
		action0.doubleClick(dd0).perform();
		waitforElemPresent(driver, testcaseName, 30, do_not_touch_merge_dp1_from_sogo_asharma, test);
		click(driver, testcaseName, do_not_touch_merge_dp1_from_sogo_asharma, test);
		waitforElemPresent(driver, testcaseName, 30, select_project2, test);
		click(driver, testcaseName, select_project2, test);
		waitforElemPresent(driver, testcaseName, 30, dd1, test);
		WebElement dd1 = driver.findElement(By.xpath("//ul[@id='common-menu3']//li//a[@class='fly']//span[contains(text(),'Merge DP')]"));
		Actions action1 = new Actions(driver); 
		action1.doubleClick(dd1).perform();
		waitforElemPresent(driver, testcaseName, 30, do_not_touch_merge_dp2_from_sogo_asharma, test);
		click(driver, testcaseName, do_not_touch_merge_dp2_from_sogo_asharma, test);
		waitforElemPresent(driver, testcaseName, 30, continue2, test);
		click(driver, testcaseName, continue2, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();
		waitforElemPresent(driver, testcaseName, 30, import_response, test);
		click(driver, testcaseName, import_response, test);
		waitforElemPresent(driver, testcaseName, 30, done, test);
		click(driver, testcaseName, done, test);
		Thread.sleep(5000);
		
	}
	
	public void createPoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectCreatePoll(driver, param, test);
		createPollButton(driver, param, test);
		selectAnswerlibrary(driver, param, test);
		pollSettings(driver, param, test);
		visualSettings(driver, param, test);
		resultSettings(driver, param, test);
		publishPoll(driver, param, test);
		pollParticipation(driver, param, test);
		pollTrack(driver, param, test);
		answerCheck(driver, param, test);
		
	}
	
	
	
	public void headerCommonSteps(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
	}
	
	
	public void listCommonStepsHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.ENTER);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		
	}
	
	
	public void listCommonStepsFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.ENTER);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		
	}
	
	
	
	
	
	public void footerCommonSteps(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 30,description_text, test);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		
	}
	
	public void validationForBoldStyle(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//strong[normalize-space()='"+ param.get("textbox") +"']"), "header/footer added"+ param.get("textbox"), test);
		  WebElement style = driver.findElement( By.xpath("//strong[normalize-space()='"+ param.get("textbox") +"']"));
		//span[contains(text(),'This is a sample textbox')]
		  if(style.isDisplayed())
		  {
			  reportPass("bold content is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"bold content is not displayed" , test);  
			} 
	}
	
	
	public void boldCheckForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		validationForBoldStyle(driver, param, test);
	}
	
	
	
	public void boldCheckForFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
	
	 scrollIntoCenter(driver, testcaseName, save_button_for_footer, test);
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		validationForBoldStyle(driver, param, test);
	}
	
	
	
	
	
	
	public void italicCheckForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,italic_button, test);
		click(driver, testcaseName,italic_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		validationForItalicStyle(driver, param, test);
		
	}
	public void validationForItalicStyle(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//em[normalize-space()='"+ param.get("textbox") +"']"), "header/footer added"+ param.get("textbox"), test);
		  WebElement style = driver.findElement( By.xpath("//em[normalize-space()='"+ param.get("textbox") +"']"));
		
		  if(style.isDisplayed())
		  {
			  reportPass("italic content is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"italic content is not displayed" , test);  
			} 
	}
	
	public void limitTestForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("secondarylanguage"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
		 String alert_msg =  (alertPopUp.getText());
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg1 = param.get("primarylanguage");
	        if(alert_msg.contains(alert_msg1))
				reportPass("matched", test);
				else
				reportFail(testcaseName, "not matched", test);
	}
	
	public void limitTestForFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("secondarylanguage"), test);
	//	driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
	        // Print the alert message to console
		 String alert_msg =  (alertPopUp.getText());
	        // Accept the alert popup
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg1 = param.get("AnswerOptions");
	        if(alert_msg.contains(alert_msg1))
				reportPass("matched", test);
				else
				reportFail(testcaseName, "not matched", test);
	}
	
	public void italicCheckForFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,italic_button, test);
		click(driver, testcaseName,italic_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		validationForItalicStyle(driver, param, test);
	}
	public void underlineCheckForFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,underline_button, test);
		click(driver, testcaseName,underline_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		validationForUnderLineStyle(driver, param, test);
	}
	
	
	public void underlineCheckForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,underline_button, test);
		click(driver, testcaseName,underline_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		validationForUnderLineStyle(driver, param, test);
	}
	
	
	
	public void validationForUnderLineStyle(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//u[normalize-space()='"+ param.get("textbox") +"']"), "header/footer added"+ param.get("textbox"), test);
		  WebElement style = driver.findElement( By.xpath("//u[normalize-space()='"+ param.get("textbox") +"']"));
		
		  if(style.isDisplayed())
		  {
			  reportPass("underline content is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"underline content is not displayed" , test);  
			} 
	}
	
	public void removeFormatForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"), "header text", test);
		WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver, "add header edit", 30, By.xpath("//a[@title='Edit Survey Header']//div[@class='pageIcons imgEdit']"), testcaseName, test);
        click(driver, "add header edit", By.xpath("//a[@title='Edit Survey Header']//div[@class='pageIcons imgEdit']"),  testcaseName, test);
        driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
        driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.switchTo().defaultContent();
        waitforElemPresent(driver, testcaseName, 30, remove_format_button, test);
		click(driver, testcaseName, remove_format_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		
		validationForRemoveFormatHeader(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"), "header text", test);
		WebElement hower1 = driver.findElement(By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"));
		action.moveToElement(hower1).perform();
		waitforElemPresent(driver, "add header edit", 30, By.xpath("//div[@title='Delete Survey Header']"), testcaseName, test);
        click(driver, "add header edit", By.xpath("//div[@title='Delete Survey Header']"),  testcaseName, test);
       
	}
	
	
	public void validationForRemoveFormatHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='surveyHeaderText']"), "header text", test);
	    WebElement style = driver.findElement( By.xpath("//div[@class='surveyHeaderText']"));
		
		  if(style.isDisplayed())
		  {
			  reportPass("format removed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"format removed" , test);  
			} 
	}
	
	public void validationForRemoveFormatFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='surveyFooterText']"), "header text", test);
	    WebElement style = driver.findElement( By.xpath("//div[@class='surveyFooterText']"));
		
		  if(style.isDisplayed())
		  {
			  reportPass("format removed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"format removed" , test);  
			} 
	}
	
	public void removeFormatFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"), "footer text", test);
		WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver,testcaseName, 30, By.xpath("//a[@title='Edit Survey Footer']//div[@class='pageIcons imgEdit']"), "edit icon", test);
        click(driver,testcaseName, By.xpath("//a[@title='Edit Survey Footer']//div[@class='pageIcons imgEdit']"),  "edit icon", test);
        driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
        driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.switchTo().defaultContent();
        waitforElemPresent(driver, testcaseName, 30, remove_format_button, test);
		click(driver, testcaseName, remove_format_button, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		
		validationForRemoveFormatFooter(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"), "footer text", test);
		WebElement hower1 = driver.findElement(By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"));
		action.moveToElement(hower1).perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@title='Delete Survey Footer']"), "edit icon", test);
        click(driver,testcaseName, By.xpath("//div[@title='Delete Survey Footer']"),  "edit icon", test);
       
	}
	
	public void alignmentForHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,centre_align, test);
		click(driver, testcaseName,centre_align, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		editHeader(driver, param, test);
        waitforElemPresent(driver, testcaseName, 30,left_align, test);
		click(driver, testcaseName,left_align, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		editHeader(driver, param, test);
		 waitforElemPresent(driver, testcaseName, 30,right_align, test);
			click(driver, testcaseName,right_align, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
			editHeader(driver, param, test);
			 waitforElemPresent(driver, testcaseName, 30,justify_align, test);
				click(driver, testcaseName,justify_align, test);
				waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
				click(driver, testcaseName, save_button_for_header, test);
	}
	
	public void alignmentForFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,centre_align, test);
		click(driver, testcaseName,centre_align, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		editFooter(driver, param, test);
        waitforElemPresent(driver, testcaseName, 30,left_align, test);
		click(driver, testcaseName,left_align, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		editFooter(driver, param, test);
		 waitforElemPresent(driver, testcaseName, 30,right_align, test);
			click(driver, testcaseName,right_align, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
			editFooter(driver, param, test);
			 waitforElemPresent(driver, testcaseName, 30,justify_align, test);
				click(driver, testcaseName,justify_align, test);
				waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
				click(driver, testcaseName, save_button_for_footer, test);
	}
	
	public void undoAndRedoHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		headerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, remove_format_button, test);
		click(driver, testcaseName, remove_format_button, test);
		
		 waitforElemPresent(driver, testcaseName, 30, undo_icon, test);
			click(driver, testcaseName, undo_icon, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
			editHeader(driver, param, test);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30,underline_button, test);
			click(driver, testcaseName,underline_button, test);
			 waitforElemPresent(driver, testcaseName, 30, undo_icon, test);
				click(driver, testcaseName, undo_icon, test);
				 waitforElemPresent(driver, testcaseName, 30, redo_icon, test);
					click(driver, testcaseName, redo_icon, test);
					waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
					click(driver, testcaseName, save_button_for_header, test);
			
	}
	
	public void undoAndRedoFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		footerCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30,bold_button, test);
		click(driver, testcaseName,bold_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, remove_format_button, test);
		click(driver, testcaseName, remove_format_button, test);
		 waitforElemPresent(driver, testcaseName, 30, undo_icon, test);
			click(driver, testcaseName, undo_icon, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
			editFooter(driver, param, test);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
			driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30,underline_button, test);
			click(driver, testcaseName,underline_button, test);
			 waitforElemPresent(driver, testcaseName, 30, undo_icon, test);
				click(driver, testcaseName, undo_icon, test);
				 waitforElemPresent(driver, testcaseName, 30, redo_icon, test);
					click(driver, testcaseName, redo_icon, test);
					waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
					click(driver, testcaseName, save_button_for_footer, test);
	}
	
	
	
	public void editHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"), "header text", test);
		WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyHeaderView']//div[@class='surveyHeaderText']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver, "add header edit", 30, By.xpath("//a[@title='Edit Survey Header']//div[@class='pageIcons imgEdit']"), testcaseName, test);
        click(driver, "add header edit", By.xpath("//a[@title='Edit Survey Header']//div[@class='pageIcons imgEdit']"),  testcaseName, test);
        driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
        driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.switchTo().defaultContent();
	}
	
	public void editFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
        waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"), "footer text", test);
		WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyFooterView']//div[@class='surveyFooterText']"));
		Actions action = new Actions(driver);
		action.moveToElement(hower).perform();
		waitforElemPresent(driver,testcaseName, 30, By.xpath("//a[@title='Edit Survey Footer']//div[@class='pageIcons imgEdit']"), "edit icon", test);
        click(driver,testcaseName, By.xpath("//a[@title='Edit Survey Footer']//div[@class='pageIcons imgEdit']"),  "edit icon", test);
        driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
        driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.switchTo().defaultContent();
	}
	public void numberListHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsHeader(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, number_list_icon, test);
		click(driver, testcaseName, number_list_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
	}
	public void numberListFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsFooter(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, number_list_icon, test);
		click(driver, testcaseName, number_list_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
	}
	
	public void bulltedListHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsHeader(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, bullet_list_icon, test);
		click(driver, testcaseName, bullet_list_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
	}
	
	public void bulltedListFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsFooter(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, bullet_list_icon, test);
		click(driver, testcaseName, bullet_list_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
	}
	
	public void increaseAndDecreaseIndentHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsHeader(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, increase_indent_icon, test);
		click(driver, testcaseName, increase_indent_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		editHeader(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, decrease_indent_icon, test);
		click(driver, testcaseName, decrease_indent_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
	}
	
	public void increaseAndDecreaseIndentFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsFooter(driver, param, test);
		
		waitforElemPresent(driver, testcaseName, 30, increase_indent_icon, test);
		click(driver, testcaseName, increase_indent_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		editFooter(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, decrease_indent_icon, test);
		click(driver, testcaseName, decrease_indent_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
	}
	
	public void sourceHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsHeader(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, source_icon, test);
		click(driver, testcaseName, source_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
	}
	
	public void sourceFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		listCommonStepsFooter(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, source_icon, test);
		click(driver, testcaseName, source_icon, test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
	}
	
	
	public void linkUnlinkHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, link_icon, test);
		click(driver, testcaseName, link_icon, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@class='cke_dialog_ui_input_text']"), "display Text", test);
		setText(driver, testcaseName, By.xpath("//input[@class='cke_dialog_ui_input_text']"), param.get("textbox"), "display text", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='cke_dialog_ui_input_text']//input[@id='cke_131_textInput']"), "link", test);
		setText(driver, testcaseName, By.xpath("//div[@class='cke_dialog_ui_input_text']//input[@id='cke_131_textInput']"), param.get("description"), "link", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "link ok button", test);
		click(driver, testcaseName,  By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "link ok button", test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
		click(driver, testcaseName, save_button_for_header, test);
		  editHeader(driver, param, test); 
		  waitforElemPresent(driver, testcaseName, 30, unlink_icon, test);
		  click(driver, testcaseName, unlink_icon, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
		 
	}
	
	public void linkUnlinkFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, link_icon, test);
		click(driver, testcaseName, link_icon, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@class='cke_dialog_ui_input_text']"), "display Text", test);
		setText(driver, testcaseName, By.xpath("//input[@class='cke_dialog_ui_input_text']"), param.get("textbox"), "display text", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='cke_dialog_ui_input_text']//input[@id='cke_131_textInput']"), "link", test);
		setText(driver, testcaseName, By.xpath("//div[@class='cke_dialog_ui_input_text']//input[@id='cke_131_textInput']"), param.get("description"), "link", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "link ok button", test);
		click(driver, testcaseName,  By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "link ok button", test);
		waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
		click(driver, testcaseName, save_button_for_footer, test);
		  editFooter(driver, param, test); 
		  waitforElemPresent(driver, testcaseName, 30, unlink_icon, test);
		  click(driver, testcaseName, unlink_icon, test);
			waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
		 
	}
	
	public void spellCheckHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30,spell_check, test);
		click(driver, testcaseName,spell_check, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[contains(@src,'SpellCheck.aspx?')]"), "Spell check iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'SpellCheck.aspx?')]")));
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@src='SpellCheck.aspx']"), "Suggestion check iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement( By.xpath("//iframe[@src='SpellCheck.aspx']")));
		System.out.println(driver.findElements(By.xpath("//select[@class='suggestion']")).size());
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@class='suggestion']"), "suggestion", test);
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='suggestion']")));
		dropdown.selectByVisibleText(param.get("textbox"));
		waitforElemPresent(driver, testcaseName, 30,replace_button, test);
		click(driver, testcaseName,replace_button, test);
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
		 String alert_msg =  (alertPopUp.getText());
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        driver.switchTo().defaultContent();
	        waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
	}
	
	
	public void spellCheckFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30,spell_check, test);
		click(driver, testcaseName,spell_check, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[contains(@src,'SpellCheck.aspx?')]"), "Spell check iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'SpellCheck.aspx?')]")));
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@src='SpellCheck.aspx']"), "Suggestion check iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement( By.xpath("//iframe[@src='SpellCheck.aspx']")));
		System.out.println(driver.findElements(By.xpath("//select[@class='suggestion']")).size());
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@class='suggestion']"), "suggestion", test);
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@class='suggestion']")));
		dropdown.selectByVisibleText(param.get("textbox"));
		waitforElemPresent(driver, testcaseName, 30,replace_button, test);
		click(driver, testcaseName,replace_button, test);
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
		 String alert_msg =  (alertPopUp.getText());
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        driver.switchTo().defaultContent();
	        waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
		
		
	}
	
	public void pasteFromWordHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, paste_from_word, test);
		click(driver, testcaseName, paste_from_word, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@aria-label='Paste Area']"), "copy from word  iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@aria-label='Paste Area']")));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//html[@dir='ltr']//body[@contenteditable='true']"), "content", test);
		setText(driver, testcaseName, By.xpath("//html[@dir='ltr']//body[@contenteditable='true']"), param.get("description"), "link", test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "ok button", test);
		click(driver, testcaseName,  By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "ok button", test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//body[contains(text(),'"+ param.get("description") +"')]"), param.get("description"), test);
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);

	}
	
	
	public void pasteFromWordFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, paste_from_word, test);
		click(driver, testcaseName, paste_from_word, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@aria-label='Paste Area']"), "copy from word  iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@aria-label='Paste Area']")));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//html[@dir='ltr']//body[@contenteditable='true']"), "content", test);
		setText(driver, testcaseName, By.xpath("//html[@dir='ltr']//body[@contenteditable='true']"), param.get("description"), "link", test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "ok button", test);
		click(driver, testcaseName,  By.xpath("//a[@class='cke_dialog_ui_button cke_dialog_ui_button_ok']//span[@class='cke_dialog_ui_button']"), "ok button", test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//body[contains(text(),'"+ param.get("description") +"')]"), param.get("description"), test);
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
	}
	
	
	public void fontColourHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		headerCommonSteps(driver, param, test);
		fontColour(driver, param, test);
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
	}
	
	public void fontColourFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		footerCommonSteps(driver, param, test);
		fontColour(driver, param, test);
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
	}
	
	
	public void fontColour(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, font_colour_icon, test);
		click(driver, testcaseName, font_colour_icon, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@class='cke_panel_frame']"), "color  iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_panel_frame']")));
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//a[@title='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);        
		   click(driver, testcaseName,  By.xpath("//a[@title='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);
		driver.switchTo().defaultContent();
	}
	
	public void fontSizeHeader(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_header, test);
		click(driver, testcaseName, add_header, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, font_size_icon, test);
		click(driver, testcaseName, font_size_icon, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@class='cke_panel_frame']"), "size  iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_panel_frame']")));
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//span[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);        
		   click(driver, testcaseName,  By.xpath("//span[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_header, test);
			click(driver, testcaseName, save_button_for_header, test);
	}
	
	
	public void fontSizeFooter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_footer, test);
		click(driver, testcaseName, add_footer, test);
		driver.switchTo().frame(driver.findElement(By.xpath(" //iframe[@class='cke_wysiwyg_frame cke_reset']")));
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30,visual_settings_cb, test);
		click(driver, testcaseName,visual_settings_cb, test);
		waitforElemPresent(driver, testcaseName, 30, font_size_icon, test);
		click(driver, testcaseName, font_size_icon, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//iframe[@class='cke_panel_frame']"), "size  iframe", 30, 100, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_panel_frame']")));
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//span[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);        
		   click(driver, testcaseName,  By.xpath("//span[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);
		driver.switchTo().defaultContent();
		 waitforElemPresent(driver, testcaseName, 30, save_button_for_footer, test);
			click(driver, testcaseName, save_button_for_footer, test);
	}
	
	
	public void selectCreateProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, By.xpath("//div[@class='hd-logo-img']"), testcaseName, test);
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		click(driver, testcaseName, create_project, test);
		waitForLoad(driver, testcaseName, 60, test);
	}
	
	public void selectProjectType(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().frame("iframe1");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//div[@class='cls-projecttype-container']//div[contains(text(),'"+ param.get("surveyType") +"')]"), param.get("surveyType"), test);        
	   click(driver, testcaseName,  By.xpath("//div[@class='cls-projecttype-container']//div[contains(text(),'"+ param.get("surveyType") +"')]"), param.get("surveyType"), test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);
		enterSurveyName(driver, param, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	

	public void logoUploadFromComputer(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation") +"");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
		WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
		if(img.isDisplayed())
		{
			reportPass("logo is displayed", test);
		}
		else
		{
			reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
		}
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		click(driver, testcaseName, save_btn, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
		  WebElement img2 = driver.findElement(By.xpath("//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed())
		  {
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		 
		  deleteLogo(driver, param, test);
	}
	public void useAccountLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, use_account_logo, test);
		click(driver, testcaseName, use_account_logo, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), "account logo", test);
		WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
		if(img.isDisplayed())
		{
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		click(driver, testcaseName, save_btn, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), "account logo after save", test);
		  WebElement img2 = driver.findElement(By.xpath(
		  "//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed()) {
		  
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
			}
		
	}
	public void deleteUseAccountLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		 useAccountLogo(driver, param, test);
		deleteLogo(driver, param, test);
	}
	public void logoValidation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
	WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
	if(img.isDisplayed())
	{
		  reportPass("logo is displayed", test);
	  } 
	  else
		{
			reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
		}
	waitforElemPresent(driver, testcaseName, 30, save_btn, test);
	click(driver, testcaseName, save_btn, test);
	driver.switchTo().defaultContent();
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
	  WebElement img2 = driver.findElement(By.xpath(
	  "//img[@id='imgSurveyLogo1']"));
	  if(img2.isDisplayed()){
		  
		  reportPass("logo is displayed", test);
	  } 
	  else
		{
			reportFail(testcaseName,"logo is not displayed" , test);  
		}
}
	public void logoValidation2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
		  WebElement img2 = driver.findElement(By.xpath(
		  "//img[@id='imgSurveyLogo1']"));
		  if(img2.isDisplayed()){
		  
			  reportPass("logo is displayed", test);
		  } 
		  else
			{
				reportFail(testcaseName,"logo is not displayed" , test);  
			}
	}
	public void logoCommonSteps(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {

		String testcaseName = param.get("TestCaseName");
		
		selectCreateProject(driver, param, test);
		selectProjectType(driver, param, test);
		enterTextBox(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, add_logo, test);
		click(driver, testcaseName, add_logo, test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'AddSurveyLogo.aspx?')]")));
	}
	public void copyFromAnotherProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, copy_from_other_project, test);
		 click(driver, testcaseName, copy_from_other_project, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[normalize-space()='--Select Project--']"), testcaseName, test);
 	    click(driver, testcaseName, By.xpath("//a[normalize-space()='--Select Project--']"), testcaseName, test);
 	    waitforElemPresent(driver, testcaseName, 10,   By.xpath("//span[normalize-space()='"+ param.get("foldername") +"']"), param.get("foldername"), test);        
	   	click(driver, testcaseName,  By.xpath("//span[normalize-space()='"+ param.get("foldername") +"']"), param.get("foldername"), test); 
 	   waitforElemPresent(driver, testcaseName, 30, select_main, test);
		 doubleClick(driver, testcaseName, select_main, test);
		 waitforElemPresent(driver, testcaseName, 10,   By.xpath("//a[normalize-space()='"+ param.get("ThanksMsg") +"']"), param.get("ThanksMsg"), test);        
		   	click(driver, testcaseName,  By.xpath("//a[normalize-space()='"+ param.get("ThanksMsg") +"']"), param.get("ThanksMsg"), test); 
	    waitforElemPresent(driver, testcaseName, 30, copy_from_anothersurvey, test);
		 doubleClick(driver, testcaseName, copy_from_anothersurvey, test);
		 logoValidation(driver, param, test);
		 deleteLogo(driver, param, test);
	}
	
	
	public void insertFromUrl(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		  waitforElemPresent(driver, testcaseName, 30, insert_from_url, test);
			click(driver, testcaseName, insert_from_url, test);
			WebElement q6 = driver.findElement(By.xpath("//input[@id='txtLogoURL']"));
			q6.sendKeys("https://image.shutterstock.com/image-vector/link-icon-hyperlink-chain-symbol-260nw-1186749931.jpg");
			 waitforElemPresent(driver, testcaseName, 30, btn_logo_url, test);
			 click(driver, testcaseName, btn_logo_url, test);
			 logoValidation(driver, param, test);
			 deleteLogo(driver, param, test);
	}
	public void deleteLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 30, logo_display, test);
			WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action = new Actions(driver);
			action.moveToElement(hower).perform();
			waitforElemPresent(driver, testcaseName, 30, delete_logo_display, test);
			click(driver, testcaseName, delete_logo_display, test);
			waitforElemPresent(driver, testcaseName, 30, delete_icon, test);
			click(driver, testcaseName, delete_icon, test);
	}
	
	public void alignOfLogoLeft(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			 useAccountLogo(driver, param, test);
			WebElement hower = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action = new Actions(driver);
			action.moveToElement(hower).perform();
			waitforElemPresent(driver, testcaseName, 30, align_icon1, test);
			click(driver, testcaseName, align_icon1, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[normalize-space()='Left']"),"logo left align ", test);
			click(driver, testcaseName, By.xpath("//span[normalize-space()='Left']"),"logo left align ", test);
			 logoValidation2(driver, param, test);
	}
	public void alignOfLogoRight(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			
			 useAccountLogo(driver, param, test);
			
			waitforElemPresent(driver, testcaseName, 30, logo_display, test);
			
			WebElement hower1 = driver.findElement(By.xpath("//div[@class='divSurveyLogoImageContainer']"));
			Actions action1 = new Actions(driver);
			action1.moveToElement(hower1).perform();
			
			waitforElemPresent(driver, testcaseName, 30, align_icon1, test);
			click(driver, testcaseName, align_icon1, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[normalize-space()='Right']"),"logo right align ", test);
			click(driver, testcaseName, By.xpath("//span[normalize-space()='Right']"),"logo right align", test);
			
			logoValidation2(driver, param, test);
	}
	
	
	public void uploadingJPGFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation1") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);   // "img is not displayed";
				}
			
	}
	
	
	public void uploadingGIFFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation2") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			
	}
	public void uploadingJPEGFile(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
			String testcaseName = param.get("TestCaseName");
			logoCommonSteps(driver, param, test);
			waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
			click(driver, testcaseName, upload_from_computer, test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation3") +"");
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgLogo']"), testcaseName, test);
			WebElement img = driver.findElement(By.xpath("//img[@id='imgLogo']"));
			if(img.isDisplayed())
			{
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}
			waitforElemPresent(driver, testcaseName, 30, save_btn, test);
			click(driver, testcaseName, save_btn, test);
			driver.switchTo().defaultContent();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@id='imgSurveyLogo1']"), testcaseName, test);
			  WebElement img2 = driver.findElement(By.xpath(
			  "//img[@id='imgSurveyLogo1']"));
			  if(img2.isDisplayed()){
				  
				  reportPass("logo is displayed", test);
			  } 
			  else
				{
					reportFail(testcaseName,"logo is not displayed" , test);  
				}	
	}
	public void logoGreaterThan5mb(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation4") +"");
		waitForAlert(driver, testcaseName, 30, test);
		 Alert alertPopUp = driver.switchTo().alert();
	        // Print the alert message to console
		 String alert_msg =  ("Alert Box message: " + alertPopUp.getText());
	        // Accept the alert popup
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg1 = param.get("DOB");
	        if(alert_msg.contains(alert_msg1))
				
				System.out.println(" \"matched\" ");
				else
				//Fail
				System.out.println(" \"not matched\" ");
	}
	
	
	public void unSupportedFileForLogo(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		logoCommonSteps(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, upload_from_computer, test);
		click(driver, testcaseName, upload_from_computer, test);
		driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\"+ param.get("imageLocation5") +"");
		 Alert alertPopUp = driver.switchTo().alert();
	        // Print the alert message to console
		 String alert_msg =  ("Alert Box message: " + alertPopUp.getText());
	        // Accept the alert popup
		 System.out.println(alert_msg);
	        alertPopUp.accept();
	        String	alert_msg0 = param.get("Grade");
	        if(alert_msg.contains(alert_msg0))
				
				System.out.println(" \"matched\" ");
				else
				//Fail
				System.out.println(" \"not matched\" ");
		}
		
	public void selectCreatePoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().frame("iframe1");
		//driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='cls-projecttype-container']//div[@class='cls-project-name-container'][normalize-space()='Poll']")));
		waitforElemPresent(driver, testcaseName, 30, create_poll, test);
		click(driver, testcaseName, create_poll, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	
	
	public void selectAnswerlibrary(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, answer_library, test);
		click(driver, testcaseName, answer_library,test);
		WebElement OPTION = driver.findElement(By.xpath("//a[@id='A1']"));
		OPTION.click();
		driver.switchTo().frame("iframe1");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("RadioButton") +"']"), param.get("RadioButton"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("RadioButton") +"']"), param.get("RadioButton"), test); 
	   	click(driver, testcaseName, use_this_list,test);
	   	driver.switchTo().defaultContent();
	   	continuebuttonp(driver, param, test);
	   	waitforElemPresent(driver, testcaseName, 30, By.xpath("//img[@title='Auto-translate with Bing.']/parent::a"),"Bing Translate",test);
		click(driver, testcaseName, By.xpath("//img[@title='Auto-translate with Bing.']/parent::a"),"Bing Translate",test); 
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttont, test);
		click(driver, testcaseName, Continue_Buttont,test);
	}
	
	
	public void continuebuttonp(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, continue_buttonp, test);
		
	}
	
	public void pollSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, expire_poll_yes, test);
		click(driver, testcaseName, expire_poll_yes,test);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonps, test);
		click(driver, testcaseName, Continue_Buttonps,test);

	}
	
	
	public void visualSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonvs, test);
		click(driver, testcaseName, Continue_Buttonvs,test);
	}
	
	
	public void resultSettings(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, Result_Settings, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, Continue_Buttonrs, test);
		click(driver, testcaseName, Continue_Buttonrs,test);
	}
	
	public void publishPoll(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String URl = (driver.findElement(By.xpath("//div[@id='txt_English']")).getText());
		waitforElemPresent(driver, testcaseName, 30, Save_And_Finish, test);
		click(driver, testcaseName, Save_And_Finish,test);
		executeScript(driver, testcaseName, "window.open()", test);
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
	    String currentWindowHandle = driver.getWindowHandle();
	    param.put("currentWindowHandle", currentWindowHandle);
	    for (String handle : handles) {
	    	System.out.println(handle);
	    	System.out.println(currentWindowHandle);
	        if (!currentWindowHandle.equals(handle)) {
	            driver.switchTo().window(handle);
	        }
	    }
		driver.get(URl);
	}
	
	public void pollParticipation(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("AnswerOptions") +"']"), param.get("AnswerOptions"), test);
	   	click(driver, testcaseName, Participation_Poll_Submit, test);
		driver.close();
		driver.switchTo().window(param.get("currentWindowHandle"));
	}	
		
	public void pollTrack(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, Track_Poll, test);
		waitforElemPresent(driver, testcaseName, 30, Public_Access, test);
		click(driver, testcaseName, Public_Access, test);
	}
	
	public void answerCheck(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Set<String> handles = driver.getWindowHandles();
	    String currentWindowHandle = driver.getWindowHandle();
	    param.put("currentWindowHandle", currentWindowHandle);
	    for (String handle : handles) {
	    	System.out.println(handle);
	    	System.out.println(currentWindowHandle);
	        if (!currentWindowHandle.equals(handle)) {
	            driver.switchTo().window(handle);
	        }
	    }
		
	String	ANS = param.get("AnswerOptions");
	
	waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='individual-answer']"), ANS, test);
		
	String Ans = (driver.findElement(By.xpath("//div[@class='individual-answer']")).getText());
		if(Ans.contains(ANS))
			
			System.out.println(" \"matched\" ");
			else
			//Fail
			System.out.println("e \"not matched\" ");
	}
	
	
	
	public void selectBlankSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool')]"), "Iframe", test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool')]")));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, survey_button, test);
		click(driver, testcaseName, survey_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);

	}
	
	
	
	
	
	public void createNewSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		enterSurveyName(driver, param, test);
		selectFolder(driver, param, test);
		selectPrimaryLanugage(driver, param, test);
		selectSecondaryLanugage(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);
	}
	
	public void createPollButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		enterSurveyName(driver, param, test);
		
		addlanguages(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	
	
	public void enterSurveyName(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, survey_name, test);
		String surveyName = param.get("surveyname") + " - " + strDate;
		param.put("surveyName", surveyName);
		setText(driver, testcaseName, survey_name, surveyName, test);
	}
	public void selectFolder(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, folder, test);
		click(driver, testcaseName, folder, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		click(driver, testcaseName, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		
	}
		
	public void selectPrimaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, primary_lanugage_dd, test);
		click(driver, testcaseName, primary_lanugage_dd, test);
		waitforElemPresent(driver, testcaseName, 30, primary_lanugage_list, test);
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[@class='o-menu-list-item'][contains(text(),'" + param.get("primarylanguage") + "')]"), param.get("primarylanguage"), test);
		click(driver, testcaseName, By.xpath("//div[@class='o-menu-list-item'][contains(text(),'" + param.get("primarylanguage") + "')]"), param.get("primarylanguage"), test);

		
	}
	
	public void selectSecondaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, secondary_language_switch, test);
		click(driver, testcaseName, secondary_language_switch,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd, test);
		click(driver, testcaseName, secondary_lanugage_dd,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd_search, test);
		setText(driver, testcaseName, secondary_lanugage_dd_search, param.get("secondarylanguage"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		click(driver, testcaseName, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);

		
	}
	

	/**
	 * Add Description question by using double click action.
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	public void addlanguages(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd, test);
		click(driver, testcaseName, secondary_lanugage_dd,test);
		//driver.findElement(By.xpath("//label[normalize-space()='Arabic']"));
		waitforElemPresent(driver, testcaseName, 10,   By.xpath("//label[normalize-space()='"+ param.get("secondarylanguage") +"']"), param.get("secondarylanguage"), test);        
	   	click(driver, testcaseName,  By.xpath("//label[normalize-space()='"+ param.get("secondarylanguage") +"']"), param.get("secondarylanguage"), test);        
	
	}
	
	public void enterDescription(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, description_button, test);
		waitForJStoLoad(driver, 30);
		doubleClick(driver, testcaseName, description_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("description"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("description") +"']"), "Description Added "+ param.get("description"), test);
	}
	
	
	
	
	
	public void enterDescriptionByDragWithMedia(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Actions act = new Actions(driver);
		
		waitforElemPresent(driver, testcaseName, 30, description_button, test);
		List<WebElement> qList = driver.findElements(By.xpath("//span[starts-with(@id,'Qtitle_')]"));
		
		// Drop the question on canvas if there are no questions added
		if(qList.size() == 0) {
			act.dragAndDrop(driver.findElement(By.xpath(DESCRIPTION_BUTTON)), driver.findElement(By.xpath(BLANK_PAGE))).build().perform();
		}
		else {
			//  Drop the question on top of all if any other questions are already added.
			scrollIntoCenter(driver, testcaseName, qList.get(0), "First Question", test);
			waitforElemPresent(driver, testcaseName, 30, qList.get(0), "First Question", test);
			act.dragAndDrop(driver.findElement(By.xpath(DESCRIPTION_BUTTON)), qList.get(0)).build().perform();
		}
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("description"), test);
		driver.switchTo().defaultContent();
		click(driver, testcaseName, add_media, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_add_media, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ADD_MEDIA)));
		waitforElemPresent(driver, testcaseName, 30, browse_label, test);
		click(driver, testcaseName, browse_label, test);
		//executeScript(driver, testcaseName, "arguments[0].style.display='block';", driver.findElement(By.xpath("//span[@class='media-container-browse-btn']/span")), test);
		driver.findElement(By.xpath(BROWSE)).sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("images"));
		
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 60, test);
		
		waitforElemPresent(driver, testcaseName, 10, save_and_go_back, test);
		click(driver, testcaseName, save_and_go_back, test);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("description") +"']"), "Description Added "+ param.get("description"), test);
	                                                             
	}
	
	
	public void enterNetPromoter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, net_promoter_score_button, test);
		doubleClick(driver, testcaseName, net_promoter_score_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		String netPromoterLabel = getText(driver, testcaseName, description_text, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']"), "Net Promoter Label Added "+ netPromoterLabel, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']/parent::div/following-sibling::div//div[@class='clearfix slider-div']"), "Net Promoter Label Added "+ netPromoterLabel, test);
	}	

	public void enterTextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, text_box_button, test);
		doubleClick(driver, testcaseName, text_box_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		//driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']"), "Text Box Label Added "+ param.get("textbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']/parent::div/following-sibling::div//input"), "Text Box Added "+ param.get("textbox"), test);
	}
	
	public void enterRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, radio_button, test);
		doubleClick(driver, testcaseName, radio_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']"), "Radio Buttons Label Added "+ param.get("radiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Radio Buttons Added "+ param.get("radiobutton"), test);
	}
	
	public void enterCheckBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, check_box_button, test);
		doubleClick(driver, testcaseName, check_box_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("checkbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, none_of_above, test);
		click(driver, testcaseName, none_of_above, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']"), "Check Box Label Added "+ param.get("checkbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Check Box Added "+ param.get("checkbox"), test);
	}
	
	
	public void answersLibrary(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, answers_library, test);
		click(driver, testcaseName, answers_library, test);
		waitForElementToBeVisible(driver, testcaseName, answers_library_new, 30, 100, test);
		waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
		setText(driver, testcaseName, search_ans_lib, answerOption, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
	}
	
	public void saveAnslibraryOptionsList(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		List<String> ansOptList = new ArrayList<>();
		List<WebElement> ansOptionWebList = driver.findElements(By.xpath("//div[@title='" + answerOption +"']/following-sibling::div/div[@class='subListItem']"));
		int ansCount = ansOptionWebList.size();
		for(WebElement webElement : ansOptionWebList) {
			String ansOption = webElement.getAttribute("title");
			if(ansOption.contains(",")) {
				ansOptList.add(ansOption.replaceAll(",", "/~/"));
			}
			else {
				ansOptList.add(ansOption);
			}
		}
		param.put("ansOptList", ansOptList.toString());
		param.put("ansCount", String.valueOf(ansCount));
	}
	
	public void answersLibraryGrid(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 10, answers_library, test);
			click(driver, testcaseName, answers_library, test);
			waitForElementToBeVisible(driver, testcaseName, answers_library_new, 30, 100, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
			new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		
		}
	
	public void answersLibrary2(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {String testcaseName = param.get("TestCaseName");
			waitforElemPresent(driver, testcaseName, 10, By.xpath("(//div[text()='More '])[2]"), "More", test);
			click(driver, testcaseName, By.xpath("(//div[text()='More '])[2]"), "More", test);
			
			waitforElemPresent(driver, testcaseName, 10, answers_library2, test);
			click(driver, testcaseName, answers_library2, test);
			waitForElementToBeVisible(driver, testcaseName, answers_library_grid, 30, 100, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"), answerOption + " category", test);
		//	new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"))).build().perform();
			WebElement hower = driver.findElement(By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"'][@class='ansListItem']"));
			Actions action = new Actions(driver);
			action.moveToElement(hower).perform();
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']//div[@title='"+ answerOption  +"']//div[@title='Use List']"), "Use List", test);
		}
	
	public void questionsLibrary(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//td[@align='center']//div[@class='clsMore']"), "More", test);
		click(driver, testcaseName, By.xpath("//td[@align='center']//div[@class='clsMore']"), "More", test);
		
		waitforElemPresent(driver, testcaseName, 20, questions_library2, test);
		click(driver, testcaseName, questions_library2, test);
		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options2, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS2)));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		Thread.sleep(3000);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().parentFrame();
		}
	
	public void questionsLibrary2(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		waitforElemPresent(driver, testcaseName, 10, questions_library3, test);
		click(driver, testcaseName, questions_library3, test);
		
		waitforElemPresent(driver, testcaseName, 10, get_questions_questions_library, test);
		click(driver, testcaseName, get_questions_questions_library, test);
		
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options3, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS3)));
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void enterDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, drop_down_button, test);
		doubleClick(driver, testcaseName, drop_down_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("dropdown"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']"), "Drop Down Label Added "+ param.get("dropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']/parent::div/following-sibling::div/div[@class='clsEdit ControlColorsDD']"), "Drop Down Added "+ param.get("dropdown"), test);
	}
	
	public void enterDemographicsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, demographics_button, test);
		doubleClick(driver, testcaseName, demographics_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("demographics"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, name_expand, test);
		click(driver, testcaseName, name_expand, test);
		waitforElemPresent(driver, testcaseName, 30, name_title, test);
		click(driver, testcaseName, name_title, test);
//		waitforElemPresent(driver, testcaseName, 30, name_full_name, test);
//		click(driver, testcaseName, name_full_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_first_name, test);
		click(driver, testcaseName, name_first_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_middle_name, test);
		click(driver, testcaseName, name_middle_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_last_name, test);
		click(driver, testcaseName, name_last_name, test);
		waitforElemPresent(driver, testcaseName, 30, gender, test);
		click(driver, testcaseName, gender, test);
		waitforElemPresent(driver, testcaseName, 30, dob, test);
		click(driver, testcaseName, dob, test);
		
		waitforElemPresent(driver, testcaseName, 30, address_expand, test);
		click(driver, testcaseName, address_expand, test);
		waitforElemPresent(driver, testcaseName, 30, address_street1, test);
		click(driver, testcaseName, address_street1, test);
		waitforElemPresent(driver, testcaseName, 30, address_street2, test);
		click(driver, testcaseName, address_street2, test);
		waitforElemPresent(driver, testcaseName, 30, address_city, test);
		click(driver, testcaseName, address_city, test);
		waitforElemPresent(driver, testcaseName, 30, address_country, test);
		click(driver, testcaseName, address_country, test);
		waitforElemPresent(driver, testcaseName, 30, address_state, test);
		click(driver, testcaseName, address_state, test);
		waitforElemPresent(driver, testcaseName, 30, address_zip, test);
		click(driver, testcaseName, address_zip, test);
//		waitforElemPresent(driver, testcaseName, 30, address_zipplus4, test);
//		click(driver, testcaseName, address_zipplus4, test);
		
		waitforElemPresent(driver, testcaseName, 30, telephone_expand, test);
		click(driver, testcaseName, telephone_expand, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_telephone, test);
		click(driver, testcaseName, telephone_telephone, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_extension, test);
		click(driver, testcaseName, telephone_extension, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_fax, test);
		click(driver, testcaseName, telephone_fax, test);
		
		waitforElemPresent(driver, testcaseName, 30, email_address, test);
		click(driver, testcaseName, email_address, test);
		waitforElemPresent(driver, testcaseName, 30, reenter_email_address, test);
		click(driver, testcaseName, reenter_email_address, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']"), "Demographics Label Added "+ param.get("demographics"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Demographics Added "+ param.get("demographics"), test);
	}
	
	public void enterRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_button, test);
		doubleClick(driver, testcaseName, rating_scale_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscale"), test);
		driver.switchTo().defaultContent();
		scrollIntoView(driver, testcaseName, show_na_option, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, show_na_option, test);
		click(driver, testcaseName, show_na_option, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_scale_in_reverse_order, test);
		click(driver, testcaseName, show_scale_in_reverse_order, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_participant_rating_field, test);
		click(driver, testcaseName, show_participant_rating_field, test);
		Thread.sleep(500);
		scrollIntoView(driver, testcaseName, save_button, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']"), "Rating Scale Added "+ param.get("ratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']/parent::div/following-sibling::div//div[contains(@class,'slide ui-slider ui-corner-all ui-slider-horizontal')]"), "Rating Scale Slider Added "+ param.get("ratingscale"), test);
	 
	}
	
	public void enterSymbolRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] subQuestions = param.get("subquestions").split(";");
		waitforElemPresent(driver, testcaseName, 30, symbol_rating_scale_button, test);
		doubleClick(driver, testcaseName, symbol_rating_scale_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("symbolratingscale"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, increase_srs_subque, test);
//		Commenting as drop down UI is changed to up/down button UI		
//		Select select = new Select(driver.findElement(By.xpath(NUMBER_SUBQUESTION)));
//		select.selectByVisibleText("6");
//		Thread.sleep(500);
		for(int i=0; i<5; i++) {
			click(driver, testcaseName, increase_srs_subque, test);
			Thread.sleep(500);
		}
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption1']"), "Sub Question 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption1']"), subQuestions[0], "Sub Question 1", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_1']"), "Sub Question 1 Scale", test);
		Select selectSubquestion1 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_1']")));
		selectSubquestion1.selectByVisibleText("Star");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption2']"), "Sub Question 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption2']"), subQuestions[1], "Sub Question 2", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_2']"), "Sub Question 2 Scale", test);
		Select selectSubquestion2 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_2']")));
		selectSubquestion2.selectByVisibleText("Thumb up");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption3']"), "Sub Question 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption3']"), subQuestions[2], "Sub Question 3", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_3']"), "Sub Question 3 Scale", test);
		Select selectSubquestion3 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_3']")));
		selectSubquestion3.selectByVisibleText("Heart");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption4']"), "Sub Question 4", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption4']"), subQuestions[3], "Sub Question 4", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_4']"), "Sub Question 4 Scale", test);
		Select selectSubquestion4 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_4']")));
		selectSubquestion4.selectByVisibleText("Check mark");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption5']"), "Sub Question 5", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption5']"), subQuestions[4], "Sub Question 5", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_5']"), "Sub Question 5 Scale", test);
		Select selectSubquestion5 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_5']")));
		selectSubquestion5.selectByVisibleText("Dollar sign");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption6']"), "Sub Question 6", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption6']"), subQuestions[5], "Sub Question 6", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_6']"), "Sub Question 6 Scale", test);
		Select selectSubquestion6 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_6']")));
		selectSubquestion6.selectByVisibleText("Person");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
	}
	
	public void enterLikeDislikeButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, like_dislike_button, test);
		doubleClick(driver, testcaseName, like_dislike_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		//driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("likedislike"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']"), "Like/Dislike Added "+ param.get("likedislike"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Like/Dislike Added "+ param.get("likedislike"), test);
	}
	
	public void enterRankingQuestionButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, ranking_question_button, test);
		doubleClick(driver, testcaseName, ranking_question_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ranking"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']"), "Ranking Added "+ param.get("ranking"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Ranking Added "+ param.get("ranking"), test);
	}
	
	public void enterDateButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, date_button, test);
		doubleClick(driver, testcaseName, date_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("date"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']"), "Date Added "+ param.get("date"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']/parent::div/following-sibling::div//div[@class='dateIcon']"), "Date Added "+ param.get("date"), test);
	}
	
	public void enterImageChoiceButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoView(driver, testcaseName, image_choice_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, image_choice_button, test);
		doubleClick(driver, testcaseName, image_choice_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("imagechoice"), test);
		driver.switchTo().defaultContent();
		String[] images = param.get("images").split(";");
		String[] reportingValue = param.get("reportingvalue").split(";");
		for(int i = 0; i < images.length; i++) {
			if(i == 0){
				waitforElemPresent(driver, testcaseName, 10, add_image_icon, test);
				click(driver, testcaseName, add_image_icon, test);
				waitforElemPresent(driver, testcaseName, 10, iframe_answer_options4, test);
				driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS4)));
			} else {
				waitforElemPresent(driver, testcaseName, 10, add_image_icon2, test);
				click(driver, testcaseName, add_image_icon2, test);
			}
			
			waitForLoad(driver, testcaseName, 60, test);

			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + images[i]);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 10, reporting_value, test);
			setText(driver, testcaseName, reporting_value, reportingValue[i], test);
		}
		waitforElemPresent(driver, testcaseName, 10, save_button_ind, test);
		click(driver, testcaseName, save_button_ind, test);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']"), "Image Choice Added "+ param.get("imagechoice"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']"), "Image Choice Added "+ param.get("imagechoice"), test);
		Thread.sleep(1000);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']")).size();
		if(size == images.length) {
			reportPass("Image choice options added in the survey", test);
		} else {
			reportFail(testcaseName, "Image choice options not added in the survey", test);
		}
	}
	
	public void enterMultipleTextBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, multiple_textbox_button, test);
		waitforElemPresent(driver, testcaseName, 30, multiple_textbox_button, test);
		doubleClick(driver, testcaseName, multiple_textbox_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		//driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multitextbox"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, multi_text1, test);
		setText(driver, testcaseName, multi_text1, param.get("textbox1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_text2, test);
		setText(driver, testcaseName, multi_text2, param.get("textbox2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Text Box options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Text Box options not added in the survey", test);
		}
	}
	
	public void enterMultiDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_dropdown_button, test);
		doubleClick(driver, testcaseName, multiple_dropdown_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		//driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multidropdown"), test);
		driver.switchTo().defaultContent();
		answersLibraryGrid(driver, param, param.get("AnswerOptions1"), test);
		
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown1, test);
		setText(driver, testcaseName, multi_dropdown1, param.get("dropdown1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown2, test);
		setText(driver, testcaseName, multi_dropdown2, param.get("dropdown2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Drop Down options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Drop Down options not added in the survey", test);
		}
	}
	
	public void enterRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_radio_button, test);
		doubleClick(driver, testcaseName, multiple_radio_button, test);
		Thread.sleep(2000);
		waitForLoad(driver, testcaseName, 60, test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		
		
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multiradio"), test);
		driver.switchTo().parentFrame();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
//		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']"), "Radio Grid Added "+ param.get("multiradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Radio Grid Added "+ param.get("multiradio"), test);
		
	}
	
	public void enterCheckBoxGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_checkbox_button, test);
		doubleClick(driver, testcaseName, multiple_checkbox_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multicheckbox"), test);
		driver.switchTo().parentFrame();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		
	}
	
	public void enterRatingRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio_button, test);
		doubleClick(driver, testcaseName, rating_radio_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradio"), test);
		driver.switchTo().parentFrame();
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 1']"), "Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 1']"), "Yes", "Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 2']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 2']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 3']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 3']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "0", "Weight 3", test);
		
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		
	}
	
	public void enterRatingDropDownGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_drop_down_button, test);
		doubleClick(driver, testcaseName, rating_drop_down_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdown"), test);
		driver.switchTo().parentFrame();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		click(driver, testcaseName, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_add_manually, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ADD_MANUALLY)));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_0']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_0']"), "Yes", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_1']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_1']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_2']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_2']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_0']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_0']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_1']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_1']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_2']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_2']"), "0", "Weight 3", test);
		waitforElemPresent(driver, testcaseName, 10, save_button_manual, test);
		click(driver, testcaseName, save_button_manual, test);
		driver.switchTo().parentFrame();
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		
	}
	
	public void enterRatingScaleGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_grid_button, test);
		doubleClick(driver, testcaseName, rating_scale_grid_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscalegrid"), test);
		driver.switchTo().parentFrame();

		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		click(driver, testcaseName, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		click(driver, testcaseName, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtNA_0']"), "Weight NA", test);
		click(driver, testcaseName, By.xpath("//input[@name='txtNA_0']"), "Weight NA", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtNA_0']"), "NA", "Weight NA", test);

		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		
	}
	
	public void enterMatrixGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, matrix_grid_button, test);
		doubleClick(driver, testcaseName, matrix_grid_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("matrixgrid"), test);
		driver.switchTo().parentFrame();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_Header']"), "Radio Grid Header", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_Header']"), "Radio Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_Header']"), param.get("multiradio"), "Radio Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_Header']"), "Checkbox Grid Header", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_Header']"), "Radio Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_Header']"), param.get("multicheckbox"), "Checkbox Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Radio Choice 1", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Radio Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Yes", "Radio Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "Radio Choice 2", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_1_Choice']"), "Radio Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "No", "Radio Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "Radio Choice 3", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_0_2_Choice']"), "Radio Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "NA", "Radio Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Checkbox Choice 1", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Checkbox Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Yes", "Checkbox Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "Checkbox Choice 2", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_1_Choice']"), "Checkbox Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "No", "Checkbox Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "Checkbox Choice 3", test);
		click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_1_2_Choice']"), "Checkbox Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "NA", "Checkbox Choice 3", test);
		Thread.sleep(1000);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		
	}
	
	public void enterHorizontalRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoView(driver, testcaseName, horizontal_radio_button, test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, horizontal_radio_button, test);
		doubleClick(driver, testcaseName, horizontal_radio_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		//driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("horizontalradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']"), "Horizontal Radio Buttons Label Added "+ param.get("horizontalradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Horizontal Radio Buttons Added "+ param.get("horizontalradiobutton"), test);
	}
	
	public void enterNumericAllocationsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, numeric_allocations_button, test);
		doubleClick(driver, testcaseName, numeric_allocations_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("numericallocations"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
	}
	
	public void enterAttachmentButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, attachments_button, test);
		waitforElemPresent(driver, testcaseName, 30, attachments_button, test);
		doubleClick(driver, testcaseName, attachments_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("attachments"), test);
		driver.switchTo().defaultContent();
		questionsLibrary2(driver, param, param.get("QuestionOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']"), "Attachments Added "+ param.get("attachments"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Attachments Added "+ param.get("attachments"), test);
	}
	
	public void enterRatingRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio2_button, test);
		doubleClick(driver, testcaseName, rating_radio2_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']"), "Rating Radio Buttons "+ param.get("ratingradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Rating Radio Buttons Added "+ param.get("ratingradiobutton"), test);
	}
	
	public void enterRatingDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_dropdown_button, test);
		doubleClick(driver, testcaseName, rating_dropdown_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdownbutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']"), "Rating Drop Down "+ param.get("ratingdropdownbutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']/parent::div/following-sibling::div/div[@class='Search-DD-Container ControlColorsDD']"), "Rating Drop Down Buttons Added "+ param.get("ratingdropdownbutton"), test);
	}
	
	public void enterListBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, listbox_button, test);
		doubleClick(driver, testcaseName, listbox_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("listbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, other_checkbox2, test);
		click(driver, testcaseName, other_checkbox2, test);
		waitForLoad(driver, testcaseName, 60, test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']"), "Listbox Added "+ param.get("listbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Listbox Added "+ param.get("listbox"), test);
		
	}
	
	public double goToDesignerPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		
		//Check if new dashboard is enabled or not
		boolean isShowNewAllProjectDashBoard = Boolean.parseBoolean((executeScript(driver, testcaseName, "return isShowNewAllProjectDashBoard", test).toString()));
		
		//For new dashboard changes
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
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_edit_icon, 60, 100, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.new_edit_icon, test);
		}
		//For old dashboard
		else {		
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, surveyTitle, test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[@sid='"+SID+"']"), "Survey ID "+SID, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+SID+"']"));
			new Actions(driver).moveToElement(survey).perform();
			waitforElemPresent(driver, testcaseName, 60, IHomePage.edit_icon, test);
			start = System.currentTimeMillis();		
			click(driver, testcaseName, IHomePage.edit_icon, test);
		}
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	/**
	 * Use this method to get String Array of ZarcaQIDs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<String> getZarcaQIDs(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		ArrayList<Object> pageQuestionData = new ArrayList<Object>();
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		String script = "return SurveyJson.PageQuestion;";
		pageQuestionData = (ArrayList<Object>) executeScript(driver, testcaseName, script, test);
		Iterator<Object> iterator = pageQuestionData.iterator();
		while(iterator.hasNext()) {
			Map<String, Object> temp =  (Map<String, Object>) iterator.next();
			zarcaQIDs.add(temp.get("QID").toString());
		}
		return zarcaQIDs;	
	}
	
	private Boolean chooseCategory(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		// Execute for loop on categoryList and break the loop once the condition is satisfied
		List<WebElement> categoryList = getWebElements(driver, testcaseName, category_list, test);
		for (int i =0; i<categoryList.size(); i++) {
			WebElement category = categoryList.get(i);
			// Remove the leading and trailing white space to prevent NumberFormatException, that is it will convert String " 81 " to "81" and then convert String to Integer
			int questioncount = Integer.parseInt(category.getAttribute("questioncount").strip()); 
			//Check question count before depositing the question to prevent getting JS message of exhausted limit
			if (questioncount<100) {
				String categoryTitle = category.getAttribute("title");
				WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Type here to search'][@ng-change='fnSearchText()']"));
				searchField.sendKeys(categoryTitle);
				category.click();
				test.log(Status.INFO, categoryTitle +" has been selected");
				Add_Log.info(categoryTitle +" has been selected");
				Reporter.log(categoryTitle +" has been selected");
				isCategoryFound = true;

				break;	
			}
			
		}
		return isCategoryFound;
		
	}
	
	
	public void selectCategoryFromQBList(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		Boolean isCategoryFound = false;
		waitForLoad(driver, testcaseName, 60, test);
		click(driver, testcaseName, drop_down_of_select_category, test);
		isCategoryFound = chooseCategory(driver, param, test);
		if(isCategoryFound == false) {
			Calendar calendar = Calendar.getInstance();
			String newCategoryName = "Category : " + calendar.getTime();
			click(driver, testcaseName, add_category, test);
			try {
				//waitforElemPresent(driver, testcaseName, 30, toaster_msg, test);
				if(driver.findElement(By.xpath(TOASTER_MSG)).getAttribute("innerHTML").
						contains("You may create up to 50 custom Question Bank categories. Delete one or more to create new categories.")) {
					test.log(Status.INFO, "More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					Add_Log.info("More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					Reporter.log("More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");	
					TestResultStatus.failureReason.add(testcaseName + "| More than 50 custom Question Bank categories found. Please delete one or more to create new categories.");
					TestResultStatus.TestFail = true;
					Assert.fail();
					}
				} catch(Exception e) {
					
				}		
				setText(driver, testcaseName, add_category_input_field, newCategoryName, test);
				click(driver, testcaseName, save_category_name, test);
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, toaster_msg_of_category_added, test);
				click(driver, testcaseName, close_toaster_msg, test);
				waitforElemNotVisible(driver, testcaseName, 60, toaster_msg_of_category_added, test);
				test.log(Status.INFO, "Category " + newCategoryName + " added");
				Add_Log.info("Category " + newCategoryName + " added");
				Reporter.log("Category " + newCategoryName + " added");
				click(driver, testcaseName, drop_down_of_select_category, test);
				chooseCategory(driver, param, test);
			
		}
	}
	

	
	
	public double depositeQuestionToQuestionBank(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		String placeholderText = null;
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		for(int i=0; i<100; i++) {	
			waitForLoad(driver, testcaseName, 60, test);
			WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
			new Actions(driver).moveToElement(firstQue_WebElement).build().perform();
			waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
			click(driver, testcaseName, question_menu_more_options, test);
			click(driver, testcaseName, deposite_to_question_bank_option, test);
			waitforElemPresent(driver, testcaseName, 60, deposite_to_question_bank_modal, test);
			//waitUntilReqCSSValue(driver, testcaseName, 60, deposite_to_question_bank_modal, "width", "363px", test);
			String width = getWebElement(driver, testcaseName, deposite_to_question_bank_modal, test).getCssValue("width");
			System.out.println("Width = "+width);
			
			selectCategoryFromQBList(driver, param, test);
			placeholderText = getWebElement(driver, testcaseName, drop_down_of_select_category_placeholder, test).getAttribute("innerHTML");
			
			start = System.currentTimeMillis();
			click(driver, testcaseName, deposite_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 60, toaster_msg, test);
			end = System.currentTimeMillis();
			
			Thread.sleep(1000);
			System.out.println(getWebElement(driver, testcaseName, toaster_msg, test).getAttribute("innerHTML"));
			if(getWebElement(driver, testcaseName, toaster_msg, test).getAttribute("innerHTML").contains("Question deposited to ")) {
				break;
			}
			
			test.log(Status.INFO, "Limit has been exhausted for "+ placeholderText + " category");
			Add_Log.info("Limit has been exhausted for "+ placeholderText + " category");
			Reporter.log("Limit has been exhausted for "+ placeholderText + " category");
			
		}
		
		test.log(Status.INFO, "Question is deposited under "+ placeholderText + " category");
		Add_Log.info("Question is deposited under "+ placeholderText + " category");
		Reporter.log("Question is deposited under "+ placeholderText + " category");
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	
	
	
	public double addComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> zarcaQIDs = new ArrayList<String>();
		zarcaQIDs = getZarcaQIDs(driver,param,test); // Store all zarca qids in a array
		WebElement firstQue_WebElement = driver.findElement(By.xpath("//div[contains(@id,'qted_" + zarcaQIDs.get(0) + "')]"));
		dragAndDropAction2(driver, testcaseName, question_descriptive_text, firstQue_WebElement, test);
		waitForLoad(driver, testcaseName, 60, test);
		
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, descrText, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 60, test);
//		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ descrText +"']"), "Description Added "+ descrText, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	public double deleteComment(WebDriver driver, HashMap<String, String> param, String descrText, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Boolean isDescipTextFound = false;
		long totalQuestions = (Long) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion.length;", test);
		int totalUniqueQuestions = Integer.parseInt((String) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion[" +(totalQuestions-1) +"].uniqueqno;", test));
		
		for (int i= 0; i<totalUniqueQuestions; i++) {
			List<WebElement> questionList = getWebElements(driver, testcaseName, list_of_question_in_survey, test);
			WebElement question = questionList.get(i);
			scrollIntoView(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
			// Check qno attribute for each element, for comment question type qno = 'Ci', where, i=1,2,3....n.
			if(question.getAttribute("qno").contains("C")) {
				scrollIntoCenter(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				hoverAction(driver, testcaseName, question, "Question number "+question.getAttribute("qno"), test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_delete_option, test);	
				
				start = System.currentTimeMillis();
				driver.switchTo().alert().accept();
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				isDescipTextFound = true;
				break;
				
			}
			waitforElemNotVisible(driver, testcaseName, 60, question_page_loader, test);
			Thread.sleep(600);
				
		}			
		if (isDescipTextFound == false) {
			click(driver, testcaseName, page_number_drop_down, test);
			List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
			click(driver, testcaseName, surveyPages.get(0), "Page No 1", test);
			waitForElementToBePresentOnDOM(driver, testcaseName, 60, page_number_drop_down_value_1, test);		
			addComment(driver, param, descrText, test);
			hoverAction(driver, testcaseName, By.xpath("//span[contains(text(),'" + descrText + "')]"),
					"Description Question - Added via addComment method", test);
			click(driver, testcaseName, question_menu_delete_option, test);

			start = System.currentTimeMillis();
			driver.switchTo().alert().accept();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 60, designer_button, test);
			end = System.currentTimeMillis();
		}
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	public double movePage(WebDriver driver, HashMap<String, String> param, int pageNo, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectQuestionPage(driver, param, pageNo, test);
		click(driver, testcaseName, page_actions, test);
		click(driver, testcaseName, move_page, test);		
		Select select = new Select(getWebElement(driver, testcaseName, move_page_options, test));
		
		start = System.currentTimeMillis();
		select.selectByValue("2");
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, page_number_drop_down, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	public double moveMatrixGrid(WebDriver driver, HashMap<String, String> param, String SID, ExtentTest test) throws InterruptedException {
		
		String testcaseName = param.get("TestCaseName");
		Boolean isMatrixGridFound = false;
		String qtitle = null;
		List<WebElement> questions = null;
		long totalQuestions = (Long) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion.length;", test);
		int totalUniqueQuestions = Integer.parseInt((String) executeScript(driver, testcaseName, "return SurveyJson.PageQuestion[" +(totalQuestions-1) +"].uniqueqno;", test));
		
		for(int i=0; i<totalUniqueQuestions; i++) {
			questions = getWebElements(driver, testcaseName, question_title, test);
			try {
				qtitle = questions.get(i).getAttribute("qtitle");
			}catch (IndexOutOfBoundsException e) {
				executeScript(driver, testcaseName, "return window.scrollTo(0, document.body.scrollHeight);", test);
				waitForJStoLoad(driver, 30);
				questions = getWebElements(driver, testcaseName, question_title, test);
				qtitle = questions.get(i).getAttribute("qtitle");
			}
			scrollIntoCenter(driver, testcaseName, questions.get(i), "Question : " + questions.get(i).getAttribute("qtitle"), test);
			
			if(questions.get(i).getAttribute("bind-html-compile").contains("matrix")) {
				scrollIntoCenter(driver, testcaseName, questions.get(i), "Question : " + qtitle, test);
				hoverAction(driver, testcaseName, questions.get(i), "Question : " + qtitle, test);
				waitForElementToBePresentOnDOM(driver, testcaseName, 60, question_menu, test);
				click(driver, testcaseName, question_menu_more_options, test);
				click(driver, testcaseName, move_question, test);
				String moveTo = getWebElements(driver, testcaseName, move_question_options, test).get(0)
						.getAttribute("innerHTML");

				start = System.currentTimeMillis();
				click(driver, testcaseName, getWebElements(driver, testcaseName, move_question_options, test).get(0),
						"First options in Move side menu", test);
				waitForLoad(driver, testcaseName, 60, test);
				waitforElemPresent(driver, testcaseName, 60, designer_button, test);
				end = System.currentTimeMillis();
				
				test.log(Status.INFO, "Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				Add_Log.info("Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				Reporter.log("Successfully moved Matrix grid question " + qtitle + " to " + moveTo);
				
				isMatrixGridFound = true;
				break;
			} 
			Thread.sleep(1000);
		}
		
		if (isMatrixGridFound == false) {
			test.log(Status.INFO, "Matrix grid question is not found in survey SID : " + SID);
			Add_Log.info("Matrix grid question is not found in survey SID : " + SID);
			Reporter.log("Matrix grid question is not found in survey SID : " + SID);	
			TestResultStatus.failureReason.add(testcaseName + "| Matrix grid question is not found in survey SID : " + SID);
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
		
	}
	
	
	public void copySurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException  {
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
			waitForElementToBeVisible(driver, testcaseName, IHomePage.new_copy_icon, 10, 100, test);
			click(driver, testcaseName, IHomePage.new_copy_icon, test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.new_copy_drop_down, test);
			click(driver, testcaseName, IHomePage.new_copy_in_same_acc, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitForJStoLoad(driver, 60);
			
			//Rename survey title of Copied Survey
			waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("Survey Title"), test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 120, test);
			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("Survey Title") +"\"]"), param.get("Survey Title"), 60, 100, test);
			click(driver, testcaseName, getWebElements(driver, testcaseName, IHomePage.new_survey_title, test).get(0), "Survey Title", test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.new_edit_survey_title, test);
			clearText(driver, testcaseName, IHomePage.new_edit_survey_title, test);
			Thread.sleep(1000);
			
			//Save Survey title Copied survey
			param.put("copiedSurveyTitle", testcaseName +" -" + DateFormatUtils.format(new Date(), "dd-MMM-yyyy HH:mm:ss"));
			setText(driver, testcaseName, IHomePage.new_edit_survey_title, param.get("copiedSurveyTitle") , test);
			click(driver, testcaseName, IHomePage.new_save_survey_title, test);
			waitforElemNotVisible(driver, testcaseName, 30, IHomePage.small_loader, test);
			waitForJStoLoad(driver, 30);
			
//			waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
//			clearText(driver, testcaseName, IHomePage.new_search_bar, test);
//			Thread.sleep(1000);
//			setText(driver, testcaseName, IHomePage.new_search_bar, param.get("copiedSurveyTitle"), test);
//			driver.switchTo().defaultContent();	
//			waitForLoad(driver, testcaseName, 120, test);
//			switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
//			waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
//			waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + param.get("copiedSurveyTitle") +"\"]"), param.get("copiedSurveyTitle"), 60, 100, test);
			//Save Survey title and SID of Copied survey which always appears at first position
//			param.put("copiedSurveyTitle", driver.findElement(By.xpath(IHomePage.NEW_FIRST_ROW)).getAttribute("stitle"));
//			param.put("copiedSurveySID", driver.findElement(By.xpath(IHomePage.NEW_FIRST_ROW)).getAttribute("hoversurveyno"));
			
		
			test.log(Status.INFO, "Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle") 
			+ " .");
			Add_Log.info("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+ " .");
			Reporter.log("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+ " .");
		}
		// For old dashboard
		else {
			waitForElementToBeVisible(driver, testcaseName, IHomePage.main_folder, 30, 100, test);
			setText(driver, testcaseName, IHomePage.search_bar, param.get("Survey Title"), test);
			click(driver, testcaseName, IHomePage.search_icon, test);
			WebElement survey = driver.findElement(By.xpath("//div[@sid='"+param.get("SID")+"']"));
			new Actions(driver).moveToElement(survey).perform();
			waitForElementToBeVisible(driver, testcaseName, IHomePage.copy_icon, 10, 100, test);
			
			click(driver, testcaseName, IHomePage.copy_icon, test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.copy_drop_down, test);
			click(driver, testcaseName, IHomePage.copy_in_same_acc, test);
			waitForLoad(driver, testcaseName, 60, test);
			
			//Rename survey title of Copied Survey
			click(driver, testcaseName, getWebElements(driver, testcaseName, IHomePage.survey_title, test).get(0), "Survey Title", test);
			waitforElemPresent(driver, testcaseName, 30, IHomePage.edit_survey_title, test);
			clearText(driver, testcaseName, IHomePage.edit_survey_title, test);
			Thread.sleep(1000);
			
			setText(driver, testcaseName, IHomePage.edit_survey_title, testcaseName +" -" + DateFormatUtils.format(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss") , test);
			click(driver, testcaseName, IHomePage.save_survey_title, test);
			waitforElemNotVisible(driver, testcaseName, 30, IHomePage.small_loader, test);
			waitForJStoLoad(driver, 30);
			
			//Save Survey title and SID of Copied survey which always appears at first position
			param.put("copiedSurveyTitle", driver.findElement(By.xpath(IHomePage.FIRST_ROW)).getAttribute("stitle"));
			param.put("copiedSurveySID", driver.findElement(By.xpath(IHomePage.FIRST_ROW)).getAttribute("sid"));
			
			test.log(Status.INFO, "Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle") 
			+" and " +param.get("copiedSurveySID") + " respectively.");
			Add_Log.info("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+" and " +param.get("copiedSurveySID") + " respectively.");
			Reporter.log("Successfully copied the survey. Survey title and SID of copied survey is "+ param.get("copiedSurveyTitle")
			+" and " +param.get("copiedSurveySID") + " respectively.");
		}
		
		
	}
	
	/**
	 * This function creates all control survey
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	public void allControlSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		JsonObject rbcases = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\radioButtonCases.json", test);
		JsonObject rrbcases = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\ratingRadioButtonCases.json", test);
		JsonObject npscases = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\npsCases.json", test);

		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		createNewSurvey(driver, param, test);

//		addDescrQTbyDragnDrop(driver, param, test);
//		addDescrQTWithQHint(driver, param, test);
		
//		addNPSQTbyDragnDrop(driver, param, test);
//		addMandatoryNPSQT(driver, param, test);
//		addEncourageNPSQT(driver, param, test);
//		addNPSQTWithQHint(driver, param, test);
//		addTBCurrQTByDragnDrop(driver, param, test);
//		addTBCustomQTByDragnDrop(driver, param, test);
//		addTBEmailQTByDragnDrop(driver, param, test);
//		addTBNumQTByDragnDrop(driver, param, test);
//		addTBPercQTByDragnDrop(driver, param, test);
//		addTBPhoneQTByDragnDrop(driver, param, test);
//		addTBSSNQTByDragnDrop(driver, param, test);
//		addTBUsZipQTByDragnDrop(driver, param, test);
//		addTBUsZip4QTByDragnDrop(driver, param, test);
//		addPreReadTBGenQT(driver, param, test);
//		addPreEditTBGenQT(driver, param, test);
//		addPreHiddenTBGenQT(driver, param, test);
//		addPostShowTBGenQT(driver, param, test);
//		addPostHideTBGenQT(driver, param, test);
//		addShortTBGenQT(driver, param, test);
//		addPreEditShortTBGenQT(driver, param, test);
//		addPostShowShortTBGenQT(driver, param, test);
//		addMandatoryTBGenQT(driver, param, test);
//		addEncourageTBGenQT(driver, param, test);
//		addDescription(driver, param, test);
//		addNPS(driver, param, test);
//		addTBGenQTByDragnDrop(driver, param, test);
		
		addNPS(driver, param, npscases.get("case 1").getAsJsonObject(), test);
		addNPS(driver, param, npscases.get("case 2").getAsJsonObject(), test);
		addNPS(driver, param, npscases.get("case 3").getAsJsonObject(), test);
		addNPS(driver, param, npscases.get("case 4").getAsJsonObject(), test);
		addNPS(driver, param, npscases.get("case 5").getAsJsonObject(), test);
		
//		addRadioButton(driver, param, rbcases.get("case 1").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 2").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 3").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 4").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 5").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 6").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 7").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 8").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 9").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 10").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 11").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 12").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 13").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 14").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 15").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 16").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 17").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 18").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 19").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 20").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 21").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 22").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 23").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 24").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 25").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 26").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 27").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 28").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 29").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 30").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 31").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 32").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 33").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 34").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 35").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 36").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 37").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 38").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 39").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 40").getAsJsonObject(), test);
//		addRadioButton(driver, param, rbcases.get("case 41").getAsJsonObject(), test);
//		
//		addRatingRadioButton(driver, param, rrbcases.get("case 1").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 2").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 3").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 4").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 5").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 6").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 7").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 8").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 9").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 10").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 11").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 12").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 13").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 14").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 15").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 16").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 17").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 18").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 19").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 20").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 21").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 22").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 23").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 24").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 25").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 26").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 27").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 28").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 29").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 30").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 31").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 32").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 33").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 34").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 35").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 36").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 37").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 38").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 39").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 40").getAsJsonObject(), test);
//		addRatingRadioButton(driver, param, rrbcases.get("case 41").getAsJsonObject(), test);
		

//		addCheckBox(driver, param, test);
//		addDropDown(driver, param, test);
//		addDemographic(driver, param, test);
//		addRatingScale(driver, param, test);
//		addSymbolRatingScale(driver, param, test);
//		addLikeDislike(driver, param, test);
//		addRanking(driver, param, test);
//		addDate(driver, param, test);
//		addImageChoice(driver, param, test);
//		addMTB(driver, param, test);
//		addMDD(driver, param, test);
//		addRadioGrid(driver, param, test);
//		addCheckBoxGrid(driver, param, test);
//		addRatingRadioGrid(driver, param, test);
//		addRatingDropDownGrid(driver, param, test);
//		addRatingScaleGrid(driver, param, test);
//		addHorizontalRadioButton(driver, param, test);
//		addListBox(driver, param, test);
		
//		addRatingDropDown(driver, param, test);
//		addAttachment(driver, param, test);
//		enterDescriptionByDragWithMedia(driver, param, test);
	}
	
	//// Commenting this part ///
	
//	/**
//	 * Add Description question by using drag and drop action.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDescrQTbyDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, description_button, test);
//		fillQueDetails(driver, param, description_button, test);
//		saveQue(driver, param, description_button, test);
//		}
//	
//	/**
//	 * Add Description question by using double click.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDescription(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, description_button, test);
//		fillQueDetails(driver, param, description_button, test);
//		saveQue(driver, param, description_button, test);
//		}	
//	
//	/**
//	 * Add Description question by using drag and drop action with Question hint
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDescrQTWithQHint(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, description_button, test);
//		fillQueDetails(driver, param, description_button, test);
//		addQustionHint(driver, param, description_button, test);
//		saveQue(driver, param, description_button, test);	
//		}
//	
//	/**
//	 * Add NPS question by using drag and drop action.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addNPSQTbyDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, net_promoter_score_button, test);
//		fillQueDetails(driver, param, net_promoter_score_button, test);
//		saveQue(driver, param, net_promoter_score_button, test);
//		}
//	
//	
	/**
	 * Add NPS question by using double click.
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	public void addNPS(WebDriver driver, HashMap<String, String> param, JsonObject npsCase, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		if(npsCase.get("action").getAsString().equals("Double Click")) {
			doubleClickOnQT(driver, param, net_promoter_score_button, test);
		}else {
			dragandDropQuest(driver, param, net_promoter_score_button, test);
		}
		
		fillQueDetails(driver, param, net_promoter_score_button, npsCase, test);
		
		if(!npsCase.get("defaultAnsLables").getAsBoolean()) {
			fillAnsOptionsDetails(driver, param, net_promoter_score_button, npsCase, test);
		}
		
		if(npsCase.get("isMandatory").getAsBoolean()) {
			makeQueMandatory(driver, param, net_promoter_score_button, npsCase, test);
		}
		
		if(npsCase.get("isEncourage").getAsBoolean()) {
			makeQueEncourage(driver, param, net_promoter_score_button, npsCase, test);
		}
		
		if(npsCase.get("isQuestionHint").getAsBoolean()) {
			param.put("quesHint", npsCase.get("questionHintText").getAsString());
			addQustionHint(driver, param, net_promoter_score_button, test);
		}
		
		saveQue(driver, param, net_promoter_score_button, npsCase, test);
		}
//	
//	/**
//	 * Add NPS question by using drag and drop action.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addMandatoryNPSQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, net_promoter_score_button, test);
//		fillQueDetails(driver, param, net_promoter_score_button, test);
//		makeQueMandatory(driver, param, net_promoter_score_button, test);
//		saveQue(driver, param, net_promoter_score_button, test);
//		}
//	
//	/**
//	 * Add NPS question by using drag and drop action.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addEncourageNPSQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, net_promoter_score_button, test);
//		fillQueDetails(driver, param, net_promoter_score_button, test);
//		makeQueEncourage(driver, param, net_promoter_score_button, test);	
//		saveQue(driver, param, net_promoter_score_button, test);
//		}
//	
//	/**
//	 * Add NPS question with question hint.
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addNPSQTWithQHint(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, net_promoter_score_button, test);
//		fillQueDetails(driver, param, net_promoter_score_button, test);
//		addQustionHint(driver, param, net_promoter_score_button, test);
//		saveQue(driver, param, net_promoter_score_button, test);
//		}
//	
//	/**
//	 * Add Tb general question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBGenQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb Currency question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBCurrQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Currency", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb Email question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBEmailQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Email", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb Phone Number question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBPhoneQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Phone Number", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb Number question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBNumQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Number", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * 	Add Tb Percentage question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBPercQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Percentage", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb SSN question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBSSNQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Social Security Number", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb US Zip code question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBUsZipQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "US ZIP Code", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb US Zip code + 4 question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBUsZip4QTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "US ZIP Code + 4", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Tb Custom question by using drag and drop action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addTBCustomQTByDragnDrop(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		dragandDropQuest(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "Custom", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add  Pre Read Only Tb general question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPreReadTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Pre Read", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add  Pre Edit Tb general question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPreEditTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Pre Edit", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Pre hidden Tb general question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPreHiddenTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Pre Hidden", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Post Show Tb general question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPostShowTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Post Show", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Post Hide Tb general question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPostHideTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Post Hide", test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Short Answer Text box question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addShortTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectShortAnsTextCheckbox(driver, param, text_box_button, test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Short Answer Text box question with Pre-Edit Data pop by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPreEditShortTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Pre Edit", test);
//		selectShortAnsTextCheckbox(driver, param, text_box_button, test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * Add Short Answer Text box question with Post-Show Data pop by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addPostShowShortTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		selectDataPop(driver, param, text_box_button, "Post Show", test);
//		selectShortAnsTextCheckbox(driver, param, text_box_button, test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * This function adds mandatory TB General question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addMandatoryTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		makeQueMandatory(driver, param, text_box_button, test);
//		saveQue(driver, param, text_box_button, test);
//		}
//	
//	/**
//	 * This function adds encourage TB General question by using double click action
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addEncourageTBGenQT(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, text_box_button, test);
//		fillQueDetails(driver, param, text_box_button, test);
//		selectTBFormat(driver, param, text_box_button, "General", test);
//		makeQueEncourage(driver, param, text_box_button, test);
//		saveQue(driver, param, text_box_button, test);
//		}
	
	/**
	 * This function adds radio button on designer page based on test data provided in rbCase jsonobject
	 * @param driver
	 * @param param
	 * @param rbCase
	 * @param test
	 * @throws InterruptedException
	 */
	public void addRadioButton(WebDriver driver, HashMap<String, String> param, JsonObject rbCase, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		if(rbCase.get("action").getAsString().equals("Double Click")) {
			doubleClickOnQT(driver, param, radio_button, test);
		}else {
			dragandDropQuest(driver, param, radio_button, test);
		}
		
		fillQueDetails(driver, param, radio_button, rbCase, test);
		
		if(rbCase.get("isDataPop").getAsBoolean()) {
			selectDataPop(driver, param, radio_button, rbCase.get("dataPopValue").getAsString(), test);
		}
		
		if(rbCase.get("isMandatory").getAsBoolean()) {
			makeQueMandatory(driver, param, radio_button, rbCase, test);
		}
		
		if(rbCase.get("isEncourage").getAsBoolean()) {
			makeQueEncourage(driver, param, radio_button, rbCase, test);
		}
		
		if(rbCase.get("isQuestionHint").getAsBoolean()) {
			param.put("quesHint", rbCase.get("questionHintText").getAsString());
			addQustionHint(driver, param, radio_button, test);
		}
		
//		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		fillAnsOptionsDetails(driver, param, radio_button, rbCase, test);
		
		if (rbCase.get("isOtherPleaseSpecify").getAsBoolean()) {
			includeOtherPleaseSpecify(driver, param, radio_button, rbCase, test);
		}
		
		if(rbCase.get("isRearrangeAnswers").getAsBoolean()) {
			rearrangeAnsOptions(driver, param, radio_button, rbCase, test);
		}
		
		if(!rbCase.get("answerSequence").getAsString().equalsIgnoreCase("As Entered")) {
			selectAnsSequence(driver, param, radio_button, rbCase, test);
		}
		
		saveQue(driver, param, radio_button, rbCase, test);
}

// Commenting this part for temporary //

//	/**
//	 * This function add simple Checkbox by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addCheckBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, check_box_button, test);
//		fillQueDetails(driver, param, check_box_button, test);
//		addAnswerOptionByNormalView(driver, param, check_box_button, test);
//		saveQue(driver, param, check_box_button, test);
//}
//	
//	/**
//	 * This function add simple Drop down by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDropDown(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, drop_down_button, test);
//		fillQueDetails(driver, param, drop_down_button, test);
//		addAnswerOptionByNormalView(driver, param, drop_down_button, test);
//		saveQue(driver, param, drop_down_button, test);
//}
//	/**
//	 * This function add simple Demographic by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDemographic(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, demographics_button, test);
//		fillQueDetails(driver, param, demographics_button, test);
//		selectDemoGraphicQuestions(driver, param, demographics_button, test);
//		saveQue(driver, param, demographics_button, test);
//}
//	
//	/**
//	 * This function add Rating scale by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRatingScale(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, rating_scale_button, test);
//		fillQueDetails(driver, param, rating_scale_button, test);
//		saveQue(driver, param, rating_scale_button, test);
//}
//	/**
//	 * This function add Symbol Rating scale by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addSymbolRatingScale(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, symbol_rating_scale_button, test);
//		fillQueDetails(driver, param, symbol_rating_scale_button, test);
//		setNumberOfSubquestions(driver, param, symbol_rating_scale_button, test);
//		fillSubquestionDetails(driver, param, symbol_rating_scale_button, test);
//		saveQue(driver, param, symbol_rating_scale_button, test);
//}
//	
//	/**
//	 * This function add Like-Dislike question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addLikeDislike(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, like_dislike_button, test);
//		fillQueDetails(driver, param, like_dislike_button, test);
//		saveQue(driver, param, like_dislike_button, test);
//}
//	
//	/**
//	 * This function add Ranking question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRanking(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, ranking_question_button, test);
//		fillQueDetails(driver, param, ranking_question_button, test);
//		addAnswerOptionByNormalView(driver, param, ranking_question_button, test);
//		saveQue(driver, param, ranking_question_button, test);
//}
//	
//	/**
//	 * This function add Date question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addDate(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, date_button, test);
//		fillQueDetails(driver, param, date_button, test);
//		saveQue(driver, param, date_button, test);
//}
//	/**
//	 * This function add Image choice question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addImageChoice(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, image_choice_button, test);
//		fillQueDetails(driver, param, image_choice_button, test);
//		uploadImages(driver, param, test);
//		saveQue(driver, param, image_choice_button, test);
//}
//	
//	private void uploadImages(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		String[] images = param.get("images").split(";");
//		String[] reportingValue = param.get("reportingvalue").split(";");
//		for(int i = 0; i < images.length; i++) {
//			if(i == 0){
//				waitforElemPresent(driver, testcaseName, 10, add_image_icon, test);
//				click(driver, testcaseName, add_image_icon, test);
//				waitforElemPresent(driver, testcaseName, 10, iframe_answer_options4, test);
//				driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS4)));
//			} else {
//				waitforElemPresent(driver, testcaseName, 10, add_image_icon2, test);
//				click(driver, testcaseName, add_image_icon2, test);
//			}
//			
//			waitForLoad(driver, testcaseName, 60, test);
//
//			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
//					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + images[i]);
//			Thread.sleep(1000);
//			waitForLoad(driver, testcaseName, 60, test);
//			waitforElemPresent(driver, testcaseName, 10, reporting_value, test);
//			setText(driver, testcaseName, reporting_value, reportingValue[i], test);
//		}
//		waitforElemPresent(driver, testcaseName, 10, save_button_ind, test);
//		click(driver, testcaseName, save_button_ind, test);
//		waitForLoad(driver, testcaseName, 60, test);
//		driver.switchTo().defaultContent();
//	}
//	
//	/**
//	 * This function add MTB question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addMTB(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, multiple_textbox_button, test);
//		fillQueDetails(driver, param, multiple_textbox_button, test);
//		setNumberOfSubquestions(driver, param, multiple_textbox_button, test);
//		fillSubquestionDetails(driver, param, multiple_textbox_button, test);
//		saveQue(driver, param, multiple_textbox_button, test);
//}
//	
//	/**
//	 * This function add MDD question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addMDD(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, multiple_dropdown_button, test);
//		fillQueDetails(driver, param, multiple_dropdown_button, test);
//		addAnswerOptionByNormalView(driver, param, multiple_dropdown_button, test);
//		setNumberOfSubquestions(driver, param, multiple_dropdown_button, test);
//		fillSubquestionDetails(driver, param, multiple_dropdown_button, test);
//		saveQue(driver, param, multiple_dropdown_button, test);
//}
//	
//	/**
//	 * This function add Radio grid question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRadioGrid(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, multiple_radio_button, test);
//		fillQueDetails(driver, param, multiple_radio_button, test);
//		setNumberOfSubquestions(driver, param, multiple_radio_button, test);
//		fillSubquestionDetails(driver, param, multiple_radio_button, test);
//		addAnswerOptionByNormalView(driver, param, multiple_radio_button, test);
//		saveQue(driver, param, multiple_radio_button, test);
//	}
//	
//	/**
//	 * This function add Check box grid question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addCheckBoxGrid(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, multiple_checkbox_button, test);
//		fillQueDetails(driver, param, multiple_checkbox_button, test);
//		setNumberOfSubquestions(driver, param, multiple_checkbox_button, test);
//		fillSubquestionDetails(driver, param, multiple_checkbox_button, test);
//		addAnswerOptionByNormalView(driver, param, multiple_checkbox_button, test);
//		saveQue(driver, param, multiple_checkbox_button, test);
//	}
//	
//	/**
//	 * This function add Rating Radio grid question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRatingRadioGrid(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, rating_radio_button, test);
//		fillQueDetails(driver, param, rating_radio_button, test);
//		setNumberOfSubquestions(driver, param, rating_radio_button, test);
//		fillSubquestionDetails(driver, param, rating_radio_button, test);
//		addAnswerOptionByNormalView(driver, param, rating_radio_button, test);
//		saveQue(driver, param, rating_radio_button, test);
//	}
//	
//	/**
//	 * This function add Rating Drop Down grid question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRatingDropDownGrid(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, rating_drop_down_button, test);
//		fillQueDetails(driver, param, rating_drop_down_button, test);
//		setNumberOfSubquestions(driver, param, rating_drop_down_button, test);
//		fillSubquestionDetails(driver, param, rating_drop_down_button, test);
//		addAnswerOptionByNormalView(driver, param, rating_drop_down_button, test);
//		saveQue(driver, param, rating_drop_down_button, test);
//	}
//	
//	/**
//	 * This function add Rating Scale grid question by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRatingScaleGrid(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, rating_scale_grid_button, test);
//		fillQueDetails(driver, param, rating_scale_grid_button, test);
//		setNumberOfSubquestions(driver, param, rating_scale_grid_button, test);
//		fillSubquestionDetails(driver, param, rating_scale_grid_button, test);
//		fillAnsOptionsInRSG(driver, param, rating_scale_grid_button, test);
//		saveQue(driver, param, rating_scale_grid_button, test);
//	}
//	
//	/**
//	 * This function add simple horizontal radio button by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addHorizontalRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, horizontal_radio_button, test);
//		fillQueDetails(driver, param, horizontal_radio_button, test);
//		addAnswerOptionByNormalView(driver, param, horizontal_radio_button, test);
//		saveQue(driver, param, horizontal_radio_button, test);
//}
//	
//	/**
//	 * This function add List box by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addListBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, listbox_button, test);
//		fillQueDetails(driver, param, listbox_button, test);
//		addAnswerOptionByNormalView(driver, param, listbox_button, test);
//		saveQue(driver, param, listbox_button, test);
//}
//	
	/**
	 * This function add Rating Radio button by using double click
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	public void addRatingRadioButton(WebDriver driver, HashMap<String, String> param, JsonObject rrbCase, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		if(rrbCase.get("action").getAsString().equals("Double Click")) {
			doubleClickOnQT(driver, param, rating_radio2_button, test);
		}else {
			dragandDropQuest(driver, param, rating_radio2_button, test);
		}
		
		fillQueDetails(driver, param, rating_radio2_button, rrbCase, test);
		
		if(rrbCase.get("isDataPop").getAsBoolean()) {
			selectDataPop(driver, param, rating_radio2_button, rrbCase.get("dataPopValue").getAsString(), test);
		}
		
		if(rrbCase.get("isMandatory").getAsBoolean()) {
			makeQueMandatory(driver, param, rating_radio2_button, rrbCase, test);
		}
		
		if(rrbCase.get("isEncourage").getAsBoolean()) {
			makeQueEncourage(driver, param, rating_radio2_button, rrbCase, test);
		}
		
		if(rrbCase.get("isQuestionHint").getAsBoolean()) {
			param.put("quesHint", rrbCase.get("questionHintText").getAsString());
			addQustionHint(driver, param, rating_radio2_button, test);
		}
		
		fillAnsOptionsDetails(driver, param, rating_radio2_button, rrbCase, test);
		
		if(rrbCase.get("isRearrangeAnswers").getAsBoolean()) {
			rearrangeAnsOptions(driver, param, rating_radio2_button, rrbCase, test);
		}
		
		if(!rrbCase.get("answerSequence").getAsString().equalsIgnoreCase("As Entered")) {
			selectAnsSequence(driver, param, rating_radio2_button, rrbCase, test);
		}
		
		saveQue(driver, param, rating_radio2_button, rrbCase, test);
}
//	
//	/**
//	 * This function add Rating Drop Down by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addRatingDropDown(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, rating_dropdown_button, test);
//		fillQueDetails(driver, param, rating_dropdown_button, test);
//		addAnswerOptionByNormalView(driver, param, rating_dropdown_button, test);
//		saveQue(driver, param, rating_dropdown_button, test);
//}
//	
//	/**
//	 * This function add Attachment by using double click
//	 * @param driver
//	 * @param param
//	 * @param test
//	 * @throws InterruptedException
//	 */
//	public void addAttachment(WebDriver driver, HashMap<String, String> param, ExtentTest test)
//			throws InterruptedException {
//		String testcaseName = param.get("TestCaseName");
//		doubleClickOnQT(driver, param, attachments_button, test);
//		fillQueDetails(driver, param, attachments_button, test);
//		setNumberOfSubquestions(driver, param, attachments_button, test);
//		fillSubquestionDetails(driver, param, attachments_button, test);
//		saveQue(driver, param, attachments_button, test);
//}

	
	/***
	 * Create function for every action which can be reused later for creating any other question types
	 * Action 1 : Drag and drop
	 * Action 2 : Fill necessary question details
	 * Action 3 : Save the Question type
	 * Action 4 : Add Question Hint
	 * Action 5 : Make question mandatory
	 * Action 6 : Make question encouraged
	 * Action 7 : Select Text box question format
	 * Action 8 : Select Data population type
	 * Action 9 : Double click on Question type
	 * Action 10 : Select Short Text Box question type
	 * Action 11 : Type Manually Answer options
	 * Action 12 : Select demographic fields
	 */

	/**
	 * Action 1 : Drag and drop
	 * Add given question type onto the question manager page by using drag drop action
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	private void dragandDropQuest(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Actions act = new Actions(driver);
		
		String quesType = getWebElement(driver, testcaseName, ele, test).getAttribute("id");
		param.put("quesType", quesType);
		
		waitforElemPresent(driver, testcaseName, 30, ele, test);
		List<WebElement> qList = driver.findElements(By.xpath("//span[starts-with(@id,'Qtitle_')]"));
		
		// Drop the question on canvas if there are no questions added
		if(qList.size() == 0) {
			act.dragAndDrop(getWebElement(driver, testcaseName, ele, test), driver.findElement(By.xpath(BLANK_PAGE))).build().perform();
		}
		else {
			//  Drop the question on top of all if any other questions are already added.
			scrollIntoCenter(driver, testcaseName, qList.get(0), "First Question", test);
			waitforElemPresent(driver, testcaseName, 30, qList.get(0), "First Question", test);
			act.dragAndDrop(getWebElement(driver, testcaseName, ele, test), qList.get(0)).build().perform();
		}
		waitForLoad(driver, testcaseName, 60, test);
		}
	
	
	
	/**
	 *  Action 2 : Fill necessary question details
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void fillQueDetails(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) 
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		String quesType = param.get("quesType");
		switch(quesType) {
		case "dvcom":
			if(qtCases.get("isRandomDescription").getAsBoolean()) {
				param.put("description", getQueDetails(param, "description", test));
			}else {
				param.put("description", qtCases.get("description").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("description"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrat_NPS":
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			
			if(qtCases.get("isDefaultQuestionText").getAsBoolean()) {
				param.put("netPromoterLabel", getText(driver, testcaseName, description_text, test));
			}else {
				clearText(driver, testcaseName, description_text, test);
				Thread.sleep(1000);
				param.put("netPromoterLabel", qtCases.get("question text").getAsString());
				setText(driver, testcaseName, description_text, param.get("netPromoterLabel"), test);
			}
			driver.switchTo().defaultContent();
			break;
		case "dvtb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("textbox", getQueDetails(param, "textbox", test));
			}else {
				param.put("textbox", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("textbox"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("radiobutton", getQueDetails(param, "radiobutton", test));
			}else {
				param.put("radiobutton", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvmscb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("checkbox", getQueDetails(param, "checkbox", test));
			}else {
				param.put("checkbox", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("checkbox"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvdd":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("dropdown", getQueDetails(param, "dropdown", test));
			}else {
				param.put("dropdown", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("dropdown"), test);
			driver.switchTo().defaultContent();
			break;	
		case "dvdemo":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("demographics", getQueDetails(param, "demographics", test));
			}else {
				param.put("demographics",  qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("demographics"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrat":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("ratingscale", getQueDetails(param, "ratingscale", test));
			}else {
				param.put("ratingscale", qtCases.get("question text").getAsString());
			}	
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingscale"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvGQ":
			param.put("symbolratingscale", getQueDetails(param, "symbolratingscale", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("symbolratingscale"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvLikeDislike":
			param.put("likedislike", getQueDetails(param, "likedislike", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("likedislike"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrk":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("ranking", getQueDetails(param, "ranking", test));
			}else {
				param.put("ranking", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ranking"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvdate":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("date", getQueDetails(param, "date", test));
			}else {
				param.put("date", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("date"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvIMC":
			param.put("imagechoice", getQueDetails(param, "imagechoice", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("imagechoice"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvmtb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("multitextbox", getQueDetails(param, "multitextbox", test));
			}else {
				param.put("multitextbox", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("multitextbox"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvmdd":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("multidropdown", getQueDetails(param, "multidropdown", test));
			}else {
				param.put("multidropdown", qtCases.get("question text").getAsString());
			}	
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("multidropdown"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrg":
			param.put("multiradio", getQueDetails(param, "multiradio", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("multiradio"), test);
			driver.switchTo().parentFrame();
			break;
		case "dvcbg":
			param.put("multicheckbox", getQueDetails(param, "multicheckbox", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("multicheckbox"), test);
			driver.switchTo().parentFrame();
			break;
		case "dvrrg":
			param.put("ratingradio", getQueDetails(param, "ratingradio", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingradio"), test);
			driver.switchTo().parentFrame();
			break;
		case "dvrddg":
			param.put("ratingdropdown", getQueDetails(param, "ratingdropdown", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingdropdown"), test);
			driver.switchTo().parentFrame();
			break;
		case "dvrcg":
			param.put("ratingscalegrid", getQueDetails(param, "ratingscalegrid", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingscalegrid"), test);
			driver.switchTo().parentFrame();
			break;
		case "dvHRB":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("horizontalradiobutton", getQueDetails(param, "horizontalradiobutton", test));
			}else {
				param.put("horizontalradiobutton", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("horizontalradiobutton"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvmslb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("listbox", getQueDetails(param, "listbox", test));
			}else {
				param.put("listbox", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("listbox"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvrrb":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("ratingradiobutton", getQueDetails(param, "ratingradiobutton", test));
			}else {
				param.put("ratingradiobutton", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingradiobutton"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvratdd":
			param.put("ratingdropdownbutton", getQueDetails(param, "ratingdropdownbutton", test));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("ratingdropdownbutton"), test);
			driver.switchTo().defaultContent();
			break;
		case "dvatt":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("attachments", getQueDetails(param, "attachments", test));
			}else {
				param.put("attachments", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("attachments"), test);
			driver.switchTo().defaultContent();
			break;
			
		case "dvNumeric":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("numericAllocation", getQueDetails(param, "numericAllocation", test));
			}else {
				param.put("numericAllocation", qtCases.get("question text").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("numericAllocation"), test);
			driver.switchTo().defaultContent();
			break;
		
		//Matrix Grid Question
		case "dvmg":
			if(qtCases.get("isRandomQuestiontext").getAsBoolean()) {
				param.put("matrixgrid", getQueDetails(param, "matrixgrid", test));
			}else {
				param.put("matrixgrid", qtCases.get("gridHeader").getAsString());
			}
			waitforElemPresent(driver, testcaseName, 30, iframe_answer_grid, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_GRID)));
			waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
			waitforElemPresent(driver, testcaseName, 30, description_text, test);
			setText(driver, testcaseName, description_text, param.get("matrixgrid"), test);
			driver.switchTo().parentFrame();
			break;
		}
		
		
	}
	
	private String getQueDetails(HashMap<String, String> param, String quetype, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject surveyData = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\surveyData.json", test);
		JsonArray temp = surveyData.get(quetype).getAsJsonArray();
		int rnd = new Random().nextInt(temp.size());
		return temp.get(rnd).getAsString();
	}
		
	/**
	 * Action 3 : Save the Question type
	 * This function saves the question type
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private String saveQue(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) 
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		int size = 0;
		
		String quesType = param.get("quesType");
		switch(quesType) {
		case "dvcom":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("description") +"\"]"), "Description Added "+ param.get("description"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			break;
		case "dvrat_NPS":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("netPromoterLabel") +"\"]"), "Net Promoter Label Added "+ param.get("netPromoterLabel"), test);
			
			//Put QID in param
			param.put("QID",driver.findElement(By.xpath("//span[text()=\""+ param.get("netPromoterLabel") +"\"]")).getAttribute("id").split("_")[1]);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("netPromoterLabel") +"']/parent::div/following-sibling::div//div[@class='clearfix slider-div']"), "Net Promoter Label Added "+ param.get("netPromoterLabel"), test);
			
			// Validation mandatory icon is present or not. Check svg element for validation
			if(qtCases.get("isMandatory").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='imgMan_" + param.get("QID") + "']"), "Mandatory Icon", test);
				if(driver.findElement(By.xpath("//div[@id='imgMan_" + param.get("QID") + "']/*[@id='Layer_1']")).isDisplayed()) {
					reportPass("Mandatory icon for NPS Question is displayed", test);
				}else {
					reportFail(testcaseName, "Mandatory icon for NPS Question is not displayed", test);
				}			
			}
			
			// Validate Question Hint ToolTip content
			if(qtCases.get("isQuestionHint").getAsBoolean()) {
				if(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]")).isDisplayed()) {
					new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]"))).build().perform();
					String actualQHint = driver.findElement(By.xpath("//div[@id='divQuestionTip_" + param.get("QID") + "']")).getAttribute("innerHTML");
					String expctedQHint = qtCases.get("questionHintText").getAsString();
					assertEquals(actualQHint, expctedQHint, "Question Hint text is not matching with expected result.");
					reportPass("Question Hint for NPS is displayed", test);
				}else {
					reportFail(testcaseName, "Question Hint for NPS is not displayed", test);
				}
			}
			
			// Validate answer labels used in NPS question
			String actualNPSLabel0 = driver.findElement(By.xpath("//div[@id='sliders_" + param.get("QID") + "']/div/div[@id='like']/p[@ng-if='answer.weight==0']")).getAttribute("innerHTML");
			String actualNPSLabel10 = driver.findElement(By.xpath("//div[@id='sliders_" + param.get("QID") + "']/div/div[@id='like']/p[@ng-if='answer.weight==10']")).getAttribute("innerHTML");
			String expectedNPSLabel0 = null;
			String expectedNPSLabel10 = null;
			
			if(qtCases.get("defaultAnsLables").getAsBoolean()) {
				expectedNPSLabel0 = "Not at all Likely";
				expectedNPSLabel10 = "Extremely Likely";
			
			}else {
				expectedNPSLabel0 = qtCases.get("ansLabels").getAsJsonArray().get(0).getAsString();
				expectedNPSLabel10 = qtCases.get("ansLabels").getAsJsonArray().get(1).getAsString();
			}
			
			Assert.assertEquals(actualNPSLabel0, expectedNPSLabel0, "NPS lable is not matching for 0th value");
			Assert.assertEquals(actualNPSLabel10, expectedNPSLabel10, "NPS lable is not matching for 10th value");
						
			break;
		case "dvtb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("textbox") +"\"]"), "Text Box Label Added "+ param.get("textbox"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("textbox") +"\"]/parent::div/following-sibling::div//input"), "Text Box Added "+ param.get("textbox"), test);
			break;
		
		// Radio Button
		case "dvrb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("radiobutton") +"\"]"), "Radio Buttons Label Added "+ param.get("radiobutton"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			//Put QID in param
			param.put("QID",driver.findElement(By.xpath("//span[text()=\""+ param.get("radiobutton") +"\"]")).getAttribute("id").split("_")[1]);
			
			// Validate Answer options if display order is 1 Column
			if(qtCases.get("ansColumns").getAsString().equalsIgnoreCase("1 Column")) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("radiobutton") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Radio Buttons Added "+ param.get("radiobutton"), test);
				List<String> expectedansOptList = new ArrayList<>();
				
				// Add elements in expected answer option list from param if isRandomAnsoptiontext or isAnswerlibrary is set to true
				if(qtCases.get("isRandomAnsoptiontext").getAsBoolean() ||  qtCases.get("isAnswerlibrary").getAsBoolean()){
					List<String> rawList = Arrays.asList(param.get("ansOptList").replace("[", "").replace("]", "").split("\\s*,\\s*"));
					for(String ansOption : rawList) {
						if(ansOption.contains("/~/")) {
							expectedansOptList.add(ansOption.replaceAll("/~/", ","));
						}else {
							expectedansOptList.add(ansOption);
						}
					}
				}
				// Add elements in expected answer option list from json if isRandomAnsoptiontext is set to false
				else {
					// Check isRearrangeAnswers bit and sortBy is empty or not.
					// If isRearrangeAnswers == true and sortBy is empty then reordering of answer option is applied, and hence do not execute this block
					if(!(qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().isEmpty())) {
						for(int i=0; i<qtCases.get("answerOptionsText").getAsJsonArray().size(); i++) {
							expectedansOptList.add(i, qtCases.get("answerOptionsText").getAsJsonArray().get(i).getAsString());
						}
					}
					
				}
				
				// Change the order of expected answer option list based on sorting or rearrange order.
				if(qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().equalsIgnoreCase("AToZ")) {
					expectedansOptList = expectedansOptList.stream().sorted().collect(Collectors.toList());
				}else if (qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().equalsIgnoreCase("ZToA")){
					expectedansOptList = expectedansOptList.stream().sorted().collect(Collectors.toList());
					Collections.reverse(expectedansOptList);
				}else if (qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().isEmpty()) {
					expectedansOptList = Arrays.asList(param.get("ansOptList").replace("[", "").replace("]", "").split("\\s*,\\s*"));
				}
				
				List<WebElement> actualansOptList = driver.findElements(By.xpath("//div/div[@zqid='" + param.get("QID") +"']"));
				for(int i=0; i<expectedansOptList.size(); i++) {
					String actualAnsoptiontext = actualansOptList.get(i).getAttribute("innerHTML").trim();
					String expectedAnsoptiontext = expectedansOptList.get(i);
					assertEquals(actualAnsoptiontext, expectedAnsoptiontext, "Answer Option is not matching with expected result");
				}
				reportPass(expectedansOptList + " are validated on question manager page", test);
			}
			
			
			// Validation mandatory icon is present or not. Check svg element for validation
			if(qtCases.get("isMandatory").getAsBoolean()) {
				if(!(qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Read")
				|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Hidden") 
				|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Post Hide"))) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='imgMan_" + param.get("QID") + "']"), "Mandatory Icon", test);
					if(driver.findElement(By.xpath("//div[@id='imgMan_" + param.get("QID") + "']/*[@id='Layer_1']")).isDisplayed()) {
						reportPass("Mandatory icon for Radio button is displayed", test);
					}else {
						reportFail(testcaseName, "Mandatory icon for Radio button is not displayed", test);
					}
				}
				
			}
			
			// Validate Question Hint ToolTip content
			if(qtCases.get("isQuestionHint").getAsBoolean()) {
				if(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]")).isDisplayed()) {
					new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]"))).build().perform();
					String actualQHint = driver.findElement(By.xpath("//div[@id='divQuestionTip_" + param.get("QID") + "']")).getAttribute("innerHTML");
					String expctedQHint = qtCases.get("questionHintText").getAsString();
					assertEquals(actualQHint, expctedQHint, "Question Hint text is not matching with expected result.");
					reportPass("Question Hint for Radio button is displayed", test);
				}else {
					reportFail(testcaseName, "Question Hint for Radio button is not displayed", test);
				}
			}
			
			// Validate Data population cases if isDataPop is true
			if(qtCases.get("isDataPop").getAsBoolean()) {
				if(qtCases.get("dataPopValue").getAsString().contains("Pre Read")){
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img"), "Pre-Pop Image", test);
					if(driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img")).isDisplayed()) {
						new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img"))).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/div/div/div[text()='Data Population - Pre [Read Only] applied here!']"), "Pre Read Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img")).getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Read", test);
						}
						reportPass("Data Population icon is displayed on Radio button when Pre Read is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Radio button when Pre Read is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Pre Edit")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/div/div/div[text()='Data Population - Pre [Editable] applied here!']"), "Pre Edit Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Edit", test);
						}
						reportPass("Data Population icon is displayed on Radio button when Pre Edit is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Radio button when Pre Edit is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Pre Hidden")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/div/div/div[text()='Data Population - Pre [Hidden] applied here!']"), "Pre Hidden Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Hidden", test);
						}
						reportPass("Data Population icon is displayed on Radio button when Pre Hidden is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Radio button when Pre Hidden is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Post Show")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/div/div/div[text()='Data Population - Post [Show] applied here!']"), "Post Show Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Post Show", test);
						}
						reportPass("Data Population icon is displayed on Radio button when Post Show is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Radio button when Post Show is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Post Hide")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\"" +param.get("radiobutton") + "\"]/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/div/div/div[text()='Data Population - Post [Hide] applied here!']"), "Post Hide Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Post Hide", test);
						}
						reportPass("Data Population icon is displayed on Radio button when Post Hide is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Radio button when Post Hide is applied", test);
					}
				}
			}
			
			// Validate Other please specify label text and Text box width
			if (qtCases.get("isOtherPleaseSpecify").getAsBoolean()) {
				WebElement otherPlzSpecifyLable = driver.findElement(By.xpath("//div[@title='Edit'][@ zqid = '"+ param.get("QID") + "']"));
				WebElement otherPlzSpecifyTb = driver.findElement(By.xpath("//input[contains(@id, '" + param.get("QID") + "_OT_ID')]"));
				
				// Validate Other Please specify Lable text
				if(qtCases.get("isOtherPleaseSpecifyDefaultLable").getAsBoolean()) {
					assertEquals(otherPlzSpecifyLable.getAttribute("innerHTML").trim(), "Other (Please specify)", "Default Lable Text is not present");
					reportPass("Validated default lable text of Other Please specify choice", test);
				}else {
					assertEquals(otherPlzSpecifyLable.getAttribute("innerHTML").trim(), qtCases.get("otherPleaseSpecifyLableText").getAsString(), "Other Please Specify Lable text is not matching with given text");
					reportPass("Validated lable text of Other Please specify choice", test);
				}
				
				// Validate Other Please specify Tb Width
				//String width = otherPlzSpecifyTb.getCssValue("width");  // Return pixel value , need to discuss how to convert pixel to percentage value or vice versa
				String style = otherPlzSpecifyTb.getAttribute("style");
				String width = style.substring(style.indexOf("width: "));
				assertEquals(width.replace("width: ", "").replace(";", ""), qtCases.get("otherPleaseSpecifyWidth").getAsString().concat("%"), "Width of Other Please Specify Text Box is not matching");
				reportPass("Validated Width of Other Please Specify Text Box", test);
			}
			break;
			
		case "dvmscb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("checkbox") +"\"]"), "Check Box Buttons Label Added "+ param.get("checkbox"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("checkbox") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Check Box Added "+ param.get("checkbox"), test);
			break;
		case "dvdd":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("dropdown") +"\"]"), "Drop down Label Added "+ param.get("dropdown"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			//Put QID in param
			param.put("QID",driver.findElement(By.xpath("//span[text()=\""+ param.get("dropdown") +"\"]")).getAttribute("id").split("_")[1]);
			
			scrollIntoCenter(driver, testcaseName, By.xpath("//span[text()=\""+ param.get("dropdown") +"\"]"), param.get("dropdown"), test);
			int ansCount =  Integer.parseInt(param.get("ansCount"));
			// For searchable drop down
			if (ansCount>9) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("dropdown") +"\"]/parent::div/following-sibling::div//div[@class='Search-DD-Container ControlColorsDD']"), "Drop Down Added "+ param.get("dropdown"), test);
			}else {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("dropdown") +"\"]/parent::div/following-sibling::div//div[@class='clsEdit ControlColorsDD']"), "Drop Down Added "+ param.get("dropdown"), test);

			}
			break;
		case "dvdemo":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("demographics") +"\"]"), "Demographic Label Added "+ param.get("demographics"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("demographics") +"\"]/parent::div/following-sibling::div//table[@class='minColTable']"), "Demographic Added "+ param.get("demographics"), test);
			break;
		case "dvrat":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingscale") +"\"]"), "Rating Scale Added "+ param.get("ratingscale"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingscale") +"\"]/parent::div/following-sibling::div//div[contains(@class,'slide ui-slider ui-corner-all')]"), "Rating Scale Added "+ param.get("ratingscale"), test);
			break;
		case "dvGQ":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("symbolratingscale") +"\"]"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("symbolratingscale") +"\"]/parent::div/following-sibling::div//table[@class='minColTable ']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
			break;
		case "dvLikeDislike":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("likedislike") +"\"]"), "Like/Dislike Added "+ param.get("likedislike"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("likedislike") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Like/Dislike Added "+ param.get("likedislike"), test);
			break;
		case "dvrk":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ranking") +"\"]"), "Ranking Added "+ param.get("ranking"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ranking") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Ranking Added "+ param.get("ranking"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			break;
		case "dvdate":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("date") +"\"]"), "Date Added "+ param.get("date"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("date") +"\"]/parent::div/following-sibling::div//div[@class='dateIcon']"), "Date Added "+ param.get("date"), test);
			break;
		case "dvIMC":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("imagechoice") +"\"]"), "Image Choice Added "+ param.get("imagechoice"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("imagechoice") +"\"]/parent::div/following-sibling::div//li[@class='ng-scope']"), "Image Choice Added "+ param.get("imagechoice"), test);
			size = driver.findElements(By.xpath("//span[text()=\""+ param.get("imagechoice") +"\"]/parent::div/following-sibling::div//li[@class='ng-scope']")).size();
			if(size == param.get("images").split(";").length) {
				reportPass("Image choice options added in the survey", test);
			} else {
				reportFail(testcaseName, "Image choice options not added in the survey", test);
			}
			break;
		case "dvmtb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multitextbox") +"\"]"), "Multi Text Box Added "+ param.get("multitextbox"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multitextbox") +"\"]/parent::div/following-sibling::div//tr"), "Multi Text Box Added "+ param.get("multitextbox"), test);
			size = driver.findElements(By.xpath("//span[text()=\""+ param.get("multitextbox") +"\"]/parent::div/following-sibling::div//tr")).size();
			if (size == Integer.parseInt(param.get("MTBSubqueCount"))){
				reportPass("Multi Text Box options added in the survey", test);
			}else {
				reportFail(testcaseName, "Multi Text Box options not added in the survey", test);
			}
			break;
		case "dvmdd":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multidropdown") +"\"]"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multidropdown") +"\"]/parent::div/following-sibling::div//tr"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
			size = driver.findElements(By.xpath("//span[text()=\""+ param.get("multidropdown") +"\"]/parent::div/following-sibling::div//tr")).size();
			if(size == Integer.parseInt(param.get("MDDSubqueCount"))) {
				reportPass("Multi Drop Down options added in the survey", test);
			} else {
				reportFail(testcaseName, "Multi Drop Down options not added in the survey", test);
			}
			break;
		case "dvrg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multiradio") +"\"]"), "Radio Grid Added "+ param.get("multiradio"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multiradio") +"\"]/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Radio Grid Added "+ param.get("multiradio"), test);
			break;
		case "dvcbg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multicheckbox") +"\"]"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("multicheckbox") +"\"]/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
			break;
		case "dvrrg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingradio") +"\"]"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingradio") +"\"]/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
			break;
		case "dvrddg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingdropdown") +"\"]"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingdropdown") +"\"]/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
			break;
		case "dvrcg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingscalegrid") +"\"]"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingscalegrid") +"\"]/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
			break;
		case "dvHRB":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("horizontalradiobutton") +"\"]"), "Horizontal Radio Buttons Label Added "+ param.get("horizontalradiobutton"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("horizontalradiobutton") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Horizontal Radio Buttons Added "+ param.get("horizontalradiobutton"), test);
			break;
		case "dvmslb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("listbox") +"\"]"), "Listbox Added "+ param.get("listbox"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("listbox") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Listbox Added "+ param.get("listbox"), test);
			break;
		case "dvrrb":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingradiobutton") +"\"]"), "Rating Radio Buttons "+ param.get("ratingradiobutton"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			//Put QID in param
			param.put("QID",driver.findElement(By.xpath("//span[text()=\""+ param.get("ratingradiobutton") +"\"]")).getAttribute("id").split("_")[1]);
			
			// Validate Answer options if display order is 1 Column
			if(qtCases.get("ansColumns").getAsString().equalsIgnoreCase("1 Column")) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingradiobutton") +"\"]/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Rating Radio Buttons Added "+ param.get("ratingradiobutton"), test);
				List<String> expectedansOptList = new ArrayList<>();
				
				// Add elements in expected answer option list from param if isRandomAnsoptiontext or  isAnswerlibrary is set to true
				if(qtCases.get("isRandomAnsoptiontext").getAsBoolean() ||  qtCases.get("isAnswerlibrary").getAsBoolean()){
					List<String> rawList = Arrays.asList(param.get("ansOptList").replace("[", "").replace("]", "").split("\\s*,\\s*"));
					for(String ansOption : rawList) {
						if(ansOption.contains("/~/")) {
							expectedansOptList.add(ansOption.replaceAll("/~/", ","));
						}else {
							expectedansOptList.add(ansOption);
						}
					}
				}
				// Add elements in expected answer option list from json if isRandomAnsoptiontext is set to false
				else {
					// Check isRearrangeAnswers bit and sortBy is empty or not.
					// If isRearrangeAnswers == true and sortBy is empty then reordering of answer option is applied, and hence do not execute this block
					if(!(qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().isEmpty())) {
						for(int i=0; i<qtCases.get("answerOptionsText").getAsJsonArray().size(); i++) {
							expectedansOptList.add(i, qtCases.get("answerOptionsText").getAsJsonArray().get(i).getAsString());
						}
					}
					
				}
				
				// Change the order of expected answer option list based on sorting or rearrange order.
				if(qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().equalsIgnoreCase("AToZ")) {
					expectedansOptList = expectedansOptList.stream().sorted().collect(Collectors.toList());
				}else if (qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().equalsIgnoreCase("ZToA")){
					expectedansOptList = expectedansOptList.stream().sorted().collect(Collectors.toList());
					Collections.reverse(expectedansOptList);
				}else if (qtCases.get("isRearrangeAnswers").getAsBoolean() && qtCases.get("sortBy").getAsString().isEmpty()) {
					expectedansOptList = Arrays.asList(param.get("ansOptList").replace("[", "").replace("]", "").split("\\s*,\\s*"));
				}
			
				List<WebElement> actualansOptList = driver.findElements(By.xpath("//div/div[@zqid='" + param.get("QID") +"']"));
				for(int i=0; i<expectedansOptList.size(); i++) {
					String actualAnsoptiontext = actualansOptList.get(i).getAttribute("innerHTML").trim();
					String expectedAnsoptiontext = expectedansOptList.get(i);
					assertEquals(actualAnsoptiontext, expectedAnsoptiontext, "Answer Option is not matching with expected result");
				}
				reportPass(expectedansOptList + " are validated on question manager page", test);			
			}
			
			// Validation mandatory icon is present or not. Check svg element for validation
			if(qtCases.get("isMandatory").getAsBoolean()) {
				if(!(qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Read")
				|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Hidden") 
				|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Post Hide"))) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='imgMan_" + param.get("QID") + "']"), "Mandatory Icon", test);
					if(driver.findElement(By.xpath("//div[@id='imgMan_" + param.get("QID") + "']/*[@id='Layer_1']")).isDisplayed()) {
						reportPass("Mandatory icon for Rating Radio button is displayed", test);
					}else {
						reportFail(testcaseName, "Mandatory icon for Rating Radio button is not displayed", test);
					}
				}
				
			}
			
			// Validate Question Hint ToolTip content
			if(qtCases.get("isQuestionHint").getAsBoolean()) {
				if(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]")).isDisplayed()) {
					new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/parent::div//span[starts-with(@id,'QuesitonTip_')]"))).build().perform();
					String actualQHint = driver.findElement(By.xpath("//div[@id='divQuestionTip_" + param.get("QID") + "']")).getAttribute("innerHTML");
					String expctedQHint = qtCases.get("questionHintText").getAsString();
					assertEquals(actualQHint, expctedQHint, "Question Hint text is not matching with expected result.");
					reportPass("Question Hint for Radio button is displayed", test);
				}else {
					reportFail(testcaseName, "Question Hint for Rating Radio button is not displayed", test);
				}
			}
			
			// Validate Data population cases if isDataPop is true
			if(qtCases.get("isDataPop").getAsBoolean()) {
				if(qtCases.get("dataPopValue").getAsString().contains("Pre Read")){
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img"), "Pre-Pop Image", test);
					if(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img")).isDisplayed()) {
						new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img"))).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/div/div/div[text()='Data Population - Pre [Read Only] applied here!']"), "Pre Read Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Read Only']/img")).getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Read", test);
						}
						reportPass("Data Population icon is displayed on Rating Radio button when Pre Read is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Rating Radio button when Pre Read is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Pre Edit")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Editable']/div/div/div[text()='Data Population - Pre [Editable] applied here!']"), "Pre Edit Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Edit", test);
						}
						reportPass("Data Population icon is displayed on Rating Radio button when Pre Edit is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Rating Radio button when Pre Edit is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Pre Hidden")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hidden']/div/div/div[text()='Data Population - Pre [Hidden] applied here!']"), "Pre Hidden Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Pre Hidden", test);
						}
						reportPass("Data Population icon is displayed on Rating Radio button when Pre Hidden is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Rating Radio button when Pre Hidden is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Post Show")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Show']/div/div/div[text()='Data Population - Post [Show] applied here!']"), "Post Show Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Post Show", test);
						}
						reportPass("Data Population icon is displayed on Rating Radio button when Post Show is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Rating Radio button when Post Show is applied", test);
					}
				}else if(qtCases.get("dataPopValue").getAsString().contains("Post Hide")) {
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/img"), "Pre-Pop Image", test);
					WebElement dataPopImg = driver.findElement(By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/img"));
					if(dataPopImg.isDisplayed()) {
						new Actions(driver).moveToElement(dataPopImg).build().perform();
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@id='Qtitle_" + param.get("QID") + "']/ancestor::table[@class='tblAnswerBox']/tbody/tr/td/div[@id='questionProperties']/div/div[@ng-data='Hide']/div/div/div[text()='Data Population - Post [Hide] applied here!']"), "Post Hide Tooltip Content", test);
						
						// The naturalWidth attribute returns the original width of the image, and it is zero for a broken image
						if(dataPopImg.getAttribute("naturalWidth").equals("0")) {
							reportFail(testcaseName, "Data Population image is seen broken for Post Hide", test);
						}
						reportPass("Data Population icon is displayed on Rating Radio button when Post Hide is applied", test);
					}else {
						reportFail(testcaseName, "Data Population icon is not displayed on Rating Radio button when Post Hide is applied", test);
					}
				}
			}
			
			break;
		case "dvratdd":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingdropdownbutton") +"\"]"), "Rating Drop Down "+ param.get("ratingdropdownbutton"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("ratingdropdownbutton") +"\"]/parent::div/following-sibling::div/div[@class='clsEdit ControlColorsDD']"), "Rating Drop Down Buttons Added "+ param.get("ratingdropdownbutton"), test);
			break;
		case "dvatt":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("attachments") +"\"]"), "Attachments Added "+ param.get("attachments"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("attachments") +"\"]/parent::div/following-sibling::div//table[@class='minColTable ']"), "Attachments Added "+ param.get("attachments"), test);
			break;
		case "dvNumeric":
			waitforElemPresent(driver, testcaseName, 10, save_button, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button, test);
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("numericAllocation") +"\"]"), "Numeric allocation Added "+ param.get("numericAllocation"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()=\""+ param.get("numericAllocation") +"\"]/parent::div/following-sibling::div//table[@class='minColTable']"), "Numeric Allocation Answer Options Added "+ param.get("numericAllocation"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			
			break;
		case "dvmg":
			waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, save_button_return, test);
			driver.switchTo().defaultContent();
			waitForLoad(driver, testcaseName, 60, test);
			// Check if question is added or not
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
			end = System.currentTimeMillis();	
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
			
			break;
		
		}
		return strtotalTime;
	}
	
	/**
	 * Action 4 : Add Question Hint
	 *  This function add the question hint
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void addQustionHint(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, question_hint, test);
		waitforElemPresent(driver, testcaseName, 30, question_hint_tb, test);
		setText(driver, testcaseName, question_hint_tb, param.get("quesHint"), test);
	}
	
	/**
	 * Action 5 : Make question mandatory
	 * This function makes question mandatory
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void makeQueMandatory(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		String quesType = param.get("quesType");
		switch(quesType) {
		// Radio Button, Rating Radio Button
		case "dvrb":
		case "dvrrb":
			if(qtCases.get("isMandatory").getAsBoolean() && (qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Read")
					|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Hidden") 
					|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Post Hide"))) {
				
				// Pass the test if mandatory button is disabled and opacity of lable is 0.5
				if(!driver.findElement(By.xpath(MANDATORY_BTN)).isEnabled() && driver.findElement(By.xpath(MANDATORY_BTN_LABEL)).getCssValue("opacity").equals("0.5")) {
					reportPass("Mandatory button is seen disabled for "+ qtCases.get("dataPopValue").getAsString(), test);
				}else {
					reportFail(testcaseName, "Mandatory button is not seen disabled for "+ qtCases.get("dataPopValue").getAsString(), test);
				}
			}else {
				waitforElemPresent(driver, testcaseName, 30, mandatory_btn_label, test);
				click(driver, testcaseName, mandatory_btn_label, test);
			}
			break;
			
		// NPS Question
		case "dvrat_NPS":
			waitforElemPresent(driver, testcaseName, 30, mandatory_btn_label, test);
			click(driver, testcaseName, mandatory_btn_label, test);
			break;
		}
		
	}
	
	/**
	 * Action 6 : Make question encouraged
	 * This function makes question encourage
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void makeQueEncourage(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String quesType = param.get("quesType");
		switch(quesType) {
		// Radio Button, Rating Radio Button
		case "dvrb":
		case "dvrrb":
			if(qtCases.get("isEncourage").getAsBoolean() && (qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Read")
					|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Pre Hidden") 
					|| qtCases.get("dataPopValue").getAsString().equalsIgnoreCase("Post Hide"))) {
				
				// Pass the test if encourage button is disabled and opacity of lable is 0.5
				if(!driver.findElement(By.xpath(ENCOURAGE_BTN)).isEnabled() && driver.findElement(By.xpath(ENCOURAGE_BTN_LABEL)).getCssValue("opacity").equals("0.5")) {
					reportPass("Encourage button is seen disabled for "+ qtCases.get("dataPopValue").getAsString(), test);
				}else {
					reportFail(testcaseName, "Encourage button is not seen disabled for "+ qtCases.get("dataPopValue").getAsString(), test);
				}
			}else {
				waitforElemPresent(driver, testcaseName, 30, encourage_btn_label, test);
				click(driver, testcaseName, encourage_btn_label, test);
				waitforElemPresent(driver, testcaseName, 30, encourage_msg_tb, test);
			}
			break;
			
		//	NPS question
		case "dvrat_NPS":
			waitforElemPresent(driver, testcaseName, 30, encourage_btn_label, test);
			click(driver, testcaseName, encourage_btn_label, test);
			waitforElemPresent(driver, testcaseName, 30, encourage_msg_tb, test);
			break;
			
		}
		
	}
	
	/**
	 * Action 7 : Select Text box question format
	 * This function selects the Text box format
	 * @param driver
	 * @param param
	 * @param ele
	 * @param format
	 * @param test
	 * @throws InterruptedException
	 */
	private void selectTBFormat(WebDriver driver, HashMap<String, String> param, WebPageElements ele, String format, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, select_tb_format, test);
		selectByExactVisibleText(driver, testcaseName, select_tb_format, format, test);
		switch(format) {
		case "General":
			waitforElemPresent(driver, testcaseName, 30, max_words, test);
			break;
		case "Currency":
			waitforElemPresent(driver, testcaseName, 30, currency_symbol, test);
			break;
		case "Email":
			waitforElemPresent(driver, testcaseName, 30, re_enter_email, test);
			break;
		case "Phone Number":
			waitforElemPresent(driver, testcaseName, 30, validation_dd, test);
			break;
		case "Number":
			waitforElemPresent(driver, testcaseName, 30, allow_int_only, test);
			break;
		case "Percentage":
			waitforElemPresent(driver, testcaseName, 30, from_range_tb, test);
			break;
		case "Social Security Number":
			waitforElemPresent(driver, testcaseName, 30, validation_dd, test);
			break;
		case "US ZIP Code":
			waitforElemPresent(driver, testcaseName, 30, validation_dd, test);
			break;
		case "US ZIP Code + 4":
			waitforElemPresent(driver, testcaseName, 30, validation_dd, test);
			break;
		case "Custom":
			waitforElemPresent(driver, testcaseName, 30, custom_format_tb, test);
			setText(driver, testcaseName, custom_format_tb, param.get("Custom format"), test);
			break;
		}
		
	}
	
	/**
	 * Action 8 : Select Data population type
	 * Use this function to apply data population
	 * @param driver
	 * @param param
	 * @param ele
	 * @param dataPop
	 * @param test
	 * @throws InterruptedException
	 */
	private void selectDataPop(WebDriver driver, HashMap<String, String> param, WebPageElements ele, String dataPop, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, data_population_dd, test);
		click(driver, testcaseName, data_population_dd, test);
		waitforElemPresent(driver, testcaseName, 30, data_population_menu, test);
		switch(dataPop) {
		case "Pre Read":
			waitforElemPresent(driver, testcaseName, 30, pre_read, test);
			click(driver, testcaseName, pre_read, test);
			break;
		case "Pre Edit":
			waitforElemPresent(driver, testcaseName, 30, pre_edit, test);
			click(driver, testcaseName, pre_edit, test);
			break;
		case "Pre Hidden":
			waitforElemPresent(driver, testcaseName, 30, pre_hidden, test);
			click(driver, testcaseName, pre_hidden, test);
			break;
		case "Post Show":
			waitforElemPresent(driver, testcaseName, 30, post_show, test);
			click(driver, testcaseName, post_show, test);
			break;
		case "Post Hide":
			waitforElemPresent(driver, testcaseName, 30, post_hide, test);
			click(driver, testcaseName, post_hide, test);
			break;
		}
		
	}
	
	/**
	 * Action 9 : Double click on Question type
	 * Add given question type onto the question manager page by double click
	 * @param driver
	 * @param param
	 * @param test
	 * @throws InterruptedException
	 */
	private String doubleClickOnQT(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitForJStoLoad(driver, 30);
		scrollIntoView(driver, testcaseName, ele, test);
		waitforElemPresent(driver, testcaseName, 30, ele, test);
		waitForJStoLoad(driver, 30);
		
		String quesType = getWebElement(driver, testcaseName, ele, test).getAttribute("id");
		param.put("quesType", quesType);
		
		// Capture page load time
		start = System.currentTimeMillis();		
		doubleClick(driver, testcaseName, ele, test);		
		
		try {
			switch(quesType) {
			
			case "dvcom":
				if(driver.findElement(By.xpath(DESCRIPTION_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;				
			case "dvrat_NPS":
				if(driver.findElement(By.xpath(NPS_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvtb":
				if(driver.findElement(By.xpath(TB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrb":
				if(driver.findElement(By.xpath(RB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvdd":
				if(driver.findElement(By.xpath(DD_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvdemo":
				if(driver.findElement(By.xpath(DEMO_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrat":
				if(driver.findElement(By.xpath(RATING_SCALE_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvGQ":
				if(driver.findElement(By.xpath(SYMBOL_RATING_SCALE_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvLikeDislike":
				if(driver.findElement(By.xpath(LIKE_DISLIKE_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrk":
				if(driver.findElement(By.xpath(RANKING_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvdate":
				if(driver.findElement(By.xpath(DATE_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvIMC":
				if(driver.findElement(By.xpath(IMC_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvmtb":
				if(driver.findElement(By.xpath(MTB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvmdd":
				if(driver.findElement(By.xpath(MDD_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrg":
				if(driver.findElement(By.xpath(RG_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvcbg":
				if(driver.findElement(By.xpath(CBG_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrrg":
				if(driver.findElement(By.xpath(RRG_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrddg":
				if(driver.findElement(By.xpath(RDDG_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrcg":
				if(driver.findElement(By.xpath(RSG_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvHRB":
				if(driver.findElement(By.xpath(HRB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvmslb":
				if(driver.findElement(By.xpath(LB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvrrb":
				if(driver.findElement(By.xpath(RRB_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvratdd":
				if(driver.findElement(By.xpath(RDD_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvatt":
				if(driver.findElement(By.xpath(ATTACHMENT_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvNumeric":
				if(driver.findElement(By.xpath(NUMERICAL_ALLOCATION_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			case "dvmg":
				if(driver.findElement(By.xpath(MATRIX_GRID_SAMPLE)).isDisplayed()) {
					test.log(Status.INFO, "Question sample displayed on performing double click, hence performing double click again.");
					Add_Log.info("Question sample displayed on performing double click, hence performing double click again.");
					Reporter.log("Question sample displayed on performing double click, hence performing double click again.");
					waitforElemPresent(driver, testcaseName, 30, ele, test);
					start = System.currentTimeMillis();		
					doubleClick(driver, testcaseName, ele, test);
				}
				break;
			}
			
		}catch(NoSuchElementException e) {
			
		}
		waitForLoad(driver, testcaseName, 60, test);
		
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		return strtotalTime;
	}
	
	/**
	 * Action 10 : Select Short Text Box question type
	 * Use this function to allow Tb general to be used as Short Answer text
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void selectShortAnsTextCheckbox(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, short_ans_text_cb, test);
		click(driver, testcaseName, short_ans_text_cb, test);
	}
	
	/**
	 * Action 11 : Type Manually Answer options
	 * Use this function to type answer options manually
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void fillAnsOptionsDetails(WebDriver driver, HashMap<String, String> param, WebPageElements ele,
			JsonObject qtCases, ExtentTest test) throws InterruptedException {
		
		String testcaseName = param.get("TestCaseName");
		String quesType = param.get("quesType");

		JsonObject ansList = new JsonObject();
		JsonArray ansListArray = new JsonArray();
		List<String> ansListArrayCopy = new ArrayList<>();
		int ansNo = 0;
		
		if(qtCases.has("isRandomAnsoptiontext")) {
			// Fetch Answer options text
			// If isRandomAnsoptiontext == true then fetch random answer options from anslibData.json
			if (qtCases.get("isRandomAnsoptiontext").getAsBoolean()) {
				ansList = getAnsDetails(param, test);
				Iterator<Entry<String, JsonElement>> keys = ansList.entrySet().iterator();
				String key = keys.next().getKey();
				ansListArray = ansList.get(key).getAsJsonArray();
				ansNo = ansListArray.size();
	
			} else {
				ansListArray = qtCases.get("answerOptionsText").getAsJsonArray();
				ansNo = ansListArray.size();
			}
		}
		// For Radio grid and Check Box grid question
		if (quesType.equals("dvrg") || quesType.equals("dvcbg")) {
			int defaultAnsOptions = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();
			int newansOptionCount = defaultAnsOptions;

			// Loop for adding answer options based on ansNo
			for (int i = 0; i < ansNo - defaultAnsOptions; i++) {
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).get(0)).build().perform();
				waitforElemPresent(driver, testcaseName, 30,
						driver.findElements(By.xpath("//div[@class='newSmallAdd']")).get(0), "Add Answer option", test);
				click(driver, testcaseName, driver.findElements(By.xpath("//div[@class='newSmallAdd']")).get(0),
						"Add Answer option", test);
				newansOptionCount = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();

				// Wait till new ans option is added
				while (newansOptionCount == defaultAnsOptions + (i + 1)) {
					try {
						newansOptionCount = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
			for (int i = 0; i < ansNo; i++) {
				try {
					scrollIntoCenter(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					click(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				setText(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
						ansListArray.get(i).getAsString(), "Answer Option " + (i + 1), test);
			}
		}
		// For Rating radio grid
		else if (quesType.equals("dvrrg")) {

			int defaultAnsOptions = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();
			int newansOptionCount = defaultAnsOptions;

			// Loop for adding answer options based on ansNo
			for (int i = 0; i < ansNo - defaultAnsOptions; i++) {
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).get(0)).build().perform();
				waitforElemPresent(driver, testcaseName, 30,
						driver.findElements(By.xpath("//div[@class='newSmallAdd']")).get(0), "Add Answer option", test);
				click(driver, testcaseName, driver.findElements(By.xpath("//div[@class='newSmallAdd']")).get(0),
						"Add Answer option", test);
				newansOptionCount = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();

				// Wait till new ans option is added
				while (newansOptionCount == defaultAnsOptions + (i + 1)) {
					try {
						newansOptionCount = driver.findElements(By.xpath(DEFAULT_ANS_OPTS_IN_GRID)).size();
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
			for (int i = 0; i < ansNo; i++) {
				try {
					scrollIntoCenter(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					click(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
							"Answer Option " + (i + 1), test);
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				setText(driver, testcaseName, By.xpath("//input[@id='txtGrid_0_" + i + "_Choice']"),
						ansListArray.get(i).getAsString(), "Answer Option " + (i + 1), test);
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_" + i + "_Weight']"),
						"Weight 1", test);
				setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_" + i + "_Weight']"),
						Integer.toString(i + 1), "Weight " + (i + 1), test);
			}

		}
		// Rating drop down grid
		else if (quesType.equals("dvrddg")) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options",
					test);
			click(driver, testcaseName, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, iframe_add_manually, test);
			driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ADD_MANUALLY)));
			for (int i = 0; i < ansNo; i++) {
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_" + i + "']"),
						"Answer Option " + (i + 1), test);
				setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_" + i + "']"),
						ansListArray.get(i).getAsString(), "Answer Option " + (i + 1), test);
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_" + i + "']"),
						"Weight of answer option" + (i + 1), test);
				setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_" + i + "']"), Integer.toString(i + 1),
						"Weight of answer option" + (i + 1), test);
			}
			click(driver, testcaseName, save_button_manual, test);
			driver.switchTo().parentFrame();
		}
		
		// NPS question
		else if(quesType.equals("dvrat_NPS")) {
			if(!qtCases.get("defaultAnsLables").getAsBoolean()) {
				JsonArray ansLables = qtCases.get("ansLabels").getAsJsonArray();
				
				clearText(driver, testcaseName, ans_label0, test);
				Thread.sleep(1000);
				setText(driver, testcaseName, ans_label0, ansLables.get(0).getAsString(), test);
				
				clearText(driver, testcaseName, ans_label10, test);
				Thread.sleep(1000);
				setText(driver, testcaseName, ans_label10, ansLables.get(1).getAsString(), test);
			}
		}
		// For Radio button, Drop Down, CheckBox, Multiple Drop Down, Horizontal Radio Button, List Box button,
		// Rating radio button,  Rating drop down
		else {
			// Enter answer options in Normal view
			if(qtCases.get("isNormalView").getAsBoolean() && !qtCases.get("isListView").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, noraml_view, test);
				click(driver, testcaseName, noraml_view, test);
				waitforElemPresent(driver, testcaseName, 30, noraml_view_text_area, test);
				for (int i = 0; i < ansNo; i++) {
					setText(driver, testcaseName, noraml_view_text_area, ansListArray.get(i).getAsString() + "\n", test);
					ansListArrayCopy.add(i, ansListArray.get(i).getAsString());
				}
			}
			// Enter answer options in List view
			else if(!qtCases.get("isNormalView").getAsBoolean() && qtCases.get("isListView").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, list_view, test);
				if(ansNo<=5) {
					for(int i=0; i<ansNo; i++) {
						setText(driver, testcaseName, By.xpath("//input[@id='option" + (i+1) + "']"), ansListArray.get(i).getAsString(), "Answer Option " + (i+1), test);
						ansListArrayCopy.add(i, ansListArray.get(i).getAsString());
					}
				}else {
					int counter = (int) Math.ceil((ansNo-5)/10f);
					// Add answer option fields based on ansNo count
					for(int i=0; i<counter; i++) {
						scrollIntoCenter(driver, testcaseName, add_more, test);
						waitforElemPresent(driver, testcaseName, 10, add_more, test);
						Thread.sleep(500);
						click(driver, testcaseName, add_more, test);
						Thread.sleep(500);
					}
					// Fill answer option field with text
					for(int i=0; i<ansNo; i++) {
						scrollIntoCenter(driver, testcaseName, By.xpath("//input[@id='option" + (i+1) + "']"), "Answer Option " + (i+1), test);
						waitforElemPresent(driver, testcaseName, 10, By.xpath("//input[@id='option" + (i+1) + "']"), "Answer Option " + (i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='option" + (i+1) + "']"), ansListArray.get(i).getAsString(), "Answer Option " + (i+1), test);
						ansListArrayCopy.add(i, ansListArray.get(i).getAsString());
					}
				}
				
			}
			
			// Set weights if question type is RRB, RDD
			if (quesType.equals("dvrrb") || quesType.equals("dvratdd")) {
				if (qtCases.get("isNormalView").getAsBoolean() && !qtCases.get("isListView").getAsBoolean()) {
					click(driver, testcaseName, list_view, test);
				}
				// Execute this block only if case object has weights key and isRandomAnsoptiontext is false
				if (qtCases.getAsJsonObject().has("weights") && !qtCases.get("isRandomAnsoptiontext").getAsBoolean()) {
					// Assign weights if present
					if (qtCases.get("weights").getAsJsonArray().size() != 0) {
						JsonArray weights = qtCases.get("weights").getAsJsonArray();
						for (int i = 0; i < ansNo; i++) {
							waitforElemPresent(driver, testcaseName, 30,
									By.xpath("//input[@name='rating_weight" + (i + 1) + "']"), "Weight " + (i + 1), test);
							setText(driver, testcaseName, By.xpath("//input[@name='rating_weight" + (i + 1) + "']"),
									weights.get(i).getAsString(), "Weight " + (i + 1), test);
						}
					}
					// Skip the weights if it's empty
					else {
						Add_Log.info("Saving question without weights since weights are not given");
						Reporter.log("Saving question without weights since weights are not given");
						test.info("Saving question without weights since weights are not given");
					}
				}
				// Loop the weights
				else {
					for (int i = 0; i < ansNo; i++) {
						waitforElemPresent(driver, testcaseName, 30,
								By.xpath("//input[@name='rating_weight" + (i + 1) + "']"), "Weight " + (i + 1), test);
						setText(driver, testcaseName, By.xpath("//input[@name='rating_weight" + (i + 1) + "']"),
								Integer.toString(i), "Weight " + (i + 1), test);
					}
				}

			}

		}

		param.put("ansOptList", ansListArrayCopy.toString());

	}
	
	/**
	 * Use this function to get Answer options json  
	 * @param param
	 * @param test
	 * @return
	 */
	private JsonObject getAnsDetails(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject anslibData = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\anslibData.json", test);
		JsonArray anslib = anslibData.get("anslib").getAsJsonArray();
		int rnd = new Random().nextInt(anslib.size());
		return anslib.get(rnd).getAsJsonObject();
	}
	
	
	/**
	 * Action 12 : Select demographic fields 
	 * Use this function to Select demographic fields
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void selectDemoGraphicQuestions(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");		
		
		waitforElemPresent(driver, testcaseName, 30, name_expand, test);
		
		// Execute this block only if user wants to add any Name fields in demographic question.
		if(qtCases.get("isNameField").getAsBoolean()) {
			click(driver, testcaseName, name_expand, test);
			if(qtCases.get("isTitle").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, name_title, test);
				click(driver, testcaseName, name_title, test);
			}
			if(qtCases.get("isFullName").getAsBoolean()) {
				if(qtCases.get("isFirstName").getAsBoolean() || qtCases.get("isMiddleName").getAsBoolean() || qtCases.get("isLastName").getAsBoolean()) {
					reportFail(testcaseName, "isFirstName, isMiddleName, isLastName should be false in jsonCase file.", test);
				}
				waitforElemPresent(driver, testcaseName, 30, name_full_name, test);
				click(driver, testcaseName, name_full_name, test);
			}
			if(qtCases.get("isFirstName").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, name_first_name, test);
				click(driver, testcaseName, name_first_name, test);
			}
			if(qtCases.get("isMiddleName").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, name_middle_name, test);
				click(driver, testcaseName, name_middle_name, test);
			}
			if(qtCases.get("isLastName").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, name_last_name, test);
				click(driver, testcaseName, name_last_name, test);
			}
			if(qtCases.get("isGender").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, gender, test);
				click(driver, testcaseName, gender, test);
			}
			if(qtCases.get("isDOB").getAsBoolean()) {
				waitforElemPresent(driver, testcaseName, 30, dob, test);
				click(driver, testcaseName, dob, test);
			}
		}
		
		waitforElemPresent(driver, testcaseName, 30, address_expand, test);
		
		// Execute this block only if user wants to add any Address fields in demographic question.
		if(qtCases.get("isAddressField").getAsBoolean()) {
			click(driver, testcaseName, address_expand, test);
			if(qtCases.get("isUS").getAsBoolean() && !qtCases.get("isInternational").getAsBoolean()) {
				if(qtCases.get("isStreet1").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_street1, test);
					click(driver, testcaseName, address_street1, test);
				}
				if(qtCases.get("isStreet2").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_street2, test);
					click(driver, testcaseName, address_street2, test);
				}
				if(qtCases.get("isCity").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_city, test);
					click(driver, testcaseName, address_city, test);
				}
				if(qtCases.get("isCountry").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_country, test);
					click(driver, testcaseName, address_country, test);
				}
				if(qtCases.get("isState").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_state, test);
					click(driver, testcaseName, address_state, test);
				}
				if(qtCases.get("isZip").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_zip, test);
					click(driver, testcaseName, address_zip, test);
				}
				if(qtCases.get("isZip4").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, address_zipplus4, test);
					click(driver, testcaseName, address_zipplus4, test);
				}
				
			}else if(!qtCases.get("isUS").getAsBoolean() && qtCases.get("isInternational").getAsBoolean()) {
				
			}else {
				reportFail(testcaseName, "Both isUS and isInternational can not be true and false at same time in jsonCase file.", test);
			}
		}
		
		waitforElemPresent(driver, testcaseName, 30, telephone_expand, test);
		
		// Execute this block only if user wants to add any Telephone fields in demographic question.
		if(qtCases.get("isTelephone/FaxField").getAsBoolean()) {
			click(driver, testcaseName, telephone_expand, test);
			if(qtCases.get("isUS").getAsBoolean() && !qtCases.get("isInternational").getAsBoolean()) {
				if(qtCases.get("isTelephone").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, telephone_telephone, test);
					click(driver, testcaseName, telephone_telephone, test);
				}
				if(qtCases.get("isExtension").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, telephone_extension, test);
					click(driver, testcaseName, telephone_extension, test);
				}
				if(qtCases.get("isFax").getAsBoolean()) {
					waitforElemPresent(driver, testcaseName, 30, telephone_fax, test);
					click(driver, testcaseName, telephone_fax, test);
				}
				
			}else if(!qtCases.get("isUS").getAsBoolean() && qtCases.get("isInternational").getAsBoolean()) {
				
			}else {
				reportFail(testcaseName, "Both isUS and isInternational can not be true and false at same time in jsonCase file.", test);
			}
			
		}
		
		if(qtCases.get("isEmailAddress").getAsBoolean()) {
			waitforElemPresent(driver, testcaseName, 30, email_address, test);
			click(driver, testcaseName, email_address, test);
		}
		if(qtCases.get("isConfirmEmailAddress").getAsBoolean()) {
			waitforElemPresent(driver, testcaseName, 30, reenter_email_address, test);
			click(driver, testcaseName, reenter_email_address, test);
		}

		
	}
	
	/**
	 * Action 13 : Set number of sub-questions in grid questions
	 * Use this function to set the number of sub-questions in given grid question.
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void setNumberOfSubquestions(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String quesType = param.get("quesType");
		int numberOfSubquestions = 0;
		
		switch(quesType) {
		
		// Symbol Rating question
		case "dvGQ":
			if (!param.get("SRSSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("SRSSubqueCount"));
				waitforElemPresent(driver, testcaseName, 30, increase_srs_subque, test);
				for (int i = 0; i < (numberOfSubquestions -1); i++) {
					click(driver, testcaseName, increase_srs_subque, test);
					Thread.sleep(500);
				}
			}
			break;
			
		// MTB Question
		case "dvmtb":
			if (!param.get("MTBSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("MTBSubqueCount"));
				waitforElemPresent(driver, testcaseName, 30, driver.findElements(By.xpath(ADD_MTB_SUBQUE)).get(0), "Add Button", test);
				for (int i = 0; i < (numberOfSubquestions -2); i++) {
					click(driver, testcaseName, driver.findElements(By.xpath(ADD_MTB_SUBQUE)).get(0), "Add Button", test);
					Thread.sleep(500);
				}
			}
			break;
			
		// MDD Question
		case "dvmdd":
			if (!param.get("MDDSubqueCount").isEmpty()) {
				selectByExactVisibleText(driver, testcaseName, number_of_drop_down, param.get("MDDSubqueCount"), test);
			}
			break;
			
		// Radio Grid
		case "dvrg":
			if (!param.get("RGSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("RGSubqueCount"));
				if (numberOfSubquestions < 5) {
					for (int i = 0; i < (5-numberOfSubquestions); i++) {
						click(driver, testcaseName, remove_subque, test);
						Thread.sleep(500);
					}
				}else if (numberOfSubquestions > 5) {
					for (int i = 0; i < (numberOfSubquestions-5); i++) {
						click(driver, testcaseName, add_subque, test);
						Thread.sleep(500);
					}
				} 
			}
			break;
			
		//	Check box grid
		case "dvcbg":
			if (!param.get("CBGSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("CBGSubqueCount"));
				if (numberOfSubquestions < 5) {
					for (int i = 0; i < (5-numberOfSubquestions); i++) {
						click(driver, testcaseName, remove_subque, test);
						Thread.sleep(500);
					}
				}else if (numberOfSubquestions > 5) {
					for (int i = 0; i < (numberOfSubquestions-5); i++) {
						click(driver, testcaseName, add_subque, test);
						Thread.sleep(500);
					}
				} 
			}
			break;
			
		// Rating radio grid
		case "dvrrg":
			if (!param.get("RRGSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("RRGSubqueCount"));
				if (numberOfSubquestions < 5) {
					for (int i = 0; i < (5-numberOfSubquestions); i++) {
						click(driver, testcaseName, remove_subque, test);
						Thread.sleep(500);
					}
				}else if (numberOfSubquestions > 5) {
					for (int i = 0; i < (numberOfSubquestions-5); i++) {
						click(driver, testcaseName, add_subque, test);
						Thread.sleep(500);
					}
				} 
			}
			break;
		
		// Rating drop down grid
		case "dvrddg":
			if (!param.get("RDDGSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("RDDGSubqueCount"));
				if (numberOfSubquestions < 5) {
					for (int i = 0; i < (5-numberOfSubquestions); i++) {
						click(driver, testcaseName, remove_subque, test);
						Thread.sleep(500);
					}
				}else if (numberOfSubquestions > 5) {
					for (int i = 0; i < (numberOfSubquestions-5); i++) {
						click(driver, testcaseName, add_subque, test);
						Thread.sleep(500);
					}
				} 
			}
			break;
			
		// Rating scale grid
		case "dvrcg":
			if (!param.get("RSGSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("RSGSubqueCount"));
				if (numberOfSubquestions < 5) {
					for (int i = 0; i < (5-numberOfSubquestions); i++) {
						click(driver, testcaseName, remove_subque, test);
						Thread.sleep(500);
					}
				}else if (numberOfSubquestions > 5) {
					for (int i = 0; i < (numberOfSubquestions-5); i++) {
						click(driver, testcaseName, add_subque, test);
						Thread.sleep(500);
					}
				} 
			}
			break;
			
			// Matrix grid
			case "dvmg":
				if (!param.get("MGSubquestionCount").isEmpty()) {
					click(driver, testcaseName, expand_num_of_subque, test);
					waitforElemPresent(driver, testcaseName, 30, remove_subque, test);
					numberOfSubquestions = Integer.parseInt(param.get("MGSubquestionCount"));
					if (numberOfSubquestions < 5) {
						for (int i = 0; i < (5-numberOfSubquestions); i++) {
							click(driver, testcaseName, remove_subque, test);
							Thread.sleep(500);
						}
					}else if (numberOfSubquestions > 5) {
						for (int i = 0; i < (numberOfSubquestions-5); i++) {
							click(driver, testcaseName, add_subque, test);
							Thread.sleep(500);
						}
					} 
				}
				break;
			
		// For Attachment question
		case "dvatt":
			if (param.containsKey("attachmentsCount")) {
				selectByExactVisibleText(driver, testcaseName, select_attachment_subques, param.get("attachmentsCount"), test);
			}
			break;
		}
		
		
		
	}
	
	/**
	 * Action 14 : Fill sub-questions details in grid questions
	 * Use this function to fill sub-question details in given grid question.
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void fillSubquestionDetails(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String quesType = param.get("quesType");
		int numberOfSubquestions = 0;
		Set<String> uniqueSubQues =  null;
		
		switch(quesType) {
		// Symbol Rating question
		case "dvGQ":
			if (!param.get("SRSSubqueCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("SRSSubqueCount"));
				if (numberOfSubquestions>1) {
					String[] srsFormats = param.get("srsFormat").split(";");
					if (srsFormats.length == numberOfSubquestions) {	
						
						// Unique sub-question list 
						uniqueSubQues = new HashSet<String>(numberOfSubquestions);
						for(int i=0; i<numberOfSubquestions; i++) {
							while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
						}
						String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
						
						for(int i=0; i<numberOfSubquestions; i++) {
							waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption"+ (i+1) +"']"), "Sub Question "+ (i+1), test);
							setText(driver, testcaseName, By.xpath("//input[@name='GQoption"+ (i+1) +"']"), uniqueSubArray[i], "Sub Question " + (i+1), test);
							Thread.sleep(500);
							waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_"+ (i+1) +"']"), "Sub Question "+ (i+1) +" Scale", test);
							Select selectSubquestion = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_"+ (i+1) +"']")));
							selectSubquestion.selectByVisibleText(srsFormats[i]);
							Thread.sleep(500);
						}
					}else {
						test.log(Status.FAIL, "SRS formats length should be equal to number of subquestions. Number of Subquestions : " + numberOfSubquestions 
								+ " Number of SRS formats : " +srsFormats.length);
						Add_Log.info("SRS formats length should be equal to number of subquestions. Number of Subquestions : " + numberOfSubquestions 
								+ " Number of SRS formats : " +srsFormats.length);
						Reporter.log("SRS formats length should be equal to number of subquestions. Number of Subquestions : " + numberOfSubquestions 
								+ " Number of SRS formats : " +srsFormats.length);
						TestResultStatus.failureReason.add(testcaseName + "| "+ "SRS formats length should be equal to number of subquestions. Number of Subquestions : " + numberOfSubquestions 
								+ " Number of SRS formats : " +srsFormats.length);
						TestResultStatus.TestFail = true;
						Assert.fail();
					}		
				}
			}
				break;
			
			// MTB Question
			case "dvmtb":
				if (!param.get("MTBSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("MTBSubqueCount"));
					String[] mtbFormats = param.get("mtbFormat").split(";");
					String[] uniqueSubArray;
					
					if (qtCases.has("isRandomSubQuestiontext")) {
						if(qtCases.get("isRandomSubQuestiontext").getAsBoolean()) {
							// Unique sub-question list 
							uniqueSubQues = new HashSet<String>(numberOfSubquestions);
							for(int i=0; i<numberOfSubquestions; i++) {
								while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
							}
							uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
						}else {
							uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
						}
					}else {
						uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
					}
					
					
					for(int i=0; i<numberOfSubquestions; i++) {			
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//tr[@id='trMTTextBoxes"+ (i+1) +"']//input[@name='option"+ (i+1) +"']"), "MTB Subquestion " +(i+1), test);
						setText(driver, testcaseName, By.xpath("//tr[@id='trMTTextBoxes"+ (i+1) +"']//input[@name='option"+ (i+1) +"']"), uniqueSubArray[i], "MTB Subquestion " +(i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlTextBoxFormat"+ (i+1) +"']"), "Sub Question "+ (i+1) +" Format", test);
						Select selectSubquestion = new Select(driver.findElement(By.xpath("//select[@name='ddlTextBoxFormat"+ (i+1) +"']")));
						selectSubquestion.selectByVisibleText(mtbFormats[i]);
						if(mtbFormats[i].equals("Custom")) {
							waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtCustomFormat"+ (i+1) +"']"), "Specify custom format of subquestion " +(i+1) +" text box", test);
							setText(driver, testcaseName, By.xpath("//input[@id='txtCustomFormat"+ (i+1) +"']"), param.get("Custom format"), "Specify custom format of subquestion " +(i+1) +" text box", test);
						}
					}
				}	
				break;
			
			// MDD Question
			case "dvmdd":
				if (!param.get("MDDSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("MDDSubqueCount"));
					String[] uniqueSubArray; 
					
					if (qtCases.has("isRandomSubQuestiontext")) {
						if(qtCases.get("isRandomSubQuestiontext").getAsBoolean()) {
							// Unique sub-question list 
							uniqueSubQues = new HashSet<String>(numberOfSubquestions);
							for(int i=0; i<numberOfSubquestions; i++) {
								while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
							}
							uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
						}else {
							uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
						}
					}else {
						uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
					}
					
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='MDoption" + (i+1) + "']"), "MDD Subquestion "+(i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='MDoption" +(i+1) + "']"), "MDD Subquestion "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='MDoption" +(i+1) + "']"), uniqueSubArray[i], "MDD Subquestion "+(i+1), test);
					}
				}
				break;
				
			case "dvrg":
				if (!param.get("RGSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("RGSubqueCount"));
					
					// Unique sub-question list 
					uniqueSubQues = new HashSet<String>(numberOfSubquestions);
					for(int i=0; i<numberOfSubquestions; i++) {
						while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
					}
					String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Radio Grid Sub question "+ (i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Radio Grid Sub question "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), uniqueSubArray[i], "Radio Grid Sub question "+(i+1), test);
					
					}
				}
				
				break;
				
			// Check box grid
			case "dvcbg":
				if (!param.get("CBGSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("CBGSubqueCount"));
					
					// Unique sub-question list 
					uniqueSubQues = new HashSet<String>(numberOfSubquestions);
					for(int i=0; i<numberOfSubquestions; i++) {
						while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
					}
					String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Check Box Grid Sub question "+ (i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Check Box Sub question "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), uniqueSubArray[i], "Check Box Sub question "+(i+1), test);
					
					}
				}
				
				break;
			//	Rating radio grid
			case "dvrrg":
				if (!param.get("RRGSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("RRGSubqueCount"));
					
					// Unique sub-question list 
					uniqueSubQues = new HashSet<String>(numberOfSubquestions);
					for(int i=0; i<numberOfSubquestions; i++) {
						while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
					}
					String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Radio Grid Sub question "+ (i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Radio Sub question "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), uniqueSubArray[i], "Rating Radio Sub question "+(i+1), test);
					
					}
				}
				break;
				
			// Rating drop down grid 
			case "dvrddg":
				if (!param.get("RDDGSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("RDDGSubqueCount"));
					
					// Unique sub-question list 
					uniqueSubQues = new HashSet<String>(numberOfSubquestions);
					for(int i=0; i<numberOfSubquestions; i++) {
						while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
					}
					String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Drop Down Grid Sub question "+ (i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Drop Down Grid Sub question "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), uniqueSubArray[i], "Rating Drop Down Grid Sub question "+(i+1), test);
					
					}
				}
				
				break;
				
			// Rating Scale grid 
			case "dvrcg":
				if (!param.get("RSGSubqueCount").isEmpty()) {
					numberOfSubquestions = Integer.parseInt(param.get("RSGSubqueCount"));
					
					// Unique sub-question list 
					uniqueSubQues = new HashSet<String>(numberOfSubquestions);
					for(int i=0; i<numberOfSubquestions; i++) {
						while(!uniqueSubQues.add(getQueDetails(param, "subquestions", test)));
					}
					String[] uniqueSubArray = uniqueSubQues.toArray(new String [uniqueSubQues.size()]);
					for(int i=0; i<numberOfSubquestions; i++) {	
						scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Scale Grid Sub question "+ (i+1), test);
						waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_"+ i +"']"), "Rating Scale Grid Sub question "+(i+1), test);
						setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_"+ i +"']"), uniqueSubArray[i], "Rating Scale Grid Sub question "+(i+1), test);
					
					}
				}
				
				break;
			
			// Matric grid questions
			case "dvmg":
			if (!param.get("MGSubquestionCount").isEmpty()) {
				numberOfSubquestions = Integer.parseInt(param.get("MGSubquestionCount"));
				String[] uniqueSubArray;

				if (qtCases.has("isRandomSubQuestiontext")) {
					if (qtCases.get("isRandomSubQuestiontext").getAsBoolean()) {
						// Unique sub-question list
						uniqueSubQues = new HashSet<String>(numberOfSubquestions);
						for (int i = 0; i < numberOfSubquestions; i++) {
							while (!uniqueSubQues.add(getQueDetails(param, "subquestions", test)))
								;
						}
						uniqueSubArray = uniqueSubQues.toArray(new String[uniqueSubQues.size()]);
					} else {
						uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
					}
				} else {
					uniqueSubArray = qtCases.get("subQuestionText").getAsString().split("/~/");
				}
				for (int i = 0; i < numberOfSubquestions; i++) {
					scrollIntoView(driver, testcaseName, By.xpath("//input[@id='txtQuestion_" + i + "']"),
							"Matrix Grid Subquestion " + (i + 1), test);
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='txtQuestion_" + i + "']"),
							"Matrix Grid Subquestion " + (i + 1), test);
					setText(driver, testcaseName, By.xpath("//input[@id='txtQuestion_" + i + "']"), uniqueSubArray[i],
							"Matrix Grid Subquestion " + (i + 1), test);
				}
			}
				
				break;
				
			// Attachment question type
			case "dvatt":
				numberOfSubquestions = qtCases.get("attachmentsCount").getAsInt();
				JsonArray subQuestion = qtCases.get("attachmentsSubQues").getAsJsonArray();
				JsonArray formats = qtCases.get("format").getAsJsonArray();
				for(int i=0; i<numberOfSubquestions; i++) 	{
					scrollIntoCenter(driver, testcaseName, By.xpath("//input[@id='AToption" + (i+1) +"']"), "Attachment " + (i+1),test);
					waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@id='AToption" + (i+1) +"']"), "Attachment " + (i+1), test);
					setText(driver, testcaseName, By.xpath("//input[@id='AToption" + (i+1) +"']"), subQuestion.get(i).getAsString(), "Attachment " + (i+1), test);
					setText(driver, testcaseName, By.xpath("//input[@id='AttachmentOption_" + (i+1) +"']"), formats.get(i).getAsString(), "Attachment " + (i+1) +" format", test);
				}
				
				break;
		}
			
		
	}
	
	
	/**
	 * Action 15 : Type Manually Answer options in Rating Scale Grid
	 * Use this function to type answer options manually
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	
	private void fillAnsOptionsInRSG(WebDriver driver, HashMap<String, String> param, WebPageElements ele, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		String[] ansOptions = param.get("RSGAnsOptions").split(";");
		LinkedHashMap<String, Object> rsgparam = new LinkedHashMap<String, Object>();
		
		for (int i = 0; i < ansOptions.length; i++) {
			String string = ansOptions[i];
			HashMap<String, Object> ansparam = new HashMap<String, Object>();
			if (i==0) {
				ansparam.put("ansText", string.split("-")[0]);
				ansparam.put("value", Integer.parseInt(string.split("-")[1]));
				rsgparam.put("Lowest", ansparam);
			}else if (i==1) {
				ansparam.put("ansText", string.split("-")[0]);
				ansparam.put("value", Integer.parseInt(string.split("-")[1]));
				rsgparam.put("Middle", ansparam);
			} else if(i==2) {
				ansparam.put("ansText", string.split("-")[0]);
				ansparam.put("value", Integer.parseInt(string.split("-")[1]));
				rsgparam.put("Highest", ansparam);
			}else {
				ansparam.put("ansText", string.split("-")[0]);
				ansparam.put("value", 0);
				rsgparam.put("NA", ansparam);
			}
			
		}
		rsgparam.entrySet().forEach(e -> {
			
			System.out.println( "Key :" +e.getKey() + ", Value :" +e.getValue());
			switch(e.getKey()) {
			case "Lowest":	
				try {
					@SuppressWarnings("unchecked")
					HashMap<String, Object> ansparam = (HashMap<String, Object>) e.getValue();
					waitforElemPresent(driver, testcaseName, 60, lowest_text_field, test);
					clearText(driver, testcaseName, lowest_text_field, test);
					Thread.sleep(1000);
					setText(driver, testcaseName, lowest_text_field, String.valueOf(ansparam.get("ansText")), test);
					int valueToBeAssign = (int) ansparam.get("value");
					int defValue = Integer.parseInt(driver.findElement(By.xpath(LOWEST_VALUE_FIELD)).getAttribute("value"));
					if (valueToBeAssign>defValue) {
						for(int i=0; i<valueToBeAssign-defValue; i++) {
							waitforElemPresent(driver, testcaseName, 30, lowest_value_step_up, test);
							click(driver, testcaseName, lowest_value_step_up, test);
							waitForJStoLoad(driver, 30);
						}
					}else if(valueToBeAssign<defValue) {
						for(int i=0; i<defValue-valueToBeAssign; i++) {
							waitforElemPresent(driver, testcaseName, 30, lowest_value_step_down, test);
							click(driver, testcaseName, lowest_value_step_down, test);
							waitForJStoLoad(driver, 30);
						}
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Middle":
				try {
					@SuppressWarnings("unchecked")
					HashMap<String, Object> ansparam = (HashMap<String, Object>) e.getValue();
					waitforElemPresent(driver, testcaseName, 60, middle_text_field, test);
					clearText(driver, testcaseName, middle_text_field, test);
					Thread.sleep(1000);
					setText(driver, testcaseName, middle_text_field, String.valueOf(ansparam.get("ansText")), test);
					int valueToBeAssign = (int) ansparam.get("value");
					int defValue = Integer.parseInt(driver.findElement(By.xpath(MIDDLE_VALUE_FIELD)).getAttribute("value"));
					if (valueToBeAssign>defValue) {
						for(int i=0; i<valueToBeAssign-defValue; i++) {
							waitforElemPresent(driver, testcaseName, 30, middle_value_step_up, test);
							click(driver, testcaseName, middle_value_step_up, test);
							waitForJStoLoad(driver, 30);
						}
					}else if(valueToBeAssign<defValue) {
						for(int i=0; i<defValue-valueToBeAssign; i++) {
							waitforElemPresent(driver, testcaseName, 30, middle_value_step_down, test);
							click(driver, testcaseName, middle_value_step_down, test);
							waitForJStoLoad(driver, 30);
						}
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case "Highest":
				try {
					@SuppressWarnings("unchecked")
					HashMap<String, Object> ansparam = (HashMap<String, Object>) e.getValue();
					waitforElemPresent(driver, testcaseName, 60, highest_text_field, test);
					clearText(driver, testcaseName, highest_text_field, test);
					Thread.sleep(1000);
					setText(driver, testcaseName, highest_text_field, String.valueOf(ansparam.get("ansText")), test);
					int valueToBeAssign = (int) ansparam.get("value");
					int defValue = Integer.parseInt(driver.findElement(By.xpath(HIGHEST_VALUE_FIELD)).getAttribute("value"));
					if (valueToBeAssign>defValue) {
						for(int i=0; i<valueToBeAssign-defValue; i++) {
							waitforElemPresent(driver, testcaseName, 30, highest_value_step_up, test);
							click(driver, testcaseName, highest_value_step_up, test);
							waitForJStoLoad(driver, 30);
						}
					}else if(valueToBeAssign<defValue) {
						for(int i=0; i<defValue-valueToBeAssign; i++) {
							waitforElemPresent(driver, testcaseName, 30, highest_value_step_down, test);
							click(driver, testcaseName, highest_value_step_down, test);
							waitForJStoLoad(driver, 30);
						}
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case "NA":
				@SuppressWarnings("unchecked")
				HashMap<String, Object> ansparam = (HashMap<String, Object>) e.getValue();
				waitforElemPresent(driver, testcaseName, 30, na_text_field, test);
				click(driver, testcaseName, na_text_field, test);
				setText(driver, testcaseName, na_text_field, String.valueOf(ansparam.get("ansText")), test);
				break;
			}
			
		});

	
	}
	
	/**
	 * Action 16 : Include Other Please Specify Choice
	 * Use this function to include Other please specify in following question types
	 * Radio Button, 
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void includeOtherPleaseSpecify(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		
		// Enter the Other please specify lable text given in qtCases object
		if(qtCases.get("isOtherPleaseSpecifyDefaultLable").getAsBoolean() == false) {
			waitforElemPresent(driver, testcaseName, 30, other_plz_textbox, test);
			clearText(driver, testcaseName, other_plz_textbox, test);
			Thread.sleep(1000);
			setText(driver, testcaseName, other_plz_textbox, qtCases.get("otherPleaseSpecifyLableText").getAsString(), test);
		}
		selectByExactVisibleText(driver, testcaseName, select_other_plz_tb_width, qtCases.get("otherPleaseSpecifyWidth").getAsString(), test);
	}

	/**
	 * Action 17 : Rearrange Answer Options
	 * Use this function to Rearrange the answer options for following question types
	 * Radio Button, 
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void rearrangeAnsOptions(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rearrange_ans, test);
		click(driver, testcaseName, rearrange_ans, test);
		
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, rearrange_ans_text, test);
		waitforElemPresent(driver, testcaseName, 30, rearrange_ans_menu, test);
		
		// Apply Sorting based on qtCases
		if (qtCases.get("sortBy").getAsString().equalsIgnoreCase("AToZ")) {
			waitforElemPresent(driver, testcaseName, 30, atoz_sort, test);
			click(driver, testcaseName, atoz_sort, test);
			waitforElemPresent(driver, testcaseName, 30, ztoa_sort, test);
			waitForJStoLoad(driver, 10);
		}else if(qtCases.get("sortBy").getAsString().equalsIgnoreCase("ZToA")) {
			waitforElemPresent(driver, testcaseName, 30, atoz_sort, test);
			click(driver, testcaseName, atoz_sort, test);
			waitforElemPresent(driver, testcaseName, 30, ztoa_sort, test);
			waitForJStoLoad(driver, 10);
			click(driver, testcaseName, ztoa_sort, test);
			waitforElemPresent(driver, testcaseName, 30, atoz_sort, test);
			waitForJStoLoad(driver, 10);
		}else if(qtCases.get("sortBy").getAsString().isEmpty()) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='clsRearrangeText']"), "Rearrange Answer Options", test);
			List<WebElement> ansOptList = driver.findElements(By.xpath("//div[@class='clsRearrangeText']"));
			int ansCount = ansOptList.size();
			
			// Create an array of random numbers
			Integer[] arr = new Integer[ansCount];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i+1;
			}
			Collections.shuffle(Arrays.asList(arr));
			
			// Save reordering sequence in pair of order and answer option
			Map<Integer, String> reorderseq = new LinkedHashMap<>(ansCount);
			for(int i=0; i<ansCount; i++) {
				reorderseq.put(arr[i], ansOptList.get(i).getAttribute("innerHTML"));
			}
			
			Add_Log.info("Reordering generated via shuffle function : " +reorderseq);
			Reporter.log("Reordering generated via shuffle function : " +reorderseq);
			test.info("Reordering generated via shuffle function : " +reorderseq);
			
			// Rearrange the answer options based on parameters passed in reorderseq
			Actions act = new Actions(driver);
			for(int i=0; i<ansCount; i++) {
				WebElement source = driver.findElement(By.xpath("//div[text()='" + reorderseq.get(i+1) +"']/parent::div"));
				WebElement target = ansOptList.get(i);
				scrollIntoCenter(driver, testcaseName, source, reorderseq.get(i+1), test);
				waitforElemPresent(driver, testcaseName, 10, source, reorderseq.get(i+1), test);
				act.moveToElement(source).dragAndDrop(source, target).build().perform();
				Thread.sleep(500);
				ansOptList = driver.findElements(By.xpath("//div[@class='clsRearrangeText']"));
			}
			
		}
		
		// Save the answer list in ansOptList as key in param 
		List<String> ansOptList = new ArrayList<>();
		List<WebElement> rearrangedAnsOptions = driver.findElements(By.xpath("//div[@class='clsRearrangeText']"));
		for(int i=0; i<rearrangedAnsOptions.size(); i++) {
			ansOptList.add(i, rearrangedAnsOptions.get(i).getAttribute("innerHTML"));
		}
		
		param.put("ansOptList", ansOptList.toString());
		
		click(driver, testcaseName, done_btn, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, save_button, test);
	}
	
	
	/**
	 * Action 18 : Select Answer Sequence
	 * Use this function to Select the answer answer sequence for following question types
	 * Radio Button, 
	 * @param driver
	 * @param param
	 * @param ele
	 * @param test
	 * @throws InterruptedException
	 */
	private void selectAnsSequence(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, answer_seq, test);
		waitforElemPresent(driver, testcaseName, 30, answer_seq, test);
		click(driver, testcaseName, answer_seq, test);
		
		if(qtCases.get("answerSequence").getAsString().equalsIgnoreCase("Rotate")) {
			waitforElemPresent(driver, testcaseName, 30, rotate_label, test);
			click(driver, testcaseName, rotate_label, test);
		}else {
			waitforElemPresent(driver, testcaseName, 30, randomize_label, test);
			click(driver, testcaseName, randomize_label, test);
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param param
	 * @param ele
	 * @param qtCases
	 * @param test
	 * @throws InterruptedException
	 */
	private void setNumberOfQuestionsInMG(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		if (!param.get("MGquestionCount").isEmpty()) {
			click(driver, testcaseName, expand_num_of_que, test);
			waitforElemPresent(driver, testcaseName, 30, remove_que, test);
			int numberOfQuestions = Integer.parseInt(param.get("MGquestionCount"));
			if (numberOfQuestions < 2) {
				click(driver, testcaseName, remove_que, test);
			}else if (numberOfQuestions > 2) {
				for (int i = 0; i < (numberOfQuestions-2); i++) {
					click(driver, testcaseName, add_que, test);
					Thread.sleep(500);
				}
		
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param param
	 * @param ele
	 * @param qtCases
	 * @param test
	 * @throws InterruptedException 
	 */
	private void fillGridQueDetailsinMG(WebDriver driver, HashMap<String, String> param, WebPageElements ele, JsonObject qtCases, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		int questCount = qtCases.get("questionCount").getAsInt();
		JsonArray queText = qtCases.get("questionText").getAsJsonArray();
		JsonArray questionTypes = qtCases.get("questionTypes").getAsJsonArray();
		JsonArray isAnsLibrary =  qtCases.get("isAnswerlibrary").getAsJsonArray();
		JsonArray isAnsLibraryList =  qtCases.get("answerlibraryList").getAsJsonArray();
		if(!((queText.size() == questCount) &&  (questCount == questionTypes.size()))) {
			reportFail(testcaseName, "Number of questionText, questCount and questionTypes given in jsonCase file should be equal.", test);
		}
		for(int i=0; i<questCount; i++) {
			scrollIntoView(driver, testcaseName, By.xpath("//a[@id='products" + i + "']"), "Grid Question Drop Down Button "  +(i+1), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[@id='products" + i + "']"), "Grid Question Drop Down Button "  +(i+1), test);
			click(driver, testcaseName, By.xpath("//a[@id='products" + i + "']"), "Grid Question Drop Down Button "  +(i+1), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='menu_" +i +"']/ul"), "Grid Question Drop Down Menu " +(i+1), test);
			
			//  Select grid question type
			switch(questionTypes.get(i).getAsString()) {
			case "RG" :
				waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='menu_" +i +"']/ul/li/a[text()='Radio Button']"), "Radio Button", test);
				click(driver, testcaseName, By.xpath("//div[@id='menu_" +i +"']/ul/li/a[text()='Radio Button']"), "Radio Button", test);
				waitforElemNotVisible(driver, testcaseName, 30, By.xpath("//div[@id='menu_" +i +"']/ul"), "Grid Question Drop Down Menu " +(i+1), test);
				waitForElementToBeVisible(driver, testcaseName, By.xpath("//a[@id='products" + i +"'][text()='Radio Button']"), "Radio Button", 30, 
						100, test);
				break;
			}
			
			scrollIntoView(driver, testcaseName, By.xpath("//input[@name='txtGrid_" +i +"_Header']"), "Grid Header " +(i+1), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_" +i +"_Header']"), "Grid Header " +(i+1), test);
			click(driver, testcaseName,  By.xpath("//input[@name='txtGrid_" +i +"_Header']"), "Grid Header " +(i+1), test);
			setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_" +i +"_Header']"), queText.get(i).getAsString(), "Grid Header " +(i+1), test);
			
			// Fill answer option details
			switch(questionTypes.get(i).getAsString()) {
			case "RG" :
				if(Boolean.parseBoolean(isAnsLibrary.get(i).getAsString())) {
					answersLibraryinMG(driver, param, isAnsLibraryList.get(i).getAsString(), i, test);
				}
				break;
			}
			
		}
	}
	

	
	public void answersLibraryinMG(WebDriver driver, HashMap<String, String> param, String answerOption, int i, ExtentTest test)
			throws InterruptedException {String testcaseName = param.get("TestCaseName");
			scrollIntoView(driver, testcaseName, By.xpath("//div[@id='menu_" + i +"']/following-sibling::div"), "More", test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='menu_" + i +"']/following-sibling::div"), "More", test);
			click(driver, testcaseName, By.xpath("//div[@id='menu_" +i +"']/following-sibling::div"), "More", test);
			waitforElemPresent(driver, testcaseName, 10, By.xpath("//li[@id='lnkAnsLib" +i +"']"), "Answer library Button", test);
			click(driver, testcaseName, By.xpath("//li[@id='lnkAnsLib" +i +"']"), "Answer library button", test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//div[@id='menu_" +i +"']/div/div[@class='ansLibraryContainer']"), 
						"Answer library button", 30, 100, test);
			waitforElemPresent(driver, testcaseName, 30, search_ans_lib, test);
			setText(driver, testcaseName, search_ans_lib, answerOption, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='searchListOption']/div[@title='"+ answerOption  +"']"), 
						answerOption + " category", test);
			click(driver, testcaseName, By.xpath("//div[@id='searchListOption']/div[@title='"+ answerOption  +"']"), answerOption + " category", test);
			waitForLoad(driver, testcaseName, 30, test);
			
		}
	
	/**
	 * Readings function : DNT
	 * Survey Creation Readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getSMXReadingsOfSurveyCreation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), getProjectDashboardReading(driver, param, test));
		readingData.put(param.get("Step2"), getSurveyCreationReading(driver, param, test));
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("surveyName"), param.get("SID"), test);
		deleteProject(driver, param, param.get("surveyName"), param.get("SID"), test);
		return readingData;
	}
	
	
	/**
	 * Reading function : DNT
	 * Get Survey setting readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getSurveySettingsReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), goToProjectDetails(driver, param, test));
		readingData.put(param.get("Step2"), goToSurveySetting(driver, param, test).
				goToThankyouPage(driver, param, test).
				saveSurveySettings(driver, param, test));
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Drop down readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getDropDownReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\dropDownCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, drop_down_button, test));
		fillQueDetails(driver, param, drop_down_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, drop_down_button, testdata.get("case 1").getAsJsonObject(), test));
		deleteQuestion(driver, param, 1, 1, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Radio button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getRadioButtonReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\radioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, radio_button, test));
		fillQueDetails(driver, param, radio_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, radio_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Horizontal radio button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getHorizontalRadioButtonReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\horizontalRadioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, horizontal_radio_button, test));
		fillQueDetails(driver, param, horizontal_radio_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, horizontal_radio_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Check box button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getCheckBoxButtonReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\checkBoxCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, check_box_button, test));
		fillQueDetails(driver, param, check_box_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, check_box_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Text box button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getTextBoxButtonReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\textBoxCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, text_box_button, test));
		fillQueDetails(driver, param, text_box_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, text_box_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get List box button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getListBoxButtonReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\listBoxCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, listbox_button, test));
		fillQueDetails(driver, param, listbox_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, listbox_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Numeric allocation button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getNumericAllocationReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\numericAllocationCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, numeric_allocation, test));
		fillQueDetails(driver, param, numeric_allocation, testdata.get("case 1").getAsJsonObject(), test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, numeric_allocation, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Ranking button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getRankingReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\rankingCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, ranking_question_button, test));
		fillQueDetails(driver, param, ranking_question_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, ranking_question_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Rating radio button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getRatingRadioButtonsReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\ratingRadioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, rating_radio2_button, test));
		fillQueDetails(driver, param, rating_radio2_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, rating_radio2_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Rating Scale button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getRatingScaleButtonsReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\ratingScaleCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, rating_scale_button, test));
		fillQueDetails(driver, param, rating_scale_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, rating_scale_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Date button readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getDateButtonsReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\dateCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, date_button, test));
		fillQueDetails(driver, param, date_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, date_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Multiple Text box readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getMultipleTextBoxReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\multipleTextBoxCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, multiple_textbox_button, test));
		fillQueDetails(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MTBSubqueCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfSubquestions(driver, param, multiple_textbox_button, test);
		param.put("mtbFormat", testdata.get("case 1").getAsJsonObject().get("format").getAsString());
		fillSubquestionDetails(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Multiple drop down readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getMultipleDropdownReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\multipleDropDownCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, multiple_dropdown_button, test));
		fillQueDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		fillAnsOptionsDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MDDSubqueCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfSubquestions(driver, param, multiple_dropdown_button, test);
		fillSubquestionDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Demographic readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getDemographicReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\demoGraphicCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, demographics_button, test));
		fillQueDetails(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test);
		selectDemoGraphicQuestions(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Matrix grid readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getMatrixGridReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\matrixGridCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, matrix_grid_button, test));
		fillQueDetails(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MGquestionCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("questionCount").getAsInt()));
		param.put("MGSubquestionCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfQuestionsInMG(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		setNumberOfSubquestions(driver, param, matrix_grid_button, test);
		fillGridQueDetailsinMG(driver, param, matrix_grid_button,  testdata.get("case 1").getAsJsonObject(), test);
		fillSubquestionDetails(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Description readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getDescriptionReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\descriptionCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, description_button, test));
		fillQueDetails(driver, param, description_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, description_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	/**
	 * Reading function : DNT
	 * Get Attachment readings
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public Map<String, String> getAttachmentReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\attachmentCases.json", test);
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, attachments_button, test));
		fillQueDetails(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("attachmentsCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("attachmentsCount").getAsInt()));
		setNumberOfSubquestions(driver, param, attachments_button, test);
		fillSubquestionDetails(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		
		return readingData;
	}
	
	public String getSurveyCreationReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		enterSurveyName(driver, param, test);
		selectFolder(driver, param, test);
		selectPrimaryLanugage(driver, param, test);
		selectSecondaryLanugage(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		
		// Capture page load time
		start = System.currentTimeMillis();	
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		param.put("SID", driver.getCurrentUrl().toLowerCase().split("survey_no=")[1]);
		
		return strtotalTime;
	}
	
	public String getProjectDashboardReading(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		// Capture page load time
		start = System.currentTimeMillis();	
		click(driver, testcaseName, IHomePage.all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		closeAllProjectDashbard(driver, param, test);
		
		return strtotalTime;
	}
	
	public String deleteProject(WebDriver driver, HashMap<String, String> param, String surveyName, String SID, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyName +"\"]"));
		hoverAction(driver, testcaseName, survey, surveyName, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.more_icon, 60, 100, test);
		click(driver, testcaseName, IHomePage.more_icon, test);
		waitforElemPresent(driver, testcaseName, 30, IHomePage.delete, test);
		click(driver, testcaseName, IHomePage.delete, test);
		
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	

		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	public Map<String, String> getAddQuestionReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		JsonObject testdata = new JsonObject();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\radioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step1"), doubleClickOnQT(driver, param, radio_button, test));
		fillQueDetails(driver, param, radio_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step2"), saveQue(driver, param, radio_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
				
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\dropDownCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step3"), doubleClickOnQT(driver, param, drop_down_button, test));
		fillQueDetails(driver, param, drop_down_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step4"), saveQue(driver, param, drop_down_button, testdata.get("case 1").getAsJsonObject(), test));
		deleteQuestion(driver, param, 1, 1, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\horizontalRadioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step5"), doubleClickOnQT(driver, param, horizontal_radio_button, test));
		fillQueDetails(driver, param, horizontal_radio_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step6"), saveQue(driver, param, horizontal_radio_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\checkBoxCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step7"), doubleClickOnQT(driver, param, check_box_button, test));
		fillQueDetails(driver, param, check_box_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step8"), saveQue(driver, param, check_box_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\textBoxCases.json", test);
		readingData.put(param.get("Step9"), doubleClickOnQT(driver, param, text_box_button, test));
		fillQueDetails(driver, param, text_box_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step10"), saveQue(driver, param, text_box_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\listBoxCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step11"), doubleClickOnQT(driver, param, listbox_button, test));
		fillQueDetails(driver, param, listbox_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step12"), saveQue(driver, param, listbox_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\numericAllocationCases.json", test);
		readingData.put(param.get("Step13"), doubleClickOnQT(driver, param, numeric_allocation, test));
		fillQueDetails(driver, param, numeric_allocation, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step14"), saveQue(driver, param, numeric_allocation, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\rankingCases.json", test);
		readingData.put(param.get("Step15"), doubleClickOnQT(driver, param, ranking_question_button, test));
		fillQueDetails(driver, param, ranking_question_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step16"), saveQue(driver, param, ranking_question_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\ratingRadioButtonCases.json", test);
		param.put("AnswerOptions", testdata.get("case 1").getAsJsonObject().get("answerlibrary").getAsString());
		readingData.put(param.get("Step17"), doubleClickOnQT(driver, param, rating_radio2_button, test));
		fillQueDetails(driver, param, rating_radio2_button, testdata.get("case 1").getAsJsonObject(), test);
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		saveAnslibraryOptionsList(driver, param, param.get("AnswerOptions"), test);
		readingData.put(param.get("Step18"), saveQue(driver, param, rating_radio2_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);		
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\ratingScaleCases.json", test);
		readingData.put(param.get("Step19"), doubleClickOnQT(driver, param, rating_scale_button, test));
		fillQueDetails(driver, param, rating_scale_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step20"), saveQue(driver, param, rating_scale_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\dateCases.json", test);
		readingData.put(param.get("Step21"), doubleClickOnQT(driver, param, date_button, test));
		fillQueDetails(driver, param, date_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step22"), saveQue(driver, param, date_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\multipleTextBoxCases.json", test);
		readingData.put(param.get("Step23"), doubleClickOnQT(driver, param, multiple_textbox_button, test));
		fillQueDetails(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MTBSubqueCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfSubquestions(driver, param, multiple_textbox_button, test);
		param.put("mtbFormat", testdata.get("case 1").getAsJsonObject().get("format").getAsString());
		fillSubquestionDetails(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step24"), saveQue(driver, param, multiple_textbox_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\multipleDropDownCases.json", test);
		readingData.put(param.get("Step25"), doubleClickOnQT(driver, param, multiple_dropdown_button, test));
		fillQueDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		fillAnsOptionsDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MDDSubqueCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfSubquestions(driver, param, multiple_dropdown_button, test);
		fillSubquestionDetails(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step26"), saveQue(driver, param, multiple_dropdown_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\demoGraphicCases.json", test);
		readingData.put(param.get("Step27"), doubleClickOnQT(driver, param, demographics_button, test));
		fillQueDetails(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test);
		selectDemoGraphicQuestions(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step28"), saveQue(driver, param, demographics_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\matrixGridCases.json", test);
		readingData.put(param.get("Step29"), doubleClickOnQT(driver, param, matrix_grid_button, test));
		fillQueDetails(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("MGquestionCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("questionCount").getAsInt()));
		param.put("MGSubquestionCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("subquestionCount").getAsInt()));
		setNumberOfQuestionsInMG(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		setNumberOfSubquestions(driver, param, matrix_grid_button, test);
		fillGridQueDetailsinMG(driver, param, matrix_grid_button,  testdata.get("case 1").getAsJsonObject(), test);
		fillSubquestionDetails(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step30"), saveQue(driver, param, matrix_grid_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\descriptionCases.json", test);
		readingData.put(param.get("Step31"), doubleClickOnQT(driver, param, description_button, test));
		fillQueDetails(driver, param, description_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step32"), saveQue(driver, param, description_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		testdata = new JSONUtility().readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonfiles\\attachmentCases.json", test);
		readingData.put(param.get("Step33"), doubleClickOnQT(driver, param, attachments_button, test));
		fillQueDetails(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test);
		param.put("attachmentsCount", String.valueOf(testdata.get("case 1").getAsJsonObject().get("attachmentsCount").getAsInt()));
		setNumberOfSubquestions(driver, param, attachments_button, test);
		fillSubquestionDetails(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test);
		readingData.put(param.get("Step34"), saveQue(driver, param, attachments_button, testdata.get("case 1").getAsJsonObject(), test));
		deletePage(driver, param, test);
		Thread.sleep(3000);
		
		return readingData;
	}
	
	public Map<String, String> getAutoTranslateReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		
		readingData.put(param.get("Step1"), gotoTextTranslationPage(driver, param, test));
		readingData.put(param.get("Step2"), translateAllQuestions(driver, param, test));
		readingData.put(param.get("Step3"), saveTranslation(driver, param, test));
		readingData.put(param.get("Step4"), resetTranslation(driver, param, test));
		
		
		return readingData;
	}
	
	
	private String gotoTextTranslationPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, text_and_translation, test);
		click(driver, testcaseName, text_and_translation, test);
		waitforElemPresent(driver, testcaseName, 30, text_and_translation_menu, test);
		
		// Capture page load time
		start = System.currentTimeMillis();	
		click(driver, testcaseName, By.xpath("//div[@class='hd-dropdown-row'][text()='" + param.get("ttlangauage") + "']"), param.get("ttlangauage"), test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, language_dropdown, test);
		end = System.currentTimeMillis();	
	

		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	private String translateAllQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, auto_translate, test);
		click(driver, testcaseName, auto_translate, test);
		waitforElemPresent(driver, testcaseName, 30, all_translate, test);
		click(driver, testcaseName, all_translate, test);
	
		String actualAlertText = driver.switchTo().alert().getText();
		String expectedAlertText = "Please note, any existing text formatting or hyperlinks will not be retained while translating. Are you sure you want to continue? ";
		assertEquals(actualAlertText, expectedAlertText, "Auto translate alert message is not matching with expected text");
		
		// Capture page load time
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
		
	}
	
	private String saveTranslation(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoView(driver, testcaseName, save_btn, test);
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, language_dropdown, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	private String resetTranslation(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, reset_translation, test);
		click(driver, testcaseName, reset_translation, test);
		
		String actualAlertText = driver.switchTo().alert().getText();
		String expectedAlertText = "Are you sure you want to reset the translation done for this language? Once it is reset, this language will stop showing in survey participation.";
		assertEquals(actualAlertText, expectedAlertText, "Reset translation alert message is not matching with expected text");
		
		// Capture page load time
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
		
	}
	
	public Map<String, String> getQDLReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		String[] ansOptions = param.get("ansOptionsAll").split("/~~/");
		String[] showQuestion = param.get("showQuestion").split("/~/");
		String[] decisionQuestion = param.get("decisionQuestion").split("/~/");
		String[] operator = param.get("operator").split("/~/");
		
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		selectQuestionPage(driver, param, Integer.parseInt(param.get("pageNo")), test);
		readingData.put(param.get("Step1"), openQDLModal(driver, param, test));
		
		param.put("showQuestion", showQuestion[0]);
		param.put("decisionQuestion", decisionQuestion[0]);
		param.put("operator", operator[0]);
		
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_QDL)));
		addConditionInQDL(driver, param, ansOptions[0].split("/~/"), test);
		readingData.put(param.get("Step2"), saveQDLModal(driver, param, test));
		closeQDLModal(driver, param, test);
		readingData.put(param.get("Step3"), openQDLModal(driver, param, test));
		
		for(int i=1; i<showQuestion.length; i++) {
			param.put("showQuestion", showQuestion[i]);
			param.put("decisionQuestion", decisionQuestion[i]);
			param.put("operator", operator[i]);
			if (i==1) {
				driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_QDL)));
			}
			addConditionInQDL(driver, param, ansOptions[i].split("/~/"), test);
			if(i<showQuestion.length-1) {
				click(driver, testcaseName, add_more_qdl, test);
			}
			waitForLoad(driver, testcaseName, 30, test);
		}
		
		readingData.put(param.get("Step4"), saveQDLModal(driver, param, test));
		closeQDLModal(driver, param, test);
		readingData.put(param.get("Step5"), openQDLModal(driver, param, test));
		
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_QDL)));
		for(int i=1; i<= showQuestion.length; i++) {
			deleteQDLRule(driver, param, 1, test);
		}
		closeQDLModal(driver, param, test);
		
		return readingData;
	}
	
	public Map<String, String> getExpiryRuleReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}		
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), goToExpiryRule(driver, param, test));
		readingData.put(param.get("Step2"), saveSurveySettings(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getVisualSettingReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}		
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		
		readingData.put(param.get("Step1"), goToVisualSettingPage(driver, param, test));
		readingData.put(param.get("Step2"), saveVisualSettingPage(driver, param, test));
		readingData.put(param.get("Step3"), switchToMobileTheme(driver, param, test));
		readingData.put(param.get("Step4"), saveVisualSettingPage(driver, param, test));
		
		return readingData;
	}
	
	
	/**
	 * Use this method switch between survey pages by passing pageNo
	 * @param driver
	 * @param param
	 * @param pageNo
	 * @param test
	 */
	public String selectQuestionPage(WebDriver driver, HashMap<String, String> param, int pageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_number_drop_down, test);
		waitforElemPresent(driver, testcaseName, 60, go_to_page_list, test);
		if (pageNo > 0) {
			List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, surveyPages.get(pageNo-1), "Page "+pageNo, test);
			waitforElemPresent(driver, testcaseName, 60, page_actions, test);
			end = System.currentTimeMillis();	
			totalTime = (end - start) / 1000;
			strtotalTime = df.format(totalTime);
			
		}else {
			// Capture page load time
			click(driver, testcaseName, all_pages, test);
			waitforElemNotVisible(driver, testcaseName, 30, page_actions, test);
			end = System.currentTimeMillis();	
			totalTime = (end - start) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	private String openQDLModal(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, logic, test);
		click(driver, testcaseName, logic, test);
		waitforElemPresent(driver, testcaseName, 30, qdl_option, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, qdl_option, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_qdl, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public void addConditionInQDL (WebDriver driver, HashMap<String, String> param, String[] ansOptions, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		if (!isFirstQDL) {
			click(driver, testcaseName, add_more_qdl, test);
		}
		waitforElemPresent(driver, testcaseName, 30, select_showhide_question, test);
		selectByExactVisibleText(driver, testcaseName, select_showhide_question, param.get("showQuestion"), test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, select_decision_question, test);
		selectByExactVisibleText(driver, testcaseName, select_decision_question, param.get("decisionQuestion"), test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, select_operator, test);
		selectByExactVisibleText(driver, testcaseName, select_operator, param.get("operator"), test);
		
		for(int i=0; i<ansOptions.length; i++) {
			click(driver, testcaseName, By.xpath("//label[text()='" + ansOptions[i] + "']"), ansOptions[i], test);
		}
		isFirstQDL = false;
	}
	
	public String saveQDLModal(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, save, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save, test);
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
		
	}
	
	public void closeQDLModal(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, close, test);
		click(driver, testcaseName, close, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void deleteQDLRule(WebDriver driver, HashMap<String, String> param, int ruleNo, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[@class='qdl_question_no'][text()='" + ruleNo + "']/parent::div/parent::div"), "Rule No "+ ruleNo, test);
		String ruleId = driver.findElement(By.xpath("//label[@class='qdl_question_no'][text()='" + ruleNo +"']/ancestor::table[starts-with(@id,'divRule_')]"))
				.getAttribute("id");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//label[@class='qdl_question_no'][text()='" + ruleNo + "']/parent::div/parent::div"))).build().perform();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[@class='qdl_question_no'][text()='" + ruleNo + "']"
				+ "/parent::div/parent::div/following-sibling::span/a[@title='Delete']"), 
				"Rule No "+ ruleNo +" Delete icon", test);
		click(driver, testcaseName, By.xpath("//label[@class='qdl_question_no'][text()='" + ruleNo + "']"
				+ "/parent::div/parent::div/following-sibling::span/a[@title='Delete']"), "Rule No "+ ruleNo +" Delete icon", test);
		driver.switchTo().alert().accept();
		waitforElemNotVisible(driver, testcaseName, 30, By.xpath("//table[@id='" +ruleId +"']"), "Rule No "+ ruleNo, test);
	}
	
	
	public String goToExpiryRule(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		goToSurveySetting(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, expiry_rules, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		clickAtOffset(driver, testcaseName, expiry_rules, -15, 0, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, expiry_rules_title, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;

	}
	
	public String saveSurveySettings(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, save_btn2, test);
		waitforElemPresent(driver, testcaseName, 30, save_btn2, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn2, test);
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToVisualSettingPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, visual_settings, test);

		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, visual_settings, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 300, desktop_dev, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String saveVisualSettingPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String switchToMobileTheme(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, mobile_dev, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, mobile_dev, test);
		waitforElemPresent(driver, testcaseName, 30, mobile_view, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public Map<String, String> getSurveyDownloadReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		searchForSurveyInDashboard(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), downloadSurvey(driver, param, param.get("surveyname"), param.get("SID"), "pdf", test));
		readingData.put(param.get("Step2"), downloadSurvey(driver, param, param.get("surveyname"), param.get("SID"), "word", test));
		readingData.put(param.get("Step3"), downloadSurvey(driver, param, param.get("surveyname"), param.get("SID"), "scannerready", test));
		
		return readingData;
	}	
	
	
	public void searchForSurveyInDashboard(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_main_folder, 30, 100, test);
		setText(driver, testcaseName, IHomePage.new_search_bar, surveyTitle, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 120, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"), surveyTitle, 60, 100, test);
		
	}
	
	public String downloadSurvey(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, String fileType,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyTitle +"\"]"));
		new Actions(driver).moveToElement(survey).build().perform();
		waitForElementToBeVisible(driver, testcaseName, IHomePage.more_icon, 60, 100, test);
		click(driver, testcaseName, IHomePage.more_icon, test);
		waitforElemPresent(driver, testcaseName, 30, IHomePage.download, test);
		click(driver, testcaseName, IHomePage.download, test);
		
		start = System.currentTimeMillis();
		
		switch(fileType.toLowerCase()) {
		case "pdf" : 
			waitForDownloadFile(driver, param, IHomePage.pdf, "pdf", param.get("downloadFilePath"), test);
			break;
		case "word" : 
			waitForDownloadFile(driver, param, IHomePage.word, "doc", param.get("downloadFilePath"), test);
			break;
		case "scannerready" :
			waitForDownloadFile(driver, param, IHomePage.scanner_ready, "docx", param.get("downloadFilePath"), test);
			break;
		}
		
		end = System.currentTimeMillis();	

		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public void waitForDownloadFile(WebDriver driver, HashMap<String, String> param, WebPageElements downloadButton, String format, String downloadFilePath, ExtentTest test) {
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
			waitforElemPresent(driver, testcaseName, 30, downloadButton, test);
			click(driver, testcaseName, downloadButton, test);

			while (beforeCount >= afterCount && i < 600) {
				afterCount = Files.list(Paths.get(downloadFilePath)).count();
				Thread.sleep(500);
				i++;
			}
			if(i == 600) {
				reportFail(testcaseName,
						"The file was not downloaded.", test);
			}
			System.out.println(afterCount);
			
			String fileName = dmxPage.latestFileNameFromPath(downloadFilePath);
			while(fileName.contains("tmp") || fileName.contains("crdownload")) {
				Thread.sleep(500);
				fileName = dmxPage.latestFileNameFromPath(downloadFilePath);
			}
			
		} catch (Exception e) {
			reportFail(testcaseName,
					"The file was not downloaded.", test);
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
	
	public Map<String, String> getSurveyPageActionReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("surveyname"), param.get("SID"), test);
		copySurveyIntoSameAccount(driver, param, param.get("surveyname"), test);
		closeAllProjectDashbard(driver, param, test);
		
		goToDesignerPage(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		
		selectQuestionPage(driver, param, 1, test);
		readingData.put(param.get("Step1"), selectQuestionPage(driver, param, 0, test));
		readingData.put(param.get("Step2"), selectQuestionPage(driver, param, 19, test));
		readingData.put(param.get("Step3"), copyPage(driver, param, "Before page 1", test));
		selectQuestion(driver, param, 1, 4, test);
		readingData.put(param.get("Step4"), deleteQuestion(driver, param, 1, 4, test));
		readingData.put(param.get("Step5"), deletePage(driver, param, test));
		selectQuestionPage(driver, param, 19, test);
		readingData.put(param.get("Step6"), movePage(driver, param, "Before page 1", test));
		movePage(driver, param, "After page 19", test);
		readingData.put(param.get("Step7"),selectQuestion(driver, param, 19, 295, test));
		
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		deleteProject(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		
		
		return readingData;
	}
	
	public String copyPage(WebDriver driver, HashMap<String, String> param, String dest, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_actions, test);
		waitforElemPresent(driver, testcaseName, 30, copy_page, test);
		click(driver, testcaseName, copy_page, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		selectByExactVisibleText(driver, testcaseName, copy_page_options, dest, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, page_number_drop_down, test);
		end = System.currentTimeMillis();
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String movePage(WebDriver driver, HashMap<String, String> param, String dest, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_actions, test);
		waitforElemPresent(driver, testcaseName, 30, move_page, test);
		click(driver, testcaseName, move_page, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		selectByExactVisibleText(driver, testcaseName, move_page_options, dest, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, page_number_drop_down, test);
		end = System.currentTimeMillis();
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String deletePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_actions, test);
		waitforElemPresent(driver, testcaseName, 30, delete_page, test);
		click(driver, testcaseName, delete_page, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String selectQuestion(WebDriver driver, HashMap<String, String> param, int pageNo, int questionNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, page_number_drop_down, test);
		waitforElemPresent(driver, testcaseName, 60, go_to_page_list, test);
		if (pageNo > 0) {
			List<WebElement> surveyPages = getWebElements(driver, testcaseName, list_of_survey_pages, test);
			hoverAction(driver, testcaseName, surveyPages.get(pageNo-1), "Page No "+ pageNo, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//ul[@id='qpg" +pageNo +"']"), "Menu", test);
			hoverAction(driver, testcaseName, By.xpath("//ul[@id='qpg" +pageNo +"']/li/a[@tabindex='1']"), "First option", test);
			scrollIntoCenter(driver, testcaseName, By.xpath("//a[text()='" + "Question " + questionNo +"']"), "Question " + questionNo, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[text()='" + "Question " + questionNo +"']"), "Question " + questionNo, test);
			
			// Capture page load time
			start = System.currentTimeMillis();
			click(driver, testcaseName, By.xpath("//a[text()='" + "Question " + questionNo +"']"), "Question " + questionNo, test);
			waitForLoad(driver, testcaseName, 60, test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//div[@pageno='" + pageNo + "'][@qno='" + questionNo + "']"), "", 30, 100, test);
			end = System.currentTimeMillis();
			totalTime = (end - start) / 1000;
			strtotalTime = df.format(totalTime);
		}
		
		return strtotalTime;
	}
	
	
	public String deleteQuestion(WebDriver driver, HashMap<String, String> param, int pageNo, int questionNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@pageno='" + pageNo + "'][@qno='" + questionNo + "']"))).build().perform();
		waitForElementToBeVisible(driver, testcaseName, question_menu_delete_option, 30, 100, test);
		click(driver, testcaseName, question_menu_delete_option, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public Map<String, String> getQuotaReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		selectQuestion(driver, param, 1, 3, test);
		readingData.put(param.get("Step1"), openAnswerQuota(driver, param, 1, 3, test));
		setAnswerQuota(driver, param, "Big Problem", "1", "Grayed Out", "Quota exhaused", test);
		readingData.put(param.get("Step2"),saveAnswerQuota(driver, param, test));
		openAnswerQuota(driver, param, 1, 3, test);
		resetAnswerQuota(driver, param, "Big Problem", test);
		saveAnswerQuota(driver, param, test);
		
		return readingData;
	}
	
	public String openAnswerQuota(WebDriver driver, HashMap<String, String> param, int pageNo, int questionNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		hoverAction(driver, strtotalTime, By.xpath("//div[@pageno='" + pageNo + "'][@qno='" + questionNo + "']"), "Question " +questionNo, test);
		waitForElementToBeVisible(driver, testcaseName, question_menu_more_options, 30, 100, test);
		click(driver, testcaseName, question_menu_more_options, test);
		waitForElementToBeVisible(driver, testcaseName, answer_quota, 30, 100, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, answer_quota, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforFrameToBePresent(driver, testcaseName, 30, iframe_answer_quota, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[@for='ControlID_0_grdQs_ctl02_chkEnableQuota']"), "Answer option 1", test);
		end = System.currentTimeMillis();
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public void setAnswerQuota(WebDriver driver, HashMap<String, String> param, String ansOption, String quota, String action, String quotaMessage, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30,  By.xpath("//label[text()='" + ansOption +"']"), ansOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='" + ansOption +"']"), ansOption, test);
		String qid = driver.findElement(By.xpath("//label[text()='" + ansOption +"']/preceding-sibling::input/parent::span")).getAttribute("class");
		param.put("qid", qid.split("/")[0]);  
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='" + qid +"']/preceding-sibling::div/input"), ansOption + " quoto limit", test);
		setText(driver, testcaseName, By.xpath("//input[@value='" + qid +"']/preceding-sibling::div/input"), quota, ansOption + " quoto limit", test);
		selectByVisibleText(driver, testcaseName, By.xpath("//input[@value='" + qid +"']/ancestor::td/following-sibling::td/div/div/select"), action, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='" + qid +"']/ancestor::td/following-sibling::td/input"), 
				"Message Text Box", test);
		setText(driver, testcaseName, By.xpath("//input[@value='" + qid +"']/ancestor::td/following-sibling::td/input"), quotaMessage, "Message Text Box", test);
		
	}
	
	public String saveAnswerQuota(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 30, test);
		if(isAnswerQuotaApplied) {
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//img[@class='imgquota_mngmnt_" + param.get("qid") +"']"), "Quota Image", 30, 100, test);
		}else {
			waitforElemNotVisible(driver, testcaseName, 30, By.xpath("//img[@class='imgquota_mngmnt_" + param.get("qid") +"']"), "Quota Image", test);
		}
		
		end = System.currentTimeMillis();
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public void resetAnswerQuota(WebDriver driver, HashMap<String, String> param, String ansOption, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, reset, test);
		driver.switchTo().alert().accept();
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[text()='" + ansOption +"']"), ansOption,  test);
		isAnswerQuotaApplied = false;
	}
	
	
	public Map<String, String> getCopySurveyReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), copySurveyIntoSameAccount(driver, param, param.get("surveyname"), test));
		closeAllProjectDashbard(driver, param, test);
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		deleteProject(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		closeAllProjectDashbard(driver, param, test);
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step2"),copySurveyIntoDiffAccount(driver, param, param.get("surveyname"), test));
		return readingData;
	}
	
	public String copySurveyIntoSameAccount(WebDriver driver, HashMap<String, String> param, String surveyName, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyName +"\"]"));
		hoverAction(driver, testcaseName, survey, surveyName, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_copy_icon, 10, 100, test);
		click(driver, testcaseName, IHomePage.new_copy_icon, test);
		waitforElemPresent(driver, testcaseName, 30, IHomePage.new_copy_drop_down, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, IHomePage.new_copy_in_same_acc, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
		end = System.currentTimeMillis();
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		waitforElemPresent(driver, testcaseName, 60, IHomePage.new_search_bar, test);
		setText(driver, testcaseName, IHomePage.new_search_bar, surveyName, test);
		driver.switchTo().defaultContent();
		waitForLoad(driver, testcaseName, 120, test);
		switchToIframe(driver, testcaseName, IHomePage.all_project_dashboard_iframe, test);
		waitforElemPresent(driver, testcaseName, 60, IHomePage.filter_applied, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//tr[@stitle=\"" + surveyName +"\"]"), surveyName, 60, 100, test);
		
		String title = driver.findElements(By.xpath(IHomePage.NEW_SURVEY_TITLE)).get(0).getAttribute("title");
		param.put("copiedSurveyTitle", title.split(",", 2)[1].strip());
		param.put("copiedsurveySID", title.split(",", 2)[0].split(":")[1].strip());
		
		return strtotalTime;
	}
	
	
	public void closeAllProjectDashbard(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, IHomePage.close_button, test);
		click(driver, testcaseName, IHomePage.close_button, test);
	}
	
	public String copySurveyIntoDiffAccount(WebDriver driver, HashMap<String, String> param, String surveyName, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		WebElement survey = driver.findElement(By.xpath("//tr[@stitle=\"" + surveyName +"\"]"));
		hoverAction(driver, testcaseName, survey, surveyName, test);
		waitForElementToBeVisible(driver, testcaseName, IHomePage.new_copy_icon, 10, 100, test);
		click(driver, testcaseName, IHomePage.new_copy_icon, test);
		waitforElemPresent(driver, testcaseName, 30, IHomePage.new_copy_drop_down, test);
		
		click(driver, testcaseName, IHomePage.copy_in_diff_acc, test);
		waitforElemPresent(driver, testcaseName, 30, IHomePage.userid_copied_into, test);
		setText(driver, testcaseName, IHomePage.userid_copied_into, param.get("copiedIntoAccount"), test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, IHomePage.copy, test);
		waitforAlert(driver, testcaseName, 30, test);
		driver.switchTo().alert().accept();
		end = System.currentTimeMillis();
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String goToProjectDetails(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		goToSurveySetting(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, project_details, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, project_details, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, project_details_title, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;

	}

	public SMXPage goToSurveySetting(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, survey_options, test);
		click(driver, testcaseName, survey_options, test);
		return this;
	}
	
	public SMXPage goToThankyouPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, thank_you_page, test);
		click(driver, testcaseName, thank_you_page, test);
		return this;
	}
	
	public Map<String, String> getAssessmentSettingsReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), goToAssignScorePage(driver, param, test));
		readingData.put(param.get("Step2"), selectCategory(driver, param, "Category 1", test).
				saveAssignScore(driver, param, test));
		return readingData;
	}
	
	public String goToAssignScorePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, assign_scores, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, assign_scores, test);
		waitforElemPresent(driver, testcaseName, 30, assign_scores_label, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public SMXPage selectCategory(WebDriver driver, HashMap<String, String> param, String category, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@title='" + category + "']"), category, test);
		click(driver, testcaseName, By.xpath("//div[@title='" + category + "']"), category, test);
		waitforElemPresent(driver, testcaseName, 60, category_heading, test);
		return this;
	}
	
	public String saveAssignScore(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, save_btn, test);
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn, test);
		waitForLoad(driver, testcaseName, 60, test);
		end = System.currentTimeMillis();	
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public Map<String, String> getMultipleQuestionBranchingReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), goToMultipleQuestionBranching(driver, param, test));
		
		// Add first rule
		String [] ansOption = {"Never", "Almost Never"};
		selectMultipleQuestionBranchingPage(driver, param, "2", test).selectQuestionForRule(driver, param, "1", "1", "Q 1. Frequency (Rating Radio Button)", test)
		.selectAnsConditionForRule(driver, param, "1", "1", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "1", "1", ansOption, test)
		.addCondition(driver, param, "1", test);
		String [] ansOption2 = {"Big Problem", "Moderate Problem"};
		selectQuestionForRule(driver, param, "1", "2", "Q 3. Influence", test)
		.selectAnsConditionForRule(driver, param, "1", "2", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "1", "2", ansOption2, test)
		.addCondition(driver, param, "1", test);
		String [] ansOption3 = {"Accountant", "Consultant"};
		selectQuestionForRule(driver, param, "1", "3", "Q 4. Occupation", test)
		.selectAnsConditionForRule(driver, param, "1", "3", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "1", "3", ansOption3, test)
		.addNewRule(driver, param, "2", test);
		
		// Add second rule
		selectQuestionForRule(driver, param, "2", "1", "Q 1. Frequency (Rating Radio Button)", test)
		.selectAnsConditionForRule(driver, param, "2", "1", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "2", "1", ansOption, test)
		.addCondition(driver, param, "2", test);
		selectQuestionForRule(driver, param, "2", "2", "Q 3. Influence", test)
		.selectAnsConditionForRule(driver, param, "2", "2", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "2", "2",ansOption2, test)
		.addCondition(driver, param, "2", test);
		selectQuestionForRule(driver, param, "2", "3", "Q 4. Occupation", test)
		.selectAnsConditionForRule(driver, param, "2", "3", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "2", "3", ansOption3, test)
		.addNewRule(driver, param, "2", test);
		
		// Add third rule
		selectQuestionForRule(driver, param, "3", "1", "Q 1. Frequency (Rating Radio Button)", test)
		.selectAnsConditionForRule(driver, param, "3", "1", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "3", "1", ansOption, test)
		.addCondition(driver, param, "3", test);
		selectQuestionForRule(driver, param, "3", "2", "Q 3. Influence", test)
		.selectAnsConditionForRule(driver, param, "3", "2", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "3", "2", ansOption2, test)
		.addCondition(driver, param, "3", test);
		selectQuestionForRule(driver, param, "3", "3", "Q 4. Occupation", test)
		.selectAnsConditionForRule(driver, param, "3", "3", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "3", "3", ansOption3, test)
		.addNewRule(driver, param, "2", test);
		
		// Add fourth rule
		selectQuestionForRule(driver, param, "4", "1", "Q 1. Frequency (Rating Radio Button)", test)
		.selectAnsConditionForRule(driver, param, "4", "1", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "4", "1", ansOption, test)
		.addCondition(driver, param, "4", test);
		selectQuestionForRule(driver, param, "4", "2", "Q 3. Influence", test)
		.selectAnsConditionForRule(driver, param, "4", "2", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "4", "2", ansOption2, test)
		.addCondition(driver, param, "4", test);
		selectQuestionForRule(driver, param, "4", "3", "Q 4. Occupation", test)
		.selectAnsConditionForRule(driver, param, "4", "3", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "4", "3", ansOption3, test)
		.addNewRule(driver, param, "2", test);
		
		// Add fifth rule
		selectQuestionForRule(driver, param, "5", "1", "Q 1. Frequency (Rating Radio Button)", test)
		.selectAnsConditionForRule(driver, param, "5", "1", "Is one of the following", test).selectAnsOptionsForRule(driver, param, "5", "1", ansOption, test)
		.addCondition(driver, param, "5", test);
		selectQuestionForRule(driver, param, "5", "2", "Q 3. Influence", test)
		.selectAnsConditionForRule(driver, param, "5", "2", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "5", "2", ansOption2, test)
		.addCondition(driver, param, "5", test);
		selectQuestionForRule(driver, param, "5", "3", "Q 4. Occupation", test)
		.selectAnsConditionForRule(driver, param, "5", "3", "Is not one of the following", test).selectAnsOptionsForRule(driver, param, "5", "3", ansOption3, test);
		
		readingData.put(param.get("Step2"), saveBranchingRule(driver, param, testcaseName, test));
		
		// Delete all rules
		for(int i= 0; i<5; i++) {
			deleteRule(driver, param, 1, test);
		}
		
		saveBranchingRulenReturn(driver, param, testcaseName, test);
				
		return readingData;
	}
	
	/**
	 * Open Multi-Question Branching modal
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public String goToMultipleQuestionBranching(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, logic, test);
		waitforElemPresent(driver, testcaseName, 30, multiple_que_branching, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, multiple_que_branching, test);
		waitForElementToBeVisible(driver, testcaseName, iframe_multiple_que_branching, 30, 100, test);
		switchToIframe(driver, testcaseName, iframe_multiple_que_branching, test);
		waitForInsideLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[starts-with(@id,'dvMainPageCon_')]"), "Page Accordion", test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Select any page by passing strPageNo parameter in Multiple-Question Branching modal
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param test
	 * @return
	 */
	public SMXPage selectMultipleQuestionBranchingPage(WebDriver driver, HashMap<String, String> param, String strPageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvMainPageCon_" + strPageNo + "']"), "Page Accordion " + strPageNo, test);
		click(driver, testcaseName, By.xpath("//div[@id='dvMainPageCon_" + strPageNo + "']"), "Page Accordion " + strPageNo,  test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, mqb_info, test);
		return this;
	}
	
	/**
	 * Select survey question for Multiple-Question Branching rule
	 * @param driver
	 * @param param
	 * @param strRuleNO
	 * @param strConditionNo
	 * @param qTitle
	 * @param test
	 * @return
	 */
	public SMXPage selectQuestionForRule(WebDriver driver, HashMap<String, String> param, String strRuleNO, String strConditionNo, String qTitle, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvQCont_"+ strRuleNO + "_" + strConditionNo +"']"), "Condition Drop down", test);
		click(driver, testcaseName, By.xpath("//div[@id='dvQCont_"+ strRuleNO + "_" + strConditionNo +"']"), "Condition Drop down", test);
		scrollIntoCenter(driver, testcaseName, By.xpath("//li[@id='liQList_"+ strRuleNO + "_" + strConditionNo +"']//span[@title='" + qTitle + "']"), qTitle, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//li[@id='liQList_"+ strRuleNO + "_" + strConditionNo +"']//span[@title='" + qTitle + "']"), qTitle, test);
		click(driver, testcaseName,By.xpath("//li[@id='liQList_"+ strRuleNO + "_" + strConditionNo +"']//span[@title='" + qTitle + "']"), qTitle, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@id='ddlAnsOpr_"+ strRuleNO + "_" + strConditionNo +"']"), "Answer Option Drop down", test);
		return this;
	}
	
	/**
	 * Select answer options condition for for applied condition in rule
	 * @param driver
	 * @param param
	 * @param strRuleNO
	 * @param strConditionNo
	 * @param strCondition
	 * @param test
	 * @return
	 */
	public SMXPage selectAnsConditionForRule(WebDriver driver, HashMap<String, String> param, String strRuleNO, String strConditionNo, String strCondition, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@id='ddlAnsOpr_"+ strRuleNO + "_" + strConditionNo +"']"), "Answer Option Drop down", test);
		selectByVisibleText(driver, testcaseName, By.xpath("//select[@id='ddlAnsOpr_"+ strRuleNO + "_" + strConditionNo +"']"), strCondition, test);		
		return this;
	}
	
	/**
	 * Select Answer options for applied condition in rule
	 * @param driver
	 * @param param
	 * @param strRuleNO
	 * @param strConditionNo
	 * @param ansOptions
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public SMXPage selectAnsOptionsForRule(WebDriver driver, HashMap<String, String> param, String strRuleNO, String strConditionNo, String[] ansOptions, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		for(int i=0; i<ansOptions.length; i++) {
			scrollIntoCenter(driver, testcaseName, By.xpath("//label[starts-with(@id,'lblAns_" + strRuleNO + "_" + strConditionNo +"')][text()='" + ansOptions[i] + "']"), ansOptions[i], test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[starts-with(@id,'lblAns_" + strRuleNO + "_" + strConditionNo +"')][text()='" + ansOptions[i] + "']"), ansOptions[i], test);
			click(driver, testcaseName, By.xpath("//label[starts-with(@id,'lblAns_" + strRuleNO + "_" + strConditionNo +"')][text()='" + ansOptions[i] + "']"), ansOptions[i], test);
			Thread.sleep(500);
		}
		return this;
	}
	
	/**
	 * Add condition in rule
	 * @param driver
	 * @param param
	 * @param strRuleNO
	 * @param test
	 * @return
	 */
	public SMXPage addCondition(WebDriver driver, HashMap<String, String> param, String strRuleNO, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		int totalConditionsBefore = driver.findElements(By.xpath("//div[starts-with(@id,'dvQCont_')]")).size();
		click(driver, testcaseName, By.xpath("//td[@id='tdAddCond_" + strRuleNO + "']/div[@class='add_new_btn_cont addcondition']") , "Add Condition", test);
		waitForLoad(driver, testcaseName, 60, test);
		int totalConditionsAfter = driver.findElements(By.xpath("//div[starts-with(@id,'dvQCont_')]")).size();
		
		// Validate if condition has been added or not
		if(totalConditionsAfter == (totalConditionsBefore + 1)) {
			reportPass("Condition added successfully.", test);
		}else {
			reportFail(testcaseName, "Condition is not added.", test);
		}
		return this;
	}
	
	/**
	 * Add new rule in given page
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param test
	 * @return
	 */
	public SMXPage addNewRule(WebDriver driver, HashMap<String, String> param, String strPageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[@id='dvAddRule_" + strPageNo +"']"), "Add New Rule", test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvAddRule_" + strPageNo +"']"), "Add New Rule", test);
		click(driver, testcaseName, By.xpath("//div[@id='dvAddRule_" + strPageNo +"']"), "Add New Rule", test);
		waitForLoad(driver, testcaseName, 30, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//div[text()='Rule " + strPageNo + "']"), "Rule " + strPageNo, 30, 100, test);
		return this;
	}
	
	/**
	 * Save Branching Rule
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param test
	 * @return
	 */
	public String saveBranchingRule(WebDriver driver, HashMap<String, String> param, String strPageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, adv_save, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemNotVisible(driver, testcaseName, 60, add_condition, test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Save and Return to Branching page
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param test
	 * @return
	 */
	public String saveBranchingRulenReturn(WebDriver driver, HashMap<String, String> param, String strPageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, adv_save_n_return, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[starts-with(@id,'dvMainPageCon_')]"), "Page Accordion", test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	/**
	 * Delete Branching rule
	 * @param driver
	 * @param param
	 * @param ruleNo
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public SMXPage deleteRule(WebDriver driver, HashMap<String, String> param, int ruleNo, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		int totalRulesBefore = driver.findElements(By.xpath("//td[@class='brRule_head']/div[starts-with(text(),'Rule')]")).size();
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[starts-with(text(),'Rule "+ ruleNo + "')]/parent::td[@class='brRule_head']//*[@class='spnruledelete']/a"), "Rule " + ruleNo, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[starts-with(text(),'Rule "+ ruleNo + "')]/parent::td[@class='brRule_head']//*[@class='spnruledelete']/a"), "Rule " + ruleNo, test);
		click(driver, testcaseName, By.xpath("//div[starts-with(text(),'Rule "+ ruleNo + "')]/parent::td[@class='brRule_head']//*[@class='spnruledelete']/a"), "Rule " + ruleNo, test);
		driver.switchTo().alert().accept();
		waitForJStoLoad(driver, 60);
		
		int totalRulesAfter = driver.findElements(By.xpath("//td[@class='brRule_head']/div[starts-with(text(),'Rule')]")).size();
		
		// Validate if Rule has been deleted or not
		if(totalRulesAfter == (totalRulesBefore - 1)) {
			reportPass("Rule deleted successfully.", test);
		}else {
			reportFail(testcaseName, "Rule is not deleted.", test);
		}
		
		return this;
	}
	

	public Map<String, String> getSingleQuestionBranchingReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		goToDesignerPage(driver, param, param.get("surveyname"), param.get("SID"), test);
		readingData.put(param.get("Step1"), goToSingleQuestionBranching(driver, param, test));
		
		selectSingleQuestionBranchingPage(driver, param, "1", test)
		.selectBranchingQue(driver, param, "1", "1", "Frequency (Rating Radio Button)", test)
		.selectBranchingLogicForAnswers(driver, param, "1", "1", "Never", "Page 3", test)
		.saveSingleQuestionBranching(driver, param, "1", test);
		
		selectSingleQuestionBranchingPage(driver, param, "2", test)
		.selectBranchingQue(driver, param, "2", "31", "Frequency (Rating Radio Button)", test)
		.selectBranchingLogicForAnswers(driver, param, "2", "31", "Never", "Page 4", test)
		.saveSingleQuestionBranching(driver, param, "31", test);
		
		selectSingleQuestionBranchingPage(driver, param, "6", test)
		.selectBranchingQue(driver, param, "6", "75", "Frequency (Rating Radio Button)", test)
		.selectBranchingLogicForAnswers(driver, param, "6", "75", "Never", "Page 8", test)
		.saveSingleQuestionBranching(driver, param, "75", test);
		
		selectSingleQuestionBranchingPage(driver, param, "7", test)
		.selectBranchingQue(driver, param, "7", "102", "Frequency (Rating Radio Button)", test)
		.selectBranchingLogicForAnswers(driver, param, "7", "102", "Never", "Page 9", test)
		.saveSingleQuestionBranching(driver, param, "102", test);
		
		selectSingleQuestionBranchingPage(driver, param, "8", test)
		.selectBranchingQue(driver, param, "8", "129", "Frequency (Rating Radio Button)", test)
		.selectBranchingLogicForAnswers(driver, param, "8", "129", "Never", "Page 10", test);
		
		readingData.put(param.get("Step2"), saveSingleQuestionBranching(driver, param, "129", test));
		
		deleteSingleQueBranching(driver, param, "1", test)
		.deleteSingleQueBranching(driver, param, "31", test)
		.deleteSingleQueBranching(driver, param, "75", test)
		.deleteSingleQueBranching(driver, param, "102", test)
		.deleteSingleQueBranching(driver, param, "129", test);
		
		return readingData;
	}
	
	/**
	 * Navigate to Single Question branching page
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 */
	public String goToSingleQuestionBranching(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, logic, test);
		waitforElemPresent(driver, testcaseName, 30, single_que_branching, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, single_que_branching, test);
		waitForElementToBeVisible(driver, testcaseName, iframe_single_que_branching, 30, 100, test);
		switchToIframe(driver, testcaseName, iframe_single_que_branching, test);
		waitForInsideLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[starts-with(@id,'dvMainPageCon_')]"), "Page Accordion", test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Select page on which branching needs to be apply
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param test
	 * @return
	 */
	public SMXPage selectSingleQuestionBranchingPage(WebDriver driver, HashMap<String, String> param, String strPageNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[@id='dvMainPageCon_" + strPageNo + "']"), "Page Accordion " + strPageNo, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvMainPageCon_" + strPageNo + "']"), "Page Accordion " + strPageNo, test);
		click(driver, testcaseName, By.xpath("//div[@id='dvMainPageCon_" + strPageNo + "']"), "Page Accordion " + strPageNo,  test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvQuestionText_" + strPageNo + "']"), "Select Question Drop Down", test);
		return this;
	}
	
	/**
	 * Select question for branching
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param strQNo
	 * @param qTitle
	 * @param test
	 * @return
	 */
	public SMXPage selectBranchingQue(WebDriver driver, HashMap<String, String> param, String strPageNo, String strQNo, String qTitle, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, By.xpath("//div[@id='dvQuestionText_" + strPageNo + "']"), "Select Question Drop Down", test);
		scrollIntoCenter(driver, testcaseName, By.xpath("//div[@class='QuestCount'][text()='Q "+ strQNo +"']/following-sibling::div[@title='" + qTitle + "']"), 
				"Q "+ strQNo + " " + qTitle, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='QuestCount'][text()='Q "+ strQNo +"']/following-sibling::div[@title='" + qTitle + "']"),
				"Q "+ strQNo + " " + qTitle, test);
		click(driver, testcaseName, By.xpath("//div[@class='QuestCount'][text()='Q "+ strQNo +"']/following-sibling::div[@title='" + qTitle + "']"), 
				"Q "+ strQNo + " " + qTitle, test);
		waitforElemPresent(driver, testcaseName, 0, By.xpath("//div[@id='dvAnswerList" + strPageNo + "']"), "Answer List", test);
		return this;
	}
	
	/**
	 * Select logic for applied branching rule
	 * @param driver
	 * @param param
	 * @param strPageNo
	 * @param strQNo
	 * @param ansOption
	 * @param branchToLogic
	 * @param test
	 * @return
	 */
	public SMXPage selectBranchingLogicForAnswers(WebDriver driver, HashMap<String, String> param, String strPageNo, String strQNo, String ansOption, String branchToLogic, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvAnswerList" + strPageNo + "']/div//table//td[text()='" + ansOption + "']/following-sibling::td//select[@qno='" + strQNo + "']"), 
				"Branch to this page for answer option :" + ansOption, test);
		selectByExactVisibleText(driver, testcaseName, By.xpath("//div[@id='dvAnswerList" + strPageNo + "']/div//table//td[text()='" + ansOption + "']/following-sibling::td//select[@qno='" + strQNo + "']"), 
				branchToLogic, test);
		return this;
	}
	
	/**
	 * Save Single Question branching rule
	 * @param driver
	 * @param param
	 * @param strQNo
	 * @param test
	 * @return
	 */
	public String saveSingleQuestionBranching(WebDriver driver, HashMap<String, String> param, String strQNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dvSaveCancel_" + strQNo + "']/input[@value='Save']"), "Save",  test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, By.xpath("//div[@id='dvSaveCancel_" + strQNo + "']/input[@value='Save']"), "Save", test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//div[@id='dvEditDeleteBranching_" + strQNo + "']//div[starts-with(@onclick,'removeBranching')]"), "Remove Branching", 60, 100, test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Delete Branching rule
	 * @param driver
	 * @param param
	 * @param strQNo
	 * @param test
	 * @return
	 */
	public SMXPage deleteSingleQueBranching(WebDriver driver, HashMap<String, String> param, String strQNo, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		int totalRulesBefore = driver.findElements(By.xpath("//div[starts-with(@id,'dvEditDeleteBranching_')]")).size();
		
		click(driver, testcaseName, By.xpath("//div[@id='dvEditDeleteBranching_" + strQNo + "']//div[starts-with(@onclick,'removeBranching')]"), "Remove Branching", test);
		driver.switchTo().alert().accept();
		waitForLoad(driver, testcaseName, 60, test);
		
		int totalRulesAfter = driver.findElements(By.xpath("//div[starts-with(@id,'dvEditDeleteBranching_')]")).size();
		
		// Validate if branching has been deleted or not
		if(totalRulesAfter == (totalRulesBefore - 1)) {
			reportPass("Rule deleted successfully.", test);
		}else {
			reportFail(testcaseName, "Rule is not deleted.", test);
		}
		return this;
	}
	
	public Map<String, String> getRearrangeQuestionReadings(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		new HomePage().openDashboard(driver, param, test);
		searchForSurveyInDashboard(driver, param, param.get("surveyname"), param.get("SID"), test);
		copySurveyIntoSameAccount(driver, param, param.get("surveyname"), test);
		closeAllProjectDashbard(driver, param, test);
		
		goToDesignerPage(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		readingData.put(param.get("Step1"), goToRearrangePage(driver, param, test));
		rearrangeQuestions(driver, param, "1", "1. Frequency (Rating Radio Button) [Rating Radio Button] ", 
				"2", "0", test);
		saveRearrangePage(driver, param, test);
		
//		openDashboard(driver, param, test);
//		searchForSurveyInDashboard(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
//		deleteProject(driver, param, param.get("copiedSurveyTitle"), param.get("copiedsurveySID"), test);
		
		return readingData;
	}
	
	public String goToRearrangePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, rearrange_questions, test);
		waitForElementToBeVisible(driver, testcaseName, iframe_rearrange_questions, 30, 100, test);
		switchToIframe(driver, testcaseName, iframe_rearrange_questions, test);
		waitForInsideLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[starts-with(@class, 'Rearr-pg-ON')]"), "Page Accordion", test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public SMXPage rearrangeQuestions(WebDriver driver, HashMap<String, String> param, String strPageNoSrc, 
			String qTitleSrc, String strTargetPageNo, String strOrderNo,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		WebElement source = driver.findElement(By.xpath("//div[@title='" + qTitleSrc + "'][@page_no='" + strPageNoSrc + "']"));
		
		// Get list of questions present of target page
		List<WebElement> questionList = driver.findElements(By.xpath("//div[@id='p" + strTargetPageNo + "']/div"));
		
		Actions builder = new Actions(driver);
//		TouchActions builder = new TouchActions(driver);
//		builder.moveToElement(source).dragAndDrop(source, questionList.get(Integer.parseInt(strOrderNo))).build().perform();
		builder.clickAndHold(source).pause(Duration.ofSeconds(1)).moveToElement(questionList.get(Integer.parseInt(strOrderNo))).pause(Duration.ofSeconds(1)).release(questionList.get(Integer.parseInt(strOrderNo))).build().perform();
		
		// Refresh the list of questions present on target page for validation
		questionList = driver.findElements(By.xpath("//div[@id='p" + strTargetPageNo + "']/div"));
		
		//To verify drop success/fail by validating the text inside target element
		String targetText = questionList.get(Integer.parseInt(strOrderNo)).getAttribute("title");
		if(targetText == qTitleSrc) {
			reportPass("Source is dropped at location", test);
		}else {
			reportFail(testcaseName, "Source is not dropped at location", test);
		}
		Thread.sleep(1000);
		
		return this;
	}
	
	public String saveRearrangePage(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, save_btn, test);
		waitforElemPresent(driver, testcaseName, 30, save_btn, test);
		
		// Capture page load time
		start = System.currentTimeMillis();
		click(driver, testcaseName, save_btn, test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 60, designer_button, test);
		end = System.currentTimeMillis();	
		
		totalTime = (end - start) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
		
	}
	
}
