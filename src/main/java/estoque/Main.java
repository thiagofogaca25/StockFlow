package estoque;

import estoque.dao.ProdutoDAO;
import estoque.database.ConnectionFactory;
import estoque.model.Produto;
import estoque.model.ProdutoDigital;
import estoque.model.ProdutoFisico;
import estoque.service.EstoqueService;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();
        IO.println("Conexao realizada");
        connection.close();
        EstoqueService estoque = new EstoqueService();
        ProdutoDAO dao = new ProdutoDAO();

        IO.println("---- Comeco da lista ----");
        estoque.listarProdutos();

        IO.println("---- Adicionando novos produtos ---- ");

        Produto notebook = new ProdutoFisico("Notebook", 3500,1, "TI");
        Produto cursoJava = new ProdutoDigital("Curso Java", 190,2,"Cursos");

        estoque.adicionarProduto(notebook);
        estoque.adicionarProduto(cursoJava);

        IO.println("NOVA LISTA: ");
        estoque.listarProdutos();

        IO.println("---- Editar quantidade ----");
        IO.println("Digite o ID: ");
        int id = Integer.parseInt(scanner.next());

        IO.println("Digite a nova Quantidade: ");
        int quantidade = Integer.parseInt(scanner.next());

        estoque.atualizarQuantidade(id,quantidade);

        IO.println("NOVA LISTA: ");
        estoque.listarProdutos();

        IO.println("---- Deletar pelo ID ----");

        IO.println("Escreva o ID: ");
        int deleteID = Integer.parseInt(scanner.next());
        estoque.deleteById(deleteID);

        IO.println("NOVA LISTA: ");
        estoque.listarProdutos();

    }
}