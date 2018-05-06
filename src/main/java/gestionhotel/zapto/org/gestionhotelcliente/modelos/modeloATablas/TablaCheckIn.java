package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaCheckIn {

    String numeroReserva, cliente, tipo;
    int habitacion;
    Date fechaPrevistaEntrada;

    public TablaCheckIn(String numeroReserva, String cliente, int habitacion, String tipo, Date fechaPrevistaEntrada) {
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.tipo = tipo;
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaPrevistaEntrada() {
        return fechaPrevistaEntrada;
    }

    public void setFechaPrevistaEntrada(Date fechaPrevistaEntrada) {
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
    }

    public static ObservableList<TablaCheckIn> modeloCheckin(List<DetallesReserva> listaDetallesReserva) {
        ObservableList<TablaCheckIn> listaCheckIn = FXCollections.observableArrayList();
            String numeroReserva = "nombre de prueba";
        String cliente = "";
        int habitacion = 0;
        Date fechaPrevistaEntrada = new Date();
        String tipo = "";

        for (DetallesReserva detallesReserva : listaDetallesReserva) {
            Reserva reserva = detallesReserva.getReserva();
            if (listaDetallesReserva.get(0) != detallesReserva) {
//                numeroReserva = detallesReserva.getReserva().getNumero();
//                Persona persona = detallesReserva.getReserva().getPersonaByCodCliente();
//                if (persona != null) {
//                    String nombre = "";
//                    String primerApellido = "";
//                    String segundoApellido = "";
//                    if (persona.getNombre() != null) {
//                        nombre = persona.getNombre();
//                    }
//                    if (persona.getFisPrimerApellido() != null) {
//                        primerApellido = persona.getFisPrimerApellido();
//                    }
//                    if (persona.getFisSegundoApellido() != null) {
//                        segundoApellido = persona.getFisSegundoApellido();
//                    }
//                    cliente = nombre + " " + primerApellido + " " + segundoApellido;
//                }
//                habitacion = detallesReserva.getHabitacion().getNumero();
//                fechaPrevistaEntrada = detallesReserva.getFechaEntradaPrevista();
//                tipo = detallesReserva.getHabitacion().getTipo();
            }
        }
        TablaCheckIn c = new TablaCheckIn(numeroReserva, cliente, habitacion, tipo, fechaPrevistaEntrada);
        listaCheckIn.add(c);
        return listaCheckIn;
    }
}
