package pageobjects;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.WebPageElements;

public class RMXPage extends SeleniumUtils implements IRMXPage, IHomePage {
	

	public double finish, start;
	public double end;
	
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
//		
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[contains(text(),'This report has been saved as ')]"), "This report has been saved as ", test);
		
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
	                waitforElemPresent(driver, testcaseName, 30, download_word_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_all;
	                break;
	            case 2:
	                System.out.println("Tuesday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_all;
	                break;
	            case 3:
	                System.out.println("Wednesday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_WORD))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_word_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_all;
	                break;
	            case 4:
	                System.out.println("Thursday");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_all;
	                break;
	            case 5:
	                System.out.println("Friday");
	                waitforElemPresent(driver, testcaseName, 30, download_word, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_WORD))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_word_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "docx";
	        		download_report = download_word_all;
	                break;
	            default:
	                System.out.println("Weekend");
	                waitforElemPresent(driver, testcaseName, 30, download_excel4, test);
	                action.moveToElement(driver.findElement(By.xpath(DOWNLOAD_EXCEL4))).build().perform();
	                waitforElemPresent(driver, testcaseName, 30, download_excel_all, test);
//	        		click(driver, testcaseName, download_word, test);
	        		waitForLoad(driver, testcaseName, 30, test);
	        		format = "xls";
	        		download_report = download_excel_all;
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
	
	
	}



