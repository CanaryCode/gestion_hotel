package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
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
public class ControladorHuespedBuscador implements Initializable {

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
    private Button borrar, crear, actualizar, seleccionar, aceptar, resetarCampos, telefono, ver;
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
    private List<Persona> listaPersonas = new ArrayList<>();
    private Persona huespedEnVista;
    private ObservableList<Persona> listaAddHuesped, listaTodosLosHuespedes;
    private ObservableList<TablaHuesped> listaAddTablaHuesped;
    int modoVentana;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleNombre.selectedProperty().addListener((e) -> {
            codigoToogleNombre();
        });
        togglePrimerApellido.selectedProperty().addListener((e) -> {
            codigoTooglePrimerApellido();
        });
        toggleSegundoApellido.selectedProperty().addListener((e) -> {
            codigoToogleSegundoApellido();
        });
        toggleFnacimiento.selectedProperty().addListener((e) -> {
            codigoToogleFNacimiento();
        });
        toggleSexo.selectedProperty().addListener((e) -> {
            codigoToogleSexo();
        });
        toggleDiscapacitado.selectedProperty().addListener((e) -> {
            codigoToogleDiscapacitado();
        });
        toggleNacionalidad.selectedProperty().addListener((e) -> {
            codigoToogleNacionalidad();
        });
        toggleProvincia.selectedProperty().addListener((e) -> {
            codigoToogleProvincia();
        });
        toggleCiudad.selectedProperty().addListener((e) -> {
            codigoToogleCiudad();
        });
        toggleCalle.selectedProperty().addListener((e) -> {
            codigoToogleCalle();
        });
        toggleNumero.selectedProperty().addListener((e) -> {
            codigoToogleNumero();
        });
        toggleCodigoPostal.selectedProperty().addListener((e) -> {
            codigoToogleCodigoPostal();
        });
        toggleDni.selectedProperty().addListener((e) -> {
            codigoToogleDni();
        });
        togglePasaporte.selectedProperty().addListener((e) -> {
            codigoTooglePasaporte();
        });
        toggleExpPasaporte.selectedProperty().addListener((e) -> {
            codigoToogleExpPasaporte();
        });
        togglePaginaWeb.selectedProperty().addListener((e) -> {
            codigoTooglePaginaWeb();
        });
        toggleEmail.selectedProperty().addListener((e) -> {
            codigoToogleEmail();
        });
        toggleTratamiento.selectedProperty().addListener((e) -> {
            codigoToogleTratamiento();
        });
        toggleCategoría.selectedProperty().addListener((e) -> {
            codigoToogleCategoria();
        });

        categoria.setItems(Registro.ListaCategoriaCliente);
        categoria.getSelectionModel().selectFirst();
        tratamiento.setItems(Registro.ListaTratamiento);
        tratamiento.getSelectionModel().selectFirst();
        nacionalidad.setItems(Registro.listaPaises);
        nacionalidad.getSelectionModel().selectFirst();

        listaPersonas = PruebasModelo.getListaDeHuespedes();
        listaTablaHuespedes = TablaHuesped.getTablaBuscadorHuesped(listaPersonas);

        tabla.setItems(FXCollections.observableArrayList(listaTablaHuespedes));

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

        tabla.getSelectionModel().selectedIndexProperty().addListener((observable) -> {
            tablaOnSelectedItem();
        });

        borrar.setOnAction((e) -> {
            codigoBorrar();

        });

        crear.setOnAction((e) -> {
            codigoInsertar();

        });
        actualizar.setOnAction((e) -> {
            codigoActualizar();
        });

