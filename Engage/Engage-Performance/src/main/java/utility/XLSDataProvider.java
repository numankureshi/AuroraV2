package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class XLSDataProvider {
	static XLSDataProvider objXLS = new XLSDataProvider();
	
	@DataProvider(name = "Performance")
	public static Object[][] sanityTestData(Method m) {
		FetchExcelDataSet fetchExcelDataSet = new FetchExcelDataSet();
		Object[][] dataSet = fetchExcelDataSet.getDataSetAsObjectArray(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Engage_NSReadings.xlsx", "PerformanceTC", m.getName());
		return dataSet;
	}
	
	@DataProvider(name = "PlatformReadings")
	public static Object[][] PlatformReadingsTestData(Method m) {
		FetchExcelDataSet fetchExcelDataSet = new FetchExcelDataSet();
		Object[][] dataSet = fetchExcelDataSet.getDataSetAsObjectArray(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Engage_PlatformReadings.xlsx", "PlatformReadingsTC", m.getName());
		return dataSet;
	}
}
