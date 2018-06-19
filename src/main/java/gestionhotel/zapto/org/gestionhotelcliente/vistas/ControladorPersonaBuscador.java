package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.selects.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorPersonaBuscador implements Initializable, BuscadorInterface {

    @FXML
    private TextField nombre, primerApellido, segundoApellido, dni, nombreEmpresa,
            cif, provincia, ciudad, calle, numero, codigoPostal, correoElectronico,
            paginaWeb;
    @FXML
    private DatePicker fechaNacimiento;
    @FXML
    private RadioButton sexoM, sexoF;
    @FXML
    private ComboBox<?> nacionalidad, tratamiento, categoria, razonSocial, estado;
    @FXML
    private Button borrar, crear, actualizar, buscar, seleccionar, resetearCampos, telefono;
    @FXML
    AnchorPane panelPrincipal, panelPersona, panelEmpresa, panelFiltro;
    @FXML
    private TabPane tabPanel;

    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido,
            toggleFNacimiento, toggleCif, toggleNombreEmpresa, toggleRazonSocial, toggleSexo,
            toggleNacionalidad, toggleTratamiento, toggleDni, toggleEstado, toggleProvincia,
            toggleCiudad, toggleCalle, toggleNumero, toggleCodigoPostal,
            togglePaginaWeb, toggleEmail, toggleCategoria;
    @FXML
    private TableView<TablaPersona> tabla;

    private ObservableList<TablaPersona> listaTablaPersona = FXCollections.observableArrayList();
    private ObservableList<Persona> listaAddPersona = FXCollections.observableArrayList();
    private ObservableList<Persona> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<TelefonoPersona> listaAddTelefono = FXCollections.observableArrayList();
    private Persona PersonaEnVista;

    private ObservableList<Node> nodosApagables;

    private int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilBuscador.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilBuscador.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilBuscador.iniciaComboBox(categoria, Registro.ListaCategoriaPersona);
        UtilBuscador.iniciaComboBox(razonSocial, Registro.ListaRazonSocial);
        UtilBuscador.iniciaComboBox(estado, Registro.listaPaises);
        //------------------------------------------------------------------------
        nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        primerApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(primerApellido, newValue, oldValue, 40);
        });
        segundoApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(segundoApellido, newValue, oldValue, 40);
        });
        dni.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(dni, newValue, oldValue, 40);
        });
        nombreEmpresa.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombreEmpresa, newValue, oldValue, 40);
        });
        cif.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(cif, newValue, oldValue, 40);
        });
        provincia.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(provincia, newValue, oldValue, 40);
        });
        ciudad.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(ciudad, newValue, oldValue, 40);
        });
        calle.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(calle, newValue, oldValue, 40);
        });
        numero.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(numero, newValue, oldValue, 40);
        });
        codigoPostal.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(codigoPostal, newValue, oldValue, 40);
        });
        correoElectronico.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(correoElectronico, newValue, oldValue, 40);
        });
        paginaWeb.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(paginaWeb, newValue, oldValue, 40);
        });
        //------------------------------------------------------------------------

        toggleNombre.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNombre, nombre, panelPrincipal, nodosApagables);
        });
        togglePrimerApellido.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(togglePrimerApellido, primerApellido, panelPrincipal, nodosApagables);
        });
        toggleSegundoApellido.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleSegundoApellido, segundoApellido, panelPrincipal, nodosApagables);
        });
        toggleFNacimiento.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleFNacimiento, fechaNacimiento, panelPrincipal, nodosApagables);
        });
        toggleCif.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCif, cif, panelPrincipal, nodosApagables);

        });
        toggleNombreEmpresa.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNombreEmpresa, nombreEmpresa, panelPrincipal, nodosApagables);
        });
        toggleRazonSocial.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleRazonSocial, razonSocial, panelPrincipal, nodosApagables);
        });
        toggleNacionalidad.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNacionalidad, nacionalidad, panelPrincipal, nodosApagables);
        });
        toggleTratamiento.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleTratamiento, tratamiento, panelPrincipal, nodosApagables);
        });
        toggleDni.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleDni, dni, panelPrincipal, nodosApagables);
        });
        toggleEstado.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleEstado, estado, panelPrincipal, nodosApagables);
        });
        toggleProvincia.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleProvincia, provincia, panelPrincipal, nodosApagables);
        });
        toggleCiudad.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCiudad, ciudad, panelPrincipal, nodosApagables);
        });
        toggleCalle.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCalle, calle, panelPrincipal, nodosApagables);
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNumero, numero, panelPrincipal, nodosApagables);
        });
        toggleCodigoPostal.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCodigoPostal, codigoPostal, panelPrincipal, nodosApagables);
        });
        togglePaginaWeb.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(togglePaginaWeb, paginaWeb, panelPrincipal, nodosApagables);
        });

        toggleEmail.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleEmail, correoElectronico, panelPrincipal, nodosApagables);
        });
        toggleCategoria.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCategoria, categoria, panelPrincipal, nodosApagables);
        });
        toggleSexo.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleSexo, sexoM, panelPrincipal, nodosApagables);
        });
        //-------------------------------------------------------------------------------------------
        tabPanel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            UtilBuscador.CambiaTab(oldValue);
        });

        borrar.setOnAction((e) -> {
            UtilBuscador.accionBorrar();
        });

        crear.setOnAction((e) -> {
            UtilBuscador.accionCrear(VentanasFactory.getPersonaFormulario(Ventanas.PERSONA_BUSCADOR ,Modality.APPLICATION_MODAL, null));
        });
        actualizar.setOnAction((e) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getPersonaFormulario(Ventanas.PERSONA_BUSCADOR, Modality.APPLICATION_MODAL, null), PersonaEnVista);
        });
        buscar.setOnAction((e) -> {
            //--------------------------
        });
        seleccionar.setOnAction((e) -> {
            UtilBuscador.accionSeleccionar(listaAddPersona, PersonaEnVista, Ventanas.PERSONA_BUSCADOR);
        });
        resetearCampos.setOnAction((e) -> {
            UtilBuscador.ResetearCampos(panelPrincipal);
        });
        telefono.setOnAction((e) -> {
            ObservableList<TelefonoPersona> listaFiltroTelefono = Select.getListaFiltroTelefono(PersonaEnVista);
            UtilBuscador.abrirTelefono(VentanasFactory.getTelefonoBuscador(Ventanas.PERSONA_BUSCADOR, Modality.APPLICATION_MODAL, null), listaAddTelefono, Select.getListaFiltroTelefono(PersonaEnVista), Ventanas.MODO_FORMULARIO_LECTURA);

        });

        //---------------------------------------------------------------------
        tabla.setOnMouseClicked((event) -> {
            PersonaEnVista = UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getPersonaFormulario(Ventanas.PERSONA_BUSCADOR, Modality.APPLICATION_MODAL, null),
                    PersonaEnVista, listaFiltro, seleccionar,
                    actualizar, telefono, borrar);
        });
        //----------------------------------------------------------------------------------------
        nodosApagables = FXCollections.observableArrayList(resetearCampos, buscar);
    }

    @Override
    public ControladorPersonaBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorPersonaBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddPersona = (ObservableList<Persona>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorPersonaBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Persona>) ListaObjeto;
        listaTablaPersona = new TablaPersona().getListaObjetosDeTabla(listaFiltro);
        CreadorDeTabla.generaTabla(panelPrincipal, tabla, listaTablaPersona, new TablaPersona().getListaObjetosColumnas());
        return this;
    }
}
