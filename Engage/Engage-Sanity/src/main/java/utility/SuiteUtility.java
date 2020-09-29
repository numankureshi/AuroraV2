package utility;

import java.util.ArrayList;
import java.util.HashMap;

public class SuiteUtility {
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String colName, HashMap<String, String> TestResultTL) {
		return xls.writeResult(sheetName, colName, TestResultTL);
	}
	
	public static boolean WriteResultUtility1(Read_XLS xls, String sheetName, String colName, ArrayList<String> failureReasons) {
		return xls.writeFailureReasons(sheetName, colName, failureReasons);
	}
}
