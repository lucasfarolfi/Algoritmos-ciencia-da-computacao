public class Cliente {
    public String nome;
    public int idade;

    //Método construtor default (sem parâmetro)
    /*
    public Cliente(){
        System.out.println("Olá cliente !!!");
    }
    */

    //Método construtor que recebe parâmetro
    public Cliente(String n, int i){
        nome = n;
        idade = i;
    }

    public String retornaNome(){
        return nome;
    }

    public int retornaIdade(){
        return idade;
    }
}
