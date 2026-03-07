# 🎬 Movie API - Java

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

## 📋 Sobre o Projeto

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de filmes. A aplicação permite realizar operações de CRUD em um catálogo de filmes, seguindo as melhores práticas de desenvolvimento com arquitetura em camadas.

### 🎯 Funcionalidades

- ✅ Cadastro de filmes com validação de dados
- ✅ Listagem completa de filmes
- ✅ Busca por ID
- ✅ Atualização de informações
- ✅ Remoção de filmes
- ✅ DTOs para controle de dados trafegados

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3** - Framework principal
- **Spring Web** - Criação de APIs REST
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **Lombok** - Redução de código boilerplate
- **Maven** - Gerenciamento de dependências

## 📁 Estrutura do Projeto
src/main/java/com/joaodddev/movieapi/
├── controller/ # Controladores REST (endpoints da API)
├── service/ # Lógica de negócios da aplicação
├── model/ # Entidades JPA (representação das tabelas)
├── dto/ # Objetos de transferência de dados
└── MovieapiApplication.java # Classe principal da aplicação


### Detalhamento da Estrutura

- **controller/**: Classes que expõem os endpoints REST da API
- **service/**: Classes responsáveis pelas regras de negócio
- **model/**: Entidades que representam as tabelas do banco de dados
- **dto/**: Objetos para transferência de dados entre camadas (evita expor as entidades diretamente)
- **MovieapiApplication.java**: Classe com método `main` para iniciar a aplicação Spring Boot

## Pré-requisitos

- Java 17 ou superior
- Maven 3.8 ou superior
- Banco de dados (PostgreSQL/MySQL - a definir)

👨‍💻 Autor
João Victor

https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white

