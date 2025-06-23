plugins {
    kotlin("jvm") version "1.9.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

application {
    mainClass.set("MainKt")
}

tasks.withType<Jar>().configureEach {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "MainKt"
            )
        )
    }
}