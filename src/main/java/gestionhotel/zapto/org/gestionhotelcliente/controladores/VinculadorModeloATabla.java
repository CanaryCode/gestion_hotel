package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaInterface;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class VinculadorModeloATabla {

    public static <T, P extends TablaInterface> void vinculaAListaTabla(ObservableList<T> lista,
            ObservableList<P> listaTabla, P objetoTabla, ListChangeListener.Change<? extends T> cambio) {
       
        cambio.next();
        listaTabla.clear();
        listaTabla.addAll(objetoTabla.getListaObjetosDeTabla(lista));
    }

    public static <T, P extends TablaInterface> void vinculaVariasAUna(ObservableList<T> lista,
            ListChangeListener.Change<? extends T> cambio, ObservableList<T> listasVinculada) {
        if (!listasVinculada.contains(cambio.next())) {
            if (cambio.wasAdded()) {
                listasVinculada.add(cambio.getAddedSubList().get(cambio.getAddedSubList().size() - 1));
            } else if (cambio.wasRemoved()) {
                listasVinculada.removeAll(cambio.getRemoved());
            }
        }
    }
}
