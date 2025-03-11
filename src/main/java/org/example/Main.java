package org.example;

import Operacoes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Funcoes funcoes = new Funcoes();
        MenuGestor menuGestor = new MenuGestor();
        MenuParticipante menuParticipante = new MenuParticipante(menuGestor.agenda);

        // Instanciando gestores
        Gestor gestor1 = new Gestor("Marcos Antônio", "M445");
        Gestor gestor2 = new Gestor("Abigail Maria", "A422");
        Gestor.addGestor(gestor1);
        Gestor.addGestor(gestor2);

        // Instanciando eventos
        Evento evento1 = new Workshop("Mayara Silvia", "Segurança no Trabalho", "506", "28/03/2025", "14:00", 30);
        Evento evento2 = new Workshop("Mario Santos", "Métodos ágeis: SCRUM", "13", "03/04/2025", "10:30", 3);
        Evento evento3 = new Palestra("Jamile Dantas", "Majorana 1: Uma revolução para a Computação Quântica", "110", "15/03/2025", "14:00", 75);
        Evento evento4 = new Palestra("Mauricio José", "Inteligência Artificial", "512", "28/03/2025", "15:00", 65);
        Evento evento5 = new Congresso("Eduardo Miguel", "Summit de I.A. 2025", "14", "05/06/2025", "09:00", 150, "06/06/2025");
        menuGestor.addEventos(evento1);
        menuGestor.addEventos(evento2);
        menuGestor.addEventos(evento3);
        menuGestor.addEventos(evento4);
        menuGestor.addEventos(evento5);

        // Instanciando participantes
        Participante participante1 = new Participante("Marcelo Abreu", "111", evento2);
        Participante participante2 = new Participante("Jessica Amanda", "222", evento2);
        Participante participante3 = new Participante("Kauane Bianca", "333", evento3);
        Participante participante4 = new Participante("Marcelo Abreu", "111", evento3);
        Participante participante5 = new Participante("Kauane Bianca", "333", evento5);

        // Atualizando capacidades/vagas nos eventos
        evento2.atualizarCapacidade(evento2.getCapacidade()-2);
        evento3.atualizarCapacidade(evento3.getCapacidade()-2);
        evento5.atualizarCapacidade(evento5.getCapacidade()-1);

        menuParticipante.addParticipante(participante1);
        menuParticipante.addParticipante(participante2);
        menuParticipante.addParticipante(participante3);
        menuParticipante.addParticipante(participante4);
        menuParticipante.addParticipante(participante5);

        // variável para leitura da seleção no menu
        int opMenu;

        // Estrutura do-while para repetição do menu
        do {
            // chama função para mostrar as opções do menu
            funcoes.mostrarMenu();
            opMenu = sc.nextInt();
            System.out.println();
            switch (opMenu) {
                case 1: {
                    // operações para o gestor
                    System.out.println("Acessando área do Gestor...");
                    // chama função para verificar se o gestor existe
                    if (Gestor.encontrarGestor()) {
                        menuGestor.operacoes(); // direciona para as operações do gestor
                    } else {
                        System.out.println("Autenticação falhou");
                    }
                    break;
                }
                case 2: {
                    // direciona para as operações do participante
                    menuParticipante.operacoes();
                    break;
                }
                case 3: {
                    // sai do sistema
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