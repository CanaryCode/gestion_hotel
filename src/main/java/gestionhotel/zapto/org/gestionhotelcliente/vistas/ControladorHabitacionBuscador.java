package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
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

    private ObservableList<Habitacion> listaAddHabitacion = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<Node> listaNodosApagables;

    private Habitacion habitacionEnVista;
    private int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //----------------------------------------------------------------------
        UtilBuscador.iniciaComboBox(numero, Registro.ListaNumeroHabitacion);
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
            UtilBuscador.accionCrear(VentanasFactory.getHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.WINDOW_MODAL, null));
        });
        actualizar.setOnAction((event) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.APPLICATION_MODAL, null), habitacionEnVista);
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
       
        
        tabla.setOnMouseClicked((event) -> {
            habitacionEnVista=UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getHabitacionFormulario(Ventanas.HABITACION_BUSCADOR, Modality.WINDOW_MODAL, null), habitacionEnVista,
                    listaFiltro, seleccionar, actualizar, borrar);
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
        this.listaTablaHabitacion = new TablaHabitacion().getListaObjetosDeTabla(listaFiltro);
        CreadorDeTabla.generaTabla(principal, tabla, listaTablaHabitacion, new TablaHabitacion().getListaObjetosColumnas());
        return this;
    }

}
