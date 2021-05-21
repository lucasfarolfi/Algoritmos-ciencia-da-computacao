public class App {
    public static void main(String[] args) throws Exception {
        Cliente c1 = new Cliente();

        c1.setIdade(20);
        c1.setCPF("000.000.000-00");
        c1.setEndereco("Avenida Santos Drummond");

        System.out.println("Idade: " + c1.getIdade() + "\nCPF: " + c1.getCPF() + "\nEndereço: " + c1.getEndereco());
    }
}
