public class App {
    public static void main(String[] args) throws Exception {
        
        double somaTotal = 0;

        for(int i=1; i <= 50000; i++){
            
            if(i >= 100 && i <= 137){
                continue;
            }
            else{
                somaTotal += i;
            }
        }

        System.out.println("Soma: " + somaTotal);
    }
}
