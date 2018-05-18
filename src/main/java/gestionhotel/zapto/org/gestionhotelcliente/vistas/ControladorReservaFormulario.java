package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
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
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorReservaFormulario implements Initializable {

    @FXML
    private ComboBox tipoTarjeta;

    @FXML
    private TextArea comentario;

    @FXML
    private Button confirmar, buscarCliente, buscarAgencia, alojamientos;

    @FXML
    private TextField  numeroTarjeta;
    @FXML
    private TableView tablaAgencia, tablaCliente;

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
            tableColumnRazonSocialAgencia, tableColumnTipoAgencia,
            tableColumnNombreComercialAgencia, tableColumnDocumentoNumeroAgencia,
            tableColumnNombreAgencia, tableColumnPrimerApellidoAgencia,
            tableColumnSegundoApellidoAgencia, tableColumnFechaNacimientoAgencia,
            tableColumnNacionalidadAgencia, tableColumnProvinciaAgencia, tableColumnCiudadAgencia,
            tableColumnCalleAgencia, tableColumnNumeroAgencia, tableColumnCodigoPostalAgencia,
            tableColumnSexoAgencia, tableColumnEstadoAgencia, tableColumnEmailAgencia,
            tableColumnPaginaWebAgencia, tableColumnCategoriaAgencia, tableColumnTratamientoAgencia;

    private ObservableList<Persona> listaCliente = FXCollections.observableArrayList();
    private ObservableList<TablaCliente> listaTablaCliente = FXCollections.observableArrayList();
    private ObservableList<Persona> listaAgencia = FXCollections.observableArrayList();
    private ObservableList<TablaCliente> listaTablaAgencia = FXCollections.observableArrayList();
    private ObservableList<DetallesReserva> listaDetalleReserva = FXCollections.observableArrayList();

    private DetallesReserva detalleReserva;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscarCliente.setOnAction((e) -> {
            codigoBuscarCliente();
        });
        confirmar.setOnAction((e) -> {
            codigoConfirmar();
        });
        buscarAgencia.setOnAction((e) -> {
            codigoBuscarAgencia();
        });
        alojamientos.setOnAction((e) -> {
            codigoAlojamientos();
        });

        tipoTarjeta.setItems(FXCollections.observableList(Registro.ListaTipoTarjeta));
        tipoTarjeta.getSelectionModel().selectFirst();

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
        tableColumnPrimerApellidoAgencia.setCellValueFactory(new PropertyValueFactory("primerApellido"));
        tableColumnSegundoApellidoAgencia.setCellValueFactory(new PropertyValueFactory("segundoApellido"));
        tableColumnFechaNacimientoAgencia.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        tableColumnSexoAgencia.setCellValueFactory(new PropertyValueFactory("sexoHombre"));
        tableColumnCiudadAgencia.setCellValueFactory(new PropertyValueFactory("ciudad"));
        tableColumnProvinciaAgencia.setCellValueFactory(new PropertyValueFactory("provincia"));
        tableColumnEstadoAgencia.setCellValueFactory(new PropertyValueFactory("estado"));
        tableColumnCalleAgencia.setCellValueFactory(new PropertyValueFactory("calle"));
        tableColumnCodigoPostalAgencia.setCellValueFactory(new PropertyValueFactory("codigoPostal"));
        tableColumnEmailAgencia.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnTratamientoAgencia.setCellValueFactory(new PropertyValueFactory("tratamiento"));
        tableColumnCategoriaAgencia.setCellValueFactory(new PropertyValueFactory("categoria"));
        tableColumnNumeroAgencia.setCellValueFactory(new PropertyValueFactory("numero"));
        tableColumnRazonSocialAgencia.setCellValueFactory(new PropertyValueFactory("razonSocial"));
        tableColumnTipoAgencia.setCellValueFactory(new PropertyValueFactory("esEmpresa"));
        tableColumnNombreComercialAgencia.setCellValueFactory(new PropertyValueFactory("nombreComercial"));
        tableColumnPaginaWebAgencia.setCellValueFactory(new PropertyValueFactory("paginaWeb"));
        tableColumnNacionalidadAgencia.setCellValueFactory(new PropertyValueFactory("nacionalidad"));

    }

    private void codigoConfirmar() {

    }

    private void codigoBuscarAgencia() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoAlojamientos() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaAlojamiento(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    private void codigoBuscarCliente() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarCliente(Ventanas.RESERVA_FORMULARIO, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    public ControladorReservaFormulario setDetalleReserva(DetallesReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
        //-----------------------------------------------------
        listaCliente.add(detalleReserva.getReserva().getPersonaByCodCliente());
        listaTablaCliente.addAll(TablaCliente.getTablaBuscadorCliente(listaCliente));
        tablaCliente.setItems(listaTablaCliente);
        //---------------------------------------------------
        listaAgencia.add(detalleReserva.getReserva().getPersonaByAgencia());
        listaTablaAgencia.addAll(TablaCliente.getTablaBuscadorCliente(listaAgencia));
        tablaAgencia.setItems(listaTablaAgencia);
        //---------------------------------------------------
        listaDetalleReserva.add(detalleReserva);
        //----------------------------------------------------
      
        if (detalleReserva.getReserva().getTipoTarjetaCredito() != null) {
            tipoTarjeta.getSelectionModel().select(detalleReserva.getReserva().getTipoTarjetaCredito());
        }
        if (detalleReserva.getReserva().getNumeroTarjetaCredito() != null) {
            numeroTarjeta.setText(detalleReserva.getReserva().getNumeroTarjetaCredito());
        }
        if (detalleReserva.getReserva().getComentario()!= null) {
            comentario.setText(detalleReserva.getReserva().getComentario());
        }
        return this;
    }
}
