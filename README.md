```markdown
# 📦 Loja UNIEURO - Tema 8: Consulta de Estoque Mínimo

Este projeto foi desenvolvido para a disciplina de Programação Orientada a Objetos (2026.2) do Centro Universitário UNIEURO. O sistema implementa o caso de uso de identificação de produtos com quantidade abaixo do limite de segurança no stock, utilizando interface gráfica e persistência de dados.

## 👥 Grupo 2 (G2)
* **Ana Luiza Fernandes Novaes**
* **Sthefanny Ramos Parrini** 
* **Yasmin Gomes de Matos** 

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java
* **Interface Gráfica:** Java Swing
* **Base de Dados:** PostgreSQL / Supabase
* **Conexão:** JDBC com PreparedStatement

## ⚙️ Configuração da Conexão
Para que a aplicação funcione corretamente, é necessário configurar a conexão com a base de dados:
1. Importe o ficheiro de script disponível na pasta `sql/` na sua ferramenta de gestão de base de dados para criar a tabela de produtos e inserir os dados iniciais[cite: 2].
2. No código-fonte, localize a classe de conexão JDBC.
3. Altere as credenciais para o seu ambiente local ou na cloud (Supabase):
   ```java
   String url = "jdbc:postgresql://SEU_HOST:5432/SUA_BASE_DE_DADOS";
   String user = "SEU_USUARIO";
   String password = "SUA_SENHA";

```

## ▶️ Instruções de Execução

1. Clone este repositório para a sua máquina local:
```bash
git clone [https://github.com/SEU_USUARIO/loja-unieuro-estoque-g2.git](https://github.com/SEU_USUARIO/loja-unieuro-estoque-g2.git)

```

2. Abra a pasta do projeto no VS Code ou IntelliJ IDEA.
3. Certifique-se de que o driver JDBC do PostgreSQL está corretamente referenciado e adicionado ao projeto.
4. Execute a aplicação e acione a funcionalidade na interface gráfica para visualizar os resultados da consulta ao banco de dados.
