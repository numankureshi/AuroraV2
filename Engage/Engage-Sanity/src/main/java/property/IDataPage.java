package property;

import utility.WebPageElements;

public interface IDataPage {
	
	String DATA_MODULE = "//a[text()='Data']";
	WebPageElements data_module = new WebPageElements("Data Module", "xpath", DATA_MODULE);
	
	String IMPORT_MODULE = "//div[@id='MyHeader_ctl00_dvImport']";
	WebPageElements import_module = new WebPageElements("Import data module", "xpath", IMPORT_MODULE);
	
	String IMPORT_FILE = "//input[@name='File1']";
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
	
	
	
	
	

}
