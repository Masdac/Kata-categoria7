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

  @LoginIncompleto
  Scenario Outline: Intentar iniciar sesión sin ingresar Username y validar mensaje de error
    Given el usuario deja vacío el campo username
    And escribe "<password>" en password
    When se da click al botón Login
    Then se muestra el mensaje "Required"

    Examples:
      | password  |
      | admin123  |

  @LoginVacio
  Scenario: Intentar iniciar sesión sin ingresar Username ni Password y validar mensaje de error
    Given el usuario deja vacío el campo username
    And el usuario deja vacío el campo password
    When se da click al botón Login
    Then se muestra el mensaje "Required" en el campo username
    And se muestra el mensaje "Required" en el campo password

  @LoginExitoso
  Scenario: Iniciar sesión con credenciales correctas
    Given el usuario escribe "Admin" en username
    And escribe "admin123" en password
    When se da click al botón Login
    Then el usuario es redirigido al dashboard


