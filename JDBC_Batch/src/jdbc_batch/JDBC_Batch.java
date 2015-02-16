package jdbc_batch;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Batch {

    public static void main(String[] args) throws ClassNotFoundException, 
            SQLException {
        
        String URL ="jdbc:mysql://localhost:3306/mydb4";
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(URL, "root","root");
        if(con==null){
            System.out.println("error");
            System.exit(0);
        }
        DatabaseMetaData dm=con.getMetaData();
        System.out.println(dm.supportsTransactions());
        System.out.println(con.getTransactionIsolation()==Connection.TRANSACTION_REPEATABLE_READ);
        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        Statement st=con.createStatement();
        st.addBatch("insert into mytable2 (city) values ('Paris')");
        st.addBatch("insert into mytable2 (city) values('Madrid')");
        int[] mas=st.executeBatch();
        System.out.println(mas[0]);
    }
}
