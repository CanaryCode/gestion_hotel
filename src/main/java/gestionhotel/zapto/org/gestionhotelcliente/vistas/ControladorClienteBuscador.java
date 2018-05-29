package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
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
import javafx.scene.control.TableColumn;
;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */


public class ControladorClienteBuscador implements Initializable, BuscadorInterface {

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
    private TableView<TablaCliente> tabla;

    @FXML
    private TableColumn tableColumnRazonSocial, tableColumnTipo, tableColumnNombreComercial,
            tableColumnDocumentoNumero, tableColumnNombre, tableColumnPrimerApellido,
            tableColumnSegundoApellido, tableColumnFechaNacimiento, tableColumnNacionalidad,
            tableColumnProvincia, tableColumnCiudad, tableColumnCalle, tableColumnNumero,
            tableColumnCodigoPostal, tableColumnSexo, tableColumnEstado, tableColumnEmail, tableColumnPaginaWeb, tableColumnCategoria,
            tableColumnTratamiento;

    private ObservableList<TablaCliente> listaTablaClientes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaAddClientes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<TelefonoPersona> listaAddTelefono = FXCollections.observableArrayList();
    private Persona ClienteEnVista;

    private ObservableList<Node> nodosApagables;

    private int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilBuscador.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilBuscador.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilBuscador.iniciaComboBox(categoria, Registro.ListaCategoriaCliente);
        UtilBuscador.iniciaComboBox(razonSocial, Registro.ListaRazonSocial);
        UtilBuscador.iniciaComboBox(estado, Registro.listaPaises);

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
            UtilBuscador.accionCrear(VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null));
        });
        actualizar.setOnAction((e) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null), ClienteEnVista);
        });
        buscar.setOnAction((e) -> {
            //--------------------------
        });
        seleccionar.setOnAction((e) -> {
            UtilBuscador.accionSeleccionar(listaAddClientes, ClienteEnVista, Ventanas.CLIENTE_BUSCADOR);
        });
        resetearCampos.setOnAction((e) -> {
            UtilBuscador.ResetearCampos(panelPrincipal);
        });
        telefono.setOnAction((e) -> {
            ObservableList<TelefonoPersona> listaFiltroTelefono = Consultas.getListaFiltroTelefono(ClienteEnVista);
            UtilBuscador.abrirTelefono(VentanasFactory.getObjetoVentanaTelefonoBuscador(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null), listaAddTelefono, Consultas.getListaFiltroTelefono(ClienteEnVista), Ventanas.MODO_FORMULARIO_LECTURA);

        });

        //---------------------------------------------------------------------
        tableColumnDocumentoNumero.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellido.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellido.setCellValueFactory(new PropertyValueFactory("segundoApellido"));
        tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexo.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvincia.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostal.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamiento.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        tableColumnRazonSocial.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory("esEmpresa"));
        tableColumnNombreComercial.setCellValueFactory(new PropertyValueFactory("nombreComercial"));
        tableColumnPaginaWeb.setCellValueFactory(new PropertyValueFactory("paginaWeb"));
        tableColumnNacionalidad.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        
        tabla.setOnMouseClicked((event) -> {
                ClienteEnVista=UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null), 
                        ClienteEnVista,listaFiltro, seleccionar,
                    actualizar, telefono, borrar);
        });
        //----------------------------------------------------------------------------------------
    nodosApagables=FXCollections.observableArrayList(resetearCampos,buscar);
    }

    @Override
    public ControladorClienteBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorClienteBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddClientes = (ObservableList<Persona>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorClienteBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Persona>) ListaObjeto;
        tabla.setItems(TablaCliente.getTablaBuscadorCliente(listaFiltro));
        return this;
    }
}
