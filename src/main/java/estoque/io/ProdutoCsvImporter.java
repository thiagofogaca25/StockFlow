package estoque.io;

import estoque.model.Produto;
import estoque.model.ProdutoDigital;
import estoque.model.ProdutoFisico;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCsvImporter {
    public List<Produto> importar(Path caminho) throws IOException {
        List<Produto> produto = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(caminho)){
            String linha;

            while ((linha = reader.readLine()) != null){
                if(linha.startsWith("id,")){
                    continue;
                }
                String[] colunas = linha.split(",");

                if(colunas.length < 6){
                    System.out.println("Linha invalida ignorada: " + linha);
                    continue;
                }
                String nome = colunas[1];
                double preco = Double.parseDouble(colunas[2]);
                String categoria = colunas[3];
                int quantidade = Integer.parseInt(colunas[4]);
                String tipo = colunas[5];

                if(tipo.equalsIgnoreCase("fisico")){
                    Produto produtoFisico = new ProdutoFisico(nome,preco,categoria,quantidade,tipo);
                    produto.add(produtoFisico);
                }else{
                    Produto produtoDigital = new ProdutoDigital(nome,preco,quantidade,categoria,tipo);
                    produto.add(produtoDigital);
                }
            }
        }

        return produto;
    }
}
