package com.Helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public ExcelDataConfig(String excelPath) {
		try {
			File src = new File(excelPath);
			//"C:\\Users\\Aravind Raj\\Documents\\TestData.xlsx"
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNum, int row, int col) {
		sheet1=wb.getSheetAt(sheetNum);
		String data=sheet1.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
}
