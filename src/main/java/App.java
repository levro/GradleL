public class App {

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

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
