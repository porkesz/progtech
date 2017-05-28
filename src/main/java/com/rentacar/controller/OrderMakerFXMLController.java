/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.controller;

import com.rentacar.dao.car.Car;
import com.rentacar.dao.order.Order;
import com.rentacar.model.CarModel;
import com.rentacar.model.OrderModel;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */
public class OrderMakerFXMLController  implements Initializable {
    
    private CarModel carModel;
    
    private OrderModel orderModel;
    
    private List<Car> cars;
    
    @FXML
    private ListView listView;
    
    @FXML
    private TextField dayNumber;
    
    @FXML
    private CheckBox gps;
    
    @FXML
    private CheckBox extraInsurance;
    
    @FXML
    private CheckBox useForeign;
    
    @FXML
    private Label listViewError;
    
    @FXML
    private Label dayNumberError;
    
    @FXML
    private Label orderTotal;
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private void saveOrderButtonAction(ActionEvent event) throws IOException
    {
        if (validateOrder()) {
            int total = getOrderTotal();
            Order order = createOrderObject(total);
            orderModel.saveOrder(order);
            loadNextPage("/fxml/OpenPage.fxml", event);
        }
    }
    
    @FXML
    private void calculateOrderButtonAction(ActionEvent event) throws IOException
    {
        if (validateOrder()) {
            int total = getOrderTotal();
            orderTotal.setText(total + " Ft");
        }
    }
    
    @FXML
    private void logoutButtonAction(ActionEvent event) throws IOException
    {
        MainApp.customer = null;
        loadNextPage("/fxml/OpenPage.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        orderTotal.setText("");
        usernameLabel.setText("Üdv: " + MainApp.customer.getFirstname());
        carModel = new CarModel();
        orderModel = new OrderModel();
        cars = carModel.getAllCar();
        listView.setItems(FXCollections.observableArrayList(cars));
    }
   
    private void loadNextPage(String fxml, ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        Button source = (Button)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.setOnCloseRequest(e->MainApp.closeDbConection());
        stage.setTitle(MainApp.TITLE);
        stage.setScene(scene);
        stage.show();
    }
    
    private Boolean validateOrder()
    {
        Boolean isValid = true;
        int selectedCarIndex = listView.getSelectionModel().getSelectedIndex();
        
        listViewError.setText(""); 
        if (selectedCarIndex < 0) {
            isValid = false;
            listViewError.setText("Válassz autót!");
        }
        
       dayNumberError.setText(""); 
       if (!orderModel.dayNumberIsValid(dayNumber.getText())) {
           isValid = false;
           dayNumberError.setText("Hibás Napok száma!");
       }
       
       return isValid;
        
    }
    
    private Order createOrderObject(int total) {
        int intDayNumber = Integer.parseInt(dayNumber.getText());
        Car car = cars.get(listView.getSelectionModel().getSelectedIndex());
        Order order = new Order(
                MainApp.customer,
                car,
                total,
                intDayNumber,
                gps.isSelected(), 
                extraInsurance.isSelected(), 
                useForeign.isSelected());
        return order;
    }
    
    private int getOrderTotal() {
        int intDayNumber = Integer.parseInt(dayNumber.getText());
        Car car = cars.get(listView.getSelectionModel().getSelectedIndex());
        int total = orderModel.getOrderTotal(
                car,
                intDayNumber,
                gps.isSelected(), 
                extraInsurance.isSelected(), 
                useForeign.isSelected());
        return total;
    }
}
