package gestionhotel.zapto.org.gestionhotelcliente.modelos;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.AbrirCerrarConexiones;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Consultas {

    public static String pendienteDeCheckIn = "SELECT reserva . * \n"
            + "FROM persona\n"
            + "INNER JOIN reserva ON reserva.cod_cliente = persona.cod_persona\n"
            + "INNER JOIN detalles_reserva ON detalles_reserva.cod_reserva = reserva.cod_reserva\n"
            + "WHERE detalles_reserva.fecha_entrada_prevista < NOW( ) \n"
            + "AND reserva.fecha_cancelada IS NULL \n"
            + "AND detalles_reserva.fecha_entrada IS NULL ";

    public static <T> List<T> realizaQuery(String query, Class<T> clase) {
        Session s = AbrirCerrarConexiones.getSession();
        Transaction tx=s.beginTransaction();
        SQLQuery q = s.createSQLQuery(Consultas.pendienteDeCheckIn).addEntity(clase);
        tx.commit();
        List<T> lista = q.list();
        if (lista.isEmpty()) {
            return new ArrayList<T>();
        } else {
          
            return lista;
        }
    }
}
