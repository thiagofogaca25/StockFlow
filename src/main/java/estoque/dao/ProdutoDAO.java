package estoque.dao;

import estoque.database.ConnectionFactory;
import estoque.model.Produto;
import estoque.model.ProdutoDigital;
import estoque.model.ProdutoFisico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class ProdutoDAO {
    public void save(Produto produto){
        String sql = "INSERT INTO produtos (nome, preco, quantidade, categoria, tipo) VALUES (?, ?, ?, ?, ?)";
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setDouble(2, produto.getPreco());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setString(4, produto.getCategoria());
            preparedStatement.setString(5, produto.getTipo());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if(generatedKeys.next()){
                produto.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro no banco de dados: ", e);
        }
    }

    public List<Produto> findAll(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    produtos.add(mapearProduto(resultSet));
                }

                return produtos;
        }catch (SQLException e){
            throw new RuntimeException("Erro no banco de dados: ", e);
        }
    }
    private Produto mapearProduto(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        double preco = resultSet.getDouble("preco");
        int quantidade = resultSet.getInt("quantidade");
        String categoria = resultSet.getString("categoria");
        String tipo = resultSet.getString("tipo");

        if (tipo.equalsIgnoreCase("Fisico")) {
            return new ProdutoFisico(id, nome, preco, quantidade, categoria);
        }

        return new ProdutoDigital(id, nome, preco, quantidade, categoria);
    }

    public void updateQuantidade(int id, int quantidade){
        String sql = "UPDATE produtos SET quantidade = ? WHERE id = ?";

        try(
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ){
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Erro no banco de dados: ",e);
        }
    }

    public void delete(int id){
        String sql = "DELETE FROM produtos WHERE id=?";
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro no banco de dados: ", e);
        }
    }
}
