package singleton;
class Singleton1 {

    private static Singleton1 obj;
    private Singleton1(){}

    public static synchronized Singleton1 getInstance() {
        if(obj == null) {
            obj = new Singleton1();
        }
        return obj;
    }
}
