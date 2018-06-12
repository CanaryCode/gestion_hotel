package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Agencia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaAgencia implements TablaInterface<TablaAgencia, Agencia> {

    private String numeroDocumento, calle, codigoPostal, ciudad, provincia, estado, categoria,
            email, numero, paginaWeb,razonSocial, nombreComercial;

    public TablaAgencia() {

    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {
        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Cif", "numeroDocumento", 100));
        lista.add(new CreadorDeTabla("Nombre", "nombreComercial", 100));
        lista.add(new CreadorDeTabla("Razón social", "razonSocial", 100));
        lista.add(new CreadorDeTabla("Categoria", "categoria", 100));
        lista.add(new CreadorDeTabla("País", "estado", 100));
        lista.add(new CreadorDeTabla("Provincia", "provincia", 100));
        lista.add(new CreadorDeTabla("Ciudad", "ciudad", 100));
        lista.add(new CreadorDeTabla("Calle", "calle", 100));
        lista.add(new CreadorDeTabla("Número", "numero", 100));
        lista.add(new CreadorDeTabla("Código postal", "codigoPostal", 100));
        lista.add(new CreadorDeTabla("Correo electrónico", "email", 100));
        lista.add(new CreadorDeTabla("Página web", "paginaWeb", 100));

        return lista;
    }

    @Override
    public ObservableList<TablaAgencia> getListaObjetosDeTabla(ObservableList<Agencia> listaAgencias) {
        ObservableList<TablaAgencia> listaTablaAgencias = FXCollections.observableArrayList();
        for (Agencia agencia : listaAgencias) {
            String numero = agencia.getPersona().getNumero();
            String razonSocial = agencia.getPersona().getJurRazonSocial();
            String nombreComercial = agencia.getPersona().getJurNombreComercial();
            String ciudad = agencia.getPersona().getCiudad();
            String provincia = agencia.getPersona().getProvincia();
            String calle = agencia.getPersona().getCalle();
            String codigoPostal = agencia.getPersona().getCodPostal();
            String numeroDocumento = agencia.getPersona().getNumeroDocumento();
            String estado = agencia.getPersona().getEstado();
            String email = agencia.getPersona().getEmail();
            String categoria = agencia.getPersona().getCategoria();
            String paginaWeb = agencia.getPersona().getPaginaWeb();
            
             TablaAgencia tablaAgencia = new TablaAgencia(numeroDocumento, calle, codigoPostal, 
                     ciudad, provincia, estado, categoria, email, numero, paginaWeb, razonSocial,
                     nombreComercial);

            listaTablaAgencias.add(tablaAgencia);
        }
        return listaTablaAgencias;
    }

    public TablaAgencia(String numeroDocumento,String calle, String codigoPostal,
            String ciudad, String provincia, String estado, String categoria,
            String email, String numero,  String paginaWeb,String razonSocial,
            String nombreComercial) {
        
        this.numeroDocumento = numeroDocumento;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.categoria = categoria;
        this.email = email;
        this.numero = numero;
        this.paginaWeb = paginaWeb;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

}
