package property;

import utility.WebPageElements;

public interface IDMXPage {

	String PUBLISH_BUTTON = "//span[text()='Publish']";
	WebPageElements publish_button = new WebPageElements("Publish Button", "xpath", PUBLISH_BUTTON);
	
	String SINGLE_USE_LINK = "(//span[text()='Single-Use Link']/ancestor::div[@class='front-face'])[1]";
	WebPageElements single_use_link_button = new WebPageElements("Single Use Link Button", "xpath", SINGLE_USE_LINK);
	
	String SURVEY_PASSWORDS = "(//span[contains(text(),'Survey Passwords')]/ancestor::div[@class='front-face'])[1]";
	WebPageElements survey_passwords = new WebPageElements("Survey Passwords", "xpath", SURVEY_PASSWORDS);
	
	String CREATE_CONTACT = "//a[text()='Contact Lists']";
	WebPageElements create_contact = new WebPageElements("Contact Lists", "xpath", CREATE_CONTACT);
	
	String SEARCH_CONTACT_LIST = "//input[@id='txtContactSearch']";
	WebPageElements search_contact_list = new WebPageElements("Search Contact Lists", "xpath", SEARCH_CONTACT_LIST);
	
	String SEARCH_CONTACT_LIST_ICON = "//div[@class='contact-list-btn']";
	WebPageElements search_contact_list_icon = new WebPageElements("Search Contact Lists Icon", "xpath", SEARCH_CONTACT_LIST);
	
	String VIEW_MODIFY_CONTACT_LIST = "(//input[@value= 'View / Modify'])[1]";
	WebPageElements view_modify_contact_list = new WebPageElements("View/Modify Contact Lists Button", "xpath", VIEW_MODIFY_CONTACT_LIST);
	
	String TOTAL_RECORD_FIELD = "//span[@id='ctl00_ctl00_cphMain_cphBody_ModifyList_lblsummaryTotalRecordsValue']";
	WebPageElements total_record_field = new WebPageElements("Contact Lists - Total Record Field", "xpath", TOTAL_RECORD_FIELD);
	
	String CONTACT_LIST_FIELDS = "//a[contains(@id,'Gv_ListDetails')]";
	WebPageElements contact_list_fields = new WebPageElements("Contact Lists - Fields ", "xpath", CONTACT_LIST_FIELDS);
	
	String CONTACT_LIST_HEADER_FIELDS = "//th//a[contains(@href,'Gv_ListDetails')][2]";
	WebPageElements contact_list_header_fields = new WebPageElements("Contact Lists -Header Fields ", "xpath", CONTACT_LIST_HEADER_FIELDS);
	
	String CONTACT_LIST_ROW = "//tr[contains(@onclick,'ListDetails__ctl')]";
	WebPageElements contact_list_row = new WebPageElements("Contact Lists - Row ", "xpath", CONTACT_LIST_ROW);
	
	String CONTACT_LIST_DROP_DOWN = "//select[contains(@id,'ModifyList_gridrecords')]";
	WebPageElements contact_list_drop_down = new WebPageElements("Contact Lists - Page Drop Down ", "xpath", CONTACT_LIST_DROP_DOWN);
	
	String LIST_CHCKBOX = "//input[@type='checkbox' and contains(@name,'chk_ListId')]";
	WebPageElements list_checkbox = new WebPageElements("Contact Lists Checkbox", "xpath", LIST_CHCKBOX);
	
	String DELETE_BUTTON = "(//input[@value='Delete'])[1]";
	WebPageElements delete_button = new WebPageElements("Delete Button", "xpath", DELETE_BUTTON);
	
	String DELETE_MSG = "//span[contains(text(),'List  deleted successfully.')]";
	WebPageElements delete_msg = new WebPageElements("Delete Message", "xpath", DELETE_MSG);
	
	String CREATE_NEW = "(//input[@value='Create New'])[1]";
	WebPageElements create_new = new WebPageElements("Create New", "xpath", CREATE_NEW);
	
	String LIST_NAME = "//input[@placeholder='Enter list name']";
	WebPageElements list_name = new WebPageElements("List Name", "xpath", LIST_NAME);
	
	String CREATE_NEW_LIST = "//a[text()='List']";
	WebPageElements create_new_list = new WebPageElements("Create New List", "xpath", CREATE_NEW_LIST);
	
	String SINGLE_USE_PWD = "//div[text()='Single-Use Passwords']/parent::div";
	WebPageElements single_use_pwd = new WebPageElements("Survey Passwords", "xpath", SINGLE_USE_PWD);

