group = rootProject.group
version = rootProject.version

val ktorVersion = "1.6.4"

plugins {
    kotlin("jvm") version "1.6.0"
    application
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:1.2.7")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

tasks.register("stage") {
    dependsOn("installDist")
}
