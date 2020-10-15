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
	
	String SECONDARY_LANGUAGE_DD = "//div[@class='SecondaryHolder']";
	WebPageElements secondary_lanugage_dd = new WebPageElements("Secondary Langugage Drop down", "xpath", SECONDARY_LANGUAGE_DD);
	
	String SECONDARY_LANGUAGE_DD_SEARCH = "//input[@class='SearchInput']";
	WebPageElements secondary_lanugage_dd_search = new WebPageElements("Secondary Langugage Drop down Search", "xpath", SECONDARY_LANGUAGE_DD_SEARCH);
	
	String START_BUTTON = "(//input[@value='Start'])[1]";
	WebPageElements start_button = new WebPageElements("Start Button", "xpath", START_BUTTON);
	
	String SECONDARY_LANGUAGE_SWITCH = "//input[@id='rdOtherLangYes']";
	WebPageElements secondary_language_switch = new WebPageElements("Secondary Language Switch", "xpath", SECONDARY_LANGUAGE_SWITCH);
	
	String DESCRIPTION_BUTTON = "//div[contains(text(),'Descriptive Text')]/parent::div[@id='dvcom']";
	WebPageElements description_button = new WebPageElements("Description Button", "xpath", DESCRIPTION_BUTTON);
	
	String NET_PROMOTER_BUTTON = "//div[contains(text(),'Net Promoter')]/parent::div[@id='dvrat_NPS']";
	WebPageElements net_promoter_score_button = new WebPageElements("Net Promoter Button", "xpath", NET_PROMOTER_BUTTON);
	
	String TEXT_BOX_BUTTON = "//div[contains(text(),'Text Box')]/parent::div[@id='dvtb']";
	WebPageElements text_box_button = new WebPageElements("Text Box Button", "xpath", TEXT_BOX_BUTTON);
	
	String IFRAME_BUTTON = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
	WebPageElements iframe_button = new WebPageElements("Iframe Button", "xpath", IFRAME_BUTTON);
	
	String DESCRIPTION_TEXT = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']";
	WebPageElements description_text = new WebPageElements("Description Text Input", "xpath", DESCRIPTION_TEXT);
	
	String SAVE_BUTTON = "//input[@name='btnSaveQuestionAnswer']";
	WebPageElements save_button = new WebPageElements("Save Button", "xpath", SAVE_BUTTON);
	
}
