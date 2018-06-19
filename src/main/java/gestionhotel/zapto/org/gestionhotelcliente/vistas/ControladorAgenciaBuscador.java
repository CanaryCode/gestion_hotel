package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.BuscadorInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaAgencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaCliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Agencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorAgenciaBuscador implements Initializable,BuscadorInterface {

   @FXML
    private AnchorPane panelPrincipal, panelFiltro;

    @FXML
    private TableView<?> tablaPersona, tabla;

    @FXML
    private Button modificaPersona, buscar, resetearCampos, crear, actualizar, borrar, seleccionar;

    @FXML
    private ToggleButton toggleButtonModificaPersona;

    private ObservableList<TablaAgencia> listaTablaClientes = FXCollections.observableArrayList();
    private ObservableList<Agencia> listaAddClientes = FXCollections.observableArrayList();
    private ObservableList<Agencia> listaFiltro = FXCollections.observableArrayList();
    private ObservableList<Persona> listaPersona = FXCollections.observableArrayList();
    private ObservableList<TablaPersona> listaTablaPersona = FXCollections.observableArrayList();
    private Agencia ClienteEnVista;

    private ObservableList<Node> nodosApagables;

    private int modo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        borrar.setOnAction((e) -> {
            UtilBuscador.accionBorrar();
        });

        crear.setOnAction((e) -> {
            UtilBuscador.accionCrear(VentanasFactory.getClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null));
        });
        actualizar.setOnAction((e) -> {
            UtilBuscador.accionActualizar(VentanasFactory.getClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null), ClienteEnVista);
        });
        buscar.setOnAction((e) -> {
            //--------------------------
        });
        seleccionar.setOnAction((e) -> {
            UtilBuscador.accionSeleccionar(listaAddClientes, ClienteEnVista, Ventanas.CLIENTE_BUSCADOR);
        });
        resetearCampos.setOnAction((e) -> {
            UtilBuscador.ResetearCampos(panelPrincipal);
        });
        modificaPersona.setOnAction((e) -> {
            UtilBuscador.abrirPersona(VentanasFactory.getPersonaBuscador(Ventanas.CLIENTE_BUSCADOR, Modality.NONE, null)
                    , listaPersona, PruebasModelo.getListaDePersonas(), Ventanas.MODO_BUSCADOR_SELECCIONAR);
        });

        //---------------------------------------------------------------------
        tabla.setOnMouseClicked((event) -> {
            ClienteEnVista = UtilBuscador.onMouseClickedOnTable(tabla, event, VentanasFactory.getClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null),
                    ClienteEnVista, listaFiltro, seleccionar,
                    actualizar, borrar);
        });
        //----------------------------------------------------------------------------------------
        nodosApagables = FXCollections.observableArrayList(resetearCampos, buscar);
        CreadorDeTabla.generaTabla(panelPrincipal, tablaPersona, listaPersona, new TablaPersona().getListaObjetosColumnas());
        //---------------------------------------------------------------------------------------
        UtilBuscador.apagaToggle(toggleButtonModificaPersona, modificaPersona, panelPrincipal, nodosApagables);
    }

    @Override
    public ControladorAgenciaBuscador setModo(int modo) {
        this.modo = modo;
        return this;
    }

    @Override
    public <T> ControladorAgenciaBuscador setListaToAdd(ObservableList<T> ListaObjeto) {
        this.listaAddClientes = (ObservableList<Agencia>) ListaObjeto;
        return this;
    }

    @Override
    public <T> ControladorAgenciaBuscador setFiltro(ObservableList<T> ListaObjeto) {
        this.listaFiltro = (ObservableList<Agencia>) ListaObjeto;
        listaTablaClientes = new TablaAgencia().getListaObjetosDeTabla(listaFiltro);
        CreadorDeTabla.generaTabla(panelPrincipal, tabla, listaTablaClientes, new TablaCliente().getListaObjetosColumnas());
        return this;
    }
}
