package weightreporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WeightSheet 
{
	/**
	 * Default Constructor
	 */
	public WeightSheet() 
	{
		
	}
	
	public void outputExcel (Double weight) throws IOException 
	{
		
		String excelFilePath = "C:/Users/cguil/Documents/WeightSheet.xlsx";
        
        try 
        {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            int rowCount = sheet.getLastRowNum();
            
            Row row = sheet.createRow(++rowCount);
            
            int columnCount = 0;
             
            Cell cell = row.createCell(columnCount);
            cell.setCellValue(rowCount);
            
            cell = row.createCell(++columnCount);
            cell.setCellValue(weight);
            
            cell = row.createCell(++columnCount);
            LocalDate ldt = LocalDate.now();
            String timeStamp = ldt.toString();
            cell.setCellValue(timeStamp);
 
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("C:/Users/cguil/Documents/WeightSheet.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } 
        catch (IOException | EncryptedDocumentException ex) 
        {
            ex.printStackTrace();
        }
	}
}
