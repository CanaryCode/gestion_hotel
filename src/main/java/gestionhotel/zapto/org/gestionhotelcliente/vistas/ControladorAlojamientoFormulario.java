package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorAlojamientoFormulario implements Initializable, FormularioInterface {

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
    private Button confirmar,reseteaCampos;
    @FXML
    private AnchorPane principal;

    private int modo;
    private Alojamiento alojamientoEnVista;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(numeroPersonas, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(numeroBebes, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(numeroChild, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(pension, Registro.ListaPension);
        UtilFormularios.iniciaComboBox(vistas, Registro.ListaVistas);
        UtilFormularios.iniciaComboBox(tipoCama, Registro.ListaTipoCama);
        UtilFormularios.iniciaComboBox(numeroHabitacion, Registro.ListaNumeroHabitacion);
        UtilFormularios.iniciaComboBox(turnoRestaurante, Registro.ListaTurnoRestaurante);
        UtilFormularios.iniciaComboBox(tipoRestaurante, Registro.ListaTipoRestaurante);
        UtilFormularios.iniciaComboBox(tipoHabitacion, Registro.ListaTipoHabitacion);
        confirmar.setOnAction((event) -> {
            codigoConfirmar();
        });

    }

    private void codigoConfirmar() {

    }

    @Override
    public ControladorAlojamientoFormulario setModo(int modo) {
        this.modo=modo;
        UtilFormularios.configurarModo(Ventanas.ALOJAMIENTO_FORMULARIO,modo, confirmar,reseteaCampos , principal);
        return this;
    }

    @Override
    public ControladorAlojamientoFormulario setObjetoEnVista(Object objetoEnVista) {
        alojamientoEnVista=(Alojamiento) objetoEnVista;
        
      UtilFormularios.ValidarNodo(fechaInicio,alojamientoEnVista.getFechaEntradaPrevista());
      UtilFormularios.ValidarNodo(fechaFin,alojamientoEnVista.getFechaSalidaPrevista());
      UtilFormularios.ValidarNodo(comentario,alojamientoEnVista.getComentario());
      UtilFormularios.ValidarNodo(camaExtraNo,alojamientoEnVista.getCamaExtra());
      UtilFormularios.ValidarNodo(cunaNo,alojamientoEnVista.getCuna());
      UtilFormularios.ValidarNodo(numeroPersonas,String.valueOf(alojamientoEnVista.getNumeroAdultos()));
      UtilFormularios.ValidarNodo(numeroChild,String.valueOf(alojamientoEnVista.getNumeroChild()));
      UtilFormularios.ValidarNodo(numeroBebes,String.valueOf(alojamientoEnVista.getNumeroBebes()));
      UtilFormularios.ValidarNodo(pension,alojamientoEnVista.getPension());
      UtilFormularios.ValidarNodo(vistas,alojamientoEnVista.getPrefVistas());
      UtilFormularios.ValidarNodo(tipoCama,alojamientoEnVista.getPrefTipoCama());
      UtilFormularios.ValidarNodo(numeroHabitacion,alojamientoEnVista.getPrefHabitacion());
      UtilFormularios.ValidarNodo(turnoRestaurante,alojamientoEnVista.getPrefTurnoRestaurante());
      UtilFormularios.ValidarNodo(tipoRestaurante,alojamientoEnVista.getPrefTipoRestaurante());
      UtilFormularios.ValidarNodo(tipoHabitacion,alojamientoEnVista.getPrefTipoHabitacion());
        
        return this;
    }
}
