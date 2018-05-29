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
public class TablaPrevision {

    String numeroReserva, cliente, tipo, habitacion, nombreAgencia;
    LocalDate fechaPrevistaEntrada, fechaPrevistaSalida;

    public static ObservableList<TablaPrevision> modeloCheckin(List<DetallesReserva> listaDetallesReserva) {
        ObservableList<TablaPrevision> listaCheckIn = FXCollections.observableArrayList();
        if (!listaDetallesReserva.isEmpty()) {
            for (DetallesReserva detallesReserva : listaDetallesReserva) {
                String numeroReserva = "";
                String nombrecliente = "";
                String habitacion = "";
                String nombreAgencia= "";
                LocalDate fechaPrevistaEntrada = null;
                LocalDate fechaPrevistaSalida = null;
                String tipo = "";
                numeroReserva = detallesReserva.getReserva().getNumero();
                Persona cliente = detallesReserva.getReserva().getPersonaByCodCliente();
                Persona agencia = detallesReserva.getReserva().getPersonaByAgencia();
                
                if (cliente != null) {
                    String nombre = "";
                    String primerApellido = "";
                    String segundoApellido = "";
                    if (cliente.getNombre() != null) {
                        nombre = cliente.getNombre();
                    }
                    if (agencia.getJurNombreComercial() != null) {
                        nombreAgencia = agencia.getJurNombreComercial();
                    }
                    if (cliente.getFisPrimerApellido() != null) {
                        primerApellido = cliente.getFisPrimerApellido();
                    }
                    if (cliente.getFisSegundoApellido() != null) {
                        segundoApellido = cliente.getFisSegundoApellido();
                    }
                    nombrecliente = nombre + " " + primerApellido + " " + segundoApellido;
                }
                habitacion = detallesReserva.getPreferenciaHabitacion();
                fechaPrevistaEntrada = detallesReserva.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                fechaPrevistaSalida = detallesReserva.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                tipo = detallesReserva.getPreferenciaTipoHabitacion();
                TablaPrevision c = new TablaPrevision(nombreAgencia,numeroReserva, nombrecliente, habitacion, tipo, fechaPrevistaEntrada, fechaPrevistaSalida);
                listaCheckIn.add(c);
            }
        }
        return listaCheckIn;
    }

    public TablaPrevision(String nombreAgencia, String numeroReserva, String cliente, String habitacion, String tipo, LocalDate fechaPrevistaEntrada, LocalDate fechaPrevistaSalida) {
        this.nombreAgencia = nombreAgencia;
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.tipo = tipo;
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
        this.fechaPrevistaSalida = fechaPrevistaSalida;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
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

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
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
}
