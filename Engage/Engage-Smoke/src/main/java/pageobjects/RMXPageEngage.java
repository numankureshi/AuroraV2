package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import property.IHomePage;
import property.IRMXPage;
import property.IRMXPageEngage;
import utility.SeleniumUtils;

public class RMXPageEngage extends SeleniumUtils implements IRMXPageEngage, IRMXPage{
	

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
	
	/*
	 * public void loadDARReport(WebDriver driver, HashMap<String, String> param,
	 * String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
	 * String testcaseName = param.get("TestCaseName"); goToReportPage(driver,
	 * param, surveyTitle, SID, test);
	 * 
	 * 
	 * click(driver, testcaseName, special_reports, test); click(driver,
	 * testcaseName, dimensional_analysis, test); waitforElemPresent(driver,
	 * testcaseName, 30, select_project_1_dd, test); click(driver, testcaseName,
	 * dar_1dd, test); scrollIntoCenter(driver, testcaseName, select_folder1_dd,
	 * test); click(driver, testcaseName, select_folder1_dd, test); click(driver,
	 * testcaseName, select_project_1_dd, test); click(driver, testcaseName,
	 * dar_2dd, test); scrollIntoCenter(driver, testcaseName, select_folder2_dd,
	 * test); click(driver, testcaseName, select_folder2_dd, test); click(driver,
	 * testcaseName, select_project2_dd, test); click(driver, testcaseName,
	 * generate_report, test); click(driver, testcaseName, select_folder2_dd, test);
	 * waitforElemPresent(driver, testcaseName, 30, add_parent1, test);
	 * click(driver, testcaseName, add_parent1, test); click(driver, testcaseName,
	 * add_star1, test); click(driver, testcaseName, add_parent2, test);
	 * click(driver, testcaseName, add_star2, test); click(driver, testcaseName,
	 * add_parent3, test); click(driver, testcaseName, add_star3, test);
	 * click(driver, testcaseName, add_parent4, test); click(driver, testcaseName,
	 * add_star4, test); click(driver, testcaseName, add_parent5, test);
	 * click(driver, testcaseName, add_star5, test); click(driver, testcaseName,
	 * add_parent6, test); click(driver, testcaseName, add_star6, test);
	 * click(driver, testcaseName, add_parent7, test); click(driver, testcaseName,
	 * add_star7, test); click(driver, testcaseName, add_parent8, test);
	 * click(driver, testcaseName, add_star8, test); click(driver, testcaseName,
	 * add_parent9, test); click(driver, testcaseName, add_star9, test);
	 * click(driver, testcaseName, add_parent10, test); click(driver, testcaseName,
	 * add_star10, test); click(driver, testcaseName, add_parent11, test);
	 * click(driver, testcaseName, add_star11, test); click(driver, testcaseName,
	 * report_canvas, test); waitforElemPresent(driver, testcaseName, 30,
	 * canvas_title, test); click(driver, testcaseName, canvas_title, test);
	 * click(driver, testcaseName, canvas_description, test); click(driver,
	 * testcaseName, segment, test); waitforElemPresent(driver, testcaseName, 30,
	 * segment_surveydd, test); click(driver, testcaseName, segment_surveydd, test);
	 * click(driver, testcaseName, segment_questiondd, test); click(driver,
	 * testcaseName, segment_answercb, test); click(driver, testcaseName,
	 * email_report, test); waitforElemPresent(driver, testcaseName, 30, segment,
	 * test);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void loadEngagementReport(WebDriver driver, HashMap<String, String> param, String surveyTitle, String SID, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		goToReportPage(driver, param, surveyTitle, SID, test);
		
		
        click(driver, testcaseName, engagement, test);
        click(driver, testcaseName, indicate_nmax, test);
        click(driver, testcaseName, engage_continue1, test);
        click(driver, testcaseName, engagement_cb, test);
		click(driver, testcaseName, engagement_cb1, test);
		click(driver, testcaseName, engagement_cb2, test);
		click(driver, testcaseName, engage_continue, test);
		click(driver, testcaseName, engagement_dcb, test);
		click(driver, testcaseName, engagement_dcb1, test);
		click(driver, testcaseName, engagement_dcb2, test);
		click(driver, testcaseName, engage_ques, test);
		click(driver, testcaseName, engage_add, test);
		click(driver, testcaseName, composition_ques, test);
		click(driver, testcaseName, composition_cb, test);
		click(driver, testcaseName, composition_dd, test);
		click(driver, testcaseName, composition_cbdd, test);
		click(driver, testcaseName, composition_generate, test);		
	}
	
	public void selectOmniReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, omni_report, test);
		click(driver, testcaseName, omni_report, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void generateOmniReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		RMXPage rmxPage = new RMXPage();
		rmxPage.goToReportsPage(driver, param, test);
		selectOmniReport(driver, param, test);
		rmxPage.slideShowEmail(driver, param, test);
		rmxPage.saveReport(driver, param, test);
		rmxPage.downloadReport(driver, param, test);
		rmxPage.emailReport(driver, param, test);
	}
	
	
	
	public void generateSegmentationReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		RMXPage rmxPage = new RMXPage();
		rmxPage.goToReportsPage(driver, param, test);
		rmxPage.selectSegmentationReport(driver, param, test);
		rmxPage.selectSegmentationQuestion(driver, param, test);
		
		selectAllQuestions3(driver, param, test);
		propertiesPage3(driver, param, test);
		comparisonSegmentationPage(driver, param, test);
		comparisonCustomizeCoverPage(driver, param, test);
		
		rmxPage.emailReport2(driver, param, test);
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
	
	public void comparisonCustomizeCoverPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, customize_cover_page, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button6, test);
		click(driver, testcaseName, continue_button6, test);
		waitForLoad(driver, testcaseName, 30, test);
	}
	
	public void comparisonSegmentationPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, comparison_segmentation, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button5, test);
		click(driver, testcaseName, continue_button5, test);
		waitForLoad(driver, testcaseName, 30, test);
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
		
		
		/*
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']"
		 * ), "Rules and Regulations", test); click(driver, testcaseName, By.
		 * xpath("//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']"
		 * ), "Rules and Regulations", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("(//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "Rules and Regulations", test); click(driver, testcaseName, By.
		 * xpath("(//div[@class='ClimateScore_1_5']//span[text()='Rules and Regulations']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "Rules and Regulations", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"),
		 * "Rules and Regulations", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"),
		 * "Rules and Regulations", test); Thread.sleep(500); waitforElemPresent(driver,
		 * testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]")
		 * , "Rules and Regulations", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]")
		 * , "Rules and Regulations", test); Thread.sleep(500);
		 */
		
		
		/*
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']"
		 * ), "Comparison Over Time", test); click(driver, testcaseName, By.
		 * xpath("//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']"
		 * ), "Comparison Over Time", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("(//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"
		 * ), "Comparison Over Time", test); click(driver, testcaseName, By.
		 * xpath("(//div[@class='ClimateScore_1_5']//div[text()='Comparison Over Time']/following::div[@class='StarInActive'])[1]"
		 * ), "Comparison Over Time", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"),
		 * "Comparison Over Time", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[text()='Show Table'])[1]"),
		 * "Comparison Over Time", test); Thread.sleep(500); waitforElemPresent(driver,
		 * testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]")
		 * , "Comparison Over Time", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_5']//div[@class='StarInActive'])[1]")
		 * , "Comparison Over Time", test);
		 */
		
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
		
		
		/*
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']"
		 * ), "What is your ethnic group?", test); click(driver, testcaseName, By.
		 * xpath("//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']"
		 * ), "What is your ethnic group?", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("(//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "What is your ethnic group?", test); click(driver, testcaseName, By.
		 * xpath("(//div[@class='ClimateScore_1_3']//span[text()='What is your ethnic group?']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "What is your ethnic group?", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_3']//div[text()='Show Table'])[1]"),
		 * "What is your ethnic group?", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_3']//div[text()='Show Table'])[1]"),
		 * "What is your ethnic group?", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_3']//div[@class='StarInActive'])[1]")
		 * , "What is your ethnic group?", test); click(driver, testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_3']//div[@class='StarInActive'])[1]")
		 * , "What is your ethnic group?", test); Thread.sleep(500);
		 */
		
		
		/*
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']"
		 * ), "Please respond to the following statements.", test); click(driver,
		 * testcaseName, By.
		 * xpath("//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']"
		 * ), "Please respond to the following statements.", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30, By.
		 * xpath("(//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "Please respond to the following statements.", test); click(driver,
		 * testcaseName, By.
		 * xpath("(//div[@class='ClimateScore_1_6']//span[text()='Please respond to the following statements.']/following::div[@class='StarInActive GraphStar'])[1]"
		 * ), "Please respond to the following statements.", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_6']//div[text()='Show Table'])[1]"),
		 * "Please respond to the following statements.", test); click(driver,
		 * testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_6']//div[text()='Show Table'])[1]"),
		 * "Please respond to the following statements.", test); Thread.sleep(500);
		 * waitforElemPresent(driver, testcaseName, 30,
		 * By.xpath("(//div[@class='ClimateScore_1_6']//div[@class='StarInActive'])[1]")
		 * , "Please respond to the following statements.", test); click(driver,
		 * testcaseName,
		 * By.xpath("(//div[@class='ClimateScore_1_6']//div[@class='StarInActive'])[1]")
		 * , "Please respond to the following statements.", test); Thread.sleep(500);
		 */
		
		
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
	
