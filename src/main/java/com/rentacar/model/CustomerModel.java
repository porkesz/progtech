/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.model;

import com.rentacar.controller.MainApp;
import com.rentacar.dao.customer.Customer;
import com.rentacar.dao.customer.CustomerDAO;
import com.rentacar.dao.factory.DAOFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Adam
 */
public class CustomerModel {
    
    private CustomerDAO customerDao;
    
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public CustomerModel() {
        customerDao = DAOFactory.getInstance().createCustomerDao();
    }
    
    public CustomerModel(String test) {
    }
    
    public Boolean validateLogin(String email, String password)
    {
        Customer customer = customerDao.readCustomerByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            MainApp.customer = customer;
            return true;
        }
        return false;
    }
    
    public Boolean firstnameIsValid(String firstname)
    {
        if (firstname.length() > 1) {
            return true;
        }
        return false;
    }
    
    public  Boolean lastnameIsValid(String lastname)
    {
        if (lastname.length() > 1) {
            return true;
        } 
        return false;
    }
    
    public  Boolean emailIsValid(String email)
    {
        Pattern pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    
    public Boolean telephoneIsValid(String telephone)
    {
        if (telephone.length() > 9 && telephone.length() < 18) {
            return true;
        }
        return false;
    }
    
    public Boolean birthdayIsValid(String birthday)
    {
        try {
            dateFormat.parse(birthday);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public Boolean passwordIsValid(String password1, String password2)
    {
        if (password1.length() > 0 && password1.equals(password2)) {
            return true;
        }
        return false;
    }
    
    public void saveCustomer(Customer customer)
    {
        customerDao.saveCustomer(customer);
    }
    
    
    
}
