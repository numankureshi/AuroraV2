package property;

import utility.WebPageElements;

public interface ISMxPage {
	
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
	
	String SAVE_BUTTON = "//input[@id='btnSaveQuestionAnswer']";
	WebPageElements save_button = new WebPageElements("Save question Button", "xpath", SAVE_BUTTON);
	
	String PAGE_NUMBER_DROP_DOWN = "//div[@id='divPageNo']";
	WebPageElements page_number_drop_down = new WebPageElements("Page Number Drop Down", "xpath", PAGE_NUMBER_DROP_DOWN);
	
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
