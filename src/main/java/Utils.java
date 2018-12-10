import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Utils {

    static final Level epicFail = Level.forName("EPIC.FAIL!", 50);
    final static Logger log = LogManager.getLogger( Utils.class);

    private final static String PROPERTIES_FILE = "gradle.properties";

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

    public static void addPropertyToFile( String str) {

        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter( PROPERTIES_FILE, true));
            writer.append("\n");
            writer.append(str);
            writer.close();
        } catch ( IOException e ) {
            log.error("IOException!!!!!" + e);
        }
    }

    static void modifyProperty(String key, String value)
    {
        File fileToBeModified = new File(PROPERTIES_FILE);
        String newContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(key)) {
                    line = key + "=" + value;
                }
                newContent = newContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            writer = new FileWriter(fileToBeModified);
            writer.write(newContent.substring(0, newContent.length() - 2 ));
        }
        catch (IOException e) { e.printStackTrace(); }
        finally {
            try {
                reader.close();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String readPropertyFromFile( String key) {
        String result = null;
        try {
            Scanner scanner = new Scanner( new File( PROPERTIES_FILE));
            scanner.useDelimiter("\n");
            while ( scanner.hasNext() ) {
                String row = scanner.next();
                if (row.startsWith( key )) {
                    result = row;
                }
            }
        } catch ( IOException e ) {
            log.error("IOException!!!!!" + e);
            result = e.toString();
        }
        return result;
    }

}
