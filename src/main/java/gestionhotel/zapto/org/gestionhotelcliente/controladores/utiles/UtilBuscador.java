package gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.VentanasFactory;
import gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles.interfaces.FormularioInterface;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.ObjetoVentana;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
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
            ((FormularioInterface) obj.getfXMLLoader().getController()).setModo(Ventanas.MODO_INSERTAR);
            obj.ver();
        }
    }

    public static <T> void accionActualizar(ObjetoVentana obj, T objetoEnVista) {
        if (obj != null) {
            ((FormularioInterface) obj.getfXMLLoader().getController()).
                    setModo(Ventanas.MODO_ACTUALIZAR).
                    setObjetoEnVista(objetoEnVista);
            obj.ver();
        }
    }

    public static <T> void accionVer(ObjetoVentana obj, T objetoEnVista) {
        VentanasFactory.getObjetoVentanaClienteFormulario(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            ((FormularioInterface) obj.getfXMLLoader().getController()).
                    setModo(Ventanas.MODO_VER).
                    setObjetoEnVista(objetoEnVista);;
            obj.ver();
        }

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

    public static <T> void abrirTelefono() {
        ObjetoVentana obj = VentanasFactory.getObjetoVentanaTelefonoBuscador(Ventanas.CLIENTE_BUSCADOR, Modality.APPLICATION_MODAL, null);
        if (obj != null) {
            obj.ver();
        }
    }

    public static void configuraBotones(Pane panelPrincipal, ObservableList<Node> nodoosApagables) {
        List<ToggleButton> listaToggle = RecorredorPaneles.getListaObjetos(panelPrincipal, FXCollections.observableArrayList());
        boolean hayToggleOn = false;
        for (ToggleButton toggleButton : listaToggle) {
            if (toggleButton.isSelected()) {
                hayToggleOn = true;
                break;
            }
        }
        if (hayToggleOn) {
            for (Node nodo : nodoosApagables) {
                nodo.setDisable(false);
            }
        } else {
            for (Node nodo : nodoosApagables) {
                nodo.setDisable(true);
            }
        }
    }

    public static void CambiaTab(Tab viejoTab) {
        RecorredorPaneles.reseteaControles((Pane) viejoTab.getContent());
    }

    public static void apagaToggle(ToggleButton toogle, Node nodo, Pane panelPrincipal, ObservableList<Node> listaNodosApagables) {
        if (toogle.isSelected()) {
            if (nodo instanceof RadioButton) {
                for (Toggle t : ((RadioButton) nodo).getToggleGroup().getToggles()) {
                    ((RadioButton) t).setDisable(false);
                }
            } else {
                nodo.setDisable(false);
            }
            for (Node nod : listaNodosApagables) {
                nod.setDisable(false);
            }
        } else {
            nodo.setDisable(true);
            if (nodo instanceof TextInputControl) {
                ((TextInputControl) nodo).setText("");
            } else if (nodo instanceof DatePicker) {
                ((DatePicker) nodo).setValue(null);
            } else if (nodo instanceof ComboBox) {
                ((ComboBox) nodo).getSelectionModel().selectFirst();
            } else if (nodo instanceof RadioButton) {
                ((RadioButton) nodo).getToggleGroup().selectToggle(((RadioButton) nodo).getToggleGroup().getToggles().get(0));
                for (Toggle t : ((RadioButton) nodo).getToggleGroup().getToggles()) {
                    ((RadioButton) t).setDisable(true);
                }
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
                for (Node n : listaNodosApagables) {
                    nodo.setDisable(false);
                }
            } else {
                for (Node n : listaNodosApagables) {
                    nodo.setDisable(true);
                }
            }
        }
    }

    public static <T> void iniciaComboBox(ComboBox combo, ObservableList<T> lista) {
        combo.setItems(lista);
        combo.getSelectionModel().selectFirst();
    }
}
