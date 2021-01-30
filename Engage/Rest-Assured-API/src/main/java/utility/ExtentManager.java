package utility;


import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentReports extent;
	
	public static ExtentReports getExtentInstance() {
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
		String reportPath = ".\\Extent Reports\\" + fileName;
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
