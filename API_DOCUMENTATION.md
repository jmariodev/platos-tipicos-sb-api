# Documentación de la API - Platos Típicos SB API

Este documento contiene la especificación de los endpoints disponibles en la API de Platos Típicos.

## Índice
1. [Usuarios](#1-usuarios)
2. [Roles](#2-roles)

---

## 1. Usuarios
Base URL: `/api/usuario`

### 1.1 Obtener todos los usuarios
Obtiene la lista completa de usuarios registrados.

*   **URL:** `/api/usuario`
*   **Método:** `GET`
*   **Respuesta Exitosa (200 OK):**
    ```json
    [
      {
        "id": 1,
        "nombre": "Juan Perez",
        "usuario": "jperez",
        "estado": true,
        "roles": [
          { "id": 1, "nombre": "ADMIN" }
        ]
      }
    ]
    ```

### 1.2 Obtener usuario por ID
Obtiene los detalles de un usuario específico.

*   **URL:** `/api/usuario/{id}`
*   **Método:** `GET`
*   **Parámetros:** `id` (Long)
*   **Respuesta Exitosa (200 OK):**
    ```json
    {
      "id": 1,
      "nombre": "Juan Perez",
      "usuario": "jperez",
      "estado": true,
      "roles": [
        { "id": 1, "nombre": "ADMIN" }
      ]
    }
    ```
*   **Error (404 Not Found):** `{"mensaje": "Usuario con ID {id} no encontrado"}`

### 1.3 Crear nuevo usuario
Registra un nuevo usuario en el sistema. La contraseña se encripta automáticamente usando BCrypt.

*   **URL:** `/api/usuario`
*   **Método:** `POST`
*   **Cuerpo de la Petición:**
    ```json
    {
      "nombre": "Juan Perez",
      "usuario": "jperez",
      "contrasena": "password123",
      "estado": true,
      "rolesIds": [1, 2]
    }
    ```
*   **Respuesta Exitosa (201 Created):** Retorna el objeto `UsuarioDto` creado (sin el campo contrasena).
*   **Error de Validación (400 Bad Request):**
    ```json
    {
        "nombre": "El nombre es obligatorio",
        "usuario": "El usuario es obligatorio",
        "contrasena": "La contraseña es obligatoria",
        "rolesIds": "Debe asignar al menos un rol"
    }
    ```

### 1.4 Actualizar usuario
Modifica los datos de un usuario existente. Si se envía una contraseña, se re-encripta.

*   **URL:** `/api/usuario/{id}`
*   **Método:** `PUT`
*   **Cuerpo de la Petición:** (Igual al de creación)
*   **Respuesta Exitosa (200 OK):** Retorna el objeto `UsuarioDto` actualizado.
*   **Error (404 Not Found):** `{"mensaje": "Usuario con ID {id} no encontrado"}`

### 1.5 Eliminar usuario
Elimina un usuario de forma permanente.

*   **URL:** `/api/usuario/{id}`
*   **Método:** `DELETE`
*   **Respuesta Exitosa (204 No Content):** (Sin cuerpo)
*   **Error (404 Not Found):** `{"mensaje": "Usuario con ID {id} no encontrado"}`

---

## 2. Roles (Manual/DB)
*Actualmente gestionados directamente en la base de datos o mediante scripts SQL.*

### Roles Disponibles
*   **ID 1:** `ADMIN`
*   **ID 2:** `USER`

---
*Última actualización: 2025-05-22*
