package gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.vistas.ControladorTelefonoBuscador;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class UtilBuscador {

    public static void accionBorrar() {

    }

    public static void accionCrear(ObjetoVentana obj) {
        if (obj != null) {
            ((FormularioInterface) obj.getfXMLLoader().getController()).setModo(Ventanas.MODO_FORMULARIO_INSERTAR);
            obj.ver();
        }
    }

    public static <T> void accionActualizar(ObjetoVentana obj, T objetoEnVista) {
        
        if (obj != null) {
            ((FormularioInterface) obj.getfXMLLoader().getController()).
                    setModo(Ventanas.MODO_FORMULARIO_ACTUALIZAR).
                    setObjetoEnVista(objetoEnVista);
            obj.ver();
        }
    }

    public static <T> T onMouseClickedOnTable(TableView tabla, MouseEvent event,
            ObjetoVentana obj, T objetoEnVista,ObservableList<T> listaObjeto,
            Node... nodosHabilitados) {
        
        T Objeto = null;
        if (tabla.getSelectionModel().getSelectedItem() != null) {
            for (Node nodo : nodosHabilitados) {
                nodo.setDisable(false);
            }
            Objeto = listaObjeto.get(tabla.getSelectionModel().getSelectedIndex());

            double headerHeight = tabla.lookup(".column-header-background").getBoundsInLocal().getHeight();
            if (event.getClickCount() >= 2 && headerHeight <= event.getY()) {
                VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null);
                if (obj != null) {
                    ((FormularioInterface) obj.getfXMLLoader().getController()).
                            setModo(Ventanas.MODO_FORMULARIO_LECTURA).
                            setObjetoEnVista(objetoEnVista);
                    obj.ver();
                }
            }
        }
        return Objeto;
    }

    public static void ResetearCampos(Pane panelPrincipal) {
        RecorredorPaneles.reseteaControles(panelPrincipal);
    }

    public static <T> T accionOnSelectedTable(ObservableList<T> listaObjeto, TableView tabla, Node... nodosHabilitados) {
        for (Node nodo : nodosHabilitados) {
            nodo.setDisable(false);
        }
        T Objeto = listaObjeto.get(tabla.getSelectionModel().getSelectedIndex());
        return Objeto;
    }

    public static <T> void accionSeleccionar(ObservableList<T> listaObjeto, T objetoEnVista, String NombreVentana) {
        listaObjeto.add(objetoEnVista);
        Ventanas.cerrarVentana(NombreVentana);
    }

    public static <T> void accionBuscar() {

    }

    public static <T> void abrirTelefono(ObjetoVentana obj, ObservableList<TelefonoPersona> listaAddTelefono, ObservableList<TelefonoPersona> listaAddFiltro, int modo) {
        if (obj != null) {
            ((ControladorTelefonoBuscador) obj.getfXMLLoader().getController()).
                    setListaToAdd(listaAddTelefono).
                    setFiltro(listaAddFiltro).
                    setModo(modo);
            obj.ver();
        }
    }

    public static void CambiaTab(Tab viejoTab) {
        RecorredorPaneles.reseteaControles((Pane) viejoTab.getContent());
    }

    /**
     *
     *
     * @param toogle toggleButton que se va a apagar
     * @param nodo nodo que se asocia al toggle para apagarlo
     * @param panelPrincipal panel desde el cual se empieza a escanear
     * @param listaNodosApagables nodos que se apagarán si no hay ningun toggle
     * encendido
     */
    public static void apagaToggle(ToggleButton toogle, Node nodo, Pane panelPrincipal, ObservableList<Node> listaNodosApagables) {
        //Si el toggle está encendido.
        if (toogle.isSelected()) {
            //Si el nodo asociado al toggle es un RadioButton
            if (nodo instanceof RadioButton) {
                //recorre los grupos de botones del RadioButton
                ((RadioButton) nodo).getToggleGroup().getToggles().forEach((t) -> {
                    //Habilita el RadioButton que esté en ese momento iterando
                    ((RadioButton) t).setDisable(false);
                }); //Si el nodo asociado al toggle no es un RadioButton
            } else {
                //apaga habilita el nodo que es un toggle
                nodo.setDisable(false);
            }
            //recorre todos los nodos apagables
            listaNodosApagables.forEach((nod) -> {
                //habilita todos los nodos apagables
                nod.setDisable(false);
            }); //si el toggle está apagado
        } else {
            //desahabilita el nodo
            nodo.setDisable(true);
            if (nodo instanceof TextInputControl) {
                ((TextInputControl) nodo).setText("");
            } else if (nodo instanceof DatePicker) {
                ((DatePicker) nodo).setValue(null);
            } else if (nodo instanceof ComboBox) {
                ((ComboBox) nodo).getSelectionModel().selectFirst();
            } else if (nodo instanceof RadioButton) {
                ((RadioButton) nodo).getToggleGroup().selectToggle(((RadioButton) nodo).getToggleGroup().getToggles().get(0));
                ((RadioButton) nodo).getToggleGroup().getToggles().forEach((t) -> {
                    ((RadioButton) t).setDisable(true);
                });
            }

            List<ToggleButton> listaToggle = RecorredorPaneles.getListaObjetos(panelPrincipal, FXCollections.observableArrayList());
            boolean hayToggleOn = false;
            for (ToggleButton toggleButton : listaToggle) {
                if (toggleButton.isSelected()) {
                    hayToggleOn = true;
                    break;
                }
            }
            if (hayToggleOn) {
                listaNodosApagables.forEach((n) -> {
                    n.setDisable(false);
                });
            } else {
                listaNodosApagables.forEach((n) -> {
                    n.setDisable(true);
                });
            }
        }
    }

    public static <T> void iniciaComboBox(ComboBox combo, ObservableList<T> lista) {
        combo.setItems(lista);
        combo.getSelectionModel().selectFirst();
    }
}
