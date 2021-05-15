package pageobjects;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import property.IHomePage;
import property.IRMXPage;
import testsuitebase.SuiteBase;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.SuiteUtility;
import utility.WebPageElements;

public class RMXPage extends SeleniumUtils implements IRMXPage, IHomePage {
	

	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	
	
	
	public double goToReportPage(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		new DMXPage().goToDistributePage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();		
		click(driver, testcaseName, report_tab, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_report, test);
		end = System.currentTimeMillis();
		
		driver.switchTo().defaultContent();		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}
	
	
	
	public double loadOMNIReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, omni_report, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_modify_report, test);
		end = System.currentTimeMillis();
		
		double totalTime = ((end - start)) / 1000;
		return totalTime;
	}

	
	

	

	public void loadDARReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		
		
		click(driver, testcaseName, special_reports, test);
		click(driver, testcaseName, dimensional_analysis, test);
		waitforElemPresent(driver, testcaseName, 30, select_project_1_dd, test);
		click(driver, testcaseName, dar_1dd, test);
		scrollIntoCenter(driver, testcaseName, select_folder1_dd, test);
		click(driver, testcaseName, select_folder1_dd, test);
		click(driver, testcaseName, select_project_1_dd, test);
		click(driver, testcaseName, dar_2dd, test);
		scrollIntoCenter(driver, testcaseName, select_folder2_dd, test);
		click(driver, testcaseName, select_folder2_dd, test);
		click(driver, testcaseName, select_project2_dd, test);
		click(driver, testcaseName, generate_report, test);
		click(driver, testcaseName, select_folder2_dd, test);
		waitforElemPresent(driver, testcaseName, 30, add_parent1, test);
		click(driver, testcaseName, add_parent1, test);
		click(driver, testcaseName, add_star1, test);
		click(driver, testcaseName, add_parent2, test);
		click(driver, testcaseName, add_star2, test);
		click(driver, testcaseName, add_parent3, test);
		click(driver, testcaseName, add_star3, test);
		click(driver, testcaseName, add_parent4, test);
		click(driver, testcaseName, add_star4, test);
		click(driver, testcaseName, add_parent5, test);
		click(driver, testcaseName, add_star5, test);
		click(driver, testcaseName, add_parent6, test);
		click(driver, testcaseName, add_star6, test);
		click(driver, testcaseName, add_parent7, test);
		click(driver, testcaseName, add_star7, test);
		click(driver, testcaseName, add_parent8, test);
		click(driver, testcaseName, add_star8, test);
		click(driver, testcaseName, add_parent9, test);
		click(driver, testcaseName, add_star9, test);
		click(driver, testcaseName, add_parent10, test);
		click(driver, testcaseName, add_star10, test);
		click(driver, testcaseName, add_parent11, test);
		click(driver, testcaseName, add_star11, test);
		click(driver, testcaseName, report_canvas, test);
		waitforElemPresent(driver, testcaseName, 30, canvas_title, test);
		click(driver, testcaseName, canvas_title, test);
		click(driver, testcaseName, canvas_description, test);
		click(driver, testcaseName, segment, test);
		waitforElemPresent(driver, testcaseName, 30, segment_surveydd, test);
		click(driver, testcaseName, segment_surveydd, test);
		click(driver, testcaseName, segment_questiondd, test);
		click(driver, testcaseName, segment_answercb, test);
		click(driver, testcaseName, email_report, test);
		waitforElemPresent(driver, testcaseName, 30, segment, test);
		
		
		
		
	}
		
		
		
		
	public void goToIndividualReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		click(driver, testcaseName, individual_report, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		click(driver, testcaseName, all_questions, test);
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		click(driver, testcaseName, wizard_step1_continue, test);
		click(driver, testcaseName, wizard_step3_continue, test);
		click(driver, testcaseName, generate_now_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, survey_metric, test);
	}
	
	public ArrayList<String> getAnswerDataFromIndividualReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> answerData = new ArrayList<String> ();
		List<WebElement> answerField = getWebElements(driver, testcaseName, individual_report_answer_field, test);
		for(WebElement ele : answerField) {
			answerData.add(Jsoup.parse(ele.getAttribute("innerHTML")).text());		
		}
		return answerData;
	}
	
	
	public ArrayList<String> getMetaDataFromIndividualReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		ArrayList<String> metaData = new ArrayList<String>();
		String emailID = getWebElement(driver, testcaseName, individual_report_emailid_field, test)
				.getAttribute("innerHTML");
		String responseNo = getWebElement(driver, testcaseName, individual_report_response_number_field, test)
				.getAttribute("innerHTML");
		String participationTime = (getWebElements(driver, testcaseName, individual_report_participation_time, test))
				.get(1).getAttribute("innerHTML");
		String ipAddress = (getWebElements(driver, testcaseName, individual_report_participation_time, test)).get(2)
				.getAttribute("innerHTML");

		metaData.add(responseNo);
		metaData.add(emailID);
		metaData.add(participationTime);
		metaData.add(ipAddress);
		return metaData;
	}
	
	public void getJsonData(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		int endNo = Integer.parseInt(param.get("intendno"));
		String intstartno = param.get("intstartno");
		ArrayList<String> metaData  = new ArrayList<String>();
		ArrayList<String> answerData = new ArrayList<String>();
		JsonArray table = new JsonArray();
		JsonObject rawData = new JsonObject();

		scrollIntoCenter(driver, testcaseName, individual_report_next_button, test);
		Select select = new Select(getWebElement(driver, testcaseName, select_page_drop_down, test));
		select.selectByValue(intstartno);
		try {
			waitForJStoLoad(driver, 60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int j=Integer.parseInt(param.get("intstartno")); j<=endNo; j++) {
			JsonArray jArray = new JsonArray();

			metaData = getMetaDataFromIndividualReport(driver, param, test);
			answerData = getAnswerDataFromIndividualReport(driver, param, test);
			JsonObject json = new JsonObject();

			json.addProperty("Response No", metaData.get(0));
			json.addProperty("Email ID", metaData.get(1));
			json.addProperty("Participation Time", metaData.get(2));
			json.addProperty("IP Address", metaData.get(3));
			
			for (int i = 0; i < answerData.size(); i++) {
				JsonObject innerJson = new JsonObject();
				innerJson.addProperty("answer", answerData.get(i));
				jArray.add(innerJson);
			}
			json.add("Answer", jArray);

			table.add(json);
			if(j== endNo) {
				break;
			}
			scrollIntoCenter(driver, testcaseName, individual_report_next_button, test);
			click(driver, testcaseName, individual_report_next_button, test);
			while(!(getWebElement(driver, testcaseName, individual_report_next_button, test).isEnabled() || getWebElement(driver, testcaseName, individual_report_previous_button, test).isEnabled())) {
				System.out.println(getText(driver, testcaseName, individual_report_next_button, test) +" is Disabled");
			}
			
		}	
			rawData.add("Raw Data", table);

		new JSONUtility().writeJSONToFIle(testcaseName, rawData, "\\src\\main\\resources\\jsonFiles\\getJsonData.json",test);
	}
	
	public void goToResponseTableReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		click(driver, testcaseName, response_table_report, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		click(driver, testcaseName, all_questions, test);
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		click(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		click(driver, testcaseName, wizard_step3_continue, test);
		Thread.sleep(1000);
		click(driver, testcaseName, generate_now_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, survey_metric, test);
	}
	
	public void getResponseTableData(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws ParseException {
		String testcaseName = param.get("TestCaseName");
		String endno = param.get("intendno");
		String startno = param.get("intstartno");
		String anonymous = param.get("anonymous");
		int intendno = Integer.parseInt(endno);
		int intstartno = Integer.parseInt(startno);
		
		scrollIntoCenter(driver, testcaseName, response_table_select_response_dd, test);
		Select select = new Select(getWebElement(driver, testcaseName, response_table_select_response_dd, test));
//		select.selectByIndex(Integer.parseInt(intstartno)/100);
//		waitForLoad(driver, testcaseName, 30, test);
		
		String lastResponse = select.getAllSelectedOptions().get(0).getAttribute("innerHTML");
		lastResponse = ((lastResponse.substring(10)).split("-"))[1];
		System.out.println(lastResponse);
		
		int selectIndex = intstartno/100;
		select.selectByIndex(selectIndex);
		waitForLoad(driver, testcaseName, 30, test);
		scrollIntoCenter(driver, testcaseName, response_table_select_response_dd, test);
		
		List<WebElement> responseTbData = getWebElements(driver, testcaseName, response_table_answer_field, test);
		int totalFields = responseTbData.size();
		int fieldsPerResponse = totalFields/Integer.parseInt(lastResponse);
		System.out.println(fieldsPerResponse);
		
		// Split the response table data based start number and end number provided.
		int startPoint = fieldsPerResponse*((intstartno-(selectIndex*100))-1);
		int endPoint = fieldsPerResponse*(intendno-(selectIndex*100));
		responseTbData = responseTbData.subList(startPoint, endPoint);
		
		totalFields = responseTbData.size();
		int requiredResponse = (intendno-intstartno)+1;
		String allFields[] = new String[totalFields];
		System.out.println("------------------------------Adding data of "+requiredResponse +" responses in an array-----------------------------------");
		for(int i=0; i<totalFields; i++) {
			allFields[i] = Jsoup.parse(responseTbData.get(i).getAttribute("innerHTML")).text();
		}
		System.out.println("------------------------------Adding data of "+requiredResponse +" responses is completed-----------------------------------");
		
		int fromIndex = 0;
		JsonObject rawData = new JsonObject();
		JsonArray table = new JsonArray();
		for (int i = 0; i < requiredResponse; i++) {
			int toIndex = fromIndex + (fieldsPerResponse);
			String individualResponseData[] = Arrays.copyOfRange(allFields, fromIndex, toIndex);
			fromIndex = fromIndex + (fieldsPerResponse);
			/*
			 * If survey is anonymous, meta data will have 2 fields only (Sr No & Response No), metaDataIndex = 2
			 * else, metaDataIndex = 6, i.e (Sr No,Response No,Email ID, Participation Time,  Participation Time, IP Address)
			 */
			int metaDataIndex = 6;
			if (anonymous.equalsIgnoreCase("Y")) {
				metaDataIndex = 2;
			}

			JsonArray jArray = new JsonArray();
			JsonObject json = new JsonObject();

			json.addProperty("Sr No", individualResponseData[0].replaceAll("[.]*", ""));
			json.addProperty("Response No", individualResponseData[1]);
			if (metaDataIndex == 6) {
				json.addProperty("Email ID", individualResponseData[2]);
				SimpleDateFormat convertdf = new SimpleDateFormat("M/dd/yyyy hh:mm aaa", Locale.ENGLISH); // 12/27/2020 04:22 PM
				SimpleDateFormat mydf = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa", Locale.ENGLISH); // 27-12-2020 04:22 PM
				String participationTime = individualResponseData[4].concat(" ").concat(individualResponseData[5]);
				// Change the data format of participation time in response table report data to match with API response
				json.addProperty("Participation Time", convertdf.format(mydf.parse(participationTime)));
				json.addProperty("IP Address", individualResponseData[3]);
			}
			for (int j = metaDataIndex; j < individualResponseData.length; j++) {
				JsonObject innerJson = new JsonObject();
				innerJson.addProperty("answer", individualResponseData[j]);
				jArray.add(innerJson);
			}
			json.add("Answer", jArray);
			table.add(json);
		}
				

		rawData.add("Raw Data", table);
		new JSONUtility().writeJSONToFIle(testcaseName, rawData, "\\src\\main\\resources\\jsonFiles\\getResponseTbDataJson.json",test);
		}
	

	
	
	
	public void goToReportsPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		//new StaticPage().login(driver, param, username, password, URL, test);
		click(driver, testcaseName, all_projects, test);
		waitForJStoLoad(driver, 60);
		waitForLoad(driver, testcaseName, 60, test);
		switchToIframe(driver, testcaseName, all_project_dashboard_iframe, test);
		waitForElementToBeVisible(driver, testcaseName, main_folder, 30, 100, test);
		setText(driver, testcaseName, search_bar, param.get("surveyTitle"), test);
		click(driver, testcaseName, search_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		WebElement survey = driver.findElement(By.xpath("//div[@sid='"+param.get("SID")+"']"));
		new Actions(driver).moveToElement(survey).perform();
		waitForElementToBeVisible(driver, testcaseName, report_icon2, 10, 100, test);
	
		click(driver, testcaseName, report_icon2, test);
		waitForJStoLoad(driver, 60);
		waitforElemPresent(driver, testcaseName, 60, omni_report, test);
		
		driver.switchTo().defaultContent();	
	}
	
	public void generateOmniReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		slideShowEmail(driver, param, test);
		saveReport(driver, param, test);
		downloadReport(driver, param, test);
		emailReport(driver, param, test);
	}
	
	public void generateAdvancedFrequencyReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectFrequencyReport(driver, param, test);
		selectAllQuestions(driver, param, test);
		reorderQuestions(driver, param, test);
		propertiesPage(driver, param, test);
		dataSources(driver, param, test);
		slideShowEmail(driver, param, test);
		saveReport2(driver, param, test);
		downloadReportAdvance(driver, param, test);
		emailReport(driver, param, test);
	}
	
	public void generateIndividualReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectIndividualReport(driver, param, test);
		selectAllQuestions2(driver, param, test);
		propertiesPage2(driver, param, test);
		dataSources2(driver, param, test);
		saveReport3(driver, param, test);
		downloadReportIndividual(driver, param, test);
		emailReport(driver, param, test);
	}
	
	public void generateResponseTableReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectResponseTableReport(driver, param, test);
		selectAllQuestions2(driver, param, test);
		propertiesPage2(driver, param, test);
		dataSources2(driver, param, test);
		saveReport3(driver, param, test);
		downloadReportResponseTable(driver, param, test);
		emailReport(driver, param, test);
	}
	
	public void generateSegmentationReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectSegmentationReport(driver, param, test);
		selectSegmentationQuestion(driver, param, test);
		
		selectAllQuestions3(driver, param, test);
		propertiesPage3(driver, param, test);
		comparisonSegmentationPage(driver, param, test);
		comparisonCustomizeCoverPage(driver, param, test);
		
		emailReport2(driver, param, test);
	}
	
	public void generateEngagementReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectEngagementReport(driver, param, test);
		participationDetailsPage(driver, param, test);
		selectAllQuestions4(driver, param, test);
		selectDriverQuestions(driver, param, test);
		selectAdditionalQuestions(driver, param, test);
		selectCompositionAnalysis(driver, param, test);
		selectSegmentationReportPage(driver, param, test);
		dataSources3(driver, param, test);
		
	}
	
	public void generateDarReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportsPage(driver, param, test);
		selectDarReport(driver, param, test);
		selectProjectsPage(driver, param, test); 
		selectDARPage(driver, param, test); 
		reportCanvas(driver, param, test);
				 /*
				 * * selectAllQuestions4(driver, param, test); selectDriverQuestions(driver, param, test);
		 * selectAdditionalQuestions(driver, param, test);
		 * selectCompositionAnalysis(driver, param, test);
		 * selectSegmentationReportPage(driver, param, test); dataSources3(driver,
		 * param, test);
		 */
		
	}
	
	public void selectAllQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, survey_questions_page, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions, test);
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(2000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button1, test);
		click(driver, testcaseName, continue_button1, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectAllQuestions2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, survey_questions_page2, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions2, test);
		click(driver, testcaseName, all_questions2, test);
		Thread.sleep(2000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button1, test);
		click(driver, testcaseName, continue_button1, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectAllQuestions3(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, survey_questions_page2, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions3, test);
		click(driver, testcaseName, all_questions3, test);
		Thread.sleep(2000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button22, test);
		click(driver, testcaseName, continue_button22, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectAllQuestions4(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, engagement_questions_page, test);
		String questions[] = param.get("questions").split(",");
		
		for(int i = 0; i < questions.length; i++) {
			scrollIntoView(driver, testcaseName, By.xpath("(//span[text()='"+ questions[i] +"']/parent::label)[1]"), "Question "+questions[i], test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//span[text()='"+ questions[i] +"']/parent::label)[1]"), "Question "+questions[i], test);
			click(driver, testcaseName, By.xpath("(//span[text()='"+ questions[i] +"']/parent::label)[1]"), "Question "+questions[i], test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
		}
		waitforElemPresent(driver, testcaseName, 30, continue_button22, test);
		click(driver, testcaseName, continue_button22, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectDriverQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, drivers_questions_page, test);
		
			scrollIntoView(driver, testcaseName, By.xpath("(//span[text()='"+ param.get("driver") +"']/parent::label)[2]"), "Question "+param.get("driver"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//span[text()='"+ param.get("driver") +"']/parent::label)[2]"), "Question "+param.get("driver"), test);
			click(driver, testcaseName, By.xpath("(//span[text()='"+ param.get("driver") +"']/parent::label)[2]"), "Question "+param.get("driver"), test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
	
		waitforElemPresent(driver, testcaseName, 30, continue_button4, test);
		click(driver, testcaseName, continue_button4, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectAdditionalQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, additional_questions_page, test);
		
			
			click(driver, testcaseName, additional_questions_switch, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			scrollIntoView(driver, testcaseName, By.xpath("(//span[text()='"+ param.get("additional") +"']/parent::label)[1]"), "Question "+param.get("additional"), test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//span[text()='"+ param.get("additional") +"']/parent::label)[1]"), "Question "+param.get("additional"), test);
			click(driver, testcaseName, By.xpath("(//span[text()='"+ param.get("additional") +"']/parent::label)[1]"), "Question "+param.get("additional"), test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button44, test);
		click(driver, testcaseName, continue_button44, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	

	public void selectCompositionAnalysis(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, compositional_analysis_page, test);
		
			
			click(driver, testcaseName, compostion_analysis_switch, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, compostion_report_dd, test);
			Select select = new Select(driver.findElement(By.xpath(COMPOSITION_REPORT_DD)));
//			select.selectByVisibleText(param.get("composition"));
			select.selectByIndex(Integer.parseInt(param.get("composition")));
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button5, test);
		click(driver, testcaseName, continue_button5, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectSegmentationReportPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, segementation_report_page, test);
		
			
			click(driver, testcaseName, segmentation_report_switch, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, segment_input_switch, test);
			setText(driver, testcaseName, segment_input_switch, param.get("segment"), test);
			waitForLoad(driver, testcaseName, 30, test);
			
			
			waitforElemPresent(driver, testcaseName, 30, segment_dd, test);
			Select select = new Select(driver.findElement(By.xpath(SEGMENT_DD)));
//			select2.selectByVisibleText(param.get("segmentation"));
			select.selectByIndex(Integer.parseInt(param.get("segmentation")));
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, add_more, test);
			click(driver, testcaseName, add_more, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			
			waitforElemPresent(driver, testcaseName, 30, segment_input_switch1, test);
			setText(driver, testcaseName, segment_input_switch1, param.get("segment2"), test);
			waitForLoad(driver, testcaseName, 30, test);
			
			
			waitforElemPresent(driver, testcaseName, 30, segment_dd1, test);
			Select select2 = new Select(driver.findElement(By.xpath(SEGMENT_DD1)));
//			select2.selectByVisibleText(param.get("segmentation1"));
			select2.selectByIndex(Integer.parseInt(param.get("segmentation1")));
			waitForLoad(driver, testcaseName, 30, test);
			
		waitforElemPresent(driver, testcaseName, 30, continue_button6, test);
		click(driver, testcaseName, continue_button6, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void dataSources(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, data_sources_page, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, modify_report_button, test);
	}
	
	public void dataSources2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, data_sources_page2, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, modify_report_button, test);
	}
	
	public void dataSources3(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, data_sources_page2, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		//randome code to be written
//		randomGen(1, 2);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@id='dvGenerateCheck']//a)[1]"), "Report# "+1, test);
//		click(driver, testcaseName, By.xpath("(//div[@id='dvGenerateCheck']//a)[1]"), "Report# "+1, test);
		
		
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();
	        String format = null;
	        WebPageElements download_report = null;
	        Actions action = new Actions(driver);
	        switch(noDay)
	        {
	            case 1:
	                System.out.println("Monday");
	                waitforElemPresent(driver, testcaseName, 30, export_ppt, test);
	        		click(driver, testcaseName, export_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	            case 2:
	                System.out.println("Tuesday");
	                waitforElemPresent(driver, testcaseName, 30, export_excel, test);
	        		click(driver, testcaseName, export_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	            case 3:
	                System.out.println("Wednesday");
	                waitforElemPresent(driver, testcaseName, 30, export_ppt, test);
	        		click(driver, testcaseName, export_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	            case 4:
	                System.out.println("Thursday");
	                waitforElemPresent(driver, testcaseName, 30, export_excel, test);
	        		click(driver, testcaseName, export_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	            case 5:
	                System.out.println("Friday");
	                waitforElemPresent(driver, testcaseName, 30, export_ppt, test);
	        		click(driver, testcaseName, export_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	            default:
	                System.out.println("Weekend");
	                waitforElemPresent(driver, testcaseName, 30, export_excel, test);
	        		click(driver, testcaseName, export_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
//	        		format = "docx";
//	        		download_report = download_word_all;
	                break;
	        }
		
		
		///
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, email_engagement_report, test);
		clearText(driver, testcaseName, email_engagement_report, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, email_engagement_report, param.get("emailto"), test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 60, send_email, test);
		click(driver, testcaseName, send_email, test);
		waitForLoad(driver, testcaseName, 30, test);
		Thread.sleep(1000);
		/*
		 * String text = driver.switchTo().alert().getText();
		 * if(text.equals(param.get("expected"))) {
		 * reportPass("Alert message is displayed on Submiting the report", test); }
		 * else { reportFail(testcaseName,
		 * "Alert message is not displayed on Submiting the report", test); }
		 */
//		driver.switchTo().alert().accept();
	}
	
	public static void randomGen(int min, int max) {
		System.out.println("Random value of type double between " + min + " to " + max + ":");
		double a = Math.random() * (max - min + 1) + min;
		System.out.println(a);
		System.out.println("Random value of type int between " + min + " to " + max + ":");
		int b = (int) (Math.random() * (max - min + 1) + min);
		System.out.println(b);
	}
	
	public void emailReport2(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, email_report, test);
		waitforElemPresent(driver, testcaseName, 30, email_segmentation_report, test);
		clearText(driver, testcaseName, email_segmentation_report, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, email_segmentation_report, param.get("emailto"), test);
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, word_zip, test);
		click(driver, testcaseName, word_zip, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, word_seperate, test);
		click(driver, testcaseName, word_seperate, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, generate_button, test);
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, request_received, test);
	}

	public void propertiesPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, properties_page, test);
		waitforElemPresent(driver, testcaseName, 30, display_report_with_tables, test);
		click(driver, testcaseName, display_report_with_tables, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, display_question_names, test);
		click(driver, testcaseName, display_question_names, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, display_weighted_score, test);
		click(driver, testcaseName, display_weighted_score, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button3, test);
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void propertiesPage2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, properties_page2, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button3, test);
		click(driver, testcaseName, continue_button3, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void propertiesPage3(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, properties_page2, test);
		waitforElemPresent(driver, testcaseName, 30, display_question_names, test);
		click(driver, testcaseName, display_question_names, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, display_table, test);
		click(driver, testcaseName, display_table, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, display_weighted_score, test);
		click(driver, testcaseName, display_weighted_score, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button44, test);
		click(driver, testcaseName, continue_button44, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void comparisonSegmentationPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, comparison_segmentation, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button5, test);
		click(driver, testcaseName, continue_button5, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void comparisonCustomizeCoverPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, customize_cover_page, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button6, test);
		click(driver, testcaseName, continue_button6, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void reorderQuestions(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, reorder_questions_page, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@id='dv2']"), "2nd Question", test);
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//div[@id='dv2']"))).moveToElement(driver.findElement(By.xpath("//div[@id='dv1']"))).release(driver.findElement(By.xpath("//div[@id='dv2']"))).build().perform();
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 30, continue_button2, test);
		click(driver, testcaseName, continue_button2, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	public void selectFrequencyReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, frequency_report, test);
		click(driver, testcaseName, frequency_report, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, advanced_frequency_report, test);
		click(driver, testcaseName, advanced_frequency_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectIndividualReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, raw_report, test);
		click(driver, testcaseName, raw_report, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, individual_report, test);
		click(driver, testcaseName, individual_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectResponseTableReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, raw_report, test);
		click(driver, testcaseName, raw_report, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, response_table_report, test);
		click(driver, testcaseName, response_table_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectSegmentationReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, segmentation_report, test);
		click(driver, testcaseName, segmentation_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectEngagementReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, special_report, test);
		click(driver, testcaseName, special_report, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_report, test);
		click(driver, testcaseName, engagement_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectDarReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, special_report, test);
		click(driver, testcaseName, special_report, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, dar_report, test);
		click(driver, testcaseName, dar_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void selectSegmentationQuestion(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, segmentation_question_dd, test);
		Select select = new Select(driver.findElement(By.xpath(SEGMENTATION_QUESTION_DD)));
		select.selectByVisibleText(param.get("question"));
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, select_all_options, test);
		click(driver, testcaseName, select_all_options, test);
		waitForLoad(driver, testcaseName, 30, test);	
		waitforElemPresent(driver, testcaseName, 30, continue_button1, test);
		click(driver, testcaseName, continue_button1, test);
		waitForLoad(driver, testcaseName, 30, test);	
		
	}
	
	public void participationDetailsPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, participation_details, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		String reportName = param.get("rName")+" - " + strDate;
		param.put("reportName", reportName);
		waitforElemPresent(driver, testcaseName, 30, participation_details2, test);
		setText(driver, testcaseName, participation_details2, reportName, test);
		waitForLoad(driver, testcaseName, 30, test);	
		waitforElemPresent(driver, testcaseName, 30, nmax, test);
		setText(driver, testcaseName, nmax, param.get("nmax"), test);
		waitForLoad(driver, testcaseName, 30, test);	
		waitforElemPresent(driver, testcaseName, 30, continue_button11, test);
		click(driver, testcaseName, continue_button11, test);
		waitForLoad(driver, testcaseName, 30, test);	
		
	}
	
	public void selectProjectsPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String[] folders = param.get("folder").split(",");
		String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 30, tp1tg1, test);
		click(driver, testcaseName, tp1tg1, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//li[contains(@class,'OpenDropDown')]//a/span[text()='"+ folders[0] +"']"), folders[0], test);
		click(driver, testcaseName, By.xpath("//li[contains(@class,'OpenDropDown')]//a/span[text()='"+ folders[0] +"']"), folders[0], test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//li[contains(@class,'OpenDropDown')]//a[text()='"+ folders[1] +"']"), folders[1], test);
		click(driver, testcaseName, By.xpath("//li[contains(@class,'OpenDropDown')]//a[text()='"+ folders[1] +"']"), folders[1], test);
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, tp2tg1, test);
		click(driver, testcaseName, tp2tg1, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='col3']//li[contains(@class,'OpenDropDown')]//a/span[text()='"+ folders[2] +"']"), folders[2], test);
		click(driver, testcaseName, By.xpath("//div[@class='col3']//li[contains(@class,'OpenDropDown')]//a/span[text()='"+ folders[2] +"']"), folders[2], test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='col3']//li[contains(@class,'OpenDropDown')]//a[text()='"+ folders[3] +"']"), folders[3], test);
		click(driver, testcaseName, By.xpath("//div[@class='col3']//li[contains(@class,'OpenDropDown')]//a[text()='"+ folders[3] +"']"), folders[3], test);
		Thread.sleep(500);
		
		
		
		waitforElemPresent(driver, testcaseName, 30, generate_report, test);
		click(driver, testcaseName, generate_report, test);
		waitForLoad(driver, testcaseName, 60, test);	
		waitforElemPresent(driver, testcaseName, 60, By.xpath("//div[text()='Dimensional Analysis Report']"), "Dimensional Analysis Report", test);
		
	}
	
	public void reportCanvas(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String[] folders = param.get("folder").split(",");
		String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 30, report_canvas, test);
		click(driver, testcaseName, report_canvas, test);
		Thread.sleep(500);
		waitForLoad(driver, testcaseName, 60, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, report_title, test);
//		String reportName = param.get("rName")+" - " + strDate;
		param.put("reportName", param.get("rName"));
		setText(driver, testcaseName, report_title, param.get("rName"), test);
		waitForLoad(driver, testcaseName, 30, test);
		
		waitforElemPresent(driver, testcaseName, 30, report_desc, test);
		String reportDesc = param.get("rName")+" - " + strDate;
		param.put("reportDesc", reportDesc);
		setText(driver, testcaseName, report_desc, reportDesc, test);
		waitForLoad(driver, testcaseName, 30, test);
		
		reportSegmentation(driver, param, test);
	}
	
	public void reportSegmentation(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		
		String testcaseName = param.get("TestCaseName");
		

		waitforElemPresent(driver, testcaseName, 30, segment_icon, test);
		click(driver, testcaseName, segment_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		Thread.sleep(500);
//		waitforElemPresent(driver, testcaseName, 30, segmentation_survey, test);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'SiteLevelReport.aspx?')]")));
		Select select = new Select(driver.findElement(By.xpath(SEGMENTATION_SURVEY)));
		select.selectByVisibleText(param.get("surveyTitle"));
		waitForLoad(driver, testcaseName, 30, test);
		Thread.sleep(500);
		
//		waitforElemPresent(driver, testcaseName, 30, segmentation_question, test);
		Select select2 = new Select(driver.findElement(By.xpath(SEGMENTATION_QUESTION)));
		select2.selectByValue(param.get("driver"));
		waitForLoad(driver, testcaseName, 30, test);
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, select_all, test);
		click(driver, testcaseName, select_all, test);
		Thread.sleep(500);
		waitForLoad(driver, testcaseName, 60, test);
		
		waitforElemPresent(driver, testcaseName, 30, email_report_to, test);
		setText(driver, testcaseName, email_report_to, param.get("emailto"), test);
		waitForLoad(driver, testcaseName, 30, test);
		
		driver.findElement(By.xpath(EMAIL_REPORT_TO)).sendKeys(Keys.TAB);
		
		waitforElemPresent(driver, testcaseName, 30, email_report2, test);
		click(driver, testcaseName, email_report2, test);
		Thread.sleep(500);
		waitForLoad(driver, testcaseName, 60, test);
		driver.switchTo().defaultContent();
	}
	
	public void selectDARPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String[] folders = param.get("folder").split(",");
		String testcaseName = param.get("TestCaseName");
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1001']//div[@class='StarInActive GraphStar']"), "Overall Score", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1001']//div[@class='StarInActive GraphStar']"), "Overall Score", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Show Table'])[1]"), "Overall Score Data Table", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Show Table'])[1]"), "Overall Score Data Table", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1001']//div[@class='StarInActive'])[1]"), "Overall Score Data Table", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1001']//div[@class='StarInActive'])[1]"), "Overall Score Data Table", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1001']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1001']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1001']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1001']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1001']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1002']//span[text()='Dimension Scores']"), "Dimension Scores", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1002']//span[text()='Dimension Scores']"), "Dimension Scores", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//span[text()='Dimension Scores']/following::div[@class='StarInActive GraphStar'])[1]"), "Dimension Scores", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//span[text()='Dimension Scores']/following::div[@class='StarInActive GraphStar'])[1]"), "Dimension Scores", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Show Table'])[1]"), "Dimension Scores", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Show Table'])[1]"), "Dimension Scores", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//div[@class='StarInActive'])[1]"), "Dimension Scores", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//div[@class='StarInActive'])[1]"), "Dimension Scores", test);
		Thread.sleep(500);
		

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1002']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1002']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1002']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1002']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']"), "Rules and Regulations", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']"), "Rules and Regulations", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']/following::div[@class='StarInActive GraphStar'])[1]"), "Rules and Regulations", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']/following::div[@class='StarInActive GraphStar'])[1]"), "Rules and Regulations", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"), "Rules and Regulations", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"), "Rules and Regulations", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]"), "Rules and Regulations", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]"), "Rules and Regulations", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"), "Comparison Over Time", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]"), "Comparison Over Time", test);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1003']//span[text()='Highest Ranking Indicators']"), "Highest Ranking Indicators", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1003']//span[text()='Highest Ranking Indicators']"), "Highest Ranking Indicators", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1003']//span[text()='Highest Ranking Indicators']/following::div[@class='StarInActive'])[1]"), "Highest Ranking Indicators", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1003']//span[text()='Highest Ranking Indicators']/following::div[@class='StarInActive'])[1]"), "Highest Ranking Indicators", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_1004']//span[text()='Lowest Ranking Indicators']"), "Lowest Ranking Indicators", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_1004']//span[text()='Lowest Ranking Indicators']"), "Lowest Ranking Indicators", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_1004']//span[text()='Lowest Ranking Indicators']/following::div[@class='StarInActive'])[1]"), "Lowest Ranking Indicators", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_1004']//span[text()='Lowest Ranking Indicators']/following::div[@class='StarInActive'])[1]"), "Lowest Ranking Indicators", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']"), "What is your ethnic group?", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']"), "What is your ethnic group?", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']/following::div[@class='StarInActive GraphStar'])[1]"), "What is your ethnic group?", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']/following::div[@class='StarInActive GraphStar'])[1]"), "What is your ethnic group?", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_3']//div[text()='Show Table'])[1]"), "What is your ethnic group?", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_3']//div[text()='Show Table'])[1]"), "What is your ethnic group?", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_3']//div[@class='StarInActive'])[1]"), "What is your ethnic group?", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_3']//div[@class='StarInActive'])[1]"), "What is your ethnic group?", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']"), "Please respond to the following statements.", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']"), "Please respond to the following statements.", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']/following::div[@class='StarInActive GraphStar'])[1]"), "Please respond to the following statements.", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']/following::div[@class='StarInActive GraphStar'])[1]"), "Please respond to the following statements.", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_6']//div[text()='Show Table'])[1]"), "Please respond to the following statements.", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_6']//div[text()='Show Table'])[1]"), "Please respond to the following statements.", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_6']//div[@class='StarInActive'])[1]"), "Please respond to the following statements.", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_6']//div[@class='StarInActive'])[1]"), "Please respond to the following statements.", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_2001']//span[text()='Response Rate']"), "Response Rate", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_2001']//span[text()='Response Rate']"), "Response Rate", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2001']//span[text()='Response Rate']/following::div[@class='StarInActive GraphStar'])[1]"), "Response Rate", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2001']//span[text()='Response Rate']/following::div[@class='StarInActive GraphStar'])[1]"), "Response Rate", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2001']//div[text()='Show Table'])[1]"), "Response Rate", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2001']//div[text()='Show Table'])[1]"), "Response Rate", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2001']//div[@class='StarInActive'])[1]"), "Response Rate", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2001']//div[@class='StarInActive'])[1]"), "Response Rate", test);
		Thread.sleep(500);
		
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[@class='ClimateScore_1_2002']//span[text()='Response Source']"), "Response Source", test);
		click(driver, testcaseName, By.xpath("//div[@class='ClimateScore_1_2002']//span[text()='Response Source']"), "Response Source", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2002']//span[text()='Response Source']/following::div[@class='StarInActive GraphStar'])[1]"), "Response Source", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2002']//span[text()='Response Source']/following::div[@class='StarInActive GraphStar'])[1]"), "Response Source", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2002']//div[text()='Show Table'])[1]"), "Response Source", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2002']//div[text()='Show Table'])[1]"), "Response Source", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("(//div[@class='ClimateScore_1_2002']//div[@class='StarInActive'])[1]"), "Response Source", test);
		click(driver, testcaseName, By.xpath("(//div[@class='ClimateScore_1_2002']//div[@class='StarInActive'])[1]"), "Response Source", test);
		Thread.sleep(500);
		
	}
	
	
	
	public void slideShowEmail(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, slideshow_icon, test);
		click(driver, testcaseName, slideshow_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, slideshow_email, test);
		click(driver, testcaseName, slideshow_email, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, slideshow_email_to, test);
		setText(driver, testcaseName, slideshow_email_to, param.get("emailto"), test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, slideshow_email_send, test);
		click(driver, testcaseName, slideshow_email_send, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='Your report has been emailed successfully.']"), "Your report has been emailed successfully.", test);
		waitforElemPresent(driver, testcaseName, 30, slideshow_close, test);
		click(driver, testcaseName, slideshow_close, test);
		waitForLoad(driver, testcaseName, 30, test);
		if(driver.getTitle().contains("Omni")) {
			click(driver, testcaseName, toaster_close, test);
		}
		
	}
	
	public void saveReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, save_report_icon, test);
		click(driver, testcaseName, save_report_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, save_report_name, test);
		String reportName = param.get("rName")+" - " + strDate;
		param.put("reportName", reportName);
		setText(driver, testcaseName, save_report_name, reportName, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, save_button, test);
		click(driver, testcaseName, save_button, test);
