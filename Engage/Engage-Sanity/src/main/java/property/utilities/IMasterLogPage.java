package property.utilities;

import utility.WebPageElements;

public interface IMasterLogPage {
	String MASTER_LOG = "//span[contains(text(),'Master Log')]";
	WebPageElements master_log = new WebPageElements("master log", "xpath", MASTER_LOG );
	
	String EXPORT_ALL = "//input[@id='ctl00_ctl00_cphMain_cphBody_btnExportAll']";
	WebPageElements export_all = new WebPageElements("Export all in master log", "xpath", EXPORT_ALL );

	String SEARCH_BOX = "//input[@class='searchText']";
	WebPageElements search_box = new WebPageElements("Search Box in master log", "xpath", SEARCH_BOX );
	
	String SUBSCRIPTION_STATUS = "//img[@id='Img4']";
	WebPageElements subscription_status = new WebPageElements("subscription status in master log", "xpath", SUBSCRIPTION_STATUS );
	
	String UNSUBSCRIBED_STATUS = "//label[(contains (text(),'Unsubscribed'))]";
	WebPageElements unsubscribed_status = new WebPageElements("Unsubscribed Status in master log", "xpath", UNSUBSCRIBED_STATUS );
	
	String OK_STATUS = "//label[(contains (text(),'OK'))]";
	WebPageElements ok_status = new WebPageElements("Ok Status in master log", "xpath", OK_STATUS );
	
	String MASTERLOG_STATUS_DONE = "//tr//td[@style='text-align: center']//input[@value='Done']";
	WebPageElements masterlog_status_done = new WebPageElements("done button in subscriptionstatus of master log", "xpath", MASTERLOG_STATUS_DONE );
	
	String EXPORT_FILTERED_RECORD = "//div[@id='ctl00_ctl00_cphMain_cphBody_upperdiv']//input[@value='Export Filtered Records']";
	WebPageElements export_filtered_record = new WebPageElements("Export filtered record in master log", "xpath", EXPORT_FILTERED_RECORD );
	
	String TOOL_TIP_MASTER_LOG = "//div[@class='tooltip_container tooltip_help tooltip_white']";
	WebPageElements tool_tip_master_log = new WebPageElements("Tool Tip in master log", "xpath", TOOL_TIP_MASTER_LOG );
	
	String LEARN_MORE = "//a[(contains (text(),'Learn more'))]";
	WebPageElements learn_more = new WebPageElements("Learn More in master log", "xpath", LEARN_MORE );
	
	String USERGUIDE_MASTER_LOG = "//a[(contains (text(),'Learn more'))]";
	WebPageElements userguide_master_log = new WebPageElements("User Guide in master log", "xpath", USERGUIDE_MASTER_LOG );
	
	String IFRAME_USERGUIDE_MASTER_LOG = "//iframe[@title='Help panel Iframe']";
	WebPageElements iframe_userguide_master_log = new WebPageElements("IFrame User Guide in master log", "xpath", IFRAME_USERGUIDE_MASTER_LOG );
	
	String EMAILADDRESS_MOBILENUMBER = "//img[@id='img1']";
	WebPageElements emailaddress_mobilenumber = new WebPageElements("Email/Mobile Filter", "xpath", EMAILADDRESS_MOBILENUMBER );
	
	String EMAILADDRESS_MOBILENUMBER_FILTER_DONE = "//table[@class='status smallradio']//input[@value='Done']";
	WebPageElements emailaddress_mobilenumber_filter_done = new WebPageElements("Email/Mobile Filter Done", "xpath", EMAILADDRESS_MOBILENUMBER_FILTER_DONE );
	
	String CHOOSE_ALPHABET_NUMBER = "//select[@class='smallfont']";
	WebPageElements choose_alphabet_number = new WebPageElements("Choose Aplhabet/Number for Filter in master log", "xpath", CHOOSE_ALPHABET_NUMBER );
	
	String OPTION_VALUE_B = "//option[@value='b']";
	WebPageElements option_value_b = new WebPageElements("select b", "xpath", OPTION_VALUE_B );
	
	String OPTION_VALUE_C = "//option[@value='c']";
	WebPageElements option_value_c = new WebPageElements("select c", "xpath", OPTION_VALUE_C );
	
	String OPTION_VALUE_D = "//option[@value='d']";
	WebPageElements option_value_d = new WebPageElements("select d", "xpath", OPTION_VALUE_D );
	
	String OPTION_VALUE_E = "//option[@value='e']";
	WebPageElements option_value_e = new WebPageElements("select e", "xpath", OPTION_VALUE_E );
	
	String OPTION_VALUE_F = "//option[@value='f']";
	WebPageElements option_value_f = new WebPageElements("select f", "xpath", OPTION_VALUE_F );
	
	String OPTION_VALUE_G = "//option[@value='g']";
	WebPageElements option_value_g = new WebPageElements("select g", "xpath", OPTION_VALUE_G );
	
	String OPTION_VALUE_H = "//option[@value='h']";
	WebPageElements option_value_h = new WebPageElements("select h", "xpath", OPTION_VALUE_H );
	
