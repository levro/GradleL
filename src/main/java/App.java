public class App {

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        String sum = Utils.sumOfTwoStrings( "120", "53" );
        System.out.println(sum);
    }

    public String getGreeting() {
        return "Hello world.";
    }
}
