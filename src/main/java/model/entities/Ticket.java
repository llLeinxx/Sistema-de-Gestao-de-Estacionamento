package model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cdTicket;
    private int tipoV;
    private int cancela;
    private LocalDateTime dtHtEntrada;
    private LocalDateTime dtHtSaida;
    private Double vlTicket;
    VehicleType vehicleType;
    Gate gate;

    public Ticket(){}

    public Ticket(int cdTicket, LocalDateTime dtHtEntrada, LocalDateTime dtHtSaida, Double vlTicket, int tipoV, Gate gate) {
        this.cdTicket = cdTicket;
        this.dtHtEntrada = dtHtEntrada;
        this.dtHtSaida = dtHtSaida;
        this.vlTicket = vlTicket;
        this.vehicleType = vehicleType;
        this.gate = gate;
    }

    public int getTipoV() {
        return tipoV;
    }

    public void setTipoV(int tipoV) {
        this.tipoV = tipoV;
    }

    public int getCdTicket() {
        return cdTicket;
    }

    public void setCdTicket(int cdTicket) {
        this.cdTicket = cdTicket;
    }

    public LocalDateTime getDtHtEntrada() {
        return dtHtEntrada;
    }

    public void setDtHtEntrada(LocalDateTime dtHtEntrada) {
        this.dtHtEntrada = dtHtEntrada;
    }

    public LocalDateTime getDtHtSaida() {
        return dtHtSaida;
    }

    public void setDtHtSaida(LocalDateTime dtHtSaida) {
        this.dtHtSaida = dtHtSaida;
    }

    public Double getVlTicket() {
        return vlTicket;
    }

    public void setVlTicket(Double vlTicket) {
        this.vlTicket = vlTicket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return getCdTicket() == ticket.getCdTicket();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdTicket());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "cdTicket=" + cdTicket +
                ", dtHtEntrada=" + dtHtEntrada +
                ", dtHtSaida=" + dtHtSaida +
                ", vlTicket=" + vlTicket +
                ", vehicleType=" + vehicleType +
                ", gate=" + gate +
                '}';
    }
}
