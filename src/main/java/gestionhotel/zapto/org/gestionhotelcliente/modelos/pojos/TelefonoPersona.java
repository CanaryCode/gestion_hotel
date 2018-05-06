package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 06-may-2018 1:59:43 by Hibernate Tools 4.3.1



/**
 * TelefonoPersona generated by hbm2java
 */
public class TelefonoPersona  implements java.io.Serializable {


     private TelefonoPersonaId id;
     private Persona personaByNumTelefono;
     private Persona personaByCodPersona;
     private String descripcion;

    public TelefonoPersona() {
    }

	
    public TelefonoPersona(TelefonoPersonaId id, Persona personaByNumTelefono, Persona personaByCodPersona) {
        this.id = id;
        this.personaByNumTelefono = personaByNumTelefono;
        this.personaByCodPersona = personaByCodPersona;
    }
    public TelefonoPersona(TelefonoPersonaId id, Persona personaByNumTelefono, Persona personaByCodPersona, String descripcion) {
       this.id = id;
       this.personaByNumTelefono = personaByNumTelefono;
       this.personaByCodPersona = personaByCodPersona;
       this.descripcion = descripcion;
    }
   
    public TelefonoPersonaId getId() {
        return this.id;
    }
    
    public void setId(TelefonoPersonaId id) {
        this.id = id;
    }
    public Persona getPersonaByNumTelefono() {
        return this.personaByNumTelefono;
    }
    
    public void setPersonaByNumTelefono(Persona personaByNumTelefono) {
        this.personaByNumTelefono = personaByNumTelefono;
    }
    public Persona getPersonaByCodPersona() {
        return this.personaByCodPersona;
    }
    
    public void setPersonaByCodPersona(Persona personaByCodPersona) {
        this.personaByCodPersona = personaByCodPersona;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


