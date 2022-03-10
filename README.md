# Microserviços - Api Ordem e Api Usuários

Pequeno projeto de microserviços utilizando spring cloud e suas funcionalidades. O projeto foi desenvolvido utilizando arquitetura hexagonal. Abaixo listo as tecnologias usadas, o motivo da utilização, o caminho dos endpoint, o que será consumido e o retorno esperado.

Para a execução do projeto utilizei:

- Spring Cloud - Responsável por criar o microserviço e realizar o seu processamento e persistência.
- Spring Netflix Eureka - Service Discovery responsável por unificar o registros dos microserviços.
- Spring Cloud Gateway - Responsável por se conectar com o eureka e expor via gateway os microserviços registrados.
- Spring Feign - Reponsável por executar o Load Balance na chamada de integração dos microserviços.
- Lombok - Para forncecer produtividade e redução de código boilerplate
- MySQL - Banco de Dados

# Microserviços

- http://localhost:8765 - API-Gateway - Responsável por centralizar as chamadas externas
- http://localhost:8761 - Naming Server - Service Discovery responsável por registar os microserviços
- http://localhost:8100 - Order API - Serviço de registro de pedidos.
- http://localhost:8400 - User API - Serviço de registro de usuários.

# Documentação

- Order API
   - http://localhost:8100/swagger-ui/index.html
   - Endpoints:
      - GET http://localhost:8100/orders  - Lista todas as ordens cadastradas no banco de dados.
        - JSON retorno:
          
              {
                "id": 0,
                "itemDescription": "string",
                "itemQuantity": 0,
                "itemPrice": 0,
                "totalValue": 0,
                "createdAt": "2022-02-25T02:09:14.567Z",
                "updatedAt": "2022-02-25T02:09:14.567Z"
              }
           

      - POST http://localhost:8100/orders - Cria uma ordem. 
          - Request Body requerido (exemplo):
          -     {
                  "userId": 0,
                  "itemDescription": "string",
                  "itemQuantity": 0,
                  "itemPrice": 0
                }
     - PUT Http://localhost:8100/orders - Edita uma ordem pelo seu id único.
         - Request Body requerido (exemplo):
         -      {
                  "orderId": 0,
                  "userId": 0,
                  "itemDescription": "string",
                  "cpf": 0,
                  "itemQuantity": 0,
                  "itemPrice": 0
                }
      - GET http:localhost:8100/orders/list-by-user/{id} - Lista as Ordens por Usuário (id do Usuário)
        - Parâmetro: Id do usuário
        - JSON do retorno:
          -      {
                  "orderResponses": [
                      {
                        "id": 0,
                        "itemDescription": "string",
                        "itemQuantity": 0,
                        "itemPrice": 0,
                        "totalValue": 0,
                        "createdAt": "2022-02-25T02:05:53.630Z",
                        "updatedAt": "2022-02-25T02:05:53.630Z"
                      }
                    ],
                    "userResponse": {
                      "name": "string",
                      "cpf": 0,
                      "email": "string",
                      "phoneNumber": 0
                    }
                }
       - DELETE http://localhost:8100/orders/{id} - Deleta uma orderm
        - Parâmetro: Id da ordem 
  
 - User API
   - http://localhost:8400/swagger-ui/index.html
   - Endpoints:
      - GET http://localhost:8400/users  - Lista todas os usuarios cadastradas no banco de dados.
        - JSON retorno:

              {
                "name": "string",
                "cpf": 0,
                "email": "string",
                "phoneNumber": 0,
                "createdAt": "2022-02-25T02:12:28.332Z",
                "updatedAt": "2022-02-25T02:12:28.332Z"
              }
           

      - POST http://localhost:8400/users - Cria um usuário. 
          - Request Body requerido (exemplo):
              -     {
                      "name": "string",
                      "cpf": 0,
                      "email": "string",
                      "phoneNumber": 0
                    }
     - PUT Http://localhost:8400/users - Edita uma usuário pelo seu id único.
         - Request Body requerido (exemplo):
         -      {
                  "id": 0,
                  "name": "string",
                  "cpf": 0,
                  "email": "string",
                  "phoneNumber": 0
                }
      - GET http://localhost:8400/users/{id} - Lista um usuário específico
        - Parâmetro: Id do usuário
        - JSON do retorno:
          -      {
                  "name": "string",
                  "cpf": 0,
                  "email": "string",
                  "phoneNumber": 0,
                  "createdAt": "2022-02-25T02:16:31.658Z",
                  "updatedAt": "2022-02-25T02:16:31.658Z"
                }
     - DELETE http://localhost:8400/users/{id} - Deleta um usuário específico
        - Parâmetro: Id do usuário 


