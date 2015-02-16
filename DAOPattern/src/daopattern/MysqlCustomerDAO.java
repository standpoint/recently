/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;

/**
 *
 * @author volodya
 */
public class MysqlCustomerDAO implements CustomerDAO {
    
    private final Connection con;
    private Statement st;
    
    public MysqlCustomerDAO() throws SQLException{
        con = MysqlDAOFactory.createConnection();
        st = con.createStatement();
    }

    @Override
    public int insertCustomer(String name, String streetAddress, String city, String country) {
        int id = -1;
        try {
            String query1="insert into persons (Name) value(?)";
            String query2="insert into location (streetAddress,city,country) "
                    + "value (?,?,?)";
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps1.setString(1, name);
            ps1.executeUpdate();
            ps2.setString(1, streetAddress);
            ps2.setString(2, city);
            ps2.setString(3, country);
            ps2.executeUpdate();
            ResultSet rs = con.createStatement().executeQuery("select * from persons");
            id = rs.getMetaData().getColumnCount() - 1;
        } catch (SQLException ex) {
            Logger.getLogger(MysqlCustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectCustomersRS(String entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectCustomersTO(String entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
