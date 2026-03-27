# Documentación de la API - Platos Típicos SB API

Este documento contiene la especificación de los endpoints disponibles en la API de Platos Típicos.

## Índice
1. [Usuarios](#1-usuarios)
2. [Roles](#2-roles)
3. [Regiones](#3-regiones)
4. [Departamentos](#4-departamentos)
5. [Categorías](#5-categorías)

---

## 1. Usuarios
Base URL: `/api/usuario`

### 1.1 Obtener todos los usuarios
*   **URL:** `/api/usuario`
*   **Método:** `GET`
*   **Respuesta Exitosa (200 OK):** Lista de `UsuarioDto`.

### 1.2 Obtener usuario por ID
*   **URL:** `/api/usuario/{id}`
*   **Método:** `GET`
*   **Respuesta Exitosa (200 OK):** `UsuarioDto`.

### 1.3 Crear nuevo usuario
*   **URL:** `/api/usuario`
*   **Método:** `POST`
*   **Cuerpo (UsuarioSaveDto):** `nombre`, `usuario`, `contrasena`, `estado`, `rolesIds[]`.
*   **Respuesta Exitosa (201 Created):** `UsuarioDto`.

---

## 2. Roles (Manual/DB)
*   **ID 1:** `ADMIN`
*   **ID 2:** `USER`

---

## 3. Regiones
Base URL: `/api/region`

### 3.1 Obtener todas las regiones
*   **URL:** `/api/region`
*   **Método:** `GET`

### 3.2 Crear Región
*   **URL:** `/api/region`
*   **Método:** `POST`
*   **Cuerpo (RegionSaveDto):** `nombre`, `descripcion`, `imagen`, `color`.

---

## 4. Departamentos
Base URL: `/api/departamento`

### 4.1 Obtener todos los departamentos
*   **URL:** `/api/departamento`
*   **Método:** `GET`

### 4.2 Crear Departamento
*   **URL:** `/api/departamento`
*   **Método:** `POST`
*   **Cuerpo (DepartamentoSaveDto):** `nombre`, `regionId`.

---

## 5. Categorías
Base URL: `/api/categoria`

### 5.1 Obtener todas las categorías
*   **URL:** `/api/categoria`
*   **Método:** `GET`

### 5.2 Crear Categoría
*   **URL:** `/api/categoria`
*   **Método:** `POST`
*   **Cuerpo (CategoriaSaveDto):** `nombre`.

---
*Última actualización: 2025-05-22*
