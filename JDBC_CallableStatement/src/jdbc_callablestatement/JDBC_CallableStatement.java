package jdbc_callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBC_CallableStatement {

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

        String SQL = "{call myproced (?,?)}";
        CallableStatement cs=con.prepareCall(SQL);
        cs.setInt(1, 2);
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.execute();
        String s=cs.getString(2);
        System.out.println(s);
    }
    
}
