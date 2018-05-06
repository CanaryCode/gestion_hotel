package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.hibernate.criterion.Expression;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorHuesped implements Initializable {

    @FXML
    TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, telefonoMovil, telefonoFijo, codigoPostal, dni, pasaporte;
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
    private boolean accionInsertar = true;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tratamiento.setItems(Registro.ListaTratamiento);
        tratamiento.getSelectionModel().selectFirst();
        categoria.setItems(Registro.listaCategoriaHuesped);
        categoria.getSelectionModel().selectFirst();
        nacionalidad.setItems(Registro.listaPaises);
        nacionalidad.getSelectionModel().selectFirst();
        aceptar.setOnAction((event) -> {
            accionAdd(event);
        });
        reseteaCampos.setOnAction((event) -> {
            codigoResetearCampos();
        });
    }

    private void accionAdd(Event e) {
        //si se esta actualizando la información de un huesped
        if (!accionInsertar) {
            //entonces cuando termines, de  hacerlo cierra la ventana.
            Ventanas.cerrarVentana(Ventanas.HUESPED);
            //si se está insertando a una persona
        } else {
            //entonces resetea todos los campos.
            codigoResetearCampos();
        }
    }

    public void setAccionInsertar(boolean accionInsertar) {
        this.accionInsertar = accionInsertar;
    }

    public void codigoResetearCampos() {
        RecorredorPaneles.reseteaControles(principal);

    }

    public void setHuespedEnVista(Persona huesped) {
        nombre.setText(huesped.getNombre());
        primerApellido.setText(huesped.getFisPrimerApellido());
        segundoApellido.setText(huesped.getFisSegundoApellido());
        dni.setText(huesped.getDocumentoNumero());
        for (Object obj : nacionalidad.getItems()) {
            if (((String) obj).equals(huesped.getFisNacionalidad())) {
                nacionalidad.getSelectionModel().select(obj);
            }
        }
        for (Object obj : tratamiento.getItems()) {
            if (((String) obj).equals(huesped.getFisTratamiento())) {
                tratamiento.getSelectionModel().select(obj);
            }
        }
        for (Object obj : categoria.getItems()) {
            if (((String) obj).equals(huesped.getCategoria())) {
                categoria.getSelectionModel().select(obj);
            }
        }

        fechaNacimiento.setValue(new Date(huesped.getFisFechaNacimiento().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        fechaExpedicion.setValue(new Date(huesped.getFisExpPasaporte().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        if (huesped.getFisSexoHombre().equals("hombre")) {
            sexoM.setSelected(true);
        } else {
            sexoM.setSelected(true);
        }
        if (huesped.getFisDiscapacitado().equals("Discapacitado")) {
            discapacitadoSi.setSelected(true);
        } else {
            discapacitadoNo.setSelected(true);
        }
        nacionalidad.getSelectionModel().select(huesped.getFisNacionalidad());
        tratamiento.getSelectionModel().select(huesped.getFisTratamiento());
        pasaporte.setText(huesped.getPasaporte());
        provincia.setText(huesped.getProvincia());
        codigoPostal.setText(huesped.getCodPostal());
        correoElectronico.setText(huesped.getEmail());
        calle.setText(huesped.getCalle());
        ciudad.setText(huesped.getCiudad());
        pasaporte.setText(huesped.getPasaporte());
        comentario.setText(huesped.getComentario());
        numero.setText(huesped.getNumero());
    }
}
