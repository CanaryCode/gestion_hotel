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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorHuesped implements Initializable {

    @FXML
    TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, paginaWeb, codigoPostal, dni, pasaporte;
    @FXML
    ComboBox categoria, tratamiento, nacionalidad;

    @FXML
    TextArea comentario;

    @FXML
    DatePicker fechaNacimiento, fechaExpedicion;

    @FXML
    RadioButton sexoM, sexoF, discapacitadoSi, discapacitadoNo;

    @FXML
    Button aceptar, reseteaCampos;
    @FXML
    AnchorPane principal;
    private int modoFormulario;
    private Persona huespedEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tratamiento.setItems(Registro.ListaTratamiento);
        tratamiento.getSelectionModel().selectFirst();
        categoria.setItems(Registro.listaCategoriaHuesped);
        categoria.getSelectionModel().selectFirst();
        nacionalidad.setItems(Registro.listaPaises);
        nacionalidad.getSelectionModel().selectFirst();
        reseteaCampos.setOnAction((event) -> {
            codigoResetearCampos();
        });
    }

    private void configurarModo() {
        if (modoFormulario == Ventanas.MODO_ACTUALIZAR) {
            aceptar.setOnAction((event) -> {
                //entonces cuando termines, de  hacerlo cierra la ventana.
                Ventanas.cerrarVentana(Ventanas.HUESPED);
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

    public ControladorHuesped setModoFormulario(int modoFormulario) {
        this.modoFormulario = modoFormulario;
        configurarModo();
        return this;
    }

    public void codigoResetearCampos() {
        RecorredorPaneles.reseteaControles(principal);

    }

    public ControladorHuesped setHuespedEnVista(Persona huesped) {
        huespedEnVista = huesped;
        if (huesped.getNombre() != null) {
            nombre.setText(huesped.getNombre());
        }

        if (huesped.getFisPrimerApellido() != null) {
            primerApellido.setText(huesped.getFisPrimerApellido());
        }

        if (huesped.getFisSegundoApellido() != null) {
            segundoApellido.setText(huesped.getFisSegundoApellido());
        }

        if (huesped.getDocumentoNumero() != null) {
            dni.setText(huesped.getDocumentoNumero());
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
        if (huesped.getPasaporte() != null) {
            pasaporte.setText(huesped.getPasaporte());
        }
        if (huesped.getPaginaWeb() != null) {
            paginaWeb.setText(huesped.getPaginaWeb());
        }
        /**
         * --------------------------------------------------------------
         */
        if (huesped.getFisNacionalidad() != null) {
            for (Object obj : nacionalidad.getItems()) {
                if (((String) obj).equals(huesped.getFisNacionalidad())) {
                    nacionalidad.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (huesped.getFisTratamiento() != null) {
            for (Object obj : tratamiento.getItems()) {
                if (((String) obj).equals(huesped.getFisTratamiento())) {
                    tratamiento.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        if (huesped.getCategoria() != null) {
            for (Object obj : categoria.getItems()) {
                if (((String) obj).equals(huesped.getCategoria())) {
                    categoria.getSelectionModel().select(obj);
                    break;
                }
            }
        }
        /**
         * --------------------------------------------------------------
         */
        if (huesped.getFisDiscapacitado() != null) {
            if (huesped.getFisDiscapacitado() == 1) {
                discapacitadoSi.setSelected(true);
            }
        }

        if (huesped.getFisSexoHombre() != null) {
            if (huesped.getFisSexoHombre() == 0) {
                sexoF.setSelected(true);
            }
        }
        /**
         * -----------------------------------------------------------------
         */
        if (huesped.getFisFechaNacimiento() != null) {
            fechaNacimiento.setValue(new Date(huesped.getFisFechaNacimiento().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        if (huesped.getFisExpPasaporte() != null) {
            fechaExpedicion.setValue(new Date(huesped.getFisExpPasaporte().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
//        pasaporte.setEditable(false);
//        paginaWeb.setEditable(false);
//        nacionalidad.setEditable(false);
//        tratamiento.setEditable(false);
//        categoria.setEditable(false);
//        discapacitadoSi.setDisable(false);
//        discapacitadoNo.setDisable(false);
//        sexoF.setDisable(false);
//        sexoM.setDisable(false);
//        /**
//         * -----------------------------------------------------------------
//         */
//        fechaNacimiento.setEditable(false);
//        fechaExpedicion.setEditable(false);

        RecorredorPaneles.setEditableFalseControles(principal);
    }

    private void deshabilitaBotones() {
        aceptar.setDisable(true);
        reseteaCampos.setDisable(true);
    }
}
