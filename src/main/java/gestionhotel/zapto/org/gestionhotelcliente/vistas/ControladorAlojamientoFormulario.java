package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
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
    private DetallesReserva alojamientoEnVista;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(numeroPersonas, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(numeroBebes, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(numeroChild, Registro.ListaNumeroPersonas);
        UtilFormularios.iniciaComboBox(pension, Registro.ListaPension);
        UtilFormularios.iniciaComboBox(vistas, Registro.ListaVistas);
        UtilFormularios.iniciaComboBox(tipoCama, Registro.ListaTipoCama);
        UtilFormularios.iniciaComboBox(numeroHabitacion, Registro.ListaHabitacion);
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
        UtilFormularios.configurarModo(modo, confirmar,reseteaCampos , principal);
        return this;
    }

    @Override
    public ControladorAlojamientoFormulario setObjetoEnVista(Object objetoEnVista) {
        alojamientoEnVista=(DetallesReserva) objetoEnVista;
        
      UtilFormularios.ValidarNodo(fechaInicio,alojamientoEnVista.getFechaEntradaPrevista());
      UtilFormularios.ValidarNodo(fechaFin,alojamientoEnVista.getFechaSalidaPrevista());
     // UtilFormularios.ValidarNodo(comentario,alojamientoEnVista.get);
      UtilFormularios.ValidarNodo(camaExtraNo,alojamientoEnVista.getCamaExtra());
      UtilFormularios.ValidarNodo(cunaNo,alojamientoEnVista.getCuna());
      UtilFormularios.ValidarNodo(numeroPersonas,String.valueOf(alojamientoEnVista.getNumeroAdultos()));
      UtilFormularios.ValidarNodo(numeroChild,String.valueOf(alojamientoEnVista.getNumeroChild()));
      UtilFormularios.ValidarNodo(numeroBebes,String.valueOf(alojamientoEnVista.getNumeroBebes()));
      UtilFormularios.ValidarNodo(pension,alojamientoEnVista.getPension());
      UtilFormularios.ValidarNodo(vistas,alojamientoEnVista.getPreferenciaVistas());
      UtilFormularios.ValidarNodo(tipoCama,alojamientoEnVista.getPreferenciaTipoCama());
      UtilFormularios.ValidarNodo(numeroHabitacion,alojamientoEnVista.getPreferenciaHabitacion());
      UtilFormularios.ValidarNodo(turnoRestaurante,alojamientoEnVista.getPreferenciaTurnoRestaurante());
      UtilFormularios.ValidarNodo(tipoRestaurante,alojamientoEnVista.getPreferenciaTipoRestaurante());
      UtilFormularios.ValidarNodo(tipoHabitacion,alojamientoEnVista.getPreferenciaTipoHabitacion());
        
        return this;
    }
}
