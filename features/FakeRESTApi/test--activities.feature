Feature: Activities

  @activities
  Scenario Outline: Validação dos metodos da api Activities.
    Given Dado que eu preencha todos campos necessário para chamada da api
    Then o statusCode sera 200.

    Examples:
      | Method | statusCode |
      | GET    | 200        |