package org.example.Operacoes;

import java.util.Scanner;

public class MenuParticipante implements Interface {

    // definindo Scanner para uso nas classes
    private final Scanner sc = new Scanner(System.in);
    private final AgendaEventos agenda; // instancia da classe AgendaEventos

    // construtor que recebe a mesma instancia de agenda utilizada no menu dos gestores
    public MenuParticipante(AgendaEventos agenda) {
        this.agenda = agenda;
    }

    // metodo para adicionar novo participante
    public void addParticipante(Participante participante) {
        agenda.addParticipante(participante); //
    }

    // menu de operações
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
            opMenu = sc.nextInt();
            sc.nextLine(); // Para não pular leitura de uma variável String

            switch (opMenu) {
                case 1:
                    // chama a função para o participante se inscrever em um evento, e printa o retorno
                    System.out.println(inscEvento());
                    break;
                case 2:
                    // chama a função para mostrar os eventos em que o participante está inscrito
                    eventos();
                    break;
                case 3:
                    // chama a função para cancelar inscrição e printa o retorno da func.
                    System.out.println(cancelarInsc());
                    break;
                case 4:
                    // retorna para o menu principal
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opMenu != 4);
    }

    private String inscEvento() {
        // chama o metodo para visualizar os enventos disponíveis
        agenda.visuAgenda();
        System.out.print("Selecione o ID do evento que deseja se inscrever ou digite [0] para cancelar: ");

        int eventoSel = sc.nextInt();
        if (eventoSel == 0) {
            // caso usuário digite 0, retorna para o menu principal
            return "Voltando para o menu...";
        }
        // chama e retorna a mensagem do metodo selecionarEvento
        return agenda.selecionarEvento(eventoSel);
    }

    private void eventos() {
        // recebe o cpf do participante para mostrar apenas os eventos em que o participante está inscrito
        System.out.print("- Informe seu CPF: ");
        String doc = sc.nextLine();
        agenda.visuEventos(doc); // chama o metodo passando o doc
    }

    private String cancelarInsc() {
        // recebe o cpf do participante para mostrar apenas os eventos em que o participante está inscrito
        System.out.print("- Informe seu CPF: ");
        String doc = sc.nextLine();
        agenda.visuEventos(doc); // chama o metodo passando o doc

        // solicita que o usuário informe o ID da palestra que deseja cancelar
        System.out.print("- Informe o ID do evento que deseja cancelar inscrição: ");

        int idEvento = sc.nextInt();
        return agenda.excInscricao(idEvento, doc); // chama o metodo para excluir a inscrição e retorna uma msg
    }
}
