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
    public void run() {
        String login;
        String pass;

        System.out.println("        -== Autorization UI ==-     ");

        while (true) {
            System.out.println("Введите login:");
            login = userInput.nextLine().trim();

            System.out.println("Введите пароль:");
            pass = userInput.nextLine();

            try {
                checkAutorization(login, pass);
                    System.out.println("Доступ разрешен для пользователя " + login + " с паролем: " +
                            getUserByLogin(login).hashedPassword);
                    System.out.println();

            } catch (UserNotFoundException | AutorizationException | AccessDeniedException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void checkAutorization(String login, String pass) throws UserNotFoundException,
            AccessDeniedException, AutorizationException {

        User user = getUserByLogin(login);

        if (user.login.equals(login) && user.passwordCheck(pass)) {
            if (user.age < (byte) 18) {
                throw new AccessDeniedException();
            }
        } else {
            throw new AutorizationException();
        }
    }

    private User getUserByLogin(String login) throws UserNotFoundException{
        User foundedUser = null;
        for (User user : users){
            if (user.login.equals(login)){
                foundedUser = user;
            }
        }
        if (foundedUser == null) {
            throw new UserNotFoundException();
        }
        return foundedUser;
    }

}
