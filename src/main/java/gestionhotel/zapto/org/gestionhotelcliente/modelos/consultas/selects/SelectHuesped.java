
package gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.selects;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class SelectHuesped {
  public static ObservableList<Huesped> getHuespedesFuera() {
        ObservableList<Huesped> lista = FXCollections.observableArrayList();
        for (Huesped huesped : PruebasModelo.getListaDeHuespedes()) {
            if (!huesped.isDentro()) {
                lista.add(huesped);
            }
        }
        return lista;
    }
   public static ObservableList<Huesped> getHuespedesDentro() {
        ObservableList<Huesped> lista = FXCollections.observableArrayList();
        for (Huesped h : PruebasModelo.getListaDeHuespedes()) {
            if(h.isDentro()){
                lista.add(h);
            }
        }
        return lista;
    }
}
