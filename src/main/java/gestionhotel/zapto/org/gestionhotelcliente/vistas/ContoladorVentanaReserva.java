package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ContoladorVentanaReserva implements Initializable {

    @FXML
    private DatePicker fechaInicio, fechaFin;

    @FXML
    private ComboBox<?> numeroPersonas, numeroPersonas1, numeroPersonas11, numeroPersonas2,
            numeroPersonas21, numeroPersonas3, numeroPersonas4;

    @FXML
    private TextArea comentario;

    @FXML
    private Button confirmar, buscarCliente, addCliente;

    public ContoladorVentanaReserva() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addCliente.setOnAction((e)->{
            accionAddCliente();
        });
    }

    private void accionConfirmar() {

    }

    private void accionBuscarCliente() {
    }
    private void accionAddCliente() {
        new Ventanas().abrirVentanaRegistroClientes(Ventanas.ventanaRegistroCliente, Modality.WINDOW_MODAL);
    }

}
