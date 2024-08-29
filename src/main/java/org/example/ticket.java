package org.example;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ticket {

    Connection conn = null;
    PreparedStatement st = null;
    private int ticket;
    private int tipoVeiculo;
    private double hrSainda;

    public ticket() {
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public double getHrSainda() {
        return hrSainda;
    }

    public void setHrSainda(double hrSainda) {
        this.hrSainda = hrSainda;
    }

    public void cadastrarTicket(){
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeFormatted = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));


        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO ticket (cd_ticket, cd_tipo_veiculo, hr_entrada, dt_entrada) VALUES (?, ?, ?, ?)", 1);
            st.setInt(1, ticket);
            st.setInt(2, tipoVeiculo);
            st.setString(3, timeFormatted);
            st.setString(4, dateFormatted);

            int var3 = st.executeUpdate();
        } catch (SQLException var7) {
            var7.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
