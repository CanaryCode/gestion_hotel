package gestionhotel.zapto.org.gestionhotelcliente.controladores;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.excepciones.ItemRepetido;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas.TablaInterface;
import javafx.collections.FXCollections;
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

}
