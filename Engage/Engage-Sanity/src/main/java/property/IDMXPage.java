package property;

import utility.WebPageElements;

public interface IDMXPage {

	String PUBLISH_BUTTON = "//span[text()='Publish']";
	WebPageElements publish_button = new WebPageElements("Publish Button", "xpath", PUBLISH_BUTTON);
	
	String SINGLE_USE_LINK = "(//span[text()='Single-Use Link']/ancestor::div[@class='front-face'])[1]";
	WebPageElements single_use_link_button = new WebPageElements("Single Use Link Button", "xpath", SINGLE_USE_LINK);
	
	String SELECT_EMAIL_MESSAGE = "//a[text()='Select Email Message']";
	WebPageElements select_email_message = new WebPageElements("Select Email Message", "xpath", SELECT_EMAIL_MESSAGE);
	
	String SEARCH_EMAIL = "(//input[@class='searchText ui-autocomplete-input'])[1]";
	WebPageElements search_email = new WebPageElements("Search Email", "xpath", SEARCH_EMAIL);
	
	String EDIT_BUTTON = "//span[text()='Edit ']";
	WebPageElements edit_button = new WebPageElements("Edit Button", "xpath", EDIT_BUTTON);
	
	String EDIT_SUBJECT = "//span[@id='hlSubject']";
	WebPageElements edit_subject = new WebPageElements("Edit Subject - Email Template", "xpath", EDIT_SUBJECT);
	
	String EDIT_SUBJECT_HOVER = "//span[@id='hlSubject']/parent::div";
	WebPageElements edit_subject_hover = new WebPageElements("Edit Subject - Email Template", "xpath", EDIT_SUBJECT_HOVER);
	
	String EDIT_SUBJECT_ICON = "//span[@id='hlSubject']/following-sibling::img";
	WebPageElements edit_subject_icon = new WebPageElements("Edit Subject Icon - Email Template", "xpath", EDIT_SUBJECT_ICON);
	
	String EDIT_SUBJECT_SAVE = "(//span[@id='hlSubject']//following::input[@name='btn_Save'])[1]";
	WebPageElements edit_subject_save = new WebPageElements("Edit Subject Save - Email Template", "xpath", EDIT_SUBJECT_SAVE);
	
	String DONE_EDITING = "//input[@name='btnNext']";
	WebPageElements done_editing_button = new WebPageElements("Done Editing Button", "xpath", DONE_EDITING);
	
	String SAVE_OVERWRITE = "//label[text()='Save and Overwrite']";
	WebPageElements save_overwrite_button = new WebPageElements("Save and Overwrite Button", "xpath", SAVE_OVERWRITE);
	
	String DONE_BUTTON = "//input[@name='btnSave']";
	WebPageElements done_button = new WebPageElements("Done Editing Button", "xpath", DONE_BUTTON);
	
	String SOURCE_EMAIL = "//a[contains(text(),'Select Source')]";
	WebPageElements source_email = new WebPageElements("Select Source", "xpath", SOURCE_EMAIL);
}
