public class App {
    public static void main(String[] args) throws Exception {
        
        Gato g1 = new Gato();
        Animal g2 = new Gato(); //Tem acesso aos métodos, mas não aos atributos
        Animal a1 = new Animal();

        g1.emitirSom();
        g2.emitirSom();
        a1.emitirSom();

        if(g2 instanceof Gato){ //Verifica se g2 é um objeto Gato
            Gato g3 = (Gato) g2; //Faz casting, convertendo g2 para um objeto Gato
            
            g3.emitirSom();
        }
    }
}
