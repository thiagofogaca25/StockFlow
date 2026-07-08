package estoque;

import estoque.dao.ProdutoDAO;
import estoque.database.ConnectionFactory;
import estoque.io.Backup;
import estoque.io.ProdutoCsvExporter;
import estoque.io.ProdutoCsvImporter;
import estoque.model.Produto;
import estoque.model.ProdutoSerializer;
import estoque.service.EstoqueService;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Path CAMINHO_DAT = Path.of("exports/produtos.dat");
    private static final Path CAMINHO_CSV = Path.of("exports/produtos.csv");

    static void main() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Testa a conexão com o banco antes de seguir com as operações
        testarConexaoComBanco();

        EstoqueService estoque = new EstoqueService();
        ProdutoDAO dao = new ProdutoDAO();
        ProdutoCsvExporter exporter = new ProdutoCsvExporter();
        ProdutoCsvImporter importer = new ProdutoCsvImporter();
        ProdutoSerializer serializer = new ProdutoSerializer();
        Backup backup = new Backup();

        // Carrega produtos serializados previamente e exibe as informações de cada um
        IO.println("---- Carregando produtos salvos (.dat) ----");
        List<Produto> produtosSalvos = serializer.carregar(CAMINHO_DAT);
        if (produtosSalvos.isEmpty()) {
            IO.println("Nenhum produto encontrado no arquivo .dat");
        } else {
            for (Produto produto : produtosSalvos) {
                produto.exibirInformacao();
            }
        }

        // Faz backup do arquivo .dat antes de sobrescrevê-lo mais adiante
        IO.println("---- Realizando backup do arquivo .dat ----");
        backup.backupObjeto(CAMINHO_DAT);
        IO.println("Backup realizado com sucesso.");

        // Busca produtos direto do banco de dados
        IO.println("---- Buscando produtos no banco de dados ----");
        List<Produto> produtos = dao.findAll();
        IO.println(produtos.size() + " produto(s) encontrado(s) no banco.");

        // Importa produtos de um arquivo CSV
        IO.println("---- Importando produtos do CSV ----");
        List<Produto> produtosImportados = importer.importar(CAMINHO_CSV);
        IO.println(produtosImportados.size() + " produto(s) importado(s) do CSV:");
        for (Produto produto : produtosImportados) {
            IO.println(" - " + produto.getNome());
        }

        // Salva (serializa) os produtos do banco para o arquivo .dat
        IO.println("---- Salvando produtos em arquivo .dat ----");
        serializer.salvar(produtos, CAMINHO_DAT);
        IO.println("Produtos salvos com sucesso em " + CAMINHO_DAT);

        // Exporta os produtos do banco para CSV
        exporter.exportar(produtos, CAMINHO_CSV);
        IO.println("Produtos exportados com sucesso para " + CAMINHO_CSV);

        IO.println("---- Lista atual de produtos ----");
        estoque.listarProdutos();

        // TODO: reativar quando a criação de novos produtos estiver pronta
        // IO.println("---- Adicionando novos produtos ----");
        // Produto notebook = new ProdutoFisico("Notebook", 3500, "TI", 1);
        // Produto cursoJava = new ProdutoDigital("Curso Java", 190, 2, "Cursos");
        // estoque.adicionarProduto(notebook);
        // estoque.adicionarProduto(cursoJava);
        // IO.println("---- Nova lista após adição ----");
        // estoque.listarProdutos();

        IO.println("---- Editar quantidade de um produto ----");
        IO.print("Digite o ID do produto: ");
        int id = Integer.parseInt(scanner.next());

        IO.print("Digite a nova quantidade: ");
        int quantidade = Integer.parseInt(scanner.next());
        estoque.atualizarQuantidade(id, quantidade);
        IO.println("Quantidade atualizada com sucesso!");

        IO.println("---- Lista após atualização ----");
        estoque.listarProdutos();

        IO.println("---- Deletar produto pelo ID ----");
        IO.print("Digite o ID do produto a ser removido: ");
        int deleteID = Integer.parseInt(scanner.next());
        estoque.deleteById(deleteID);
        IO.println("Produto removido com sucesso!");

        IO.println("---- Lista final de produtos ----");
        estoque.listarProdutos();
    }

    /**
     * Abre e fecha uma conexão com o banco apenas para validar
     * que a configuração de conexão está funcionando.
     */
    private static void testarConexaoComBanco() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        IO.println("Conexão com o banco de dados realizada com sucesso.");
        connection.close();
    }
}