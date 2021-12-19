package property;

import utility.WebPageElements;

public interface IDataPage {
	
	String DATA_MODULE = "//a[text()='Data']";
	WebPageElements data_module = new WebPageElements("Data Module", "xpath", DATA_MODULE);
	
	String IMPORT_MODULE = "//div[@id='MyHeader_ctl00_dvImport']";
	WebPageElements import_module = new WebPageElements("Import data module", "xpath", IMPORT_MODULE);
	
	String IMPORT_FILE = "//input[@name='MyFile']";
	WebPageElements import_file = new WebPageElements("Import File", "xpath", IMPORT_FILE);
	
	String IMPORT_DATA = "//input[@name='btnImport']";
	WebPageElements import_data = new WebPageElements("Import Data Button", "xpath", IMPORT_DATA);
	
	String IMPORT_CONTINUE = "//input[@name='btnContinue']";
	WebPageElements import_continue = new WebPageElements("Import Data Button", "xpath", IMPORT_CONTINUE);
	
	String IMPORT_LOADRESPONSES = "//input[@name='btnMoreResponses']";
	WebPageElements import_loadresponses = new WebPageElements("Import Data Button", "xpath", IMPORT_LOADRESPONSES);
	
	String IMPORT_MAP = "//input[@name='btnUpload']";
	WebPageElements import_map = new WebPageElements("Map Columns", "xpath", IMPORT_MAP);
	
	String EXPORT_EXCEL = "//div[@id='dvExcel']";
	WebPageElements export_excel = new WebPageElements("Export in Excel", "xpath", EXPORT_EXCEL);
	
	String EXPORT_CSV = "//div[@id='dvCsv']";
	WebPageElements export_csv = new WebPageElements("Export in CSV", "xpath", EXPORT_CSV);
	
	String EXPORT_XML = "//div[@id='dvXml']";
	WebPageElements export_xml = new WebPageElements("Export in XML", "xpath", EXPORT_XML);
	
	String EXPORT_SPSS = "//div[@id='dvSpss']";
	WebPageElements export_spss = new WebPageElements("Export in SPSS", "xpath", EXPORT_SPSS);
	
	String EXPORT_ACCESS = "//div[@id='dvAccess']";
	WebPageElements export_access = new WebPageElements("Export in Access", "xpath", EXPORT_ACCESS);
	
	String EXPORT_WORD = "//div[@id='dvWord']";
	WebPageElements export_word = new WebPageElements("Export in Word", "xpath", EXPORT_WORD);
	
	String EXPORT_HTML = "//div[@id='dvHtml']";
	WebPageElements export_html = new WebPageElements("Export in HTML", "xpath", EXPORT_HTML);
	
	String EXPORT_SOGOSURVEY = "//div[@id='dvProductFormat']";
	WebPageElements export_sogosurvey = new WebPageElements("Export in Sogosurvey", "xpath", EXPORT_SOGOSURVEY);
	
	String EXPORT_CONTINUE = "(//input[@value='Continue'])[2]";
	WebPageElements export_continue = new WebPageElements("Export Continue Button", "xpath", EXPORT_CONTINUE);
	
	String EXPORT_RESPONSES = "//input[@name='btnExportNow']";
	WebPageElements export_responses = new WebPageElements("Export Responses Button", "xpath", EXPORT_RESPONSES);
	
	String EXPORT_NOW = "//input[@value='Export Now']";
	WebPageElements export_now = new WebPageElements("Export Now Button", "xpath", EXPORT_NOW);
	
	String SELECT_CONTINUE1 = "//input[@name='Wizard1$StartNavigationTemplateContainerID$btnContinue']";
	WebPageElements select_continue1 = new WebPageElements("Export Continue1 Button", "xpath", SELECT_CONTINUE1);
	
	String SELECT_CONTINUE2 = "//input[@name='Wizard1$StepNavigationTemplateContainerID$btnContinue']";
	WebPageElements selectex_continue2 = new WebPageElements("Export Continue2 Button", "xpath", SELECT_CONTINUE2);
	
	String SELECT_EXPORT = "//input[@name='Wizard1$FinishNavigationTemplateContainerID$btnExport']";
	WebPageElements select_export = new WebPageElements("Export  Button", "xpath", SELECT_EXPORT);
	
	String EXPORT_PREPARE = "//input[@value='Continue'][contains(@id,'btnPrepareDataSubmit')]";
	WebPageElements export_prepare = new WebPageElements("Continue", "xpath", EXPORT_PREPARE);
	
	String EXPORT_PREPARE_NOTE = "//div[contains(text(),'Preparing Data for Export')]";
	WebPageElements export_prepare_note = new WebPageElements("Export Data Prepare Note", "xpath", EXPORT_PREPARE_NOTE);
	
	String SELECT_ALL_QUESTIONS = "//label[text()='All Questions']";
	WebPageElements select_all_questions = new WebPageElements("Select All - Check box", "xpath", SELECT_ALL_QUESTIONS);
	
	String CONTINUEBTN = "//input[@id='btnContinue'][@class='next']";
	WebPageElements continuebtn = new WebPageElements("Continue Button", "xpath", CONTINUEBTN);
	
