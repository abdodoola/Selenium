import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		ArrayList<String> dataInSheet = new ArrayList<String>();
		int numberOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i); // Identify Test cases column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows

				while (rows.hasNext()) {
					Row firstrow = rows.next();
					Iterator<Cell> cell = firstrow.cellIterator();// row is collection of cells

					while (cell.hasNext()) {

						Cell value = cell.next();
						if(value.getCellType()==CellType.STRING)
						{
							String a = value.getStringCellValue();
							System.out.println(a);
						//a.add(c.getStringCellValue());
						}
						else if(value.getCellType()==CellType.NUMERIC){

						//a.add(NumberToTextConverter.toText(value.getNumericCellValue()));
							String a = NumberToTextConverter.toText(value.getNumericCellValue());
							System.out.println(a);
						}
					}
				}
			}
		}
	}
}
