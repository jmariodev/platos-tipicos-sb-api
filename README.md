# 🥘 Platos Típicos SB API

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.5-brightgreen?style=for-the-badge&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ed?style=for-the-badge&logo=docker)](./Dockerfile)
[![Deployed on Render](https://img.shields.io/badge/Render-Deployed-7b3e92?style=for-the-badge&logo=render)](https://render.com/)

API REST profesional para la gestión y consulta del patrimonio gastronómico de Colombia. Desarrollada con arquitectura limpia, seguridad integrada y lista para despliegue en contenedores.

---

## 🚀 Puntos de Acceso (Endpoints)

Puedes consumir la API utilizando el **Host** de tu preferencia (Local o Producción).

### 🔗 Hosts Disponibles
- **Local**: `http://localhost:8080`
- **Producción (Render)**: `PON_AQUI_TU_ENDPOINT_DE_RENDER`

### 🛣️ Rutas Principales (Base: `/api`)

| Entidad | Endpoint | Descripción |
| :--- | :--- | :--- |
| **Platos** | `/plato` | Gestión completa de platos típicos, galería e ingredientes. |
| **Usuarios** | `/usuario` | Administración de usuarios y roles (BCrypt). |
| **Regiones** | `/region` | Catálogo de regiones geográficas. |
| **Departamentos** | `/departamento` | Departamentos asociados a regiones. |
| **Categorías** | `/categoria` | Clasificación de platos (Sopas, Fritos, etc). |
| **Ingredientes** | `/ingrediente` | Maestro de ingredientes para selección múltiple. |

---

## 🛠️ Stack Tecnológico

- **Core**: Java 21 & Spring Boot 4.0.5
- **Seguridad**: Spring Security + BCrypt Password Encoding
- **Datos**: Spring Data JPA + Hibernate (PostgreSQL)
- **Validación**: Jakarta Bean Validation
- **Productividad**: Lombok & Maven
- **DevOps**: Docker & Multi-stage builds

---

## 📖 Guía de Uso Rápido

### Documentación Detallada
Para ver ejemplos de JSON, parámetros de entrada (`SaveDto`) y formatos de respuesta, consulta nuestra guía técnica:
👉 **[Ver Documentación Técnica de Endpoints]()**

### Ejemplo de Consumo (CURL)
Sustituye `${HOST}` por tu URL base:

```bash
# Listar todos los platos
curl -X GET ${HOST}/api/plato

# Crear un nuevo ingrediente
curl -X POST ${HOST}/api/ingrediente \
     -H "Content-Type: application/json" \
     -d '{"nombre": "Ajo"}'
```

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
