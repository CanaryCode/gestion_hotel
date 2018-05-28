package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHabitacionBuscador implements Initializable, BuscadorInterface {

    @FXML
    private AnchorPane principal, panelFiltro;

    @FXML
    private ComboBox numero, tipoCama, tipoHabitacion, vistas;

    @FXML
    private ToggleButton toggleNumero, toggleTipoCama, toggleTipoHabitacion, toggleVistas;

    @FXML
    private Button seleccionar, resetearCampos, crear, actualizar, borrar, buscar;

    @FXML
    private TableView<TablaHabitacion> tabla;

    @FXML
    private TableColumn tableColumnNumero, tableColumnTipo, tableColumnCama, tableColumnVista;
    private ObservableList<Habitacion> listaAddHabitacion = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<Node> listaNodosApagables;

    private Habitacion habitacionEnVista;
    private int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //----------------------------------------------------------------------
        UtilBuscador.iniciaComboBox(numero, Registro.ListaHabitacion);
        UtilBuscador.iniciaComboBox(tipoCama, Registro.ListaTipoCama);
        UtilBuscador.iniciaComboBox(tipoHabitacion, Registro.ListaTipoHabitacion);
        UtilBuscador.iniciaComboBox(vistas, Registro.ListaVistas);
        //----------------------------------------------------------------------
        seleccionar.setOnAction((event) -> {
            UtilBuscador.accionSeleccionar(listaAddHabitacion, habitacionEnVista, Ventanas.HABITACION_BUSCADOR);
        });
        resetearCampos.setOnAction((event) -> {
            UtilBuscador.ResetearCampos(principal);
        });
        crear.setOnAction((event) -> {
            UtilBuscador.accionCrear(VentanasFactory.getObjetoVentanaHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.WINDOW_MODAL, null));
        });
        actualizar.setOnAction((event) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getObjetoVentanaHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.APPLICATION_MODAL, null), habitacionEnVista);
        });
        borrar.setOnAction((event) -> {
            UtilBuscador.accionBorrar();
        });
        buscar.setOnAction((event) -> {
            UtilBuscador.accionBuscar();
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleNumero, numero, principal, listaNodosApagables);
        });
        toggleTipoCama.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleTipoCama, tipoCama, principal, listaNodosApagables);
        });
        toggleTipoHabitacion.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleTipoHabitacion, tipoHabitacion, principal, listaNodosApagables);
        });
        toggleVistas.selectedProperty().addListener((e) -> {
            UtilBuscador.apagaToggle(toggleVistas, vistas, principal, listaNodosApagables);
        });
        //----------------------------------------------------
        tableColumnNumero.setCellValueFactory(
                new PropertyValueFactory("numero"));
        tableColumnTipo.setCellValueFactory(
                new PropertyValueFactory("tipo"));
        tableColumnCama.setCellValueFactory(
                new PropertyValueFactory("cama"));
        tableColumnVista.setCellValueFactory(
                new PropertyValueFactory("vista"));

        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            habitacionEnVista = UtilBuscador.accionOnSelectedTable(listaFiltro, tabla,
                    seleccionar, actualizar,borrar);
        });

        //-------------------------------------------------------------
        listaNodosApagables = FXCollections.observableArrayList(buscar, resetearCampos);
    }

    @Override
    public <T> ControladorHabitacionBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddHabitacion = (ObservableList<Habitacion>) ListaObjeto;
        return this;
    }

    @Override
    public ControladorHabitacionBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorHabitacionBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Habitacion>) ListaObjeto;
        this.listaTablaHabitacion = TablaHabitacion.getTablaHabitacion(listaFiltro);
        tabla.setItems(listaTablaHabitacion);
        return this;
    }

}
