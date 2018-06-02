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
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TableView<TablaHuesped> tablaResponsable, tablaOtro, tablaChild, tablaBebes;
    //-------------------------------------------------------------------------------------------
    private ObservableList<Persona> listaHuespedResponsable, listaHuespedOtros, listaHuespedChild,
            listaHuespedBebes, listaTodosLosHuespedes;
    private ObservableList<TablaHuesped> listaTablaHuespedResponsable, listaTablaHuespedOtros,
            listaTablaHuespedChild, listaTablaHuespedBebes;
    private int maxHuespedResponsables = 1, maxHuespedOtros = 2, maxHuespedChild = 2, maxHuespedBebes;
    private Persona ResponsableEnVista, OtrosHuespedesEnVista, ChildEnVista, BebesEnVista;
    ListChangeListener<Persona> listenerBebe;
    ListChangeListener<Persona> listenerOtros;
    ListChangeListener<Persona> listenerResponsable;
    ListChangeListener<Persona> listenerChild;

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
            logicaBorrar(listaHuespedResponsable, tablaResponsable);;
        });
        botonBorrarOtros.setOnAction((e) -> {
            logicaBorrar(listaHuespedOtros, tablaOtros);
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
                    listaHuespedResponsable, botonBorrarResponsable);
        });
        tablaOtros.setOnMouseClicked((event) -> {
            OtrosHuespedesEnVista = UtilBuscador.onMouseClickedOnTable(tablaOtros, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), OtrosHuespedesEnVista,
                    listaHuespedOtros, tablaOtros, botonBorrarOtros);
        });
        tablaChild.setOnMouseClicked((event) -> {
            ChildEnVista = UtilBuscador.onMouseClickedOnTable(tablaChild, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null), ChildEnVista,
                    listaHuespedChild, botonBorrarChild);
        });
        tablaBebes.setOnMouseClicked((event) -> {
            UtilBuscador.onMouseClickedOnTable(tablaBebes, event, VentanasFactory.getHuespedFormulario(Ventanas.HUESPED_RESERVA, Modality.WINDOW_MODAL, null),
                    BebesEnVista, listaHuespedBebes, botonBorrarBebes);
        });
    }

    private void accionAddResponsable() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA,
                Modality.WINDOW_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedResponsable).
                setFiltro(PruebasModelo.getListaDeHuespedes()).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddOtros() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedOtros).
                setFiltro(PruebasModelo.getListaDeHuespedes()).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddChild() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedChild).
                setFiltro(PruebasModelo.getListaDeHuespedes()).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionAddBebes() {
        ObjetoVentana obj = VentanasFactory.getBuscarHuesped(Ventanas.HUESPED_RESERVA, Modality.APPLICATION_MODAL, null);
        ((ControladorHuespedBuscador) obj.getfXMLLoader().getController()).
                setListaToAdd(listaHuespedBebes).
                setFiltro(PruebasModelo.getListaDeHuespedes()).
                setModo(Ventanas.MODO_BUSCADOR_SELECCIONAR);
        obj.ver();
    }

    private void accionOK() {
        listaHuespedBebes.removeListener(listenerBebe);
        listaHuespedChild.removeListener(listenerChild);
        listaHuespedOtros.remove(listaHuespedOtros);
        listaHuespedResponsable.removeListener(listenerResponsable);
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
            botonBorrarBebes.setDisable(false);
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

    public ControladorHuespedReserva setListas(ObservableList<Persona> HuespedOtrosLista,
            ObservableList<Persona> HuespedResponsableLista, ObservableList<Persona> HuespedChildLista,
            ObservableList<Persona> HuespedBebesLista, ObservableList<Persona> TodosLosHuespedesLista) {
        this.listaHuespedResponsable = HuespedResponsableLista;
        this.listaTablaHuespedResponsable = new TablaHuesped().getListaObjetosDeTabla(HuespedResponsableLista);
        CreadorDeTabla.generaTabla(principal, tablaResponsable, this.listaTablaHuespedResponsable, new TablaHuesped().getListaObjetosColumnas());
        //-----------------------------------------------------------------------------------------------
        this.listaHuespedOtros = HuespedOtrosLista;
        this.listaTablaHuespedOtros = new TablaHuesped().getListaObjetosDeTabla(this.listaHuespedOtros);
        CreadorDeTabla.generaTabla(principal, tablaOtros, this.listaTablaHuespedOtros, new TablaHuesped().getListaObjetosColumnas());
        //------------------------------------------------------------------------------------------------
        this.listaHuespedChild = HuespedChildLista;
        this.listaTablaHuespedChild = new TablaHuesped().getListaObjetosDeTabla(this.listaHuespedChild);
        CreadorDeTabla.generaTabla(principal, tablaChild, this.listaTablaHuespedChild, new TablaHuesped().getListaObjetosColumnas());
        //--------------------------------------------------------------------------------------------
        this.listaHuespedBebes = HuespedBebesLista;
        this.listaTablaHuespedBebes = new TablaHuesped().getListaObjetosDeTabla(this.listaHuespedBebes);
        CreadorDeTabla.generaTabla(principal, tablaBebes, this.listaTablaHuespedBebes, new TablaHuesped().getListaObjetosColumnas());
        //---------------------------------------------------------------------------------------------
        this.listaTodosLosHuespedes = TodosLosHuespedesLista;
        //-------------------------------------------------
        //-----------------------------------------------------------
        listenerChild=new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedChild, listaTablaHuespedChild, new TablaHuesped(), cambio);
                VinculadorModeloATabla.vinculaVariasAUna(HuespedChildLista, cambio, TodosLosHuespedesLista);
                enciendoAdds(HuespedChildLista, maxHuespedChild, botonAddChild);
                habilitadoBotonesOkYResetea();
            }
        };
        this.listaHuespedChild.addListener(listenerChild);
        
        listenerBebe=new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                VinculadorModeloATabla.vinculaAListaTabla(HuespedBebesLista, listaTablaHuespedBebes, new TablaHuesped(), cambio);
                VinculadorModeloATabla.vinculaVariasAUna(HuespedBebesLista, cambio, TodosLosHuespedesLista);
                enciendoAdds(HuespedBebesLista, maxHuespedBebes, botonAddBebes);
                habilitadoBotonesOkYResetea();
            }
        };
        this.listaHuespedBebes.addListener(listenerBebe);
        
        listenerOtros=new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedOtros, listaTablaHuespedOtros, new TablaHuesped(), cambio);
                VinculadorModeloATabla.vinculaVariasAUna(HuespedOtrosLista, cambio, TodosLosHuespedesLista);
                enciendoAdds(HuespedOtrosLista, maxHuespedOtros, botonAddOtros);
                habilitadoBotonesOkYResetea();
            }
        };
        this.listaHuespedOtros.addListener(listenerOtros);
        
        listenerResponsable=new ListChangeListener<Persona>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Persona> cambio) {
                VinculadorModeloATabla.vinculaAListaTabla(listaHuespedResponsable, listaTablaHuespedResponsable, new TablaHuesped(), cambio);
                VinculadorModeloATabla.vinculaVariasAUna(HuespedResponsableLista, cambio, TodosLosHuespedesLista);
                enciendoAdds(HuespedResponsableLista, maxHuespedResponsables, botonAddResponsable);
                habilitadoBotonesOkYResetea();
            }
        };
        this.listaHuespedResponsable.addListener(listenerResponsable);
        //----------------------------------------------------------------------------------------
        if (HuespedResponsableLista.isEmpty()) {
            botonBorrarResponsable.setDisable(true);
            reseteaCampos.setDisable(true);
            botonOk.setDisable(true);
        } else {
            botonBorrarResponsable.setDisable(false);
            reseteaCampos.setDisable(false);
            botonOk.setDisable(false);
        }
        if (HuespedOtrosLista.isEmpty()) {
            botonBorrarOtros.setDisable(true);
        } else {
            botonBorrarOtros.setDisable(false);
        }
        if (HuespedChildLista.isEmpty()) {
            botonBorrarChild.setDisable(true);
        } else {
            botonBorrarChild.setDisable(false);
        }
        if (HuespedBebesLista.isEmpty()) {
            botonBorrarBebes.setDisable(true);
        } else {
            botonBorrarBebes.setDisable(false);
        }
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
        listaHuespedBebes.clear();
        listaHuespedChild.clear();
        listaHuespedOtros.clear();
        listaHuespedResponsable.clear();
    }

    private void habilitadoBotonesOkYResetea() {
        if (listaTodosLosHuespedes.isEmpty()) {
            reseteaCampos.setDisable(true);
        } else {
            reseteaCampos.setDisable(false);
        }
        if (listaHuespedResponsable.isEmpty()) {
            botonOk.setDisable(true);
        } else {
            botonOk.setDisable(false);
        }
    }
}
