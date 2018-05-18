package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHuespedReserva implements Initializable {

    @FXML
    private Button botonAdd1, botonAdd2, botonOk,
            botonBorrar1, botonBorrar2, reseteaCampos;

    @FXML
    public AnchorPane principal;
    @FXML
    public TableView<TablaHuesped> tablaResponsable, tablaOtros;
    @FXML
    public TableColumn tableColumnNumero, tableColumnDni, tableColumnNombre, tableColumnPrimerApellido,
            tableColumnSegundoApellido, tableColumnFechaNacimiento, tableColumnSexo, tableColumnDiscapacitado,
            tableColumnCiudad, tableColumnProvincia, tableColumnPais, tableColumnCalle, tableColumnCodigoPostal,
            tableColumnPasaporte, tableColumnFechaExpedicion, tableColumnEmail, tableColumnTratamiento,
            tableColumnCategoria,
            //------------------------------------------------------------------------------------------
            tableColumnNumero1, tableColumnDni1, tableColumnNombre1, tableColumnPrimerApellido1,
            tableColumnSegundoApellido1, tableColumnFechaNacimiento1, tableColumnSexo1, tableColumnDiscapacitado1,
            tableColumnCiudad1, tableColumnProvincia1, tableColumnPais1, tableColumnCalle1, tableColumnCodigoPostal1,
            tableColumnPasaporte1, tableColumnFechaExpedicion1, tableColumnEmail1, tableColumnTratamiento1,
            tableColumnCategoria1;
    //-------------------------------------------------------------------------------------------

    private ObservableList<Persona> listaHuespedes;
    private ObservableList<Persona> listaHuespededResponsable;
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable;
    private ObservableList<TablaHuesped> listaTablaHuespedes;
    private ObservableList<Persona> listaTodosLosHuespedes;
    private int maxResponsables = 1, MaxHuespedes = 2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonAdd1.setOnAction((e) -> {
            accionAdd1();
        });
        botonAdd2.setOnAction((e) -> {
            accionAdd2();
        });

        botonBorrar1.setOnAction((e) -> {
            accionBorrar1();
        });
        botonBorrar2.setOnAction((e) -> {
            accionBorrar2();
        });

        botonOk.setOnAction((e) -> {
            accionOK();
        });

        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });

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
        //------------------------------------------------------------------------------------------

    }

    /**
     *
     */
    private void accionAdd1() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA,
                Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setModoVentana(Ventanas.MODO_SELECCIONAR).
                    setListaHuesped(listaHuespededResponsable, listaTablaHuespedResponsable, listaTodosLosHuespedes);
            obj.ver();
        }

    }

    private void accionAdd2() {

        ObjetoVentana obj = VentanasFactory.getObjetoVentanaBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                    setModoVentana(Ventanas.MODO_SELECCIONAR).setListaHuesped(listaHuespedes, listaTablaHuespedes, listaTodosLosHuespedes);
            obj.ver();
        }

    }

    private void accionBorrar1() {
        listaHuespededResponsable.remove(listaHuespededResponsable.size() - 1);
        listaTablaHuespedResponsable.remove(listaTablaHuespedResponsable.size() - 1);
        listaTodosLosHuespedes.remove(listaTodosLosHuespedes.size() - 1);

    }

    private void accionBorrar2() {
        listaHuespedes.remove(listaHuespedes.size() - 1);
        listaTablaHuespedes.remove(listaTablaHuespedes.size() - 1);
        listaTodosLosHuespedes.remove(listaTodosLosHuespedes.size() - 1);
    }

    private void accionOK() {
         Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
    }

    private void codigoReseteaCampos() {
        listaHuespedes.clear();
        listaHuespededResponsable.clear();
        listaTodosLosHuespedes.clear();
        listaTablaHuespedResponsable.clear();
        listaTablaHuespedes.clear();
    }

    private void codigoListaHuespedResponsable() {
        if (listaHuespededResponsable.size() == maxResponsables) {
            botonAdd1.setDisable(true);
            botonAdd2.setDisable(false);
        } else if (listaHuespededResponsable.size() < maxResponsables) {
            botonAdd1.setDisable(false);
        }
        if (!listaHuespededResponsable.isEmpty()) {
            botonOk.setDisable(false);
            reseteaCampos.setDisable(false);
            botonBorrar1.setDisable(false);
            botonAdd2.setDisable(false);
            botonAdd1.setDisable(true);
        } else {
            botonAdd1.setDisable(false);
            botonBorrar1.setDisable(true);
            botonOk.setDisable(true);
            reseteaCampos.setDisable(true);
            botonAdd2.setDisable(true);
        }
    }

    private void codigoListaHuespedes() {
        if (listaHuespedes.size() == MaxHuespedes) {
            botonAdd2.setDisable(true);
        } else if (listaHuespedes.size() < MaxHuespedes) {
            botonAdd2.setDisable(false);
        }
        if (listaHuespedes.isEmpty()) {
            botonBorrar1.setDisable(false);
            botonAdd2.setDisable(false);
            botonBorrar2.setDisable(true);
        } else {
            botonBorrar1.setDisable(true);
            botonBorrar2.setDisable(false);
        }
    }

    public ControladorHuespedReserva setNumeroHuespedes(int numeroResponsables, int numeroNormales) {
        this.maxResponsables = numeroResponsables;
        this.MaxHuespedes = numeroNormales;

        return this;
    }

    public ControladorHuespedReserva setListas(ObservableList<Persona> listaHuespedes,
            ObservableList<Persona> listaHuespededResponsable, ObservableList<TablaHuesped> listaTablaHuespedResponsable,
            ObservableList<TablaHuesped> listaTablaHuespedes, ObservableList<Persona> listaTodosLosHuespedes) {
        this.listaHuespedes = listaHuespedes;
        this.listaHuespededResponsable = listaHuespededResponsable;
        this.listaTablaHuespedResponsable = listaTablaHuespedResponsable;
        this.listaTablaHuespedes = listaTablaHuespedes;
        this.listaTodosLosHuespedes = listaTodosLosHuespedes;
        tablaResponsable.setItems(listaTablaHuespedResponsable);
        tablaOtros.setItems(listaTablaHuespedes);
        listaHuespededResponsable.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                codigoListaHuespedResponsable();
            }
        });
        listaHuespedes.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                codigoListaHuespedes();
            }
        });

        return this;
    }

}
