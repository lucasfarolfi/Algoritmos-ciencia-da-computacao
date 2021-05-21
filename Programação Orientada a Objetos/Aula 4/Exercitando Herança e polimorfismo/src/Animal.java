public class Animal {
    public String nome;
    public int idade;
    public String cor;

    public Animal(String nome, int idade, String cor){
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public void emitirSom(){
        System.out.println("Emitindo som...");
    }
}
