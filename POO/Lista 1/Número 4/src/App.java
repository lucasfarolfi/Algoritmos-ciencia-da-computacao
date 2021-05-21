public class App {
    public static void main(String[] args) throws Exception {
        
        Casa c1 = new Casa();
        Casa c2 = new Casa();

        c1.numero = 150;
        c1.cor = "verde";

        c2.numero = 325;
        c2.cor = "amarelo";

        System.out.println("A casa de número " + c1.numero + " tem cor " + c1.cor + ".");
        System.out.println("A casa de número " + c2.numero + " tem cor " + c2.cor + ".");
    }
}
