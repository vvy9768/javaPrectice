package com.maveric;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
public static void main(String[] args) throws IOException {
	
	 
	//  String[] valueToWrite = {"Mr. E","Noida","add"};

      //Create an object of current class

  //  writeExcel("ExcelBook/aaa.xlsx","Sheet1",valueToWrite);

	
}



    public static void writeExcel(String filePath,String sheetName,String dataToWrite) throws IOException{

        //Create an object of File class to open xlsx file

        File file =    new File(filePath);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workBookObj = null;

        String []   filePathArr= filePath.split("\\.");
   	 String extension= filePathArr[1];
   	 if(extension.equalsIgnoreCase("xlsx")){
   		workBookObj=new XSSFWorkbook(inputStream);
   	 }else {
   		workBookObj=new HSSFWorkbook(inputStream);
   	 }

    //Read excel sheet by sheet name    

    Sheet sheet = workBookObj.getSheet(sheetName);

    //Get the current count of rows in excel file

    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Get the first row from the sheet

    Row row = sheet.getRow(0);

    //Create a new row and append it at last of sheet
for (int i = 0; i <3; i++) {
	

    Row newRow = sheet.createRow(i);

    //Create a loop over the cell of newly created Row

        Cell cell = newRow.createCell(rowCount);

        cell.setCellValue(dataToWrite);
   System.out.print(" "+dataToWrite);
}  
    

    //Close input stream

    inputStream.close();

    //Create an object of FileOutputStream class to create write data in excel file

    FileOutputStream outputStream = new FileOutputStream(file);

    //write data in the excel file

    workBookObj.write(outputStream);

    //close output stream

    outputStream.close();
	
    }



}

  

