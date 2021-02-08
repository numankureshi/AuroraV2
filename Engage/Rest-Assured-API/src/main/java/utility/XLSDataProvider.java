package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class XLSDataProvider {
	static XLSDataProvider objXLS = new XLSDataProvider();
	
	@DataProvider(name = "SoGo API")
	public static Object[][] sanityTestData(Method m) {
		FetchExcelDataSet fetchExcelDataSet = new FetchExcelDataSet();
		Object[][] dataSet = fetchExcelDataSet.getDataSetAsObjectArray(System.getProperty("user.dir") + "\\src\\main\\resources\\excelfiles\\Sogo_API.xlsx", "API_TC", m.getName());
		return dataSet;
	}
}
