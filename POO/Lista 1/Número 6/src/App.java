public class App {
    public static void main (String args[]){

        Janela janela = new Janela();
        Casa casa = new Casa();

        // atributo janela da classe casa APONTA para o objeto janela
        casa.janela = janela;

        casa.janela.cor = "Transparente";
        casa.janela.material = "Vidro";

        casa.cor = "Marrom";
        casa.numero = 150;

        System.out.println("Cor da casa: " + casa.cor + "\nNúmero da casa: " + casa.numero + "\nCor da janela: " + casa.janela.cor + "\nMaterial da janela: " + casa.janela.material);
    }

} // fim classe App
