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
	
	String DELETE_MODAL_DIALOG = "//div[@id='ctl00_ctl00_cphMain_cphBody_dvDeleteModalAlert']/div";
	WebPageElements delete_modal_dialog = new WebPageElements("Delete Modal", "xpath", DELETE_MODAL_DIALOG);
	
	String DELETE_BUTTON2 = "//input[@id='ctl00_ctl00_cphMain_cphBody_btnDeleteConfirm']";
	WebPageElements delete_button2 = new WebPageElements("Ok", "xpath", DELETE_BUTTON2);
	
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
	
	String SINGLE_USE_PWD2 = "//div[text()='Single-Use Passwords']";
	WebPageElements single_use_pwd2 = new WebPageElements("Survey Passwords", "xpath", SINGLE_USE_PWD2);
	
	String GENERATE_NEW_URL_BTN = "(//a[text()='Generate New URL'])[1]";
	WebPageElements generate_new_url_btn = new WebPageElements("Generate New URL Button", "xpath", GENERATE_NEW_URL_BTN);

	String SMS_INVITATION = "(//span[text()='SMS Invitation ']/ancestor::div[@class='front-face'])[1]";
	WebPageElements sms_invitation = new WebPageElements("SMS Invitation Button", "xpath", SMS_INVITATION);
	
	String SELECT_EMAIL_MESSAGE = "//a[text()='Select Email Message']";
	WebPageElements select_email_message = new WebPageElements("Select Email Message", "xpath", SELECT_EMAIL_MESSAGE);
	
	String USE_EXISTING_LIST = "//div[text()='Use an existing Contact List']/parent::div";
	WebPageElements use_existing_list = new WebPageElements("Use Existing List", "xpath", USE_EXISTING_LIST);
	
	String SEARCH_EMAIL = "(//input[contains(@class,'searchText ui-autocomplete-input')])[1]";
	WebPageElements search_email = new WebPageElements("Search Email", "xpath", SEARCH_EMAIL);
	
	String ATTRIBUTE = "//input[@name='txtMailMerge0']";
	WebPageElements attribute = new WebPageElements("Attribute", "xpath", ATTRIBUTE);
	
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
	
	String QUICK_LOOK_MODAL_HEADER = "//div[@id='myModalLabel'][text()='Quick Look']";
	WebPageElements quick_look_modal_header = new WebPageElements("Quick Look - Modal Header", "xpath", QUICK_LOOK_MODAL_HEADER);
	
	String REVIEW_MISMATCH_DATA = "//div[@class='header-content']/a[contains(text(),'Review Data')]";
	WebPageElements review_mismatch_data = new WebPageElements("Review Data", "xpath", REVIEW_MISMATCH_DATA);
	
	String GENERATE_NEW_URL = "//a[text()='Generate New URL']";
	WebPageElements generate_new_url = new WebPageElements("Generate New URL", "xpath", GENERATE_NEW_URL);
	
	String ALLOW_DUPLICATE = "//input[contains(@name,'chkDuplicateFile')]";
	WebPageElements allow_duplicate = new WebPageElements("Allow duplicate email addresses", "xpath", ALLOW_DUPLICATE);
	
	String CONTINUE_BUTTON3 = "//input[@value='Continue' and @type='submit']";
	WebPageElements continue_button3 = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON3);
	
	String CONTINUE_BUTTON1 = "//input[@id='btnContinue']";
	WebPageElements continue_button1 = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON1);
	
	String CONTINUE_BUTTON4 = "//input[@Value='Done' and @type ='submit']";
	WebPageElements continue_button4 = new WebPageElements("Done", "xpath", CONTINUE_BUTTON4);
	
	String SMS_INVITES_REMINDER = "//div[text()='SMS Invitations']";
	WebPageElements sms_invites_reminder = new WebPageElements("SMS Invitations", "xpath", SMS_INVITES_REMINDER);
	
	String SAVE_OVERWRITE = "//label[text()='Save and Overwrite']";
	WebPageElements save_overwrite_button = new WebPageElements("Save and Overwrite Button", "xpath", SAVE_OVERWRITE);
	
	String DONE_BUTTON = "//input[@name='btnSave']";
	WebPageElements done_button = new WebPageElements("Done Editing Button", "xpath", DONE_BUTTON);
	
	String TEMPLATE_NAME_TB = "//input[@name='txtTemplateName']";
	WebPageElements template_name_tb = new WebPageElements("Template Name Text box", "xpath", TEMPLATE_NAME_TB);
	
	String SOURCE_EMAIL = "//a[contains(text(),'Select Source')]";
	WebPageElements source_email = new WebPageElements("Select Source", "xpath", SOURCE_EMAIL);
	
	String FROM_A_LIST = "//div[text()='From a List']/ancestor::div[@id='divFromList']";
	WebPageElements from_a_list = new WebPageElements("From A List", "xpath", FROM_A_LIST);
	
