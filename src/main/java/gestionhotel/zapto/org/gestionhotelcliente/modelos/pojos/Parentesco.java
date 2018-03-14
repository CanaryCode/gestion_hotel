package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 13-mar-2018 20:11:32 by Hibernate Tools 4.3.1



/**
 * Parentesco generated by hbm2java
 */
public class Parentesco  implements java.io.Serializable {


     private ParentescoId id;
     private Persona personaByCodPersona;
     private Persona personaByCodPariente;
     private String tipoParentesco;

    public Parentesco() {
    }

    public Parentesco(ParentescoId id, Persona personaByCodPersona, Persona personaByCodPariente, String tipoParentesco) {
       this.id = id;
       this.personaByCodPersona = personaByCodPersona;
       this.personaByCodPariente = personaByCodPariente;
       this.tipoParentesco = tipoParentesco;
    }
   
    public ParentescoId getId() {
        return this.id;
    }
    
    public void setId(ParentescoId id) {
        this.id = id;
    }
    public Persona getPersonaByCodPersona() {
        return this.personaByCodPersona;
    }
    
    public void setPersonaByCodPersona(Persona personaByCodPersona) {
        this.personaByCodPersona = personaByCodPersona;
    }
    public Persona getPersonaByCodPariente() {
        return this.personaByCodPariente;
    }
    
    public void setPersonaByCodPariente(Persona personaByCodPariente) {
        this.personaByCodPariente = personaByCodPariente;
    }
    public String getTipoParentesco() {
        return this.tipoParentesco;
    }
    
    public void setTipoParentesco(String tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }




}


