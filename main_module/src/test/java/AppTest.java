import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    @Test public void testSumStrings() {
        Utils classUnderTest = new Utils();
        assertEquals( "150", classUnderTest.sumOfTwoStrings( "100", "50") );
    }

    @Test public void testSumStringsNeg() {
        Utils classUnderTest = new Utils();
        assertEquals( "0", classUnderTest.sumOfTwoStrings( "seven", "50") );
    }
}
