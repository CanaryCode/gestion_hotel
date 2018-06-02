package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaCliente implements TablaInterface<TablaCliente, Persona> {

    private String numeroDocumento, nombre, calle, codigoPostal, ciudad, provincia, estado,
            sexoHombre, nacionalidad, categoria, email, numero, comentario,
            teléfonoFijo, teléfonoMovil, primerApellido, segundoApellido, tratamiento, paginaWeb, esEmpresa,
            razonSocial, nombreComercial;

    public TablaCliente() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Tipo", "esEmpresa", 100));
        lista.add(new CreadorDeTabla("Documento", "numeroDocumento", 100));
        lista.add(new CreadorDeTabla("Nombre comercial", "razonSocial", 100));
        lista.add(new CreadorDeTabla("Razón social", "nombreComercial", 100));
        lista.add(new CreadorDeTabla("Nombre", "nombre", 100));
        lista.add(new CreadorDeTabla("Primer Apellido", "primerApellido", 100));
        lista.add(new CreadorDeTabla("Segundo Apellido", "segundoApellido", 100));
        lista.add(new CreadorDeTabla("Tratamiento", "tratamiento", 100));
        lista.add(new CreadorDeTabla("Categoria", "categoria", 100));
        lista.add(new CreadorDeTabla("Nacionalidad", "nacionalidad", 100));
        lista.add(new CreadorDeTabla("Sexo", "sexoHombre", 100));
        lista.add(new CreadorDeTabla("Fecha nacimiento", "fechaNacimiento", 100));
        lista.add(new CreadorDeTabla("Pais", "estado", 100));
        lista.add(new CreadorDeTabla("Provincia", "provincia", 100));
        lista.add(new CreadorDeTabla("Ciudad", "ciudad", 100));
        lista.add(new CreadorDeTabla("Calle", "calle", 100));
        lista.add(new CreadorDeTabla("Numero", "numero", 100));
        lista.add(new CreadorDeTabla("Código Postal", "codigoPostal", 100));
        lista.add(new CreadorDeTabla("E-mail", "email", 200));
        lista.add(new CreadorDeTabla("Página web", "paginaWeb", 200));

        return lista;
    }

    /**
     * con una lista del modelo personas de la base de datos crea una lista del
     * modelo de tabla para la visualización en dicha tabla.
     *
     * @param listaPersona lista de personas normalmente retornada de una
     * consulta a las base de datos
     * @return lista del modelo de la tabla
     */
    @Override
    public ObservableList<TablaCliente> getListaObjetosDeTabla(ObservableList<Persona> listaPersona) {
        ObservableList<TablaCliente> listaClientes = FXCollections.observableArrayList();
        if (!listaPersona.isEmpty()) {
            for (Persona persona : listaPersona) {
                String numero = persona.getNumero();
                String nombre = persona.getNombre();
                String primerApellido = persona.getFisPrimerApellido();
                String SegundoApellido = persona.getFisSegundoApellido();
                Date fechaNacimiento = persona.getFisFechaNacimiento();
                String razonSocial = persona.getJurRazonSocial();
                String nombreComercial = persona.getJurNombreComercial();
                String nacionalidad = persona.getFisNacionalidad();
                String ciudad = persona.getCiudad();
                String provincia = persona.getProvincia();
                String calle = persona.getCalle();
                String codigoPostal = persona.getCodPostal();
                String numeroDocumento = persona.getDocumentoNumero();
                String estado = persona.getEstado();
                String email = persona.getEmail();
                String categoria = persona.getCategoria();
                String comentario = persona.getComentario();
                String telefonoFijo = null;
                String telefonoMovil = null;
                String tratamiento = persona.getFisTratamiento();
                String paginaWeb = persona.getPaginaWeb();
                String esEmpresa = "";
                if (persona.getEsEmpresa() != null) {
                    esEmpresa = (persona.getEsEmpresa() == 0) ? "Persona" : "Empresa";
                }
                String sexo = "";
                if (persona.getFisSexoHombre() != null) {
                    sexo = (persona.getFisSexoHombre() == 0) ? "mujer" : "hombre";
                }
                TablaCliente cliente = new TablaCliente(numeroDocumento, nombre, calle, codigoPostal, ciudad,
                        provincia, estado, sexo, nacionalidad, categoria, email, numero, comentario,
                        telefonoFijo, telefonoMovil, primerApellido, SegundoApellido,
                        tratamiento, paginaWeb, esEmpresa, razonSocial, nombreComercial, fechaNacimiento);
                listaClientes.add(cliente);
            }
        }
        return listaClientes;
    }

    public TablaCliente(String numeroDocumento, String nombre, String calle, String codigoPostal,
            String ciudad, String provincia, String estado, String sexoHombre, String nacionalidad,
            String categoria, String email, String numero, String comentario, String teléfonoFijo,
            String teléfonoMovil, String primerApellido, String segundoApellido, String tratamiento,
            String paginaWeb, String esEmpresa, String razonSocial, String nombreComercial,
            Date fechaNacimiento) {

        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.sexoHombre = sexoHombre;
        this.nacionalidad = nacionalidad;
        this.categoria = categoria;
        this.email = email;
        this.numero = numero;
        this.comentario = comentario;
        this.teléfonoFijo = teléfonoFijo;
        this.teléfonoMovil = teléfonoMovil;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.tratamiento = tratamiento;
        this.paginaWeb = paginaWeb;
        this.esEmpresa = esEmpresa;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTeléfonoFijo() {
        return teléfonoFijo;
    }

    public void setTeléfonoFijo(String teléfonoFijo) {
        this.teléfonoFijo = teléfonoFijo;
    }

    public String getTeléfonoMovil() {
        return teléfonoMovil;
    }

    public void setTeléfonoMovil(String teléfonoMovil) {
        this.teléfonoMovil = teléfonoMovil;
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

    public String getEsEmpresa() {
        return esEmpresa;
    }

    public void setEsEmpresa(String esEmpresa) {
        this.esEmpresa = esEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    private Date fechaNacimiento;

}
