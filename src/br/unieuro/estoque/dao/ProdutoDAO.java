package br.unieuro.estoque.dao;

import br.unieuro.estoque.excecao.EstoqueException;
import br.unieuro.estoque.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private static final String SQL_ESTOQUE_MINIMO =
            "SELECT id, nome, quantidade, estoque_minimo FROM produtos "
                    + "WHERE quantidade < estoque_minimo AND LOWER(nome) LIKE ? "
                    + "ORDER BY quantidade ASC";

    public List<Produto> buscarAbaixoDoMinimo(String filtroNome) throws EstoqueException {
        String filtro = (filtroNome == null) ? "" : filtroNome.trim().toLowerCase();
        List<Produto> produtos = new ArrayList<>();

        try (Connection conexao = ConexaoBD.obterConexao();
             PreparedStatement comando = conexao.prepareStatement(SQL_ESTOQUE_MINIMO)) {

            comando.setString(1, "%" + filtro + "%");

            try (ResultSet resultado = comando.executeQuery()) {
                while (resultado.next()) {
                    produtos.add(new Produto(
                            resultado.getInt("id"),
                            resultado.getString("nome"),
                            resultado.getInt("quantidade"),
                            resultado.getInt("estoque_minimo")));
                }
            }
        } catch (SQLException e) {
            throw new EstoqueException("Erro ao consultar o estoque mínimo no banco de dados: " + e.getMessage(), e);
        }

        return produtos;
    }
}