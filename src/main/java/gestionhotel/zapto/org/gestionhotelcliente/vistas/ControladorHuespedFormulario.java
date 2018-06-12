package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
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
    private Huesped huespedEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilFormularios.iniciaComboBox(categoria, Registro.listaCategoriaHuesped);
        UtilFormularios.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilFormularios.iniciaComboBox(estado, Registro.listaPaises);
        //-----------------------------------------------------------------------
        nombre.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         primerApellido.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         segundoApellido.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         provincia.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         ciudad.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         calle.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         pasaporte.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         numero.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         codigoPostal.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         dni.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         correoElectronico.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         paginaWeb.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
         });
         comentario.textProperty().addListener((observable, oldValue, newValue) -> {
             LimitadorDeCaracteres.addLimitacion(comentario, newValue, oldValue, 300);
         });
        //-----------------------------------------------------------------------
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
        huespedEnVista = (Huesped) objetoEnVista;
        UtilFormularios.ValidarNodo(nombre, huespedEnVista.getPersona().getNombre());
        UtilFormularios.ValidarNodo(primerApellido, huespedEnVista.getPersona().getFisPrimerApellido());
        UtilFormularios.ValidarNodo(segundoApellido, huespedEnVista.getPersona().getFisSegundoApellido());
        UtilFormularios.ValidarNodo(dni, huespedEnVista.getPersona().getNumeroDocumento());
        UtilFormularios.ValidarNodo(provincia, huespedEnVista.getPersona().getProvincia());
        UtilFormularios.ValidarNodo(codigoPostal, huespedEnVista.getPersona().getCodPostal());
        UtilFormularios.ValidarNodo(ciudad, huespedEnVista.getPersona().getCiudad());
        UtilFormularios.ValidarNodo(correoElectronico, huespedEnVista.getPersona().getEmail());
        UtilFormularios.ValidarNodo(calle, huespedEnVista.getPersona().getCalle());
        UtilFormularios.ValidarNodo(comentario, huespedEnVista.getPersona().getComentario());
        UtilFormularios.ValidarNodo(numero, huespedEnVista.getPersona().getNumero());
        UtilFormularios.ValidarNodo(pasaporte, huespedEnVista.getPersona().getPasaporte());
        UtilFormularios.ValidarNodo(paginaWeb, huespedEnVista.getPersona().getPaginaWeb());
        /**
         * --------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(nacionalidad, huespedEnVista.getPersona().getFisNacionalidad());
        UtilFormularios.ValidarNodo(tratamiento, huespedEnVista.getPersona().getFisTratamiento());
        UtilFormularios.ValidarNodo(categoria, huespedEnVista.getPersona().getCategoria());
        UtilFormularios.ValidarNodo(estado, huespedEnVista.getPersona().getEstado());
        /**
         * --------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(discapacitadoSi, huespedEnVista.getPersona().getFisDiscapacitado());
        UtilFormularios.ValidarNodo(sexoF, huespedEnVista.getPersona().getFisSexoHombre());
        /**
         * -----------------------------------------------------------------
         */
        UtilFormularios.ValidarNodo(fechaNacimiento, huespedEnVista.getPersona().getFisFechaNacimiento());
       // UtilFormularios.ValidarNodo(fechaExpedicion, huespedEnVista.getFisExpPasaporte());

        return this;
    }
}
