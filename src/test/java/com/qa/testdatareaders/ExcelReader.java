package com.qa.testdatareaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private String filePath;
	
	public ExcelReader(String filePath) {
		this.filePath = filePath;
	}
	
	public List<String> getFieldsNamesfromExcel(String sheetname) throws IOException{
		
		List<String> fieldNames = new ArrayList<String>();
		
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int rows = sheet.getPhysicalNumberOfRows();
			for(int row = 1; row < rows ; row++) {
				fieldNames.add(sheet.getRow(row).getCell(0).getStringCellValue());
			}
			workbook.close();
			fis.close();
			
		}catch (Exception e) {
			
			System.err.println("An exception occured while reading the excel file: "+e.getMessage());
			e.printStackTrace();
		}		
		return fieldNames;
	}

}
