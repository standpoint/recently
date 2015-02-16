package singleton;
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){}
    static {
        try {
            instance = new Singleton4();
        } catch (Exception e) {
            throw new RuntimeException("При создании объекта «Singleton» произошла ошибка");
        }
    }
    public static Singleton4 getInstance(){
        return instance;
    }
    
}
