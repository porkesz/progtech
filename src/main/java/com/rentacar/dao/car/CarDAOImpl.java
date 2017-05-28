/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.car;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adam
 */
public class CarDAOImpl implements CarDAO
{
    private EntityManager em;

    public CarDAOImpl(EntityManager em) {
        this.em = em;
    }    
    
    @Override
    public void saveCar(Car c) {
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
    }

    @Override
    public Car readCarById(int id) {
        TypedQuery<Car> query = em.createQuery(
                "SELECT c FROM Car c WHERE c.id = '"+ id +"'"
                , Car.class
        );
        
        return query.getSingleResult();
    }
    
    @Override
    public List<Car> readAllCar() {
        TypedQuery<Car> query = em.createQuery(
                "SELECT c FROM Car c"
                , Car.class
        );
        
        return query.getResultList();
    }

    @Override
    public void updateCar(Car c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCar(Car c) {
        
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        
    }
    
}
