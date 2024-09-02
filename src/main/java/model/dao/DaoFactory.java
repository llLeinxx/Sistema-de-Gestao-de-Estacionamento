package model.dao;

import db.DB;
import model.dao.impl.TicketDaoJDBC;
import model.dao.impl.VagaDaoJDBC;
import model.dao.impl.VehicleDaoJDBC;

public class DaoFactory {
    public static TicketDao createTicketDao(){
        return new TicketDaoJDBC(DB.getConnection());

    }
    public static VehicleDao createVehicleDao(){
        return new VehicleDaoJDBC(DB.getConnection());

    }

    public static VagaDao createVagaDao(){
        return new VagaDaoJDBC(DB.getConnection());
    }
}
