package property;

import utility.WebPageElements;

public interface IHomePage {
	
	String ALL_PROJECTS = "//div[@id='divBrowseAll']";
	WebPageElements all_projects = new WebPageElements("All Projects", "xpath", ALL_PROJECTS);
	
	String ALL_PROJECTS2 = "//div[text()='All Projects']";
	WebPageElements all_projects2 = new WebPageElements("All Projects", "xpath", ALL_PROJECTS2);
	
	String ALL_PROJECTS3 = "//span[text()=' All Projects']";
	WebPageElements all_projects3 = new WebPageElements("All Projects", "xpath", ALL_PROJECTS3);
	
	String HAMBURGER_ICON = "//div[@class='hd-main-DD']";
	WebPageElements hamburger_icon = new WebPageElements("Hamburger Main Icon", "xpath", HAMBURGER_ICON);
	
	String ALL_PROJECT_DASHBOARD_IFRAME = "//iframe[@id='iframe1']";
	WebPageElements all_project_dashboard_iframe = new WebPageElements("All project dashboard Iframe", "xpath", ALL_PROJECT_DASHBOARD_IFRAME);
	
	String CLOSE_BUTTON = "//div[@id='dvcloseModal']";
	WebPageElements close_button = new WebPageElements("Close Dashboard", "xpath", CLOSE_BUTTON);
	
	String MAIN_FOLDER = "//img[@class='openMain']";
	WebPageElements main_folder = new WebPageElements("Main Folder", "xpath", MAIN_FOLDER);
	
	String NEW_MAIN_FOLDER = "//span[text()='Main']";
	WebPageElements new_main_folder = new WebPageElements("Main Folder", "xpath", NEW_MAIN_FOLDER);
	
	String REPORT_ICON = "//div[@id='OverDivReport']/span";
	WebPageElements report_icon = new WebPageElements("Report Icon", "xpath", REPORT_ICON);
	
	String PUBLISH_ICON = "//div[@id='OverDivPublish']/span";
	WebPageElements publish_icon = new WebPageElements("Publish Icon", "xpath", PUBLISH_ICON);
	
	String NEW_PUBLISH_ICON = "//div[@id='OverDivPublish'][@style='display: flex;']/span";
	WebPageElements new_publish_icon = new WebPageElements("Publish Icon", "xpath", NEW_PUBLISH_ICON);
	
	String TRACK_SURVEY_ICON = "//div[@id='OverDivTrack']/span";
	WebPageElements track_survey_icon = new WebPageElements("Track Survey Icon", "xpath", TRACK_SURVEY_ICON);
	
	String NEW_TRACK_SURVEY_ICON = "//div[@id='OverDivTrack'][@style='display: flex;']/span";
	WebPageElements new_track_survey_icon = new WebPageElements("Track Survey Icon", "xpath", NEW_TRACK_SURVEY_ICON);
	
	String DATA_ICON = "//div[@id='OverDivData']/span";
	WebPageElements data_icon = new WebPageElements("Data Icon", "xpath", DATA_ICON);
	
	String NEW_DATA_ICON = "//div[@id='OverDivData'][@style='display: flex;']/span";
	WebPageElements new_data_icon = new WebPageElements("Data Icon", "xpath", NEW_DATA_ICON);
	
	String NEW_REPORT_ICON = "//div[@id='OverDivReport'][@style='display: flex;']/span";
	WebPageElements new_report_icon = new WebPageElements("Report Icon", "xpath", NEW_REPORT_ICON);
	
	String EDIT_ICON = "//div[@id='OverDivEdit']/span";
	WebPageElements edit_icon = new WebPageElements("Edit Icon", "xpath", EDIT_ICON);
	
	String NEW_EDIT_ICON = "//div[@id='OverDivEdit'][@style='display: flex;']/span";
	WebPageElements new_edit_icon = new WebPageElements("Edit Icon", "xpath", NEW_EDIT_ICON);
	
	String MORE_ICON = "//div[@id='divSurveyMoreButton'][@style='position: relative; display: flex;']";
	WebPageElements more_icon = new WebPageElements("More Icon", "xpath", MORE_ICON);
	
	String DOWNLOAD = "//div[@class='survey more-button-options top-arrow']/div/span[contains(text(),'Download')]";
	WebPageElements download = new WebPageElements("Download", "xpath", DOWNLOAD);
	
	String PDF = "//div[@class='survey more-button-options top-arrow']//a[@id='pdf']";
	WebPageElements pdf = new WebPageElements("Adobe PDF", "xpath", PDF);
	
	String WORD = "//div[@id='over-div-contents']//a[@id='word']";
	WebPageElements word = new WebPageElements("MS Word", "xpath", WORD);
	
	String SCANNER_READY = "//div[@id='over-div-contents']//a[@id='A1']";
	WebPageElements scanner_ready = new WebPageElements("Scanner Ready", "xpath", SCANNER_READY);
	
	String DELETE = "//div[@id='over-div-contents']//div[contains(@class,'survey more-button-options')]/div/span[contains(text(),'Delete')]";
	WebPageElements delete = new WebPageElements("Delete", "xpath", DELETE);
	
