package org.example.Operacoes;

// A classe Congresso estende a classe Evento, ou seja, herda suas propriedades e métodos.
public class Congresso extends Evento {
    // Atributos específicos da classe Congresso.
    private String nomeCoordenador; // Nome do coordenador do congresso.
    private String dataTermino; // Data de término do congresso.

    // Construtor da classe Congresso. Ele chama o construtor da classe pai (Evento) usando 'super'
    // e inicializa os atributos específicos dessa classe (nomeCoordenador e dataTermino).
    public Congresso(String nome, String titulo, String local, String data, String horario, int capacidade, String dataTermino) {
        super(titulo, local, data, horario, capacidade); // Chama o construtor da classe Evento.
        this.nomeCoordenador = nome; // Inicializa o nome do coordenador.
        this.dataTermino = dataTermino; // Inicializa a data de término.
    }

    // Getter para o nome do coordenador.
    public String getNomePalestrante() {
        return nomeCoordenador;
    }

    // Getter para a data de término.
    public String getDataTermino() {
        return dataTermino;
    }

    // Metodo sobrescrito da classe Evento para exibir os detalhes específicos do Congresso.
    @Override
    public void exibirDetalhes() {
        // Exibe informações detalhadas do congresso.
        System.out.println("- ID: [" + getId() + "]"); // Exibe o ID do evento.
        System.out.println("- Congresso: " + getTitulo()); // Exibe o título do congresso.
        System.out.println("- Organizador: " + nomeCoordenador); // Exibe o nome do coordenador.
        System.out.println("- Local: " + getLocal()); // Exibe o local do congresso.
        System.out.println("- Data: " + getData()); // Exibe a data do congresso.
        System.out.println("- Data de término: " + getDataTermino()); // Exibe a data de término do congresso.
        System.out.println("- Horário: " + getHorario()); // Exibe o horário do congresso.
        System.out.println("- Status: " + getStatus()); // Exibe o status do evento (presumivelmente herdado da classe Evento).
        System.out.println("-----------------------------------------------------------");
    }
}
