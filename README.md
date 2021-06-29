# Spring RESTful API

Projeto para avalição de backend

## Tecnologias:

- [Java 11](https://docs.oracle.com/en/java/javase/11/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/)
- [JWT](https://jwt.io/)
- [Amazon S3](https://aws.amazon.com/pt/s3/)
- [Lombok](https://projectlombok.org/)
- [ModelMapper](http://modelmapper.org/)
- [MySQL](https://www.mysql.com/)
- [Flyway Migration](https://flywaydb.org/documentation/concepts/migrations)
- [OpenAPI | Swagger](https://swagger.io/specification/)

## Características:

- DTO (Data Transfer Object)
- Conversão automática de DTO para Entidade
- Mensagens de exceções personalizadas
- JWT - JSON Web Token para autenticação do usuário
- Upload de imagens no Amazon S3
- Flyway para o controle e versionamento de dados e tabelas no banco de dados
- Open API para documentação da API

## Ferramentas usadas:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/promo/)
- [MySQL Workbench](https://www.mysql.com/products/workbench/)
- [Postman](https://www.postman.com/)

## Feito com:

- [Spring Initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/index.html)

## Como posso testar os endpoints?

Abra sua IDEA de preferência

O maven irá baixar as dependências e depois disso abra a classe WsAvaliacaoApplication clicando na opção Run

Você pode usar [Insomnia](https://insomnia.rest/) ou [Postman](https://www.postman.com/) para checar os endpoints

Para usar a api é necessário: 

1. Primeiro criar um novo usuário

2. Fazer autenticação com username e password para poder acessar outros endpoints

3. Utilizar o token gerado para poder acessar outros endpoints