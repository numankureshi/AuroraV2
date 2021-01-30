package pageobjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
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

public class RMXPage extends SeleniumUtils implements IRMXPage{
	

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
	
	
	}



