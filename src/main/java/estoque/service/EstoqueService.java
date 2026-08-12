package estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import estoque.model.Produto;
import estoque.repository.ProdutoRepository;

@Service
public class EstoqueService {

    private final ProdutoRepository produtoRepository;

    public EstoqueService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto salvar(Produto produto) {

        if (produto.getTipo() == null) {
            throw new IllegalArgumentException("Tipo do produto é obrigatório");
        }

        if (!produto.getTipo().equalsIgnoreCase("fisico")
                && !produto.getTipo().equalsIgnoreCase("digital")) {

            throw new IllegalArgumentException(
                    "Tipo de produto inválido. Use 'fisico' ou 'digital'."
            );
        }

        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id)
                .orElse(null);

        if (produto == null) {
            return null;
        }
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setTipo(produtoAtualizado.getTipo());
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setQuantidade(produtoAtualizado.getQuantidade());

        return produtoRepository.save(produto);
    }
    public boolean deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            return false;
        }

        produtoRepository.deleteById(id);
        return true;
    }
}