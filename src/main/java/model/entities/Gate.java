package model.entities;

import db.DB;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Gate implements Serializable {

    private static final long serialVersionUID = 1L;
    private boolean acessoPermitido = false;
    private int gate;

    public boolean isAcessoPermitido() {
        return acessoPermitido;
    }

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Gate(){


    }

    public Gate(int gate) {
        this.gate = gate;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gate gate1)) return false;
        return getGate() == gate1.getGate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGate());
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gate=" + gate +
                '}';
    }

    public void gateEntry(){

        switch (type) {
            case 1: // Carro
                acessoPermitido = true;
                break;
            case 2: // Caminhão
                acessoPermitido = (gate == 1 || (gate >= 6 && gate <= 10));
                break;
            case 3: // Moto
                acessoPermitido = (gate == 5 && gate == 10);
                break;
            case 4: // Serviço Público
                acessoPermitido = true;
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
        }
        if (acessoPermitido) {
            System.out.println("Pode acessar pela cancela");
        } else {
            System.out.println("O veiculo não é permitido nessa cancela.");
        }

    }


    }

