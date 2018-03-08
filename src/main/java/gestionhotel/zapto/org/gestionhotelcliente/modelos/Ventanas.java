package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorFXMLLogIn;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author deico
 */
public class Ventanas {
//todas de las ventanas de la app

    public static Stage ventanaPrincipal, ventanaLogin, ventanaReserva, ventanaCliente;

    public void abrirVentanaPrincipal() {
        Stage stage = new Stage();
        Ventanas.ventanaLogin = stage;
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaLogIn.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Log - in");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirVentanaHuesped() {
        Parent root;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaHuesped.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Kardex");
            stage.setScene(scene);
            Ventanas.ventanaLogin.close();
            Ventanas.ventanaPrincipal = stage;
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirVentanaReservaCheckIn() {
        Parent root;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaReservaCheckIn.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Reserva");
            stage.setScene(scene);
            stage.initOwner(Ventanas.ventanaPrincipal);
            Ventanas.ventanaCliente = stage;
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirVentanaQuienesSomos() {
        Parent root;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaQuienesSomos.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Quienes somos");
            stage.setScene(scene);
            Ventanas.ventanaLogin.close();
            Ventanas.ventanaPrincipal = stage;
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

