package pageobjects;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
import testsuitebase.SuiteBase;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.SuiteUtility;

public class RMXPage extends SeleniumUtils implements IRMXPage{
	

	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	
	public String getDownloadedDocumentName(String downloadDir, String fileExtension)
	{	
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 20; 
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
							System.out.println("File is downloaded in "+(System.currentTimeMillis()-startTime)/1000 +" seconds");
							Thread.sleep(500);
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
	 * Capture the page load time of report generation. This method can be use in Bar graph, Response table, Individual report, Frequency table report, Verbatim Report.
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



