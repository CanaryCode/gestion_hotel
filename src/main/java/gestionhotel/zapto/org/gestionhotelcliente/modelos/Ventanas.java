package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Ventanas {
//todas de las ventanas de la app

    private static ObservableList<VentanaCustom> listaVentanas = FXCollections.observableArrayList();

    /**
     *
     * @return lista de ventanas activas
     */
    public static ObservableList<VentanaCustom> getListaVentanas() {
        return listaVentanas;
    }

    /**
     *
     * @param vc Stage modificado
     * @return lista de ventanas activas
     */
    public static ObservableList<VentanaCustom> addVentana(VentanaCustom vc) {
        listaVentanas.add(vc);
        return listaVentanas;
    }

    /**
     *
     * @param nombreVentana nombre que tiene la ventana que se desea eliminar
     * @return lista de ventanas activas
     */
    public static void removeVentana(String nombreVentana) {
            for (VentanaCustom Vent : listaVentanas) {
                if (Vent.getMiNombre().equals(nombreVentana)) {
                    listaVentanas.remove(Vent);
                    break;
                }
            }
    }

    public static VentanaCustom getVentana(String nombre) {
        VentanaCustom ventanaCustom = null;
        for (VentanaCustom Vent : listaVentanas) {
            if (Vent.getMiNombre().equals(nombre)) {
                ventanaCustom = Vent;
                break;
            }
        }
        return ventanaCustom;
    }

}
