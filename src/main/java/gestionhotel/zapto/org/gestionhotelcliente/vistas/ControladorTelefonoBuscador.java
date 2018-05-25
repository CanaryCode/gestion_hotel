package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaTelefono;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class ControladorTelefonoBuscador implements Initializable {

    @FXML
    private AnchorPane principal, panelFiltro;

    @FXML
    private TextField numero, nombre, tipo;

    @FXML
    private ToggleButton toggleNumero, toggleNombre, toggleTipo;

    @FXML
    private Button seleccionar, resetearCampos, crear, actualizar, borrar, aceptar;

    @FXML
    private TableView<TablaTelefono> tabla;

    @FXML
    private TableColumn tableColumnNombre, tableColumnNumero, tableColumnTipo;
    private ObservableList<TelefonoPersona> listaTelefono = FXCollections.observableArrayList();
    private ObservableList<TablaTelefono> listaTablaTelefono = FXCollections.observableArrayList();
    private TelefonoPersona telefonoEnVista;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabla.setItems(listaTablaTelefono);
        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            tablaOnSelectedItem();
        });
        //---------------------------------------------------------------------
        seleccionar.setOnAction((event) -> {
            codigoSeleccionar();
        });
        resetearCampos.setOnAction((event) -> {
            codigoResetearCampos();
        });
        crear.setOnAction((event) -> {
            codigoCrear();
        });
        actualizar.setOnAction((event) -> {
            codigoActualizar();
        });
        borrar.setOnAction((event) -> {
            codigoBorrar();
        });
        aceptar.setOnAction((event) -> {
            codigoAceptar();
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            codigoToggleNumero();
        });
        toggleNombre.selectedProperty().addListener((e) -> {
            codigoToggleNombre();
        });
        toggleTipo.selectedProperty().addListener((e) -> {
            codigoToggleTipo();
        });
        //----------------------------------------------------
        tableColumnNombre.setCellValueFactory(
                new PropertyValueFactory("nombre"));
        tableColumnNumero.setCellValueFactory(
                new PropertyValueFactory("numero"));
        tableColumnTipo.setCellValueFactory(
                new PropertyValueFactory("tipo"));
    }

    private void codigoAceptar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefonoFormulario(Ventanas.TELEFONO_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }
    private void codigoActualizar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefonoFormulario(Ventanas.TELEFONO_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }
    public ControladorTelefonoBuscador setModo(int modo) {

        return this;
    }

    public ControladorTelefonoBuscador setLista(ObservableList<TelefonoPersona> listaTelefono) {
        this.listaTelefono = listaTelefono;
        this.listaTablaTelefono = TablaTelefono.getTablaTelefono(listaTelefono);
        tabla.setItems(listaTablaTelefono);
        return this;
    }

    private void codigoToggleTipo() {
        if (toggleTipo.isSelected()) {
            tipo.setDisable(false);
            enciendeToggle();
        } else {
            tipo.setDisable(true);
            configuraBotones();
        }
    }

    private void codigoToggleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
            enciendeToggle();
        } else {
            nombre.setDisable(true);
            configuraBotones();
        }
    }

    private void codigoToggleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
            enciendeToggle();
        } else {
            tipo.setDisable(true);
            configuraBotones();
        }
    }

    public void enciendeToggle() {
        seleccionar.setDisable(false);
        resetearCampos.setDisable(false);
    }

    private void configuraBotones() {
        if (hayTogglesOn()) {
            resetearCampos.setDisable(false);
            seleccionar.setDisable(false);
        } else {
            resetearCampos.setDisable(true);
            seleccionar.setDisable(true);
        }
    }

    private boolean hayTogglesOn() {
        List<ToggleButton> listaToggle = RecorredorPaneles.getListaObjetos(principal, FXCollections.observableArrayList());
        boolean hayToogleOn = false;
        for (ToggleButton toggleButton : listaToggle) {
            if (toggleButton.isSelected()) {
                hayToogleOn = true;
                break;
            }
        }
        return hayToogleOn;
    }

    private void codigoSeleccionar() {

    }

    private void codigoResetearCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }

    private void codigoCrear() {
    }

    private void codigoBorrar() {

    }
    public void tablaOnSelectedItem() {
        aceptar.setDisable(false);
        actualizar.setDisable(false);
        borrar.setDisable(false);
        telefonoEnVista = listaTelefono.get(tabla.getSelectionModel().getSelectedIndex());
    }

}
