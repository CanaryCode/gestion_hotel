package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
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
import javafx.scene.layout.Pane;

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
        if (clienteEnVista.getEsEmpresa() == 0) {
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
        UtilFormularios.configurarModo(modoFormulario, aceptar, reseteaCampos, principal);
        return this;
    }
}
