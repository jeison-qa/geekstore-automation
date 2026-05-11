# GeekStore Automation

Proyecto de automatización de pruebas para GeekStore usando Serenity BDD, Cucumber y Gradle.

## Tecnologías
- Java 17
- Serenity BDD
- Cucumber
- Gradle
- Selenium WebDriver

## Estructura del proyecto

## Casos de prueba automatizados
| Escenario | Tags | Estado |
|---|---|---|
| Registro exitoso con datos aleatorios | @smoke @geekstore | ✅ |
| Registro con email ya existente | @regression @geekstore | ✅ |
| Registro con username ya existente | @regression @geekstore | ✅ |

## Cómo correr las pruebas
```bash
gradle clean test
```

## Reporte
 https://jeison-qa.github.io/geekstore-automation/

## Autor
Jeison Monterrosa — QA Automation