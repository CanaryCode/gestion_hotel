package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaTelefono;
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
import javafx.scene.control.TableColumn;
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
public class ControladorTelefonoBuscador implements Initializable, BuscadorInterface {

    @FXML
    private AnchorPane principal, panelFiltro;

    @FXML
    private TextField numero, propietario;

    @FXML
    private ComboBox tipo;

    @FXML
    private ToggleButton toggleNumero, togglePropietario, toggleTipo;

    @FXML
    private Button seleccionar, resetearCampos, crear, actualizar, borrar, buscar;

    @FXML
    private TableView<TablaTelefono> tabla;

    @FXML
    private TableColumn tableColumnPropietario, tableColumnNumero, tableColumnTipo;
    private ObservableList<TelefonoPersona> listaAddLTelefono = FXCollections.observableArrayList();
    private ObservableList<TelefonoPersona> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<TablaTelefono> listaTablaTelefono = FXCollections.observableArrayList();
    private ObservableList<Node> nodosApagables = FXCollections.observableArrayList();
    private TelefonoPersona telefonoEnVista;
    private int modo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UtilBuscador.iniciaComboBox(tipo, Registro.ListaTipoTelefono);
        //---------------------------------------------------------------------
        seleccionar.setOnAction((event) -> {
            UtilBuscador.accionSeleccionar(listaFiltro, telefonoEnVista, Ventanas.TELEFONO_BUSCADOR);
        });
        resetearCampos.setOnAction((event) -> {
            UtilBuscador.ResetearCampos(principal);
        });
        crear.setOnAction((event) -> {
            UtilBuscador.accionCrear(VentanasFactory.getObjetoVentanaTelefonoFormulario(Ventanas.TELEFONO_BUSCADOR, Modality.APPLICATION_MODAL, null));
        });
        actualizar.setOnAction((event) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getObjetoVentanaTelefonoFormulario(Ventanas.TELEFONO_BUSCADOR, Modality.APPLICATION_MODAL, null), telefonoEnVista);
        });
        borrar.setOnAction((event) -> {
            UtilBuscador.accionBorrar();
        });
        buscar.setOnAction((event) -> {
            UtilBuscador.accionBuscar();
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNumero, numero, principal, nodosApagables);
        });
        togglePropietario.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(togglePropietario, propietario, principal, nodosApagables);
        });
        toggleTipo.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleTipo, tipo, principal, nodosApagables);
        });
        //----------------------------------------------------
        tableColumnPropietario.setCellValueFactory(
                new PropertyValueFactory("nombre"));
        tableColumnNumero.setCellValueFactory(
                new PropertyValueFactory("numero"));
        tableColumnTipo.setCellValueFactory(
                new PropertyValueFactory("tipo"));
        //------------------------------------------------------------------------------------------
        tabla.setOnMouseClicked((event) -> {
            telefonoEnVista=UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getObjetoVentanaTelefonoFormulario(Ventanas.TELEFONO_BUSCADOR, Modality.WINDOW_MODAL, null), telefonoEnVista,
                    listaFiltro, seleccionar, actualizar,borrar);
        });
        //-----------------------------------------------------------------------------------------
        nodosApagables = FXCollections.observableArrayList(resetearCampos, buscar);
    }

    @Override
    public ControladorTelefonoBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorTelefonoBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddLTelefono = listaAddLTelefono;
        return this;
    }

    @Override
    public <T> ControladorTelefonoBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<TelefonoPersona>) ListaObjeto;
        this.listaTablaTelefono = TablaTelefono.getTablaTelefono(listaFiltro);
        tabla.setItems(listaTablaTelefono);
        return this;
    }

}
