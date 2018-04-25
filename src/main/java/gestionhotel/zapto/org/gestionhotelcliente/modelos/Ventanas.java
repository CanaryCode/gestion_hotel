package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.AbrirCerrarConexiones;
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
            ventanaHuesped, ventanaQuienesSomos, ventanaAddReserva, ventanaHuespedBuscador,
            ventanaClienteBuscador, ventanaCalculadora, ventanaHuespedReserva;

    /**
     * configura las propiedades de la escena.
     *
     * @param nombreFXML nombre del archivo "FXML" que se va a cargar.
     * @return la escena configurada.
     */
    public class Objetos {

        private ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/mensajes");
        FXMLLoader fXMLLoader;
        Stage stage;
        Scene scene;

        public Objetos(FXMLLoader fXMLLoader, Stage stage, Scene scene) {
            this.fXMLLoader = fXMLLoader;
            this.stage = stage;
            this.scene = scene;
        }

        public Scene getScene() {
            return scene;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
        }

        public Objetos(FXMLLoader fXMLLoader, Stage stage) {
            this.fXMLLoader = fXMLLoader;
            this.stage = stage;
        }

        public Objetos() {

        }

        public ResourceBundle getResourceBundle() {
            return resourceBundle;
        }

        public void setResourceBundle(ResourceBundle resourceBundle) {
            this.resourceBundle = resourceBundle;
        }

        public FXMLLoader getfXMLLoader() {
            return fXMLLoader;
        }

        public void setfXMLLoader(FXMLLoader fXMLLoader) {
            this.fXMLLoader = fXMLLoader;
        }

        public Stage getStage() {
            return stage;
        }

        public void setStage(Stage stage) {
            this.stage = stage;
        }
    }

    public Objetos creaEscena(String nombreFXML, Stage stage) {
        Scene scene = null;
        Objetos obj = new Objetos();
        FXMLLoader fXMLLoader = new FXMLLoader();
        try {
            fXMLLoader.setLocation(getClass().getResource("/fxml/" + nombreFXML + ".fxml"));
            Parent root = fXMLLoader.load(getClass().getResource("/fxml/" + nombreFXML + ".fxml"), obj.getResourceBundle());
            scene = new Scene(root);
            stage.setScene(scene);
            obj.setfXMLLoader(fXMLLoader);
            obj.setStage(stage);
            obj.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
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
    public Objetos abrirVentanaLogIn() {
        Objetos obj = new Objetos();
        Stage stage = new Stage();
        obj = creaEscena("FXMLVentanaLogIn", stage);
        stage.setScene(obj.getScene());
        stage.setTitle(obj.resourceBundle.getString("windows.logIn"));
        stage.getIcons().add(new Image("/imagenes/hotel.png"));
        Ventanas.ventanaLogin = stage;
        stage.setResizable(false);
        stage.setOnCloseRequest(Event -> {
            Ventanas.ventanaLogin = null;
            AbrirCerrarConexiones.cerrar();
        });
        return obj;
    }

    /**
     * abre la ventana de "Ventana". No se apoya en las clases privadas de
     * configuración debido a sus características especiales.
     */
    public Objetos abrirVentanaPrincipal() {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaPrincipal", stage);
        if (ventanaPrincipal == null) {
            configuraVentana(stage, Ventanas.ventanaLogin, "windows.principal", Modality.NONE);
            Ventanas.ventanaPrincipal = stage;
            stage.getIcons().add(new Image("/imagenes/hotel.png"));

            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaPrincipal = null;
                AbrirCerrarConexiones.cerrar();
            });
            Ventanas.ventanaLogin.close();
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());

        }

        return obj;
    }

    /**
     * abre la ventana "Huesped". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public Objetos abrirVentanaHuesped(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaHuesped", stage);
        if (Ventanas.ventanaHuesped == null) {
            Ventanas.ventanaHuesped = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.huesped"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuesped = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    /**
     * abre la ventana Reserva "Check-In". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public Objetos abrirVentanaReservaCheckIn(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaReservaCheckIn", stage);
        if (ventanaReservaCheckIn == null) {
            Ventanas.ventanaReservaCheckIn = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.checkIn"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaReservaCheckIn = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    /**
     * abre la ventana "quienes somos". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public Objetos abrirVentanaQuienesSomos(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaQuienesSomos", stage);
        if (ventanaQuienesSomos == null) {
            Ventanas.ventanaQuienesSomos = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.quienesSomos"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaQuienesSomos = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    /**
     * abre la ventana "Registro Clientes". Se apoya en las clases privadas para
     * configurarla.
     *
     * @param owner ventana padre.
     * @param modalidad modalidad de esta ventana (modal,normal).
     */
    public Objetos abrirVentanaRegistroClientes(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaCliente", stage);
        if (ventanaRegistroCliente == null) {
            Ventanas.ventanaRegistroCliente = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.cliente"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaRegistroCliente = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    public Objetos abrirVentanaAddReserva(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaReserva", stage);
        if (ventanaAddReserva == null) {
            Ventanas.ventanaAddReserva = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.addReserva"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaAddReserva = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    public Objetos abrirVentanaBuscarHuesped(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaHuespedBuscador", stage);
        if (ventanaHuespedBuscador == null) {
            Ventanas.ventanaHuespedBuscador = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.huespedBuscador"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuespedBuscador = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    public Objetos abrirVentanaBuscarCliente(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaClienteBuscador", stage);
        if (ventanaHuespedBuscador == null) {
            Ventanas.ventanaClienteBuscador = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.clienteBuscador"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaClienteBuscador = null;
            });

            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        }
        return obj;
    }

    public Objetos abrirVentanaCalculadora(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLCalculadora", stage);
        if (ventanaCalculadora == null) {
            Ventanas.ventanaCalculadora = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.calculadora"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaCalculadora = null;
            });
            stage.setAlwaysOnTop(true);
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
            stage.setResizable(false);

        }
        return obj;
    }

    public Objetos abrirVentanaHuespedReserva(Stage owner, Modality modalidad) {
        Stage stage = new Stage();
        Objetos obj = creaEscena("FXMLVentanaHuespedReserva", stage);
        if (ventanaHuespedReserva == null) {
            Ventanas.ventanaHuespedReserva = stage;
            configuraVentana(stage, owner, obj.resourceBundle.getString("windows.HuespedReserva"), modalidad);
            stage.setOnCloseRequest(Event -> {
                Ventanas.ventanaHuespedReserva = null;
            });
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
            stage.setResizable(false);

        }
        return obj;
    }
}