	String DELETE_POLL = "//div[@id='over-div-contents']//div[contains(@class,'survey1 more-button-options')]/div/span[contains(text(),'Delete')]";
	WebPageElements delete_poll = new WebPageElements("Delete", "xpath", DELETE_POLL);
	
	String COPY_ICON = "//div[@id='OverDivCopy']/span";
	WebPageElements copy_icon = new WebPageElements("Copy Icon", "xpath", COPY_ICON);
	
	String NEW_COPY_ICON = "(//div[@id='OverDivCopy'][@style='display: flex;']/span)[2]";
	WebPageElements new_copy_icon = new WebPageElements("Copy Icon", "xpath", NEW_COPY_ICON);
	
	String COPY_DROP_DOWN = "//div[@id='dvMakeCopy']/ul[@id='qm-menu']";
	WebPageElements copy_drop_down = new WebPageElements("Copy Drop Down", "xpath", COPY_DROP_DOWN);
	
	String NEW_COPY_DROP_DOWN = "(//div[@id='dvMakeCopy']/ul[@id='qm-menu'])[2]";
	WebPageElements new_copy_drop_down = new WebPageElements("Copy Drop Down", "xpath", NEW_COPY_DROP_DOWN);
	
	String COPY_IN_SAME_ACC = "//a[@id='SurveyGrid_lnkBtnCopyToSameAccount']";
	WebPageElements copy_in_same_acc = new WebPageElements("Copy in Same Account Option", "xpath", COPY_IN_SAME_ACC);
	
	String NEW_COPY_IN_SAME_ACC = "(//a[@id='lnkBtnCopyToSameAccount'])[2]";
	WebPageElements new_copy_in_same_acc = new WebPageElements("Copy in Same Account Option", "xpath", NEW_COPY_IN_SAME_ACC);
	
	String COPY_IN_DIFF_ACC = "//div[@id='over-div-contents']//a[@id='lnkBtnCopyToDifferentAccount']";
	WebPageElements copy_in_diff_acc = new WebPageElements("Copy into Different Account", "xpath", COPY_IN_DIFF_ACC);
	
	String USERID_COPIED_INTO = "//input[@id='txtCorporateID']";
	WebPageElements userid_copied_into = new WebPageElements("User ID", "xpath", USERID_COPIED_INTO);
	
	String COPY = "//input[@id='btnCopyToDiffAcc']";
	WebPageElements copy = new WebPageElements("Copy", "xpath", COPY);
	
	String FIRST_ROW = "(//div[@class='dRow'])[1]";
	WebPageElements first_row = new WebPageElements("First Project From All Project", "xpath", FIRST_ROW);
	
	String NEW_FIRST_ROW = "(//tr[@class='tr-All-Data ng-scope'])[1]";
	WebPageElements new_first_row = new WebPageElements("First Project From All Project", "xpath", NEW_FIRST_ROW);
	
	String SEARCH_BAR = "//input[@id='txtSearch']";
	WebPageElements search_bar = new WebPageElements("Search Bar", "xpath", SEARCH_BAR);
	
	String NEW_SEARCH_BAR = "//input[@id='InSearchText']";
	WebPageElements new_search_bar = new WebPageElements("Search Bar", "xpath", NEW_SEARCH_BAR);
	
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
	
	String NEW_SURVEY_TITLE= "//div[contains(@ng-click,'fnEditTitle')]";
	WebPageElements new_survey_title = new WebPageElements("Survey Title", "xpath", NEW_SURVEY_TITLE);
	
	String EDIT_SURVEY_TITLE= "//input[@id='SurveyGrid_txtNewSurveyTitle']";
	WebPageElements edit_survey_title = new WebPageElements("Edit Survey Title", "xpath", EDIT_SURVEY_TITLE);
	
	String NEW_EDIT_SURVEY_TITLE= "//input[@id='txtNewSurveyTitle']";
	WebPageElements new_edit_survey_title = new WebPageElements("Edit Survey Title", "xpath", NEW_EDIT_SURVEY_TITLE);
	
	String SAVE_SURVEY_TITLE= "//input[contains(@id,'SurveyGrid_btnChangeTitle')]";
	WebPageElements save_survey_title = new WebPageElements("Save Survey Title", "xpath", SAVE_SURVEY_TITLE);
	
	String NEW_SAVE_SURVEY_TITLE= "//a[@id='EditcontSaveButton']";
	WebPageElements new_save_survey_title = new WebPageElements("Save Survey Title", "xpath", NEW_SAVE_SURVEY_TITLE);
	
	String SMALL_LOADER= "//img[contains(@id,'imgSmallLoader')]";
	WebPageElements small_loader = new WebPageElements("Loader", "xpath", SMALL_LOADER);

	String FILTER_APPLIED= "//div[@id='dvFilterApplied']";
	WebPageElements filter_applied = new WebPageElements("Filter", "xpath", FILTER_APPLIED);
	
	String LOGO_HOME= "//a[contains(@href,'/zHome/home.aspx')]";
	WebPageElements logo_home = new WebPageElements("Logo - Home", "xpath", LOGO_HOME);
	
}
