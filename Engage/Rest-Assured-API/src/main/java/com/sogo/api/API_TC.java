package com.sogo.api;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.response.Response;
import pageobjects.RMXPage;
import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.JSONUtility;
import utility.Read_XLS;
import utility.SuiteUtility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class API_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	String testCaseDescription = null;
	public boolean testSkip = false;
	String sheetName = "API_TC";
	public ExtentTest test;
	static public HashMap<String, String> statusCode = new HashMap<String, String>();
	static public HashMap<String, String> respData = new HashMap<String, String>();
	static public HashMap<String, String> headers = new HashMap<String, String>();
	Response response = null;
	String outputJsonPath = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa", Locale.ENGLISH); //30-12-2020 06:56 PM
	
	
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

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC1(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
								
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC2(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC3(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC4(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC5(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC6(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC7(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
		
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getSurveyURL API", alwaysRun = true)
	public void API_TC8(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");		
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("ExpectedResult", getData(data, "ExpectedResult"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				responseData = api.getSurveyURL(param, URLs.get(key), apiToken, test);	
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				
			}
		}

	}
		
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInvite API", alwaysRun = true)
	public void API_TC9(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInvite(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInvite API", alwaysRun = true)
	public void API_TC10(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInvite(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInvite API", alwaysRun = true)
	public void API_TC11(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInvite(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInvite API", alwaysRun = true)
	public void API_TC12(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInvite(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInviteWithReminder API", alwaysRun = true)
	public void API_TC13(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				// Validate reminder period from platform
				dmx.goToReminderPage(getDriver(), param, test);
				dmx.applyFirstReminderFilter(getDriver(), param, test);
				dmx.jsonReminderData(getDriver(), param, test);
				api.validateReminderPeriod(param, (ArrayList<String>) responseData.get("emailList"), test);		
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInviteWithReminder API", alwaysRun = true)
	public void API_TC14(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				// Validate reminder period from platform
				dmx.goToReminderPage(getDriver(), param, test);
				dmx.applyFirstReminderFilter(getDriver(), param, test);
				dmx.jsonReminderData(getDriver(), param, test);
				api.validateReminderPeriod(param, (ArrayList<String>) responseData.get("emailList"), test);		
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInviteWithReminder API", alwaysRun = true)
	public void API_TC15(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				//Validate URL Expiry from tracksurvey Data
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToTrackSurvey(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.jsonTrackSurveyData(getDriver(), param, test);
				api.validateExpiryDateFromTrackSurvey(param, (ArrayList<String>) responseData.get("emailList"), test);
				// Validate reminder period from platform
				dmx.goToReminderPage(getDriver(), param, test);
				dmx.applyFirstReminderFilter(getDriver(), param, test);
				dmx.jsonReminderData(getDriver(), param, test);
				api.validateReminderPeriod(param, (ArrayList<String>) responseData.get("emailList"), test);		
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyInviteWithReminder API", alwaysRun = true)
	public void API_TC16(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyReminder API", alwaysRun = true)
	public void API_TC17(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyReminder API", alwaysRun = true)
	public void API_TC18(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyReminder API", alwaysRun = true)
	public void API_TC19(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}

	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "sendSurveyReminder API", alwaysRun = true)
	public void API_TC20(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("inthour", getData(data, "inthour"));
		param.put("path", getData(data, "path"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				responseData = api.sendSurveyInviteWithReminder(param, URLs.get(key), apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "generateSurveyKey API", alwaysRun = true)
	public void API_TC21(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("surveyKeyURL", getData(data, "surveyKeyURL"));
		param.put("passwordtype", getData(data, "passwordtype"));
		param.put("expirydays", getData(data, "expirydays"));
		param.put("path", getData(data, "path"));
		param.put("isUniquePassword", getData(data, "isUniquePassword"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
						

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				
				responseData = api.generateSurveyKey(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToSurveyPasswordsInTrackSurvey(getDriver(), param, test);
				dmx.getSAPDataFromTrackSurvey(getDriver(), param, test);
				api.validateSurveyKeyPasswordFromTrackSurvey(param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "generateSurveyKey API", alwaysRun = true)
	public void API_TC22(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("surveyKeyURL", getData(data, "surveyKeyURL"));
		param.put("passwordtype", getData(data, "passwordtype"));
		param.put("expirydays", getData(data, "expirydays"));
		param.put("path", getData(data, "path"));
		param.put("isUniquePassword", getData(data, "isUniquePassword"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
						

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				
				responseData = api.generateSurveyKey(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToSurveyPasswordsInTrackSurvey(getDriver(), param, test);
				dmx.getSAPDataFromTrackSurvey(getDriver(), param, test);
				api.validateSurveyKeyPasswordFromTrackSurvey(param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "generateSurveyKey API", alwaysRun = true)
	public void API_TC23(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("surveyKeyURL", getData(data, "surveyKeyURL"));
		param.put("passwordtype", getData(data, "passwordtype"));
		param.put("expirydays", getData(data, "expirydays"));
		param.put("path", getData(data, "path"));
		param.put("isUniquePassword", getData(data, "isUniquePassword"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
						

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				
				responseData = api.generateSurveyKey(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToSurveyPasswordsInTrackSurvey(getDriver(), param, test);
				dmx.getSAPDataFromTrackSurvey(getDriver(), param, test);
				api.validateSurveyKeyPasswordFromTrackSurvey(param, test);
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "generateSurveyKey API", alwaysRun = true)
	public void API_TC24(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("surveyKeyURL", getData(data, "surveyKeyURL"));
		param.put("passwordtype", getData(data, "passwordtype"));
		param.put("expirydays", getData(data, "expirydays"));
		param.put("path", getData(data, "path"));
		param.put("isUniquePassword", getData(data, "isUniquePassword"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
						

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				
				responseData = api.generateSurveyKey(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "generateSurveyKey API", alwaysRun = true)
	public void API_TC25(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyTitle", getData(data, "surveyTitle"));
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("surveyKeyURL", getData(data, "surveyKeyURL"));
		param.put("passwordtype", getData(data, "passwordtype"));
		param.put("expirydays", getData(data, "expirydays"));
		param.put("path", getData(data, "path"));
		param.put("isUniquePassword", getData(data, "isUniquePassword"));
		param.put("isSurveyActive", getData(data, "isSurveyActive"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
						

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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				
				responseData = api.generateSurveyKey(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC26(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				//Validate received email from Inbox
				api.getReopenURLFromEmail(param, test);				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC27(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC28(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				//Validate received email from Inbox
				api.getReopenURLFromEmail(param, test);				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC29(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC30(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC31(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC32(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC33(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "reopenresponse API", alwaysRun = true)
	public void API_TC34(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("emailhost", getData(data, "emailhost"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("emailPassword", getData(data, "emailPassword"));
		param.put("subject", getData(data, "subject"));
		param.put("path", getData(data, "path"));
		param.put("participationStatus", getData(data, "participationStatus"));
		param.put("urlExpiry", getData(data, "urlExpiry"));
		param.put("anonymous", getData(data, "anonymous"));
		param.put("semiAnonymous", getData(data, "semiAnonymous"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.reopenresponse(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
			
			}
		}

	}
		
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC35(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Completed")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC36(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Incomplete")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC37(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Completed")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC38(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Incomplete")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC39(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						String overallStatusWithoutHtml = Jsoup.parse(overallStatus.get("OverAllStatus")).text();	//Remove HTML tags from string
						//Validate overall status of given email address
						if (overallStatusWithoutHtml.equalsIgnoreCase("Bounced (Unknown host)")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatusWithoutHtml+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatusWithoutHtml+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC40(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						String overallStatusWithoutHtml = Jsoup.parse(overallStatus.get("OverAllStatus")).text();	//Remove HTML tags from string
						//Validate overall status of given email address
						if (overallStatusWithoutHtml.equalsIgnoreCase("Bounced (Unknown user)")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatusWithoutHtml+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatusWithoutHtml+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC41(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Email Scheduled")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC42(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Email Delivered / Not Read")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC43(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Dropped out on page")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC44(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
						String dataString = response.jsonPath().get("Data").toString();
						JSONParser parser = new JSONParser();
						JSONObject jsonData = (JSONObject) parser.parse(dataString);
						ArrayList<Object> tableArray = (ArrayList<Object>) jsonData.get("Table");
						HashMap<String, String> overallStatus = (HashMap<String, String>) tableArray.get(0);
						//Validate overall status of given email address
						if (overallStatus.get("OverAllStatus").equalsIgnoreCase("Email Read / Not Participated")) {
							Reporter.log("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));  // Add log in testNG report
							test.info("Participation status of given email address <b>"+getData(data, "stremailaddress")+"</b> : <b>"+overallStatus.get("OverAllStatus")+"</b> in Survey ID "+getData(data, "surveyNo"));	// Add log in extent report		
						}
						else {
							test.log(Status.FAIL,"Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							Add_Log.info("Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							Reporter.log("Participation status received for email address <b> "+getData(data, "stremailaddress")+"</b> is <span style=\"color:red;\">wrong</span> <br/>"+response.getBody().asPrettyString());
							TestResultStatus.failureReason.add(TestCaseName + "| "+ "Participation status received for email address "+getData(data, "stremailaddress")+" is wrong "+response.getBody().asPrettyString());
							TestResultStatus.TestFail = true;
							Assert.fail();
						}
								
					}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC45(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey anonymous, participant details cannot be tracked")) {
							Reporter.log("Participation status of given email address <b>" +getData(data, "stremailaddress") +" </b>can not be tracked as survey ID "+getData(data, "surveyNo")+" is <b> Anonymous</b>.");  // Add log in testNG report
							test.info("Participation status of given email address <b>" +getData(data, "stremailaddress") +" </b>can not be tracked as survey ID "+getData(data, "surveyNo")+" is <b> Anonymous</b>.");	// Add log in extent report		
						}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}			
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC46(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getParticipationStatusInfo(param, URLs.get(key), apiToken, getData(data, "surveyNo"), getData(data, "stremailaddress"), getData(data, "issurveyaccesscodes"), getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				respData.put(TestCaseName, response.getBody().asPrettyString());
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey anonymous, participant details cannot be tracked")) {
							Reporter.log("Participation status of given email address <b>" +getData(data, "stremailaddress") +" </b>can not be tracked as survey ID "+getData(data, "surveyNo")+" is <b> Semi-Anonymous</b>.");  // Add log in testNG report
							test.info("Participation status of given email address <b>" +getData(data, "stremailaddress") +" </b>can not be tracked as survey ID "+getData(data, "surveyNo")+" is <b> Semi-Anonymous</b>.");	// Add log in extent report		
						}
					else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
					}			
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "Participation Status", alwaysRun = true)
	public void API_TC47(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String surveyData = getData(data, "surveyData");
		String[] surveyData_Array = surveyData.split(",");
		boolean isSurveyIDPresent = false;
		
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				
				response = api.getSurveyList(param, URLs.get(key), apiToken, getData(data, "path"), test);
				api.writeJsonResponse(param, response.getBody().asString(), outputJsonPath, test);
				statusCode.put(TestCaseName, String.valueOf(response.getStatusCode()));
				headers.put(TestCaseName, response.getHeaders().asList().toString());
				
				//Validate the status code
				if(response.getStatusCode() == 200) {
					//Validate status from API response
					if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
							String dataString = response.jsonPath().get("Data").toString();
							JsonParser parser = new JsonParser();
							JsonObject jsonData = (JsonObject) parser.parse(dataString);
							for (int i=0; i<jsonData.getAsJsonArray("Table").size(); i++) {
								
								int surveyNo = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("survey_no").getAsInt();
								
								//Check for given survey id in API response, if not found then fail the test case.
								if(surveyNo == Integer.parseInt(surveyData_Array[1])) {
									int actualCorpNo = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("corporate_no").getAsInt();
									int expectedCorpNo = Integer.parseInt(surveyData_Array[0]);
									String actualTitle = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("title").getAsString();
									String expectedTitle = surveyData_Array[2];
									int actualCreatedby = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("createdby").getAsInt();
									int expectedCreatedby = Integer.parseInt(surveyData_Array[3]);
									boolean actualAnonymity = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("anonymity").getAsBoolean();
									boolean expectedAnonymity = Boolean.parseBoolean(surveyData_Array[4]);
									boolean actualSemi_anonymous = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("semi_anonymous").getAsBoolean();
									boolean expectedSemi_anonymous = Boolean.parseBoolean(surveyData_Array[5]);
									boolean actualMultilingual = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("multilingual").getAsBoolean();
									boolean expectedMultilingual = Boolean.parseBoolean(surveyData_Array[6]);
									boolean actualActivate = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("activate").getAsBoolean();
									boolean expectedActivate = Boolean.parseBoolean(surveyData_Array[7]);
									boolean actualExpired = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("expired").getAsBoolean();
									boolean expectedExpired = Boolean.parseBoolean(surveyData_Array[8]);
									int actualResponses = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("responses").getAsInt();
									int expectedResponses = Integer.parseInt(surveyData_Array[9]);
									int actualUniqueResponses = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("UniqueResponses").getAsInt();
									int expectedUniqueResponses = Integer.parseInt(surveyData_Array[10]);
									int actualPublicResponses = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("PublicResponses").getAsInt();
									int expectedPublicResponses = Integer.parseInt(surveyData_Array[11]);
									int actualUniquePartialResponses = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("UniquePartialResponses").getAsInt();
									int expectedUniquePartialResponses = Integer.parseInt(surveyData_Array[12]);
									int actualPublicPartialResponses = jsonData.getAsJsonArray("Table").get(i).getAsJsonObject().get("PublicPartialResponses").getAsInt();
									int expectedPublicPartialResponses = Integer.parseInt(surveyData_Array[13]);
									
									//Validate Corp no, Survey title, Created by, Anonymity, Semi-anonymity, Multilingual, Activate, Expired, Responses,
									//Unique, Public, Partial unique, Partial public values for given survey ID by using assertion.
									try {
										Assert.assertEquals(actualCorpNo, expectedCorpNo, "Corp number is wrong");
										Assert.assertEquals(actualTitle, expectedTitle, "Title is incorrect");
										Assert.assertEquals(actualCreatedby, expectedCreatedby, "Created by value is wrong");
										Assert.assertEquals(actualAnonymity, expectedAnonymity, "Anonymity given is API response is wrong");
										Assert.assertEquals(actualSemi_anonymous, expectedSemi_anonymous, "Semi-Anonymity given in API response is wrong");
										Assert.assertEquals(actualMultilingual, expectedMultilingual, "Multilingual value given in API response is wrong");
										Assert.assertEquals(actualActivate, expectedActivate, "Activate value given in API response is wrong");
										Assert.assertEquals(actualExpired, expectedExpired, "Expired value given in API response is wrong");
										Assert.assertEquals(actualResponses, expectedResponses, "Number of responses given in API is wrong");
										Assert.assertEquals(actualUniqueResponses, expectedUniqueResponses, "Number of unique responses given in API is wrong");
										Assert.assertEquals(actualPublicResponses, expectedPublicResponses, "Number of public responses given in API is wrong");
										Assert.assertEquals(actualUniquePartialResponses, expectedUniquePartialResponses, "Number of unique partial responses given in API is wrong");
										Assert.assertEquals(actualPublicPartialResponses, expectedPublicPartialResponses, "Number of public partial responses given in API is wrong");
										
										//Confirm the validation in testNG and Extent report
										test.info("<b>Corp no, Survey title, Created by, Anonymity, Semi-anonymity, Multilingual, Activate, Expired, Responses, Unique Responses, Public Responses, Partial Unique Responses, Partial Public Responses</b> has been validated for given survey ID <b>"+surveyData_Array[1] +"</b>.");
										Reporter.log("<b>Corp no, Survey title, Created by, Anonymity, Semi-anonymity, Multilingual, Activate, Expired, Responses, Unique Responses, Public Responses, Partial Unique Responses, Partial Public Responses</b> has been validated for given survey ID <b>"+surveyData_Array[1] +"</b>.");
									}catch (AssertionError e){
										test.log(Status.FAIL,"Assertion error occured : "+e.getMessage());
										Add_Log.info("Assertion error occured : "+e.getMessage());
										Reporter.log("Assertion error occured : "+e.getMessage());
										TestResultStatus.failureReason.add(TestCaseName + "| "+ "Assertion error occured : "+e.getMessage());
										TestResultStatus.TestFail = true;
										Assert.fail();
									}
									respData.put(TestCaseName, (new GsonBuilder().setPrettyPrinting().create()).toJson(jsonData.getAsJsonArray("Table").get(i).getAsJsonObject()));
									isSurveyIDPresent = true;
									break;
								}
								
							}
							//Fail the test case if given survey ID is not found in API response
							if(isSurveyIDPresent == false) {
								test.log(Status.FAIL,"Given survey ID " +surveyData_Array[1] +" is not found in survey list");
								Add_Log.info("Given survey ID " +surveyData_Array[1] +" is not found in survey list");
								Reporter.log("Given survey ID " +surveyData_Array[1] +" is not found in survey list");
								TestResultStatus.failureReason.add(TestCaseName + "| "+ "Given survey ID " +surveyData_Array[1] +" is not found in survey list");
								TestResultStatus.TestFail = true;
								Assert.fail();
								}
							}else {
								test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
								Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
								Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
								TestResultStatus.failureReason.add(TestCaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
								TestResultStatus.TestFail = true;
								Assert.fail();
					}
					
				}else {
					test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
					Add_Log.info("Incorrect status code returned "+response.getStatusCode());
					Reporter.log("Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.failureReason.add(TestCaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getData API", alwaysRun = true)
	public void API_TC48(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("intstartno", getData(data, "intstartno"));
		param.put("intendno", getData(data, "intendno"));
		param.put("path", getData(data, "path"));
		param.put("anonymous", getData(data, "anonymous"));
	
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.getData(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToResponseTableReport(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				rmx.getResponseTableData(getDriver(), param, test);
				api.validateDataFromResponseTbReport(param, test);
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getData API", alwaysRun = true)
	public void API_TC49(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("intstartno", getData(data, "intstartno"));
		param.put("intendno", getData(data, "intendno"));
		param.put("path", getData(data, "path"));
		param.put("anonymous", getData(data, "anonymous"));
	
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.getData(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToResponseTableReport(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				rmx.getResponseTableData(getDriver(), param, test);
				api.validateDataFromResponseTbReport(param, test);
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "getData API", alwaysRun = true)
	public void API_TC50(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("surveyNo", getData(data, "surveyNo"));
		param.put("intstartno", getData(data, "intstartno"));
		param.put("intendno", getData(data, "intendno"));
		param.put("path", getData(data, "path"));
		param.put("anonymous", getData(data, "anonymous"));
	
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.getData(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				rmx.goToResponseTableReport(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				rmx.getResponseTableData(getDriver(), param, test);
				api.validateDataFromResponseTbReport(param, test);
			}
		}

	}
		
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "updateContactList API", alwaysRun = true)
	public void API_TC51(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("listname", getData(data, "listname"));
		param.put("intoperationtype", getData(data, "intoperationtype"));
		param.put("isallowduplicate", getData(data, "isallowduplicate"));
		param.put("path", getData(data, "path"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("ContactListHeaderFields", getData(data, "ContactListHeaderFields"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.updateContactList(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.goToContactList(getDriver(), param, test);
				dmx.selectContactList(getDriver(), param, test);
				dmx.getContactListDetailsJson(getDriver(), param, test);
				api.validateContactListData(param, test);
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "updateContactList API", alwaysRun = true)
	public void API_TC52(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("listname", getData(data, "listname"));
		param.put("intoperationtype", getData(data, "intoperationtype"));
		param.put("isallowduplicate", getData(data, "isallowduplicate"));
		param.put("path", getData(data, "path"));
		param.put("numberOfContact", getData(data, "numberOfContact"));
		param.put("ContactListHeaderFields", getData(data, "ContactListHeaderFields"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.updateContactList(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.goToContactList(getDriver(), param, test);
				dmx.selectContactList(getDriver(), param, test);
				dmx.getContactListDetailsJsonOfInsertedData(getDriver(), param, test);
				api.validateContactListData(param, test);
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "updateContactList API", alwaysRun = true)
	public void API_TC53(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("listname", getData(data, "listname"));
		param.put("intoperationtype", getData(data, "intoperationtype"));
		param.put("isallowduplicate", getData(data, "isallowduplicate"));
		param.put("path", getData(data, "path"));
		param.put("stremailaddress", getData(data, "stremailaddress"));
		param.put("ContactListHeaderFields", getData(data, "ContactListHeaderFields"));
		param.put("upsertAction", getData(data, "upsertAction"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.updateContactList(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.goToContactList(getDriver(), param, test);
				dmx.selectContactList(getDriver(), param, test);
				dmx.getContactListDetailsJson(getDriver(), param, test);
				api.validateContactListData(param, test);
				
				
			}
		}

	}
	
	@Test(dataProvider = "SoGo API", dataProviderClass = utility.XLSDataProvider.class, groups = "updateContactList API", alwaysRun = true)
	public void API_TC54(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		outputJsonPath = "\\Output Json\\"+TestCaseName+".json";
		test = extent.createTest(TestCaseName);
		testCaseDescription = getData(data, "Test_Description");
		Reporter.log("Test description : <b>"+testCaseDescription +"</b>");  
		test.info("Test description : <b>"+testCaseDescription +"</b>");
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("TestCaseName", TestCaseName);
		param.put("listname", getData(data, "listname"));
		param.put("intoperationtype", getData(data, "intoperationtype"));
		param.put("isallowduplicate", getData(data, "isallowduplicate"));
		param.put("path", getData(data, "path"));
		param.put("numberOfContact", getData(data, "numberOfContact"));
		param.put("ContactListHeaderFields", getData(data, "ContactListHeaderFields"));
		param.put("upsertAction", getData(data, "upsertAction"));
		
		HashMap<String, Object> responseData = new HashMap<String, Object>();
			
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
					apiToken = users.get("apiToken");
				}
//				password = decryptPass.decryptUserPassword(encPassword);
				param.put("baseURL", URLs.get(key));
				responseData = api.updateContactList(param, apiToken, test);
				statusCode.put(TestCaseName, responseData.get("statusCode").toString());
				respData.put(TestCaseName, responseData.get("respData").toString());
				headers.put(TestCaseName, responseData.get("headerList").toString());
				
				loadBrowser();
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				dmx.goToDistributePage(getDriver(), param, getData(data, "surveyTitle"), getData(data, "surveyNo"), test);
				dmx.goToContactList(getDriver(), param, test);
				dmx.selectContactList(getDriver(), param, test);
				dmx.getContactListDetailsJsonOfInsertedData(getDriver(), param, test);
				api.validateContactListData(param, test);
				
				
			}
		}

	}



	@AfterMethod(alwaysRun = true)
	public void reporterDataResults(ITestResult Result) throws IOException {
		if (Result.getStatus() == ITestResult.SKIP) {
			statusCode.put(Result.getName(), "--");
			respData.put(Result.getName(), "--");
			headers.put(Result.getName(), "--");
			Reporter.log(Result.getName() + " is SKIPPED.");
			Add_Log.info(Result.getName() + " is SKIPPED.");
			TestResultTL.put(Result.getName(), "SKIP");
			test.skip(Result.getName() + " is SKIPPED.");
		} else if (Result.getStatus() == ITestResult.FAILURE) {
			statusCode.put(Result.getName(), "--");
			respData.put(Result.getName(), "--");
			headers.put(Result.getName(), "--");
			Reporter.log(Result.getName() + " is FAILED.");
			Add_Log.info(Result.getName() + " is FAILED.");
			TestResultTL.put(Result.getName(), "FAIL");
			test.fail(Result.getName() + " is FAILED.");
//			test.fail(Result.getName() + " is FAILED.", (MediaEntityBuilder.createScreenCaptureFromPath(takescreenshots(getDriver())).build()));
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
			SuiteUtility.WriteResultUtility2(filePath, sheetName, "statusCode", statusCode);
			SuiteUtility.WriteResultUtility2(filePath, sheetName, "respData", respData);
			SuiteUtility.WriteResultUtility2(filePath, sheetName, "headerList", headers);
			extent.flush();
			fetchExcelData.reportLog("Sogo_API", "Report", "xlsx");
		
	}
	

	 

}
