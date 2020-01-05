package com.cogmento.ui.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cogmento.ui.base.TestBase;

		public class ExcelUtilities extends TestBase {
		private static Sheet ExcelWorkSheet;
		private static Workbook ExcelWorkBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		
		public static final String Path_TestData = "D:\\Users\\mnoum\\Documents\\GitHub"
				+ "\\uicogmentopom"
				+ "\\src\\main\\java\\com\\cogmento\\ui\\data\\TestData.xlsx";
	    public static final String File_TestData = "TestData.xlsx";

	/*
	 * //This method is to set the File path and //to open the Excel file, Pass
	 * Excel Path and SheetName as Arguments to this method
	 * 
	 * public static void setExcelFile(String Path_TestData,String File_TestData)
	 * throws Exception {
	 * 
	 * try {
	 * 
	 * // Open the Excel file FileInputStream ExcelFile = new
	 * FileInputStream(Path_TestData);
	 * 
	 * // Access the required test data sheet ExcelWorkBook = new
	 * XSSFWorkbook(ExcelFile); ExcelWorkSheet =
	 * ExcelWorkBook.getSheet(File_TestData);
	 * 
	 * } catch (Exception e){ throw (e); } }
	 * 
	 * //This method is to read the test data from the Excel cell, //in this we are
	 * passing parameters as Row num and Col num public static String
	 * getCellData(int RowNum, int ColNum) throws Exception{
	 * 
	 * try{
	 * 
	 * Cell = ExcelWorkSheet.getRow(RowNum).getCell(ColNum); String CellData =
	 * Cell.getStringCellValue(); return CellData;
	 * 
	 * }catch (Exception e){ return""; } }
	 * 
	 * //This method is to write in the Excel cell, Row num and Col num are the
	 * parameters public static void setCellData(String Result, int RowNum, int
	 * ColNum) throws Exception {
	 * 
	 * try{
	 * 
	 * Row = ExcelWorkSheet.getRow(RowNum); // Cell = Row.getCell(ColNum,
	 * Row.RETURN_BLANK_AS_NULL);//it has error Cell = Row.getCell(ColNum, null); if
	 * (Cell == null) { Cell = Row.createCell(ColNum); Cell.setCellValue(Result); }
	 * else { Cell.setCellValue(Result); }
	 * 
	 * // Constant variables Test Data path and Test Data file name FileOutputStream
	 * fileOut = new FileOutputStream(Path_TestData + File_TestData);
	 * ExcelWorkBook.write(fileOut); fileOut.flush(); fileOut.close();
	 * }catch(Exception e){ throw (e); } }
	 */
	    public static Object[][] getTestData(String sheetName) {
			FileInputStream file=null ;
			try {
				file = new FileInputStream(Path_TestData);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				ExcelWorkBook = WorkbookFactory.create(file);
		} /*
			 * catch (InvalidFormatException e) { e.printStackTrace(); }
			 */ catch (IOException e) {
				e.printStackTrace();
			}
			ExcelWorkSheet = ExcelWorkBook.getSheet(sheetName);
			Object[][] data = new Object[ExcelWorkSheet.getLastRowNum()][ExcelWorkSheet.getRow(0).getLastCellNum()];
			 System.out.println("Excel LastRow:::LastColumn"+ExcelWorkSheet.getLastRowNum() + "--------" +ExcelWorkSheet.getRow(0).getLastCellNum());
			for (int i = 1; i < ExcelWorkSheet.getLastRowNum(); i++) {///for row
				for (int k = 0; k < ExcelWorkSheet.getRow(0).getLastCellNum(); k++) {////for columns
					data[i][k] = ExcelWorkSheet.getRow(i + 1).getCell(k).toString();///row is i+1 because ith Row is Headings Row
					 System.out.println(data[i][k]);
				}
			}
			return data;
		}
}//ending class
