public class App {
    public static void main(String[] args) throws Exception {
        
        int [] v = {1, 2, 3, 4, 5 , 6};
        int tam = v.length;

        App.Inverter(v, tam);
    }

    public static void Inverter(int v[], int tam){
        
        int [] aux = new int[tam];
        int j = 0;
        
        for(int i = tam - 1; i >= 0; i--){
            
            aux[j] = v[i];
            j++; 
        }

        for(int i = 0; i < aux.length; i++){
            System.out.printf(aux[i] + " ");
        }
    }
}
