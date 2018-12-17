import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    private final static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        log.warn("===============================================LOGGING=============================================");
        log.error("This is not error message with error level");
        String sum = Utils.sumOfTwoStrings("120", "53");
        System.out.println("Result is " + sum);

        log.warn("===============================================PROPERTIES==========================================");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String propertyName = String.valueOf(System.currentTimeMillis());
        log.info("Add to file 'custom.properties' new property [" + propertyName + "] with current time");
        FileOperations.addPropertyToFile( propertyName + "=" + dateFormat.format(date) );
        System.out.println( FileOperations.readPropertyFromFile( propertyName ) );
        String propertyToModiy = "mainProperty";
        log.info("Change property [" + propertyToModiy + "] in 'gradle.properties' file");
        FileOperations.modifyProperty(propertyToModiy, "water");
        log.info("Read changed property");
        System.out.println( FileOperations.readPropertyFromFile( propertyToModiy ) );

        log.warn("===============================================EXCEL===============================================");
        String[] xlsRecords = {"Borodops", "Gwanrole", "Panatarg"};
        FileOperations.writeXLS(xlsRecords, "testtt.xls" );

        List<Object[]> readFromXLS = FileOperations.readXLS("testtt.xls");
        printArray(readFromXLS);
        System.out.println();

        xlsRecords = new String[] {"1j2h3g4b5a", "*&^%$^##%^"};
        FileOperations.appendXLS(xlsRecords, "testtt.xls");

        readFromXLS = FileOperations.readXLS("testtt.xls");
        printArray(readFromXLS);
    }

    private static void printArray(List<Object[]> readFromXLS) {
        for (Object[] str : readFromXLS ) {
            for (Object s : str ) {
                System.out.print(s + "\t\t");
            }
            System.out.println();
        }
    }
}
