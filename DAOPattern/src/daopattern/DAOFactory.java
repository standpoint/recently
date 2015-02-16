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
public abstract class DAOFactory {
    
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DERBY = 3;
    
    public abstract CustomerDAO getCustomerDAO();
    
    public static DAOFactory getDAOFactory(int wichFactory) 
            throws NoSuchMethodException {
        
        switch(wichFactory){
            case MYSQL:
                return new MysqlDAOFactory();
            case ORACLE:
                throw new NoSuchMethodException("has no DAO realesation for ORACLE");
            case DERBY:
                throw new NoSuchMethodException("has no DAO realesation for DERBY");
            default:
                return new MysqlDAOFactory();
        }
    }
}
