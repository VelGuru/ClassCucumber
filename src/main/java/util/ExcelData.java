package util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	/*public static String getCellValue(String sheetName, int row, int column) {
		String cellValue = "";
		try {

			FileInputStream fis = new FileInputStream(new File("D:\\Data.xlsx"));

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheet(sheetName);
			
			cellValue=sheet.getRow(row).getCell(column).toString();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return cellValue;
	}*/
}
