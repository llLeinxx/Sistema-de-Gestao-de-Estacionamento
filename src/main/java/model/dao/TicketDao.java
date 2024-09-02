package model.dao;

import model.entities.Ticket;
import model.entities.VehicleType;

import java.util.List;

public interface TicketDao {
    void insertTicket(int cdTicket, int cdGate, int cdVaga);
    void updateTicket(int cdTicket);
    Ticket calculateTicket(int cdTicket);

    List<Ticket> findByVehicleType(VehicleType vehicleType);
}
