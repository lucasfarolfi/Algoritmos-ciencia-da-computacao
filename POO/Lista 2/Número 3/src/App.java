public class App {
    public static void main(String[] args) throws Exception {
        
        double somaTotal = 0;

        for(int i=1; i <= 10000; i++){
            if(i % 2 == 0){
                continue;
            }
            else{
                somaTotal += i;
            }
        }
        
        System.out.println("Soma: " + somaTotal);
    }
}
