/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.model;

import com.rentacar.dao.customer.CustomerDAO;
import com.rentacar.dao.factory.DAOFactory;
import com.rentacar.dao.car.Car;
import com.rentacar.dao.order.Order;
import com.rentacar.dao.order.OrderDAO;
import java.util.List;

/**
 *
 * @author Adam
 */
public class OrderModel {
    
    private OrderDAO OrderDao;

    public OrderModel() {
        OrderDao = DAOFactory.getInstance().createOrderDao();
    }
    
    public OrderModel(String test){
    }
    
    public int getOrderTotal(Car car, int dayNumber, Boolean gps, Boolean extraInsurance, Boolean useForeign) {
        int carTotal = car.getDailyFee() * dayNumber;
        int gpsTotal = 0;
        double total = 0;
        
        if (gps) {
            gpsTotal = dayNumber * 500;
        }
        
        total = carTotal + gpsTotal;
        
        if (extraInsurance) {
            total = total * 1.1;
        }
        
        if (useForeign) {
            total = total *1.15;
        }
        
        return (int)total;
    }
    
    public void saveOrder(Order order) {
        OrderDao.saveOrder(order);
    }
    
    public Boolean dayNumberIsValid(String dayNumber) {
        int intDayNumber = 0;
        
        if (dayNumber.length() == 0) {
            return false;
        }
        
        try {
            intDayNumber = Integer.parseInt(dayNumber);
        } catch (Exception e){
            return false;
        }
        
        if (intDayNumber < 1) {
            return false;
        }
        
        return true;
    }
}
