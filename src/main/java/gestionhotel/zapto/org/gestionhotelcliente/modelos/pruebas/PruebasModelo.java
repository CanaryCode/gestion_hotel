package gestionhotel.zapto.org.gestionhotelcliente.modelos.pruebas;

import gestionhotel.zapto.org.gestionhotelcliente.MainApp;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.Registro;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Agencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Cliente;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Habitacion;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Huesped;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Reserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Telefono;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.TelefonoPersona;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Trabajador;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Hibernate;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class PruebasModelo {

    private static ObservableList<Alojamiento> listaAlojamientos = null;
    private static ObservableList<Reserva> listaReservas = null;
    private static ObservableList<Cliente> listaClientes = null;
    private static ObservableList<Persona> listaPersonas = null;
    private static ObservableList<Huesped> listaHuespedes = null;
    private static ObservableList<Habitacion> listaHabitaciones = null;
    private static ObservableList<Agencia> listaAgencias = null;
//    private static ObservableList<HuespedHabitacion> listaHuespedHabitacion = null;
    private static ObservableList<TelefonoPersona> listaTelefonoPersona = null;
    private static ObservableList<Telefono> listaTelefono = null;
    private static ObservableList<Trabajador> listaUsuario = null;

    public static ObservableList<Alojamiento> getListaDeAlojamientos() {
        if (listaAlojamientos == null) {

            listaAlojamientos = FXCollections.observableArrayList();
            Alojamiento alojamiento1 = new Alojamiento();
            alojamiento1.setId(1);
            alojamiento1.setTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento1.setPension(Registro.ListaPension.get(3));
            alojamiento1.setFechaEntradaPrevista(new Date(116, 05, 11));
            alojamiento1.setFechaSalidaPrevista(new Date(135, 07, 11));
            alojamiento1.setReserva(getListaDeReservas().get(0));
            alojamiento1.setComentario("comentario alojamiento 1");

            alojamiento1.setCuna(false);
            alojamiento1.setCamaExtra(true);
            alojamiento1.setNumeroAdultos(2);
            alojamiento1.setNumeroBebes(2);
            alojamiento1.setNumeroChild(3);
            alojamiento1.setPrefHabitacion(Registro.ListaNumeroHabitacion.get(1));
            alojamiento1.setPrefTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento1.setPrefTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento1.setPrefTipoHabitacion(Registro.ListaTipoHabitacion.get(3));
            alojamiento1.setPrefTipoRestaurante(Registro.ListaTipoRestaurante.get(2));
            alojamiento1.setPrefVistas(Registro.ListaVistas.get(3));

            Alojamiento alojamiento2 = new Alojamiento();
            alojamiento2.setId(2);
            alojamiento2.setTipoCama(Registro.ListaTipoCama.get(2));
            alojamiento2.setPension(Registro.ListaPension.get(3));
            alojamiento2.setFechaEntradaPrevista(new Date(105, 04, 11));
            alojamiento2.setFechaSalidaPrevista(new Date(145, 12, 11));
            alojamiento2.setReserva(getListaDeReservas().get(1));

            alojamiento2.setCuna(true);
            alojamiento2.setCamaExtra(false);
            alojamiento2.setNumeroAdultos(2);
            alojamiento2.setNumeroBebes(2);
            alojamiento2.setNumeroChild(3);
            alojamiento2.setPrefHabitacion(Registro.ListaNumeroHabitacion.get(2));
            alojamiento2.setPrefTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento2.setPrefTipoCama(Registro.ListaTipoCama.get(2));
            alojamiento2.setPrefTipoHabitacion(Registro.ListaTipoHabitacion.get(3));
            alojamiento2.setPrefTipoRestaurante(Registro.ListaTipoRestaurante.get(3));
            alojamiento2.setPrefVistas(Registro.ListaVistas.get(3));
            alojamiento2.setComentario("comentario alojamiento 2");

            Alojamiento alojamiento3 = new Alojamiento();
            alojamiento3.setId(3);
            alojamiento3.setTipoCama(Registro.ListaTipoCama.get(3));
            alojamiento3.setPension(Registro.ListaPension.get(2));
            alojamiento3.setFechaEntradaPrevista(new Date(118, 05, 10));
            alojamiento3.setFechaSalidaPrevista(new Date(119, 06, 11));
            alojamiento3.setReserva(getListaDeReservas().get(2));

            alojamiento3.setCuna(true);
            alojamiento3.setCamaExtra(true);
            alojamiento3.setNumeroAdultos(2);
            alojamiento3.setNumeroBebes(2);
            alojamiento3.setNumeroChild(3);
            alojamiento3.setPrefHabitacion(Registro.ListaNumeroHabitacion.get(3));
            alojamiento3.setPrefTurnoRestaurante(Registro.ListaTurnoRestaurante.get(2));
            alojamiento3.setPrefTipoCama(Registro.ListaTipoCama.get(4));
            alojamiento3.setPrefTipoHabitacion(Registro.ListaTipoHabitacion.get(1));
            alojamiento3.setPrefTipoRestaurante(Registro.ListaTipoRestaurante.get(4));
            alojamiento3.setPrefVistas(Registro.ListaVistas.get(1));
            alojamiento3.setComentario("comentario alojamiento 2");

            Alojamiento alojamiento4 = new Alojamiento();
            alojamiento4.setId(4);
            alojamiento4.setTipoCama(Registro.ListaTipoCama.get(4));
            alojamiento4.setPension(Registro.ListaPension.get(1));
            alojamiento4.setFechaEntradaPrevista(new Date(114, 06, 11));
            alojamiento4.setFechaSalidaPrevista(new Date(120, 07, 11));
            alojamiento4.setReserva(getListaDeReservas().get(3));

            alojamiento4.setCuna(false);
            alojamiento4.setCamaExtra(false);
            alojamiento4.setNumeroAdultos(3);
            alojamiento4.setNumeroBebes(0);
            alojamiento4.setNumeroChild(1);
            alojamiento4.setPrefHabitacion(Registro.ListaNumeroHabitacion.get(4));
            alojamiento4.setPrefTurnoRestaurante(Registro.ListaTurnoRestaurante.get(1));
            alojamiento4.setPrefTipoCama(Registro.ListaTipoCama.get(1));
            alojamiento4.setPrefTipoHabitacion(Registro.ListaTipoHabitacion.get(2));
            alojamiento4.setPrefTipoRestaurante(Registro.ListaTipoRestaurante.get(3));
            alojamiento4.setPrefVistas(Registro.ListaVistas.get(2));
            alojamiento4.setComentario("comentario alojamiento 2");

            listaAlojamientos.add(alojamiento1);
            listaAlojamientos.add(alojamiento2);
            listaAlojamientos.add(alojamiento3);
            listaAlojamientos.add(alojamiento4);
        }
        return listaAlojamientos;
    }

    public static ObservableList<Agencia> getListaDeAgencia() {
        if (listaAgencias == null) {
            listaAgencias = FXCollections.observableArrayList();
            Agencia agencia1 = new Agencia();
            agencia1.setId(1);
            agencia1.setPersona(getListaDePersonas().get(0));

            Agencia agencia2 = new Agencia();
            agencia2.setId(2);
            agencia2.setPersona(getListaDePersonas().get(1));

            Agencia agencia3 = new Agencia();
            agencia3.setId(3);
            agencia3.setPersona(getListaDePersonas().get(2));

            Agencia agencia4 = new Agencia();
            agencia4.setId(4);
            agencia4.setPersona(getListaDePersonas().get(3));

            listaAgencias.add(agencia1);
            listaAgencias.add(agencia2);
            listaAgencias.add(agencia3);
            listaAgencias.add(agencia4);
        }
        return listaAgencias;
    }

    public static ObservableList<Reserva> getListaDeReservas() {
        if (listaReservas == null) {
            listaReservas = FXCollections.observableArrayList();
            Reserva reserva1 = new Reserva();
            reserva1.setId(1);
            reserva1.setFecha(new Date(117, 05, 11));
            reserva1.setComentario("una reserva cualquiera");
            reserva1.setCodigo("1");
            reserva1.setNumeroTarjetaCredito("4532544");
            reserva1.setVoucher("voucher11");
            reserva1.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(4));
            reserva1.setCliente(getListaDeClientes().get(1));
            reserva1.setAgencia(getListaDeAgencia().get(0));

            Reserva reserva2 = new Reserva();
            reserva2.setId(2);
            reserva2.setFecha(new Date(117, 05, 10));
            reserva2.setComentario("una reserva cualquiera");
            reserva2.setCodigo("2");
            reserva2.setNumeroTarjetaCredito("r3ewf3");
            reserva2.setVoucher("voucher22");
            reserva2.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(3));
            reserva2.setCliente(getListaDeClientes().get(1));
            reserva2.setAgencia(getListaDeAgencia().get(3));

            Reserva reserva3 = new Reserva();
            reserva3.setId(3);
            reserva3.setFecha(new Date(117, 05, 15));
            reserva3.setComentario("una reserva cualquiera");
            reserva3.setCodigo("3");
            reserva3.setNumeroTarjetaCredito("3444");
            reserva3.setVoucher("4335");
            reserva3.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(2));
            reserva3.setCliente(getListaDeClientes().get(1));
            reserva3.setAgencia(getListaDeAgencia().get(2));

            Reserva reserva4 = new Reserva();
            reserva4.setId(4);
            reserva4.setFecha(new Date(117, 05, 05));
            reserva4.setComentario("una reserva cualquiera");
            reserva4.setCodigo("1");
            reserva4.setNumeroTarjetaCredito("re543345");
            reserva4.setVoucher("voucher44");
            reserva4.setTipoTarjetaCredito(Registro.ListaTipoTarjeta.get(1));
            reserva4.setCliente(getListaDeClientes().get(0));
            reserva4.setAgencia(getListaDeAgencia().get(3));

            listaReservas.add(reserva1);
            listaReservas.add(reserva2);
            listaReservas.add(reserva3);
            listaReservas.add(reserva4);
        }
        return listaReservas;
    }

    public static ObservableList<Persona> getListaDePersonas() {
        if (listaPersonas == null) {
            listaPersonas = FXCollections.observableArrayList();
            Persona persona5 = new Persona();
            persona5.setId(5);
            persona5.setNombre("Florentino");
            persona5.setFisPrimerApellido("Perez");
            persona5.setFisSegundoApellido("Dinero");
            persona5.setFisFechaNacimiento(new Date(55, 05, 04));
            persona5.setFisSexoHombre(true);
            persona5.setFisDiscapacitado(false);
            persona5.setFisNacionalidad(Registro.listaPaises.get(14));
            persona5.setProvincia("Madrid");
            persona5.setCiudad("Madrid");
            persona5.setCalle("dinero");
            persona5.setNumero("100");
            persona5.setCodPostal("34433");
            persona5.setNumeroDocumento("742573239m");
            persona5.setCategoria(Registro.ListaCategoriaCliente.get(1));
            persona5.setPaginaWeb("wwww.soyrico.com");
            persona5.setEmail("soyrico@gmail.com");
            persona5.setFisTratamiento(Registro.ListaTratamiento.get(4));
            persona5.setComentario("Una persona rica");
            persona5.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                System.out.println();
                persona5.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona6 = new Persona();
            persona6.setId(6);
            persona6.setNombre("Joan");
            persona6.setFisPrimerApellido("Gaspar");
            persona6.setFisSegundoApellido("Flipao");
            persona6.setFisFechaNacimiento(new Date(34, 8, 07));
            persona6.setFisSexoHombre(true);
            persona6.setFisDiscapacitado(true);
            persona6.setFisNacionalidad("España");
            persona6.setProvincia("Barcelona");
            persona6.setCiudad("Tabarnia");
            persona6.setCalle("catalanes");
            persona6.setNumero("10");
            persona6.setCodPostal("345532");
            persona6.setNumeroDocumento("72354353m");
            persona6.setCategoria(Registro.ListaCategoriaCliente.get(4));
            persona6.setPaginaWeb("wwww.soyunflipao.com");
            persona6.setEmail("soyunflipao@gmail.com");
            persona6.setFisTratamiento(Registro.ListaTratamiento.get(3));
            persona6.setComentario("Una persona especial");
            persona6.setEstado(Registro.listaPaises.get(23));
            persona6.setEsEmpresa(false);
            try {
               byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona6.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona7 = new Persona();
            persona7.setId(7);
            persona7.setNombre("Acs");
            persona7.setJurNombreComercial("Acs internacional");
            persona7.setJurRazonSocial("S.A");
            persona7.setProvincia("Madrid");
            persona7.setCiudad("Madrid");
            persona7.setCalle("Gran via");
            persona7.setNumero("23");
            persona7.setCodPostal("33632");
            persona7.setNumeroDocumento("cif33322");
            persona7.setCategoria(Registro.ListaCategoriaCliente.get(2));
            persona7.setPaginaWeb("wwww.acs.com");
            persona7.setEmail("acs@gmail.com");
            persona7.setComentario("multinacinal");
            persona7.setEstado(Registro.listaPaises.get(76));
            persona7.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona7.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona8 = new Persona();
            persona8.setId(8);
            persona8.setNombre("Iberdrola");
            persona8.setJurRazonSocial("S.A");
            persona8.setJurNombreComercial("Iberdrola Spain");
            persona8.setProvincia("Barcelona");
            persona8.setCiudad("Barcelona");
            persona8.setCalle("Las ramblas");
            persona8.setNumero("33");
            persona8.setCodPostal("334455");
            persona8.setNumeroDocumento("cif34355");
            persona8.setCategoria(Registro.ListaCategoriaCliente.get(3));
            persona8.setPaginaWeb("wwww.Iberdrola.com");
            persona8.setEmail("iberdrola@gmail.com");
            persona8.setComentario("Renovables");
            persona8.setEstado(Registro.listaPaises.get(86));
            persona8.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona8.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona1 = new Persona();
            persona1.setId(1);
            persona1.setNombre("Antonio Jesús");
            persona1.setFisPrimerApellido("Perez Delgado");
            persona1.setFisSegundoApellido("Delgado");
            persona1.setFisFechaNacimiento(new Date(85, 12, 25));
            persona1.setFisSexoHombre(true);
            persona1.setFisDiscapacitado(false);
            persona1.setFisNacionalidad(Registro.listaPaises.get(1));
            persona1.setProvincia("Santa cruz de Tenerife");
            persona1.setCiudad("Icod de los vinos");
            persona1.setCalle("penichet");
            persona1.setNumero("14");
            persona1.setCodPostal("38430");
            persona1.setNumeroDocumento("78633049m");
            persona1.setPasaporte("pas333");
            persona1.setCategoria(Registro.listaCategoriaHuesped.get(3));
            persona1.setPaginaWeb("wwww.soyunmaquina.com");
            persona1.setEmail("soyunmaquina@gmail.com");
            persona1.setFisTratamiento(Registro.ListaTratamiento.get(1));
            persona1.setEstado(Registro.listaPaises.get(1));
            persona1.setComentario("Una persona especial");
            persona1.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona1.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona2 = new Persona();
            persona2.setId(2);
            persona2.setNombre("Sergia");
            persona2.setFisPrimerApellido("Vidal");
            persona2.setFisSegundoApellido("Castellano");
            persona2.setFisFechaNacimiento(new Date(79, 04, 12));
            persona2.setFisSexoHombre(false);
            persona2.setFisDiscapacitado(true);
            persona2.setFisNacionalidad(Registro.listaPaises.get(54));
            persona2.setProvincia("Rabat");
            persona2.setCiudad("Ala es grande");
            persona2.setCalle("asereje");
            persona2.setNumero("43");
            persona2.setCodPostal("304d3v");
            persona2.setNumeroDocumento("78422449m");
            persona2.setPasaporte("pas344");
            persona2.setCategoria(Registro.listaCategoriaHuesped.get(2));
            persona2.setPaginaWeb("wwww.soyungay.com");
            persona2.setEmail("soyungay@gmail.com");
            persona2.setFisTratamiento(Registro.ListaTratamiento.get(2));
            persona2.setEstado(Registro.listaPaises.get(49));
            persona2.setComentario("Una persona gay");
            persona2.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona2.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona3 = new Persona();
            persona3.setId(3);
            persona3.setNombre("Marcos");
            persona3.setFisPrimerApellido("Tabaiba");
            persona3.setFisSegundoApellido("Seca");
            persona3.setFisFechaNacimiento(new Date(40, 03, 03));
            persona3.setFisSexoHombre(false);
            persona3.setFisDiscapacitado(true);
            persona3.setFisNacionalidad(Registro.listaPaises.get(14));
            persona3.setProvincia("ala akbar");
            persona3.setCiudad("bomba");
            persona3.setCalle("bomba lapa");
            persona3.setNumero("2");
            persona3.setCodPostal("ert3");
            persona3.setNumeroDocumento("78e3s29m");
            persona3.setPasaporte("pas333");
            persona3.setCategoria(Registro.listaCategoriaHuesped.get(4));
            persona3.setPaginaWeb("wwww.soyuntranque.com");
            persona3.setEmail("soyuntranque@gmail.com");
            persona3.setFisTratamiento(Registro.ListaTratamiento.get(3));
            persona3.setEstado(Registro.listaPaises.get(53));
            persona3.setComentario("Una persona con diversidad funcional");
            persona3.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona3.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Persona persona4 = new Persona();
            persona4.setId(4);
            persona4.setNombre("Samuel");
            persona4.setFisPrimerApellido("Etoo");
            persona4.setFisSegundoApellido("n´jalmo");
            persona4.setFisFechaNacimiento(new Date(59, 12, 22));
            persona4.setFisSexoHombre(true);
            persona4.setFisDiscapacitado(false);
            persona4.setFisNacionalidad(Registro.listaPaises.get(100));
            persona4.setProvincia("Hambre");
            persona4.setCiudad("guerra");
            persona4.setCalle("penurias");
            persona4.setNumero("19");
            persona4.setCodPostal("384e23");
            persona4.setNumeroDocumento("23dss39m");
            persona4.setPasaporte("pas345cdsd");
            persona4.setCategoria(Registro.listaCategoriaHuesped.get(1));
            persona4.setPaginaWeb("wwww.soyunnegro.com");
            persona4.setEmail("soyunnegro@gmail.com");
            persona4.setFisTratamiento(Registro.ListaTratamiento.get(4));
            persona4.setEstado(Registro.listaPaises.get(1));
            persona4.setComentario("Una persona especial");
            persona4.setEsEmpresa(false);
            try {
                byte[] b = Files.readAllBytes(Paths.get("C:\\Users\\deico\\OneDrive\\Documentos\\NetBeansProjects\\gestion_hotel_cliente\\src\\main\\resources\\imagenes\\pruebas\\user1.png"));
                persona4.setFoto(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

            listaPersonas.add(persona1);
            listaPersonas.add(persona2);
            listaPersonas.add(persona3);
            listaPersonas.add(persona4);
            listaPersonas.add(persona5);
            listaPersonas.add(persona6);
            listaPersonas.add(persona7);
            listaPersonas.add(persona8);
        }
        return listaPersonas;
    }

    public static ObservableList<Cliente> getListaDeClientes() {
        if (listaClientes == null) {
            listaClientes = FXCollections.observableArrayList();

            Cliente cliente1 = new Cliente(getListaDePersonas().get(5));
            cliente1.setId(1);
            Cliente cliente2 = new Cliente(getListaDePersonas().get(6));
            cliente2.setId(2);
            Cliente cliente3 = new Cliente(getListaDePersonas().get(7));
            cliente3.setId(3);
            Cliente cliente4 = new Cliente(getListaDePersonas().get(4));
            cliente4.setId(4);

            listaClientes.add(cliente1);
            listaClientes.add(cliente2);
            listaClientes.add(cliente3);
            listaClientes.add(cliente4);
        }
        return listaClientes;
    }

    public static ObservableList<Huesped> getListaDeHuespedes() {
        if (listaHuespedes == null) {
            synchronized (new Object()) {
                if (listaHuespedes == null) {
                    listaHuespedes = FXCollections.observableArrayList();

                    Huesped huesped1 = new Huesped();
                    huesped1.setId(1);
                    huesped1.setPersona(getListaDePersonas().get(0));
                    huesped1.setDentro(false);

                    Huesped huesped2 = new Huesped();
                    huesped2.setId(2);
                    huesped2.setPersona(getListaDePersonas().get(1));
                    huesped2.setDentro(false);

                    Huesped huesped3 = new Huesped();
                    huesped3.setId(3);
                    huesped3.setPersona(getListaDePersonas().get(2));
                    huesped3.setDentro(false);

                    Huesped huesped4 = new Huesped();
                    huesped4.setId(4);
                    huesped4.setPersona(getListaDePersonas().get(3));
                    huesped4.setDentro(false);

                    Huesped huesped5 = new Huesped();
                    huesped5.setId(5);
                    huesped5.setPersona(getListaDePersonas().get(4));
                    huesped5.setDentro(false);

                    Huesped huesped6 = new Huesped();
                    huesped6.setId(6);
                    huesped6.setPersona(getListaDePersonas().get(5));
                    huesped6.setDentro(false);

                    listaHuespedes.add(huesped1);
                    listaHuespedes.add(huesped2);
                    listaHuespedes.add(huesped3);
                    listaHuespedes.add(huesped4);
                    listaHuespedes.add(huesped5);
                    listaHuespedes.add(huesped6);
                }
            }
        }
        return listaHuespedes;
    }

    public static ObservableList<Habitacion> getListaDeHabitaciones() {
        if (listaHabitaciones == null) {
            listaHabitaciones = FXCollections.observableArrayList();
            Habitacion hab1 = new Habitacion();
            hab1.setVistas(Registro.ListaVistas.get(1));
//            hab1.set(Registro.ListaTipoHabitacion.get(3));
            hab1.setNumero(Registro.ListaNumeroHabitacion.get(4));
            hab1.setTipoCama(Registro.ListaTipoCama.get(1));
            hab1.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab2 = new Habitacion();
            hab2.setVistas(Registro.ListaVistas.get(1));
//            hab2.setTipo(Registro.ListaTipoHabitacion.get(2));
            hab2.setNumero(Registro.ListaNumeroHabitacion.get(1));
            hab2.setTipoCama(Registro.ListaTipoCama.get(2));
            hab2.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab3 = new Habitacion();
            hab3.setVistas(Registro.ListaVistas.get(2));
//            hab3.setTipo(Registro.ListaTipoHabitacion.get(1));
            hab3.setNumero(Registro.ListaNumeroHabitacion.get(3));
            hab3.setTipoCama(Registro.ListaTipoCama.get(3));
            hab3.setEstado(Registro.ListaEstadoHabitacion.get(2));

            Habitacion hab4 = new Habitacion();
            hab4.setVistas(Registro.ListaVistas.get(3));
//            hab4.setTipo(Registro.ListaTipoHabitacion.get(4));
            hab4.setNumero(Registro.ListaNumeroHabitacion.get(2));
            hab4.setTipoCama(Registro.ListaTipoCama.get(1));
            hab4.setEstado(Registro.ListaEstadoHabitacion.get(2));

            listaHabitaciones.add(hab1);
            listaHabitaciones.add(hab2);
            listaHabitaciones.add(hab3);
            listaHabitaciones.add(hab4);
        }
        return listaHabitaciones;
    }

    public static ObservableList<Telefono> getListaDeTelefono() {
        if (listaTelefono == null) {
            Telefono telefono1 = new Telefono();
            telefono1.setNumero("63543266");
            telefono1.setDescripcion("una descripcion normal");
            telefono1.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono1.setComentario("comentario numero 1");

            Telefono telefono2 = new Telefono();
            telefono2.setNumero("63445576");
            telefono2.setDescripcion("una descripcion especial");
            telefono2.setTipo(Registro.ListaTipoTelefono.get(2));
            telefono2.setComentario("comentario numero 2");

            Telefono telefono3 = new Telefono();
            telefono3.setNumero("66787654");
            telefono3.setDescripcion("una descripcion cualquiera");
            telefono3.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono3.setComentario("comentario numero 3");

            Telefono telefono4 = new Telefono();
            telefono4.setNumero("6543245657");
            telefono4.setDescripcion("una descripcion a secas");
            telefono4.setTipo(Registro.ListaTipoTelefono.get(3));
            telefono4.setComentario("comentario numero 4");

            Telefono telefono5 = new Telefono();
            telefono5.setNumero("69674568");
            telefono5.setDescripcion("una descripcion 3");
            telefono5.setTipo(Registro.ListaTipoTelefono.get(3));
            telefono5.setComentario("comentario numero 5");

            Telefono telefono6 = new Telefono();
            telefono6.setNumero("627543567");
            telefono6.setDescripcion("una descripcion");
            telefono6.setTipo(Registro.ListaTipoTelefono.get(2));
            telefono6.setComentario("comentario numero 6");

            Telefono telefono7 = new Telefono();
            telefono7.setNumero("6894257534");
            telefono7.setDescripcion("describiendo");
            telefono7.setTipo(Registro.ListaTipoTelefono.get(1));
            telefono7.setComentario("comentario numero 7");

            listaTelefono.add(telefono1);
            listaTelefono.add(telefono2);
            listaTelefono.add(telefono3);
            listaTelefono.add(telefono4);
            listaTelefono.add(telefono5);
            listaTelefono.add(telefono6);
            listaTelefono.add(telefono7);
        }
        return listaTelefono;
    }

    public static ObservableList<TelefonoPersona> getListaDeTelefonoPersona() {
        if (listaTelefonoPersona == null) {
            listaTelefonoPersona = FXCollections.observableArrayList();
            TelefonoPersona telefonoPersona1 = new TelefonoPersona();
            telefonoPersona1.setId(1);

            TelefonoPersona telefonoPersona2 = new TelefonoPersona();
            telefonoPersona2.setId(2);

            TelefonoPersona telefonoPersona3 = new TelefonoPersona();
            telefonoPersona3.setId(3);

            TelefonoPersona telefonoPersona4 = new TelefonoPersona();
            telefonoPersona4.setId(4);

            TelefonoPersona telefonoPersona5 = new TelefonoPersona();
            telefonoPersona5.setId(5);

            TelefonoPersona telefonoPersona6 = new TelefonoPersona();
            telefonoPersona6.setId(6);

            TelefonoPersona telefonoPersona7 = new TelefonoPersona();
            telefonoPersona7.setId(7);

            listaTelefonoPersona.add(telefonoPersona1);
            listaTelefonoPersona.add(telefonoPersona2);
            listaTelefonoPersona.add(telefonoPersona3);
            listaTelefonoPersona.add(telefonoPersona4);
            listaTelefonoPersona.add(telefonoPersona5);
            listaTelefonoPersona.add(telefonoPersona6);
            listaTelefonoPersona.add(telefonoPersona7);
        }
        return listaTelefonoPersona;
    }

    public static ObservableList<Trabajador> getListaDeTrabajadores() {
        if (listaUsuario == null) {
            listaUsuario = FXCollections.observableArrayList();
            Trabajador trabajador1 = new Trabajador();
            trabajador1.setId(1);
            trabajador1.setDentro(true);
            trabajador1.setPassword("");
            trabajador1.setUsuario("");
            trabajador1.setPersona(getListaDePersonas().get(0));
            trabajador1.setDepartamento(Registro.ListaDeparmentos.get(1));

            Trabajador trabajador2 = new Trabajador();
            trabajador2.setId(2);
            trabajador2.setDentro(true);
            trabajador2.setPassword("hola");
            trabajador2.setUsuario("hola");
            trabajador2.setPersona(getListaDePersonas().get(1));
            trabajador2.setDepartamento(Registro.ListaDeparmentos.get(2));

            Trabajador trabajador3 = new Trabajador();
            trabajador3.setId(3);
            trabajador3.setDentro(true);
            trabajador3.setPassword("nada");
            trabajador3.setUsuario("nada");
            trabajador3.setPersona(getListaDePersonas().get(2));
            trabajador3.setDepartamento(Registro.ListaDeparmentos.get(1));

            Trabajador trabajador4 = new Trabajador();
            trabajador4.setId(4);
            trabajador4.setDentro(true);
            trabajador4.setPassword("0");
            trabajador4.setUsuario("0");
            trabajador4.setPersona(getListaDePersonas().get(3));
            trabajador4.setDepartamento(Registro.ListaDeparmentos.get(2));

            listaUsuario.add(trabajador1);
            listaUsuario.add(trabajador2);
            listaUsuario.add(trabajador3);
            listaUsuario.add(trabajador4);
        }
        return listaUsuario;
    }

//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
}
