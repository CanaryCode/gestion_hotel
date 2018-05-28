package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
public class ControladorHuespedBuscador implements Initializable, BuscadorInterface {

    @FXML
    private TextField nombre, primerApellido, segundoApellido, provincia, ciudad, calle,
            pasaporte, numero, codigoPostal, dni, correoElectronico, paginaWeb;
    @FXML
    private AnchorPane panelPrincipal;

    @FXML
    private DatePicker fechaNacimiento, fechaExpedicion;

    @FXML
    private RadioButton sexoM, sexoF, discapacitadoNo, discapacitadoSi;

    @FXML
    private ComboBox<?> nacionalidad, tratamiento, categoria;

    @FXML
    private Button borrar, crear, actualizar, seleccionar, buscar, resetarCampos, telefono;
    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido, toggleFnacimiento,
            toggleSexo, toggleDiscapacitado, toggleNacionalidad, toggleProvincia, toggleCiudad,
            toggleCalle, toggleNumero, toggleCodigoPostal, toggleDni, togglePasaporte,
            toggleExpPasaporte, togglePaginaWeb, toggleEmail, toggleTratamiento,
            toggleCategoría;
    @FXML
    private TableView<TablaHuesped> tabla;

    @FXML
    private TableColumn tableColumnNumero, tableColumnDni, tableColumnNombre, tableColumnPrimerApellido,
            tableColumnSegundoApellido, tableColumnFechaNacimiento, tableColumnSexo, tableColumnDiscapacitado,
            tableColumnCiudad, tableColumnProvincia, tableColumnPais, tableColumnCalle, tableColumnCodigoPostal,
            tableColumnPasaporte, tableColumnFechaExpedicion, tableColumnEmail, tableColumnTratamiento,
            tableColumnCategoria;

    private List<TablaHuesped> listaTablaHuespedes = new ArrayList<>();
    private Persona huespedEnVista;
    private ObservableList<Persona> listaAddHuesped, listaFiltro;
    private ObservableList<TelefonoPersona> listaAddTelefono;
    private ObservableList<Node> nodosApagables;
    int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleNombre.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNombre, nombre, panelPrincipal, nodosApagables);
        });
        togglePrimerApellido.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(togglePrimerApellido, primerApellido, panelPrincipal, nodosApagables);
        });
        toggleSegundoApellido.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleSegundoApellido, segundoApellido, panelPrincipal, nodosApagables);
        });
        toggleFnacimiento.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleFnacimiento, fechaNacimiento, panelPrincipal, nodosApagables);
        });

        toggleDiscapacitado.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleDiscapacitado, discapacitadoSi, panelPrincipal, nodosApagables);

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
//        toggleEstado.selectedProperty().addListener((e) -> {
//             UtilBuscador.apagaToggle(toggleEstado, estado, panelPrincipal, nodosApagables);
//        });
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
        toggleCategoría.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleCategoría, categoria, panelPrincipal, nodosApagables);
        });
        toggleSexo.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleSexo, sexoM, panelPrincipal, nodosApagables);
        });
        togglePasaporte.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(togglePasaporte, pasaporte, panelPrincipal, nodosApagables);
        });
        toggleExpPasaporte.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleExpPasaporte, fechaExpedicion, panelPrincipal, nodosApagables);
        });

        categoria.setItems(Registro.ListaCategoriaCliente);
        categoria.getSelectionModel().selectFirst();
        tratamiento.setItems(Registro.ListaTratamiento);
        tratamiento.getSelectionModel().selectFirst();
        nacionalidad.setItems(Registro.listaPaises);
        nacionalidad.getSelectionModel().selectFirst();
        //----------------------------------------------------------------------------------------
        tableColumnDni.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellido.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellido.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexo.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitado.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvincia.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPais.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostal.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporte.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicion.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamiento.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumero.setCellValueFactory(new PropertyValueFactory("numero"));

        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            huespedEnVista = UtilBuscador.accionOnSelectedTable(listaFiltro, tabla, seleccionar,
                    actualizar, telefono, borrar);
        });
        tabla.setOnMouseClicked((event) -> {
            UtilBuscador.accionVer(event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null), huespedEnVista);
        });
        //--------------------------------------------------------------------------------------------
        borrar.setOnAction((e) -> {
            UtilBuscador.accionBorrar();
        });

        crear.setOnAction((e) -> {
            UtilBuscador.accionCrear(VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null));

        });
        actualizar.setOnAction((e) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null), huespedEnVista);
        });

        seleccionar.setOnAction((e) -> {
            UtilBuscador.accionSeleccionar(listaAddHuesped, huespedEnVista, Ventanas.HUESPED_BUSCADOR);

        });
        buscar.setOnAction((e) -> {
            UtilBuscador.accionBuscar();
        });
        resetarCampos.setOnAction((e) -> {
            UtilBuscador.ResetearCampos(panelPrincipal);
        });
        telefono.setOnAction((e) -> {
            UtilBuscador.abrirTelefono(VentanasFactory.getObjetoVentanaTelefonoBuscador(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null), listaAddTelefono, PruebasModelo.getLisTelefono(), Ventanas.MODO_FORMULARIO_LECTURA);
        });
        nodosApagables = FXCollections.observableArrayList(resetarCampos, buscar);
    }

    @Override
    public ControladorHuespedBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorHuespedBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddHuesped = (ObservableList<Persona>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorHuespedBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Persona>) ListaObjeto;
        tabla.setItems(TablaHuesped.getTablaBuscadorHuesped(listaFiltro));
        return this;
    }

}
