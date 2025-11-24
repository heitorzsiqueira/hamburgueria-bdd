# language: pt
@hamburgueria
Funcionalidade: Pedidos na hamburgueria Peppa Lanches
  Para realizar pedidos corretos
  Como cliente
  Eu quero saber se o item pode ser pedido, o valor total e o tempo estimado

  Contexto:
    Dado que o cardápio contém os itens:
      | item         | preco |
      | x-bacon      | 25.00 |
      | x-salada     | 22.00 |
      | batata frita | 12.00 |

  @feliz
  Cenário: Pedido simples de item existente
    Quando eu pedir "x-bacon" com quantidade 2
    Então o total do pedido deve ser 50.00

  @inexistente
  Cenário: Pedido de item inexistente
    Quando eu pedir "milk-shake" com quantidade 1
    Então deve ocorrer erro "Item indisponível no cardápio"

  @quantidade
  Cenário: Pedido com quantidade inválida
    Quando eu pedir "x-salada" com quantidade 0
    Então deve ocorrer erro "Quantidade inválida"

  @desconto
  Cenário: Pedido com desconto de 10 por cento
    Quando eu pedir "batata frita" com quantidade 3 com desconto de 10 por cento
    Então o total do pedido deve ser 32.40

  @sla
  Cenário: Calcular tempo estimado de preparo
    Quando eu pedir "x-bacon" com quantidade total 4
    Então o tempo estimado deve ser 16
