package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 06-may-2018 1:59:43 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Reserva generated by hbm2java
 */
public class Reserva  implements java.io.Serializable {


     private Integer codReserva;
     private Persona personaByCodCliente;
     private Persona personaByCodEmpleado;
     private Persona personaByAgencia;
     private Date fecha;
     private Date fechaCancelada;
     private String motivoCancelacion;
     private String voucher;
     private String tipoTarjetaCredito;
     private String numeroTarjetaCredito;
     private String comentario;
     private String numero;
     private Set detallesReservas = new HashSet(0);

    public Reserva() {
    }

	
    public Reserva(String numero) {
        this.numero = numero;
    }
    public Reserva(Persona personaByCodCliente, Persona personaByCodEmpleado, Persona personaByAgencia, Date fecha, Date fechaCancelada, String motivoCancelacion, String voucher, String tipoTarjetaCredito, String numeroTarjetaCredito, String comentario, String numero, Set detallesReservas) {
       this.personaByCodCliente = personaByCodCliente;
       this.personaByCodEmpleado = personaByCodEmpleado;
       this.personaByAgencia = personaByAgencia;
       this.fecha = fecha;
       this.fechaCancelada = fechaCancelada;
       this.motivoCancelacion = motivoCancelacion;
       this.voucher = voucher;
       this.tipoTarjetaCredito = tipoTarjetaCredito;
       this.numeroTarjetaCredito = numeroTarjetaCredito;
       this.comentario = comentario;
       this.numero = numero;
       this.detallesReservas = detallesReservas;
    }
   
    public Integer getCodReserva() {
        return this.codReserva;
    }
    
    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }
    public Persona getPersonaByCodCliente() {
        return this.personaByCodCliente;
    }
    
    public void setPersonaByCodCliente(Persona personaByCodCliente) {
        this.personaByCodCliente = personaByCodCliente;
    }
    public Persona getPersonaByCodEmpleado() {
        return this.personaByCodEmpleado;
    }
    
    public void setPersonaByCodEmpleado(Persona personaByCodEmpleado) {
        this.personaByCodEmpleado = personaByCodEmpleado;
    }
    public Persona getPersonaByAgencia() {
        return this.personaByAgencia;
    }
    
    public void setPersonaByAgencia(Persona personaByAgencia) {
        this.personaByAgencia = personaByAgencia;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFechaCancelada() {
        return this.fechaCancelada;
    }
    
    public void setFechaCancelada(Date fechaCancelada) {
        this.fechaCancelada = fechaCancelada;
    }
    public String getMotivoCancelacion() {
        return this.motivoCancelacion;
    }
    
    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }
    public String getVoucher() {
        return this.voucher;
    }
    
    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
    public String getTipoTarjetaCredito() {
        return this.tipoTarjetaCredito;
    }
    
    public void setTipoTarjetaCredito(String tipoTarjetaCredito) {
        this.tipoTarjetaCredito = tipoTarjetaCredito;
    }
    public String getNumeroTarjetaCredito() {
        return this.numeroTarjetaCredito;
    }
    
    public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Set getDetallesReservas() {
        return this.detallesReservas;
    }
    
    public void setDetallesReservas(Set detallesReservas) {
        this.detallesReservas = detallesReservas;
    }




}


