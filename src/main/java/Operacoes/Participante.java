package Operacoes;

public class Participante {

    // Classe participante deve conter nome, documento e o evento selecionado
    private String nomeParticipante;
    private String docParticipante;
    private Evento evento;

    // construtor que recebe as informações
    public Participante(String nomeParticipante, String docParticipante, Evento evento) {
        this.nomeParticipante = nomeParticipante;
        this.docParticipante = docParticipante;
        this.evento = evento;
    }

    // GETTER para ter acesso às infos
    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public String getDocParticipante() {
        return docParticipante;
    }

    public Evento getEvento() {
        return evento;
    }
}
