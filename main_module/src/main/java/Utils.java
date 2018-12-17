import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

    private static final Level epicFail = Level.forName("EPIC.FAIL!", 50);
    private final static Logger log = LogManager.getLogger( Utils.class);

    public static String sumOfTwoStrings (String str1, String str2) {

        log.info("Test log levels");

        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");
        log.fatal("This is a fatal message");
        log.log(epicFail, "This is a epicFail message");
        long a;
        long b;
        try {
            a = Long.parseLong( str1 );
            b = Long.parseLong( str2 );
        } catch ( NumberFormatException e ) {
            return "0";
        }
        return String.valueOf( a + b );
    }
}
