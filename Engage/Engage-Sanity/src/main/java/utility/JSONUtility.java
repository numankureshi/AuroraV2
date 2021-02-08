package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import testsuitebase.TestResultStatus;

public class JSONUtility {
	
	public Logger Add_Log = Logger.getLogger("rootLogger");
	
	
	public JsonObject readJSONFromString(String testcaseName, String strJson, ExtentTest test) {
		JsonObject json = new JsonObject();	
		try {
			JsonParser parser = new JsonParser();
			json = (JsonObject) parser.parse(strJson);
		}catch(Exception e) {
			test.log(Status.FAIL, "Following error occured while reading JSON from file : "+e.getMessage());
			Add_Log.info("Following error occured while reading JSON from file : "+e.getMessage());
			Reporter.log("Following error occured while reading JSON from file : "+e.getMessage());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Following error occured while reading JSON from file : "+e.getMessage());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
		return json;
	}
	
	public JsonObject readJSONFromFile(String testcaseName,String jsonPath, ExtentTest test){
		JsonObject json = new JsonObject();
		try {
			JsonParser parser = new JsonParser();
			json = (JsonObject) parser.parse(new FileReader(System.getProperty("user.dir") + jsonPath));
		} catch (Exception e) {
			test.log(Status.FAIL, "Error occured while reading JSON file. Error : "+e.getMessage());
			Add_Log.info("Error occured while reading JSON file. Error : "+e.getMessage());
			Reporter.log("Error occured while reading JSON file. Error : "+e.getMessage());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Error occured while reading JSON file. Error : "+e.getMessage());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		return json;
	}
	
	public void writeJSONToFIle(String testcaseName, JsonObject json, String filePath, ExtentTest test){
		
		try {
			FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + filePath);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String prettyJson = gson.toJson(json);
			fileWriter.write(prettyJson);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			test.log(Status.FAIL, "Following error occured while writing JSON to file : "+e.getMessage());
			Add_Log.info("Following error occured while writing JSON to file : "+e.getMessage());
			Reporter.log("Following error occured while writing JSON to file : "+e.getMessage());
			TestResultStatus.failureReason.add(testcaseName + "| "+ "Following error occured while writing JSON to file : "+e.getMessage());
			TestResultStatus.TestFail = true;
			Assert.fail();
		}
		
	}
	

}
