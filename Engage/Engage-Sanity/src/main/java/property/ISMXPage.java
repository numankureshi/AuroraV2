package property;

import utility.WebPageElements;

public interface ISMXPage {

	String CREATE_PROJECT = "//span[text()='Create Project']";
	WebPageElements create_project = new WebPageElements("Create Project Button", "xpath", CREATE_PROJECT);
	
	String BEGIN_LABEL = "//div[text()='Where would you like to begin?']";
	WebPageElements begin_label = new WebPageElements("Where would you like to begin?", "xpath", BEGIN_LABEL);
	
	String SURVEY_BUTTON = "//span[text()='Survey']";
	WebPageElements survey_button = new WebPageElements("Survey Button", "xpath", SURVEY_BUTTON);
	
	String BLANK_SURVEY = "//span[text()='Start with a Blank Survey']";
	WebPageElements blank_survey = new WebPageElements("Start with a Blank Survey Button", "xpath", BLANK_SURVEY);
	
	String CONTINUE_BUTTON = "//input[@id='btnContinue' and @type='button']";
	WebPageElements continue_button = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON);
	
	String CREATE_SURVEY_LABEL = "//div[text()='Create New Survey']";
	WebPageElements create_survey_label = new WebPageElements("Create New Survey Label", "xpath", CREATE_SURVEY_LABEL);
	
	String SURVEY_NAME = "//input[@name='txtSurveyTitle']";
	WebPageElements survey_name = new WebPageElements("Survey Name", "xpath", SURVEY_NAME);
	
	String FOLDER = "//div[@class='folder-select']";
	WebPageElements folder = new WebPageElements("Select Folder", "xpath", FOLDER);
	
	String PRIMARY_LANGUAGE_DD = "//select[@name='ddlPrimaryLang']";
	WebPageElements primary_lanugage_dd = new WebPageElements("Primary Langugage Drop down", "xpath", PRIMARY_LANGUAGE_DD);
	
	String START_BUTTON = "(//input[@value='Start'])[1]";
	WebPageElements start_button = new WebPageElements("Start Button", "xpath", START_BUTTON);
	
}
