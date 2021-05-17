package vtiger.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains methods to read and write data to the excel sheet.
 * @author Satyajit
 *
 */

public class ExcelUtility {
	
	/**
	 * This method returns Data from excelSheet 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return Data from cell
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheet,int row,int cell) throws Throwable
	{	
	FileInputStream fis=new FileInputStream(IPathConstant.EXCELFILE_PATH);
	Workbook wb = WorkbookFactory.create(fis);
	return wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
}
	/**
	 * This method return all the data in the sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELFILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		Object [][] ob=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				ob[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return ob;
	}

	public String getExcelData(String sheetName,String tcId,String headerName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELFILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int expectedRow = 0;
		for(int i=0;i<lastRow;i++)
		{
			String testCaseId = sheet.getRow(i).getCell(0).getStringCellValue();
			if(tcId.equalsIgnoreCase(testCaseId))
			{
				expectedRow=i;
				break;
			}
		}
		expectedRow--;
		int expectedCell = 0;
		short lastCell = sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0;j<lastCell;j++)
		{
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerName))
			{
				expectedCell=j;
				break;
			}
		}
		return sheet.getRow(expectedRow).getCell(expectedCell).getStringCellValue();
	}
	/**
	 * this method used to write data inside the excel sheet.
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeDataToExcel(String sheetName,int row,int cell,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELFILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fo=new FileOutputStream(IPathConstant.EXCELFILE_PATH);
		wb.write(fo);
		
	}
	
	
}
