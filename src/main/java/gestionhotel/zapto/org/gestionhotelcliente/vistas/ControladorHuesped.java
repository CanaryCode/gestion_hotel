package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.tablas.Huesped;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorHuesped implements Initializable {

    @FXML
    TextField nombre, primerApellido, segundoApellido, calle, numero, provincia, ciudad,
            correoElectronico, telefonoMovil, telefonoFijo, codigoPostal, dni;
    @FXML
    ComboBox categoria, tratamiento, nacionalidad;

    @FXML
    TextArea comentario;

    @FXML
    DatePicker fechaNacimiento, ExpedicionPasaporte;

    @FXML
    RadioButton sexoM, sexoF, discapacitadoSi, discapacitadoNo;

    @FXML
    Button aceptar, reseteaCampos;
    @FXML
    AnchorPane principal;

    private Huesped huespedEnVista;
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
}
