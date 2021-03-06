package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorTelefonoFormulario implements Initializable, FormularioInterface {

    @FXML
    private TextField numero, nombre;

    @FXML
    private ComboBox<?> tipo;

    @FXML
    private TextArea comentario;

    @FXML
    private Button reseteaCampos, aceptar;
    @FXML
    private AnchorPane principal;

    private int modo;
    private TelefonoPersona telefonoEnVista;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //-----------------------------------------------------------------------
         numero.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(numero, newValue, oldValue, 40);
         });
         nombre.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 120);
         });
        //-----------------------------------------------------------------------
        UtilFormularios.iniciaComboBox(tipo, Registro.ListaTipoTelefono);
        reseteaCampos.setOnAction((event) -> {
            UtilFormularios.reseteaCampos(principal);
        });
        aceptar.setOnAction((event) -> {
            UtilFormularios.accionAceptar();
        });
    }

    @Override
    public ControladorTelefonoFormulario setModo(int modo) {
        this.modo = modo;
        UtilFormularios.configurarModo(Ventanas.TELEFONO_FORMULARIO, modo, aceptar, reseteaCampos, principal);
        return this;
    }

    @Override
    public ControladorTelefonoFormulario setObjetoEnVista(Object objetoEnVista) {
        this.telefonoEnVista = (TelefonoPersona) objetoEnVista;
        UtilFormularios.ValidarNodo(tipo, telefonoEnVista.getTelefono().getTipo());
        UtilFormularios.ValidarNodo(numero, telefonoEnVista.getTelefono().getNumero());
        UtilFormularios.ValidarNodo(comentario, telefonoEnVista.getTelefono().getComentario());
        Persona p = telefonoEnVista.getPersona();
        if (p != null && p.getEsEmpresa() == true) {
            UtilFormularios.ValidarNodo(nombre, telefonoEnVista.getPersona().getJurNombreComercial());
        } else {
            UtilFormularios.ValidarNodo(nombre, telefonoEnVista.getPersona().getNombre() + " "
                    + p.getFisPrimerApellido() + " " + p.getFisSegundoApellido());
        }

        return this;
    }

}
