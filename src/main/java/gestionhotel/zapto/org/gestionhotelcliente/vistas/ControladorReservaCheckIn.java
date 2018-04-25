package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Consultas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.tablas.CheckIn;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        try {
            FXMLLoader loader =new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/FXMLVentanaHuespedReserva.fxml"));;
            Parent p =loader.load();
             ControladorVentanaHuespedReserva chr=loader.getController();
            chr.setReserva(reservaEnVista);
            Scene scene =new Scene(p);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControladorReservaCheckIn.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void accionReserva() {
        new Ventanas().abrirVentanaAddReserva(Ventanas.ventanaReservaCheckIn, Modality.APPLICATION_MODAL);
    }

    private void activaBotonesBuscarYResetea() {
        List ticList = Arrays.asList(new TextInputControl[]{
            reserva, cliente});

        ActivadorDeControles.addActivador(ticList, resetearCampos, buscar);
    }

    private void cargarTableColumns() {

    }
}
