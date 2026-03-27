# ==========================================
# Etapa 1: Construcción (Build)
# ==========================================
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar el archivo de dependencias y el código fuente
COPY pom.xml .
COPY src ./src

# Compilar el proyecto y empaquetarlo en un archivo .jar (omitiendo tests para mayor rapidez)
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
# Usamos solo el JRE (Java Runtime Environment) en lugar del JDK completo para que la imagen sea más ligera
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copiar el .jar generado en la etapa anterior. 
# Spring Boot suele nombrar el jar con la versión, usamos *.jar para atraparlo.
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto (8080 es el estándar de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación, permitiendo que Render inyecte el puerto dinámicamente si lo requiere
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]
