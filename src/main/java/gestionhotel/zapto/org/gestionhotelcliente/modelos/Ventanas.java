package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Aquí es donde se guardan todos la lista de las ventanas activas. Y los
 * nombres que tienen todas las ventanas de la aplicación.
 *
 * @author Antonio Jesús Pérez Delgado
 */
public class Ventanas {

    /**
     * todas de las ventanas de la app
     */
    public static final String RESERVA = "Reserva", CLIENTE_BUSCADOR = "ClienteBuscador", LOGIN = "LogIn",
            HUESPED = "Huesped", HUESPED_BUSCADOR = "HuespedBuscador", RESERVA_CHECKIN = "ReservaCheckIn",
            CLIENTE = "Cliente", HUESPED_RESERVA = "HuespedReserva", PRINCIPAL = "Principal",
            QUIENES_SOMOS = "QuienesSomos", CALCULADORA = "Calculadora";

    /**
     * lista de ventanas activas
     */
    private static ObservableList<VentanaCustom> listaVentanas = FXCollections.observableArrayList();

    /**
     * devuelve la variable estatica.
     *
     * @return lista de ventanas activas
     */
    public static ObservableList<VentanaCustom> getListaVentanas() {
        return listaVentanas;
    }

    /**
     * @param vc ventana que se desea añadir a la lista de ventanas activas.
     *
     * @return lista de ventanas activas
     */
    public static ObservableList<VentanaCustom> addVentana(VentanaCustom vc) {
        listaVentanas.add(vc);
        return listaVentanas;
    }

    /**
     * busca en la lista de ventanas si hay un "match" con el nombre que se pasa
     * por parámetro y si es así, elimina la ventana en cuestión.
     *
     * @param nombreVentana nombre que tiene la ventana que se desea eliminar
     */
    public static void removeVentana(String nombreVentana) {
        for (VentanaCustom Vent : listaVentanas) {
            if (Vent.getMiNombre().equals(nombreVentana)) {
                listaVentanas.remove(Vent);
                break;
            }
        }
    }

    /**
     * busca en la lista de ventanas si hay un "match" con el nombre que se pasa
     * por parámetro y si es así, devuelve la ventana en cuestión.
     *
     * @param nombre nombre que tiene la ventana que se desea buscar
     * @return ventana activa con el nombre pasado por parametro si la hubiera.
     */
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

    public static void cerrarVentana(String ventana) {
        VentanaCustom vc = Ventanas.getVentana(ventana);
        vc.close();
        Ventanas.removeVentana(ventana);
        vc = null;
    }
}
