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

* 👩‍💻 **Ana Luiza Fernandes Novaes**
* 👩‍💻 **Sthefanny Ramos Parrini**
* 👩‍💻 **Yasmin Gomes de Matos**

---

## 🛠️ Tecnologias e Ferramentas

| Camada | Tecnologia |
| --- | --- |
| **Linguagem** | Java (JDK 17 ou superior) |
| **Interface Gráfica** | Java Swing |
| **Banco de Dados** | PostgreSQL / Supabase |
| **Conexão** | JDBC com `PreparedStatement` |

---

## ⚙️ Configuração do Banco de Dados

Para que a aplicação funcione corretamente, você precisará configurar a conexão com o banco de dados antes de rodar o código:

1. **Estrutura Inicial:** Importe o script SQL contido na pasta de migrações (`produtos.sql`) na sua ferramenta de gestão de banco de dados (ex: pgAdmin, DBeaver ou SQL Editor do Supabase) para criar a tabela de produtos e carregar os dados de teste.
2. **Acesso ao Código:** No código-fonte, localize a classe responsável pela conexão JDBC.
3. **Credenciais:** Altere as variáveis de ambiente para as credenciais correspondentes ao seu ambiente local ou na nuvem (Supabase):

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
git clone https://github.com/SEU_USUARIO/loja-unieuro-estoque-g2.git

```

**2. Prepare a IDE**
Importe o projeto em sua IDE (IntelliJ IDEA, Eclipse ou Visual Studio Code).

**3. Configure o Driver**
Certifique-se de que o driver JDBC do PostgreSQL consta nas dependências (ex: `.jar` adicionado ao *build path* do projeto).

**4. Execute**
Execute a classe principal da interface gráfica para iniciar a aplicação e visualizar os resultados da consulta.

---

## 🤖 Declaração de Uso de Inteligência Artificial

Conforme as normas estabelecidas para a disciplina, declaramos que ferramentas de Inteligência Artificial foram empregadas como apoio para a estruturação dos scripts de teste, revisão de boas práticas de programação orientada a objetos e formatação da documentação técnica do repositório.
