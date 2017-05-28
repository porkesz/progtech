/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.model;

import com.rentacar.dao.factory.DAOFactory;
import com.rentacar.dao.car.Car;
import com.rentacar.dao.car.CarDAO;
import java.util.List;

/**
 *
 * @author Adam
 */
public class CarModel {
    
    private CarDAO CarDao;

    public CarModel() {
        CarDao = DAOFactory.getInstance().createCarDao();
    }
    
    public List<Car> getAllCar(){
        return CarDao.readAllCar();
    }
    
}
