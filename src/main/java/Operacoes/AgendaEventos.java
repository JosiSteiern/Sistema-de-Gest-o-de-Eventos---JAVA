package Operacoes;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class AgendaEventos {

    private List<Evento> eventos = new ArrayList<>();
    private List<Participante> participantesEventos = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public void addEvento(Evento evento) {
        eventos.add(evento);
    }

    public void addParticipante(Participante participante) {
        participantesEventos.add(participante);
    }

    public void visuAgenda() {
        System.out.println("----------- AGENDA DE EVENTOS -----------");
        mostrarEventos();
    }

    public void mostrarEventos() {
        eventos.sort(Comparator.comparing((Evento e) -> !(e instanceof Palestra)).thenComparing(e -> LocalDate.parse(e.getData(), formatter)));
        for (Evento evento : eventos) {
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
                if (evento.getStatus() == Vagas.LOTADO) {
                    return "- Evento lotado, por favor selecione outro.";
                }

                System.out.println("- Evento selecionado: " + evento.getTitulo());
                System.out.println("- Informe seu nome: ");
                String nomePart = sc.nextLine();
                System.out.println("- Informe seu CPF: ");
                String docPart = sc.nextLine();
                System.out.println();

                if (verificaEvento(docPart)) {
                    return "Participante já inscrito no evento selecionado.";
                }

                evento.atualizarCapacidade(evento.getCapacidade() - 1);

                Participante participante = new Participante(nomePart, docPart, evento);
                participantesEventos.add(participante);
                return "Inscrição realizada com sucesso!";
            }
        }
        return "Algo deu errado, tente novamente mais tarde.";
    }

    private boolean verificaEvento(String doc) {
        for (Participante participante : participantesEventos) {
            if (doc.equals(participante.getDocParticipante())) {
                return true;
            }
        }
        return false;
    }

    public void visuEventos(String doc) {
        boolean encontrou = false;
        for (Participante participante : participantesEventos) {
            if (doc.equals(participante.getDocParticipante())) {
                if (!encontrou) {
                    System.out.println("---------- EVENTOS INSCRITOS -----------");
                    encontrou = true;
                }
                participante.getEvento().exibirDetalhes();
            }
        }
        if (!encontrou) {
            System.out.println("Você não está inscrito em nenhum evento.");
        }
    }

    public String excInscricao(int id, String doc) {
        for(Participante participante : participantesEventos) {
            if (doc.equals(participante.getDocParticipante()) && id == participante.getEvento().getId()) {
                participantesEventos.remove(participante);

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

    public void visuParticipantes() {
        if (participantesEventos.isEmpty()) {
            System.out.println("Nenhum participante cadastrado!");
            return;
        }

        for (Participante participante : participantesEventos) {
            System.out.println("- Participante: " + participante.getNomeParticipante());
            if (participante.getEvento() != null) {
                System.out.println("- Evento inscrito: " + participante.getEvento().getTitulo() + " - " + participante.getEvento().getData());
            } else {
                System.out.println("- Nenhum evento inscrito.");
            }
            System.out.println("----------------------------------------------------------------");
        }
    }
}
