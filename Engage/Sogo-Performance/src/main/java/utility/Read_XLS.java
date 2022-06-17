package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Read_XLS {

	public String fileLocation = null;
	public FileInputStream fip = null;
	public FileOutputStream fop = null;
	public XSSFWorkbook book = null;
	public XSSFSheet sheet = null;
	public WebDriver driver;
	
	public Read_XLS(String fileLocation) {
		this.fileLocation = fileLocation;
		try {
			// Set MinInflateRatio to 0 to avoid zip bomb error
			ZipSecureFile.setMinInflateRatio(0);
			fip = new FileInputStream(fileLocation);
			book = new XSSFWorkbook(fip);
			sheet = book.getSheetAt(0);
			fip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String createPlatformreading(String fileName, String sheetName, String extension) {
		String filePath = System.getProperty("user.dir") + "\\PlatformReadings\\";
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet(sheetName);
		OutputStream fileOut;
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		File theDir = new File(filePath);  // Create folder if not exists

		if (!theDir.exists()) {
			theDir.mkdir();
		}
		
		filePath = filePath + fileName + " - " + dateFormat.format(new Date())+"." +extension;
		try {
			fileOut = new FileOutputStream(new File(filePath));
			wb.write(fileOut);
			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	public HashMap<String, String> getEnvURL(String wsName) {
		try {
			int rowNum = retrieveNoOfRows(wsName);
			HashMap<String, String> URLLIST = new HashMap<String, String>();
			for(int i = 0; i < rowNum; i++) {
				XSSFRow row = sheet.getRow(i);
				if(row.getCell(2).getStringCellValue().equalsIgnoreCase("Y")) {
					URLLIST.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
				}
			}
			return URLLIST;
		} catch (Exception e) {
			return null;
		}
	}
	
	public int retrieveNoOfRows(String wsName) {
		int sheetIndex = book.getSheetIndex(wsName);
		if(sheetIndex == -1) {
			return 0;
		} else {
			sheet = book.getSheetAt(sheetIndex);
			int rowCount = sheet.getLastRowNum() + 1;
			return rowCount;
		}
	}
	
	public int retrieveNoOfCols(String wsName) {
		int sheetIndex = book.getSheetIndex(wsName);
		if(sheetIndex == -1) {
			return 0;
		} else {
			sheet = book.getSheetAt(sheetIndex);
			int colCount = sheet.getRow(0).getLastCellNum();
			return colCount;
		}
	}
	
	public ArrayList<HashMap<String, String>> getLoginCredentials(String sheetName, String role){
		int rowNum = retrieveNoOfRows(sheetName);
		ArrayList<HashMap<String, String>> credentials = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> users = new HashMap<String, String>();
		for(int i = 0; i < rowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(role)) {
				if(row.getCell(3).getStringCellValue().equalsIgnoreCase("Y")) {
					users.put("username", row.getCell(1).getStringCellValue());
					users.put("password", row.getCell(2).getStringCellValue());
					credentials.add(users);
				}
			}
		}
		return credentials;
	}
	
	public boolean writeFailureReasons(String sheetName, String colName, ArrayList<String> failureReasons) {
		String failureReason, TestCaseName;
		int rowNumber = 0;
		int sheetIndex = book.getSheetIndex(sheetName);
		if(sheetIndex == -1) 
			return false;
		int colNum = retrieveNoOfCols(sheetName);
		int colNumber = -1;
		int rowNum = retrieveNoOfRows(sheetName);
		XSSFSheet sheet = book.getSheetAt(sheetIndex);
		XSSFCellStyle linkStyle = book.createCellStyle();
		XSSFFont linkFont = book.createFont();
		linkFont .setUnderline(XSSFFont.U_SINGLE);
		linkFont.setColor(IndexedColors.BLUE.getIndex());
		linkStyle.setFont(linkFont);
		try {
			for(int j = 0; j <failureReasons.size(); j++) {
				String[] temp = failureReasons.get(j).split("\\|");
				TestCaseName = temp[0];
				failureReason = temp[1];
				for(int i = 0; i < rowNum; i++) {
					XSSFRow suiteRow = sheet.getRow(i);
					if(suiteRow.getCell(0).getStringCellValue().equals(TestCaseName)) {
						rowNumber = i;
						break;
					}
				}
				
				XSSFRow suiteRow = sheet.getRow(0);
				for(int i = 0; i < colNum; i++) {
					if(suiteRow.getCell(i).getStringCellValue().equals(colName.trim())) {
						colNumber = i;
						break;
					}
				}
				if(colNumber == -1)
					return false;
				
				XSSFRow row = sheet.getRow(rowNumber);
				XSSFCell cell = row.getCell(colNumber);
				if(cell == null)
					cell = row.createCell(colNumber);
				
				cell.setCellValue(failureReason);
			}
			
			fop = new FileOutputStream(fileLocation);
			book.write(fop);
			fop.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean writeResult(String sheetName, String colName, HashMap<String, String> TestResultTL) {
		String Result = null;
		int rowNumber = 0;
		try {
			int sheetIndex = book.getSheetIndex(sheetName);
			if(sheetIndex == -1)
				return false;
			int colNum = retrieveNoOfCols(sheetName);
			int colNumber = -1;
			int rowNum = retrieveNoOfRows(sheetName);
			
			XSSFCellStyle stylePass = book.createCellStyle();
			stylePass.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			stylePass.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			XSSFFont font = book.createFont();
			font.setColor(IndexedColors.BLACK.getIndex());
			stylePass.setFont(font);
			
			XSSFCellStyle styleFail = book.createCellStyle();
			styleFail.setFillForegroundColor(IndexedColors.RED.getIndex());
			styleFail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setColor(IndexedColors.BLACK.getIndex());
			styleFail.setFont(font);
			
			XSSFCellStyle styleSkip = book.createCellStyle();
			styleSkip.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			styleSkip.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			font.setColor(IndexedColors.BLACK.getIndex());
			styleSkip.setFont(font);
			
			for(String testCaseName : TestResultTL.keySet()) {
				if(TestResultTL.get(testCaseName).equalsIgnoreCase("PASS")) {
					Result = "PASS";
				} else if(TestResultTL.get(testCaseName).equalsIgnoreCase("FAIL")) {
					Result = "FAIL";
				} else if(TestResultTL.get(testCaseName).equalsIgnoreCase("SKIP")) {
					Result = "SKIP";
				}
				
				for (int i = 0; i < rowNum; i++) {
					XSSFRow suiteRow = sheet.getRow(i);
					if(suiteRow.getCell(0).getStringCellValue().equals(testCaseName)){
						rowNumber = i;
					}
				}
				XSSFRow suiteRow = sheet.getRow(0);
				for (int i = 0; i < colNum; i++) {
					if(suiteRow.getCell(i).getStringCellValue().equals(colName.trim())){
						colNumber = i;
					}
				}
				
				if(colNumber == -1) {
					return false;
				}
				XSSFRow row = sheet.getRow(rowNumber);
				XSSFCell cell = row.getCell(colNumber);
				if (cell == null)
					cell = row.createCell(colNumber);
				
				cell.setCellValue(Result);
				
				if(Result.equalsIgnoreCase("PASS")) {
					cell.setCellStyle(stylePass);
				} else if(Result.equalsIgnoreCase("FAIL")) {
					cell.setCellStyle(styleFail);
				} else if(Result.equalsIgnoreCase("SKIP")) {
					cell.setCellStyle(styleSkip);
				}
			}
			fop = new FileOutputStream(fileLocation);
			book.write(fop);
			fop.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean writeResultPerformance(String sheetName, String colName, HashMap<String, String> TestResultTL) {
		String Result = null;
		int rowNumber = 0;
		try {
			int sheetIndex = book.getSheetIndex(sheetName);
			if(sheetIndex == -1)
				return false;
			int colNum = retrieveNoOfCols(sheetName);
			int colNumber = -1;
			int rowNum = retrieveNoOfRows(sheetName);
			
			/*
			 * XSSFCellStyle stylePass = book.createCellStyle();
			 * stylePass.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			 * stylePass.setFillPattern(FillPatternType.SOLID_FOREGROUND); XSSFFont font =
			 * book.createFont(); font.setColor(IndexedColors.BLACK.getIndex());
			 * stylePass.setFont(font);
			 * 
			 * XSSFCellStyle styleFail = book.createCellStyle();
			 * styleFail.setFillForegroundColor(IndexedColors.RED.getIndex());
			 * styleFail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			 * font.setColor(IndexedColors.BLACK.getIndex()); styleFail.setFont(font);
			 * 
			 * XSSFCellStyle styleSkip = book.createCellStyle();
			 * styleSkip.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			 * styleSkip.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			 * font.setColor(IndexedColors.BLACK.getIndex()); styleSkip.setFont(font);
			 */
			
			for(String testCaseName : TestResultTL.keySet()) {
				Result = TestResultTL.get(testCaseName);
				
				
				for (int i = 0; i < rowNum; i++) {
					XSSFRow suiteRow = sheet.getRow(i);
					if(suiteRow.getCell(0).getStringCellValue().equals(testCaseName)){
						rowNumber = i;
					}
				}
				XSSFRow suiteRow = sheet.getRow(0);
				for (int i = 0; i < colNum; i++) {
					if(suiteRow.getCell(i).getStringCellValue().equals(colName.trim())){
						colNumber = i;
					}
				}
				
				if(colNumber == -1) {
					return false;
				}
				XSSFRow row = sheet.getRow(rowNumber);
				XSSFCell cell = row.getCell(colNumber);
				if (cell == null)
					cell = row.createCell(colNumber);
				
				cell.setCellValue(Result);
				
				/*
				 * if(Result.equalsIgnoreCase("PASS")) { cell.setCellStyle(stylePass); } else
				 * if(Result.equalsIgnoreCase("FAIL")) { cell.setCellStyle(styleFail); } else
				 * if(Result.equalsIgnoreCase("SKIP")) { cell.setCellStyle(styleSkip); }
				 */
			}
			fop = new FileOutputStream(fileLocation);
			book.write(fop);
			fop.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean writePlatformReadings(String sheetName, ITestResult TestResultTL, Map<String,String> readingData) {
		int colNumber = 0;
		try {
			int sheetIndex = book.getSheetIndex(sheetName);
			if(sheetIndex == -1)
				return false;
			int rowNum = retrieveNoOfRows(sheetName);
			
			if(rowNum>1) 
				rowNum+=1;
			
			
			XSSFFont fontStatus = book.createFont();
			fontStatus.setColor(IndexedColors.BLACK.getIndex());
			
			XSSFFont fontReportName = book.createFont();
			fontReportName.setColor(IndexedColors.BLACK.getIndex());
			fontReportName.setBold(true);

			XSSFCellStyle stylePass = book.createCellStyle();
			stylePass.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			stylePass.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			stylePass.setFont(fontStatus);
			
			XSSFCellStyle styleFail = book.createCellStyle();
			styleFail.setFillForegroundColor(IndexedColors.RED.getIndex());
			styleFail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			styleFail.setFont(fontStatus);
			
			XSSFCellStyle styleSkip = book.createCellStyle();
			styleSkip.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			styleSkip.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			styleSkip.setFont(fontStatus);
			
			XSSFCellStyle styleReportName = book.createCellStyle();
			styleReportName.setBorderBottom(BorderStyle.THIN);
			styleReportName.setBorderTop(BorderStyle.THIN);
			styleReportName.setBorderLeft(BorderStyle.THIN);
			styleReportName.setBorderRight(BorderStyle.THIN);
			styleReportName.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			styleReportName.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			styleReportName.setFont(fontReportName);
			
			XSSFCellStyle stepsStyle = book.createCellStyle();
			stepsStyle.setBorderBottom(BorderStyle.THIN);
			stepsStyle.setBorderTop(BorderStyle.THIN);
			stepsStyle.setBorderLeft(BorderStyle.THIN);
			stepsStyle.setBorderRight(BorderStyle.THIN);
					
			String reportName = TestResultTL.getTestContext().getCurrentXmlTest().getParameter(TestResultTL.getName());

			String result = null;
			if (TestResultTL.getStatus() == 1) {
				result = "PASS";
			}else if(TestResultTL.getStatus() == 2) {
				result = "FAIL";
			}else {
				result = "SKIP";
			}
			XSSFRow row = sheet.createRow(rowNum);
			XSSFCell cell = row.createCell(colNumber);
			cell.setCellValue(reportName);
			cell.setCellStyle(styleReportName);
			if (result.equalsIgnoreCase("PASS")) {
				if (readingData.containsKey("Comment")) {
	
					XSSFComment comment = sheet.createDrawingPatriarch().createCellComment(new XSSFClientAnchor());
					comment.setString(readingData.get("Comment"));
					cell.setCellComment(comment);
					readingData.remove("Comment");
				}
			}
				cell = row.createCell(colNumber + 1);
				cell.setCellValue(result);
				
				if(result.equalsIgnoreCase("PASS")) {
					cell.setCellStyle(stylePass);
				} else if(result.equalsIgnoreCase("FAIL")) {
					cell.setCellStyle(styleFail);
				} else if(result.equalsIgnoreCase("SKIP")) {
					cell.setCellStyle(styleSkip);
				}
				
				if (result.equalsIgnoreCase("PASS")) {
					for (String key : readingData.keySet()) {
						rowNum = retrieveNoOfRows(sheetName);
						row = sheet.createRow(rowNum);
						cell = row.createCell(colNumber);
						cell.setCellValue(key);
						cell.setCellStyle(stepsStyle);
						sheet.autoSizeColumn(colNumber);
						cell = row.createCell(colNumber + 1);
						cell.setCellValue(readingData.get(key));
						cell.setCellStyle(stepsStyle);
					}
				}
			
			fop = new FileOutputStream(fileLocation);
			book.write(fop);
			fop.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
}
