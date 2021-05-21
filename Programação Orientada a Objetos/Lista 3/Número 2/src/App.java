public class App {
    public static void main(String[] args) throws Exception {
        
        Novo i1 = new Novo();
        Velho i2 = new Velho();

        i1.setPreco(1500.00);
        i2.setPreco(1500.00);

        System.out.println(i1.getPreco() );
        System.out.println(i2.getPreco() );
    }
}
