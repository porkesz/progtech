/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "car")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_sequence", allocationSize = 1)
    @Column(name = "id")
    private int id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "vintage")
    private int vintage;
    
    @Column(name = "daily_fee")
    private int dailyFee;

    public Car() {
    }

    public Car(String type, String model, int vintage, int dailyFee) {
        this.type = type;
        this.model = model;
        this.vintage = vintage;
        this.dailyFee = dailyFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public int getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(int dailyFee) {
        this.dailyFee = dailyFee;
    }

    @Override
    public String toString() {
        return type + " " + model + ", évjárat:" + vintage + ", napi díj:" + dailyFee;
    }
    
    
}
