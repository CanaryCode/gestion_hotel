package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
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
public class ControladorPrincipal implements Initializable {

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
            codigoAbrirCalculadora();
        });
        configuracionReloj();
    }

    private void codigoMenuAddReservas() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();
    }

    private void codigoMenuKardex() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();
    }

    private void codigoMenuReserva() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaPrevision(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();
    }

    private void codigoMenuQuienesSomos() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaQuienesSomos(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();
        ((ControladorQuienesSomos)obj.getfXMLLoader().getController()).reproduceVideo();
    }

    private void codigoMenuRegistroClientes() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();
    }

    private void codigoMenuBuscadorHuesped() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();

    }

    private void codigoMenuBuscadorCliente() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarCliente(Ventanas.PRINCIPAL, Modality.NONE, null);
        obj.ver();

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

    private void codigoAbrirCalculadora() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaCalculadora(Ventanas.PRINCIPAL, Modality.NONE, null);
        if (obj != null&&Ventanas.getVentana(obj.getNombreVentana())==null) {
            obj.ver();
        }
    }
}