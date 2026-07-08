package estoque.io;

import estoque.model.Produto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class ProdutoCsvExporter {
    public void exportar(List<Produto> produtos, Path caminho) throws IOException{
        Files.createDirectories(caminho.getParent());

        try(BufferedWriter writer = Files.newBufferedWriter(caminho)){
            writer.write("id,nome,preco,categoria,quantidade,tipo");
            writer.newLine();

            for (Produto produto : produtos){
                writer.write( "%d,%s,%s,%s,%d,%s".formatted(
                        produto.getId(),
                        produto.getNome(),
                        String.format(Locale.US, "%.2f", produto.getPreco()),
                        produto.getCategoria(),
                        produto.getQuantidade(),
                        produto.getTipo()));
                writer.newLine();
            }
        }
    }
}
