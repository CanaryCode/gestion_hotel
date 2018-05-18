package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 18-may-2018 17:14:22 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int codUsuario;
     private Persona persona;
     private String nombreUsuario;
     private String passUsuario;
     private Byte bloqueado;
     private Byte administrador;
     private Byte recepcion;
     private Byte mostrador;
     private Byte servidor;
     private Date ultimaActividad;
     private Date fechaCaducidad;

    public Usuario() {
    }

	
    public Usuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    public Usuario(int codUsuario, Persona persona, String nombreUsuario, String passUsuario, Byte bloqueado, Byte administrador, Byte recepcion, Byte mostrador, Byte servidor, Date ultimaActividad, Date fechaCaducidad) {
       this.codUsuario = codUsuario;
       this.persona = persona;
       this.nombreUsuario = nombreUsuario;
       this.passUsuario = passUsuario;
       this.bloqueado = bloqueado;
       this.administrador = administrador;
       this.recepcion = recepcion;
       this.mostrador = mostrador;
       this.servidor = servidor;
       this.ultimaActividad = ultimaActividad;
       this.fechaCaducidad = fechaCaducidad;
    }
   
    public int getCodUsuario() {
        return this.codUsuario;
    }
    
    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getPassUsuario() {
        return this.passUsuario;
    }
    
    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
    public Byte getBloqueado() {
        return this.bloqueado;
    }
    
    public void setBloqueado(Byte bloqueado) {
        this.bloqueado = bloqueado;
    }
    public Byte getAdministrador() {
        return this.administrador;
    }
    
    public void setAdministrador(Byte administrador) {
        this.administrador = administrador;
    }
    public Byte getRecepcion() {
        return this.recepcion;
    }
    
    public void setRecepcion(Byte recepcion) {
        this.recepcion = recepcion;
    }
    public Byte getMostrador() {
        return this.mostrador;
    }
    
    public void setMostrador(Byte mostrador) {
        this.mostrador = mostrador;
    }
    public Byte getServidor() {
        return this.servidor;
    }
    
    public void setServidor(Byte servidor) {
        this.servidor = servidor;
    }
    public Date getUltimaActividad() {
        return this.ultimaActividad;
    }
    
    public void setUltimaActividad(Date ultimaActividad) {
        this.ultimaActividad = ultimaActividad;
    }
    public Date getFechaCaducidad() {
        return this.fechaCaducidad;
    }
    
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }




}


