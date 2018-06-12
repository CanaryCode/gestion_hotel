package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaTelefono implements TablaInterface<TablaTelefono, TelefonoPersona >{

    private String numero, nombre, comentario, tipo;

    public TablaTelefono(String numero, String nombre, String comentario, String tipo) {
        this.numero = numero;
        this.nombre = nombre;
        this.comentario = comentario;
        this.tipo = tipo;
    }
    public TablaTelefono(){
    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Propietario", "nombre", 400));
        lista.add(new CreadorDeTabla("Número", "numero", 100));
        lista.add(new CreadorDeTabla("Tipo", "tipo", 400));
        return lista;
    }

    @Override
    public ObservableList<TablaTelefono> getListaObjetosDeTabla(ObservableList<TelefonoPersona> listaTelefono) {
        ObservableList<TablaTelefono> Telefonos = FXCollections.observableArrayList();

        if (listaTelefono != null || !listaTelefono.isEmpty()) {

            for (TelefonoPersona telefonoPersona : listaTelefono) {
                Persona p = telefonoPersona.getPersona();

                if (p != null) {
                    String comentario = telefonoPersona.getTelefono().getComentario();
                    String nombre = telefonoPersona.getPersona().getNombre() + " "
                            + telefonoPersona.getPersona().getFisPrimerApellido() + " "
                            + telefonoPersona.getPersona().getFisSegundoApellido();
                    String tipo = telefonoPersona.getTelefono().getTipo();
                    String numero = telefonoPersona.getTelefono().getNumero();
                    TablaTelefono tablaTelefono = new TablaTelefono(numero, nombre, comentario, tipo);
                    Telefonos.add(tablaTelefono);
                };
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
