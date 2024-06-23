# Sistema de Gerenciamento de Tarefas (To-Do List)

Este repositório contém um projeto de sistema de gerenciamento de tarefas desenvolvido para fins de estudo e aprimoramento de habilidades em desenvolvimento backend.

## Inspiração

Este projeto foi inspirado pelo desafio de desenvolvimento proposto pela Simplify, cujo repositório original pode ser encontrado [aqui](https://github.com/simplify-tec/desafio-junior-backend-simplify).

## Executar o projeto

1. Clone o Repositório

    Abra o terminal e execute o seguinte comando para clonar o repositório Todolist Backend:

    ```  
      git clone https://github.com/jordhanfelix/todolist-backend.git
   
      cd todolist-backend
   ```
## Iniciando os Serviços com Docker Compose
   2. No terminal, dentro do diretório todolist-backend, execute o seguinte comando para construir e iniciar os serviços necessários (Spring Boot e PostgreSQL) usando Docker Compose:

      ````
      docker-compose up --build 
      ````
   Este comando irá construir as imagens necessárias (se ainda não estiverem construídas) e iniciar os containers para a aplicação Spring Boot e o banco de dados PostgreSQL.

## Acessando a Aplicação
3.  Após a inicialização, você poderá acessar a aplicação nos seguintes endpoints, dependendo da configuração do seu docker-compose.yml:

- Aplicação: `http://localhost:8080`
- Swagger UI (Documentação da API): ``http://localhost:8080/swagger``

## Encerrando a Aplicação
4. Para encerrar a aplicação e remover os containers, pressione Ctrl + C no terminal onde o ``docker-compose up`` está sendo executado. Em seguida, execute o seguinte comando para limpar os containers:

      ````
      docker-compose down      
      ````
  Isso removerá os containers, mas manterá os dados do banco de dados persistidos (se configurado no ``docker-compose.yml``).

## Tecnologias Utilizadas

Aqui estão algumas das tecnologias e ferramentas que podem ser usadas para este projeto:

- Linguagem de programação: Java
- Framework: Spring Boot
- Banco de dados: H2 (ambiente de testes), PostgreSQL.
- Outros: Maven, JPA/Hibernate