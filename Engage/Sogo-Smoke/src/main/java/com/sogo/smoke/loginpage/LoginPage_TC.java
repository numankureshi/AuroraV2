package com.sogo.smoke.loginpage;

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
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class LoginPage_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	public boolean testSkip = false;
	String sheetName = "SanityTC";
	public ExtentTest test;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		init();
		filePath = TestFile;
		URLs = TestFile.getEnvURL("Environment");
		participationURLs = TestFile.getEnvURL("Participation");
		for (String env : URLs.keySet()) {
			Environment = env;
		}
	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC77(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("textbox", getData(data, "textbox"));
		param.put("Expected", getData(data, "Expected"));
		
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
				staticPage.SoGoLoginPageWithoutCredentials(getDriver(), param, URLs.get(key), test);
				staticPage.SogolyticsButtonValidation(getDriver(), param, test);
				staticPage.Facebooklogin(getDriver(), param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC78(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("textbox", getData(data, "textbox"));
		param.put("Expected", getData(data, "Expected"));
		
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
				staticPage.SoGoLoginPageWithoutCredentials(getDriver(), param, URLs.get(key), test);
				staticPage.SogolyticsButtonValidation(getDriver(), param, test);
				staticPage.Googlelogin(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC79(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("textbox", getData(data, "textbox"));
		param.put("TextBox", getData(data, "TextBox"));
		param.put("Expected", getData(data, "Expected"));
		param.put("Expected2", getData(data, "Expected2"));
		param.put("Expected3", getData(data, "Expected3"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("RadioButton", getData(data, "RadioButton"));
		param.put("RadioButton2", getData(data, "RadioButton2"));
		param.put("CheckBox", getData(data, "CheckBox"));
		param.put("Header", getData(data, "Header"));
		
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
				staticPage.SoGoLoginPageWithoutCredentials(getDriver(), param, URLs.get(key), test);
				staticPage.SogolyticsButtonValidation(getDriver(), param, test);
				staticPage.Invalidlogin(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC80(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("textbox", getData(data, "textbox"));

		
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
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC160(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("textbox", getData(data, "textbox"));
		param.put("Expected", getData(data, "Expected"));
		param.put("Expected2", getData(data, "Expected2"));
		param.put("Expected3", getData(data, "Expected3"));
		param.put("Header", getData(data, "Header"));
		param.put("TextBox", getData(data, "TextBox"));
		
		
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
				staticPage.SoGoLoginPageWithoutCredentials(getDriver(), param, URLs.get(key), test);
				staticPage.extraDetails(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC161(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC162(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);;
				staticPage.TrialPlusSignup(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC163(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);;
				staticPage.TrialProSignup(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC164(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);;
				staticPage.TrialPremiumSignup(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC165(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.Blockedmail(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC166(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyFirstName(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC167(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyLastName(getDriver(), param, test);
		}
		
		}

	}
	

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC168(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.MinCharUserId(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC169(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.MinCharUserId(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC170(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.MissingPasswordRequisite(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC171(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.InvalidUserId(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC172(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.AllFieldsEmpty(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC173(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.InvalidCharactersUserId(getDriver(), param, test);
		}
		
		}

	}
	
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC174(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyCompanyInfo(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC175(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyOrgName(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC176(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyJobTitle(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC177(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyPhoneNumber(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC178(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.InvalidPhoneNumber(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC179(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyWorkInfo(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC180(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.EmptyProjectInfo(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC181(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.ExistingUserID(getDriver(), param, test);
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC182(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePlusPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC183(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProYPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC184(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProMPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC185(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePremYPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC186(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePremMPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC187(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.InvalidCC(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC188(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.InvalidDate(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC189(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePremMPaidAccount(getDriver(), param, test);
				staticPage.CancelPaidAccount(getDriver(), param, test);
				
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC190(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePremYPaidAccount(getDriver(), param, test);
				staticPage.CancelPaidAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC191(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePlusPaidAccount(getDriver(), param, test);
				staticPage.CancelPaidAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC192(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProYPaidAccount(getDriver(), param, test);
				staticPage.CancelPaidAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC193(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProMPaidAccount(getDriver(), param, test);
				staticPage.CancelPaidAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC194(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.CancelTrialAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC195(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.CancelTrialAccount(getDriver(), param, test);
				
		}
		
		}

	}

	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC196(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialProSignup(getDriver(), param, test);
				staticPage.CancelTrialAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC197(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPremiumSignup(getDriver(), param, test);
				staticPage.CancelTrialAccount(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC198(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProMPaidAccount(getDriver(), param, test);
				staticPage.SwitchtoYearly(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC199(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePremMPaidAccount(getDriver(), param, test);
				staticPage.SwitchtoYearly(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC200(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePlusPaidAccount(getDriver(), param, test);
				staticPage.UpgradetoProY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC201(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreatePlusPaidAccount(getDriver(), param, test);
				staticPage.UpgradetoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC202(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProYPaidAccount(getDriver(), param, test);
				staticPage.UpgradetoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC203(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProMPaidAccount(getDriver(), param, test);
				staticPage.UpgradetoPremM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC204(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.CreateProMPaidAccount(getDriver(), param, test);
				staticPage.UpgradetoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC205(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPlusY(getDriver(), param, test);
								
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC206(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC207(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProY(getDriver(), param, test);
								
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC208(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC209(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.BasicAccountSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC210(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPlusY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC211(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC212(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC213(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremM(getDriver(), param, test);
				
		}
		
		}

	}

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC214(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPlusSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremY(getDriver(), param, test);
				
				
		}
		
		}

	}
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC215(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialProSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC216(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialProSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoProY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC217(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialProSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremM(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC218(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialProSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC219(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPremiumSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremM(getDriver(), param, test);
				
		}
		
		}

	}
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "loginpage", alwaysRun = true)
	public void Smoke_TC220(LinkedHashMap<String, String> data) throws Exception {
		//This is to be run on QAUC only
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Timezone", getData(data, "Timezone"));
		param.put("CC_number", getData(data, "CC_number"));
		param.put("CVV", getData(data, "CVV"));
		
		
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
				staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				staticPage.TrialPremiumSignup(getDriver(), param, test);
				staticPage.UpgradefromTrialtoPremY(getDriver(), param, test);
				
		}
		
		}

	}
	
	@AfterMethod(alwaysRun = true)
	public void reporterDataResults(ITestResult Result) throws IOException {
		if (Result.getStatus() == ITestResult.SKIP) {
			Reporter.log(Result.getName() + " is SKIPPED.");
			Add_Log.info(Result.getName() + " is SKIPPED.");
			TestResultTL.put(Result.getName(), "SKIP");
			test.skip(Result.getName() + " is SKIPPED.");
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			String path = captureScreenShot(Result, "FAIL", getDriver());
			File screenshot = new File(path);
			File logFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\logging\\applog.log");
			
			// 	Send error mails on testcase failure
			String errorPage = getErrorPage(getDriver());
			URL errorURL = new URL(errorPage);	
			StringWriter errors = new StringWriter();
			Result.getThrowable().printStackTrace(new PrintWriter(errors));
			String subject = errorURL.getHost().replace("http://","").replace("http:// www.","").replace("www.","").replace(".com", "") +" : Error in Smoke Suite";
			sendHtmlFormatMail(subject, errorPage, errorURL.getPath(), errorURL.getQuery(), getIpAddress(), errors.toString(), screenshot, logFile);
			
			Reporter.log(Result.getName() + " is FAILED.");
			Add_Log.info(Result.getName() + " is FAILED.");
			TestResultTL.put(Result.getName(), "FAIL");
			test.fail(Result.getName() + " is FAILED.", (MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots(getDriver())).build()));

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
		testSkip = false;
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		
			SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
			SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
			extent.flush();
			fetchExcelData.reportLog("Sogo_Smoke", "Report", "xlsx");
		
	}
}