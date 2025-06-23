FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew clean build

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/minimal-ktor.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
