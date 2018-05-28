package gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.RecorredorPaneles;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Ventanas;
import java.time.ZoneId;
import java.util.Date;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.Pane;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class UtilFormularios {

    public static void accionAceptar() {

    }

    public static void CambiaTab(Tab viejoTab) {
        RecorredorPaneles.reseteaControles((Pane) viejoTab.getContent());
    }

    public static void reseteaCampos(Pane panelPrincipal) {
        RecorredorPaneles.reseteaControles(panelPrincipal);
    }

    public static void ValidarNodo(Node nodo, Object input) {
        if (nodo instanceof TextInputControl) {
            if (input != null) {
                ((TextInputControl) nodo).setText(((String) input));
            }
        } else if (nodo instanceof ComboBox) {
            for (Object combo : ((ComboBox) nodo).getItems()) {
                if (((String) combo).equals(((String) input))) {
                    ((ComboBox) nodo).getSelectionModel().select(combo);
                    break;
                }
            }
        } else if (nodo instanceof RadioButton) {
            if (input != null) {
                if (((Byte) input).equals(0)) {
                    ((RadioButton) nodo).getToggleGroup().selectToggle(((RadioButton) nodo).getToggleGroup().getToggles().get(0));
                } else {
                    ((RadioButton) nodo).getToggleGroup().getToggles().get(1);
                }
            }
        } else if (nodo instanceof DatePicker) {
            if (input != null) {
                ((DatePicker) nodo).setValue(new Date(((Date) input).getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

            }
        } else if (nodo instanceof TabPane) {
            if (input != null) {
                if (((Byte) input).byteValue()==0) {
                    ((TabPane) nodo).getSelectionModel().select(((TabPane) nodo).getTabs().get(0));
                    ((TabPane) nodo).getTabs().get(1).setDisable(true);
                } else {
                    ((TabPane) nodo).getSelectionModel().select(((TabPane) nodo).getTabs().get(1));
                    ((TabPane) nodo).getTabs().get(0).setDisable(true);
                }
            }
        }
    }

    public static void configurarModo(int modoFormulario, Button aceptar, Button reseteaCampos,
            Pane principal) {

        if (modoFormulario == Ventanas.MODO_FORMULARIO_ACTUALIZAR) {
            aceptar.setOnAction((event) -> {
                //entonces cuando termines, de  hacerlo cierra la ventana.
                Ventanas.cerrarVentana(Ventanas.CLIENTE_FORMULARIO);
                //si se está insertando a una persona
            });
            reseteaCampos.setDisable(true);

        } else if (modoFormulario == Ventanas.MODO_FORMULARIO_INSERTAR) {
            aceptar.setOnAction((event) -> {
                //entonces resetea todos los campos.
                reseteaCampos(principal);
            });

        } else if (modoFormulario == Ventanas.MODO_FORMULARIO_LECTURA) {
           RecorredorPaneles.DesahilitaNodes(principal);
        }
    }
      public static <T> void iniciaComboBox(ComboBox combo, ObservableList<T> lista) {
        combo.setItems(lista);
        combo.getSelectionModel().selectFirst();
    }
    
}
