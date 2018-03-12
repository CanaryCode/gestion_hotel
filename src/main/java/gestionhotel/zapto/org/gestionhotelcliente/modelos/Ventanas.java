package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Ventanas {
//todas de las ventanas de la app

    public static Stage ventanaPrincipal, ventanaLogin, ventanaReservaCheckIn, ventanaRegistroCliente,
            ventanaHuesped, ventanaQuienesSomos;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/mensajes");

    public Scene creaEscena(String nombreFXML) {
        Scene scene = null;
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/fxml/" + nombreFXML + ".fxml"), resourceBundle);
            scene = new Scene(root);
        } catch (IOException ex) {
            Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scene;
    }

    private Stage configuraVentana(Stage ventana, Stage owner, String titulo) {
        ventana.setResizable(false);
        ventana.setTitle(titulo);
        if (owner != null) {
            ventana.initOwner(owner);
        }
        return ventana;
    }

    public void abrirVentanaLogIn() {
        Stage stage = new Stage();
        stage.setScene(creaEscena("FXMLVentanaLogIn"));
        stage.setTitle("Log - in");
        Ventanas.ventanaLogin = stage;
        stage.setResizable(false);
        stage.setOnCloseRequest(Event -> {
            Ventanas.ventanaLogin = null;
        });
        stage.show();
    }

    public void abrirVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            try {
                Stage stage = new Stage();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaPrincipal.fxml"),resourceBundle);
                Scene scene = new Scene(root);
                stage.setTitle("Ventana Principal");
                stage.setScene(scene);
                Ventanas.ventanaPrincipal = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(Event -> {
                    Ventanas.ventanaPrincipal = null;
                });
                Ventanas.ventanaLogin.close();
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void abrirVentanaHuesped(Stage owner) {
        if (Ventanas.ventanaHuesped == null) {
            Stage stage = new Stage();
            Ventanas.ventanaHuesped=stage;
            configuraVentana(stage, ventanaPrincipal, "Kardex").setScene(creaEscena("FXMLVentanaHuesped"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuesped = null;
            });
            stage.show();
        }
    }

    public void abrirVentanaReservaCheckIn(Stage owner) {
        if (ventanaReservaCheckIn == null) {
            Stage stage = new Stage();
            Ventanas.ventanaReservaCheckIn=stage;
            configuraVentana(stage, ventanaPrincipal, "Check-in").setScene(creaEscena("FXMLVentanaReservaCheckIn"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaReservaCheckIn = null;
            });
            stage.show();
        }
    }

    public void abrirVentanaQuienesSomos(Stage owner) {
        if (ventanaQuienesSomos == null) {
            Stage stage = new Stage();
            Ventanas.ventanaQuienesSomos=stage;
            configuraVentana(stage, ventanaPrincipal, "Quienes somos").setScene(creaEscena("FXMLVentanaQuienesSomos"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaQuienesSomos = null;
            });
            stage.show();
        }
    }

    public void abrirVentanaRegistroClientes(Stage owner) {
        if (ventanaRegistroCliente == null) {
            Stage stage = new Stage();
            Ventanas.ventanaRegistroCliente=stage;
            configuraVentana(stage, ventanaPrincipal, "Registro clientes").setScene(creaEscena("FXMLVentanaCliente"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaRegistroCliente = null;
            });
            stage.show();
        }
    }
}
