# Documentación de la API - Platos Típicos SB API

Este documento contiene la especificación de los endpoints disponibles en la API de Platos Típicos.

## Índice
1. [Usuarios](#1-usuarios)
2. [Roles](#2-roles)
3. [Regiones](#3-regiones)
4. [Departamentos](#4-departamentos)
5. [Categorías](#5-categorías)
6. [Ingredientes (Maestro)](#6-ingredientes-maestro)
7. [Platos](#7-platos)

---

## 1. Usuarios
Base URL: `/api/usuario`
... (documentación anterior)

---

## 6. Ingredientes (Maestro)
Base URL: `/api/ingrediente`

### 6.1 Crear Ingrediente
*   **URL:** `/api/ingrediente`
*   **Método:** `POST`
*   **Cuerpo:** `{"nombre": "Cebolla"}`

---

## 7. Platos
Base URL: `/api/plato`

### 7.1 Crear Plato (Incluye Galería e Ingredientes)
*   **URL:** `/api/plato`
*   **Método:** `POST`
*   **Cuerpo (JSON Example):**
    ```json
    {
      "nombre": "Bandeja Paisa",
      "porciones": 1,
      "destacado": true,
      "tiempoPreparacion": 60,
      "datoCurioso": "Plato insignia de Antioquia",
      "historia": "...",
      "descripcion": "...",
      "categoriaId": 1,
      "departamentoId": 1,
      "usuarioId": 1,
      "ingredientesIds": [1, 2, 3],
      "galeria": [
        { "url": "http://image.com/1.jpg", "esPrincipal": true },
        { "url": "http://image.com/2.jpg", "esPrincipal": false }
      ]
    }
    ```
*   **Respuesta Exitosa (201 Created):** Retorna `PlatoDto` con todas sus relaciones y galería.

---
*Última actualización: 2025-05-22*
