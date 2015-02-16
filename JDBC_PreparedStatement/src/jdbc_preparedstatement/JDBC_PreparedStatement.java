package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_PreparedStatement {

    public static void main(String[] args) throws ClassNotFoundException, 
            SQLException {
        
        String URL ="jdbc:mysql://localhost:3306/mydb4";
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(URL, "root", "root");
        if(con==null){
          System.out.println("error");
          System.exit(0);
        }
        String SQL="select * from mytable2 where city=?";
        PreparedStatement ps=con.prepareStatement(SQL);
        ps.setString(1, "Kiev");
        ResultSet rs=ps.executeQuery();
        int x=rs.getMetaData().getColumnCount();
        while(rs.next()){
          for(int i=1; i<=x;i++){
            System.out.print(rs.getString(i)+" ");
          }
          System.out.println();
        }
    }
}
