package estoque.service;

import java.util.List;
import java.util.Locale;

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
            return null;
        }

        String tipoMinusculo = produto.getTipo().toLowerCase(Locale.ROOT);

        if (!tipoMinusculo.equals("digital") && !tipoMinusculo.equals("fisico")) {
            return null; // Se não for digital E também não for físico, barra o salvamento
        }

        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id)
                .orElse(null);

        if (produto == null) {
            return null;
        }

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