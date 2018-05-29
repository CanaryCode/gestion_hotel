package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.Conexiones;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersonaId;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
import java.util.List;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Consultas {

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
    public static ObservableList<TelefonoPersona> getListaFiltroTelefono(Persona personaEnVista){
        ObservableList<TelefonoPersona> lista=FXCollections.observableArrayList();
        for (TelefonoPersona t : PruebasModelo.getLisTelefono()) {
            if(t.getId().getCodPersona()==personaEnVista.getCodPersona()){
               lista.add(t);
            }
        }
        
        return lista;
    }
}
