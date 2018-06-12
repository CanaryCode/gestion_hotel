package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Agencia;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Alojamiento;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Cliente;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaPrevision implements TablaInterface<TablaPrevision, Alojamiento>{

    String numeroReserva, cliente, tipo, habitacion, nombreAgencia,voucher;
    LocalDate fechaPrevistaEntrada, fechaPrevistaSalida;
    public TablaPrevision(){
        
    }

    @Override
    public ObservableList<CreadorDeTabla> getListaObjetosColumnas() {

        ObservableList<CreadorDeTabla> lista = FXCollections.observableArrayList();
        lista.add(new CreadorDeTabla("Número reserva", "numeroReserva", 150));
        lista.add(new CreadorDeTabla("Número voucher", "voucher", 150));
        lista.add(new CreadorDeTabla("Nombre cliente", "cliente", 300));
        lista.add(new CreadorDeTabla("Nombre agencia", "nombreAgencia", 300));
        lista.add(new CreadorDeTabla("Fecha prevista entrada", "fechaPrevistaEntrada", 150));
        lista.add(new CreadorDeTabla("Fecha prevista salida", "fechaPrevistaSalida", 150));

        return lista;
    }

    @Override
    public ObservableList<TablaPrevision> getListaObjetosDeTabla(ObservableList<Alojamiento> listaAlojamietos) {
        ObservableList<TablaPrevision> listaCheckIn = FXCollections.observableArrayList();
        if (!listaAlojamietos.isEmpty()) {
            for (Alojamiento alojamiento : listaAlojamietos) {
                String codigo = "";
                String nombrecliente = "";
                String habitacion = "";
                String nombreAgencia = "";
                String voucher="";
                LocalDate fechaPrevistaEntrada = null;
                LocalDate fechaPrevistaSalida = null;
                String tipo = "";
                codigo = alojamiento.getReserva().getCodigo();
                Cliente cliente = alojamiento.getReserva().getCliente();
                Agencia agencia = alojamiento.getReserva().getAgencia();
                if (cliente != null) {
                    String nombre = "";
                    String primerApellido = "";
                    String segundoApellido = "";
                    if (cliente.getPersona().getNombre() != null) {
                        nombre = cliente.getPersona().getNombre();
                    }
                    if (agencia.getPersona().getJurNombreComercial() != null) {
                        nombreAgencia = agencia.getPersona().getJurNombreComercial();
                    }
                    if (cliente.getPersona().getFisPrimerApellido() != null) {
                        primerApellido = cliente.getPersona().getFisPrimerApellido();
                    }
                    if (cliente.getPersona().getFisSegundoApellido() != null) {
                        segundoApellido = cliente.getPersona().getFisSegundoApellido();
                    }
                    nombrecliente = nombre + " " + primerApellido + " " + segundoApellido;
                }
                if(alojamiento.getReserva()!=null){
                    if(alojamiento.getReserva().getVoucher()!=null){
                        voucher=alojamiento.getReserva().getVoucher();
                    }
                }
                habitacion = alojamiento.getPrefHabitacion();
                fechaPrevistaEntrada = alojamiento.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                fechaPrevistaSalida = alojamiento.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                tipo = alojamiento.getPrefHabitacion();
                TablaPrevision c = new TablaPrevision(voucher,nombreAgencia, codigo, nombrecliente, habitacion, tipo, fechaPrevistaEntrada, fechaPrevistaSalida);
                listaCheckIn.add(c);
            }
        }
        return listaCheckIn;
    }

    public TablaPrevision(String voucher,String nombreAgencia, String numeroReserva, String cliente, String habitacion, String tipo, LocalDate fechaPrevistaEntrada, LocalDate fechaPrevistaSalida) {
        this.nombreAgencia = nombreAgencia;
        this.numeroReserva = numeroReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.tipo = tipo;
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
        this.fechaPrevistaSalida = fechaPrevistaSalida;
        this.voucher=voucher;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(String numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaPrevistaEntrada() {
        return fechaPrevistaEntrada;
    }

    public void setFechaPrevistaEntrada(LocalDate fechaPrevistaEntrada) {
        this.fechaPrevistaEntrada = fechaPrevistaEntrada;
    }

    public LocalDate getFechaPrevistaSalida() {
        return fechaPrevistaSalida;
    }

    public void setFechaPrevistaSalida(LocalDate fechaPrevistaSalida) {
        this.fechaPrevistaSalida = fechaPrevistaSalida;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }  
}
