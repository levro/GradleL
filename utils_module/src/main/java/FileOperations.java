import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
        }
        book.write(new FileOutputStream(fileName));
        book.close();
    }

    public static List<Object[]> readXLS(String fileName) throws IOException{

        List<Object[]> result = new ArrayList<>();
        FileInputStream excelInputStream = new FileInputStream(new File(fileName));
        Workbook workbook = new HSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator <Row> rowItr = sheet.iterator();
        while (rowItr.hasNext()) {
            Row row = rowItr.next();
            List<String> currentRow = new ArrayList<>();
            Iterator <Cell> cellItr = row.iterator();
            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    currentRow.add(cell.getStringCellValue());
                } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    currentRow.add(cell.getDateCellValue().toString());
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    currentRow.add(String.valueOf(cell.getNumericCellValue()));
                }
            }
            result.add(currentRow.toArray());
        }
        workbook.close();
        excelInputStream.close();
        return result;
    }


    public static void appendXLS(String[] xlsRecords, String fileName) throws IOException {
        FileInputStream excelInputStream = new FileInputStream(new File(fileName));
        Workbook book = new HSSFWorkbook(excelInputStream);
        Sheet sheet = book.getSheetAt(0);
        int startRow = sheet.getLastRowNum() + 1;
        for (int i = 0; i < xlsRecords.length; i++) {
            Row row = sheet.createRow(i + startRow);
            Cell name = row.createCell(0);
            name.setCellValue(xlsRecords[i]);
            Cell time = row.createCell(1);
            DataFormat format = book.createDataFormat();
            CellStyle dateStyle = book.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy HH:MM:SS"));
            time.setCellStyle(dateStyle);
            time.setCellValue(new Date());
        }
        book.write(new FileOutputStream(fileName));
        book.close();
    }
}
