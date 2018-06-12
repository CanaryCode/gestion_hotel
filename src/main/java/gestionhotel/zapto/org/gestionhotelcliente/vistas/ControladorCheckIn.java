package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VinculadorModeloATabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
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
    private Alojamiento alojamiento;
    private ObservableList<Huesped> listaTodosLosHuespedes = FXCollections.observableArrayList();
    private ObservableList<Huesped> listaHuespedAdultos = FXCollections.observableArrayList();
    private ObservableList<Huesped> listaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<Huesped> listaHuespedBebes = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedTodos = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedAdultos = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedBebes = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listaHabitacion = FXCollections.observableArrayList();
    private ObservableList<TablaReserva> listaTablaReserva = FXCollections.observableArrayList();
    private ObservableList<Alojamiento> listaAlojamientos;
    private ObservableList<Reserva> listaReserva = FXCollections.observableArrayList();
    
    private Reserva ReservaEnVista;
    private Habitacion habitacionEnVista;
    private Huesped huespedEnVista;
public static int contador=0;
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
        listaTodosLosHuespedes.addListener(new ListChangeListener<Huesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Huesped> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaTodosLosHuespedes, listaTablaHuespedTodos, new TablaHuesped(), c);
                checkeoTodasLasListasRellenas();
            }
        });
        listaTablaHuespedTodos.addListener(new ListChangeListener<TablaHuesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TablaHuesped> c) {
                checkeoTodasLasListasRellenas();
            }
        });
        listaTodosLosHuespedes.addListener(new ListChangeListener<Huesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Huesped> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaTodosLosHuespedes, listaTablaHuespedTodos, new TablaHuesped(), c);
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
        listaHabitacion.addListener(new ListChangeListener<Habitacion>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Habitacion> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHabitacion, listaTablaHabitacion, new TablaHabitacion(), c);
                checkeoTodasLasListasRellenas();
            }

        });
        listaHuespedAdultos.addListener(new ListChangeListener<Huesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Huesped> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedAdultos, listaTablaHuespedAdultos, new TablaHuesped(), c);       
                if (c.wasAdded()) {
                    listaTodosLosHuespedes.addAll(c.getAddedSubList());
                         contador++;
                System.out.println("contador " + contador);
                System.out.println("la lista de adultos: " + listaHuespedAdultos.size());
                System.out.println("la lista de tabla adultos: " + listaTablaHuespedAdultos.size());
                } else if (c.wasRemoved()) {
                    listaTodosLosHuespedes.removeAll(c.getRemoved());
                         contador++;
                System.out.println("contador " + contador);
                System.out.println("la lista de adultos: " + listaHuespedAdultos.size());
                System.out.println("la lista de tabla adultos: " + listaTablaHuespedAdultos.size());
                }
            }
        }
        );
        listaHuespedChild.addListener(new ListChangeListener<Huesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Huesped> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedChild, listaTablaHuespedChild, new TablaHuesped(), c);
                if (c.wasAdded()) {
                    listaTodosLosHuespedes.addAll(c.getAddedSubList());
                } else if (c.wasRemoved()) {
                    listaTodosLosHuespedes.removeAll(c.getRemoved());
                }
            }
        }
        );

        listaHuespedBebes.addListener(new ListChangeListener<Huesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Huesped> c) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedBebes, listaTablaHuespedBebes, new TablaHuesped(), c);
                if (c.wasAdded()) {
                    listaTodosLosHuespedes.addAll(c.getAddedSubList());
                } else if (c.wasRemoved()) {
                    listaTodosLosHuespedes.removeAll(c.getRemoved());
                }
               
            }
        }
        );
    }

    public ControladorCheckIn setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
        this.ReservaEnVista = alojamiento.getReserva();
        //---------------------------------------------------
        listaReserva = FXCollections.observableArrayList();
        listaReserva.add(ReservaEnVista);
        listaTablaReserva = new TablaReserva().getListaObjetosDeTabla(listaReserva);
        CreadorDeTabla.generaTabla(principal, tablaReserva, listaTablaReserva, new TablaReserva().getListaObjetosColumnas());
        return this;
    }

    public ControladorCheckIn setListaAlojamientos(ObservableList<Alojamiento> listaAlojamiento) {
        this.listaAlojamientos = listaAlojamiento;
        return this;
    }

    private void codigoModificaHuesped() {
        Ventana obj = VentanasFactory.getHuespedReserva(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).
                setNumeroHuespedes( alojamiento.getNumeroAdultos(), alojamiento.getNumeroChild(),
                        alojamiento.getNumeroBebes()).
                setListas(listaTodosLosHuespedes,listaHuespedAdultos, listaHuespedChild,
                        listaHuespedBebes,listaTablaHuespedAdultos,listaTablaHuespedChild,listaTablaHuespedBebes);
        obj.ver();
        ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).configuraVentana();
    }

    private void codigoModificaHabitacion() {
        ObservableList<Habitacion> listaCopia = FXCollections.observableArrayList();
        listaCopia.addListener(new ListChangeListener<Habitacion>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Habitacion> c) {
                c.next();
                listaHabitacion.clear();
                listaHabitacion.addAll(c.getAddedSubList());
            }
        });

        Ventana obj = VentanasFactory.getHabitacionBuscador(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        ((ControladorHabitacionBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaCopia).
                setFiltro(UtilBuscador.creaFiltro(Select.getHabitacionesDesOcupadas(), listaHabitacion));
        obj.ver();
    }

    private void codigoModificaReserva() {
        Ventana obj = VentanasFactory.getReservaFormulario(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        ((ControladorReservaFormulario) obj.getfXMLLoader().getController())
                .setObjetoEnVista(ReservaEnVista).
                setModo(Ventanas.MODO_FORMULARIO_ACTUALIZAR);
        obj.ver();
    }

    private void codigoBotonOk() {
        listaTablaHuespedTodos.clear();
        Select.realizaCheckin(listaAlojamientos.get(0), listaHabitacion.get(0),listaTodosLosHuespedes);
        Ventanas.cerrarVentana(Ventanas.CHECK_IN);
    }

    private void codigoReseteaCampos() {
        listaHabitacion.clear();
        listaTablaHuespedTodos.clear();
    }

    private void checkeoTodasLasListasRellenas() {
        if (!listaTodosLosHuespedes.isEmpty() && !listaHabitacion.isEmpty() && !listaReserva.isEmpty()) {
            botonOk.setDisable(false);
        } else {
            botonOk.setDisable(true);
        }
    }
}
