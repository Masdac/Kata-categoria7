@loginOrangehrm
Feature: Prueba de login en OrangeHRM

  @LoginIncorrecto
  Scenario Outline: Intentar iniciar sesión con credenciales incorrectas y validar mensaje de error
    Given el usuario escribe "<usuario>" en username
    And escribe "<password>" en password
    When se da click al botón Login
    Then se muestra el mensaje "Invalid credentials"

    Examples:
      | usuario  | password  |
      | testuser | 123456    |
      | Admin    | 659823    |

  @LoginIncompleto
  Scenario Outline: Intentar iniciar sesión sin ingresar Username o Password y validar mensaje de error
    Given el usuario escribe en el campo "<locator1>" el texto ""
    And escribe en el campo "<locator2>" el texto "<texto>"
    When se da click al botón Login
    Then se muestra 1 mensaje "Required" en la pantalla

    Examples:
      | locator1  | locator2 | texto       |
      | username  | password | contrasena  |
      | password  | username | usuario     |


  @LoginVacio
  Scenario: Intentar iniciar sesión sin ingresar Username ni Password y validar mensaje de error
    Given el usuario deja vacio el username y el password
    When se da click al botón Login
    Then se muestra 2 mensajes "Required" en la pantalla

  @LoginExitoso
  Scenario: Iniciar sesión con credenciales correctas
    Given el usuario escribe "Admin" en username
    And escribe "admin123" en password
    When se da click al botón Login
    Then el usuario es redirigido al dashboard
