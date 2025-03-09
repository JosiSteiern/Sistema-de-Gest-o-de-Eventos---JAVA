package Operacoes;

import java.util.Scanner;

public class MenuGestor implements Interface {

    private final Scanner sc = new Scanner(System.in);
    public AgendaEventos agenda = new AgendaEventos();

    public void addEventos(Evento evento) {
        agenda.addEvento(evento);
    }

    private void showMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("|          MENU GESTOR             |");
        System.out.println("|----------------------------------|");
        System.out.println("| [1] CADASTRAR EVENTO             |");
        System.out.println("| [2] ATUALIZAR INFO DE EVENTO     |");
        System.out.println("| [3] VISUALIZAR PARTICIPANTES     |");
        System.out.println("| [4] VISUALIZAR AGENDA DE EVENTOS |");
        System.out.println("| [5] SAIR                         |");
        System.out.println("------------------------------------");
        System.out.print("- Selecione: ");
    }

    public void operacoes() {
        MenuParticipante menuParticipante = new MenuParticipante(agenda);
        int opMenu;
        do {
            showMenu();
            opMenu = sc.nextInt();
            sc.nextLine();

            switch (opMenu) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    agenda.atualizarInfoEvento();
                    break;
                case 3:
                    agenda.visuParticipantes();
                    break;
                case 4:
                    agenda.visuAgenda();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } while (opMenu != 5);
    }

    private void cadastrarEvento() {
        System.out.println("\n---- CADASTRO DE EVENTO ----");
        System.out.println("- [1] PALESTRA");
        System.out.println("- [2] WORKSHOP");
        System.out.print("- Escolha o tipo de evento: ");
        int tipoEvento = sc.nextInt();
        sc.nextLine();

        System.out.print("- Nome do palestrante/organizador: ");
        String nome = sc.nextLine();
        System.out.print("- Tema/Assunto do evento: ");
        String tema = sc.nextLine();
        System.out.print("- Local (sala/auditório): ");
        String local = sc.nextLine();
        System.out.print("- Data (dd/mm/aaaa): ");
        String data = sc.nextLine();
        System.out.print("- Horário: ");
        String horario = sc.nextLine();
        System.out.print("- Capacidade máxima: ");
        int capacidade = sc.nextInt();
        sc.nextLine();

        Evento novoEvento;
        if (tipoEvento == 1) {
            novoEvento = new Palestra(nome, tema, local, data, horario, capacidade);
            System.out.println("\n- Palestra cadastrada com sucesso!\n");
        } else if (tipoEvento == 2) {
            novoEvento = new Workshop(nome, tema, local, data, horario, capacidade);
            System.out.println("\n- Workshop cadastrado com sucesso!\n");
        } else {
            System.out.println("- Opção inválida! Cadastro cancelado.");
            return;
        }

        agenda.addEvento(novoEvento);
    }
}
