package br.unieuro.estoque.dao;

import br.unieuro.estoque.excecao.EstoqueException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBD {

    private static final String ARQUIVO_CONFIG = "db.properties";

    private ConexaoBD() {
    }

    public static Connection obterConexao() throws EstoqueException {
        Properties config = carregarConfiguracao();

        String url = config.getProperty("url");
        String usuario = config.getProperty("user");
        String senha = config.getProperty("password");

        if (url == null || usuario == null || senha == null) {
            throw new EstoqueException(
                    "Configuração incompleta: preencha url, user e password em " + ARQUIVO_CONFIG + ".");
        }

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new EstoqueException(
                    "Não foi possível conectar ao banco de dados. Verifique sua internet e as credenciais.", e);
        }
    }

    private static Properties carregarConfiguracao() throws EstoqueException {
        Properties config = new Properties();
        try (FileInputStream entrada = new FileInputStream(ARQUIVO_CONFIG)) {
            config.load(entrada);
        } catch (IOException e) {
            throw new EstoqueException(
                    "Arquivo " + ARQUIVO_CONFIG + " não encontrado na raiz do projeto.", e);
        }
        return config;
    }
}