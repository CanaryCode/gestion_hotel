package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorReservaCheckIn implements Initializable {

    @FXML
    private TextField cliente, reserva;
    
    @FXML
    private Button buscar, resetearCampos, checkIn, addReserva;

    @FXML
    private TableColumn tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada, tableColumnFechaPrevistaSalida, tableColumnHuesped;
    
    @FXML
    private TableView<Persona> tabla;
    ObservableList<Persona> listaPendientesCheckIn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscar.setOnAction((event) -> {
            accionBuscar();
        });
        resetearCampos.setOnAction((event) -> {
            accionCampos();
        });
        checkIn.setOnAction((event) -> {
            accionCheckIn();
        });
        addReserva.setOnAction((event) -> {
            accionReserva();
        });
        
        cargarTableColumns();
        activaBotonesBuscarYResetea();
        
        
        listaPendientesCheckIn =FXCollections.observableArrayList(Consultas.personasPendientesDeCheckIn(Consultas.pendienteDeCheckIn, Persona.class));
        tabla.setItems(listaPendientesCheckIn);
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
    }

    private void accionBuscar() {

    }
    private void accionCampos() {
        reserva.setText("");
        cliente.setText("");

    }
    private void accionCheckIn() {
      new Ventanas().abrirVentanaHuespedReserva(Ventanas.ventanaReservaCheckIn, Modality.APPLICATION_MODAL);
    }
    private void accionReserva() {
     new Ventanas().abrirVentanaAddReserva(Ventanas.ventanaReservaCheckIn, Modality.APPLICATION_MODAL);
    }
    private void activaBotonesBuscarYResetea(){
        List ticList = Arrays.asList(new TextInputControl[]{
            reserva, cliente }); 
    
        ActivadorDeControles.addActivador(ticList, resetearCampos,buscar);
    }
    private void cargarTableColumns(){
        
    }
}
