package Operacoes;

public abstract class Evento {
    private int id;
    private String titulo;
    private String local;
    private String data;
    private String horario;
    private int capacidade;
    private Vagas status;

    private static int ContadorId = 1;

    public Evento(String titulo, String local, String data, String horario, int capacidade) {
        this.id = ContadorId++;
        this.titulo = titulo;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.capacidade = capacidade;
        this.status = Vagas.ABERTO;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getLocal() { return local; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public int getCapacidade() { return capacidade; }
    public Vagas getStatus() { return status; }

    public void setLocal(String local) { this.local = local; }
    public void setData(String data) { this.data = data; }
    public void setHorario(String horario) { this.horario = horario; }

    public void atualizarCapacidade(int novaCapacidade) {
        this.capacidade = novaCapacidade;
        if (capacidade <= 0) {
            this.status = Vagas.LOTADO;
        } else {
            this.status = Vagas.ABERTO;
        }
    }


    public abstract void exibirDetalhes();
}
