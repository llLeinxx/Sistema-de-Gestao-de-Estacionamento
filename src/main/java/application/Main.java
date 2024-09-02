package application;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.TicketDao;
import model.dao.VagaDao;
import model.dao.VehicleDao;
import model.entities.Gate;
import model.entities.Ticket;
import model.entities.Vaga;
import model.entities.VehicleType;

public class Main {
    public static void main(String[] args) {
        TicketDao ticketDao = DaoFactory.createTicketDao();
        VehicleDao vehicleDao = DaoFactory.createVehicleDao();
        VagaDao vagaDao = DaoFactory.createVagaDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o que você deseja fazer no sistema");
        System.out.println("1- Gerar ticket");
        System.out.println("2- Finalizar ticket");
        System.out.println("2- Cadastrar Veículos Mensais");
        int sys = sc.nextInt();
        switch (sys) {
            case 1: // gerar ticket
                System.out.println("Digite o Tipo do veiculo");
                int tipo = sc.nextInt();
                System.out.println("Digite a cancela que o veiculo vai entrar");
                int cancela = sc.nextInt();
                vagaDao.checkVaga();
                System.out.println("Digite a vaga: ");
                int vaga = sc.nextInt();
                Gate gate = new Gate();
                gate.setType(tipo);
                gate.setGate(cancela);
                gate.gateEntry();
                if (gate.isAcessoPermitido() == true){
                    ticketDao.insertTicket(tipo, cancela, vaga);}
                    vagaDao.checkDisponibilidadeVaga(vaga);
                break;
            case 2: // Finalizar ticket
                System.out.println("Digite o ticket do veiculo");
                int ticket = sc.nextInt();
                ticketDao.updateTicket(ticket);
                ticketDao.calculateTicket(ticket);
                break;
            case 3: // Cadastrar veiculo
                System.out.println("Digite a placa do veiculo");
                int placa = sc.nextInt();
                System.out.println("Digite o tipo do veiculo");
                int caTipo = sc.nextInt();
                System.out.println("Digite a categoria do veiculo");
                int categoria = sc.nextInt();
                vehicleDao.insertMensalista(placa, caTipo, categoria);

                break;
            default:
        }

    }
}