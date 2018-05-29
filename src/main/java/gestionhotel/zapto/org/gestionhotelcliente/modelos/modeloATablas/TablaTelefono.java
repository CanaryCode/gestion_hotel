package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersonaId;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas.PruebasModelo;
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
        if (listaTelefono != null || !listaTelefono.isEmpty()) {
            for (TelefonoPersona telefonoPersona : listaTelefono) {
                Persona p = telefonoPersona.getPersona();
                if (p != null) {
                    
                    String comentario = telefonoPersona.getComentario();
                    String nombre = telefonoPersona.getPersona().getNombre()+" "+
                            telefonoPersona.getPersona().getFisPrimerApellido()+" "+
                            telefonoPersona.getPersona().getFisSegundoApellido();
                    String tipo = telefonoPersona.getTipo();
                    String numero = telefonoPersona.getId().getNumTelefono();
                    TablaTelefono tablaTelefono = new TablaTelefono(numero, nombre, comentario, tipo);
                    Telefonos.add(tablaTelefono);
                }
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
