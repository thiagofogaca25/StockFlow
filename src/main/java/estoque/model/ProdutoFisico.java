package estoque.model;

import estoque.Vendavel;

public class ProdutoFisico extends Produto implements Vendavel {
    public ProdutoFisico(String nome, double preco, int quantidade, String categoria) {
        super(nome, preco, categoria, quantidade);
    }

    public ProdutoFisico(int id,String nome, double preco, int quantidade, String categoria){
        super(id, nome, preco, categoria, quantidade);
    }

    @Override
    public void vender(int quantidade){
        if(quantidade<=getQuantidade()){
            quantidade -= quantidade;
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
