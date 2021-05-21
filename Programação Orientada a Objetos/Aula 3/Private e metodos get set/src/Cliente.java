public class Cliente {
    private int idade;
    private String CPF;
    private String endereco;

    //Idade 

    public int getIdade(){ // Método que exibe o valor
        return idade;
    }
    public void setIdade(int id){ // Método que modifica o valor
        idade = id;
    }

    //CPF
    public String getCPF(){
        return CPF;
    }
    public void setCPF(String cpf){
        CPF = cpf;
    }

    //Endereço
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String e){
        endereco = e;
    }
}
