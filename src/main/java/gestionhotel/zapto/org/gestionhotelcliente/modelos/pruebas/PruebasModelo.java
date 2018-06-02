package gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.HuespedHabitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersonaId;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Usuario;
import java.time.Instant;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class PruebasModelo {

    private static ObservableList<Persona> listaHuespedesDentro = null;
    private static ObservableList<Persona> listaHuespedesFuera = null;
    private static ObservableList<DetallesReserva> listaAlojamientos = null;
    private static ObservableList<Reserva> listaReservas = null;
    private static ObservableList<Persona> listaClientes = null;
    private static ObservableList<Persona> listaHuespedes = null;
    private static ObservableList<Habitacion> listaHabitaciones = null;
    private static ObservableList<HuespedHabitacion> listaHuespedHabitacion = null;
    private static ObservableList<TelefonoPersonaId> listaTelefonoIds = null;
    private static ObservableList<TelefonoPersona> listaTelefonoPersona = null;
    private static ObservableList<Usuario> listaUsuario = null;

    public static ObservableList<DetallesReserva> getListaDeAlojamientos() {
        if (listaAlojamientos == null) {

            listaAlojamientos = FXCollections.observableArrayList();
            DetallesReserva alojamiento1 = new DetallesReserva();
            alojamiento1.setIdDetallesReserva(1);
            alojamiento1.setTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento1.setPension(Registro.ListaPension.get(3));
            alojamiento1.setNombreReserva("nombre1");
            alojamiento1.setFechaEntradaPrevista(new Date(116, 05, 11));
            alojamiento1.setFechaSalidaPrevista(new Date(135, 07, 11));
            alojamiento1.setReserva(getListaDeReservas().get(0));
            alojamiento1.setHabitacion(getListaDeHabitaciones().get(0));
            alojamiento1.setComentario("comentario alojamiento 1");

            alojamiento1.setCuna(Byte.parseByte("0"));
            alojamiento1.setCamaExtra(Byte.parseByte("0"));
            alojamiento1.setNumeroAdultos(2);
            alojamiento1.setNumeroBebes(2);
            alojamiento1.setNumeroChild(3);
            alojamiento1.setPreferenciaHabitacion(Registro.ListaNumeroHabitacion.get(1));
            alojamiento1.setPreferenciaTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento1.setPreferenciaTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento1.setPreferenciaTipoHabitacion(Registro.ListaTipoHabitacion.get(3));
            alojamiento1.setPreferenciaTipoRestaurante(Registro.ListaTipoRestaurante.get(2));
            alojamiento1.setPreferenciaVistas(Registro.ListaVistas.get(3));

            DetallesReserva alojamiento2 = new DetallesReserva();
            alojamiento2.setIdDetallesReserva(2);
            alojamiento2.setTipoCama(Registro.ListaTipoCama.get(2));
            alojamiento2.setPension(Registro.ListaPension.get(3));
            alojamiento2.setNombreReserva("nombre2");
            alojamiento2.setFechaEntradaPrevista(new Date(105, 04, 11));
            alojamiento2.setFechaSalidaPrevista(new Date(145, 12, 11));
            alojamiento2.setReserva(getListaDeReservas().get(1));
            alojamiento2.setHabitacion(getListaDeHabitaciones().get(3));

            alojamiento2.setCuna(Byte.parseByte("0"));
            alojamiento2.setCamaExtra(Byte.parseByte("0"));
            alojamiento2.setNumeroAdultos(2);
            alojamiento2.setNumeroBebes(2);
            alojamiento2.setNumeroChild(3);
            alojamiento2.setPreferenciaHabitacion(Registro.ListaNumeroHabitacion.get(2));
            alojamiento2.setPreferenciaTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento2.setPreferenciaTipoCama(Registro.ListaTipoCama.get(2));
            alojamiento2.setPreferenciaTipoHabitacion(Registro.ListaTipoHabitacion.get(3));
            alojamiento2.setPreferenciaTipoRestaurante(Registro.ListaTipoRestaurante.get(3));
            alojamiento2.setPreferenciaVistas(Registro.ListaVistas.get(3));
            alojamiento2.setComentario("comentario alojamiento 2");

            DetallesReserva alojamiento3 = new DetallesReserva();
            alojamiento3.setIdDetallesReserva(3);
            alojamiento3.setTipoCama(Registro.ListaTipoCama.get(3));
            alojamiento3.setPension(Registro.ListaPension.get(2));
            alojamiento3.setNombreReserva("nombre3");
            alojamiento3.setFechaEntradaPrevista(new Date(118, 05, 10));
            alojamiento3.setFechaSalidaPrevista(new Date(119, 06, 11));
            alojamiento3.setReserva(getListaDeReservas().get(2));
            alojamiento3.setHabitacion(getListaDeHabitaciones().get(3));

            alojamiento3.setCuna(Byte.parseByte("0"));
            alojamiento3.setCamaExtra(Byte.parseByte("0"));
            alojamiento3.setNumeroAdultos(2);
            alojamiento3.setNumeroBebes(2);
            alojamiento3.setNumeroChild(3);
            alojamiento3.setPreferenciaHabitacion(Registro.ListaNumeroHabitacion.get(3));
            alojamiento3.setPreferenciaTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento3.setPreferenciaTipoCama(Registro.ListaTipoCama.get(4));
            alojamiento3.setPreferenciaTipoHabitacion(Registro.ListaTipoHabitacion.get(1));
            alojamiento3.setPreferenciaTipoRestaurante(Registro.ListaTipoRestaurante.get(4));
            alojamiento3.setPreferenciaVistas(Registro.ListaVistas.get(1));
            alojamiento3.setComentario("comentario alojamiento 2");

            DetallesReserva alojamiento4 = new DetallesReserva();
            alojamiento4.setIdDetallesReserva(4);
            alojamiento4.setTipoCama(Registro.ListaTipoCama.get(4));
            alojamiento4.setPension(Registro.ListaPension.get(1));
            alojamiento4.setNombreReserva("nombre4");
            alojamiento4.setFechaEntradaPrevista(new Date(114, 06, 11));
            alojamiento4.setFechaSalidaPrevista(new Date(120, 07, 11));
            alojamiento4.setReserva(getListaDeReservas().get(3));
            alojamiento4.setHabitacion(getListaDeHabitaciones().get(2));

            alojamiento4.setCuna(Byte.parseByte("0"));
            alojamiento4.setCamaExtra(Byte.parseByte("0"));
            alojamiento4.setNumeroAdultos(3);
            alojamiento4.setNumeroBebes(0);
            alojamiento4.setNumeroChild(1);
            alojamiento4.setPreferenciaHabitacion(Registro.ListaNumeroHabitacion.get(4));
            alojamiento4.setPreferenciaTurnoRestaurante(Registro.ListaTurnoRestaurante.get(1));
            alojamiento4.setPreferenciaTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento4.setPreferenciaTipoHabitacion(Registro.ListaTipoHabitacion.get(2));
            alojamiento4.setPreferenciaTipoRestaurante(Registro.ListaTipoRestaurante.get(3));
            alojamiento4.setPreferenciaVistas(Registro.ListaVistas.get(2));
            alojamiento4.setComentario("comentario alojamiento 2");

            listaAlojamientos.add(alojamiento1);
            listaAlojamientos.add(alojamiento2);
            listaAlojamientos.add(alojamiento3);
            listaAlojamientos.add(alojamiento4);
        }
        return listaAlojamientos;
    }

    public static ObservableList<Reserva> getListaDeReservas() {
        if (listaReservas == null) {
            listaReservas = FXCollections.observableArrayList();
            Reserva reserva1 = new Reserva();
            reserva1.setCodReserva(1);
            reserva1.setFecha(new Date(117, 05, 11));
            reserva1.setComentario("una reserva cualquiera");
            reserva1.setNumero("1");
            reserva1.setNumeroTarjetaCredito("4532544");
            reserva1.setVoucher("voucher11");
            reserva1.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(4));
            reserva1.setPersonaByCodCliente(getListaDeClientes().get(1));
            reserva1.setPersonaByAgencia(getListaDeClientes().get(2));

            Reserva reserva2 = new Reserva();
            reserva2.setCodReserva(2);
            reserva2.setFecha(new Date(117, 05, 10));
            reserva2.setComentario("una reserva cualquiera");
            reserva2.setNumero("2");
            reserva2.setNumeroTarjetaCredito("r3ewf3");
            reserva2.setVoucher("voucher22");
            reserva2.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(3));
            reserva2.setPersonaByCodCliente(getListaDeClientes().get(1));
            reserva2.setPersonaByAgencia(getListaDeClientes().get(3));

            Reserva reserva3 = new Reserva();
            reserva3.setCodReserva(3);
            reserva3.setFecha(new Date(117, 05, 15));
            reserva3.setComentario("una reserva cualquiera");
            reserva3.setNumero("3");
            reserva3.setNumeroTarjetaCredito("3444");
            reserva3.setVoucher("4335");
            reserva3.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(2));
            reserva3.setPersonaByCodCliente(getListaDeHuespedes().get(1));
            reserva3.setPersonaByAgencia(getListaDeClientes().get(2));

            Reserva reserva4 = new Reserva();
            reserva4.setCodReserva(4);
            reserva4.setFecha(new Date(117, 05, 05));
            reserva4.setComentario("una reserva cualquiera");
            reserva4.setNumero("1");
            reserva4.setNumeroTarjetaCredito("re543345");
            reserva4.setVoucher("voucher44");
            reserva4.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(1));
            reserva4.setPersonaByCodCliente(getListaDeHuespedes().get(0));
            reserva4.setPersonaByAgencia(getListaDeClientes().get(3));

            listaReservas.add(reserva1);
            listaReservas.add(reserva2);
            listaReservas.add(reserva3);
            listaReservas.add(reserva4);
        }
        return listaReservas;
    }

    public static ObservableList<Persona> getListaDeClientes() {
        if (listaClientes == null) {
            listaClientes = FXCollections.observableArrayList();
            Persona persona1 = new Persona();
            persona1.setCodPersona(5);
            persona1.setNombre("Florentino");
            persona1.setFisPrimerApellido("Perez");
            persona1.setFisSegundoApellido("Dinero");
            persona1.setFisFechaNacimiento(new Date(55, 05, 04));
            persona1.setFisSexoHombre(Byte.parseByte("1"));
            persona1.setFisDiscapacitado(Byte.parseByte("0"));
            persona1.setFisNacionalidad(Registro.listaPaises.get(14));
            persona1.setProvincia("Madrid");
            persona1.setCiudad("Madrid");
            persona1.setCalle("dinero");
            persona1.setNumero("100");
            persona1.setCodPostal("34433");
            persona1.setDocumentoNumero("742573239m");
            persona1.setCategoria(Registro.ListaCategoriaCliente.get(1));
            persona1.setPaginaWeb("wwww.soyrico.com");
            persona1.setEmail("soyrico@gmail.com");
            persona1.setFisTratamiento(Registro.ListaTratamiento.get(4));
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
            persona2.setCategoria(Registro.ListaCategoriaCliente.get(4));
            persona2.setPaginaWeb("wwww.soyunflipao.com");
            persona2.setEmail("soyunflipao@gmail.com");
            persona2.setFisTratamiento(Registro.ListaTratamiento.get(3));
            persona2.setComentario("Una persona especial");
            persona2.setEsCliente(Byte.parseByte("1"));
            persona2.setEstado(Registro.listaPaises.get(23));
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
            persona3.setCategoria(Registro.ListaCategoriaCliente.get(2));
            persona3.setPaginaWeb("wwww.acs.com");
            persona3.setEmail("acs@gmail.com");
            persona3.setComentario("multinacinal");
            persona3.setEsCliente(Byte.parseByte("1"));
            persona3.setEstado(Registro.listaPaises.get(76));
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
            persona4.setCategoria(Registro.ListaCategoriaCliente.get(3));
            persona4.setPaginaWeb("wwww.Iberdrola.com");
            persona4.setEmail("iberdrola@gmail.com");
            persona4.setComentario("Renovables");
            persona4.setEsCliente(Byte.parseByte("1"));
            persona4.setEstado(Registro.listaPaises.get(86));
            persona4.setEsEmpresa(Byte.parseByte("1"));

            listaClientes.add(persona1);
            listaClientes.add(persona2);
            listaClientes.add(persona3);
            listaClientes.add(persona4);
        }
        return listaClientes;
    }

    public static ObservableList<Persona> getListaDeHuespedes() {
        if (listaHuespedes == null) {
            synchronized (new Object()) {
                if (listaHuespedes == null) {
                    listaHuespedes = FXCollections.observableArrayList();
                    Persona persona1 = new Persona();
                    persona1.setCodPersona(1);
                    persona1.setNombre("Antonio Jesús");
                    persona1.setFisPrimerApellido("Perez Delgado");
                    persona1.setFisSegundoApellido("Delgado");
                    persona1.setFisFechaNacimiento(new Date(85, 12, 25));
                    persona1.setFisSexoHombre(Byte.parseByte("1"));
                    persona1.setFisDiscapacitado(Byte.parseByte("0"));
                    persona1.setFisNacionalidad(Registro.listaPaises.get(1));
                    persona1.setProvincia("Santa cruz de Tenerife");
                    persona1.setCiudad("Icod de los vinos");
                    persona1.setCalle("penichet");
                    persona1.setNumero("14");
                    persona1.setCodPostal("38430");
                    persona1.setDocumentoNumero("78633049m");
                    persona1.setPasaporte("pas333");
                    persona1.setFisExpPasaporte(new Date(0, 11, 23));
                    persona1.setCategoria(Registro.listaCategoriaHuesped.get(3));
                    persona1.setPaginaWeb("wwww.soyunmaquina.com");
                    persona1.setEmail("soyunmaquina@gmail.com");
                    persona1.setFisTratamiento(Registro.ListaTratamiento.get(1));
                    persona1.setEstado(Registro.listaPaises.get(1));
                    persona1.setComentario("Una persona especial");
                    persona1.setEsEmpresa(Byte.parseByte("0"));
                    persona1.setDentro(Byte.parseByte("0"));

                    Persona persona2 = new Persona();
                    persona2.setCodPersona(2);
                    persona2.setNombre("Sergia");
                    persona2.setFisPrimerApellido("Vidal");
                    persona2.setFisSegundoApellido("Castellano");
                    persona2.setFisFechaNacimiento(new Date(79, 04, 12));
                    persona2.setFisSexoHombre(Byte.parseByte("0"));
                    persona2.setFisDiscapacitado(Byte.parseByte("0"));
                    persona2.setFisNacionalidad(Registro.listaPaises.get(54));
                    persona2.setProvincia("Rabat");
                    persona2.setCiudad("Ala es grande");
                    persona2.setCalle("asereje");
                    persona2.setNumero("43");
                    persona2.setCodPostal("304d3v");
                    persona2.setDocumentoNumero("78422449m");
                    persona2.setPasaporte("pas344");
                    persona2.setFisExpPasaporte(new Date(99, 12, 29));
                    persona2.setCategoria(Registro.listaCategoriaHuesped.get(2));
                    persona2.setPaginaWeb("wwww.soyungay.com");
                    persona2.setEmail("soyungay@gmail.com");
                    persona2.setFisTratamiento(Registro.ListaTratamiento.get(2));
                    persona2.setEstado(Registro.listaPaises.get(49));
                    persona2.setComentario("Una persona gay");
                    persona2.setEsEmpresa(Byte.parseByte("0"));
                    persona2.setDentro(Byte.parseByte("0"));

                    Persona persona3 = new Persona();
                    persona3.setCodPersona(3);
                    persona3.setNombre("Marcos");
                    persona3.setFisPrimerApellido("Tabaiba");
                    persona3.setFisSegundoApellido("Seca");
                    persona3.setFisFechaNacimiento(new Date(40, 03, 03));
                    persona3.setFisSexoHombre(Byte.parseByte("0"));
                    persona3.setFisDiscapacitado(Byte.parseByte("0"));
                    persona3.setFisNacionalidad(Registro.listaPaises.get(14));
                    persona3.setProvincia("ala akbar");
                    persona3.setCiudad("bomba");
                    persona3.setCalle("bomba lapa");
                    persona3.setNumero("2");
                    persona3.setCodPostal("ert3");
                    persona3.setDocumentoNumero("78e3s29m");
                    persona3.setPasaporte("pas333");
                    persona3.setFisExpPasaporte(new Date(2, 05, 12));
                    persona3.setCategoria(Registro.listaCategoriaHuesped.get(4));
                    persona3.setPaginaWeb("wwww.soyuntranque.com");
                    persona3.setEmail("soyuntranque@gmail.com");
                    persona3.setFisTratamiento(Registro.ListaTratamiento.get(3));
                    persona3.setEstado(Registro.listaPaises.get(53));
                    persona3.setComentario("Una persona con diversidad funcional");
                    persona3.setEsEmpresa(Byte.parseByte("0"));
                    persona3.setDentro(Byte.parseByte("0"));

                    Persona persona4 = new Persona();
                    persona4.setCodPersona(4);
                    persona4.setNombre("Samuel");
                    persona4.setFisPrimerApellido("Etoo");
                    persona4.setFisSegundoApellido("n´jalmo");
                    persona4.setFisFechaNacimiento(new Date(59, 12, 22));
                    persona4.setFisSexoHombre(Byte.parseByte("1"));
                    persona4.setFisDiscapacitado(Byte.parseByte("0"));
                    persona4.setFisNacionalidad(Registro.listaPaises.get(100));
                    persona4.setProvincia("Hambre");
                    persona4.setCiudad("guerra");
                    persona4.setCalle("penurias");
                    persona4.setNumero("19");
                    persona4.setCodPostal("384e23");
                    persona4.setDocumentoNumero("23dss39m");
                    persona4.setPasaporte("pas345cdsd");
                    persona4.setFisExpPasaporte(new Date(0, 06, 21));
                    persona4.setCategoria(Registro.listaCategoriaHuesped.get(1));
                    persona4.setPaginaWeb("wwww.soyunnegro.com");
                    persona4.setEmail("soyunnegro@gmail.com");
                    persona4.setFisTratamiento(Registro.ListaTratamiento.get(4));
                    persona4.setEstado(Registro.listaPaises.get(1));
                    persona4.setComentario("Una persona especial");
                    persona4.setEsEmpresa(Byte.parseByte("0"));
                    persona4.setDentro(Byte.parseByte("0"));

                    listaHuespedes.add(persona1);
                    listaHuespedes.add(persona2);
                    listaHuespedes.add(persona3);
                    listaHuespedes.add(persona4);
                }
            }
        }
        return listaHuespedes;
    }

    public static ObservableList<Habitacion> getListaDeHabitaciones() {
        if (listaHabitaciones == null) {
            listaHabitaciones = FXCollections.observableArrayList();
            Habitacion hab1 = new Habitacion();
            hab1.setCamaExtra(Byte.parseByte("1"));
            hab1.setVistas(Registro.ListaVistas.get(1));
            hab1.setTipo(Registro.ListaTipoHabitacion.get(3));
            hab1.setNumero(Integer.parseInt(Registro.ListaNumeroHabitacion.get(4)));
            hab1.setTipoCama(Registro.ListaTipoCama.get(1));
            hab1.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab2 = new Habitacion();
            hab2.setCamaExtra(Byte.parseByte("1"));
            hab2.setVistas(Registro.ListaVistas.get(1));
            hab2.setTipo(Registro.ListaTipoHabitacion.get(2));
            hab2.setNumero(Integer.parseInt(Registro.ListaNumeroHabitacion.get(1)));
            hab2.setTipoCama(Registro.ListaTipoCama.get(2));
            hab2.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab3 = new Habitacion();
            hab3.setCamaExtra(Byte.parseByte("0"));
            hab3.setVistas(Registro.ListaVistas.get(2));
            hab3.setTipo(Registro.ListaTipoHabitacion.get(1));
            hab3.setNumero(Integer.parseInt(Registro.ListaNumeroHabitacion.get(3)));
            hab3.setTipoCama(Registro.ListaTipoCama.get(3));
            hab3.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab4 = new Habitacion();
            hab4.setCamaExtra(Byte.parseByte("0"));
            hab4.setVistas(Registro.ListaVistas.get(3));
            hab4.setTipo(Registro.ListaTipoHabitacion.get(4));
            hab4.setNumero(Integer.parseInt(Registro.ListaNumeroHabitacion.get(2)));
            hab4.setTipoCama(Registro.ListaTipoCama.get(1));
            hab4.setEstado(Registro.ListaEstadoHabitacion.get(2));

            listaHabitaciones.add(hab1);
            listaHabitaciones.add(hab2);
            listaHabitaciones.add(hab3);
            listaHabitaciones.add(hab4);
        }
        return listaHabitaciones;
    }

    public static ObservableList<TelefonoPersona> getListaDeTelefono() {
        if (listaTelefonoPersona == null) {
            listaTelefonoIds = FXCollections.observableArrayList();
            TelefonoPersona telefono1 = new TelefonoPersona();
            telefono1.setId(getListaDeTelefonoID().get(0));
            telefono1.setDescripcion("una descripcion normal");
            telefono1.setPersona(getListaDeHuespedes().get(1));
            telefono1.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono1.setComentario("comentario numero 1");

            TelefonoPersona telefono2 = new TelefonoPersona();
            telefono2.setId(getListaDeTelefonoID().get(1));
            telefono2.setDescripcion("una descripcion especial");
            telefono2.setPersona(getListaDeHuespedes().get(1));
            telefono2.setTipo(Registro.ListaTipoTelefono.get(2));
            telefono2.setComentario("comentario numero 2");

            TelefonoPersona telefono3 = new TelefonoPersona();
            telefono3.setId(getListaDeTelefonoID().get(2));
            telefono3.setDescripcion("una descripcion cualquiera");
            telefono3.setPersona(getListaDeHuespedes().get(2));
            telefono3.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono3.setComentario("comentario numero 3");

            TelefonoPersona telefono4 = new TelefonoPersona();
            telefono4.setId(getListaDeTelefonoID().get(3));
            telefono4.setDescripcion("una descripcion a secas");
            telefono4.setPersona(getListaDeHuespedes().get(3));
            telefono4.setTipo(Registro.ListaTipoTelefono.get(3));
            telefono4.setComentario("comentario numero 4");

            TelefonoPersona telefono5 = new TelefonoPersona();
            telefono5.setId(getListaDeTelefonoID().get(4));
            telefono5.setDescripcion("una descripcion 3");
            telefono5.setPersona(getListaDeClientes().get(0));
            telefono5.setTipo(Registro.ListaTipoTelefono.get(3));
            telefono5.setComentario("comentario numero 5");

            TelefonoPersona telefono6 = new TelefonoPersona();
            telefono6.setId(getListaDeTelefonoID().get(5));
            telefono6.setDescripcion("una descripcion");
            telefono6.setPersona(getListaDeClientes().get(1));
            telefono6.setTipo(Registro.ListaTipoTelefono.get(2));
            telefono6.setComentario("comentario numero 6");

            TelefonoPersona telefono7 = new TelefonoPersona();
            telefono7.setId(new TelefonoPersonaId(6, "92436879"));
            telefono7.setDescripcion("describiendo");
            telefono7.setPersona(getListaDeClientes().get(0));
            telefono7.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono7.setComentario("comentario numero 7");

            listaTelefonoPersona.add(telefono1);
            listaTelefonoPersona.add(telefono2);
            listaTelefonoPersona.add(telefono3);
            listaTelefonoPersona.add(telefono4);
            listaTelefonoPersona.add(telefono5);
            listaTelefonoPersona.add(telefono6);
            listaTelefonoPersona.add(telefono7);
        }
        return listaTelefonoPersona;
    }

    public static ObservableList<TelefonoPersonaId> getListaDeTelefonoID() {
        if (listaTelefonoIds == null) {
            listaTelefonoIds = FXCollections.observableArrayList();
            TelefonoPersonaId telefonoId1 = new TelefonoPersonaId(1, "9228154732");

            TelefonoPersonaId telefonoId2 = new TelefonoPersonaId(1, "922342345");

            TelefonoPersonaId telefonoId3 = new TelefonoPersonaId(2, "922452235");

            TelefonoPersonaId telefonoId4 = new TelefonoPersonaId(3, "922543267");

            TelefonoPersonaId telefonoId5 = new TelefonoPersonaId(4, "922543267");

            TelefonoPersonaId telefonoId6 = new TelefonoPersonaId(5, "63363232325");

            TelefonoPersonaId telefonoId7 = new TelefonoPersonaId(4, "92436879");

            listaTelefonoIds.add(telefonoId1);
            listaTelefonoIds.add(telefonoId2);
            listaTelefonoIds.add(telefonoId3);
            listaTelefonoIds.add(telefonoId4);
            listaTelefonoIds.add(telefonoId5);
            listaTelefonoIds.add(telefonoId6);
            listaTelefonoIds.add(telefonoId7);
        }
        return listaTelefonoIds;
    }

    public static ObservableList<Usuario> getListaDeUsuarios() {
        if (listaUsuario == null) {
            listaUsuario = FXCollections.observableArrayList();
            Usuario user1 = new Usuario();
            user1.setAdministrador(Byte.parseByte("1"));
            user1.setCodUsuario(1);
            user1.setBloqueado(Byte.parseByte("0"));
            user1.setFechaCaducidad(new Date(120, 05, 12));
            user1.setMostrador(Byte.parseByte("1"));
            user1.setNombreUsuario("admin");
            user1.setPassUsuario("admin");
            user1.setPersona(getListaDeHuespedes().get(2));
            user1.setRecepcion(Byte.parseByte("1"));
            user1.setServidor(Byte.parseByte("1"));
            user1.setUltimaActividad(Date.from(Instant.now()));

            Usuario user2 = new Usuario();
            user2.setAdministrador(Byte.parseByte("1"));
            user2.setCodUsuario(2);
            user2.setBloqueado(Byte.parseByte("0"));
            user2.setFechaCaducidad(new Date(120, 05, 12));
            user2.setMostrador(Byte.parseByte("1"));
            user2.setNombreUsuario("");
            user2.setPassUsuario("");
            user2.setPersona(getListaDeHuespedes().get(1));
            user2.setRecepcion(Byte.parseByte("1"));
            user2.setServidor(Byte.parseByte("1"));
            user2.setUltimaActividad(Date.from(Instant.now()));

            listaUsuario.add(user1);
            listaUsuario.add(user2);
        }
        return listaUsuario;
    }

    public static ObservableList<Persona> getListaDeHuespedesDentro() {
        if (listaHuespedesDentro == null) {
            listaHuespedesDentro = FXCollections.observableArrayList();
        }
        return listaHuespedesDentro;
    }
 
    public static ObservableList<Persona> getListaDeHuespedesFuera() {
        if (listaHuespedesFuera== null) {
            listaHuespedesFuera = getListaDeHuespedes();
        }
        return listaHuespedesFuera;
    }
 

    public static ObservableList<HuespedHabitacion> getListaDeHuespedHabitacion() {
        if (listaHuespedHabitacion == null) {
            listaHuespedHabitacion = FXCollections.observableArrayList();
        }
        return listaHuespedHabitacion;
    }
//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------

}
