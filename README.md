# Sistema de Agendamento de Consultas

## Descrição

Este projeto é um sistema de agendamento de consultas médicas desenvolvido como parte de um desafio de back-end. O objetivo é fornecer uma API RESTful para gerenciar pacientes, médicos e consultas, garantindo um fluxo organizado e eficiente para marcação e cancelamento de consultas.

## Tecnologias Utilizadas

- **Java** (versão mais recente estável)
- **Spring Boot** (para desenvolvimento rápido e eficiente da API)
- **Spring Data JPA** (para interação com banco de dados relacional)
- **H2 Database** (banco de dados utilizado no projeto)
  
## Estrutura do Projeto

A estrutura do projeto segue as boas práticas do Spring Boot, aplicando princípios de Clean Architecture e SOLID:

```
/src
  /main
    /java
      /com
        /AgendamentoDeConsulta
          /SistemaAgendamento
            /controllers
            /dtos
            /enums
            /exception
            /models
            /repositories  
            /service    
            /utils  
    /resources
      /db/migration     # Scripts do Flyway para migração do banco
      application.yml    # Configurações do sistema
```

## Endpoints Principais

## **Criar Usuario**

- **POST /users**
- **Request Body:**
```json
{
	"nome": "Breno",
	"cpf": "123456789-10",
	"email":"12345@12345.com",
	"tipoUsuario":"Médico"
}
```
- **Response:**
```json
{
	"id": 3,
	"nome": "Breno",
	"cpf": "123456789-10",
	"email": "12345@12345.com",
	"tipoUsuario": "Médico",
	"especialidade": "Geral",
	"status": "Disponivel"
}
```

## **Listar Usuarios**

- **GET /users**
- **Response:**
```json
[
	{
		"id": 1,
		"nome": "Breno",
		"cpf": "123456789-10",
		"email": "12345@12345.com",
		"tipoUsuario": "Paciente",
		"especialidade": null,
		"status": "Disponivel"
	},
	{
		"id": 2,
		"nome": "Breno",
		"cpf": "123456789-10",
		"email": "12345@12345.com",
		"tipoUsuario": "Médico",
		"especialidade": "Geral",
		"status": "Ocupado"
	},
	{
		"id": 3,
		"nome": "Breno",
		"cpf": "123456789-10",
		"email": "12345@12345.com",
		"tipoUsuario": "Médico",
		"especialidade": "Geral",
		"status": "Disponivel"
	}
]
```

### **Agendar Consulta**
- **POST /consulta**
- **Request Body:**
```json
{
	"pacienteID":1,
	"medicoID":2,
	"DataConsulta":"2025-02-24"
}
```
- **Response:**
```json
No body returned for response
```

## **Listar Consultas**

- **GET /constulta**
- **Response:**
```json
[
	{
		"pacienteID": 2,
		"medicoID": 1,
		"dataConsulta": "2025-02-24"
	}
]
```


## Motivo da Não Utilização do Lombok

O **Lombok** não foi utilizado neste projeto devido a problemas de instabilidade em seu plugin, que pode causar dificuldades na compilação e execução da aplicação. Optamos por implementar manualmente os getters, 
setters e construtores para evitar possíveis inconsistências no ambiente de desenvolvimento e produção.

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Brenedito/SistemaAgendamentoAPI.git
   ```

2. Entre na pasta do projeto:
   ```bash
   cd SistemaAgendamentoAPI
   ```

4. Execute a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

5. A API estará disponível em `http://localhost:8080`



---
**Desenvolvido com ❤️ por Breno Brito**

