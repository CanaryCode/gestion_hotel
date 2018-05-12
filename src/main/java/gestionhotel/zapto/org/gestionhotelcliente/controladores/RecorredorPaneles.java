package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import java.util.List;
import java.util.function.Consumer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class RecorredorPaneles {

    /**
     * Sirve para recorrer un panel raiz y que se vaya metiendo dentro de todos
     * los paneles anidados y cuando detecte que hay un T lo añada a la lista
     * que posteriormete devolverá.
     *
     * @param pane panel raiz desde el cual se empieza a inspeccionar
     * @param lista una lista que preferiblemente sea nueva se utiliza para que
     * funcione la recursividad en las anidaciones posteriores.
     * @return
     */
    public static <T> List<T> getListaObjetos(Pane pane, List<T> lista) {
        //recorre todos hijos del panel principal
        pane.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node object) {
                //si un hijo es un panel
                if (object instanceof Pane) {
                    //haz recursividad y como segundo parámetro te paso la lista
                    //por parámetro que se introdujo en la primera invocación.
                    //es ahí donde vas a ir acumulando.
                    getListaObjetos((Pane) object, lista);
                    //si lo que me encuentro es un ToogleButton que no es un RadioButton
                } else if (object instanceof ToggleButton && object instanceof RadioButton == false) {
                    //añadelo a lista.
                    lista.add((T) object);
                    //si lo que me encuentro es un SplitPane
                } else if (object instanceof SplitPane) {
                    //utiliza el método de dar lista de hijos inmodificables para 
                    //obtener una lista de todos sus nodos.
                    ObservableList<Node> listaNodos = ((SplitPane) object).getChildrenUnmodifiable();
                    //recorre la lista de todos sus nodos y si un nodo es instancia de Pane utiliza la recursividad
                    //acumulando en la lista pasada por parámetro en la primera invocación.
                    listaNodos.stream().filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        getListaObjetos((Pane) nodo, lista);
                    });
                    //si es una instancia de TabPane
                } else if (object instanceof TabPane) {
                    //utiliza el metodoGetTabs para obtener todas las pestañas
                    ObservableList<Tab> listaTabs = ((TabPane) object).getTabs();
                    //con la lista de pestañas por cada una utiliza el método getContent
                    //y este devuelve una pestaña que examina si es instancia de Pane y si lo es
                    //utiliza la recursividad acumulando en la lista pasada por parámetro en la primera
                    //invocación
                    listaTabs.stream().map((tab) -> tab.getContent()).filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        getListaObjetos((Pane) nodo, lista);
                    });
                }
            }
        });
        //devuelve la lista donde se fue acumulando todo.
        return lista;
    }

    /**
     * Se utiliza para recorrer todos los controles de un Panel pasado por
     * parámetro y sus correspondientes subniveles anidados hasta recorrer todos
     * los controles que hay dentro y restaurar los valores iniciales.
     *
     * @param pane Panel raiz desde donde se quiere empezar a inspeccionar
     */
    public static void reseteaControles(Pane pane) {
        //obten todos nodos del panel padre y por cada uno:
        pane.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node object) {
                //si es instancia de pane
                if (object instanceof Pane) {
                    //utiliza recursividad.
                    reseteaControles((Pane) object);
                    //si es instancia de SplitPane
                } else if (object instanceof SplitPane) {
                    //utiliza el método getItems() para obstener una lista de todos
                    //los nodos que tiene dentro.
                    ObservableList<Node> listaNodos = ((SplitPane) object).getItems();
                    //por cada nodo mira si es instacia de Pane y en el caso de ser
                    //así utiliza la recursividad.
                    listaNodos.stream().filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        reseteaControles((Pane) nodo);
                    });
                    //si es instancia de TabPane u
                } else if (object instanceof TabPane) {
                    //utiliza el método getTabs() para obtener las pestañas de las que está compuesta.
                    ObservableList<Tab> listaTabs = ((TabPane) object).getTabs();
                    //por cada pestaña utiliza el método getContent() para obtener los nodos
                    //y si son instancia de Pane, utiliza la recursividad.
                    listaTabs.stream().map((tab) -> tab.getContent()).filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        reseteaControles((Pane) nodo);
                    });
                    //si el objeto es un InputContol
                } else if (object instanceof TextInputControl) {
                    //borra lo que haya escrito en el
                    ((TextInputControl) object).setText("");
                    //si es un ComboBox
                } else if (object instanceof ComboBox) {
                    //haz que se seleccione el primer articulo de la lista.
                    ((ComboBox) object).getSelectionModel().selectFirst();
                    //si es un DatePicker
                } else if (object instanceof DatePicker) {
                    //haz que no haya nada seleccionado.
                    ((DatePicker) object).setValue(null);
                    //si es un radioButton
                } else if (object instanceof RadioButton) {
                    //obten el TogggleGroup y haz que se marque el primero.
                    ((RadioButton) object).getToggleGroup().getToggles().get(0).setSelected(true);
                    //si es un ToggleButton
                } else if (object instanceof ToggleButton) {
                    //haz que se deseleccione.
                    ((ToggleButton) object).setSelected(false);
                }
            }
        });
    }

    public static void setOnlyReadsInputs(Pane pane) {
        //obten todos nodos del panel padre y por cada uno:
        pane.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node object) {
                //si es instancia de pane
                if (object instanceof Pane) {
                    //utiliza recursividad.
                    setOnlyReadsInputs((Pane) object);
                    //si es instancia de SplitPane
                } else if (object instanceof SplitPane) {
                    //utiliza el método getItems() para obstener una lista de todos
                    //los nodos que tiene dentro.
                    ObservableList<Node> listaNodos = ((SplitPane) object).getItems();
                    //por cada nodo mira si es instacia de Pane y en el caso de ser
                    //así utiliza la recursividad.
                    listaNodos.stream().filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        setOnlyReadsInputs((Pane) nodo);
                    });
                    //si es instancia de TabPane u
                } else if (object instanceof TabPane) {
                    //utiliza el método getTabs() para obtener las pestañas de las que está compuesta.
                    ObservableList<Tab> listaTabs = ((TabPane) object).getTabs();
                    //por cada pestaña utiliza el método getContent() para obtener los nodos
                    //y si son instancia de Pane, utiliza la recursividad.
                    listaTabs.stream().map((tab) -> tab.getContent()).filter((nodo) -> (nodo instanceof Pane)).forEachOrdered((nodo) -> {
                        setOnlyReadsInputs((Pane) nodo);
                    });
                    //si el objeto es un InputContol
                } else if (object instanceof TextInputControl) {
                    //borra lo que haya escrito en el
                    ((TextInputControl) object).setEditable(false);
                    //si es un ComboBox
                } else if (object instanceof ComboBox) {
                    //haz que se seleccione el primer articulo de la lista.
                    ((ComboBox) object).setDisable(true);
                    ((ComboBox) object).setStyle("-fx-opacity: 1.0;");
                    //si es un DatePicker
                } else if (object instanceof DatePicker) {
                    //haz que no haya nada seleccionado.
                    ((DatePicker) object).setDisable(true);
                    ((DatePicker) object).setStyle("-fx-opacity: 1.0;");
                    //si es un radioButton
                } else if (object instanceof RadioButton) {
                    //obten el TogggleGroup y haz que se marque el primero.
                    ((RadioButton) object).setDisable(true);
                    ((RadioButton) object).setStyle("-fx-opacity: 1.0;");
                    //si es un ToggleButton
                } else if (object instanceof ToggleButton) {
                    //haz que se deseleccione.
                    ((ToggleButton) object).setDisable(true);
                    ((ToggleButton) object).setStyle("-fx-opacity: 1.0;");
                }
            }
        });
    }
}
