package model.entities;

import model.dao.DaoFactory;
import model.dao.VagaDao;

import java.util.Objects;
import java.util.Scanner;

public class Vaga {
    private int cdVaga;
    private boolean icVaga;

    VagaDao vagaDao = DaoFactory.createVagaDao();

    public Vaga(){

    }

    public Vaga(int cdVaga, boolean icVaga) {
        this.cdVaga = cdVaga;
        this.icVaga = icVaga;
    }

    public int getCdVaga() {
        return cdVaga;
    }

    public void setCdVaga(int cdVaga) {
        this.cdVaga = cdVaga;
    }

    public boolean isIcVaga() {
        return icVaga;
    }

    public void setIcVaga(boolean icVaga) {
        this.icVaga = icVaga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaga vaga)) return false;
        return getCdVaga() == vaga.getCdVaga();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCdVaga());
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "cdVaga=" + cdVaga +
                ", icVaga=" + icVaga +
                '}';
    }

}
