package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
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
public class ControladorHabitacionFormulario implements Initializable {

    @FXML
    private TextField numeroHabitacion;
    @FXML
    private ComboBox tipoHabitacion, vistas, tipoCama;

    @FXML
    private TextArea comentario;

    @FXML
    private Button reseteaCampos, aceptar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoHabitacion.setItems(Registro.ListaTipoHabitacion);
        tipoHabitacion.getSelectionModel().selectFirst();
        vistas.setItems(Registro.ListaVistas);
        vistas.getSelectionModel().selectFirst();
        tipoCama.setItems(Registro.ListaTipoCama);
        tipoCama.getSelectionModel().selectFirst();
        //-------------------------------
         reseteaCampos.setOnAction((event) -> {
             codigoReseteaCampos();
         });
         aceptar.setOnAction((event) -> {
             codigoAceptar();
         });
    }
private void codigoReseteaCampos(){
    
}
private void codigoAceptar(){
    
}
}
