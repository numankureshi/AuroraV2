package property;

import utility.WebPageElements;

public interface IRMXPage {
	
	String REPORT_TAB = "//a[@id='Inner_header1_ctl00_arm']";
	WebPageElements report_tab = new WebPageElements("Report Tab", "xpath", REPORT_TAB);
	
	String OMNI_REPORT = "//div[@id='btnOmniReport']/span";
	WebPageElements omni_report = new WebPageElements("OMNI Report Button", "xpath", OMNI_REPORT);
	
	String OMNI_MODIFY_REPORT = "//span[contains(text(),'Modify Report')]";
	WebPageElements omni_modify_report = new WebPageElements("Modify Report - OMNI", "xpath", OMNI_MODIFY_REPORT);
	
	String TEXT_ANALYSIS = "//a[@id='btnSentimentAnalysis']";
	WebPageElements text_analysis = new WebPageElements("Text Analysis", "xpath", TEXT_ANALYSIS);
	
	String FREQ_DD = "//a[@class='hd-btn hd-dd-btn mar-l fl bor-left-rad bor-right-rad  hd-active']";
	WebPageElements freq_dd = new WebPageElements("Frequency DD", "xpath", FREQ_DD );
	
	String BAR_GRAPH = "//a[@id='ddBarGraph']";
	WebPageElements bar_graph = new WebPageElements("Bar Graph", "xpath", BAR_GRAPH );
	
	String CONDITIONAL = "//a[@id='ddBarGraph']";
	WebPageElements conditional = new WebPageElements("Conditional", "xpath", CONDITIONAL );

	String ADV_FREQ = "//a[@id='ddAdvBarGraph']";
	WebPageElements adv_freq = new WebPageElements("ADV frequency", "xpath", ADV_FREQ );
	
	String CROSS_DD = "//a[@id='btnPivot']";
	WebPageElements cross_dd = new WebPageElements("Cross DD", "xpath", CROSS_DD );

	String CROSS_TAB = "//a[@id='ddCrossTab']";
	WebPageElements cross_tab = new WebPageElements("Cross Tab", "xpath", CROSS_TAB );
	
	String ADV_PIV = "//a[@id='liadvPivot']";
	WebPageElements adv_piv = new WebPageElements("ADV PIV", "xpath", ADV_PIV );
	
	String RAW_DATA = "//a[@id='btnIndividual']";
	WebPageElements raw_data = new WebPageElements("Raw Data", "xpath", RAW_DATA );
	
	String INDIVIDUAL = "//a[@id='ddindividual']";
	WebPageElements individual = new WebPageElements("Individual", "xpath", INDIVIDUAL );
	
	String RESPONSE_TABLE = "//a[@id='btnResponseTable']";
	WebPageElements response_table = new WebPageElements("Rsponse Table", "xpath", RESPONSE_TABLE );
	
	String VERBATIM = "//a[@id='ddVerbatim']";
	WebPageElements verbatim = new WebPageElements("Verbatim", "xpath", VERBATIM );
	
	String ATTACHMENT_REPORT = "//a[@id='btnAttachmentReport']";
	WebPageElements attachment_report = new WebPageElements("Attachment Report", "xpath", ATTACHMENT_REPORT );

	String SEGMENTATION = "//a[@id='ddegmentation']";
	WebPageElements segmentation = new WebPageElements("SEGMENTATION", "xpath", SEGMENTATION );

	String SPECIAL_REPORTS = "//a[@id='btnSpecial']";
	WebPageElements special_reports = new WebPageElements("Special Reports", "xpath", SPECIAL_REPORTS );
	
	String ENGAGEMENT = "//a[@id='btnEnagagementReport']";
	WebPageElements engagement = new WebPageElements("ENGAGEMENT", "xpath", ENGAGEMENT );
	
	String DIMENSIONAL_ANALYSIS = "//a[@id='btnClimateReport']";
	WebPageElements dimensional_analysis = new WebPageElements("Dimensional Analysis", "xpath", DIMENSIONAL_ANALYSIS );
	
