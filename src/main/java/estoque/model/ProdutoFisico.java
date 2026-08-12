package estoque.model;

import estoque.Vendavel;
import jakarta.persistence.Entity;

@Entity
public class ProdutoFisico extends Produto implements Vendavel {
    public ProdutoFisico(String nome, double preco, String categoria, int quantidade,String tipo) {
        super(nome, preco, categoria, quantidade, tipo);
    }

    public ProdutoFisico() {
    }
    @Override
    public void vender(int quantidadeVenda){
        if(quantidadeVenda<=getQuantidade()){
            setQuantidade(getQuantidade()-quantidadeVenda);
            System.out.println("Venda Realizada.");
        }else{
            System.out.println("Estoque Insuficiente.");
        }
    }

    public String getTipo(){
        return "Fisico";
    }


}
