package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaPrevision;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ArrayList;
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
public class ControladorPrevision implements Initializable {

    @FXML
    private TextField cliente, reserva;

    @FXML
    private Button resetearCampos, checkIn, addReserva, noShow;

    @FXML
    private TableColumn tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada, tableColumnFechaPrevistaSalida;

    @FXML
    private TableView<TablaPrevision> tabla;
    ObservableList<TablaPrevision> listaPendientesCheckIn = FXCollections.observableArrayList(), listaFiltro;
    List<DetallesReserva> listaReservas = FXCollections.observableArrayList();
    public DetallesReserva detallesReservaEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetearCampos.setOnAction((event) -> {
            accionReseteaCampos();
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

        listaReservas = PruebasModelo.getListaDeAlojamientos();

        listaPendientesCheckIn = TablaPrevision.modeloCheckin(listaReservas);
        listaFiltro = FXCollections.observableArrayList(listaPendientesCheckIn);
        tabla.setItems(listaFiltro);

        tableColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        tableColumnFechaPrevistaEntrada.setCellValueFactory(new PropertyValueFactory("fechaPrevistaEntrada"));
        tableColumnHabitacion.setCellValueFactory(new PropertyValueFactory("habitacion"));
        tableColumnNumeroReserva.setCellValueFactory(new PropertyValueFactory("numeroReserva"));
        tableColumnTipoHabitacion.setCellValueFactory(new PropertyValueFactory("tipo"));
        tableColumnFechaPrevistaSalida.setCellValueFactory(new PropertyValueFactory("fechaPrevistaSalida"));

        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            codigoSeleccionTabla();
        });
        cliente.textProperty().addListener((observable, oldValue, newValue) -> {
            accionFiltroCliente(newValue);
        });
        reserva.textProperty().addListener((observable, oldValue, newValue) -> {
            accionFiltroReserva(newValue);
        });
    }

    private void seleccionaReservaEnVista() {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            for (DetallesReserva dr : listaReservas) {
                if (dr.getReserva().getNumero().equals(tabla.getSelectionModel().getSelectedItem().getNumeroReserva())) {
                    detallesReservaEnVista = dr;
                    this.checkIn.setDisable(true);
                }
            }
        }
    }

    private void accionReseteaCampos() {
        reserva.setText("");
        cliente.setText("");

    }

    private void accionCheckIn() {
        if (detallesReservaEnVista != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaCheckin(Ventanas.PREVISION, Modality.WINDOW_MODAL, null);
            if (obj != null) {
                ((ControladorCheckIn) obj.getfXMLLoader().getController()).setReserva(detallesReservaEnVista);
                obj.ver();
            }
        }
    }

    private void accionReserva() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.PREVISION, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionNoshow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Seguro que quiere marcar como: \"NO-SHOW\"."
                + "\n\na la reserva: " + detallesReservaEnVista.getReserva().getNumero()
                + "\n\npertenciente al cliente: " + detallesReservaEnVista.getReserva().getPersonaByCodCliente().getNombre() + " "
                + detallesReservaEnVista.getReserva().getPersonaByCodCliente().getFisPrimerApellido() + " "
                + detallesReservaEnVista.getReserva().getPersonaByCodCliente().getFisPrimerApellido(),
                ButtonType.YES, ButtonType.NO);
        alert.show();
    }

    private void activaBotonesBuscarYResetea() {
        List ticList = Arrays.asList(new TextInputControl[]{
            reserva, cliente});
        ActivadorDeControles.addActivador(ticList, resetearCampos);
    }

    private void accionFiltroReserva(String newValue) {
        listaFiltro = FXCollections.observableArrayList();
        tabla.getSelectionModel().select(null);
        checkIn.setDisable(true);
        noShow.setDisable(true);
        for (TablaPrevision row : listaPendientesCheckIn) {
            if (row.getNumeroReserva().contains(newValue) && row.getCliente().contains(cliente.getText())) {
                listaFiltro.add(row);
            }
        }
        tabla.setItems(listaFiltro);
    }

    private void accionFiltroCliente(String newValue) {
        listaFiltro = FXCollections.observableArrayList();
        tabla.getSelectionModel().select(null);
        detallesReservaEnVista = null;
        checkIn.setDisable(true);
        noShow.setDisable(true);
        for (TablaPrevision row : listaPendientesCheckIn) {
            if (row.getCliente().contains(newValue) && row.getNumeroReserva().contains(reserva.getText())) {
                listaFiltro.add(row);
            }
        }
        tabla.setItems(listaFiltro);
    }

    private void codigoSeleccionTabla() {
        seleccionaReservaEnVista();
        noShow.setDisable(false);
        checkIn.setDisable(false);
    }
}
