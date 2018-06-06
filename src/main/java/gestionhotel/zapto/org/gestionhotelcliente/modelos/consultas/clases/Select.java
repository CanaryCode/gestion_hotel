package gestionhotel.zapto.org.gestionhotelcliente.modelos.consultas.clases;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.Conexiones;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.HuespedHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Usuario;
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
        for (TelefonoPersona t : PruebasModelo.getListaDeTelefono()) {
            if (t.getId().getCodPersona() == personaEnVista.getCodPersona()) {
                lista.add(t);
            }
        }

        return lista;
    }

    public static Usuario isUserAndPasswordRight(String usuario, String password) {
        Usuario user = null;
        for (Usuario u : PruebasModelo.getListaDeUsuarios()) {
            if (u.getNombreUsuario().equals(usuario) && u.getPassUsuario().equals(password)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public static ObservableList<Persona> getHuespedesDentro() {
        return PruebasModelo.getListaDeHuespedesDentro();
    }

    public static ObservableList<DetallesReserva> getAlojamientosPendientesCheckIn() {
        return PruebasModelo.getListaDeAlojamientos();
    }

    public static boolean realizaCheckin(DetallesReserva detallesReserva,
            Habitacion habitacion, ObservableList<Persona> huespedes) {
        
        for (DetallesReserva d : PruebasModelo.getListaDeAlojamientos()) {
            if (d.equals(detallesReserva)) {
                PruebasModelo.getListaDeAlojamientos().remove(d);
                int contador = 1;
                for (Persona huesped : huespedes) {
                    HuespedHabitacion huespedHabitacion = new HuespedHabitacion();
                    huespedHabitacion.setPersona(huesped);
                    huespedHabitacion.setDetallesReserva(detallesReserva);
                    huespedHabitacion.setComentario("comentario " + contador);
                    PruebasModelo.getListaDeHuespedesDentro().add(huesped);
                    PruebasModelo.getListaDeHuespedes().remove(huesped);
                    PruebasModelo.getListaDeHuespedes().remove(huesped);
                    contador++;
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
    public static ObservableList<Persona> getHuespedesFuera(){
        ObservableList<Persona> lista=PruebasModelo.getListaDeHuespedesFuera();
        FXCollections.copy(lista, PruebasModelo.getListaDeHuespedesFuera());
        return PruebasModelo.getListaDeHuespedesFuera();
    }
    public static ObservableList<Habitacion> getHabitacionesDesOcupadas(){
        ObservableList<Habitacion> lista =FXCollections.observableArrayList();
        ObservableList<Habitacion> listaTodas =PruebasModelo.getListaDeHabitaciones();
        for (Habitacion hab : listaTodas) {
            if(hab.getEstado().equals(Registro.ListaEstadoHabitacion.get(2)))
            lista.add(hab);
        }
        return lista;
    }
    public static ObservableList<Habitacion> getHabitacionesOcupadas(){
        ObservableList<Habitacion> lista =PruebasModelo.getListaDeHabitaciones();
        ObservableList<Habitacion> listaTodas =PruebasModelo.getListaDeHabitaciones();
        for (Habitacion hab : listaTodas) {
            if(hab.getEstado().equals(Registro.ListaEstadoHabitacion.get(1)))
            lista.add(hab);
        }
        return lista;
    }
}
