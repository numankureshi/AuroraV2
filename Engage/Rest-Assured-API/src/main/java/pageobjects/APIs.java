package pageobjects;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import groovyjarjarantlr4.v4.runtime.Parser.TrimToSizeListener;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testsuitebase.TestResultStatus;
import utility.JSONUtility;

public class APIs extends JSONUtility{
	
	private String outputJsonPath = "";
	public HashMap<String, Object> responseData = new HashMap<String, Object>();
	
	public HashMap<String, Object> getSurveyURL(HashMap<String, String> param, String baseURL, String apiToken, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		String surveyNo = param.get("surveyNo");
		String path = param.get("path");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_getSurveyURL.json", test);
			
		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString());		// Add the Json string to the body of the request
		Response response = request.post(path); 		// Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());	
		
		//Validate the status code
		if(response.getStatusCode() == 200) {
			String actualSurveyURL = response.jsonPath().get("Data");
			String expectedSurveyURL = param.get("ExpectedResult");
			try {
				Assert.assertEquals(actualSurveyURL, expectedSurveyURL, "Survye URL received in API is wrong");
			} catch (AssertionError e) {
				test.log(Status.FAIL,"Assertion error occured : "+e.getMessage());
				Add_Log.info("Assertion error occured : "+e.getMessage());
				Reporter.log("Assertion error occured : "+e.getMessage());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured : "+e.getMessage());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
			Reporter.log("Survey URL has been verified for Survey ID : "+surveyNo +" : '" +response.jsonPath().get("Data")+"'");  // Add survey url in testNG report
			test.info("Survey URL has been verified for Survey ID : "+surveyNo +" : '" +response.jsonPath().get("Data")+"'");		// Add survey url in extent report
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}	
		return responseData;
	}
		
	public HashMap<String, Object> sendSurveyInvite(HashMap<String, String> param, String baseURL, String apiToken, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		String surveyNo = param.get("surveyNo");
		String path = param.get("path");
		String isSurveyActive = param.get("isSurveyActive");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		JsonObject additionalInfo = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendInvite.json", test);
		ArrayList<String> emailList = getEmailFromAdditionalInfoJson(param, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendInvite.json", test);
		Collections.reverse(emailList);
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.add("additionalinfo", additionalInfo);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_sendSurveyInvite.json", test);
		
		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString());		// Add the Json to the body of the request
		Date currentTime = Calendar.getInstance().getTime();  // Record the time at when API is called
		Response response = request.post(path); 		// Post the request and check the response
		
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		responseData.put("emailList", emailList);
		
		//Validate the status code
		if(response.getStatusCode() == 200) {
			if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")){
				//Validate emails received from Inbox
				getInviteURLFromEmail(param, currentTime, test);				
				Reporter.log("Invitation of Survey ID "+surveyNo +" were sent successfully to " +" : '" +response.jsonPath().get("Description")+"' participants. They are as follows : <br/> <b>"+emailList +"</b>");  // Add log in testNG report
				test.info("Invitation of Survey ID "+surveyNo +" were sent successfully to " +" : '" +response.jsonPath().get("Description")+"' participants. They are as follows : <br/> <b>"+emailList +"</b>");		// Add log in extent report
			}else if (isSurveyActive.equalsIgnoreCase("N") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Error") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey Expired")){
				Reporter.log("Survey ID " +surveyNo+" is expired. Hence, invitations were not sent to following email ids, <br/> <b>" +emailList +"</b> <br/>"+response.getBody().asPrettyString());  // Add log in testNG report
				test.info("Survey ID " +surveyNo+" is expired. Hence, invitations were not sent to following email ids, <br/> <b>" +emailList +"</b> <br/>"+response.getBody().asPrettyString());		// Add log in extent report
			}
			else {
				test.log(Status.FAIL,"Error received in API response : "+response.getBody().asPrettyString());
				Add_Log.info("Error received in API response : "+response.getBody().asPrettyString());
				Reporter.log("Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		return responseData;

	}
	
	public void validateExpiryDateFromTrackSurvey(HashMap<String, String> param, ArrayList<String> emailList, ExtentTest test) throws ParseException {
		String testcaseName = param.get("TestCaseName");

		JsonObject jsonTrackSurveyData = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\jsonTrackSurveyData.json", test);
		JsonObject additionalInfo = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendInvite.json", test);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa", Locale.ENGLISH); //30-12-2020 06:56 PM
		
		for(int i=0; i<emailList.size(); i++) {
			String actualEmailSentTo = jsonTrackSurveyData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Email").getAsString();
			String expectedEmailSentTo = emailList.get(i);
			String sDate = jsonTrackSurveyData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Invitation Date").getAsString();
			String eDate = jsonTrackSurveyData.getAsJsonArray("Table").get(i).getAsJsonObject().get("URL Expiry").getAsString();
			long diffInMillies = Math.abs(dateFormat.parse(eDate).getTime() -dateFormat.parse(sDate).getTime());
		    long actualExpityDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		    long expectedExpiryDays = Long.parseLong(additionalInfo.get("InvitationExpiry").getAsJsonObject().get("Days").getAsString());
		    // Validate email sent to and expiry days value given in API by comparing them with platform
		    try {
		    	Assert.assertEquals(actualExpityDays, expectedExpiryDays, "Expiry days set in API is not matching it with platform!!");
		    	Assert.assertEquals(actualEmailSentTo, expectedEmailSentTo, "Email invitation sent from API are not found in TrackSurvey!!");
		    }catch(AssertionError e) {
		    	test.log(Status.FAIL,"Assertion error occured in :"+e.getMessage());
				Add_Log.info("Assertion error occured in :"+e.getMessage());
				Reporter.log("Assertion error occured in :"+e.getMessage());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured in :"+e.getMessage());
				TestResultStatus.TestFail = true;
				Assert.fail();						    							    	
		    }
		}
	}
	
