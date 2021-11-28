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

	String ADV_FREQ = "//li[@id='ddAdvBarGraph']/a";
	WebPageElements adv_freq = new WebPageElements("ADV frequency", "xpath", ADV_FREQ );
	
	String ADV_FREQ_REORDER_DESCR = "//span[text()='Indicate the order of questions (you can drag and drop a question to another location). ']";
	WebPageElements adv_freq_reorder_descr = new WebPageElements("Adv Freq Reorder Description", "xpath", ADV_FREQ_REORDER_DESCR );
	
	String PECENTAGE_SETTING = "//span[text()='Percentage Setting']";
	WebPageElements percentage_setting = new WebPageElements("Percentage Setting", "xpath", PECENTAGE_SETTING );
	
	String DATA_SOURCES = "//span[text()='Data Sources']";
	WebPageElements data_sources = new WebPageElements("Data Sources", "xpath", DATA_SOURCES );
	
	String ADV_FREQ_TITLE = "//div[text()='Advanced Frequency Report']";
	WebPageElements adv_freq_title = new WebPageElements("Advanced Frequency Report - Title", "xpath", ADV_FREQ_TITLE );
	
	String CROSS_DD = "//div[@id='btnPivot']//span[contains(text(),'Cross Tabulation')]";
	WebPageElements cross_dd = new WebPageElements("Cross Tabulation - Drop Down", "xpath", CROSS_DD );
	
	String CROSS_TABULATION = "//div[@id='btnPivot1']/span";
	WebPageElements cross_tabulation = new WebPageElements("Cross Tabulation", "xpath", CROSS_TABULATION );
	
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
	
	String ADV_PIV = "//li[@id='liadvPivot']/a";
	WebPageElements adv_piv = new WebPageElements("Advance Pivot Report", "xpath", ADV_PIV );
	
	String ADV_PIVOT_PAGE_1_DESCR = "//div[@class='pageDescription']/span[contains(text(),'Select Segmentation Question')]";
	WebPageElements adv_pivot_page_1_descr = new WebPageElements("Advance Pivot Report - Select Segment Question Page Description", "xpath", ADV_PIVOT_PAGE_1_DESCR );
	
	String ADV_PIVOT_PAGE_1_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepOneNext')]";
	WebPageElements adv_pivot_page_1_continue = new WebPageElements("Advance Pivot Report - Select Segment Question Page Continue Button", "xpath", ADV_PIVOT_PAGE_1_CONTINUE );
	
	String ADV_PIVOT_PAGE_2_DESCR = "//div[@class='pageDescription']/span[contains(text(),'Select the questions you would like to display in your report.')]";
	WebPageElements adv_pivot_page_2_descr = new WebPageElements("Advance Pivot Report - Select All Question Page Description", "xpath", ADV_PIVOT_PAGE_2_DESCR );
	
	String ADV_PIVOT_PAGE_2_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepTwoNext')]";
	WebPageElements adv_pivot_page_2_continue = new WebPageElements("Advance Pivot Report - Select All Question Page Continue Button", "xpath", ADV_PIVOT_PAGE_2_CONTINUE );
	
	String ADV_PIVOT_PAGE_3_DESCR = "//div[@class='pageDescription']/span[contains(text(),'Merge answer options')]";
	WebPageElements adv_pivot_page_3_descr = new WebPageElements("Advance Pivot Report - Merge answer options Page Description", "xpath", ADV_PIVOT_PAGE_3_DESCR );
	
	String ADV_PIVOT_PAGE_3_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepThreeNext')]";
	WebPageElements adv_pivot_page_3_continue = new WebPageElements("Advance Pivot Report - Merge answer options Page Continue Button", "xpath", ADV_PIVOT_PAGE_3_CONTINUE );
	
	String ADV_PIVOT_PAGE_4_DESCR = "//span[contains(text(),'Please note that some properties can still be modified once the report is generated.')]";
	WebPageElements adv_pivot_page_4_descr = new WebPageElements("Advance Pivot Report - Report Properties Page Description", "xpath", ADV_PIVOT_PAGE_4_DESCR );
	
	String ADV_PIVOT_PAGE_4_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepFourNext')]";
	WebPageElements adv_pivot_page_4_continue = new WebPageElements("Advance Pivot Report - Report Properties Page Continue Button", "xpath", ADV_PIVOT_PAGE_4_CONTINUE );
	
	String ADV_PIVOT_PAGE_5_DESCR = "//span[contains(text(),'Select your desired filters.')]";
	WebPageElements adv_pivot_page_5_descr = new WebPageElements("Advance Pivot Report - Filter Page Description", "xpath", ADV_PIVOT_PAGE_5_DESCR );
	
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
	
	String SOGO_ENGAGEMENT_WIZARD_STEP1_PAGE_DESCR = "//div[@class='pageDescription']/span[text()='Define participation details.']";
	WebPageElements sogo_engagement_wizard_step1_page_descr = new WebPageElements("Engagement - Step 1 Page Description", "xpath", SOGO_ENGAGEMENT_WIZARD_STEP1_PAGE_DESCR );
	
	String ENGAGEMENT_ADDITIONAL_QUESTION = "//div[contains(text(),'Do you want to include additional questions?')]";
	WebPageElements engagement_additional_question = new WebPageElements("Engagement - Additional Question Description", "xpath", ENGAGEMENT_ADDITIONAL_QUESTION );
	
	String ENGAGEMENT_COMPOSITION_QUESTION = "//div[contains(text(),'Do you want a report by individual composition?')]";
	WebPageElements engagement_composition_question = new WebPageElements("Engagement - Composition Question Description", "xpath", ENGAGEMENT_COMPOSITION_QUESTION );
	
	String SOGO_ENGAGEMENT_COMPOSITION_QUESTION = "//div[contains(text(),'Do you want to review engagement results broken down by specific groups?')]";
	WebPageElements sogo_engagement_composition_question = new WebPageElements("Engagement - Composition Question Description", "xpath", SOGO_ENGAGEMENT_COMPOSITION_QUESTION );
	
	String ENGAGEMENT_SEGMENT_QUESTION = "//div[contains(text(),'Do you want a segmentation report for each department?')]";
	WebPageElements engagement_segment_question = new WebPageElements("Engagement - Segment Question Description", "xpath", ENGAGEMENT_SEGMENT_QUESTION );
	
	String SOGO_ENGAGEMENT_SEGMENT_QUESTION = "//div[contains(text(),'Do you want to generate group-specific reports?')]";
	WebPageElements sogo_engagement_segment_question = new WebPageElements("Engagement - Segment Question Description", "xpath", SOGO_ENGAGEMENT_SEGMENT_QUESTION );
	
	String ENGAGEMENT_FILTER_QUESTION = "//span[contains(text(),'Do you want to apply a filter on this report?')]";
	WebPageElements engagement_filter_question = new WebPageElements("Engagement - Filter Question Description", "xpath", ENGAGEMENT_FILTER_QUESTION );
	
	
	String TOGGLE = "//input[@id='rdAYes']";
	WebPageElements toggle = new WebPageElements("Engagement - Additional Question Toggle", "xpath", TOGGLE );
	
	String TOGGLE1 = "//input[@id='rdIyes']";
	WebPageElements toggle1 = new WebPageElements("Engagement - Composition Analysis Toggle", "xpath", TOGGLE1 );
	
	String TOGGLE2 = "//input[@id='rdSeg_yes']";
	WebPageElements toggle2 = new WebPageElements("Engagement - Segment Question Toggle", "xpath", TOGGLE2 );
	
	String TOGGLE3 = "//input[@id='fyes']";
	WebPageElements toggle3 = new WebPageElements("Engagement - Filter Question Toggle", "xpath", TOGGLE3 );
	
	
	
	String DIMENSIONAL_ANALYSIS = "//a[@id='btnClimateReport']";
	WebPageElements dimensional_analysis = new WebPageElements("Dimensional Analysis", "xpath", DIMENSIONAL_ANALYSIS );
	
	String LEGACY_REPORTS = "//div[@id='btnLegacy']/span";
	WebPageElements legacy_reports  = new WebPageElements("Legacy Reports", "xpath", LEGACY_REPORTS );
	
	String LEGACY_REPORTS_MENU = "//div[@id='dvLegacy']/ul";
	WebPageElements legacy_reports_menu  = new WebPageElements("Legacy Reports - Menu", "xpath", LEGACY_REPORTS_MENU );
	
	String FREQUENCY_TABLE = "//li[@id='ddfrequencyTable']/a";
	WebPageElements frequency_table = new WebPageElements("Frequency Table", "xpath", FREQUENCY_TABLE );
	
	String COMPARISON = "//li[@id='ddComparison']/a";
	WebPageElements comparison = new WebPageElements("comparison", "xpath", COMPARISON );
	
	String  COMPARISON_PAGE_1_DESCR= "//span[contains(text(),'Select the questions you would like to display in your report.')]";
	WebPageElements comparison_page_1_descr  = new WebPageElements("Comparison Report - Select Survey Question Page Description", "xpath", COMPARISON_PAGE_1_DESCR );
	
	String  COMPARISON_PAGE_1_CONTINUE= "//input[@id='btnstep3Next'][contains(@onclick,'Step1Next')]";
	WebPageElements comparison_page_1_continue  = new WebPageElements("Comparison Report - Select Survey Question Page Continue Button", "xpath", COMPARISON_PAGE_1_CONTINUE );
	
	String  COMPARISON_PAGE_2_DESCR= "//span[contains(text(),'To rearrange, drag and drop the questions below into the desired order.')]";
	WebPageElements comparison_page_2_descr  = new WebPageElements("Comparison Report - Reorder Question Page Description", "xpath", COMPARISON_PAGE_2_DESCR );
	
	String  COMPARISON_PAGE_2_CONTINUE= "//input[@id='btnStep2Next']";
	WebPageElements comparison_page_2_continue  = new WebPageElements("Comparison Report - Reorder Question Page Continue Button", "xpath", COMPARISON_PAGE_2_CONTINUE );
	
	String  COMPARISON_PAGE_3_DESCR= "//span[contains(text(),'Select your desired data sets')]";
	WebPageElements comparison_page_3_descr  = new WebPageElements("Comparison Report - Survey Dataset Page Description", "xpath", COMPARISON_PAGE_3_DESCR );
	
	String  SELECT_DATASET_COUNT= "//select[@id='cmbDatasetCount']";
	WebPageElements select_dataset_count  = new WebPageElements("Comparison Report - Select Dataset Dropdown", "xpath", SELECT_DATASET_COUNT );
	
	String  COMPARISON_PAGE_3_CONTINUE= "//input[@id='btnstep3Next']";
	WebPageElements comparison_page_3_continue  = new WebPageElements("Comparison Report - Survey Dataset Page Continue Button", "xpath", COMPARISON_PAGE_3_CONTINUE );
	
	String  COMPARISON_PAGE_4_DESCR= "//span[contains(text(),'Select desired report properties.')]";
	WebPageElements comparison_page_4_descr  = new WebPageElements("Comparison Report - Report Properties Page Description", "xpath", COMPARISON_PAGE_4_DESCR );
	
	
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
	
	
	String RESPONSE_RATE  = "//li[@id='btnParticipationRate']/a";
	WebPageElements response_rate = new WebPageElements("Response Rate", "xpath", RESPONSE_RATE );
	
	String SELECT_RESP_RATE_QUE  = "//select[@id='cmbQuestions']";
	WebPageElements select_resp_rate_que = new WebPageElements("Response Rate Question Drop down", "xpath", SELECT_RESP_RATE_QUE );
	
	String MAX_POSSIBLE_CB  = "//input[@id='chkWarn']";
	WebPageElements max_possible_cb = new WebPageElements("Max Possible Response Warning Check box", "xpath", MAX_POSSIBLE_CB );
	
	String RESPONSE_TREND = "//li[@id='btnResponseTrend']/a";
	WebPageElements response_trend = new WebPageElements("Response Trend", "xpath", RESPONSE_TREND );
	
	String RESPONSE_TREND_HEADER = "//div[contains(text(),'Response Trend Report')]";
	WebPageElements response_trend_header = new WebPageElements("Response Trend Header", "xpath", RESPONSE_TREND_HEADER );
	
	
	String BALLOT_BOX = "//li[@id='btnBallotBoxReport']/a";
	WebPageElements ballot_box = new WebPageElements("Ballot box", "xpath", BALLOT_BOX );
	
	String  BALLOT_PAGE_1_DESCR= "//span[contains(text(),'Enter the known max responses possible for each group.')]";
	WebPageElements ballot_page_1_descr  = new WebPageElements("Ballot Box Report - Specify IP Address Page Description", "xpath", BALLOT_PAGE_1_DESCR );
	
	String BALLOT_PAGE_1_CONTINUE = "//input[@id='btnNext1']";
	WebPageElements ballot_page_1_continue = new WebPageElements("Ballot Box Report - Specify IP Address Page Continue Button", "xpath", BALLOT_PAGE_1_CONTINUE );
	
	String  BALLOT_PAGE_2_DESCR= "//span[contains(text(),'Number of Duplicates Allowed.')]";
	WebPageElements ballot_page_2_descr  = new WebPageElements("Ballot Box Report - Number of Duplicates Allowed Page Description", "xpath", BALLOT_PAGE_2_DESCR );
	
	String  DUPLICATE_ALLOWED_TB= "//input[@id='txtNumDuplicates']";
	WebPageElements duplicate_allowed_tb  = new WebPageElements("Ballot Box Report - Number of Duplicates Allowed Textbox", "xpath", DUPLICATE_ALLOWED_TB );
	
	String BALLOT_PAGE_2_CONTINUE = "//input[@id='btnNext2']";
	WebPageElements ballot_page_2_continue = new WebPageElements("Ballot Box Report - Number of Duplicates Allowed Page Continue Button", "xpath", BALLOT_PAGE_2_CONTINUE );
	
	String  BALLOT_PAGE_3_DESCR= "//span[contains(text(),'Select the questions to be reviewed to determine if multiple responses may be a result of ballot box stuffing.')]";
	WebPageElements ballot_page_3_descr  = new WebPageElements("Ballot Box Report - Data Review Page Description", "xpath", BALLOT_PAGE_3_DESCR );
	
	String  BALLOT_BOX_IP_TABLE= "//div[@id='DvIpDetails']";
	WebPageElements ballot_box_ip_table  = new WebPageElements("Ballot Box Report - IP Details Table", "xpath", BALLOT_BOX_IP_TABLE );
	
	
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
	WebPageElements next1 = new WebPageElements("Continue", "xpath", NEXT1 );
	
	String NEXT3 = "//input[@id='btnstep3Next']";
	WebPageElements next3 = new WebPageElements("Continue", "xpath", NEXT3 );
	
	String NEXT4 = "//input[@id='btnstep4Next']";
	WebPageElements next4 = new WebPageElements("Continue", "xpath", NEXT4 );

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
	
	
	String REPORT_TITLE = "//input[@id='txtRtitle']";
	WebPageElements report_title = new WebPageElements("Report Title", "xpath", REPORT_TITLE);
	
	String REPORT_DESC = "//input[@id='txtDescription']";
	WebPageElements report_desc = new WebPageElements("Report Description", "xpath", REPORT_DESC);
	
	String SEGMENT_ICON = "//div[@title='Segment']";
	WebPageElements segment_icon = new WebPageElements("Segment Icon", "xpath", SEGMENT_ICON);

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
	
	String SEGMENTATION_SURVEY = "//select[@name='SurveyListddl']";
	WebPageElements segmentation_survey = new WebPageElements("Segmentation Survey", "xpath", SEGMENTATION_SURVEY);
	
	String SEGMENTATION_QUESTION = "//select[@id='ddlSiteQuestions']";
	WebPageElements segmentation_question = new WebPageElements("Segmentation Question", "xpath", SEGMENTATION_QUESTION);
	
	String EMAIL_REPORT_TO = "//input[@id='txtSendFromType']";
	WebPageElements email_report_to = new WebPageElements("Email Report To", "xpath", EMAIL_REPORT_TO);
	
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
	
	String EMAIL_REPORT2 = "//input[@value='Email Report']";
	WebPageElements email_report2 = new WebPageElements("Email Report", "xpath", EMAIL_REPORT2);
	
	String SELECT_ALL = "//label[text()=' Select All']";
	WebPageElements select_all = new WebPageElements("Select All", "xpath", SELECT_ALL);
	
	String RAW_DATA = "//div[@id='btnIndividual']/span";
	WebPageElements raw_data = new WebPageElements("Raw Data", "xpath", RAW_DATA);
	
	String RAW_DATA_MENU = "//div[@id ='dvIndiviual']/ul";
	WebPageElements raw_data_menu = new WebPageElements("Raw Data Menu", "xpath", RAW_DATA_MENU);
	
