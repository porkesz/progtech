/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.car;

import java.util.List;

/**
 *
 * @author Adam
 */
public interface CarDAO {
    
    public void saveCar(Car c);
    
    public Car readCarById(int id);
    
    public List<Car> readAllCar();
    
    public void updateCar(Car c);
    
    public void deleteCar(Car c);
    
}
