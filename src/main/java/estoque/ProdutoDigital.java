package estoque;

public class ProdutoDigital extends Produto implements Vendavel {
    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public void vender(int quantidade) {
        IO.println("Produto digital vendido. Quantidade: "+quantidade);
    }

    @Override
    public void exibirInformacao() {
        IO.println(getNome() + " - R$ " + getPreco() + " - Produto Digital " );
    }
}
