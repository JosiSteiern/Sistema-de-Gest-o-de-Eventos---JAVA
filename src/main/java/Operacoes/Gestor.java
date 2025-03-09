    package Operacoes;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Gestor {

        private static List<Gestor> gestores = new ArrayList<>();
        private static Scanner sc = new Scanner(System.in);

        protected String nomeGestor;
        protected String senhaGestor;

        // CONSTRUTOR
        public Gestor(String nome, String senha){
            this.nomeGestor = nome;
            this.senhaGestor = senha;
        }

        // GETTERS
        public String getNomeGestor(){
            return this.nomeGestor;
        }

        public String getSenhaGestor(){
            return this.senhaGestor;
        }

        // FUNÇÕES

        public static void addGestor(Gestor gestor){
            gestores.add(gestor);
        }

        public static boolean encontrarGestor(){
            System.out.println("- Digite sua senha: ");
            String senha = sc.nextLine();

            for (Gestor gestor : gestores){
                if(gestor.getSenhaGestor().equals(senha)){
                    System.out.println("GESTOR: [" + gestor.getNomeGestor() + "]");
                    return true;
                }
            }
            System.out.println("Senha inválida ou gestor não encontrado.");
            return false;
        }


    }
