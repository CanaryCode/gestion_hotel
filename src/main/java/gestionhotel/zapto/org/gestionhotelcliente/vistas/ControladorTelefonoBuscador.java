package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaTelefono;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.net.URL;
import java.util.ArrayList;
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

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane principal;

    @FXML
    private TextField numero, nombre;

    @FXML
    private ToggleButton toggleNumero, toggleNombre;

    @FXML
    private Button seleccionar, resetarCampos, crear, actualizar, borrar, aceptar;

    @FXML
    private TableView<TablaTelefono> tabla;

    @FXML
    private TableColumn<?, ?> tableColumnNombre, tableColumnNumero, tableColumnTipo;

    private List<TablaTelefono> listaTablaTelefono = new ArrayList<>();
    private List<TelefonoPersona> listaTelefonoPersonaEnVista = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleNumero.setOnAction((event) -> {
            codigoToggleNumero();
        });
        toggleNombre.setOnAction((event) -> {
            codigoToggleNombre();
        });
      toggleNombre.selectedProperty().addListener((e) -> {
         codigoToggleNombre();
        });
      toggleNumero.selectedProperty().addListener((e) -> {
         codigoToggleNumero();
        });
        seleccionar.setOnAction((event) -> {
            codigoSeleccionar();
        });
        resetarCampos.setOnAction((event) -> {
            codigoResetarCampos();
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
//        listaTelefonoPersona = Consultas.realizaSQLQuery(Consultas.TODAS_LAS_PERSONAS, TelefonoPersona.class);
//        listaTablaTelefono= TablaTelefono.getTablaTelefono(listaTelefonoPersona);

        tabla.setItems(FXCollections.observableArrayList(listaTablaTelefono));
        tableColumnNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory("tipo"));

    }

    private void codigoToggleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
            enciendeToggle();
        } else {
            numero.setDisable(true);
            numero.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
            enciendeToggle();
        } else {
            nombre.setDisable(true);
            nombre.setText("");
            configuraBotones();
        }
    }

    private void codigoSeleccionar() {

    }

    private void codigoResetarCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }

    private void codigoCrear() {
              ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefono(Ventanas.TELEFONO_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorVentanaTelefono) obj.getfXMLLoader().getController()).
                    setModoFormulario(Ventanas.MODO_INSERTAR);
            obj.ver();
        }
    }

    private void codigoActualizar() {

    }

    private void codigoBorrar() {

    }

    private void codigoAceptar() {

    }

    public void enciendeToggle() {
        seleccionar.setDisable(false);
        resetarCampos.setDisable(false);
    }

    private void configuraBotones() {
        if (hayTogglesOn()) {
            resetarCampos.setDisable(false);
            seleccionar.setDisable(false);
        } else {
            resetarCampos.setDisable(true);
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
public ControladorTelefonoBuscador setLisTalefonoEnVista(ObservableList<TelefonoPersona> listaTelefonos){
    listaTelefonoPersonaEnVista=listaTelefonos;
    return this;
}
}
