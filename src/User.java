import org.mindrot.BCrypt;
public class User {

    String salt = BCrypt.gensalt();
    String login;
    String hashedPassword;
    byte age;
    String email;

    User(String login, String password, byte age, String email){
        this.login = login;
        this.hashedPassword = passwordHashing(password, salt);
        this.age = age;
        this.email = email;
    }

    private String passwordHashing(String pass, String salt){
        return BCrypt.hashpw(pass, salt);
    }

    public boolean passwordCheck(String password){
        return BCrypt.checkpw(password, hashedPassword);
    }

}
