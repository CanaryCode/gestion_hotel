package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHabitacionFormulario implements Initializable, FormularioInterface {

    @FXML
    private ComboBox numeroHabitacion, tipoHabitacion, vistas, tipoCama;

    @FXML
    private TextArea comentario;

    @FXML
    private Button reseteaCampos, aceptar;
    
    Habitacion habitacionEnVista;
    
    private int modo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoHabitacion.setItems(Registro.ListaTipoHabitacion);
        tipoHabitacion.getSelectionModel().selectFirst();
        vistas.setItems(Registro.ListaVistas);
        vistas.getSelectionModel().selectFirst();
        tipoCama.setItems(Registro.ListaTipoCama);
        tipoCama.getSelectionModel().selectFirst();
        numeroHabitacion.setItems(Registro.ListaHabitacion);
        numeroHabitacion.getSelectionModel().selectFirst();
        //-------------------------------
        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        aceptar.setOnAction((event) -> {
            codigoAceptar();
        });
    }

    private void codigoReseteaCampos() {

    }

    private void codigoAceptar() {

    }

    @Override
    public ControladorHabitacionFormulario setModo(int modo) {
        this.modo=modo;
        return this;
    }

    @Override
    public ControladorHabitacionFormulario setObjetoEnVista(Object objetoEnVista) {
        this.habitacionEnVista=(Habitacion) objetoEnVista;
        return this;
    }

}
