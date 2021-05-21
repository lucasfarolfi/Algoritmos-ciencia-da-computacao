public class App {

    public class Conta{
        double saldo;
        
        public void calcula () {
            if (saldo < 1000){

                int teste = saldo – 1000; //A declaração da variável teste é int, porém ela recebe double, então está errada
                //O certo seria double teste

                if (teste < 0){
                    System.out.println("Deu zebra");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
