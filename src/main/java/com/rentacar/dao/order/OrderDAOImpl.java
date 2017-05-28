/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.order;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adam
 */
public class OrderDAOImpl implements OrderDAO
{
    private EntityManager em;

    public OrderDAOImpl(EntityManager em) {
        this.em = em;
    }    

    @Override
    public void saveOrder(Order o) {
        
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        
    }

    @Override
    public List<Order> readAllOrder() {
        
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o"
                , Order.class
        );
        
        return query.getResultList();    
    }

    @Override
    public void updateOrder(Order o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOrder(Order o) {
        
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
        
    }
    
}
