package com.sogo.smoke.smxpage;

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

public class SMXPage_TC extends SuiteBase {
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


		//Anas comment
		//Vivek Comment

		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC2(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
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
			param.put("AnswerOptions1", getData(data, "AnswerOptions1"));
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
			param.put("horizontalradiobutton", getData(data, "horizontalradiobutton"));
			param.put("numericallocations", getData(data, "numericallocations"));
			param.put("attachments", getData(data, "attachments"));
			param.put("ratingradiobutton", getData(data, "ratingradiobutton"));	
			param.put("ratingdropdownbutton", getData(data, "ratingdropdownbutton"));
			param.put("listbox", getData(data, "listbox"));
			param.put("demographics", getData(data, "demographics"));
			param.put("subquestions", getData(data, "subquestions"));
			param.put("symbolratingscale", getData(data, "symbolratingscale"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.createSurvey(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC119(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("TestCaseName", TestCaseName);
			param.put("surveyname", getData(data, "surveyname"));
			param.put("foldername", getData(data, "foldername"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("reportingvalue", getData(data, "reportingvalue"));
			param.put("images", getData(data, "images"));
			param.put("QuestionOptions", getData(data, "QuestionOptions"));
			param.put("matrixgrid", getData(data, "matrixgrid"));
			param.put("numericallocations", getData(data, "numericallocations"));
			param.put("SRSSubqueCount", getData(data, "subQuestionCount"));
			param.put("MDDSubqueCount", getData(data, "subQuestionCount"));
			param.put("RGSubqueCount", getData(data, "subQuestionCount"));
			param.put("CBGSubqueCount", getData(data, "subQuestionCount"));
			param.put("RRGSubqueCount", getData(data, "subQuestionCount"));
			param.put("RDDGSubqueCount", getData(data, "subQuestionCount"));
			param.put("RSGSubqueCount", getData(data, "subQuestionCount"));
			param.put("attachmentQDetails", getData(data, "attachmentQDetails1"));
			param.put("srsFormat", getData(data, "srsFormat"));
			param.put("MTBSubqueCount", getData(data, "MTBSubqueCount"));
			param.put("mtbFormat", getData(data, "mtbFormat"));
			param.put("RSGAnsOptions", getData(data, "RSG"));
//			param.put("quesHint", getData(data, "quesHint"));
			param.put("Custom format", getData(data, "Custom format"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.allControlSurvey(getDriver(), param, test);
					
				}
			}

		}
	
		
		
		
		
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC19(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("surveyname", getData(data, "surveyname"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("RadioButton",getData(data, "RadioButton"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.createPoll(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC20(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("imageLocation", getData(data, "secondarylanguage"));
			param.put("surveyType", getData(data, "surveyType"));
			
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.logoUploadFromComputer(getDriver(), param, test);
					
				}
			}

		}

		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC21(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("surveyType", getData(data, "surveyType"));
		
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.useAccountLogo(getDriver(), param, test);
					
				}
			}

		}
	
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC22(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("foldername", getData(data, "foldername"));
			param.put("ThanksMsg", getData(data, "ThanksMsg"));
			param.put("surveyname", getData(data, "surveyname"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.copyFromAnotherProject(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC23(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.insertFromUrl(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC24(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("imageLocation1", getData(data, "RadioButton"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.uploadingJPGFile(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC25(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("imageLocation2", getData(data, "RadioButton2"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.uploadingGIFFile(getDriver(), param, test);
					
				}
			}

		}
		
		
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC26(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.alignOfLogoLeft(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC27(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));	
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.alignOfLogoRight(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC28(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("imageLocation3", getData(data, "CheckBox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.uploadingJPEGFile(getDriver(), param, test);
					
				}
			}

		}
		
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC29(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("imageLocation4", getData(data, "DropDown"));
			param.put("DOB", getData(data, "DOB"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.logoGreaterThan5mb(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC30(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("imageLocation5", getData(data, "Gender"));
			param.put("Grade", getData(data, "Grade"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.unSupportedFileForLogo(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC31(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.deleteUseAccountLogo(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC32(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			// test

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
					// password = decryptPass.decryptUserPassword(encPassword);

					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.MergeDP(getDriver(), param, test);

				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC43(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.limitTestForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC44(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.limitTestForFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC45(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
		
			
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.boldCheckForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC46(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.boldCheckForFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC47(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.italicCheckForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC48(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.italicCheckForFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC49(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.underlineCheckForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC50(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.underlineCheckForFooter(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC51(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.removeFormatForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC52(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.removeFormatFooter(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC53(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.alignmentForHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC54(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.alignmentForFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC55(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.undoAndRedoHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC56(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.undoAndRedoFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC57(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.numberListHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC58(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.numberListFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC59(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.bulltedListHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC60(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.bulltedListFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC61(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.increaseAndDecreaseIndentHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC62(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.increaseAndDecreaseIndentFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC63(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.sourceHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC64(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.sourceFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC65(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.linkUnlinkHeader(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC66(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.linkUnlinkFooter(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC67(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.spellCheckHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC68(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.spellCheckFooter(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC69(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.pasteFromWordHeader(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC70(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.pasteFromWordFooter(getDriver(), param, test);
					
				}
			}

		}
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC71(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.fontColourHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC72(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.fontColourFooter(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC73(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.fontSizeHeader(getDriver(), param, test);
					
				}
			}

		}
		
		
		@Test(dataProvider = "SurveyPage", dataProviderClass = utility.XLSDataProvider.class, groups = "smxpage", alwaysRun = true)
		public void Smoke_TC74(LinkedHashMap<String, String> data) throws Exception {
			TestCaseName = getData(data, "TestCaseName");
			test = extent.createTest(TestCaseName);
			CaseToRun = getData(data, "CaseToRun");
			String Role = getData(data, "Role");
			//test
			
			HashMap<String, String> param = new HashMap<String, String>();
			param.put("textbox", getData(data, "textbox"));
			param.put("surveyType", getData(data, "surveyType"));
			param.put("surveyname", getData(data, "surveyname"));
			param.put("description", getData(data, "description"));
			param.put("AnswerOptions", getData(data, "AnswerOptions"));
			param.put("primarylanguage", getData(data, "primarylanguage"));
			param.put("secondarylanguage", getData(data, "secondarylanguage"));
			param.put("radiobutton", getData(data, "radiobutton"));
			
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
//					password = decryptPass.decryptUserPassword(encPassword);
					
					loadBrowser();
					staticPage.login(getDriver(), param, username, encPassword, URLs.get(key), test);
					smxPage.fontSizeFooter(getDriver(), param, test);
					
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

	/*
	 * @AfterSuite(alwaysRun = true) public void afterSuite() {
	 * 
	 * SuiteUtility.WriteResultUtility(filePath, sheetName, "Pass/Fail/Skip",
	 * TestResultTL); SuiteUtility.WriteResultUtility1(filePath, sheetName,
	 * "Failure Reason", TestResultStatus.failureReason); extent.flush();
	 * fetchExcelData.reportLog("Engage_Sanity", "Report", "xlsx");
	 * 
	 * }
	 */
	
	

}
