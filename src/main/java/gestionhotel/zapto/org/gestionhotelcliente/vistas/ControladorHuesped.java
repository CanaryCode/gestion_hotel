package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    ComboBox estado, categoria, tratamiento, nacionalidad;

    @FXML
    TextArea comentario;

    @FXML
    DatePicker fechaNacimiento, ExpedicionPasaporte;

    @FXML
    RadioButton sexoM, sexoF, discapacitadoSi, discapacitadoNo;

    @FXML
    Button add, actualizar, borrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add.setOnAction((event) -> {
            accionAdd();
        });
        actualizar.setOnAction((event) -> {
            accionActualizar();
        });
        borrar.setOnAction((event) -> {
            accionBorrar();
        });
    }

    private void accionAdd() {

    }

    private void accionActualizar() {

    }

    private void accionBorrar() {

    }

}
