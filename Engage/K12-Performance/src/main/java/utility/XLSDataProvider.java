package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class XLSDataProvider {
	static XLSDataProvider objXLS = new XLSDataProvider();
	
	@DataProvider(name = "Performance")
	public static Object[][] sanityTestData(Method m) {
		FetchExcelDataSet fetchExcelDataSet = new FetchExcelDataSet();
		Object[][] dataSet = fetchExcelDataSet.getDataSetAsObjectArray(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\K12_Performance.xlsx", "PerformanceTC", m.getName());
		return dataSet;
	}
}
