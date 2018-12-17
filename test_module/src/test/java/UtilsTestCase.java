import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class UtilsTestCase {

    @Test
    public void testSumStrings() {
        Utils classUnderTest = new Utils();
        assertEquals( "150", classUnderTest.sumOfTwoStrings( "100", "50") );
    }

    @Test public void testSumStringsNeg() {
        Utils classUnderTest = new Utils();
        assertEquals( "0", classUnderTest.sumOfTwoStrings( "seven", "50") );
    }
}