//		Thread.sleep(1000);
		
//		waitForLoad(driver, testcaseName, 30, test);
		waitForElementToBeVisible(driver, testcaseName,  By.xpath("//span[contains(text(),'This report has been saved as ')]"), 
				"This report has been saved as ", 30, 100, test);
		//waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'This report has been saved as ')]"), "This report has been saved as ", test);
		
	}
	
	public void saveReport2(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, save_report_icon, test);
		click(driver, testcaseName, save_report_icon, test);
		waitForLoad(driver, testcaseName, 30, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, save_report_name2, test);
		String reportName = param.get("rName")+" - " + strDate;
		param.put("reportName", reportName);
		clearText(driver, testcaseName, save_report_name2, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, save_report_name2, reportName, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'This report has been saved as ')]"), "This report has been saved as ", test);
		
	}
	
	public void saveReport3(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		Thread.sleep(2000);
//		waitforElemPresent(driver, testcaseName, 30, save_report_icon, test);
		click(driver, testcaseName, save_report_icon, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
	
		String reportName = param.get("rName")+" - " + strDate;
		param.put("reportName", reportName);
		waitforElemPresent(driver, testcaseName, 30, save_report_name3, test);
		clearText(driver, testcaseName, save_report_name3, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, save_report_name3, reportName, test);
		Thread.sleep(1000);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'This report has been saved as ')]"), "This report has been saved as ", test);
		
	}
	
	public void emailReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, share_email, test);
		click(driver, testcaseName, share_email, test);
		waitForLoad(driver, testcaseName, 30, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		String reportNameTitle = param.get("rName")+" - " + strDate;
		param.put("reportNameTitle", reportNameTitle);
		waitforElemPresent(driver, testcaseName, 30, share_email_title, test);
		setText(driver, testcaseName, share_email_title, reportNameTitle, test);
		waitForLoad(driver, testcaseName, 30, test);
		
		waitforElemPresent(driver, testcaseName, 30, share_email_to, test);
		setText(driver, testcaseName, share_email_to, param.get("emailto"), test);
		waitForLoad(driver, testcaseName, 30, test);
		
		waitforElemPresent(driver, testcaseName, 30, continue_button, test);
		click(driver, testcaseName, continue_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, share_email_send, test);
		click(driver, testcaseName, share_email_send, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='Your report has been emailed to:']"), "Your report has been emailed to:", test);

	}
	
	public void downloadReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, download_report2, test);
		click(driver, testcaseName, download_report2, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[contains(text(),'Export Report')]"), "Export Report", test);
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();
	        String format = null;
	        switch(noDay)
	        {
	            case 1:
	                System.out.println("Monday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel, test);
	        		click(driver, testcaseName, download_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xlsx";
	                break;
	            case 2:
	                System.out.println("Tuesday");
	                waitforElemPresent(driver, testcaseName, 30, download_ppt, test);
	        		click(driver, testcaseName, download_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "pptx";
	                break;
	            case 3:
	                System.out.println("Wednesday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel, test);
	        		click(driver, testcaseName, download_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xlsx";
	                break;
	            case 4:
	                System.out.println("Thursday");
	                waitforElemPresent(driver, testcaseName, 30, download_ppt, test);
	        		click(driver, testcaseName, download_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "pptx";
	                break;
	            case 5:
	                System.out.println("Friday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel, test);
	        		click(driver, testcaseName, download_excel, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xlsx";
	                break;
	            default:
	                System.out.println("Weekend");
	                waitforElemPresent(driver, testcaseName, 30, download_ppt, test);
	        		click(driver, testcaseName, download_ppt, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "pptx";
	                break;
	        }
	        int size = driver.findElements(By.xpath("//a[text()='Export']")).size();
	        waitforElemPresent(driver, testcaseName, 30, By.xpath("(//a[text()='Export'])["+ size +"]"), "Export", test);
//    		click(driver, testcaseName, By.xpath("(//a[text()='Export'])["+ size +"]"), "Export", test);
    		waitForLoad(driver, testcaseName, 30, test);
    		String DOWNLOAD_REPORT = "(//a[text()='Export'])["+ size +"]";
    		WebPageElements download_report = new WebPageElements("Download Report", "xpath", DOWNLOAD_REPORT);
    		downloadFile(driver, param, download_report, format, test);
	}
	
	public void downloadReportAdvance(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, download_report2, test);
		click(driver, testcaseName, download_report2, test);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[contains(text(),'Export Report')]"), "Export Report", test);
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();
	        String format = null;
	        WebPageElements download_report = null;
	        switch(noDay)
	        {
	            case 1:
	                System.out.println("Monday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word;
	                break;
	            case 2:
	                System.out.println("Tuesday");
	                waitforElemPresent(driver, testcaseName, 30, download_ppt2, test);
//	        		click(driver, testcaseName, download_ppt2, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "pptx";
	        		download_report = download_ppt2;
	                break;
	            case 3:
	                System.out.println("Wednesday");
	                waitforElemPresent(driver, testcaseName, 30, download_ppt3, test);
//	        		click(driver, testcaseName, download_ppt3, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "pptx";
	        		download_report = download_ppt3;
	                break;
	            case 4:
	                System.out.println("Thursday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel2, test);
//	        		click(driver, testcaseName, download_excel2, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel2;
	                break;
	            case 5:
	                System.out.println("Friday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel3, test);
//	        		click(driver, testcaseName, download_excel3, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xlsx";
	        		download_report = download_excel3;
	                break;
	            default:
	                System.out.println("Weekend");
	                waitforElemPresent(driver, testcaseName, 30, download_excel2, test);
//	        		click(driver, testcaseName, download_excel2, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel2;
	                break;
	        }
	     
    		
    		downloadFile(driver, param, download_report, format, test);
	}
	
	public void downloadReportIndividual(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, download_report2, test);
		click(driver, testcaseName, download_report2, test);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[contains(text(),'Export Report')]"), "Export Report", test);
		LocalDate date = LocalDate.now();  
		DayOfWeek day = date.getDayOfWeek();
		int noDay = day.getValue();
	        String format = null;
	        WebPageElements download_report = null;
	        Actions action = new Actions(driver);
	        switch(noDay)
	        {
	            case 1:
	                System.out.println("Monday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_WORD))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_word_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_one;
	                break;
	            case 2:
	                System.out.println("Tuesday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_one;
	                break;
	            case 3:
	                System.out.println("Wednesday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_WORD))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_word_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_one;
	                break;
	            case 4:
	                System.out.println("Thursday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_one;
	                break;
	            case 5:
	                System.out.println("Friday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_WORD))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_word_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_one;
	                break;
	            default:
	                System.out.println("Weekend");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_one, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_one;
	                break;
	        }
	     
    		
    		downloadFile(driver, param, download_report, format, test);
	}
	
	public void downloadReportResponseTable(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, download_report2, test);
		click(driver, testcaseName, download_report2, test);
		waitForLoad(driver, testcaseName, 30, test);
//		waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[contains(text(),'Export Report')]"), "Export Report", test);

		String format = null;
		WebPageElements download_report = null;

		waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
//	        		click(driver, testcaseName, download_word, test);
		waitForLoad(driver, testcaseName, 30, test);
		format = "xls";
		download_report = download_excel4;

		downloadFile(driver, param, download_report, format, test);
	}
	
	public void downloadFile(WebDriver driver, HashMap<String, String> param, WebPageElements button, String format, ExtentTest test) {
		DMXPage dmxPage = new DMXPage();
		String testcaseName = param.get("TestCaseName");
		String downloadFilePath = System.getProperty("user.dir") +"\\src\\main\\resources\\excelfiles";
		String fileSystem = "ExportFiles";
		long beforeCount = 0;
		try {
			beforeCount = Files.list(Paths.get("./src/main/resources/excelfiles")).count();
			System.out.println(beforeCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			long afterCount = beforeCount;
			int i = 0;
//			waitforElemPresent(driver, testcaseName, 30, button, test);
			click(driver, testcaseName, button, test);
			while (beforeCount >= afterCount && i < 300) {
				afterCount = Files.list(Paths.get("./src/main/resources/excelfiles")).count();
				Thread.sleep(1000);
				i++;
			}
			if(i == 300) {
				reportFail(testcaseName,
						"The excel was not downloaded.", test);
			}
			System.out.println(afterCount);
//			Thread.sleep(2000);
			String fileName = dmxPage.latestFileName();
			while(fileName.contains("tmp") || fileName.contains("crdownload")) {
				Thread.sleep(500);
				fileName = dmxPage.latestFileName();
			}
			
		} catch (Exception e) {
			reportFail(testcaseName,
					"The excel was not downloaded.", test);
		}
		
		File theDir = new File("./src/main/resources/excelfiles/"+ fileSystem);
		if(!theDir.exists()) {
			theDir.mkdir();
		}
		int r = dmxPage.RandomNumber();
		String fileName = dmxPage.latestFileName(format);
		String[] filesNew2 = fileName.split("\\.");
		String latestFile = filesNew2[0] + "_" + r;
//		String latestFile = fileName;
		System.out.println(latestFile);
		File file = new File("./src/main/resources/excelfiles/"+latestFile.trim()+"."+format);
		File file2 = new File("./src/main/resources/excelfiles/"+fileName);
		
		file2.renameTo(file);
		String path = "./src/main/resources/excelfiles/"+fileSystem+"/"+latestFile.trim()+"."+format;
		
		file.renameTo(new File("./src/main/resources/excelfiles/"+fileSystem+"/"+latestFile.trim()+"."+format));
		System.out.println("File path is: "+path);
	}
	
	public Map<String, String> getBarGraphReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToBarGraphReport(driver, param, test));	
		readingData.put(param.get("Step2"), getReorderQuestionReading(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReading(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReading(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		readingData.put(param.get("Step6"), getMakeAllChartReading(driver, param, test));
		
		return readingData;
		
	}
	
	public Map<String, String> getResponseTableReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToResponseTableReport(driver, param, test));
		readingData.put(param.get("Step2"), getReorderQuestionReading(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReading(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReading(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getIndividualReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToIndividualReport(driver, param, test));
		readingData.put(param.get("Step2"), getReorderQuestionReading(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReading(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReading(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		
		return readingData;

	}
	
	public Map<String, String> getFreqTableReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToFrequencyTableReport(driver, param, test));
		readingData.put(param.get("Step2"), getReorderQuestionReading(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReading(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReading(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		
		return readingData;

	}
	
	
	public Map<String, String> getConditionalReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (!(param.get("Comment").length() == 0)) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToConditionalReport(driver, param, test));
		readingData.put(param.get("Step2"), getSelectSurveyQuestionReadingOfConditional(driver, param, test));
		readingData.put(param.get("Step3"), getReorderQuestionReadingOfConditional(driver, param, test));	
		readingData.put(param.get("Step4"), getReportPropertyReadingOfConditional(driver, param, test));
		readingData.put(param.get("Step5"), getGenerateReadingOfConditional(driver, param, test));
		
		return readingData;

	}
	
	public Map<String, String> get2LvlCrossTabReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (!(param.get("Comment").length() == 0)) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToCrossTabReport(driver, param, test));
		readingData.put(param.get("Step2"), getReportPropertyReadingOf2LvlCrossTab(driver, param, test));
		readingData.put(param.get("Step3"), getFilterReadingOfCrossTab(driver, param, test));	
		readingData.put(param.get("Step4"), getGenerateReadingOfCrossTab(driver, param, test));
		
		return readingData;

	}
	
	public Map<String, String> get3LvlCrossTabReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (!(param.get("Comment").length() == 0)) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToCrossTabReport(driver, param, test));
		readingData.put(param.get("Step2"), getReportPropertyReadingOf3LvlCrossTab(driver, param, test));
		readingData.put(param.get("Step3"), getFilterReadingOfCrossTab(driver, param, test));	
		readingData.put(param.get("Step4"), getGenerateReadingOfCrossTab(driver, param, test));
		
		return readingData;

	}
	
	public Map<String, String> getPivotReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (!(param.get("Comment").length() == 0)) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToCrossTabReport(driver, param, test));
		readingData.put(param.get("Step2"), getReportPropertyReadingOfPivot(driver, param, test));
		readingData.put(param.get("Step3"), getFilterReadingOfCrossTab(driver, param, test));	
		readingData.put(param.get("Step4"), getGenerateReadingOfCrossTab(driver, param, test));
		
		return readingData;

	}
	
	public Map<String, String> getVerbatimReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (!(param.get("Comment").length() == 0)) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToVerbatimReport(driver, param, test));
		readingData.put(param.get("Step2"), getReorderQuestionReadingOfVerbatim(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReadingOfVerbatim(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReadingOfVerbatim(driver, param, test));
		readingData.put(param.get("Step5"), getGroupingQuestionReadingOfVerbatim(driver, param, test));
		readingData.put(param.get("Step6"), getReportGenerationReading(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getAssessmentSummaryReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		readingData.put(param.get("Step1"), goToAssessmentSummaryReport(driver, param, test));
		readingData.put(param.get("Step2"), getReorderQuestionReading(driver, param, test));
		readingData.put(param.get("Step3"), getReportPropertyReading(driver, param, test));	
		readingData.put(param.get("Step4"), getFilterStepReading(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getResponseTrendReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		
		click(driver, testcaseName, legacy_reports, test);
		waitforElemPresent(driver, testcaseName, 30, legacy_reports_menu, test);
		
		//Capture page load time of Response Trend
		start = System.currentTimeMillis();	
		click(driver, testcaseName, response_trend, test);
		waitforElemPresent(driver, testcaseName, 30, response_trend_header, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		readingData.put(param.get("Step1"), strtotalTime);		
		return readingData;
	}
	
	public Map<String, String> getStatisticalReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToStatisticalReport(driver, param, test));
		readingData.put(param.get("Step2"), getRedorderReadingOfStatistical(driver, param, test));
		readingData.put(param.get("Step3"), getStatParameterReadingOfStatistical(driver, param, test));	
		readingData.put(param.get("Step4"), getSegmentReadingOfStatistical(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getReportGenerationReadingOfStatistical(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getStatisticalReportReadingWithSegmentAnswserOption(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToStatisticalReport(driver, param, test));
		readingData.put(param.get("Step2"), getRedorderReadingOfStatistical(driver, param, test));
		readingData.put(param.get("Step3"), getStatParameterReadingOfStatistical(driver, param, test));	
		readingData.put(param.get("Step4"), getSegmentReadingOfStatistical(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getStatReportGenReadingWithSegmentBased1Que(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getStatisticalReportReadingWithMoreThanOneSegQue(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToStatisticalReport(driver, param, test));
		readingData.put(param.get("Step2"), getRedorderReadingOfStatistical(driver, param, test));
		readingData.put(param.get("Step3"), getStatParameterReadingOfStatistical(driver, param, test));	
		readingData.put(param.get("Step4"), getSegmentReadingOfStatistical(driver, param, test));
		Thread.sleep(1000);
		readingData.put(param.get("Step5"), getStatReportGenReadingWithSegmentBasedOnMoreThan1Que(driver, param, test));
		
		return readingData;
	}
	
	public Map<String, String> getEngagementReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToEngagementReport(driver, param, test));
		readingData.put(param.get("Step2"), getEngagementQueReading(driver, param, test));
		readingData.put(param.get("Step3"), getDriverQueReading(driver, param, test));
		readingData.put(param.get("Step4"), geAdditionalQueReading(driver, param, test));
		readingData.put(param.get("Step5"), getCompositionAnalysisReading(driver, param, test));
		readingData.put(param.get("Step6"), getSegmentRepReading(driver, param, test));
		readingData.put(param.get("Step7"), getFilterReading(driver, param, test));
		readingData.put(param.get("Step8"), getPPTExportReading(driver, param, test));
		readingData.put(param.get("Step9"), getExcelExportReading(driver, param, test));
		
		
		return readingData;
	}
	
	public Map<String, String> getComparisonReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToComparisonReport(driver, param, test));
		readingData.put(param.get("Step2"), getRedorderReadingOfComparison(driver, param, test));
		readingData.put(param.get("Step3"), getDatasetReadingOfComparison(driver, param, test));
		readingData.put(param.get("Step4"), getReportPropertyReadingOfComparison(driver, param, test));
		readingData.put(param.get("Step5"), getReportGenerationReading(driver, param, test));
		
		
		return readingData;
	}
	
	public Map<String, String> getBallotBoxReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToBallotBoxReport(driver, param, test));
		readingData.put(param.get("Step2"), getBallotBoxPage2Reading(driver, param, test));
		readingData.put(param.get("Step3"), getBallotBoxPage3Reading(driver, param, test));
		readingData.put(param.get("Step4"), getBallotBoxPageGenReading(driver, param, test));
		
		
		return readingData;
	}
	
	public Map<String, String> getAdvPivotReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToAdvPivotReport(driver, param, test));
		readingData.put(param.get("Step2"), getAdvPivotPage2Reading(driver, param, test));
		readingData.put(param.get("Step3"), getAdvPivotPage3Reading(driver, param, test));
		readingData.put(param.get("Step4"), getAdvPivotPage4Reading(driver, param, test));
		readingData.put(param.get("Step5"), getAdvPivotPage5Reading(driver, param, test));
		readingData.put(param.get("Step6"), getReportGenerationReading(driver, param, test));
		
		
		return readingData;
	}
	
	public Map<String, String> getSegmentationReportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Map<String, String> readingData = new LinkedHashMap<String, String>();
		if (param.containsKey("Comment")) {
			readingData.put("Comment", param.get("Comment"));
		}
		readingData.put(param.get("Step1"), goToSegmentationReport(driver, param, test));
		readingData.put(param.get("Step2"), getSegmentationPage2Reading(driver, param, test));
		readingData.put(param.get("Step3"), getSegmentationPage3Reading(driver, param, test));
		readingData.put(param.get("Step4"), getSegmentationPage4Reading(driver, param, test));
		readingData.put(param.get("Step5"), getSegmentationPage5Reading(driver, param, test));
		readingData.put(param.get("Step6"), getSegmentationPage6Reading(driver, param, test));
		readingData.put(param.get("Step7"), getSegmentationPage7Reading(driver, param, test));
		readingData.put(param.get("Step8"), getSegmentationPage8Reading(driver, param, test));
		
		
		return readingData;
	}
	
	public String goToSegmentationReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, segmentation_report, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_question_dd, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public String getSegmentationPage2Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectByVisibleText(driver, testcaseName, segmentation_question_dd, param.get("Segment question 1"), test);
		waitForLoad(driver, testcaseName, 30, test);
		click(driver, testcaseName, select_all_options, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button1, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_2_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage3Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(1000);
		scrollIntoCenter(driver, testcaseName, rearrange_toggle, test);
		click(driver, testcaseName, rearrange_toggle, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button22, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_3_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage4Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		scrollIntoCenter(driver, testcaseName, segmentation_report_page_3_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, segmentation_report_page_3_continue, 10, 200, test);
		
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, segmentation_report_page_3_continue, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_4_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage5Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		scrollIntoCenter(driver, testcaseName, segmentation_report_page_4_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, segmentation_report_page_4_continue, 10, 200, test);
		
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, segmentation_report_page_4_continue, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_5_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage6Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");

		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, segmentation_report_page_5_continue, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_6_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage7Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");

		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, segmentation_report_page_6_continue, test);
		waitforElemPresent(driver, testcaseName, 30, segmentation_report_page_7_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentationPage8Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		clearText(driver, testcaseName, email_segmentation_report, test);
		Thread.sleep(1000);
		setText(driver, testcaseName, email_segmentation_report, param.get("toEmail"), test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, request_received, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToAdvPivotReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, cross_dd, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_menu, test);
		
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, adv_piv, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, adv_pivot_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public String getAdvPivotPage2Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, adv_pivot_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, adv_pivot_page_2_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getAdvPivotPage3Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, adv_pivot_page_2_continue, 10, 200, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, adv_pivot_page_2_continue, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitForJStoLoad(driver, 10);
		waitforElemPresent(driver, testcaseName, 30, adv_pivot_page_3_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getAdvPivotPage4Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		scrollIntoCenter(driver, testcaseName, adv_pivot_page_3_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, adv_pivot_page_3_continue, 10, 200, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, adv_pivot_page_3_continue, test);
		waitForJStoLoad(driver, 10);
		waitforElemPresent(driver, testcaseName, 30, adv_pivot_page_4_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getAdvPivotPage5Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, adv_pivot_page_4_continue, test);
		waitforElemPresent(driver, testcaseName, 30, adv_pivot_page_5_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToBallotBoxReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, legacy_reports, test);
		waitforElemPresent(driver, testcaseName, 30, legacy_reports_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, ballot_box, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, ballot_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getBallotBoxPage2Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, ballot_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, ballot_page_2_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getBallotBoxPage3Reading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		setText(driver, testcaseName, duplicate_allowed_tb, param.get("Nmax"), test);
		start = System.currentTimeMillis();	
		click(driver, testcaseName, ballot_page_2_continue, test);
		waitforElemPresent(driver, testcaseName, 30, ballot_page_3_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getBallotBoxPageGenReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, generate_button, 10, 200, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, generate_button, test);
		waitforElemPresent(driver, testcaseName, 30, ballot_box_ip_table, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	
	public String goToComparisonReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, legacy_reports, test);
		waitforElemPresent(driver, testcaseName, 30, legacy_reports_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, comparison, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, comparison_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getRedorderReadingOfComparison(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_questions, test);
		//scrollIntoCenter(driver, testcaseName, statistical_page_1_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, comparison_page_1_continue, 10, 200, test);

		start = System.currentTimeMillis();	
		click(driver, testcaseName, comparison_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, comparison_page_2_descr, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getDatasetReadingOfComparison(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, comparison_page_2_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, comparison_page_2_continue, 10, 200, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, comparison_page_2_continue, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, comparison_page_3_descr, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getReportPropertyReadingOfComparison(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		String[] queArray = param.get("Condition que 1").split("/~/");
		String[] operandArray = param.get("Condition que 1 operand").split("/~/");
		String[] ansArray = param.get("Condition que 1 answers").split("/~/");
		
//		Select selDataSetCount = new Select(getWebElement(driver, testcaseName, select_dataset_count, test));
//		selDataSetCount.selectByValue(param.get("datasetCount"));
		selectByVisibleText(driver, testcaseName, select_dataset_count, param.get("datasetCount"), test);
		waitForJStoLoad(driver, 30);
		waitForLoad(driver, testcaseName, 30, test);
		
		//Execute a loop based on no of data set in given resource excel
		for(int i = 0; i < Integer.parseInt(param.get("datasetCount")); i++){
			scrollIntoCenter(driver, testcaseName, By.xpath("//input[contains(@id,'rdCondition1_"+(i+1)+"')]"), "Dataset "+(i+1)+" toggle", test);
			//Thread.sleep(500);
			click(driver, testcaseName, By.xpath("//input[contains(@id,'rdCondition1_"+(i+1)+"')]"), "Dataset "+(i+1)+" toggle", test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//div[contains(@id,'dvQuestiondd_"+(i+1)+"')]"), "Dataset "+(i+1)+" Question Drop Down", test);
			click(driver, testcaseName, By.xpath("//div[contains(@id,'dvQuestiondd_"+(i+1)+"')]"), "Dataset "+(i+1)+" Question Drop Down", test);
			
			WebElement conditionalQue = driver.findElement(By.xpath("(//div[contains(text(), \""+ queArray[i] + "\")])["+(i+1)+"]"));
			scrollIntoCenter(driver, testcaseName, conditionalQue, queArray[i], test);
			//Thread.sleep(1000);
			click(driver, testcaseName, conditionalQue, queArray[i], test);
			waitForJStoLoad(driver, 30);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[contains(@id,'cmbCondition"+(i+1)+"')]"), "Dataset "+(i+1)+" - Operand Drop Down", test);
			selectByVisibleText(driver, testcaseName, By.xpath("//select[contains(@id,'cmbCondition"+(i+1)+"')]"), operandArray[i], test);
			selectByVisibleText(driver, testcaseName, By.xpath("//select[contains(@id,'cmbAnswer"+(i+1)+"')]"), ansArray[i], test);

			
			click(driver, testcaseName, By.xpath("//input[contains(@id,'btnAddCondition"+(i+1)+"')]"), "Dataset "+(i+1)+" - Add Condition button", test);
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//td/div[contains(text(),\"" + queArray[i] + "\")]"), 
					"Show Condition -" +queArray[i], 30, 200, test);
			
		}
		scrollIntoCenter(driver, testcaseName, comparison_page_3_continue, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, comparison_page_3_continue, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, comparison_page_4_descr, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	
	public String goToEngagementReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, special_reports, test);
		waitforElemPresent(driver, testcaseName, 30, special_reports_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, engagement, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_wizard_step1_page_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getEngagementQueReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		setText(driver, testcaseName, nmax, param.get("Nmax"), test);
		
		//Capture page load time of Engagement question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button11, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getDriverQueReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] arrayQuestion = param.get("Engagement questions").split(";");
		
		for(String strQuestion : arrayQuestion) {
			scrollIntoCenter(driver, testcaseName, By.xpath("(//label[contains(text(),'"+strQuestion+"')])[1]"), strQuestion, test);
			Thread.sleep(500);
			click(driver, testcaseName, By.xpath("(//label[contains(text(),'"+strQuestion+"')])[1]"), strQuestion, test);
		}
		scrollIntoCenter(driver, testcaseName, continue_button22, test);
		Thread.sleep(200);
		//Capture page load time of Driver question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button22, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions5, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String geAdditionalQueReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] arrayQuestion = param.get("Driver questions").split(";");
		
		for(String strQuestion : arrayQuestion) {
			scrollIntoCenter(driver, testcaseName, By.xpath("(//label[contains(text(),'"+strQuestion+"')])[2]"), strQuestion, test);
			Thread.sleep(500);
			click(driver, testcaseName, By.xpath("(//label[contains(text(),'"+strQuestion+"')])[2]"), strQuestion, test);
		}
		scrollIntoCenter(driver, testcaseName, continue_button4, test);
		Thread.sleep(500);
		//Capture page load time of Driver question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button4, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_additional_question, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String getCompositionAnalysisReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		//Capture page load time of Composition analysis question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button44, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_composition_question, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getSegmentRepReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		//Capture page load time of Segment question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button5, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_segment_question, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getFilterReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		//Capture page load time of Filter  question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, continue_button6, test);
		waitforElemPresent(driver, testcaseName, 30, engagement_filter_question, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getPPTExportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, generate_now_button_2, test);
		waitforElemPresent(driver, testcaseName, 30, export_to_PPT, test);
		
		//Capture load time of PPT export
		start = System.currentTimeMillis();	
		click(driver, testcaseName, export_to_PPT, test);
		validateDownloadFile(System.getProperty("user.dir")+"\\src\\main\\resources\\downloadfiles\\", "pptx");
		//end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getExcelExportReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, generate_now_button_2, test);
		waitforElemPresent(driver, testcaseName, 30, export_to_ecxel, test);
		
		//Capture load time of PPT export
		start = System.currentTimeMillis();	
		click(driver, testcaseName, export_to_ecxel, test);
		validateDownloadFile(System.getProperty("user.dir")+"\\src\\main\\resources\\downloadfiles\\", "xlsx");
		//end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	

	private String validateDownloadFile(String downloadDir, String fileExtension)
	{	
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 300000; 
		try 
		{					
			Path downloadFolderPath = Paths.get(downloadDir);
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do 
			{
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}
				
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					Kind<?> kind = event.kind();
					if(kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
						String fileName = event.context().toString();
						System.out.println("New File Created:" + fileName);
						if(fileName.endsWith(fileExtension)) {
							downloadedFileName = fileName;
							System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " +fileName);
							end = System.currentTimeMillis();
							System.out.println("File is downloaded in "+(end-start)/1000 +" seconds");
							Thread.sleep(100);
							found = true;
							break;
						}
					}
				}
				
				if(found)
				{
					return downloadedFileName;
				}
				else
				{
					currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		}
		catch (Exception e)
		{
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}

	
	
	
	
	public String goToStatisticalReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, legacy_reports, test);
		waitforElemPresent(driver, testcaseName, 30, legacy_reports_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, statistical, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, statistical_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getRedorderReadingOfStatistical(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_questions, test);
		//scrollIntoCenter(driver, testcaseName, statistical_page_1_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, statistical_page_1_continue, 10, 200, test);

		start = System.currentTimeMillis();	
		click(driver, testcaseName, statistical_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, statistical_page_2_descr, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getStatParameterReadingOfStatistical(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, statistical_page_2_continue, test);
		Thread.sleep(1000);
		waitForElementToBeVisible(driver, testcaseName, statistical_page_2_continue, 10, 200, test);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, statistical_page_2_continue, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//span[contains(text(),'Choose statistical parameters.')]"), 
				"Statistical Report - Select Parameter Page Description", 30, 200, test);
		waitForJStoLoad(driver, 30);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String getSegmentReadingOfStatistical(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");

		waitForElementToBeVisible(driver, testcaseName, statistical_page_3_continue, 10, 200, test);

		start = System.currentTimeMillis();	
		click(driver, testcaseName, statistical_page_3_continue, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("(//span[contains(text(),'Segment Selection')])[1]"), 
				"Statistical Report - Select Parameter Page Description", 30, 200, test);
		waitForJStoLoad(driver, 30);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getReportGenerationReadingOfStatistical(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
				
		// Capture page load time of Generate report
		start = System.currentTimeMillis();
		click(driver, testcaseName, statistical_generate_button, test);

		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, statistical_trend_header, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);

		return strtotalTime;
	}
	
	public String getStatReportGenReadingWithSegmentBased1Que(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, statistical_based_on_one_question, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//select[@id='cmbOnesegQue']"), "Select Segment Question Drop down", 
				30, 200, test);
		
		Select selSegmentque = new Select(getWebElement(driver, testcaseName, select_statistical_segment_question, test));
		List<WebElement> listOfOptions = selSegmentque.getOptions();
		String selValue = null;
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Segment question 1"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selSegmentque.selectByValue(selValue);
		System.out.println(param.get("Segment question 1"));
//		selectByVisibleText(driver, testcaseName, select_statistical_segment_question, param.get("Segment question 1"), test);
		waitforElemPresent(driver, testcaseName, 30, statistical_segment_ans_options, test);
		
		scrollIntoCenter(driver, testcaseName, statistical_generate_now_button, test);
		waitForElementToBeVisible(driver, testcaseName, statistical_generate_now_button, 30, 200, test);
		start = System.currentTimeMillis();
		click(driver, testcaseName, statistical_generate_now_button, test);

		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, statistical_trend_header, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getStatReportGenReadingWithSegmentBasedOnMoreThan1Que(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, statistical_based_on_more_than_one_question, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//input[@id='txtsegmentName1']"), "Segment 1 Text Box", 
				30, 200, test);
		setText(driver, testcaseName, By.xpath("//input[@id='txtsegmentName1']"),  param.get("Segment 1 name"), "Segment 1 Text Box", test);
		
		//Add first condition
		click(driver, testcaseName, statistical_segment_1_drop_down, test);
		WebElement segmentQue = driver
				.findElement(By.xpath("//div[contains(text(),'" + param.get("Segment question 1") + "')]"));
		scrollIntoCenter(driver, testcaseName, segmentQue, param.get("Segment question 1"), test);
		Thread.sleep(1000);
		click(driver, testcaseName, segmentQue, param.get("Segment question 1"), test);

		waitforElemPresent(driver, testcaseName, 30, select_segment_1_operand, test);
		selectByVisibleText(driver, testcaseName, select_segment_1_operand, param.get("Segment ques 1 operand"), test);
		
		waitforElemPresent(driver, testcaseName, 30, select_segment_1_answer, test);
		selectByVisibleText(driver, testcaseName, select_segment_1_answer, param.get("Segment ques 1 answers"), test);

		click(driver, testcaseName, statistical_add_condition_1, test);
		
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//td/div[contains(text(),'" + param.get("Segment question 1") + "')]"), 
				"Show Condition -" +param.get("Segment question 1"), 30, 200, test);

		scrollIntoCenter(driver, testcaseName, statistical_generate_button, test);
		waitForElementToBeVisible(driver, testcaseName, statistical_generate_button, 30, 200, test);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, statistical_generate_button, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 60, statistical_trend_header, test);			
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		
		return strtotalTime;
	}
	
	
	
	
	
	
	public String goToAssessmentSummaryReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, assessment_summary, -50, 0, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, assessment_summary_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToVerbatimReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, verbatim, -50, 0, test);
		waitForLoad(driver, testcaseName, 60, test);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_1_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToCrossTabReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, cross_dd, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, cross_tab, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_2lvl, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public String getReportPropertyReadingOf2LvlCrossTab(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String selValue = null;
		
		Select selStub = new Select(getWebElement(driver, testcaseName, select_stub, test));
		List<WebElement> listOfOptions = selStub.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Stub"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selStub.selectByValue(selValue);
		
		Select selBanner = new Select(getWebElement(driver, testcaseName, select_banner, test));
		listOfOptions = selBanner.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Banner"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selBanner.selectByValue(selValue);
		
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, wizard_step1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_step2_page_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public String getReportPropertyReadingOf3LvlCrossTab(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String selValue = null;
		
		click(driver, testcaseName, cross_tab_3lvl, test);
		waitforElemPresent(driver, testcaseName, 30, select_parent, test);
		
		Select selParent = new Select(getWebElement(driver, testcaseName, select_parent, test));
		List<WebElement> listOfOptions = selParent.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Parent"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selParent.selectByValue(selValue);
		
		Select selStub = new Select(getWebElement(driver, testcaseName, select_stub, test));
		listOfOptions = selStub.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Stub"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selStub.selectByValue(selValue);
		
		Select selBanner = new Select(getWebElement(driver, testcaseName, select_banner, test));
		listOfOptions = selBanner.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Banner"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selBanner.selectByValue(selValue);
		
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, wizard_step1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_step2_page_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	
	public String getReportPropertyReadingOfPivot(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String selValue = null;
		
		click(driver, testcaseName, pivot_table, test);
		waitforElemPresent(driver, testcaseName, 30, pivot_table_questions, test);
		
		Select selStub = new Select(getWebElement(driver, testcaseName, select_pivot_stub, test));
		List<WebElement> listOfOptions = selStub.getOptions();
		for(WebElement option : listOfOptions) {
			if(option.getAttribute("innerHTML").contains(param.get("Stub"))) {
				selValue = option.getAttribute("value");
				break;
			}
		}
		selStub.selectByValue(selValue);
		String[] reqQues = param.get("Banner").split("\\|");
		List<WebElement> questionList = getWebElements(driver, testcaseName, pivot_table_questions_row, test);
		
		for(String strQue : reqQues) {
			for(WebElement question : questionList) {
				String qtext = Jsoup.parse(question.getAttribute("innerHTML")).text();
				if (qtext.contains(strQue)) {
					scrollIntoCenter(driver, testcaseName, question, qtext, test);
					waitforElemPresent(driver, testcaseName, 30, question, qtext, test);
					click(driver, testcaseName, question, qtext, test);
					break;
				}
			}
		}
				
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		
		start = System.currentTimeMillis();	
		click(driver, testcaseName, wizard_step1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, cross_tab_step2_page_descr, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	
	public String getFilterReadingOfCrossTab(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		scrollIntoCenter(driver, testcaseName, wizard_step2_continue_2, test);
		Thread.sleep(1000);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, wizard_step2_continue_2, test);
		waitforElemPresent(driver, testcaseName, 30, generate_now_button_2, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	public String getGenerateReadingOfCrossTab(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, generate_now_button_2, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 60, survey_metric, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	
	
	public String goToBarGraphReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, frequency, test);
		waitforElemPresent(driver, testcaseName, 30, frequency_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, bar_graph, -50, 0, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	/*
	 * Capture the load time of Make all chart similar
	 */
	public String getMakeAllChartReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		List<WebElement> chartDropdown = getWebElements(driver, testcaseName, bar_graph_chart_dropdown, test);
		
		if (chartDropdown.size() > 0) {
			scrollIntoCenter(driver, testcaseName, chartDropdown.get(0), "Chart drop of first question", test);
			Thread.sleep(1000);
			click(driver, testcaseName, chartDropdown.get(0), "Chart drop of first question", test);
			waitforElemPresent(driver, testcaseName, 10, bar_graph_chart_menu, test);
			List<WebElement> advChart = getWebElements(driver, testcaseName, bar_graph_adv_chart_option, test);
			click(driver, testcaseName, advChart.get(0), "Advance chart of first question", test);
			waitforElemPresent(driver, testcaseName, 60, bar_graph_adv_chart, test);
			
			List<WebElement> makeAllChartSimilar = getWebElements(driver, testcaseName, bar_graph_make_all_chart_similar, test);
			click(driver, testcaseName, makeAllChartSimilar.get(0), "Make all chart similar from first question", test);
			start = System.currentTimeMillis();
			driver.switchTo().alert().accept();
			waitForLoad(driver, testcaseName, 60, test);
			waitforElemPresent(driver, testcaseName, 30, survey_metric, test);
			end = System.currentTimeMillis();
			totalTime = ((end - start)) / 1000;
			strtotalTime = df.format(totalTime);
		}
		return strtotalTime;	
	}
	
	
	public String goToResponseTableReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, response_table_report, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String goToIndividualReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, raw_data, test);
		waitforElemPresent(driver, testcaseName, 30, raw_data_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, individual_report, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String goToFrequencyTableReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, legacy_reports, test);
		waitforElemPresent(driver, testcaseName, 30, legacy_reports_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		click(driver, testcaseName, frequency_table, test);
		waitforElemPresent(driver, testcaseName, 30, wizard_page_description, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String goToConditionalReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, frequency, test);
		waitforElemPresent(driver, testcaseName, 30, frequency_menu, test);
		
		//Capture page load time of All question
		start = System.currentTimeMillis();	
		clickAtOffset(driver, testcaseName, conditional, -50, 0, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, conditional_question_dropdown, test);
		end = System.currentTimeMillis();	
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
	
		return strtotalTime;
	}
	
	
	
	/**
	 * Capture page load time of Reorder question step. This method can be use in Bar graph, Response table, Individual report, Frequency table report, Assessment Summary Report
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReorderQuestionReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_questions, test);
		scrollIntoCenter(driver, testcaseName, wizard_step1_continue, test);
		Thread.sleep(1000);
		if (driver.getTitle().contains("Bar Graph") || driver.getTitle().contains("Response Table") || driver.getTitle().contains("Individual") || driver.getTitle().contains("Assessment Summary")) {
			scrollIntoCenter(driver, testcaseName, rearrange_toggle, test);
			Thread.sleep(1000);
			click(driver, testcaseName, rearrange_toggle, test);
			Thread.sleep(1000);
		}
		//Capture page load time of Reorder question step
		start = System.currentTimeMillis();	
		click(driver, testcaseName, wizard_step1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, reorder_page_description, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture page load time of Reorder question step. This method can be use in Verbatim Report
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReorderQuestionReadingOfVerbatim(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(1000);
		scrollIntoCenter(driver, testcaseName, verbatim_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_1_continue, test);
		
		//Capture page load time of Reorder question step
		start = System.currentTimeMillis();	
		click(driver, testcaseName, verbatim_page_1_continue, test);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_2_descr, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture the page load time of Report property step. This method can be use in Bar graph, Response table , Individual report,  Frequency table report, Assessment Summary Report
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReportPropertyReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		// scrollIntoCenter(driver, testcaseName, wizard_step2_continue, test);
		executeScript(driver, testcaseName, "window.scrollTo(0,document.body.scrollHeight)", test);
		Thread.sleep(1000);

		// Capture page load time of Report Properties step
		
		if (driver.getTitle().contains("Bar Graph") || driver.getTitle().contains("Response Table") || driver.getTitle().contains("Individual")
				|| driver.getTitle().contains("Assessment Summary")) {
			start = System.currentTimeMillis();
			click(driver, testcaseName, wizard_step2_continue, test);
		}else {
			start = System.currentTimeMillis();
			click(driver, testcaseName, wizard_step2_continue_2, test);
		}
		waitforElemPresent(driver, testcaseName, 30, wizard_step3_continue, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture the page load time of Report property step. This method can be use in Verbatim Report
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReportPropertyReadingOfVerbatim(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		scrollIntoCenter(driver, testcaseName, verbatim_page_2_continue, test);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_2_continue, test);

		// Capture page load time of Report Properties step
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, verbatim_page_2_continue, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitForJStoLoad(driver, 30);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_3_continue, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture page load time of Filter step. This method can be use in Bar graph, Response table  Individual report,  Frequency table report, Assessment Summary Report
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getFilterStepReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");	
		//Capture page load time of Filter step
		start = System.currentTimeMillis();
		click(driver, testcaseName, wizard_step3_continue, test);
		if (driver.getTitle().contains("Bar Graph") || driver.getTitle().contains("Response Table") || driver.getTitle().contains("Individual")  
				|| driver.getTitle().contains("Assessment Summary")) {
			waitforElemPresent(driver, testcaseName, 30, generate_now_button, test);
		}else {
			waitforElemPresent(driver, testcaseName, 30, generate_now_button_2, test);
		}
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture page load time of Filter step. This method can be use in Verbatim
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getFilterStepReadingOfVerbatim(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");	
		//Capture page load time of Filter step
		start = System.currentTimeMillis();
		click(driver, testcaseName, verbatim_page_3_continue, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, verbatim_page_4_continue, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture page load time of Grouping question step. This method can be use in Verbatim
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getGroupingQuestionReadingOfVerbatim(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		if (param.containsKey("Filter Name")) {
			click(driver, testcaseName, verbatim_filter_toggle, test);
			waitforElemPresent(driver, testcaseName, 30, select_verbatim_filter, test);
			Select selFilter = new Select(getWebElement(driver, testcaseName, select_verbatim_filter, test));
			selFilter.selectByVisibleText(param.get("Filter Name"));
			waitForElementToBeVisible(driver, testcaseName, By.xpath("//td[text()='"+param.get("Filter Name")+"']"), param.get("Filter Name"), 30, 200, test);
		}
		start = System.currentTimeMillis();
		click(driver, testcaseName, verbatim_page_4_continue, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, generate_now_button_2, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	/**
	 * Capture the page load time of report generation. This method can be use in Bar graph, Response table, 
	 * Individual report, Frequency table report, Verbatim Report, Comparison report, Advance Pivot report.
	 * @param driver
	 * @param param
	 * @param test
	 * @return
	 * @throws InterruptedException
	 */
	public String getReportGenerationReading(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		//Add Grouping Question in case of Verbatim Report.
		if (driver.getTitle().contains("Verbatim")){
			if (param.containsKey("Grouping question")) {
				String selValue = null;
				click(driver, testcaseName, verbatim_grouping_toggle, test);
				waitforElemPresent(driver, testcaseName, 30, select_verbatim_grouping, test);
				Select selGrouping = new Select(getWebElement(driver, testcaseName, select_verbatim_grouping, test));
				List<WebElement> listOfOptions = selGrouping.getOptions();
				for(WebElement option : listOfOptions) {
					if(Jsoup.parse(option.getAttribute("innerHTML")).text().contains(param.get("Grouping question"))) {
						selValue = option.getAttribute("value");
						break;
					}
				}
				selGrouping.selectByValue(selValue);
			}
		}
			
		//Capture page load time of Generate report
		if (driver.getTitle().contains("Bar Graph") || driver.getTitle().contains("Response Table") || driver.getTitle().contains("Individual")
				|| driver.getTitle().contains("Assessment Summary")) {
			start = System.currentTimeMillis();
			click(driver, testcaseName, generate_now_button, test);
		} else {
			start = System.currentTimeMillis();
			click(driver, testcaseName, generate_now_button_2, test);
		}
		waitForLoad(driver, testcaseName, 120, test);
		waitforElemPresent(driver, testcaseName, 120, survey_metric, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	public String getSelectSurveyQuestionReadingOfConditional(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		//Add first condition
		click(driver, testcaseName, conditional_question_dropdown, test);
		WebElement conditionalQue = driver.findElement(By.xpath("//div[contains(text(),'" + param.get("Condition que 1") + "')]"));
		scrollIntoCenter(driver, testcaseName, conditionalQue, param.get("Condition que 1"), test);
		Thread.sleep(1000);
		click(driver, testcaseName, conditionalQue, param.get("Condition que 1"), test);
		
		waitforElemPresent(driver, testcaseName, 30, select_condition_operand, test);
		Select selConditionOperand = new Select(getWebElement(driver, testcaseName, select_condition_operand, test));
		selConditionOperand.selectByVisibleText(param.get("Condition que 1 operand"));
		
		waitforElemPresent(driver, testcaseName, 30, select_condition_operand, test);
		Select selConditionAnswers = new Select(getWebElement(driver, testcaseName, select_condition_answers, test));
		selConditionAnswers.selectByVisibleText(param.get("Condition que 1 answers"));
		
		click(driver, testcaseName, add_condition, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//td[contains(text(),'" + param.get("Condition que 1") + "')]"), "Show Condition -" +param.get("Condition que 1"), 30, 200, test);
		
		//Add 2nd condition
		click(driver, testcaseName, conditional_question_dropdown, test);
		conditionalQue = driver.findElement(By.xpath("//div[contains(text(),'" + param.get("Condition que 2") + "')]"));
		scrollIntoCenter(driver, testcaseName, conditionalQue, param.get("Condition que 2"), test);
		Thread.sleep(1000);
		click(driver, testcaseName, conditionalQue, param.get("Condition que 2"), test);
		
		Thread.sleep(1000);
		selConditionOperand = new Select(getWebElement(driver, testcaseName, select_condition_operand, test));
		selConditionOperand.selectByVisibleText(param.get("Condition que 2 operand"));
		
		selConditionAnswers = new Select(getWebElement(driver, testcaseName, select_condition_answers, test));
		selConditionAnswers.selectByVisibleText(param.get("Condition que 2 answers"));
		
		click(driver, testcaseName, add_condition, test);
		waitForElementToBeVisible(driver, testcaseName, By.xpath("//td[contains(text(),'" + param.get("Condition que 2") + "')]"), "Show Condition -" +param.get("Condition que 2"), 30, 200, test);
		
		if (param.get("Logic").contains("Any")) {
			scrollIntoCenter(driver, testcaseName, conditional_match_any_condition, test);
			Thread.sleep(1000);
			click(driver, testcaseName, conditional_match_any_condition, test);
		}
		scrollIntoCenter(driver, testcaseName, conditional_report_step_1, test);
		Thread.sleep(1000);
		
		start = System.currentTimeMillis();
		click(driver, testcaseName, conditional_report_step_1, test);
		waitforElemPresent(driver, testcaseName, 30, all_questions, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		
		return strtotalTime;
	}
	
	
	public String getReorderQuestionReadingOfConditional(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		click(driver, testcaseName, all_questions, test);
		Thread.sleep(1000);
				
		start = System.currentTimeMillis();
		click(driver, testcaseName, conditional_report_step_2, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, reorder_page_description, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getReportPropertyReadingOfConditional(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		scrollIntoCenter(driver, testcaseName, conditional_report_step_3, test);
		Thread.sleep(1000);
				
		start = System.currentTimeMillis();
		click(driver, testcaseName, conditional_report_step_3, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, conditional_generate_button, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	public String getGenerateReadingOfConditional(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
				
		start = System.currentTimeMillis();
		click(driver, testcaseName, conditional_generate_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, survey_metric, test);
		end = System.currentTimeMillis();
		totalTime = ((end - start)) / 1000;
		strtotalTime = df.format(totalTime);
		
		return strtotalTime;
	}
	
	
	
	
	
}



