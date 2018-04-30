package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.tablas.CheckIn;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
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
            tableColumnFechaPrevistaEntrada;

    @FXML
    private TableView<CheckIn> tabla;
    
    ObservableList<CheckIn> listaPendientesCheckIn, listaFiltro;
    List<Reserva> listaReservas;
    public Reserva reservaEnVista;

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
        listaReservas = Consultas.realizaQuery(Consultas.pendienteDeCheckIn, Reserva.class);
        listaPendientesCheckIn = CheckIn.modeloCheckin(listaReservas);
        listaFiltro = listaPendientesCheckIn;
        tabla.setItems(listaFiltro);
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        tableColumnFechaPrevistaEntrada.setCellValueFactory(new PropertyValueFactory("fechaPrevistaEntrada"));
        tableColumnHabitacion.setCellValueFactory(new PropertyValueFactory("habitacion"));
        tableColumnNumeroReserva.setCellValueFactory(new PropertyValueFactory("numeroReserva"));
        tableColumnTipoHabitacion.setCellValueFactory(new PropertyValueFactory("tipo"));

        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            seleccionaReservaEnVista();
        });
    }

    private void seleccionaReservaEnVista() {
        for (Reserva r : listaReservas) {
            if (r.getNumero().equals(tabla.getSelectionModel().getSelectedItem().getNumeroReserva())) {
                reservaEnVista = r;
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
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedReserva("ventanaReservaCheckIn", Modality.WINDOW_MODAL, null);
        if (obj != null) {
            ((ControladorVentanaHuespedReserva) obj.getfXMLLoader().getController()).setReserva(reservaEnVista);
            obj.ver();
        }
    }

    private void accionReserva() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaAddReserva("ventanaReservaCheckIn", Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void activaBotonesBuscarYResetea() {
        List ticList = Arrays.asList(new TextInputControl[]{
            reserva, cliente});
        ActivadorDeControles.addActivador(ticList, resetearCampos, buscar);
    }

    private void cargarTableColumns() {

    }
}
