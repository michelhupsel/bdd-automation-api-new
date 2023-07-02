#language: pt

Funcionalidade: Gerenciamento de um animal da Loja


  Cenario: Lista animais disponíveis para a venda
    Dado que eu possua animais available
    Quando eu pesquiso por todos os animais available
    Entao eu recebo a lista de animais available
    # Passo redundante
    E eu recebo uma outra lista de animais available

  Cenario: Lista somente animais pending
    Dado que eu possua animais pending
    Quando eu pesquiso por todos os animais pending
    Entao recebo a lista com 2 animais

  Cenario: Não lista nenhum animal
    Dado que eu nao possua animais sold
    Quando eu pesquiso por todos os animais sold
    Entao recebo a lista com 0 animal


