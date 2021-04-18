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
	
	String FREQUENCY = "//span[contains(text(),'Frequency')]";
	WebPageElements frequency = new WebPageElements("Frequency Drop-Down", "xpath", FREQUENCY );
	
	String FREQUENCY_MENU = "//div[@id='dvFrequency']";
	WebPageElements frequency_menu = new WebPageElements("Frequency Drop-Down Menu", "xpath", FREQUENCY_MENU );
	
	String BAR_GRAPH = "//li[@id='ddBarGraph']";
	WebPageElements bar_graph = new WebPageElements("Bar Graph", "xpath", BAR_GRAPH );
	
	String BAR_GRAPH_CHART_DROPDOWN = "//ul[@class='chart1']";
	WebPageElements bar_graph_chart_dropdown = new WebPageElements("Bar Graph - Chart Drop down", "xpath", BAR_GRAPH_CHART_DROPDOWN );
	
	String BAR_GRAPH_CHART_MENU = "//ul[@id='chart']";
	WebPageElements bar_graph_chart_menu = new WebPageElements("Bar Graph - Chart Menu", "xpath", BAR_GRAPH_CHART_MENU );
	
	String BAR_GRAPH_ADV_CHART_OPTION = "//a[text() = 'Advanced']";
	WebPageElements bar_graph_adv_chart_option = new WebPageElements("Bar Graph - Advance Chart Option", "xpath", BAR_GRAPH_ADV_CHART_OPTION );
	
	String BAR_GRAPH_ADV_CHART = "//div[starts-with(@id,'D')]";
	WebPageElements bar_graph_adv_chart = new WebPageElements("Bar Graph - Advance Chart", "xpath", BAR_GRAPH_ADV_CHART );
	
	String BAR_GRAPH_MAKE_ALL_CHART_SIMILAR = "//a[text() = 'Make all charts similar']";
	WebPageElements bar_graph_make_all_chart_similar = new WebPageElements("Bar Graph - Make All Chart Similar", "xpath", BAR_GRAPH_MAKE_ALL_CHART_SIMILAR );
	
	String REARRANGE_TOGGLE = "//div[@id='dvRearrangeToggle']";
	WebPageElements rearrange_toggle = new WebPageElements("Re-arrange Toggle", "xpath", REARRANGE_TOGGLE );
	
	String REORDER_PAGE_DESCRIPTION = "//span[contains(text(),'To rearrange, drag and drop the questions below into the desired order.')]";
	WebPageElements reorder_page_description = new WebPageElements("Re-order page description", "xpath", REORDER_PAGE_DESCRIPTION );
	
	String REPORT_WIZARD_STEP3_DESCR = "//span[@id='WizardControl1_lblStep3Note']/text()";
	WebPageElements report_wizard_step3_descr = new WebPageElements("Report Wizard Step 3 description", "xpath", REPORT_WIZARD_STEP3_DESCR );
	
	String REPORT_WIZARD_STEP4_DESCR = "//div[@class='pageDescription']/span";
	WebPageElements report_wizard_step4_descr = new WebPageElements("Report Wizard Step 4 description", "xpath", REPORT_WIZARD_STEP4_DESCR );
	
	
	String CONDITIONAL = "//li[@id='ddConditional']/a";
	WebPageElements conditional = new WebPageElements("Conditional", "xpath", CONDITIONAL );
	
	String CONDITIONAL_QUESTION_DROPDOWN = "//td[@id='cond_Qlist']";
	WebPageElements conditional_question_dropdown = new WebPageElements("Conditional Question Drop down", "xpath", CONDITIONAL_QUESTION_DROPDOWN );
	
	String SELECT_CONDITION_QUESTION = "//select[@id='cmbQuestions']";
	WebPageElements select_condition_question = new WebPageElements("Conditional - Select Question", "xpath", SELECT_CONDITION_QUESTION );
	
	String SELECT_CONDITION_OPERAND = "//select[@id='cmbCondition']";
	WebPageElements select_condition_operand = new WebPageElements("Conditional - Select Operand", "xpath", SELECT_CONDITION_OPERAND );
	
	String SELECT_CONDITION_ANSWERS = "//select[@id='cmbAnswer']";
	WebPageElements select_condition_answers = new WebPageElements("Conditional - Select Answers", "xpath", SELECT_CONDITION_ANSWERS );
	
	String CONDITIONAL_MATCH_EVRY_CONDITION = "//label[text()='Every condition']";
	WebPageElements conditional_match_every_condition = new WebPageElements("Match Every Condition", "xpath", CONDITIONAL_MATCH_EVRY_CONDITION );
	
	String CONDITIONAL_MATCH_ANY_CONDITION = "//label[text()='Any condition']";
	WebPageElements conditional_match_any_condition = new WebPageElements("Match Any Condition", "xpath", CONDITIONAL_MATCH_ANY_CONDITION );
	
	String CONDITIONAL_REPORT_STEP_1 = "//input[@id='btnstep3Next']";
	WebPageElements conditional_report_step_1 = new WebPageElements("Conditional - Step 1 Continue", "xpath", CONDITIONAL_REPORT_STEP_1 );
	
	String CONDITIONAL_REPORT_STEP_2 = "//input[@id='btnstep3Next'][contains(@onclick,'Step2Next')]";
	WebPageElements conditional_report_step_2 = new WebPageElements("Conditional - Step 2 Continue", "xpath", CONDITIONAL_REPORT_STEP_2 );
	
	String CONDITIONAL_REPORT_STEP_3 = "//input[@id='btnstep3Next'][contains(@onclick,'Step3Next')]";
	WebPageElements conditional_report_step_3 = new WebPageElements("Conditional - Step 3 Continue", "xpath", CONDITIONAL_REPORT_STEP_3 );
	
	String CONDITIONAL_GENERATE_BUTTON = "//input[@value='Generate']";
	WebPageElements conditional_generate_button = new WebPageElements("Conditional - Generate Button", "xpath", CONDITIONAL_GENERATE_BUTTON );
	
	String ADD_CONDITION = "//input[@id='btnAddCondition']";
	WebPageElements add_condition = new WebPageElements("Conditional - Add Condition Button", "xpath", ADD_CONDITION );

	String ADV_FREQ = "//a[@id='ddAdvBarGraph']";
	WebPageElements adv_freq = new WebPageElements("ADV frequency", "xpath", ADV_FREQ );
	
	String CROSS_DD = "//div[@id='btnPivot']//span[contains(text(),'Cross Tabulation')]";
	WebPageElements cross_dd = new WebPageElements("Cross Tabulation - Drop Down", "xpath", CROSS_DD );
	
	String CROSS_TAB_MENU = "//div[@id='dvPivotTable']";
	WebPageElements cross_tab_menu = new WebPageElements("Cross Tabulation - Menu", "xpath", CROSS_TAB_MENU );
	
	String CROSS_TAB = "//li[@id='ddCrossTab']";
	WebPageElements cross_tab = new WebPageElements("Cross Tab", "xpath", CROSS_TAB );
	
	String CROSS_TAB_2LVL = "//label[contains(text(),'Cross Tab - Two Level')]";
	WebPageElements cross_tab_2lvl = new WebPageElements("Cross Tab - 2 Level Button", "xpath", CROSS_TAB_2LVL);
	
	String CROSS_TAB_3LVL = "//label[contains(text(),'Cross Tab - Three Level')]";
	WebPageElements cross_tab_3lvl = new WebPageElements("Cross Tab - 3 Level Button", "xpath", CROSS_TAB_3LVL);
	
	String PIVOT_TABLE = "//label[contains(text(),'Pivot Table')]";
	WebPageElements pivot_table = new WebPageElements("Pivot Table Button", "xpath", PIVOT_TABLE);	
	
	String PIVOT_TABLE_QUESTIONS = "//div[@class='maindiv_pivot']";
	WebPageElements pivot_table_questions = new WebPageElements("Pivot Table - Question Table", "xpath", PIVOT_TABLE_QUESTIONS);
	
	String PIVOT_TABLE_QUESTION_ROW = "//div[@id='WizardControl1_dvBGQuestSel']/table/tbody/tr/td/label";
	WebPageElements pivot_table_questions_row = new WebPageElements("Pivot Table - Question Table Row", "xpath", PIVOT_TABLE_QUESTION_ROW);
	
	String SELECT_STUB = "//select[@id='H_Question']";
	WebPageElements select_stub = new WebPageElements("Select Stub - Question Drop Down", "xpath", SELECT_STUB);
	
	String SELECT_PIVOT_STUB = "//select[@id='ddlMainQuestionList']";
	WebPageElements select_pivot_stub = new WebPageElements("Select Stub - Question Drop Down of Pivot", "xpath", SELECT_PIVOT_STUB);
	
	String SELECT_BANNER = "//select[@id='V_Question']";
	WebPageElements select_banner = new WebPageElements("Select Banner - Question Drop Down", "xpath", SELECT_BANNER);
	
	String SELECT_PARENT = "//select[@id='P_Question']";
	WebPageElements select_parent = new WebPageElements("Select Parent - Question Drop Down", "xpath", SELECT_PARENT);
	
	String CROSS_TAB_STEP2_PAGE_DESCR = "//span[@id='lblStep2Note']";
	WebPageElements cross_tab_step2_page_descr = new WebPageElements("Cross Tab - Page 2 Description", "xpath", CROSS_TAB_STEP2_PAGE_DESCR);
	
	String ADV_PIV = "//a[@id='liadvPivot']";
	WebPageElements adv_piv = new WebPageElements("ADV PIV", "xpath", ADV_PIV );
	
