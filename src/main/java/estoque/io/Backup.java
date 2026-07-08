package estoque.io;

import java.io.IOException;
import java.nio.file.*;

public class Backup {
    public void backupObjeto(Path caminho) throws IOException {
        Path backup = Path.of(caminho.toString() + ".bak");
        Files.copy(caminho, backup, StandardCopyOption.REPLACE_EXISTING);
    }
}
