package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 24-abr-2018 21:28:21 by Hibernate Tools 4.3.1



/**
 * ParentescoId generated by hbm2java
 */
public class ParentescoId  implements java.io.Serializable {


     private int codPersona;
     private int codPariente;

    public ParentescoId() {
    }

    public ParentescoId(int codPersona, int codPariente) {
       this.codPersona = codPersona;
       this.codPariente = codPariente;
    }
   
    public int getCodPersona() {
        return this.codPersona;
    }
    
    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }
    public int getCodPariente() {
        return this.codPariente;
    }
    
    public void setCodPariente(int codPariente) {
        this.codPariente = codPariente;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ParentescoId) ) return false;
		 ParentescoId castOther = ( ParentescoId ) other; 
         
		 return (this.getCodPersona()==castOther.getCodPersona())
 && (this.getCodPariente()==castOther.getCodPariente());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodPersona();
         result = 37 * result + this.getCodPariente();
         return result;
   }   


}

