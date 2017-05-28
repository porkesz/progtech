/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.order;

import java.util.List;

/**
 *
 * @author Adam
 */
public interface OrderDAO {
    
    public void saveOrder(Order o);
    
    public List<Order> readAllOrder();
    
    public void updateOrder(Order o);
    
    public void deleteOrder(Order o);
    
}