	String SMS_INVITATION = "(//span[text()='SMS Invitation ']/ancestor::div[@class='front-face'])[1]";
	WebPageElements sms_invitation = new WebPageElements("SMS Invitation Button", "xpath", SMS_INVITATION);
	
	String SELECT_EMAIL_MESSAGE = "//a[text()='Select Email Message']";
	WebPageElements select_email_message = new WebPageElements("Select Email Message", "xpath", SELECT_EMAIL_MESSAGE);
	
	String USE_EXISTING_LIST = "//div[text()='Use an existing Contact List']/parent::div";
	WebPageElements use_existing_list = new WebPageElements("Use Existing List", "xpath", USE_EXISTING_LIST);
	
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
	
	String SEND_UNIQUE = "//input[@name='btnSendUnique']";
	WebPageElements send_unique = new WebPageElements("Send Unique Button", "xpath", SEND_UNIQUE);
	
	String EDIT_SUBJECT_SAVE = "(//span[@id='hlSubject']//following::input[@name='btn_Save'])[1]";
	WebPageElements edit_subject_save = new WebPageElements("Edit Subject Save - Email Template", "xpath", EDIT_SUBJECT_SAVE);
	
	String DONE_EDITING = "//input[@name='btnNext']";
	WebPageElements done_editing_button = new WebPageElements("Done Editing Button", "xpath", DONE_EDITING);
	
	String GENERATE_NEW_URL = "//a[text()='Generate New URL']";
	WebPageElements generate_new_url = new WebPageElements("Generate New URL", "xpath", GENERATE_NEW_URL);
	
	String ALLOW_DUPLICATE = "//input[contains(@name,'chkDuplicateFile')]";
	WebPageElements allow_duplicate = new WebPageElements("Allow duplicate email addresses", "xpath", ALLOW_DUPLICATE);
	
