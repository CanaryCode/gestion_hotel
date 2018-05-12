package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 12-may-2018 8:07:49 by Hibernate Tools 4.3.1



/**
 * Parentesco generated by hbm2java
 */
public class Parentesco  implements java.io.Serializable {


     private ParentescoId id;
     private Persona personaByCodPariente;
     private Persona personaByCodPersona;
     private String tipoParentesco;

    public Parentesco() {
    }

	
    public Parentesco(ParentescoId id, Persona personaByCodPariente, Persona personaByCodPersona) {
        this.id = id;
        this.personaByCodPariente = personaByCodPariente;
        this.personaByCodPersona = personaByCodPersona;
    }
    public Parentesco(ParentescoId id, Persona personaByCodPariente, Persona personaByCodPersona, String tipoParentesco) {
       this.id = id;
       this.personaByCodPariente = personaByCodPariente;
       this.personaByCodPersona = personaByCodPersona;
       this.tipoParentesco = tipoParentesco;
    }
   
    public ParentescoId getId() {
        return this.id;
    }
    
    public void setId(ParentescoId id) {
        this.id = id;
    }
    public Persona getPersonaByCodPariente() {
        return this.personaByCodPariente;
    }
    
    public void setPersonaByCodPariente(Persona personaByCodPariente) {
        this.personaByCodPariente = personaByCodPariente;
    }
    public Persona getPersonaByCodPersona() {
        return this.personaByCodPersona;
    }
    
    public void setPersonaByCodPersona(Persona personaByCodPersona) {
        this.personaByCodPersona = personaByCodPersona;
    }
    public String getTipoParentesco() {
        return this.tipoParentesco;
    }
    
    public void setTipoParentesco(String tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }




}