	String LEGACY_REPORTS = "//a[@id='btnLegacy']";
	WebPageElements legacy_reports  = new WebPageElements("Legacy Reports", "xpath", LEGACY_REPORTS );
	
	String FREQUENCY_TABLE = "//a[@class='ddfrequencyTable']";
	WebPageElements frequency_table = new WebPageElements("Frequency Table", "xpath", FREQUENCY_TABLE );
	
	String COMPARISON = "//a[@id='ddComparison']";
	WebPageElements comparison = new WebPageElements("comparison", "xpath", COMPARISON );
	
	String  STATISTICAL= "//a[@id='btnAdvStatistic']";
	WebPageElements statistical  = new WebPageElements("statistical", "xpath", STATISTICAL );
	
	String RESPONSE_RATE  = "//a[@id='btnParticipationRate']";
	WebPageElements response_rate = new WebPageElements("Response Rate", "xpath", RESPONSE_RATE );
	
	String RESPONSE_TREND = "//a[@id='btnResponseTrend']";
	WebPageElements response_trend = new WebPageElements("Response Rate", "xpath", RESPONSE_TREND );
	
	String BALLOT_BOX = "//a[@id='btnBallotBoxReport']";
	WebPageElements ballot_box = new WebPageElements("Ballot box", "xpath", BALLOT_BOX );
	
	String SHARE_VIA_EMAIL = "//a[@id='ReportDetails_sharelnk']";
	WebPageElements share_via_email = new WebPageElements("Share Email", "xpath", SHARE_VIA_EMAIL );

	String FILTER = "//a[@id='ReportDetails_filterlnk']";
	WebPageElements filter = new WebPageElements("filter", "xpath", FILTER );
	
	String PRINT_REPORT = "//a[@id='ReportDetails_printlnk']";
	WebPageElements print_report = new WebPageElements("Print Report", "xpath", PRINT_REPORT );
	
	String SAVE_REPORT = "//a[@id='ReportDetails_savelnk']";
	WebPageElements save_report = new WebPageElements("Save Report", "xpath", SAVE_REPORT );

	String DOWNLOAD_REPORT = "//a[@id='ReportDetails_downloadLnk']";
	WebPageElements download_report = new WebPageElements("Download Report", "xpath", DOWNLOAD_REPORT );

	String NEXT_MAIL = "//input[@id='StepNext']";
	WebPageElements next_mail = new WebPageElements("Next Mail", "xpath", NEXT_MAIL ); 
	
	String SELECT_ALLCB = "//input[@name='WizardControl1$chkMain']";
	WebPageElements select_allcb = new WebPageElements("Select ALLCB", "xpath", SELECT_ALLCB );
	
	String NEXT1 = "//input[@id='btnstep1Next']";
	WebPageElements next1 = new WebPageElements("Next step 1", "xpath", NEXT1 );
	
	String NEXT3 = "//input[@id='btnstep3Next']";
	WebPageElements next3 = new WebPageElements("Next step 3", "xpath", NEXT3 );
	
	String NEXT4 = "//input[@id='btnstep4Next']";
	WebPageElements next4 = new WebPageElements("Next step 4", "xpath", NEXT4 );

	String REPORTS_DD = "//input[@id='hd-group fr hd-relative-group']";
	WebPageElements reports_dd = new WebPageElements("Reports DD", "xpath", REPORTS_DD );
	
	String ALL_REPORTS = "//input[@id='hd-merged-btn fr']";
	WebPageElements all_reports = new WebPageElements("ALL REPORTS", "xpath", ALL_REPORTS );
	
	String SAVED_REPORTS = "//input[@id='dvSavedReportTab']";
	WebPageElements saved_reports = new WebPageElements("Saved Reports", "xpath", SAVED_REPORTS );
	
	String EMAIL_REPORTS = "//input[@id='dvEmailReportTab']";
	WebPageElements email_reports = new WebPageElements("Email Reports", "xpath", EMAIL_REPORTS );
	