	String CONTINUE_BUTTON3 = "//input[@value='Continue' and @type='submit']";
	WebPageElements continue_button3 = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON3);
	
	String CONTINUE_BUTTON1 = "//input[@id='btnContinue']";
	WebPageElements continue_button1 = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON1);
	
	String SMS_INVITES_REMINDER = "//div[text()='SMS Invitations']";
	WebPageElements sms_invites_reminder = new WebPageElements("SMS Invitations", "xpath", SMS_INVITES_REMINDER);
	
	String SAVE_OVERWRITE = "//label[text()='Save and Overwrite']";
	WebPageElements save_overwrite_button = new WebPageElements("Save and Overwrite Button", "xpath", SAVE_OVERWRITE);
	
	String DONE_BUTTON = "//input[@name='btnSave']";
	WebPageElements done_button = new WebPageElements("Done Editing Button", "xpath", DONE_BUTTON);
	
	String SOURCE_EMAIL = "//a[contains(text(),'Select Source')]";
	WebPageElements source_email = new WebPageElements("Select Source", "xpath", SOURCE_EMAIL);
	
	String FROM_A_LIST = "//div[text()='From a List']/ancestor::div[@id='divFromList']";
	WebPageElements from_a_list = new WebPageElements("From A List", "xpath", FROM_A_LIST);
	
	String IMPORT_FROM_FILE = "//div[text()='Import from File']/ancestor::div[@class='source-option file-import']";
	WebPageElements import_from_file = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE);
	
	String IMPORT_FROM_FILE2 = "//div[text()='Import from file']/ancestor::div[@class='source-option file-import']";
	WebPageElements import_from_file2 = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE2);
	
	String BROWSE_BUTTON1 = "//input[@name='MyFile']";
	WebPageElements browse_button1 = new WebPageElements("Browse Button", "xpath", BROWSE_BUTTON1);
	
	String HEADER_SWITCH = "//input[@id='rbIgnoreFLineYes']";
	WebPageElements header_switch = new WebPageElements("Header Switch", "xpath", HEADER_SWITCH);
	
	String HEADER_SWITCH2 = "//input[contains(@id,'chkIgnoreHeaderFile')]";
	WebPageElements header_switch2 = new WebPageElements("Header Switch", "xpath", HEADER_SWITCH2);
	
	String SELECT_LIST = "//select[@name='ddSelectList']";
	WebPageElements select_list = new WebPageElements("Select List", "xpath", SELECT_LIST);
	
	String SELECT_LIST2 = "//select[@id='ddSelectList']";
	WebPageElements select_list2 = new WebPageElements("Select List", "xpath", SELECT_LIST2);
	
	String IFRAME_EMAIL_TEMPLATE = "(//iframe[contains(@src,'/zDM/invitationEmailContent.aspx?')])[1]";
	WebPageElements iframe_email_template = new WebPageElements("IFrame mail template", "xpath", IFRAME_EMAIL_TEMPLATE);
	
	String INVITE_IN_SEPERATE_EMAIL = "//label[text()='Send each invitation link in a separate email for every occurrence of email']";
	WebPageElements invite_in_seperate_email = new WebPageElements("invitation link in a separate email", "xpath", INVITE_IN_SEPERATE_EMAIL);
	
	String PRE_POP_SURVEY = "//label[text()='Pre-Populate Survey']";
	WebPageElements pre_pop_survey = new WebPageElements("Pre-Populate Survey", "xpath", PRE_POP_SURVEY);
	
	String PRE_POP_RESPONSES = "//label[text()='Pre-Populate Responses']";
	WebPageElements pre_pop_responses = new WebPageElements("Pre-Populate Responses", "xpath", PRE_POP_RESPONSES);
	
	String PRE_POP_SURVEY_INPUT = "//input[@name='chkPrepop']";
	WebPageElements pre_pop_survey_input = new WebPageElements("Pre-Populate Survey", "xpath", PRE_POP_SURVEY_INPUT);
	

	String PRE_POP_SURVEY_INPUT2 = "//input[@id='chkPrepop']";
	WebPageElements pre_pop_survey_input2 = new WebPageElements("Pre-Populate Survey", "xpath", PRE_POP_SURVEY_INPUT2);
	
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
	

	String MAP_FIELDS = "//input[@id='txtAttributes1']";
	WebPageElements map_fields = new WebPageElements("Map Answers 1", "xpath", MAP_FIELDS);
	
	String DONE_BUTTON2 = "//input[@value='Done' and @type='submit']";
	WebPageElements done_button2 = new WebPageElements("Done Button", "xpath", DONE_BUTTON2);
	
	String SUCCESS_MSG = "//span[text()='You have just created a new list.']";
	WebPageElements success_msg = new WebPageElements("You have just created a new list.", "xpath", SUCCESS_MSG);
	
	String SEARCH_LIST = "//input[@id='txtContactSearch']";
	WebPageElements search_list = new WebPageElements("Search List", "xpath", SEARCH_LIST);
	
	String MAP_FIELDS2 = "//input[@id='txtAttributes2']";
	WebPageElements map_fields2 = new WebPageElements("Map Answers 2", "xpath", MAP_FIELDS2);
	
	String MAP_FIELDS3 = "//input[@id='txtAttributes3']";
	WebPageElements map_fields3 = new WebPageElements("Map Answers 3", "xpath", MAP_FIELDS3);
	
	String PRE_POP_DD = "//select[@name='ddOption_0']";
	WebPageElements pre_pop_dd = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD);
	
	String PRE_POP_DD2 = "//select[@id='ddOption_0']";
	WebPageElements pre_pop_dd2 = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD2);
	
	String REVIEW_DATE = "(//a[text()='Review Data'])[2]";
	WebPageElements review_data = new WebPageElements("Review Data", "xpath", REVIEW_DATE);
	
	String SEND_OR_SCHEDULE = "//a[contains(text(),'Send Or Schedule')]";
	WebPageElements send_or_schedule = new WebPageElements("Send Or Schedule", "xpath", SEND_OR_SCHEDULE);
	
	String GENERATE_BUTTON = "//input[@value='Generate']";
	WebPageElements generate_button = new WebPageElements("Gnerate Button", "xpath", GENERATE_BUTTON);

	String SEND_NOW = "//input[@name='btnSubmit']";
	WebPageElements send_now = new WebPageElements("Send Now", "xpath", SEND_NOW);
	
	String INVITATION_SENT = "//font[contains(text(),'You have sent')]";
	WebPageElements invitation_sent = new WebPageElements("You have sent", "xpath", INVITATION_SENT);
	
	String SUCCESSFULLY_GENERATED = "//span[contains(text(),'You have successfully generated')]";
	WebPageElements successfully_generated = new WebPageElements("You have successfully generated", "xpath", SUCCESSFULLY_GENERATED);
	
	String GENERATE_PASSWORD = "//input[@id='btnDwnPwd']";
	WebPageElements generate_password = new WebPageElements("Generate Password", "xpath", GENERATE_PASSWORD);
	
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
	
	String EMAIL_TEMPLATE = "//div[@id='btnEmailManager']";
	WebPageElements email_template = new WebPageElements("Email Templates", "xpath", EMAIL_TEMPLATE);
	
	String EMAIL_FIELD = "//span[@class='ts-email-addr']";
	WebPageElements email_field = new WebPageElements("Email Field", "xpath", EMAIL_FIELD);
	
	String STATUS_FILED = "//td[contains(@id,'tdStatus_')]/span";
	WebPageElements status_field = new WebPageElements("Status Field", "xpath", STATUS_FILED);
	
	String INVITATION_DATE_FILED = "//td[contains(@id,'tdInvitationDate')]";
	WebPageElements invitation_date_field = new WebPageElements("Invitation date field", "xpath", INVITATION_DATE_FILED);

	String URL_EXPIRY_FILED = "//td[contains(@id,'tdURLExpiry_')]";
	WebPageElements url_expiry_field = new WebPageElements("URL Expiry field", "xpath", URL_EXPIRY_FILED);
	
	String REMINDER_COLUMN_FILTER = "//div[@id='divReminderFilter']";
	WebPageElements reminder_column_filter = new WebPageElements("Reminder columns filter", "xpath", REMINDER_COLUMN_FILTER);
	
	String FIRST_REMINDER_FILTER = "//label[contains(text(),'First Reminder')][@for='chk_dvCol_Reminder1']";
	WebPageElements first_reminder_filter = new WebPageElements("First reminder filter", "xpath", FIRST_REMINDER_FILTER);
	
	String REMINDER_COLUMN_FILTER_SAVE_BUTTON = "//input[@id='btnColSave']";
	WebPageElements reminder_column_filter_save_button = new WebPageElements("Reminder columns filter - Save button", "xpath", REMINDER_COLUMN_FILTER_SAVE_BUTTON);
	
	String REMINDER_EMAIL_FIELD = "//td[(starts-with(@id,'rptReminderList_ctl') and contains(@id,'td_item_email')) and @style = 'text-align: left']";
	WebPageElements reminder_email_field = new WebPageElements("Reminder - Email Field", "xpath", REMINDER_EMAIL_FIELD);
	
	String REMINDER_ORIGINAL_INVITATION_FIELD = "//td[starts-with(@id,'rptReminderList_ctl') and contains(@id,'td_item_date') and contains(@style, 'text-align: left;')]";
	WebPageElements reminder_original_invitation_field = new WebPageElements("Reminder - Original Invitation Date Field", "xpath", REMINDER_ORIGINAL_INVITATION_FIELD);
	
	String NUMBER_OF_REMINDERS_SENT = "//td[starts-with(@id,'rptReminderList_ctl') and contains(@id,'td_item_reminder') and contains(@style, 'text-align: left;')]";
	WebPageElements number_of_reminders_sent = new WebPageElements("Reminder - Number of Reminder sent", "xpath", NUMBER_OF_REMINDERS_SENT);
	
	String FIRST_REMINDER_SENT_DATE = "//td[starts-with(@id,'rptReminderList_ctl') and contains(@id,'td_item_reminder1_date')]";
	WebPageElements first_reminder_sent_date = new WebPageElements("Reminder - First Reminder Sent Date", "xpath", FIRST_REMINDER_SENT_DATE);
	
	String SELECT_CHANNEL_DROPDOWN = "//div[contains(@class,'ts-header-title fl')]";
	WebPageElements select_channel_dropdown = new WebPageElements("Track Survey - Select channel dropdown", "xpath", SELECT_CHANNEL_DROPDOWN);
	
	String CHANNEL_LIST = "//ul[contains(@class,'ts-links-cont')]";
	WebPageElements channel_list = new WebPageElements("Track Survey - Channel list", "xpath", CHANNEL_LIST);
	
	String CHANNEL_SURVEY_PASSWORDS = "//li[@id='li_SurveyPasswords']";
	WebPageElements channel_survey_passwords = new WebPageElements("Track Survey - Survey Password channel", "xpath", CHANNEL_SURVEY_PASSWORDS);
	
	String SAP_PASSWORD_FIELD = "//td[contains(@id,'tdPassword_')]";
	WebPageElements sap_password_field = new WebPageElements("Password Field", "xpath", SAP_PASSWORD_FIELD);
	
	String SAP_SURVEY_LOGIN_URL_FIELD = "//td[contains(@id,'tdSurveyLoginURL_')]";
	WebPageElements sap_survey_login_url_field = new WebPageElements("Survey Login URL Field", "xpath", SAP_SURVEY_LOGIN_URL_FIELD);
	
	String SAP_STATUS_FIELD = "//td[contains(@id,'tdStatus_')]/span";
	WebPageElements sap_status_field = new WebPageElements("Survey Password - Status Field", "xpath", SAP_STATUS_FIELD);
	
	String SAP_GENERATED_ON_FIELD = "//td[contains(@id,'tdGeneratedOn_')]";
	WebPageElements sap_generated_on_field = new WebPageElements("Survey Password - Generated On Field", "xpath", SAP_GENERATED_ON_FIELD);
	
}


