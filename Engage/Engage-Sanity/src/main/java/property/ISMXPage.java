package property;

import utility.WebPageElements;

public interface ISMXPage {

	String CREATE_PROJECT = "//span[text()='Create Project']";
	WebPageElements create_project = new WebPageElements("Create Project Button", "xpath", CREATE_PROJECT);
	
	String CREATE_POLL = "//div[@class='cls-projecttype-container']//div[contains(text(),'Poll')]";
	WebPageElements create_poll = new WebPageElements("Create Poll Button", "xpath", CREATE_POLL);
	
	String ANSWER_LIBRARY = "//div[@id='dvAnswerCat']";
	WebPageElements answer_library = new WebPageElements("Answer library", "xpath", ANSWER_LIBRARY);
	
	String CONTINUE_BUTTONP = "//input[@onclick='ValidateStep2();']";
	WebPageElements continue_buttonp = new WebPageElements("Continue Buttonp", "xpath", CONTINUE_BUTTONP);
	
	String USE_THIS_LIST = "//input[@id='btnusethislist']";
	WebPageElements use_this_list = new WebPageElements("Use This List", "xpath", USE_THIS_LIST);
	
	String EXPIRY_DATE_AND_TIME = "//label[@for='rdExpireYes']";
	WebPageElements  Expiry_Date_and_Time = new WebPageElements("Expiry date and time", "xpath", EXPIRY_DATE_AND_TIME);
	
	
	String RESULT_SETTINGS = "//label[@for='DispresT']";
	WebPageElements Result_Settings = new WebPageElements ("Result Settings","xpath",RESULT_SETTINGS);
	
	
	String PARTICIPATION_POLL_SUBMIT = "//input[@class='btnPoll']";
	WebPageElements Participation_Poll_Submit = new WebPageElements ("Result Settings","xpath",PARTICIPATION_POLL_SUBMIT);
	
	
	String TRACK_POLL = "//input[@id='btnErrorSave']";
	WebPageElements Track_Poll = new WebPageElements("Create Poll", "xpath",TRACK_POLL );
	
	
	String CONTINUE_BUTTONT = "//input[@onclick='ValidateStep2a()']";
	WebPageElements Continue_Buttont = new WebPageElements("Continue Button Translate", "xpath",CONTINUE_BUTTONT );
	
	
	String CONTINUE_BUTTONPS = "//input[@onclick='ValidateStep3()']";
	WebPageElements Continue_Buttonps = new WebPageElements("Continue Button Poll Settings","xpath",CONTINUE_BUTTONPS);
	
	
	
	String CONTINUE_BUTTONVS = "//input[@onclick='StepNext4();']";
	WebPageElements Continue_Buttonvs = new WebPageElements("Continue Visual Settings","xpath",CONTINUE_BUTTONVS);
	
	
	String CONTINUE_BUTTONRS = "//input[@id='btnMainSubmit']";
	WebPageElements Continue_Buttonrs = new WebPageElements("Continue Result Settings","xpath",CONTINUE_BUTTONRS);
	
	
	String EXPRIE_POLL_YES = "//label[@for='rdExpireYes']";
	WebPageElements expire_poll_yes = new WebPageElements("radio button for expire","xpath",EXPRIE_POLL_YES);
	
	
	String SAVE_AND_FINISH = "//input[@id='mainsubmit']";
	WebPageElements Save_And_Finish = new WebPageElements("Save and finish","xpath",SAVE_AND_FINISH);
	
	
	String PUBLIC_ACCESS = "//span[@title='View Individual Response']/parent::a";
	WebPageElements Public_Access = new WebPageElements("Public Access","xpath",PUBLIC_ACCESS);
	
	
	
	String BEGIN_LABEL = "//div[text()='Where would you like to begin?']";
	WebPageElements begin_label = new WebPageElements("Where would you like to begin?", "xpath", BEGIN_LABEL);
	
	String SURVEY_BUTTON = "(//div[text()='Survey']//parent::div[contains(@class,'project-type-container')])[1]";
	WebPageElements survey_button = new WebPageElements("Survey Button", "xpath", SURVEY_BUTTON);
	
	String BLANK_SURVEY = "//div[@id='dvstartNew']";
	WebPageElements blank_survey = new WebPageElements("Start with a Blank Survey Button", "xpath", BLANK_SURVEY);
	
	String CONTINUE_BUTTON = "//input[@id='btnContinue' and @type='button']";
	WebPageElements continue_button = new WebPageElements("Continue Button", "xpath", CONTINUE_BUTTON);
	
	String CREATE_SURVEY_LABEL = "//div[text()='Create New Survey']";
	WebPageElements create_survey_label = new WebPageElements("Create New Survey Label", "xpath", CREATE_SURVEY_LABEL);
	
	String SURVEY_NAME = "//input[@id='txtSurveyTitle']";
	WebPageElements survey_name = new WebPageElements("Survey Name", "xpath", SURVEY_NAME);
	
	String FOLDER = "//div[@class='folder-select']";
	WebPageElements folder = new WebPageElements("Select Folder", "xpath", FOLDER);
	
	String PRIMARY_LANGUAGE_DD = "//div[@id='dvPrimaryFolder']";
	WebPageElements primary_lanugage_dd = new WebPageElements("Primary Langugage Drop down", "xpath", PRIMARY_LANGUAGE_DD);
	
	String PRIMARY_LANGUAGE_LIST = "//div[@class='o-menu-list primary-dd-language']";
	WebPageElements primary_lanugage_list = new WebPageElements("Primary Langugage List", "xpath", PRIMARY_LANGUAGE_LIST);
	
	String SECONDARY_LANGUAGE_DD = "//div[@class='SecondaryHolder']";
	WebPageElements secondary_lanugage_dd = new WebPageElements("Secondary Langugage Drop down", "xpath", SECONDARY_LANGUAGE_DD);
	
	String SECONDARY_LANGUAGE_DD_SEARCH = "//input[@class='SearchInput ']";
	WebPageElements secondary_lanugage_dd_search = new WebPageElements("Secondary Langugage Drop down Search", "xpath", SECONDARY_LANGUAGE_DD_SEARCH);
	
	String START_BUTTON = "//input[@id='CreateNewProject']";
	WebPageElements start_button = new WebPageElements("Create Button", "xpath", START_BUTTON);
	
	String SECONDARY_LANGUAGE_SWITCH = "//label[@id='rbAdditionalLanguageToggle']";
	WebPageElements secondary_language_switch = new WebPageElements("Secondary Language Switch", "xpath", SECONDARY_LANGUAGE_SWITCH);
	
	String BLANK_PAGE = "//div[@class='blank-page ui-sortable-handle']";
	WebPageElements blank_page = new WebPageElements("Blank Question Manager Page", "xpath", BLANK_PAGE);
	
	String DESCRIPTION_BUTTON = "//div[contains(text(),'Descriptive Text')]/parent::div[@id='dvcom']";
	WebPageElements description_button = new WebPageElements("Description Button", "xpath", DESCRIPTION_BUTTON);
	
	String QUESTION_HINT = "//input[@id='chkQuestionTip']";
	WebPageElements question_hint = new WebPageElements("Question Hint Check Box", "xpath", QUESTION_HINT);
	
	String QUESTION_HINT_TB = "//textarea[@id='txtQuestionTip']";
	WebPageElements question_hint_tb = new WebPageElements("Question Hint Text Area", "xpath", QUESTION_HINT_TB);
	
	String ADD_MEDIA = "//a[@id='advEdit']";
	WebPageElements add_media = new WebPageElements("Add Media", "xpath", ADD_MEDIA);
	
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
	
	String NUMERIC_ALLOCATION = "//div[contains(text(),'Numeric Allocation')]/parent::div[@id='dvNumeric']";
	WebPageElements numeric_allocation = new WebPageElements("Numeric Allocation", "xpath", NUMERIC_ALLOCATION);
	
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
	
	String IFRAME_ADD_MEDIA = "//iframe[starts-with(@src,'advImMedia.aspx?')]";
	WebPageElements iframe_add_media = new WebPageElements("Add Media Iframe", "xpath", IFRAME_ADD_MEDIA);
	
	String BROWSE_LABEL = "//label[text()='browse']";
	WebPageElements browse_label = new WebPageElements("Browse", "xpath", BROWSE_LABEL);
	
//	String BROWSE = "//input[@id='btnUploadImageOrMedia']";
//	WebPageElements browse = new WebPageElements("Browse", "xpath", BROWSE);
	