	String FILTER_MANAGER = "//input[@id='dvFilterManagerTab']";
	WebPageElements filter_manager = new WebPageElements("FIlter Manager", "xpath", FILTER_MANAGER );

	String FROM_A_LIST = "//input[@name='-Select Project-']";
	WebPageElements from_a_list = new WebPageElements("From A List", "xpath", FROM_A_LIST);
	
	String GENERATE_REPORT = "//input[@id='btnGenerate']";
	WebPageElements generate_report = new WebPageElements("Report Generated", "xpath", GENERATE_REPORT);

	String DAR_1DD = "(//div[@id='divCYearP'])";
	WebPageElements dar_1dd = new WebPageElements("DAR DD1", "xpath", DAR_1DD);
	
	String DAR_2DD = "//div[@id='divLYearP']";
	WebPageElements dar_2dd = new WebPageElements("DAR DD2", "xpath", DAR_2DD);
	
	String SELECT_FOLDER1_DD = "(//span[text()='Dar'])[1]";
	WebPageElements select_folder1_dd = new WebPageElements("Folder DD", "xpath", SELECT_FOLDER1_DD);
	
	String SELECT_FOLDER2_DD = "(//span[text()='Dar'])[2]";
	WebPageElements select_folder2_dd = new WebPageElements("Folder DD2", "xpath", SELECT_FOLDER2_DD);
	
	String SELECT_PROJECT_1_DD = "(//a[text()='Dimensional Report 1'])[1]";
	WebPageElements select_project_1_dd = new WebPageElements("Project dd", "xpath", SELECT_PROJECT_1_DD);
	
	String SELECT_PROJECT2_DD = "(//a[text()='Dimensional Report 2'])[2]";
	WebPageElements select_project2_dd = new WebPageElements("Project dd2", "xpath", SELECT_PROJECT2_DD);
	
	String ADD_PARENT1 = "//div[@class='Open']/ancestor::div[@class='ClimateScore_1_1002']";
	WebPageElements add_parent1 = new WebPageElements("Parent 1", "xpath", ADD_PARENT1);
	
	String ADD_PARENT2 = "//div[@class='Open']/ancestor::div[@class='ClimateScore_1_14']";
	WebPageElements add_parent2 = new WebPageElements("Parent 2", "xpath", ADD_PARENT2);
	
	String ADD_PARENT3 = "//div[@class='Open']/ancestor::div[@class='ClimateScore_1_22']";
	WebPageElements add_parent3 = new WebPageElements("Parent 3", "xpath", ADD_PARENT3);
	
	String ADD_PARENT4 = "//div[@class='Open']/ancestor::div[@class='ClimateScore_1_1001']";
	WebPageElements add_parent4 = new WebPageElements("Parent 4", "xpath", ADD_PARENT4);
	
	String ADD_PARENT5 = "//div[@class='Open']/ancestor::div[@class='ClimateScore_1_21']";
	WebPageElements add_parent5 = new WebPageElements("Parent 5", "xpath", ADD_PARENT5);
	
	String ADD_PARENT6 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_1003'])";
	WebPageElements add_parent6 = new WebPageElements("Parent 6", "xpath", ADD_PARENT6);
	
	String ADD_PARENT7 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_1004'])";
	WebPageElements add_parent7 = new WebPageElements("Parent 7", "xpath", ADD_PARENT7);
	
	String ADD_PARENT8 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_1'])";
	WebPageElements add_parent8 = new WebPageElements("Parent 8", "xpath", ADD_PARENT8);
	
	String ADD_PARENT9 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_2'])";
	WebPageElements add_parent9 = new WebPageElements("Parent 9", "xpath", ADD_PARENT9);
	
	String ADD_PARENT10 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_4'])";
	WebPageElements add_parent10 = new WebPageElements("Parent 10", "xpath", ADD_PARENT10);
	
