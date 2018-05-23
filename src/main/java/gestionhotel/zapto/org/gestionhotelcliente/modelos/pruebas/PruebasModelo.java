package gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersonaId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class PruebasModelo {

    public static final ObservableList<DetallesReserva> getListaDeAlojamientos() {
        ObservableList<DetallesReserva> listaAlojamientos = FXCollections.observableArrayList();

        DetallesReserva alojamiento1 = new DetallesReserva();
        alojamiento1.setIdDetallesReserva(1);
        alojamiento1.setTipoCama("Doble");
        alojamiento1.setPension("Alo y Des");
        alojamiento1.setNombreReserva("nombre1");
        alojamiento1.setFechaEntradaPrevista(new Date(116, 05, 11));
        alojamiento1.setFechaSalidaPrevista(new Date(135, 07, 11));
        alojamiento1.setReserva(getListaReservas().get(0));
        alojamiento1.setHabitacion(getListaHabitaciones().get(0));

        alojamiento1.setCuna(Byte.parseByte("0"));
        alojamiento1.setCamaExtra(Byte.parseByte("0"));
        alojamiento1.setNumeroAdultos(2);
        alojamiento1.setNumeroBebes(2);
        alojamiento1.setNumeroChild(3);
        alojamiento1.setPreferenciaHabitacion("1");
        alojamiento1.setPreferenciaTurnoRestaurante("Primero");
        alojamiento1.setPreferenciaTipoCama("Doble");
        alojamiento1.setPreferenciaTipoHabitacion("Suite");
        alojamiento1.setPreferenciaTipoRestaurante("Mexicano");
        alojamiento1.setPreferenciaVistas("Mar");

        DetallesReserva alojamiento2 = new DetallesReserva();
        alojamiento2.setIdDetallesReserva(2);
        alojamiento2.setTipoCama("Individual");
        alojamiento2.setPension("Completa");
        alojamiento2.setNombreReserva("nombre2");
        alojamiento2.setFechaEntradaPrevista(new Date(105, 04, 11));
        alojamiento2.setFechaSalidaPrevista(new Date(145, 12, 11));
        alojamiento2.setReserva(getListaReservas().get(1));
        alojamiento2.setHabitacion(getListaHabitaciones().get(3));

        alojamiento2.setCuna(Byte.parseByte("0"));
        alojamiento2.setCamaExtra(Byte.parseByte("0"));
        alojamiento2.setNumeroAdultos(2);
        alojamiento2.setNumeroBebes(2);
        alojamiento2.setNumeroChild(3);
        alojamiento2.setPreferenciaHabitacion("1");
        alojamiento2.setPreferenciaTurnoRestaurante("Segundo");
        alojamiento2.setPreferenciaTipoCama("Doble");
        alojamiento2.setPreferenciaTipoHabitacion("Suite");
        alojamiento2.setPreferenciaTipoRestaurante("Mexicano");
        alojamiento2.setPreferenciaVistas("Mar");

        DetallesReserva alojamiento3 = new DetallesReserva();
        alojamiento3.setIdDetallesReserva(3);
        alojamiento3.setTipoCama("Doble");
        alojamiento3.setPension("Alo y Des");
        alojamiento3.setNombreReserva("nombre3");
        alojamiento3.setFechaEntradaPrevista(new Date(118, 05, 10));
        alojamiento3.setFechaSalidaPrevista(new Date(119, 06, 11));
        alojamiento3.setReserva(getListaReservas().get(2));
        alojamiento3.setHabitacion(getListaHabitaciones().get(3));

        alojamiento3.setCuna(Byte.parseByte("0"));
        alojamiento3.setCamaExtra(Byte.parseByte("0"));
        alojamiento3.setNumeroAdultos(2);
        alojamiento3.setNumeroBebes(2);
        alojamiento3.setNumeroChild(3);
        alojamiento3.setPreferenciaHabitacion("1");
        alojamiento3.setPreferenciaTurnoRestaurante("Primero");
        alojamiento3.setPreferenciaTipoCama("Doble");
        alojamiento3.setPreferenciaTipoHabitacion("Suite");
        alojamiento3.setPreferenciaTipoRestaurante("Mexicano");
        alojamiento3.setPreferenciaVistas("Mar");

        DetallesReserva alojamiento4 = new DetallesReserva();
        alojamiento4.setIdDetallesReserva(4);
        alojamiento4.setTipoCama("Doble");
        alojamiento4.setPension("M.P");
        alojamiento4.setNombreReserva("nombre4");
        alojamiento4.setFechaEntradaPrevista(new Date(114, 06, 11));
        alojamiento4.setFechaSalidaPrevista(new Date(120, 07, 11));
        alojamiento4.setReserva(getListaReservas().get(3));
        alojamiento4.setHabitacion(getListaHabitaciones().get(2));

        alojamiento4.setCuna(Byte.parseByte("0"));
        alojamiento4.setCamaExtra(Byte.parseByte("0"));
        alojamiento4.setNumeroAdultos(3);
        alojamiento4.setNumeroBebes(0);
        alojamiento4.setNumeroChild(1);
        alojamiento4.setPreferenciaHabitacion("143");
        alojamiento4.setPreferenciaTurnoRestaurante("Segundo");
        alojamiento4.setPreferenciaTipoCama("Individual");
        alojamiento4.setPreferenciaTipoHabitacion("Suite");
        alojamiento4.setPreferenciaTipoRestaurante("Tailandes");
        alojamiento4.setPreferenciaVistas("Piscina");

        listaAlojamientos.add(alojamiento1);
        listaAlojamientos.add(alojamiento2);
        listaAlojamientos.add(alojamiento3);
        listaAlojamientos.add(alojamiento4);
        return listaAlojamientos;
    }

    public static final ObservableList<Reserva> getListaReservas() {

        ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();
        Reserva reserva1 = new Reserva();
        reserva1.setCodReserva(1);
        reserva1.setFecha(new Date(117, 05, 11));
        reserva1.setComentario("una reserva cualquiera");
        reserva1.setNumero("1");
        reserva1.setNumeroTarjetaCredito("4532544");
        reserva1.setVoucher("voucher11");
        reserva1.setTipoTarjetaCredito("Visa");
        reserva1.setPersonaByCodCliente(getListaDeClientes().get(1));
        reserva1.setPersonaByAgencia(getListaDeClientes().get(2));

        Reserva reserva2 = new Reserva();
        reserva2.setCodReserva(2);
        reserva2.setFecha(new Date(117, 05, 10));
        reserva2.setComentario("una reserva cualquiera");
        reserva2.setNumero("2");
        reserva2.setNumeroTarjetaCredito("r3ewf3");
        reserva2.setVoucher("voucher22");
        reserva2.setTipoTarjetaCredito("Master card");
        reserva2.setPersonaByCodCliente(getListaDeClientes().get(1));
        reserva2.setPersonaByAgencia(getListaDeClientes().get(3));

        Reserva reserva3 = new Reserva();
        reserva3.setCodReserva(3);
        reserva3.setFecha(new Date(117, 05, 15));
        reserva3.setComentario("una reserva cualquiera");
        reserva3.setNumero("3");
        reserva3.setNumeroTarjetaCredito("3444");
        reserva3.setVoucher("4335");
        reserva3.setTipoTarjetaCredito("Visa");
        reserva3.setPersonaByCodCliente(getListaDeHuespedes().get(1));
        reserva3.setPersonaByAgencia(getListaDeClientes().get(2));

        Reserva reserva4 = new Reserva();
        reserva4.setCodReserva(4);
        reserva4.setFecha(new Date(117, 05, 05));
        reserva4.setComentario("una reserva cualquiera");
        reserva4.setNumero("1");
        reserva4.setNumeroTarjetaCredito("re543345");
        reserva4.setVoucher("voucher44");
        reserva4.setTipoTarjetaCredito("Visa");
        reserva4.setPersonaByCodCliente(getListaDeHuespedes().get(0));
        reserva4.setPersonaByAgencia(getListaDeClientes().get(3));

        listaReservas.add(reserva1);
        listaReservas.add(reserva2);
        listaReservas.add(reserva3);
        listaReservas.add(reserva4);

        return listaReservas;
    }

    public static final ObservableList<Persona> getListaDeClientes() {

        ObservableList<Persona> listaClientes = FXCollections.observableArrayList();
        Persona persona1 = new Persona();
        persona1.setCodPersona(5);
        persona1.setNombre("Florentino");
        persona1.setFisPrimerApellido("Perez");
        persona1.setFisSegundoApellido("Dinero");
        persona1.setFisFechaNacimiento(new Date(55, 05, 04));
        persona1.setFisSexoHombre(Byte.parseByte("1"));
        persona1.setFisDiscapacitado(Byte.parseByte("0"));
        persona1.setFisNacionalidad("España");
        persona1.setProvincia("Madrid");
        persona1.setCiudad("Madrid");
        persona1.setCalle("dinero");
        persona1.setNumero("100");
        persona1.setCodPostal("34433");
        persona1.setDocumentoNumero("742573239m");
        persona1.setCategoria("Especial");
        persona1.setPaginaWeb("wwww.soyrico.com");
        persona1.setEmail("soyrico@gmail.com");
        persona1.setFisTratamiento("Sr/Sra");
        persona1.setComentario("Una persona rica");
        persona1.setEsEmpresa(Byte.parseByte("0"));

        Persona persona2 = new Persona();
        persona2.setCodPersona(6);
        persona2.setNombre("Joan");
        persona2.setFisPrimerApellido("Gaspar");
        persona2.setFisSegundoApellido("Flipao");
        persona2.setFisFechaNacimiento(new Date(34, 8, 07));
        persona2.setFisSexoHombre(Byte.parseByte("1"));
        persona2.setFisDiscapacitado(Byte.parseByte("0"));
        persona2.setFisNacionalidad("España");
        persona2.setProvincia("Barcelona");
        persona2.setCiudad("Tabarnia");
        persona2.setCalle("catalanes");
        persona2.setNumero("10");
        persona2.setCodPostal("345532");
        persona2.setDocumentoNumero("72354353m");
        persona2.setCategoria("Especial");
        persona2.setPaginaWeb("wwww.soyunflipao.com");
        persona2.setEmail("soyunflipao@gmail.com");
        persona2.setFisTratamiento("Sr/Sra");
        persona2.setComentario("Una persona especial");
        persona2.setEsCliente(Byte.parseByte("1"));
        persona2.setEstado("España");
        persona2.setEsEmpresa(Byte.parseByte("0"));

        Persona persona3 = new Persona();
        persona3.setCodPersona(7);
        persona3.setNombre("Acs");
        persona3.setJurNombreComercial("Acs internacional");
        persona3.setJurRazonSocial("S.A");
        persona3.setProvincia("Madrid");
        persona3.setCiudad("Madrid");
        persona3.setCalle("Gran via");
        persona3.setNumero("23");
        persona3.setCodPostal("33632");
        persona3.setDocumentoNumero("cif33322");
        persona3.setCategoria("Especial");
        persona3.setPaginaWeb("wwww.acs.com");
        persona3.setEmail("acs@gmail.com");
        persona3.setComentario("multinacinal");
        persona3.setEsCliente(Byte.parseByte("1"));
        persona3.setEstado("España");
        persona3.setEsEmpresa(Byte.parseByte("1"));

        Persona persona4 = new Persona();
        persona4.setCodPersona(8);
        persona4.setNombre("Iberdrola");
        persona4.setJurRazonSocial("S.A");
        persona4.setJurNombreComercial("Iberdrola Spain");
        persona4.setProvincia("Barcelona");
        persona4.setCiudad("Barcelona");
        persona4.setCalle("Las ramblas");
        persona4.setNumero("33");
        persona4.setCodPostal("334455");
        persona4.setDocumentoNumero("cif34355");
        persona4.setCategoria("Especial");
        persona4.setPaginaWeb("wwww.Iberdrola.com");
        persona4.setEmail("iberdrola@gmail.com");
        persona4.setComentario("Renovables");
        persona4.setEsCliente(Byte.parseByte("1"));
        persona4.setEstado("España");
        persona4.setEsEmpresa(Byte.parseByte("1"));

        listaClientes.add(persona1);
        listaClientes.add(persona2);
        listaClientes.add(persona3);
        listaClientes.add(persona4);
        return listaClientes;
    }

    public static final ObservableList<Persona> getListaDeHuespedes() {

        ObservableList<Persona> listaHuespedes = FXCollections.observableArrayList();
        Persona persona1 = new Persona();
        persona1.setCodPersona(1);
        persona1.setNombre("Antonio Jesús");
        persona1.setFisPrimerApellido("Perez Delgado");
        persona1.setFisSegundoApellido("Delgado");
        persona1.setFisFechaNacimiento(new Date(85, 12, 25));
        persona1.setFisSexoHombre(Byte.parseByte("1"));
        persona1.setFisDiscapacitado(Byte.parseByte("0"));
        persona1.setFisNacionalidad("España");
        persona1.setProvincia("Santa cruz de Tenerife");
        persona1.setCiudad("Icod de los vinos");
        persona1.setCalle("penichet");
        persona1.setNumero("14");
        persona1.setCodPostal("38430");
        persona1.setDocumentoNumero("78633049m");
        persona1.setPasaporte("pas333");
        persona1.setFisExpPasaporte(new Date(0, 11, 23));
        persona1.setCategoria("Especial");
        persona1.setPaginaWeb("wwww.soyunmaquina.com");
        persona1.setEmail("soyunmaquina@gmail.com");
        persona1.setFisTratamiento("Sr/Sra");
        persona1.setEstado("España");
        persona1.setComentario("Una persona especial");
        persona1.setEsEmpresa(Byte.parseByte("0"));

        Persona persona2 = new Persona();
        persona2.setCodPersona(2);
        persona2.setNombre("Sergia");
        persona2.setFisPrimerApellido("Vidal");
        persona2.setFisSegundoApellido("Castellano");
        persona2.setFisFechaNacimiento(new Date(79, 04, 12));
        persona2.setFisSexoHombre(Byte.parseByte("0"));
        persona2.setFisDiscapacitado(Byte.parseByte("0"));
        persona2.setFisNacionalidad("Marruecos");
        persona2.setProvincia("Rabat");
        persona2.setCiudad("Ala es grande");
        persona2.setCalle("asereje");
        persona2.setNumero("43");
        persona2.setCodPostal("304d3v");
        persona2.setDocumentoNumero("78422449m");
        persona2.setPasaporte("pas344");
        persona2.setFisExpPasaporte(new Date(99, 12, 29));
        persona2.setCategoria("Especial");
        persona2.setPaginaWeb("wwww.soyungay.com");
        persona2.setEmail("soyungay@gmail.com");
        persona2.setFisTratamiento("Sr/Sra");
        persona2.setEstado("España");
        persona2.setComentario("Una persona gay");
        persona2.setEsEmpresa(Byte.parseByte("0"));

        Persona persona3 = new Persona();
        persona3.setCodPersona(3);
        persona3.setNombre("Marcos");
        persona3.setFisPrimerApellido("Tabaiba");
        persona3.setFisSegundoApellido("Seca");
        persona3.setFisFechaNacimiento(new Date(40, 03, 03));
        persona3.setFisSexoHombre(Byte.parseByte("0"));
        persona3.setFisDiscapacitado(Byte.parseByte("0"));
        persona3.setFisNacionalidad("Marruecos");
        persona3.setProvincia("ala akbar");
        persona3.setCiudad("bomba");
        persona3.setCalle("bomba lapa");
        persona3.setNumero("2");
        persona3.setCodPostal("ert3");
        persona3.setDocumentoNumero("78e3s29m");
        persona3.setPasaporte("pas333");
        persona3.setFisExpPasaporte(new Date(2, 05, 12));
        persona3.setCategoria("Especial");
        persona3.setPaginaWeb("wwww.soyuntranque.com");
        persona3.setEmail("soyuntranque@gmail.com");
        persona3.setFisTratamiento("Sr/Sra");
        persona3.setEstado("España");
        persona3.setComentario("Una persona con diversidad funcional");
        persona3.setEsEmpresa(Byte.parseByte("0"));

        Persona persona4 = new Persona();
        persona4.setCodPersona(4);
        persona4.setNombre("Samuel");
        persona4.setFisPrimerApellido("Etoo");
        persona4.setFisSegundoApellido("n´jalmo");
        persona4.setFisFechaNacimiento(new Date(59, 12, 22));
        persona4.setFisSexoHombre(Byte.parseByte("1"));
        persona4.setFisDiscapacitado(Byte.parseByte("0"));
        persona4.setFisNacionalidad("Camerùn");
        persona4.setProvincia("Hambre");
        persona4.setCiudad("guerra");
        persona4.setCalle("penurias");
        persona4.setNumero("19");
        persona4.setCodPostal("384e23");
        persona4.setDocumentoNumero("23dss39m");
        persona4.setPasaporte("pas345cdsd");
        persona4.setFisExpPasaporte(new Date(0, 06, 21));
        persona4.setCategoria("Especial");
        persona4.setPaginaWeb("wwww.soyunnegro.com");
        persona4.setEmail("soyunnegro@gmail.com");
        persona4.setFisTratamiento("Sr/Sra");
        persona4.setEstado("España");
        persona4.setComentario("Una persona especial");
        persona4.setEsEmpresa(Byte.parseByte("0"));

        listaHuespedes.add(persona1);
        listaHuespedes.add(persona2);
        listaHuespedes.add(persona3);
        listaHuespedes.add(persona4);

        return listaHuespedes;
    }

    public static ObservableList<Habitacion> getListaHabitaciones() {
        ObservableList<Habitacion> listaHabitaciones = FXCollections.observableArrayList();
        Habitacion hab1 = new Habitacion();
        hab1.setCamaExtra(Byte.parseByte("1"));
        hab1.setDescripcion("vista piscina");
        hab1.setTipo("Doble superior");
        hab1.setNumero(1);

        Habitacion hab2 = new Habitacion();
        hab2.setCamaExtra(Byte.parseByte("1"));
        hab2.setDescripcion("vista interior");
        hab2.setTipo("Normal");
        hab2.setNumero(2);

        Habitacion hab3 = new Habitacion();
        hab3.setCamaExtra(Byte.parseByte("0"));
        hab3.setDescripcion("vista mar");
        hab3.setTipo("Suite");
        hab3.setNumero(3);

        Habitacion hab4 = new Habitacion();
        hab4.setCamaExtra(Byte.parseByte("0"));
        hab4.setDescripcion("vista montaña");
        hab4.setTipo("Suite");
        hab4.setNumero(4);

        listaHabitaciones.add(hab1);
        listaHabitaciones.add(hab2);
        listaHabitaciones.add(hab3);
        listaHabitaciones.add(hab4);

        return listaHabitaciones;
    }

    public static ObservableList<TelefonoPersona> getLisTelefono() {
        ObservableList<TelefonoPersona> listaTelefonos = FXCollections.observableArrayList();
        TelefonoPersona telefono1 = new TelefonoPersona();
        telefono1.setId(new TelefonoPersonaId(1, "9228154732"));
        telefono1.setDescripcion("una descripcion normal");

        TelefonoPersona telefono2 = new TelefonoPersona();
        telefono2.setId(new TelefonoPersonaId(1, "922342345"));
        telefono2.setDescripcion("una descripcion especial");

        TelefonoPersona telefono3 = new TelefonoPersona();
        telefono3.setId(new TelefonoPersonaId(2, "922452235"));
        telefono3.setDescripcion("una descripcion cualquiera");

        TelefonoPersona telefono4 = new TelefonoPersona();
        telefono3.setId(new TelefonoPersonaId(3, "922543267"));
        telefono3.setDescripcion("una descripcion a secas");

        TelefonoPersona telefono5 = new TelefonoPersona();
        telefono3.setId(new TelefonoPersonaId(4, "922543267"));
        telefono3.setDescripcion("una descripcion a secas");

        TelefonoPersona telefono6 = new TelefonoPersona();
        telefono3.setId(new TelefonoPersonaId(5, "63363232325"));
        telefono3.setDescripcion("una descripcion");

        TelefonoPersona telefono7 = new TelefonoPersona();
        telefono3.setId(new TelefonoPersonaId(4, "92436879"));
        telefono3.setDescripcion("describiendo");

        listaTelefonos.add(telefono1);
        listaTelefonos.add(telefono2);
        listaTelefonos.add(telefono3);
        listaTelefonos.add(telefono4);
        listaTelefonos.add(telefono5);
        listaTelefonos.add(telefono6);
        listaTelefonos.add(telefono7);
        return listaTelefonos;
    }
}
