package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorClienteBuscador implements Initializable {

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
    private Button borrar, crear, actualizar, buscar, aceptar, resetearCampos, telefono,ver;
    @FXML
    AnchorPane panelPrincipal, panelPersona, panelEmpresa, panelFiltro;
    @FXML
    private TabPane tabPanel;

    @FXML
    private ToggleButton toggleNombre, togglePrimerApellido, toggleSegundoApellido,
            toggleFNacimiento, toogleCif, toggleNombreEmpresa, toggleRazonSocial, toggleSexo,
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

    private List<TablaCliente> listaClientes = new ArrayList<>();
    private List<Persona> listaPersonas = new ArrayList<>();
    private Persona ClienteEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nacionalidad.setItems(Registro.listaPaises);
        tratamiento.setItems(Registro.ListaTratamiento);
        categoria.setItems(Registro.ListaCategoriaCliente);
        razonSocial.setItems(Registro.ListaRazonSocial);
        estado.setItems(Registro.listaPaises);

        toggleNombre.selectedProperty().addListener((e) -> {
            codigoToggleNombre();
        });
        togglePrimerApellido.selectedProperty().addListener((e) -> {
            codigoTogglePrimerApellido();
        });
        toggleSegundoApellido.selectedProperty().addListener((e) -> {
            codigoToggleSegundoApellido();
        });
        toggleFNacimiento.selectedProperty().addListener((e) -> {
            codigoToggleFNacimiento();
        });
        toogleCif.selectedProperty().addListener((e) -> {
            codigoToggleCif();
        });
        toggleNombreEmpresa.selectedProperty().addListener((e) -> {
            codigoToggleNombreEmpresa();
        });
        toggleRazonSocial.selectedProperty().addListener((e) -> {
            codigoToggleRazonSocial();
        });
        toggleNacionalidad.selectedProperty().addListener((e) -> {
            codigoToggleNacionalidad();
        });
        toggleTratamiento.selectedProperty().addListener((e) -> {
            codigoToggleTratamiento();
        });
        toggleDni.selectedProperty().addListener((e) -> {
            codigoToggleDni();
        });
        toggleEstado.selectedProperty().addListener((e) -> {
            codigoToggleEstado();
        });
        toggleProvincia.selectedProperty().addListener((e) -> {
            codigoToggleProvincia();
        });
        toggleCiudad.selectedProperty().addListener((e) -> {
            codigoToggleCiudad();
        });
        toggleCalle.selectedProperty().addListener((e) -> {
            codigoToggleCalle();
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            codigoToggleNumero();
        });
        toggleCodigoPostal.selectedProperty().addListener((e) -> {
            codigoToggleCodigoPostal();
        });
        togglePaginaWeb.selectedProperty().addListener((e) -> {
            codigoTogglePagiaWeb();
        });

        toggleEmail.selectedProperty().addListener((e) -> {
            codigoToggleEmail();
        });
        toggleCategoria.selectedProperty().addListener((e) -> {
            codigoToggleCategoria();
        });
        toggleSexo.selectedProperty().addListener((e) -> {
            codigoToggleSexo();
        });
        tabPanel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            codigoTabPanel(oldValue);
        });

        borrar.setOnAction((e) -> {
            codigoBorrar();
        });

        crear.setOnAction((e) -> {
            codigoCrear();
        });
        actualizar.setOnAction((e) -> {
            codigoActualizar();
        });
        buscar.setOnAction((e) -> {
            codigoSeleccionar(); 
        });
        resetearCampos.setOnAction((e) -> {
            codigoresetearCampos();
        });
        telefono.setOnAction((e) -> {
            codigoTelefono();
            
        });
        ver.setOnAction((e) -> {
            codigoVer();
            
        });
        listaPersonas = PruebasModelo.getListaDeClientes();
        listaClientes = TablaCliente.getTablaBuscadorCliente(listaPersonas);

        tabla.setItems(FXCollections.observableArrayList(listaClientes));

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

        tabla.getSelectionModel().selectedIndexProperty().addListener((observable) -> {
            tablaOnSelectedItem();
        });

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

    private void codigoTogglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
            enciendeToggle();
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
            enciendeToggle();
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleFNacimiento() {
        if (toggleFNacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
            enciendeToggle();
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
            configuraBotones();
        }
    }

    private void codigoToggleCif() {
        if (toogleCif.isSelected()) {
            cif.setDisable(false);
            enciendeToggle();
        } else {
            cif.setDisable(true);
            cif.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleNombreEmpresa() {
        if (toggleNombreEmpresa.isSelected()) {
            nombreEmpresa.setDisable(false);
            enciendeToggle();
        } else {
            nombreEmpresa.setDisable(true);
            nombreEmpresa.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleRazonSocial() {
        if (toggleRazonSocial.isSelected()) {
            razonSocial.setDisable(false);
            enciendeToggle();
        } else {
            razonSocial.setDisable(true);
            razonSocial.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToggleSexo() {
        if (toggleSexo.isSelected()) {
            sexoF.setDisable(false);
            sexoM.setDisable(false);
            enciendeToggle();
        } else {
            sexoF.setDisable(true);
            sexoM.setDisable(true);
            sexoM.setSelected(true);
            configuraBotones();
        }
    }

    private void codigoToggleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
            enciendeToggle();
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToggleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
            enciendeToggle();
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToggleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
            enciendeToggle();
        } else {
            dni.setDisable(true);
            dni.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleEstado() {
        if (toggleEstado.isSelected()) {
            estado.setDisable(false);
            enciendeToggle();
        } else {
            estado.setDisable(true);
            estado.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToggleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
            enciendeToggle();
        } else {
            provincia.setDisable(true);
            provincia.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
            enciendeToggle();
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
            enciendeToggle();
        } else {
            calle.setDisable(true);
            calle.setText("");
            configuraBotones();
        }
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

    private void codigoToggleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
            enciendeToggle();
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
            configuraBotones();
        }
    }

    private void codigoTogglePagiaWeb() {
        if (togglePaginaWeb.isSelected()) {
            paginaWeb.setDisable(false);
            enciendeToggle();
        } else {
            paginaWeb.setDisable(true);
            paginaWeb.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
            enciendeToggle();
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
            configuraBotones();
        }
    }

    private void codigoToggleCategoria() {
        if (toggleCategoria.isSelected()) {
            categoria.setDisable(false);
            enciendeToggle();
        } else {
            categoria.setDisable(true);
            categoria.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoSeleccionar() {

    }

    private void codigoBorrar() {

    }

    private void codigoActualizar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaRegistroClientes(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorVentanaCliente) obj.getfXMLLoader().getController()).
                    setClienteEnVista(ClienteEnVista).
                    setModoFormulario(Ventanas.MODO_ACTUALIZAR);
            obj.ver();
        }
    }

    private void codigoCrear() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaRegistroClientes(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        ((ControladorVentanaCliente) obj.getfXMLLoader().getController()).
                setModoFormulario(Ventanas.MODO_INSERTAR);
        if (obj != null) {
            obj.ver();
        }
    }

    private boolean hayTogglesOn() {
        List<ToggleButton> listaToggle = RecorredorPaneles.getListaObjetos(panelPrincipal, FXCollections.observableArrayList());
        boolean hayToogleOn = false;
        for (ToggleButton toggleButton : listaToggle) {
            if (toggleButton.isSelected()) {
                hayToogleOn = true;
                break;
            }
        }
        return hayToogleOn;
    }

    private void configuraBotones() {
        if (hayTogglesOn()) {
            resetearCampos.setDisable(false);
            buscar.setDisable(false);
        } else {
            resetearCampos.setDisable(true);
            buscar.setDisable(true);
        }
    }

    public void enciendeToggle() {
        buscar.setDisable(false);
        resetearCampos.setDisable(false);
    }

    public void codigoresetearCampos() {
        RecorredorPaneles.reseteaControles(panelPrincipal);
    }

    private void codigoTabPanel(Tab viejo) {
        RecorredorPaneles.reseteaControles((Pane) viejo.getContent());
    }

    public void tablaOnSelectedItem() {
        aceptar.setDisable(false);
        actualizar.setDisable(false);
        borrar.setDisable(false);
        telefono.setDisable(false);
        ver.setDisable(false);
        ClienteEnVista = listaPersonas.get(tabla.getSelectionModel().getSelectedIndex());
    }
    public void codigoTelefono() {
          ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefonoBuscador(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
//            ((ControladorVentanaCliente) obj.getfXMLLoader().getController()).
//                    setHuespedEnVista(ClienteEnVista).
//                    setModoFormulario(Ventanas.MODO_ACTUALIZAR);
            obj.ver();
        }
    }
    private void codigoVer(){
      ObjetoVentana obj = VentanasFactory.getObjetoVentanaRegistroClientes(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorVentanaCliente) obj.getfXMLLoader().getController()).setClienteEnVista(ClienteEnVista).
                    setModoFormulario(Ventanas.MODO_VER);
            obj.ver();
        }
    }
}
