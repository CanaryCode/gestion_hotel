package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.ActivadorDeControles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaPrevision;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
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
public class ControladorPrevision implements Initializable,BuscadorInterface{

    @FXML
    private TextField cliente, reserva;

    @FXML
    private Button resetearCampos, checkIn, addReserva, noShow;

    @FXML
    private TableColumn tableColumnNumeroReserva, tableColumnCliente, tableColumnHabitacion, tableColumnTipoHabitacion,
            tableColumnFechaPrevistaEntrada, tableColumnFechaPrevistaSalida,tableColumnAgencia;

    @FXML
    private TableView<TablaPrevision> tabla;
    private ObservableList<TablaPrevision> listaTablaCheckIn = FXCollections.observableArrayList(), listaFiltroTabla;
    private ObservableList<DetallesReserva> listaAlojamientos = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaFiltroAlojamientos = FXCollections.observableArrayList();
    public DetallesReserva detallesReservaEnVista;
    public int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //----------------------------------------------------------------------
        cliente.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(cliente, newValue, oldValue, 120);
        });
        reserva.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(reserva, newValue, oldValue, 40);
        });
        //----------------------------------------------------------------------
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

        listaAlojamientos = PruebasModelo.getListaDeAlojamientos();
        listaTablaCheckIn = TablaPrevision.modeloCheckin(listaAlojamientos);
        listaFiltroTabla = FXCollections.observableArrayList(listaTablaCheckIn);
        tabla.setItems(listaFiltroTabla);

        tableColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        tableColumnFechaPrevistaEntrada.setCellValueFactory(new PropertyValueFactory("fechaPrevistaEntrada"));
        tableColumnHabitacion.setCellValueFactory(new PropertyValueFactory("habitacion"));
        tableColumnNumeroReserva.setCellValueFactory(new PropertyValueFactory("numeroReserva"));
        tableColumnTipoHabitacion.setCellValueFactory(new PropertyValueFactory("tipo"));
        tableColumnFechaPrevistaSalida.setCellValueFactory(new PropertyValueFactory("fechaPrevistaSalida"));
        tableColumnAgencia.setCellValueFactory(new PropertyValueFactory("nombreAgencia"));
        //-------------------------------------------------------------------------------------------
        tabla.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            codigoSeleccionTabla();
        });
        tabla.setOnMouseClicked((event) -> {
            detallesReservaEnVista=UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getObjetoVentanaDetallesReserva(Ventanas.PREVISION, Modality.WINDOW_MODAL, null), detallesReservaEnVista,
                    listaAlojamientos,checkIn,resetearCampos,noShow);
        });
        //---------------------------------------------------------------------------------------------
        cliente.textProperty().addListener((observable, oldValue, newValue) -> {
            accionFiltroCliente(newValue);
        });
        reserva.textProperty().addListener((observable, oldValue, newValue) -> {
            accionFiltroReserva(newValue);
        });
    }

    private void seleccionaReservaEnVista() {
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            for (DetallesReserva dr : listaAlojamientos) {
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
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.PREVISION, Modality.WINDOW_MODAL, null);
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
        listaFiltroTabla = FXCollections.observableArrayList();
        tabla.getSelectionModel().select(null);
        checkIn.setDisable(true);
        noShow.setDisable(true);
        for (TablaPrevision row : listaTablaCheckIn) {
            if (row.getNumeroReserva().contains(newValue) && row.getCliente().contains(cliente.getText())) {
                listaFiltroTabla.add(row);
            }
        }
        tabla.setItems(listaFiltroTabla);
    }

    private void accionFiltroCliente(String newValue) {
        listaFiltroTabla = FXCollections.observableArrayList();
        tabla.getSelectionModel().select(null);
        detallesReservaEnVista = null;
        checkIn.setDisable(true);
        noShow.setDisable(true);
        for (TablaPrevision row : listaTablaCheckIn) {
            if (row.getCliente().contains(newValue) && row.getNumeroReserva().contains(reserva.getText())) {
                listaFiltroTabla.add(row);
            }
        }
        tabla.setItems(listaFiltroTabla);
    }

    private void codigoSeleccionTabla() {
        seleccionaReservaEnVista();
        noShow.setDisable(false);
        checkIn.setDisable(false);
    }

    @Override
    public ControladorPrevision setModo(int modo) {
        this.modo=modo;
        return this;
    }

    @Override
    public <T> ControladorPrevision setListaToAdd(ObservableList<T> ListaObjeto) {
        listaAlojamientos=(ObservableList<DetallesReserva>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorPrevision setFiltro(ObservableList<T> ListaObjeto) {
        listaFiltroAlojamientos=(ObservableList<DetallesReserva>) ListaObjeto;
        return this;
    }
}
