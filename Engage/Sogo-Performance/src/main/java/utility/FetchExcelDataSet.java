package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.inject.spi.HasDependencies;

public class FetchExcelDataSet {
	HashMap<Integer, LinkedHashMap<String, String>> hashedDataSet = new HashMap<Integer, LinkedHashMap<String, String>>();
	
	public Object[][] getDataSetAsObjectArray(String excelPath, String sheetName, String testCaseName) {
		HashMap<Integer, LinkedHashMap<String, String>> hashDataSet = makeTestData(excelPath, sheetName, testCaseName);
		Object[][] objArray = new Object[hashDataSet.size()][1];
		for(int i = 0; i < hashDataSet.size(); i++) {
			objArray[i][0] = getData(hashDataSet, i);
		}
		return objArray;
	}
	
	public HashMap<Integer, LinkedHashMap<String, String>> makeTestData(String excelPath, String sheetName, String testCaseName){
		XSSFSheet sheet = null;
		FetchExcelDataSet fetchDataSet = new FetchExcelDataSet();
		try {
			FileInputStream inputStream = new FileInputStream(excelPath);
			XSSFWorkbook book = new XSSFWorkbook(inputStream);
			sheet = book.getSheet(sheetName);
			int numRows = sheet.getLastRowNum();
			int columnIndex = -1;
			for(int count = 0; count < sheet.getRow(0).getLastCellNum(); count++) {
				if(sheet.getRow(0).getCell(count).getStringCellValue().equalsIgnoreCase("TestCaseName")) {
					columnIndex = count;
					break;
				}
			}
			
			for(int rowNum = 1, rowIndex = 1; rowNum <=numRows; rowNum++) {
				if(sheet.getRow(rowNum).getCell(columnIndex).getStringCellValue().equalsIgnoreCase(testCaseName)) {
					hashedDataSet.put(rowIndex - 1, fetchDataSet.getRowData(sheet, rowNum));
					rowIndex++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashedDataSet;
	}
	
	public LinkedHashMap<String, String> getRowData(XSSFSheet sheet, int rowNum){
		LinkedHashMap<String, String> hashRowData = new LinkedHashMap<String, String>();
		XSSFRow rowHeader = sheet.getRow(0);
		XSSFRow row = sheet.getRow(rowNum);
		int totalInputValues = row.getLastCellNum();
		for(int colNum = 0; colNum < totalInputValues; colNum++) {
			XSSFCell cellHeader = rowHeader.getCell(colNum);
			XSSFCell cell = row.getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell.setCellType(CellType.STRING);
			String cellValue = cell.getStringCellValue();
			hashRowData.put(cellHeader.getStringCellValue(), cellValue);
		}
		return hashRowData;
	}
	
	public LinkedHashMap<String, String> getData(HashMap<Integer, LinkedHashMap<String, String>> hashMap, int rowNum){
		LinkedHashMap<String, String> hashData = null;
		hashData = hashMap.get(rowNum);
		return hashData;
	}
	
	public void reportLog(String srcFileName, String reportName, String extention) {
		File srcFile = new File(System.getProperty("user.dir") +"\\src\\main\\resources\\excelfiles\\"+ srcFileName + "." +extention);
		String destDir = "reportlog";
		new File(destDir).mkdirs();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		String destFile = reportName+" - "+dateFormat.format(new Date())+"."+extention;
		File destination = new File(destDir+"/"+destFile);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
