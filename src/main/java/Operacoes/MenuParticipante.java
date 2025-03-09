package Operacoes;

import java.util.Scanner;

public class MenuParticipante implements Interface {

    private final Scanner sc = new Scanner(System.in);
    private final AgendaEventos agenda;

    public MenuParticipante(AgendaEventos agenda) {
        this.agenda = agenda;
    }

    public void addParticipante(Participante participante) {
        agenda.addParticipante(participante);
    }

    private void showMenu() {
        System.out.println("\n-----------------------------");
        System.out.println("|   MENU DO PARTICIPANTE    |");
        System.out.println("|---------------------------|");
        System.out.println("| [1] ENCONTRAR EVENTO      |");
        System.out.println("| [2] VISUALIZAR EVENTOS    |");
        System.out.println("| [3] CANCELAR INSCRIÇÃO    |");
        System.out.println("| [4] SAIR                  |");
        System.out.println("-----------------------------");
    }

    public void operacoes() {
        int opMenu;

        do {
            showMenu();
            System.out.print("- Selecione: ");
            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número.");
                sc.next();
            }
            opMenu = sc.nextInt();
            sc.nextLine();

            switch (opMenu) {
                case 1:
                    System.out.println(inscEvento());
                    break;
                case 2:
                    eventos();
                    break;
                case 3:
                    System.out.println(cancelarInsc());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opMenu != 4);
    }

    private String inscEvento() {
        agenda.visuAgenda();
        System.out.print("Selecione o ID do evento que deseja se inscrever ou digite [0] para cancelar: ");

        while (!sc.hasNextInt()) {
            System.out.println("ID inválido! Digite um número.");
            sc.next();
        }

        int eventoSel = sc.nextInt();
        if (eventoSel == 0) {
            return "Voltando para o menu...";
        }

        return agenda.selecionarEvento(eventoSel);
    }

    private void eventos() {
        System.out.print("- Informe seu CPF: ");
        String doc = sc.nextLine();
        agenda.visuEventos(doc);
    }

    private String cancelarInsc() {
        System.out.print("- Informe seu CPF: ");
        String doc = sc.nextLine();
        agenda.visuEventos(doc);

        System.out.print("- Informe o ID do evento que deseja cancelar inscrição: ");

        while (!sc.hasNextInt()) {
            System.out.println("ID inválido! Digite um número.");
            sc.next();
        }

        int idEvento = sc.nextInt();
        return agenda.excInscricao(idEvento, doc);
    }
}
