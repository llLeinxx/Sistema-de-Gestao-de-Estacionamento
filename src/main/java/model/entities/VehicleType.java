package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class VehicleType implements Serializable {
    private static final long serialVersionUID = 1L;
    private int cdType;
    private String nmType;

    public VehicleType(){}

    public VehicleType(int cdType, String nmType) {
        this.cdType = cdType;
        this.nmType = nmType;
    }

    public int getCdType() {
        return cdType;
    }

    public void setCdType(int cdType) {
        this.cdType = cdType;
    }

    public String getNmType() {
        return nmType;
    }

    public void setNmType(String nmType) {
        this.nmType = nmType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleType that)) return false;
        return getCdType() == that.getCdType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdType());
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "cdType=" + cdType +
                ", nmType='" + nmType + '\'' +
                '}';
    }
}