//	String INDIVIDUAL_REPORT = "//li[@id='ddindividual']";
//	WebPageElements individual_report = new WebPageElements("Individual Report", "xpath", INDIVIDUAL_REPORT);
	
	String WIZARD_PAGE_DESCRIPTION = "//div[contains(@class,'pageDescription')]/span";
	WebPageElements wizard_page_description = new WebPageElements("Wizard Page Description", "xpath", WIZARD_PAGE_DESCRIPTION);
	
	String ALL_QUESTIONS = "(//label[text()='All Questions'])[1]";
	WebPageElements all_questions = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS);
	
	String WIZARD_STEP1_CONTINUE = "//input[@id='btnstep1Next']";
	WebPageElements wizard_step1_continue = new WebPageElements("Continue", "xpath", WIZARD_STEP1_CONTINUE);
	
	String WIZARD_STEP2_CONTINUE = "//input[@id='btnStep2Next']";
	WebPageElements wizard_step2_continue = new WebPageElements("Continue", "xpath", WIZARD_STEP2_CONTINUE);
	
	//Use this step 2 btn for Frequency table report, Cross tab report
	String WIZARD_STEP2_CONTINUE_2 = "//input[@id='btnstep2Next']";
	WebPageElements wizard_step2_continue_2 = new WebPageElements("Continue", "xpath", WIZARD_STEP2_CONTINUE_2);
	
	String WIZARD_STEP3_CONTINUE = "//input[@id='btnstep3Next']";
	WebPageElements wizard_step3_continue = new WebPageElements("Continue", "xpath", WIZARD_STEP3_CONTINUE);
	
	String GENERATE_NOW_BUTTON = "//input[@id='btnstep4Next']";
	WebPageElements generate_now_button = new WebPageElements("Generate Now", "xpath", GENERATE_NOW_BUTTON);
	
	//Use this generate btn for Frequency table report, Cross tab report, Verbatim Report, Comparison report
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
	
