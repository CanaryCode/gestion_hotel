package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorReservaCheckIn implements Initializable {

    @FXML
    private TextField cliente, reserva;

    @FXML
    private DatePicker fecha;

    @FXML
    private Button buscar, resetearCampos, checkIn, addReserva;

    @FXML
    private TableColumn tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada, tableColumnFechaPrevistaSalida, tableColumnHuesped;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscar.setOnAction((event) -> {
            accionBuscar();
        });
        resetearCampos.setOnAction((event) -> {
            accionCampos();
        });
        checkIn.setOnAction((event) -> {
            accionCheckIn();
        });
        addReserva.setOnAction((event) -> {
            accionReserva();
        });
    }

    private void accionBuscar() {

    }
    private void accionCampos() {

    }
    private void accionCheckIn() {

    }
    private void accionReserva() {
     new Ventanas().abrirVentanaAddReserva(Ventanas.ventanaReservaCheckIn, Modality.APPLICATION_MODAL);
    }
}
