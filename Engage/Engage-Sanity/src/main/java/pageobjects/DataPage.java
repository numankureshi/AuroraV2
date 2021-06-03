package pageobjects;


import java.io.File;
import java.io.FileFilter;
import java.lang.module.FindException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.text.ParseException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.xdgf.usermodel.section.geometry.MoveTo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import property.IDMXPage;
import property.IDataPage;
import property.IHomePage;
import property.IRMXPage;
import property.ISMXPage;
import property.ISurveyPage;
import property.IDataPage;
import utility.SeleniumUtils;
import utility.WebPageElements;

public class DataPage extends SeleniumUtils implements IDataPage {
	
	public double finish, start;
	public double end;
	
	public double goToDataPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new DMXPage().goToDistributePage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, data_module, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, import_module, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	public void dataImport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, import_module, test);
		click(driver, testcaseName, import_module, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		driver.findElement(By.xpath(IMPORT_FILE)).sendKeys(System.getProperty("user.dir")
				+"\\src\\main\\resources\\excelfiles\\uploadfiles\\" + param.get("file"));
		Thread.sleep(500);	
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[text()='"+ param.get("file") +"']"), param.get("file"), test);
		click(driver, testcaseName, import_map,test);
		waitforElemPresent(driver, testcaseName, 30, import_data, test);
		click(driver, testcaseName, import_data, test);
		try {
			if(driver.findElement(By.xpath(import_continue.getValue())).isDisplayed()){
				click(driver, testcaseName, import_continue, test);
			}		
		}catch(NoSuchElementException e) {
			System.out.println("No mismatch occured, hence mismatch wizard step skipped");
		}
		waitforElemPresent(driver, testcaseName, 30, import_loadresponses, test);
	}
	
	public void dataExportExcel(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_excel, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
		
	}
	
	public void dataExportCSV(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_csv, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
		
	}
	
	public void dataExportXML(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_xml, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	
	public void dataExportSPSS(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_spss, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	
	public void dataExportAccess(WebDriver driver, HashMap<String, String> param,  ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_access, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	public void dataExportWord(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_word, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
	}
	
	public void dataExportHtml(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_html, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, select_continue1, test);
//		click(driver, testcaseName, select_continue1, test);
//		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight);", test);
//		//scrollIntoView(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, selectex_continue2, test);
//		click(driver, testcaseName, select_export, test);
}
	public void dataExportK12Insight(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		click(driver, testcaseName, data_module, test);
		click(driver, testcaseName, export_sogosurvey, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, export_prepare, test);
		click(driver, testcaseName, export_prepare, test);
		waitForLoad(driver, testcaseName, 30, test);
//		click(driver, testcaseName, export_continue, test);
//		click(driver, testcaseName, export_responses, test);
//		//click(driver, testcaseName, selectex_continue2, test);
//		//click(driver, testcaseName, selectex_continue2, test);
//		//click(driver, testcaseName, select_export, test);
}
	
	public void dataExportAll(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();

        switch(noDay) {
        case 1:
           	dataExportExcel(driver, param, test);
            break;
        case 2:
        	dataExportCSV(driver, param, test);
            break;
        case 3:
        	dataExportXML(driver, param, test);
            break;
        case 4:
        	dataExportSPSS(driver, param, test);
            break;
        case 5:
        	dataExportAccess(driver, param, test);
            break;
        case 6:
        	dataExportWord(driver, param, test);
            break;
        case 7:
        	dataExportHtml(driver, param, test);
            break;
        default:
            break;
        }
}

	
}

