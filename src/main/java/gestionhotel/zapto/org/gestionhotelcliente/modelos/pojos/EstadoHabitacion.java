package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 13-mar-2018 20:11:32 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * EstadoHabitacion generated by hbm2java
 */
public class EstadoHabitacion  implements java.io.Serializable {


     private int id;
     private Situacion situacion;
     private Integer idAlojamiento;
     private Date fechaInicio;
     private Date fechaFin;

    public EstadoHabitacion() {
    }

	
    public EstadoHabitacion(int id, Situacion situacion) {
        this.id = id;
        this.situacion = situacion;
    }
    public EstadoHabitacion(int id, Situacion situacion, Integer idAlojamiento, Date fechaInicio, Date fechaFin) {
       this.id = id;
       this.situacion = situacion;
       this.idAlojamiento = idAlojamiento;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Situacion getSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }
    public Integer getIdAlojamiento() {
        return this.idAlojamiento;
    }
    
    public void setIdAlojamiento(Integer idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
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




}


