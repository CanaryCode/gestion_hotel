package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VinculadorModeloATabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorCheckIn implements Initializable {

    @FXML
    private AnchorPane principal;
    @FXML
    private Button modificaHuesped, modificaHabitacion, botonOk, reseteaCampos,
            modificaReserva;

    @FXML
    private TableView<TablaHuesped> tablaHuesped;
    @FXML
    private TableView<TablaHabitacion> tablaHabitacion;
    @FXML
    private TableView<TablaReserva> tablaReserva;
    //-----------------------------------------------------------------------------------------------
    private DetallesReserva detalleReserva;
    private ObservableList<Persona> listaHuespedOtros = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespededResponsable = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespedBebes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaTodosLosHuespedes = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedTodos = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listaHabitacion = FXCollections.observableArrayList();
    private ObservableList<TablaReserva> listaTablaReserva = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaAlojamientos;
    ;
    private ObservableList<Reserva> listaReserva = FXCollections.observableArrayList();
    ;
    
    private Reserva ReservaEnVista;
    private Habitacion habitacionEnVista;
    private Persona huespedEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CreadorDeTabla.generaTabla(principal, tablaHabitacion, listaTablaHabitacion, new TablaHabitacion().getListaObjetosColumnas());
        CreadorDeTabla.generaTabla(principal, tablaHuesped, listaTablaHuespedTodos, new TablaHuesped().getListaObjetosColumnas());
        //------------------------------------------------------------------------------------------
        tablaHabitacion.setOnMouseClicked((event) -> {
            habitacionEnVista = UtilBuscador.onMouseClickedOnTable(tablaHabitacion, event, VentanasFactory.getHabitacionFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), habitacionEnVista,
                    listaHabitacion, tablaHabitacion);
        });
        tablaReserva.setOnMouseClicked((event) -> {
            ReservaEnVista = UtilBuscador.onMouseClickedOnTable(tablaReserva, event, VentanasFactory.getReservaFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), ReservaEnVista,
                    listaReserva, tablaReserva);
        });
        tablaHuesped.setOnMouseClicked((event) -> {
            huespedEnVista = UtilBuscador.onMouseClickedOnTable(tablaHuesped, event, VentanasFactory.getHuespedFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), huespedEnVista,
                    listaTodosLosHuespedes);
        });
        //---------------------------------------------------------------------------------------------------
        modificaHuesped.setOnAction((event) -> {
            codigoModificaHuesped();
        }
        );

        modificaHabitacion.setOnAction((event) -> {
            codigoModificaHabitacion();
        }
        );
        botonOk.setOnAction((event) -> {
            codigoBotonOk();
        }
        );
        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        }
        );
        modificaReserva.setOnAction((event) -> {
            codigoModificaReserva();
        }
        );
        listaTodosLosHuespedes.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaTodosLosHuespedes, listaTablaHuespedTodos, new TablaHuesped(), c);
                checkeoTodasLasListasRellenas();
            }
        });
        listaHabitacion.addListener(new ListChangeListener<Habitacion>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Habitacion> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHabitacion, listaTablaHabitacion, new TablaHabitacion(), c);
                checkeoTodasLasListasRellenas();
            }
        });
        listaReserva.addListener(new ListChangeListener<Reserva>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Reserva> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaReserva, listaTablaReserva, new TablaReserva(), c);
                checkeoTodasLasListasRellenas();
            }

        });
    }

    public ControladorCheckIn setDetalleReserva(DetallesReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
        this.ReservaEnVista = detalleReserva.getReserva();
        //---------------------------------------------------
        listaReserva = FXCollections.observableArrayList();
        listaReserva.add(ReservaEnVista);
        listaTablaReserva = new TablaReserva().getListaObjetosDeTabla(listaReserva);
        CreadorDeTabla.generaTabla(principal, tablaReserva, listaTablaReserva, new TablaReserva().getListaObjetosColumnas());
        return this;
    }
    public ControladorCheckIn setListaAlojamientos(ObservableList<DetallesReserva> listaDetalleReserva) {
        this.listaAlojamientos=listaDetalleReserva;
        return this;
    }

    private void codigoModificaHuesped() {
            ObjetoVentana obj = VentanasFactory.getHuespedReserva(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).
                    setNumeroHuespedes(1, detalleReserva.getNumeroAdultos() - 1, detalleReserva.getNumeroChild(),
                            detalleReserva.getNumeroBebes()).
                    setListas(listaHuespedOtros, listaHuespededResponsable, listaHuespedChild,
                            listaHuespedBebes, listaTodosLosHuespedes);
            obj.ver();
            ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).configuraVentana();
    }

    private void codigoModificaHabitacion() {
        ObjetoVentana obj = VentanasFactory.getHabitacionBuscador(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        ((ControladorHabitacionBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHabitacion).
                setFiltro(getFiltroHabitaciones()).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void codigoModificaReserva() {
            ObjetoVentana obj = VentanasFactory.getReservaFormulario(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            ((ControladorReservaFormulario) obj.getfXMLLoader().getController())
                    .setObjetoEnVista(ReservaEnVista).
                    setModo(Ventanas.MODO_FORMULARIO_ACTUALIZAR);
            obj.ver();
    }

    private void codigoBotonOk() {
         Select.realizaCheckin(detalleReserva, habitacionEnVista, 
                 listaTodosLosHuespedes,listaAlojamientos);
         Ventanas.cerrarVentana(Ventanas.CHECK_IN);
    }

    private void codigoReseteaCampos() {
        listaHabitacion.clear();
        listaHuespedBebes.clear();
        listaHuespedChild.clear();
        listaHuespedOtros.clear();
        listaHuespededResponsable.clear();
    }

    private void checkeoTodasLasListasRellenas() {
        if (!listaTodosLosHuespedes.isEmpty() && !listaHabitacion.isEmpty() && !listaReserva.isEmpty()) {
            botonOk.setDisable(false);
        } else {
            botonOk.setDisable(true);
        }
    }
    private ObservableList<Habitacion> getFiltroHabitaciones(){
        ObservableList<Habitacion> lista = Select.getHabitacionesDesOcupadas();
        lista.removeAll(listaHabitacion);
        return lista;
    }
}
