package model.dao.impl;

import db.DB;
import model.dao.VagaDao;
import model.entities.Vaga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VagaDaoJDBC implements VagaDao {
    private Connection conn;
    public VagaDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void checkVaga() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT cd_vaga FROM vaga WHERE ic_vaga = 0");
            rs = st.executeQuery();
            System.out.println("Vagas disponiveis: ");
            while (rs.next()){

                System.out.println(rs.getInt("cd_vaga"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void checkDisponibilidadeVaga(int ckVaga) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT ic_vaga FROM vaga WHERE cd_vaga = ?");
            st.setInt(1, ckVaga);
            rs = st.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                // 5. Atualizar o status da vaga
                st = conn.prepareStatement(
                        "UPDATE vaga SET ic_vaga = 1 WHERE cd_vaga = ?");
                st.setInt(1, ckVaga);
                st.executeUpdate();
                System.out.println("Veículo inserido na vaga " + ckVaga + "!");
            } else {
                System.out.println("A vaga " + ckVaga + " já está ocupada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
        }
    }
}
