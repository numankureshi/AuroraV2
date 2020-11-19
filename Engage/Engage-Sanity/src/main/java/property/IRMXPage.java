package property;

import utility.WebPageElements;

public interface IRMXPage {
	
	String REPORT_TAB = "//a[@id='Inner_header1_ctl00_arm']";
	WebPageElements report_tab = new WebPageElements("Report Tab", "xpath", REPORT_TAB);
	
	String OMNI_REPORT = "//div[@id='btnOmniReport']/span";
	WebPageElements omni_report = new WebPageElements("OMNI Report Button", "xpath", OMNI_REPORT);
	
	String OMNI_MODIFY_REPORT = "//span[contains(text(),'Modify Report')]";
	WebPageElements omni_modify_report = new WebPageElements("Modify Report - OMNI", "xpath", OMNI_MODIFY_REPORT);
	
	
	

}
