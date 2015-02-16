package jdbc_commit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Commit {

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

        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        con.setAutoCommit(false);
        Statement st=con.createStatement();
        st.execute("insert into mytable2 (city) values ('Vienna')");
        st.execute("insert into mytable2 (city) values ('Berlin')");
        con.commit();
    }
}
