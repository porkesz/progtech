/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.customer;

/**
 *
 * @author Adam
 */
public interface CustomerDAO {
    
    public void saveCustomer(Customer c);
    
    public Customer readCustomerByEmail(String email);
    
    public void updateCustomer(Customer c);
    
    public void deleteCustomer(Customer c);
    
}
