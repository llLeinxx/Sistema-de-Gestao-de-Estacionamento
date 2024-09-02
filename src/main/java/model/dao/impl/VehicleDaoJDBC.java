package model.dao.impl;

import db.DB;
import model.dao.VehicleDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VehicleDaoJDBC implements VehicleDao {
    private Connection conn;
    public VehicleDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insertMensalista(int cdPlaca, int cdTipo, int cdCategoria) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("INSERT INTO veiculo (cd_Placa_veiculo, cd_tipo_veiculo, cd_categoria) VALUES (?, ?, ?)");
            st.setInt(1, cdPlaca);
            st.setInt(2, cdTipo);
            st.setInt(3, cdCategoria);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }
}