	String ADD_PARENT11 = "(//div[@class='Open']/ancestor::div[@class='ClimateScore_1_5'])";
	WebPageElements add_parent11 = new WebPageElements("Parent 11", "xpath", ADD_PARENT11);
	
	String ADD_STAR1 = "(//div[@id='star_0_0_1_1002')";
	WebPageElements add_star1 = new WebPageElements("Star 1", "xpath", ADD_STAR1);
	
	String ADD_STAR2 = "(//div[@id='star_0_0_1_14')";
	WebPageElements add_star2 = new WebPageElements("Star 2", "xpath", ADD_STAR2);
	
	String ADD_STAR3 = "(//div[@id='star_0_0_1_22')";
	WebPageElements add_star3 = new WebPageElements("Star 3", "xpath", ADD_STAR3);
	
	String ADD_STAR4 = "(//div[@id='star_0_0_1_1001')";
	WebPageElements add_star4 = new WebPageElements("Star 4", "xpath", ADD_STAR4);
	
	String ADD_STAR5 = "(//div[@id='star_0_0_1_21')";
	WebPageElements add_star5 = new WebPageElements("Star 5", "xpath", ADD_STAR5);
	
	String ADD_STAR6 = "(//div[@id='star_0_0_1_1003')";
	WebPageElements add_star6 = new WebPageElements("Star 6", "xpath", ADD_STAR6);
	
	String ADD_STAR7 = "(//div[@id='star_0_0_1_1004')";
	WebPageElements add_star7 = new WebPageElements("Star 7", "xpath", ADD_STAR7);
	
	String ADD_STAR8 = "(//div[@id='star_0_0_1_1')";
	WebPageElements add_star8 = new WebPageElements("Star 8", "xpath", ADD_STAR8);
	
	String ADD_STAR9 = "(//div[@id='star_0_0_1_2')";
	WebPageElements add_star9 = new WebPageElements("Star 9", "xpath", ADD_STAR9);
	
	String ADD_STAR10 = "(//div[@id='star_0_0_1_4')";
	WebPageElements add_star10 = new WebPageElements("Star 10", "xpath", ADD_STAR10);
	
	String ADD_STAR11 = "(//div[@id='star_0_0_1_5')";
	WebPageElements add_star11 = new WebPageElements("Star 11", "xpath", ADD_STAR11);
	
	String REPORT_CANVAS = "(//div[@id='tabCanvas'])";
	WebPageElements report_canvas = new WebPageElements("Report Canvas", "xpath", REPORT_CANVAS);
	
	String CANVAS_TITLE = "(//input[@id='txtRtitle')";
	WebPageElements canvas_title = new WebPageElements("Canvas Title", "xpath", CANVAS_TITLE);
	
	String CANVAS_DESCRIPTION = "(//input[@id='txtDescription')";
	WebPageElements canvas_description = new WebPageElements("Canvas Description", "xpath", CANVAS_DESCRIPTION);

	String SEGMENT = "(//div[@id='dvOpenModal')";
	WebPageElements segment = new WebPageElements("Seegment", "xpath", SEGMENT);
	
	String SEGMENT_SURVEYDD = "(//option[text()='Dimensional Report 1']/ancestor::select[@id='SurveyListddl'])";
	WebPageElements segment_surveydd = new WebPageElements("Segment Survey DD", "xpath", SEGMENT_SURVEYDD);

	String SEGMENT_QUESTIONDD = "(//option[text()='Q 5. Drop down']/ancestor::select[@id='ddlSiteQuestions'])";
	WebPageElements segment_questiondd = new WebPageElements("Segment Survey DD", "xpath", SEGMENT_QUESTIONDD);

	String SEGMENT_ANSWERCB = "(//input[@id='chkall'])";
	WebPageElements segment_answercb = new WebPageElements("Segment answer check box", "xpath", SEGMENT_ANSWERCB);
	
	String EMAIL_REPORT = "(//input[@name='ctl04'])";
	WebPageElements email_report = new WebPageElements("Email Report", "xpath", EMAIL_REPORT);

	

} 

