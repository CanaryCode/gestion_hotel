package gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.transacciones;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Checkin {

    public static boolean realizaCheckin(Alojamiento alojamiento,
            Habitacion habitacion, ObservableList<Huesped> huespedes) {

        for (Alojamiento a : PruebasModelo.getListaDeAlojamientos()) {
            if (a.equals(alojamiento)) {
                PruebasModelo.getListaDeAlojamientos().remove(a);
                for (Huesped huesped : huespedes) {
                    huesped.setDentro(true);
                }
                break;
            }
            habitacion.setEstado(Registro.ListaEstadoHabitacion.get(1));
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Consulta realizada con exito", ButtonType.OK);
        alert.show();
        return true;
    }
}
