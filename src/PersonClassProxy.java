public class PersonClassProxy implements IPerson {

    private boolean isAdmin = false;
    private IPerson person;

    public PersonClassProxy(String user, String pass) {
        if ("TestUser".equals(user) && "TestPass".equals(pass)) isAdmin = true;
        person = new PersonClass();
    }

    @Override
    public void printPersonInfo() throws Exception {
        if (isAdmin) {
            person.printPersonInfo();
        } else {
            throw new Exception("Vous n'avez pas la permission d'afficher les informations de cette personne.");
        }
    }
    
}
