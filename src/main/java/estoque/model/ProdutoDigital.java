package estoque.model;

import estoque.Vendavel;

public class ProdutoDigital extends Produto implements Vendavel {
    public ProdutoDigital(String nome, double preco, String categoria, int quantidade, String tipo) {
        super(nome, preco, categoria, quantidade,   tipo);
    }

    public ProdutoDigital(String nome, double preco, int quantidade, String categoria,  String tipo) {
        super(nome, preco, categoria, quantidade,   tipo);
    }

    @Override
    public void vender(int quantidade) {
        System.out.println("Produto digital vendido. Quantidade: "+quantidade);
    }

    public String getTipo(){
        return "Digital";
    }


}
