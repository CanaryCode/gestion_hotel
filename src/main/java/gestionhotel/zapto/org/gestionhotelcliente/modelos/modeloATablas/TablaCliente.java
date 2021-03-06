package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Cliente;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaCliente implements TablaInterface<TablaCliente, Cliente> {

    private String numeroDocumento, nombre, calle, codigoPostal, ciudad, provincia, estado, nacionalidad, categoria, email, numero, comentario,
            primerApellido, segundoApellido, tratamiento, paginaWeb,
            razonSocial, nombreComercial;
    private ImageView esEmpresa, sexoHombre;

    public TablaCliente() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Tipo", "esEmpresa", 100));
        lista.add(new CreadorDeTabla("Documento", "numeroDocumento", 100));
        lista.add(new CreadorDeTabla("Nombre comercial", "nombreComercial", 100));
        lista.add(new CreadorDeTabla("Razón social", "razonSocial", 100));
        lista.add(new CreadorDeTabla("Categoria", "categoria", 100));
        lista.add(new CreadorDeTabla("Nombre", "nombre", 100));
        lista.add(new CreadorDeTabla("Primer Apellido", "primerApellido", 100));
        lista.add(new CreadorDeTabla("Segundo Apellido", "segundoApellido", 100));
        lista.add(new CreadorDeTabla("Tratamiento", "tratamiento", 100));
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
     * @param listaCliente lista de personas normalmente retornada de una
     * consulta a las base de datos
     * @return lista del modelo de la tabla
     */
    @Override
    public ObservableList<TablaCliente> getListaObjetosDeTabla(ObservableList<Cliente> listaCliente) {
        ObservableList<TablaCliente> listaClientes = FXCollections.observableArrayList();
        if (!listaCliente.isEmpty()) {
            for (Cliente cliente : listaCliente) {
                String numero = cliente.getPersona().getNumero();
                String nombre = cliente.getPersona().getNombre();
                String primerApellido = cliente.getPersona().getFisPrimerApellido();
                String SegundoApellido = cliente.getPersona().getFisSegundoApellido();
                Date fechaNacimiento = cliente.getPersona().getFisFechaNacimiento();
                String razonSocial = cliente.getPersona().getJurRazonSocial();
                String nombreComercial = cliente.getPersona().getJurNombreComercial();
                String nacionalidad = cliente.getPersona().getFisNacionalidad();
                String ciudad = cliente.getPersona().getCiudad();
                String provincia = cliente.getPersona().getProvincia();
                String calle = cliente.getPersona().getCalle();
                String codigoPostal = cliente.getPersona().getCodPostal();
                String numeroDocumento = cliente.getPersona().getNumeroDocumento();
                String estado = cliente.getPersona().getEstado();
                String email = cliente.getPersona().getEmail();
                String categoria = cliente.getPersona().getCategoria();
                String comentario = cliente.getPersona().getComentario();
                String tratamiento = cliente.getPersona().getFisTratamiento();
                String paginaWeb = cliente.getPersona().getPaginaWeb();
                ImageView esEmpresa = null;
                if (cliente.getPersona().getEsEmpresa() != null) {
                    esEmpresa = (cliente.getPersona().getEsEmpresa() == false) ? new ImageView(new Image(getClass().getResource("/imagenes/tablas/persona.png").toExternalForm()))
                            : new ImageView(new Image(getClass().getResource("/imagenes/tablas/empresa.png").toExternalForm()));
                }
                ImageView sexo = null;
                if (cliente.getPersona().getFisSexoHombre() != null) {
                    sexo = (cliente.getPersona().getFisSexoHombre() == false) ? new ImageView(new Image(getClass().getResource("/imagenes/tablas/mujer.png").toExternalForm()))
                            : new ImageView(new Image(getClass().getResource("/imagenes/tablas/hombre.png").toExternalForm()));
                }
                TablaCliente nuevoCliente = new TablaCliente(numeroDocumento, nombre, calle, codigoPostal, ciudad,
                        provincia, estado, sexo, nacionalidad, categoria, email, numero, comentario,
                        primerApellido, SegundoApellido, tratamiento, paginaWeb, esEmpresa, razonSocial,
                        nombreComercial, fechaNacimiento);
                listaClientes.add(nuevoCliente);
            }
        }
        return listaClientes;
    }

    public TablaCliente(String numeroDocumento, String nombre, String calle, String codigoPostal,
            String ciudad, String provincia, String estado, ImageView sexoHombre, String nacionalidad,
            String categoria, String email, String numero, String comentario, String primerApellido,
            String segundoApellido, String tratamiento, String paginaWeb, ImageView esEmpresa, String razonSocial,
            String nombreComercial, Date fechaNacimiento) {

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

    public ImageView getSexoHombre() {
        return sexoHombre;
    }

    public void setSexoHombre(ImageView sexoHombre) {
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

    public ImageView getEsEmpresa() {
        return esEmpresa;
    }

    public void setEsEmpresa(ImageView esEmpresa) {
        this.esEmpresa = esEmpresa;
    }

}
