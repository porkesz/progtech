/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.factory;

import com.rentacar.dao.car.CarDAO;
import com.rentacar.dao.car.CarDAOImpl;
import com.rentacar.dao.customer.CustomerDAO;
import com.rentacar.dao.customer.CustomerDAOImpl;
import com.rentacar.dao.order.OrderDAO;
import com.rentacar.dao.order.OrderDAOImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adam
 */
public class DAOFactory implements AutoCloseable {
    
    private static EntityManagerFactory emf;
    
    private static EntityManager em;
    
    private static DAOFactory instance;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        
        if (instance == null) {
            instance = new DAOFactory();            
        }
        
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("db");
        }
        
        if (em == null) {
            em = emf.createEntityManager();
        }
        
        return instance;
    }
    
    public CustomerDAO createCustomerDao() {
        return new CustomerDAOImpl(em);
    }
    
    public CarDAO createCarDao() {
        return new CarDAOImpl(em);
    }
    
    public OrderDAO createOrderDao() {
        return new OrderDAOImpl(em);
    }

    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }   
    
}
