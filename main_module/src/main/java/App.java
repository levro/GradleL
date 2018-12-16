import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class App {

    final static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException {


/*        log.error("This is not error message with error level");
        System.out.println(new App().getGreeting());

        String sum = Utils.sumOfTwoStrings("120", "53");
        System.out.println("Result is " + sum);
        log.info("=============================================================================================");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String propertyName = String.valueOf(System.currentTimeMillis());
        log.info("Add to file 'gradle.properties' new property [" + propertyName + "] with current time");
        Utils.addPropertyToFile( propertyName + "=" + dateFormat.format(date) );
        System.out.println( "---------------------------------------------" );
        System.out.println( Utils.readPropertyFromFile( propertyName ) );

        String propertyToModiy = "mainProperty";
        log.info("Change property [" + propertyToModiy + "] in 'gradle.properties' file");
        Utils.modifyProperty(propertyToModiy, "water");
        log.info("Read changed property");
        System.out.println( Utils.readPropertyFromFile( propertyToModiy ) );

*/

        String[] xlsRecords = {"Borodops", "Gwanrole", "Panatarg"};
        FileOperations.writeXLS(xlsRecords, "testtt.xls" );

        FileOperations.readXLS("testtt.xls" );
    }

    public String getGreeting() {
        return "Hello worldapp.";
    }
}
