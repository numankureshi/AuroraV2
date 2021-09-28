package com.engage.performance.dmx;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.Read_XLS;
import utility.SuiteUtility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class DMXPlatformReading_TC extends SuiteBase {
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
	public static HashMap<String, String> TestResultTL = new HashMap<String, String>();
	static public Map<String, String> readingData = new LinkedHashMap<String, String>();
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		init();
		filePath = platformReadingFile;
		URLs = platformReadingFile.getEnvURL("Environment");
		participationURLs = platformReadingFile.getEnvURL("Participation");
		for (String env : URLs.keySet()) {
			Environment = env;
		}
		readingFilePath = SuiteUtility.createPlatformreadingSheet("Platform Reading", readingSheet, "xlsx");
	}

	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC25(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getDMHomePageReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC26(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));
		param.put("Step8", getData(data, "Step 8"));
		param.put("Step9", getData(data, "Step 9"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("prepopdd", getData(data, "prepopdd"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getSingleUseInvByListReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC27(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));
		param.put("Step8", getData(data, "Step 8"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getSingleUseInvReadingsByFile(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC28(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));
		param.put("Step8", getData(data, "Step 8"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getSingleUseInvReadingsByManually(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC29(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("emailLang", getData(data, "language"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getQuickSendReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC30(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("mapValues", getData(data, "mapValues"));
		param.put("file", getData(data, "file"));
		param.put("emailaddcol", getData(data, "emailaddcol"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getListCreationReadingByFile(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC31(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("prepopdd", getData(data, "prepopdd"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getSAPReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC32(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getEmailTempCreationReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC33(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getDeleteEmailTempReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC34(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getDeleteEmailTempFromListReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC35(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getCopyEmailTemplateReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC36(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getCopyEmailTemplateFromListReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC37(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getPreviewEmailTemplateReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC38(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, test);
				readingData = dmx.getPreviewEmailTemplateFromListReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC39(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("channel", getData(data, "channel"));
		param.put("searchRec1", getData(data, "searchRec1"));
		param.put("searchRec2", getData(data, "searchRec2"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getTrackSurveyReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC40(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("channel", getData(data, "channel"));
		param.put("delText", getData(data, "textBox1"));
		
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getTrackSurveyDeleteReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC41(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("dateFormat", getData(data, "dateFormat"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToAllProject(getDriver(), param, test);
				readingData = dmx.getScheduledLaterByFileReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC42(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("dateFormat", getData(data, "dateFormat"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToAllProject(getDriver(), param, test);
				readingData = dmx.getScheduledLaterByListReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC43(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("dateFormat", getData(data, "dateFormat"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToAllProject(getDriver(), param, test);
				readingData = dmx.getScheduledLaterTypeManuallyReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC44(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("dateFormat", getData(data, "dateFormat"));
		param.put("count", getData(data, "Nmax"));
		param.put("pages", getData(data, "textBox1"));
			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smx.copySurvey(getDriver(), param, test);
				readingData = dmx.getReminderWizReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC45(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "file"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("dateFormat", getData(data, "dateFormat"));

			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smx.copySurvey(getDriver(), param, test);
				readingData = dmx.getCancelRemindersReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC46(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));

			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getShareOnFbReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC47(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));

			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getShareOnTwitterReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC48(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));

			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getShareOnLinkedInReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "DMX", alwaysRun = true)
	public void PlatformReadings_TC49(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Survey Title", getData(data, "Survey Title"));
		param.put("SID", getData(data, "SID"));
		param.put("file", getData(data, "file"));

			
		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : URLs.keySet()) {
				System.out.println(URLs.get(key));
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				readingData = dmx.getSMSInvReadings(getDriver(), param, test);
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
		extent.flush();
		fetchExcelData.reportLog("Engage_PlatformReadings", "Report", "xlsx");
	}
	
	 

}
