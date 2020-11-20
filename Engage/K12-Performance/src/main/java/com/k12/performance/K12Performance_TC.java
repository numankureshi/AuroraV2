package com.k12.performance;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.Read_XLS;
import utility.SuiteUtility;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class K12Performance_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	public boolean testSkip = false;
	String sheetName = "PerformanceTC";
	public ExtentTest test;
	public DecimalFormat df = new DecimalFormat("#.##");
	public double finish, start;
	static public HashMap<String, String> LoadTime = new HashMap<String, String>();
	
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

	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC1(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = loginPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC2(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC3(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.depositeQuestionToQuestionBank(getDriver(), param, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC4(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];
		String descrText = surveyDetails[2];
		System.out.println(descrText);
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.addComment(getDriver(), param, descrText, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC5(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];
		String descrText = surveyDetails[2];
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.deleteComment(getDriver(), param, descrText, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC6(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];
		int pageNo =  Integer.parseInt(surveyDetails[2]);
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.movePage(getDriver(), param, pageNo, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC7(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.moveMatrixGrid(getDriver(), param, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC8(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = dmxPage.goToDistributePage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC9(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = rmxPage.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC10(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] surveyDetails = TestData.split(",");
		String surveyTitle = surveyDetails[0];
		String SID = surveyDetails[1];

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = rmxPage.loadOMNIReport(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC11(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		

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
				double totalTime = homePage.logout(getDriver(), param, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	


	@AfterMethod(alwaysRun = true)
	public void reporterDataResults(ITestResult Result) throws IOException {
		if (Result.getStatus() == ITestResult.SKIP) {
			LoadTime.put(Result.getName(), "0");
			Reporter.log(Result.getName() + " is SKIPPED.");
			Add_Log.info(Result.getName() + " is SKIPPED.");
			TestResultTL.put(Result.getName(), "SKIP");
			test.skip(Result.getName() + " is SKIPPED.");
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			LoadTime.put(Result.getName(), "0");
			String path = captureScreenShot(Result, "FAIL", getDriver());
			
			Reporter.log(Result.getName() + " is FAILED.");
			Add_Log.info(Result.getName() + " is FAILED.");
			TestResultTL.put(Result.getName(), "FAIL");
			test.fail(Result.getName() + " is FAILED.", (MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots(getDriver())).build()));
			
			String errorPage = getErrorPage(getDriver());
			URL errorURL = new URL(errorPage);
			
			StringWriter errors = new StringWriter();
			Result.getThrowable().printStackTrace(new PrintWriter(errors));
			String subject = errorURL.getHost() +" : Error in Performance Suite";
			sendHtmlFormatMail(subject, errorPage, errorURL.getPath(), errorURL.getQuery(), getIpAddress(), errors.toString());
//			String path = captureScreenShot(Result, "FAIL", getDriver());
//			if (!(getDriver() == null)) {
//				closeWebBrowser();
//			}
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
			SuiteUtility.WriteResultUtility2(filePath, sheetName, "TimeLoad", LoadTime);
			extent.flush();
			fetchExcelData.reportLog("K12_Performance", "Report", "xlsx");
		
	}
	
	
	/*
	 * public void waitForPageToBeLoaded(WebDriver driver, long timeOutInSeconds) {
	 * WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	 * wait.until(new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver
	 * driver) { return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete"); } });
	 * }
	 */
	 

}
