package org.example.Operacoes;

import java.util.Scanner;

public class MenuGestor implements Interface {

    private final Scanner sc = new Scanner(System.in);
    public AgendaEventos agenda = new AgendaEventos(); // Instancia um objeto de agenda para gerenciar eventos

    // Metodo para adicionar eventos à agenda
    public void addEventos(Evento evento) {
        agenda.addEvento(evento);
    }

    // Metodo para exibir o menu do gestor
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

    // Metodo principal para gerenciar as operações do menu
    public void operacoes() {
        MenuParticipante menuParticipante = new MenuParticipante(agenda); // Compartilha a agenda com o menu de participantes
        int opMenu;
        do {
            showMenu(); // Exibe o menu
            opMenu = sc.nextInt();
            sc.nextLine();

            switch (opMenu) {
                case 1:
                    cadastrarEvento(); // Chama o metodo para cadastrar um evento
                    break;
                case 2:
                    agenda.atualizarInfoEvento(); // Atualiza informações de um evento existente
                    break;
                case 3:
                    agenda.visuParticipantes(); // Exibe os participantes de um evento
                    break;
                case 4:
                    agenda.visuAgenda(); // Mostra todos os eventos cadastrados
                    break;
                case 5:
                    System.out.println("Saindo..."); // Encerra o programa
                    break;
                default:
                    System.out.println("Operação inválida."); // Mensagem para opções inválidas
            }
        } while (opMenu != 5); // Continua até que o usuário escolha sair
    }

    // Metodo para cadastrar um novo evento
    private void cadastrarEvento() {
        System.out.println("\n---- CADASTRO DE EVENTO ----");
        System.out.println("- [1] PALESTRA");
        System.out.println("- [2] WORKSHOP");
        System.out.println("- [3] CONGRESSO");
        System.out.print("- Escolha o tipo de evento: ");
        int tipoEvento = sc.nextInt();
        sc.nextLine();

        // Captura os dados comuns a todos os eventos
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
        sc.nextLine(); // Limpa o buffer

        Evento novoEvento;
        if (tipoEvento == 1) {
            // Criação de uma palestra
            novoEvento = new Palestra(nome, tema, local, data, horario, capacidade);
            System.out.println("\n- Palestra cadastrada com sucesso!\n");
        } else if (tipoEvento == 2) {
            // Criação de um workshop
            novoEvento = new Workshop(nome, tema, local, data, horario, capacidade);
            System.out.println("\n- Workshop cadastrado com sucesso!\n");
        } else if (tipoEvento == 3) {
            // Criação de um congresso (requer data de término adicional)
            System.out.println("- Data de término: ");
            String dataTermino = sc.nextLine();
            novoEvento = new Congresso(nome, tema, local, data, horario, capacidade, dataTermino);
            System.out.println("\n- Congresso cadastrado com sucesso!\n");
        } else {
            System.out.println("- Opção inválida! Cadastro cancelado."); // Mensagem de erro
            return;
        }

        agenda.addEvento(novoEvento); // Adiciona o evento à agenda
    }
}
