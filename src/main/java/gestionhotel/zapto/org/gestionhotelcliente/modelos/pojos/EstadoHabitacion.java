package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 06-may-2018 1:59:43 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * EstadoHabitacion generated by hbm2java
 */
public class EstadoHabitacion  implements java.io.Serializable {


     private Integer idEstadoHabitacion;
     private DetallesReserva detallesReserva;
     private Date fechaInicio;
     private Date fechaFin;
     private Integer idSituacion;

    public EstadoHabitacion() {
    }

    public EstadoHabitacion(DetallesReserva detallesReserva, Date fechaInicio, Date fechaFin, Integer idSituacion) {
       this.detallesReserva = detallesReserva;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.idSituacion = idSituacion;
    }
   
    public Integer getIdEstadoHabitacion() {
        return this.idEstadoHabitacion;
    }
    
    public void setIdEstadoHabitacion(Integer idEstadoHabitacion) {
        this.idEstadoHabitacion = idEstadoHabitacion;
    }
    public DetallesReserva getDetallesReserva() {
        return this.detallesReserva;
    }
    
    public void setDetallesReserva(DetallesReserva detallesReserva) {
        this.detallesReserva = detallesReserva;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Integer getIdSituacion() {
        return this.idSituacion;
    }
    
    public void setIdSituacion(Integer idSituacion) {
        this.idSituacion = idSituacion;
    }




}