	String RESPONDENT_ATTR = "//a[text()='Respondent Attributes']";
	WebPageElements respondent_attr = new WebPageElements("Respondent Attributes", "xpath", RESPONDENT_ATTR);
	
	String TOGGLE_RESP_IP = "//div[@id='dvSwitchRbtIp']";
	WebPageElements toggle_resp_ip = new WebPageElements("Respondent IP - Toggle", "xpath", TOGGLE_RESP_IP);
	
	String TOGGLE_RESP_EMAIL = "//div[@id='dvSwitchRbtEmail']";
	WebPageElements toggle_resp_email = new WebPageElements("Respondent Email - Toggle", "xpath", TOGGLE_RESP_EMAIL);
	
	String TOGGLE_BROWSER_TYPE = "//div[@id='dvSwitchRbtBrowser']";
	WebPageElements toggle_browser_type = new WebPageElements("Browser Type - Toggle", "xpath", TOGGLE_BROWSER_TYPE);
	
	String TOGGLE_OS = "//div[@id='dvSwitchRbtOS']";
	WebPageElements toggle_os = new WebPageElements("OS - Toggle", "xpath", TOGGLE_OS);
	
	String TOGGLE_SCREEN_RES = "//div[@id='dvSwitchRbtsResolurion']";
	WebPageElements toggle_screen_res = new WebPageElements("Screen Resolution - Toggle", "xpath", TOGGLE_SCREEN_RES);
	
	String TOGGLE_RES_SENT = "//div[@id='dvSwitchRbtsendResponse']";
	WebPageElements toggle_res_sent = new WebPageElements("Response Start and End Time - Toggle", "xpath", TOGGLE_RES_SENT);
	
	String TOGGLE_LANG = "//input[@id='LangYes']";
	WebPageElements toggle_lang = new WebPageElements("Participation Language - Toggle", "xpath", TOGGLE_LANG);
	
	String TOGGLE_CONDITION = "//div[@id='dvSwitchrbtCode']";
	WebPageElements toggle_condition = new WebPageElements("Condition - Toggle", "xpath", TOGGLE_CONDITION);
	
	String SELECT_QUE_DD = "//select[@id='cmbQuestions']";
	WebPageElements select_que_dd = new WebPageElements("Filter Question drop down", "xpath", SELECT_QUE_DD);
	
	String SELECT_CONDITION_DD = "//select[@id='cmbCondition']";
	WebPageElements select_condition_dd = new WebPageElements("Condition drop down", "xpath", SELECT_CONDITION_DD);
	
	String ANS_TEXT = "//input[@id='txtAnswer']";
	WebPageElements ans_text = new WebPageElements("Answer TB", "xpath", ANS_TEXT);
	
	String ADD_CONDITION = "//input[@id='btnAddCondition']";
	WebPageElements add_condition = new WebPageElements("Add Condition", "xpath", ADD_CONDITION);
	
	String TOGGLE_RESP_PERIOD = "//div[@id='dvSwitchrbtCode1']";
	WebPageElements toggle_resp_period = new WebPageElements("Response Period - Toggle", "xpath", TOGGLE_RESP_PERIOD);
	
	String SELECT_RESP_PERIOD_DD = "//select[@id='ddlResponsePeriod']";
	WebPageElements select_resp_period_dd = new WebPageElements("Response Period drop down", "xpath", SELECT_RESP_PERIOD_DD);
	
	String CAL_FROM_DATE = "//input[@id='txtDate2']";
	WebPageElements cal_from_date = new WebPageElements("Calender From Date", "xpath", CAL_FROM_DATE);
	
	String SELECT_YEAR = "//select[@data-handler='selectYear']";
	WebPageElements select_year = new WebPageElements("Year Drop Down", "xpath", SELECT_YEAR);
	
	String SELECT_MONTH = "//select[@data-handler='selectMonth']";
	WebPageElements select_month = new WebPageElements("Month Drop Down", "xpath", SELECT_MONTH);
	
	String CAL_TO_DATE = "//input[@id='txtDate3']";
	WebPageElements cal_to_date = new WebPageElements("Calender To Date", "xpath", CAL_TO_DATE);
	
	String TOGGLE_ASSIGN_CODE = "//div[@id='divAssignCodeSw']";
	WebPageElements toggle_assign_code = new WebPageElements("Assign Code - Toggle", "xpath", TOGGLE_ASSIGN_CODE);
	
	String SELECT_RANGE = "//select[@id='ddcount']";
	WebPageElements select_range = new WebPageElements("Range Drop down", "xpath", SELECT_RANGE);
	
	String EXPORT = "//input[@id='btnExport']";
	WebPageElements export = new WebPageElements("Export", "xpath", EXPORT);
	
	String SPSS_ASSIGN_CODE_NOTE = "//ul[@id='ulNoteSPSS']";
	WebPageElements spss_assign_code_note = new WebPageElements("SPSS Assigned Code Note", "xpath", SPSS_ASSIGN_CODE_NOTE);
	
}
