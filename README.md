# Proyecto de prueba con Ktor

Un microproyecto en [Ktor](https://ktor.io) (Kotlin) que simplemente imprime un mensaje al arrancar. Utilizado para practicar el uso de Docker y flujos de integración con GitHub Actions.

## Cómo ejecutar el proyecto

**Requisitos previos**:

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) instalado y en ejecución. Asegúrate de que Docker usa el motor Linux.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/), no es obligatorio, pero lo recomiendo para abrir el proyecto.
- [Java 17+](https://adoptium.net/) instalado si deseas ejecutar el `.jar` manualmente (no necesario si solo usas Docker).

**Ejecución**:

1. Clona el repositorio y ve al directorio en tu máquina
2. Compila el `.jar` con Gradle Wrapper mediante el comando `./gradlew clean build`.
3. Construye la imagen Docker con `docker build -t minimal-ktor-test .`
4. Ejecuta la imagen `docker run -d --name ktor-test minimal-ktor-test`

**Comprobaciones**:

Si ejecutas `docker ps` deberías poder ver el contenedor, y si ejecutas `docker logs ktor-test` deberías poder ver el mensaje "¡Estoy vivo!".

## Descripción de los archivos principales

`Main.kt`
Código principal del proyecto. Contiene una función `main()` que imprime un mensaje.


`build.gradle.kts`
Archivo de configuración de Gradle que define:
- El uso del plugin Kotlin.
- Dependencias del proyecto (`ktor-server-core`, `logback`).
- La clase principal (`MainKt`) para incluir en el `.jar`.

`settings.gradle.kts`
Declara el nombre del proyecto (`minimal-ktor`).

`Dockerfile`
Define cómo construir la imagen Docker:

1. Usa una imagen base con Java 17.
2. Ejecuta `./gradlew build` dentro del contenedor.
3. Copia el `.jar` generado a una imagen liviana.
4. Lo ejecuta con `java -jar`.
