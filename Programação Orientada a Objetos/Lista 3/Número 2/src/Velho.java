public class Velho extends Imovel{

    public double getPreco(){ return super.getPreco() - ((10 * super.getPreco())/100); }
}
