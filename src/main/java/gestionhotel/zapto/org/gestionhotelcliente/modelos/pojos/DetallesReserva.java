package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 06-may-2018 1:59:43 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DetallesReserva generated by hbm2java
 */
public class DetallesReserva  implements java.io.Serializable {


     private Integer idDetallesReserva;
     private Habitacion habitacion;
     private Reserva reserva;
     private String nombreReserva;
     private Integer cantidadHuespedes;
     private Date fechaEntradaPrevista;
     private Date fechaSalidaPrevista;
     private Date fechaEntrada;
     private Date fechaSalida;
     private String pension;
     private String tipoCama;
     private Set estadoHabitacions = new HashSet(0);
     private Set huespedHabitacions = new HashSet(0);

    public DetallesReserva() {
    }

    public DetallesReserva(Habitacion habitacion, Reserva reserva, String nombreReserva, Integer cantidadHuespedes, Date fechaEntradaPrevista, Date fechaSalidaPrevista, Date fechaEntrada, Date fechaSalida, String pension, String tipoCama, Set estadoHabitacions, Set huespedHabitacions) {
       this.habitacion = habitacion;
       this.reserva = reserva;
       this.nombreReserva = nombreReserva;
       this.cantidadHuespedes = cantidadHuespedes;
       this.fechaEntradaPrevista = fechaEntradaPrevista;
       this.fechaSalidaPrevista = fechaSalidaPrevista;
       this.fechaEntrada = fechaEntrada;
       this.fechaSalida = fechaSalida;
       this.pension = pension;
       this.tipoCama = tipoCama;
       this.estadoHabitacions = estadoHabitacions;
       this.huespedHabitacions = huespedHabitacions;
    }
   
    public Integer getIdDetallesReserva() {
        return this.idDetallesReserva;
    }
    
    public void setIdDetallesReserva(Integer idDetallesReserva) {
        this.idDetallesReserva = idDetallesReserva;
    }
    public Habitacion getHabitacion() {
        return this.habitacion;
    }
    
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public String getNombreReserva() {
        return this.nombreReserva;
    }
    
    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }
    public Integer getCantidadHuespedes() {
        return this.cantidadHuespedes;
    }
    
    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }
    public Date getFechaEntradaPrevista() {
        return this.fechaEntradaPrevista;
    }
    
    public void setFechaEntradaPrevista(Date fechaEntradaPrevista) {
        this.fechaEntradaPrevista = fechaEntradaPrevista;
    }
    public Date getFechaSalidaPrevista() {
        return this.fechaSalidaPrevista;
    }
    
    public void setFechaSalidaPrevista(Date fechaSalidaPrevista) {
        this.fechaSalidaPrevista = fechaSalidaPrevista;
    }
    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public Date getFechaSalida() {
        return this.fechaSalida;
    }
    
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public String getPension() {
        return this.pension;
    }
    
    public void setPension(String pension) {
        this.pension = pension;
    }
    public String getTipoCama() {
        return this.tipoCama;
    }
    
    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }
    public Set getEstadoHabitacions() {
        return this.estadoHabitacions;
    }
    
    public void setEstadoHabitacions(Set estadoHabitacions) {
        this.estadoHabitacions = estadoHabitacions;
    }
    public Set getHuespedHabitacions() {
        return this.huespedHabitacions;
    }
    
    public void setHuespedHabitacions(Set huespedHabitacions) {
        this.huespedHabitacions = huespedHabitacions;
    }




}


