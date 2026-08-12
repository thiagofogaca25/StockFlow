package estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estoque.model.Produto;
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
