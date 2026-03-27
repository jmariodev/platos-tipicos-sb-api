# 🍽️ API Platos Típicos Colombianos - Documentación

Esta API permite gestionar el catálogo de platos típicos de Colombia, incluyendo regiones, departamentos, categorías, ingredientes, galerías de imágenes y comentarios de usuarios.

---

## 🏗️ Configuración Global
- **Base URL**: `http://localhost:8080/api`
- **Seguridad**: Las contraseñas se almacenan con encriptación BCrypt.
- **Formato**: JSON (UTF-8)

---

## 🔑 1. Autenticación (`/auth`)

### 1.1 Login
- **URL**: `/auth/login`
- **Método**: `POST`
- **Body**:
  ```json
  {
    "usuario": "admin",
    "contrasena": "admin123"
  }
  ```
- **Respuesta (200)**: Retorna el mensaje de éxito y el objeto `UsuarioDto`.
- **Errores**: 404 (Usuario no encontrado), 400 (Contraseña incorrecta/Inactivo).

---

## 👤 2. Usuarios (`/usuario`)

### 2.1 Listar todos
- **GET** `/usuario`

### 2.2 Crear Usuario
- **POST** `/usuario`
- **Body (UsuarioSaveDto)**: `nombre`, `usuario`, `contrasena`, `estado`, `rolesIds[]`.

---

## 🛡️ 3. Roles (`/rol`)

### 3.1 Listar Roles
- **GET** `/rol`

### 3.2 Crear Rol
- **POST** `/rol`
- **Body**: `{"nombre": "ADMIN"}`

---

## 🖼️ 4. Galería (`/galeria`)

### 4.1 Listar todas las imágenes
- **GET** `/galeria`

### 4.2 Agregar imagen a Plato
- **POST** `/galeria/plato/{platoId}`
- **Body**: `{"url": "...", "esPrincipal": true}`

### 4.3 Eliminar imagen
- **DELETE** `/galeria/{id}`

---

## 🗺️ 5. Regiones (`/region`)
... (listado de regiones)

---

## 📍 6. Departamentos (`/departamento`)
... (listado de departamentos)

---

## 🏷️ 7. Categorías (`/categoria`)
... (listado de categorías)

---

## 🧂 8. Ingredientes (`/ingrediente`)
... (maestro de ingredientes)

---

## 🍲 9. Platos (`/plato`)
... (listado de platos)

---

## 💬 10. Comentarios (`/comentario`)
... (listado de comentarios)

---

## ❌ 11. Manejo de Errores
... (manejo de errores)

---
*Documentación generada el 2025-05-22*
