package org.example.Operacoes;

// Classe abstrata que representa um evento genérico
public abstract class Evento {
    private int id; // Identificador único do evento
    private String titulo; // Título do evento
    private String local; // Local onde o evento será realizado
    private String data; // Data do evento
    private String horario; // Horário do evento
    private int capacidade; // Capacidade máxima de participantes
    private Vagas status; // Status do evento (Aberto ou Lotado)

    private static int ContadorId = 1; // Contador para gerar IDs únicos

    // Construtor da classe Evento
    public Evento(String titulo, String local, String data, String horario, int capacidade) {
        this.id = ContadorId++; // Atribui um ID e incrementa o contador
        this.titulo = titulo;
        this.local = local;
        this.data = data;
        this.horario = horario;
        this.capacidade = capacidade;
        this.status = Vagas.ABERTO; // define o evento como aberto para inscrições
    }

    // Métodos getters para acessar os atributos da classe
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getLocal() { return local; }
    public String getData() { return data; }
    public String getHorario() { return horario; }
    public int getCapacidade() { return capacidade; }
    public Vagas getStatus() { return status; }

    // Métodos setters para modificar alguns atributos
    public void setLocal(String local) { this.local = local; }
    public void setData(String data) { this.data = data; }
    public void setHorario(String horario) { this.horario = horario; }

    // Metodo para atualizar a capacidade do evento
    public void atualizarCapacidade(int novaCapacidade) {
        this.capacidade = novaCapacidade;
        // Se a capacidade for 0 ou menor, define o status como LOTADO
        if (capacidade <= 0) {
            this.status = Vagas.LOTADO;
        } else {
            this.status = Vagas.ABERTO;
        }
    }

    // Metodo abstrato que será implementado nas classes filhas para exibir detalhes do evento
    public abstract void exibirDetalhes();
}