//	String RESPONSE_TABLE_REPORT = "//li[@id='btnResponseTable']";
//	WebPageElements response_table_report = new WebPageElements("Response Table Report", "xpath", RESPONSE_TABLE_REPORT);
	
	String RESPONSE_TB_SELECT_RESPONSE_DD = "//select[@id='cmbResponse']";
	WebPageElements response_table_select_response_dd = new WebPageElements("Response Table Report - Select Page", "xpath", RESPONSE_TB_SELECT_RESPONSE_DD);
	
	String RESPONSE_TB_ANSWER_FIELD = "//td[@class='responsetd']";
	WebPageElements response_table_answer_field = new WebPageElements("Response Table Report - Answer field", "xpath", RESPONSE_TB_ANSWER_FIELD);
	
//	String REPORT_TAB = "//a[@id='Inner_header1_ctl00_arm']";
//	WebPageElements report_tab = new WebPageElements("Report Tab", "xpath", REPORT_TAB);
//	
//	String OMNI_REPORT = "//div[@id='btnOmniReport']/span";
//	WebPageElements omni_report = new WebPageElements("OMNI Report Button", "xpath", OMNI_REPORT);
//	
//	String OMNI_MODIFY_REPORT = "//span[contains(text(),'Modify Report')]";
//	WebPageElements omni_modify_report = new WebPageElements("Modify Report - OMNI", "xpath", OMNI_MODIFY_REPORT);
	
	String REPORT_ICON2 = "//span[@class='survey-option-icon report-option-icon']";
	WebPageElements report_icon2 = new WebPageElements("Report Icon", "xpath", REPORT_ICON2);
	
	String SLIDESHOW_ICON = "//a[@class='slideshowNormal']";
	WebPageElements slideshow_icon = new WebPageElements("Slide Show Icon", "xpath", SLIDESHOW_ICON);
	
	String SLIDESHOW_EMAIL = "//span[@id='slemail']";
	WebPageElements slideshow_email = new WebPageElements("Slide Show Email", "xpath", SLIDESHOW_EMAIL);
	
	String SLIDESHOW_EMAIL_TO = "//input[@name='txtTo']";
	WebPageElements slideshow_email_to = new WebPageElements("Slide Show Email TO", "xpath", SLIDESHOW_EMAIL_TO);
	
	String SLIDESHOW_EMAIL_SEND = "//input[@id='btnSendEmail']";
	WebPageElements slideshow_email_send = new WebPageElements("Slide Show Email Send", "xpath", SLIDESHOW_EMAIL_SEND);
	
	String SLIDESHOW_CLOSE = "//span[@id='closeBTN']";
	WebPageElements slideshow_close = new WebPageElements("Slide Show Close", "xpath", SLIDESHOW_CLOSE);
	
	String TOASTER_CLOSE = "//div[@id='dvOmniMsg']/span[@class='closebtn']";
	WebPageElements toaster_close = new WebPageElements("Toaster - Close", "xpath", TOASTER_CLOSE);
	

	String SAVE_REPORT_ICON = "//a[@class='saveNormal']";
	WebPageElements save_report_icon = new WebPageElements("Save Report Icon", "xpath", SAVE_REPORT_ICON);
	
	String SAVE_REPORT_NAME = "//input[@id='txtReportName']";
	WebPageElements save_report_name = new WebPageElements("Save Report name", "xpath", SAVE_REPORT_NAME);
	
	String SAVE_REPORT_NAME2 = "//input[@id='txtNewconditionname']";
	WebPageElements save_report_name2 = new WebPageElements("Save Report name", "xpath", SAVE_REPORT_NAME2);
	
	String SAVE_REPORT_NAME3 = "//input[@id='new_condition_name']";
	WebPageElements save_report_name3 = new WebPageElements("Save Report name", "xpath", SAVE_REPORT_NAME3);
	
	String SAVE_BUTTON = "//input[@id='imgsave']";
	WebPageElements save_button = new WebPageElements("Save Report Button", "xpath", SAVE_BUTTON);
	
	String SHARE_EMAIL = "//a[@class='shareNormal']";
	WebPageElements share_email = new WebPageElements("Share Email Icon", "xpath", SHARE_EMAIL);
	
	String DOWNLOAD_REPORT2 = "//a[@class='downloadNormal']";
	WebPageElements download_report2 = new WebPageElements("Download Icon", "xpath", DOWNLOAD_REPORT2);
	
	String DOWNLOAD_EXCEL = "//span[@title='Excel']/parent::div";
	WebPageElements download_excel = new WebPageElements("Download Excel", "xpath", DOWNLOAD_EXCEL);
	
	String DOWNLOAD_EXCEL2 = "//span[text()='Excel1']/parent::li";
	WebPageElements download_excel2 = new WebPageElements("Download Excel 1", "xpath", DOWNLOAD_EXCEL2);
	
	String DOWNLOAD_EXCEL3 = "//span[text()='Excel2']/parent::li";
	WebPageElements download_excel3 = new WebPageElements("Download Excel 2", "xpath", DOWNLOAD_EXCEL3);
	
	String DOWNLOAD_EXCEL4 = "//span[text()='Excel']/parent::li";
	WebPageElements download_excel4 = new WebPageElements("Download Excel", "xpath", DOWNLOAD_EXCEL4);
	
	String DOWNLOAD_WORD = "//span[text()='Word']/parent::li";
	WebPageElements download_word = new WebPageElements("Download Word", "xpath", DOWNLOAD_WORD);
	
	String EXPORT_PPT = "//a[text()='Export to PPT']/parent::li";
	WebPageElements export_ppt = new WebPageElements("Export to PPT", "xpath", EXPORT_PPT);
	
	String EXPORT_EXCEL = "//a[text()='Export to Excel']/parent::li";
	WebPageElements export_excel = new WebPageElements("Export to Excel", "xpath", EXPORT_EXCEL);
	
	String DOWNLOAD_WORD_ALL = "(//a[text()='Export all responses'])[1]";
	WebPageElements download_word_all = new WebPageElements("Download Word All resonses", "xpath", DOWNLOAD_WORD_ALL);
	
	String DOWNLOAD_WORD_ONE = "//a[@id='expwordone']";
	WebPageElements download_word_one = new WebPageElements("Download Word this resonses", "xpath", DOWNLOAD_WORD_ONE);
	
	String DOWNLOAD_EXCEL_ALL = "(//a[text()='Export all responses'])[2]";
	WebPageElements download_excel_all = new WebPageElements("Download Excel All resonses", "xpath", DOWNLOAD_EXCEL_ALL);
	
	String DOWNLOAD_EXCEL_ONE = "//a[@id='expexcelone']";
	WebPageElements download_excel_one = new WebPageElements("Download Excel this resonses", "xpath", DOWNLOAD_EXCEL_ONE);
	
	String DOWNLOAD_PPT2 = "//span[text()='PowerPoint1']/parent::li";
	WebPageElements download_ppt2 = new WebPageElements("Download PowerPoint 1", "xpath", DOWNLOAD_PPT2);
	
	String DOWNLOAD_PPT3 = "//span[text()='PowerPoint2']/parent::li";
	WebPageElements download_ppt3 = new WebPageElements("Download PowerPoint 2", "xpath", DOWNLOAD_PPT3);
	
	String DOWNLOAD_PPT = "//span[@title='PowerPoint']/parent::div";
	WebPageElements download_ppt = new WebPageElements("Download PowerPoint", "xpath", DOWNLOAD_PPT);
	
	String SHARE_EMAIL_TITLE = "//input[@name='TxtReportName']";
	WebPageElements share_email_title = new WebPageElements("Share Email Title", "xpath", SHARE_EMAIL_TITLE);
	
	String SHARE_EMAIL_TO = "//input[@name='TextToEmail']";
	WebPageElements share_email_to = new WebPageElements("Share Email TO", "xpath", SHARE_EMAIL_TO);
	
	String CONTINUE_BUTTON = "//input[@id='StepNext']";
	WebPageElements continue_button = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON);
	
	String SHARE_EMAIL_SEND = "//input[@id='btnSubmit']";
	WebPageElements share_email_send = new WebPageElements("Share Email Send", "xpath", SHARE_EMAIL_SEND);
	
	String FREQUENCY_REPORT = "//span[text()='Frequency']";
	WebPageElements frequency_report = new WebPageElements("Frequency Report", "xpath", FREQUENCY_REPORT);
	
	String ADVANCED_FREQUENCY_REPORT = "//a[contains(text(),'Advanced Frequency')]";
	WebPageElements advanced_frequency_report = new WebPageElements("Frequency Report", "xpath", ADVANCED_FREQUENCY_REPORT);
	
	String RAW_REPORT = "//span[text()='Raw Data']";
	WebPageElements raw_report = new WebPageElements("Raw Report", "xpath", RAW_REPORT);
	
	String SPECIAL_REPORT = "//span[text()='Special Reports']";
	WebPageElements special_report = new WebPageElements("Special Report", "xpath", SPECIAL_REPORT);
	
	String SEGMENTATION_REPORT = "//div[@id='ddegmentation']/span";
	WebPageElements segmentation_report = new WebPageElements("Segmentation Report", "xpath", SEGMENTATION_REPORT);
	
	String SEGMENTATION_QUESTION_DD = "//select[@name='DDLQuestion']";
	WebPageElements segmentation_question_dd = new WebPageElements("Segmentation Question", "xpath", SEGMENTATION_QUESTION_DD);
	
	String SEGMENTATION_REPORT_PAGE_2_DESCR = "//span[text()='Select the questions you would like to display in your report.']";
	WebPageElements segmentation_report_page_2_descr = new WebPageElements("Segmentation Report - Survey Question Page Description", "xpath", SEGMENTATION_REPORT_PAGE_2_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_3_DESCR = "//span[text()='To rearrange, drag and drop the questions below into the desired order.']";
	WebPageElements segmentation_report_page_3_descr = new WebPageElements("Segmentation Report - Reorder Page Description", "xpath", SEGMENTATION_REPORT_PAGE_3_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_4_DESCR = "//span[contains(text(),'Select desired report properties.')]";
	WebPageElements segmentation_report_page_4_descr = new WebPageElements("Segmentation Report - Report Properties Page Description", "xpath", SEGMENTATION_REPORT_PAGE_4_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_5_DESCR = "//span[contains(text(),'Would you like to compare your segments with other filtered data?')]";
	WebPageElements segmentation_report_page_5_descr = new WebPageElements("Segmentation Report - Comparison Segment Data Page Description", "xpath", SEGMENTATION_REPORT_PAGE_5_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_6_DESCR = "//span[contains(text(),'Customize your Segmentation Report cover page.')]";
	WebPageElements segmentation_report_page_6_descr = new WebPageElements("Segmentation Report - Customize Cover Page Description", "xpath", SEGMENTATION_REPORT_PAGE_6_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_7_DESCR = "//span[contains(text(),'Select delivery options for your report.')]";
	WebPageElements segmentation_report_page_7_descr = new WebPageElements("Segmentation Report - Customize Cover Page Description", "xpath", SEGMENTATION_REPORT_PAGE_7_DESCR);
	
	String SEGMENTATION_REPORT_PAGE_3_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepThreeNext')]";
	WebPageElements segmentation_report_page_3_continue = new WebPageElements("Segmentation Report - Reorder Page Continue Button", "xpath", SEGMENTATION_REPORT_PAGE_3_CONTINUE);
	
	String SEGMENTATION_REPORT_PAGE_4_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepFourNext')]";
	WebPageElements segmentation_report_page_4_continue = new WebPageElements("Segmentation Report - Report Properties Continue Button", "xpath", SEGMENTATION_REPORT_PAGE_4_CONTINUE);
	
	String SEGMENTATION_REPORT_PAGE_5_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepNewFifthNext')]";
	WebPageElements segmentation_report_page_5_continue = new WebPageElements("Segmentation Report - Comparison Segment Data Continue Button", "xpath", SEGMENTATION_REPORT_PAGE_5_CONTINUE);
	
	String SEGMENTATION_REPORT_PAGE_6_CONTINUE = "//input[@value='Continue'][contains(@onclick,'StepSixthNext')]";
	WebPageElements segmentation_report_page_6_continue = new WebPageElements("Segmentation Report - Customize Cover Continue Button", "xpath", SEGMENTATION_REPORT_PAGE_6_CONTINUE);
	
	
	String COMPOSITION_REPORT_DD = "//select[@name='DDL_Com']";
	WebPageElements compostion_report_dd = new WebPageElements("Segmentation Question", "xpath", COMPOSITION_REPORT_DD);
	
	String SEGMENT_DD = "//select[@name='DDL_Seg']";
	WebPageElements segment_dd = new WebPageElements("Segmentation DD", "xpath", SEGMENT_DD);
	
	String SEGMENT_DD1 = "//select[@name='DDL_Seg1']";
	WebPageElements segment_dd1 = new WebPageElements("Segmentation DD", "xpath", SEGMENT_DD1);
	
	String SELECT_ALL_OPTIONS = "//label[contains(text(),'Select All Options')]";
	WebPageElements select_all_options = new WebPageElements("Select All Options", "xpath", SELECT_ALL_OPTIONS);
	
	String PARTICIPATION_DETAILS2 = "//input[@id='txtReportType']";
	WebPageElements participation_details2 = new WebPageElements("Participants in study", "xpath", PARTICIPATION_DETAILS2);
	
	String NMAX = "//input[@id='txtNmax']";
	WebPageElements nmax = new WebPageElements("Nmax", "xpath", NMAX);
	
	String ENGAGEMENT_REPORT_TYPE = "//input[@id='txtReportType']";
	WebPageElements engagement_report_type = new WebPageElements("Engagement Report Type", "xpath", ENGAGEMENT_REPORT_TYPE);
	
	String INDIVIDUAL_REPORT = "//a[contains(text(),'Individual')]";
	WebPageElements individual_report = new WebPageElements("Individual Report", "xpath", INDIVIDUAL_REPORT);
	
	String RESPONSE_TABLE_REPORT = "//a[contains(text(),'Response Table')]";
	WebPageElements response_table_report = new WebPageElements("Response Table Report", "xpath", RESPONSE_TABLE_REPORT);
	
	String ENGAGEMENT_REPORT = "//a[contains(text(),'Engagement')]";
	WebPageElements engagement_report = new WebPageElements("Engagement Report", "xpath", ENGAGEMENT_REPORT);
	
	String DAR_REPORT = "//a[contains(text(),'Dimensional Analysis')]";
	WebPageElements dar_report = new WebPageElements("Dimensional Analysis Report", "xpath", DAR_REPORT); 
	
	String SURVEY_QUESTIONS_PAGE = "//span[text()='Please select the questions that would be displayed in this report. ']";
	WebPageElements survey_questions_page = new WebPageElements("Survey Questions Page", "xpath", SURVEY_QUESTIONS_PAGE);
	
	String SURVEY_QUESTIONS_PAGE2 = "//span[text()='Select the questions you would like to display in your report.']";
	WebPageElements survey_questions_page2 = new WebPageElements("Survey Questions Page", "xpath", SURVEY_QUESTIONS_PAGE2);
	
	String ENGAGEMENT_QUESTIONS_PAGE = "//span[text()='Please select all engagement questions for this report.']";
	WebPageElements engagement_questions_page = new WebPageElements("Engagement Questions Page", "xpath", ENGAGEMENT_QUESTIONS_PAGE);
	
	String DRIVER_QUESTIONS_PAGE = "//span[text()='Please select all driver questions for this report.']";
	WebPageElements drivers_questions_page = new WebPageElements("Drivers Questions Page", "xpath", DRIVER_QUESTIONS_PAGE);
	
	String ADDITIONAL_QUESTIONS_PAGE = "//span[text()='Select additional questions.']";
	WebPageElements additional_questions_page = new WebPageElements("Additional Questions Page", "xpath", ADDITIONAL_QUESTIONS_PAGE);
	
	String COMPOSITION_ANALYSIS_PAGE = "//span[contains(text(),'Choose whether to include a breakdown of participants by relevant groups.')]";
	WebPageElements compositional_analysis_page = new WebPageElements("Composition Analysis Page", "xpath", COMPOSITION_ANALYSIS_PAGE);
	
	String SEGMENTATION_REPORT_PAGE = "//span[contains(text(),'Choose whether to generate segmentation reports by group.')]";
	WebPageElements segementation_report_page = new WebPageElements("Segmentation Report Page", "xpath", SEGMENTATION_REPORT_PAGE);
	
	String EXPORT_TO_PPT = "//a[contains(text(),'Export to PPT')]";
	WebPageElements export_to_PPT = new WebPageElements("Export to PPT", "xpath", EXPORT_TO_PPT);
	
	String EXPORT_TO_EXCEL = "//a[contains(text(),'Export to Excel')]";
	WebPageElements export_to_ecxel = new WebPageElements("Export to Excel", "xpath", EXPORT_TO_EXCEL);
	
	
	String ADD_MORE = "//a[text()='Add More']";
	WebPageElements add_more = new WebPageElements("Add more", "xpath", ADD_MORE);
	
//	String ALL_QUESTIONS = "//label[text()='All Questions' and @for='chkMain']";
//	WebPageElements all_questions = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS);
	
	String ALL_QUESTIONS2 = "//label[text()='All Questions' and @for='WizardControl1_chkMain']";
	WebPageElements all_questions2 = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS2);
	
	String ALL_QUESTIONS3 = "//label[text()='All Questions' and @for='chkMain']";
	WebPageElements all_questions3 = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS3);
	
	String ALL_QUESTIONS4 = "//label[text()='All Questions' and @for='chkMain2']";
	WebPageElements all_questions4 = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS4);
	
	String ALL_QUESTIONS5 = "//label[text()='All Questions' and @for='chkMain3']";
	WebPageElements all_questions5 = new WebPageElements("All Questions", "xpath", ALL_QUESTIONS5);
	
	
	String CONTINUE_BUTTON1 = "//input[@id='btnstep1Next']";
	WebPageElements continue_button1 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON1);
	
	String CONTINUE_BUTTON2 = "//input[@id='btnStep2Next']";
	WebPageElements continue_button2 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON2);
	
	String CONTINUE_BUTTON11 = "(//input[@value='Continue'])[1]";
	WebPageElements continue_button11 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON11);
	
	String CONTINUE_BUTTON22 = "(//input[@value='Continue'])[2]";
	WebPageElements continue_button22 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON22);
	
	String CONTINUE_BUTTON4 = "(//input[@value='Continue'])[3]";
	WebPageElements continue_button4 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON4);
	
	String CONTINUE_BUTTON44 = "(//input[@value='Continue'])[4]";
	WebPageElements continue_button44 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON44);
	
	String CONTINUE_BUTTON5 = "(//input[@value='Continue'])[5]";
	WebPageElements continue_button5 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON5);
	
	String CONTINUE_BUTTON6 = "(//input[@value='Continue'])[6]";
	WebPageElements continue_button6 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON6);
	
	String CONTINUE_BUTTON7 = "(//input[@value='Continue'])[7]";
	WebPageElements continue_button7 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON7);
	
	String CONTINUE_BUTTON3 = "//input[@id='btnstep3Next']";
	WebPageElements continue_button3 = new WebPageElements("Continue", "xpath", CONTINUE_BUTTON3);
	
	String REORDER_QUESTIONS_PAGE = "//span[text()='Indicate the order of questions (you can drag and drop a question to another location). ']";
	WebPageElements reorder_questions_page = new WebPageElements("Reorder Questions Page", "xpath", REORDER_QUESTIONS_PAGE);
	
	String DISPLAY_REPORT_WITH_TABLES = "//label[text()='Display reports with data tables ']";
	WebPageElements display_report_with_tables = new WebPageElements("Display reports with data tables ", "xpath", DISPLAY_REPORT_WITH_TABLES);
	
	String DISPLAY_QUESTION_NAMES = "//label[contains(text(),'Display Question Numbers')]";
	WebPageElements display_question_names = new WebPageElements("Display Question Numbers ", "xpath", DISPLAY_QUESTION_NAMES);
	
	String DISPLAY_TABLE = "//label[contains(text(),'Display Table')]";
	WebPageElements display_table = new WebPageElements("Display Table", "xpath", DISPLAY_TABLE);
	
	String DISPLAY_WEIGHTED_SCORE = "//label[contains(text(),'Display Weighted Score/Average for Rating Questions')]";
	WebPageElements display_weighted_score = new WebPageElements("Display Weighted Score/Average for Rating Questions ", "xpath", DISPLAY_WEIGHTED_SCORE);
	
	String PROPERTIES_PAGE = "//span[text()='Select desired report properties. Please note that you will have an opportunity to change some of these settings even after the report is generated.']";
	WebPageElements properties_page = new WebPageElements("Properties Page", "xpath", PROPERTIES_PAGE);
	
	String PROPERTIES_PAGE2 = "//span[text()='Select desired report properties. Please note that some properties can still be modified once the report is generated.']";
	WebPageElements properties_page2 = new WebPageElements("Properties Page", "xpath", PROPERTIES_PAGE2);
	
	String COMPARISON_SEGMENTATION = "//span[text()='Would you like to compare your segments with other filtered data?']";
	WebPageElements comparison_segmentation = new WebPageElements("Comparison Segmentation Page", "xpath", COMPARISON_SEGMENTATION);
	
	String PARTICIPATION_DETAILS = "//span[text()='Define participation details.']";
	WebPageElements participation_details = new WebPageElements("Participation Details Page", "xpath", PARTICIPATION_DETAILS);
	
	String TP1TG1 = "//div[@class='col2 row1']";
	WebPageElements tp1tg1 = new WebPageElements("Target Period 1 Target Group 1", "xpath", TP1TG1);
	
	String TP2TG1 = "//div[@class='col3']";
	WebPageElements tp2tg1 = new WebPageElements("Target Period 2 Target Group 1", "xpath", TP2TG1);
	
	String CUSTOMIZE_COVER_PAGE = "//span[text()='Customize your Segmentation Report cover page.']";
	WebPageElements customize_cover_page = new WebPageElements("Customize Cover Page", "xpath", CUSTOMIZE_COVER_PAGE);
	
	String DATA_SOURCES_PAGE = "//span[text()='Select various data sources for this report ']";
	WebPageElements data_sources_page = new WebPageElements("Data Sources Page", "xpath", DATA_SOURCES_PAGE);
	
	String EMAIL_REPORT = "//span[text()='Select delivery options for your report.']";
	WebPageElements email_report = new WebPageElements("Data Sources Page", "xpath", EMAIL_REPORT);
	
	String EMAIL_SEGMENTATION_REPORT = "//input[@name='TxtMailMe']";
	WebPageElements email_segmentation_report = new WebPageElements("Email Segmentation Report", "xpath", EMAIL_SEGMENTATION_REPORT);
	
	String EMAIL_ENGAGEMENT_REPORT = "//input[@id='emailId']";
	WebPageElements email_engagement_report = new WebPageElements("Email Engagement Report", "xpath", EMAIL_ENGAGEMENT_REPORT);
	
	String WORD_ZIP = "//label[text()='All segment reports as multiple Word documents in a zipped file.']";
	WebPageElements word_zip = new WebPageElements("Word documents in a zipped file", "xpath", WORD_ZIP);
	
	String SEND_EMAIL = "//input[@name='sendEmail']";
	WebPageElements send_email = new WebPageElements("Submit", "xpath", SEND_EMAIL);
	
	String WORD_SEPERATE = "//label[text()='Individual segment report in separate Word document.']";
	WebPageElements word_seperate = new WebPageElements("separate Word document", "xpath", WORD_SEPERATE);
	
	String DATA_SOURCES_PAGE2 = "//span[text()='Select your desired filters.']";
	WebPageElements data_sources_page2 = new WebPageElements("Data Sources Page", "xpath", DATA_SOURCES_PAGE2);

	String GENERATE_BUTTON = "//input[@value='Generate']";
	WebPageElements generate_button = new WebPageElements("Generate Button", "xpath", GENERATE_BUTTON);
	
	String MODIFY_REPORT_BUTTON = "//input[@value='Modify Report']";
	WebPageElements modify_report_button = new WebPageElements("Modify Report Button", "xpath", MODIFY_REPORT_BUTTON);
	
	String REQUEST_RECEIVED = "//div[contains(text(),'Your request has been received, and your report is being processed. During this time, you may continue using other platform features.')]";
	WebPageElements request_received = new WebPageElements("Your request has been received", "xpath", REQUEST_RECEIVED);
	
	String ADDITIONAL_QUESTIONS_SWITCH = "//input[@id='rdAYes']";
	WebPageElements additional_questions_switch = new WebPageElements("Additional Questions Switch", "xpath", ADDITIONAL_QUESTIONS_SWITCH);
	
	String COMPOSITION_ANALYSIS_SWITCH = "//input[@id='rdIyes']";
	WebPageElements compostion_analysis_switch = new WebPageElements("Composition Analysis Switch", "xpath", COMPOSITION_ANALYSIS_SWITCH);
	
	String SEGMENTATION_REPORT_SWITCH = "//input[@id='rdSeg_yes']";
	WebPageElements segmentation_report_switch = new WebPageElements("Segmentation Report Switch", "xpath", SEGMENTATION_REPORT_SWITCH);
	
	String SEGMENT_INPUT = "//input[@id='txtSegment']";
	WebPageElements segment_input_switch = new WebPageElements("Segment Input Switch", "xpath", SEGMENT_INPUT);
	
	String SEGMENT_INPUT1 = "//input[@id='txtSegment1']";
	WebPageElements segment_input_switch1 = new WebPageElements("Segment Input Switch", "xpath", SEGMENT_INPUT1);
	
	String SELECT_RESPONSE_NO = "//select[@id='cmbPageSel']";
	WebPageElements select_response_no = new WebPageElements("Response Drop Down", "xpath", SELECT_RESPONSE_NO);

	String EXCLUDE_FROM_REPORTS = "//button[text()='Exclude from reports']";
	WebPageElements exclude_from_reports = new WebPageElements("Exclude From Reports Button", "xpath", EXCLUDE_FROM_REPORTS);
	
	String EXCLUDE_RESPONSE_NOTE = "//span[@id='lblExcludeResponse']";
	WebPageElements exclude_response_note = new WebPageElements("Exclude Response - Note", "xpath", EXCLUDE_RESPONSE_NOTE);
	
	String INCLUDE_IN_REPORTS = "//button[text()='Include in reports']";
	WebPageElements include_in_reports = new WebPageElements("Include in Reports Button", "xpath", INCLUDE_IN_REPORTS);
	
	
	
}
