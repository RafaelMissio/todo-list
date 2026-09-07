# todo-list

Aplicação Spring Boot para gerenciamento de tarefas (`todos`) com API REST, persistência com JPA e documentação OpenAPI.

## Tecnologias

- Java 25
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Spring Validation
- SpringDoc OpenAPI
- H2 e MySQL

## Funcionalidades

- Criar, listar, consultar, atualizar e remover tarefas.
- Validar dados de entrada.
- Retornar erros padronizados para recurso não encontrado e validação.

## Estrutura principal

- `src/main/java/br/com/missio/todolist/controllers`
- `src/main/java/br/com/missio/todolist/services`
- `src/main/java/br/com/missio/todolist/repositories`
- `src/main/java/br/com/missio/todolist/entities`
- `src/main/java/br/com/missio/todolist/dto`

## Execucao

```bash
mvn spring-boot:run
```

## Build

```bash
mvn clean package
```

## Testes

```bash
mvn test
```

## API

- `GET /todos`
- `GET /todos/{id}`
- `POST /todos`
- `PUT /todos/{id}`
- `DELETE /todos/{id}`

## Documentacao

- OpenAPI/SpringDoc disponivel na aplicacao.
- `HELP.md` contem referencias oficiais do ecossistema Spring usadas no projeto.
