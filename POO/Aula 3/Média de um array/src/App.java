import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int [] vet = new int [3];

        Scanner scan = new Scanner(System.in);

        //vet.length - Conta o tamanho do array
        for(int i = 0; i < vet.length; i++){
            
            System.out.printf("Digite uma nota: ");
            int val = scan.nextInt();

            vet[i] = val;
        }

        //For Each - O i recebe o valor dos índices de vet[]
        for(int i:vet){
            System.out.println(i);
        }

        System.out.println("A média dos três números é: " + calculaMedia(vet));

        scan.close();
    }
    public static double calculaMedia(int v[]){
        double media = 0;

        //For Each - O i recebe o valor do índice de v[]        
        for(int i:v){
            media += i;
        }

        return (media)/(v.length);
    }
}

