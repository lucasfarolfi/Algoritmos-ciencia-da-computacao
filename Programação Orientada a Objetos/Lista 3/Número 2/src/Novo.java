public class Novo extends Imovel{ 
    
    public double getPreco(){ return ((10 * super.getPreco())/100) + super.getPreco(); }
}
