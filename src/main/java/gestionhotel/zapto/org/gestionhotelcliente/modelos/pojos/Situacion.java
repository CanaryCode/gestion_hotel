package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 02-jun-2018 20:17:43 by Hibernate Tools 4.3.1



/**
 * Situacion generated by hbm2java
 */
public class Situacion  implements java.io.Serializable {


     private Integer idSituacion;
     private String descripcion;

    public Situacion() {
    }

    public Situacion(String descripcion) {
       this.descripcion = descripcion;
    }
   
    public Integer getIdSituacion() {
        return this.idSituacion;
    }
    
    public void setIdSituacion(Integer idSituacion) {
        this.idSituacion = idSituacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


