/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.dao.order;

import com.rentacar.dao.customer.Customer;
import com.rentacar.dao.car.Car;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Adam
 */
@Entity
@Table(name = "order_table")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_sequence", allocationSize = 1)
    @Column(name = "id")
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
    
    @Column(name = "total")
    private int total;
    
    @Column(name = "day_number")
    private int dayNumber;
    
    @Column(name = "gps")
    private Boolean gps;
    
    @Column(name = "extra_insurance")
    private Boolean extraInsurance;
    
    @Column(name = "use_foreign")
    private Boolean useForeign;

    public Order() {
    }

    public Order(Customer customer, Car car, int total, int dayNumber, Boolean gps, Boolean extraInsurance, Boolean useForeign) {
        this.customer = customer;
        this.car = car;
        this.total = total;
        this.dayNumber = dayNumber;
        this.gps = gps;
        this.extraInsurance = extraInsurance;
        this.useForeign = useForeign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    public Boolean getExtraInsurance() {
        return extraInsurance;
    }

    public void setExtraInsurance(Boolean extraInsurance) {
        this.extraInsurance = extraInsurance;
    }

    public Boolean getUseForeign() {
        return useForeign;
    }

    public void setUseForeign(Boolean useForeign) {
        this.useForeign = useForeign;
    }
    
}
