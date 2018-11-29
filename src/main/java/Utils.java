import java.io.*;
import java.util.Scanner;

public class Utils {

    private final static String PROPERTIES_FILE = "gradle.properties";

    public static String sumOfTwoStrings (String str1, String str2) {
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
            System.out.println("IOException!!!!!");
            System.out.println(e);
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
            System.out.println("IOException!!!!!");
            result = e.toString();
        }
        return result;
    }

}
