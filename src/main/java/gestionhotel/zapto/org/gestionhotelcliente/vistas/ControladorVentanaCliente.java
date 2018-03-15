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
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Button add, actualizar, borrar;

    @FXML
    private Tab tabPersona, tabEmpresa;

    public ControladorVentanaCliente() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        estado.setItems(FXCollections.observableArrayList(Registro.listaPaises));
        estado.getSelectionModel().selectFirst();
        tratamiento.setItems(FXCollections.observableArrayList(Registro.ListaTratamiento));
        tratamiento.getSelectionModel().selectFirst();
        categoria.setItems(FXCollections.observableArrayList(Registro.ListaCategoriaClente));
        categoria.getSelectionModel().selectFirst();
        nacionalidad.setItems(FXCollections.observableArrayList(Registro.listaPaises));
        nacionalidad.getSelectionModel().selectFirst();
        razonSocial.setItems(FXCollections.observableArrayList(Registro.ListaRazonSocial));
        razonSocial.getSelectionModel().selectFirst();
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
    
    private void accionAdd(){
        
    }
    private void accionActualizar(){
        
    }
    private void accionBorrar(){
        
    }

}
