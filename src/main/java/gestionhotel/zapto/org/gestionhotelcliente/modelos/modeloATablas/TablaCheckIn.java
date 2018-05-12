package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaCheckIn {

    String numeroReserva, cliente, tipo;
    int habitacion;
    LocalDate fechaPrevistaEntrada, fechaPrevistaSalida;

    public TablaCheckIn(String numeroReserva, String cliente, int habitacion, String tipo, LocalDate fechaPrevistaEntrada, LocalDate fechaPrevistaSalida) {
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.tipo = tipo;
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
        this.fechaPrevistaSalida = fechaPrevistaSalida;
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

    public LocalDate getFechaPrevistaEntrada() {
        return fechaPrevistaEntrada;
    }

    public void setFechaPrevistaEntrada(LocalDate fechaPrevistaEntrada) {
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
    }

    public LocalDate getFechaPrevistaSalida() {
        return fechaPrevistaSalida;
    }

    public void setFechaPrevistaSalida(LocalDate fechaPrevistaSalida) {
        this.fechaPrevistaSalida = fechaPrevistaSalida;
    }

    public static ObservableList<TablaCheckIn> modeloCheckin(List<DetallesReserva> listaDetallesReserva) {
        ObservableList<TablaCheckIn> listaCheckIn = FXCollections.observableArrayList();
        if (!listaDetallesReserva.isEmpty()) {
            for (DetallesReserva detallesReserva : listaDetallesReserva) {
                String numeroReserva = "";
                String cliente = "";
                int habitacion = 0;
                LocalDate fechaPrevistaEntrada = null;
                LocalDate fechaPrevistaSalida = null;
                String tipo = "";
                numeroReserva = detallesReserva.getReserva().getNumero();
                Persona persona = detallesReserva.getReserva().getPersonaByCodCliente();
                if (persona != null) {
                    String nombre = "";
                    String primerApellido = "";
                    String segundoApellido = "";
                    if (persona.getNombre() != null) {
                        nombre = persona.getNombre();
                    }
                    if (persona.getFisPrimerApellido() != null) {
                        primerApellido = persona.getFisPrimerApellido();
                    }
                    if (persona.getFisSegundoApellido() != null) {
                        segundoApellido = persona.getFisSegundoApellido();
                    }
                    cliente = nombre + " " + primerApellido + " " + segundoApellido;
                }
                habitacion = detallesReserva.getHabitacion().getNumero();
                fechaPrevistaEntrada = detallesReserva.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                fechaPrevistaSalida = detallesReserva.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                tipo = detallesReserva.getHabitacion().getTipo();
                TablaCheckIn c = new TablaCheckIn(numeroReserva, cliente, habitacion, tipo, fechaPrevistaEntrada, fechaPrevistaSalida);
                listaCheckIn.add(c);
            }
        }
        return listaCheckIn;
    }
}
