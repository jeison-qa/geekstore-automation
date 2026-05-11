Feature: Login de usuarios en GeekStore

  @smoke @geekstore @login
  Scenario Outline: Login con diferentes credenciales
    Given el usuario abre la pagina de login de GeekStore
    When ingresa email "<email>" y clave "<clave>"
    Then el resultado del login es "<resultado>"

    Examples:
      | email                 | clave      | resultado                    |
      | testuser1@yopmail.com | Test1234!  |  debe ver su cuenta activa    |
      | error@yopmail.com      | clavemal   | These credentials do not match our records.|