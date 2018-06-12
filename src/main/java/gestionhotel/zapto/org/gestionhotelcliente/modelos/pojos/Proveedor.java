package gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos;
// Generated 09-jun-2018 9:28:59 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proveedor generated by hbm2java
 */
@Entity
@Table(name="proveedor"
    ,catalog="gestionhotel"
)
public class Proveedor  implements java.io.Serializable {


     private Integer id;
     private Persona persona;
     private Set articulos = new HashSet(0);

    public Proveedor() {
    }

	
    public Proveedor(Persona persona) {
        this.persona = persona;
    }
    public Proveedor(Persona persona, Set articulos) {
       this.persona = persona;
       this.articulos = articulos;
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
    @JoinColumn(name="fk_persona", nullable=false)
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proveedor")
    public Set getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Set articulos) {
        this.articulos = articulos;
    }




}


