public class App {
    public static void main(String[] args) throws Exception {
        Gato g = new Gato();

        g.setNome("Jake");
        g.setIdade(5);
        g.setCor("Preto");

        System.out.println("Nome: " + g.getNome() + "\nIdade: " + g.getIdade() + "\nCor: " + g.getCor());

    }
}
