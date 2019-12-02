package com.cogmento.ui.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cogmento.ui.base.TestBase;

		public class ExcelUtilities extends TestBase {
		private static XSSFSheet ExcelWorkSheet;
		private static XSSFWorkbook ExcelWorkBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;

		//This method is to set the File path and 
		//to open the Excel file, Pass Excel Path and SheetName as Arguments to this method

		public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

				// Open the Excel file
				FileInputStream ExcelFile = new FileInputStream(Path);

				// Access the required test data sheet
				ExcelWorkBook = new XSSFWorkbook(ExcelFile);
				ExcelWorkSheet = ExcelWorkBook.getSheet(SheetName);

			} catch (Exception e){
			throw (e);
			}
          }

	//This method is to read the test data from the Excel cell, 
	//in this we are passing parameters as Row num and Col num
		public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{

				Cell = ExcelWorkSheet.getRow(RowNum).getCell(ColNum);
				String CellData = Cell.getStringCellValue();
				return CellData;

				}catch (Exception e){
				return"";
				}
			}
		
		//This method is to write in the Excel cell, Row num and Col num are the parameters
	     public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {
	 
	       try{
	 
	           Row  = ExcelWorkSheet.getRow(RowNum);
	           //Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);//it has error
	           Cell = Row.getCell(ColNum, null);
	           if (Cell == null) {
	        	   Cell = Row.createCell(ColNum);
	        	   Cell.setCellValue(Result);
	           } else {
	        	   Cell.setCellValue(Result);
	           }
	 
	          // Constant variables Test Data path and Test Data file name
	           FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
	           ExcelWorkBook.write(fileOut);
	           fileOut.flush();
	           fileOut.close();
	       		}catch(Exception e){
	       	     throw (e); 
	          }
	         }

}//ending class
