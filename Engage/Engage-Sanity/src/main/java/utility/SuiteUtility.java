package utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class SuiteUtility {
	public static boolean WriteResultUtility(Read_XLS xls, String sheetName, String colName, HashMap<String, String> TestResultTL) {
		return xls.writeResult(sheetName, colName, TestResultTL);
	}
	
	public static boolean WriteResultUtility1(Read_XLS xls, String sheetName, String colName, ArrayList<String> failureReasons) {
		return xls.writeFailureReasons(sheetName, colName, failureReasons);
	}
	
	public static boolean isValidEmailAddrss(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
