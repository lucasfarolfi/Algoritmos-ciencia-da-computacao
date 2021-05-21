public class App {

    public class Conta{
        double saldo;
        
        public void calcula () {
            if (saldo < 1000){
                double testeSaldo = saldo*0.1;
            }System.out.println(testeSaldo); //Está errado, pois a variável foi declarada dentro de um escopo, que não é acessível fora
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
