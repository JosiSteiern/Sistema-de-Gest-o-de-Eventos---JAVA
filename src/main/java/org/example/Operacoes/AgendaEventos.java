package org.example.Operacoes;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class AgendaEventos {

    // Listas para armazenar as informações dos eventos cadastrados e dos participantes
    private List<Evento> eventos = new ArrayList<>();
    private List<Participante> participantesEventos = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    // Utilizado para a ordenação dos eventos por data
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void addEvento(Evento evento) {
        eventos.add(evento);
    }

    public void addParticipante(Participante participante) {
        participantesEventos.add(participante);
    }

    public void visuAgenda() {
        System.out.println("----------------------- AGENDA DE EVENTOS -----------------------");
        mostrarEventos();
    }

    public void mostrarEventos() {
        // Ordena a lista de eventos para apresentar para o usuário separando por palestras e workshops, além de ordenar por ordem de datas
        eventos.sort(Comparator.comparing((Evento e) -> !(e instanceof Palestra)).thenComparing(e -> LocalDate.parse(e.getData(), formatter)));
        for (Evento evento : eventos) {
            // chama o metodo abstrarto exibirDetalhes utilizando polimorfismo
            evento.exibirDetalhes();
        }
    }

    private void menuAtualizar() {
        System.out.println("---------- ATUALIZAR INFORMAÇÕES ----------");
        System.out.println("- [1] Local                               -");
        System.out.println("- [2] Data                                -");
        System.out.println("- [3] Horário                             -");
        System.out.println("- Selecione a opção que deseja atualizar: ");
    }

    public void atualizarInfoEvento() {
        mostrarEventos();
        System.out.println("- Informe o ID do evento que deseja alterar: ");
        int idSelecionado = sc.nextInt();
        sc.nextLine();

        for (Evento evento : eventos) {
            // encontra o evento pelo ID selecionado
            if (evento.getId() == idSelecionado) {
                menuAtualizar();
                int opAtualizar = sc.nextInt();
                sc.nextLine();

                switch (opAtualizar) {
                    case 1:
                        System.out.println("- Informe o novo Local do evento: ");
                        evento.setLocal(sc.nextLine());
                        System.out.println("Informação atualizada com sucesso!");
                        break;
                    case 2:
                        System.out.println("- Informe a nova data do evento: ");
                        evento.setData(sc.nextLine());
                        System.out.println("Informação atualizada com sucesso!");
                        break;
                    case 3:
                        System.out.println("- Informe o novo horário do evento: ");
                        evento.setHorario(sc.nextLine());
                        System.out.println("Informação atualizada com sucesso!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                return;
            }
        }
        System.out.println("Evento não encontrado.");
    }

    public String selecionarEvento(int idEvento) {
        for (Evento evento : eventos) {
            if (idEvento == evento.getId()) {
                // Verifica o status do evento, caso esteja como LOTADO, o sistema retorna para o menu para que o usuário escolha outro evento
                if (evento.getStatus() == Vagas.LOTADO) {
                    return "- Evento lotado, por favor selecione outro.";
                }

                System.out.println("- Evento selecionado: " + evento.getTitulo());
                System.out.println("- Informe seu nome: ");
                String nomePart = sc.nextLine();
                System.out.println("- Informe seu CPF: ");
                String docPart = sc.nextLine();
                System.out.println();

                // chama a função de verifica se o participante já está inscrito no evento utilizando o documento, caso sim(true), retorna para o menu
                if (verificaEvento(docPart)) {
                    return "Participante já inscrito no evento selecionado.";
                }

                evento.atualizarCapacidade(evento.getCapacidade() - 1); // atualiza a capacidade no evento

                // cria um novo objeto e adiciona na lista de participantes, passando nome, documento e obj Evento como parâmetros
                Participante participante = new Participante(nomePart, docPart, evento);
                participantesEventos.add(participante);
                return "Inscrição realizada com sucesso!";
            }
        }
        return "Algo deu errado, tente novamente mais tarde.";
    }

    // Função para verficar se o participante já está inscrito no evento. Parcorre a lista de participantes e tenta encontrar o doc. Caso sim, retorna true, caso não retorna false
    private boolean verificaEvento(String doc) {
        for (Participante participante : participantesEventos) {
            if (doc.equals(participante.getDocParticipante())) {
                return true;
            }
        }
        return false;
    }

    // Metodo para mostrar os eventos em que o participante está inscrito
    public void visuEventos(String doc) {
        boolean encontrou = false; // variável para verificar se o evento foi encontrado
        for (Participante participante : participantesEventos) {
            // procura se o doc está cadastrado no evento
            if (doc.equals(participante.getDocParticipante())) {
                if (!encontrou) {
                    // Atualiza a variável para true
                    System.out.println("---------- EVENTOS INSCRITOS -----------");
                    encontrou = true;
                }
                participante.getEvento().exibirDetalhes(); // mostra o evento
            }
        }
        // caso não encontre
        if (!encontrou) {
            System.out.println("Você não está inscrito em nenhum evento.");
        }
    }

    // metodo para o participante excluir a inscrição em algum evento, recebe o ID do evento selecionado e o doc do participante
    public String excInscricao(int id, String doc) {
        for(Participante participante : participantesEventos) {
            // verifica se o documento e o ID da palestra estão no mesmo obj
            if (doc.equals(participante.getDocParticipante()) && id == participante.getEvento().getId()) {
                participantesEventos.remove(participante); // remove obj da lista

                // atualiza a capacidade do evento para +1
                for (Evento evento : eventos) {
                    if (id == evento.getId()) {
                        evento.atualizarCapacidade(evento.getCapacidade() + 1);
                    }
                }
                return "Inscrição cancelada com sucesso!";
            }
        }
        return "Inscrição ou evento não encontrado.";
    }

    // metodo para o gestor visualizar os participantes inscritos em eventos
    public void visuParticipantes() {
        System.out.println();
        // verifica se a lista está vazia
        if (participantesEventos.isEmpty()) {
            System.out.println("Nenhum participante cadastrado!");
            return;
        }

        // mostra os participantes e eventos inscitos
        for (Participante participante : participantesEventos) {
            System.out.println("- Participante: " + participante.getNomeParticipante());
            if (participante.getEvento() != null) {
                System.out.println("- Evento inscrito: " + participante.getEvento().getTitulo() + " - " + participante.getEvento().getData());
            } else {
                System.out.println("- Nenhum evento inscrito.");
            }
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }
}
