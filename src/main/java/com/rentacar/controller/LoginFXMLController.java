/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.controller;

import com.rentacar.model.CustomerModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */
public class LoginFXMLController implements Initializable {
    
    private CustomerModel customerModel;
        
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label invalidCustomer;
    
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException
    {
        if (customerModel.validateLogin(email.getText(), password.getText())) {
            loadNextPage("/fxml/OrderMaker.fxml", event);
        } else {
            invalidCustomer.setText("Hibás felhsználónév vagy jelszó!");
        }
    }
    
    @FXML
    private void registerButtonAction(ActionEvent event) throws IOException
    {
        loadNextPage("/fxml/Register.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        customerModel = new CustomerModel();
        invalidCustomer.setText("");
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
}

