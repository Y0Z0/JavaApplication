import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("Sheet1");
      Row row = sheet.createRow(0);
      Cell cell1 = row.createCell(0);
      cell1.setCellValue("Name");
      try (FileOutputStream fos = new FileOutputStream("example.xlsx")) {
          workbook.write(fos);
          System.out.println("Excel file has been written successfully.");
      } catch (IOException e) {
          e.printStackTrace();
      }
      try {
          workbook.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
