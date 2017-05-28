/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.customer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adam
 */
public class CustomerDAOImpl implements CustomerDAO{
    
    private EntityManager em;

    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveCustomer(Customer c) {
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
    }

    @Override
    public Customer readCustomerByEmail(String email) {
        
        Customer customer;
        
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.email = '"+ email +"'"
                , Customer.class
        );
        
        try {
            customer = query.getSingleResult();
        } catch (Exception e) {
            customer = null;
        }
        
        return customer;
    }

    @Override
    public void updateCustomer(Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCustomer(Customer c) {
        
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        
    }    
}
