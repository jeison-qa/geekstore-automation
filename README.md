# GeekStore Automation

Proyecto de automatización de pruebas web desarrollado con Serenity BDD, Cucumber, Selenium WebDriver y Gradle.

Este proyecto forma parte de mi portafolio como QA Automation Engineer y tiene como objetivo validar funcionalidades críticas de una tienda en línea mediante pruebas automatizadas siguiendo el patrón Screenplay.

## Tecnologías
- Java 17
- Serenity BDD
- Cucumber
- Gradle
- Selenium WebDriver

## Estructura del proyecto

### Casos de prueba automatizados
| Flujo | Escenarios | Tags |
|---|---|---|
| Registro de usuarios | Registro exitoso, email duplicado, username duplicado | @smoke @registro |
| Login | Login exitoso, login fallido | @smoke @login |
| Carrito de compras | Agregar productos por categoria | @smoke @carrito |
| Configurar computador | RAM valida, RAM invalida | @regression @computador |

## Cómo correr las pruebas
```bash
# Todas las pruebas
gradle clean test

# Por tag
gradle clean test '-Dcucumber.filter.tags=@smoke'
gradle clean test '-Dcucumber.filter.tags=@login'
gradle clean test '-Dcucumber.filter.tags=@carrito'
gradle clean test '-Dcucumber.filter.tags=@computador'
```

## Reporte
 https://jeison-qa.github.io/geekstore-automation/

## Autor
Jeison Monterrosa — QA Automation
