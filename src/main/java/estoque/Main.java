package estoque;

public class Main {
    static void main(){
        EstoqueService estoque = new EstoqueService();

        Produto notebook = new ProdutoFisico("Notebook", 3500,10);
        Produto cursoJava = new ProdutoDigital("Curso Java", 190);

        estoque.adicionarProduto(notebook);
        estoque.adicionarProduto(cursoJava);

        estoque.listarProdutos();
    }
}