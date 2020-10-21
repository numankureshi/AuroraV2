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
	
	String CHECK_BOX_BUTTON = "//div[contains(text(),'Check Box')]/parent::div[@id='dvmscb']";
	WebPageElements check_box_button = new WebPageElements("Check Box Button", "xpath", CHECK_BOX_BUTTON);
	
	String DROP_DOWN_BUTTON = "//div[contains(text(),'Drop Down')]/parent::div[@id='dvdd']";
	WebPageElements drop_down_button = new WebPageElements("Drop Down Button", "xpath", DROP_DOWN_BUTTON);
	
	String RATING_SCALE_BUTTON = "//div[contains(text(),'Drop Down')]/parent::div[@id='dvdd']";
	WebPageElements rating_scale_button = new WebPageElements("Rating Scale Button", "xpath", RATING_SCALE_BUTTON);
	
	String LIKE_DISLIKE_BUTTON = "//div[contains(text(),'Like/Dislike')]/parent::div[@id='dvLikeDislike']";
	WebPageElements like_dislike_button = new WebPageElements("Like/Dislike Button", "xpath", LIKE_DISLIKE_BUTTON);
	
	String DATE_BUTTON = "//div[contains(text(),'Date')]/parent::div[@id='dvdate']";
	WebPageElements date_button = new WebPageElements("Date Button", "xpath", DATE_BUTTON);
	
	String IMAGE_CHOICE_BUTTON = "//div[contains(text(),'Image Choice')]/parent::div[@id='dvIMC']";
	WebPageElements image_choice_button = new WebPageElements("Image Choice Button", "xpath", IMAGE_CHOICE_BUTTON);
	
	String RANKING_QUESTION_BUTTON = "//div[contains(text(),'Ranking')]/parent::div[@id='dvrk']";
	WebPageElements ranking_question_button = new WebPageElements("Ranking Button", "xpath", RANKING_QUESTION_BUTTON);
	
	String MULTIPLE_TEXTBOX_BUTTON = "//div[contains(text(),'Multiple Text Box')]/parent::div[@id='dvmtb']";
	WebPageElements multiple_textbox_button = new WebPageElements("Multiple Textbox Button", "xpath", MULTIPLE_TEXTBOX_BUTTON);
	
	String MULTIPLE_DROPDOWN_BUTTON = "//div[contains(text(),'Multiple Drop Down')]/parent::div[@id='dvmdd']";
	WebPageElements multiple_dropdown_button = new WebPageElements("Multiple DropDown Button", "xpath", MULTIPLE_DROPDOWN_BUTTON);
	
	String MULTIPLE_RADIO_BUTTON = "//div[contains(text(),'Radio Grid')]/parent::div[@id='dvrg']";
	WebPageElements multiple_radio_button = new WebPageElements("Multiple Radio Grid Button", "xpath", MULTIPLE_RADIO_BUTTON);
	
	String MULTIPLE_CHECKBOX_BUTTON = "//div[contains(text(),'Check Box Grid')]/parent::div[@id='dvcbg']";
	WebPageElements multiple_checkbox_button = new WebPageElements("Multiple Check Box Button", "xpath", MULTIPLE_CHECKBOX_BUTTON);
	
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
	
	String IFRAME_ANSWER_OPTIONS2 = "//iframe[contains(@src,'PresetList_Grid.aspx?GridType')]";
	WebPageElements iframe_answer_options2 = new WebPageElements("Iframe Answer Options", "xpath", IFRAME_ANSWER_OPTIONS2);
	 
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
	
	String GET_ANSWER_OPTIONS_LIBRARY = "//a[text()='Get Answer Options from Answer Library']";
	WebPageElements get_answer_options_library = new WebPageElements("Get Answer Options from Answer Library Button", "xpath", GET_ANSWER_OPTIONS_LIBRARY);
	
	String ANWERS_LIBRARY_LABEL = "//div[text()='Answer Library']";
	WebPageElements ansers_liburary_label = new WebPageElements("Ansers Library Button", "xpath", ANWERS_LIBRARY_LABEL);
	
	String USE_THIS_LIST_BUTTON = "//input[@id='btnusethislist']";
	WebPageElements use_this_list_button = new WebPageElements("Use this list Button", "xpath", USE_THIS_LIST_BUTTON);
	
	String OTHER_CHCKBOX = "//input[@id='CHK_Other_CheckBox']/following-sibling::label[text()='Include \"Other\" text responses']";
	WebPageElements other_checkbox = new WebPageElements("Other checkbox", "xpath", OTHER_CHCKBOX);
	
	String NONE_OF_ABOVE = "//label[text()='Include \"None of the above\" ']";
	WebPageElements none_of_above = new WebPageElements("None of Above", "xpath", NONE_OF_ABOVE);
	
	String ADD_IMAGE_ICON = "(//div[@id='dvAddImgs'])[1]";
	WebPageElements add_image_icon = new WebPageElements("Add Image", "xpath", ADD_IMAGE_ICON);
	
	String ADD_IMAGE_ICON2 = "//div[@class='add_dv']/div[contains(@class,'addbtn')][1]";
	WebPageElements add_image_icon2 = new WebPageElements("Add Image", "xpath", ADD_IMAGE_ICON2);
	

	
	String BROWSE_BUTTON = "//input[@class='button_upload']";
	WebPageElements browse_button = new WebPageElements("Browse Button", "xpath", BROWSE_BUTTON);
	
	String REPORTING_VALUE = "//input[@name='txtRepVal']";
	WebPageElements reporting_value = new WebPageElements("Reporting Value", "xpath", REPORTING_VALUE);
	
}
