package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ContoladorVentanaReserva implements Initializable {

    @FXML
    private DatePicker fechaInicio, fechaFin;

    @FXML
    private ComboBox numeroPersonas, tipoCama, pension,
            tipoHabitacion,agencia,tipoTarjeta;

    @FXML
    private TextArea comentario;

    @FXML
    private Button confirmar, buscarCliente;
    
    @FXML
    TextField numeroAgencia;

    public ContoladorVentanaReserva() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    buscarCliente.setOnAction((e)->{
        accionBuscarCliente();
    });
    
    
    numeroPersonas.setItems(FXCollections.observableList(Registro.ListaNumeroPersonas));
    numeroPersonas.getSelectionModel().selectFirst();
    tipoCama.setItems(FXCollections.observableList(Registro.ListaTipoCama));
    tipoCama.getSelectionModel().selectFirst();
    pension.setItems(FXCollections.observableList(Registro.ListaPension));
    pension.getSelectionModel().selectFirst();
    tipoHabitacion.setItems(FXCollections.observableList(Registro.ListaTipoHabitacion));
    tipoHabitacion.getSelectionModel().selectFirst();
    agencia.setItems(FXCollections.observableList(Registro.ListaAgencia));
    agencia.getSelectionModel().selectFirst();
    tipoTarjeta.setItems(FXCollections.observableList(Registro.ListaTipoTarjeta));
    tipoTarjeta.getSelectionModel().selectFirst();
    }

    private void accionConfirmar() {

    }

    private void accionBuscarCliente() {
        VentanasFactory.getObjetoVentanaBuscarCliente("ventanaAddReserva", Modality.APPLICATION_MODAL,null);
    }
  

}
