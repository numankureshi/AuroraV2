package com.sogo.performance;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import pageobjects.SoGoStaticPage;
import testsuitebase.SuiteBase;
import testsuitebase.TestResultStatus;
import utility.FetchExcelDataSet;
import utility.Read_XLS;
import utility.MyScreenRecorder;
import utility.SeleniumUtils;
import utility.SuiteUtility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;

public class SogoNSReading_TC extends SuiteBase {
	Read_XLS filePath = null;
	String Environment;
	String TestCaseName = null;
	public boolean testSkip = false;
	String sheetName = "PerformanceTC";
	public ExtentTest test;
	public DecimalFormat df = new DecimalFormat("#.##");
	public double finish, start;
	public static HashMap<String, String> TestResultTL = new HashMap<String, String>();
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
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC1(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
//				Selenium 4 Changes : add network logs				
//				devTools.createSession();
//				devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//				
//				JsonArray ntwJsonArray = new JsonArray();
//				devTools.addListener(Network.responseReceived(), response -> {
//					Long originTime = System.currentTimeMillis();
//					JsonObject resp = new JsonObject(); 
//					resp.addProperty("url", response.getResponse().getUrl());
//					resp.addProperty("status",response.getResponse().getStatus());
//					resp.addProperty("MimeType",response.getResponse().getMimeType());
//					resp.addProperty("Protocol",response.getResponse().getProtocol().get());
//					resp.addProperty("Type",response.getType().name());
//					Long respTime = (long) Double.parseDouble(response.getResponse().getResponseTime().get().toString());
//					resp.addProperty("ResponseTime",respTime);
//					resp.addProperty("originTime",originTime);
//					resp.addProperty("Duration",(respTime-originTime));
//					ntwJsonArray.add(resp);
//				});
				double totalTime = staticPage.navigateToSogoStatic(getDriver(), param, URLs.get(key), test);
//				System.out.println(ntwJsonArray);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
//				devTools.send(Network.disable());
//				devTools.close();
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC2(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				double totalTime = staticPage.navigateToSogoLoginPage(getDriver(), param, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC3(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				double totalTime = staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC4(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				double totalTime = staticPage.navigateToSogoProducts(getDriver(), param, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC5(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				double totalTime = staticPage.navigateToSogoPricing(getDriver(), param, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC6(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				double totalTime = staticPage.navigateToSoGoRegistration(getDriver(), param, URLs.get(key), test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Static", alwaysRun = true)
	public void Performance_TC7(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
		test = extent.createTest(TestCaseName);
		CaseToRun = getData(data, "CaseToRun");
		String Role = getData(data, "Role");
		String TestData = getData(data, "TestData");
		String[] regDetails = TestData.split(",");
		String firstName = regDetails[0];
		String lastName = regDetails[1];
		String userID = regDetails[2];
		String password = regDetails[3];
		String emailId = regDetails[4];
		
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
				double totalTime = staticPage.navigateToSoGoBilling(getDriver(), param, URLs.get(key), test, firstName, lastName, userID, password, emailId);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}

	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC8(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				double totalTime = smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC9(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.depositeQuestionToQuestionBank(getDriver(), param, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC10(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.addComment(getDriver(), param, descrText, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC11(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.deleteComment(getDriver(), param, descrText, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC12(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.movePage(getDriver(), param, pageNo, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}
		}

	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC13(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				smxPage.goToDesignerPage(getDriver(), param, surveyTitle, SID, test);
				double totalTime = smxPage.moveMatrixGrid(getDriver(), param, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC14(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				double totalTime = dmxPage.goToDistributePage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC15(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				double totalTime = rmxPage.goToReportPage(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC16(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
				double totalTime = rmxPage.loadOMNIReport(getDriver(), param, surveyTitle, SID, test);
				String totaltime = df.format(totalTime);
				System.out.println("total time :"+ totaltime);
				LoadTime.put(TestCaseName, totaltime);
			}

		}
	}
	
	
	@Test(dataProvider = "Performance", dataProviderClass = utility.XLSDataProvider.class, groups = "Platform", alwaysRun = true)
	public void Performance_TC17(LinkedHashMap<String, String> data) throws Exception {
		
		TestCaseName = getData(data, "TestCaseName");
		MyScreenRecorder.startRecording(TestCaseName);
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
				staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
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
		try {
			MyScreenRecorder.stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testSkip = false;
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("After Class Method");
		SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
		SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
		SuiteUtility.WriteResultUtility2(filePath, sheetName, "TimeLoad", LoadTime);
		extent.flush();
		//fetchExcelData.reportLog("Sogo_NSReadings", "Report", "xlsx");
	}

//	@AfterSuite(alwaysRun = true)
//	public void afterSuite() {
//		
//			SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip", TestResultTL);
//			SuiteUtility.WriteResultUtility1(filePath, sheetName, "Failure Reason", TestResultStatus.failureReason);
//			SuiteUtility.WriteResultUtility2(filePath, sheetName, "TimeLoad", LoadTime);
//			extent.flush();
//			fetchExcelData.reportLog("Sogo_Performance", "Report", "xlsx");
//		
//	}
	
	
	/*
	 * public void waitForPageToBeLoaded(WebDriver driver, long timeOutInSeconds) {
	 * WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	 * wait.until(new ExpectedCondition<Boolean>() { public Boolean apply(WebDriver
	 * driver) { return ((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete"); } });
	 * }
	 */
	 

}
