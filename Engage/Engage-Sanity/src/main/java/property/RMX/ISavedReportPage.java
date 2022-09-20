package property.RMX;

import utility.WebPageElements;

public interface ISavedReportPage {
	
	String SAVED_REPORTS = "//div[@id='dvSavedReportTab']";
	WebPageElements saved_reports = new WebPageElements("Saved Reports", "xpath", SAVED_REPORTS );
	
	String SAVED_REPORT_PAGE_HEADER = "//div[text()='Modify and review Saved Reports.']";
	WebPageElements saved_report_page_header = new WebPageElements("Saved Report Page Header", "xpath", SAVED_REPORT_PAGE_HEADER );
	
}
