package singleton;
class Singleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Singleton1 s11, s12;
        Singleton2 s21, s22;
        Singleton3 s31, s32;
        Singleton4 s41, s42;
        Singleton5 s51, s52;
        Singleton6 s61, s62;
        
        s11 = Singleton1.getInstance();
        s12 = Singleton1.getInstance();
        
        s21 = Singleton2.getInstance();
        s22 = Singleton2.getInstance();
        
        s31 = Singleton3.INSTANCE;
        s32 = Singleton3.INSTANCE;
        
        s41 = Singleton4.getInstance();
        s42 = Singleton4.getInstance();
        
        s51 = Singleton5.getInstance();
        s52 = Singleton5.getInstance();
        
        s61 = Singleton6.getInstance();
        s62 = Singleton6.getInstance();
        
        System.out.println(s11 + "\n" + s12);
        System.out.println(s21 + "\n" + s22);
        System.out.println(s31 + "\n" + s32);
        System.out.println(s41 + "\n" + s42);
        System.out.println(s51 + "\n" + s52);
        System.out.println(s61 + "\n" + s62);
        
    }
    
}
