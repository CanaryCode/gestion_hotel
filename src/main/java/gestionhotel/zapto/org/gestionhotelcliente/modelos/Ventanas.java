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
    public static final String RESERVA_FORMULARIO = "reservaformulario", CLIENTE_BUSCADOR = "clienteBuscador", LOGIN = "logIn",
            HUESPED_FORMULARIO = "huespedFormulario", HUESPED_BUSCADOR = "huespedBuscador", PREVISION=  "prevision",
            CLIENTE_FORMULARIO = "clienteFormulario", HUESPED_RESERVA = "huespedReserva", PRINCIPAL = "principal",
            QUIENES_SOMOS = "quienesSomos", CALCULADORA = "calculadora",TELEFONO_BUSCADOR="telefonoBuscador",
            TELEFONO_FORMULARIO="telefonoFormulario",LISTA_VACIA="listaVacia",CHECK_IN="checkIn",
            ALOJAMIENTO_FORMULARIO="alojamiento",HABITACION_FORMULARIO="habitacionFormulario",
            HABITACION_BUSCADOR="habitacionBuscador",PERSONA_BUSCADOR="personaBuscador",PERSONA_FORMULARIO="personaFormulario";
    
    /**
     * modos en los que se puede abrir una ventana se modifica en el controlador de la misma.
     */
    public static final int MODO_FORMULARIO_INSERTAR=1,MODO_FORMULARIO_ACTUALIZAR=2,MODO_FORMULARIO_LECTURA=3,
            MODO_BUSCADOR_SELECCIONAR=4,MODO_BUSCADOR_ACTUALIZAR=5;
    /**
     * modos en los que se puede abrir una ventana se modifica en el controlador de la misma.
     */
    public static final int DESVANECIBLE=1, NO_DESVANECIBLE=0;

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
