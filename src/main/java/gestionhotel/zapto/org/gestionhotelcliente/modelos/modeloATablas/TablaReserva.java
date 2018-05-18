package gestionhotel.zapto.org.gestionhotelcliente.modelos.modeloATablas;

import gestionhotel.zapto.org.gestionhotelcliente.modelos.pojos.DetallesReserva;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Antonio Jesús Pérez Delgado <A. Jesús with netbeans>
 */
public class TablaReserva {

    LocalDate fechaEntradaPrevista, fechaSalidaPrevista;
    String tipoCliente, nombreAgencia, nombreCliente, pension, cuna, camaExtra, tipoTarjetaCredito,
            tarjetaCredito, voucher, preferenciaTipoHabitacion, prefenciaNumeroHabitacion,
            preferenciaVistas, oreferenciaTipoCama, preferenciaTipoRestaurante,
            preferenciaTurnoRestaurante;
    int numeroAdultos, numeroChild, numeroBebes;

    public static ObservableList<TablaReserva> getListaTablaReserva(ObservableList<DetallesReserva> listaReservas) {
        ObservableList<TablaReserva> listaTablaReserva = FXCollections.observableArrayList();
        for (DetallesReserva detallesReserva : listaReservas) {
            LocalDate fechaEntradaPrevista = null;
            LocalDate fechaSalidaPrevista = null;
            String tipoCliente = "";
            String nombreAgencia = "";
            String nombreCliente = "";
            String pension = "";
            int numeroAdultos = 0;
            int numeroChild = 0;
            int numeroBebes = 0;
            String cuna = "";
            String camaExtra = "";
            String tipoTarjetaCredito = "";
            String tarjetaCredito = "";
            String voucher = "";
            String preferenciaTipoHabitacion = "";
            String prefenciaNumeroHabitacion = "";
            String preferenciaVistas = "";
            String preferenciaTipoCama = "";
            String preferenciaTipoRestaurante = "";
            String preferenciaTurnoRestaurante = "";

            if (detallesReserva.getFechaEntradaPrevista() != null) {
                fechaEntradaPrevista = detallesReserva.getFechaEntradaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (detallesReserva.getFechaSalidaPrevista() != null) {
                fechaSalidaPrevista = detallesReserva.getFechaSalidaPrevista().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
            if (detallesReserva.getReserva().getPersonaByCodCliente().getEsEmpresa() != null) {
                tipoCliente = (detallesReserva.getReserva().getPersonaByCodCliente().getEsEmpresa() == 0) ? "Persona" : "Empresa";
            }

            nombreAgencia = detallesReserva.getReserva().getPersonaByAgencia().getNombre();
            if (detallesReserva.getReserva().getPersonaByCodCliente().getEsEmpresa() != null) {
                nombreCliente = (detallesReserva.getReserva().getPersonaByCodCliente().getEsEmpresa() == 0) ? detallesReserva.getReserva().getPersonaByCodCliente().getNombre() + " "
                        + detallesReserva.getReserva().getPersonaByCodCliente().getFisPrimerApellido() + " "
                        + detallesReserva.getReserva().getPersonaByCodCliente().getFisSegundoApellido() : detallesReserva.getReserva().getPersonaByCodCliente().getJurNombreComercial();
                pension = detallesReserva.getPension();
            }
            if (detallesReserva.getNumeroAdultos() != null) {
                numeroAdultos = detallesReserva.getNumeroAdultos();
            }
            if (detallesReserva.getNumeroChild() != null) {
                numeroChild = detallesReserva.getNumeroChild();
            }

            if (detallesReserva.getNumeroBebes() != null) {
                numeroBebes = detallesReserva.getNumeroBebes();
            }
            if (detallesReserva.getCuna() != null) {
                cuna = (detallesReserva.getCuna() == 0) ? "No" : "Si";
            }
            if (detallesReserva.getCuna() != null) {
                camaExtra = (detallesReserva.getCamaExtra() == 0) ? "No" : "Si";
            }
            tipoTarjetaCredito = detallesReserva.getReserva().getTipoTarjetaCredito();
            tarjetaCredito = detallesReserva.getReserva().getNumeroTarjetaCredito();
            voucher = detallesReserva.getReserva().getVoucher();
            preferenciaTipoHabitacion = detallesReserva.getPreferenciaTipoHabitacion();
            prefenciaNumeroHabitacion = detallesReserva.getPreferenciaHabitacion();
            preferenciaVistas = detallesReserva.getPreferenciaVistas();
            preferenciaTipoCama = detallesReserva.getPreferenciaTipoCama();
            preferenciaTipoRestaurante = detallesReserva.getPreferenciaTipoRestaurante();
            preferenciaTurnoRestaurante = detallesReserva.getPreferenciaTurnoRestaurante();
            TablaReserva tablaReserva = new TablaReserva(fechaEntradaPrevista, fechaSalidaPrevista, tipoCliente, nombreAgencia, nombreCliente,
                    pension, cuna, camaExtra, tipoTarjetaCredito, tarjetaCredito, voucher, preferenciaTipoHabitacion, prefenciaNumeroHabitacion,
                    preferenciaVistas, preferenciaTipoCama, preferenciaTipoRestaurante, preferenciaTurnoRestaurante, numeroAdultos, numeroChild, numeroBebes);
            listaTablaReserva.add(tablaReserva);
        }
        return listaTablaReserva;
    }

    public TablaReserva(LocalDate fechaEntradaPrevista, LocalDate fechaSalidaPrevista, String tipoCliente, String nombreAgencia, String nombreCliente, String pension, String cuna, String camaExtra, String tipoTarjetaCredito, String tarjetaCredito, String voucher, String preferenciaTipoHabitacion, String prefenciaNumeroHabitacion, String preferenciaVistas, String oreferenciaTipoCama, String preferenciaTipoRestaurante, String preferenciaRestaurante, int numeroAdultos, int numeroChild, int numeroBebes) {
        this.fechaEntradaPrevista = fechaEntradaPrevista;
        this.fechaSalidaPrevista = fechaSalidaPrevista;
        this.tipoCliente = tipoCliente;
        this.nombreAgencia = nombreAgencia;
        this.nombreCliente = nombreCliente;
        this.pension = pension;
        this.cuna = cuna;
        this.camaExtra = camaExtra;
        this.tipoTarjetaCredito = tipoTarjetaCredito;
        this.tarjetaCredito = tarjetaCredito;
        this.voucher = voucher;
        this.preferenciaTipoHabitacion = preferenciaTipoHabitacion;
        this.prefenciaNumeroHabitacion = prefenciaNumeroHabitacion;
        this.preferenciaVistas = preferenciaVistas;
        this.oreferenciaTipoCama = oreferenciaTipoCama;
        this.preferenciaTipoRestaurante = preferenciaTipoRestaurante;
        this.preferenciaTurnoRestaurante = preferenciaRestaurante;
        this.numeroAdultos = numeroAdultos;
        this.numeroChild = numeroChild;
        this.numeroBebes = numeroBebes;
    }

    public LocalDate getFechaEntradaPrevista() {
        return fechaEntradaPrevista;
    }

    public void setFechaEntradaPrevista(LocalDate fechaEntradaPrevista) {
        this.fechaEntradaPrevista = fechaEntradaPrevista;
    }

    public LocalDate getFechaSalidaPrevista() {
        return fechaSalidaPrevista;
    }

    public void setFechaSalidaPrevista(LocalDate fechaSalidaPrevista) {
        this.fechaSalidaPrevista = fechaSalidaPrevista;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getCuna() {
        return cuna;
    }

    public void setCuna(String cuna) {
        this.cuna = cuna;
    }

    public String getCamaExtra() {
        return camaExtra;
    }

    public void setCamaExtra(String camaExtra) {
        this.camaExtra = camaExtra;
    }

    public String getTipoTarjetaCredito() {
        return tipoTarjetaCredito;
    }

    public void setTipoTarjetaCredito(String tipoTarjetaCredito) {
        this.tipoTarjetaCredito = tipoTarjetaCredito;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getPreferenciaTipoHabitacion() {
        return preferenciaTipoHabitacion;
    }

    public void setPreferenciaTipoHabitacion(String preferenciaTipoHabitacion) {
        this.preferenciaTipoHabitacion = preferenciaTipoHabitacion;
    }

    public String getPrefenciaNumeroHabitacion() {
        return prefenciaNumeroHabitacion;
    }

    public void setPrefenciaNumeroHabitacion(String prefenciaNumeroHabitacion) {
        this.prefenciaNumeroHabitacion = prefenciaNumeroHabitacion;
    }

    public String getPreferenciaVistas() {
        return preferenciaVistas;
    }

    public void setPreferenciaVistas(String preferenciaVistas) {
        this.preferenciaVistas = preferenciaVistas;
    }

    public String getOreferenciaTipoCama() {
        return oreferenciaTipoCama;
    }

    public void setOreferenciaTipoCama(String oreferenciaTipoCama) {
        this.oreferenciaTipoCama = oreferenciaTipoCama;
    }

    public String getPreferenciaTipoRestaurante() {
        return preferenciaTipoRestaurante;
    }

    public void setPreferenciaTipoRestaurante(String preferenciaTipoRestaurante) {
        this.preferenciaTipoRestaurante = preferenciaTipoRestaurante;
    }

    public String getPreferenciaTurnoRestaurante() {
        return preferenciaTurnoRestaurante;
    }

    public void setPreferenciaTurnoRestaurante(String preferenciaTurnoRestaurante) {
        this.preferenciaTurnoRestaurante = preferenciaTurnoRestaurante;
    }

    public int getNumeroAdultos() {
        return numeroAdultos;
    }

    public void setNumeroAdultos(int numeroAdultos) {
        this.numeroAdultos = numeroAdultos;
    }

    public int getNumeroChild() {
        return numeroChild;
    }

    public void setNumeroChild(int numeroChild) {
        this.numeroChild = numeroChild;
    }

    public int getNumeroBebes() {
        return numeroBebes;
    }

    public void setNumeroBebes(int numeroBebes) {
        this.numeroBebes = numeroBebes;
    }

}