        seleccionar.setOnAction((e) -> {
            codigoSeleccionar();

        });
        aceptar.setOnAction((e) -> {
            codigoAceptar();
        });
        resetarCampos.setOnAction((e) -> {
            codigoResetearCampos();
        });
        telefono.setOnAction((e) -> {
            codigoTelefono();
        });
        ver.setOnAction((e) -> {
            codigoVer();
        });

    }

    private void codigoToogleNombre() {
        if (toggleNombre.isSelected()) {
            nombre.setDisable(false);
            enciendeToggle();
        } else {
            nombre.setDisable(true);
            nombre.setText("");
            configuraBotones();
        }
    }

    private void codigoTooglePrimerApellido() {
        if (togglePrimerApellido.isSelected()) {
            primerApellido.setDisable(false);
            enciendeToggle();
        } else {
            primerApellido.setDisable(true);
            primerApellido.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleSegundoApellido() {
        if (toggleSegundoApellido.isSelected()) {
            segundoApellido.setDisable(false);
            enciendeToggle();
        } else {
            segundoApellido.setDisable(true);
            segundoApellido.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleFNacimiento() {
        if (toggleFnacimiento.isSelected()) {
            fechaNacimiento.setDisable(false);
            enciendeToggle();
        } else {
            fechaNacimiento.setDisable(true);
            fechaNacimiento.setValue(null);
            configuraBotones();
        }
    }

    private void codigoToogleSexo() {
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

    private void codigoToogleDiscapacitado() {
        if (toggleDiscapacitado.isSelected()) {
            discapacitadoNo.setDisable(false);
            discapacitadoSi.setDisable(false);
            enciendeToggle();
        } else {
            discapacitadoNo.setDisable(true);
            discapacitadoSi.setDisable(true);
            discapacitadoNo.setSelected(true);
            configuraBotones();
        }
    }

    private void codigoToogleNacionalidad() {
        if (toggleNacionalidad.isSelected()) {
            nacionalidad.setDisable(false);
            enciendeToggle();
        } else {
            nacionalidad.setDisable(true);
            nacionalidad.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToogleProvincia() {
        if (toggleProvincia.isSelected()) {
            provincia.setDisable(false);
            enciendeToggle();
        } else {
            provincia.setDisable(true);
            provincia.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleCiudad() {
        if (toggleCiudad.isSelected()) {
            ciudad.setDisable(false);
            enciendeToggle();
        } else {
            ciudad.setDisable(true);
            ciudad.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleCalle() {
        if (toggleCalle.isSelected()) {
            calle.setDisable(false);
            enciendeToggle();
        } else {
            calle.setDisable(true);
            calle.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleNumero() {
        if (toggleNumero.isSelected()) {
            numero.setDisable(false);
            enciendeToggle();
        } else {
            numero.setDisable(true);
            numero.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleCodigoPostal() {
        if (toggleCodigoPostal.isSelected()) {
            codigoPostal.setDisable(false);
            enciendeToggle();
        } else {
            codigoPostal.setDisable(true);
            codigoPostal.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleDni() {
        if (toggleDni.isSelected()) {
            dni.setDisable(false);
            enciendeToggle();
        } else {
            dni.setDisable(true);
            dni.setText("");
            configuraBotones();
        }
    }

    private void codigoTooglePasaporte() {
        if (togglePasaporte.isSelected()) {
            pasaporte.setDisable(false);
            enciendeToggle();
        } else {
            pasaporte.setDisable(true);
            pasaporte.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleExpPasaporte() {
        if (toggleExpPasaporte.isSelected()) {
            fechaExpedicion.setDisable(false);
            enciendeToggle();
        } else {
            fechaExpedicion.setDisable(true);
            fechaExpedicion.setValue(null);
            configuraBotones();
        }
    }

    private void codigoTooglePaginaWeb() {
        if (togglePaginaWeb.isSelected()) {
            paginaWeb.setDisable(false);
            enciendeToggle();
        } else {
            paginaWeb.setDisable(true);
            paginaWeb.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleEmail() {
        if (toggleEmail.isSelected()) {
            correoElectronico.setDisable(false);
            enciendeToggle();
        } else {
            correoElectronico.setDisable(true);
            correoElectronico.setText("");
            configuraBotones();
        }
    }

    private void codigoToogleTratamiento() {
        if (toggleTratamiento.isSelected()) {
            tratamiento.setDisable(false);
            enciendeToggle();
        } else {
            tratamiento.setDisable(true);
            tratamiento.getSelectionModel().selectFirst();
            configuraBotones();
        }
    }

    private void codigoToogleCategoria() {
        if (toggleCategoría.isSelected()) {
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "seguro que quiere eliminar a el usuario:",
                ButtonType.NO, ButtonType.YES);
        alert.show();
    }

    private void codigoActualizar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuesped) obj.getfXMLLoader().getController()).setHuespedEnVista(huespedEnVista).
                    setModoFormulario(Ventanas.MODO_ACTUALIZAR);
            obj.ver();
        }
    }

    private void codigoInsertar() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuesped) obj.getfXMLLoader().getController()).
                    setModoFormulario(Ventanas.MODO_INSERTAR);
            obj.ver();
        }
    }

    private void codigoAceptar() {
        if (modoVentana == Ventanas.MODO_SELECCIONAR) {
            boolean estaEscogido = false;
            if (!listaTodosLosHuespedes.isEmpty()) {
                for (Persona p : listaTodosLosHuespedes) {
                    if (p.getCodPersona().equals(huespedEnVista.getCodPersona())) {
                        estaEscogido = true;
                        break;
                    }
                }
            }
            if (estaEscogido == false) {
                listaAddHuesped.add(huespedEnVista);
                listaAddTablaHuesped.clear();
                listaAddTablaHuesped.addAll(TablaHuesped.getTablaBuscadorHuesped(listaAddHuesped));
                Ventanas.cerrarVentana(Ventanas.HUESPED_BUSCADOR);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Este huesped ya ha sido escogido "
                        + "debe de seleccionar a otro o salir de de este menú ", ButtonType.CLOSE);
                alert.show();
            }
        }
    }

    private void codigoResetearCampos() {
        RecorredorPaneles.reseteaControles(panelPrincipal);
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
            resetarCampos.setDisable(false);
            seleccionar.setDisable(false);
        } else {
            resetarCampos.setDisable(true);
            seleccionar.setDisable(true);
        }
    }

    public void enciendeToggle() {
        seleccionar.setDisable(false);
        resetarCampos.setDisable(false);
    }

    public void tablaOnSelectedItem() {
        aceptar.setDisable(false);
        actualizar.setDisable(false);
        borrar.setDisable(false);
        telefono.setDisable(false);
        ver.setDisable(false);
        huespedEnVista = listaPersonas.get(tabla.getSelectionModel().getSelectedIndex());
    }

    public void codigoTelefono() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefonoBuscador(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoVer() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.HUESPED_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuesped) obj.getfXMLLoader().getController()).setHuespedEnVista(huespedEnVista).
                    setModoFormulario(Ventanas.MODO_VER);
            obj.ver();
        }
    }

    public ControladorHuespedBuscador setListaHuesped(ObservableList<Persona> listaHuesped, ObservableList<TablaHuesped> listaTablaHuesped, ObservableList<Persona> listaTodosLosHuespedes) {
        this.listaAddHuesped = listaHuesped;
        this.listaAddTablaHuesped = listaTablaHuesped;
        this.listaTodosLosHuespedes = listaTodosLosHuespedes;
        return this;
    }

    public ControladorHuespedBuscador setModoVentana(int modoVentana) {
        this.modoVentana = modoVentana;
        return this;
    }

}
