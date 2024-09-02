package model.dao;

import model.entities.Ticket;
import model.entities.Vaga;

public interface VagaDao {
    void checkVaga();
    void checkDisponibilidadeVaga(int ckVaga);
}
