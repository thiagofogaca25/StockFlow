# 📦 StockFlow
![Java](https://img.shields.io/badge/Java-21-orange)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-success)

Sistema de gerenciamento de estoque desenvolvido em **Java**, aplicando conceitos de **Programação Orientada a Objetos**, **JDBC** e **PostgreSQL**.

O projeto faz parte da minha jornada de aprendizado para me tornar um Desenvolvedor Back-End Java e evolui continuamente conforme avanço no roadmap de estudos.

---

# 🚀 Funcionalidades

- ✅ Cadastro de produtos
- ✅ Listagem de produtos
- ✅ Busca por ID
- ✅ Atualização de produtos
- ✅ Remoção de produtos
- ✅ Controle de estoque
- ✅ Produtos físicos
- ✅ Produtos digitais
- ✅ Persistência de dados em PostgreSQL
- ✅ Geração automática de IDs pelo banco
- ✅ Arquitetura em camadas (Model • DAO • Service)
- ✅ Interface via terminal

---

# 🛠️ Tecnologias

- Java 21
- PostgreSQL
- JDBC
- Maven
- Git
- GitHub

---

# 📚 Conceitos Aplicados

### Programação Orientada a Objetos

- Classes e Objetos
- Encapsulamento
- Herança
- Polimorfismo
- Classes Abstratas
- Interfaces

### Collections Framework

- ArrayList
- List
- Iterator

### Tratamento de Exceções

- try/catch
- finally
- throw
- throws
- Exceções customizadas

### Banco de Dados

- PostgreSQL
- JDBC
- Connection
- PreparedStatement
- ResultSet
- Generated Keys
- CRUD completo

### Boas práticas

- Separação de responsabilidades
- Arquitetura em camadas
- Reutilização de código
- Organização de pacotes

---

# 📂 Estrutura do Projeto

```
src
└── main
    └── java
        └── estoque
            ├── model
            │   ├── Produto.java
            │   ├── ProdutoFisico.java
            │   └── ProdutoDigital.java
            │
            ├── dao
            │   └── ProdutoDAO.java
            │
            ├── service
            │   └── EstoqueService.java
            │
            ├── database
            │   └── ConnectionFactory.java
            │
            └── Main.java
```

---

# 💾 Banco de Dados

O projeto utiliza **PostgreSQL** para persistência dos dados.

Tabela principal:

| Campo | Tipo |
|-------|------|
| id | SERIAL |
| nome | VARCHAR |
| preco | DECIMAL |
| quantidade | INTEGER |
| categoria | VARCHAR |
| tipo | VARCHAR |

---

# ⚙️ Como executar

## 1. Clone o repositório

```bash
git clone https://github.com/thiagofogaca25/StockFlow.git
```

---

## 2. Entre na pasta

```bash
cd StockFlow
```

---

## 3. Configure o PostgreSQL

Crie um banco de dados:

```sql
CREATE DATABASE stockflow;
```

Depois crie a tabela:

```sql
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    categoria VARCHAR(50),
    tipo VARCHAR(20)
);
```

---

## 4. Configure a conexão

Edite a classe `ConnectionFactory.java` informando:

```java
url
usuario
senha
```

---

## 5. Execute

Pela IDE:

```
Main.java
```

Ou utilizando Maven:

```bash
mvn compile
mvn exec:java
```

---

# 📈 Roadmap do Projeto

## ✅ Concluído

- Programação Orientada a Objetos
- Collections Framework
- Tratamento de Exceções
- JDBC
- PostgreSQL
- CRUD completo
- 
## Imagens
[codigos 1](https://github.com/thiagofogaca25/StockFlow/blob/main/codigos1.png)
[codigos 2](https://github.com/thiagofogaca25/StockFlow/blob/main/codigos2.png)
[terminal](https://github.com/thiagofogaca25/StockFlow/blob/main/terminal1.png)

## 🚧 Próximas implementações

- [ ] Spring Boot
- [ ] API REST
- [ ] Spring Data JPA
- [ ] Hibernate
- [ ] Validação com Bean Validation
- [ ] JWT
- [ ] Docker
- [ ] Testes Unitários (JUnit)
- [ ] Swagger / OpenAPI

---

# 🎯 Objetivo

Mais do que um sistema de estoque, este projeto representa minha evolução prática em Java.

A cada nova etapa do roadmap, novas tecnologias e boas práticas são incorporadas, transformando o StockFlow em uma aplicação cada vez mais próxima de um sistema utilizado no mercado.

---

# 👨‍💻 Autor

**Thiago Fogaça**

GitHub:
> https://github.com/thiagofogaca25

LinkedIn:
> https://www.linkedin.com/in/thiago-fogaca

---

⭐ Se este projeto foi interessante para você, deixe uma estrela no repositório!