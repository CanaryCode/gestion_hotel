package gestionhotel.zapto.org.gestionhotelcliente.vistas;

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
        UtilFormularios.ValidarNodo(tipo, telefonoEnVista.getTipo());
        UtilFormularios.ValidarNodo(numero, telefonoEnVista.getId().getNumTelefono());
        UtilFormularios.ValidarNodo(comentario, telefonoEnVista.getComentario());
        Persona p = telefonoEnVista.getPersona();
        if (p != null && p.getEsEmpresa() == 1) {
            UtilFormularios.ValidarNodo(nombre, telefonoEnVista.getPersona().getJurNombreComercial());
        } else {
           UtilFormularios.ValidarNodo(nombre, telefonoEnVista.getPersona().getNombre()+" "+
                   p.getFisPrimerApellido()+" "+p.getFisSegundoApellido());
        }

        return this;
    }

}
