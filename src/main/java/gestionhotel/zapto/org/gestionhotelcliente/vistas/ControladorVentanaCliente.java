package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import java.net.URL;
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
    private Button add, reseteaCampos;
    @FXML
    private AnchorPane principal;

    @FXML
    private TabPane tabPanel;

    public ControladorVentanaCliente() {
    }

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
        add.setOnAction((event) -> {
            accionAdd();
        });
        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        tabPanel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            codigoTabPanel(oldValue);
        });
    }

    private void accionAdd() {

    }

    private void codigoReseteaCampos() {
        RecorredorPaneles.reseteaControles(principal);
    }
    private void codigoTabPanel(Tab viejo){
        RecorredorPaneles.reseteaControles((Pane)viejo.getContent());
    }
}