	String BROWSE = "//div/input[@type='file']";
	WebPageElements browse = new WebPageElements("Browse", "xpath", BROWSE);
	
	String SAVE_AND_GO_BACK = "//input[@id='btnSaveGoToQM']";
	WebPageElements save_and_go_back = new WebPageElements("Save and Go Back", "xpath", SAVE_AND_GO_BACK);
	
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
	
	String ANSWERS_LIBRARY_NEW = "//div[@class='ansLibraryContainer']";
	WebPageElements answers_library_new = new WebPageElements("Answer Library Menu", "xpath", ANSWERS_LIBRARY_NEW);
	
	String ANSWERS_LIBRARY_GRID = "//div[@id='menu_0']/div/div[@class='ansLibraryContainer']";
	WebPageElements answers_library_grid = new WebPageElements("Answer Library Menu", "xpath", ANSWERS_LIBRARY_GRID);
	
	String SEARCH_ANS_LIB = "//input[@id='txtSearchAnsLib']";
	WebPageElements search_ans_lib = new WebPageElements("Search", "xpath", SEARCH_ANS_LIB);
	
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
	
	String OTHER_CHCKBOX2 = "//input[@id='CHK_Other_Check']/following-sibling::label[text()='Include \"Other\" text responses']";
	WebPageElements other_checkbox2 = new WebPageElements("Other checkbox2", "xpath", OTHER_CHCKBOX2);
	
	String OTHER_PLZ_TEXTBOX = "//input[@id='TB_Other']";
	WebPageElements other_plz_textbox = new WebPageElements("Other Please Specify Lable Text Box", "xpath", OTHER_PLZ_TEXTBOX);
	
	String SELECT_OTHER_PLZ_TB_WIDTH = "//select[@id='DDL_TextboxWidth_Other']";
	WebPageElements select_other_plz_tb_width = new WebPageElements("Other Please Specify Width Drop Down", "xpath", SELECT_OTHER_PLZ_TB_WIDTH);
	
	String NONE_OF_ABOVE = "//div[@id='dispNoneOfAbove_check']//label[text()='Include \"None of the above\" ']";
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
	
	String ANSWER_QUOTA = "//a[text()='Set Answer Quota']";
	WebPageElements answer_quota = new WebPageElements("Set Answer Quota", "xpath", ANSWER_QUOTA);
	
	String IFRAME_ANSWER_QUOTA = "//iframe[contains(@src,'Qmgmt.aspx?')]";
	WebPageElements iframe_answer_quota = new WebPageElements("Set Answer Quota - Iframe", "xpath", IFRAME_ANSWER_QUOTA);
	
	String RESET = "//a[text()='Reset']";
	WebPageElements reset = new WebPageElements("Reset", "xpath", RESET);
	
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
	
//	String DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER = "//span[contains(@class,'clsCategoryText')]";
//	WebPageElements drop_down_of_select_category_placeholder = new WebPageElements("Placeholder field of select category drop down", "xpath", DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER);
	
	String DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER = "//span[contains(@class,'SecondPlaceholder')]";
	WebPageElements drop_down_of_select_category_placeholder = new WebPageElements("Placeholder field of select category drop down", "xpath", DROP_DOWN_OF_SELECT_CATEGORY_PLACEHOLDER);
	
	String DEPOSITE_BUTTON = "//input[contains(@value,'Deposit')]";
	WebPageElements deposite_button = new WebPageElements("Deposite button", "xpath", DEPOSITE_BUTTON);
	
	String TOASTER_MSG_OF_DEPOSITE_TO_QUESTION_BANK = "//span[contains(@id,'spnMsg')][contains(text(),'Question deposited to Question Bank')]";
	WebPageElements toaster_msg_of_deposite_to_question_bank = new WebPageElements("Toaster message - Question deposited to Question Bank", "xpath", TOASTER_MSG_OF_DEPOSITE_TO_QUESTION_BANK);
	
	String TOASTER_MSG_OF_EXHUSTED_LIMIT = "//span[contains(@id,'spnMsg')][contains(text(),'You have exhausted the maximum limit of 100 questions for this group. Please Select another Group from the Question Bank page or reduce the number of questions.')]";
	WebPageElements toaster_msg_of_exhausted_limit = new WebPageElements("Toaster message - Limit exhausted of question bank category", "xpath", TOASTER_MSG_OF_EXHUSTED_LIMIT);
	
	String TOASTER_MSG = "//span[contains(@id,'spnMsg')]";
	WebPageElements toaster_msg = new WebPageElements("Toaster message", "xpath", TOASTER_MSG);
		
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
	
	String ALL_PAGES = "//a[starts-with(text(),'All Pages')]";
	WebPageElements all_pages = new WebPageElements("All Pages", "xpath", ALL_PAGES);
		
	String PAGE_ACTIONS = "//div[@title='Page Actions']";
	WebPageElements page_actions = new WebPageElements("Page Actions", "xpath", PAGE_ACTIONS);
	
	String MOVE_PAGE = "//a[@id='ancmove']";
	WebPageElements move_page = new WebPageElements("Page Actions - Move Page", "xpath", MOVE_PAGE);
	
	String COPY_PAGE = "//a[@id='anccopy']";
	WebPageElements copy_page = new WebPageElements("Page Actions - Copy Page", "xpath", COPY_PAGE);
	
	String DELETE_PAGE = "//a[@id='ancdelete']";
	WebPageElements delete_page = new WebPageElements("Page Actions - Delete Page", "xpath", DELETE_PAGE);
	
	String MOVE_PAGE_OPTIONS = "//select[@id='LBMovePage']";
	WebPageElements move_page_options = new WebPageElements("Move Page Options", "xpath", MOVE_PAGE_OPTIONS);
	
	String COPY_PAGE_OPTIONS = "//select[@id='LBCopyPage']";
	WebPageElements copy_page_options = new WebPageElements("Copy Page Options", "xpath", COPY_PAGE_OPTIONS);
	
	String LIST_OF_QUESTION_IN_SURVEY = "//div[contains(@class,'ui-sortable-handle')][@content='item']";
	WebPageElements list_of_question_in_survey = new WebPageElements("Total Questions in Survey", "xpath", LIST_OF_QUESTION_IN_SURVEY);
	
	String QUESTION_TITLE = "//span[contains(@id,'Qtitle_')]";
	WebPageElements question_title = new WebPageElements("Question title", "xpath", QUESTION_TITLE);
	
	String QUESTION_PAGE_LOADER = "//div[@id='smallloaderfull']";
	WebPageElements question_page_loader = new WebPageElements("Question Page Loader", "xpath", QUESTION_PAGE_LOADER);
	
	String MOVE_QUESTION = "//div[@class='move']";
	WebPageElements move_question = new WebPageElements("Move Question", "xpath", MOVE_QUESTION);
	
	String MOVE_QUESTION_OPTIONS = "//ul[contains(@class,' MoveQues ps-container')]/li";
	WebPageElements move_question_options = new WebPageElements("Select Move Question Options", "xpath", MOVE_QUESTION_OPTIONS);
	
	String INCREASE_SRS_SUBQUE = "//div[contains(@onclick,'fnIncreaseSRSSubQuestion') and @class='step-plus']";
	WebPageElements increase_srs_subque = new WebPageElements("Increase SRS Question Button", "xpath", INCREASE_SRS_SUBQUE);
	
	String EXPAND_NUM_OF_QUE = "//div[@id='divNumberOfQuestions']//div[@class='txt_opts_mg']";
	WebPageElements expand_num_of_que = new WebPageElements("Number of Question", "xpath", EXPAND_NUM_OF_QUE);
	
	String EXPAND_NUM_OF_SUBQUE = "//div[@id='stepperNumberOfSubQuestions']/parent::div[@class='txt_opts_mg']";
	WebPageElements expand_num_of_subque = new WebPageElements("Number of SubQuestion", "xpath", EXPAND_NUM_OF_SUBQUE);
	
	String ADD_SUBQUE = "//div[contains(@onclick,'addSubQuestions(1)') and @class='step-plus']";
	WebPageElements add_subque = new WebPageElements("Add Sub-question Button", "xpath", ADD_SUBQUE);
	
	String REMOVE_SUBQUE = "//div[contains(@onclick,'deleteOneRow()') and @class='step-minus']";
	WebPageElements remove_subque = new WebPageElements("Remove Sub-question Button", "xpath", REMOVE_SUBQUE);
	
