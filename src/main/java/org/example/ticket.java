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
        String timeFormatted = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO ticket (cd_tipo_veiculo, hr_entrada, dt_entrada) VALUES (?, ?, ?)");
           // st.setInt(1, ticket);
            st.setInt(1, tipoVeiculo);
            st.setString(2, timeFormatted);
            st.setString(3, dateFormatted);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
    public void finalizarTicket(){
        LocalDateTime now = LocalDateTime.now();
        String dateFormatted2 = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String timeFormatted2 = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("UPDATE ticket set hr_saida = ?, dt_saida = ? WHERE cd_ticket = ?");
            st.setString(1, timeFormatted2);
            st.setString(2, dateFormatted2);
            st.setInt(3, ticket);
            st.executeUpdate();
        } catch(SQLException a) {
            a.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
