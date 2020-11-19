package property;

import utility.WebPageElements;

public interface IDMXPage {

	String PUBLISH_BUTTON = "//span[text()='Publish']";
	WebPageElements publish_button = new WebPageElements("Publish Button", "xpath", PUBLISH_BUTTON);
	
	String SINGLE_USE_LINK = "(//span[text()='Single-Use Link']/ancestor::div[@class='front-face'])[1]";
	WebPageElements single_use_link_button = new WebPageElements("Single Use Link Button", "xpath", SINGLE_USE_LINK);
	
	String SELECT_EMAIL_MESSAGE = "//a[text()='Select Email Message']";
	WebPageElements select_email_message = new WebPageElements("Select Email Message", "xpath", SELECT_EMAIL_MESSAGE);
	
	String SEARCH_EMAIL = "(//input[contains(@class,'searchText ui-autocomplete-input')])[1]";
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
	
	String FROM_A_LIST = "//div[text()='From a List']/ancestor::div[@id='divFromList']";
	WebPageElements from_a_list = new WebPageElements("From A List", "xpath", FROM_A_LIST);
	
	String SELECT_LIST = "//select[@name='ddSelectList']";
	WebPageElements select_list = new WebPageElements("Select List", "xpath", SELECT_LIST);
	
	String IFRAME_EMAIL_TEMPLATE = "(//iframe[contains(@src,'/zDM/invitationEmailContent.aspx?')])[1]";
	WebPageElements iframe_email_template = new WebPageElements("IFrame mail template", "xpath", IFRAME_EMAIL_TEMPLATE);
	
	String INVITE_IN_SEPERATE_EMAIL = "//label[text()='Send each invitation link in a separate email for every occurrence of email']";
	WebPageElements invite_in_seperate_email = new WebPageElements("invitation link in a separate email", "xpath", INVITE_IN_SEPERATE_EMAIL);
	
	String PRE_POP_SURVEY = "//label[text()='Pre-Populate Survey']";
	WebPageElements pre_pop_survey = new WebPageElements("Pre-Populate Survey", "xpath", PRE_POP_SURVEY);
	
	String PRE_POP_SURVEY_INPUT = "//input[@name='chkPrepop']";
	WebPageElements pre_pop_survey_input = new WebPageElements("Pre-Populate Survey", "xpath", PRE_POP_SURVEY_INPUT);
	
	String MAIL_MERGE = "(//a[contains(text(),'Mail Merge')])[2]";
	WebPageElements mail_merge = new WebPageElements("Mail merge", "xpath", MAIL_MERGE);
	
	String MAIL_MERGE_DD1 = "//select[@name='ddlAttributeNames0']";
	WebPageElements mail_merge_dd1 = new WebPageElements("Mail merge Drop down 1", "xpath", MAIL_MERGE_DD1);
	
	String MAIL_MERGE_DD2 = "//select[@name='ddlAttributeNames1']";
	WebPageElements mail_merge_dd2 = new WebPageElements("Mail merge Drop down 2", "xpath", MAIL_MERGE_DD2);
	
	String MAIL_MERGE_DD3 = "//select[@name='ddlAttributeNames2']";
	WebPageElements mail_merge_dd3 = new WebPageElements("Mail merge Drop down 3", "xpath", MAIL_MERGE_DD3);
	
	String MAIL_MERGE_TXT1 = "//input[@name='txtMailMerge0']";
	WebPageElements mail_merge_txt1 = new WebPageElements("Mail merge Text Box 1", "xpath", MAIL_MERGE_TXT1);
	
	String MAIL_MERGE_TXT2 = "//input[@name='txtMailMerge1']";
	WebPageElements mail_merge_txt2 = new WebPageElements("Mail merge Text Box 2", "xpath", MAIL_MERGE_TXT2);
	
	String MAIL_MERGE_TXT3 = "//input[@name='txtMailMerge2']";
	WebPageElements mail_merge_txt3 = new WebPageElements("Mail merge Text Box 3", "xpath", MAIL_MERGE_TXT3);
	
	String MAP_ANSWERS = "//a[contains(text(),'Map Answers')]";
	WebPageElements map_answers = new WebPageElements("Map Answers", "xpath", MAP_ANSWERS);
	
	String PRE_POP_DD = "//select[@name='ddOption_0']";
	WebPageElements pre_pop_dd = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD);
	
	String REVIEW_DATE = "(//a[text()='Review Data'])[2]";
	WebPageElements review_data = new WebPageElements("Review Data", "xpath", REVIEW_DATE);
	
	String SEND_OR_SCHEDULE = "//a[contains(text(),'Send Or Schedule')]";
	WebPageElements send_or_schedule = new WebPageElements("Send Or Schedule", "xpath", SEND_OR_SCHEDULE);
	
	String SEND_NOW = "//input[@name='btnSubmit']";
	WebPageElements send_now = new WebPageElements("Send Now", "xpath", SEND_NOW);
	
	String INVITATION_SENT = "//font[contains(text(),'You have sent')]";
	WebPageElements invitation_sent = new WebPageElements("You have sent", "xpath", INVITATION_SENT);
	
	String INVITATION_SENT_EXE = "//font[contains(text(),'invitation(s) have been queued for delivery. You will be notified via email')]";
	WebPageElements invitation_sent_exe = new WebPageElements("have been queued for delivery ", "xpath", INVITATION_SENT_EXE);
	
	String REMINDERS = "(//span[contains(text(),'Reminders')])[1]";
	WebPageElements reminders = new WebPageElements("Reminders", "xpath", REMINDERS);
	
	String ORIGINAL_INVITATION_DATE_FILTER = "//span[text()='Original Invitation Date']/ancestor::th/img[@class='v-mid FilterImage']";
	WebPageElements original_invitation_date_filter = new WebPageElements("Original Invitation Date", "xpath", ORIGINAL_INVITATION_DATE_FILTER);
	
	String ON_DATE = "(//label[@for='onDate'])[1]";
	WebPageElements on_date = new WebPageElements("On Date", "xpath", ON_DATE);
	
	String CALENDAR = "//img[contains(@src,'icon-calendar-active.png') and @id='img_invsdate']";
	WebPageElements calendar = new WebPageElements("Calendar", "xpath", CALENDAR);
	
	String YEAR = "//select[@class='ui-datepicker-year']";
	WebPageElements year = new WebPageElements("Calendar - Year", "xpath", YEAR);
	
	String MONTH = "//select[@class='ui-datepicker-month']";
	WebPageElements month = new WebPageElements("Calendar - Month", "xpath", MONTH);
	
	String DONE_BUTTON3 = "//input[@name='btninvdate']";
	WebPageElements done_button3 = new WebPageElements("Done Button", "xpath", DONE_BUTTON3);
	
	String SCHEDULE_REMINDER = "//input[@name='btnSendReminderNew']";
	WebPageElements schedule_reminder = new WebPageElements("Schedule Reminder Button", "xpath", SCHEDULE_REMINDER);
	
	String QUICK_SEND = "//div[@id='inviteddl_divQuickSend']";
	WebPageElements quick_send = new WebPageElements("Quick send button", "xpath", QUICK_SEND);

	
}


