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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deico
 */
public class ControladorFXMLLogIn implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button botonEntrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        botonEntrar.setOnAction((ActionEvent event) -> {
            logicaBoton();
        });
    }

    private void logicaBoton() {
        Parent root;
        Stage stage=new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaPrincipal.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Log - in");
            stage.setScene(scene);
            Ventanas.ventanaLogin.close();
            Ventanas.ventanaPrincipal=stage;
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