//	String RAW_DATA = "//a[@id='btnIndividual']";
//	WebPageElements raw_data = new WebPageElements("Raw Data", "xpath", RAW_DATA );
	
	String INDIVIDUAL = "//a[@id='ddindividual']";
	WebPageElements individual = new WebPageElements("Individual", "xpath", INDIVIDUAL );
	
	String RESPONSE_TABLE = "//a[@id='btnResponseTable']";
	WebPageElements response_table = new WebPageElements("Rsponse Table", "xpath", RESPONSE_TABLE );
	
	String VERBATIM = "//li[@id='ddVerbatim']/a";
	WebPageElements verbatim = new WebPageElements("Verbatim Report", "xpath", VERBATIM );
	
	String VERBATIM_PAGE_1_DESCR = "//span[@id='SQlable']";
	WebPageElements verbatim_page_1_descr = new WebPageElements("Verbatim Report - Select Verbatim Question Page Description", "xpath", VERBATIM_PAGE_1_DESCR );
	
	String VERBATIM_PAGE_1_CONTINUE = "//input[@id='btnstep3Next'][contains(@onclick,'Step1Next')]";
	WebPageElements verbatim_page_1_continue = new WebPageElements("Verbatim Report - Select Verbatim Question Continue Button", "xpath", VERBATIM_PAGE_1_CONTINUE );
	
	String VERBATIM_PAGE_2_DESCR = "//div[@id='dvStepSecond']/div";
	WebPageElements verbatim_page_2_descr = new WebPageElements("Verbatim Report - Reorder Question Page Description", "xpath", VERBATIM_PAGE_2_DESCR );
	
	String VERBATIM_PAGE_2_CONTINUE = "//input[@id='btnstep3Next'][contains(@onclick,'genReport')]";
	WebPageElements verbatim_page_2_continue = new WebPageElements("Verbatim Report - Select Verbatim Question Continue Button", "xpath", VERBATIM_PAGE_2_CONTINUE );
	
	String VERBATIM_PAGE_3_DESCR = "//span[@id='SQlable']/text()";
	WebPageElements verbatim_page_3_descr = new WebPageElements("Verbatim Report - Select Report Properties Page Description", "xpath", VERBATIM_PAGE_3_DESCR );
	
	String VERBATIM_PAGE_3_CONTINUE = "//input[@id='btnstep3Next'][contains(@onclick,'SetReportProperities')]";
	WebPageElements verbatim_page_3_continue = new WebPageElements("Verbatim Report - Report Properties Continue Button", "xpath", VERBATIM_PAGE_3_CONTINUE );
	
	String VERBATIM_PAGE_4_DESCR = "//span[@id='SQlable']/text()";
	WebPageElements verbatim_page_4_descr = new WebPageElements("Verbatim Report - Filter Page Description", "xpath", VERBATIM_PAGE_4_DESCR );
	
	String VERBATIM_FILTER_TOGGLE = "//input[@id='rdbCYes']";
	WebPageElements verbatim_filter_toggle = new WebPageElements("Verbatim Report - Filter Toggle", "xpath", VERBATIM_FILTER_TOGGLE );
	
	String SELECT_VERBATIM_FILTER = "//select[@id='lstFilter']";
	WebPageElements select_verbatim_filter = new WebPageElements("Verbatim Report - Filter Drop Down", "xpath", SELECT_VERBATIM_FILTER );
	
	String VERBATIM_PAGE_4_CONTINUE = "//input[@id='btnstep3Next'][contains(@onclick,'setFilterVal')]";
	WebPageElements verbatim_page_4_continue = new WebPageElements("Verbatim Report - Filter Continue Button", "xpath", VERBATIM_PAGE_4_CONTINUE );
	
	String VERBATIM_GROUPING_TOGGLE = "//input[@id='rdbGYes']";
	WebPageElements verbatim_grouping_toggle = new WebPageElements("Verbatim Report - Grouping Question Toggle", "xpath", VERBATIM_GROUPING_TOGGLE );
	
	String SELECT_VERBATIM_GROUPING = "//select[@id='cmbGQuestions']";
	WebPageElements select_verbatim_grouping = new WebPageElements("Verbatim Report - Filter Drop Down", "xpath", SELECT_VERBATIM_GROUPING );
	
	String VERBATIM_PAGE_5_DESCR = "//span[@id='SQlable']/text()";
	WebPageElements verbatim_page_5_descr = new WebPageElements("Verbatim Report - Grouping Question Page Description", "xpath", VERBATIM_PAGE_5_DESCR );
	
	String ASSESSMENT_SUMMARY = "//li[@id='btnScoreSummary']/a";
	WebPageElements assessment_summary = new WebPageElements("Verbatim Report - Grouping Question Page Description", "xpath", ASSESSMENT_SUMMARY );
	
	String ASSESSMENT_SUMMARY_PAGE_1_DESCR = "//span[contains(text(),'Select the questions you would like to display in your report.')]";
	WebPageElements assessment_summary_page_1_descr = new WebPageElements("Verbatim Report - Grouping Question Page Description", "xpath", ASSESSMENT_SUMMARY_PAGE_1_DESCR );
	
	
	
	String ATTACHMENT_REPORT = "//a[@id='btnAttachmentReport']";
	WebPageElements attachment_report = new WebPageElements("Attachment Report", "xpath", ATTACHMENT_REPORT );

	String SEGMENTATION = "//a[@id='ddegmentation']";
	WebPageElements segmentation = new WebPageElements("SEGMENTATION", "xpath", SEGMENTATION );

	String SPECIAL_REPORTS = "//div[@id='btnSpecial']/span[text()='Special Reports']";
	WebPageElements special_reports = new WebPageElements("Special Reports", "xpath", SPECIAL_REPORTS );
	
	String SPECIAL_REPORTS_MENU = "//div[@id='dvsliceDice']/ul";
	WebPageElements special_reports_menu = new WebPageElements("Special Reports - Menu", "xpath", SPECIAL_REPORTS_MENU );
	
	String ENGAGEMENT = "//li[@id='btnEnagagementReport']";
	WebPageElements engagement = new WebPageElements("Engagement", "xpath", ENGAGEMENT );
	
	String ENGAGEMENT_WIZARD_STEP1_PAGE_DESCR = "//div[@class='pageDescription']/span[text()='Select Report Type from the drop down menu.']";
	WebPageElements engagement_wizard_step1_page_descr = new WebPageElements("Engagement - Step 1 Page Description", "xpath", ENGAGEMENT_WIZARD_STEP1_PAGE_DESCR );
	
	
	
	
	String DIMENSIONAL_ANALYSIS = "//a[@id='btnClimateReport']";
	WebPageElements dimensional_analysis = new WebPageElements("Dimensional Analysis", "xpath", DIMENSIONAL_ANALYSIS );
	
	String LEGACY_REPORTS = "//div[@id='btnLegacy']/span";
	WebPageElements legacy_reports  = new WebPageElements("Legacy Reports", "xpath", LEGACY_REPORTS );
	
	String LEGACY_REPORTS_MENU = "//div[@id='dvLegacy']/ul";
	WebPageElements legacy_reports_menu  = new WebPageElements("Legacy Reports - Menu", "xpath", LEGACY_REPORTS_MENU );
	
	String FREQUENCY_TABLE = "//li[@id='ddfrequencyTable']/a";
	WebPageElements frequency_table = new WebPageElements("Frequency Table", "xpath", FREQUENCY_TABLE );
	
	String COMPARISON = "//a[@id='ddComparison']";
	WebPageElements comparison = new WebPageElements("comparison", "xpath", COMPARISON );
	
	String  STATISTICAL= "//li[@id='btnAdvStatistic']/a";
	WebPageElements statistical  = new WebPageElements("Statistical", "xpath", STATISTICAL );
	
	String  STATISTICAL_PAGE_1_DESCR= "//span[contains(text(),'Select the questions you would like to display in your report.')]";
	WebPageElements statistical_page_1_descr  = new WebPageElements("Statistical Report - Select Survey Question Page Description", "xpath", STATISTICAL_PAGE_1_DESCR );
	
	String STATISTICAL_PAGE_1_CONTINUE = "//input[@id='btnStep1Next'][contains(@onclick,'Step1Next')]";
	WebPageElements statistical_page_1_continue = new WebPageElements("Statistical Report - Survey Question Continue Button", "xpath", STATISTICAL_PAGE_1_CONTINUE );
	
	String  STATISTICAL_PAGE_2_DESCR= "//span[contains(text(),'To rearrange, drag and drop the questions below into the desired order.')]";
	WebPageElements statistical_page_2_descr  = new WebPageElements("Statistical Report - Reorder Question Page Description", "xpath", STATISTICAL_PAGE_2_DESCR );
	
	String STATISTICAL_PAGE_2_CONTINUE = "//input[@id='btnStep2Next']";
	WebPageElements statistical_page_2_continue = new WebPageElements("Statistical Report - Reorder Question Page Continue Button", "xpath", STATISTICAL_PAGE_2_CONTINUE );
	
	String  STATISTICAL_PAGE_3_DESCR= "//span[contains(text(),'Choose statistical parameters.')]";
	WebPageElements statistical_page_3_descr  = new WebPageElements("Statistical Report - Select Parameter Page Description", "xpath", STATISTICAL_PAGE_3_DESCR );
	
	String STATISTICAL_PAGE_3_CONTINUE = "//input[@id='btnStep3Next']";
	WebPageElements statistical_page_3_continue = new WebPageElements("Statistical Report - Parameter Page Continue Button", "xpath", STATISTICAL_PAGE_3_CONTINUE );
	
	String  STATISTICAL_PAGE_4_DESCR= "(//span[contains(text(),'Segment Selection')])[1]";
	WebPageElements statistical_page_4_descr  = new WebPageElements("Statistical Report - Select Segment Page Description", "xpath", STATISTICAL_PAGE_4_DESCR );
	
	String  STATISTICAL_SEGMENT_BASED_ON_ONE_QUESTION= "//label[contains(text(),'Segment based on answers to only ONE question in survey')]";
	WebPageElements statistical_based_on_one_question  = new WebPageElements("Statistical Report - Select Segment Based on One question", "xpath", STATISTICAL_SEGMENT_BASED_ON_ONE_QUESTION );
	
	String SELECT_STATISTICAL_SEGMENT_QUESTION= "//select[@id='cmbOnesegQue']";
	WebPageElements select_statistical_segment_question  = new WebPageElements("Statistical Report - Select Segment Based on One question Drop down", "xpath", SELECT_STATISTICAL_SEGMENT_QUESTION );
	
	String  STATISTICAL_SEGMENT_ANS_OPTIONS= "//div[@id='dvOnesegOption']";
	WebPageElements statistical_segment_ans_options  = new WebPageElements("Statistical Report - Segment Answer Options", "xpath", STATISTICAL_SEGMENT_ANS_OPTIONS );
	
	String  STATISTICAL_SEGMENT_BASED_ON_MORE_THAN_ONE_QUESTION= "//label[contains(text(),'Segment based on answers to more than one question in survey')]";
	WebPageElements statistical_based_on_more_than_one_question  = new WebPageElements("Statistical Report - Select Segment Based on More than One question", "xpath", STATISTICAL_SEGMENT_BASED_ON_MORE_THAN_ONE_QUESTION );
	
	String  STATISTICAL_SEGMENT_1_DROP_DOWN= "//a[contains(@class,'QuestionDDtop_link')]";
	WebPageElements statistical_segment_1_drop_down  = new WebPageElements("Statistical Report - Segment 1 Drop Down", "xpath", STATISTICAL_SEGMENT_1_DROP_DOWN );
	
	String  SELECT_SEGMENT_1_OPERAND= "//select[@id='cmbCondition1']";
	WebPageElements select_segment_1_operand  = new WebPageElements("Statistical Report - Segment 1 Operand Drop Down", "xpath", SELECT_SEGMENT_1_OPERAND );
	
	String  SELECT_SEGMENT_1_ANSWER= "//select[@id='cmbAnswer1']";
	WebPageElements select_segment_1_answer  = new WebPageElements("Statistical Report - Segment 1 Answer Drop Down", "xpath", SELECT_SEGMENT_1_ANSWER );
	
	String  STATISTICAL_ADD_CONDITION_1= "//input[@id='btnAddCondition1']";
	WebPageElements statistical_add_condition_1  = new WebPageElements("Statistical Report - Add Condition 1 Button", "xpath", STATISTICAL_ADD_CONDITION_1 );
	
	
	String STATISTICAL_GENERATE_BUTTON = "//input[@value='Generate']";
	WebPageElements statistical_generate_button = new WebPageElements("Generate Now", "xpath", STATISTICAL_GENERATE_BUTTON);
	
	String STATISTICAL_GENERATE_NOW_BUTTON = "//input[@value='Generate Now']";
	WebPageElements statistical_generate_now_button = new WebPageElements("Generate Now", "xpath", STATISTICAL_GENERATE_NOW_BUTTON);
	
	String STATISTICAL_HEADER = "//div[contains(text(),'Statistical Report')]";
	WebPageElements statistical_trend_header = new WebPageElements("Statistical Header", "xpath", STATISTICAL_HEADER );
	
	String STATISTICAL_REPORT_DOWNLOAD = "//a[@title='Download']";
	WebPageElements statistical_report_download = new WebPageElements("Statistical Report - Download Button", "xpath", STATISTICAL_REPORT_DOWNLOAD );
	
	String STATISTICAL_DOWNLOAD_WORD = "//li[contains(@id,'tdWord1')]";
	WebPageElements statistical_download_word = new WebPageElements("Statistical Report - Download Button", "xpath", STATISTICAL_DOWNLOAD_WORD );
	
	
	String RESPONSE_RATE  = "//a[@id='btnParticipationRate']";
	WebPageElements response_rate = new WebPageElements("Response Rate", "xpath", RESPONSE_RATE );
	
	String RESPONSE_TREND = "//li[@id='btnResponseTrend']/a";
	WebPageElements response_trend = new WebPageElements("Response Trend", "xpath", RESPONSE_TREND );
	
	String RESPONSE_TREND_HEADER = "//div[contains(text(),'Response Trend Report')]";
	WebPageElements response_trend_header = new WebPageElements("Response Trend Header", "xpath", RESPONSE_TREND_HEADER );
	
	
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

	
	String RAW_DATA = "//div[@id='btnIndividual']/span";
	WebPageElements raw_data = new WebPageElements("Raw Data", "xpath", RAW_DATA);
	
	String RAW_DATA_MENU = "//div[@id ='dvIndiviual']/ul";
	WebPageElements raw_data_menu = new WebPageElements("Raw Data Menu", "xpath", RAW_DATA_MENU);
	
	String INDIVIDUAL_REPORT = "//li[@id='ddindividual']";
	WebPageElements individual_report = new WebPageElements("Individual Report", "xpath", INDIVIDUAL_REPORT);
	
	String WIZARD_PAGE_DESCRIPTION = "//div[contains(@class,'pageDescription')]/span";
	WebPageElements wizard_page_description = new WebPageElements("Wizard Page Description", "xpath", WIZARD_PAGE_DESCRIPTION);
	
	String ALL_QUESTIONS = "(//label[text()='All Questions'])[1]";
	WebPageElements all_questions = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS);
	
	String WIZARD_STEP1_CONTINUE = "//input[@id='btnstep1Next']";
	WebPageElements wizard_step1_continue = new WebPageElements("Report Wizard - Step 1 Continue", "xpath", WIZARD_STEP1_CONTINUE);
	
	String WIZARD_STEP2_CONTINUE = "//input[@id='btnStep2Next']";
	WebPageElements wizard_step2_continue = new WebPageElements("Report Wizard - Step 2 Continue", "xpath", WIZARD_STEP2_CONTINUE);
	
	//Use this step 2 btn for Frequency table report, Cross tab report
	String WIZARD_STEP2_CONTINUE_2 = "//input[@id='btnstep2Next']";
	WebPageElements wizard_step2_continue_2 = new WebPageElements("Report Wizard - Step 2 Continue", "xpath", WIZARD_STEP2_CONTINUE_2);
	
	String WIZARD_STEP3_CONTINUE = "//input[@id='btnstep3Next']";
	WebPageElements wizard_step3_continue = new WebPageElements("Report Wizard - Step 3 Continue", "xpath", WIZARD_STEP3_CONTINUE);
	
	String GENERATE_NOW_BUTTON = "//input[@id='btnstep4Next']";
	WebPageElements generate_now_button = new WebPageElements("Generate Now", "xpath", GENERATE_NOW_BUTTON);
	
	//Use this generate btn for Frequency table report, Cross tab report, Verbatim Report
	String GENERATE_NOW_BUTTON_2 = "//input[@value='Generate']";
	WebPageElements generate_now_button_2 = new WebPageElements("Generate Now", "xpath", GENERATE_NOW_BUTTON_2);
	
	String SURVEY_METRIC = "//div[@id='dvSurveyMetrics']";
	WebPageElements survey_metric = new WebPageElements("Survey Metric", "xpath", SURVEY_METRIC);
	
	String INDIVIDUAL_REPORT_ANSWER_FIELD = "//div[@class='spananswer']";
	WebPageElements individual_report_answer_field = new WebPageElements("Individual Report - Answer field", "xpath", INDIVIDUAL_REPORT_ANSWER_FIELD);
	
	String INDIVIDUAL_REPORT_EMAILID_FIELD = "//div[@class='tindDatatd']/span/b";
	WebPageElements individual_report_emailid_field = new WebPageElements("Individual Report - Email ID field", "xpath", INDIVIDUAL_REPORT_EMAILID_FIELD);
	
	String INDIVIDUAL_REPORT_RESPONSE_NUMBER_FIELD = "//div[@class='tindDatatd']/b/span";
	WebPageElements individual_report_response_number_field = new WebPageElements("Individual Report - Response Number field", "xpath", INDIVIDUAL_REPORT_RESPONSE_NUMBER_FIELD);
	
	String INDIVIDUAL_REPORT_PARTICIPATION_TIME = "//div[@class='tindDatatd']/b";
	WebPageElements individual_report_participation_time = new WebPageElements("Individual Report - Participation Time", "xpath", INDIVIDUAL_REPORT_PARTICIPATION_TIME);
	
	String SELECT_PAGE_DROP_DOWN = "//select[@id='cmbPageSel']";
	WebPageElements select_page_drop_down = new WebPageElements("Individual Report - Select Page", "xpath", SELECT_PAGE_DROP_DOWN);
	
	String INDIVIDUAL_REPORT_NEXT_BUTTON = "//input[@name='ImgBtnNextRec']";
	WebPageElements individual_report_next_button = new WebPageElements("Individual Report - Next Button", "xpath", INDIVIDUAL_REPORT_NEXT_BUTTON);
	
	String INDIVIDUAL_REPORT_PREVIOUS_BUTTON = "//input[@name='ImgBtnPrevRec']";
	WebPageElements individual_report_previous_button = new WebPageElements("Individual Report - Previous Button", "xpath", INDIVIDUAL_REPORT_PREVIOUS_BUTTON);
	
	String RESPONSE_TABLE_REPORT = "//li[@id='btnResponseTable']";
	WebPageElements response_table_report = new WebPageElements("Response Table Report", "xpath", RESPONSE_TABLE_REPORT);
	
	String RESPONSE_TB_SELECT_RESPONSE_DD = "//select[@id='cmbResponse']";
	WebPageElements response_table_select_response_dd = new WebPageElements("Response Table Report - Select Page", "xpath", RESPONSE_TB_SELECT_RESPONSE_DD);
	
	String RESPONSE_TB_ANSWER_FIELD = "//td[@class='responsetd']";
	WebPageElements response_table_answer_field = new WebPageElements("Response Table Report - Answer field", "xpath", RESPONSE_TB_ANSWER_FIELD);

}
