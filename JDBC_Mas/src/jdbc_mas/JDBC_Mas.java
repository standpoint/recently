package jdbc_mas;
public class JDBC_Mas {

    public static void main(String[] args) {
        DB data = new DB("jdbc:derby:", "NeuronNetwork", "org.apache.derby.jdbc.EmbeddedDriver");
        data.createMas("mas",3,3);
        data.set("mas",1,1,3.56);
        double d=data.get("mas",1,1);
        System.out.println(d);
        data.set("mas",1,2,4.78);
        d=data.get("mas",1,2);
        System.out.println(d);
        int r=data.Ncolumns("mas");
        int c=data.Nrows("mas");
        System.out.println("rows= "+r);
        System.out.println("cols= "+c);
        data.set("mas",1,2,5.5);
        d=data.get("mas",1,2);
        System.out.println(d);
    }
    
}
