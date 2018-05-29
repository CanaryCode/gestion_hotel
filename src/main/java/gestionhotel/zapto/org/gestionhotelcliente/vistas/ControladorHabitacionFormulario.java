package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

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
    private AnchorPane principal;

    @FXML
    private Button reseteaCampos, aceptar;
    
    Habitacion habitacionEnVista;
    
    private int modo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(tipoHabitacion, Registro.ListaTipoHabitacion);
        UtilFormularios.iniciaComboBox(vistas, Registro.ListaVistas);
        UtilFormularios.iniciaComboBox(tipoCama, Registro.ListaTipoCama);
        UtilFormularios.iniciaComboBox(numeroHabitacion, Registro.ListaNumeroHabitacion);
        //-------------------------------
        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        aceptar.setOnAction((event) -> {
            codigoAceptar();
        });
        comentario.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(comentario, newValue, oldValue, 300);
        });
    }

    private void codigoReseteaCampos() {

    }

    private void codigoAceptar() {

    }

    @Override
    public ControladorHabitacionFormulario setModo(int modo) {
        this.modo=modo;
        UtilFormularios.configurarModo(Ventanas.HABITACION_FORMULARIO,modo, aceptar, reseteaCampos, principal);
        return this;
    }

    @Override
    public ControladorHabitacionFormulario setObjetoEnVista(Object objetoEnVista) {
        this.habitacionEnVista=(Habitacion) objetoEnVista;
        //---------------------------------------------------------------------------
        UtilFormularios.ValidarNodo(tipoCama, habitacionEnVista.getTipoCama());
        UtilFormularios.ValidarNodo(tipoHabitacion, habitacionEnVista.getTipo());
        UtilFormularios.ValidarNodo(numeroHabitacion, String.valueOf(habitacionEnVista.getNumero()));
        UtilFormularios.ValidarNodo(vistas, habitacionEnVista.getVistas());
        UtilFormularios.ValidarNodo(comentario, habitacionEnVista.getComentario());
        return this;
    }

}
