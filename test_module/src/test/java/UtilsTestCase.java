import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class UtilsTestCase {
    private final static Logger log = LogManager.getLogger( UtilsTestCase.class );

    @Test
    public void testSumStrings() {
        log.error( "TEST_01: testSumStrings" );
        assertEquals( "150", Utils.sumOfTwoStrings( "100", "50") );
    }

    @Test
    public void testSumStringsNeg() {
        log.error( "TEST_02: testSumStringsNeg" );
        assertEquals( "0", Utils.sumOfTwoStrings( "seven", "50") );
    }

    @Test
    public void testOOBException() {
        log.error( "TEST_05: testOOBException" );
        String[] arr = new String[]{ "uhb", "tfc"};
        int index = 4;
        try {
            Utils.getElementByIndex( arr, index );
        } catch ( ArrayIndexOutOfBoundsException e ) {
            assertEquals( "java.lang.ArrayIndexOutOfBoundsException: " + index, e.toString());
        }
    }
}
