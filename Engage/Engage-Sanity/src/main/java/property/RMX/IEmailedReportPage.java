package property.RMX;

import utility.WebPageElements;

public interface IEmailedReportPage {
	
	String EMAIL_REPORTS = "//div[@id='dvEmailReportTab']";
	WebPageElements email_reports = new WebPageElements("Email Reports", "xpath", EMAIL_REPORTS );
	
	String EMAILED_REPORT_PAGE_HEADER = "//div[text()='Below are the Emailed Reports for this Project.']";
	WebPageElements emailed_report_page_header = new WebPageElements("Emailed Report Page Header", "xpath", EMAILED_REPORT_PAGE_HEADER );
}
