package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VinculadorModeloATabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class ControladorHuespedReserva implements Initializable {

    @FXML
    private Button botonAddAdultos, botonBorrarAdultos,
            botonAddChild, botonBorrarChild, botonAddBebes, botonBorrarBebes,
            botonOk, reseteaCampos;

    @FXML
    private AnchorPane principal;
    @FXML
    private TableView<TablaHuesped> tablaAdultos, tablaChild, tablaBebes;
    //-------------------------------------------------------------------------------------------
    private ObservableList<Huesped> listaHuespedAdultos, listaHuespedChild,
            listaHuespedBebes, listaHuespedTodos;
    private ObservableList<TablaHuesped> listaTablaHuespedAdultos;
    private ObservableList<TablaHuesped> listaTablaHuespedChild;
    private ObservableList<TablaHuesped> listaTablaHuespedBebes;
    ;
    private int maxHuespedAdultos, maxHuespedChild, maxHuespedBebes;
    private Huesped HuespedesEnVista, ChildEnVista, BebesEnVista;
    private ListChangeListener<TablaHuesped> listenerAdultos, listenerChild, listenerBebes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonAddAdultos.setOnAction((e) -> {
            accionAddAdultos();
        });
        botonAddChild.setOnAction((e) -> {
            accionAddChild();
        });

        botonAddBebes.setOnAction((e) -> {
            accionAddBebes();
        });
        //----------------------------------------------------------------------

        botonBorrarAdultos.setOnAction((e) -> {
            logicaBorrar(listaHuespedAdultos, tablaAdultos);
        });
        botonBorrarChild.setOnAction((e) -> {
            logicaBorrar(listaHuespedChild, tablaChild);
        });
        botonBorrarBebes.setOnAction((e) -> {
            logicaBorrar(listaHuespedBebes, tablaBebes);
        });
        //-----------------------------------------------------------------------

        botonOk.setOnAction((e) -> {
            accionOK();
        });

        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });

    }

    private void accionAddAdultos() {
        Ventana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedAdultos).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedChild, listaHuespedAdultos)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.verReajustable();
    }

    private void accionAddChild() {
        Ventana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedChild).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedChild, listaHuespedAdultos)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.verReajustable();
    }

    private void accionAddBebes() {
        Ventana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedBebes).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedChild, listaHuespedAdultos)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.verReajustable();
    }

    private void accionOK() {
        tablaAdultos.getItems().removeListener(listenerAdultos);
        tablaChild.getItems().removeListener(listenerChild);
        tablaBebes.getItems().removeListener(listenerBebes);
        Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
    }

    private void codigoReseteaCampos() {
        borrarListas();
    }

    public ControladorHuespedReserva setNumeroHuespedes(int numeroAdultos, int numeroChild,
            int numeroBebes) {
        this.maxHuespedAdultos = numeroAdultos;
        this.maxHuespedChild = numeroChild;
        this.maxHuespedBebes = numeroBebes;
        if (maxHuespedBebes > 0) {
            botonAddBebes.setDisable(false);
        }
        if (maxHuespedChild > 0) {
            botonAddChild.setDisable(false);
        }
        if (maxHuespedAdultos > 0) {
            botonAddAdultos.setDisable(false);
        }

        return this;
    }
    public ControladorHuespedReserva setListas(ObservableList<Huesped> listaTodosLosHuespedes,
            ObservableList<Huesped> huespedAdultosLista, ObservableList<Huesped> huespedChildLista,
            ObservableList<Huesped> huespedBebesLista, ObservableList<TablaHuesped> listaTablaAdultos,
            ObservableList<TablaHuesped> listaTablaChild, ObservableList<TablaHuesped> listaTablaBebes) {
        this.listaHuespedBebes = huespedBebesLista;
        this.listaHuespedChild = huespedChildLista;
        this.listaHuespedAdultos = huespedAdultosLista;
        this.listaHuespedTodos = listaTodosLosHuespedes;
        this.listaTablaHuespedAdultos = listaTablaAdultos;
        this.listaTablaHuespedChild = listaTablaChild;
        this.listaTablaHuespedBebes = listaTablaBebes;
        listaTablaHuespedBebes.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedBebes));
        listaTablaHuespedChild.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedChild));
        listaTablaHuespedAdultos.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedAdultos));
        tablaAdultos.setItems(listaTablaAdultos);
        tablaChild.setItems(listaTablaChild);
        tablaBebes.setItems(listaTablaBebes);
        listenerAdultos = new ListChangeListener<TablaHuesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TablaHuesped> c) {
                enciendoAdds(huespedAdultosLista, maxHuespedAdultos, botonAddAdultos);
                habilitadorBotonesOkYResetea();
            }
        };
        tablaAdultos.getItems().addListener(listenerAdultos);

        listenerChild = new ListChangeListener<TablaHuesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TablaHuesped> c) {
                enciendoAdds(huespedChildLista, maxHuespedChild, botonAddChild);
                habilitadorBotonesOkYResetea();
            }
        };
        tablaChild.getItems().addListener(listenerChild);

        listenerBebes = new ListChangeListener<TablaHuesped>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends TablaHuesped> c) {
                enciendoAdds(huespedBebesLista, maxHuespedBebes, botonAddBebes);
                habilitadorBotonesOkYResetea();
            }
        };
        tablaBebes.getItems().addListener(listenerBebes);
        //------------------------------------------------------------------------------------------
        tablaBebes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                botonBorrarBebes.setDisable(true);
            } else {
                botonBorrarBebes.setDisable(false);
            }
        });
        tablaChild.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                botonBorrarChild.setDisable(true);
            } else {
                botonBorrarChild.setDisable(false);
            }
        });
        tablaAdultos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                botonBorrarAdultos.setDisable(true);
            } else {
                botonBorrarAdultos.setDisable(false);
            }
        });
        //------------------------------------------------------------------------------------------
        tablaAdultos.setOnMouseClicked((event) -> {
            HuespedesEnVista = UtilBuscador.onMouseClickedOnTable(tablaAdultos, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), HuespedesEnVista,
                    listaHuespedAdultos, tablaAdultos, botonBorrarAdultos);
        });
        tablaChild.setOnMouseClicked((event) -> {
            ChildEnVista = UtilBuscador.onMouseClickedOnTable(tablaChild, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ChildEnVista,
                    listaHuespedChild, botonBorrarChild);
        });
        tablaBebes.setOnMouseClicked((event) -> {
            UtilBuscador.onMouseClickedOnTable(tablaBebes, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null),
                    BebesEnVista, listaHuespedBebes, botonBorrarBebes);
        });
        //-----------------------------------------------------------------------------------------------
        this.listaHuespedAdultos = huespedAdultosLista;
        CreadorDeTabla.generaTabla(principal, tablaAdultos, listaTablaHuespedAdultos, new TablaHuesped().getListaObjetosColumnas());
        //------------------------------------------------------------------------------------------------
        this.listaHuespedChild = huespedChildLista;
        CreadorDeTabla.generaTabla(principal, tablaChild, listaTablaHuespedChild, new TablaHuesped().getListaObjetosColumnas());
        //--------------------------------------------------------------------------------------------
        this.listaHuespedBebes = huespedBebesLista;
        CreadorDeTabla.generaTabla(principal, tablaBebes, listaTablaHuespedBebes, new TablaHuesped().getListaObjetosColumnas());
        //---------------------------------------------------------------------------------------------        
        //----------------------------------------------------------------------------------------
        habilitadorBotonesOkYResetea();
        return this;
    }

    private void logicaBorrar(ObservableList<Huesped> listaHuesped, TableView<TablaHuesped> tabla) {
        TablaHuesped th = tabla.getSelectionModel().getSelectedItem();
        if (th != null) {
            listaHuesped.remove(tabla.getSelectionModel().getSelectedIndex());
        }
    }

    private void enciendoAdds(ObservableList<Huesped> lista, int max, Button boton) {
        if (lista.size() < max) {
            boton.setDisable(false);
        } else {
            boton.setDisable(true);
        }
    }

    public void configuraVentana() {
        Ventanas.getVentana(Ventanas.HUESPED_RESERVA).setOnCloseRequest((event) -> {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Si sale de esta ventana se perderá toda la selección."
                    + "\n ¿Está de acuerdo con salir?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                borrarListas();
                tablaAdultos.getItems().removeListener(listenerAdultos);
                tablaChild.getItems().removeListener(listenerChild);
                tablaBebes.getItems().removeListener(listenerBebes);
                Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
            } else {
                event.consume();
            }
        });
    }

    private void borrarListas() {
        listaHuespedAdultos.clear();
        listaHuespedChild.clear();
        listaHuespedBebes.clear();
    }

    private void habilitadorBotonesOkYResetea() {
        if (tablaBebes.getItems().isEmpty() && tablaChild.getItems().isEmpty()
                && tablaAdultos.getItems().isEmpty()) {
            reseteaCampos.setDisable(true);
            botonOk.setDisable(true);
        } else {
            reseteaCampos.setDisable(false);
            botonOk.setDisable(false);
        }
    }
}
