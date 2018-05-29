package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorClienteFormulario implements Initializable, FormularioInterface {

    @FXML
    private TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, codigoPostal, cif, nombreEmpresa, paginaWeb,
            dni;

    @FXML
    private TextArea comentario;

    @FXML
    private ComboBox estado, razonSocial, categoria, tratamiento, nacionalidad;

    @FXML
    private DatePicker fechaNacimiento;

    @FXML
    private RadioButton sexoM, sexoF;

    @FXML
    private Button aceptar, reseteaCampos;
    @FXML
    private AnchorPane principal;

    @FXML
    private TabPane tabPanel;
    @FXML
    private Tab tabPersona, tabEmpresa;

    public ControladorClienteFormulario() {
    }
    private int modoFormulario;
    private Persona clienteEnVista;
    private ObservableList listaBotones;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilFormularios.iniciaComboBox(estado, Registro.listaPaises);
        UtilFormularios.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilFormularios.iniciaComboBox(categoria, Registro.ListaCategoriaCliente);
        UtilFormularios.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilFormularios.iniciaComboBox(razonSocial, Registro.ListaRazonSocial);
        //-----------------------------------------------------------------------
        nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        primerApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(primerApellido, newValue, oldValue, 40);
        });
        segundoApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(segundoApellido, newValue, oldValue, 40);
        });
        calle.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(calle, newValue, oldValue, 40);
        });
        numero.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(numero, newValue, oldValue, 40);
        });
        provincia.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(provincia, newValue, oldValue, 40);
        });
        ciudad.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(ciudad, newValue, oldValue, 40);
        });
        correoElectronico.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(correoElectronico, newValue, oldValue, 40);
        }); 
        codigoPostal.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(codigoPostal, newValue, oldValue, 40);
        }); 
        cif.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(cif, newValue, oldValue, 40);
        });
        nombreEmpresa.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombreEmpresa, newValue, oldValue, 40);
        });
        paginaWeb.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(paginaWeb, newValue, oldValue, 40);
        });
        dni.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(dni, newValue, oldValue, 40);
        });
        comentario.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(comentario, newValue, oldValue, 300);
        });
        //-----------------------------------------------------------------------
        reseteaCampos.setOnAction((event) -> {
            UtilFormularios.reseteaCampos(principal);
        });
        tabPanel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            UtilFormularios.CambiaTab(oldValue);
        });
        listaBotones = FXCollections.observableArrayList(reseteaCampos, aceptar);
    }

    @Override
    public ControladorClienteFormulario setObjetoEnVista(Object objetoEnVista) {
        clienteEnVista = (Persona) objetoEnVista;
        //---------------------------------------------------------------------------------
        if (clienteEnVista.getEsEmpresa()!=null&&clienteEnVista.getEsEmpresa() == 0) {
            UtilFormularios.ValidarNodo(nombre, clienteEnVista.getNombre());
            UtilFormularios.ValidarNodo(sexoM, clienteEnVista.getFisSexoHombre());
            UtilFormularios.ValidarNodo(fechaNacimiento, clienteEnVista.getFisFechaNacimiento());
            UtilFormularios.ValidarNodo(tratamiento, clienteEnVista.getFisTratamiento());
            UtilFormularios.ValidarNodo(nacionalidad, clienteEnVista.getFisNacionalidad());
            UtilFormularios.ValidarNodo(primerApellido, clienteEnVista.getFisPrimerApellido());
            UtilFormularios.ValidarNodo(segundoApellido, clienteEnVista.getFisSegundoApellido());
            UtilFormularios.ValidarNodo(dni, clienteEnVista.getDocumentoNumero());
        } else {
            UtilFormularios.ValidarNodo(cif, clienteEnVista.getDocumentoNumero());
            UtilFormularios.ValidarNodo(razonSocial, clienteEnVista.getJurRazonSocial());
            UtilFormularios.ValidarNodo(nombreEmpresa, clienteEnVista.getJurNombreComercial());
        }
        //------------------------------------------------------------------------------
        UtilFormularios.ValidarNodo(provincia, clienteEnVista.getProvincia());
        UtilFormularios.ValidarNodo(codigoPostal, clienteEnVista.getCodPostal());
        UtilFormularios.ValidarNodo(correoElectronico, clienteEnVista.getEmail());
        UtilFormularios.ValidarNodo(calle, clienteEnVista.getCalle());
        UtilFormularios.ValidarNodo(ciudad, clienteEnVista.getCiudad());
        UtilFormularios.ValidarNodo(comentario, clienteEnVista.getComentario());
        UtilFormularios.ValidarNodo(numero, clienteEnVista.getNumero());
        UtilFormularios.ValidarNodo(paginaWeb, clienteEnVista.getPaginaWeb());
        //----------------------------------------------------------------------------
        UtilFormularios.ValidarNodo(estado, clienteEnVista.getEstado());
        UtilFormularios.ValidarNodo(categoria, clienteEnVista.getCategoria());
        // ----------------------------------------------------------------------------
        UtilFormularios.ValidarNodo(tabPanel, clienteEnVista.getEsEmpresa());
        return this;
    }

    @Override
    public ControladorClienteFormulario setModo(int modoFormulario) {
        this.modoFormulario = modoFormulario;
        UtilFormularios.configurarModo(Ventanas.CLIENTE_FORMULARIO,modoFormulario, aceptar, reseteaCampos, principal);
        return this;
    }
}
