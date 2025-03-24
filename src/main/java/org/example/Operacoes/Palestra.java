package org.example.Operacoes;

public class Palestra extends Evento {
    private String nomePalestrante;

    public Palestra(String nomePalestrante, String titulo, String local, String data, String horario, int capacidade) {
        super(titulo, local, data, horario, capacidade);
        this.nomePalestrante = nomePalestrante;
    }

    public String getNomePalestrante() {
        return nomePalestrante;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("- ID: [" + getId() + "]");
        System.out.println("- Palestra: " + getTitulo());
        System.out.println("- Palestrante: " + nomePalestrante);
        System.out.println("- Local: " + getLocal());
        System.out.println("- Data: " + getData());
        System.out.println("- Horário: " + getHorario());
        System.out.println("- Status: " + getStatus());
        System.out.println("------------------------------------------------------------");
    }
}