//	String IMPORT_FROM_FILE = "//div[text()='Import from File']/ancestor::div[@class='source-option file-import']";
//	WebPageElements import_from_file = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE);

	String IMPORT_FROM_FILE = "//div[@class='source-option file-import']/div[@class='source-option-icon']";
	WebPageElements import_from_file = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE);
	
	String IMPORT_FROM_EXTERNAL_SOURCES = "//div[@id='externalSources']/div[@class='source-option-icon']";
	WebPageElements import_from_external_sources = new WebPageElements("Import from external sources", "xpath", IMPORT_FROM_EXTERNAL_SOURCES);
	
	String SALESFORCE = "//div[@class='external-source-type-title'][text()='Salesforce']";
	WebPageElements salesforce = new WebPageElements("Salesforce", "xpath", SALESFORCE);
	
	String SALESFORCE_DROP_DOWN = "//span[contains(@id,'spSalesForce')]";
	WebPageElements salesforce_drop_down = new WebPageElements("Import record from drop down", "xpath", SALESFORCE_DROP_DOWN);
	
	String STATIC_LIST_TOGGLE = "//label[contains(@id,'lblSFStaticList')]";
	WebPageElements static_list_toggle = new WebPageElements("Create a static Contact List​ toggle", "xpath", STATIC_LIST_TOGGLE);
	
	String IMPORT_FROM_FILE2 = "//div[text()='Import from file']/ancestor::div[@class='source-option file-import']";
	WebPageElements import_from_file2 = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE2);
	
	String IMPORT_FROM_FILE3 = "//div[@id='divFromFile']/div";
	WebPageElements import_from_file3 = new WebPageElements("Import from File", "xpath", IMPORT_FROM_FILE3);
	
	String CHOOSE_FILE = "//input[@id='btnFileUpload']";
	WebPageElements choose_file = new WebPageElements("Choose file", "xpath", CHOOSE_FILE);
	
	String BROWSE_BUTTON1 = "//input[@name='MyFile']";
	WebPageElements browse_button1 = new WebPageElements("Browse Button", "xpath", BROWSE_BUTTON1);
	
	String BROWSE_BUTTON1_OPT = "//div[@id='div_ctl00_ctl00_cphMain_cphBody_btnFileUpload']";
	WebPageElements browse_button1_opt = new WebPageElements("Browse Button", "xpath", BROWSE_BUTTON1_OPT);
	
	String HEADER_SWITCH = "//input[@id='rbIgnoreFLineYes']";
	WebPageElements header_switch = new WebPageElements("Header Switch", "xpath", HEADER_SWITCH);
	
	String HEADER_SWITCH2 = "//input[contains(@id,'chkIgnoreHeaderFile')]";
	WebPageElements header_switch2 = new WebPageElements("Header Switch", "xpath", HEADER_SWITCH2);
	
	String HEADER_SWITCH3 = "(//span[@class='cross-tick'])[1]";
	WebPageElements header_switch3 = new WebPageElements("Header Switch", "xpath", HEADER_SWITCH3);
	
	String SELECT_LIST = "//select[@name='ddSelectList']";
	WebPageElements select_list = new WebPageElements("Select List", "xpath", SELECT_LIST);
	
	String ATTRIBUTES_LIST = "//select[@name='ddlAttributeNames0']";
	WebPageElements attributes_list = new WebPageElements("Attributes List", "xpath", ATTRIBUTES_LIST);
	
	
	String SELECT_LIST2 = "//select[@id='ddSelectList']";
	WebPageElements select_list2 = new WebPageElements("Select List", "xpath", SELECT_LIST2);
	
	String PRE_POP_CHECKBOX = "//input[@id='chkPrepop']";
	WebPageElements pre_pop_checkbox = new WebPageElements("Pre pop checkbox", "xpath", PRE_POP_CHECKBOX);
		
	String IFRAME_EMAIL_TEMPLATE = "(//iframe[contains(@src,'/zDM/invitationEmailContent.aspx?')])[1]";
	WebPageElements iframe_email_template = new WebPageElements("IFrame mail template", "xpath", IFRAME_EMAIL_TEMPLATE);
	
	String IFRAME_EDIT_TEMPLATE = "//iframe[contains(@src,'EditSelectedTemplate.aspx?')]";
	WebPageElements iframe_edit_template = new WebPageElements("IFrame Edit Email template", "xpath", IFRAME_EDIT_TEMPLATE);
	
	String IFRAME_PREVIEW_TEMPLATE = "//iframe[@id='iframeTemplatePreview']";
	WebPageElements iframe_preview_template = new WebPageElements("IFrame Email template preview", "xpath", IFRAME_PREVIEW_TEMPLATE);
	
	String WARN_TEXT = "//div[text()='This email preview does not allow participation.']";
	WebPageElements warn_text = new WebPageElements("Warning Text of Participation", "xpath", WARN_TEXT);
	
	String DELETE_TEMPLATE = "//span[@title='Delete']";
	WebPageElements delete_template = new WebPageElements("Delete Template Icon", "xpath", DELETE_TEMPLATE);
	
	String PREVIEW_TEMPLATE = "//a[@title='Preview']";
	WebPageElements preview_template = new WebPageElements("Preview Template Icon", "xpath", PREVIEW_TEMPLATE);
	
	String DELETE_TOASTER_MSG = "//span[text()='1 Email Message(s) Deleted.']";
	WebPageElements delete_toaster_msg = new WebPageElements("Delete Toaster Message", "xpath", DELETE_TOASTER_MSG);
	
	String MAIL_MERGE_COL_HEADER = "//th[text()='Mail Merge Used']";
	WebPageElements mail_merge_col_header = new WebPageElements("Mail Merge Column Header", "xpath", MAIL_MERGE_COL_HEADER);
	
	String COPY_TEMP_ICON = "//li[@title='Copy Message']";
	WebPageElements copy_temp_icon = new WebPageElements("Copy Icon", "xpath", COPY_TEMP_ICON);
	
	String COPY_TOOLTIP = "//div[@class='copypathcont']//div[text()=\"Here's your copy!\"]";
	WebPageElements copy_tooltip = new WebPageElements("Copy ToolTip", "xpath", COPY_TOOLTIP);
	
	String COPIED_TEMPLATE_HEADER = "//div[@class='copypathcont']/following-sibling::div[@class='top-content']";
	WebPageElements copied_template_header = new WebPageElements("Header of Copied Template", "xpath", COPIED_TEMPLATE_HEADER);
	
	String COPY_TOOLTIP_FOR_LIST = "//div[@class='copypathcont dgEmailManager']//div[text()=\"Here's your copy!\"]";
	WebPageElements copy_tooltip_for_list = new WebPageElements("Copy ToolTip", "xpath", COPY_TOOLTIP_FOR_LIST);
	
	String COPIED_TEMPLATE_HEADER_FOR_LISTVIEW = "//div[@class='copypathcont dgEmailManager']/following-sibling::div[@class='edit-email-title-wrapper']/span";
	WebPageElements copied_template_header_for_listview = new WebPageElements("Header of Copied Template in List View", "xpath", COPIED_TEMPLATE_HEADER_FOR_LISTVIEW);
	
	String QUICK_LOOK_BUTTON = "(//input[@value='Quick Look'])[1]";
	WebPageElements quick_look_button = new WebPageElements("Quick Look Button", "xpath", QUICK_LOOK_BUTTON);
	
	String DELETE_TEMP_BUTTON = "(//input[@value='Delete'])[1]";
	WebPageElements delete_temp_button = new WebPageElements("Delete Template Button", "xpath", DELETE_TEMP_BUTTON);
	
	String COPY_BUTTON = "(//input[@value='Copy'])[1]";
	WebPageElements copy_button = new WebPageElements("Copy Template Button", "xpath", COPY_BUTTON);
	
	String SWITCH_VIEW = "//a[@id='btn-switch-view']";
	WebPageElements switch_view = new WebPageElements("Switch View Button", "xpath", SWITCH_VIEW);
	
	String PREVIEW_EMAIL = "//input[@id='btnPreview1']";
	WebPageElements preview_email = new WebPageElements("Preview Email", "xpath", PREVIEW_EMAIL);
	
	String SENDER_NAME_LABEL = "//span[text()='Sender Name']";
	WebPageElements sender_name_label = new WebPageElements("Sender Name - Label", "xpath", SENDER_NAME_LABEL);
	
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
	
	String MODIFY_MESSAGE = "//a[contains(text(),'Modify Message')]";
	WebPageElements modify_message = new WebPageElements("Modify Message", "xpath", MODIFY_MESSAGE);
	
	String SMS_PREVIEW_LINK = "//span[text()='Preview']";
	WebPageElements sms_preview_link = new WebPageElements("SMS Invitation Preview Link", "xpath", SMS_PREVIEW_LINK);
	
	String SMS_INV_PREVIEW = "//div[(text()='SMS Invitation Preview')]";
	WebPageElements sms_inv_preview = new WebPageElements("SMS Invitation Preview", "xpath", SMS_INV_PREVIEW);
	
	String SMS_INV_PREVIEW_CLOSE = "//div[@class='close-mobilePreview']";
	WebPageElements sms_inv_preview_close = new WebPageElements("SMS Invitation Preview Cross Icon", "xpath", SMS_INV_PREVIEW_CLOSE);

	String MAP_FIELDS = "//input[@id='txtAttributes1']";
	WebPageElements map_fields = new WebPageElements("Map Answers 1", "xpath", MAP_FIELDS);
	
	String CHECK_ALL_FIELDS = "//label[@for='chkAll']";
	WebPageElements check_all_fields = new WebPageElements("Select All Fields Values", "xpath", CHECK_ALL_FIELDS);
	
	String ALL_PREPOP_DD = "//select[starts-with(@id,'ddOption_')]";
	WebPageElements all_prepop_DD = new WebPageElements("All Prepop drop downs", "xpath", ALL_PREPOP_DD);
	
	String NO_OF_PASSWORDS = "//div[starts-with(text(),'Number of Passwords: ')]";
	WebPageElements no_of_passwords = new WebPageElements("Number of Password - Label text", "xpath", NO_OF_PASSWORDS);
	
	String ALL_MAP_FIELDS = "//input[starts-with(@id,'txtAttributes')]";
	WebPageElements all_map_fields = new WebPageElements("Map Answers", "xpath", ALL_MAP_FIELDS);
	
	String DONE_BUTTON2 = "//input[@value='Done' and @type='submit']";
	WebPageElements done_button2 = new WebPageElements("Done Button", "xpath", DONE_BUTTON2);
	
	String SUCCESS_MSG = "//span[text()='Your list has been created!']";
	WebPageElements success_msg = new WebPageElements("You have just created a new list.", "xpath", SUCCESS_MSG);
	
	String SEARCH_LIST = "//input[@id='txtContactSearch']";
	WebPageElements search_list = new WebPageElements("Search List", "xpath", SEARCH_LIST);
	
	String MAP_FIELDS2 = "//input[@id='txtAttributes2']";
	WebPageElements map_fields2 = new WebPageElements("Map Answers 2", "xpath", MAP_FIELDS2);
	
	String MAP_FIELDS3 = "//input[@id='txtAttributes3']";
	WebPageElements map_fields3 = new WebPageElements("Map Answers 3", "xpath", MAP_FIELDS3);
	
	String PRE_POP_DD = "//select[@name='ddOption_0']";
	WebPageElements pre_pop_dd = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD);
	
	
	String PRE_POP_DD3 = "//select[contains(@name,'ddOption_')]";
	WebPageElements pre_pop_dd3 = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD3);
	
	String ERROR_MSG = "//span[@id='ErrorMessage_dgErrors_ctl02_lblError']";
	WebPageElements error_msg = new WebPageElements("Toaster Messgage", "xpath", ERROR_MSG);
	
	String PRE_POP_DD2 = "//select[@id='ddOption_0']";
	WebPageElements pre_pop_dd2 = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD2);
	
	String PRE_POP_DD4 = "//select[contains(@id,'ddOption_')]";
	WebPageElements pre_pop_dd4 = new WebPageElements("Pre Pop DD", "xpath", PRE_POP_DD4);
	
	
	String REVIEW_DATE = "(//a[text()='Review Data'])[2]";
	WebPageElements review_data = new WebPageElements("Review Data", "xpath", REVIEW_DATE);
	
	String SEND_OR_SCHEDULE = "//a[contains(text(),'Send Or Schedule')]";
	WebPageElements send_or_schedule = new WebPageElements("Send Or Schedule", "xpath", SEND_OR_SCHEDULE);
	
	String SEND_OR_SCHEDULE2 = "//a[contains(text(),'Send Or Schedule')]";
	WebPageElements send_or_schedule2 = new WebPageElements("Send Or Schedule", "xpath", SEND_OR_SCHEDULE2);
	
	
	String GENERATE_BUTTON = "//input[@value='Generate']";
	WebPageElements generate_button = new WebPageElements("Gnerate Button", "xpath", GENERATE_BUTTON);

	String SEND_NOW = "//input[@name='btnSubmit']";
	WebPageElements send_now = new WebPageElements("Send Now", "xpath", SEND_NOW);
	
	String SCHEDULED_DELIVERY = "//input[@value='Schedule Delivery'][@name='btnSubmit']";
	WebPageElements scheduled_delivery = new WebPageElements("Schedule Delivery", "xpath", SCHEDULED_DELIVERY);
	
	String INVITATION_SENT = "//span[contains(text(),'Email Invitation(s) sent:')]";
	WebPageElements invitation_sent = new WebPageElements("Email Invitation(s) sent Message", "xpath", INVITATION_SENT);
	
	String REMINDER_SENT = "//span[@id='spnPublish'][starts-with(text(),'Email Reminder(s) sent')]";
	WebPageElements reminder_sent = new WebPageElements("Email Reminder(s) sent Message", "xpath", REMINDER_SENT);
	
	String SMS_INVITATION_SENT = "//span[@id='spnPublish'][starts-with(text(),'SMS Invitation(s) sent')]";
	WebPageElements sms_invitation_sent = new WebPageElements("SMS Invitation(s) sent Message", "xpath", SMS_INVITATION_SENT);
	
	String SMS_REMINDER_SENT = "//span[@id='spnPublish'][starts-with(text(),'SMS Reminder(s) sent')]";
	WebPageElements sms_reminder_sent = new WebPageElements("SMS Reminder(s) sent Message", "xpath", SMS_REMINDER_SENT);
	
	String SUCCESSFULLY_GENERATED = "//span[@id='spnPublish'][starts-with(text(),'Passwords generated')]";
	WebPageElements successfully_generated = new WebPageElements("Password Generated Message", "xpath", SUCCESSFULLY_GENERATED);
	
	String GENERATE_PASSWORD = "//input[@id='btnDwnPwd']";
	WebPageElements generate_password = new WebPageElements("Generate Password", "xpath", GENERATE_PASSWORD);
	
	String INVITATION_SENT_EXE = "//span[starts-with(text(),'Invitations queued for delivery:')]";
	WebPageElements invitation_sent_exe = new WebPageElements("have been queued for delivery ", "xpath", INVITATION_SENT_EXE);
	
	String REMINDERS_SENT_EXE = "//span[@id='spnPublish'][starts-with(text(),'Reminders queued for delivery')]";
	WebPageElements reminders_sent_exe = new WebPageElements("Reminders have been queued for delivery message", "xpath", REMINDERS_SENT_EXE);
	
	
	String REMINDERS = "(//span[contains(text(),'Reminders')])[1]";
	WebPageElements reminders = new WebPageElements("Reminders", "xpath", REMINDERS);
	
	String REMINDERS2 = "//span[@id='ToolBox1_Span1']";
	WebPageElements reminders2 = new WebPageElements("Reminders", "xpath", REMINDERS2);
	
	String REMINDER_HISTORY_BAR = "//span[text()='View Reminder History']";
	WebPageElements reminder_history_bar = new WebPageElements("View Reminder History", "xpath", REMINDER_HISTORY_BAR);
	
	String SEND_REMINDERS_TO_ALL = "//input[@id='btnSendReminderNew']";
	WebPageElements send_reminders_to_all = new WebPageElements("Reminders to All", "xpath", SEND_REMINDERS_TO_ALL);
	
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
	
	String QUICK_SEND_LEFT_PANNEL_TITLE = "//div[@class ='left-panel-title'][text()='Quick Send']";
	WebPageElements quick_send_left_pannel_title = new WebPageElements("Quick send - Left Pannel Title", "xpath", QUICK_SEND_LEFT_PANNEL_TITLE);	
	
	String QUICK_SEND_SINGLE_USE_LINK = "//span[contains(text(),'Single-Use Link')][@class='header']";
	WebPageElements quick_send_single_use_channel = new WebPageElements("Quick send - Single Use Invitation", "xpath", QUICK_SEND_SINGLE_USE_LINK);	
	
	String QUICK_SEND_EMAIL_LANG = "//select[@id='ddlLanguages']";
	WebPageElements quick_send_email_lang = new WebPageElements("Quick send - Email Language", "xpath", QUICK_SEND_EMAIL_LANG);	
	
	String QUICK_SEND_EMAIL_MSG = "//select[@id='DDLEmailList']";
	WebPageElements quick_send_email_msg = new WebPageElements("Quick send - Email Message", "xpath", QUICK_SEND_EMAIL_MSG);	
	
	String QUICK_SEND_NOW_BTN = "//input[@id='btnFromType']";
	WebPageElements quick_send_now_btn = new WebPageElements("Send Now Button", "xpath", QUICK_SEND_NOW_BTN);	
	
	String EMAIL_TEMPLATE = "//div[@id='btnEmailManager']";
	WebPageElements email_template = new WebPageElements("Email Templates", "xpath", EMAIL_TEMPLATE);
	
	String CREATE_NEW_MESSAGE = "//input[@id='EmailMessage1_btnCreate']";
	WebPageElements create_new_message = new WebPageElements("Create New Message", "xpath", CREATE_NEW_MESSAGE);
	
	String CREATE_NEW_MESSAGE_TITLE = "//div[text()='To create a new message, click Select to customize one of the options below.']";
	WebPageElements create_new_message_title = new WebPageElements("Create New Message - Title", "xpath", CREATE_NEW_MESSAGE_TITLE);
	
	String TIME_FILTER = "//div[@class='ts-select-time']";
	WebPageElements time_filter = new WebPageElements("Time Filter", "xpath", TIME_FILTER);
	
	String SELECTED_CHANNEL = "//span[@id='lblSelectedChannel']";
	WebPageElements selected_channel = new WebPageElements("Channel", "xpath", SELECTED_CHANNEL);
	
	String CHANNEL_MENU = "//div[@id='dvChannelMenu']";
	WebPageElements channel_menu = new WebPageElements("Channel Menu", "xpath", CHANNEL_MENU);
	
	String SINGLE_USE_LINK_CHANNEL = "//li[@id='li_SingleUseLink']";
	WebPageElements single_use_link_channel = new WebPageElements("Single-use Link Channel", "xpath", SINGLE_USE_LINK_CHANNEL);
	
	String MULTI_USE_LINK_CHANNEL = "//li[@id='li_MultiUseLink']";
	WebPageElements multi_use_link_channel = new WebPageElements("Multi-use Link Channel", "xpath", MULTI_USE_LINK_CHANNEL);
	
	String SURVEY_PASSWORD_CHANNEL = "//li[@id='li_SurveyPasswords']";
	WebPageElements survey_password_channel = new WebPageElements("Survey Password Channel", "xpath", SURVEY_PASSWORD_CHANNEL);
	
	String SMS_INVITES_CHANNEL = "//li[@id='li_SMSInvites']";
	WebPageElements sms_invites_channel = new WebPageElements("SMS Invites Channel", "xpath", SMS_INVITES_CHANNEL);
	
	String DISTRIBUTE = "//a[text()='Distribute']";
	WebPageElements distribute = new WebPageElements("Distribute", "xpath", DISTRIBUTE);
	
	String SEARCH_FIELD = "//input[@class='ts-search-bar']";
	WebPageElements search_field = new WebPageElements("Search Field", "xpath", SEARCH_FIELD);
	
	String SEARCH_ICON = "//div[@id='dvSearchBarMain']";
	WebPageElements search_icon = new WebPageElements("Search Icon", "xpath", SEARCH_ICON);
	
	String EMAIL_FIELD = "//span[@class='ts-email-addr']";
	WebPageElements email_field = new WebPageElements("Email Field", "xpath", EMAIL_FIELD);
	
	String NO_RECORD_FOUND = "//span[text()='No Records Found']";
	WebPageElements no_record_found = new WebPageElements("No Record Found", "xpath", NO_RECORD_FOUND);
	
	String STATUS_FILED = "//td[contains(@id,'tdStatus_')]/span";
	WebPageElements status_field = new WebPageElements("Status Field", "xpath", STATUS_FILED);
	
	String INVITATION_DATE_FILED = "//td[contains(@id,'tdInvitationDate')]";
	WebPageElements invitation_date_field = new WebPageElements("Invitation date field", "xpath", INVITATION_DATE_FILED);

	String TEST_DD = "//div[@id='btn_SendTestInvitation']";
	WebPageElements test_dd = new WebPageElements("Test Invite Dropdown", "xpath", TEST_DD);
	
	String TEST_URL = "//div[@id='anhGenTestURL']";
	WebPageElements test_url = new WebPageElements("Test Invite URL", "xpath", TEST_URL);
	
	String TEST_INVITE = "//div[@id='anhSendTestInvite']";
	WebPageElements test_invite = new WebPageElements("Test Invite", "xpath", TEST_INVITE);
	
	String TEST_CB = "//div[@name='DmTool$chkGenTestURLIAgree']";
	WebPageElements test_cb = new WebPageElements("Test Invite CB", "xpath", TEST_CB);
	
	String TEST_DONE = "//div[@class='btn-next smallnext']";
	WebPageElements test_done = new WebPageElements("Test Invite Done", "xpath", TEST_DONE);
	
	String TEST_SINGLE = "(//span[contains(text(),'Single-Use Link')])[2]";
	WebPageElements test_single = new WebPageElements("Test Single Use Link", "xpath", TEST_SINGLE); 

	String TEST_SEND = "//input[@id='sub1']";
	WebPageElements test_send = new WebPageElements("Test Send Link", "xpath", TEST_SEND); 
	
	String TRACK_SURVEY = "//input[@id='btnTrackSurvey']";
	WebPageElements track_survey = new WebPageElements("Go To TrackSurvey", "xpath", TRACK_SURVEY);

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
	
	String SELECT_SAMPLE_SIZE = "//select[@id='ddSampleType']";
	WebPageElements select_sample_size = new WebPageElements("Select Sample size - drop down", "xpath", SELECT_SAMPLE_SIZE);
	
	String TOUCH_RULE_INPUT = "//input[@name='chkTouchRule']";
	WebPageElements touch_rule_input = new WebPageElements("Touch Rule checkbox", "xpath", TOUCH_RULE_INPUT);
	
	String TOUCH_RULES = "//label[text()='Touch Rules']";
	WebPageElements touch_rules = new WebPageElements("Touch Rules", "xpath", TOUCH_RULES);
	
	String MAIL_MERGE_USED = "//span[contains(@id , 'lblMailMerge')]";
	WebPageElements mail_merge_used = new WebPageElements("Mail Merge Variables Used in Content", "xpath", MAIL_MERGE_USED);
	
	String LIST_ATTRIBUTES = "//select[contains(@id , 'ddlAttributeNames')]";
	WebPageElements list_attributes = new WebPageElements("List Attributes - Drop down", "xpath", LIST_ATTRIBUTES);
	
	String PRE_POP_QUES = "//span[contains(@style,'vertical-align:middle;')]";
	WebPageElements pre_pop_ques = new WebPageElements("Pre-Pop Questions", "xpath", PRE_POP_QUES);
	
	String DATA_MISMATCH_TEXT = "//div[text()='Data Mismatch']";
	WebPageElements data_mismatch_text = new WebPageElements("Data Mismatch Text", "xpath", DATA_MISMATCH_TEXT);
	
	String BLANK_DATA_TEXT = "//div[text()='Blank Fields']";
	WebPageElements blank_data_text = new WebPageElements("Blank Data Text", "xpath", BLANK_DATA_TEXT);
	
	String SEND_NOW_INV = "//label[@id='lblSendNow']";
	WebPageElements send_now_inv = new WebPageElements("Send Now Radio Button", "xpath", SEND_NOW_INV);
	
	String DUPLICATE_MODAL = "//div[@class='fbcNewmodalTitle'][text()='Caution']";
	WebPageElements duplicate_modal = new WebPageElements("Caution Modal", "xpath", DUPLICATE_MODAL);
	
	String ENTER_EMAILIDS = "//input[@id='txtSendFromType']";
	WebPageElements enter_emailids = new WebPageElements("Enter Email Address - Text box", "xpath", ENTER_EMAILIDS);
	
	String ENTER_MOBILE = "//input[@id='txtSendFromType']";
	WebPageElements enter_mobile = new WebPageElements("Enter Mobile Numbers - Text box", "xpath", ENTER_MOBILE);
	
	String CHECK_ALL = "//input[@id='chk_All']";
	WebPageElements check_all = new WebPageElements("Check all check box", "xpath", CHECK_ALL);
	
	String DELETE_BTN = "//a[@id='anhDelete']";
	WebPageElements delete_btn = new WebPageElements("Delete Button", "xpath", DELETE_BTN);
	
	String OKAY_BTN = "//input[@id='btnDeletePopJS']";
	WebPageElements okay_btn = new WebPageElements("OKAY Button", "xpath", OKAY_BTN);
	
	String DELETE_TEXT_BOX = "//input[@id='tbDelete']";
	WebPageElements delete_text_box = new WebPageElements("Delete Text Box", "xpath", DELETE_TEXT_BOX);
	
	String DELETE_BTN_POP= "//input[@id='btnDeletePop']";
	WebPageElements delete_btn_pop = new WebPageElements("Delete Button", "xpath", DELETE_BTN_POP);
	
	String INVITATION_SENT_COUNT= "//div[text()='Invitations Sent']/preceding-sibling::div";
	WebPageElements inivitation_sent_count = new WebPageElements("Invitation Sent Count", "xpath", INVITATION_SENT_COUNT);
	
	String SCHEDULED_FOR_LATER = "//div[@id='dvSchedule']";
	WebPageElements scheduled_for_later = new WebPageElements("Schedule for Later", "xpath", SCHEDULED_FOR_LATER);
	
	String INVITATION_DATE = "//input[@id='txtdtinvitationDate']";
	WebPageElements invitation_date = new WebPageElements("Invitation Date", "xpath", INVITATION_DATE);
	
	String ALL_REMINDERS_CB = "//input[@id='rptReminderList_ctl00_chkreminder']";
	WebPageElements all_reminders_cb = new WebPageElements("Select All Invites Check box", "xpath", ALL_REMINDERS_CB);
	
	String SEND_REMINDERS = "//input[@id='btn_SendReminder_top']";
	WebPageElements send_reminders = new WebPageElements("Send Selected Reminders", "xpath", SEND_REMINDERS);
	
	String 	REMINDER_CHECK_BOX = "//input[contains(@id,'rptReminderList_ctl')]";
	WebPageElements reminder_check_box = new WebPageElements("Individual Reminder Check box", "xpath", REMINDER_CHECK_BOX);
	
	String REMINDER_PAGE_DD = "//select[@id='Paging2_ddlPgNo']";
	WebPageElements reminder_page_dd = new WebPageElements("Reminders Page Drop Down", "xpath", REMINDER_PAGE_DD);
	
	String CANCEL_REMINDERS = "//div[@title='Cancel Reminder(s)']";
	WebPageElements cancel_reminders = new WebPageElements("Cancel Reminders", "xpath", CANCEL_REMINDERS);
	
	String FIRST_REMINDERS_TITLE = "//div[text()='First Reminder Details']";
	WebPageElements first_reminder_title = new WebPageElements("First Reminder Title", "xpath", FIRST_REMINDERS_TITLE);
	
	String FACEBOOK = "//span[text()='Facebook']";
	WebPageElements facebook = new WebPageElements("Facebook", "xpath", FACEBOOK);
	
	String FB_WIZARD_HEADER_1 = "//span[text()='Customize the post to be displayed on Facebook.']";
	WebPageElements fb_wizard_header_1 = new WebPageElements("Facebook - First Wizard Header", "xpath", FB_WIZARD_HEADER_1);
	
	String FB_PUBLISH_BTN = "//input[@id='btnFbPublish']";
	WebPageElements fb_publish_btn = new WebPageElements("Publish on FB", "xpath", FB_PUBLISH_BTN);
	
	String TWITTER = "//span[text()='Twitter']";
	WebPageElements twitter = new WebPageElements("Twitter", "xpath", TWITTER);
	
	String TWITTER_WIZARD_HEADER_1 = "//span[text()='Authenticate survey participant by asking login details before participation.']";
	WebPageElements twitter_wizard_header_1 = new WebPageElements("Twiiter - First Wizard Header", "xpath", TWITTER_WIZARD_HEADER_1);
	
	String TWITTER_PUBLISH_BTN = "//input[@value='Publish on Twitter']";
	WebPageElements twitter_publish_btn = new WebPageElements("Publish on Twitter", "xpath", TWITTER_PUBLISH_BTN);
	
	String LINKEDIN = "//span[text()='LinkedIn']";
	WebPageElements linkedin = new WebPageElements("LinkedIn", "xpath", LINKEDIN);
	
	String LINKEDIN_WIZARD_HEADER_1 = "//span[text()='Customize the post to be displayed on LinkedIn.']";
	WebPageElements linkedin_wizard_header_1 = new WebPageElements("LinkedIn - First Wizard Header", "xpath", LINKEDIN_WIZARD_HEADER_1);
	
	String LINKEDIN_PUBLISH_BTN = "//input[@value='Publish On LinkedIn']";
	WebPageElements linkedin_publish_btn = new WebPageElements("Publish on LinkedIn", "xpath", LINKEDIN_PUBLISH_BTN);
	
	String TYPE_MANUALLY_ICON = "//div[text()='Type Manually']/preceding::div[contains(@class,'source-option-icon')]";
	WebPageElements type_manually_icon = new WebPageElements("Type Manually Icon", "xpath", TYPE_MANUALLY_ICON);
	
	String TEST_BUTTON = "//span[normalize-space()='Test']";
	WebPageElements test_button = new WebPageElements("TestButton", "xpath", TEST_BUTTON );
	
	String SEND_TEST_INVITATION = "//div[@id='anhSendTestInvite']";
	WebPageElements send_test_invitation = new WebPageElements("SendTestInvitation", "xpath", SEND_TEST_INVITATION );
	
	String SELECT_TEMPLATE = "//div[@class='btn-quick-view center select-btn']";
	WebPageElements select_template = new WebPageElements("SelectTemplate", "xpath", SELECT_TEMPLATE );
	
	String TEXT_AREA_FOR_INVIATION = "//div[@class='textarea invitation wordcontainer']";
	WebPageElements text_area_for_invitation = new WebPageElements("Text_Area_For_Invitaion", "xpath", TEXT_AREA_FOR_INVIATION );
	
	String BUTTON_CONTINUE = "//input[@id='btnNext']";
	WebPageElements button_continue = new WebPageElements("Button_Continue", "xpath", BUTTON_CONTINUE );
	
	String TEXTBOX = "//div[@id='dvtb']";
	WebPageElements textbox = new WebPageElements("Textbox", "xpath", TEXTBOX );
	
	String SAVE_QUESTION = "//input[@id='btnSaveQuestionAnswer']";
	WebPageElements save_question = new WebPageElements("Save_Question", "xpath", SAVE_QUESTION );
	
	String SEND_NOW1 = "//input[@id='sub1']";
	WebPageElements send_now1 = new WebPageElements("Send_Now1", "xpath", SEND_NOW1 );
	
	String CONFIRM1 = "//input[@id='btnSubmit']";
	WebPageElements confirm1 = new WebPageElements("Confirm1", "xpath", CONFIRM1 );
	
	String GOT_IT = "//input[@value='Got it​']";
	WebPageElements got_it = new WebPageElements("Done", "xpath", GOT_IT );
	
}
	




