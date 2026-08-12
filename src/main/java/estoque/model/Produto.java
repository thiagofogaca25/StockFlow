package estoque.model;
import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
@Entity
public class Produto{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;
    private String categoria;
    private int quantidade;
    private String tipo;
    public Produto() {
    }

    public Produto(String nome, double preco, String categoria, int quantidade, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Long getId(){return id;}

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria(){return categoria;}
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    public int getQuantidade(){return quantidade;}
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public String getTipo(){return tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
}
