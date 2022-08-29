package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public static String getData(String sheetName, int row, int cell) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bhushan.kshirsagar\\eclipse-workspace\\KiteZeroda\\src\\test\\resources\\TestData.xlsx");
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public static double getNumericData(String sheetName, int row, int cell) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\bhushan.kshirsagar\\eclipse-workspace\\KiteZeroda\\src\\test\\resources\\TestData.xlsx");
		double value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		return value;
}}