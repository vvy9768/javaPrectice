package com.maveric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtill {

	static Workbook wbook=null;
	public static Workbook getWorkBookobj(String filePath) throws IOException  {
	File fileObj=new File(filePath);
	InputStream isObj=new FileInputStream(fileObj);
	   String []   filePathArr= filePath.split("\\.");
	 String extension= filePathArr[1];
	 if(extension.equalsIgnoreCase("xlsx")){
	 wbook=new XSSFWorkbook(isObj);
	 }else {
	 wbook=new HSSFWorkbook(isObj);
	 }
	 return wbook;
	}

	public static String getStatusOfColumnByclumnName(Sheet sheetObj, String columnName, int num) throws IOException {
	String rowStringValue = null;String status = null;
	int columnNum=getColumnNumbycolunmName(sheetObj, columnName);
	int rowNum=1;
	for (int i = rowNum; i <= sheetObj.getLastRowNum(); i++) {
	Row rowObj=sheetObj.getRow(i);
	Cell cellObj=rowObj.getCell(columnNum,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
	rowStringValue=cellObj.getStringCellValue();
	
	//System.out.println(rowStringValue);
	     int strNum=rowStringValue.length();
	if(strNum<=num)
	{
	System.out.println("true ");
	 status="PASS";
   
	}else
	{
	System.out.println("false  "+rowStringValue);
	 status="Failed "+rowStringValue;
	
	}

	// WriteExcel.writeExcel("ExcelBook/RC+.xlsx", "Sheet1", status);
	}
	return status;
	         
	}



	protected  static int colunmNum=1;
	public static int getColumnNumbycolunmName(Sheet sheetObj,String columnName) {

	Row rowObj=sheetObj.getRow(0);
	int columnCount=rowObj.getLastCellNum();
	for (int i = 0; i<=columnCount; i++) {
	Cell cellObj=rowObj.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	String cellValue=cellObj.getStringCellValue();
	if (cellValue.equalsIgnoreCase(columnName)) {
	colunmNum=i;
	break;

	}
	}
	return colunmNum;
	}
	
}
