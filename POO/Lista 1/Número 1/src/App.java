public class App {
    public static void main(String[] args) throws Exception {
        
        gato g1 = new gato();

        g1.nome = "Fred";
        g1.idade = 5;
        g1.cor = "Preto";
        g1.vivo = true;

        g1.miar();
    }
}
