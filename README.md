<div align="center">
  
  # 📦 Loja UNIEURO
  ### Tema 8: Consulta de Estoque Mínimo
  *Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (2026.2)*

  ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
  ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
  ![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)

</div>

<br>

## 📌 Sobre o Projeto
O sistema implementa o caso de uso de identificação de produtos com quantidade abaixo do limite de segurança no estoque, utilizando uma interface gráfica intuitiva e persistência de dados segura. 

---

## 👥 Integrantes - Grupo 2 (G2)
- 👩‍💻 **Ana Luiza Fernandes Novaes**
- 👩‍💻 **Sthefanny Ramos Parrini** 
- 👩‍💻 **Yasmin Gomes de Matos** 

---

## 🛠️ Tecnologias e Ferramentas
| Camada | Tecnologia |
| :--- | :--- |
| **Linguagem** | Java |
| **Interface Gráfica** | Java Swing |
| **Banco de Dados** | PostgreSQL / Supabase |
| **Conexão** | JDBC com `PreparedStatement` |

---

## ⚙️ Configuração do Banco de Dados
Para que a aplicação funcione corretamente, você precisará configurar a conexão com o banco de dados antes de rodar o código:

1. **Estrutura Inicial:** Importe o arquivo de script disponível na pasta `sql/` na sua ferramenta de gestão de banco de dados (ex: pgAdmin, DBeaver ou SQL Editor do Supabase) para criar a tabela de produtos e inserir os dados de teste[cite: 2].
2. **Acesso ao Código:** No código-fonte, localize a classe responsável pela conexão JDBC.
3. **Credenciais:** Altere as variáveis de ambiente para o seu ambiente local ou na nuvem (Supabase):

```java
   String url = "jdbc:postgresql://SEU_HOST:5432/SEU_BANCO_DE_DADOS";
   String user = "SEU_USUARIO";
   String password = "SUA_SENHA";

```

> ⚠️ **Aviso:** Nunca faça *commit* das suas senhas reais no repositório!

---

## ▶️ Instruções de Execução

**1. Clone o repositório**
Abra o seu terminal e rode o comando abaixo para baixar o projeto para a sua máquina:

```bash
git clone [https://github.com/SEU_USUARIO/loja-unieuro-estoque-g2.git](https://github.com/SEU_USUARIO/loja-unieuro-estoque-g2.git)

```

**2. Prepare a IDE**
Abra a pasta do projeto no **VS Code** ou **IntelliJ IDEA**.

**3. Configure o Driver**
Certifique-se de que o driver JDBC do PostgreSQL (`.jar`) está corretamente referenciado e adicionado ao *build path* do projeto.

**4. Execute**
Rode a classe principal da aplicação e acione a funcionalidade na interface gráfica para visualizar os resultados da consulta de estoque mínimo direto do banco de dados.
