package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Fechas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.reloj.Reloj;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private MenuItem kardex, reserva, quienesSomos, registroClientes, addReservas,
            buscadorHuesped, buscadorCliente;
    @FXML
    private Label nombreUsuario, pieDePágina, horaActual;
    @FXML
    private ImageView ImagenUsuario;
    @FXML
    private HBox panelReloj;
    @FXML
    private Button botonCalculadora;

    private Fechas fechas;
    private Reloj reloj;
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
        addReservas.setOnAction((ActionEvent event) -> {
            codigoMenuAddReservas();
        });
        buscadorHuesped.setOnAction((ActionEvent event) -> {
            codigoMenuBuscadorHuesped();
        });
        buscadorCliente.setOnAction((ActionEvent event) -> {
            codigoMenuBuscadorCliente();
        });

        botonCalculadora.setOnAction((e) -> {
            Ventanas.Objetos obj = new Ventanas().abrirVentanaCalculadora(Ventanas.ventanaLogin, Modality.NONE);
            obj.getStage().show();
        });

        configuracionReloj();
    }

    private void codigoMenuAddReservas() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaAddReserva(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
    }

    private void codigoMenuKardex() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaHuesped(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
    }

    private void codigoMenuReserva() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaReservaCheckIn(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
    }

    private void codigoMenuQuienesSomos() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaQuienesSomos(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
    }

    private void codigoMenuRegistroClientes() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaRegistroClientes(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
    }

    private void codigoMenuBuscadorHuesped() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaBuscarHuesped(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
        obj.getStage().show();
    }

    private void codigoMenuBuscadorCliente() {
        Ventanas.Objetos obj = new Ventanas().abrirVentanaBuscarCliente(Ventanas.ventanaPrincipal, Modality.WINDOW_MODAL);
        obj.getStage().show();
        obj.getStage().show();
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
