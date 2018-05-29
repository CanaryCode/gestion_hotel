package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorCheckIn implements Initializable {

    @FXML
    private Button modificaHuesped, modificaHabitacion, botonOk, reseteaCampos,
            modificaReserva;

    @FXML
    private TableView<TablaHuesped> tablaHuesped;
    @FXML
    private TableView<TablaHabitacion> tablaHabitacion;
    @FXML
    private TableView<TablaReserva> tablaReserva;

    @FXML
    private TableColumn tableColumnDni, tableColumnNombre, tableColumnPrimerApellido,
            tableColumnSegundoApellido, tableColumnFechaNacimiento, tableColumnSexo,
            tableColumnDiscapacitado, tableColumnPais, tableColumnCiudad, tableColumnProvincia,
            tableColumnNumero, tableColumnCalle, tableColumnCodigoPostal, tableColumnPasaporte,
            tableColumnFechaExpedicion, tableColumnEmail, tableColumnTratamiento, tableColumnCategoria,
            tableColumnPaginaWeb,
            //--------------------------------------------------------------------------------
            numeroHabitacion, tipoHabitacion, vistaHabitacion,
            //-----------------------------------------------------------------------------------------------
            tableColumnTipoCliente, tableColumnNombreCliente, tableColumnNombreAgencia, tableColumnFechaEntradaPrevista,
            tableColumnFechaFinPrevista, tableColumnNUmeroAdultos, tableColumnNumeroChild, tableColumnNumeroBebes,
            tableColumnPension, tableColumnCamaExtra, tableColumnCuna, tableColumnPreferenciaHabitacion, tableColumnPreferenciaVistas,
            tableColumnTipoCama, tableColumnNumeroHabitacion, tableColumnTurnoRestaurante, tableColumnTipoRestaurante,
            tableColumnNumeroTarjeta, tableColumnTipoTarjeta,tableColumnVoucher;
    ;

    private DetallesReserva detalleReserva;
    private ObservableList<Persona> listaHuespedOtros = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespededResponsable = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespedBebes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaTodosLosHuespedes = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedOtros = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedBebes = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedTodos = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<Habitacion> listaHabitacion = FXCollections.observableArrayList();
    private ObservableList<TablaReserva> listaTablaReserva;
    private ObservableList<DetallesReserva> listaDetalleReserva = FXCollections.observableArrayList();
    
    private DetallesReserva detallesReservaEnVista;
    private Habitacion habitacionEnVista;
    private Persona huespedEnVista;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaHuesped.setItems(listaTablaHuespedTodos);
        tablaHabitacion.setItems(listaTablaHabitacion);
        //----------------------------------------------------------------------------------
        tableColumnDni.setCellValueFactory(
                new PropertyValueFactory("numeroDocumento"));
        tableColumnNombre.setCellValueFactory(
                new PropertyValueFactory("nombre"));
        tableColumnPrimerApellido.setCellValueFactory(
                new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellido.setCellValueFactory(
                new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimiento.setCellValueFactory(
                new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexo.setCellValueFactory(
                new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitado.setCellValueFactory(
                new PropertyValueFactory("discapacitado"));
        tableColumnCiudad.setCellValueFactory(
                new PropertyValueFactory("ciudad"));
        tableColumnProvincia.setCellValueFactory(
                new PropertyValueFactory("provincia"));
        tableColumnPais.setCellValueFactory(
                new PropertyValueFactory("estado"));
        tableColumnCalle.setCellValueFactory(
                new PropertyValueFactory("calle"));
        tableColumnCodigoPostal.setCellValueFactory(
                new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporte.setCellValueFactory(
                new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicion.setCellValueFactory(
                new PropertyValueFactory("expPasaporte"));
        tableColumnEmail.setCellValueFactory(
                new PropertyValueFactory("email"));
        tableColumnTratamiento.setCellValueFactory(
                new PropertyValueFactory("tratamiento"));
        tableColumnCategoria.setCellValueFactory(
                new PropertyValueFactory("categoria"));
        tableColumnNumero.setCellValueFactory(
                new PropertyValueFactory("numero"));
        tableColumnPaginaWeb.setCellValueFactory(
                new PropertyValueFactory("paginaWeb"));
        //---------------------------------------------------------------------------------------------
        numeroHabitacion.setCellValueFactory(
                new PropertyValueFactory("numero"));
        tipoHabitacion.setCellValueFactory(
                new PropertyValueFactory("tipo"));
        vistaHabitacion.setCellValueFactory(
                new PropertyValueFactory("vista"));
        //---------------------------------------------------------------------------------------------------
        tableColumnTipoCliente.setCellValueFactory(
                new PropertyValueFactory("tipoCliente"));
        tableColumnNombreCliente.setCellValueFactory(
                new PropertyValueFactory("nombreCliente"));
        tableColumnNombreAgencia.setCellValueFactory(
                new PropertyValueFactory("nombreAgencia"));
        tableColumnFechaEntradaPrevista.setCellValueFactory(
                new PropertyValueFactory("fechaEntradaPrevista"));
        tableColumnFechaFinPrevista.setCellValueFactory(
                new PropertyValueFactory("fechaSalidaPrevista"));
        tableColumnNUmeroAdultos.setCellValueFactory(
                new PropertyValueFactory("numeroAdultos"));
        tableColumnNumeroChild.setCellValueFactory(
                new PropertyValueFactory("numeroChild"));
        tableColumnNumeroBebes.setCellValueFactory(
                new PropertyValueFactory("numeroBebes"));
        tableColumnPension.setCellValueFactory(
                new PropertyValueFactory("pension"));
        tableColumnCamaExtra.setCellValueFactory(
                new PropertyValueFactory("camaExtra"));
        tableColumnCuna.setCellValueFactory(
                new PropertyValueFactory("cuna"));
        tableColumnPreferenciaHabitacion.setCellValueFactory(
                new PropertyValueFactory("preferenciaTipoHabitacion"));
        tableColumnPreferenciaVistas.setCellValueFactory(
                new PropertyValueFactory("preferenciaVistas"));
        tableColumnTipoCama.setCellValueFactory(
                new PropertyValueFactory("oreferenciaTipoCama"));
        tableColumnNumeroHabitacion.setCellValueFactory(
                new PropertyValueFactory("prefenciaNumeroHabitacion"));
        tableColumnTurnoRestaurante.setCellValueFactory(
                new PropertyValueFactory("preferenciaTurnoRestaurante"));
        tableColumnTipoRestaurante.setCellValueFactory(
                new PropertyValueFactory("preferenciaTipoRestaurante"));
        tableColumnNumeroTarjeta.setCellValueFactory(
                new PropertyValueFactory("tarjetaCredito"));
        tableColumnTipoTarjeta.setCellValueFactory(
                new PropertyValueFactory("tipoTarjetaCredito"));
        tableColumnVoucher.setCellValueFactory(
                new PropertyValueFactory("voucher"));
        //------------------------------------------------------------------------------------------
         tablaHabitacion.setOnMouseClicked((event) -> {
            habitacionEnVista= UtilBuscador.onMouseClickedOnTable(tablaHabitacion,event, VentanasFactory.getObjetoVentanaHabitacionFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), habitacionEnVista,
                     listaHabitacion, tablaHabitacion);
         });
         tablaReserva.setOnMouseClicked((event) -> {
            detallesReservaEnVista= UtilBuscador.onMouseClickedOnTable(tablaReserva,event, VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), detallesReservaEnVista,
                     listaDetalleReserva, tablaReserva);
         });
         tablaHuesped.setOnMouseClicked((event) -> {
             huespedEnVista=UtilBuscador.onMouseClickedOnTable(tablaHuesped,event, VentanasFactory.getObjetoVentanaHuespedFormulario(Ventanas.CHECK_IN, Modality.WINDOW_MODAL, null), huespedEnVista,
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
                codigoListaTodos();
            }
        });
        listaHabitacion.addListener(new ListChangeListener<Habitacion>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Habitacion> c) {
                codigoListaHabitacion(c);
            }
        });
        listaDetalleReserva.addListener(new ListChangeListener<DetallesReserva>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends DetallesReserva> c) {
                codigoListaReserva(c);
            }
        });
    }

    public ControladorCheckIn setReserva(DetallesReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
        //---------------------------------------------------
        listaDetalleReserva.add(detalleReserva);
        listaTablaReserva = TablaReserva.getListaTablaReserva(listaDetalleReserva);
        tablaReserva.setItems(listaTablaReserva);
        return this;
    }

    private void codigoModificaHuesped() {
        if (detalleReserva != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedReserva(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            if (obj != null) {
                ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).
                        setNumeroHuespedes(1, detalleReserva.getNumeroAdultos() - 1, detalleReserva.getNumeroChild(),
                                detalleReserva.getNumeroBebes()).
                        setListas(listaHuespedOtros, listaHuespededResponsable, listaHuespedChild,
                                listaHuespedBebes, listaTodosLosHuespedes, listaTablaHuespedResponsable,
                                listaTablaHuespedOtros, listaTablaHuespedChild, listaTablaHuespedBebes, listaTablaHuespedTodos);
                obj.ver();
                ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).configuraVentana();
            }
        }
    }

    private void codigoModificaHabitacion() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHabitacionBuscador(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHabitacionBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaHabitacion).
                    setFiltro(PruebasModelo.getListaHabitaciones()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void codigoModificaReserva() {
        if (detalleReserva != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            if (obj != null) {
                ((ControladorReservaFormulario) obj.getfXMLLoader().getController())
                        .setObjetoEnVista(detalleReserva).
                        setModo(Ventanas.MODO_FORMULARIO_ACTUALIZAR);
                obj.ver();
            }
        }
    }

    private void codigoBotonOk() {

    }

    private void codigoReseteaCampos() {

    }

    private void codigoListaTodos() {
        checkeoTodasLasListasRellenas();
    }

    private void codigoListaHabitacion(ListChangeListener.Change<? extends Habitacion> cambio) {
        
        listaTablaHabitacion=TablaHabitacion.getTablaHabitacion(listaHabitacion);
        tablaHabitacion.setItems(listaTablaHabitacion);
        checkeoTodasLasListasRellenas();
    }

    private void codigoListaReserva(ListChangeListener.Change<? extends DetallesReserva> cambio) {
        listaTablaReserva=TablaReserva.getListaTablaReserva(listaDetalleReserva);
        tablaReserva.setItems(listaTablaReserva);
        checkeoTodasLasListasRellenas();
    }

    private void checkeoTodasLasListasRellenas() {
        if (!listaTodosLosHuespedes.isEmpty() && !listaHabitacion.isEmpty() && !listaDetalleReserva.isEmpty()) {
            botonOk.setDisable(false);
        } else {
            botonOk.setDisable(true);
        }
    }
}
