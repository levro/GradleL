import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    final static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        log.error("This is not error message with error level");
        System.out.println(new App().getGreeting());

        String sum = Utils.sumOfTwoStrings("120", "53");
        System.out.println("Result is " + sum);
        log.info("=============================================================================================");
        String sum = Utils.sumOfTwoStrings( "120", "53" );
        System.out.println(sum);
        Utils.addPropertyToFile( "newProp=300" );
        System.out.println( "---------------------------------------------" );
        System.out.println( Utils.readPropertyFromFile( "newProp" ) );
    }

    public String getGreeting() {
        return "Hello world.";
    }
}
