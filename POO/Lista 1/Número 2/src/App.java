public class App {
    public static void main(String[] args) throws Exception {
        
        Gato g1 = new Gato();
        Gato g2 = new Gato();
        Gato g3 = new Gato();

        g1.nome = "Jake";
        g1.idade = 5;
        g1.cor = "Preto";
        g1.vivo = true;

        g2.nome = "Miau";
        g2.idade = 10;
        g2.cor = "branco";
        g2.vivo = false;

        g3.nome = "Fred";
        g3.idade = 2;
        g3.cor = "Cinza";
        g3.vivo = true;

        System.out.println("O gato(a) " + g1.nome + " tem " + g1.idade + " anos, sua cor é " + g1.cor + " e ele(a) está " + g1.vivo + ".");

        System.out.println("O gato(a) " + g2.nome + " tem " + g2.idade + " anos, sua cor é " + g2.cor + " e ele(a) está " + g2.vivo + ".");

        System.out.println("O gato(a) " + g3.nome + " tem " + g3.idade + " anos, sua cor é " + g3.cor + " e ele(a) está " + g3.vivo + ".");
    }
}
