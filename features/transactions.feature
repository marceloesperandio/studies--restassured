Feature: Processamento de Transação - API Transactions
  Scenario Outline: Scenario Outline name: Inclusão de Transação <typeScenario>
    Given que o valor da transação seja <amount>,
    And a Descricao da transação <description>
    And o Metodo de Pagamento seja <payment_method>
    And o Numero do Cartão <card_number> esteja preenchido com um numero válido.
    And o Nome do portador <card_holder_name> preenchido.
    And a data de validade esteja no formarto <card_expiration_date>
    And e o codigo de verificação do cartão seja <card_cvv>
    When a transação for efetivada
    Then deverá retornar uma lista com os valores informados
    And o StatusCode da api <StatusCode>

    Examples:
      | Id | typeScenario                                                       | amount   | description           | payment_method | card_number      | card_holder_name | card_expiration_date | card_cvv | StatusCode |
      | 1  | POSITIVO -- Inclusão de Transação CC com bandeira Visa             | 12220,00 | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 200        |
      | 2  | POSITIVO -- Inclusão de Transação CC com bandeira Mastercard       | 12220,00 | Apple Watch: Series 7 | credit_card    | 5112582290429464 | Florus Pisani    | 04/26                | 254      | 200        |
      | 3  | POSITIVO -- Inclusão de Transação CC com bandeira Outros           | 12220,00 | Apple Watch: Series 7 | credit_card    | 340205901392278  | Layla Kharsack   | 04/22                | 254      | 200        |
      | 4  | POSITIVO -- Inclusão de Transação card_expiration_date com MM/YYYY | 12220,00 | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/2022              | 254      | 200        |
      | 5  | POSITIVO -- Inclusão de Transação DB                               | 12220,00 | Apple Watch: Series 7 | debit_card     | 4497737227506309 | Layla Kharsack   | 04/25                | 254      | 200        |
      | 6  | NEGATIVO -- Valor amount Invalido                                  | AAAAA    | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 400        |
      | 7  | NEGATIVO -- Valor amount vazio                                     |          | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 400        |
      | 8  | NEGATIVO -- Valor description Invalido                             | 12220,00 | 1234566               | credit_card    | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 400        |
      | 9  | NEGATIVO -- Campo payment_method vazio                             | 12220,00 | Apple Watch: Series 7 |                | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 400        |
      | 10 | NEGATIVO -- Descriçao da payment_method invalida                   | 12220,00 | Apple Watch: Series 7 | ouro           | 4497737227506309 | Layla Kharsack   | 04/30                | 254      | 400        |
      | 11 | NEGATIVO -- Campo card_number com valor invalido                   | 12220,00 | Apple Watch: Series 7 | credit_card    | AAAAA            | Layla Kharsack   | 04/30                | 254      | 400        |
      | 12 | NEGATIVO -- Descriçao da card_holder_name invalida                 | 12220,00 | Apple Watch: Series 7 | credit_card    | 4497737227506309 | 12151516116651   | 04/30                | 254      | 400        |
      | 13 | NEGATIVO -- Campo card_expiration_date com numero vencido          | 12220,00 | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/19                | 254      | 400        |
      | 14 | NEGATIVO -- Campo card_cvv menor que o numero permitido            | 12220,00 | Apple Watch: Series 7 | credit_card    | 4497737227506309 | Layla Kharsack   | 04/30                | 25       | 400        |
