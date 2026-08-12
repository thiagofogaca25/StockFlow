package estoque.controller;

import estoque.dto.ProdutoResponseDTO;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import estoque.model.Produto;
import estoque.service.EstoqueService;
import estoque.dto.ProdutoRequestDTO;

import java.net.URI;
import java.util.List;

@RestController
public class ProdutoController {

    private final EstoqueService service;

    public ProdutoController(EstoqueService service) {
        this.service = service;
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return service.listarProdutos();
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {

        Produto produto =  service.buscarPorId(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody ProdutoRequestDTO produto) {

        ProdutoResponseDTO produtoCriado = service.salvar(produto);

        URI location = URI.create("/produtos/" + produtoCriado.getId());

        return ResponseEntity
                .created(location)
                .body(produtoCriado);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @RequestBody Produto produtoAtualizado) {

        Produto produto = service.atualizar(id, produtoAtualizado);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        boolean removido = service.deletar(id);

        if (!removido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}