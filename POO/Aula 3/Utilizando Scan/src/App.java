//Importar a biblioteca de scan
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Criar um objeto da classe Scanner 
        Scanner scanf = new Scanner(System.in);

        System.out.printf("Insira o seu nome: ");
        String nome = scanf.nextLine(); //Método que recupera dados em string

        System.out.printf("Insira a sua idade: ");
        int idade = scanf.nextInt(); //Método que recupera dados em int

        scanf.close(); // termina de dar scan

        System.out.println("\nSeu nome é " + nome + ", e sua idade é " + idade + " anos.");
    }
}