	public void generateDarReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		RMXPage rmxPage = new RMXPage();
		rmxPage.goToReportsPage(driver, param, test);
		rmxPage.selectDarReport(driver, param, test);
		rmxPage.selectProjectsPage(driver, param, test); 
		selectDARPage(driver, param, test); 
		rmxPage.reportCanvas(driver, param, test);
				 /*
				 * * selectAllQuestions4(driver, param, test); selectDriverQuestions(driver, param, test);
		 * selectAdditionalQuestions(driver, param, test);
		 * selectCompositionAnalysis(driver, param, test);
		 * selectSegmentationReportPage(driver, param, test); dataSources3(driver,
		 * param, test);
		 */
		
	}
	
	public void generateEngagementReport(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		RMXPage rmxPage = new RMXPage();
		rmxPage.goToReportsPage(driver, param, test);
		rmxPage.selectEngagementReport(driver, param, test);
		participationDetailsPage(driver, param, test);
		rmxPage.selectAllQuestions4(driver, param, test);
		rmxPage.selectDriverQuestions(driver, param, test);
		rmxPage.selectAdditionalQuestions(driver, param, test);
		selectCompositionAnalysis(driver, param, test);
		selectSegmentationReportPage(driver, param, test);
		rmxPage.dataSources3(driver, param, test);
		
	}
	
	public void participationDetailsPage(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, report_type, test);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		String reportName = param.get("header");
		param.put("reportName", reportName);
		waitforElemPresent(driver, testcaseName, 30, select_report_type, test);
		Select select = new Select(driver.findElement(By.xpath(SELECT_REPORT_TYPE)));
		select.selectByVisibleText(reportName);
		waitForLoad(driver, testcaseName, 30, test);	
		waitforElemPresent(driver, testcaseName, 30, nmax, test);
		setText(driver, testcaseName, nmax, param.get("nmax"), test);
		waitForLoad(driver, testcaseName, 30, test);	
		waitforElemPresent(driver, testcaseName, 30, continue_button11, test);
		click(driver, testcaseName, continue_button11, test);
		waitForLoad(driver, testcaseName, 30, test);	
		
	}
	
	public void selectCompositionAnalysis(WebDriver driver, HashMap<String, String> param, ExtentTest test) throws InterruptedException{
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, compositional_analysis_page2, test);
		
			
			click(driver, testcaseName, compostion_analysis_switch, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//label[text()='"+ param.get("compositionby") +"']"), param.get("compositionby"), test);
			click(driver, testcaseName, By.xpath("//label[text()='"+ param.get("compositionby") +"']"), param.get("compositionby"), test);
			Select select = new Select(driver.findElement(By.xpath(COMPOSITION_REPORT_DD2)));
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
		waitforElemPresent(driver, testcaseName, 30, segementation_report_page2, test);
		String[] list = param.get("segment").split(",");
		String[] list2 = param.get("segment2").split(",");	
			click(driver, testcaseName, segmentation_report_switch, test);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//label[text()='"+ list[0] +"'])[2]"), list[0], test);
			click(driver, testcaseName, By.xpath("(//label[text()='"+ list[0] +"'])[2]"), list[0], test);
			waitforElemPresent(driver, testcaseName, 30, segmentation_report_dd1, test);
			Select select = new Select(driver.findElement(By.xpath(SEGMENTATION_REPORT_DD1)));
			
//			select2.selectByVisibleText(param.get("segmentation"));
			select.selectByIndex(Integer.parseInt(list2[0]));
			waitForLoad(driver, testcaseName, 30, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//label[text()='"+ list[1] +"'])[2]"), list[1], test);
			click(driver, testcaseName, By.xpath("(//label[text()='"+ list[1] +"'])[2]"), list[1], test);
			waitforElemPresent(driver, testcaseName, 30, segmentation_report_dd2, test);
			Select select2 = new Select(driver.findElement(By.xpath(SEGMENTATION_REPORT_DD2)));
			
//			select2.selectByVisibleText(param.get("segmentation"));
			select2.selectByIndex(Integer.parseInt(list2[1]));
			waitForLoad(driver, testcaseName, 30, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//label[text()='"+ list[2] +"'])[2]"), list[2], test);
			click(driver, testcaseName, By.xpath("(//label[text()='"+ list[2] +"'])[2]"), list[2], test);
			waitforElemPresent(driver, testcaseName, 30, segmentation_report_dd3, test);
			Select select3 = new Select(driver.findElement(By.xpath(SEGMENTATION_REPORT_DD3)));
			
//			select2.selectByVisibleText(param.get("segmentation"));
			select3.selectByIndex(Integer.parseInt(list2[2]));
			waitForLoad(driver, testcaseName, 30, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//label[text()='"+ list[3] +"'])[2]"), list[3], test);
			click(driver, testcaseName, By.xpath("(//label[text()='"+ list[3] +"'])[2]"), list[3], test);
			waitforElemPresent(driver, testcaseName, 30, segmentation_report_dd4, test);
			Select select4 = new Select(driver.findElement(By.xpath(SEGMENTATION_REPORT_DD4)));
			
//			select2.selectByVisibleText(param.get("segmentation"));
			select4.selectByIndex(Integer.parseInt(list2[3]));
			waitForLoad(driver, testcaseName, 30, test);
			
			waitforElemPresent(driver, testcaseName, 30, By.xpath("(//label[text()='"+ list[4] +"'])[2]"), list[4], test);
			click(driver, testcaseName, By.xpath("(//label[text()='"+ list[4] +"'])[2]"), list[4], test);
			waitforElemPresent(driver, testcaseName, 30, segmentation_report_dd5, test);
			Select select5 = new Select(driver.findElement(By.xpath(SEGMENTATION_REPORT_DD5)));
			
//			select2.selectByVisibleText(param.get("segmentation"));
			select5.selectByIndex(Integer.parseInt(list2[4]));
			waitForLoad(driver, testcaseName, 30, test);
			
			
		waitforElemPresent(driver, testcaseName, 30, continue_button6, test);
		click(driver, testcaseName, continue_button6, test);
		waitForLoad(driver, testcaseName, 30, test);
		
	}
	
	
}
		


