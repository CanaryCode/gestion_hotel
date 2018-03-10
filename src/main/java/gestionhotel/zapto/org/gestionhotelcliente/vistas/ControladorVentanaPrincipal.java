package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
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
