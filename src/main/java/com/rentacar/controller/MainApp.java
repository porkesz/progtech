/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentacar.controller;

import com.rentacar.dao.customer.Customer;
import com.rentacar.dao.factory.DAOFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */
public class MainApp  extends Application {

    public static Customer customer;
    public static final String TITLE = "Rent A Car";
    
    @Override
    public void start(Stage stage) throws Exception {
        customer = null;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/OpenPage.fxml"));
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(e->closeDbConection());
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void closeDbConection() {
        try {
            DAOFactory.getInstance().close();
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

