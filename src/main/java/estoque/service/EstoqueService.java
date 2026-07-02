package estoque.service;
import estoque.dao.ProdutoDAO;
import estoque.model.Produto;

import java.util.List;

public class EstoqueService {
    private final ProdutoDAO dao = new ProdutoDAO();

    public void adicionarProduto(Produto produto){
        dao.save(produto);
        IO.println(produto.getId());
    }

    public void listarProdutos(){
        List<Produto> produtos = dao.findAll();
        for(Produto produto : produtos){
            produto.exibirInformacao();
        }
    }

    public void atualizarQuantidade(int id, int quantidade){
        dao.updateQuantidade(id,quantidade);
    }

    public void deleteById(int id){
        dao.delete(id);
    }

}
