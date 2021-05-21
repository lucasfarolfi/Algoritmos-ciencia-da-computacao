public class App {

    public class Elefante {
        private String nome;
        private int idade;
        public boolean morto;
        String cor;
        default double peso; //Está errada pois está declarada como default, pois não precisa
        public tamanho int; //Está errada, pois está sendo declarado o nome antes do tipo
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
