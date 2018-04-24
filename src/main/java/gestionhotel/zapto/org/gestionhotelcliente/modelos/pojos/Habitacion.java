package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 24-abr-2018 3:43:16 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Habitacion generated by hbm2java
 */
public class Habitacion  implements java.io.Serializable {


     private int numero;
     private String descripcion;
     private String tipo;
     private Byte limpiar;
     private Byte camaExtra;
     private Set detallesReservas = new HashSet(0);

    public Habitacion() {
    }

	
    public Habitacion(int numero) {
        this.numero = numero;
    }
    public Habitacion(int numero, String descripcion, String tipo, Byte limpiar, Byte camaExtra, Set detallesReservas) {
       this.numero = numero;
       this.descripcion = descripcion;
       this.tipo = tipo;
       this.limpiar = limpiar;
       this.camaExtra = camaExtra;
       this.detallesReservas = detallesReservas;
    }
   
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Byte getLimpiar() {
        return this.limpiar;
    }
    
    public void setLimpiar(Byte limpiar) {
        this.limpiar = limpiar;
    }
    public Byte getCamaExtra() {
        return this.camaExtra;
    }
    
    public void setCamaExtra(Byte camaExtra) {
        this.camaExtra = camaExtra;
    }
    public Set getDetallesReservas() {
        return this.detallesReservas;
    }
    
    public void setDetallesReservas(Set detallesReservas) {
        this.detallesReservas = detallesReservas;
    }




}


