package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.Event;
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
            correoElectronico, telefonoMovil, telefonoFijo, codigoPostal, cif, nombreEmpresa,
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

    public ControladorVentanaCliente setClienteEnVista(Persona huesped) {
        this.modoFormulario = modoFormulario;
        if (huesped.getNombre() != null) {
            if (huesped.getEsEmpresa() == 0) {
                nombre.setText(huesped.getNombre());
            } else {
                nombreEmpresa.setText(huesped.getNombre());
            }
        }
        if (huesped.getFisPrimerApellido() != null) {
            primerApellido.setText(huesped.getFisPrimerApellido());
        }
        if (huesped.getFisSegundoApellido() != null) {
            segundoApellido.setText(huesped.getFisSegundoApellido());
        }
        if (huesped.getDocumentoNumero() != null) {
            if (huesped.getEsEmpresa() == 0) {
                dni.setText(huesped.getDocumentoNumero());
            } else {
                cif.setText(huesped.getDocumentoNumero());
            }
        }
        if (huesped.getProvincia() != null) {
            provincia.setText(huesped.getProvincia());
        }
        if (huesped.getCodPostal() != null) {
            codigoPostal.setText(huesped.getCodPostal());
        }
        if (huesped.getEmail() != null) {
            correoElectronico.setText(huesped.getEmail());
        }
        if (huesped.getCalle() != null) {
            calle.setText(huesped.getCalle());
        }
        if (huesped.getCiudad() != null) {
            ciudad.setText(huesped.getCiudad());
        }
        if (huesped.getComentario() != null) {
            comentario.setText(huesped.getComentario());
        }
        if (huesped.getNumero() != null) {
            numero.setText(huesped.getNumero());
        }
        /**
         * --------------------------------------------------------
         */
        if (huesped.getFisNacionalidad() != null) {
            for (Object obj : nacionalidad.getItems()) {
                if (((String) obj).equals(huesped.getFisNacionalidad())) {
                    nacionalidad.getSelectionModel().select(obj);
                }
            }
        }
        if (huesped.getFisNacionalidad() != null) {
            for (Object obj : estado.getItems()) {
                if (((String) obj).equals(huesped.getFisNacionalidad())) {
                    estado.getSelectionModel().select(obj);
                }
            }
        }
        if (huesped.getFisTratamiento() != null) {
            for (Object obj : tratamiento.getItems()) {
                if (((String) obj).equals(huesped.getFisTratamiento())) {
                    tratamiento.getSelectionModel().select(obj);
                }
            }
        }
        if (huesped.getCategoria() != null) {
            for (Object obj : categoria.getItems()) {
                if (((String) obj).equals(huesped.getCategoria())) {
                    categoria.getSelectionModel().select(obj);
                }
            }
        }
        if (huesped.getJurRazonSocial() != null) {
            for (Object obj : razonSocial.getItems()) {
                if (((String) obj).equals(huesped.getFisNacionalidad())) {
                    razonSocial.getSelectionModel().select(obj);
                }
            }
        }
        /**
         * ----------------------------------------------------------------------------
         */
        if (huesped.getEsEmpresa() != null) {
            if (huesped.getEsEmpresa() == 0) {
                tabPanel.getSelectionModel().select(tabPersona);
                tabEmpresa.setDisable(true);
            } else {
                tabPanel.getSelectionModel().select(tabEmpresa);
                tabPersona.setDisable(true);
            }
        }
        if (huesped.getFisSexoHombre() != null) {
            if (huesped.getFisSexoHombre() == 0) {
                sexoF.setSelected(true);
            }
        }
        if (huesped.getFisFechaNacimiento() != null) {
            fechaNacimiento.setValue(new Date(huesped.getFisFechaNacimiento().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        return this;
    }

}
