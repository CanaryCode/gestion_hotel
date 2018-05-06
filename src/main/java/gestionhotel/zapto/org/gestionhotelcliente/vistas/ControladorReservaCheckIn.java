package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCheckIn;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private Button buscar, resetearCampos, checkIn, addReserva, noShow;

    @FXML
    private TableColumn tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada;

    @FXML
    private TableView<TablaCheckIn> tabla;

    ObservableList<TablaCheckIn> listaPendientesCheckIn=FXCollections.observableArrayList(), listaFiltro=FXCollections.observableArrayList();
    List<DetallesReserva> listaReservas=FXCollections.observableArrayList();
    public DetallesReserva detallesReserva;

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
        noShow.setOnAction((event) -> {
            accionNoshow();
        });
        
        activaBotonesBuscarYResetea();
        
        listaReservas = Consultas.realizaSQLQuery(Consultas.TODOS_LOS_DETALLES_RESERVA, DetallesReserva.class);
        
        
        listaPendientesCheckIn = TablaCheckIn.modeloCheckin(listaReservas);
        listaFiltro = listaPendientesCheckIn;
        tabla.setItems(listaFiltro);
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        tableColumnFechaPrevistaEntrada.setCellValueFactory(new PropertyValueFactory("fechaPrevistaEntrada"));
        tableColumnHabitacion.setCellValueFactory(new PropertyValueFactory("habitacion"));
        tableColumnNumeroReserva.setCellValueFactory(new PropertyValueFactory("numeroReserva"));
        tableColumnTipoHabitacion.setCellValueFactory(new PropertyValueFactory("tipo"));

        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            seleccionaReservaEnVista();
            noShow.setDisable(false);
            checkIn.setDisable(false);
        });
    }

    private void seleccionaReservaEnVista() {
        for (DetallesReserva dr : listaReservas) {
            if (dr.getNombreReserva().equals(tabla.getSelectionModel().getSelectedItem().getNumeroReserva())) {
                detallesReserva = dr;
            }
        }
    }

    private void accionBuscar() {

    }

    private void accionCampos() {
        reserva.setText("");
        cliente.setText("");

    }

    private void accionCheckIn() {
        if (detallesReserva != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedReserva(Ventanas.RESERVA_CHECKIN, Modality.WINDOW_MODAL, null);
            if (obj != null) {
                ((ControladorVentanaHuespedReserva) obj.getfXMLLoader().getController()).setReserva(detallesReserva);
                obj.ver();
            }
        }
    }

    private void accionReserva() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaAddReserva(Ventanas.RESERVA_CHECKIN, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionNoshow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Seguro que quiere marcar como: \"NO-SHOW\"."
//                + "\n\na la reserva: " + detallesReserva.getReserva().getNumero()
//                + "\n\npertenciente al cliente: " + detallesReserva.getReserva().getPersonaByCodCliente().getNombre() + " "
//                + detallesReserva.getReserva().getPersonaByCodCliente().getFisPrimerApellido() + " "
//                + detallesReserva.getReserva().getPersonaByCodCliente().getFisPrimerApellido()
                , ButtonType.YES, ButtonType.NO);
        alert.show();
    }

    private void activaBotonesBuscarYResetea() {
        List ticList = Arrays.asList(new TextInputControl[]{
            reserva, cliente});
        ActivadorDeControles.addActivador(ticList, resetearCampos, buscar);
    }
}
