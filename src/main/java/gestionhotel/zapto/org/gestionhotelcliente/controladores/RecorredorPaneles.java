package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class RecorredorPaneles {

    public static List<ToggleButton> recorrePanelesToggle(Pane pane, List<ToggleButton> list) {
        List lista = pane.getChildren();
        for (Object object : lista) {
            if (object instanceof Pane) {
                recorrePanelesToggle((Pane) object, list);
            } else if (object instanceof Tab) {
                recorrePanelesToggle((Pane) object, list);
            } else if (object instanceof ToggleButton) {
                list.add((ToggleButton) object);
            }
        }
        return list;
    }
}
