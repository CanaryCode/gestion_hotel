package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHabitacionBuscador implements Initializable {

    @FXML
    private AnchorPane panelFiltro;

    @FXML
    private ToggleButton toggleNumero, toggleTipoHabitacion, toggleVistas, toggleTipoCama;

    @FXML
    private Button seleccionar, resetarCampos, actualizar, borrar, aceptar, crear;

    @FXML
    private TableView<?> tabla;

    @FXML
    private TableColumn<?, ?> tableColumnNumero, tableColumnTipo, tableColumnCama, tableColumnVistas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seleccionar.setOnAction((event) -> {
            codigoSeleccionar();
        });
        resetarCampos.setOnAction((event) -> {
            codigoResetearCampos();
        });
        actualizar.setOnAction((event) -> {
            codigoActualizar();
        });
        borrar.setOnAction((event) -> {
            codigoBorrar();
        });
        aceptar.setOnAction((event) -> {
            codigoAceptar();
        });
        crear.setOnAction((event) -> {
            codigoCrear();
        });
    }

    private void codigoAceptar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoBorrar() {

    }

    private void codigoActualizar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoResetearCampos() {

    }

    private void codigoSeleccionar() {

    }

    private void codigoCrear() {

    }

}
