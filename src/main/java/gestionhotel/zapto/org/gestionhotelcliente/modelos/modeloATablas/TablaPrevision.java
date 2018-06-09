package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.controladores.CreadorDeTabla;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.Persona;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaPrevision implements TablaInterface<TablaPrevision, DetallesReserva>{

    String numeroReserva, cliente, tipo, habitacion, nombreAgencia,voucher;
    LocalDate fechaPrevistaEntrada, fechaPrevistaSalida;
    ImageView img;
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
        lista.add(new CreadorDeTabla("Imagen", "img", 150));

        return lista;
    }

    @Override
    public ObservableList<TablaPrevision> getListaObjetosDeTabla(ObservableList<DetallesReserva> listaDetallesReserva) {
        ObservableList<TablaPrevision> listaCheckIn = FXCollections.observableArrayList();
        if (!listaDetallesReserva.isEmpty()) {
            for (DetallesReserva detallesReserva : listaDetallesReserva) {
                String numeroReserva = "";
                String nombrecliente = "";
                String habitacion = "";
                String nombreAgencia = "";
                String voucher="";
                LocalDate fechaPrevistaEntrada = null;
                LocalDate fechaPrevistaSalida = null;
                String tipo = "";
                numeroReserva = detallesReserva.getReserva().getNumero();
                Persona cliente = detallesReserva.getReserva().getPersonaByCodCliente();
                Persona agencia = detallesReserva.getReserva().getPersonaByAgencia();
                if (cliente != null) {
                    String nombre = "";
                    String primerApellido = "";
                    String segundoApellido = "";
                    if (cliente.getNombre() != null) {
                        nombre = cliente.getNombre();
                    }
                    if (agencia.getJurNombreComercial() != null) {
                        nombreAgencia = agencia.getJurNombreComercial();
                    }
                    if (cliente.getFisPrimerApellido() != null) {
                        primerApellido = cliente.getFisPrimerApellido();
                    }
                    if (cliente.getFisSegundoApellido() != null) {
                        segundoApellido = cliente.getFisSegundoApellido();
                    }
                    nombrecliente = nombre + " " + primerApellido + " " + segundoApellido;
                }
                if(detallesReserva.getReserva()!=null){
                    if(detallesReserva.getReserva().getVoucher()!=null){
                        voucher=detallesReserva.getReserva().getVoucher();
                    }
                }
                habitacion = detallesReserva.getPreferenciaHabitacion();
                fechaPrevistaEntrada = detallesReserva.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                fechaPrevistaSalida = detallesReserva.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                tipo = detallesReserva.getPreferenciaTipoHabitacion();
                TablaPrevision c = new TablaPrevision(voucher,nombreAgencia, numeroReserva, nombrecliente, habitacion, tipo, fechaPrevistaEntrada, fechaPrevistaSalida);
                c.setImg(new ImageView(new Image(getClass().getResource("/imagenes/tablas/empresa.png").toExternalForm())));
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

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    
}
