package model.entities;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private VehicleType vehicleType;
    private Category category;
    Connection conn = null;
    PreparedStatement pst = null;
    Statement st = null;
    ResultSet rs = null;
    int cdPlaca;

    public  Vehicle(){}

    public Vehicle(VehicleType vehicleType, Category category, int cdPlaca) {
        this.vehicleType = vehicleType;
        this.category = category;
        this.cdPlaca = cdPlaca;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return getCdPlaca() == vehicle.getCdPlaca();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdPlaca());
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", category=" + category +
                ", cdPlaca=" + cdPlaca +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCdPlaca() {
        return cdPlaca;
    }

    public void setCdPlaca(int cdPlaca) {
        this.cdPlaca = cdPlaca;
    }

}
