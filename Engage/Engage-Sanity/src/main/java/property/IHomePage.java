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
	
	String SEARCH_BAR = "//input[@id='txtSearch']";
	WebPageElements search_bar = new WebPageElements("Search Bar", "xpath", SEARCH_BAR);
	
	String SEARCH_ICON = "//div[@id='SurveyGrid_dvsearchIcon']";
	WebPageElements search_icon = new WebPageElements("Search Icon", "xpath", SEARCH_ICON);	
	
	String ACCOUNT_SETTINGS= "//div[contains(@id,'dvAccountSettings')]";
	WebPageElements account_settings = new WebPageElements("Account settings", "xpath", ACCOUNT_SETTINGS);
	
	String LOGOUT_POPUP_OPTION= "//div[contains(text(),'Logout')]";
	WebPageElements logout_popup_option = new WebPageElements("Logout - Popup Option", "xpath", LOGOUT_POPUP_OPTION);

	
}
