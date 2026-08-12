package estoque.service;

import java.util.List;

import estoque.model.ProdutoDigital;
import estoque.model.ProdutoFisico;
import org.springframework.stereotype.Service;

import estoque.model.Produto;
import estoque.repository.ProdutoRepository;
import estoque.dto.ProdutoResponseDTO;
import estoque.dto.ProdutoRequestDTO;

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
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        if (dto.getTipo() == null) {
            throw new IllegalArgumentException("Tipo do produto é obrigatório");
        }

        if (!dto.getTipo().equalsIgnoreCase("fisico")
                && !dto.getTipo().equalsIgnoreCase("digital")) {

            throw new IllegalArgumentException(
                    "Tipo de produto inválido. Use 'fisico' ou 'digital'."
            );
        }
        Produto produto;

        if (dto.getTipo().equalsIgnoreCase("fisico")) {

            produto = new ProdutoFisico(
                    dto.getNome(),
                    dto.getPreco(),
                    dto.getCategoria(),
                    dto.getQuantidade(),
                    dto.getTipo()
            );

        } else {

            produto = new ProdutoDigital(
                    dto.getNome(),
                    dto.getPreco(),
                    dto.getCategoria(),
                    dto.getQuantidade(),
                    dto.getTipo()
            );
        }
        Produto produtoSalvo = produtoRepository.save(produto);
        return new ProdutoResponseDTO(
                produtoSalvo.getId(),
                produtoSalvo.getNome(),
                produtoSalvo.getPreco(),
                produtoSalvo.getCategoria(),
                produtoSalvo.getQuantidade(),
                produtoSalvo.getTipo()
        );
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