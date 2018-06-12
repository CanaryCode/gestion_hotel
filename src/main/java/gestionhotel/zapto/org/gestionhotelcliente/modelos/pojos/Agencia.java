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
 * Agencia generated by hbm2java
 */
@Entity
@Table(name="agencia"
    ,catalog="gestionhotel"
)
public class Agencia  implements java.io.Serializable {


     private Integer id;
     private Persona persona;
     private Set reservas = new HashSet(0);
     private Set alojamientos = new HashSet(0);

    public Agencia() {
    }

	
    public Agencia(Persona persona) {
        this.persona = persona;
    }
    public Agencia(Persona persona, Set reservas, Set alojamientos) {
       this.persona = persona;
       this.reservas = reservas;
       this.alojamientos = alojamientos;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="agencia")
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="agencia")
    public Set getAlojamientos() {
        return this.alojamientos;
    }
    
    public void setAlojamientos(Set alojamientos) {
        this.alojamientos = alojamientos;
    }




}


