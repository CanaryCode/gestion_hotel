package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 12-may-2018 8:07:49 by Hibernate Tools 4.3.1



/**
 * HuespedHabitacion generated by hbm2java
 */
public class HuespedHabitacion  implements java.io.Serializable {


     private Integer idHuespedHabitacion;
     private DetallesReserva detallesReserva;
     private Persona persona;

    public HuespedHabitacion() {
    }

    public HuespedHabitacion(DetallesReserva detallesReserva, Persona persona) {
       this.detallesReserva = detallesReserva;
       this.persona = persona;
    }
   
    public Integer getIdHuespedHabitacion() {
        return this.idHuespedHabitacion;
    }
    
    public void setIdHuespedHabitacion(Integer idHuespedHabitacion) {
        this.idHuespedHabitacion = idHuespedHabitacion;
    }
    public DetallesReserva getDetallesReserva() {
        return this.detallesReserva;
    }
    
    public void setDetallesReserva(DetallesReserva detallesReserva) {
        this.detallesReserva = detallesReserva;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }




}


