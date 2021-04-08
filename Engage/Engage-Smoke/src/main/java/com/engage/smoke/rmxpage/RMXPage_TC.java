package com.engage.smoke.rmxpage;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageobjects.LoginPage;
import pageobjects.RMXPage;
import pageobjects.StaticPage;
import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.Read_XLS;
import utility.SuiteUtility;

import java.io.IOException;
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

public class RMXPage_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	public boolean testSkip = false;
	String sheetName = "SmokeTC";
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
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC9(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("rName", getData(data, "Expected"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPageEngage.generateOmniReport(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC10(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("rName", getData(data, "Expected"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.generateAdvancedFrequencyReport(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC11(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("rName", getData(data, "Expected"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.generateIndividualReport(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC12(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("rName", getData(data, "Expected"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPage.generateResponseTableReport(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC13(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("question", getData(data, "Expected2"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPageEngage.generateSegmentationReport(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC14(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("questions", getData(data, "Expected2"));
		param.put("rName", getData(data, "Expected"));
		param.put("driver", getData(data, "Expected3"));
		param.put("nmax", getData(data, "TextBox"));
		param.put("additional", getData(data, "RadioButton"));
		param.put("composition", getData(data, "RadioButton2"));
		param.put("segmentation", getData(data, "CheckBox"));
		param.put("segmentation1", getData(data, "DropDown"));
		param.put("segment", getData(data, "Gender"));
		param.put("segment2", getData(data, "Grade"));
		param.put("header", getData(data, "Header"));
		param.put("compositionby", getData(data, "DOB"));
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPageEngage.generateEngagementReport(getDriver(), param, test);
			}
		}

	}

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "rmxpage", alwaysRun = true)
	public void Smoke_TC15(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("SID", getData(data, "surveyid"));
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("emailto", getData(data, "Email"));
		param.put("folder", getData(data, "Expected2"));
		param.put("rName", getData(data, "Expected"));
		param.put("driver", getData(data, "Expected3"));
		param.put("nmax", getData(data, "TextBox"));
		param.put("additional", getData(data, "RadioButton"));
		param.put("composition", getData(data, "RadioButton2"));
		param.put("segmentation", getData(data, "CheckBox"));
		param.put("segmentation1", getData(data, "DropDown"));
		param.put("segment", getData(data, "Gender"));
		param.put("segment2", getData(data, "Grade"));
		
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
				loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmxPageEngage.generateDarReport(getDriver(), param, test);
			}
		}

	}
	
	/*
	 * @Test(dataProvider = "SurveyPage", dataProviderClass =
	 * utility.XLSDataProvider.class, groups = "rmxPage", alwaysRun = true) public
	 * void Sanity_TC10(LinkedHashMap<String, String> data) throws Exception {
	 * TestCaseName = getData(data, "TestCaseName"); test =
	 * extent.createTest(TestCaseName); CaseToRun = getData(data, "CaseToRun");
	 * String Role = getData(data, "Role");
	 * 
	 * HashMap<String, String> param = new HashMap<String, String>();
	 * param.put("TestCaseName", TestCaseName); param.put("surveyid", getData(data,
	 * "surveyid")); param.put("surveyname", getData(data, "surveyname"));
	 * param.put("canvas_title", getData(data,"canvastitle"));
	 * param.put("canvas_description", getData(data,"canvasdescription"));
	 * 
	 * if (CaseToRun.equalsIgnoreCase("N")) {
	 * System.out.println("CaseToRun = N for " + TestCaseName +
	 * "So skipping Exceution."); testSkip = true; test.skip("CaseToRun = N for " +
	 * TestCaseName + "So skipping Exceution."); throw new
	 * SkipException("CaseToRun = N for " + TestCaseName +
	 * "So skipping Exceution."); } else { for (String key : URLs.keySet()) {
	 * System.out.println(URLs.get(key)); credentials =
	 * TestFile.getLoginCredentials("Users", Role); for (int i = 0; i <
	 * credentials.size(); i++) { users = credentials.get(i); username =
	 * users.get("username"); encPassword = users.get("password"); }
	 * 
	 * 
	 * loadBrowser(); loginPage.login(getDriver(), param, username, encPassword,
	 * URLs.get(key), test); rmxPage.goToReportPage(getDriver(), param,
	 * "Dimensional Report 1", "91", test); //
	 * rmxPageEngage.loadDARReport(getDriver(), param, getData(data, "surveyname"),
	 * getData(data, "surveyid"), test); } }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @Test(dataProvider = "SurveyPage", dataProviderClass =
	 * utility.XLSDataProvider.class, groups = "rmxPage", alwaysRun = true) public
	 * void Sanity_TC9(LinkedHashMap<String, String> data) throws Exception {
	 * TestCaseName = getData(data, "TestCaseName"); test =
	 * extent.createTest(TestCaseName); CaseToRun = getData(data, "CaseToRun");
	 * String Role = getData(data, "Role");
	 * 
	 * HashMap<String, String> param = new HashMap<String, String>();
	 * param.put("TestCaseName", TestCaseName); param.put("surveyid", getData(data,
	 * "surveyid")); param.put("surveyname", getData(data, "surveyname"));
	 * param.put("canvas_title", getData(data,"canvastitle"));
	 * param.put("canvas_description", getData(data,"canvasdescription"));
	 * 
	 * if (CaseToRun.equalsIgnoreCase("N")) {
	 * System.out.println("CaseToRun = N for " + TestCaseName +
	 * "So skipping Exceution."); testSkip = true; test.skip("CaseToRun = N for " +
	 * TestCaseName + "So skipping Exceution."); throw new
	 * SkipException("CaseToRun = N for " + TestCaseName +
	 * "So skipping Exceution."); } else { for (String key : URLs.keySet()) {
	 * System.out.println(URLs.get(key)); credentials =
	 * TestFile.getLoginCredentials("Users", Role); for (int i = 0; i <
	 * credentials.size(); i++) { users = credentials.get(i); username =
	 * users.get("username"); encPassword = users.get("password"); }
	 * 
	 * 
	 * loadBrowser(); loginPage.login(getDriver(), param, username, encPassword,
	 * URLs.get(key), test); rmxPage.goToReportPage(getDriver(), param,
	 * "Dimensional Report 1", "91", test); rmxPage.loadOMNIReport(getDriver(),
	 * param, "Dimensional Report 1", "91", test);
	 * rmxPageEngage.loadEngagementReport(getDriver(), param, "Dimensional Report 1"
	 * , "91", test); } }
	 * 
	 * }
	 */
	@AfterMethod(alwaysRun = true)
	public void reporterDataResults(ITestResult Result) throws IOException {
		if (Result.getStatus() == ITestResult.SKIP) {
			Reporter.log(Result.getName() + " is SKIPPED.");
			Add_Log.info(Result.getName() + " is SKIPPED.");
			TestResultTL.put(Result.getName(), "SKIP");
			test.skip(Result.getName() + " is SKIPPED.");
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			String path = captureScreenShot(Result, "FAIL", getDriver());
			
			Reporter.log(Result.getName() + " is FAILED.");
			Add_Log.info(Result.getName() + " is FAILED.");
			TestResultTL.put(Result.getName(), "FAIL");
			test.fail(Result.getName() + " is FAILED.", (MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots(getDriver())).build()));
//			String path = captureScreenShot(Result, "FAIL", getDriver());
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


	/*
	 * @AfterSuite(alwaysRun = true)
	public void afterSuite() {
		
			SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
			SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
			extent.flush();
			fetchExcelData.reportLog("Engage_Smoke", "Report", "xlsx");
		
	}
	*/
}
	