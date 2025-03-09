package org.example;

import Operacoes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Funcoes funcoes = new Funcoes();
        MenuGestor menuGestor = new MenuGestor();
        MenuParticipante menuParticipante = new MenuParticipante(menuGestor.agenda);

        Gestor gestor1 = new Gestor("Marcos Antônio", "M445");
        Gestor gestor2 = new Gestor("Abigail Maria", "A422");
        Gestor.addGestor(gestor1);
        Gestor.addGestor(gestor2);

        Evento evento1 = new Workshop("Mayara Silvia", "Segurança no Trabalho", "506", "28/03/2025", "14:00", 30);
        Evento evento2 = new Workshop("Mario Santos", "Métodos ágeis: SCRUM", "13", "03/04/2025", "10:30", 3);
        Evento evento3 = new Palestra("Jamile Dantas", "Majorana 1: Uma revolução para a Computação Quântica", "110", "15/03/2025", "14:00", 75);
        Evento evento4 = new Palestra("Mauricio José", "Inteligência Artificial", "512", "28/03/2025", "15:00", 65);
        menuGestor.addEventos(evento1);
        menuGestor.addEventos(evento2);
        menuGestor.addEventos(evento3);
        menuGestor.addEventos(evento4);

        Participante participante1 = new Participante("Marcelo Abreu", "111", evento2);
        Participante participante2 = new Participante("Jessica Amanda", "222", evento2);
        Participante participante3 = new Participante("Kauane Bianca", "333", evento3);
        Participante participante4 = new Participante("Marcelo Abreu", "111", evento3);

        evento2.atualizarCapacidade(evento2.getCapacidade()-2);
        evento3.atualizarCapacidade(evento3.getCapacidade()-2);

        menuParticipante.addParticipante(participante1);
        menuParticipante.addParticipante(participante2);
        menuParticipante.addParticipante(participante3);
        menuParticipante.addParticipante(participante4);

        int opMenu;

        do {
            funcoes.mostrarMenu();
            opMenu = sc.nextInt();
            System.out.println();
            switch (opMenu) {
                case 1: {
                    System.out.println("Acessando área do Gestor...");
                    if (Gestor.encontrarGestor()) {
                        menuGestor.operacoes();
                    } else {
                        System.out.println("Autenticação falhou");
                    }
                    break;
                }
                case 2: {
                    menuParticipante.operacoes();
                    break;
                }
                case 3: {
                    System.out.println("Saindo...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida, selecione novamente.");
                    break;
                }
            }
        } while (opMenu!=3);
    }
}

class Funcoes{

    public void mostrarMenu(){
        System.out.println("---- UA EVENTOS ----");
        System.out.println("- [1] GESTOR       -");
        System.out.println("- [2] PARTICIPANTE -");
        System.out.println("- [3] SAIR         -");
        System.out.println("--------------------");
        System.out.println("Selecione: ");
    }

}