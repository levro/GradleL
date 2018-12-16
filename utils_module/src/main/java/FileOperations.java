import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;
import java.util.Iterator;

public class FileOperations {

    public static void writeXLS (String[] records, String fileName) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Records");

        for (int i = 0; i < records.length; i++) {
            Row row = sheet.createRow(i);
            Cell name = row.createCell(0);
            name.setCellValue(records[i]);

            Cell time = row.createCell(1);
            DataFormat format = book.createDataFormat();
            CellStyle dateStyle = book.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy HH:MM:SS"));
            time.setCellStyle(dateStyle);
            time.setCellValue(new Date());

            sheet.autoSizeColumn(1);
        }
        book.write(new FileOutputStream(fileName));
        book.close();
    }

    public static void readXLS(String fileName) throws IOException{

        FileInputStream excelInputStream = new FileInputStream(new File(fileName));
        Workbook workbook = new HSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator < Row > rowItr = sheet.iterator();
        int rowNum = 0;
        while (rowItr.hasNext()) {
            Row row = rowItr.next();
            Iterator < Cell > cellItr = row.iterator();
            System.out.print(rowNum + ". ");
            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t\t");
                } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue() + "\t\t");
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                }
            }
            System.out.println();
            rowNum++;
        }
        workbook.close();
        excelInputStream.close();
    }
}
