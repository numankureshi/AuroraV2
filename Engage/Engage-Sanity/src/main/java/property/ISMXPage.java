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
	
	String RADIO_BUTTON = "//div[contains(text(),'Radio Button')]/parent::div[@id='dvrb']";
	WebPageElements radio_button = new WebPageElements("Radio Button", "xpath", RADIO_BUTTON);
	
	String HORIZONTAL_RADIO_BUTTON = "//div[contains(text(),'Horizontal Radio')]/parent::div[@id='dvHRB']";
	WebPageElements horizontal_radio_button = new WebPageElements("Hoorizontal Radio Button", "xpath", HORIZONTAL_RADIO_BUTTON);
	
	String RATING_RADIO2_BUTTON = "//div[contains(text(),'Rating Radio Button')]/parent::div[@id='dvrrb']";
	WebPageElements rating_radio2_button = new WebPageElements("Rating Radio Button", "xpath", RATING_RADIO2_BUTTON);
	
	String RATING_DROPDOWN_BUTTON = "//div[contains(text(),'Rating Drop Down')]/parent::div[@id='dvratdd']";
	WebPageElements rating_dropdown_button = new WebPageElements("Rating Drop Down Button", "xpath", RATING_DROPDOWN_BUTTON);
	
	String CHECK_BOX_BUTTON = "//div[contains(text(),'Check Box')]/parent::div[@id='dvmscb']";
	WebPageElements check_box_button = new WebPageElements("Check Box Button", "xpath", CHECK_BOX_BUTTON);
	
	String DROP_DOWN_BUTTON = "//div[contains(text(),'Drop Down')]/parent::div[@id='dvdd']";
	WebPageElements drop_down_button = new WebPageElements("Drop Down Button", "xpath", DROP_DOWN_BUTTON);
	
	String DEMOGRAPHICS_BUTTON = "//div[contains(text(),'Demographics')]/parent::div[@id='dvdemo']";
	WebPageElements demographics_button = new WebPageElements("Demographics Button", "xpath", DEMOGRAPHICS_BUTTON);
	
	String RATING_SCALE_BUTTON = "//div[contains(text(),'Rating Scale')]/parent::div[@id='dvrat']";
	WebPageElements rating_scale_button = new WebPageElements("Rating Scale Button", "xpath", RATING_SCALE_BUTTON);
	
	String SYMBOL_RATING_SCALE_BUTTON = "//div[contains(text(),'Symbol Rating Scale')]/parent::div[@id='dvGQ']";
	WebPageElements symbol_rating_scale_button = new WebPageElements("Symbol Rating Scale Button", "xpath", SYMBOL_RATING_SCALE_BUTTON);
	
	String LIKE_DISLIKE_BUTTON = "//div[contains(text(),'Like/Dislike')]/parent::div[@id='dvLikeDislike']";
	WebPageElements like_dislike_button = new WebPageElements("Like/Dislike Button", "xpath", LIKE_DISLIKE_BUTTON);
	
	String DATE_BUTTON = "//div[contains(text(),'Date')]/parent::div[@id='dvdate']";
	WebPageElements date_button = new WebPageElements("Date Button", "xpath", DATE_BUTTON);
	
	String IMAGE_CHOICE_BUTTON = "//div[contains(text(),'Image Choice')]/parent::div[@id='dvIMC']";
	WebPageElements image_choice_button = new WebPageElements("Image Choice Button", "xpath", IMAGE_CHOICE_BUTTON);
	
	String CAPTCHA_BUTTON = "//div[contains(text(),'Captcha')]/parent::div[@id='dvcaptcha']";
	WebPageElements captcha_button = new WebPageElements("Captcha Button", "xpath", CAPTCHA_BUTTON);
	
	String RANKING_QUESTION_BUTTON = "//div[contains(text(),'Ranking')]/parent::div[@id='dvrk']";
	WebPageElements ranking_question_button = new WebPageElements("Ranking Button", "xpath", RANKING_QUESTION_BUTTON);
	
	String NUMERIC_ALLOCATIONS_BUTTON = "//div[contains(text(),'Numeric Allocation')]/parent::div[@id='dvNumeric']";
	WebPageElements numeric_allocations_button = new WebPageElements("Numeric Allocations Button", "xpath", NUMERIC_ALLOCATIONS_BUTTON);
	
	String ATTATHCMENTS_BUTTON = "//div[contains(text(),'Attachment')]/parent::div[@id='dvatt']";
	WebPageElements attachments_button = new WebPageElements("Attachments Button", "xpath", ATTATHCMENTS_BUTTON);
	
	String MULTIPLE_TEXTBOX_BUTTON = "//div[contains(text(),'Multiple Text Box')]/parent::div[@id='dvmtb']";
	WebPageElements multiple_textbox_button = new WebPageElements("Multiple Textbox Button", "xpath", MULTIPLE_TEXTBOX_BUTTON);
	
	String MULTIPLE_DROPDOWN_BUTTON = "//div[contains(text(),'Multiple Drop Down')]/parent::div[@id='dvmdd']";
	WebPageElements multiple_dropdown_button = new WebPageElements("Multiple DropDown Button", "xpath", MULTIPLE_DROPDOWN_BUTTON);
	
	String MULTIPLE_RADIO_BUTTON = "//div[contains(text(),'Radio Grid')]/parent::div[@id='dvrg']";
	WebPageElements multiple_radio_button = new WebPageElements("Multiple Radio Grid Button", "xpath", MULTIPLE_RADIO_BUTTON);
	
	String MULTIPLE_CHECKBOX_BUTTON = "//div[contains(text(),'Check Box Grid')]/parent::div[@id='dvcbg']";
	WebPageElements multiple_checkbox_button = new WebPageElements("Multiple Check Box Button", "xpath", MULTIPLE_CHECKBOX_BUTTON);
	
	String LISTBOX_BUTTON = "//div[contains(text(),'List Box')]/parent::div[@id='dvmslb']";
	WebPageElements listbox_button = new WebPageElements("List Box Button", "xpath", LISTBOX_BUTTON);
	
	String RATING_RADIO_BUTTON = "//div[contains(text(),'Rating Radio Grid')]/parent::div[@id='dvrrg']";
	WebPageElements rating_radio_button = new WebPageElements("Rating Radio Grid Button", "xpath", RATING_RADIO_BUTTON);
	
	String RATING_DROP_DOWN_BUTTON = "//div[contains(text(),'Rating Drop Down Grid')]/parent::div[@id='dvrddg']";
	WebPageElements rating_drop_down_button = new WebPageElements("Rating Drop Down Grid Button", "xpath", RATING_DROP_DOWN_BUTTON);
	
	String RATING_SCALE_GRID_BUTTON = "//div[contains(text(),'Rating Scale Grid')]/parent::div[@id='dvrcg']";
	WebPageElements rating_scale_grid_button = new WebPageElements("Rating Scale Grid Button", "xpath", RATING_SCALE_GRID_BUTTON);
	
	String MATRIX_GRID_BUTTON = "//div[contains(text(),'Matrix Grid')]/parent::div[@id='dvmg']";
	WebPageElements matrix_grid_button = new WebPageElements("Matrix Grid Button", "xpath", MATRIX_GRID_BUTTON);
	
	String IFRAME_BUTTON = "//iframe[@class='cke_wysiwyg_frame cke_reset']";
	WebPageElements iframe_button = new WebPageElements("Iframe Button", "xpath", IFRAME_BUTTON);
	
	String IFRAME_ADD_MANUALLY = "//iframe[contains(@src,'PresetList_AddManually.aspx')]";
	WebPageElements iframe_add_manually = new WebPageElements("Iframe Button", "xpath", IFRAME_ADD_MANUALLY);
	
	String IFRAME_ANSWER_OPTIONS = "//iframe[contains(@src,'PresetList_Use.aspx?CreateEditFlg')]";
	WebPageElements iframe_answer_options = new WebPageElements("Iframe Answer Options", "xpath", IFRAME_ANSWER_OPTIONS);
	
	String IFRAME_ANSWER_OPTIONS_GRID = "//iframe[contains(@src,'PresetList_Grid.aspx?')]";
	WebPageElements iframe_answer_options_grid = new WebPageElements("Iframe Answer Options", "xpath", IFRAME_ANSWER_OPTIONS_GRID);
	
	String IFRAME_ANSWER_OPTIONS2 = "//iframe[contains(@src,'PresetList_Grid.aspx?GridType')]";
	WebPageElements iframe_answer_options2 = new WebPageElements("Iframe Answer Options", "xpath", IFRAME_ANSWER_OPTIONS2);
	
	String IFRAME_ANSWER_OPTIONS3 = "//iframe[contains(@src,'PresetList_Use.aspx')]";
	WebPageElements iframe_answer_options3 = new WebPageElements("Iframe Questions Options", "xpath", IFRAME_ANSWER_OPTIONS3);
	
	String IFRAME_ANSWER_OPTIONS4 = "//iframe[contains(@src,'imgChoiceAnswers.aspx')]";
	WebPageElements iframe_answer_options4 = new WebPageElements("Iframe Questions Options", "xpath", IFRAME_ANSWER_OPTIONS4);
	
	String IFRAME_ANSWER_GRID = "//iframe[contains(@src,'gridmatrix_qm.aspx?')]";
	WebPageElements iframe_answer_grid = new WebPageElements("Iframe Questions Options", "xpath", IFRAME_ANSWER_GRID);
	 
	String DESCRIPTION_TEXT = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']";
	WebPageElements description_text = new WebPageElements("Description Text Input", "xpath", DESCRIPTION_TEXT);
	
	String MULTI_TEXT1 = "//tr[@id='trMTTextBoxes1']//input[@name='option1']";
	WebPageElements multi_text1 = new WebPageElements("Multi Textbox 1 Input", "xpath", MULTI_TEXT1);
	
	String MULTI_TEXT2 = "//tr[@id='trMTTextBoxes2']//input[@name='option2']";
	WebPageElements multi_text2 = new WebPageElements("Multi Textbox 2 Input", "xpath", MULTI_TEXT2);
	
	String MULTI_DROPDOWN1 = "//tr[@id='trMDTextBoxes1']//input[@name='MDoption1']";
	WebPageElements multi_dropdown1 = new WebPageElements("Multi Dropdown 1 Input", "xpath", MULTI_DROPDOWN1);
	
	String MULTI_DROPDOWN2 = "//tr[@id='trMDTextBoxes2']//input[@name='MDoption2']";
	WebPageElements multi_dropdown2 = new WebPageElements("Multi Dropdown 2 Input", "xpath", MULTI_DROPDOWN2);
	
	String SHOW_NA_OPTION = "//label[text()='Show N/A option']";
	WebPageElements show_na_option = new WebPageElements("Show N/A option", "xpath", SHOW_NA_OPTION);
	
	String NUMBER_SUBQUESTION = "//select[@name='DdlTotalControls_GQ']";
	WebPageElements number_subquestion = new WebPageElements("Number of Sub Questions", "xpath", NUMBER_SUBQUESTION);
	
	String SHOW_SCALE_IN_REVERSE = "//label[text()='Show scale in reverse order']";
	WebPageElements show_scale_in_reverse_order = new WebPageElements("Show scale in reverse order", "xpath", SHOW_SCALE_IN_REVERSE);
	
	String SHOW_PARTICIPANT_RATING_FIELD = "//label[text()='Show participant rating field']";
	WebPageElements show_participant_rating_field = new WebPageElements("Show participant rating field", "xpath", SHOW_PARTICIPANT_RATING_FIELD);
	
	String SAVE_BUTTON = "//input[@name='btnSaveQuestionAnswer']";
	WebPageElements save_button = new WebPageElements("Save Button", "xpath", SAVE_BUTTON);
	
	String SAVE_BUTTON_MANUAL = "//a[@id='hlnkCancel']/following-sibling::input[@name='btnSave']";
	WebPageElements save_button_manual = new WebPageElements("Save Button", "xpath", SAVE_BUTTON_MANUAL);
	
	String SAVE_BUTTON_IND = "//input[@name='btnSaveNBack']";
	WebPageElements save_button_ind = new WebPageElements("Save Button", "xpath", SAVE_BUTTON_IND);
	
	String SAVE_BUTTON_RETURN = "//input[@name='btnsaveandgotoquestmng']";
	WebPageElements save_button_return = new WebPageElements("Save Button Return", "xpath", SAVE_BUTTON_RETURN);
	
	String ANSWERS_LIBRARY = "(//a[contains(text(),'Answer Library')])[1]";
	WebPageElements answers_library = new WebPageElements("Answer Library Button", "xpath", ANSWERS_LIBRARY);
	
	String ANSWERS_LIBRARY2 = "(//li[contains(text(),'Answer Library')])[1]";
	WebPageElements answers_library2 = new WebPageElements("Answer Library Button", "xpath", ANSWERS_LIBRARY2);
	
	String QUESTIONS_LIBRARY2 = "(//li[contains(text(),'Question Library')])[1]";
	WebPageElements questions_library2 = new WebPageElements("Questions Library Button", "xpath", QUESTIONS_LIBRARY2);
	
	String QUESTIONS_LIBRARY3 = "(//div[contains(text(),'Attachment Properties')]/following::a[contains(text(),'Question Library') and @class='qmultiple_library'])[1]";
	WebPageElements questions_library3 = new WebPageElements("Questions Library Button", "xpath", QUESTIONS_LIBRARY3);
	
	String GET_QUESTIONS_QUESTIONS_LIBRARY = "(//div[contains(text(),'Attachment Properties')]/following::a[text()='Get questions from Question Library'])[1]";
	WebPageElements get_questions_questions_library = new WebPageElements("Questions Library Button", "xpath", GET_QUESTIONS_QUESTIONS_LIBRARY);
	
	String GET_ANSWER_OPTIONS_LIBRARY = "//a[text()='Get Answer Options from Answer Library']";
	WebPageElements get_answer_options_library = new WebPageElements("Get Answer Options from Answer Library Button", "xpath", GET_ANSWER_OPTIONS_LIBRARY);
	
	String ANWERS_LIBRARY_LABEL = "//div[text()='Answer Library']";
	WebPageElements ansers_liburary_label = new WebPageElements("Ansers Library Button", "xpath", ANWERS_LIBRARY_LABEL);
	
	String USE_THIS_LIST_BUTTON = "//input[@id='btnusethislist']";
	WebPageElements use_this_list_button = new WebPageElements("Use this list Button", "xpath", USE_THIS_LIST_BUTTON);
	
	String OTHER_CHCKBOX = "//input[@id='CHK_Other_CheckBox']/following-sibling::label[text()='Include \"Other\" text responses']";
	WebPageElements other_checkbox = new WebPageElements("Other checkbox", "xpath", OTHER_CHCKBOX);
	
	String OTHER_CHCKBOX2 = "//input[@id='CHK_Other']/following-sibling::label[text()='Include \"Other\" text responses']";
	WebPageElements other_checkbox2 = new WebPageElements("Other checkbox", "xpath", OTHER_CHCKBOX2);
	
	String NONE_OF_ABOVE = "//label[text()='Include \"None of the above\" ']";
	WebPageElements none_of_above = new WebPageElements("None of Above", "xpath", NONE_OF_ABOVE);
	
	String ADD_IMAGE_ICON = "(//div[@id='dvAddImgs'])[1]";
	WebPageElements add_image_icon = new WebPageElements("Add Image", "xpath", ADD_IMAGE_ICON);
	
	String ADD_IMAGE_ICON2 = "//div[@class='add_dv']/div[contains(@class,'addbtn')][1]";
	WebPageElements add_image_icon2 = new WebPageElements("Add Image", "xpath", ADD_IMAGE_ICON2);
	
	String REPORTING_VALUE = "//input[@name='txtRepVal']";
	WebPageElements reporting_value = new WebPageElements("Reporting Value", "xpath", REPORTING_VALUE);
	
	String BROWSE_BUTTON = "//input[@class='myAjaxUpload']";
	WebPageElements browse_button = new WebPageElements("Browse Button", "xpath", BROWSE_BUTTON);
	
	String NAME_EXPAND = "//a[text()='Name']";
	WebPageElements name_expand = new WebPageElements("Demographics Name", "xpath", NAME_EXPAND);
	
	String ADDRESS_EXPAND = "//a[text()='Address']";
	WebPageElements address_expand = new WebPageElements("Demographics Address", "xpath", ADDRESS_EXPAND);
	
	String TELEPHONE_EXPAND = "//a[text()='Telephone/Fax']";
	WebPageElements telephone_expand = new WebPageElements("Demographics Telephone/FAX", "xpath", TELEPHONE_EXPAND);
	
	String NAME_TITLE = "//label[text()='Title']";
	WebPageElements name_title = new WebPageElements("Demographics Name: Title", "xpath", NAME_TITLE);
	
	String NAME_FULL_NAME = "//label[text()='Full Name']";
	WebPageElements name_full_name = new WebPageElements("Demographics Name: Full Name", "xpath", NAME_FULL_NAME);
	
	String NAME_FIRST_NAME = "//label[text()='First Name ']";
	WebPageElements name_first_name = new WebPageElements("Demographics Name: First Name", "xpath", NAME_FIRST_NAME);
	
	String NAME_MIDDLE_NAME = "//label[text()='Middle Name/Initial']";
	WebPageElements name_middle_name = new WebPageElements("Demographics Name: Middle Name", "xpath", NAME_MIDDLE_NAME);
	
	String NAME_LAST_NAME = "//label[text()='Last Name']";
	WebPageElements name_last_name = new WebPageElements("Demographics Name: Last Name", "xpath", NAME_LAST_NAME);
	
	String GENDER = "//label[text()='Gender']";
	WebPageElements gender = new WebPageElements("Demographics Gender", "xpath", GENDER);
	
	String DOB = "//label[text()='Date of Birth  ']";
	WebPageElements dob = new WebPageElements("Demographics Date of Birth", "xpath", DOB);
	
	String ADDRESS_STREET1 = "//label[text()='Street 1']";
	WebPageElements address_street1 = new WebPageElements("Demographics Address: Street 1", "xpath", ADDRESS_STREET1);
	
	String ADDRESS_STREET2 = "//label[text()='Street 2']";
	WebPageElements address_street2 = new WebPageElements("Demographics Address: Street 2", "xpath", ADDRESS_STREET2);
	
	String ADDRESS_CITY = "//label[text()='City']";
	WebPageElements address_city = new WebPageElements("Demographics Address: City", "xpath", ADDRESS_CITY);
	
	String ADDRESS_COUNTRY = "//label[text()='County']";
	WebPageElements address_country = new WebPageElements("Demographics Address: Country", "xpath", ADDRESS_COUNTRY);
	
	String ADDRESS_STATE = "//label[text()='State']";
	WebPageElements address_state = new WebPageElements("Demographics Address: State", "xpath", ADDRESS_STATE);
	
	String ADDRESS_ZIP = "//label[text()='ZIP']";
	WebPageElements address_zip = new WebPageElements("Demographics Address: ZIP", "xpath", ADDRESS_ZIP);
	
	String ADDRESS_ZIPPLUS4 = "//label[text()='ZIP+4']";
	WebPageElements address_zipplus4 = new WebPageElements("Demographics Address: ZIP+4", "xpath", ADDRESS_ZIPPLUS4);
	
	String TELEPHONE_TELEPHONE = "//label[text()='Telephone']";
	WebPageElements telephone_telephone = new WebPageElements("Demographics Telephone/FAX: Telephone", "xpath", TELEPHONE_TELEPHONE);
	
	String TELEPHONE_EXTENSION = "//label[text()='Extension']";
	WebPageElements telephone_extension = new WebPageElements("Demographics Telephone/FAX: Extension", "xpath", TELEPHONE_EXTENSION);
	
	String TELEPHONE_FAX = "//label[text()='Fax']";
	WebPageElements telephone_fax = new WebPageElements("Demographics Telephone/FAX: Fax", "xpath", TELEPHONE_FAX);
	
	String EMAIL_ADDRESS = "//label[text()='Email Address']";
	WebPageElements email_address = new WebPageElements("Demographics Email Address", "xpath", EMAIL_ADDRESS);
	
	String REENTER_EMAIL_ADDRESS = "//label[text()='Require to re-enter email address.']";
	WebPageElements reenter_email_address = new WebPageElements("Demographics Require to re-enter email address", "xpath", REENTER_EMAIL_ADDRESS);
	
	
	String DESIGNER_BUTTON = "//span[contains(text(),'Designer')]";
	WebPageElements designer_button = new WebPageElements("Designer button", "xpath", DESIGNER_BUTTON);
	
	String QUESTION_MENU = "//div[contains(@class,'qltcontainer ')]";
	WebPageElements question_menu = new WebPageElements("Question Menu", "xpath", QUESTION_MENU);
	
	String QUESTION_MENU_MORE_OPTIONS = "//div[contains(@class,'content-wrapper')][contains(@onclick,'funcShowMoreMenu(this);')]";
	WebPageElements question_menu_more_options = new WebPageElements("Question Menu - More Options", "xpath", QUESTION_MENU_MORE_OPTIONS);
	
	String QUESTION_MENU_DELETE_OPTION = "//span[contains(text(),'Delete')][@class='caption']";
	WebPageElements question_menu_delete_option = new WebPageElements("Question Menu - Delete Option", "xpath", QUESTION_MENU_DELETE_OPTION);
	
	String DEPOSITE_TO_QUESTION_BANK_OPTION = "//a[contains(text(),'Deposit to Question Bank')]";
	WebPageElements deposite_to_question_bank_option = new WebPageElements("Question Menu - Deposite to Question Bank Option", "xpath", DEPOSITE_TO_QUESTION_BANK_OPTION);
	
	String DEPOSITE_TO_QUESTION_BANK_MODAL = "//div[contains(@class,'fbcmodalTitle')][contains(text(),'Deposit to Question Bank')]";
	WebPageElements deposite_to_question_bank_modal = new WebPageElements("Deposite to Question Bank Modal", "xpath", DEPOSITE_TO_QUESTION_BANK_MODAL);
	
	String DROP_DOWN_OF_SELECT_CATEGORY = "//div[contains(@class,'DepositQBHolder')]";
	WebPageElements drop_down_of_select_category = new WebPageElements("Select Category Drop down of Deposite to Question bank Modal", "xpath", DROP_DOWN_OF_SELECT_CATEGORY);
	
	String CATEGORY_LIST = "//span[contains(@class,'clsCategoryText')]";
	WebPageElements category_list = new WebPageElements("List of category present in survey", "xpath", CATEGORY_LIST);
	
	String ADD_CATEGORY = "//div[contains(text(),'Add Category')]";
	WebPageElements add_category = new WebPageElements("Add Category", "xpath", ADD_CATEGORY);
	
	String ADD_CATEGORY_INPUT_FIELD = "//input[@id='txtNewGroupName']";
	WebPageElements add_category_input_field = new WebPageElements("Add Category Name", "xpath", ADD_CATEGORY_INPUT_FIELD);
	
	String SAVE_CATEGORY_NAME = "//a[@id='lnkAddCat']";
	WebPageElements save_category_name = new WebPageElements("Save Category Name", "xpath", SAVE_CATEGORY_NAME);
	
	String DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER = "//span[contains(@class,'clsCategoryText')]";
	WebPageElements drop_down_of_select_category_placeholder = new WebPageElements("Placeholder field of select category drop down", "xpath", DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER);
	
	String DEPOSITE_BUTTON = "//input[contains(@value,'Deposit')]";
	WebPageElements deposite_button = new WebPageElements("Deposite button", "xpath", DEPOSITE_BUTTON);
	
	String TOASTER_MSG_OF_DEPOSITE_TO_QUESTION_BANK = "//span[contains(@id,'spnMsg')][contains(text(),'Question deposited to Question Bank')]";
	WebPageElements toaster_msg_of_deposite_to_question_bank = new WebPageElements("Toaster message - Question deposited to Question Bank", "xpath", TOASTER_MSG_OF_DEPOSITE_TO_QUESTION_BANK);
	
	String TOASTER_MSG_OF_CATEGORY_ADDED = "//span[contains(@id,'spnMsg')][contains(text(),'Category added successfully.')]";
	WebPageElements toaster_msg_of_category_added = new WebPageElements("Toaster message - Category added successfully.", "xpath", TOASTER_MSG_OF_CATEGORY_ADDED);
	
	String CLOSE_TOASTER_MSG = "//div[@id = 'dvMsg']/span[3]";
	WebPageElements close_toaster_msg = new WebPageElements("Close Toaster message", "xpath", CLOSE_TOASTER_MSG);
	
	String QUESTION_DESCRIPTIVE_TEXT = "//div[@id='dvcom']";
	WebPageElements question_descriptive_text = new WebPageElements("Descriptive Text Question", "xpath", QUESTION_DESCRIPTIVE_TEXT);
	
	String QUESTION_TEXT_CONTENT = "//div[@id='ck_QuestionText_contents']";
	WebPageElements question_text_content = new WebPageElements("Descriptive Question - Tex Content", "xpath", QUESTION_TEXT_CONTENT);
	
	String IFRAME_DESCRIPTIVE_TEXT = "//iframe[contains(@title,'Rich Text Editor, QuestionText')]";
	WebPageElements iframe_descriptive_text = new WebPageElements("Descriptive Text Question - IFRAME", "xpath", IFRAME_DESCRIPTIVE_TEXT);
	
	String HEADER_DESCRIPTIVE_TEXT = "//span[@id='dvQTextORComment']";
	WebPageElements header_descriptive_text = new WebPageElements("Descriptive text header", "xpath", HEADER_DESCRIPTIVE_TEXT);
	
	String QUESTION_DESCRIPTIVE_TEXT_INPUT_FIELD = "//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]";
	WebPageElements question_descriptive_text_input_field = new WebPageElements("Descriptive Text Question -  Input field", "xpath", QUESTION_DESCRIPTIVE_TEXT_INPUT_FIELD);
	
	String PAGE_NUMBER_DROP_DOWN = "//div[@id='divPageNo']";
	WebPageElements page_number_drop_down = new WebPageElements("Page Number Drop Down", "xpath", PAGE_NUMBER_DROP_DOWN);
	
	String GO_TO_PAGE_LIST = "//div[@id='dvGotoPage']";
	WebPageElements go_to_page_list = new WebPageElements("Go to Page list", "xpath", GO_TO_PAGE_LIST);	
	
	String PAGE_NUMBER_DROP_DOWN_VALUE_1 = "//div[@id='divPageNo'][@pageno='1']";
	WebPageElements page_number_drop_down_value_1 = new WebPageElements("Page Number Drop Down - Page 1", "xpath", PAGE_NUMBER_DROP_DOWN_VALUE_1);
	
	String LIST_OF_SURVEY_PAGES = "//a[starts-with(text(),'Page')][@class='arrw']";
	WebPageElements list_of_survey_pages = new WebPageElements("Survey Pages", "xpath", LIST_OF_SURVEY_PAGES);
		
	String PAGE_ACTIONS = "//div[@title='Page Actions']";
	WebPageElements page_actions = new WebPageElements("Page Actions", "xpath", PAGE_ACTIONS);
	
	String MOVE_PAGE = "//a[@id='ancmove']";
	WebPageElements move_page = new WebPageElements("Page Actions - Move Page", "xpath", MOVE_PAGE);
	
	String MOVE_PAGE_OPTIONS = "//select[@id='LBMovePage']";
	WebPageElements move_page_options = new WebPageElements("Move Page Options", "xpath", MOVE_PAGE_OPTIONS);
	
	String LIST_OF_QUESTION_IN_SURVEY = "//div[contains(@class,'ui-sortable-handle')][@content='item']";
	WebPageElements list_of_question_in_survey = new WebPageElements("Total Questions in Survey", "xpath", LIST_OF_QUESTION_IN_SURVEY);
	
	String QUESTION_PAGE_LOADER = "//div[@id='smallloaderfull']";
	WebPageElements question_page_loader = new WebPageElements("Question Page Loader", "xpath", QUESTION_PAGE_LOADER);
	
	String MOVE_QUESTION = "//div[@class='move']";
	WebPageElements move_question = new WebPageElements("Move Question", "xpath", MOVE_QUESTION);
	
	String MOVE_QUESTION_OPTIONS = "//ul[contains(@class,' MoveQues ps-container')]/li";
	WebPageElements move_question_options = new WebPageElements("Select Move Question Options", "xpath", MOVE_QUESTION_OPTIONS);
	
	
	
	
	
}
