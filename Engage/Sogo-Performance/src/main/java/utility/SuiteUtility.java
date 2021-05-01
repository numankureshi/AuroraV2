package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestResult;

public class SuiteUtility {
	
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String colName, HashMap<String, String> TestResultTL) {
		return xls.writeResult(sheetName, colName, TestResultTL);
	}
	
	public static boolean WriteResultUtility1(Read_XLS xls, String sheetName, String colName, ArrayList<String> failureReasons) {
		return xls.writeFailureReasons(sheetName, colName, failureReasons);
	}
	
	public static boolean WriteResultUtility2(Read_XLS xls, String sheetName, String colName, HashMap<String, String> LoadTime) {
		return xls.writeResultPerformance(sheetName, colName, LoadTime);
	}
	
	public static String createPlatformreadingSheet(String fileName, String sheetName, String extension) {
		return Read_XLS.createPlatformreading(fileName, sheetName, extension);
	}
	
	public static boolean WriteResultUtility4(Read_XLS xls, String sheetName, ITestResult TestResultTL, Map<String,String> loadTime) {
		return xls.writePlatformReadings(sheetName, TestResultTL, loadTime);
	}
}
