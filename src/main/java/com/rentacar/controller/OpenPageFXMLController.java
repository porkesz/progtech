/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.controller;

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
import javafx.stage.Stage;
/**
 *
 * @author Adam
 */
public class OpenPageFXMLController implements Initializable {
   
    @FXML
    private void loginButtonAction(ActionEvent event) throws IOException
    {
        loadNextPage("/fxml/Login.fxml", event);
    }
    
    @FXML
    private void registerButtonAction(ActionEvent event) throws IOException
    {
        loadNextPage("/fxml/Register.fxml", event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
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

