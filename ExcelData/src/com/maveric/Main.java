package com.maveric;



import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Main {
	public static void main(String[] args) throws IOException {
		int num=0; Row rowObj;Cell cellObj;
		Workbook workBookObj1=ExcelUtill.getWorkBookobj("ExcelBook/DWH.xlsx");
	      Sheet sheetObj1= workBookObj1.getSheet("Sheet1");
	      int cellNum=ExcelUtill.getColumnNumbycolunmName(sheetObj1, "Calumn_name");
	      int cellNum1=ExcelUtill.getColumnNumbycolunmName(sheetObj1, "StringNum");
		    
	     int lastRowNum=sheetObj1.getLastRowNum();
	     
	for (int j = 1; j <= lastRowNum; j++) {
		
	    String calumnName = sheetObj1.getRow(j).getCell(cellNum).getStringCellValue();
       System.out.println(calumnName);
       
      Workbook workBookObj2=ExcelUtill.getWorkBookobj("ExcelBook/RC+.xlsx");
	      Sheet sheetObj2= workBookObj2.getSheet("Sheet1");
	      
	      for (int i = j; i <=j; i++) {
	    	  rowObj = sheetObj1.getRow(i);
	    	cellObj  =rowObj .getCell(cellNum1);
	    
		    	 String calNumForValChar = cellObj.getStringCellValue();
		          num =getNumFromString(calNumForValChar);
		          ExcelUtill.getStatusOfColumnByclumnName(sheetObj2, calumnName, num);

		     }
  		System.out.println();

		 
	}
	}
	
public static int getNumFromString(String str) {
	String strNum=str.replaceAll("[^0-9]", "");
	int num=Integer.parseInt(strNum);
	return num;
}
   
}
