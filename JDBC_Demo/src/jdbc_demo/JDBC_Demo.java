package jdbc_demo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC_Demo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String URL = "jdbc:mysql://localhost:3306/mydb4";
        String driverName = "com.mysql.jdbc.Driver";    // берем из документации к jdbc драйверу
        Class.forName(driverName);  // загружаем драйвер в methode area
        Connection con = DriverManager.getConnection(URL, "root", "root");
        if(con==null){
            System.out.println("error");
            System.exit(0);
        }
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from mytable");
        ResultSetMetaData rm = rs.getMetaData();
        int columns = rm.getColumnCount();
        while(rs.next()){
            for(int i = 1; i <= columns; i++){
                System.out.print(rs.getString(i) + "   ");
            }
            System.out.println();
        }
        System.out.println(con.getTransactionIsolation());
    }    
}
