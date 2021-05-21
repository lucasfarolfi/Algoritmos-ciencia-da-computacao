public class Animal {
    private String nome;
    private int idade;
    private String cor;

    // Nome
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome; //O this diferencia o atributo da classe do parâmetro de fora
    }

    // idade
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    // Cor
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

}
