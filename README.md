# Ktor test project

A micro-project in [Ktor](https://ktor.io) (Kotlin) that simply prints a message on startup. Used to practice Docker and integration workflows with GitHub Actions.

## How to run the project

**Prerequisites**:

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running. Make sure Docker uses the Linux engine.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/), not mandatory, but I recommend it to open the project.
- [Java 17+](https://adoptium.net/) installed if you want to run the `.jar` manually (not needed if you only use Docker).

**Execution**:

1. Clone the repository and go to its directory on your machine
2. Build the `.jar` with Gradle Wrapper using the command `./gradlew clean build`.
3. Build the Docker image with `docker build -t minimal-ktor-test .`
4. Run the image `docker run -d --name ktor-test minimal-ktor-test`

**Checks**:

If you run `docker ps` you should be able to see the container, and if you run `docker logs ktor-test` you should be able to see the message "¡Estoy vivo!".

## Description of the main files

`Main.kt`
Main code of the project. Contains a `main()` function that prints a message.


`build.gradle.kts`
Gradle configuration file that defines:
- The use of the Kotlin plugin.
- Project dependencies (`ktor-server-core`, `logback`).
- The main class (`MainKt`) to include in the `.jar`.

`settings.gradle.kts`
Declares the project name (`minimal-ktor`).

`Dockerfile`
Defines how to build the Docker image:

1. Uses a base image with Java 17.
2. Runs `./gradlew build` inside the container.
3. Copies the generated `.jar` to a lightweight image.
4. Runs it with `java -jar`.
