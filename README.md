# 📦 FiapLocatech

**FiapLocatech** é um projeto pessoal de estudos criado com o objetivo de praticar o desenvolvimento de APIs REST usando **Java**, **Spring Boot** e a documentação interativa do **Swagger**. O sistema simula uma aplicação de locação de tecnologia (como notebooks, smartphones, etc.), com operações básicas de **CRUD** para diferentes entidades.

Este repositório é parte da minha jornada de aprendizado com o ecossistema Spring, explorando boas práticas de arquitetura e o uso de ferramentas modernas de documentação de APIs.

---

## 🚀 Tecnologias e Ferramentas

- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Swagger / Springdoc OpenAPI**
- **Maven**
- **H2 Database (para testes locais)**

---

## 🎯 Objetivos do Projeto

- Fixar os conceitos de API RESTful com Spring Boot
- Praticar o padrão MVC (Model-View-Controller)
- Aplicar o CRUD completo em múltiplas entidades
- Aprender a configurar e utilizar o **Swagger UI** para documentação da API
- Organizar o código seguindo uma arquitetura limpa e escalável

---

## 🧱 Estrutura do Projeto

```bash
FiapLocatech
├── model/         # Entidades do sistema (ex: Cliente, Produto, Locacao)
├── repository/    # Interfaces que acessam o banco de dados (JPA)
├── service/       # Regras de negócio
├── controller/    # Endpoints REST expostos pela API
├── config/        # Configuração do Swagger e outras definições globais
└── resources/
    └── application.properties  # Configurações da aplicação
