package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Fechas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.reloj.Reloj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author deico
 */
public class ControladorVentanaPrincipal implements Initializable {

    @FXML
    MenuItem kardex;
    @FXML
    MenuItem reserva;
    @FXML
    MenuItem quienesSomos;
    @FXML
    MenuItem registroClientes;
    @FXML
    Label nombreUsuario, pieDePágina;
    @FXML
    ImageView ImagenUsuario;

    @FXML
    HBox panelReloj;
    @FXML
    Label horaActual;
    
    Fechas fechas = new Fechas();
    Reloj reloj = new Reloj();
    VBox relojArrancable;

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
        registroClientes.setOnAction((ActionEvent event) -> {
            codigoMenuRegistroClientes();
        });

        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                relojArrancable = reloj.getReloj();

            }
        });
        hilo.run();
        panelReloj.getChildren().add(relojArrancable);
        horaActual.setText(fechas.getTimeActual());
    }

    private void codigoMenuKardex() {
        new Ventanas().abrirVentanaHuesped(Ventanas.ventanaPrincipal);
    }

    private void codigoMenuReserva() {
        new Ventanas().abrirVentanaReservaCheckIn(Ventanas.ventanaPrincipal);
    }

    private void codigoMenuQuienesSomos() {
        new Ventanas().abrirVentanaQuienesSomos(Ventanas.ventanaPrincipal);
    }

    private void codigoMenuRegistroClientes() {
        new Ventanas().abrirVentanaRegistroClientes(Ventanas.ventanaPrincipal);
    }
}
