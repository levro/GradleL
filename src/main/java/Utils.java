public class Utils {

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
}
