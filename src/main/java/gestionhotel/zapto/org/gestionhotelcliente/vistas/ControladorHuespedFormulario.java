package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorHuespedFormulario implements Initializable, FormularioInterface {

    @FXML
    TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, paginaWeb, codigoPostal, dni, pasaporte;
    @FXML
    ComboBox categoria, tratamiento, nacionalidad,estado;

    @FXML
    TextArea comentario;

    @FXML
    DatePicker fechaNacimiento, fechaExpedicion;

    @FXML
    RadioButton sexoM, sexoF, discapacitadoSi, discapacitadoNo;

    @FXML
    Button aceptar, reseteaCampos;
    @FXML
    AnchorPane principal;
    private int modo;
    private Persona huespedEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilFormularios.iniciaComboBox(categoria, Registro.listaCategoriaHuesped);
        UtilFormularios.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilFormularios.iniciaComboBox(estado, Registro.listaPaises);
        reseteaCampos.setOnAction((event) -> {
            UtilFormularios.reseteaCampos(principal);
        });
    }

    @Override
    public ControladorHuespedFormulario setModo(int modo) {
        this.modo = modo;
        UtilFormularios.configurarModo(Ventanas.HUESPED_FORMULARIO,modo, aceptar, reseteaCampos, principal);
        return this;
    }

    @Override
    public ControladorHuespedFormulario setObjetoEnVista(Object objetoEnVista) {
        huespedEnVista = (Persona) objetoEnVista;
        UtilFormularios.ValidarNodo(nombre, huespedEnVista.getNombre());
        UtilFormularios.ValidarNodo(primerApellido, huespedEnVista.getFisPrimerApellido());
        UtilFormularios.ValidarNodo(segundoApellido, huespedEnVista.getFisSegundoApellido());
        UtilFormularios.ValidarNodo(dni, huespedEnVista.getDocumentoNumero());
        UtilFormularios.ValidarNodo(provincia, huespedEnVista.getProvincia());
        UtilFormularios.ValidarNodo(codigoPostal, huespedEnVista.getCodPostal());
        UtilFormularios.ValidarNodo(ciudad, huespedEnVista.getCiudad());
        UtilFormularios.ValidarNodo(correoElectronico, huespedEnVista.getEmail());
        UtilFormularios.ValidarNodo(calle, huespedEnVista.getCalle());
        UtilFormularios.ValidarNodo(comentario, huespedEnVista.getComentario());
        UtilFormularios.ValidarNodo(numero, huespedEnVista.getNumero());
        UtilFormularios.ValidarNodo(pasaporte, huespedEnVista.getPasaporte());
        UtilFormularios.ValidarNodo(paginaWeb, huespedEnVista.getPaginaWeb());
        /**
         * --------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(nacionalidad, huespedEnVista.getFisNacionalidad());
        UtilFormularios.ValidarNodo(tratamiento, huespedEnVista.getFisTratamiento());
        UtilFormularios.ValidarNodo(categoria, huespedEnVista.getCategoria());
        UtilFormularios.ValidarNodo(estado, huespedEnVista.getEstado());
        /**
         * --------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(discapacitadoSi, huespedEnVista.getFisDiscapacitado());
        UtilFormularios.ValidarNodo(sexoF, huespedEnVista.getFisSexoHombre());
        /**
         * -----------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(fechaNacimiento, huespedEnVista.getFisFechaNacimiento());
        UtilFormularios.ValidarNodo(fechaExpedicion, huespedEnVista.getFisExpPasaporte());

        return this;
    }
}
