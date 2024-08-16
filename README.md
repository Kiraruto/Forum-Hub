# Forum-Hub

**Forum-Hub** é uma aplicação Back-End desenvolvida em Java, projetada para ser um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos e receber respostas de outros usuários. Esta API oferece operações básicas de CRUD para tópicos, respostas e gerenciamento de usuários.

## Funcionalidades

A API oferece as seguintes operações:

### Tópicos
- **Criar Tópico:** `POST /topicos`
- **Atualizar Tópico:** `PUT /topicos`
- **Deletar Tópico:** `DELETE /topicos`
- **Listar Tópicos:** `GET /topicos`
- **Listar Tópico por ID:** `GET /topicos/{id}`

### Respostas
- **Criar Resposta:** `POST /resposta`
- **Listar Respostas:** `GET /resposta`
- **Apagar Respostas:** `DELETE /resposta`
- **Listar Respostas por ID do Tópico:** `GET /resposta?topico_id={id}`

### Usuários
- **Criar Usuário:** `POST /usuario`
- **Logar:** `POST /login`

## Como Usar

Para utilizar a aplicação, siga estas etapas:

1. **Criar Usuário:**
   - Endpoint: `POST /usuario`
   - Exemplo de corpo da requisição:
     ```json
     {
         "id": 1,
         "nome": "Fulano",
         "email": "fulano@example.com",
         "senha": "$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.",
         "perfil": {
             "id": 1,
             "nome": "Perfil Fulano"
         }
     }
     ```

2. **Logar e Obter Token JWT:**
   - Endpoint: `POST /login`
   - Exemplo de corpo da requisição:
     ```json
     {
         "email": "fulano@example.com",
         "senha": "123456"
     }
     ```

3. **Autenticar Requisições:**
   - Inclua o token JWT no cabeçalho `Authorization` das requisições para acessar as rotas protegidas.
   - Exemplo:
     ```json
     {
         "method": "GET",
         "url": "http://sua-api-url/topicos",
         "headers": {
             "Authorization": "Bearer seuToken"
         }
     }
     ```

4. **Criar Tópico:**
   - Endpoint: `POST /topicos`
   - Exemplo de corpo da requisição:
     ```json
     {
         "titulo": "Projeto de Machine Learning",
         "mensagem": "Discussão sobre algoritmos de aprendizado de máquina.",
         "dataCriacao": "2024-06-30T15:45:00",
         "status": true,
         "autor": {
             "id": 3,
             "nome": "Ciclano",
             "email": "ciclano@example.com",
             "senha": "$2a$10$abc123xyz456",
             "perfil": {
                 "id": 3,
                 "nome": "Perfil Ciclano"
             }
         },
         "curso": {
             "id": 3,
             "nome": "Curso B",
             "categoria": "Ciência de Dados"
         }
     }
     ```

5. **Criar Resposta:**
   - Endpoint: `POST /resposta`
   - Exemplo de corpo da requisição:
     ```json
     {
         "id": 5,
         "mensagem": "esta é outra mensagem para teste.",
         "data_criacao": "2024-07-06T15:20:00",
         "autor": {
             "id": 1
         },
         "topico": {
             "id": 1
         },
         "solucao": false
     }
     ```

## Requisitos

Certifique-se de que o seu ambiente de desenvolvimento tenha as seguintes dependências:

- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

### Instruções de Configuração

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
