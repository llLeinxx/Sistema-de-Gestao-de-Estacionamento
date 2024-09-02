package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.VehicleTypeDao;
import model.entities.VehicleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

public class VehicleTypeDaoJDBC implements VehicleTypeDao {
    private Connection conn;
    public VehicleTypeDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public VehicleType findByCd(int cdType) {
        return null;
    }
}
