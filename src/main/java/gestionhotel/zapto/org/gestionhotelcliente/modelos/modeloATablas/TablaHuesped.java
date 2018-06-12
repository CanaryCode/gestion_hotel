package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaHuesped implements TablaInterface<TablaHuesped, Huesped> {

    private String numeroDocumento, nombre, calle, codigoPostal, ciudad, provincia, estado,
            nacionalidad, categoria, pasaporte, email,  numero, comentario,
            primerApellido, segundoApellido, tratamiento, paginaWeb;
    private ImageView discapacitado,sexoHombre;
    private int codigoPersona;
    private Date fechaNacimiento, expPasaporte, vencPasaporte;

    public TablaHuesped() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Dni", "numeroDocumento", 100));
        lista.add(new CreadorDeTabla("Nombre", "nombre", 100));
        lista.add(new CreadorDeTabla("Primer Apellido", "primerApellido", 100));
        lista.add(new CreadorDeTabla("Segundo Apellido", "segundoApellido", 100));
        lista.add(new CreadorDeTabla("Tratamiento", "tratamiento", 100));
        lista.add(new CreadorDeTabla("Categoria", "categoria", 100));
        lista.add(new CreadorDeTabla("Pasaporte", "pasaporte", 100));
        lista.add(new CreadorDeTabla("Nacionalidad", "nacionalidad", 100));
        lista.add(new CreadorDeTabla("Sexo", "sexoHombre", 100));
        lista.add(new CreadorDeTabla("Fecha nacimiento", "fechaNacimiento", 100));
        lista.add(new CreadorDeTabla("Exp. pasaporte", "expPasaporte", 100));
        lista.add(new CreadorDeTabla("Discapacitado", "discapacitado", 100));
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

    @Override
    public ObservableList<TablaHuesped> getListaObjetosDeTabla(ObservableList<Huesped> listaHuesped) {
        ObservableList<TablaHuesped> listaHuespedes = FXCollections.observableArrayList();
        if (listaHuesped != null||!listaHuesped.isEmpty()) {
            if (!listaHuesped.isEmpty()) {
                for (Huesped huesped : listaHuesped) {
                    String numero = huesped.getPersona().getNumero();
                    String nombre = huesped.getPersona().getNombre();
                    String primerApellido = huesped.getPersona().getFisPrimerApellido();
                    String SegundoApellido = huesped.getPersona().getFisSegundoApellido();
                    Date fechaNacimiento = huesped.getPersona().getFisFechaNacimiento();
                    //Date fechaExpPasaporte = huesped.ge;
                    String nacionalidad = huesped.getPersona().getFisNacionalidad();
                    String tratamiento = huesped.getPersona().getFisTratamiento();
                    String ciudad = huesped.getPersona().getCiudad();
                    String provincia = huesped.getPersona().getProvincia();
                    String calle = huesped.getPersona().getCalle();
                    String codigoPostal = huesped.getPersona().getCodPostal();
                    String dni = huesped.getPersona().getNumeroDocumento();
                    String estado = huesped.getPersona().getEstado();
                    String pasaporte = huesped.getPersona().getPasaporte();
                    String email = huesped.getPersona().getEmail();
                    String categoria = huesped.getPersona().getCategoria();
                    String comentario = huesped.getPersona().getComentario();
                    String paginaWeb = huesped.getPersona().getPaginaWeb();
                    ImageView sexo = null;
                    int codigoPersona = huesped.getId();
                    
                    if (huesped.getPersona().getFisSexoHombre() != null) {
                        sexo = (huesped.getPersona().getFisSexoHombre() == false) ?new ImageView(new Image(getClass().getResource("/imagenes/tablas/mujer.png").toExternalForm())) :
                            new ImageView(new Image(getClass().getResource("/imagenes/tablas/hombre.png").toExternalForm()));
                }
                    ImageView discapacitado = null;
                    if (huesped.getPersona().getFisSexoHombre() != null) {
                        discapacitado = (huesped.getPersona().getFisSexoHombre() == false) ? new ImageView(new Image(getClass().getResource("/imagenes/tablas/discapacitado.png").toExternalForm())) :
                            new ImageView();
                }
                    TablaHuesped huespedNuevo = new TablaHuesped(numero, dni, nombre, calle, codigoPostal, ciudad,
                            provincia, estado, tratamiento, sexo, primerApellido, SegundoApellido,
                            nacionalidad, categoria, pasaporte, email, discapacitado, null,
                            null, fechaNacimiento, comentario, codigoPersona, paginaWeb);
                    listaHuespedes.add(huespedNuevo);
                }
            }
        }
        return listaHuespedes;
    }

    public TablaHuesped(String numero, String documentoNumero, String nombre, String calle, String codPostal,
            String ciudad, String provincia, String estado, String tratamiento, ImageView SexoHombre,
            String PrimerApellido, String SegundoApellido, String Nacionalidad, String categoria,
            String pasaporte, String email, ImageView discapacitado, Date expPasaporte, Date vencPasaporte,
            Date fechaNacimiento, String comentario, Integer codigoPersona, String paginaWeb) {
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
        this.paginaWeb = paginaWeb;
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

    public ImageView getDiscapacitado() {
        return discapacitado;
    }

    public void setDiscapacitado(ImageView discapacitado) {
        this.discapacitado = discapacitado;
    }

    public ImageView getSexoHombre() {
        return sexoHombre;
    }

    public void setSexoHombre(ImageView sexoHombre) {
        this.sexoHombre = sexoHombre;
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
