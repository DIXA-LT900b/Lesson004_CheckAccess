public class AccessDeniedException extends Exception{

    AccessDeniedException(){
        super("Доступ запрещен. Возраст младше 18 лет!");
    }
}