	String ADD_QUE = "//div[@id='stepperNumberOfQuestions']/div[@class='step-plus']";
	WebPageElements add_que = new WebPageElements("Add Question Button", "xpath", ADD_QUE);
	
	String REMOVE_QUE = "//div[@id='stepperNumberOfQuestions']/div[@class='step-minus']";
	WebPageElements remove_que = new WebPageElements("Remove Question Button", "xpath", REMOVE_QUE);
	
	String MANDATORY_BTN_LABEL = "//label[@id='lblMandatory']";
	WebPageElements mandatory_btn_label = new WebPageElements("Mandatory Button Label", "xpath", MANDATORY_BTN_LABEL);
	
	String MANDATORY_BTN = "//input[@id='chkMandatory']";
	WebPageElements mandatory_btn = new WebPageElements("Mandatory Button", "xpath", MANDATORY_BTN);
	
	String ENCOURAGE_BTN_LABEL = "//label[@id='lblChkSoftRequired']";
	WebPageElements encourage_btn_label = new WebPageElements("Encouraged Button Label", "xpath", ENCOURAGE_BTN_LABEL);
	
	String ENCOURAGE_BTN = "//input[@id='chkSoftRequired']";
	WebPageElements encourage_btn = new WebPageElements("Encouraged Button", "xpath", ENCOURAGE_BTN);
	
	String ENCOURAGE_MSG_TB = "//textarea[@id='txtSoftRequiredErrorMsg']";
	WebPageElements encourage_msg_tb = new WebPageElements("Encouraged Message Text Box", "xpath", ENCOURAGE_MSG_TB);
	
	String SELECT_TB_FORMAT = "//select[@id='DDL_AnswerSubType']";
	WebPageElements select_tb_format = new WebPageElements("TB Format Drop Down", "xpath", SELECT_TB_FORMAT);
	
	String MAX_WORDS = "//input[@id='TB_MaximumWords']";
	WebPageElements max_words = new WebPageElements("Maximum characters allowed Text Box", "xpath", MAX_WORDS);
	
	String CURRECY_SYMBOL = "//label[@id='lblcurrency']";
	WebPageElements currency_symbol = new WebPageElements("Append Currency Symbol", "xpath",CURRECY_SYMBOL);
	
	String RE_ENTER_EMAIL = "//label[@id='lblreEnterText']";
	WebPageElements re_enter_email = new WebPageElements("Re-Enter Email Address Label", "xpath",RE_ENTER_EMAIL);
	
	String ALLOW_INT_ONLY = "//label[@id='lblAllowOnlyIntegerValue']";
	WebPageElements allow_int_only = new WebPageElements("Allow Integer Only Label", "xpath",ALLOW_INT_ONLY);
	
	String FROM_RAGE_TB = "//input[@id='TB_NumRangeFrom']";
	WebPageElements from_range_tb = new WebPageElements("From Field", "xpath",FROM_RAGE_TB);
	
	String CUSTOM_FORMAT_TB = "//input[@id='txt_CustomFormat']";
	WebPageElements custom_format_tb = new WebPageElements("Custom Format Textbox", "xpath",CUSTOM_FORMAT_TB);
	
	String VALIDATION_DD = "//div[@id='layer_errormsg']";
	WebPageElements validation_dd = new WebPageElements("Validation Message Drop down", "xpath",VALIDATION_DD);
	
	String DATA_POPULATION_DD = "//div[contains(text(),'Data Population')][@class='txt_opts Data_pop']";
	WebPageElements data_population_dd = new WebPageElements("Data Population Drop down", "xpath", DATA_POPULATION_DD);
	
	String DATA_POPULATION_MENU = "//ul[@id='Ul1']";
	WebPageElements data_population_menu = new WebPageElements("Data Population Menu", "xpath", DATA_POPULATION_MENU);
	
	String PRE_READ = "//label[@for='rdPrePopReadOnly']";
	WebPageElements pre_read = new WebPageElements("Pre Read Only", "xpath", PRE_READ);
	
	String PRE_EDIT = "//label[@for='rdPrePopEditable']";
	WebPageElements pre_edit = new WebPageElements("Pre Edit", "xpath", PRE_EDIT);
	
	String PRE_HIDDEN = "//label[@for='rdPrePopHidden']";
	WebPageElements pre_hidden = new WebPageElements("Pre Hidden", "xpath", PRE_HIDDEN);
	
	String POST_SHOW = "//label[@for='rdPrePopShow']";
	WebPageElements post_show = new WebPageElements("Post Show", "xpath", POST_SHOW);
	
	String POST_HIDE = "//label[@for='rdPrePopHide']";
	WebPageElements post_hide = new WebPageElements("Post Hide", "xpath", POST_HIDE);
	
	String SHORT_ANS_TEXT_CB = "//label[@id='lblSingleLine']";
	WebPageElements short_ans_text_cb = new WebPageElements("Allow only short answer text", "xpath", SHORT_ANS_TEXT_CB);
	
	String CROSS_BUTTON = "//div[@onclick='closeTabPanel(this)']";
	WebPageElements cross_button = new WebPageElements("Close Preview Question", "xpath", CROSS_BUTTON);
	
