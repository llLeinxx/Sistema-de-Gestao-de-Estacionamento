package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.TicketDao;
import model.entities.Ticket;
import model.entities.VehicleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketDaoJDBC implements TicketDao{
    private Connection conn;
    public TicketDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insertTicket(int cdTicket, int cdGate, int cdVaga) {
        PreparedStatement st = null;
        ResultSet rs = null;
        LocalDateTime now = LocalDateTime.now();
        String dateTimeFormatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            st = conn.prepareStatement("INSERT INTO Ticket (cd_tipo_veiculo, dt_entrada, cd_gateEntrada, cd_vaga) VALUES (?, ?, ?, ?)");
            st.setInt(1, cdTicket);
            st.setString(2, dateTimeFormatted);
            st.setInt(3, cdGate);
            st.setInt(4, cdVaga);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void updateTicket(int cdTicket) {
        PreparedStatement st = null;
        ResultSet rs = null;
        LocalDateTime now = LocalDateTime.now();
        String dateTimeFormatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("UPDATE Ticket set dt_saida = ? WHERE cd_ticket = ?");
            st.setString(1, dateTimeFormatted);
            st.setInt(2, cdTicket);
            st.executeUpdate();
        } catch(SQLException a) {
            a.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
        }


    }

    @Override
    public Ticket calculateTicket(int cdTicket) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select dt_entrada, dt_saida " +
                    "from Ticket where cd_ticket = ?");
            st.setInt(1, cdTicket);
            rs = st.executeQuery();

            if (rs.next()){
                LocalDateTime dtSaida = rs.getTimestamp("dt_saida").toLocalDateTime();
                LocalDateTime dtEntrada = rs.getTimestamp("dt_entrada").toLocalDateTime();

                System.out.println("Data de Entrada: " + dtEntrada);
                System.out.println("Data de Saida: " + dtSaida);

                Duration duracaoTicket = Duration.between(dtEntrada, dtSaida);
                long horas = duracaoTicket.toHours();
                long minutes = duracaoTicket.toMinutes() % 60;

                if (minutes > 50 || horas > 0){
                    double totalPayable;
                    totalPayable = ((horas * 60) + minutes)* 0.10;
                    System.out.println("Tempo entre entrada e saída: " + horas + " horas e " + minutes + " minutos");
                    System.out.println("Total a pagar: " + totalPayable);
                }else {
                    System.out.println("Valor minimo a pagar R$5.00");
                }


            }else {
                System.out.println("Nenhum Ticket encontrado");
            }

        } catch(SQLException e) {
          throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public List<Ticket> findByVehicleType(VehicleType vehicleType) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("select t.cd_ticket, tv.cd_tipo_veiculo, tv.nm_tipo_veiculo from ticket t " +
                    "join tipo_veiculo tv on t.cd_tipo_veiculo = tv.cd_tipo_veiculo where t.cd_ticket = ?");
            st.setInt(1, vehicleType.getCdType());
            rs = st.executeQuery();
            List<Ticket> list = new ArrayList<>();
            Map<Integer, VehicleType> map = new HashMap<>();
            while (rs.next()){

                VehicleType vt = map.get(rs.getInt("cd_tipo_veiculo"));

                if (vt == null){

                    vt = instantiateVehicleType(rs);
                    map.put(rs.getInt("cd_tipo_veiculo"), vt);
                }
                Ticket tc = instantiateTicket(rs, vt);
                list.add(tc);
            }
            return list;
        } catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }

    private VehicleType instantiateVehicleType(ResultSet rs) throws SQLException{
        VehicleType vt = new VehicleType();
        vt.setCdType(rs.getInt("cd_tipo_veiculo"));
        vt.setNmType(rs.getString("nm_tipo_veiculo"));
        return vt;
    }

    private Ticket instantiateTicket(ResultSet rs, VehicleType vt) throws SQLException {
        Ticket tc = new Ticket();
        tc.setCdTicket(rs.getInt("cd_ticket"));
        tc.setVehicleType(vt);
        return tc;
    }
}
