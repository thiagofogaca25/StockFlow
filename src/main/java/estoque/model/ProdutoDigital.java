package estoque.model;

import estoque.Vendavel;

public class ProdutoDigital extends Produto implements Vendavel {
    public ProdutoDigital(int id,String nome, double preco, String categoria, int quantidade) {
        super(id, nome, preco, categoria, quantidade);
    }

    public ProdutoDigital(String nome, double preco, int quantidade, String categoria) {
        super(nome, preco, categoria, quantidade);
    }

    @Override
    public void vender(int quantidade) {
        IO.println("Produto digital vendido. Quantidade: "+quantidade);
    }

    @Override
    public String getTipo(){
        return "Digital";
    }

    @Override
    public void exibirInformacao() {
        IO.println("ID: "+ getId() +" "+ getNome() + " - R$ " + getPreco() + " - Quantidade " + getQuantidade()+ " - Tipo: " + getTipo());
    }
}
