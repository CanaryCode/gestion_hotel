package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
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
    private ComboBox<?> nacionalidad, tratamiento, categoria, estado;

    @FXML
    private Button borrar, crear, actualizar, seleccionar, buscar, resetarCampos, telefono;
    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido, toggleFnacimiento,
            toggleSexo, toggleDiscapacitado, toggleNacionalidad, toggleProvincia, toggleCiudad,
            toggleCalle, toggleNumero, toggleCodigoPostal, toggleDni, togglePasaporte,
            toggleExpPasaporte, togglePaginaWeb, toggleEmail, toggleTratamiento,
            toggleCategoría, toggleEstado;
    @FXML
    private TableView<TablaHuesped> tabla;

    private ObservableList<TablaHuesped> listaTablaHuespedes;
    private Huesped huespedEnVista;
    private ObservableList<Huesped> listaAddHuesped, listaFiltro;
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
        //-------------------------------------------------------------------------
        UtilBuscador.iniciaComboBox(categoria, Registro.ListaCategoriaPersona);
        UtilBuscador.iniciaComboBox(tratamiento, Registro.ListaTratamiento);
        UtilBuscador.iniciaComboBox(nacionalidad, Registro.listaPaises);
        UtilBuscador.iniciaComboBox(estado, Registro.listaPaises);
        //----------------------------------------------------------------------------------------
        nombre.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        primerApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        segundoApellido.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        provincia.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        ciudad.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        calle.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        pasaporte.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        numero.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        codigoPostal.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        dni.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        correoElectronico.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        paginaWeb.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(nombre, newValue, oldValue, 40);
        });
        //----------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------
        tabla.setOnMouseClicked((event) -> {
            huespedEnVista = UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null), huespedEnVista,
                    listaFiltro, seleccionar, actualizar, telefono, borrar);
        });
        //--------------------------------------------------------------------------------------------
        borrar.setOnAction((e) -> {
            UtilBuscador.accionBorrar();
        });

        crear.setOnAction((e) -> {
            UtilBuscador.accionCrear(VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null));

        });
        actualizar.setOnAction((e) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null), huespedEnVista);
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
            ObservableList<TelefonoPersona> listaFiltroTelefono = Select.getListaFiltroTelefono(huespedEnVista.getPersona());
            Platform.runLater(() -> {
                UtilBuscador.abrirTelefono(VentanasFactory.getTelefonoBuscador(Ventanas.HUESPED_BUSCADOR, Modality.WINDOW_MODAL, null),listaAddTelefono, listaFiltroTelefono, Ventanas.MODO_FORMULARIO_LECTURA);

            });
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
        this.listaAddHuesped = (ObservableList<Huesped>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorHuespedBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Huesped>) ListaObjeto;
        listaTablaHuespedes = new TablaHuesped().getListaObjetosDeTabla(listaFiltro);
        CreadorDeTabla.generaTabla(panelPrincipal, tabla, listaTablaHuespedes, new TablaHuesped().getListaObjetosColumnas());
        return this;
    }

}
