package com.sogo.smoke.dmxpage;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageobjects.DMXPage;
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
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.lang.time.DateFormatUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class DMXPage_TC extends SuiteBase {
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

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC3(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		
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
				dmxPage.publishSingleUseLinkexe(getDriver(), param, test);
				//dmxPage.sendRemindersEXE(getDriver(), param, test);
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC4(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		
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
				dmxPage.publishSingleUseLink(getDriver(), param, test);
				dmxPage.sendReminders(getDriver(), param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC5(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		param.put("file", getData(data, "selectlist"));
		
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
				dmxPage.publishSmsInvitation(getDriver(), param, test);
				dmxPage.sendSMSReminders(getDriver(), param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC6(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String downloadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadfiles\\"  + "publish\\" 
		+ DateFormatUtils.format(new Date(), "dd-MM-yyyy") + "\\";
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		param.put("downloadFilePath", downloadFilePath);
		
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
				
				loadBrowser(downloadFilePath);
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmxPageSogo.publishSurveyPasswords(getDriver(), param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC7(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("file", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		
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
				dmxPage.createContactList(getDriver(), param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC8(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplate", getData(data, "emailtemplate"));
		param.put("selectlist", getData(data, "selectlist"));
		param.put("mailmergedd", getData(data, "mailmergedd"));
		param.put("mailmergetxt", getData(data, "mailmergetxt"));
		param.put("prepopdd", getData(data, "prepopdd"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		
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
				dmxPageSogo.publishTestInvites(getDriver(), param, test);
				/*
				 * dmxPage.goToDistributePage(getDriver(), param, getData(data,"surveyname"),
				 * getData(data, "surveyid"), test); dmxPage.selectTestDropDown(getDriver(),
				 * param, test);
				 */
				
				
			}
		}

	}

	
	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "dmxpage", alwaysRun = true)
	public void Smoke_TC16(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		//test
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyid", getData(data, "surveyid"));
		param.put("emailtemplatere", getData(data, "emailtemplatere"));
		
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
				dmxPage.selectDistributeProject(getDriver(), param, test);
				dmxPage.sendRemindersEXE(getDriver(), param, test);
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
