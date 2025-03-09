package Operacoes;

public class Workshop extends Evento {
    private String instrutor;

    public Workshop(String instrutor, String titulo, String local, String data, String horario, int capacidade) {
        super(titulo, local, data, horario, capacidade);
        this.instrutor = instrutor;
    }

    public String getInstrutor() {
        return instrutor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("- ID: [" + getId() + "]");
        System.out.println("- Workshop: " + getTitulo());
        System.out.println("- Instrutor: " + instrutor);
        System.out.println("- Local: " + getLocal());
        System.out.println("- Data: " + getData());
        System.out.println("- Horário: " + getHorario());
        System.out.println("- Status: " + getStatus());
        System.out.println("---------------------------------");
    }
}
