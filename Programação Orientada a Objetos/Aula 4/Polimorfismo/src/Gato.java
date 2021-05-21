public class Gato extends Animal{
    public String raca;

    public Gato(String raca, String nome, int idade, String cor){
        super(nome, idade, cor);
        this.raca = raca;
    }

    public void emitirSom(){
        System.out.println("Miau");
    }
}
