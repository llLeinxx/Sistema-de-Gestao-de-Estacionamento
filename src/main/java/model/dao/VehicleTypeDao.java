package model.dao;

import model.entities.VehicleType;

public interface VehicleTypeDao {
    VehicleType findByCd (int cdType);
}
