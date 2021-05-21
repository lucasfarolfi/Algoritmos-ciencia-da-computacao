public class App {

    public class Conta{
        double saldo; //O certo seria boolean temSaldo;
        
        public void calcula () {
            if (saldo){ //Está errado pois está usando uma propriedade booleana para saber se o saldo existe ou não
                System.out.println("Tem saldo");
            }else {System.out.println("Não tem saldo");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
