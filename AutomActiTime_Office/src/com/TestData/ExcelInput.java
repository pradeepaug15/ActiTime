package com.TestData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelInput {

	public String getExcelInput(String SheetNum, int rowNum, int colNum ) throws InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream("F:\\Selenium Materials\\Study Materials\\workspace\\workspace\\AutomActiTime_Office\\TestData\\Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetNum);
		String getData = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		return getData;
	}
	public int getRowCount(String SheetNum) throws InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("F:\\Selenium Materials\\Study Materials\\workspace\\workspace\\AutomActiTime_Office\\TestData\\Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetNum);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}	
	public int getCellCount(String SheetNum) throws InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("F:\\Selenium Materials\\Study Materials\\workspace\\workspace\\AutomActiTime_Office\\TestData\\Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetNum);
		Row r = sh.getRow(0);
		int cellCount = r.getLastCellNum();
		return cellCount;
	}
}
