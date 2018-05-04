/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionhotel.zapto.org.gestionhotelcliente.modelos.tablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.dialect.H2Dialect;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class Huesped {

    private int numero;
    private String documentoNumero, nombre, calle, codPostal, ciudad, provincia, estado,
            Tratamiento, SexoHombre, PrimerApellido, SegundoApellido, Nacionalidad, categoria, pasaporte,
            email, discapacitado;
    private Date fisExpPasaporte;
    private Date fisVencPasaporte;
    private Date fisFechaNacimiento;

    public static ObservableList<Huesped> modeloCheckin(List<Persona> listaPersona) {
        ObservableList<Huesped> listaHuespedes = FXCollections.observableArrayList();

        for (Persona persona : listaPersona) {
            int numero = persona.getCodPersona();
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
            String sexo = (persona.getFisSexoHombre() == 0) ? "mujer" : "hombre";
            String discapacitado = (persona.getFisSexoHombre() == 0) ? "no" : "si";

            Huesped huesped = new Huesped(numero, dni, nombre, calle, codigoPostal, ciudad,
                    provincia, estado, tratamiento, sexo, primerApellido, SegundoApellido,
                    nacionalidad, categoria, pasaporte, email, discapacitado, fechaExpPasaporte,
                    fechaExpPasaporte, fechaNacimiento);
            listaHuespedes.add(huesped);
        }
        return listaHuespedes;
    }

    public Huesped() {

    }

    public Huesped(int numero, String documentoNumero, String nombre, String calle, String codPostal,
            String ciudad, String provincia, String estado, String Tratamiento, String SexoHombre,
            String PrimerApellido, String SegundoApellido, String Nacionalidad, String categoria,
            String pasaporte, String email, String discapacitado, Date fisExpPasaporte, Date fisVencPasaporte,
            Date fisFechaNacimiento) {
        this.numero = numero;
        this.documentoNumero = documentoNumero;
        this.nombre = nombre;
        this.calle = calle;
        this.codPostal = codPostal;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.estado = estado;
        this.Tratamiento = Tratamiento;
        this.SexoHombre = SexoHombre;
        this.PrimerApellido = PrimerApellido;
        this.SegundoApellido = SegundoApellido;
        this.Nacionalidad = Nacionalidad;
        this.categoria = categoria;
        this.pasaporte = pasaporte;
        this.email = email;
        this.discapacitado = discapacitado;
        this.fisExpPasaporte = fisExpPasaporte;
        this.fisVencPasaporte = fisVencPasaporte;
        this.fisFechaNacimiento = fisFechaNacimiento;
    }

    public int getCodPersona() {
        return numero;
    }

    public void setCodPersona(int numero) {
        this.numero = numero;
    }

    public String getDocumentoNumero() {
        return documentoNumero;
    }

    public void setDocumentoNumero(String documentoNumero) {
        this.documentoNumero = documentoNumero;
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

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
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

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }

    public String getSexoHombre() {
        return SexoHombre;
    }

    public void setSexoHombre(String SexoHombre) {
        this.SexoHombre = SexoHombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
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

    public Date getFisExpPasaporte() {
        return fisExpPasaporte;
    }

    public void setFisExpPasaporte(Date fisExpPasaporte) {
        this.fisExpPasaporte = fisExpPasaporte;
    }

    public Date getFisVencPasaporte() {
        return fisVencPasaporte;
    }

    public void setFisVencPasaporte(Date fisVencPasaporte) {
        this.fisVencPasaporte = fisVencPasaporte;
    }

    public Date getFisFechaNacimiento() {
        return fisFechaNacimiento;
    }

    public void setFisFechaNacimiento(Date fisFechaNacimiento) {
        this.fisFechaNacimiento = fisFechaNacimiento;
    }

}
