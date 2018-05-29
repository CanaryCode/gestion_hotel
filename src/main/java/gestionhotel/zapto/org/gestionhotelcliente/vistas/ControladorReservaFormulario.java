package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilFormularios;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaAlojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
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
    private TableView<TablaCliente> tablaAgencia, tablaCliente;
    @FXML
    private TableView<TablaAlojamiento> tablaAlojamiento;

    @FXML
    private TableColumn tableColumnRazonSocialCliente, tableColumnTipoCliente,
            tableColumnNombreComercialCliente, tableColumnDocumentoNumeroCliente,
            tableColumnNombreCliente, tableColumnPrimerApellidoCliente,
            tableColumnSegundoApellidoCliente, tableColumnFechaNacimientoCliente,
            tableColumnNacionalidadCliente, tableColumnProvinciaCliente, tableColumnCiudadCliente,
            tableColumnCalleCliente, tableColumnNumeroCliente, tableColumnCodigoPostalCliente,
            tableColumnSexoCliente, tableColumnEstadoCliente, tableColumnEmailCliente,
            tableColumnPaginaWebCliente, tableColumnCategoriaCliente, tableColumnTratamientoCliente,
            //------------------------------------------------------------------------------------
            tableColumnRazonSocialAgencia, tableColumnNombreComercialAgencia, tableColumnDocumentoNumeroAgencia,
            tableColumnNombreAgencia, tableColumnProvinciaAgencia, tableColumnCiudadAgencia,
            tableColumnCalleAgencia, tableColumnNumeroAgencia, tableColumnCodigoPostalAgencia,
            tableColumnEstadoAgencia, tableColumnEmailAgencia, tableColumnPaginaWebAgencia,
            tableColumnCategoriaAgencia,
            //-------------------------------------------------------------------------------------------------
            tableColumnFechaInicio, tableColumnFechaFin, tableColumnNumeroAdultos, tableColumnNumeroChild,
            tableColumnNumeroBebes, tableColumnPension, tableColumnCamaExtra, tableColumnCuna,
            tableColumnPrefTipoHabitacion, tableColumnPrefHabitacion, tableColumnPrefTipoCama,
            tableColumnPrefVistas, tableColumnPrefRestaurante, tableColumnPrefTipoRestaurante;

    private ObservableList<Persona> listaCliente = FXCollections.observableArrayList();
    private ObservableList<TablaCliente> listaTablaCliente = FXCollections.observableArrayList();
    private ObservableList<Persona> listaAgencia = FXCollections.observableArrayList();
    private ObservableList<TablaCliente> listaTablaAgencia = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaDetalleReserva = FXCollections.observableArrayList();
    private ObservableList<TablaAlojamiento> listaTablaAlojamientos = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaAlojamientos = FXCollections.observableArrayList();

    private DetallesReserva reservaEnVista;
    private Persona ClienteEnVista, AgenciaEnVista;
    private DetallesReserva AlojamientoEnVista;
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
            UtilBuscador.accionCrear(VentanasFactory.getObjetoVentanaDetallesReserva(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null));
        });
        modificarCliente.setOnAction((e) -> {
            codigoModificaCliente();
        });
        borrarAlojamiento.setOnAction((e) -> {
            codigoBorrarAlojamiento();
        });
        //----------------------------------------------------------------------

        UtilBuscador.iniciaComboBox(tipoTarjeta, Registro.ListaTipoTarjeta);

        // ------------------------------------------------------------------------------------------
        tableColumnDocumentoNumeroCliente.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreCliente.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnPrimerApellidoCliente.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoCliente.setCellValueFactory(new PropertyValueFactory("segundoApellido"));
        tableColumnFechaNacimientoCliente.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoCliente.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnCiudadCliente.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaCliente.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnEstadoCliente.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleCliente.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalCliente.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnEmailCliente.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoCliente.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaCliente.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroCliente.setCellValueFactory(new PropertyValueFactory("numero"));
        tableColumnRazonSocialCliente.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        tableColumnTipoCliente.setCellValueFactory(new PropertyValueFactory("esEmpresa"));
        tableColumnNombreComercialCliente.setCellValueFactory(new PropertyValueFactory("nombreComercial"));
        tableColumnPaginaWebCliente.setCellValueFactory(new PropertyValueFactory("paginaWeb"));
        tableColumnNacionalidadCliente.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        //------------------------------------------------------------------------------------------
        tableColumnDocumentoNumeroAgencia.setCellValueFactory(new PropertyValueFactory("numeroDocumento"));
        tableColumnNombreAgencia.setCellValueFactory(new PropertyValueFactory("nombre"));
        tableColumnCiudadAgencia.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaAgencia.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnEstadoAgencia.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleAgencia.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalAgencia.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnEmailAgencia.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnCategoriaAgencia.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroAgencia.setCellValueFactory(new PropertyValueFactory("numero"));
        tableColumnRazonSocialAgencia.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        tableColumnNombreComercialAgencia.setCellValueFactory(new PropertyValueFactory("nombreComercial"));
        tableColumnPaginaWebAgencia.setCellValueFactory(new PropertyValueFactory("paginaWeb"));
        //-------------------------------------------------------------------------------------------
        tableColumnFechaInicio.setCellValueFactory(new PropertyValueFactory("fechaInicio"));
        tableColumnFechaFin.setCellValueFactory(new PropertyValueFactory("fechaFin"));
        tableColumnNumeroAdultos.setCellValueFactory(new PropertyValueFactory("NumeroAdultos"));
        tableColumnNumeroChild.setCellValueFactory(new PropertyValueFactory("NumeroChild"));
        tableColumnNumeroBebes.setCellValueFactory(new PropertyValueFactory("NumeroBebes"));
        tableColumnPension.setCellValueFactory(new PropertyValueFactory("Pension"));
        tableColumnCamaExtra.setCellValueFactory(new PropertyValueFactory("CamaExtra"));
        tableColumnCuna.setCellValueFactory(new PropertyValueFactory("cuna"));
        tableColumnPrefTipoHabitacion.setCellValueFactory(new PropertyValueFactory("PrefTipoHabitacion"));
        tableColumnPrefHabitacion.setCellValueFactory(new PropertyValueFactory("PrefHabitacion"));
        tableColumnPrefTipoCama.setCellValueFactory(new PropertyValueFactory("PrefTipoCama"));
        tableColumnPrefVistas.setCellValueFactory(new PropertyValueFactory("PrefVistas"));
        tableColumnPrefRestaurante.setCellValueFactory(new PropertyValueFactory("PrefTurnoRestaurante"));
        tableColumnPrefTipoRestaurante.setCellValueFactory(new PropertyValueFactory("PrefTipoRestaurante"));
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
            AgenciaEnVista = UtilBuscador.onMouseClickedOnTable(tablaAgencia, event, VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), AgenciaEnVista,
                    listaAgencia);
        });
        tablaCliente.setOnMouseClicked((event) -> {
            ClienteEnVista = UtilBuscador.onMouseClickedOnTable(tablaCliente, event, VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), ClienteEnVista,
                    listaCliente);

        });
        tablaAlojamiento.setOnMouseClicked((event) -> {
            AlojamientoEnVista = UtilBuscador.onMouseClickedOnTable(tablaAlojamiento, event, VentanasFactory.getObjetoVentanaDetallesReserva(Ventanas.RESERVA_FORMULARIO, Modality.WINDOW_MODAL, null), AlojamientoEnVista,
                    listaAlojamientos, borrarAlojamiento);
        });
        //---------------------------------------------------------------------------------------------
    }

    private void codigoConfirmar() {

    }

    private void codigoModificaAgencia() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorClienteBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaAgencia).
                    setFiltro(PruebasModelo.getListaDeClientes()).
                    setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
            obj.ver();
        }
    }

    private void codigoModificaCliente() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
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
        reservaEnVista = (DetallesReserva) objetoEnVista;
        //----------------------------------------------------------------------
        //------------------Lista Cliente---------------------------------------
        //----------------------------------------------------------------------
        listaCliente.add(reservaEnVista.getReserva().getPersonaByCodCliente());
        listaTablaCliente.addAll(TablaCliente.getTablaBuscadorCliente(listaCliente));
        tablaCliente.setItems(listaTablaCliente);
        //----------------------------------------------------------------------
        //------------------Lista Agencia---------------------------------------
        //----------------------------------------------------------------------
        listaAgencia.add(reservaEnVista.getReserva().getPersonaByAgencia());
        listaTablaAgencia.addAll(TablaCliente.getTablaBuscadorCliente(listaAgencia));
        tablaAgencia.setItems(listaTablaAgencia);
        //----------------------------------------------------------------------
        //------------------Lista Alojamientos----------------------------------
        //----------------------------------------------------------------------
        for (DetallesReserva dr : PruebasModelo.getListaDeAlojamientos()) {
            if (reservaEnVista.getReserva().getCodReserva().equals(dr.getReserva().getCodReserva())) {
                listaAlojamientos.add(dr);
            }
        }
        listaTablaAlojamientos.addAll(TablaAlojamiento.getListaTablaAlojamiento(listaAlojamientos));
        tablaAlojamiento.setItems(listaTablaAlojamientos);
        //---------------------------------------------------
        listaDetalleReserva.add(reservaEnVista);
        //----------------------------------------------------

        if (reservaEnVista.getReserva().getTipoTarjetaCredito() != null) {
            tipoTarjeta.getSelectionModel().select(reservaEnVista.getReserva().getTipoTarjetaCredito());
        }
        if (reservaEnVista.getReserva().getNumeroTarjetaCredito() != null) {
            numeroTarjeta.setText(reservaEnVista.getReserva().getNumeroTarjetaCredito());
        }
        if (reservaEnVista.getReserva().getComentario() != null) {
            comentario.setText(reservaEnVista.getReserva().getComentario());
        }
        return this;
    }
}
