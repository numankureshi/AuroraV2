package pageobjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import property.ISMXPage;
import property.ISurveyPage;
import utility.SeleniumUtils;

public class SMXPage extends SeleniumUtils implements ISMXPage {
	
	public void createSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		selectCreateProject(driver, param, test);
		selectBlankSurvey(driver, param, test);
		createNewSurvey(driver, param, test);
		enterDescription(driver, param, test);
		enterNetPromoter(driver, param, test);
		enterTextBox(driver, param, test);
		enterRadioButton(driver, param, test);
		enterCheckBoxButton(driver, param, test);
		enterDropDownButton(driver, param, test);
		enterDemographicsButton(driver, param, test);
		enterRatingScaleButton(driver, param, test);
		enterSymbolRatingScaleButton(driver, param, test);
		enterLikeDislikeButton(driver, param, test);
		enterRankingQuestionButton(driver, param, test);
		enterDateButton(driver, param, test);
		enterImageChoiceButton(driver, param, test);
		enterMultipleTextBoxButton(driver, param, test);
		enterMultiDropDownButton(driver, param, test);
		enterRadioGridButton(driver, param, test);
		enterCheckBoxGridButton(driver, param, test);
		enterRatingRadioGridButton(driver, param, test);
		enterRatingDropDownGridButton(driver, param, test);
		enterRatingScaleGridButton(driver, param, test);
		enterMatrixGridButton(driver, param, test);
		enterHorizontalRadioButton(driver, param, test);
		enterAttachmentButton(driver, param, test);
		enterRatingRadioButton(driver, param, test);
		enterRatingDropDownButton(driver, param, test);
		enterListBoxButton(driver, param, test);
		waitforElemPresent(driver, testcaseName, 10, captcha_button, test);
	}

	public void selectCreateProject(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 100, create_project, test);
		click(driver, testcaseName, create_project, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, begin_label, test);
	}
	
	public void selectBlankSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool.aspx')]"), "Iframe", test);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1' and contains(@src,'CreateNewTool.aspx')]")));
		Thread.sleep(1000);
		waitforElemPresent(driver, testcaseName, 30, survey_button, test);
		click(driver, testcaseName, survey_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, blank_survey, test);
		click(driver, testcaseName, blank_survey, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, continue_button, test);
		click(driver, testcaseName, continue_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, create_survey_label, test);
	}
	
	public void createNewSurvey(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		enterSurveyName(driver, param, test);
		selectFolder(driver, param, test);
		selectPrimaryLanugage(driver, param, test);
		selectSecondaryLanugage(driver, param, test);
		waitforElemPresent(driver, testcaseName, 30, start_button, test);
		click(driver, testcaseName, start_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[@title='"+ param.get("surveyName") +"']"), param.get("surveyName"), test);
	}
	
	public void enterSurveyName(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date);
		
		waitforElemPresent(driver, testcaseName, 30, survey_name, test);
		String surveyName = param.get("surveyname") + " - " + strDate;
		param.put("surveyName", surveyName);
		setText(driver, testcaseName, survey_name, surveyName, test);
	}
	public void selectFolder(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, folder, test);
		click(driver, testcaseName, folder, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		click(driver, testcaseName, By.xpath("//span[text()='"+ param.get("foldername") +"']"), param.get("foldername"), test);
		
	}
		
	public void selectPrimaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, primary_lanugage_dd, test);
		Select select = new Select(driver.findElement(By.xpath(PRIMARY_LANGUAGE_DD)));
		select.selectByVisibleText(param.get("primarylanguage"));
		
	}
	
	public void selectSecondaryLanugage(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
//		waitforElemPresent(driver, testcaseName, 30, secondary_language_switch, test);
		click(driver, testcaseName, secondary_language_switch,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd, test);
		click(driver, testcaseName, secondary_lanugage_dd,test);
		waitforElemPresent(driver, testcaseName, 30, secondary_lanugage_dd_search, test);
		setText(driver, testcaseName, secondary_lanugage_dd_search, param.get("secondarylanguage"), test);
		Thread.sleep(2000);
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
		click(driver, testcaseName, By.xpath("//label[contains(text(),'"+ param.get("secondarylanguage") +"')]"), param.get("secondarylanguage"), test);
//		Select select = new Select(driver.findElement(By.xpath(PRIMARY_LANGUAGE_DD)));
//		select.selectByVisibleText(param.get("primarylanguage"));
		
	}
	
	public void enterDescription(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, description_button, test);
		doubleClick(driver, testcaseName, description_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("description"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("description") +"']"), "Description Added "+ param.get("description"), test);
	}
	
	public void enterNetPromoter(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, net_promoter_score_button, test);
		doubleClick(driver, testcaseName, net_promoter_score_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		String netPromoterLabel = getText(driver, testcaseName, description_text, test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']"), "Net Promoter Label Added "+ netPromoterLabel, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ netPromoterLabel +"']/parent::div/following-sibling::div//div[@class='clearfix slider-div']"), "Net Promoter Label Added "+ netPromoterLabel, test);
	}	

	public void enterTextBox(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, text_box_button, test);
		doubleClick(driver, testcaseName, text_box_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("textbox"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']"), "Text Box Label Added "+ param.get("textbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("textbox") +"']/parent::div/following-sibling::div//input"), "Text Box Added "+ param.get("textbox"), test);
	}
	
	public void enterRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, radio_button, test);
		doubleClick(driver, testcaseName, radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("radiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']"), "Radio Buttons Label Added "+ param.get("radiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("radiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Radio Buttons Added "+ param.get("radiobutton"), test);
	}
	
	public void enterCheckBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, check_box_button, test);
		doubleClick(driver, testcaseName, check_box_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("checkbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, none_of_above, test);
		click(driver, testcaseName, none_of_above, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']"), "Check Box Label Added "+ param.get("checkbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("checkbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Check Box Added "+ param.get("checkbox"), test);
	}
	
	
	public void answersLibrary(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, answers_library, test);
		click(driver, testcaseName, answers_library, test);
		waitforElemPresent(driver, testcaseName, 10, get_answer_options_library, test);
		click(driver, testcaseName, get_answer_options_library, test);
		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS)));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void answersLibrary2(WebDriver driver, HashMap<String, String> param, String answerOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, By.xpath("(//div[text()='More '])[2]"), "More", test);
		click(driver, testcaseName, By.xpath("(//div[text()='More '])[2]"), "More", test);
		
		waitforElemPresent(driver, testcaseName, 10, answers_library2, test);
		click(driver, testcaseName, answers_library2, test);
		
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options2, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS2)));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ answerOption +"']"), answerOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void questionsLibrary(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 10, By.xpath("(//div[text()='More '])[1]"), "More", test);
		click(driver, testcaseName, By.xpath("(//div[text()='More '])[1]"), "More", test);
		
		waitforElemPresent(driver, testcaseName, 10, questions_library2, test);
		click(driver, testcaseName, questions_library2, test);
		
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options2, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS2)));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void questionsLibrary2(WebDriver driver, HashMap<String, String> param, String questionOption, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		
		
		waitforElemPresent(driver, testcaseName, 10, questions_library3, test);
		click(driver, testcaseName, questions_library3, test);
		
		waitforElemPresent(driver, testcaseName, 10, get_questions_questions_library, test);
		click(driver, testcaseName, get_questions_questions_library, test);
		
//		waitforElemPresent(driver, testcaseName, 30, ansers_liburary_label, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_answer_options3, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ANSWER_OPTIONS3)));
		waitforElemPresent(driver, testcaseName, 10, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		click(driver, testcaseName, By.xpath("//label[text()='"+ questionOption +"']"), questionOption, test);
		waitforElemPresent(driver, testcaseName, 10, use_this_list_button, test);
		click(driver, testcaseName, use_this_list_button, test);
		driver.switchTo().defaultContent();
		}
	
	public void enterDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, drop_down_button, test);
		doubleClick(driver, testcaseName, drop_down_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("dropdown"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']"), "Drop Down Label Added "+ param.get("dropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("dropdown") +"']/parent::div/following-sibling::div/div[@class='clsEdit ControlColorsDD']"), "Drop Down Added "+ param.get("dropdown"), test);
	}
	
	public void enterDemographicsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, demographics_button, test);
		doubleClick(driver, testcaseName, demographics_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("demographics"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, name_expand, test);
		click(driver, testcaseName, name_expand, test);
		waitforElemPresent(driver, testcaseName, 30, name_title, test);
		click(driver, testcaseName, name_title, test);
//		waitforElemPresent(driver, testcaseName, 30, name_full_name, test);
//		click(driver, testcaseName, name_full_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_first_name, test);
		click(driver, testcaseName, name_first_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_middle_name, test);
		click(driver, testcaseName, name_middle_name, test);
		waitforElemPresent(driver, testcaseName, 30, name_last_name, test);
		click(driver, testcaseName, name_last_name, test);
		waitforElemPresent(driver, testcaseName, 30, gender, test);
		click(driver, testcaseName, gender, test);
		waitforElemPresent(driver, testcaseName, 30, dob, test);
		click(driver, testcaseName, dob, test);
		
		waitforElemPresent(driver, testcaseName, 30, address_expand, test);
		click(driver, testcaseName, address_expand, test);
		waitforElemPresent(driver, testcaseName, 30, address_street1, test);
		click(driver, testcaseName, address_street1, test);
		waitforElemPresent(driver, testcaseName, 30, address_street2, test);
		click(driver, testcaseName, address_street2, test);
		waitforElemPresent(driver, testcaseName, 30, address_city, test);
		click(driver, testcaseName, address_city, test);
		waitforElemPresent(driver, testcaseName, 30, address_country, test);
		click(driver, testcaseName, address_country, test);
		waitforElemPresent(driver, testcaseName, 30, address_state, test);
		click(driver, testcaseName, address_state, test);
		waitforElemPresent(driver, testcaseName, 30, address_zip, test);
		click(driver, testcaseName, address_zip, test);
//		waitforElemPresent(driver, testcaseName, 30, address_zipplus4, test);
//		click(driver, testcaseName, address_zipplus4, test);
		
		waitforElemPresent(driver, testcaseName, 30, telephone_expand, test);
		click(driver, testcaseName, telephone_expand, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_telephone, test);
		click(driver, testcaseName, telephone_telephone, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_extension, test);
		click(driver, testcaseName, telephone_extension, test);
		waitforElemPresent(driver, testcaseName, 30, telephone_fax, test);
		click(driver, testcaseName, telephone_fax, test);
		
		waitforElemPresent(driver, testcaseName, 30, email_address, test);
		click(driver, testcaseName, email_address, test);
		waitforElemPresent(driver, testcaseName, 30, reenter_email_address, test);
		click(driver, testcaseName, reenter_email_address, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']"), "Demographics Label Added "+ param.get("demographics"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("demographics") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Demographics Added "+ param.get("demographics"), test);
	}
	
	public void enterRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_button, test);
		doubleClick(driver, testcaseName, rating_scale_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscale"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, show_na_option, test);
		click(driver, testcaseName, show_na_option, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_scale_in_reverse_order, test);
		click(driver, testcaseName, show_scale_in_reverse_order, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, show_participant_rating_field, test);
		click(driver, testcaseName, show_participant_rating_field, test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']"), "Rating Scale Added "+ param.get("ratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscale") +"']/parent::div/following-sibling::div//div[contains(@class,'slide ui-slider ui-slider-horizontal')]"), "Rating Scale Added "+ param.get("ratingscale"), test);
	}
	
	public void enterSymbolRatingScaleButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		String[] subQuestions = param.get("subquestions").split(";");
		waitforElemPresent(driver, testcaseName, 30, symbol_rating_scale_button, test);
		doubleClick(driver, testcaseName, symbol_rating_scale_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("symbolratingscale"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 30, number_subquestion, test);
		Select select = new Select(driver.findElement(By.xpath(NUMBER_SUBQUESTION)));
		select.selectByVisibleText("6");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption1']"), "Sub Question 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption1']"), subQuestions[0], "Sub Question 1", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_1']"), "Sub Question 1 Scale", test);
		Select selectSubquestion1 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_1']")));
		selectSubquestion1.selectByVisibleText("Star");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption2']"), "Sub Question 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption2']"), subQuestions[1], "Sub Question 2", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_2']"), "Sub Question 2 Scale", test);
		Select selectSubquestion2 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_2']")));
		selectSubquestion2.selectByVisibleText("Thumb up");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption3']"), "Sub Question 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption3']"), subQuestions[2], "Sub Question 3", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_3']"), "Sub Question 3 Scale", test);
		Select selectSubquestion3 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_3']")));
		selectSubquestion3.selectByVisibleText("Heart");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption4']"), "Sub Question 4", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption4']"), subQuestions[3], "Sub Question 4", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_4']"), "Sub Question 4 Scale", test);
		Select selectSubquestion4 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_4']")));
		selectSubquestion4.selectByVisibleText("Check mark");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption5']"), "Sub Question 5", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption5']"), subQuestions[4], "Sub Question 5", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_5']"), "Sub Question 5 Scale", test);
		Select selectSubquestion5 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_5']")));
		selectSubquestion5.selectByVisibleText("Dollar sign");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='GQoption6']"), "Sub Question 6", test);
		setText(driver, testcaseName, By.xpath("//input[@name='GQoption6']"), subQuestions[5], "Sub Question 6", test);
		Thread.sleep(500);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//select[@name='ddlGQGrid_0_6']"), "Sub Question 6 Scale", test);
		Select selectSubquestion6 = new Select(driver.findElement(By.xpath("//select[@name='ddlGQGrid_0_6']")));
		selectSubquestion6.selectByVisibleText("Person");
		Thread.sleep(500);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("symbolratingscale") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Symbol Rating Scale Added "+ param.get("symbolratingscale"), test);
	}
	
	public void enterLikeDislikeButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, like_dislike_button, test);
		doubleClick(driver, testcaseName, like_dislike_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("likedislike"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']"), "Like/Dislike Added "+ param.get("likedislike"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("likedislike") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Like/Dislike Added "+ param.get("likedislike"), test);
	}
	
	public void enterRankingQuestionButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, ranking_question_button, test);
		doubleClick(driver, testcaseName, ranking_question_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ranking"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']"), "Ranking Added "+ param.get("ranking"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ranking") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Ranking Added "+ param.get("ranking"), test);
	}
	
	public void enterDateButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, date_button, test);
		doubleClick(driver, testcaseName, date_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("date"), test);
		driver.switchTo().defaultContent();
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']"), "Date Added "+ param.get("date"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("date") +"']/parent::div/following-sibling::div//div[@class='dateIcon']"), "Date Added "+ param.get("date"), test);
	}
	
	public void enterImageChoiceButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, image_choice_button, test);
		doubleClick(driver, testcaseName, image_choice_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("imagechoice"), test);
		driver.switchTo().defaultContent();
		String[] images = param.get("images").split(";");
		String[] reportingValue = param.get("reportingvalue").split(";");
		for(int i = 0; i < images.length; i++) {
			if(i == 0){
				waitforElemPresent(driver, testcaseName, 10, add_image_icon, test);
				click(driver, testcaseName, add_image_icon, test);
			} else {
				waitforElemPresent(driver, testcaseName, 10, add_image_icon2, test);
				click(driver, testcaseName, add_image_icon2, test);
			}
			
			waitForLoad(driver, testcaseName, 30, test);
//			waitforElemPresent(driver, testcaseName, 10, browse_button, test);
//			setText(driver, testcaseName, browse_button, images[i], test);
			driver.findElement(By.xpath(BROWSE_BUTTON)).sendKeys(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\excelfiles\\uploadfiles\\" + images[i]);
			Thread.sleep(1000);
			waitForLoad(driver, testcaseName, 30, test);
			waitforElemPresent(driver, testcaseName, 10, reporting_value, test);
			setText(driver, testcaseName, reporting_value, reportingValue[i], test);
		}
		waitforElemPresent(driver, testcaseName, 10, save_button_ind, test);
		click(driver, testcaseName, save_button_ind, test);
		waitForLoad(driver, testcaseName, 30, test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']"), "Image Choice Added "+ param.get("imagechoice"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']"), "Image Choice Added "+ param.get("imagechoice"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("imagechoice") +"']/parent::div/following-sibling::div//li[@class='ng-scope']")).size();
		if(size == images.length) {
			reportPass("Image choice options added in the survey", test);
		} else {
			reportFail(testcaseName, "Image choice options not added in the survey", test);
		}
	}
	
	public void enterMultipleTextBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_textbox_button, test);
		doubleClick(driver, testcaseName, multiple_textbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multitextbox"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, multi_text1, test);
		setText(driver, testcaseName, multi_text1, param.get("textbox1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_text2, test);
		setText(driver, testcaseName, multi_text2, param.get("textbox2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr"), "Multi Text Box Added "+ param.get("multitextbox"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multitextbox") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Text Box options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Text Box options not added in the survey", test);
		}
	}
	
	public void enterMultiDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_dropdown_button, test);
		doubleClick(driver, testcaseName, multiple_dropdown_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multidropdown"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown1, test);
		setText(driver, testcaseName, multi_dropdown1, param.get("dropdown1"), test);
		waitforElemPresent(driver, testcaseName, 30, multi_dropdown2, test);
		setText(driver, testcaseName, multi_dropdown2, param.get("dropdown2"), test);
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr"), "Multi Drop Down Added "+ param.get("multidropdown"), test);
		int size = driver.findElements(By.xpath("//span[text()='"+ param.get("multidropdown") +"']/parent::div/following-sibling::div//tr")).size();
		if(size == 2) {
			reportPass("Multi Drop Down options added in the survey", test);
		} else {
			reportFail(testcaseName, "Multi Drop Down options not added in the survey", test);
		}
	}
	
	public void enterRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_radio_button, test);
		doubleClick(driver, testcaseName, multiple_radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multiradio"), test);
		driver.switchTo().defaultContent();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']"), "Radio Grid Added "+ param.get("multiradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multiradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Radio Grid Added "+ param.get("multiradio"), test);
		
	}
	
	public void enterCheckBoxGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, multiple_checkbox_button, test);
		doubleClick(driver, testcaseName, multiple_checkbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("multicheckbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary2(driver, param, param.get("AnswerOptions"), test);
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("multicheckbox") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "CheckBox Grid Added "+ param.get("multicheckbox"), test);
		
	}
	
	public void enterRatingRadioGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio_button, test);
		doubleClick(driver, testcaseName, rating_radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradio"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 1']"), "Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 1']"), "Yes", "Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 2']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 2']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@value='Choice 3']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@value='Choice 3']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Weight']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Weight']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Weight']"), "0", "Weight 3", test);
		
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradio") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Radio Grid Added "+ param.get("ratingradio"), test);
		
	}
	
	public void enterRatingDropDownGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_drop_down_button, test);
		doubleClick(driver, testcaseName, rating_drop_down_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdown"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		click(driver, testcaseName, By.xpath("//a[text()='Add/Edit Options']"), "Add/Edit Options", test);
		
		waitforElemPresent(driver, testcaseName, 30, iframe_add_manually, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_ADD_MANUALLY)));
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_0']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_0']"), "Yes", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_1']"), "Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_1']"), "No", "Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtChoice_2']"), "Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtChoice_2']"), "NA", "Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_0']"), "Weight 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_0']"), "2", "Weight 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_1']"), "Weight 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_1']"), "1", "Weight 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtWeight_2']"), "Weight 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtWeight_2']"), "0", "Weight 3", test);
		waitforElemPresent(driver, testcaseName, 10, save_button_manual, test);
		click(driver, testcaseName, save_button_manual, test);
		
		driver.switchTo().defaultContent();
		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdown") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Drop Down Grid Added "+ param.get("ratingdropdown"), test);
		
	}
	
	public void enterRatingScaleGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_scale_grid_button, test);
		doubleClick(driver, testcaseName, rating_scale_grid_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingscalegrid"), test);
		driver.switchTo().defaultContent();

		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		click(driver, testcaseName, By.xpath("//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']"), "Weight Highest", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		click(driver, testcaseName, By.xpath("//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']"), "Weight Middle", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtNA_0']"), "Weight NA", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtNA_0']"), "NA", "Weight NA", test);

		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingscalegrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Rating Scale Grid Added "+ param.get("ratingscalegrid"), test);
		
	}
	
	public void enterMatrixGridButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, matrix_grid_button, test);
		doubleClick(driver, testcaseName, matrix_grid_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("matrixgrid"), test);
		driver.switchTo().defaultContent();
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_Header']"), "Radio Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_Header']"), param.get("multiradio"), "Radio Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_Header']"), "Checkbox Grid Header", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_Header']"), param.get("multicheckbox"), "Checkbox Grid Header", test);

		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Radio Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_0_Choice']"), "Yes", "Radio Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "Radio Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_1_Choice']"), "No", "Radio Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "Radio Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_0_2_Choice']"), "NA", "Radio Choice 3", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Checkbox Choice 1", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_0_Choice']"), "Yes", "Checkbox Choice 1", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "Checkbox Choice 2", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_1_Choice']"), "No", "Checkbox Choice 2", test);
		
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "Checkbox Choice 3", test);
		setText(driver, testcaseName, By.xpath("//input[@name='txtGrid_1_2_Choice']"), "NA", "Checkbox Choice 3", test);

		questionsLibrary(driver, param, param.get("QuestionOptions"), test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("matrixgrid") +"']/parent::div/following-sibling::div//table[contains(@class,'minColTable')]"), "Matrix Grid Added "+ param.get("matrixgrid"), test);
		
	}
	
	public void enterHorizontalRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, horizontal_radio_button, test);
		doubleClick(driver, testcaseName, horizontal_radio_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("horizontalradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 30, other_checkbox, test);
		click(driver, testcaseName, other_checkbox, test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']"), "Horizontal Radio Buttons Label Added "+ param.get("horizontalradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("horizontalradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Horizontal Radio Buttons Added "+ param.get("horizontalradiobutton"), test);
	}
	
	public void enterNumericAllocationsButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, numeric_allocations_button, test);
		doubleClick(driver, testcaseName, numeric_allocations_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("numericallocations"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("numericallocations") +"']/parent::div/following-sibling::div//table[@class='minColTable']"), "Numeric Allocations Added "+ param.get("numericallocations"), test);
	}
	
	public void enterAttachmentButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, attachments_button, test);
		doubleClick(driver, testcaseName, attachments_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("attachments"), test);
		driver.switchTo().defaultContent();
		questionsLibrary2(driver, param, param.get("QuestionOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']"), "Attachments Added "+ param.get("attachments"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("attachments") +"']/parent::div/following-sibling::div//table[@class='minColTable ']"), "Attachments Added "+ param.get("attachments"), test);
	}
	
	public void enterRatingRadioButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_radio2_button, test);
		doubleClick(driver, testcaseName, rating_radio2_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingradiobutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']"), "Rating Radio Buttons "+ param.get("ratingradiobutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingradiobutton") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Rating Radio Buttons Added "+ param.get("ratingradiobutton"), test);
	}
	
	public void enterRatingDropDownButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, rating_dropdown_button, test);
		doubleClick(driver, testcaseName, rating_dropdown_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("ratingdropdownbutton"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions1"), test);
		
		for(int i = 1; i <= 10; i++) {
			waitforElemPresent(driver, testcaseName, 30, By.xpath("//input[@name='rating_weight"+ i +"']"), "Weight "+i, test);
			setText(driver, testcaseName, By.xpath("//input[@name='rating_weight"+ i +"']"), Integer.toString((i - 1)), "Weight "+i, test);
			Thread.sleep(1000);
		}
		
		waitforElemPresent(driver, testcaseName, 10, save_button, test);
		click(driver, testcaseName, save_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']"), "Rating Drop Down "+ param.get("ratingdropdownbutton"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("ratingdropdownbutton") +"']/parent::div/following-sibling::div/div[@class='Search-DD-Container ControlColorsDD']"), "Rating Drop Down Buttons Added "+ param.get("ratingdropdownbutton"), test);
	}
	
	public void enterListBoxButton(WebDriver driver, HashMap<String, String> param, ExtentTest test)
			throws InterruptedException {
		String testcaseName = param.get("TestCaseName");
		waitforElemPresent(driver, testcaseName, 30, listbox_button, test);
		doubleClick(driver, testcaseName, listbox_button, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, iframe_button, test);
		driver.switchTo().frame(driver.findElement(By.xpath(IFRAME_BUTTON)));
		waitforElemPresent(driver, testcaseName, 30, description_text, test);
		setText(driver, testcaseName, description_text, param.get("listbox"), test);
		driver.switchTo().defaultContent();
		answersLibrary(driver, param, param.get("AnswerOptions"), test);
		waitforElemPresent(driver, testcaseName, 10, other_checkbox2, test);
		click(driver, testcaseName, other_checkbox2, test);
		waitForLoad(driver, testcaseName, 30, test);
		
		
		waitforElemPresent(driver, testcaseName, 10, save_button_return, test);
		click(driver, testcaseName, save_button_return, test);
		waitForLoad(driver, testcaseName, 30, test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']"), "Listbox Added "+ param.get("listbox"), test);
		waitforElemPresent(driver, testcaseName, 30, By.xpath("//span[text()='"+ param.get("listbox") +"']/parent::div/following-sibling::div//ul[@class='ControlColorsRB']"), "Listbox Added "+ param.get("listbox"), test);
		
	}
}
