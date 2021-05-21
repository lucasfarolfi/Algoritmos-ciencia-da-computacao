public class App {
    public static void main(String[] args) throws Exception {
        // TESTE DE OPERADORES

        //Média de nota
        float x = 10f;
        float y = 8f;
        
        float media = (x + y) / (2);

        System.out.println("A média das duas notas é: " + media);

        //Contador de número par
        for(int i=0; i < 10; i++){

            if(i % 2 != 0){
                continue; //Pula os comandos da contagem atual do for/switch/while
            }
            System.out.println("i: " + i);
        }

        //Contador de número primo
        for(int j = 1; j < 100; j++){

            if((j == 2) || (j == 3) || (j % 2 != 0) && (j % 3 != 0)){
                System.out.println("j: " + j);

                if(j > 15){
                    break;
                }
            }
        }
    }
}
