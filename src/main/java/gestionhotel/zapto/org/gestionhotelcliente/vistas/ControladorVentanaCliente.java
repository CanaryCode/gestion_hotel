package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorVentanaCliente implements Initializable {

    @FXML
    private TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, codigoPostal, cif, nombreEmpresa, paginaWeb,
            dni;

    @FXML
    private TextArea comentario;

    @FXML
    private ComboBox estado, razonSocial, categoria, tratamiento, nacionalidad;

    @FXML
    private DatePicker fechaNacimiento;

    @FXML
    private RadioButton sexoM, sexoF;

    @FXML
    private Button aceptar, reseteaCampos;
    @FXML
    private AnchorPane principal;

    @FXML
    private TabPane tabPanel;
    @FXML
    private Tab tabPersona, tabEmpresa;

    public ControladorVentanaCliente() {
    }
    private int modoFormulario;
    private Persona clienteEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estado.setItems(Registro.listaPaises);
        estado.getSelectionModel().selectFirst();
        tratamiento.setItems(Registro.ListaTratamiento);
        tratamiento.getSelectionModel().selectFirst();
        categoria.setItems(Registro.ListaCategoriaCliente);
        categoria.getSelectionModel().selectFirst();
        nacionalidad.setItems(Registro.listaPaises);
        nacionalidad.getSelectionModel().selectFirst();
        razonSocial.setItems(Registro.ListaRazonSocial);
        razonSocial.getSelectionModel().selectFirst();

        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        tabPanel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            codigoTabPanel(oldValue);
        });

    }

    private void configurarModo() {
        if (modoFormulario == Ventanas.MODO_ACTUALIZAR) {
            aceptar.setOnAction((event) -> {
                //entonces cuando termines, de  hacerlo cierra la ventana.
                Ventanas.cerrarVentana(Ventanas.CLIENTE);
                //si se está insertando a una persona
            });
            reseteaCampos.setDisable(true);

        } else if (modoFormulario == Ventanas.MODO_INSERTAR) {
            aceptar.setOnAction((event) -> {
                //entonces resetea todos los campos.
                codigoResetearCampos();
            });

        } else if (modoFormulario == Ventanas.MODO_VER) {
            deshabilitaEditables();
            deshabilitaBotones();
        }
    }

    private void codigoResetearCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }

    public ControladorVentanaCliente setModoFormulario(int modoFormulario) {
        this.modoFormulario = modoFormulario;
        configurarModo();
        return this;
    }

    private void codigoReseteaCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }

    private void codigoTabPanel(Tab viejo) {
        RecorredorPaneles.reseteaControles((Pane) viejo.getContent());
    }

    public ControladorVentanaCliente setClienteEnVista(Persona cliente) {
        clienteEnVista = cliente;
        if (cliente.getNombre() != null) {
            if (cliente.getEsEmpresa() == 0) {
                nombre.setText(cliente.getNombre());
            } else {
                nombreEmpresa.setText(cliente.getNombre());
            }
        }
        if (cliente.getFisPrimerApellido() != null) {
            primerApellido.setText(cliente.getFisPrimerApellido());
        }
        if (cliente.getFisSegundoApellido() != null) {
            segundoApellido.setText(cliente.getFisSegundoApellido());
        }
        if (cliente.getDocumentoNumero() != null) {
            if (cliente.getEsEmpresa() == 0) {
                dni.setText(cliente.getDocumentoNumero());
            } else {
                cif.setText(cliente.getDocumentoNumero());
            }
        }
        if (cliente.getProvincia() != null) {
            provincia.setText(cliente.getProvincia());
        }
        if (cliente.getCodPostal() != null) {
            codigoPostal.setText(cliente.getCodPostal());
        }
        if (cliente.getEmail() != null) {
            correoElectronico.setText(cliente.getEmail());
        }
        if (cliente.getCalle() != null) {
            calle.setText(cliente.getCalle());
        }
        if (cliente.getCiudad() != null) {
            ciudad.setText(cliente.getCiudad());
        }
        if (cliente.getComentario() != null) {
            comentario.setText(cliente.getComentario());
        }
        if (cliente.getNumero() != null) {
            numero.setText(cliente.getNumero());
        }
        if (cliente.getPaginaWeb() != null) {
            paginaWeb.setText(cliente.getPaginaWeb());
        }
        /**
         * --------------------------------------------------------
         */
        if (cliente.getFisNacionalidad() != null) {
            for (Object obj : nacionalidad.getItems()) {
                if (((String) obj).equals(cliente.getFisNacionalidad())) {
                    nacionalidad.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (cliente.getFisNacionalidad() != null) {
            for (Object obj : estado.getItems()) {
                if (((String) obj).equals(cliente.getFisNacionalidad())) {
                    estado.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (cliente.getFisTratamiento() != null) {
            for (Object obj : tratamiento.getItems()) {
                if (((String) obj).equals(cliente.getFisTratamiento())) {
                    tratamiento.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (cliente.getCategoria() != null) {
            for (Object obj : categoria.getItems()) {
                if (((String) obj).equals(cliente.getCategoria())) {
                    categoria.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (cliente.getJurRazonSocial() != null) {
            for (Object obj : razonSocial.getItems()) {
                if (((String) obj).equals(cliente.getFisNacionalidad())) {
                    razonSocial.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        /**
         * ----------------------------------------------------------------------------
         */
        if (cliente.getEsEmpresa() != null) {
            if (cliente.getEsEmpresa() == 0) {
                tabPanel.getSelectionModel().select(tabPersona);
                tabEmpresa.setDisable(true);
            } else {
                tabPanel.getSelectionModel().select(tabEmpresa);
                tabPersona.setDisable(true);
            }
        }
        if (cliente.getFisSexoHombre() != null) {
            if (cliente.getFisSexoHombre() == 0) {
                sexoF.setSelected(true);
            }
        }
        if (cliente.getFisFechaNacimiento() != null) {
            fechaNacimiento.setValue(new Date(cliente.getFisFechaNacimiento().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        return this;
    }

    private void deshabilitaEditables() {
//        nombre.setEditable(false);
//        primerApellido.setEditable(false);
//        segundoApellido.setEditable(false);
//        dni.setEditable(false);
//        provincia.setEditable(false);
//        codigoPostal.setEditable(false);
//        correoElectronico.setEditable(false);
//        calle.setEditable(false);
//        ciudad.setEditable(false);
//        comentario.setEditable(false);
//        numero.setEditable(false);
//        paginaWeb.setEditable(false);
//        nacionalidad.setEditable(false);
//        estado.setEditable(false);
//        tratamiento.setEditable(false);
//        categoria.setEditable(false);
//        razonSocial.setEditable(false);
//        sexoF.setDisable(false);
//        sexoM.setDisable(false);
//        fechaNacimiento.setEditable(false);
        RecorredorPaneles.setOnlyReadsInputs(principal);
    }

    private void deshabilitaBotones() {
        aceptar.setDisable(true);
        reseteaCampos.setDisable(true);
    }
}
