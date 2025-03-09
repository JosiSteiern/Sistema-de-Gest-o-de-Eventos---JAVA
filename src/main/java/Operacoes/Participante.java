package Operacoes;

public class Participante {

    private String nomeParticipante;
    private String docParticipante;
    private Evento evento;

    public Participante(String nomeParticipante, String docParticipante, Evento evento) {
        this.nomeParticipante = nomeParticipante;
        this.docParticipante = docParticipante;
        this.evento = evento;
    }

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
