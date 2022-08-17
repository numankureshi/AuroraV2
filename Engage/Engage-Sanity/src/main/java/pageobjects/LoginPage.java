package pageobjects;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Set;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.message.BasicListHeaderIterator;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.time.CalendarUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v100.performance.Performance;
import org.openqa.selenium.devtools.v100.performance.model.Metric;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import property.IHomePage;
import property.ISMXPage;
import property.IloginPage;
import testsuitebase.TestResultStatus;
import utility.JSONUtility;
import utility.SeleniumUtils;
import utility.WebPageElements;
	
public class LoginPage extends SeleniumUtils implements IloginPage{
	public double finish, start, totalTime;
	public double end;
	String strtotalTime= null;
	public DecimalFormat df = new DecimalFormat("#.##");
	boolean isFirstQDL = true;
	boolean isAnswerQuotaApplied = true;
	
	public void Validlogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
		driver.close();
	}
	
	public void Invalidlogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30,invalid_username, test);
		driver.findElement(By.xpath("//input[@id='txtUserId']")).sendKeys("sogo44test@gmail.com");		
		waitforElemPresent(driver, testcaseName, 30,invalid_password, test);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("xyz");
		waitforElemPresent(driver, testcaseName, 30, login, test);
		click(driver, testcaseName, login, test);
		waitforElemPresent(driver, testcaseName, 60, invalid_id_pass, test);
		driver.close();
	}
	
	public void Facebooklogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, fb, test);
		click(driver, testcaseName, fb, test);
		String winHandleBefore = driver.getWindowHandle();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		waitforElemPresent(driver, testcaseName, 30, fb_username, test);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testingrmx123@gmail.com");
		waitforElemPresent(driver, testcaseName, 30, fb_password, test);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Welcome@1234");
		click(driver, testcaseName, fb_login_button, test);
		driver.switchTo().window(winHandleBefore);
		waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
		driver.close();	
	}
	
	public void Googlelogin(WebDriver driver, HashMap<String, String> param, ExtentTest test) {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, google, test);
		click(driver, testcaseName, google, test);
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		waitforElemPresent(driver, testcaseName, 30, google_username, test);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("sogo44test@gmail.com");
		waitforElemPresent(driver, testcaseName, 30, google_next_button, test);
		click(driver, testcaseName, google_next_button, test);
		waitforElemPresent(driver, testcaseName, 30, google_password, test);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9819254698");
		waitforElemPresent(driver, testcaseName, 30, google_next_button, test);
		click(driver, testcaseName, google_next_button, test);
		driver.switchTo().window(winHandleBefore);
		waitforElemPresent(driver, testcaseName, 60, sogo_account, test);
		driver.close();
	}
}



