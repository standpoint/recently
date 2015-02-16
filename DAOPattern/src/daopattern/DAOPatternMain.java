/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopattern;

/**
 *
 * @author volodya
 */
public class DAOPatternMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchMethodException {
        final int MYSQL = 1;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(MYSQL);
        CustomerDAO customerDAO = daoFactory.getCustomerDAO();
        int insertCustomer = customerDAO.insertCustomer("First Person", 
                "FirstAvenue, 1a", "Kiev", "Ukraine");
        System.out.println("Insertion:" + "First Person, " + "FirstAvenue, 1a, " 
                + "Kiev, " + "Ukraine:\t" + insertCustomer);
    }
    
}
