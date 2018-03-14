package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ContoladorVentanaReserva implements Initializable {
    
 @FXML
    Button crear, actualizar, borrar;
 
 @FXML
 TextArea comentario;
 
 @FXML
 DatePicker fechaInicio, FechaFin;
 
 @FXML
 ComboBox numeroPersonas;
 
 @FXML
 TextField algo;

    public ContoladorVentanaReserva(Button crear, Button actualizar, Button borrar, TextArea comentario, DatePicker fechaInicio, DatePicker FechaFin) {
        this.crear = crear;
        this.actualizar = actualizar;
        this.borrar = borrar;
        this.comentario = comentario;
        this.fechaInicio = fechaInicio;
        this.FechaFin = FechaFin;
    }

    public ContoladorVentanaReserva() {
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void accionAdd(){
        
    }
    private void accionActualizar(){
        
    }
    private void accionBorrar(){
        
    }
}
