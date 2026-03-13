# AUTO_FRONT_POM_FACTORY

Automatización E2E de interfaz web utilizando el patrón **Page Object Model (POM) + Page Factory** con **Serenity BDD**, **Cucumber** y **Selenium WebDriver**.

---

## Descripción

Este proyecto automatiza pruebas funcionales de un sistema de gestión de tickets (Ticket Management System). Cubre el flujo completo E2E: inicio de sesión del administrador, creación de un ticket de soporte, visualización del detalle y actualización de prioridad.

---

## Tecnologías y Dependencias

| Tecnología | Versión |
|---|---|
| Java | 17 |
| Gradle | Wrapper incluido |
| Serenity BDD | 4.2.22 |
| Cucumber | 7.20.1 |
| JUnit 5 (Platform Suite) | 1.11.4 |
| Selenium WebDriver | Vía Serenity |
| AssertJ | 3.23.1 |
| Logback | 1.2.10 |

---

## Estructura del Proyecto

```
pom/
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── gradle/wrapper/
│   └── gradle-wrapper.properties
└── src/test/
    ├── java/
    │   ├── pages/                  # Page Objects (POM + Page Factory)
    │   │   ├── BasePage.java
    │   │   ├── LoginPage.java
    │   │   ├── CreateTicketPage.java
    │   │   ├── TicketsPage.java
    │   │   └── TicketDetailPage.java
    │   ├── stepdefinitions/        # Definiciones de pasos Cucumber
    │   │   ├── LoginStepDefinitions.java
    │   │   └── TicketManagementStepDefinitions.java
    │   ├── steps/                  # Pasos de negocio (Serenity @Step)
    │   │   ├── LoginSteps.java
    │   │   └── TicketManagementSteps.java
    │   ├── runners/                # Runner de pruebas
    │   │   └── TestRunner.java
    │   └── utils/                  # Utilidades
    │       └── Priority.java
    └── resources/
        ├── features/               # Archivos Gherkin
        │   └── TicketManagement.feature
        ├── serenity.conf           # Configuración de Serenity
        └── logback-test.xml        # Configuración de logging
```

---

## Arquitectura

El proyecto sigue una arquitectura en capas:

```
Feature (Gherkin) → StepDefinitions → Steps (@Step) → Pages (POM + Page Factory)
```

- **Feature**: Escenarios escritos en lenguaje Gherkin.
- **StepDefinitions**: Vinculan los pasos Gherkin con la lógica de negocio.
- **Steps**: Contienen la lógica de negocio con anotaciones `@Step` de Serenity para reportes detallados.
- **Pages**: Implementan el patrón POM con `@FindBy` (Page Factory) heredando de `PageObject` de Serenity.

---

## Escenario de Prueba

**Feature: Ticket Management System E2E Flow**

1. El administrador inicia sesión en la plataforma.
2. Navega a la página de creación de tickets.
3. Crea un nuevo ticket con título y descripción.
4. Verifica que el ticket aparece en el dashboard.
5. Accede al detalle del ticket.
6. Cambia la prioridad a "HIGH" y guarda los cambios.
7. Verifica que la prioridad fue actualizada correctamente.

---

## Prerrequisitos

- **Java 17** o superior instalado.
- **Google Chrome** instalado.
- La aplicación bajo prueba corriendo en `http://localhost:3000`.

---

## Ejecución

Desde la carpeta `pom/`:

```bash
# Ejecutar todas las pruebas y generar reportes
./gradlew clean test aggregate

# Solo en Windows
gradlew.bat clean test aggregate
```

---

## Reportes

Tras la ejecución, Serenity genera reportes en:

- **HTML Single Page Report**: `pom/target/site/serenity/`

Abrir el archivo `index.html` en un navegador para consultar los resultados detallados con capturas de pantalla por cada acción.

---

## Configuración

La configuración del WebDriver y Serenity se encuentra en `src/test/resources/serenity.conf`:

- **URL base**: `http://localhost:3000`
- **Navegador**: Chrome
- **Capturas de pantalla**: En cada acción (`FOR_EACH_ACTION`)
- **Timeout implícito**: 5 segundos
- **Timeout de espera**: 10 segundos
- **Modo headless**: Desactivado por defecto
