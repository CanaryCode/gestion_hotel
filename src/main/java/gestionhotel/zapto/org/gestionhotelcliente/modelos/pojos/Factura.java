package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 09-jun-2018 9:28:59 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Factura generated by hbm2java
 */
@Entity
@Table(name="factura"
    ,catalog="gestionhotel"
)
public class Factura  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private Trabajador trabajador;
     private String comentario;
     private Date fechaCreacion;
     private Date fechaLiquidacion;

    public Factura() {
    }

	
    public Factura(Trabajador trabajador, Date fechaCreacion) {
        this.trabajador = trabajador;
        this.fechaCreacion = fechaCreacion;
    }
    public Factura(Cliente cliente, Trabajador trabajador, String comentario, Date fechaCreacion, Date fechaLiquidacion) {
       this.cliente = cliente;
       this.trabajador = trabajador;
       this.comentario = comentario;
       this.fechaCreacion = fechaCreacion;
       this.fechaLiquidacion = fechaLiquidacion;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_cliente")
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_trabajador", nullable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    
    @Column(name="comentario", length=300)
    public String getComentario() {
        return this.comentario;
    }
    
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_creacion", nullable=false, length=10)
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_liquidacion", length=10)
    public Date getFechaLiquidacion() {
        return this.fechaLiquidacion;
    }
    
    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }




}


