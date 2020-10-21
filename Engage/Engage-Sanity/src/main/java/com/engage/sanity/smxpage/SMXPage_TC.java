package com.engage.sanity.smxpage;

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

public class SMXPage_TC extends SuiteBase {
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

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
	public void Sanity_TC2(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyname", getData(data, "surveyname"));
		param.put("foldername", getData(data, "foldername"));
		param.put("primarylanguage", getData(data, "primarylanguage"));
		param.put("secondarylanguage", getData(data, "secondarylanguage"));
		param.put("description", getData(data, "description"));
		param.put("textbox", getData(data, "textbox"));
		param.put("radiobutton", getData(data, "radiobutton"));
		param.put("AnswerOptions", getData(data, "AnswerOptions"));
		param.put("checkbox", getData(data, "checkbox"));
		param.put("imagechoice", getData(data, "imagechoice"));
		param.put("reportingvalue", getData(data, "reportingvalue"));
		param.put("images", getData(data, "images"));
		param.put("date", getData(data, "date"));
		param.put("likedislike", getData(data, "likedislike"));
		param.put("ratingscale", getData(data, "ratingscale"));
		param.put("dropdown", getData(data, "dropdown"));
		param.put("ranking", getData(data, "ranking"));
		param.put("multitextbox", getData(data, "multitextbox"));
		param.put("textbox1", getData(data, "textbox1"));
		param.put("textbox2", getData(data, "textbox2"));
		param.put("multidropdown", getData(data, "multidropdown"));
		param.put("dropdown1", getData(data, "dropdown1"));
		param.put("dropdown2", getData(data, "dropdown2"));
		param.put("multiradio", getData(data, "multiradio"));
		param.put("QuestionOptions", getData(data, "QuestionOptions"));
		param.put("multicheckbox", getData(data, "multicheckbox"));
		param.put("ratingradio", getData(data, "ratingradio"));	
		param.put("ratingdropdown", getData(data, "ratingdropdown"));
		param.put("ratingscalegrid", getData(data, "ratingscalegrid"));
		param.put("matrixgrid", getData(data, "matrixgrid"));
		

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
				smxPage.createSurvey(getDriver(), param, test);
				
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

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		
			SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
			SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
			extent.flush();
			fetchExcelData.reportLog("Engage_Sanity", "Report", "xlsx");
		
	}
	
	

}
