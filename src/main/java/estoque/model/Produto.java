package estoque.model;

public abstract class Produto{
    private int id;
    private final String nome;
    private final double preco;
    private final String categoria;
    private final int quantidade;

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

    public abstract void exibirInformacao();

}
