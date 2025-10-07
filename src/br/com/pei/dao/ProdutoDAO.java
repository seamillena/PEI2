package br.com.pei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.pei.model.Produto;

public class ProdutoDAO {

    public void save(Produto produto) {
        // SQL com a coluna 'descricao' que adicionamos
        String sql = "INSERT INTO produtos (codigo_de_barras, nome, preco, quantidade_em_estoque, descricao) VALUES (?, ?, ?, ?, ?)";

        // O try-with-resources garante que a conexão é fechada automaticamente
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Define os valores para cada '?' no comando SQL
            pstmt.setString(1, produto.getCodigoDeBarras());
            pstmt.setString(2, produto.getNome());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setInt(4, produto.getQuantidadeEmEstoque());
            pstmt.setString(5, produto.getDescricao());

            // Executa o comando para inserir os dados no banco
            pstmt.executeUpdate();
            System.out.println("Produto salvo com sucesso no banco de dados!");

        } catch (SQLException e) {
            System.err.println("Erro ao salvar produto no banco de dados: " + e.getMessage());
            // Em uma aplicação real, trataríamos esse erro de forma mais elegante
        }
    }
}