# EntregaP3P4 · Prestamo-Formulario

Aplicación web con **Spring Boot, Spring MVC y Thymeleaf** para consultar el catálogo
de un aula maker y enviar solicitudes de préstamo. El catálogo y las solicitudes son
temporales: no hay base de datos ni persistencia, y una solicitud válida solo se
muestra en la página de resultado.

---

## 1.Requisitos

- Java 17 o 21
- Maven (o el wrapper incluido: `mvnw`)
- Puerto **8080** libre

## 1.1 Cómo ejecutar

- **Desde el IDE:** ejecutar la clase `EntregaP3P4Application`.
- **Desde la terminal:**
    - Linux/macOS: `./mvnw spring-boot:run`
    - Windows: `mvnw.cmd spring-boot:run`

La aplicación queda disponible en http://localhost:8080

---

## 2.Rutas principales

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/` | Catálogo de materiales |
| GET | `/materiales/{codigo}?turno=` | Ficha del material. `turno` es opcional (por defecto `general`) |
| GET | `/solicitud/nueva` | Formulario de solicitud de préstamo |
| POST | `/solicitudes` | Valida la solicitud y muestra el resumen o vuelve al formulario con errores |

Un código inexistente (por ejemplo `/materiales/NO-EXISTE`) devuelve un **404 real**
y se muestra `error/404.html`. Existen también `error/4xx.html` y `error/5xx.html`.

---

## 3.Estructura del proyecto

```
src/main/java/com/aulamaker/entregaP3P4/
    EntregaP3P4Application.java
    MaterialesControlador.java      # controlador y métodos auxiliares
    SolicitudPrestamoForm.java      # DTO del formulario
src/main/resources/
    messages.properties             # mensajes de errores de conversión
    static/css/estilos.css
    templates/
        catalogo.html  ficha.html  formulario.html  resultado.html
        error/404.html  error/4xx.html  error/5xx.html
```

---

## 4.Ámbitos de las variables y uso del modelo

- **Parámetros de método** (`codigo`, `turno`, `model`, `solicitud`, `result`):
  solo existen dentro del método que los recibe; se crean al llamarlo y desaparecen
  al terminar.
- **Variables locales** (`material`, `recogida`, `devolucion`, `dias`, `diasUnidad`):
  se declaran dentro de un método y solo existen hasta el final de su bloque.
- **Propiedades del DTO** (`nombre`, `correo`, `material`, `unidades`,
  `fechaRecogida`, `fechaDevolucion`, `motivo`, `normas`): atributos de instancia de
  `SolicitudPrestamoForm`. Se rellenan con el binding en cada petición, se descartan
  al terminar y se acceden con getters y setters.
- **Constante de clase** (`MATERIALES`, `static final`): el array del catálogo, visible
  desde todos los métodos del controlador.
- **Atributos del modelo**: se añaden con `model.addAttribute(...)` y solo están
  disponibles en la plantilla que devuelve ese método, durante esa petición.

### 5.Uso de los atributos del modelo en la vista

| Método | Atributos del modelo | Plantilla | Uso en la vista |
|---|---|---|---|
| `catalogo` | `materiales` | `catalogo.html` | `th:each="m : ${materiales}"` |
| `ficha` | `material`, `turno` | `ficha.html` | `${material[1]}`, `${turno}` |
| `nuevaSolicitud` | `solicitud`, `materiales` | `formulario.html` | `th:object`, opciones del selector |
| `procesarSolicitud` (con errores) | `solicitud`, `materiales` | `formulario.html` | repuebla campos y selector |
| `procesarSolicitud` (válida) | `solicitud`, `nombreMaterial`, `dias`, `diasUnidad` | `resultado.html` | resumen y `th:if="${dias == 1}"` |

`${...}` accede a un atributo del modelo; `*{...}` accede a una propiedad del objeto
indicado en `th:object` (`*{nombre}` equivale a `${solicitud.nombre}`).

---

## 6.Decisiones técnicas

- **Tipos de datos:** `String` para textos, `Integer` para unidades (admite `null` si
  la conversión falla), `LocalDate` para fechas, `boolean` para la aceptación de
  normas y `long` para días y días-unidad.
- **Validación:** anotaciones de Jakarta Bean Validation en el DTO y dos reglas en el
  controlador con `BindingResult` (el material existe en el catálogo y la devolución
  no es anterior a la recogida).
- **Conversión:** los errores de conversión (texto en unidades, fecha con formato
  inválido) tienen mensajes en español en `messages.properties`.
- **Seguridad:** todos los datos recibidos se muestran con `th:text` (escapado). No se
  usa `th:utext`.
- **Enlaces:** todos los enlaces y el `action` del formulario se generan con `@{...}`,
  sin rutas escritas a mano.
- **Errores:** páginas propias sin trazas ni detalles internos.

---

## 7.Comprobaciones realizadas

| Prueba | Resultado esperado | Estado |
|---|---|---|
| Abrir `/` | Catálogo con todos los materiales y enlaces a sus fichas | ⬜ |
| `/materiales/MICRO?turno=tarde` | Ficha del kit y turno «tarde» | ⬜ |
| `/materiales/MICRO` | Turno predeterminado «general» | ⬜ |
| `/materiales/NO-EXISTE` | Estado 404 y página `404.html` | ⬜ |
| Formulario vacío | Errores y selector con opciones | ⬜ |
| Correo inválido, 0 unidades o motivo corto | Errores de validación y resto de valores conservados | ⬜ |
| Texto en unidades o fecha inválida | Error de conversión comprensible, sin resultado | ⬜ |
| Devolución anterior a la recogida | Error en la fecha de devolución, sin resultado | ⬜ |
| Todos los campos correctos | Resumen, días, días-unidad y mensaje condicional | ⬜ |
| Préstamo de un día frente a varios días | Mensaje distinto en cada caso | ⬜ |
| HTML en un campo (`<b>hola</b>`) | Se muestra como texto escapado | ⬜ |
| Existen `4xx.html` y `5xx.html` | Plantillas generales presentes | ⬜ |

Los casos de conversión se probaron con `novalidate` en el formulario o con `curl`,
porque el navegador bloquea esos valores antes de enviarlos.