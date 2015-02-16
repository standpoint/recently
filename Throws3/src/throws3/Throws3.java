/*
/* ТАК ДЕЛАТЬ НЕЛЬЗЯ - УТЕЧКА ПАМЯТИ!!!
 */
package throws3;

class A{
    static A pa;
    
    public A(boolean flag) throws Exception {
        pa = this;  // ссылка записывается в статическое поле до выброса исключения
                    // и останется там висеть после выброса исключения до завершения программы
        if(flag) throw new Exception();
    }
}
/**
 *
 * @author vladimir
 */
public class Throws3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        A p = null;
        try {
            p = new A(true);  // исключение - объект не создан!
        } catch (Exception e) {
            
        }
        System.out.println(p);
        System.out.println(A.pa);
    }
    
}
