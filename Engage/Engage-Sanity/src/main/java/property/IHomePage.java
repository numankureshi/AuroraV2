package property;

import utility.WebPageElements;

public interface IHomePage {
	
	String ALL_PROJECTS = "//div[@id='divBrowseAll']";
	WebPageElements all_projects = new WebPageElements("All Projects", "xpath", ALL_PROJECTS);
	
	String ALL_PROJECT_DASHBOARD_IFRAME = "//iframe[@id='iframe1']";
	WebPageElements all_project_dashboard_iframe = new WebPageElements("All project dashboard Iframe", "xpath", ALL_PROJECT_DASHBOARD_IFRAME);
	
	String MAIN_FOLDER = "//img[@class='openMain']";
	WebPageElements main_folder = new WebPageElements("Main Folder", "xpath", MAIN_FOLDER);
	
	String REPORT_ICON = "//div[@id='OverDivReport']/span";
	WebPageElements report_icon = new WebPageElements("Report Icon", "xpath", REPORT_ICON);
	
	String PUBLISH_ICON = "//div[@id='OverDivPublish']/span";
	WebPageElements publish_icon = new WebPageElements("Publish Icon", "xpath", PUBLISH_ICON);
	
	String TRACK_SURVEY_ICON = "//div[@id='OverDivTrack']/span";
	WebPageElements track_survey_icon = new WebPageElements("Track Survey Icon", "xpath", TRACK_SURVEY_ICON);
	
	String DATA_ICON = "//div[@id='OverDivData']/span";
	WebPageElements data_icon = new WebPageElements("Data Icon", "xpath", DATA_ICON);
	
	String EDIT_ICON = "//div[@id='OverDivEdit']/span";
	WebPageElements edit_icon = new WebPageElements("Edit Icon", "xpath", EDIT_ICON);
	
	String COPY_ICON = "//div[@id='OverDivCopy']/span";
	WebPageElements copy_icon = new WebPageElements("Copy Icon", "xpath", COPY_ICON);
	
	String COPY_DROP_DOWN = "//div[@id='dvMakeCopy']/ul[@id='qm-menu']";
	WebPageElements copy_drop_down = new WebPageElements("Copy Drop Down", "xpath", COPY_DROP_DOWN);
	
	String COPY_IN_SAME_ACC = "//a[@id='SurveyGrid_lnkBtnCopyToSameAccount']";
	WebPageElements copy_in_same_acc = new WebPageElements("Copy in Same Account Option", "xpath", COPY_IN_SAME_ACC);
	
	String FIRST_ROW = "(//div[@class='dRow'])[1]";
	WebPageElements first_row = new WebPageElements("First Project From All Project", "xpath", FIRST_ROW);
	
	String SEARCH_BAR = "//input[@id='txtSearch']";
	WebPageElements search_bar = new WebPageElements("Search Bar", "xpath", SEARCH_BAR);
	
	String SEARCH_ICON = "//div[@id='SurveyGrid_dvsearchIcon']";
	WebPageElements search_icon = new WebPageElements("Search Icon", "xpath", SEARCH_ICON);	
	
	String ACCOUNT_SETTINGS= "//div[contains(@id,'dvAccountSettings')]";
	WebPageElements account_settings = new WebPageElements("Account settings", "xpath", ACCOUNT_SETTINGS);
	
	String LOGOUT_POPUP_OPTION= "//div[contains(text(),'Logout')]";
	WebPageElements logout_popup_option = new WebPageElements("Logout - Popup Option", "xpath", LOGOUT_POPUP_OPTION);
	
	String MAIN_LOADER= "//div[@class='loader']";
	WebPageElements main_loader = new WebPageElements("Loader", "xpath", MAIN_LOADER);
	
	String SURVEY_TITLE= "//div[contains(@class,'dContent')]";
	WebPageElements survey_title = new WebPageElements("Survey Title", "xpath", SURVEY_TITLE);
	
	String EDIT_SURVEY_TITLE= "//input[@id='SurveyGrid_txtNewSurveyTitle']";
	WebPageElements edit_survey_title = new WebPageElements("Edit Survey Title", "xpath", EDIT_SURVEY_TITLE);
	
	String SAVE_SURVEY_TITLE= "//input[contains(@id,'SurveyGrid_btnChangeTitle')]";
	WebPageElements save_survey_title = new WebPageElements("Save Survey Title", "xpath", SAVE_SURVEY_TITLE);
	
	String SMALL_LOADER= "//img[contains(@id,'imgSmallLoader')]";
	WebPageElements small_loader = new WebPageElements("Loader", "xpath", SMALL_LOADER);

	
}
