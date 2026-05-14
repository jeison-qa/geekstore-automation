Feature: Configurar computador personalizado en GeekStore

  @regression @geekstore @computador
  Scenario Outline: Configurar computador con diferentes opciones
    Given el usuario esta autenticado y selecciona la categoria "<categoria>"
    When configura el computador con processor "<processor>" os "<os>" ssd "<ssd>" y ram "<ram>"
    Then el resultado de la configuracion es "<resultado>"

    Examples:
      | categoria | processor          | os         | ssd    | ram | resultado               |
      | Computers | AMD                | Windows 10 | 512 GB | 8   | boton agregar visible   |
      | Computers | Intel Core i6      | Windows 11 |   2 TB | 20  | Sorry: Invalid RAM size |
      | Computers | Intel Core i9      | Linux      |   1 TB | 3   | Sorry: Invalid RAM size |
