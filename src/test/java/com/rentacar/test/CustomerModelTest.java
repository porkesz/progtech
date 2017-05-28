/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.test;


import com.rentacar.model.CustomerModel;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class CustomerModelTest extends TestCase {
    
    private CustomerModel customerModel;
    
    @Before
    public void setUp() {
        customerModel = new CustomerModel("test");
    }
    
    @After
    public void tearDown() {
    }
    
    public void testFirstnameValidation(){
        assertTrue(customerModel.firstnameIsValid("Adam"));
        assertFalse(customerModel.firstnameIsValid(""));
    }
    
    public void testLastnameValidation(){
        assertTrue(customerModel.firstnameIsValid("Adam"));
        assertFalse(customerModel.firstnameIsValid(""));
    }
    
    public void testEmailValidation(){
        assertTrue(customerModel.emailIsValid("adam@gmail.com"));
        assertFalse(customerModel.emailIsValid("adam@gmailcom"));
        assertFalse(customerModel.emailIsValid("adamgmail.com"));
        assertFalse(customerModel.firstnameIsValid(""));
    }
    
    public void testTelephoneValidation(){
        assertFalse(customerModel.telephoneIsValid(""));
        assertFalse(customerModel.telephoneIsValid("012012012"));
        assertTrue(customerModel.telephoneIsValid("06303030303"));
    }
    
    public void testBirthdayValidation(){
        assertFalse(customerModel.birthdayIsValid(""));
        assertFalse(customerModel.birthdayIsValid("20001011"));
        assertFalse(customerModel.birthdayIsValid("2000.01.01"));
        assertTrue(customerModel.birthdayIsValid("2000-10-11"));
    }
    
    public void testPasswordValidation(){
        assertFalse(customerModel.passwordIsValid("", ""));
        assertFalse(customerModel.passwordIsValid("asd", ""));
        assertFalse(customerModel.passwordIsValid("", "asd"));
        assertFalse(customerModel.passwordIsValid("asd", "as"));
        assertFalse(customerModel.passwordIsValid("das", "asd"));
        assertTrue(customerModel.passwordIsValid("asdasd", "asdasd"));
    }
}
