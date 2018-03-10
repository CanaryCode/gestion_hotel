package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorFXMLLogIn;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author deico
 */
public class Ventanas {
//todas de las ventanas de la app

    public static Stage ventanaPrincipal, ventanaLogin, ventanaReservaCheckIn, ventanaRegistroCliente,
            ventanaHuesped, ventanaQuienesSomos;

    public void abrirVentanaLogIn() {
        Stage stage = new Stage();
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaLogIn.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Log - in");
            stage.setScene(scene);
            Ventanas.ventanaLogin = stage;
            stage.setResizable(false);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Ventanas.ventanaLogin = null;
                }
            });
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            Stage stage = new Stage();
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaPrincipal.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Ventana Principal");
                stage.setScene(scene);
                Ventanas.ventanaPrincipal = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Ventanas.ventanaPrincipal = null;
                    }
                });
                Ventanas.ventanaLogin.close();
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(Ventanas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void abrirVentanaHuesped(Stage owner) {
        if (ventanaHuesped == null) {
            Parent root;
            Stage stage = new Stage();
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaHuesped.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Kardex");
                stage.setScene(scene);
                Ventanas.ventanaHuesped = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Ventanas.ventanaHuesped = null;
                    }
                });
                if (owner != null) {
                    stage.initOwner(owner);
                }
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void abrirVentanaReservaCheckIn(Stage owner) {
        if (ventanaReservaCheckIn == null) {
            Parent root;
            Stage stage = new Stage();
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaReservaCheckIn.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Reserva");
                stage.setScene(scene);
                Ventanas.ventanaReservaCheckIn = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Ventanas.ventanaReservaCheckIn = null;
                    }
                });
                if (owner != null) {
                    stage.initOwner(owner);
                }
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void abrirVentanaQuienesSomos(Stage owner) {
        if (ventanaQuienesSomos == null) {
            Parent root;
            Stage stage = new Stage();
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaQuienesSomos.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Quienes somos");
                stage.setScene(scene);
                Ventanas.ventanaQuienesSomos = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Ventanas.ventanaQuienesSomos = null;
                    }
                });
                if (owner != null) {
                    stage.initOwner(owner);
                }
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void abrirVentanaRegistroClientes(Stage owner) {
        if (ventanaRegistroCliente == null) {
            Parent root;
            Stage stage = new Stage();
            try {
                root = FXMLLoader.load(getClass().getResource("/fxml/FXMLVentanaCliente.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("RegistroCliente");
                stage.setScene(scene);
                Ventanas.ventanaRegistroCliente = stage;
                stage.setResizable(false);
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        Ventanas.ventanaRegistroCliente = null;
                    }
                });
                if (owner != null) {
                    stage.initOwner(owner);
                }
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(ControladorFXMLLogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