	public HashMap<String, Object> sendSurveyInviteWithReminder(HashMap<String, String> param, String baseURL, String apiToken, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		String surveyNo = param.get("surveyNo");
		String inthour = param.get("inthour");
		String path = param.get("path");
		String isSurveyActive = param.get("isSurveyActive");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		JsonObject additionalInfo = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendInviteWithReminder.json", test);
		ArrayList<String> emailList = getEmailFromAdditionalInfoJson(param, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendInviteWithReminder.json", test);
		Collections.reverse(emailList);
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.add("additionalinfo", additionalInfo);
		requestParams.addProperty("inthour", inthour);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_sendSurveyInviteWithReminder.json", test);
		
		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString());		// Add the Json to the body of the request
		Date currentTime = Calendar.getInstance().getTime();  // Record the time at when API is called
		Response response = request.post(path); 		// Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		responseData.put("emailList", emailList);
		
		//Validate the status code
		if (response.getStatusCode() == 200) {
			if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
				// Validate emails received from Inbox
				getInviteURLFromEmail(param, currentTime, test);
				Reporter.log("Invitation of Survey ID " + surveyNo + " were sent successfully to " + " : '"
						+ response.jsonPath().get("Description") + "' participants along with reminders.. They are as follows : <br/> <b>"
						+ emailList + "</b>"); // Add log in testNG report
				test.info("Invitation of Survey ID " + surveyNo + " were sent successfully to " + " : '"
						+ response.jsonPath().get("Description") + "' participants along with reminders.. They are as follows : <br/> <b>"
						+ emailList + "</b>"); // Add log in extent report
			} else if (isSurveyActive.equalsIgnoreCase("N")
					&& response.jsonPath().get("Status").toString().equalsIgnoreCase("Error")
					&& response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey Expired")) {
				Reporter.log("Survey ID " + surveyNo
						+ " is expired. Hence, invitations were not sent to following email ids, <br/> <b>" + emailList
						+ "</b> <br/>" + response.getBody().asPrettyString()); // Add log in testNG report
				test.info("Survey ID " + surveyNo
						+ " is expired. Hence, invitations were not sent to following email ids, <br/> <b>" + emailList
						+ "</b> <br/>" + response.getBody().asPrettyString()); // Add log in extent report
			} else {
				test.log(Status.FAIL, "Error received in API response : " + response.getBody().asPrettyString());
				Add_Log.info("Error received in API response : " + response.getBody().asPrettyString());
				Reporter.log("Error received in API response : " + response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| " + "Error received in API response : "
						+ response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		} else {
			test.log(Status.FAIL, "Incorrect status code returned " + response.getStatusCode());
			Add_Log.info("Incorrect status code returned " + response.getStatusCode());
			Reporter.log("Incorrect status code returned " + response.getStatusCode());
			TestResultStatus.failureReason
					.add(testcaseName + "| " + "Incorrect status code returned " + response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}

		return responseData;

	}
	
	public void validateReminderPeriod(HashMap<String, String> param, ArrayList<String> emailList, ExtentTest test) throws ParseException {
		String testcaseName = param.get("TestCaseName");
		Collections.reverse(emailList);
		JsonObject jsonReminderData = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\jsonReminderData.json", test);
		JsonObject payload = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\payload_sendSurveyInviteWithReminder.json", test);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aaa", Locale.ENGLISH); //30-12-2020 06:56 PM
		
		long actualReminderPeriod = Long.parseLong(payload.get("inthour").getAsString());
		
		for(int i=0; i<emailList.size(); i++) {
			String actualEmailSentTo = jsonReminderData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Email").getAsString();
			String expectedEmailSentTo = emailList.get(i);
			String sDate = jsonReminderData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Original Invitation Date").getAsString();
			String eDate = jsonReminderData.getAsJsonArray("Table").get(i).getAsJsonObject().get("First Reminder Sent Date").getAsString();
			long diffInMillies = Math.abs(dateFormat.parse(eDate).getTime() -dateFormat.parse(sDate).getTime());
		    long expectedReminderPeriod = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS); //Get expected reminder period in hours 
		    // Validate email sent to and expiry days value given in API by comparing them with platform
		    try {
		    	Assert.assertEquals(actualReminderPeriod, expectedReminderPeriod, "Expiry days set in API is not matching it with platform!!");
		    	Assert.assertEquals(actualEmailSentTo, expectedEmailSentTo, "Email invitation sent from API are not found in TrackSurvey!!");
		    }catch(AssertionError e) {
		    	test.log(Status.FAIL,"Assertion error occured in :"+e.getMessage());
				Add_Log.info("Assertion error occured in :"+e.getMessage());
				Reporter.log("Assertion error occured in :"+e.getMessage());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured in :"+e.getMessage());
				TestResultStatus.TestFail = true;
				Assert.fail();						    							    	
		    }
		}
	}
	
	
	public HashMap<String, Object> sendSurveyReminder(HashMap<String, String> param, String baseURL, String apiToken, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		String surveyNo = param.get("surveyNo");
		String path = param.get("path");
		String isSurveyActive = param.get("isSurveyActive");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		JsonObject additionalInfo = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendReminder.json", test);
		ArrayList<String> emailList = getEmailFromAdditionalInfoJson(param, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendReminder.json", test);
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.add("additionalinfo", additionalInfo);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_sendSurveyReminder.json", test);
		
		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString());		// Add the Json to the body of the request
		Date currentTime = Calendar.getInstance().getTime();  // Record the time at when API is called
		Response response = request.post(path); 		// Post the request and check the response
		
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		
		//Validate the status code
		if(response.getStatusCode() == 200) {
			if (response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")){
				//Validate reminders from Inbox
				getInviteURLFromEmail(param, currentTime, test);
				Reporter.log("Reminder sent successfully to " +" : '" +response.jsonPath().get("Description")+"' participants from Survey ID "+surveyNo+". They are as follows <br/> <b>" +emailList +"</b>");  // Add log in testNG report
				test.info("Reminder sent successfully to " +" : '" +response.jsonPath().get("Description")+"' participants from Survey ID "+surveyNo+". They are as follows <br/> <b>" +emailList +"</b>");		// Add log in extent report
			}else if (isSurveyActive.equalsIgnoreCase("N") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Error") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey Expired")){
				Reporter.log("Survey ID " +surveyNo+" is expired. Hence, reminders were not sent to email ids, <br/> <b>" +emailList +"</b> <br/>"+response.getBody().asPrettyString());  // Add log in testNG report
				test.info("Survey ID " +surveyNo+" is expired. Hence, reminders were not sent to email ids, <br/> <b>" +emailList +"</b> <br/>"+response.getBody().asPrettyString());		// Add log in extent report
			}else {
				test.log(Status.FAIL,"Error received in API response : "+response.getBody().asPrettyString());
				Add_Log.info("Error received in API response : "+response.getBody().asPrettyString());
				Reporter.log("Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}

		return responseData;

	}
	
	public Response sendSurveyReminder(HashMap<String, String> param, String baseURL, String apiToken, String surveyNo, String path, ExtentTest test) throws InterruptedException  {
		String testcaseName = param.get("TestCaseName");
		JsonObject additionalInfo = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\additioninfo_SendReminder.json", test);
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();
		
		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.add("additionalinfo", additionalInfo);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_sendSurveyReminder.json", test);
		
		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString());		// Add the Json to the body of the request
		Response response = request.post(path); 		// Post the request and check the response

		return response;

	}
	

	
	public HashMap<String, Object> generateSurveyKey(HashMap<String, String> param, String apiToken,  ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String baseURL = param.get("baseURL");
		String surveyKeyURL = param.get("surveyKeyURL");
		String passwordType = param.get("passwordtype");
		String expiryDays = param.get("expirydays");
		String path = param.get("path");
		String isSurveyActive = param.get("isSurveyActive");
		String isUniquePassword = param.get("isUniquePassword");		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
			
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();
		JsonObject additionalInfo;
		if(isUniquePassword.equalsIgnoreCase("Y")) {
			additionalInfo = updateSurveyKeyPasswordFromJson(param, "\\src\\main\\resources\\jsonFiles\\additioninfo_GenerateSurveyKey.json", test);
		}else {
			additionalInfo = getAdditionalInfoJson(param, "\\src\\main\\resources\\jsonFiles\\additioninfo_GenerateSurveyKey.json", test);
		}
		
		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("baseurl", surveyKeyURL);
		requestParams.addProperty("passwordtype", passwordType);
		requestParams.add("additionalinfo", additionalInfo);
		requestParams.addProperty("expirydays", expiryDays);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_generateSurveyKey.json", test);

		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());		
		
		ArrayList<String> passwordList = getPaswordListFromAdditionalInfoJson(additionalInfo, test);
		Collections.reverse(passwordList);
		
		//Validate the status code
		if(response.getStatusCode() == 200) {
			if (isSurveyActive.equalsIgnoreCase("Y") && isUniquePassword.equalsIgnoreCase("Y") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success") && response.jsonPath().get("Description").toString().contains("You have successfully generated")){
				Reporter.log(response.jsonPath().get("Description") +" They are as follows <b>" +passwordList +"</b>.");  // Add log in testNG report
				test.info(response.jsonPath().get("Description") +" They are as follows <b>" +passwordList +"</b>.");		// Add log in extent report
			}
			else if(isSurveyActive.equalsIgnoreCase("N") && isUniquePassword.equalsIgnoreCase("Y") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Survey Expired.")) {
				Reporter.log("Survey is expired. Hence, survey passwords can't be generated.");  // Add log in testNG report
				test.info("Survey is expired. Hence, survey passwords can't be generated.");		// Add log in extent report	
			}else if (isSurveyActive.equalsIgnoreCase("Y") && isUniquePassword.equalsIgnoreCase("N") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success") && response.jsonPath().get("Description").toString().equalsIgnoreCase("No password left after removing duplicates and existing password")){
				Reporter.log("Duplicate survey passwords found for given baseurl <b>" +surveyKeyURL +"</b>. <br/> And passwords used here are : <b>" +passwordList +"</b>.");  // Add log in testNG report
				test.info("Duplicate survey passwords found for given baseurl <b>" +surveyKeyURL +"</b>. <br/> And passwords used here are : <b>" +passwordList +"</b>.");		// Add log in extent report
			}
			else {
				test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
				Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
				Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
		return responseData;

	}
	
	public void validateSurveyKeyPasswordFromTrackSurvey(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject jsonSAPData = readJSONFromFile(testcaseName,"\\src\\main\\resources\\jsonFiles\\jsonSAPData.json", test);
		JsonObject payload = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\payload_generateSurveyKey.json", test);
		ArrayList<String> passwordList = new ArrayList<String>();
		
		for (JsonElement password : payload.getAsJsonObject("additionalinfo").getAsJsonArray("Attributes")) {
			passwordList.add(password.getAsJsonObject().get("Password").getAsString());
		}
		Collections.reverse(passwordList);
		for(int i=0; i<passwordList.size(); i++) {
			int j = (payload.getAsJsonObject("additionalinfo").getAsJsonArray("Attributes").size());
			String actualPassword = jsonSAPData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Password").getAsString();
			String expectedPassword = passwordList.get(i);
			try {
				Assert.assertEquals(actualPassword, expectedPassword, "Survey password generated from API is not found in track survey!!");
				Reporter.log("<b>"+actualPassword +"</b> has been validated from track survey which is generated on <b>"+jsonSAPData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Generated On").getAsString() +"</b> with survey URL :<b>"+jsonSAPData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Survey Login URL").getAsString()+"</b>");  // Add log in testNG report
				test.info("<b>"+actualPassword +"</b> has been validated from track survey which is generated on <b>"+jsonSAPData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Generated On").getAsString() +"</b> with survey URL :<b>"+jsonSAPData.getAsJsonArray("Table").get(i).getAsJsonObject().get("Survey Login URL").getAsString()+"</b>");
				
			}catch(AssertionError e) {
				test.log(Status.FAIL,"Assertion error occured in :"+e.getMessage());
				Add_Log.info("Assertion error occured in :"+e.getMessage());
				Reporter.log("Assertion error occured in :"+e.getMessage());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured in :"+e.getMessage());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}
	}
		
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> reopenresponse(HashMap<String, String> param, String apiToken,  ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String baseURL = param.get("baseURL");
		String surveyNo = param.get("surveyNo");
		String stremailaddress = param.get("stremailaddress");
		String path = param.get("path");
		String participationStatus = param.get("participationStatus");
		String urlExpiry = param.get("urlExpiry");
		String anonymous = param.get("anonymous");
		String semiAnonymous = param.get("semiAnonymous");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.addProperty("stremailaddress", stremailaddress);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_reopenresponse.json", test);

		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		
		//Validate the status code
		if(response.getStatusCode() == 200) {
			if(anonymous.equalsIgnoreCase("Y") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Error") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Responses to Anonymous or Semi-Anonymous projects cannot be reopened.")) {
				Reporter.log("Survey ID <b>"+surveyNo+"</b> is an <b> anonymous survey </b>, hence survey can not be reopen for given email addresses.");  // Add log in testNG report
				test.info("Survey ID <b>"+surveyNo+"</b> is an <b> anonymous survey </b>, hence survey can not be reopen for given email addresses.");		// Add log in extent report				
			}else if(semiAnonymous.equalsIgnoreCase("Y") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Error") && response.jsonPath().get("Description").toString().equalsIgnoreCase("Responses to Anonymous or Semi-Anonymous projects cannot be reopened.")) {
				Reporter.log("Survey ID <b>"+surveyNo+"</b> is an <b> Semi-anonymous survey </b>, hence survey can not be reopen for given email addresses.");  // Add log in testNG report
				test.info("Survey ID <b>"+surveyNo+"</b> is an <b> Semi-anonymous survey </b>, hence survey can not be reopen for given email addresses.");		// Add log in extent report				
			}else if (anonymous.equalsIgnoreCase("N") && semiAnonymous.equalsIgnoreCase("N") && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")){
				ArrayList<Object> reopenStatus = response.jsonPath().get("ReopenStatus");
				String emailAddress = "";
				for(int i=0; i<reopenStatus.size(); i++) {
					HashMap<String, String> reopenData = (HashMap<String, String>) reopenStatus.get(i);
					if ((participationStatus.equalsIgnoreCase("Completed") || participationStatus.equalsIgnoreCase("Completed(Edited)")) && urlExpiry.equalsIgnoreCase("N") && reopenData.get("Status").equalsIgnoreCase("Success")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> has been reopened for email address : <b>" +emailAddress+"</b>.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> has been reopened for email address : <b>" +emailAddress+"</b>.");		// Add log in extent report
					}else if(participationStatus.equalsIgnoreCase("Incomplete") && urlExpiry.equalsIgnoreCase("N") && reopenData.get("Status").equalsIgnoreCase("Fail") && reopenData.get("Message").equalsIgnoreCase("Only completed single-use links can be reopened.")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as incomplete status has been recorded for same.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as incomplete status has been recorded for same.");		// Add log in extent report		
					}else if(participationStatus.equalsIgnoreCase("Incomplete (Edited)") && urlExpiry.equalsIgnoreCase("N") && reopenData.get("Status").equalsIgnoreCase("Fail") && reopenData.get("Message").equalsIgnoreCase("Only completed single-use links can be reopened.")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as incomplete (edited) status has been recorded for same.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as incomplete (edited) status has been recorded for same.");		// Add log in extent report		
					}else if(participationStatus.equalsIgnoreCase("Email delivered/Not Read") && urlExpiry.equalsIgnoreCase("N") && reopenData.get("Status").equalsIgnoreCase("Fail") && reopenData.get("Message").equalsIgnoreCase("Only completed single-use links can be reopened.")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Email delivered/Not Read status has been recorded for same.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Email delivered/Not Read status has been recorded for same.");		// Add log in extent report		
					}else if(participationStatus.equalsIgnoreCase("Bounced") && urlExpiry.equalsIgnoreCase("N") && reopenData.get("Status").equalsIgnoreCase("Fail") && reopenData.get("Message").equalsIgnoreCase("Only completed single-use links can be reopened.")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Bounced status has been recorded for same.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Bounced status has been recorded for same.");		// Add log in extent report		
					}else if(urlExpiry.equalsIgnoreCase("Y") && reopenData.get("Status").equalsIgnoreCase("Fail") && reopenData.get("Message").equalsIgnoreCase("Only completed single-use links can be reopened.")) {
						emailAddress = reopenData.get("EmailAddress");
						Reporter.log("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Survey invitation has been expired for same.");  // Add log in testNG report
						test.info("Survey ID <b>"+surveyNo+"</b> can not be reopened for email address : <b>" +emailAddress+"</b> as Survey invitation has been expired for same.");		// Add log in extent report		
					}else {
						test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
						Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
						Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
						TestResultStatus.failureReason.add(testcaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
						TestResultStatus.TestFail = true;
						Assert.fail();
						}
					}
				}
		}
		else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}

		return responseData;

	}
	
	public Response getParticipationStatusInfo(HashMap<String, String> param, String baseURL, String apiToken, String surveyNo, String stremailaddress, String issurveyaccesscodes,String path, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.addProperty("stremailaddress", stremailaddress);
		requestParams.addProperty("issurveyaccesscodes", issurveyaccesscodes);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_getParticipationStatusInfo.json", test);

		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response

		return response;

	}
	
	public Response getSurveyList(HashMap<String, String> param, String baseURL, String apiToken, String path, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("token", apiToken);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_getSurveyList.json", test);


		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response

		return response;

	}
		
	public HashMap<String, Object> getData(HashMap<String, String> param, String apiToken,  ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String baseURL = param.get("baseURL");
		String surveyNo = param.get("surveyNo");
		String intstartno = param.get("intstartno");
		String intendno = param.get("intendno");
		String path = param.get("path");
		
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("intsurveyno", surveyNo);
		requestParams.addProperty("intstartno", intstartno);
		requestParams.addProperty("intendno", intendno);
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_getData.json", test);

		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		
		//Validate the status code
		if (response.getStatusCode() == 200) {
			if(response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")) {
				Reporter.log("Responses have been retrived from <b>"+intstartno +"</b> to <b>" +intendno +"</b> for survey id :<b>"+surveyNo+"</b>.");  // Add log in testNG report
				test.info("Responses have been retrived from <b>"+intstartno +"</b> to <b>" +intendno +"</b> for survey id :<b>"+surveyNo+"</b>.");		// Add log in extent report
			}else {
				test.log(Status.FAIL,"Unexpected error occured  : "+response.getBody().asPrettyString());
				Add_Log.info("Unexpected error occured : "+response.getBody().asPrettyString());
				Reporter.log("Unexpected error occured : "+response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Error received in API response : "+response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();		
			}
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();	
		}

		return responseData;

	} 
	
	public void validateDataFromResponseTbReport(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String anonymous = param.get("anonymous");
		JsonObject getResponseTbDataJson = readJSONFromFile(testcaseName,"\\src\\main\\resources\\jsonFiles\\getResponseTbDataJson.json", test);
		JsonObject data = readJSONFromFile(testcaseName, "\\Output Json\\"+testcaseName+".json", test);
		
		JsonArray respData = data.get("Data").getAsJsonObject().get("Responses").getAsJsonArray();
		for(int i=0; i<respData.size(); i++) {
			String actualResponseNum = respData.get(i).getAsJsonObject().get("ResponseNum").getAsString();
			String actualEmailID = respData.get(i).getAsJsonObject().get("EmailID").getAsString();
			String actualIPAddress = respData.get(i).getAsJsonObject().get("IPAddress").getAsString();
			String actualParticipationTime = respData.get(i).getAsJsonObject().get("EndTime").getAsString();
			String expectedResponseNum = getResponseTbDataJson.get("Raw Data").getAsJsonArray().get(i).getAsJsonObject().get("Response No").getAsString();
			String expectedEmailID = "Anonymous";
			String expectedParticipationTime = "";
			String expectedIPAddress = "Anonymous";
			if(anonymous.equalsIgnoreCase("N") || anonymous.isEmpty()) {
				 expectedEmailID = getResponseTbDataJson.get("Raw Data").getAsJsonArray().get(i).getAsJsonObject().get("Email ID").getAsString();
				 expectedParticipationTime = getResponseTbDataJson.get("Raw Data").getAsJsonArray().get(i).getAsJsonObject().get("Participation Time").getAsString();
				 expectedIPAddress = getResponseTbDataJson.get("Raw Data").getAsJsonArray().get(i).getAsJsonObject().get("IP Address").getAsString();
			}
			ArrayList<String> actualAnswerSet = new ArrayList<String>();
			ArrayList<String> expectedAnswerSet = new ArrayList<String>();
			for(int j=0; j<respData.get(i).getAsJsonObject().get("AnswerSet").getAsJsonArray().size(); j++) {			
				String actualAnswerData = respData.get(i).getAsJsonObject().get("AnswerSet").getAsJsonArray().get(j).getAsJsonObject().get("answer").getAsString().trim().replaceAll("\\s+", " ");		//Replace any whitespace between words and remove any at the string's beginning and end
				String expectedAnswerData = getResponseTbDataJson.get("Raw Data").getAsJsonArray().get(i).getAsJsonObject().get("Answer").getAsJsonArray().get(j).getAsJsonObject().get("answer").getAsString();
				actualAnswerSet.add(actualAnswerData);
				expectedAnswerSet.add(expectedAnswerData);
			}
			try {
				if(anonymous.equalsIgnoreCase("N") || anonymous.isEmpty()) {
					Assert.assertEquals(actualResponseNum, expectedResponseNum, "Mismatch occured in Response number");
					Assert.assertEquals(actualEmailID, expectedEmailID, "Mismatch occured in Email ID");
					Assert.assertEquals(actualIPAddress, expectedIPAddress, "Mismatch occured in IP address");
					Assert.assertEquals(actualParticipationTime, expectedParticipationTime, "Mismatch occured in Participation Time");
					Assert.assertTrue(actualAnswerSet.equals(expectedAnswerSet), "Mismatch occured in Answer responses of response number "+actualResponseNum
							+" actualanswer set from API : "+actualAnswerSet +" whereas expected answer set found in response table report is : "+expectedAnswerSet);			
				}else {
					Assert.assertEquals(actualResponseNum, expectedResponseNum, "Mismatch occured in Response number");
					Assert.assertEquals(actualEmailID, expectedEmailID, "Mismatch occured in Email ID");
					Assert.assertEquals(actualIPAddress, expectedIPAddress, "Mismatch occured in IP address");
					Assert.assertTrue(actualAnswerSet.equals(expectedAnswerSet), "Mismatch occured in Answer responses");
				}
				
			}catch(AssertionError e) {
				test.log(Status.FAIL,"Assertion error occured : "+e.getMessage());
				Add_Log.info("Assertion error occured : "+e.getMessage());
				Reporter.log("Assertion error occured : "+e.getMessage());
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured : "+e.getMessage());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
			
		}
	}
	
	public HashMap<String, Object> updateContactList(HashMap<String, String> param, String apiToken,  ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String baseURL = param.get("baseURL");
		String listname = param.get("listname");
		int intoperationtype = Integer.parseInt(param.get("intoperationtype"));
		boolean isallowduplicate = Boolean.parseBoolean(param.get("isallowduplicate"));
		String upsertAction = param.get("upsertAction");
		String path = param.get("path");
		JsonObject listattributesJson = new JsonObject();
		outputJsonPath = "\\Output Json\\"+testcaseName+".json";
		
		if (intoperationtype == 1) {
			listattributesJson = createUniqueListAttributeJsonForInsert(param, test);
		} else if (intoperationtype == 2) {
			listattributesJson = createUniqueListAttributeJsonForUpdate(param, test);
		}else if (intoperationtype == 3) {
			if(upsertAction.equalsIgnoreCase("Update")) {
				listattributesJson = createUniqueListAttributeJsonForUpdate(param, test);
			}else {
				listattributesJson = createUniqueListAttributeJsonForInsert(param, test);
			}
		}
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = baseURL;
		RequestSpecification request = RestAssured.given();

		// Create JsonObject and put the payload in key:value format
		JsonObject requestParams = new JsonObject();

		requestParams.addProperty("token", apiToken);
		requestParams.addProperty("listname", listname);
		requestParams.addProperty("intoperationtype", intoperationtype);
		requestParams.addProperty("isallowduplicate", isallowduplicate);
		requestParams.add("listattributes", listattributesJson.get("Table").getAsJsonArray());
		
		writeJSONToFIle(testcaseName, requestParams, "\\src\\main\\resources\\jsonFiles\\payload_updateContactList.json", test);

		request.header("Content-Type", "application/json"); // Add a header stating the Request body is a JSON
		request.body(requestParams.toString()); // Add the Json to the body of the request
		Response response = request.post(path); // Post the request and check the response
		
		writeJSONToFIle(testcaseName, response.getBody().asPrettyString(), outputJsonPath, test);
		responseData.put("statusCode", String.valueOf(response.getStatusCode()));
		responseData.put("respData", response.getBody().asPrettyString());
		responseData.put("headerList", response.getHeaders().asList().toString());
		
		//Validate the status code
		if (response.getStatusCode() == 200) {
			if (intoperationtype == 1 && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")
					&& response.jsonPath().get("Description").toString().equalsIgnoreCase("Record(s) inserted")) {
				Reporter.log("Records have been insered successfully"); // Add log in testNG report
				test.info("Records have been insered successfully"); // Add log in extent report
			} else if (intoperationtype == 2 && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")
					&& response.jsonPath().get("Description").toString().equalsIgnoreCase("Record(s) updated")) {
				Reporter.log("Records have been updated successfully"); // Add log in testNG report
				test.info("Records have been updated successfully"); // Add log in extent report
			} else if (intoperationtype == 3 && response.jsonPath().get("Status").toString().equalsIgnoreCase("Success")
					&& response.jsonPath().get("Description").toString().equalsIgnoreCase("Upsert successful.")) {
				Reporter.log("Records have been updated successfully"); // Add log in testNG report
				test.info("Records have been updated successfully"); // Add log in extent report
			}else {
				test.log(Status.FAIL, "Unexpected error occured  : " + response.getBody().asPrettyString());
				Add_Log.info("Unexpected error occured : " + response.getBody().asPrettyString());
				Reporter.log("Unexpected error occured : " + response.getBody().asPrettyString());
				TestResultStatus.failureReason.add(testcaseName + "| " + "Error received in API response : "
						+ response.getBody().asPrettyString());
				TestResultStatus.TestFail = true;
				Assert.fail();
			}
		}else {
			test.log(Status.FAIL,"Incorrect status code returned "+response.getStatusCode());
			Add_Log.info("Incorrect status code returned "+response.getStatusCode());
			Reporter.log("Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Incorrect status code returned "+response.getStatusCode());
			TestResultStatus.TestFail = true;
			Assert.fail();	
		}

		return responseData;

	}
	
	/**
	 * This method will create list attribute json  to update contact list field
	 * @param param
	 * @param test
	 * @return
	 */
	public JsonObject createUniqueListAttributeJsonForUpdate(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String emailStr = param.get("stremailaddress");
		String strHeaderFields = param.get("ContactListHeaderFields");
		String[] emailList = emailStr.split(",");
		String[] headerFields = strHeaderFields.split(",");
		
		JsonObject jTable = new JsonObject();
		JsonArray jarray = new JsonArray();
			
		for(int i=0; i<emailList.length; i++) {
			JsonObject json = new JsonObject();
			json.addProperty(headerFields[0], emailList[i]);
			for(int j=1; j<headerFields.length; j++) {
				json.addProperty(headerFields[j], RandomStringUtils.randomAlphanumeric(10));
			}
			jarray.add(json);
		}
		jTable.add("Table", jarray);
		writeJSONToFIle(testcaseName, jTable, "\\src\\main\\resources\\jsonFiles\\update_listattributes.json", test);
		
		return jTable;
	}
	
	public JsonObject createUniqueListAttributeJsonForInsert(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String strHeaderFields = param.get("ContactListHeaderFields");
		int numberOfContact = Integer.parseInt(param.get("numberOfContact"));
		String[] headerFields = strHeaderFields.split(",");
		
		JsonObject jTable = new JsonObject();
		JsonArray jarray = new JsonArray();
			
		for(int i=0; i<numberOfContact; i++) {
			JsonObject json = new JsonObject();
			json.addProperty(headerFields[0], RandomStringUtils.randomAlphanumeric(10)+"@email.com");
			for(int j=1; j<headerFields.length; j++) {
				json.addProperty(headerFields[j], RandomStringUtils.randomAlphanumeric(10));
			}
			jarray.add(json);
		}
		jTable.add("Table", jarray);
		writeJSONToFIle(testcaseName, jTable, "\\src\\main\\resources\\jsonFiles\\update_listattributes.json", test);
		
		return jTable;
	}
	
	public void validateContactListData(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String strHeaderFields = param.get("ContactListHeaderFields");
		String[] headerFields = strHeaderFields.split(",");
		JsonObject jsonContactListData = readJSONFromFile(testcaseName,"\\src\\main\\resources\\jsonFiles\\jsonContactListData.json", test);
		JsonObject payload = readJSONFromFile(testcaseName, "\\src\\main\\resources\\jsonFiles\\payload_updateContactList.json", test);
		JsonArray actualContactListData = jsonContactListData.get("Table").getAsJsonArray();
		JsonArray expectedContactListData = payload.get("listattributes").getAsJsonArray();
		
		for(int i=0; i<actualContactListData.size(); i++) {
			for(int j=0; j<actualContactListData.get(i).getAsJsonObject().size(); j++) {
				String actual = actualContactListData.get(i).getAsJsonObject().get(headerFields[j]).getAsString();
				String expected = expectedContactListData.get(i).getAsJsonObject().get(headerFields[j]).getAsString();
				try {
					Assert.assertEquals(actual, expected, "Mismatch occured in " + headerFields[j] + " field");
				} catch (AssertionError e) {
					test.log(Status.FAIL,"Assertion error occured : "+e.getMessage());
					Add_Log.info("Assertion error occured : "+e.getMessage());
					Reporter.log("Assertion error occured : "+e.getMessage());
					TestResultStatus.failureReason.add(testcaseName + "| "+ "Assertion error occured : "+e.getMessage());
					TestResultStatus.TestFail = true;
					Assert.fail();
				}
			}
			Reporter.log("Data has been successfully validated for "+headerFields[0] +" : <b>"
					+actualContactListData.get(i).getAsJsonObject().get(headerFields[0]).getAsString()+"</b>.");  // Add log in testNG report
			test.info("Data has been successfully validated for "+headerFields[0] +" : <b>"
					+actualContactListData.get(i).getAsJsonObject().get(headerFields[0]).getAsString()+"</b>.");		// Add log in extent report
			
		}
	}
	
	
	public ArrayList<String> getEmailFromAdditionalInfoJson(HashMap<String, String> param, String jsonPath, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject additionalInfoJson = readJSONFromFile(testcaseName, jsonPath, test);
		
		ArrayList<String> emailList = new ArrayList<String>();
		for(int i=0; i<additionalInfoJson.getAsJsonArray("Attributes").size(); i++) {
			String email = additionalInfoJson.getAsJsonArray("Attributes").get(i).getAsJsonObject().get("Email").getAsString();
			emailList.add(i, email);
		}
		return emailList;
	}
	
	public int generate9DigitRandomNumbers() {
		long timeSeed = System.currentTimeMillis(); // to get the current date time value
		double randSeed = Math.random() * 1000; // random number generation
		long midSeed = (long) (timeSeed * randSeed); // mixing up the time and random number. Variable timeSeed will be unique variable random will ensure no relation between the numbers
		String s = midSeed + "";
		String subStr = s.substring(0, 9);
		return Integer.parseInt(subStr); // Integer value
	}
		
	/**
	 * Use this method to update the password value from 'additioninfo_GenerateSurveyKey.json' in order to avoid duplicate passwords.
	 * @param additionalInfoJson
	 * @return 
	 */
	public JsonObject updateSurveyKeyPasswordFromJson(HashMap<String, String> param, String jsonPath, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject additionalInfoJson = readJSONFromFile(testcaseName, jsonPath, test);
		for(int i = 0; i<additionalInfoJson.getAsJsonArray("Attributes").size(); i++) {
			int random = generate9DigitRandomNumbers();
			additionalInfoJson.getAsJsonArray("Attributes").get(i).getAsJsonObject().addProperty("Password", String.valueOf(random));

		}
		return additionalInfoJson;
	}
	
	public ArrayList<String> getPaswordListFromAdditionalInfoJson(JsonObject additionalInfoJson, ExtentTest test) {
		ArrayList<String> passwordList = new ArrayList<String>();
		for(int i = 0; i<additionalInfoJson.getAsJsonArray("Attributes").size(); i++) {
			String password = additionalInfoJson.getAsJsonArray("Attributes").get(i).getAsJsonObject().get("Password").getAsString();
			passwordList.add(i, password);
		}
		return passwordList;
	}
	
	public ArrayList<String> getPaswordListFromAdditionalInfoJson(HashMap<String, String> param, String jsonPath, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject additionalInfoJson = readJSONFromFile(testcaseName, jsonPath, test);
		ArrayList<String> passwordList = new ArrayList<String>();
		for(int i = 0; i<additionalInfoJson.getAsJsonArray("Attributes").size(); i++) {
			String password = additionalInfoJson.getAsJsonArray("Attributes").get(i).getAsJsonObject().get("Password").getAsString();
			passwordList.add(i, password);
		}
		return passwordList;
	}
	
	public void writeJsonResponse(HashMap<String, String> param,String strJson, String filePath, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject json = readJSONFromString(testcaseName, strJson, test);
		writeJSONToFIle(testcaseName, json, filePath, test);
	}
	
	public JsonObject getAdditionalInfoJson(HashMap<String, String> param, String filePath, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		JsonObject additionalInfoJson = readJSONFromFile(testcaseName, filePath, test);
		return additionalInfoJson;
	}
	
	public HashMap<String, String> readRecentEmail(HashMap<String, String> param, String host, String userName, String password, String sub, Date currentTime, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		HashMap<String, String> emailData = new HashMap<String, String>();
		String saveDirectory = System.getProperty("user.dir") + "\\SaveEmails";
		String Date = "";
		String sentFrom = "";
		String subject = "";
		String messageContent = "";
		boolean isMailReceived = false;
		
		System.out.println("Current time : "+currentTime);
		
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        try {
            double endTime = 300;    // Run loop for 300 seconds
            double startTime = System.currentTimeMillis();
            do {
            	Session session = Session.getDefaultInstance(properties, null);
                Store store = session.getStore("imaps");
                
    			if (host.equalsIgnoreCase("gmail")) {
    				store.connect("imap.gmail.com", userName, password);
    			} else if (host.equalsIgnoreCase("yahoo")) {
    				store.connect("imap.mail.yahoo.com", userName, password);
    			} else if (host.equalsIgnoreCase("outlook")) {
    				store.connect("outlook.office365.com", userName, password);
    			} else if (host.equalsIgnoreCase("bluwberry")) {
    				store.connect("corp.bluwberry.com", userName, password);
    			}
            	Folder inbox = store.getFolder("INBOX");
            	 
                int unreadMailCount = inbox.getUnreadMessageCount();
                System.out.println("No. of Unread Mails = " + unreadMailCount);
     
                inbox.open(Folder.READ_WRITE);
                
                Message messages[] = inbox.getMessages();
                System.out.println("No. of Total Mails = " + messages.length);
            	//Get latest message
                Message message = messages[messages.length-1];
 
                Address[] from = message.getFrom();
                System.out.println("====================================== Mail no.: " + messages.length + " start ======================================");
                Date = message.getSentDate().toString();
                sentFrom = from[0].toString();
                subject = message.getSubject();
                
                System.out.println("Date: " + Date);
                System.out.println("From: " + sentFrom);
                System.out.println("Subject: " + subject);
                
                
                String contentType = message.getContentType();
 
                // store attachment file name, separated by comma
                String attachFiles = "";
 
                if (contentType.contains("multipart")) {
                    // content may contain attachments
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // this part is attachment
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            part.saveFile(saveDirectory + File.separator + fileName);
						}
						// this part may be the message content
                        if (part.getContentType().contains("multipart")) {
                        	messageContent = ((Multipart) (part.getContent())).getBodyPart(partCount).getContent().toString();
                        }else {
                        	messageContent = part.getContent().toString();
                        }
						
						System.out.println("Message content : " + (messageContent));

                    }
 
                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                        System.out.println("Message content : "+messageContent);
                    }
                }
                System.out.println("Attachments: " + attachFiles);
             
                System.out.println("====================================== Mail no.: " + messages.length + " end ======================================");
                if (subject.equalsIgnoreCase(sub) && (message.getSentDate().after(currentTime) || message.getSentDate().equals(currentTime))) {
                	isMailReceived = true;
                	break;
                }
                // disconnect
                inbox.close(false);
                store.close();
                Thread.sleep(3000);
            }while(((System.currentTimeMillis()-startTime)/1000) < endTime);  // Exit the loop after 300 seconds
            
            //Fail the test case if mail is not received.
            if(isMailReceived == false) {
            	test.log(Status.FAIL,"Expected mail with subject <b>"+sub +"</b> is not received.");
				Add_Log.info("Expected mail with subject "+sub +" is not received.");
				Reporter.log("Expected mail with subject <b>"+sub +"</b> is not received.");
				TestResultStatus.failureReason.add(testcaseName + "| "+ "Expected mail with subject "+sub +" is not received.");
				TestResultStatus.TestFail = true;
				Assert.fail();
            }
            
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for pop3.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
        emailData.put("Date", Date);
        emailData.put("Sent From", sentFrom);
        emailData.put("Subject", subject);
        emailData.put("Message Content", messageContent);
        
        return emailData;
	}
	
	public void getReopenURLFromEmail(HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String[] hostArray = param.get("emailhost").split(",");
		String[] emailArray = param.get("stremailaddress").split(",");
		String[] passwordArray = param.get("emailPassword").split(",");
		String sub = param.get("subject");
		Date currentTime = Calendar.getInstance().getTime();
		
		for(int i=0; i<emailArray.length; i++) {
			HashMap<String, String> emailData = readRecentEmail(param, hostArray[i], emailArray[i], passwordArray[i], sub, currentTime, test);
			try {
				String participationLink = (emailData.get("Message Content").substring(1886).split("<"))[0];
				Reporter.log("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and participation URL is : <b>"+participationLink+"</b>.");  // Add log in testNG report
				test.info("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and participation URL is : <b>"+participationLink+"</b>.");		// Add log in extent report		
			}catch(StringIndexOutOfBoundsException ex) {
				Reporter.log("Email not found in the INBOX of email id : <b>" +emailArray[i]+"</b>");
				test.log(Status.FATAL, "Email not found in INBOX of email id : <b>" +emailArray[i]+"</b>");
			}
		}
	}
	
	public void getInviteURLFromEmail(HashMap<String, String> param, Date currentTime, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		String[] hostArray = param.get("emailhost").split(",");
		String[] emailArray = param.get("stremailaddress").split(",");
		String[] passwordArray = param.get("emailPassword").split(",");
		String sub = param.get("subject");
		
		for(int i=0; i<emailArray.length; i++) {
			HashMap<String, String> emailData = readRecentEmail(param, hostArray[i], emailArray[i], passwordArray[i], sub, currentTime, test);
			try {
				String[] emailContent = emailData.get("Message Content").split(" ");
				String participationLink = "";
				for (String content : emailContent) {
					if (content.contains("https://") && content.contains("/k/")) {
						participationLink = content.substring(content.indexOf("https://"));
						break;
					}
				}
				Reporter.log("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and participation URL is : <b>"+participationLink+"</b>.");  // Add log in testNG report
				test.info("Email has been received with Subject <b>"+emailData.get("Subject") +"</b> from <b> "+(emailData.get("Sent From").replaceAll("[<>]*", "")) +"</b> to <b>"+ emailArray[i] +"</b> on <b>"+emailData.get("Date") +"</b> and participation URL is : <b>"+participationLink+"</b>.");		// Add log in extent report		
			}catch(StringIndexOutOfBoundsException ex) {
				Reporter.log("Email not found in the INBOX of email id : <b>" +emailArray[i]+"</b>");
				test.log(Status.FATAL, "Email not found in INBOX of email id : <b>" +emailArray[i]+"</b>");
			}
		}

		
	}
	

	

}


