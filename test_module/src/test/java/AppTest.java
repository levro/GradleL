import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    private static final String XLS_FILE = "test_file.xls";

    @Test
    public void testAppendToXls() throws IOException {
        String[] xlsRecords = new String[]{"ABCDEF"};
        FileOperations.appendXLS(xlsRecords, XLS_FILE);
        List<Object[]> objects = FileOperations.readXLS(XLS_FILE);
        assertEquals(xlsRecords[xlsRecords.length - 1], objects.get(objects.size() - 1)[0]);
    }

    @Test
    public void testWriteToXls() throws IOException {
        String[] xlsRecords = {"Test1", "100", ""};
        FileOperations.writeXLS(xlsRecords, XLS_FILE );
        List<Object[]> objects = FileOperations.readXLS(XLS_FILE);
        int recordsAmount = xlsRecords.length;
        for (int i = 0; i < recordsAmount; i++) {
            assertEquals(xlsRecords[recordsAmount - 1], objects.get(recordsAmount - 1)[0]);
        }
    }

/*    @Test public void testSumStrings() {
        Utils classUnderTest = new FileOperations();
        assertEquals( "150", classUnderTest.sumOfTwoStrings( "100", "50") );
    }

    @Test public void testSumStringsNeg() {
        Utils classUnderTest = new Utils();
        assertEquals( "0", classUnderTest.sumOfTwoStrings( "seven", "50") );
    }*/
}
