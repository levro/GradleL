import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FileOpsTestCase {
    private static final String XLS_FILE = "test_file.xls";

    @Test
    public void testAppendToXls() {
        String[] xlsRecords = new String[]{"ABCDEFGH"};
        FileOperations.appendXLS(xlsRecords, XLS_FILE);
        List<Object[]> objects = FileOperations.readXLS(XLS_FILE);
        assertEquals(xlsRecords[xlsRecords.length - 1], objects.get(objects.size() - 1)[0]);
    }

    @Test
    public void testWriteToXls() {
        String[] xlsRecords = {"Test1", "100", ""};
        FileOperations.writeXLS(xlsRecords, XLS_FILE );
        List<Object[]> objects = FileOperations.readXLS(XLS_FILE);
        int recordsAmount = xlsRecords.length;
        for (int i = 0; i < recordsAmount; i++) {
            assertEquals(xlsRecords[recordsAmount - 1], objects.get(recordsAmount - 1)[0]);
        }
    }
}
