#language: pt

Funcionalidade: Gerenciamento de pedidos

  @DeleteExtraPets
  Cenario: Cliente cria um pedido na loja
    Dado que eu possua um animal available
    Quando faco o pedido desse animal
    Entao o pedido e aprovado