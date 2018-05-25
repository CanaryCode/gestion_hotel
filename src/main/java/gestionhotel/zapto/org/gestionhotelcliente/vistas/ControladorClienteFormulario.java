package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
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
public class ControladorClienteFormulario implements Initializable, FormularioInterface {

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

    public ControladorClienteFormulario() {
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
                Ventanas.cerrarVentana(Ventanas.CLIENTE_FORMULARIO);
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

    private void codigoReseteaCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }

    private void codigoTabPanel(Tab viejo) {
        RecorredorPaneles.reseteaControles((Pane) viejo.getContent());
    }

    private void deshabilitaEditables() {
        RecorredorPaneles.setOnlyReadsInputs(principal);
    }

    private void deshabilitaBotones() {
        aceptar.setDisable(true);
        reseteaCampos.setDisable(true);
    }

    @Override
    public ControladorClienteFormulario setObjetoEnVista(Object objetoEnVista) {
         clienteEnVista=(Persona) objetoEnVista;
        if (clienteEnVista.getNombre() != null && clienteEnVista.getEsEmpresa() != null) {
            if (clienteEnVista.getEsEmpresa() == 0) {
                nombre.setText(clienteEnVista.getNombre());
            } else {
                nombreEmpresa.setText(clienteEnVista.getNombre());
            }
        }
        if (clienteEnVista.getFisPrimerApellido() != null) {
            primerApellido.setText(clienteEnVista.getFisPrimerApellido());
        }
        if (clienteEnVista.getFisSegundoApellido() != null) {
            segundoApellido.setText(clienteEnVista.getFisSegundoApellido());
        }
        if (clienteEnVista.getDocumentoNumero() != null && clienteEnVista.getEsEmpresa() != null) {
            if (clienteEnVista.getEsEmpresa() == 0) {
                dni.setText(clienteEnVista.getDocumentoNumero());
            } else {
                cif.setText(clienteEnVista.getDocumentoNumero());
            }
        }
        if (clienteEnVista.getProvincia() != null) {
            provincia.setText(clienteEnVista.getProvincia());
        }
        if (clienteEnVista.getCodPostal() != null) {
            codigoPostal.setText(clienteEnVista.getCodPostal());
        }
        if (clienteEnVista.getEmail() != null) {
            correoElectronico.setText(clienteEnVista.getEmail());
        }
        if (clienteEnVista.getCalle() != null) {
            calle.setText(clienteEnVista.getCalle());
        }
        if (clienteEnVista.getCiudad() != null) {
            ciudad.setText(clienteEnVista.getCiudad());
        }
        if (clienteEnVista.getComentario() != null) {
            comentario.setText(clienteEnVista.getComentario());
        }
        if (clienteEnVista.getNumero() != null) {
            numero.setText(clienteEnVista.getNumero());
        }
        if (clienteEnVista.getPaginaWeb() != null) {
            paginaWeb.setText(clienteEnVista.getPaginaWeb());
        }
        /**
         * --------------------------------------------------------
         */
        if (clienteEnVista.getFisNacionalidad() != null) {
            for (Object obj : nacionalidad.getItems()) {
                if (((String) obj).equals(clienteEnVista.getFisNacionalidad())) {
                    nacionalidad.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (clienteEnVista.getEstado() != null) {
            for (Object obj : estado.getItems()) {
                if (((String) obj).equals(clienteEnVista.getEstado())) {
                    estado.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (clienteEnVista.getFisTratamiento() != null) {
            for (Object obj : tratamiento.getItems()) {
                if (((String) obj).equals(clienteEnVista.getFisTratamiento())) {
                    tratamiento.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (clienteEnVista.getCategoria() != null) {
            for (Object obj : categoria.getItems()) {
                if (((String) obj).equals(clienteEnVista.getCategoria())) {
                    categoria.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (clienteEnVista.getJurRazonSocial() != null) {
            for (Object obj : razonSocial.getItems()) {
                if (((String) obj).equals(clienteEnVista.getFisNacionalidad())) {
                    razonSocial.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        /**
         * ----------------------------------------------------------------------------
         */
        if (clienteEnVista.getEsEmpresa() != null) {
            if (clienteEnVista.getEsEmpresa() == 0) {
                tabPanel.getSelectionModel().select(tabPersona);
                tabEmpresa.setDisable(true);
            } else {
                tabPanel.getSelectionModel().select(tabEmpresa);
                tabPersona.setDisable(true);
            }
        }
        if (clienteEnVista.getFisSexoHombre() != null) {
            if (clienteEnVista.getFisSexoHombre() == 0) {
                sexoF.setSelected(true);
            }
        }
        if (clienteEnVista.getFisFechaNacimiento() != null) {
            fechaNacimiento.setValue(new Date(clienteEnVista.getFisFechaNacimiento().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        return this;
    }
      @Override
    public ControladorClienteFormulario setModo(int modoFormulario) {
        this.modoFormulario = modoFormulario;
        configurarModo();
        return this;
    }
}
