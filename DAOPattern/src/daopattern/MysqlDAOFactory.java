/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author volodya
 */
public class MysqlDAOFactory extends DAOFactory {
    
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mydb";

    MysqlDAOFactory() {
        
    }
    
    public static Connection createConnection(){
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, "root", "root");
            if(con==null){
                System.out.println("error");
                System.exit(0);
            }
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MysqlDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con == null) System.exit(0);
        }
        return null;
    }
    
    @Override
    public CustomerDAO getCustomerDAO() {
        try {
            return new MysqlCustomerDAO();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
