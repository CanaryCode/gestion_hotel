/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/** 
 * FXML Controller class
 *
 * @author deico
 */
public class ControladorVentanaPrincipal implements Initializable {
     
    /**
     * Initializes the controller class.
     */
    @FXML
    MenuItem kardex;
    @FXML
    MenuItem reserva;
    @FXML
    MenuItem quienesSomos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kardex.setOnAction((ActionEvent event) -> {
            codigoMenuKardex();
        });
        
        reserva.setOnAction((ActionEvent event) -> {
            codigoMenuReserva();
        });
        
        quienesSomos.setOnAction((ActionEvent event) -> {
            codigoMenuQuienesSomos();
        });
        
    }    
    private void codigoMenuKardex(){
          Parent root;
        Stage stage=new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaCliente.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Kardex");
            stage.setScene(scene);
            Ventanas.ventanaLogin.close();
            Ventanas.ventanaPrincipal=stage;
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    private void codigoMenuReserva(){
        Parent root;
        Stage stage=new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaReserva.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Reserva");
            stage.setScene(scene);
            stage.initOwner(Ventanas.ventanaPrincipal);
            Ventanas.ventanaCliente=stage;
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void codigoMenuQuienesSomos(){
              Parent root;
        Stage stage=new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaQuienesSomos.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Quienes somos");
            stage.setScene(scene);
            Ventanas.ventanaLogin.close();
            Ventanas.ventanaPrincipal=stage;
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
