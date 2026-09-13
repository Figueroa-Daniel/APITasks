# APITasks

APITasks es una API RESTful sencilla desarrollada con Kotlin y Spring Boot para gestionar una lista de tareas. El proyecto utiliza Spring Data JPA para la persistencia (con PostgreSQL) y Spring Security para proteger los endpoints mediante una clave de API (API Key).

## Tecnologías Principales

- **Kotlin**
- **Spring Boot 4.1.1**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Gradle**

## Configuración y Ejecución

1. **Base de Datos**: Configura tus credenciales de PostgreSQL en el archivo `src/main/resources/application.properties`.
2. **API Key**: Define una variable de entorno o propiedad en `application.properties` para `api.key`, que será usada para la autenticación de la API.
3. **Ejecución**: Para ejecutar la aplicación usando Gradle, desde la raíz del proyecto utiliza:

```bash
./gradlew bootRun
```

## Autenticación

Todos los endpoints están protegidos por un filtro de API Key. Debes incluir la clave configurada (`api.key`) en los encabezados de tu petición HTTP:

```http
X-API-KEY: tu_clave_aqui
```

## Endpoints (Ruta Base: `/tasks`)

La API expone los siguientes endpoints para operaciones CRUD y búsquedas:

- `GET /tasks/getTasksByTitle?title={title}`
  Obtiene una lista de tareas filtrada por título.

- `GET /tasks/getTasksByState?state={state}`
  Obtiene una lista de tareas filtrada por estado.

- `POST /tasks/createTask`
  Crea una nueva tarea.
  **Body (JSON):**
  ```json
  {
    "title": "Comprar leche",
    "description": "Ir al supermercado a comprar leche deslactosada",
    "state": "PENDING"
  }
  ```

- `PUT /tasks/updateTask`
  Actualiza una tarea existente.
  **Body (JSON):**
  ```json
  {
    "id": 1,
    "title": "Comprar leche",
    "description": "Ir al supermercado a comprar leche deslactosada",
    "state": "COMPLETED"
  }
  ```

- `DELETE /tasks/removeTaskById?id={id}`
  Elimina una tarea específica por su ID.

## Pruebas

Para correr los tests automatizados del proyecto, ejecuta:

```bash
./gradlew test
```
