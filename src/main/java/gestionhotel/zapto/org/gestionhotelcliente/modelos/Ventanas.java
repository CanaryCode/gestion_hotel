package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Ventanas {
//todas de las ventanas de la app

    public static Stage ventanaPrincipal, ventanaLogin, ventanaReservaCheckIn, ventanaRegistroCliente,
            ventanaHuesped, ventanaQuienesSomos, ventanaAddReserva,ventanaHuespedBuscador,
            ventanaClienteBuscador, ventanaCalculadora;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/mensajes");

    /**
     * configura las propiedades de la escena.
     *
     * @param nombreFXML nombre del archivo "FXML" que se va a cargar.
     * @return la escena configurada.
     */
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

    /**
     * Configura los parámetros del "Stage".
     *
     * @param ventana ventana que se va a configurar.
     * @param owner ventana padre de la ventana que se va a configurar.
     * @param titulo Nombre de la ventana.
     * @param modalidad Tipo de modalidad (modal,normal).
     * @return stage ya configurado
     */
    private Stage configuraVentana(Stage ventana, Stage owner, String titulo, Modality modalidad) {
        ventana.setTitle(titulo);
        ventana.initModality(modalidad);
        ventana.getIcons().add(new Image("/imagenes/hotel.png"));
        if (owner != null) {
            ventana.initOwner(owner);
        }
        return ventana;
    }

    /**
     * abre la ventana de "Log-in". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     */
    public void abrirVentanaLogIn() {
        Stage stage = new Stage();
        stage.setScene(creaEscena("FXMLVentanaLogIn"));
        stage.setTitle(resourceBundle.getString("windows.logIn"));
        stage.getIcons().add(new Image("/imagenes/hotel.png"));
        Ventanas.ventanaLogin = stage;
        stage.setResizable(false);
        stage.setOnCloseRequest(Event -> {
            Ventanas.ventanaLogin = null;
        });
        stage.show();
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     */
    public void abrirVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            try {
                Stage stage = new Stage();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaPrincipal.fxml"), resourceBundle);
                Scene scene = new Scene(root);
                stage.setTitle(resourceBundle.getString("windows.principal"));
                stage.setScene(scene);
                Ventanas.ventanaPrincipal = stage;
                stage.getIcons().add(new Image("/imagenes/hotel.png"));

                stage.setOnCloseRequest(Event -> {
                    Ventanas.ventanaPrincipal = null;
                });
                Ventanas.ventanaLogin.close();
                stage.show();
                stage.setMinWidth(stage.getWidth());
                stage.setMinHeight(stage.getHeight());
            } catch (IOException ex) {
                Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * abre la ventana "Huesped". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */

    public void abrirVentanaHuesped(Stage owner, Modality modalidad) {
        if (Ventanas.ventanaHuesped == null) {
            Stage stage = new Stage();
            Ventanas.ventanaHuesped = stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.huesped"), modalidad).setScene(creaEscena("FXMLVentanaHuesped"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuesped = null;
            });
            stage.show();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
  /**
     * abre la ventana Reserva "Check-In". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public void abrirVentanaReservaCheckIn(Stage owner, Modality modalidad) {
        if (ventanaReservaCheckIn == null) {
            Stage stage = new Stage();
            Ventanas.ventanaReservaCheckIn = stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.checkIn"), modalidad).setScene(creaEscena("FXMLVentanaReservaCheckIn"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaReservaCheckIn = null;
            });
            stage.show();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
  /**
     * abre la ventana "quienes somos". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public void abrirVentanaQuienesSomos(Stage owner, Modality modalidad) {
        if (ventanaQuienesSomos == null) {
            Stage stage = new Stage();
            Ventanas.ventanaQuienesSomos = stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.quienesSomos"), modalidad).setScene(creaEscena("FXMLVentanaQuienesSomos"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaQuienesSomos = null;
            });
            stage.show();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
  /**
     * abre la ventana "Registro Clientes". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public void abrirVentanaRegistroClientes(Stage owner, Modality modalidad) {
        if (ventanaRegistroCliente == null) {
            Stage stage = new Stage();
            Ventanas.ventanaRegistroCliente = stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.cliente"), modalidad).setScene(creaEscena("FXMLVentanaCliente"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaRegistroCliente = null;
            });
            stage.showAndWait();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
    public void abrirVentanaAddReserva(Stage owner, Modality modalidad) {
        if (ventanaAddReserva == null) {
            Stage stage = new Stage();
            Ventanas.ventanaAddReserva = stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.addReserva"), modalidad).setScene(creaEscena("FXMLVentanaReserva"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaAddReserva = null;
            });
            stage.showAndWait();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
    public void abrirVentanaBuscarHuesped(Stage owner, Modality modalidad) {
        if (ventanaHuespedBuscador == null) {
            Stage stage = new Stage();
            Ventanas.ventanaHuespedBuscador= stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.huespedBuscador"), modalidad).setScene(creaEscena("FXMLVentanaHuespedBuscador"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuespedBuscador = null;
            });
            stage.showAndWait();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
    public void abrirVentanaBuscarCliente(Stage owner, Modality modalidad) {
        if (ventanaHuespedBuscador == null) {
            Stage stage = new Stage();
            Ventanas.ventanaClienteBuscador= stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.clienteBuscador"), modalidad).setScene(creaEscena("FXMLVentanaClienteBuscador"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaClienteBuscador = null;
            });
            stage.showAndWait();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
    }
    public void abrirVentanaCalculadora(Stage owner, Modality modalidad) {
        if (ventanaCalculadora == null) {
            Stage stage = new Stage();
            Ventanas.ventanaCalculadora= stage;
            configuraVentana(stage, owner, resourceBundle.getString("windows.calculadora"), modalidad).setScene(creaEscena("FXMLCalculadora"));
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaCalculadora = null;
            });
            stage.setAlwaysOnTop(true);
            stage.showAndWait();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
            stage.setResizable(false);
        }
    }
}
