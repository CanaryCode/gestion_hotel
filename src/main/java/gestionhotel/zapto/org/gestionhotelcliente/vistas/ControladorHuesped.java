package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    ComboBox  categoria, tratamiento, nacionalidad;

    @FXML
    TextArea comentario;

    @FXML
    DatePicker fechaNacimiento, ExpedicionPasaporte;

    @FXML
    RadioButton sexoM, sexoF, discapacitadoSi, discapacitadoNo;

    @FXML
    Button aceptar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tratamiento.setItems(FXCollections.observableArrayList(Registro.ListaTratamiento));
        tratamiento.getSelectionModel().selectFirst();
        categoria.setItems(FXCollections.observableArrayList(Registro.listaCategoriaHuesped));
        categoria.getSelectionModel().selectFirst();
        nacionalidad.setItems(FXCollections.observableArrayList(Registro.listaPaises));
        nacionalidad.getSelectionModel().selectFirst();
        aceptar.setOnAction((event) -> {
            accionAdd();
        });
  
    }

    private void accionAdd() {

    }

    private void accionActualizar() {

    }

    private void accionBorrar() {

    }

}
