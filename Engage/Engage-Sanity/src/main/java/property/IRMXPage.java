package property;

import utility.WebPageElements;

public interface IRMXPage {
	
	String REPORT_TAB = "//a[@id='Inner_header1_ctl00_arm']";
	WebPageElements report_tab = new WebPageElements("Report Tab", "xpath", REPORT_TAB);
	
	String OMNI_REPORT = "//div[@id='btnOmniReport']/span";
	WebPageElements omni_report = new WebPageElements("OMNI Report Button", "xpath", OMNI_REPORT);
	
	String OMNI_MODIFY_REPORT = "//span[contains(text(),'Modify Report')]";
	WebPageElements omni_modify_report = new WebPageElements("Modify Report - OMNI", "xpath", OMNI_MODIFY_REPORT);
	
	String RAW_DATA = "//div[@id='btnIndividual']/span";
	WebPageElements raw_data = new WebPageElements("Raw Data", "xpath", RAW_DATA);
	
	String RAW_DATA_MENU = "//div[@id ='dvIndiviual']/ul";
	WebPageElements raw_data_menu = new WebPageElements("Raw Data Menu", "xpath", RAW_DATA_MENU);
	
	String INDIVIDUAL_REPORT = "//li[@id='ddindividual']";
	WebPageElements individual_report = new WebPageElements("Individual Report", "xpath", INDIVIDUAL_REPORT);
	
	String WIZARD_PAGE_DESCRIPTION = "//div[contains(@class,'pageDescription')]/span";
	WebPageElements wizard_page_description = new WebPageElements("Wizard Page Description", "xpath", WIZARD_PAGE_DESCRIPTION);
	
	String ALL_QUESTIONS = "//label[contains(@class,'fontbold')]";
	WebPageElements all_questions = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS);
	
	String WIZARD_STEP1_CONTINUE = "//input[@id='btnstep1Next']";
	WebPageElements wizard_step1_continue = new WebPageElements("Report Wizard - Step 1 Continue", "xpath", WIZARD_STEP1_CONTINUE);
	
	String WIZARD_STEP3_CONTINUE = "//input[@id='btnstep3Next']";
	WebPageElements wizard_step3_continue = new WebPageElements("Report Wizard - Step 3 Continue", "xpath", WIZARD_STEP3_CONTINUE);
	
	String GENERATE_NOW_BUTTON = "//input[@id='btnstep4Next']";
	WebPageElements generate_now_button = new WebPageElements("Generate Now", "xpath", GENERATE_NOW_BUTTON);
	
	String SURVEY_METRIC = "//div[@id='dvSurveyMetrics']";
	WebPageElements survey_metric = new WebPageElements("Survey Metric", "xpath", SURVEY_METRIC);
	
	String INDIVIDUAL_REPORT_ANSWER_FIELD = "//div[@class='spananswer']";
	WebPageElements individual_report_answer_field = new WebPageElements("Individual Report - Answer field", "xpath", INDIVIDUAL_REPORT_ANSWER_FIELD);
	
	String INDIVIDUAL_REPORT_EMAILID_FIELD = "//div[@class='tindDatatd']/span/b";
	WebPageElements individual_report_emailid_field = new WebPageElements("Individual Report - Email ID field", "xpath", INDIVIDUAL_REPORT_EMAILID_FIELD);
	
	String INDIVIDUAL_REPORT_RESPONSE_NUMBER_FIELD = "//div[@class='tindDatatd']/b/span";
	WebPageElements individual_report_response_number_field = new WebPageElements("Individual Report - Response Number field", "xpath", INDIVIDUAL_REPORT_RESPONSE_NUMBER_FIELD);
	
	String INDIVIDUAL_REPORT_PARTICIPATION_TIME = "//div[@class='tindDatatd']/b";
	WebPageElements individual_report_participation_time = new WebPageElements("Individual Report - Participation Time", "xpath", INDIVIDUAL_REPORT_PARTICIPATION_TIME);
	
	String SELECT_PAGE_DROP_DOWN = "//select[@id='cmbPageSel']";
	WebPageElements select_page_drop_down = new WebPageElements("Individual Report - Select Page", "xpath", SELECT_PAGE_DROP_DOWN);
	
	String INDIVIDUAL_REPORT_NEXT_BUTTON = "//input[@name='ImgBtnNextRec']";
	WebPageElements individual_report_next_button = new WebPageElements("Individual Report - Next Button", "xpath", INDIVIDUAL_REPORT_NEXT_BUTTON);
	
	String INDIVIDUAL_REPORT_PREVIOUS_BUTTON = "//input[@name='ImgBtnPrevRec']";
	WebPageElements individual_report_previous_button = new WebPageElements("Individual Report - Previous Button", "xpath", INDIVIDUAL_REPORT_PREVIOUS_BUTTON);
	
	String RESPONSE_TABLE_REPORT = "//li[@id='btnResponseTable']";
	WebPageElements response_table_report = new WebPageElements("Response Table Report", "xpath", RESPONSE_TABLE_REPORT);
	
	String RESPONSE_TB_SELECT_RESPONSE_DD = "//select[@id='cmbResponse']";
	WebPageElements response_table_select_response_dd = new WebPageElements("Response Table Report - Select Page", "xpath", RESPONSE_TB_SELECT_RESPONSE_DD);
	
	String RESPONSE_TB_ANSWER_FIELD = "//td[@class='responsetd']";
	WebPageElements response_table_answer_field = new WebPageElements("Response Table Report - Answer field", "xpath", RESPONSE_TB_ANSWER_FIELD);

}
