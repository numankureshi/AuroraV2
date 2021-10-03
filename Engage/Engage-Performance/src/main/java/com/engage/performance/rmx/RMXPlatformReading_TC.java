package com.engage.performance.rmx;

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

public class RMXPlatformReading_TC extends SuiteBase {
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
		readingFilePath = SuiteUtility.createPlatformreadingSheet("RMx Reading", readingSheet, "xlsx");
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
		param.put("Step6", getData(data, "Step 6"));
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getBarGraphReportReading(getDriver(), param, test);
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
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getResponseTableReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC3(LinkedHashMap<String, String> data) throws Exception {
		
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
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getIndividualReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC4(LinkedHashMap<String, String> data) throws Exception {
		
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
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getFreqTableReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC5(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Condition que 1", getData(data, "Condition que 1"));
		param.put("Condition que 1 operand", getData(data, "Condition que 1 operand"));
		param.put("Condition que 1 answers", getData(data, "Condition que 1 answers"));
		param.put("Condition que 2", getData(data, "Condition que 2"));
		param.put("Condition que 2 operand", getData(data, "Condition que 2 operand"));
		param.put("Condition que 2 answers", getData(data, "Condition que 2 answers"));
		param.put("Logic", getData(data, "Logic"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getConditionalReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC6(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Condition que 1", getData(data, "Condition que 1"));
		param.put("Condition que 1 operand", getData(data, "Condition que 1 operand"));
		param.put("Condition que 1 answers", getData(data, "Condition que 1 answers"));
		param.put("Condition que 2", getData(data, "Condition que 2"));
		param.put("Condition que 2 operand", getData(data, "Condition que 2 operand"));
		param.put("Condition que 2 answers", getData(data, "Condition que 2 answers"));
		param.put("Logic", getData(data, "Logic"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getConditionalReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC7(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Stub", getData(data, "Stub"));
		param.put("Banner", getData(data, "Banner"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.get2LvlCrossTabReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC8(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Stub", getData(data, "Stub"));
		param.put("Banner", getData(data, "Banner"));
		param.put("Parent", getData(data, "Parent"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.get3LvlCrossTabReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC9(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Stub", getData(data, "Stub"));
		param.put("Banner", getData(data, "Banner"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getPivotReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC10(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Stub", getData(data, "Stub"));
		param.put("Banner", getData(data, "Banner"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getPivotReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC11(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));
		param.put("Comment", getData(data, "Comment"));

		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getVerbatimReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC12(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));
		param.put("Comment", getData(data, "Comment"));
		param.put("Filter Name", getData(data, "Filter Name"));

		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getVerbatimReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC13(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));
		param.put("Comment", getData(data, "Comment"));
		param.put("Grouping question", getData(data, "Grouping question"));

		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getVerbatimReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC14(LinkedHashMap<String, String> data) throws Exception {
		
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
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getAssessmentSummaryReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC15(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String surveyTitle = getData(data, "Survey Title");
		String SID = getData(data, "SID");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("Step1", getData(data, "Step 1"));
		
			
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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getResponseTrendReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC16(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getStatisticalReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC17(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Segment question 1", getData(data, "Segment question 1"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getStatisticalReportReadingWithSegmentAnswserOption(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC18(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Segment 1 name", getData(data, "Segment 1 name"));
		param.put("Segment question 1", getData(data, "Segment question 1"));
		param.put("Segment ques 1 operand", getData(data, "Segment ques 1 operand"));
		param.put("Segment ques 1 answers", getData(data, "Segment ques 1 answers"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getStatisticalReportReadingWithMoreThanOneSegQue(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC19(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));
		param.put("Step8", getData(data, "Step 8"));
		param.put("Step9", getData(data, "Step 9"));
		param.put("Nmax", getData(data, "Nmax"));
		param.put("Engagement questions", getData(data, "Engagement questions"));
		param.put("Driver questions", getData(data, "Driver questions"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getEngagementReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}

	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC20(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Condition que 1", getData(data, "Condition que 1"));
		param.put("Condition que 1 operand", getData(data, "Condition que 1 operand"));
		param.put("Condition que 1 answers", getData(data, "Condition que 1 answers"));
		param.put("datasetCount", getData(data, "datasetCount"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getComparisonReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC21(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Condition que 1", getData(data, "Condition que 1"));
		param.put("Condition que 1 operand", getData(data, "Condition que 1 operand"));
		param.put("Condition que 1 answers", getData(data, "Condition que 1 answers"));
		param.put("datasetCount", getData(data, "datasetCount"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getComparisonReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC22(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Comment", getData(data, "Comment"));
		param.put("Nmax", getData(data, "Nmax"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getBallotBoxReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC23(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));



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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getAdvPivotReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC24(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));
		param.put("Step8", getData(data, "Step 8"));
		param.put("Segment question 1", getData(data, "Segment question 1"));
		param.put("toEmail", getData(data, "toEmail"));



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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getSegmentationReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC50(LinkedHashMap<String, String> data) throws Exception {
		
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
		param.put("respRateQue", getData(data, "Condition que 1"));


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
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getResponseRateReportReading(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "Reports", alwaysRun = true)
	public void PlatformReadings_TC51(LinkedHashMap<String, String> data) throws Exception {
		
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
				credentials = platformReadingFile.getLoginCredentials("Users", Role);
				for (int i = 0; i < credentials.size(); i++) {
					users = credentials.get(i);
					username = users.get("username");
					encPassword = users.get("password");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				readingData = rmx.getAdvFreqRReportReading(getDriver(), param, test);
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
		SuiteUtility.WriteResultUtility4(new Read_XLS(readingFilePath), readingSheet, Result, readingData);
		testSkip = false;
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
		SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
		extent.flush();
	}
	
	

}
