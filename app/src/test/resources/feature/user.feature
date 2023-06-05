#language: pt

Funcionalidade: Gerenciamento de um usuario na Petstore

  Algum contexto de negocio
  História do Jira
  Qualquer informação

  Cenario: Cria um usuario na loja
    Quando faco um POST para /v3/user com os seguintes valores:
      | id         | 10             |
      | username   | theUser        |
      | firstName  | John           |
      | lastName   | James          |
      | email      | john@email.com |
      | password   | 12345          |
      | phone      | 12345          |
      | userStatus | 1              |
    Entao quando faco um GET para /v3/user/theUser, o usuario e criado

  Cenario: Cria usuario na loja refletindo o negocio
    Quando crio um usuario
    Entao o usuario é salvo no sistema



