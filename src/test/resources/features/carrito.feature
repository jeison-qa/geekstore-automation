Feature: Agregar producto al carrito en GeekStore

  @smoke @geekstore @carrito
  Scenario Outline: Agregar producto al carrito exitosamente
    Given el usuario esta autenticado en GeekStore
    When selecciona la categoria "<categoria>" y agrega el producto "<producto>" al carrito
    Then debe ver el mensaje de producto agregado

    Examples:
      | categoria          | producto                    |
      | Computers          | HP Spectre XT Pro UltraBook |
      | Digital Downloads  | Night Visions  |