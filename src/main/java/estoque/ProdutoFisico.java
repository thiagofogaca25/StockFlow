package estoque;

public class ProdutoFisico extends Produto implements Vendavel{
    int quantidade;
    public ProdutoFisico(String nome, double preco, int quantidade){
        super(nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public void vender(int quantidade){
        if(quantidade<=this.quantidade){
            this.quantidade -= quantidade;
            IO.println("Venda Realizada.");
        }else{
            IO.println("Estoque Insuficiente.");
        }
    }

    @Override
    public void exibirInformacao(){
        IO.println(getNome() + " - R$ " + getPreco() + " - Quantidade " + quantidade);
    }
}
