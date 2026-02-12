plugins {
    id("java")
    id("application")
}

group = "com.rafamompo.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.rafamompo.tema4gradle.Main")
}

tasks.register<Exec>("ollamaVersion") {
    commandLine("powershell", "-NoProfile", "-Command", "ollama --version")
}

tasks.register<Exec>("ollamaPs") {
    commandLine("powershell", "-NoProfile", "-Command", "ollama ps")
}

tasks.register("llmInfo") {
    dependsOn("ollamaVersion", "ollamaPs")
    doLast {
        println("Demo finalizada")
    }
}