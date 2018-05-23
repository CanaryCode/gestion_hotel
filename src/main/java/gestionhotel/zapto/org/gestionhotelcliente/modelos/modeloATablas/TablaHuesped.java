package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaHuesped {

    private String numeroDocumento, nombre, calle, codigoPostal, ciudad, provincia, estado,
            sexoHombre, nacionalidad, categoria, pasaporte, email, discapacitado, numero, comentario,
            primerApellido, segundoApellido, tratamiento, paginaWeb;
   private int codigoPersona;
    private Date fechaNacimiento, expPasaporte, vencPasaporte;

    public static ObservableList<TablaHuesped> getTablaBuscadorHuesped(List<Persona> listaPersona) {
        ObservableList<TablaHuesped> listaHuespedes = FXCollections.observableArrayList();
        if (!listaPersona.isEmpty()) {
            for (Persona persona : listaPersona) {
                String numero = persona.getNumero();
                String nombre = persona.getNombre();
                String primerApellido = persona.getFisPrimerApellido();
                String SegundoApellido = persona.getFisSegundoApellido();
                Date fechaNacimiento = persona.getFisFechaNacimiento();
                Date fechaExpPasaporte = persona.getFisExpPasaporte();
                String nacionalidad = persona.getFisNacionalidad();
                String tratamiento = persona.getFisTratamiento();
                String ciudad = persona.getCiudad();
                String provincia = persona.getProvincia();
                String calle = persona.getCalle();
                String codigoPostal = persona.getCodPostal();
                String dni = persona.getDocumentoNumero();
                String estado = persona.getEstado();
                String pasaporte = persona.getPasaporte();
                String email = persona.getEmail();
                String categoria = persona.getCategoria();
                String comentario = persona.getComentario();
                String sexo = "";
                int codigoPersona=persona.getCodPersona();
                if (persona.getFisSexoHombre() != null) {
                    sexo = (persona.getFisSexoHombre() == 0) ? "mujer" : "hombre";
                }
                String discapacitado = "";
                if (persona.getFisSexoHombre() != null) {
                    discapacitado = (persona.getFisSexoHombre() == 0) ? "Discapacitado" : "No";
                }

                TablaHuesped huesped = new TablaHuesped(numero, dni, nombre, calle, codigoPostal, ciudad,
                        provincia, estado, tratamiento, sexo, primerApellido, SegundoApellido,
                        nacionalidad, categoria, pasaporte, email, discapacitado, fechaExpPasaporte,
                        fechaExpPasaporte, fechaNacimiento, comentario,codigoPersona);
                listaHuespedes.add(huesped);
            }
        }
        return listaHuespedes;
    }

    public TablaHuesped() {

    }

    public TablaHuesped(String numero, String documentoNumero, String nombre, String calle, String codPostal,
            String ciudad, String provincia, String estado, String tratamiento, String SexoHombre,
            String PrimerApellido, String SegundoApellido, String Nacionalidad, String categoria,
            String pasaporte, String email, String discapacitado, Date expPasaporte, Date vencPasaporte,
            Date fechaNacimiento, String comentario,Integer codigoPersona) {
        this.numero = numero;
        this.numeroDocumento = documentoNumero;
        this.nombre = nombre;
        this.calle = calle;
        this.codigoPostal = codPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.tratamiento = tratamiento;
        this.sexoHombre = SexoHombre;
        this.primerApellido = PrimerApellido;
        this.segundoApellido = SegundoApellido;
        this.nacionalidad = Nacionalidad;
        this.categoria = categoria;
        this.pasaporte = pasaporte;
        this.email = email;
        this.discapacitado = discapacitado;
        this.expPasaporte = expPasaporte;
        this.vencPasaporte = vencPasaporte;
        this.fechaNacimiento = fechaNacimiento;
        this.comentario = comentario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }
    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexoHombre() {
        return sexoHombre;
    }

    public void setSexoHombre(String sexoHombre) {
        this.sexoHombre = sexoHombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(String discapacitado) {
        this.discapacitado = discapacitado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

   
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getExpPasaporte() {
        return expPasaporte;
    }

    public void setExpPasaporte(Date expPasaporte) {
        this.expPasaporte = expPasaporte;
    }

    public Date getVencPasaporte() {
        return vencPasaporte;
    }

    public void setVencPasaporte(Date vencPasaporte) {
        this.vencPasaporte = vencPasaporte;
    }

}
