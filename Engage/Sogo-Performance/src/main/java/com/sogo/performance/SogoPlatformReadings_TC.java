package com.sogo.performance;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageobjects.SoGoStaticPage;
import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.Read_XLS;
import utility.SuiteUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.ITest;



public class SogoPlatformReadings_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	public boolean testSkip = false;
	String sheetName = "PlatformReadingsTC";
	String readingSheet = "Readings";
	String readingFilePath = null;
	public ExtentTest test;
	public DecimalFormat df = new DecimalFormat("#.##");
	public double finish, start;
	static public Map<String, String> readingData = new LinkedHashMap<String, String>();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		init();
		filePath = TestFile;
		URLs = TestFile.getEnvURL("Environment");
		participationURLs = TestFile.getEnvURL("Participation");
		for (String env : URLs.keySet()) {
			Environment = env;
		}	
		readingFilePath = SuiteUtility.createPlatformreadingSheet("Platform Reading", readingSheet, "xlsx");
		    
	}

	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC1(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String surveyTitle = getData(data, "Survey Title");
		String SID = getData(data, "SID");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = TestFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmxPage.getBarGraphReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC2(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String surveyTitle = getData(data, "Survey Title");
		String SID = getData(data, "SID");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = TestFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmxPage.getResponseTableReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC3(LinkedHashMap<String, String> data, String reportName) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String surveyTitle = getData(data, "Survey Title");
		String SID = getData(data, "SID");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = TestFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmxPage.getIndividualReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	


	@AfterMethod(alwaysRun = true)
	public void reporterDataResults(ITestResult Result) throws IOException {
		if (Result.getStatus() == ITestResult.SKIP) {
			readingData.put(Result.getName(), "0");
			Reporter.log(Result.getName() + " is SKIPPED.");
			Add_Log.info(Result.getName() + " is SKIPPED.");
			TestResultTL.put(Result.getName(), "SKIP");
			test.skip(Result.getName() + " is SKIPPED.");
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			readingData.put(Result.getName(), "0");
			String path = captureScreenShot(Result, "FAIL", getDriver());
			File screenshot = new File(path);
			
			Reporter.log(Result.getName() + " is FAILED.");
			Add_Log.info(Result.getName() + " is FAILED.");
			TestResultTL.put(Result.getName(), "FAIL");
			test.fail(Result.getName() + " is FAILED.", (MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots(getDriver())).build()));
			
			String errorPage = getErrorPage(getDriver());
			URL errorURL = new URL(errorPage);	
			StringWriter errors = new StringWriter();
			Result.getThrowable().printStackTrace(new PrintWriter(errors));
			String subject = errorURL.getHost().replace("http://","").replace("http:// www.","").replace("www.","").replace(".com", "") +" : Error in Performance Suite";
			sendHtmlFormatMail(subject, errorPage, errorURL.getPath(), errorURL.getQuery(), getIpAddress(), errors.toString(), screenshot);
			
			if (!(getDriver() == null)) {
				closeWebBrowser();
			}
		} else if (Result.getStatus() == ITestResult.SUCCESS) {
//			String path = captureScreenShot(Result, "PASS", getDriver());
			
			Reporter.log(Result.getName() + " is PASSED.");
			Add_Log.info(Result.getName() + " is PASSED.");
			TestResultTL.put(Result.getName(), "PASS");
			test.pass(Result.getName() + " is PASSED.");
			if (!(getDriver() == null)) {
				closeWebBrowser();
			}
		}
		SuiteUtility.WriteResultUtility4(new Read_XLS(System.getProperty("user.dir") + readingFilePath), readingSheet, Result, readingData);
		testSkip = false;
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
		SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
	}


	 

}
