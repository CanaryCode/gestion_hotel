package gestionhotel.zapto.org.gestionhotelcliente.modelos.tablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
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
public class CheckIn {

    String numeroReserva, cliente, tipo;
    int habitacion;
    Date fechaPrevistaEntrada;

    public CheckIn(String numeroReserva, String cliente, int habitacion, String tipo, Date fechaPrevistaEntrada) {
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

    public static ObservableList<CheckIn> modeloCheckin(List<Reserva> listaPersona) {
        ObservableList<CheckIn> listaCheckIn = FXCollections.observableArrayList();
        for (Reserva reserva: listaPersona) {
            String numeroReserva=reserva.getNumero();
            String nombre=(reserva.getPersonaByCodCliente().getNombre()!=null)?reserva.getPersonaByCodCliente().getNombre():"";
            String primerApellido=(reserva.getPersonaByCodCliente().getFisPrimerApellido()!=null)?reserva.getPersonaByCodCliente().getFisPrimerApellido():"";
            String SegundoApellido=(reserva.getPersonaByCodCliente().getFisSegundoApellido()!=null)?reserva.getPersonaByCodCliente().getFisSegundoApellido():"";
         
            String cliente =reserva.getPersonaByCodCliente().getNombre()+" "+
                    reserva.getPersonaByCodCliente().getFisPrimerApellido()+" "+
                    reserva.getPersonaByCodCliente().getFisSegundoApellido();
           int habitacion=0;
            Date fechaPrevistaEntrada=new Date();;
            String tipo = "";
            Set<DetallesReserva> s= reserva.getDetallesReservas();
            for (DetallesReserva detallesReserva : s) {
                habitacion=detallesReserva.getHabitacion().getNumero();
                fechaPrevistaEntrada=detallesReserva.getFechaEntradaPrevista();
                tipo=detallesReserva.getHabitacion().getTipo();
            }
            CheckIn c = new CheckIn(numeroReserva, cliente, habitacion, tipo, fechaPrevistaEntrada);
            listaCheckIn.add(c);
        }
        return listaCheckIn;
    }
}
