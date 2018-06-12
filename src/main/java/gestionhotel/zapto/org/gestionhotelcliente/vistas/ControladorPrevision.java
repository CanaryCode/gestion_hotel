package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VinculadorModeloATabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaPrevision;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class ControladorPrevision implements Initializable, BuscadorInterface {

    @FXML
    private AnchorPane principal;
    @FXML
    private TextField cliente, reserva, agencia, voucher;

    @FXML
    private Button resetearCampos, checkIn, addReserva, noShow;

    @FXML
    private TableView<TablaPrevision> tabla;
    
    private ObservableList<TablaPrevision> listaTablaCheckIn = FXCollections.observableArrayList(), listaFiltroTabla;
    private ObservableList<Alojamiento> listaAlojamientos = FXCollections.observableArrayList();
    private ObservableList<Alojamiento> listaFiltroAlojamientos = FXCollections.observableArrayList();
    public Alojamiento alojamientoEnVista;
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
        listaTablaCheckIn = new TablaPrevision().getListaObjetosDeTabla(listaAlojamientos);
        listaFiltroTabla = FXCollections.observableArrayList(listaTablaCheckIn);
        tabla.setItems(listaFiltroTabla);
        //----------------------------------------------------------------------------------

        //-------------------------------------------------------------------------------------------
      
        tabla.setOnMouseClicked((event) -> {
            alojamientoEnVista = UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getAlojamientoFormulario(Ventanas.PREVISION, Modality.WINDOW_MODAL, null), alojamientoEnVista,
                    listaAlojamientos, checkIn, noShow);
        });
        //---------------------------------------------------------------------------------------------
        cliente.textProperty().addListener((observable, oldValue, newValue) -> {
            filtroBusquedaInterna(newValue);
        });
        reserva.textProperty().addListener((observable, oldValue, newValue) -> {
            filtroBusquedaInterna(newValue);
        });
        agencia.textProperty().addListener((observable, oldValue, newValue) -> {
            filtroBusquedaInterna(newValue);
        });
        voucher.textProperty().addListener((observable, oldValue, newValue) -> {
            filtroBusquedaInterna(newValue);
        });
    }

    private void accionReseteaCampos() {
        UtilFormularios.reseteaCampos(principal);
    }

    private void accionCheckIn() {
        if (alojamientoEnVista != null) {
            Ventana obj = VentanasFactory.getCheckin(Ventanas.PREVISION, Modality.WINDOW_MODAL, null);
                ((ControladorCheckIn) obj.getfXMLLoader().getController()).setAlojamiento(alojamientoEnVista).
                        setListaAlojamientos(listaAlojamientos);
                obj.ver();
            }
    }

    private void accionReserva() {
        Ventana obj = VentanasFactory.getReservaFormulario(Ventanas.PREVISION, Modality.WINDOW_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void accionNoshow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Seguro que quiere marcar como: \"NO-SHOW\"."
                + "\n\na la reserva: " + alojamientoEnVista.getReserva().getCodigo()
                + "\n\npertenciente al cliente: " + alojamientoEnVista.getReserva().getCliente().getPersona().getNombre() + " "
                + alojamientoEnVista.getReserva().getCliente().getPersona().getFisPrimerApellido() + " "
                + alojamientoEnVista.getReserva().getCliente().getPersona().getFisPrimerApellido(),
                ButtonType.YES, ButtonType.NO);
        alert.show();
    }


    private void filtroBusquedaInterna(String newValue) {
        listaFiltroTabla = FXCollections.observableArrayList();
        for (TablaPrevision row : listaTablaCheckIn) {
            if (row.getCliente().contains(cliente.getText())
                    && row.getNumeroReserva().contains(reserva.getText())
                    && row.getVoucher().contains(voucher.getText())
                    && row.getNombreAgencia().contains(agencia.getText())) {
                listaFiltroTabla.add(row);
            }
            if (cliente.getText().equals("")
                    && reserva.getText().equals("")
                    && voucher.getText().equals("")
                    && agencia.getText().equals("")) {
                resetearCampos.setDisable(true);
            } else {
                resetearCampos.setDisable(false);
            }
            tabla.setItems(listaFiltroTabla);
        }
    }

    @Override
    public ControladorPrevision setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorPrevision setListaToAdd(ObservableList<T> ListaObjeto) {
        return this;
    }

    @Override
    public <T> ControladorPrevision setFiltro(ObservableList<T> ListaObjeto) {
        listaAlojamientos=(ObservableList<Alojamiento>)ListaObjeto;
        FXCollections.copy(listaAlojamientos, (ObservableList<Alojamiento>)ListaObjeto);
        listaFiltroAlojamientos = listaAlojamientos;
        listaTablaCheckIn = new TablaPrevision().getListaObjetosDeTabla(listaFiltroAlojamientos);
        CreadorDeTabla.generaTabla(principal, tabla, listaTablaCheckIn, new TablaPrevision().getListaObjetosColumnas());
    
        listaAlojamientos.addListener(new ListChangeListener<Alojamiento>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Alojamiento> c) {
          VinculadorModeloATabla.vinculaAListaTabla(listaAlojamientos,listaTablaCheckIn, 
                  new TablaPrevision(), c);
            }
        });
        return this;
    }
}
