group = "com.example"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
    }
}

tasks.register("stage") {
    dependsOn("build")
}
