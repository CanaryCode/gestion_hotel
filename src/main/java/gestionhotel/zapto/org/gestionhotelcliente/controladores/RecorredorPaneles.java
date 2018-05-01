package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class RecorredorPaneles {

    public static List<ToggleButton> recorrePanelesToggle(Object pane, List<ToggleButton> list) {
        List<Object> lista = FXCollections.observableArrayList();
        for (Object object : lista) {
            if (object instanceof Pane) {
                List listaAnidada = recorrePanelesToggle((Pane) object, list);
                lista.addAll(lista);
            } else if (pane instanceof SplitPane) {
                SplitPane splitPane = ((SplitPane) pane);
                lista.addAll(splitPane.getItems());
        }else if (object instanceof ToggleButton) {
                list.add((ToggleButton) object);
            }
    }
    return list ;
}
}
