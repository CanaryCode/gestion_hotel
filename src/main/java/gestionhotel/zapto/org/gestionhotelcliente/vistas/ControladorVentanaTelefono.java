package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorVentanaTelefono implements Initializable {

    @FXML
    private TextField numero, nombre;

    @FXML
    private ComboBox<?> tipo;

    @FXML
    private TextArea comentario;

    @FXML
    private Button reseteaCampos, aceptar;
    private int modoVentana;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tipo.setItems(Registro.ListaTipoTelefono);
        tipo.getSelectionModel().selectFirst();
        reseteaCampos.setOnAction((event) -> {
            codigoResetarCampos();
        });
        aceptar.setOnAction((event) -> {
            codigoAceptar();
        });

        ConfiguraModo();
    }

    private void ConfiguraModo() {
        if (modoVentana == Ventanas.MODO_INSERTAR) {

        } else if (modoVentana == Ventanas.MODO_ACTUALIZAR) {
            reseteaCampos.setDisable(true);
        } else if (modoVentana == Ventanas.MODO_VER) {
            deshabilitaBotones();
        }
    }

    private void codigoAceptar() {

    }

    private void codigoResetarCampos() {

    }

    public ControladorVentanaTelefono setModoFormulario(int modo) {
        this.modoVentana = modo;
        return this;
    }

    public void deshabilitaBotones() {
        aceptar.setDisable(true);
        reseteaCampos.setDisable(true);
    }

}
