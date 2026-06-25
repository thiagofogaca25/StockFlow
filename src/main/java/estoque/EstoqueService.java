package estoque;
import java.util.ArrayList;

public class EstoqueService {
    private final ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
    }

    public void listarProdutos(){
        for(Produto produto : produtos){
            produto.exibirInformacao();
        }
    }
}
