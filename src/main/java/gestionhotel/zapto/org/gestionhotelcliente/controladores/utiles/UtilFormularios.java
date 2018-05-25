package gestionhotel.zapto.org.gestionhotelcliente.controladores.utiles;

import java.time.ZoneId;
import java.util.Date;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class UtilFormularios {

    public static void accionAceptar() {

    }

    public static void ValidarNodo(Node nodo, Object input) {
        if (nodo instanceof TextInputControl) {
            if (input != null) {
                ((TextInputControl) nodo).setText(((String) input));
            }
        } else if (nodo instanceof ComboBox) {
            for (Object obj : ((ComboBox) nodo).getItems()) {
                if (((String) obj).equals(input)) {
                    ((ComboBox) nodo).getSelectionModel().select(obj);
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
        } else if (input != null) {
            if (((Byte) input).equals(0)) {
                ((TabPane) nodo).getSelectionModel().select(((TabPane) nodo).getTabs().get(0));
                ((TabPane) nodo).getTabs().get(1).setDisable(true);
            } else {
                ((TabPane) nodo).getSelectionModel().select(((TabPane) nodo).getTabs().get(1));
                ((TabPane) nodo).getTabs().get(0).setDisable(true);
            }
        }
    }
}
