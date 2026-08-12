# 📦 StockFlow

Sistema de gerenciamento de estoque desenvolvido em **Java**, atualmente utilizando **Spring Boot**, **Spring Data JPA**, **Hibernate** e **PostgreSQL**.

O projeto começou como uma aplicação Java utilizando **JDBC** e evoluiu para uma **API REST**, acompanhando minha jornada de aprendizado para me tornar um **Desenvolvedor Back-End Java**.

---

# 🚀 Funcionalidades

* ✅ Cadastro de produtos
* ✅ Listagem de produtos
* ✅ Busca de produto por ID
* ✅ Atualização de produtos
* ✅ Remoção de produtos
* ✅ Controle de estoque
* ✅ Produtos físicos
* ✅ Produtos digitais
* ✅ Persistência em PostgreSQL
* ✅ Geração automática de IDs pelo banco
* ✅ API REST
* ✅ Respostas HTTP apropriadas
* ✅ `201 Created` para criação de recursos
* ✅ `404 Not Found` para recursos inexistentes
* ✅ `204 No Content` para remoção
* ✅ Arquitetura em camadas
* ✅ Spring Data JPA
* ✅ Hibernate

### Funcionalidades implementadas anteriormente

* ✅ Exportação de produtos para CSV
* ✅ Backup de dados utilizando serialização (`.dat`)
* ✅ Restauração de backups
* ✅ Persistência utilizando JDBC

---

# 🛠️ Tecnologias

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* PostgreSQL
* JDBC
* Java I/O (NIO)
* Maven
* Git
* GitHub

---

# 📚 Conceitos Aplicados

## Programação Orientada a Objetos

* Classes e Objetos
* Encapsulamento
* Herança
* Polimorfismo
* Classes Abstratas
* Interfaces

## Collections Framework

* List
* ArrayList
* Iterator

## Tratamento de Exceções

* `try/catch`
* `finally`
* `throw`
* `throws`
* Exceções customizadas

## Banco de Dados

* PostgreSQL
* SQL
* JDBC
* PreparedStatement
* ResultSet
* Generated Keys
* CRUD completo
* Persistência de entidades

## Java I/O

* Path
* Files
* BufferedWriter
* BufferedReader
* InputStream
* OutputStream
* ObjectInputStream
* ObjectOutputStream
* Serializable
* Exportação CSV
* Backup e restauração de objetos

## Spring Boot

* Spring Boot
* Inversão de Controle (IoC)
* Injeção de Dependência (DI)
* Spring Web
* REST API
* `@RestController`
* `@GetMapping`
* `@PostMapping`
* `@PutMapping`
* `@DeleteMapping`
* `ResponseEntity`
* Status HTTP

## Spring Data JPA

* `@Entity`
* `@Id`
* `@GeneratedValue`
* `JpaRepository`
* `findAll()`
* `findById()`
* `save()`
* `existsById()`
* `deleteById()`

## Hibernate

* ORM
* Mapeamento objeto-relacional
* Persistência de entidades
* Geração de SQL

## Boas Práticas

* Separação de responsabilidades
* Arquitetura em camadas
* Injeção de dependências
* Reutilização de código
* Organização de pacotes
* Persistência desacoplada
* Uso adequado de status HTTP

---

# 📂 Estrutura do Projeto

```text
src
└── main
    ├── java
    │   └── estoque
    │       ├── controller
    │       ├── model
    │       ├── repository
    │       ├── service
    │       ├── io
    │       └── StockflowApiApplication.java
    │
    └── resources
        └── application.properties
```

A arquitetura atual segue o fluxo:

```text
Cliente HTTP
     ↓
Controller
     ↓
Service
     ↓
Repository
     ↓
Spring Data JPA
     ↓
Hibernate
     ↓
PostgreSQL
```

---

# 💾 Banco de Dados

O projeto utiliza **PostgreSQL** para persistência dos dados.

A versão atual utiliza **Spring Data JPA + Hibernate** para realizar o mapeamento entre objetos Java e tabelas do banco.

### Entidade principal

```java
@Entity
public class Produto
```

Campos principais:

| Campo      | Tipo    |
| ---------- | ------- |
| id         | Long    |
| nome       | String  |
| preco      | Double  |
| quantidade | Integer |
| categoria  | String  |
| tipo       | String  |

