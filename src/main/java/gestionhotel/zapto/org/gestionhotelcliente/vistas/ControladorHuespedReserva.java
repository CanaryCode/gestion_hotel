package gestionhotel.zapto.org.gestionhotelcliente.vistas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VinculadorModeloATabla;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.UtilBuscador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases.Select;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaHuesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.net.URL;
import java.util.ResourceBundle;
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
    private Button botonAddResponsable, botonBorrarResponsable, botonAddOtros, botonBorrarOtros,
            botonAddChild, botonBorrarChild, botonAddBebes, botonBorrarBebes,
            botonOk, reseteaCampos;

    @FXML
    private AnchorPane principal;
    @FXML
    private TableView<TablaHuesped> tablaResponsable, tablaOtros, tablaChild, tablaBebes;
    //-------------------------------------------------------------------------------------------
    private ObservableList<Persona> listaHuespedResponsable, listaHuespedOtros, listaHuespedChild,
            listaHuespedBebes, listaHuespedTodos, listaHuespedResponsableCopia, listaHuespedOtrosCopia, listaHuespedChildCopia,
            listaHuespedBebesCopia;
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedOtros = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedChild = FXCollections.observableArrayList();
    private ObservableList<TablaHuesped> listaTablaHuespedBebes = FXCollections.observableArrayList();
    ;
    private int maxHuespedResponsables = 1, maxHuespedOtros = 2, maxHuespedChild = 2, maxHuespedBebes;
    private Persona ResponsableEnVista, OtrosHuespedesEnVista, ChildEnVista, BebesEnVista;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonAddResponsable.setOnAction((e) -> {
            accionAddResponsable();
        });
        botonAddOtros.setOnAction((e) -> {
            accionAddOtros();
        });
        botonAddChild.setOnAction((e) -> {
            accionAddChild();
        });

        botonAddBebes.setOnAction((e) -> {
            accionAddBebes();
        });
        //----------------------------------------------------------------------

        botonBorrarResponsable.setOnAction((e) -> {
            logicaBorrar(listaHuespedResponsableCopia, tablaResponsable);;
        });
        botonBorrarOtros.setOnAction((e) -> {
            logicaBorrar(listaHuespedOtrosCopia, tablaOtros);
        });
        botonBorrarChild.setOnAction((e) -> {
            logicaBorrar(listaHuespedChildCopia, tablaChild);
        });
        botonBorrarBebes.setOnAction((e) -> {
            logicaBorrar(listaHuespedBebesCopia, tablaBebes);
        });
        //-----------------------------------------------------------------------

        botonOk.setOnAction((e) -> {
            accionOK();
        });

        reseteaCampos.setOnAction((event) -> {
            codigoReseteaCampos();
        });
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
        tablaOtros.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                botonBorrarOtros.setDisable(true);
            } else {
                botonBorrarOtros.setDisable(false);
            }
        });
        tablaResponsable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                botonBorrarResponsable.setDisable(true);
            } else {
                botonBorrarResponsable.setDisable(false);
            }
        });
        //------------------------------------------------------------------------------------------
        tablaResponsable.setOnMouseClicked((event) -> {
            ResponsableEnVista = UtilBuscador.onMouseClickedOnTable(tablaResponsable, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ResponsableEnVista,
                    listaHuespedResponsableCopia, botonBorrarResponsable);
        });
        tablaOtros.setOnMouseClicked((event) -> {
            OtrosHuespedesEnVista = UtilBuscador.onMouseClickedOnTable(tablaOtros, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), OtrosHuespedesEnVista,
                    listaHuespedOtrosCopia, tablaOtros, botonBorrarOtros);
        });
        tablaChild.setOnMouseClicked((event) -> {
            ChildEnVista = UtilBuscador.onMouseClickedOnTable(tablaChild, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ChildEnVista,
                    listaHuespedChildCopia, botonBorrarChild);
        });
        tablaBebes.setOnMouseClicked((event) -> {
            UtilBuscador.onMouseClickedOnTable(tablaBebes, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null),
                    BebesEnVista, listaHuespedBebesCopia, botonBorrarBebes);
        });
    }

    private void accionAddResponsable() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA,
                Modality.WINDOW_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedResponsableCopia).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedResponsable, listaHuespedChild, listaHuespedOtros)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddOtros() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedOtrosCopia).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedResponsable, listaHuespedChild, listaHuespedOtros)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddChild() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedChildCopia).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedResponsable, listaHuespedChild, listaHuespedOtros)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddBebes() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedBebesCopia).
                setFiltro(UtilBuscador.creaFiltro(Select.getHuespedesFuera(), listaHuespedBebes,
                        listaHuespedResponsable, listaHuespedChild, listaHuespedOtros)).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionOK() {
        Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
    }

    private void codigoReseteaCampos() {
        borrarListas();
    }

    public ControladorHuespedReserva setNumeroHuespedes(int numeroResponsables, int numeroOtros,
            int numeroChild, int numeroBebes) {
        this.maxHuespedResponsables = numeroResponsables;
        this.maxHuespedOtros = numeroOtros;
        this.maxHuespedChild = numeroChild;
        this.maxHuespedBebes = numeroBebes;
        if (maxHuespedBebes > 0) {
            botonAddBebes.setDisable(false);
        }
        if (maxHuespedResponsables > 0) {
            botonAddResponsable.setDisable(false);
        }
        if (maxHuespedChild > 0) {
            botonAddChild.setDisable(false);
        }
        if (maxHuespedOtros > 0) {
            botonAddOtros.setDisable(false);
        }

        return this;
    }

    public ControladorHuespedReserva setListas(ObservableList<Persona> listaTodosLosHuespedes, ObservableList<Persona> huespedOtrosLista,
            ObservableList<Persona> huespedResponsableLista, ObservableList<Persona> huespedChildLista,
            ObservableList<Persona> huespedBebesLista) {
        this.listaHuespedBebes = huespedBebesLista;
        this.listaHuespedChild = huespedChildLista;
        this.listaHuespedOtros = huespedOtrosLista;
        this.listaHuespedResponsable = huespedResponsableLista;
        this.listaHuespedTodos = listaTodosLosHuespedes;
        listaTablaHuespedBebes.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedBebes));
        listaTablaHuespedChild.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedChild));
        listaTablaHuespedOtros.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedOtros));
        listaTablaHuespedResponsable.addAll(new TablaHuesped().getListaObjetosDeTabla(listaHuespedResponsable));
        listaHuespedResponsableCopia = FXCollections.observableArrayList(this.listaHuespedResponsable);
        listaHuespedResponsableCopia.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        listaHuespedResponsable.addAll(c.getAddedSubList());
                        listaTodosLosHuespedes.addAll(c.getAddedSubList());
                    } else if (c.wasRemoved()) {
                        listaTodosLosHuespedes.removeAll(c.getRemoved());
                        listaHuespedResponsable.removeAll(c.getRemoved());
                    }
                    VinculadorModeloATabla.vinculaAListaTabla(listaHuespedResponsable, listaTablaHuespedResponsable, new TablaHuesped(), c);
                    enciendoAdds(huespedResponsableLista, maxHuespedResponsables, botonAddResponsable);
                    habilitadorBotonesOkYResetea();
                }
            }
        }
        );
        listaHuespedOtrosCopia = FXCollections.observableArrayList(this.listaHuespedOtros);
        listaHuespedOtrosCopia.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        listaTodosLosHuespedes.addAll(c.getAddedSubList());
                        listaHuespedOtros.addAll(c.getAddedSubList());
                    } else if (c.wasRemoved()) {
                        listaTodosLosHuespedes.removeAll(c.getRemoved());
                        listaHuespedOtros.removeAll(c.getRemoved());
                    }
                    VinculadorModeloATabla.vinculaAListaTabla(listaHuespedOtros, listaTablaHuespedOtros, new TablaHuesped(), c);
                    enciendoAdds(huespedOtrosLista, maxHuespedOtros, botonAddOtros);
                    habilitadorBotonesOkYResetea();
                }
            }
        }
        );
        listaHuespedChildCopia = FXCollections.observableArrayList(this.listaHuespedChild);
        listaHuespedChildCopia.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        listaTodosLosHuespedes.addAll(c.getAddedSubList());
                        listaHuespedChild.addAll(c.getAddedSubList());
                    } else if (c.wasRemoved()) {
                        listaTodosLosHuespedes.removeAll(c.getRemoved());
                        listaHuespedChild.removeAll(c.getRemoved());
                    }
                    VinculadorModeloATabla.vinculaAListaTabla(listaHuespedChild, listaTablaHuespedChild, new TablaHuesped(), c);
                    enciendoAdds(huespedChildLista, maxHuespedChild, botonAddChild);
                    habilitadorBotonesOkYResetea();
                }
            }
        }
        );
        listaHuespedBebesCopia = FXCollections.observableArrayList(this.listaHuespedBebes);
        listaHuespedBebesCopia.addListener(new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        listaTodosLosHuespedes.addAll(c.getAddedSubList());
                        listaHuespedBebes.addAll(c.getAddedSubList());
                    } else if (c.wasRemoved()) {
                        listaTodosLosHuespedes.removeAll(c.getRemoved());
                        listaHuespedBebes.removeAll(c.getRemoved());
                    }
                    VinculadorModeloATabla.vinculaAListaTabla(listaHuespedBebes, listaTablaHuespedBebes, new TablaHuesped(), c);
                    enciendoAdds(huespedBebesLista, maxHuespedBebes, botonAddBebes);
                    habilitadorBotonesOkYResetea();
                }
            }
        }
        );
        this.listaHuespedResponsable = huespedResponsableLista;
        CreadorDeTabla.generaTabla(principal, tablaResponsable, listaTablaHuespedResponsable, new TablaHuesped().getListaObjetosColumnas());
        //-----------------------------------------------------------------------------------------------
        this.listaHuespedOtros = huespedOtrosLista;
        CreadorDeTabla.generaTabla(principal, tablaOtros, listaTablaHuespedOtros, new TablaHuesped().getListaObjetosColumnas());
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

    private void logicaBorrar(ObservableList<Persona> listaHuesped, TableView<TablaHuesped> tabla) {
        TablaHuesped th = tabla.getSelectionModel().getSelectedItem();
        if (th != null) {
            listaHuesped.remove(tabla.getSelectionModel().getSelectedIndex());
        }
    }

    private void enciendoAdds(ObservableList<Persona> lista, int max, Button boton) {
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
                Ventanas.cerrarVentana(Ventanas.HUESPED_RESERVA);
            } else {
                event.consume();
            }
        });
    }

    private void borrarListas() {
        listaHuespedBebesCopia.clear();
        listaHuespedChildCopia.clear();
        listaHuespedOtrosCopia.clear();
        listaHuespedResponsableCopia.clear();
    }

    private void habilitadorBotonesOkYResetea() {
        if (tablaBebes.getItems().isEmpty() && tablaChild.getItems().isEmpty()
                && tablaOtros.getItems().isEmpty() && tablaResponsable.getItems().isEmpty()) {
            reseteaCampos.setDisable(true);
        } else {
            reseteaCampos.setDisable(false);
        }
        if (tablaResponsable.getItems().isEmpty()) {
            botonOk.setDisable(true);
        } else {
            botonOk.setDisable(false);
        }
    }
}
