/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.test;

import com.rentacar.dao.car.Car;
import com.rentacar.model.OrderModel;
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
public class OrderModelTest extends TestCase{
    
    private OrderModel orderModel;
    
    @Before
    public void setUp() {
        orderModel = new OrderModel("test");
    }
    
    @After
    public void tearDown() {
    }

    public void testGetOrderTotal(){
        Car car = new Car("Suzuki", "Swift", 2010, 10000);
        
        assertEquals(20000,
                orderModel.getOrderTotal(car, 2, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE)
        );
        assertEquals(33000,
                orderModel.getOrderTotal(car, 3, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE)
        );
        assertEquals(11500,
                orderModel.getOrderTotal(car, 1, Boolean.FALSE, Boolean.FALSE, Boolean.TRUE)
        );
        assertEquals(21000,
                orderModel.getOrderTotal(car, 2, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE)
        );
        assertEquals(23100,
                orderModel.getOrderTotal(car, 2, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE)
        );
    
    }
    
    public void testDayNumberIsValid(){
        assertFalse(orderModel.dayNumberIsValid(""));
        assertFalse(orderModel.dayNumberIsValid("a"));
        assertFalse(orderModel.dayNumberIsValid("a1"));
        assertFalse(orderModel.dayNumberIsValid("-1"));
        assertTrue(orderModel.dayNumberIsValid("11"));
    }
    
}
