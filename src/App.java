public class App {
    public static void main(String[] args) throws Exception {
        IPerson person_good = new PersonClassProxy("TestUser", "TestPass");
        IPerson person_wrong = new PersonClassProxy("wrong_user", "wrong_pass");
        
        try {
            person_wrong.printPersonInfo();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            person_good.printPersonInfo();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
