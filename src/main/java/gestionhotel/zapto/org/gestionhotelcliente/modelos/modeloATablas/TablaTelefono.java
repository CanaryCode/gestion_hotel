package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import java.util.List;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaTelefono {

    private String numero, nombre, comentario, tipo;

    public TablaTelefono(String numero, String nombre, String comentario, String tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.comentario = comentario;
        this.tipo = tipo;
    }

    public static ObservableList<TablaTelefono> getTablaTelefono(List<TelefonoPersona> listaTelefono) {
        ObservableList<TablaTelefono> Telefonos = FXCollections.observableArrayList();
        if (listaTelefono!=null||!listaTelefono.isEmpty()) {
            for (TelefonoPersona telefonoPersona : listaTelefono) {
                String comentario = telefonoPersona.getDescripcion();
                String nombre = "un nombre de prueba";
                String tipo = "un tipo de prueba";
                String numero = "un nombre de prueba";
                TablaTelefono tablaTelefono = new TablaTelefono(numero, nombre, comentario, tipo);
                Telefonos.add(tablaTelefono);
            }
        }
        return Telefonos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
