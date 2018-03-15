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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorVentanaPrincipal implements Initializable {

    @FXML
    private MenuItem kardex, reserva, quienesSomos, registroClientes;
    @FXML
    private Label nombreUsuario, pieDePágina, horaActual;
    @FXML
    private ImageView ImagenUsuario;
    @FXML
    private HBox panelReloj;

    private Fechas fechas;
    private Reloj reloj ;
    private VBox relojArrancable;

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
        configuracionReloj();
    }

    private void codigoMenuKardex() {
        new Ventanas().abrirVentanaHuesped(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
    }

    private void codigoMenuReserva() {
        new Ventanas().abrirVentanaReservaCheckIn(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
    }

    private void codigoMenuQuienesSomos() {
        new Ventanas().abrirVentanaQuienesSomos(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
    }

    private void codigoMenuRegistroClientes() {
        new Ventanas().abrirVentanaRegistroClientes(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
    }

    private void configuracionReloj() {
//configuración reloj
        fechas = new Fechas();
        reloj = new Reloj();
        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                relojArrancable = reloj.getReloj();

            }
        });
        hilo.setPriority(Thread.MIN_PRIORITY);
        hilo.run();
        panelReloj.getChildren().add(relojArrancable);
        horaActual.setText(fechas.getTimeActual());
    }
}
