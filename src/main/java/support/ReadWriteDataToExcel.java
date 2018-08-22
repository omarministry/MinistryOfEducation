package support;

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

public class ReadWriteDataToExcel {

	public void writeExcel(String filePath, String fileName, String sheetName, int data) throws IOException {
		//create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		
		//create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook workbook = null;
		
		String fileExtension = fileName.substring(fileName.indexOf("."));
		if (fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}else if (fileExtension.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}
		
		//create an object of sheet by sheetName
		Sheet sheet = workbook.getSheet(sheetName);
		
		//create a new row and append it at the last of sheet
		int lastRow = sheet.getLastRowNum();

		Row row = sheet.getRow(lastRow);
		if(row != null) {
			Row newRow = sheet.createRow(lastRow + 1);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue(data);
		}else {
			Row newRow = sheet.createRow(lastRow);
			Cell newCell = newRow.createCell(0);
			newCell.setCellValue(data);
		}

			
		
//		Row newRow = sheet.createRow(lastRow);
//		Cell newCell = newRow.createCell(0);
//		newCell.setCellValue(data);
		
		//close input stream
		inputStream.close();
		
		//create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);
		
		//write data in the excel file
		workbook.write(outputStream);
		outputStream.close();
	}
	
	public int readExcel(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		
		String fileExtension = fileName.substring(fileName.indexOf("."));
		if(fileExtension.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}else if(fileExtension.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}
		
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		Row row = sheet.getRow(lastRowNum);
		Cell cell = row.getCell(0);
//		String cellValue = cell.getStringCellValue();
		int cellValue = (int)(cell.getNumericCellValue());

		return cellValue;
	}
}
