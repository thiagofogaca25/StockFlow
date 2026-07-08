package estoque.model;
import java.io.Serializable;

public abstract class Produto implements Serializable{
    private int id;
    private final String nome;
    private final double preco;
    private final String categoria;
    private int quantidade;

    public Produto(String nome, double preco, String categoria, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, double preco, String categoria, int quantidade) {
        this(nome, preco, categoria, quantidade);
        this.id = id;
    }
    public abstract String getTipo();

    public int getId(){return id;}

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCategoria(){return categoria;}

    public int getQuantidade(){return quantidade;}

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public abstract void exibirInformacao();

}
