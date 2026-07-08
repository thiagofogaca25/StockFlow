package estoque.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProdutoSerializer {

    public void salvar(List<Produto> produtos, Path caminho) throws IOException {
        Files.createDirectories(caminho.getParent());

        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(caminho))){
            out.writeObject(produtos);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Produto> carregar(Path caminho) throws IOException, ClassNotFoundException{
        try (ObjectInputStream in =
                     new ObjectInputStream(Files.newInputStream(caminho))) {
            return (List<Produto>)  in.readObject();
        }

    }
}
