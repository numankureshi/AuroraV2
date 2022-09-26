package com.sogo.performance.smx;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pageobjects.DataPage;
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
import java.util.Optional;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.ITest;



public class SMXPlatformReading_TC extends SuiteBase {
	private static final int invocationCount = 4;
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
		readingFilePath = SuiteUtility.createPlatformreadingSheet("SMX Reading", readingSheet, "xlsx");
		
		    
	}


	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC61(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("foldername", getData(data, "foldername"));
		param.put("primarylanguage", getData(data, "primarylanguage"));
		param.put("secondarylanguage", getData(data, "secondarylanguage"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
		
			
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
				readingData = smxPage.getSMXReadingsOfSurveyCreation(getDriver(), param, test);
				
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC62(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getSurveySettingsReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC63(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getDropDownReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC64(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getRadioButtonReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC65(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getHorizontalRadioButtonReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC66(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getCheckBoxButtonReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC67(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getTextBoxButtonReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC68(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getListBoxButtonReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = 3)
	public void PlatformReadings_TC69(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getNumericAllocationReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = 3)
	public void PlatformReadings_TC70(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getRankingReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC71(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getRatingRadioButtonsReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC72(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getRatingScaleButtonsReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC73(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getDateButtonsReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC74(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getMultipleTextBoxReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC75(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getMultipleDropdownReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC76(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getDemographicReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC77(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getMatrixGridReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC78(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getDescriptionReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC79(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getAttachmentReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC80(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getSingleQuestionBranchingReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}

	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC81(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getMultipleQuestionBranchingReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC82(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		
		
		
			
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
				readingData = smxPage.getRearrangeQuestionReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC83(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getAssessmentSettingsReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC84(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("pageNo", getData(data, "Nmax"));
		param.put("showQuestion", getData(data, "Condition que 2"));
		param.put("decisionQuestion", getData(data, "Condition que 1"));
		param.put("operator", getData(data, "Condition que 1 operand"));
		param.put("ansOptionsAll", getData(data, "Condition que 1 answers"));
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
				readingData = smxPage.getQDLReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC85(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("copiedIntoAccount", getData(data, "textBox1"));
		
			
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
				readingData = smxPage.getCopySurveyReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC86(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		param.put("Step5", getData(data, "Step 5"));
		param.put("Step6", getData(data, "Step 6"));
		param.put("Step7", getData(data, "Step 7"));

		
			
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
				readingData = smxPage.getSurveyPageActionReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC87(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));

		
			
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
				readingData = smxPage.getExpiryRuleReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC88(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		
			
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
				readingData = smxPage.getQuotaReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC90(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		param.put("Step4", getData(data, "Step 4"));
		
			
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
				readingData = smxPage.getVisualSettingReadings(getDriver(), param, test);
				System.out.println(readingData);
				
			}
		}

	}
	
	@Test(dataProvider = "PlatformReadings", dataProviderClass = utility.XLSDataProvider.class, groups = "SMX", alwaysRun = true, invocationCount = invocationCount)
	public void PlatformReadings_TC91(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "SID"));
		param.put("downloadFilePath", downloadFilePath);
		param.put("surveyname", getData(data, "Survey Title"));
		param.put("Step1", getData(data, "Step 1"));
		param.put("Step2", getData(data, "Step 2"));
		param.put("Step3", getData(data, "Step 3"));
		
		
		
			
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
				readingData = smxPage.getSurveyDownloadReadings(getDriver(), param, test);
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
