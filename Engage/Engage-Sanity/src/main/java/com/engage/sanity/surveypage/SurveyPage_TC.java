package com.engage.sanity.surveypage;

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

public class SurveyPage_TC extends SuiteBase {
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

	@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "surveyform", alwaysRun = true)
	public void Sanity_TC1(LinkedHashMap<String, String> data) throws Exception {
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("header", getData(data, "Header"));
		param.put("TextBox", getData(data, "TextBox"));
		param.put("RadioBtn", getData(data, "RadioButton"));
		param.put("CheckBox", getData(data, "CheckBox"));
		param.put("DropDown", getData(data, "DropDown"));
		param.put("Gender", getData(data, "Gender"));
		param.put("Grade", getData(data, "Grade"));
		param.put("DOB", getData(data, "DOB"));
		param.put("Email", getData(data, "Email"));
		param.put("Ratings", getData(data, "Ratings"));
		param.put("Like", getData(data, "Like"));
		param.put("Slider", getData(data, "Slider"));
		param.put("MultiDropDown", getData(data, "MultiDropDown"));
		param.put("Image", getData(data, "ImageRadio"));
		param.put("RatingNumber", getData(data, "RatingNumber"));
		param.put("MTB", getData(data, "MTB"));
		param.put("MDD", getData(data, "MDD"));
		param.put("RDDG", getData(data, "RDDG"));
		param.put("RadioBtn2", getData(data, "RadioButton2"));
		param.put("MTB2", getData(data, "MTB2"));
		param.put("RG", getData(data, "RG"));
		param.put("RRG", getData(data, "RRG"));
		param.put("RSG", getData(data, "RSG"));
		param.put("CBG", getData(data, "CBG"));
		param.put("MG1", getData(data, "MG1"));
		param.put("MG2", getData(data, "MG2"));
		param.put("RRB", getData(data, "RRB"));
		param.put("RDD", getData(data, "RDD"));
		param.put("LB", getData(data, "LB"));
		param.put("Attachments", getData(data, "Attachments"));
		param.put("DrillDown", getData(data, "DrillDown"));
		param.put("ThanksMsg", getData(data, "ThanksMsg"));

		if (CaseToRun.equalsIgnoreCase("N")) {
			System.out.println("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			testSkip = true;
			test.skip("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
			throw new SkipException("CaseToRun = N for " + TestCaseName + "So skipping Exceution.");
		} else {
			for (String key : participationURLs.keySet()) {
				System.out.println(participationURLs.get(key));
				param.put("URL", participationURLs.get(key));
				
				loadBrowser();
//				sp.surveyParticipation(getDriver(), param, test);
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
