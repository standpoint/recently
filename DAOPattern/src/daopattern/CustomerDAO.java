/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author volodya
 */
public interface CustomerDAO {
    
    public int insertCustomer(String name, String streetAddress, String city, 
            String country);
    public boolean deleteCustomer(int customerId);
    public Customer findCustomer(int customerId);
    public boolean updateCustomer(int customerId);
    public RowSet selectCustomersRS(String entry);
    public Collection selectCustomersTO(String entry);
}
