package com.evs.qacodes.webutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	/**
	 * This method is to create the object of the Excel sheet from which we want to
	 * read the TestData.getObject().
	 * 
	 * @param dataSheetPath This is the location where we have kept the Excel sheet
	 *                      file.
	 * @return It will return a Workbook object which has reference to the excel
	 *         sheet.
	 * @throws IOException If file is not found then we will get this exception.
	 */
	
	public Workbook getDataBook(String dataSheetPath) {
	
	
	Workbook workbook = null;
		File xlFile = new File(dataSheetPath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(xlFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] arrPath = dataSheetPath.split("\\.");
		String fileExt = arrPath[1];
		if ("xlsx".equalsIgnoreCase(fileExt)) {
			try {
				workbook = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				workbook = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return workbook;
	}

	/**
	 * This method is to get the individual work sheet from the workbook.
	 * 
	 * @param workBook  Need to provide the workbook object which we have generated
	 *                  from the getDataBook function.
	 * @param sheetName Name of the sheet which you want to read from the workbook.
	 * @return it will return the sheet object with all rows and columns.
	 */
	public Sheet getDataSheet(Workbook workBook, String sheetName) {
		Sheet sheet = null;
		sheet = workBook.getSheet(sheetName);
		return sheet;
	}

	public String getCellData(Row dataRow, int cellNum) {
		DataFormatter df = new DataFormatter();
		Cell curCell = dataRow.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		return df.formatCellValue(curCell);

	}

	/**
	 * This method is used to get the column number by providing the Column Name,
	 * because POI utility always looks for number, so we need the column number to
	 * get the TestData.getObject().
	 * 
	 * @param sheet      Sheet object which has the TestData.getObject().
	 * @param columnName Column name for which we need the column number.
	 * @return It will return integer value.
	 */
	public int getColumnNumberByColumnName(Sheet sheet, String columnName) {
		Row firstRowColumns = sheet.getRow(0);
		int columnNumber = -1;
		int columnCount = firstRowColumns.getLastCellNum();
		for (int i = 0; i <= columnCount - 1; i++) {
			if (firstRowColumns.getCell(i).getStringCellValue().toLowerCase().contains(columnName.toLowerCase())) {
				columnNumber = i;
				break;
			}
		}
		return columnNumber;
	}

	/**
	 * This method is to get the Row number for the provided Row ID.
	 * 
	 * @param sheet      Sheet object from which we want to have the row number.
	 * @param columnName Name of the column to determine the Cell value.
	 * @param rowID      Actual Row value for which we need the Row number.
	 * @return It will return the integer value.
	 */
	public int getRowNumberByRowID(Sheet sheet, String rowID, String columnName) {
		int rowCount = sheet.getLastRowNum();
		int columnNumber = getColumnNumberByColumnName(sheet, columnName);
		int rowNumber = -1;
		for (int i = 1; i <= rowCount; i++) {
			Cell cell = sheet.getRow(i).getCell(columnNumber);
			if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowID)) {
				rowNumber = i;
				break;
			}
		}
		return rowNumber;
	}

	/*
	 * below method is actually returning multiple row numbers of testcase with same
	 * testcase id in a List this method is being called in getTestDataRowsList
	 * method of TestData.java class
	 */
	public List<Integer> getRowNumbersListByRowID(Sheet sheet, String columnName, String rowID) {
		List<Integer> listData = new ArrayList<Integer>();
		int rowCount = sheet.getLastRowNum();
		int columnNumber = getColumnNumberByColumnName(sheet, columnName);
		for (int i = 1; i <= rowCount; i++) {
			Cell cell = sheet.getRow(i).getCell(columnNumber);
			if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowID)) {
				listData.add(i);

			}
		}
		return listData;
	}

	

	public Map<String, String> getTestCaseData(String testMethodName) {
		Workbook wbook = getDataBook("src//test//resources//TestData.xlsx");
		Sheet sheetobj = getDataSheet(wbook, "DataSheet");
		int rowNum = getRowNumberByRowID(sheetobj, testMethodName, "TestCaseMethodName");

		Map<String, String> mapObj = new HashedMap<String, String>();
		int startColmNum=getColumnNumberByColumnName(sheetobj, "Dataname1");
		Row datarowobj = sheetobj.getRow(rowNum);
		int coloumNum = datarowobj.getLastCellNum();
		for (int i = startColmNum; i <= coloumNum - 1; i = i + 2) {
			String cellDataName =getCellData(datarowobj, i);
			if(cellDataName.trim().equals("")) {
				break;
			}
			String cellDataValue = datarowobj.getCell(i + 1).getStringCellValue();
			mapObj.put(cellDataName, cellDataValue);
		}
		return mapObj;

	}

	
	
	public Map<String,String> pgWiseData=new HashMap<String,  String>();
	public void getPageWiseData(String sheetname,String RowId) {
		 
		String path="src//test//resources//Book1.xlsx";
	Workbook wbook = getDataBook(path);
	Sheet sheetObj = getDataSheet(wbook, sheetname);
	int dataRowNum=getRowNumberByRowID(sheetObj, RowId, "DataId");
	int startDataColoumnumber=getColumnNumberByColumnName(sheetObj, "DataId")+1;
	Row fstRow=sheetObj.getRow(0);
	Row datarow=sheetObj.getRow(dataRowNum);
	int coloumCount=fstRow.getLastCellNum();
	
	
	for(int i=startDataColoumnumber; i<=coloumCount-1; i++) {
		
		String columName=getCellData(fstRow, i);
		String dataValue=getCellData(datarow, i);
		pgWiseData.put(columName, dataValue);
		
	}
		
	}
}
