package estoque.model;

import estoque.Vendavel;

public class ProdutoFisico extends Produto implements Vendavel {
    public ProdutoFisico(String nome, double preco, String categoria, int quantidade) {
        super(nome, preco, categoria, quantidade);
    }

    public ProdutoFisico(int id,String nome, double preco, String categoria, int quantidade){
        super(id, nome, preco, categoria, quantidade);
    }

    @Override
    public void vender(int quantidadeVenda){
        if(quantidadeVenda<=getQuantidade()){
            setQuantidade(getQuantidade()-quantidadeVenda);
            IO.println("Venda Realizada.");
        }else{
            IO.println("Estoque Insuficiente.");
        }
    }

    @Override
    public String getTipo(){
        return "Fisico";
    }

    @Override
    public void exibirInformacao(){
        IO.println("ID: "+ getId() +" "+ getNome() + " - R$ " + getPreco() + " - Quantidade " + getQuantidade()+ " - Tipo: " + getTipo());
    }
}
