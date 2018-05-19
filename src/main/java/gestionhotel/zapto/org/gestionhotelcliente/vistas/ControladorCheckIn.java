package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    private TableView<TablaHuesped> tablaResponsable, tablaOtros;
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
            //--------------------------------------------------------------------------------
            tableColumnDni1, tableColumnNombre1, tableColumnPrimerApellido1,
            tableColumnSegundoApellido1, tableColumnFechaNacimiento1, tableColumnSexo1,
            tableColumnDiscapacitado1, tableColumnPais1, tableColumnCiudad1, tableColumnProvincia1,
            tableColumnNumero1, tableColumnCalle1, tableColumnCodigoPostal1, tableColumnPasaporte1,
            tableColumnFechaExpedicion1, tableColumnEmail1, tableColumnTratamiento1, tableColumnCategoria1,
            //--------------------------------------------------------------------------
            numeroHabitacion, tipoHabitacion, vistaHabitacion,
            //-----------------------------------------------------------------------------------------------
            tableColumnTipoCliente, tableColumnNombreCliente, tableColumnNombreAgencia, tableColumnFechaEntradaPrevista,
            tableColumnFechaFinPrevista, tableColumnNUmeroAdultos, tableColumnNumeroChild, tableColumnNumeroBebes,
            tableColumnPension, tableColumnCamaExtra, tableColumnCuna, tableColumnPreferenciaHabitacion, tableColumnPreferenciaVistas,
            tableColumnTipoCama, tableColumnNumeroHabitacion, tableColumnTurnoRestaurante, tableColumnTipoRestaurante, tableColumnNumeroTarjeta, tableColumnTipoTarjeta;
    ;

    private DetallesReserva detalleReserva;
    private ObservableList<Persona> listaHuespedes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaHuespededResponsable = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedes = FXCollections.observableArrayList();
    private ObservableList<Persona> listaTodosLosHuespedes = FXCollections.observableArrayList();
    private ObservableList<TablaHabitacion> listaTablaHabitacion = FXCollections.observableArrayList();
    private ObservableList<TablaReserva> listaTablaReserva = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaDetalleReserva = FXCollections.observableArrayList();
    private int maxResponsables = 1, MaxHuespedes = 2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tablaResponsable.setItems(listaTablaHuespedResponsable);
        tablaOtros.setItems(listaTablaHuespedes);
        tablaHabitacion.setItems(listaTablaHabitacion);
        tableColumnDni1.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombre1.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellido1.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellido1.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimiento1.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexo1.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitado1.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudad1.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvincia1.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPais1.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalle1.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostal1.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporte1.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicion1.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmail1.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamiento1.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoria1.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumero1.setCellValueFactory(new PropertyValueFactory("numero"));
        //------------------------------------------------------------------------------------------
        tableColumnDni.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellido.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellido.setCellValueFactory(new PropertyValueFactory("SegundoApellido"));
        tableColumnFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexo.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnDiscapacitado.setCellValueFactory(new PropertyValueFactory("discapacitado"));
        tableColumnCiudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvincia.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnPais.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalle.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostal.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnPasaporte.setCellValueFactory(new PropertyValueFactory("pasaporte"));
        tableColumnFechaExpedicion.setCellValueFactory(new PropertyValueFactory("expPasaporte"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamiento.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        //---------------------------------------------------------------------------------------------
        numeroHabitacion.setCellValueFactory(new PropertyValueFactory("numero"));
        tipoHabitacion.setCellValueFactory(new PropertyValueFactory("tipo"));
        vistaHabitacion.setCellValueFactory(new PropertyValueFactory("vista"));
        //---------------------------------------------------------------------------------------------------
        tableColumnTipoCliente.setCellValueFactory(new PropertyValueFactory("tipoCliente"));
        tableColumnNombreCliente.setCellValueFactory(new PropertyValueFactory("nombreCliente"));
        tableColumnNombreAgencia.setCellValueFactory(new PropertyValueFactory("nombreAgencia"));
        tableColumnFechaEntradaPrevista.setCellValueFactory(new PropertyValueFactory("fechaEntradaPrevista"));
        tableColumnFechaFinPrevista.setCellValueFactory(new PropertyValueFactory("fechaSalidaPrevista"));
        tableColumnNUmeroAdultos.setCellValueFactory(new PropertyValueFactory("numeroAdultos"));
        tableColumnNumeroChild.setCellValueFactory(new PropertyValueFactory("numeroChild"));
        tableColumnNumeroBebes.setCellValueFactory(new PropertyValueFactory("numeroBebes"));
        tableColumnPension.setCellValueFactory(new PropertyValueFactory("pension"));
        tableColumnCamaExtra.setCellValueFactory(new PropertyValueFactory("camaExtra"));
        tableColumnCuna.setCellValueFactory(new PropertyValueFactory("cuna"));
        tableColumnPreferenciaHabitacion.setCellValueFactory(new PropertyValueFactory("preferenciaTipoHabitacion"));
        tableColumnPreferenciaVistas.setCellValueFactory(new PropertyValueFactory("preferenciaVistas"));
        tableColumnTipoCama.setCellValueFactory(new PropertyValueFactory("oreferenciaTipoCama"));
        tableColumnNumeroHabitacion.setCellValueFactory(new PropertyValueFactory("prefenciaNumeroHabitacion"));
        tableColumnTurnoRestaurante.setCellValueFactory(new PropertyValueFactory("preferenciaTurnoRestaurante"));
        tableColumnTipoRestaurante.setCellValueFactory(new PropertyValueFactory("preferenciaTipoRestaurante"));
        tableColumnNumeroTarjeta.setCellValueFactory(new PropertyValueFactory("tarjetaCredito"));
        tableColumnTipoTarjeta.setCellValueFactory(new PropertyValueFactory("tipoTarjetaCredito"));
        //---------------------------------------------------------------------------------------------------
        modificaHuesped.setOnAction((event) -> {
            codigoModificaHuesped();
        });

        modificaHabitacion.setOnAction((event) -> {
            codigoModificaHabitacion();
        });
        botonOk.setOnAction((event) -> {
            codigoBotonOk();
        });
        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
        modificaReserva.setOnAction((event) -> {
            codigoModificaReserva();
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

    public ControladorCheckIn setNumeroHuespedes(int numeroResponsables, int numeroNormales) {
        this.maxResponsables = numeroResponsables;
        this.MaxHuespedes = numeroNormales;

        return this;
    }

    private void codigoModificaHuesped() {
        if (detalleReserva != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaHuespedReserva(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            if (obj != null) {
                ((ControladorHuespedReserva) obj.getfXMLLoader().getController()).
                        setListas(listaHuespedes, listaHuespededResponsable, listaTablaHuespedResponsable, listaTablaHuespedes, listaTodosLosHuespedes);
                obj.ver();
            }
        }
    }

    private void codigoModificaHabitacion() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaHabitacionBuscador(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoModificaReserva() {
        if (detalleReserva != null) {
            ObjetoVentana obj = VentanasFactory.getObjetoVentanaReservaFormulario(Ventanas.CHECK_IN, Modality.APPLICATION_MODAL, null);
            if (obj != null) {
                ((ControladorReservaFormulario) obj.getfXMLLoader().getController()).setDetalleReserva(detalleReserva);
                obj.ver();
            }
        }
    }

    private void codigoBotonOk() {

    }

    private void codigoReseteaCampos() {

    }

}
