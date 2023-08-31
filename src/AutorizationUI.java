import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutorizationUI {

    List<User> users = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);

    public void init(){

        users.add( new User("dixa", "1234", (byte) 38, "dixa@xaker.ru"));
        users.add( new User("user20", "user20", (byte) 20, "user@mail.ru"));
        users.add( new User("admin", "admin", (byte) 25, "admin@gmail.com"));
        users.add( new User("user17", "user17", (byte) 17, "user17@mail.ru"));
    }
    public void run(){
        String login;
        String pass;

        System.out.println("        -== Autorization UI ==-     ");

        System.out.println("Введите login:");
        login = userInput.nextLine().trim();

        System.out.println("Введите пароль:");
        pass = userInput.nextLine();

        checkAutorization(login, pass);

    }

    private void checkAutorization(String login, String pass){

    }


}