O ID é gerado automaticamente pelo PostgreSQL.

---

# 📡 API REST

## Listar produtos

```http
GET /produtos
```

Resposta:

```http
200 OK
```

---

## Buscar produto por ID

```http
GET /produtos/{id}
```

Produto encontrado:

```http
200 OK
```

Produto inexistente:

```http
404 Not Found
```

---

## Criar produto

```http
POST /produtos
```

Exemplo:

```json
{
    "nome": "Mouse Gamer",
    "preco": 120.00,
    "quantidade": 15,
    "categoria": "Periféricos",
    "tipo": "fisico"
}
```

Resposta:

```http
201 Created
```

---

## Atualizar produto

```http
PUT /produtos/{id}
```

Resposta:

```http
200 OK
```

Caso o produto não exista:

```http
404 Not Found
```

---

## Remover produto

```http
DELETE /produtos/{id}
```

Produto removido:

```http
204 No Content
```

Produto inexistente:

```http
404 Not Found
```

---

# ⚙️ Como executar

## Clone o projeto

```bash
git clone https://github.com/thiagofogaca25/StockFlow.git
```

```bash
cd StockFlow
```

## Crie o banco

```sql
CREATE DATABASE stockflow;
```

## Configure a conexão

Edite:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/stockflow
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> Não coloque senhas reais no repositório GitHub.

## Execute

Utilizando Maven:

```bash
mvn spring-boot:run
```

Ou:

```bash
mvn clean package
```

e depois execute o `.jar` gerado.

---

# 📸 Imagens

### Estrutura do projeto

Adicione aqui uma captura de tela da estrutura do projeto no VS Code ou IntelliJ.

### Código

Adicione aqui uma captura de tela mostrando a implementação da API REST.

### Execução

Adicione aqui uma captura de tela do Postman, Insomnia ou terminal mostrando uma requisição à API.

---

# 📈 Roadmap do Projeto

## ✅ Concluído

* ✔️ Programação Orientada a Objetos
* ✔️ Collections Framework
* ✔️ Tratamento de Exceções
* ✔️ JDBC
* ✔️ PostgreSQL
* ✔️ Java I/O
* ✔️ CRUD completo
* ✔️ Exportação CSV
* ✔️ Backup e restauração de dados
* ✔️ Maven
* ✔️ Spring Boot
* ✔️ API REST
* ✔️ Spring Data JPA
* ✔️ Hibernate
* ✔️ Integração Spring Boot + PostgreSQL
* ✔️ `ResponseEntity`
* ✔️ Status HTTP `200`, `201`, `204` e `404`

## 🚧 Próximas implementações

* [ ] Bean Validation
* [ ] Tratamento global de exceções
* [ ] `@ControllerAdvice`
* [ ] DTOs
* [ ] MapStruct
* [ ] JUnit
* [ ] Mockito
* [ ] Testes de integração
* [ ] Swagger / OpenAPI
* [ ] Spring Security
* [ ] JWT
* [ ] Flyway
* [ ] Docker
* [ ] Docker Compose
* [ ] Paginação
* [ ] Ordenação

---

# 🎯 Objetivo

O **StockFlow** é meu projeto principal de estudos em Java Back-End.

A cada fase do roadmap, novas tecnologias e boas práticas são incorporadas ao sistema, transformando gradualmente a aplicação em um projeto com arquitetura próxima à utilizada em aplicações profissionais.

O projeto começou como uma aplicação Java utilizando JDBC e PostgreSQL:

```text
Java
 ↓
POO
 ↓
JDBC
 ↓
PostgreSQL
```

e atualmente evoluiu para:

```text
Spring Boot
 ↓
REST API
 ↓
Service
 ↓
Spring Data JPA
 ↓
Hibernate
 ↓
PostgreSQL
```

A evolução continuará com validação, tratamento de exceções, testes, segurança, documentação e containerização.

---

# 👨‍💻 Autor

**Thiago Fogaça**

GitHub
https://github.com/thiagofogaca25

LinkedIn
https://www.linkedin.com/in/thiago-fogaca

---

Se este projeto foi útil ou interessante para você, considere deixar uma ⭐ no repositório.