	String DESCRIPTION_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='com']";
	WebPageElements description_sample = new WebPageElements("Description Sample Preview", "xpath", DESCRIPTION_SAMPLE);
	
	String NPS_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratescale_NPS']";
	WebPageElements nps_sample = new WebPageElements("NPS Sample Preview", "xpath", NPS_SAMPLE);
	
	String TB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='tb']";
	WebPageElements tb_sample = new WebPageElements("Text Box Sample Preview", "xpath", TB_SAMPLE);
	
	String RB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='rb']";
	WebPageElements rb_sample = new WebPageElements("Radio Button Sample Preview", "xpath", RB_SAMPLE);
	
	String CB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='mscb']";
	WebPageElements cb_sample = new WebPageElements("Check Box Sample Preview", "xpath", CB_SAMPLE);
	
	String DD_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='dd']";
	WebPageElements dd_sample = new WebPageElements("Drop Down Sample Preview", "xpath", DD_SAMPLE);
	
	String DEMO_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='demograph']";
	WebPageElements demo_sample = new WebPageElements("Demographics Sample Preview", "xpath", DEMO_SAMPLE);
	
	String RATING_SCALE_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratescale']";
	WebPageElements rating_scale_sample = new WebPageElements("Rating scale Sample Preview", "xpath", RATING_SCALE_SAMPLE);
	
	String SYMBOL_RATING_SCALE_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='GraphicalRating']";
	WebPageElements symbol_rating_scale_sample = new WebPageElements("Symbol rating scale Sample Preview", "xpath", SYMBOL_RATING_SCALE_SAMPLE);
	
	String LIKE_DISLIKE_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='likeDisLike']";
	WebPageElements like_dislike_sample = new WebPageElements("Like/Dislike Sample Preview", "xpath", LIKE_DISLIKE_SAMPLE);
	
	String DATE_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='date']";
	WebPageElements date_sample = new WebPageElements("Date Sample Preview", "xpath", DATE_SAMPLE);
	
	String RANKING_SAMPLE = "//div[starts-with(@class,'TabbedPanelsContent')][@id='rank']";
	WebPageElements ranking_sample = new WebPageElements("Ranking Sample Preview", "xpath", RANKING_SAMPLE);
	
	String IMC_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='imgChoice']";
	WebPageElements imc_sample = new WebPageElements("Image Choice Sample Preview", "xpath", IMC_SAMPLE);
	
	String MTB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='mtb']";
	WebPageElements mtb_sample = new WebPageElements("Multiple Text Box Sample Preview", "xpath", MTB_SAMPLE);
	
	String MDD_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='mdd']";
	WebPageElements mdd_sample = new WebPageElements("Multiple Drop Down Sample Preview", "xpath", MDD_SAMPLE);
	
	String RG_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='radioGrid']";
	WebPageElements rg_sample = new WebPageElements("Radio Grid Sample Preview", "xpath", RG_SAMPLE);
	
	String CBG_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='checkBoxGrid']";
	WebPageElements cbg_sample = new WebPageElements("Check Box Grid Sample Preview", "xpath", CBG_SAMPLE);
	
	String RRG_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratingRadioGrid']";
	WebPageElements rrg_sample = new WebPageElements("Rating Radio Grid Sample Preview", "xpath", RRG_SAMPLE);
	
	String RDDG_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratingDropDownGrid']";
	WebPageElements rddg_sample = new WebPageElements("Rating Drop Down Grid Sample Preview", "xpath", RDDG_SAMPLE);
	
	String RSG_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratingScaleGrid']";
	WebPageElements rsg_sample = new WebPageElements("Rating Scale Grid Sample Preview", "xpath", RSG_SAMPLE);
	
	String HRB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='hrb']";
	WebPageElements hrb_sample = new WebPageElements("Horizontal Sample Preview", "xpath", HRB_SAMPLE);
	
	String LB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='mslb']";
	WebPageElements lb_sample = new WebPageElements("List Box Sample Preview", "xpath", LB_SAMPLE);
	
	String RRB_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='raterb']";
	WebPageElements rrb_sample = new WebPageElements("Rating Radio Button Sample Preview", "xpath", RRB_SAMPLE);
	
	String RDD_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='ratedd']";
	WebPageElements rdd_sample = new WebPageElements("Rating Drop Down Sample Preview", "xpath", RDD_SAMPLE);
	
	String ATTACHMENT_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='attachment']";
	WebPageElements attachment_sample = new WebPageElements("Attachment Sample Preview", "xpath", ATTACHMENT_SAMPLE);
	
	String NUMERICAL_ALLOCATION_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='num']";
	WebPageElements numerical_allocation_sample = new WebPageElements("Numerical Allocation Sample Preview", "xpath", NUMERICAL_ALLOCATION_SAMPLE);
	
	String MATRIX_GRID_SAMPLE = "//div[@class='TabbedPanelsContent'][@id='matrix']";
	WebPageElements matrix_grid_sample = new WebPageElements("Matrix Grid Sample Preview", "xpath", MATRIX_GRID_SAMPLE);
	
	String SELECT_ATTACHMENT_SUBQUES = "//select[@id='DdlTotalControls_AT']";
	WebPageElements select_attachment_subques = new WebPageElements("Attachment Subquestion Drop down", "xpath", SELECT_ATTACHMENT_SUBQUES);
	
	String NORMAL_VIEW = "//a[@id='swtNw']";
	WebPageElements noraml_view = new WebPageElements("Normal View", "xpath", NORMAL_VIEW);
	
	String LIST_VIEW = "//a[@id='swtLw']";
	WebPageElements list_view = new WebPageElements("List View", "xpath", LIST_VIEW);
	
	String NORMAL_VIEW_TEXT_AREA = "//textarea[@id='lstView']";
	WebPageElements noraml_view_text_area = new WebPageElements("Normal View - Text Area", "xpath", NORMAL_VIEW_TEXT_AREA);
	
	String ADD_MTB_SUBQUE = "//div[@title='Add'][contains(@onclick,'fnAddMTBQuestion')]";
	WebPageElements add_mtb_subque = new WebPageElements("Add MTB Question", "xpath", ADD_MTB_SUBQUE);
	
	String NUMBER_OF_DROP_DOWN = "//select[@id='DdlTotalControls_MD']";
	WebPageElements number_of_drop_down = new WebPageElements("Number of drop down", "xpath", NUMBER_OF_DROP_DOWN);
	
	String DEFAULT_ANS_OPTS_IN_GRID = "//input[starts-with(@value,'Choice')]";
	WebPageElements default_ans_opts_in_grid = new WebPageElements("Default Answer Options", "xpath", DEFAULT_ANS_OPTS_IN_GRID);
	
	String LOWEST_TEXT_FIELD = "//input[@id='txtGrid_0_Lowest']";
	WebPageElements lowest_text_field = new WebPageElements("Lowest Text Field", "xpath", LOWEST_TEXT_FIELD);
	
	String LOWEST_VALUE_FIELD = "//input[@id='ddlRSLow_0']";
	WebPageElements lowest_value_field = new WebPageElements("Lowest Field Value", "xpath", LOWEST_VALUE_FIELD);
	
	String LOWEST_VALUE_STEP_UP = "//input[@name='ddlRSLow_0']/following-sibling::div[@class='step-plus']";
	WebPageElements lowest_value_step_up = new WebPageElements("Lowest Field Step Up", "xpath", LOWEST_VALUE_STEP_UP);
	
	String LOWEST_VALUE_STEP_DOWN = "//input[@name='ddlRSLow_0']/following-sibling::div[@class='step-minus']";
	WebPageElements lowest_value_step_down = new WebPageElements("Lowest Field Step Down", "xpath", LOWEST_VALUE_STEP_DOWN);
	
	String MIDDLE_TEXT_FIELD = "//input[@id='txtGrid_0_Middle']";
	WebPageElements middle_text_field = new WebPageElements("Middle Text Field", "xpath", MIDDLE_TEXT_FIELD);
	
	String MIDDLE_VALUE_FIELD = "//input[@id='txtRSMid_0']";
	WebPageElements middle_value_field = new WebPageElements("Middle Field Value", "xpath", MIDDLE_VALUE_FIELD);
	
	String MIDDLE_VALUE_STEP_UP = "//input[@name='txtRSMid_0']/following-sibling::div[@class='step-plus customStep']";
	WebPageElements middle_value_step_up = new WebPageElements("Middle Field Step Up", "xpath", MIDDLE_VALUE_STEP_UP);
	
	String MIDDLE_VALUE_STEP_DOWN = "//input[@name='txtRSMid_0']/following-sibling::div[@class='step-minus customStep']";
	WebPageElements middle_value_step_down = new WebPageElements("Middle Field Step Down", "xpath", MIDDLE_VALUE_STEP_DOWN);
	
	String HIGHEST_TEXT_FIELD = "//input[@id='txtGrid_0_Highest']";
	WebPageElements highest_text_field = new WebPageElements("Highest Text Field", "xpath", HIGHEST_TEXT_FIELD);
	
	String HIGHEST_VALUE_FIELD = "//input[@id='ddlRSHigh_0']";
	WebPageElements highest_value_field = new WebPageElements("Highest Field Value", "xpath", HIGHEST_VALUE_FIELD);
	
	String HIGHEST_VALUE_STEP_UP = "//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-plus']";
	WebPageElements highest_value_step_up = new WebPageElements("Highest Field Step Up", "xpath", HIGHEST_VALUE_STEP_UP);
	
	String HIGHEST_VALUE_STEP_DOWN = "//input[@name='ddlRSHigh_0']/following-sibling::div[@class='step-minus']";
	WebPageElements highest_value_step_down = new WebPageElements("Highest Field Step Down", "xpath", HIGHEST_VALUE_STEP_DOWN);
	
	String NA_TEXT_FIELD = "//input[@name='txtNA_0']";
	WebPageElements na_text_field = new WebPageElements("N/A Text Field", "xpath", NA_TEXT_FIELD);
	
	String REARRANGE_ANS = "//div[text()='Rearrange Answers']";
	WebPageElements rearrange_ans = new WebPageElements("Rearrange Answers", "xpath", REARRANGE_ANS);
	
	String REARRANGE_ANS_TEXT = "//span[text()='Drag and drop answers to rearrange']";
	WebPageElements rearrange_ans_text = new WebPageElements("Drag and drop answers to rearrange", "xpath", REARRANGE_ANS_TEXT);
	
	String REARRANGE_ANS_MENU = "//div[@id='updatedRearrnge']";
	WebPageElements rearrange_ans_menu = new WebPageElements("Rearrange Answer Options", "xpath", REARRANGE_ANS_MENU);
	
	String ATOZ_SORT = "//a[@id='sortRearrangeA2ZLink']";
	WebPageElements atoz_sort = new WebPageElements("Sort By A to Z Link", "xpath", ATOZ_SORT);
	
	String ZTOA_SORT = "//a[@id='sortRearrangeZ2ALink']";
	WebPageElements ztoa_sort = new WebPageElements("Sort By Z to A Link", "xpath", ZTOA_SORT);
	
	String DONE_BTN = "//input[@id='btnSaveRearrange']";
	WebPageElements done_btn = new WebPageElements("Done", "xpath", DONE_BTN);
	
	String ANSWER_SEQ = "//*[@id='divAnsSequ']/div[1]";
	WebPageElements answer_seq = new WebPageElements("Answer Sequence", "xpath", ANSWER_SEQ);
	
	String ROTATE_LABEL = "//label[@for='rdAnsSeqRotate']";
	WebPageElements rotate_label = new WebPageElements("Rotate", "xpath", ROTATE_LABEL);
	
	String RANDOMIZE_LABEL = "//label[@for='rdAnsSeqRandomize']";
	WebPageElements randomize_label = new WebPageElements("Randomize", "xpath", RANDOMIZE_LABEL);
	
	String ADD_MORE = "//a[@id='addmore']";
	WebPageElements add_more = new WebPageElements("Add +10 Answer Option", "xpath", ADD_MORE);
	
	String ANS_LABEL0 = "//input[@id='txtNum0']";
	WebPageElements ans_label0 = new WebPageElements("Answe lable for 0th field", "xpath", ANS_LABEL0);
	
	String ANS_LABEL10 = "//input[@id='txtNum10']";
	WebPageElements ans_label10 = new WebPageElements("Answe lable for 10th field", "xpath", ANS_LABEL10);
	
	String TEXT_AND_TRANSLATION = "//div[@class='dvBulkTexEdit hd-btn hd-dd-btn fl bor-left-rad']";
	WebPageElements text_and_translation = new WebPageElements("Text and Translation", "xpath", TEXT_AND_TRANSLATION);
	
	String TEXT_AND_TRANSLATION_MENU = "//div[@class='bulk-lang-dropdown hd-dropdown-content hd-show-dd']";
	WebPageElements text_and_translation_menu = new WebPageElements("Text and Translation Menu", "xpath", TEXT_AND_TRANSLATION_MENU);
	
	String LANGUAGE_DROPDOWN = "//div[@id='ctl46_dvLangText']";
	WebPageElements language_dropdown = new WebPageElements("Language Drop Down", "xpath", LANGUAGE_DROPDOWN);
	
	String AUTO_TRANSLATE = "//input[@id='Button5']";
	WebPageElements auto_translate = new WebPageElements("Auto Translate", "xpath", AUTO_TRANSLATE);
	
	String ALL_TRANSLATE = "//a[@id='A1']";
	WebPageElements all_translate = new WebPageElements("All Questions and messages", "xpath", ALL_TRANSLATE);
	
	String SAVE_BTN = "//input[@id='btnSave']";
	WebPageElements save_btn = new WebPageElements("Save", "xpath", SAVE_BTN);
	
	String SAVE_BTN2 = "//input[@id='btnsave']";
	WebPageElements save_btn2 = new WebPageElements("Save", "xpath", SAVE_BTN2);
	
	String RESET_TRANSLATION = "//input[@id='btnDeleteSurvey']";
	WebPageElements reset_translation = new WebPageElements("Reset Translation", "xpath", RESET_TRANSLATION);
	
	String LOGIC = "//div[@id='ctl08_divLogic']";
	WebPageElements logic = new WebPageElements("Logic Button", "xpath", LOGIC);
	
	String QDL_OPTION = "//div[@id='ctl08_dvPageLevelQDL']";
	WebPageElements qdl_option = new WebPageElements("Question Display Logic", "xpath", QDL_OPTION);
	
	String IFRAME_QDL = "//iframe[contains(@src,'/SMConditionalDisplayLogic/ShowAll?')]";
	WebPageElements iframe_qdl = new WebPageElements("Question Display Logic Modal", "xpath", IFRAME_QDL);
	
	String SELECT_SHOWHIDE_QUESTION = "//select[@id='ddlShowHideQuestions']";
	WebPageElements select_showhide_question = new WebPageElements("Show-Hide Question Drop Down", "xpath", SELECT_SHOWHIDE_QUESTION);
	
	String SELECT_DECISION_QUESTION = "//select[@id='ddlDecisionQuestions']";
	WebPageElements select_decision_question = new WebPageElements("Decision Question Drop Down", "xpath", SELECT_DECISION_QUESTION);
	
	String SELECT_OPERATOR = "//select[@id='ddlOperator']";
	WebPageElements select_operator = new WebPageElements("Operator Drop Down", "xpath", SELECT_OPERATOR);
	
	String SAVE = "//input[@name='btnSave']";
	WebPageElements save = new WebPageElements("Save", "xpath", SAVE);
	
	String CLOSE = "//div[@id='dvwindow']/following-sibling::div";
	WebPageElements close = new WebPageElements("Close", "xpath", CLOSE);
	
	String ADD_MORE_QDL = "//div[text()='Add More']";
	WebPageElements add_more_qdl = new WebPageElements("Add More", "xpath", ADD_MORE_QDL);
	
	String SURVEY_OPTIONS = "//div[@id='ctl08_liSS']";
	WebPageElements survey_options = new WebPageElements("Options", "xpath", SURVEY_OPTIONS);
	
	String EXPIRY_RULES = "//div[@class='hd-dropdown-row'][contains(text(),'Expiry Rules')]";
	WebPageElements expiry_rules = new WebPageElements("Expiry Rules", "xpath", EXPIRY_RULES);
	
	String EXPIRY_RULES_TITLE = "//div[@class='survey-settings-title']/span[text()='Expiry Rules']";
	WebPageElements expiry_rules_title = new WebPageElements("Expiry Rules Title", "xpath", EXPIRY_RULES_TITLE);
	
	String VISUAL_SETTINGS = "//span[text()='Visual Settings']";
	WebPageElements visual_settings = new WebPageElements("Visual Settings", "xpath", VISUAL_SETTINGS);
	
	String DESKTOP_DEV = "//div[@id='dvweb']";
	WebPageElements desktop_dev = new WebPageElements("Visual Settings - Desktop Tab", "xpath", DESKTOP_DEV);
	
	String MOBILE_DEV = "//div[@id='dvmobile']";
	WebPageElements mobile_dev = new WebPageElements("Visual Settings - Mobile Tab", "xpath", MOBILE_DEV);
	
	String MOBILE_VIEW = "//div[@id='divmobilecont']";
	WebPageElements mobile_view = new WebPageElements("Visual Settings - Mobile Background Image", "xpath", MOBILE_VIEW);
	
	String ADD_LOGO = "//div[@id='divAddSurveyLogoLink1']//div[@ng-click='showAddSurveyLogoDiv(pg.Page_no);']";
	WebPageElements add_logo = new WebPageElements("add logo", "xpath", ADD_LOGO);
		
	String UPLOAD_FROM_COMPUTER = "//div[@id='divLogoFromComputer']//div[@class='icon']";
	WebPageElements upload_from_computer = new WebPageElements("upload logo from computer", "xpath", UPLOAD_FROM_COMPUTER);

	String USE_ACCOUNT_LOGO = "//div[@id='divCopyAccountImage']//div[@class='icon']";
	WebPageElements use_account_logo = new WebPageElements("use acount logo", "xpath", USE_ACCOUNT_LOGO);
	
	String COPY_FROM_OTHER_PROJECT = "//div[@id='divCopyFromOtherSurvey']//div[@class='icon']";
	WebPageElements copy_from_other_project = new WebPageElements("copy from another project", "xpath", COPY_FROM_OTHER_PROJECT);
	
	String INSERT_FROM_URL = "//div[@id='divFromWebLink']//div[@class='icon']";
	WebPageElements insert_from_url = new WebPageElements("logo insert using url", "xpath", INSERT_FROM_URL);

	String LOGO_URL_TEXTBOX = "//input[@id='txtLogoURL']";
	WebPageElements logo_url_textbox = new WebPageElements("textbox for  url", "xpath", LOGO_URL_TEXTBOX);
	
	String BTN_LOGO_URL = "//input[@id='btnLogoURL2']";
	WebPageElements btn_logo_url = new WebPageElements("continue ", "xpath", BTN_LOGO_URL);
	
	String SELECT_MAIN = "//ul[@class='sub']//li[1]//a[1]";	 
	WebPageElements select_main = new WebPageElements("selecting main in dropdown", "xpath", SELECT_MAIN);
	
	String CPY_FROM_ANOTHERSURVEY = "//div[@id='btnCopyFromOtherSruvey']";
	WebPageElements copy_from_anothersurvey = new WebPageElements("selecting main in dropdown", "xpath", CPY_FROM_ANOTHERSURVEY);
	
	String LOGO_DISPLAY = "//img[@id='imgSurveyLogo1']";
	WebPageElements logo_display = new WebPageElements("logo display", "xpath", LOGO_DISPLAY);
	
	String DELETE_LOGO_DISPLAY = "//div[@class='editimg delete']//img[@src='../AllImages/imagesnew/general/delete_reverse.svg']";
	WebPageElements delete_logo_display = new WebPageElements("delete logo display", "xpath", DELETE_LOGO_DISPLAY);
	
	String DELETE_ICON = "//span[@class='DelCon']";
	WebPageElements delete_icon = new WebPageElements("delete icon display", "xpath", DELETE_ICON);
	
	String ALIGN_ICON = "//div[@title='Align Logo']";
	WebPageElements align_icon = new WebPageElements("align icon", "xpath", ALIGN_ICON);

	String ALIGN_ICON1 = "//span[normalize-space()='Align']";
	WebPageElements align_icon1 = new WebPageElements("align icon", "xpath", ALIGN_ICON1);
	
	String ADD_HEADER = "//span[normalize-space()='Add Header']";
	WebPageElements add_header = new WebPageElements("add header", "xpath", ADD_HEADER);
	
	
	String ADD_FOOTER = "//span[normalize-space()='Add Footer']";
	WebPageElements add_footer = new WebPageElements("add header", "xpath", ADD_FOOTER);
	
	String SAVE_BUTTON_FOR_HEADER = "//div[@class='surveyHeaderFooterSaveStrip']//input[@ng-click='SaveSurveyHeader(pg.Page_no)']";
	WebPageElements save_button_for_header = new WebPageElements("save button for header", "xpath", SAVE_BUTTON_FOR_HEADER);
	
	

	String SAVE_BUTTON_FOR_FOOTER = "	//input[@ng-click='SaveSurveyFooter(pg.Page_no)']";
	WebPageElements save_button_for_footer = new WebPageElements("save_button_for_footer", "xpath", SAVE_BUTTON_FOR_FOOTER);
	
	String VISUAL_SETTINGS_CB = "//span[@class='cke_button_icon cke_button__checkbox1_icon']";
	WebPageElements visual_settings_cb = new WebPageElements("visual setting check box in add header", "xpath", VISUAL_SETTINGS_CB);

	
	
	String BOLD_BUTTON = "//span[@class='cke_button_icon cke_button__bold_icon']";
	WebPageElements bold_button = new WebPageElements("bold font style ", "xpath", BOLD_BUTTON);
	
	
	String ITALIC_BUTTON = "//span[@class='cke_button_icon cke_button__italic_icon']";
	WebPageElements italic_button = new WebPageElements("italic font style ", "xpath", ITALIC_BUTTON);
	
	
	String UNDERLINE_BUTTON = "//span[@class='cke_button_icon cke_button__underline_icon']";
	WebPageElements underline_button = new WebPageElements("underline font style ", "xpath", UNDERLINE_BUTTON);
	
	
	
	String REMOVE_FORMAT_BUTTON = "//span[@class='cke_button_icon cke_button__removeformat_icon']";
	WebPageElements remove_format_button = new WebPageElements("remove format ", "xpath", REMOVE_FORMAT_BUTTON);
	
	
	
	String SIZE_DROPDOWN = "//span[@class='cke_combo_text cke_combo_inlinelabel']";
	WebPageElements size_dropdown = new WebPageElements("size dropdown", "xpath", SIZE_DROPDOWN);
	
	
	String CENTRE_ALIGN = "//span[@class='cke_button_icon cke_button__justifycenter_icon']";
	WebPageElements centre_align = new WebPageElements("centre align ", "xpath", CENTRE_ALIGN);
	
	
	String RIGHT_ALIGN = "//span[@class='cke_button_icon cke_button__justifyright_icon']";
	WebPageElements right_align = new WebPageElements("right align ", "xpath", RIGHT_ALIGN);
	
	String LEFT_ALIGN = "//span[@class='cke_button_icon cke_button__justifyleft_icon']";
	WebPageElements left_align = new WebPageElements("left align ", "xpath", LEFT_ALIGN);
	
	
	String JUSTIFY_ALIGN = "//span[@class='cke_button_icon cke_button__justifyblock_icon']";
	WebPageElements justify_align = new WebPageElements("justify ", "xpath", JUSTIFY_ALIGN);
	
	
	String UNDO_ICON = "//span[@class='cke_button_icon cke_button__undo_icon']";
	WebPageElements undo_icon = new WebPageElements("undo ", "xpath", UNDO_ICON);
	
	String REDO_ICON = "//span[@class='cke_button_icon cke_button__redo_icon']";
	WebPageElements redo_icon = new WebPageElements("redo ", "xpath", REDO_ICON);
	
	
	String NUMBER_LIST_ICON = "//span[@class='cke_button_icon cke_button__numberedlist_icon']";
	WebPageElements number_list_icon = new WebPageElements("number_list_icon ", "xpath", NUMBER_LIST_ICON);
	
	
	String BULET_LIST_ICON = "//span[@class='cke_button_icon cke_button__bulletedlist_icon']";
	WebPageElements bullet_list_icon = new WebPageElements("bullet_list_icon ", "xpath", BULET_LIST_ICON);
	
	
	
	
	String DECREASE_INDENT_ICON = "//span[@class='cke_button_icon cke_button__outdent_icon']";
	WebPageElements decrease_indent_icon = new WebPageElements("decrease_indent_icon ", "xpath", DECREASE_INDENT_ICON);
	
	String INCCREASE_INDENT_ICON = "//span[@class='cke_button_icon cke_button__indent_icon']";
	WebPageElements increase_indent_icon = new WebPageElements("increase_indent_icon ", "xpath", INCCREASE_INDENT_ICON);
	

	
	String SOURCE_ICON = "//span[@class='cke_button_icon cke_button__source_icon']";
	WebPageElements source_icon = new WebPageElements("source_icon ", "xpath", SOURCE_ICON);
	
	
	String LINK_ICON = "//span[@class='cke_button_icon cke_button__link_icon']";
	WebPageElements link_icon = new WebPageElements("link_icon ", "xpath", LINK_ICON);
	
	

	String UNLINK_ICON = "//span[@class='cke_button_icon cke_button__unlink_icon']";
	WebPageElements unlink_icon = new WebPageElements("unlink_icon ", "xpath", UNLINK_ICON);
	
	
	String SPELL_CHECK = "//span[@class='cke_button_icon cke_button__spellchecker_icon']";
	WebPageElements spell_check = new WebPageElements("spell_check ", "xpath", SPELL_CHECK);
	
	
	String PASTE_FROM_WORD = "//span[@class='cke_button_icon cke_button__pastefromword_icon']";
	WebPageElements paste_from_word = new WebPageElements("paste_from_word ", "xpath", PASTE_FROM_WORD);
	
	String FONT_COLOUR_ICON = "//span[@class='cke_button_icon cke_button__textcolor_icon']";
	WebPageElements font_colour_icon = new WebPageElements("font_colour", "xpath", FONT_COLOUR_ICON);
	
	String FONT_SIZE_ICON = "//span[@class='cke_combo_text cke_combo_inlinelabel']";
	WebPageElements font_size_icon = new WebPageElements("font_size", "xpath", FONT_SIZE_ICON);
	
	
	String REPLACE_BUTTON = "//input[@id='ReplaceButton']";
	WebPageElements replace_button = new WebPageElements("replace_button", "xpath", REPLACE_BUTTON);
	
	String ALL_PROJECTS= "//span[contains (text(),'All Projects')]";
	WebPageElements all_projects = new WebPageElements("AllProjects", "xpath", ALL_PROJECTS);
	
	String HD_LOGO= "//div[@class='hd-main-DD']";
	WebPageElements hd_logo = new WebPageElements("New Hd Logo", "xpath", HD_LOGO);
	
	String ALL_PROJECTS1= "//div[@class='hd-main-DD-Options headerDashboard hd-sel-survey all-projects']";
	WebPageElements all_projects1 = new WebPageElements("AllProjects1", "xpath", ALL_PROJECTS1);
	
	String SEARCH_PROJECTS= "//input[@id='InSearchText']";
	WebPageElements search_projects = new WebPageElements("SearchProjects", "xpath", SEARCH_PROJECTS);
	
	String HOVER1 = "//div[contains(@title,'Do not touch - Merge DP1 FROM sogo_Asharma')]";
	WebPageElements hover1 = new WebPageElements("Hover1", "xpath", HOVER1 );
	
	String HOVER2 = "//div[contains(@title,'Do not touch - Merge DP2 FROM sogo_Asharma')]";
	WebPageElements hover2 = new WebPageElements("Hover2", "xpath", HOVER2 );
	
	String DD0 = "//ul[@id='common-menu1']//li//a[@class='fly']//span[contains(text(),'Merge DP')]";
	WebPageElements dd0 = new WebPageElements("DdO", "xpath", DD0 );
	
	String DD1 = "//ul[@id='common-menu3']//li//a[@class='fly']//span[contains(text(),'Merge DP')]";
	WebPageElements dd1 = new WebPageElements("Dd1", "xpath", DD1);
	
	String PUBLISH_PROJECT= "//div[@id='over-div-contents']//span[@class='survey-option-icon publish-opt-icon']";
	WebPageElements publish_project = new WebPageElements("PublishProject", "xpath", PUBLISH_PROJECT);
	
	String COPY_URL= "//div[@id='copyPublishUrl']";
	WebPageElements copy_url = new WebPageElements("CopyUrl", "xpath", COPY_URL);
	
	
	String S1Q1 = "//label[normalize-space()='Much less than others']";
	WebPageElements s1q1 = new WebPageElements("Survey1Q1", "xpath", S1Q1 );
	
	String S1Q2 = "//label[normalize-space()='Strongly Disagree']";
	WebPageElements s1q2 = new WebPageElements("Survey1Q2", "xpath", S1Q2 );
	
	String S1Q3 = "//option[@value='3']";
	WebPageElements s1q3 = new WebPageElements("Survey1Q3", "xpath", S1Q3 );
	
	String S1Q4 = "//label[normalize-space()='Never']";
	WebPageElements s1q4 = new WebPageElements("Survey1Q4", "xpath", S1Q4 );
	
	String S1Q5 = "//div[@class='slide ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']";
	WebPageElements s1q5 = new WebPageElements("Survey1Q5", "xpath", S1Q5 );
	
	String S2Q1 = "//label[normalize-space()='Much less than others']";
	WebPageElements s2q1 = new WebPageElements("Survey2Q1", "xpath", S2Q1 );
	
	String S2Q2 = "//label[normalize-space()='Strongly Disagree']";
	WebPageElements s2q2 = new WebPageElements("Survey2Q2", "xpath", S2Q2 );
	
	String S2Q3 = "//option[@value='3']";
	WebPageElements s2q3 = new WebPageElements("Survey2Q3", "xpath", S2Q3 );
	
	String S2Q4 = "//label[normalize-space()='Never']";
	WebPageElements s2q4 = new WebPageElements("Survey2Q4", "xpath", S2Q4 );
	
	String S2Q5 = "//span[@role='slider']";
	WebPageElements s2q5 = new WebPageElements("Survey2Q5", "xpath", S2Q5 );
	
	String NEXT = "//input[@id='BUTTON_NEXT']";
	WebPageElements next = new WebPageElements("SurveyParticipationNext", "xpath", NEXT );
	
	String SUBMIT = "//input[@id='BUTTON_SUBMIT']";
	WebPageElements submit = new WebPageElements("SurveyParticipationSubmit", "xpath", SUBMIT );
	
	String SUBMIT2 = "//span[contains (text(),'Submit')]";
	WebPageElements submit2 = new WebPageElements("SurveyParticipationSubmit2", "xpath", SUBMIT2 );
	
	String SUBMITENGAGE = "//span[contains(text(),'Plz Do Submit')]";
	WebPageElements submitengage = new WebPageElements("SurveyParticipationSubmiEngage", "xpath", SUBMITENGAGE );
	
	String SUBMITENGAGE2 = "//input[@id='BUTTON_SUBMIT']";
	WebPageElements submitengage2 = new WebPageElements("SurveyParticipationSubmitEngage2", "xpath", SUBMITENGAGE2 );
	
	String SUBMITZARCA = "//span[contains(text(),'Submit')]";
	WebPageElements submitzarca = new WebPageElements("SurveyParticipationSubmitZarca", "xpath", SUBMITZARCA );
	
	String SUBMITZARCA2 = "//input[@id='BUTTON_SUBMIT']";
	WebPageElements submitzarca2 = new WebPageElements("SurveyParticipationSubmitZarca2", "xpath", SUBMITZARCA2 );
	 
	String UTILITIES = "//a[@id='z_h_ctl00_aum']";
	WebPageElements utilities = new WebPageElements("Utilities", "xpath", UTILITIES );
	
	String MERGE_PROJECTS = "//a[@id='Inner_header1_ctl00_lnkUTLmerge']";
	WebPageElements merge_projects = new WebPageElements("Merge_Projects", "xpath", MERGE_PROJECTS );
	
	String CREATE_NEW_MERGE_PROJECTS = "//input[@id='btnCreateNewMerge']";
	WebPageElements create_new_merge_projects = new WebPageElements("Create_New_Merge_Projects", "xpath", CREATE_NEW_MERGE_PROJECTS );
	
	String CONTINUE1 = "//input[@name='btnNext1']";
	WebPageElements continue1 = new WebPageElements("Continue1", "xpath", CONTINUE1 );
	
	String SELECT_PROJECT1 = "//div[@id='dvSurvey1']//a[@class='top_link']";
	WebPageElements select_project1 = new WebPageElements("Select_Project1", "xpath", SELECT_PROJECT1 );	
	
	String  DO_NOT_TOUCH_MERGE_DP1_FROM_SOGO_ASHARMA = "//ul[@id='common-menu1']//li//a[contains(text(),'Do not touch - Merge DP1 FROM sogo_Asharma')]";
	WebPageElements do_not_touch_merge_dp1_from_sogo_asharma = new WebPageElements("Do_NOT_TOUCH_Merge_Dp1_From_Sogo_Asharma", "xpath", DO_NOT_TOUCH_MERGE_DP1_FROM_SOGO_ASHARMA );
	
	String SELECT_PROJECT2 = "//div[@id='dvSurvey3']//a[@class='top_link']";
	WebPageElements select_project2 = new WebPageElements("Select_Project2", "xpath", SELECT_PROJECT2 );
	
	String DO_NOT_TOUCH_MERGE_DP2_FROM_SOGO_ASHARMA = "//ul[@id='common-menu3']//li//a[contains(text(),'Do not touch - Merge DP2 FROM sogo_Asharma')]";
	WebPageElements do_not_touch_merge_dp2_from_sogo_asharma = new WebPageElements("Do_NOT_TOUCH_MERGE_DP2_FROM_SOGO_ASHARMA", "xpath", DO_NOT_TOUCH_MERGE_DP2_FROM_SOGO_ASHARMA );
	
	String CONTINUE2 = "//input[@id='btnNext2']";
	WebPageElements continue2 = new WebPageElements("Continue2", "xpath", CONTINUE2 );
	
	String SELECT_FOLDER_MERGE_DP = "//span[@class='folder-text ng-binding'][normalize-space()='Merge DP']";
	WebPageElements select_folder_merge_dp = new WebPageElements("Select_Folder_Merge_Dp", "xpath", SELECT_FOLDER_MERGE_DP );
	
	String IMPORT_RESPONSE = "//label[@for='rdImportNowYes']";
	WebPageElements import_response = new WebPageElements("Import_Response", "xpath", IMPORT_RESPONSE );
	
	String DONE = "//input[@id='btnDone']";
	WebPageElements done = new WebPageElements("Done", "xpath", DONE );
	
	String HOVER3 = "//div[@title='SID: 1334, new copy paste feature Anas']";
	WebPageElements hover3 = new WebPageElements("Hover3", "xpath", HOVER3 );
	
	String EDIT1 = "//div[@id='over-div-contents']//div[@id='OverDivEdit']";
	WebPageElements edit1 = new WebPageElements("Edit1", "xpath", EDIT1 );
	
	String CLICKHERE = "//div[@class='blank-page ui-sortable-handle']//a[contains(text(),'Click here')]";
	WebPageElements clickhere = new WebPageElements("Clickhere", "xpath", CLICKHERE );
	
	String QUESTIONTAGS = "//div[@class='fr copyPasteTextTab copyPasteTag']";
	WebPageElements questiontags = new WebPageElements("Questiontags", "xpath",QUESTIONTAGS  );
	
	String DT = "//div[@class='copyPasteTextQType']//span[contains(text(),' Descriptive Text ')]";
	WebPageElements dt = new WebPageElements("Dt", "xpath", DT );
	
	String TB = "//div[@class='copyPasteTextQType']//span[contains(text(),' Text Box ')]";
	WebPageElements tb = new WebPageElements("Tb", "xpath", TB );
	
	String RB = "//div[@class='copyPasteTextQType']//span[contains(text(),'Radio Button')]";
	WebPageElements rb = new WebPageElements("Rb", "xpath", RB );
	
	String CB = "//div[@class='copyPasteTextQType']//span[contains(text(),'Check Box')]";
	WebPageElements cb = new WebPageElements("Cb", "xpath", CB );
	
	String DD = "//div[@class='copyPasteTextQType']//span[contains(text(),'Dropdown')]";
	WebPageElements dd = new WebPageElements("Dd", "xpath", DD );
	
	String R = "//div[@class='copyPasteTextQType']//span[contains(text(),'Ranking')]";
	WebPageElements r = new WebPageElements("Ranking", "xpath", R );
	
	String DATE = "//div[@class='copyPasteTextQType']//span[contains(text(),'Date')]";
	WebPageElements date = new WebPageElements("Date", "xpath", DATE );
	
	String HR = "//div[@class='copyPasteTextQType']//span[contains(text(),'Horizontal Radio')]";
	WebPageElements hr = new WebPageElements("Hr", "xpath", HR );
	
	String PB = "//div[@class='copyPasteTextQType']//span[contains(text(),'Page Break')]";
	WebPageElements pb = new WebPageElements("Pb", "xpath", PB );
	
	String ADD_QUESTIONS = "//input[@id='btnSubmit']";
	WebPageElements add_questions = new WebPageElements("Add_QUESTIONS", "xpath", ADD_QUESTIONS );
	
	String HP = "//div[@id='MyHeader_ctl00_imglogo']";
	WebPageElements hp = new WebPageElements("Home_Page", "xpath", HP );
	
	String ENTER_TEXT = "//textarea[@id='txtCopyPaste']";
	WebPageElements enter_text = new WebPageElements("Enter_Text", "xpath", ENTER_TEXT );
	
	String IHAVEQUESTIONSREADYTOCOPYPASTE = "//label[@id='lblAlreadyQuestionsWritten']";
	WebPageElements ihavequestionsreadytocp = new WebPageElements("IHaveQuestionReadyToCopyPaste", "xpath", IHAVEQUESTIONSREADYTOCOPYPASTE );
	
	String SETTINGS_ICON = "//div[@id='ctl10_liSS']";
	WebPageElements settings_icon = new WebPageElements("settings icon", "xpath", SETTINGS_ICON);
	
	
	String SETTINGS_SAVE = "//input[@id='btnsave']";
	WebPageElements settings_save = new WebPageElements("settings save", "xpath", SETTINGS_SAVE);
	
	String FILE_LIBRARY = "//a[@id='z_h_ctl00_lnkUTLfile']";
	WebPageElements file_library = new WebPageElements("file library", "xpath", FILE_LIBRARY );
	
	String ADD_NEW_FILE = "//div[@id='div_BtnAddNew']";
	WebPageElements add_new_file = new WebPageElements("Add New File", "xpath", ADD_NEW_FILE );
	
	String BROWSE_BUTTON2 = "//input[@title='Add New']";
	WebPageElements browse_button2 = new WebPageElements("Browse Button2", "xpath", BROWSE_BUTTON2 );
	
	String HOVER_XLS = "//span[contains(text(),'sogo_data_import_file.xls')]";
	WebPageElements hover_xls = new WebPageElements("Hover_xls file", "xpath", HOVER_XLS );
	
	String HOVER_XLSX = "//span[contains(text(),'smsnumber.xlsx')]";
	WebPageElements hover_xlsx = new WebPageElements("Hover_xlsx file", "xpath", HOVER_XLSX );
	
	String HOVER_DOC = "//span[contains(text(),'docfile.doc')]";
	WebPageElements hover_doc = new WebPageElements("Hover_doc file", "xpath", HOVER_DOC );
	
	String HOVER_DOCX = "//span[contains(text(),'docxfile.docx')]";
	WebPageElements hover_docx = new WebPageElements("Hover_docx file", "xpath", HOVER_DOCX );
	
	String HOVER_PPT = "//span[contains(text(),'ppt.ppt')]";
	WebPageElements hover_ppt = new WebPageElements("Hover_ppt file", "xpath", HOVER_PPT );
	
	String HOVER_PPTX = "//span[contains(text(),'pptx.pptx')]";
	WebPageElements hover_pptx = new WebPageElements("Hover_pptx file", "xpath", HOVER_PPTX );
	
	String HOVER_PPS = "//span[contains(text(),'pps.pps')]";
	WebPageElements hover_pps = new WebPageElements("Hover_pps file", "xpath", HOVER_PPS );
	
	String HOVER_PDF = "//span[contains(text(),'pdf.pdf')]";
	WebPageElements hover_pdf = new WebPageElements("Hover_pdf file", "xpath", HOVER_PDF );
	
	String HOVER_TXT = "//span[contains(text(),'txt.txt')]";
	WebPageElements hover_txt = new WebPageElements("Hover_txt file", "xpath", HOVER_TXT );
	
	String HOVER_RTF = "//span[contains(text(),'rtf.rtf')]";
	WebPageElements hover_rtf = new WebPageElements("Hover_rtf file", "xpath", HOVER_RTF );
	
	String HOVER_XML = "//span[contains(text(),'xml.xml')]";
	WebPageElements hover_xml = new WebPageElements("Hover_xml file", "xpath", HOVER_XML );
	
	String HOVER_MPG = "//span[contains(text(),'mpg.mpg')]";
	WebPageElements hover_mpg = new WebPageElements("Hover_mpg file", "xpath", HOVER_MPG );
	
	String HOVER_SWF = "//span[contains(text(),'swf.swf')]";
	WebPageElements hover_swf = new WebPageElements("Hover_swf file", "xpath", HOVER_SWF );
	
	String HOVER_JPG = "//span[contains(text(),'jpg.jpg')]";
	WebPageElements hover_jpg = new WebPageElements("Hover_jpg file", "xpath", HOVER_JPG );
	
	String HOVER_JPEG = "//span[contains(text(),'jpeg.jpeg')]";
	WebPageElements hover_jpeg = new WebPageElements("Hover_jpeg file", "xpath", HOVER_JPEG );
	
	String HOVER_BMP = "//span[contains(text(),'bmp.bmp')]";
	WebPageElements hover_bmp = new WebPageElements("Hover_bmp file", "xpath", HOVER_BMP );
	
	String HOVER_GIF = "//span[contains(text(),'gif.gif')]";
	WebPageElements hover_gif = new WebPageElements("Hover_gif file", "xpath", HOVER_GIF );
	
	String HOVER_PNG = "//span[contains(text(),'png.png')]";
	WebPageElements hover_png = new WebPageElements("Hover_png file", "xpath", HOVER_PNG );
	
	String HOVER_HTM = "//span[contains(text(),'htm.htm')]";
	WebPageElements hover_htm = new WebPageElements("Hover_htm file", "xpath", HOVER_HTM );
	
	String HOVER_HTML = "//span[contains(text(),'html.html')]";
	WebPageElements hover_html = new WebPageElements("Hover_html file", "xpath", HOVER_HTML );
	
	String HOVER_XHTML = "//span[contains(text(),'xhtml.xhtml')]";
	WebPageElements hover_xhtml = new WebPageElements("Hover_xhtml file", "xpath", HOVER_XHTML );
	
	String HOVER_CSV = "//span[contains(text(),'csv.csv')]";
	WebPageElements hover_csv = new WebPageElements("Hover_csvg file", "xpath", HOVER_CSV );
	
	String HOVER_MP3 = "//span[contains(text(),'mp3.mp3')]";
	WebPageElements hover_mp3 = new WebPageElements("Hover_mp3 file", "xpath", HOVER_MP3 );
	
	String HOVER_MP4 = "//span[contains(text(),'mp4.mp4')]";
	WebPageElements hover_mp4 = new WebPageElements("Hover_mp4 file", "xpath", HOVER_MP4 );
	
	String COPY_URL1 = "//span[@title='Copy URL']";
	WebPageElements copy_url1 = new WebPageElements("Copy URL for file library", "xpath", COPY_URL1 );
	
	String CLICK_XLS_FILE = "//span[contains(text(),'sogo_data_import_file.xls')]";
	WebPageElements click_xls_file = new WebPageElements("click on the XLS File", "xpath", CLICK_XLS_FILE );
	
	String DELTE_FILE = "//input[@id='BtnDelete']";
	WebPageElements delete_file = new WebPageElements("Delete File", "xpath", DELTE_FILE );
}
