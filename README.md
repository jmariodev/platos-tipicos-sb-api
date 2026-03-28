# 🥘 Platos Típicos SB API

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.5-brightgreen?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ed?style=for-the-badge&logo=docker)](./Dockerfile)
[![Deployed on Render](https://img.shields.io/badge/Render-Deployed-7b3e92?style=for-the-badge&logo=render)](https://render.com/)

API REST profesional para la gestión y consulta del patrimonio gastronómico de Colombia. Desarrollada con arquitectura limpia, seguridad integrada y lista para despliegue en contenedores.

---

## 🌍 Despliegue y Pruebas

La API se encuentra desplegada en la nube utilizando **Render**. Puedes interactuar con ella y probar todos los endpoints a través de la documentación funcional:

🚀 **Prueba la API aquí (Bruno Doc):** [https://bruno-platos-tipicos-sb-api-doc.onrender.com/](https://bruno-platos-tipicos-sb-api-doc.onrender.com/)

🚀 **Base URL (Production):** `https://platos-tipicos-sb-api.onrender.com`

---

## 🚀 Puntos de Acceso (Endpoints)

| Entidad | Endpoint | Descripción |
| :--- | :--- | :--- |
| **Auth** | `/auth/login` | Inicio de sesión con validación BCrypt. |
| **Platos** | `/plato` | Gestión completa de platos típicos, galería e ingredientes. |
| **Usuarios** | `/usuario` | Administración de usuarios y sus estados. |
| **Comentarios** | `/comentario` | Feedback de usuarios por plato. |
| **Regiones** | `/region` | Catálogo de regiones geográficas de Colombia. |
| **Departamentos** | `/departamento` | Departamentos asociados a regiones. |
| **Categorías** | `/categoria` | Clasificación de platos (Sopas, Fritos, etc). |
| **Ingredientes** | `/ingrediente` | Maestro de ingredientes para selección múltiple. |
| **Galería** | `/galeria` | Gestión independiente de imágenes de platos. |
| **Roles** | `/rol` | Listado de roles disponibles (ADMIN, USER). |

---

## 🛠️ Stack Tecnológico

- **Core**: Java 21 & Spring Boot 4.0.5
- **Seguridad**: Spring Security + BCrypt Password Encoding
- **CORS**: Configuración global habilitada para consumo multiplataforma.
- **Datos**: Spring Data JPA + Hibernate (PostgreSQL)
- **DevOps**: Docker & Multi-stage builds
- **Cloud**: Render

---

## ⚙️ Instalación Local

1. **Clonar y Entrar**:
   ```bash
   git clone https://github.com/tu-usuario/platos-tipicos-sb-api.git
   ```

2. **Variables de Entorno**:
   Configura tus credenciales de base de datos en `src/main/resources/application.properties`.

3. **Ejecutar con Maven**:
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Ejecutar con Docker**:
   ```bash
   docker build -t platos-api .
   docker run -p 8080:8080 platos-api
   ```

---
*Explorando los sabores de Colombia a través del código.*
