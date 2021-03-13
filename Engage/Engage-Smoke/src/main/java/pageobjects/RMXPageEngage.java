package pageobjects;

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
}
		


