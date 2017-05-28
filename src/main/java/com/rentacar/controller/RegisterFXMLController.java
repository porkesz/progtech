/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.controller;

import com.rentacar.dao.customer.Customer;
import com.rentacar.model.CustomerModel;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RegisterFXMLController  implements Initializable {
    
    private CustomerModel customerModel;
    
    @FXML
    private TextField firstname;
    
    @FXML
    private TextField lastname;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField telephone;
    
    @FXML
    private TextField birthday;
    
    @FXML
    private PasswordField password1;
    
    @FXML
    private PasswordField password2;
    
    @FXML
    private Label firstnameError;
    
    @FXML
    private Label lastnameError;
    
    @FXML
    private Label emailError;
    
    @FXML
    private Label telephoneError;
    
    @FXML
    private Label birthdayError;
    
    @FXML
    private Label passwordError;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        if (validateRegister()) {
            Customer customer = new Customer();
            customer.setFirstname(firstname.getText());
            customer.setLastname(lastname.getText());
            customer.setEmail(email.getText());
            customer.setBirthday(getBirthDate());
            customer.setTelephone(telephone.getText());
            customer.setPassword(password1.getText());
            
            customerModel.saveCustomer(customer);
            
            loadNextPage("/fxml/OpenPage.fxml", event);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        customerModel = new CustomerModel();
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
    
    private Boolean validateRegister()
    {
        Boolean isValid = true;
        
        firstnameError.setText("");
        if (!customerModel.firstnameIsValid(firstname.getText())) {
            isValid = false;
            firstnameError.setText("Hibás Keresztnév!");
        }
        
        lastnameError.setText(""); 
        if (!customerModel.lastnameIsValid(lastname.getText())) {
            isValid = false;
            lastnameError.setText("Hibás Vezetéknév!");
        }
        
        emailError.setText(""); 
        if (!customerModel.emailIsValid(email.getText())) {
            isValid = false;
            emailError.setText("Hibás Email!");
        }
        
        telephoneError.setText("");
        if (!customerModel.telephoneIsValid(telephone.getText())) {
            isValid = false;
            telephoneError.setText("Hibás Telefonszám!");
        } 
        
        birthdayError.setText(""); 
        if (!customerModel.birthdayIsValid(birthday.getText())) {
            isValid = false;
            birthdayError.setText("Hibás Születési dátum!");
        } 
        
        passwordError.setText("");
        if (!customerModel.passwordIsValid(password1.getText(), password2.getText())) {
            isValid = false;
            passwordError.setText("Hibás Jelszó!");
        } 
        
        return isValid;
    }
    
    private Date getBirthDate()
    {
        Date birthDate = null;
        
        try {
            birthDate = customerModel.dateFormat.parse(birthday.getText());
        } catch (ParseException ex) {
            Logger.getLogger(RegisterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return birthDate;
    }
   
}

