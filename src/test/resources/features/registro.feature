Feature: Registro de usuarios en GeekStore

  @smoke @geekstore @registro
  Scenario Outline: Registro de usuarios
    Given el usuario abre la pagina de registro de GeekStore
    When completa el formulario con "<telefono>" "<email>" "<usuario>" "<nombre>" "<apellido>" y "<clave>"
    Then "<resultado>"

    Examples:
      | telefono   | email                    | usuario    | nombre | apellido | clave     | resultado                                  |
      | 3001234568 | RANDOM                   | RANDOM     | Juan   | Perez    | Test1234! | debe ver el dashboard con su cuenta activa |
      | 3001234567 | testuser1@yopmail.com    | testuser99 | Juan   | Perez    | Test1234! | Email Already Taken                        |
      | 3001234567 | testuser99@yopmail.com   | testuser1  | Juan   | Perez    | Test1234! | Username Already Taken                     |