package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorAlojamientoFormulario implements Initializable {

    @FXML
    private DatePicker fechaInicio, fechaFin;

    @FXML
    private TextArea comentario;

    @FXML
    private RadioButton camaExtraSi, camaExtraNo, cunaSi, cunaNo;

    @FXML
    private ComboBox numeroPersonas, pension, vistas, tipoCama, numeroHabitacion,
            turnoRestaurante, tipoRestaurante, tipoHabitacion, numeroBebes, numeroChild;

    @FXML
    private Button confirmar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numeroPersonas.setItems(Registro.ListaNumeroPersonas);
        numeroPersonas.getSelectionModel().selectFirst();
        numeroBebes.setItems(Registro.ListaNumeroPersonas);
        numeroBebes.getSelectionModel().selectFirst();
        numeroChild.setItems(Registro.ListaNumeroPersonas);
        numeroChild.getSelectionModel().selectFirst();
        pension.setItems(Registro.ListaPension);
        pension.getSelectionModel().selectFirst();
        vistas.setItems(Registro.ListaVistas);
        vistas.getSelectionModel().selectFirst();
        tipoCama.setItems(Registro.ListaTipoCama);
        tipoCama.getSelectionModel().selectFirst();
        numeroHabitacion.setItems(Registro.ListaHabitacion);
        numeroHabitacion.getSelectionModel().selectFirst();
        turnoRestaurante.setItems(Registro.ListaTurnoRestaurante);
        turnoRestaurante.getSelectionModel().selectFirst();
        tipoRestaurante.setItems(Registro.ListaTipoRestaurante);
        tipoRestaurante.getSelectionModel().selectFirst();
        tipoHabitacion.setItems(Registro.ListaTipoHabitacion);
        tipoHabitacion.getSelectionModel().selectFirst();

        confirmar.setOnAction((event) -> {
            codigoConfirmar();
        });

    }

    private void codigoConfirmar() {

    }
}
