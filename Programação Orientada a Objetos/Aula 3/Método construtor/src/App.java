public class App {
    public static void main(String[] args) throws Exception {

        Cliente x = new Cliente("Lucas", 20);

        System.out.println("Oi, " + x.retornaNome() + " !!! Sua idade é de " + x.retornaIdade() + " anos.");
    }
}
