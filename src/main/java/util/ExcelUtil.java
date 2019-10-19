package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static String TEST_DATA_PATH="C:\\Users\\skhareed.ORADEV\\eclipse-workspace\\HubSpotApplication\\src\\main\\java\\testData\\HubSpotTestData.xlsx";
	static Workbook workbook;
	static Sheet sheet;
	
	public static Object[][] getDataFromSheet(String sheetName)
	{
		int rows,columns;
		
		try {
			FileInputStream fis=new FileInputStream(TEST_DATA_PATH);
			workbook = WorkbookFactory.create(fis);
			sheet=workbook.getSheet(sheetName);
			rows=sheet.getLastRowNum();
			columns=sheet.getRow(0).getLastCellNum();
			System.out.println("Rows: "+rows);
			System.out.println("Columns: "+columns);
			Object data[][]=new Object[rows][columns];

			for(int i=0;i<rows;i++)
				for(int j=0;j<columns;j++)
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					System.out.println("data["+(i)+"]["+j+"] = "+data[i][j]);
				}
			
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
