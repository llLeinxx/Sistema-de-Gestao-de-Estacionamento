package org.example;
import java.sql.Connection;
import java.util.Scanner;

import db.DB;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // System.out.print("Digite o codigo do ticket");
        //int valor1 = sc.nextInt();

        System.out.println("Digite o tipo do veiculo:");
        int valor2 = sc.nextInt();

        ticket cd = new ticket();
       // cd.setTicket(valor1);
        cd.setTipoVeiculo(valor2);
        cd.cadastrarTicket();
        //cd.finalizarTicket();
    }
}