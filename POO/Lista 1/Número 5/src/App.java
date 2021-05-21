public class App {
    public static void main(String[] args) throws Exception {
        
    }

    public class Casa {
    
        public String cor;  
        public int numero;
        Janela Janela;
    
        public void casa(String cor, int numero){
    
            this.cor = cor;
            this.numero = numero;
    
            System.out.println("Cor da casa: " + cor + "\nNúmero da casa: " + numero);
    
            System.out.println(Janela);
        }
    }
    
    public class Janela {
        
        public String cor;
        public String material;
    
        public void janela(String cor, String material){
    
            this.cor = cor;
            this.material = material;
    
            System.out.println("Cor da janela: " + this.cor + "\nmaterial da janela: " + this.material);
        }
    }

} // fim classe App
