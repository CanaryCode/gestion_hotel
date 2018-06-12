package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.LimitadorDeCaracteres;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaAgencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaAlojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Agencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Cliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorReservaFormulario implements Initializable, FormularioInterface {

    @FXML
    private AnchorPane principal;
    @FXML
    private ComboBox tipoTarjeta;

    @FXML
    private TextArea comentario;

    @FXML
    private Button confirmar, reseteaCampos, modificarCliente, modificarAgencia, addAlojamiento,
            borrarAlojamiento;

    @FXML
    private TextField numeroTarjeta;
    @FXML
    private TableView<TablaCliente> tablaCliente;
    @FXML
    private TableView<TablaAgencia> tablaAgencia;
    @FXML
    private TableView<TablaAlojamiento> tablaAlojamiento;

    private ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
    private ObservableList<TablaCliente> listaTablaCliente = FXCollections.observableArrayList();
    private ObservableList<Agencia> listaAgencia = FXCollections.observableArrayList();
    private ObservableList<TablaAgencia> listaTablaAgencia = FXCollections.observableArrayList();
    private ObservableList<Alojamiento> listaDetalleReserva = FXCollections.observableArrayList();
    private ObservableList<TablaAlojamiento> listaTablaAlojamientos = FXCollections.observableArrayList();
    private ObservableList<Alojamiento> listaAlojamientos = FXCollections.observableArrayList();

    private Reserva reservaEnVista;
    private Cliente ClienteEnVista;
    private Agencia AgenciaEnVista;
    private Alojamiento AlojamientoEnVista;
    private int modo;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        confirmar.setOnAction((e) -> {
            codigoConfirmar();
        });
        modificarAgencia.setOnAction((e) -> {
            codigoModificaAgencia();
        });
        addAlojamiento.setOnAction((e) -> {
            UtilBuscador.accionCrear(VentanasFactory.getAlojamientoFormulario(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null));
        });
        modificarCliente.setOnAction((e) -> {
            codigoModificaCliente();
        });
        borrarAlojamiento.setOnAction((e) -> {
            codigoBorrarAlojamiento();
        });
        //----------------------------------------------------------------------
        comentario.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(comentario, newValue, oldValue, 300);
        });
        numeroTarjeta.textProperty().addListener((observable, oldValue, newValue) -> {
            LimitadorDeCaracteres.addLimitacion(numeroTarjeta, newValue, oldValue, 40);
        });
        //----------------------------------------------------------------------

        UtilBuscador.iniciaComboBox(tipoTarjeta, Registro.ListaTipoTarjeta);
        //-------------------------------------------------------------------------------------------------------------
        tablaAlojamiento.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            AlojamientoEnVista = UtilFormularios.accionOnSelectedTable(modo, listaAlojamientos, tablaAlojamiento, borrarAlojamiento);
        });
        tablaAgencia.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            AgenciaEnVista = UtilBuscador.accionOnSelectedTable(listaAgencia, tablaAgencia);
        });
        tablaCliente.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            ClienteEnVista = UtilBuscador.accionOnSelectedTable(listaCliente, tablaCliente);
        });
        tablaAgencia.setOnMouseClicked((event) -> {
            AgenciaEnVista = UtilBuscador.onMouseClickedOnTable(tablaAgencia, event, VentanasFactory.getClienteFormulario(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), AgenciaEnVista,
                    listaAgencia);
        });
        tablaCliente.setOnMouseClicked((event) -> {
            ClienteEnVista = UtilBuscador.onMouseClickedOnTable(tablaCliente, event, VentanasFactory.getClienteFormulario(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), ClienteEnVista,
                    listaCliente);

        });
        tablaAlojamiento.setOnMouseClicked((event) -> {
            AlojamientoEnVista = UtilBuscador.onMouseClickedOnTable(tablaAlojamiento, event, VentanasFactory.getAlojamientoFormulario(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), AlojamientoEnVista,
                    listaAlojamientos, borrarAlojamiento);
        });
        //---------------------------------------------------------------------------------------------
    }

    private void codigoConfirmar() {

    }

    private void codigoModificaAgencia() {
        Ventana obj = VentanasFactory.getBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorClienteBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaAgencia).
                    setFiltro(PruebasModelo.getListaDeClientes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void codigoModificaCliente() {
        Ventana obj = VentanasFactory.getBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorClienteBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaCliente).
                    setFiltro(PruebasModelo.getListaDeClientes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void codigoBorrarAlojamiento() {
        listaAlojamientos.remove(AlojamientoEnVista);
    }

    @Override
    public ControladorReservaFormulario setModo(int modo) {
        this.modo = modo;
        UtilFormularios.configurarModo(Ventanas.RESERVA_FORMULARIO, modo, confirmar, reseteaCampos, principal);
        return this;
    }

    @Override
    public ControladorReservaFormulario setObjetoEnVista(Object objetoEnVista) {
        reservaEnVista = (Reserva) objetoEnVista;
        //----------------------------------------------------------------------
        //------------------Lista Cliente---------------------------------------
        //----------------------------------------------------------------------
        if (reservaEnVista.getCliente() != null) {
            listaCliente.add(reservaEnVista.getCliente());
            CreadorDeTabla.generaTabla(principal, tablaCliente, listaCliente, new TablaCliente().getListaObjetosColumnas());
            listaTablaCliente.addAll(new TablaCliente().getListaObjetosDeTabla(listaCliente));
        }

        tablaCliente.setItems(listaTablaCliente);
        //----------------------------------------------------------------------
        //------------------Lista Agencia---------------------------------------
        //----------------------------------------------------------------------
        if (reservaEnVista.getAgencia() != null) {
            listaAgencia.add(reservaEnVista.getAgencia());
            CreadorDeTabla.generaTabla(principal, tablaAgencia, listaAgencia, new TablaAgencia().getListaObjetosColumnas());
            listaTablaAgencia.addAll(new TablaAgencia().getListaObjetosDeTabla(listaAgencia));

        }
        tablaAgencia.setItems(listaTablaAgencia);
        //----------------------------------------------------------------------
        //------------------Lista Alojamientos----------------------------------
        //----------------------------------------------------------------------
        if (reservaEnVista.getAlojamientos() != null) {
            for (Alojamiento alo : PruebasModelo.getListaDeAlojamientos()) {
                if (reservaEnVista.getId() != null) {
                    if (reservaEnVista.getId().equals(alo.getReserva().getId())) {
                        listaAlojamientos.add(alo);
                    }
                }
            }
            listaTablaAlojamientos.addAll(new TablaAlojamiento().getListaObjetosDeTabla(listaAlojamientos));
        }
        CreadorDeTabla.generaTabla(principal, tablaAlojamiento, listaAlojamientos, new TablaAlojamiento().getListaObjetosColumnas());
        tablaAlojamiento.setItems(listaTablaAlojamientos);
        //---------------------------------------------------
        listaDetalleReserva.addAll(reservaEnVista.getAlojamientos());
        //----------------------------------------------------

        if (reservaEnVista.getTipoTarjetaCredito() != null) {
            tipoTarjeta.getSelectionModel().select(reservaEnVista.getTipoTarjetaCredito());
        }
        if (reservaEnVista.getNumeroTarjetaCredito() != null) {
            numeroTarjeta.setText(reservaEnVista.getNumeroTarjetaCredito());
        }
        if (reservaEnVista.getComentario() != null) {
            comentario.setText(reservaEnVista.getComentario());
        }
        return this;
    }
}