	String OPTION_VALUE_I = "//option[@value='i']";
	WebPageElements option_value_i = new WebPageElements("select i", "xpath", OPTION_VALUE_I );
	
	String OPTION_VALUE_J = "//option[@value='j']";
	WebPageElements option_value_j = new WebPageElements("select j", "xpath", OPTION_VALUE_J );
	
	String OPTION_VALUE_K = "//option[@value='k']";
	WebPageElements option_value_k = new WebPageElements("select k", "xpath", OPTION_VALUE_K );
	
	String OPTION_VALUE_L = "//option[@value='l']";
	WebPageElements option_value_l = new WebPageElements("select l", "xpath", OPTION_VALUE_L );
	
	String OPTION_VALUE_M = "//option[@value='m']";
	WebPageElements option_value_m = new WebPageElements("select m", "xpath", OPTION_VALUE_M );
	
	String OPTION_VALUE_N = "//option[@value='n']";
	WebPageElements option_value_n = new WebPageElements("select n", "xpath", OPTION_VALUE_N );
	
	String OPTION_VALUE_O = "//option[@value='o']";
	WebPageElements option_value_o = new WebPageElements("select o", "xpath", OPTION_VALUE_O );
	
	String OPTION_VALUE_P = "//option[@value='p']";
	WebPageElements option_value_p = new WebPageElements("select p", "xpath", OPTION_VALUE_P );
	
	String OPTION_VALUE_Q = "//option[@value='q']";
	WebPageElements option_value_q = new WebPageElements("select q", "xpath", OPTION_VALUE_Q );
	
	String OPTION_VALUE_R = "//option[@value='r']";
	WebPageElements option_value_r = new WebPageElements("select r", "xpath", OPTION_VALUE_R );
	
	String OPTION_VALUE_S = "//option[@value='s']";
	WebPageElements option_value_s = new WebPageElements("select s", "xpath", OPTION_VALUE_S );
	
	String OPTION_VALUE_T = "//option[@value='t']";
	WebPageElements option_value_t = new WebPageElements("select t", "xpath", OPTION_VALUE_T );
	
	String OPTION_VALUE_U = "//option[@value='u']";
	WebPageElements option_value_u = new WebPageElements("select u", "xpath", OPTION_VALUE_U );
	
	String OPTION_VALUE_V = "//option[@value='v']";
	WebPageElements option_value_v = new WebPageElements("select v", "xpath", OPTION_VALUE_V );
	
	String OPTION_VALUE_W = "//option[@value='w']";
	WebPageElements option_value_w = new WebPageElements("select w", "xpath", OPTION_VALUE_W );
	
	String OPTION_VALUE_X = "//option[@value='x']";
	WebPageElements option_value_x = new WebPageElements("select x", "xpath", OPTION_VALUE_X );
	
	String OPTION_VALUE_Y = "//option[@value='y']";
	WebPageElements option_value_y = new WebPageElements("select y", "xpath", OPTION_VALUE_Y );
	
	String OPTION_VALUE_Z = "//option[@value='z']";
	WebPageElements option_value_z = new WebPageElements("select z", "xpath", OPTION_VALUE_Z );
	
	String OPTION_VALUE_0 = "//option[@value='(0']";
	WebPageElements option_value_0 = new WebPageElements("select 0", "xpath", OPTION_VALUE_0 );
	
	String OPTION_VALUE_1 = "//option[@value='(1']";
	WebPageElements option_value_1 = new WebPageElements("select 1", "xpath", OPTION_VALUE_1 );
	
	String OPTION_VALUE_2 = "//option[@value='(2']";
	WebPageElements option_value_2 = new WebPageElements("select 2", "xpath", OPTION_VALUE_2 );
	
	String OPTION_VALUE_3 = "//option[@value='(3']";
	WebPageElements option_value_3 = new WebPageElements("select 3", "xpath", OPTION_VALUE_3 );
	
	String OPTION_VALUE_4 = "//option[@value='(4']";
	WebPageElements option_value_4 = new WebPageElements("select 4", "xpath", OPTION_VALUE_4 );
	
	String OPTION_VALUE_5 = "//option[@value='(5']";
	WebPageElements option_value_5 = new WebPageElements("select 5", "xpath", OPTION_VALUE_5 );
	
	String OPTION_VALUE_6 = "//option[@value='(6']";
	WebPageElements option_value_6 = new WebPageElements("select 6", "xpath", OPTION_VALUE_6 );
	
	String OPTION_VALUE_7 = "//option[@value='(7']";
	WebPageElements option_value_7 = new WebPageElements("select 7", "xpath", OPTION_VALUE_7 );
	
	String OPTION_VALUE_8 = "//option[@value='(8']";
	WebPageElements option_value_8 = new WebPageElements("select 8", "xpath", OPTION_VALUE_8 );
	
	String OPTION_VALUE_9 = "//option[@value='(9']";
	WebPageElements option_value_9 = new WebPageElements("select 9", "xpath", OPTION_VALUE_9 );
}
