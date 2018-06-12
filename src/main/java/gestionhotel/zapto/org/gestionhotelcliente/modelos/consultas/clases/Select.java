package gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.Conexiones;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Trabajador;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Select {

    /**
     * consulta de todos los detalles de reserva.
     */
    public static final String TODOS_LOS_DETALLES_RESERVA = "SELECT detalles_reserva.* FROM detalles_reserva";
    /**
     * selecciona todas las personas de la base de datos, tanto juridicas como
     * físcas
     */
    public static final String TODAS_LAS_PERSONAS = "SELECT persona.* FROM persona";

    /**
     *
     * @param <T> tipo de clase de la cual se quiere obtener la lista
     * @param query Query de SQL en crudo la cual se quiere ejecutar.
     * @param clase tipo de clase de la cual se quiere obtener la lista
     * @return lista de la clase sobre la cual se haya hecho la query
     */
    public static <T> List<T> realizaSQLQuery(String query, Class<T> clase) {
        //se crea una nueva lista de la clase que se especifica por parámetro
        List<T> lista = null;
        try {
            //se abre la session.
            Conexiones.abrir();
            //se obtiene la session que se ha abierto
            Session s = Conexiones.getSession();
            //se comienza la transacción.
            Transaction tx = s.beginTransaction();
            //se crea una Query con la consulta pasada por parámetro
            //y se especifica que sobre de que tipo de dato será
            SQLQuery q = s.createSQLQuery(query).addEntity(clase);
            //se ejecuta la consulta
            tx.commit();
            //se guarda el resultado de la consulta por parámetro
            lista = q.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //si la session está abierta, cierra la session
            if (Conexiones.getSession().isOpen()) {
                //se cierra la session
                Conexiones.getSession().close();
            }
            //finalmente, devuelve la lista, ya sea como un objeto null o
            //una lista con algo dentro.
            return lista;
        }
    }

    public static ObservableList<TelefonoPersona> getListaFiltroTelefono(Persona personaEnVista) {
        ObservableList<TelefonoPersona> lista = FXCollections.observableArrayList();
        for (TelefonoPersona t : PruebasModelo.getListaDeTelefonoPersona()) {
            if (t.getPersona().getId() == personaEnVista.getId()) {
                lista.add(t);
            }
        }

        return lista;
    }

    public static Trabajador isUserAndPasswordRight(String usuario, String password) {
        Trabajador user = null;
        for (Trabajador t : PruebasModelo.getListaDeTrabajadores()) {
            if (t.getUsuario() != null || t.getPassword() != null) {
                if (t.getUsuario().equals(usuario) && t.getPassword().equals(password)) {
                    user = t;
                    break;
                }
            }
        }
        return user;
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

    public static ObservableList<Alojamiento> getAlojamientosPendientesCheckIn() {
        return PruebasModelo.getListaDeAlojamientos();
    }

    public static boolean realizaCheckin(Alojamiento alojamiento,
            Habitacion habitacion, ObservableList<Huesped> huespedes) {

        for (Alojamiento a : PruebasModelo.getListaDeAlojamientos()) {
            if (a.equals(alojamiento)) {
                PruebasModelo.getListaDeAlojamientos().remove(a);
                for (Huesped huesped : huespedes) {
                    huesped.setDentro(true);
                }

                habitacion.setEstado(Registro.ListaEstadoHabitacion.get(1));
                PruebasModelo.getListaDeHabitaciones().remove(habitacion);

                break;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Consulta realizada con exito", ButtonType.OK);
        alert.show();
        return true;
    }

    public static ObservableList<Huesped> getHuespedesFuera() {
        ObservableList<Huesped> lista = FXCollections.observableArrayList();

        for (Huesped huesped : PruebasModelo.getListaDeHuespedes()) {
            if (!huesped.isDentro()) {
                lista.add(huesped);
            }
        }
        return lista;
    }

    public static ObservableList<Habitacion> getHabitacionesDesOcupadas() {
        ObservableList<Habitacion> lista = FXCollections.observableArrayList();
        ObservableList<Habitacion> listaTodas = PruebasModelo.getListaDeHabitaciones();
        for (Habitacion hab : listaTodas) {
            if (hab.getEstado().equals(Registro.ListaEstadoHabitacion.get(2))) {
                lista.add(hab);
            }
        }
        return lista;
    }

    public static ObservableList<Habitacion> getHabitacionesOcupadas() {
        ObservableList<Habitacion> lista = FXCollections.observableArrayList();
        ObservableList<Habitacion> listaTodas = PruebasModelo.getListaDeHabitaciones();
        for (Habitacion hab : listaTodas) {
            if (hab.getEstado().equals(Registro.ListaEstadoHabitacion.get(1))) {
                lista.add(hab);
            }
        }
        return lista;
    }
}
